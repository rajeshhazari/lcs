<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isErrorPage="true" %>
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>


<link>
<title> Solr admin Error Page </title>
</HEAD>
<BODY class="errorBody">

<br/>
<div id="lname_error" class="errorClass" >

<br/>
Error information:<br/>
<i>${indexStatusVo.strStatus}</i>

</div>
<p class="forward">
Please fix the above error/exception and try once again using the below link or contact support team @
</p>

<i><a href="${pageContext.request.contextPath}/indexCollection.do">Start Indexing on one or all Collection</a></i>
</BODY>
<c:set var = "errorMsg" value="${strIndexErrorMessage}"></c:set>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/lib/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/error.js"></script>
</HTML>