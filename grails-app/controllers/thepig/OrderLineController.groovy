package thepig

import org.springframework.dao.DataIntegrityViolationException

class OrderLineController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [orderLineInstanceList: OrderLine.list(params), orderLineInstanceTotal: OrderLine.count()]
    }

    def create() {
        [orderLineInstance: new OrderLine(params)]
    }

    def save() {
        def orderLineInstance = new OrderLine(params)
        if (!orderLineInstance.save(flush: true)) {
            render(view: "create", model: [orderLineInstance: orderLineInstance])
            return
        }

		flash.message = message(code: 'default.created.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), orderLineInstance.id])
        redirect(action: "show", id: orderLineInstance.id)
    }

    def show() {
        def orderLineInstance = OrderLine.get(params.id)
        if (!orderLineInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), params.id])
            redirect(action: "list")
            return
        }

        [orderLineInstance: orderLineInstance]
    }

    def edit() {
        def orderLineInstance = OrderLine.get(params.id)
        if (!orderLineInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), params.id])
            redirect(action: "list")
            return
        }

        [orderLineInstance: orderLineInstance]
    }

    def update() {
        def orderLineInstance = OrderLine.get(params.id)
        if (!orderLineInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), params.id])
            redirect(action: "list")
            return
        }

        if (params.version) {
            def version = params.version.toLong()
            if (orderLineInstance.version > version) {
                orderLineInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'orderLine.label', default: 'OrderLine')] as Object[],
                          "Another user has updated this OrderLine while you were editing")
                render(view: "edit", model: [orderLineInstance: orderLineInstance])
                return
            }
        }

        orderLineInstance.properties = params

        if (!orderLineInstance.save(flush: true)) {
            render(view: "edit", model: [orderLineInstance: orderLineInstance])
            return
        }

		flash.message = message(code: 'default.updated.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), orderLineInstance.id])
        redirect(action: "show", id: orderLineInstance.id)
    }

    def delete() {
        def orderLineInstance = OrderLine.get(params.id)
        if (!orderLineInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), params.id])
            redirect(action: "list")
            return
        }

        try {
            orderLineInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), params.id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'orderLine.label', default: 'OrderLine'), params.id])
            redirect(action: "show", id: params.id)
        }
    }
}
