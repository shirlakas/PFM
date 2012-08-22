<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="grails" /></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<!-- <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}"
			type="text/css">-->
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'sparse.css')}"
		type="text/css">
		<link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />	
		<g:layoutHead />
		
        <g:javascript library="application" />
    </head>
    <body>
        <div id="header">
		<a href="${ createLink(uri: '/') }" style="float: left;"><img src= "${resource(dir:'images', file:'osler-logo.png')}" height="30" alt="${message(default:'Osler Logo')}" /></a>
		<div id="home" style="float: left;">			
			<h1><a href="${createLink(uri: '/') }">Welcome to the Osler Patient Flow Monitoring System</a></h1>
		</div>
		<div id="icons" style="float: right;">
		    <a href="${ createLink(uri: '/') }" style="float: right;"><img src= "${resource(dir:'images', file:'cardiology.png')}" height="30" alt="${message(default:'Cardiology Logo')}" /></a>
       </div>
		<div class="clearer" ></div>
	</div>	
        <div id="spinner" class="spinner" style="display:none;">
            <img src="${resource(dir:'images',file:'spinner.gif')}" alt="${message(code:'spinner.alt',default:'Loading...')}"/>
        </div>
        
        <div id="grailsLogo"><a href="http://www.williamoslerhc.on.ca/" ><img src="${resource(dir:'images',file:'logo_home_new.gif')}" alt="Osler Logo" border="0"/></a>
             <img src="${resource(dir:'images',file:'header_default_body.jpg', position: '0.7em center;')}" alt="Osler Doctors" border="0" />
              </div>
        
        <g:layoutBody />
    </body>
</html>
