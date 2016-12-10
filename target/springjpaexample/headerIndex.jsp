<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link href="headerIndex/headerIndex.css" rel="stylesheet" type="text/css">
<style>
body { margin: 0; background: #000;}
video { 
position: fixed;
top: 50%;
left: 50%;
min-width: 100%;  
min-height: 100%;
width: auto;
height: auto;
z-index: -100;
-moz-transform: translateX(-50%) translateY(-50%);
-ms-transform: translateX(-50%) translateY(-50%);
-webkit-transform: translateX(-50%) translateY(-50%);
transform: translateX(-50%) translateY(-50%);
background: url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/polina.jpg') no-repeat; background-size: cover;  -webkit-transition: 1s opacity; transition: 1s opacity; }
div.topdiv { font-family: Agenda-Light, Agenda Light, Agenda, Arial Narrow, sans-serif;   
font-weight: 100; background: rgba(0,0,0,0.3); color: white; padding: 2rem; width: 33%; margin: 2rem; float: right; margin: 100px 30px 10px 10px; font-size: 1.2rem; }
h1 { font-size: 3rem; text-transform: uppercase; margin-top: 0; letter-spacing: .3rem; }
a { display: inline-block; color: #fff; text-decoration: none; background: rgba(0,0,0,0.5); 
padding: .5rem; -webkit-transition: .6s background; transition: .6s background; }
a:hover { background: rgba(0,0,0,0.9); }
.stopfade { opacity: .5; }
#polina button { 
  display: block;
  width: 80%;
  padding: .4rem;
  border: none; 
  margin: 1rem auto; 
  font-size: 1.3rem;
  background: rgba(255,255,255,0.23);
  color: #fff;
  border-radius: 3px; 
  cursor: pointer;
  -webkit-transition: .3s background;
  transition: .3s background;
}
#polina button:hover { 
   background: rgba(0,0,0,0.5);
}

@media screen and (max-width: 500px) { 
  div{width:70%;} 
}
@media all and (max-device-width: 800px) {
  body { background: url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/polina.jpg") #000 no-repeat center center fixed; background-size: cover; }
  #bgvid, #polina button { display: none; }
  div{width:70%;} 
}
</style>
<meta charset="utf-8">
</head>
<body>
<video autoplay="autoplay" loop="" poster="https://s3-us-west-2.amazonaws.com/s.cdpn.io/4273/polina.jpg" id="bgvid" class="stopfade">
<source src="headerIndex/polina.webm" type="video/webm">
<source src="headerIndex/polina.mp4" type="video/mp4">
</video> 
<div id="polina" class="topdiv">
<h1>Polina</h1>
<p>filmed by Alexander Wagner 2011
</p><p><a href="http://thenewcode.com/777/Create-Fullscreen-HTML5-Page-Background-Video">return to article</a>
</p><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
Curabitur porta dictum turpis, eu mollis justo gravida ac. Proin non 
eros blandit, rutrum est a, cursus quam. Nam ultricies, velit ac 
suscipit vehicula, turpis eros sollicitudin lacus, at convallis mauris 
magna non justo. Etiam et suscipit elit. Morbi eu ornare nulla, sit amet
 ornare est. Sed vehicula ipsum a mattis dapibus. Etiam volutpat vel 
enim at auctor.
</p><p>Aenean pharetra convallis pellentesque. Vestibulum et metus 
lectus. Nunc consectetur, ipsum in viverra eleifend, erat erat ultricies
 felis, at ultricies mi massa eu ligula. Suspendisse in justo dapibus 
metus sollicitudin ultrices id sed nisl.</p>
<button>Pause</button>
</div>
<script>
var video = document.getElementById("bgvid"),
pauseButton = document.querySelector("#polina button");

function vidFade() {
  video.classList.add("stopfade");
}

video.addEventListener('ended', function()
{
// only functional if "loop" is removed 
video.pause();
vidFade();
}, false); 
 
pauseButton.addEventListener("click", function() {
  video.classList.toggle("stopfade");
  if (video.paused) {
    video.play();
    pauseButton.innerHTML = "Pause";
  } else {
    video.pause();
    pauseButton.innerHTML = "Paused";
  }
}, false);

video.addEventListener('touchstart', function(e) {
e.preventDefault();
video.play();
})
(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','http://google-analytics.com/analytics.js','ga');
  ga('create', 'UA-9896842-2', 'auto');
  ga('send', 'pageview');
</script>
</body></html>