<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/myTagLib" prefix="ly"%>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录--%>
<%-- <%@taglib uri="/WEB-INF/tld/TagLib.tld" prefix="ly"%> --%>
<ly:referer site="http://localhost:8090" page="/index.jsp"/>
<!DOCTYPE HTML>
<html>
  <head>
     <title>防盗链标签测试</title>
  </head>
  <body>
      	 防盗链标签测试
  </body>
</html>