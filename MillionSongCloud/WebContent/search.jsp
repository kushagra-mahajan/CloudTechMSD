<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>

<html>
<script type="text/javascript" src="exportExcel.js"></script>

<head>
<title>Search Song</title>
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


<%
	int songCount = 0;
	int artistCount = 0;
%>

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
	function submitForm(actionURL) {
		document.forms[0].action = actionURL;
		document.forms[0].submit();
	}
	window.onload = function() {
		var submitbutton = document.getElementById("title");
		if (submitbutton.addEventListener) {
			submitbutton.addEventListener("click", function() {
				if (submitbutton.value == 'Search for a song by title') {
					submitbutton.value = '';
				}
			});
		}
	}
	function toggleSongTable() {
		var lTable = document.getElementById("songTable");
		lTable.style.display = (lTable.style.display == "table") ? "none"
				: "table";
	}
	function toggleArtistTable() {
		var lTable = document.getElementById("artistTable");
		lTable.style.display = (lTable.style.display == "table") ? "none"
				: "table";
	}
	function searchSongsByMood(id) {
		if (id.value == -1) {
			alert("Please select from the dropdown");
			return false;
		}
		
		var actionURL = "SearchSongsActionsearchSongsByMood";		
		document.forms[0].action = actionURL;
		document.forms[0].submit();
	}
	function viewArtistInformation(artistId)
	{
		window.open("SearchSongsActionshowArtistInformation?artistId=" +artistId, "myWindow", "status = 1, height = 300, width = 300, resizable = 0" );
	}
	function viewSongInformation(songId)
	{
		window.open("SearchSongsActionshowSongInformation?songId=" +songId, "myWindow", "status = 1, height = 300, width = 300, resizable = 0" );
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

<s:form id="searchForm" name="searchForm" enctype="multipart/form-data">
	<body>
		<div id="header">
			<div id="logo">
				<h1>Search your favorite songs or artists</h1>
			</div>
			<div id="menubar">
				<ul id="menu">
					<li><a id="home" title="Go to Home Page" href="#"
						onclick="loadWebPages(this.id);return false;">Home</a></li>
					<li class="current"><a id="search" title="Go to Search Page"
						href="#" onclick="loadWebPages(this.id);return false;">Search</a></li>
					<li><a id="visualization" title="Go to Visualization Page"
						href="#" onclick="loadWebPages(this.id);return false;">Visualization</a></li>
					<li><a id="blog" title="Go to Explore Page" href="#"
						onclick="loadWebPages(this.id);return false;">Explore</a></li>
					<li><a id="contact" title="Go to Contact Page" href="#"
						onclick="loadWebPages(this.id);return false;">Contact Us</a></li>
				</ul>
			</div>
		</div>
		<!-- HTML for SEARCH BAR -->
		<div id="tfheader">
			<table class="song_table">
				<tr>
					<td><s:text name="Search for Song/Artist" /> &nbsp;&nbsp;<input
						type="text" id="title" class="tftextinput4" name="title" size="40"
						maxlength="200" value=""><input type="button" value=""
						class="tfbutton4" id="searchButton" name="searchButton"
						onClick="submitForm('SearchSongsActionfetchSongDetails')"></td>
					<td>Total number of records &nbsp;&nbsp;<select
						id="searchCount" name="searchCount">
							<option value="10">10</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="100">100</option>
					</select></td>

				</tr>
				<tr>
					<td class = "tdfont_One"></td>
					<td class="tdfont_Two"><s:select name="songMood"
							label="Search Songs by Mood" id="songMood" headerKey="-1"
							headerValue="---Select the song mood---"
							list="#{'1':'Angry', '2':'Explosive','3':'Plain', '4':'Soft/Quiet','5':'Dark', '6':'Ecstatic','7':'Joyous', '8':'Patriotic'}"
							cssClass="listbox2" align="centre"
							onchange="searchSongsByMood(this)" /></td>
				</tr>
			</table>
		</div>
		
		<table class="song_table">
			<tr></tr>
			<s:if test="songsList.size() > 0">
				<tr>
					<td><span class="text_span"><s:property
								value="%{songsList.size()}" /> song<s:if
								test="songsList.size() >1">s</s:if> found</span>
						&nbsp;&nbsp;&nbsp;&nbsp;<a id="songLink"
						onclick="toggleSongTable();" href="#"><span class="text_span">Songs
								Information </span></a> &nbsp;&nbsp;&nbsp;&nbsp;<!-- <a id=""
						onclick="downloadPdf('songLink');" href="#"><img
							src="pdf_image.png" /></a> -->&nbsp;&nbsp;&nbsp;<a
						download="SongsInformation.csv" href="#"
						onclick="return ExcellentExport.csv(this, 'songTable');"><img
							src="excel_image.png" /></a></td>
				</tr>
			</s:if>
			<s:if test="artistsList.size() > 0">
				<tr>
					<td><span class="text_span"><s:property
								value="%{artistsList.size()}" /> artist<s:if
								test="artistsList.size() > 1">s</s:if> found</span>
						&nbsp;&nbsp;&nbsp;&nbsp;<a id="artistLink"
						onclick="toggleArtistTable();" href="#"><span
							class="text_span">Artists Information </span> <!-- </a>
						&nbsp;&nbsp;&nbsp;&nbsp;<a id=""
						onclick="downloadPdf('artistLink');" href="#"><img
							src="pdf_image.png" /> --></a>&nbsp;&nbsp;&nbsp;<a
						download="ArtistsInformation.csv" href="#"
						onclick="return ExcellentExport.csv(this, 'artistTable');"><img
							src="excel_image.png" /></a></td>
				</tr>
			</s:if>
		</table>

		<!-- Songs List by Mood -->
		<s:if test="%{songListMyMood == null || songListMyMood.size() == 0}">
			<span class="td_font"><s:actionerror /></span>
		</s:if>

		<s:elseif test="songListMyMood.size() > 0">
			<table class="workMain_Table" id="songTable">
				<tr>
					<td align="center" colspan="10" class="sub_headingOne">Songs
						List by Mood</td>	<td class="sub_headingOne"></td>				
				</tr>

				<tr>
					<td class="tdfont_Zero" colspan="10" align="center"><s:property
							value="soongMoodName" /></td class="tdfont_Zero"><td><s:if test="%{songListMyMood.size() > 0}">
							<a download="SongsInformationByMood.csv" href="#"
								onclick="return ExcellentExport.csv(this, 'songTable');"><img
								src="excel_image.png" /></a>
							</span>
						</s:if></td>
				</tr>
				<tr>
					<td width="10%" class="tdfont_One">S.No</td>
					<td class="tdfont_One">Song Id</td>
					<td class="tdfont_One">Song Title</td>
					<td class="tdfont_One">Album Name</td>
					<td class="tdfont_One">Artist Name</td>
					<td class="tdfont_One">Year</td>
				</tr>

				<s:iterator value="songListMyMood">
					<tr>
						<td class="tdfont_Two"><%=++songCount%></td>
						<td class="tdfont_Two"><a href="#"
							onclick="viewSongInformation('<s:property
									value="songId" />')"><s:property
									value="songId" /></a></td>
						<td class="tdfont_Two"><s:property value="title" /></td>
						<td class="tdfont_Two"><s:property value="albumName" /></td>
						<td class="tdfont_Two"><s:property value="artistName" /></td>
						<td class="tdfont_Two"><s:if test='%{year > 0}'>
								<s:property value="year" />
							</s:if> <s:else>NA</s:else></td>
					</tr>

				</s:iterator>

			</table>

		</s:elseif>

		<!-- Songs Information Table -->
		<s:if test="%{songsList == null || songsList.size() == 0}">
			<span class="td_font"><s:actionerror /></span>
		</s:if>

		<s:elseif test="songsList.size() > 0">
			<table class="workMain_Table" id="songTable" style="display: none">
				<tr>
					<td align="center">
				<tr>
					<td align="left" colspan="10" class="sub_headingOne">Songs
						Search Results</td>
				</tr>
				<tr>
					<td width="10%" class="tdfont_One">S.No</td>
					<td class="tdfont_One">Song Id</td>
					<td class="tdfont_One">Song Title</td>
					<td class="tdfont_One">Album Name</td>
					<td class="tdfont_One">Artist Name</td>
					<td class="tdfont_One">Year</td>
				</tr>

				<s:iterator value="songsList">
					<tr>
						<td class="tdfont_Two"><%=++songCount%></td>
						<td class="tdfont_Two"><a href="#"
							onclick="viewSongInformation('<s:property
									value="songId" />')"><s:property
									value="songId" /></a></td>
						<td class="tdfont_Two"><s:property value="title" /></td>
						<td class="tdfont_Two"><s:property value="albumName" /></td>
						<td class="tdfont_Two"><s:property value="artistName" /></td>
						<td class="tdfont_Two"><s:if test='%{year > 0}'>
								<s:property value="year" />
							</s:if> <s:else>NA</s:else></td>
					</tr>

				</s:iterator>

			</table>

		</s:elseif>

		<!-- Artists Information Table -->
		<s:if test="artistsList.size() > 0">
			<table class="workMain_Table" id="artistTable" style="display: none">
				<tr>
					<td align="center">
				<tr>
					<td align="left" colspan="10" class="sub_headingOne">Artists
						Search Results</td>
				</tr>
				<tr>
					<td width="10%" class="tdfont_One">S.No</td>
					<td class="tdfont_One">Artist Id</td>
					<td class="tdfont_One">Artist Name</td>
					<td class="tdfont_One">Album Name</td>
					<td class="tdfont_One">Album Id</td>
					<td class="tdfont_One">Artist Location</td>
				</tr>

				<s:iterator value="artistsList">
					<tr>
						<td class="tdfont_Two"><%=++artistCount%></td>
						<td class="tdfont_Two"><a href="#"
							onclick="viewArtistInformation('<s:property
									value="artistId" />')"><s:property
									value="artistId" /></a></td>
						<td class="tdfont_Two"><s:property value="artistName" /></td>
						<td class="tdfont_Two"><s:property value="albumName" /></td>
						<td class="tdfont_Two"><s:property value="albumId" /></td>
						<td class="tdfont_Two"><s:if
								test='%{artistLocation != "nan"}'>
								<s:property value="artistLocation" />
							</s:if> <s:else>NA</s:else></td>
					</tr>

				</s:iterator>

			</table>

		</s:if>




	</body>
</s:form>
</html>
