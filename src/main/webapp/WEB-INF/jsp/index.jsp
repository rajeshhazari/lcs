<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<html>
<head>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/main.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css" />

</head>
<body class="body"  style="margin-left: 150px; background-color:ThreeDLightShadow" >
	<!-- <h1>Sample LCS page</h1> -->

	<%-- <h2>largestSubString :: ${largestSubString}</h2> --%>
	<p>
	
	<div class="textFont" >Please enter strings to get Largest Common String ::<div><br>
	<div class="wallpapered"   style="margin-left: 150px;" >
		<div class="background"></div>
		<textarea  spellcheck="false" id="textArea"  autofocus="autofocus"
			required="required" placeholder="{\'setOfStrings\'&nbsp:&nbsp[{'value'&nbsp:&nbsp'sungard'},&#010;&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp{'value':'garden'}]}"></textarea>
		<br>
	</div>
	<button class="submitbutton"   style="margin-left: 150px; " >Submit</button>
	</p>
	<div class="statusMessage" id="statusMessage" style="display: none"></div>
	<div class="error" id="error" class="error,text-font,text-left "></div>
</body>
</body>
</html>