
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title>Million Song</title>
<meta name="description" content="website description" />
<meta name="keywords" content="website keywords, website keywords" />
<meta http-equiv="content-type"
	content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Tangerine&amp;v1" />
<link rel="stylesheet" type="text/css"
	href="http://fonts.googleapis.com/css?family=Yanone+Kaffeesatz" />
<link rel="stylesheet" type="text/css" href="style/style.css" />
</head>
<body onload="startClock()"></body>
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
		function startClock() {
			var today = new Date();
			var hours = today.getHours();
			var minutes = today.getMinutes();
			var seconds = today.getSeconds();

			minutes = checkTime(minutes);
			seconds = checkTime(seconds);
			document.getElementById("Time").innerHTML = hours + ":" + minutes
					+ ":" + seconds;
			var t = setTimeout(function() {
				startClock()
			}, 500);
		}

		function checkTime(i) {
			if (i < 10) {
				i = "0" + i;
			}
			return i;
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
	<body>
	<form id="indexForm" name="indexForm" enctype="multipart/form-data">

		<div id="wrapper">			
				<h1>
					<em>Yet Another Song Database</em>
					
				</h1>
				<h2 STYLE="position:relative; TOP:-10px; LEFT:55px; color: WHITE;">
				<em> Million song records from the.EchoNest.com</em>
				</h2>
				<img src="images/music01.png" STYLE="position:relative; TOP:-45px; LEFT:960px; WIDTH:375px; HEIGHT:210px"/>

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



				<div id="topcon">
					<div id="topcon-inner">
						<h2>Welcome to Million Song Database!</h2>
						<p>We have made this barely astounding and passively
							aggressive beauty of a website to provide information about a
							million songs.</p>
						<p>This website will only be up till we get our grades for
							this semester, so please take advantage of all this free
							information! Hurry!</p>
					</div>
					<br>

				</div>

				<div id="content">
					<div id="body">
						<div class="box" id="news">
							<div class="box-t">
								<div class="box-r">
									<div class="box-b">
										<div class="box-l">
											<div class="box-tr">
												<div class="box-br">
													<div class="box-bl">
														<div class="box-tl">
															<h2>NEWS &amp; EVENTS</h2>
															<h3>23.04.2016</h3>
															<p>
																Great Offer! Access songs according to your Mood! Head
																over to our <a id="blog" title="Go to Explore Page" href="#"
							onclick="loadWebPages(this.id);return false;">Explore</a> section to know
																which songs describe the effervescent feelings of your
																everchanging heart.
															</p>
															
															<div class="hr-yellow"></div>
															<h3>15.04.2016</h3>
															<p>
																This website is free, but if you think we could have
																done a better job by hiring actual developers instead of
																our team of poor graduates, please think about <a href="#">donating</a> to
																our page. We don't have a donations page yet, cause we
																don't know how to set it up :( But hopefully, when we
																have enough money and we do hire those fancy developers,
																we can set it up. Oh wait...
															</p>
															
															<div class="hr-yellow"></div>
															<h3>15.04.2016</h3>
															<p>
																If you're having problems viewing this site, you
																probably need to buy a new computer. Please consider
																giving your valued feedback at our <a id="contact" title="Go to Contact Page" href="#"
							onclick="loadWebPages(this.id);return false;">
																	About Us</a> page, which will tell you we don't accept
																feedback. You're welcome.
															</p>
															
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box" id="hits">
							<div class="box-t">
								<div class="box-r">
									<div class="box-b">
										<div class="box-l">
											<div class="box-tr">
												<div class="box-br">
													<div class="box-bl">
														<div class="box-tl">
															<h2>Some statistics of hit songs and artists! 
															</h2>
															<h3>Hit Songs</h3>
															<img src="images/pic_1.jpg" width="63" height="91"
																alt="Pic 1" class="right" />
															<ul>
																<li><a href="#">Endless Light - Erik Berglund </a></li>
																<li><a href="#"> Bitesize - Electro Beats Mix</a></li>
																<li><a href="#">Raga Anandi Kalyan (Alap_ jor and jhala)</a></li>
																<li><a href="#">Fall River Legend: Conversation: Morton Gould/Agnes de Mille </a></li>
																<li><a id="blog" title="Go to Explore Page" href="#"
							onclick="loadWebPages(this.id);return false;">Check out some more Hit songs!</a></li>
															</ul>
															<div class="hr-yellow"></div>
															<h3>Hit Artists</h3>
															<img src="images/pic_2.jpg" width="63" height="81"
																alt="Pic 2" class="right" />
															<ul>
																<li><a href="#">Still laughing, cause it says
																		Hit Artists </a></li>
																<li><a href="#">Kanye West (Du-oh)</a></li>
																<li><a href="#">Adam Levine</a></li>
																<li><a href="#">Daft Punk</a></li>
																<li><a id="blog" title="Go to Explore Page" href="#"
							onclick="loadWebPages(this.id);return false;">Check out some more Hit Artists!</a></li>
															</ul>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="box" id="new">
							<div class="box-t">
								<div class="box-r">
									<div class="box-b">
										<div class="box-l">
											<div class="box-tr">
												<div class="box-br">
													<div class="box-bl">
														<div class="box-tl">
															<h2>New Releases</h2>
															<h3>New Album</h3>
															<img src="images/pic_3.jpg" width="66" height="52"
																alt="Pic 3" class="right" />
															<p>Yes, -> this girl is listening to it</p>
															<h3>New Song</h3>
															<img src="images/pic_4.jpg" width="66" height="52"
																alt="Pic 4" class="right" />
															<p>Yup he's listening to it too -></p>
															<h3>New Artist</h3>
															<img src="images/pic_5.jpg" width="66" height="52"
																alt="Pic 5" class="right" />
															<p>Nah, he's not that guy -></p>
															<li><a id="blog" title="Go to Explore Page" href="#"
							onclick="loadWebPages(this.id);return false;">But seriously, check out some New Releases here!</a></li>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
					<div id="footer">
						<ul>
							<li><a id="home" href="#"
								onclick="loadWebPages(this.id);return false;">HOME</a> |</li>
							<li><a id="search" href="#"
								onclick="loadWebPages(this.id);return false;">SEARCH</a> |</li>
							<li><a id="blog" href="#"
								onclick="loadWebPages(this.id);return false;">EXPLORE</a> |</li>
							<li><a id="visualization" href="#"
								onclick="loadWebPages(this.id);return false;">VISUALIZATIONS</a>
								|</li>
							<li><a id="contact" href="#"
								onclick="loadWebPages(this.id);return false;">CONTACT US</a> |</li>
							<li><a title="send to Facebook"
								href="http://www.facebook.com/sharer.php?s=100&p[title]=MillionSong&p[summary]=MillionSong&p[url]=http://localhost:8989/MillionSongCloud/DisplayActiondisplayHomePage&p[images][0]=YOUR_IMAGE_TO_SHARE_OBJECT"
								target="_blank"> <span> <img width="14" height="14"
										src="images/fb.gif" alt="Facebook" /> Share Us on Facebook
								</span>
							</a></li>
						</ul>
						<p>
							Cloud Technologies &copy;2016 DCU, All Rights Reserved <em><div
									id="Time" style="text-align: center;"></div></em>
						</p>

					</div>
				</div>
			</div>

		
	</form>
	</body>
</html>
