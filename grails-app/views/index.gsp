<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to The Pig</title>
		<style type="text/css" media="screen">

			h2 {
				margin-top: 1em;
				margin-bottom: 0.3em;
				font-size: 1em;
			}

			p {
				margin: 0.25em 0;
			}
		</style>
	</head>
	<body>
		  <section class="wrap">
		  	<h1>Welcome to The Pig</h1>
			<p>
				<sec:ifLoggedIn>
					Welcome Back <sec:username />!, <g:link controller="logout">Logout</g:link>
				</sec:ifLoggedIn>
				<sec:ifNotLoggedIn>
					Please <g:link controller="login">Login</g:link>
				</sec:ifNotLoggedIn>
			</p>
		  </section>
	</body>
</html>
