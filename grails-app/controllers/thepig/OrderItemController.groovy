package thepig

import org.springframework.dao.DataIntegrityViolationException

class OrderItemController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [orderItemInstanceList: OrderItem.list(params), orderItemInstanceTotal: OrderItem.count()]
    }

    def create() {
        [orderItemInstance: new OrderItem(params)]
    }

    def save() {
        def orderItemInstance = new OrderItem(params)
        if (!orderItemInstance.save(flush: true)) {
            render(view: "create", model: [orderItemInstance: orderItemInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), orderItemInstance.id])
        redirect(action: "show", id: orderItemInstance.id)
    }

    def show() {
        def orderItemInstance = OrderItem.get(params.id)
        if (!orderItemInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), params.id])
            redirect(action: "list")
            return
        }

        [orderItemInstance: orderItemInstance]
    }

    def edit() {
        def orderItemInstance = OrderItem.get(params.id)
        if (!orderItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), params.id])
            redirect(action: "list")
            return
        }

        [orderItemInstance: orderItemInstance]
    }

    def update() {
        def orderItemInstance = OrderItem.get(params.id)
        if (!orderItemInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (orderItemInstance.version > version) {
                orderItemInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'orderItem.label', default: 'OrderItem')] as Object[],
                          "Another user has updated this OrderItem while you were editing")
                render(view: "edit", model: [orderItemInstance: orderItemInstance])
                return
            }
        }

        orderItemInstance.properties = params

        if (!orderItemInstance.save(flush: true)) {
            render(view: "edit", model: [orderItemInstance: orderItemInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), orderItemInstance.id])
        redirect(action: "show", id: orderItemInstance.id)
    }

    def delete() {
        def orderItemInstance = OrderItem.get(params.id)
        if (!orderItemInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), params.id])
            redirect(action: "list")
            return
        }

        try {
            orderItemInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'orderItem.label', default: 'OrderItem'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
