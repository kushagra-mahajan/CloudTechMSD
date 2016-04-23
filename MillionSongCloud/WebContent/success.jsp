<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>
<title>Blog</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Tangerine&amp;v1" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
<link rel="stylesheet" type="text/css" href="style/oldstyle.css" />
</head>

<script type="text/javascript">
	function loadWebPages(id) {
		var actionURL = "";
		if (id == 'home') {
			actionURL = "DisplayActiondisplayHomePage";
		} else if (id == 'search') {
			actionURL = "DisplayActiondisplaySearchPage";
		} else if (id == 'visualization') {
			actionURL = "DisplayActiondisplayVisualizationPage";
		} else if (id == 'blog') {
			actionURL = "DisplayActiondisplayBlogPage";
		} else if (id == 'contact') {
			actionURL = "DisplayActiondisplayContactPage";
		} else {
			alert("Something went wrong, please try again after sometime.");
			return false;
		}

		document.forms[0].action = actionURL;
		document.forms[0].submit();
	}
	var message="Function Disabled!";

	function clickIE4(){
		if (event.button == 2){
			alert(message);
			return false;
		}
	}

	function clickNS4(e){
		if (document.layers || document.getElementById && !document.all){
			if (e.which==2||e.which==3){
				alert(message);
				return false;
			}
		}
	}

	if (document.layers){
		document.captureEvents(Event.MOUSEDOWN);
		document.onmousedown = clickNS4;
	}
	else if (document.all && !document.getElementById){
		document.onmousedown=clickIE4;
	}

	document.oncontextmenu = new Function("alert(message);return false")
</script>

<s:form id="successForm" name="successForm"
	enctype="multipart/form-data">
	<body>
		<div id="header">
			<div id="logo">
				<h1>Million Song</h1>
			</div>
			<div id="nav">
				<ul>
					<li><a id="home" title="Go to Home Page" href="#"
						onclick="loadWebPages(this.id);return false;"><span>01</span>
							HOME</a></li>
					<li><a id="search" title="Go to Search Page" href="#"
						onclick="loadWebPages(this.id);return false;"><span>02</span>
							SEARCH</a></li>
					<li><a id="blog" title="Go to Explore Page" href="#"
						onclick="loadWebPages(this.id);return false;"><span>03</span>
							EXPLORE</a></li>
					<li><a id="visualization" title="Go to Visualization Page"
						href="#" onclick="loadWebPages(this.id);return false;"><span>04</span>
							VISUALIZATIONS</a></li>
					<li><a id="contact" title="Go to Contact Page" href="#"
						onclick="loadWebPages(this.id);return false;"><span>05</span>
							CONTACT US</a></li>
				</ul>
			</div>
		</div>
		<div id="content">
			<s:actionmessage />
		</div>
	</body>
</s:form>
</html>
