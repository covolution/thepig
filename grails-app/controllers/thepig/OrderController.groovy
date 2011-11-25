package thepig

import org.springframework.dao.DataIntegrityViolationException

class OrderController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [orderInstanceList: Order.list(params), orderInstanceTotal: Order.count()]
    }

    def create() {
        [orderInstance: new Order(params)]
    }

    def save() {
        def orderInstance = new Order(params)
        if (!orderInstance.save(flush: true)) {
            render(view: "create", model: [orderInstance: orderInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)
    }

    def show() {
        def orderInstance = Order.get(params.id)
        if (!orderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), params.id])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def edit() {
        def orderInstance = Order.get(params.id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), params.id])
            redirect(action: "list")
            return
        }

        [orderInstance: orderInstance]
    }

    def update() {
        def orderInstance = Order.get(params.id)
        if (!orderInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (orderInstance.version > version) {
                orderInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'order.label', default: 'Order')] as Object[],
                          "Another user has updated this Order while you were editing")
                render(view: "edit", model: [orderInstance: orderInstance])
                return
            }
        }

        orderInstance.properties = params

        if (!orderInstance.save(flush: true)) {
            render(view: "edit", model: [orderInstance: orderInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'order.label', default: 'Order'), orderInstance.id])
        redirect(action: "show", id: orderInstance.id)
    }

    def delete() {
        def orderInstance = Order.get(params.id)
        if (!orderInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'order.label', default: 'Order'), params.id])
            redirect(action: "list")
            return
        }

        try {
            orderInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'order.label', default: 'Order'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'order.label', default: 'Order'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
