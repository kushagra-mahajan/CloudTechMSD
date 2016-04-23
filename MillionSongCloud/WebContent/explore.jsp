<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<%
	int count = 0;
	int moodCount_1 = 0;
	int moodCount_2 = 0;
%>

<script type="text/javascript" src="exportExcel.js"></script>

<head>
<title>Explore</title>
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
	
	function searchSongsArtistsByCriteria(id) {
		/* if (id.value == -1) {
			alert("Please select from the dropdown");
			return false;
		} */
		
		var actionURL = "SearchSongsActionsearchSongsArtistsByCriteria";		
		document.forms[0].action = actionURL;
		document.forms[0].submit();
	}
	
	function exploreSongsbyMood(id) {
		/* if (id.value == -1) {
			alert("Please select from the dropdown");
			return false;
		} */
		
		var actionURL = "SearchSongsActionexploreSongsbyMood";		
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

<s:form id="exploreForm" name="exploreForm"
	enctype="multipart/form-data">
	<body>
		<div id="header">
			<div id="logo">
				<h1>Explore our song database</h1>
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

		<table border="2"
			style="background-color: #9900CC; border-collapse: collapse; border: 2px solid #FFCC00; color: #000000; width: 100%"
			cellpadding="3" cellspacing="5">

			<tr>
				<td>&nbsp;&nbsp; <s:radio label="Top 10" name="searchCriteria"
						id="searchCriteria"
						list="#{'1':'Artists by Familiarity','2':'Artists by Hotness','3':'Songs by Duration', '4':'Songs by Tempo'}"
						onclick="searchSongsArtistsByCriteria(this)" />
				</td>

			</tr>
			<tr>
				<td><s:if test="%{songsList.size() > 0}">
						<a download="SongsInformation.csv" href="#"
							onclick="return ExcellentExport.csv(this, 'songTable');"><img
							src="excel_image.png" /></a>
					</s:if></td>
				<td><s:if test="%{artistsList.size() > 0}">
						<a download="ArtistsInformation.csv" href="#"
							onclick="return ExcellentExport.csv(this, 'artistTable');"><img
							src="excel_image.png" /></a>
					</s:if></td>
			</tr>
		</table>

		<table border="2"
			style="background-color: #9900CC; border-collapse: collapse; border: 2px solid #FFCC00; color: #000000; width: 100%"
			cellpadding="3" cellspacing="5">
			<tr>
				<td><s:radio label="What's your mood" name="userMood"
						id="userMood"
						list="#{'1':'Angry', '2':'Explosive','3':'Plain', '4':'Soft/Quiet','5':'Dark', '6':'Ecstatic','7':'Joyous', '8':'Patriotic'}"
						onclick="exploreSongsbyMood(this)" /></td>
			</tr>
		</table>

		<!-- Songs Information Table -->
		<s:if test="%{songsList == null || songsList.size() == 0}">
			<span class="td_font"><s:actionerror /></span>
		</s:if>

		<s:elseif test="songsList.size() > 0">
			<table class="workMain_Table" id="songTable">
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
						<td class="tdfont_Two"><%=++count%></td>
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
		<s:if test="%{artistsList == null || artistsList.size() == 0}">
			<span class="td_font"><s:actionerror /></span>
		</s:if>

		<s:elseif test="artistsList.size() > 0">
			<table class="workMain_Table" id="artistTable">
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
						<td class="tdfont_Two"><%=++count%></td>
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
		</s:elseif>
		<s:if
			test="%{songsMoodList_1.size() > 0 && songsMoodList_2.size() > 0}">
			<table class="workMain_Table">
				<tr>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td align="left" colspan="10" class="sub_headingOne">Songs
						Recommendation By Mood</td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
					<td class="sub_headingOne" colspan="10"></td>
				</tr>
			</table>
		</s:if>
		<!-- Songs By Mood Table 1 -->
		<s:if test="%{songsMoodList_1 == null || songsMoodList_1.size() == 0}">
			<span class="td_font"><s:actionerror /></span>
		</s:if>

		<s:elseif test="songsMoodList_1.size() > 0">
			<table class="workMain_Table" id="songTable_1">
				<tr>
					<td align="left" colspan="10" class="sub_headingOne"><s:property
							value="moodValueOne" /></td>
				</tr>
				<tr>
					<td width="10%" class="tdfont_One">S.No</td>
					<td class="tdfont_One">Song Id</td>
					<td class="tdfont_One">Song Title</td>
					<td class="tdfont_One">Album Name</td>
					<td class="tdfont_One">Artist Name</td>
					<td class="tdfont_One">Year</td>
				</tr>

				<s:iterator value="songsMoodList_1">
					<tr>
						<td class="tdfont_Two"><%=++moodCount_1%></td>
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
				<tr>
					<td></td>
					<td></td>
					<td>Download to Excel</td>
					<td><s:if test="%{songsMoodList_1.size() > 0}">
							<a download="SongsInformation_1.csv" href="#"
								onclick="return ExcellentExport.csv(this, 'songTable_1');"><img
								src="excel_image.png" /></a>
						</s:if></td>
					<td></td>
					<td></td>
				</tr>

			</table>
		</s:elseif>

		<!-- Songs By Mood Table 2 -->
		<s:if test="%{songsMoodList_2 == null || songsMoodList_2.size() == 0}">
			<span class="td_font"><s:actionerror /></span>
		</s:if>

		<s:elseif test="songsMoodList_2.size() > 0">
			<table class="workMain_Table" id="songTable_2">
				<tr>
					<td align="left" colspan="10" class="sub_headingOne"><s:property
							value="moodValueTwo" /></td>
				</tr>
				<tr>
					<td width="10%" class="tdfont_One">S.No</td>
					<td class="tdfont_One">Song Id</td>
					<td class="tdfont_One">Song Title</td>
					<td class="tdfont_One">Album Name</td>
					<td class="tdfont_One">Artist Name</td>
					<td class="tdfont_One">Year</td>
				</tr>

				<s:iterator value="songsMoodList_2">
					<tr>
						<td class="tdfont_Two"><%=++moodCount_2%></td>
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
				<tr>
					<td></td>
					<td></td>
					<td>Download to Excel</td>
					<td><s:if test="%{songsMoodList_2.size() > 0}">
							<a download="SongsInformation_2.csv" href="#"
								onclick="return ExcellentExport.csv(this, 'songTable_2');"><img
								src="excel_image.png" /></a>
						</s:if></td>
					<td></td>
					<td></td>
				</tr>

			</table>
		</s:elseif>


	</body>
</s:form>
</html>
