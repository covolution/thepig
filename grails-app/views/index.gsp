<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to The Pig</title>
		<style type="text/css" media="screen">

			p {
				margin: 0.25em 0;
			}
		</style>
	</head>
	<body>
		  <section class="wrap">
		  	<h1>Welcome to The Pig</h1>
		  	<h2>A pig of beauty is a joy forever</h2>
		  	<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<p>
				<sec:ifNotLoggedIn>
					Please <g:link controller="login">Login</g:link>
				</sec:ifNotLoggedIn>
			</p>
		  </section>
		  <!--audio preload="auto" autoplay> 
  			<source src="sounds/snort.mp3" type="audio/mp3"/>
  			<source src="sounds/snort.wav" type="audio/wav" />
  			Oink Oink
		  </audio--> 
	</body>
</html>
