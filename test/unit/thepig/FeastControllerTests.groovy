package thepig



import org.junit.*
import grails.test.mixin.*
import javax.servlet.http.HttpServletResponse

@TestFor(FeastController)
@Mock(Feast)
class FeastControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/feast/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.feastInstanceList.size() == 0
        assert model.feastInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.feastInstance != null
    }

    void testSave() {
        controller.save()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.save()

        assert model.feastInstance != null
        assert view == '/feast/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/feast/show/1'
        assert controller.flash.message != null
        assert Feast.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/feast/list'


        populateValidParams(params)
        def feast = new Feast(params)

        assert feast.save() != null

        params.id = feast.id

        def model = controller.show()

        assert model.feastInstance == feast
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/feast/list'


        populateValidParams(params)
        def feast = new Feast(params)

        assert feast.save() != null

        params.id = feast.id

        def model = controller.edit()

        assert model.feastInstance == feast
    }

    void testUpdate() {

        controller.update()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/feast/list'

        response.reset()


        populateValidParams(params)
        def feast = new Feast(params)

        assert feast.save() != null

        // test invalid parameters in update
        params.id = feast.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/feast/edit"
        assert model.feastInstance != null

        feast.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/feast/show/$feast.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        feast.clearErrors()

        populateValidParams(params)
        params.id = feast.id
        params.version = -1
        controller.update()

        assert view == "/feast/edit"
        assert model.feastInstance != null
        assert model.feastInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert response.status == HttpServletResponse.SC_METHOD_NOT_ALLOWED

        response.reset()
        request.method = 'POST'
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/feast/list'

        response.reset()

        populateValidParams(params)
        def feast = new Feast(params)

        assert feast.save() != null
        assert Feast.count() == 1

        params.id = feast.id

        controller.delete()

        assert Feast.count() == 0
        assert Feast.get(feast.id) == null
        assert response.redirectedUrl == '/feast/list'
    }
}
