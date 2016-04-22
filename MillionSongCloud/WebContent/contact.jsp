<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>
<title>Contact us</title>
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
	
	function isNotNumber(evt) {
		status = "";
		evt = (evt) ? evt : window.event;
		var charCode = (evt.which) ? evt.which : evt.keyCode;		
		var isValid = false;		 
		if (charCode <= 32 || (charCode > 64 && charCode < 91) || (charCode > 96 && charCode < 123))	
			isValid = true;
		else
			status = "This field does not accept numbers, special chars";

		return isValid;
	}
	function isMailCorrectlyFormatted(id) 
	{
		var pattern = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/; 
		var isValid = false;	
		var matcher = document.getElementById(id).value;
		if (matcher == "") {
			
		}
		else {
			if (pattern.test(matcher)) {
				isValid = true;
				document.getElementById(id).style.background = "#00FF00";
			}
			else {
				alert("Invalid Email Format"); 
				isValid = false;
				document.getElementById(id).style.background = "#FF0000";
				document.getElementById(id).value = "";
			}
		}
		return isValid;	
	}
	function submitForm(actionURL)
	{
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
<s:form id="contactForm" name="contactForm"
	enctype="multipart/form-data">
	<body>
		<div id="header">
			<div id="logo">
				<h1>Contact us</h1>
			</div>
			<div id="menubar">
				<ul id="menu">
					<li><a id="home" title="Go to Home Page" href="#"
						onclick="loadWebPages(this.id);return false;">Home</a></li>
					<li><a id="search" title="Go to Search Page" href="#"
						onclick="loadWebPages(this.id);return false;">Search</a></li>
					<li><a id="visualization" title="Go to Visualization Page"
						href="#" onclick="loadWebPages(this.id);return false;">Visualization</a></li>
					<li><a id="blog" title="Go to Explore Page" href="#"
						onclick="loadWebPages(this.id);return false;">Explore</a></li>
					<li class="current"><a id="contact" title="Go to Contact Page"
						href="#" onclick="loadWebPages(this.id);return false;">Contact
							Us</a></li>
				</ul>
			</div>
		</div>
		<div id="content">
			<h1>Contact Us</h1>
			<p>Fill the following details to Contact us.</p>

			<div class="form_settings">
				<table>
					<tr>
						<td>Name</td>
						<td><s:textfield name="name" id="name" cssClass="contact"
								maxlength="30" onkeypress="return isNotNumber(event)"/></td>
					</tr>
					<tr>
						<td>Email Address</td>
						<td><s:textfield name="email" id="email" cssClass="contact"
								maxlength="30" onblur=" return isMailCorrectlyFormatted('email');"/></td>
					</tr>

					<tr>
						<td>Message</td>
						<td><s:textarea cssClass="textarea" maxlength="200" rows="8" cols="50"
								name="message" id="message">
							</s:textarea></td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td><input type="button" name="submitButton"
							id="submitButton" value="Submit"
							onClick="submitForm('UsersQueryActionsubmitUserDetails')"
							class="button" /></td>
					</tr>
				</table>
			</div>

		</div>


	</body>
</s:form>
</html>
