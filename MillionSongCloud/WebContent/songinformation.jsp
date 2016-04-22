<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<%
	int count = 0;
%>
<link rel="stylesheet" type="text/css" href="style/oldstyle.css" />
<script type="text/javascript" src="exportExcel.js"></script>
<head>
<title>Song Information</title>
</head>

<body>

	<table id="song_table" class="song_table">
		<tr>
			<td><s:property value="title" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
				download="Songs_Information.csv" href="#"
				onclick="return ExcellentExport.csv(this, 'song_table');"><img
					src="excel_image.png" /></a></td>
		</tr>
		<tr>
			<td class="tdfont_One">S. No</td>
			<td class="tdfont_One">Song Title</td>
			<td class="tdfont_One">Song Id</td>
			<td class="tdfont_One">Artist Familiarity</td>
			<td class="tdfont_One">Artist Hotness</td>
			<td class="tdfont_One">Artist Location</td>
			<td class="tdfont_One">Album Name</td>
			<td class="tdfont_One">Album Id</td>
			<td class="tdfont_One">Song Duration</td>
			<td class="tdfont_One">Key Signature</td>
			<td class="tdfont_One">Key Signature Confidence</td>
			<td class="tdfont_One">Loudness</td>
			<td class="tdfont_One">Song Mode</td>
			<td class="tdfont_One">Tempo</td>
			<td class="tdfont_One">Time Signature</td>
			<td class="tdfont_One">Time Signature Confidence</td>
			<td class="tdfont_One">Song Year</td>
		</tr>

		<s:iterator value="songInfoList">
			<tr>
				<td><%=++count%></td>
				<td><s:property value="title" /></td>
				<td><s:property value="songId" /></td>
				<td><s:property value="artistFamiliarity" /></td>
				<td><s:property value="artistHotness" /></td>
				<td><s:property value="artistLocation" /></td>
				<td><s:property value="albumName" /></td>
				<td><s:property value="albumId" /></td>
				<td><s:property value="duration" /></td>
				<td><s:property value="keySignature" /></td>
				<td><s:property value="keySignatureConfidence" /></td>
				<td><s:property value="loudness" /></td>
				<td><s:property value="songMode" /></td>
				<td><s:property value="tempo" /></td>
				<td><s:property value="timeSignature" /></td>
				<td><s:property value="timeSignatureConfidence" /></td>
				<td><s:if test='%{year > 0}'>
						<s:property value="year" />
					</s:if> <s:else>NA</s:else></td>
			</tr>

			<tr>

			</tr>
		</s:iterator>


	</table>

</body>

</html>