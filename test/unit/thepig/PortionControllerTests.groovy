package thepig



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(PortionController)
@Mock(Portion)
class PortionControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/portion/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.portionInstanceList.size() == 0
        assert model.portionInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.portionInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.portionInstance != null
        assert view == '/portion/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/portion/show/1'
        assert controller.flash.message != null
        assert Portion.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/portion/list'


        populateValidParams(params)
        def portion = new Portion(params)

        assert portion.save() != null

        params.id = portion.id

        def model = controller.show()

        assert model.portionInstance == portion
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/portion/list'


        populateValidParams(params)
        def portion = new Portion(params)

        assert portion.save() != null

        params.id = portion.id

        def model = controller.edit()

        assert model.portionInstance == portion
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/portion/list'

        response.reset()


        populateValidParams(params)
        def portion = new Portion(params)

        assert portion.save() != null

        // test invalid parameters in update
        params.id = portion.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/portion/edit"
        assert model.portionInstance != null

        portion.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/portion/show/$portion.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        portion.clearErrors()

        populateValidParams(params)
        params.id = portion.id
        params.version = -1
        controller.update()

        assert view == "/portion/edit"
        assert model.portionInstance != null
        assert model.portionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/portion/list'

        response.reset()

        populateValidParams(params)
        def portion = new Portion(params)

        assert portion.save() != null
        assert Portion.count() == 1

        params.id = portion.id

        controller.delete()

        assert Portion.count() == 0
        assert Portion.get(portion.id) == null
        assert response.redirectedUrl == '/portion/list'
    }
}
