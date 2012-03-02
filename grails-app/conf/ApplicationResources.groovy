modules = {
    application {
        resource url:'js/application.js'
    }

	modernizr {
		dependsOn 'jquery'
		resource url:'/js/modernizr-2.0.6.min.js', disposition: 'head'
	}
}