<!doctype html>
<html>
<head>
<meta name="layout" content="main" />
<title>Saved</title>
<style type="text/css" media="screen">
#bigpig {
	display: block;    
	margin-left: auto;
    margin-right: auto;
    margin-top: 1em;
}
</style>
</head>
<body>
	<section class="wrap">
		<g:if test="${flash.message}">
			<div class="message" role="status">
				${flash.message}
			</div>
		</g:if>
		<r:img id="bigpig" uri="/images/bigpig.jpg" />
		<audio preload="auto" autoplay>
			<source src="sounds/snort.mp3" type="audio/mp3" />
			<source src="sounds/snort.wav" type="audio/wav" />
			Oink Oink
		</audio>		
	</section>
</body>
</html>
