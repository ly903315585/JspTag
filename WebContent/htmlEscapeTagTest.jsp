<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/myTagLib" prefix="c"%>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录--%>
<%-- <%@taglib uri="/WEB-INF/tld/TagLib.tld" prefix="ly"%> --%>
<!DOCTYPE HTML>
<html>
<head>
<title>html转义标签测试</title>
</head>
<body>
	<c:HtmlEscape>
		<a href="http://baidu.com">baidu</a>
	</c:HtmlEscape>
</body>
</html>