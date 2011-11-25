package thepig



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(OrderLineController)
@Mock(OrderLine)
class OrderLineControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/orderLine/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.orderLineInstanceList.size() == 0
        assert model.orderLineInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.orderLineInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.orderLineInstance != null
        assert view == '/orderLine/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/orderLine/show/1'
        assert controller.flash.message != null
        assert OrderLine.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/orderLine/list'


        populateValidParams(params)
        def orderLine = new OrderLine(params)

        assert orderLine.save() != null

        params.id = orderLine.id

        def model = controller.show()

        assert model.orderLineInstance == orderLine
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/orderLine/list'


        populateValidParams(params)
        def orderLine = new OrderLine(params)

        assert orderLine.save() != null

        params.id = orderLine.id

        def model = controller.edit()

        assert model.orderLineInstance == orderLine
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/orderLine/list'

        response.reset()


        populateValidParams(params)
        def orderLine = new OrderLine(params)

        assert orderLine.save() != null

        // test invalid parameters in update
        params.id = orderLine.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/orderLine/edit"
        assert model.orderLineInstance != null

        orderLine.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/orderLine/show/$orderLine.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        orderLine.clearErrors()

        populateValidParams(params)
        params.id = orderLine.id
        params.version = -1
        controller.update()

        assert view == "/orderLine/edit"
        assert model.orderLineInstance != null
        assert model.orderLineInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/orderLine/list'

        response.reset()

        populateValidParams(params)
        def orderLine = new OrderLine(params)

        assert orderLine.save() != null
        assert OrderLine.count() == 1

        params.id = orderLine.id

        controller.delete()

        assert OrderLine.count() == 0
        assert OrderLine.get(orderLine.id) == null
        assert response.redirectedUrl == '/orderLine/list'
    }
}
