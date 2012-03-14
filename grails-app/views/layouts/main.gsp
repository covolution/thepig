<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="The Pig"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
        <r:require module="modernizr"/>
        <r:layoutResources />
		<g:layoutHead/>        
	</head>
	<body>
		<header>
			<section class="wrap clear">
				<h3 class="logo replace">
					<g:link title="Home" absolute="true" url="/"><img src="${resource(dir: 'images', file: 'thepig.jpg')}" alt="pig"/></g:link>
				</h3>
				<nav>
					<g:link controller="eat" action="create" >Eat</g:link>
					<sec:ifLoggedIn>
						Welcome <sec:username />!, <g:link controller="logout">Logout</g:link>
					</sec:ifLoggedIn>
					<sec:ifNotLoggedIn>
						<g:link class="login" controller="login">Login</g:link>
					</sec:ifNotLoggedIn>
				</nav>
			</section>
		</header>
		<section id="main-body">	
		  <g:layoutBody/>
		</section>
		<footer>
			<section class="wrap">
				<nav>
					<sec:ifAllGranted roles="ROLE_ADMIN"><g:link controller="admin" >Admin</g:link></sec:ifAllGranted>
					<sec:ifLoggedIn>
					  <g:link controller="person" action="cpassword" >Change password</g:link>
					</sec:ifLoggedIn>
					<a href="https://github.com/covolution/thepig">source code</a>
					<p>Version:<g:meta name="app.version"/></p>
				</nav>
			</section>		
		</footer>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<g:javascript library="application"/>
        <r:layoutResources />
	</body>
</html>