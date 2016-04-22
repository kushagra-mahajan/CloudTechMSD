<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>

<head>
<title>Visualization</title>
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
	var message = "Function Disabled!";

	function clickIE4() {
		if (event.button == 2) {
			alert(message);
			return false;
		}
	}

	function clickNS4(e) {
		if (document.layers || document.getElementById && !document.all) {
			if (e.which == 2 || e.which == 3) {
				alert(message);
				return false;
			}
		}
	}

	if (document.layers) {
		document.captureEvents(Event.MOUSEDOWN);
		document.onmousedown = clickNS4;
	} else if (document.all && !document.getElementById) {
		document.onmousedown = clickIE4;
	}

	document.oncontextmenu = new Function("alert(message);return false")
</script>

<s:form id="visualizationForm" name="visualizationForm"
	enctype="multipart/form-data">
	<body>
		<div id="header">
			<div id="logo">
				<h1>Million Song Data Visualization</h1>
			</div>
			<div id="menubar">
				<ul id="menu">
					<li><a id="home" title="Go to Home Page" href="#"
						onclick="loadWebPages(this.id);return false;">Home</a></li>
					<li><a id="search" title="Go to Search Page" href="#"
						onclick="loadWebPages(this.id);return false;">Search</a></li>
					<li class="current"><a id="visualization"
						title="Go to Visualization Page" href="#"
						onclick="loadWebPages(this.id);return false;">Visualization</a></li>
					<li><a id="blog" title="Go to Explore Page" href="#"
						onclick="loadWebPages(this.id);return false;">Explore</a></li>
					<li><a id="contact" title="Go to Contact Page" href="#"
						onclick="loadWebPages(this.id);return false;">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<div id="content">
		<!-- <table>
			<tr>
				<td>
					<p style="text-align: center;">
						<img src="pic_scatterplot.png" alt="Scatter plot"
							title="Scatter Plot" style="width: 304px; height: 228px;">
					</p>
				</td>
				<td>
					<p style="text-align: center;">
						<img src="pic_dendrogram.png" alt="Dendrogram" title="Dendrogram"
							style="width: 304px; height: 228px;">
					</p>
				</td>
				<td>
					<p style="text-align: center;">
						<img src="pic_circlepacking.png" alt="Circle Packing"
							title="Circle Packing" style="width: 304px; height: 228px;">
					</p>
				</td>
				<td>
					<p style="text-align: center;">
						<img src="pic_zoomablecirclepacking.png"
							alt="Zoomable Circle Packing" title="Zoomable Circle Packing"
							style="width: 304px; height: 228px;">
					</p>
				</td>
			</tr>
			</table> -->
			<h4>VISUALIZATION 1 - TOP 10 ARTISTS BY FAMILIARITY AND THEIR
				SONGS AND ALBUMS</h4>
			<a href="visualizations/Viz1.html">VIZ 1</a>
			<h4>VISUALIZATION 2 - ARTISTS, ALBUMS, SONGS</h4>
			<a href="visualizations/Viz2.html">VIZ 2</a>
			<h4>VISUALIZATION 3 - ARTISTS, ALBUMS, THEIR TEMPO</h4>
			<a href="visualizations/Viz3.html">VIZ 3</a>
			<h4>VISUALIZATION 4 - SONGS INFO WITH ARTISTS ALBUMS ETC</h4>
			<a href="visualizations/Viz4.html">VIZ 4</a>
			<h4>VISUALIZATION 5 - PARALLEL CO-ORDINATES INFO</h4>
			<a href="visualizations/Viz5.html">VIZ 5</a>
			<h4>Album, Artist, Song<br> hierarchical edge bundling</h4>
			<a href="visualizations/album.html">VIZ 6</a>
			<h4>Line Chart</h4>
			<a href="visualizations/line.html">VIZ 7</a>
			<h4>Bubble Chart</h4>
			<a href="visualizations/buublechart.html">VIZ 8</a>
		</div>


	</body>
</s:form>
</html>
