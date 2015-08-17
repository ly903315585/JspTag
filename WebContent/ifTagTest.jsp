<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/myTagLib" prefix="c"%>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录--%>
<%-- <%@taglib uri="/WEB-INF/tld/TagLib.tld" prefix="ly"%> --%>
<!DOCTYPE HTML>
<html>
<head>
<title>if标签测试</title>
</head>
<body>
	<%--if标签的test属性值为true ,标签体的内容会输出--%>
	<c:if test="true">
		<h3>网站内部资料</h3>
	</c:if>
	<%--if标签的test属性值为false ,标签体的内容不会输出--%>
	<c:if test="false">
         这里的内部不输出
     </c:if>
</body>
</html>