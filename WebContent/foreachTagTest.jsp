<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@taglib uri="/myTagLib" prefix="c"%>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录--%>
<%-- <%@taglib uri="/WEB-INF/tld/TagLib.tld" prefix="ly"%> --%>
<!DOCTYPE HTML>
<html>
<head>
<title>foreach标签测试</title>
</head>
<%
    //list集合
    List<String> listData = new ArrayList<String>();
    listData.add("111");
    listData.add("bbb");
    listData.add("ccc");

    //对象数组
    Integer intObjArr[] = new Integer[] { 1, 2, 3 };

    //基本数据类型数组
    int intArr[] = new int[] { 4, 5, 6 };

    //map集合
    Map<String, String> mapData = new HashMap<String, String>();
    mapData.put("a", "aaaaaa");
    mapData.put("b", "bbbbbb");

    //将集合存储到pageContext对象中
    pageContext.setAttribute("listData", listData);
    pageContext.setAttribute("intObjArr", intObjArr);
    pageContext.setAttribute("intArr", intArr);
    pageContext.setAttribute("mapData", mapData);
%>
<body>
	 <%--迭代存储在pageContext对象中的list集合 --%>
	<c:foreach items="${listData}" var="str">
		${str}<br />
	</c:foreach>
	<hr/>
	<%--迭代存储在pageContext对象中的数组 --%>
	<c:foreach items="${intObjArr}" var="num">
		${num}<br />
	</c:foreach>
	<hr/>
	<%--迭代存储在pageContext对象中的数组 --%>
	<c:foreach items="${intArr}" var="num">
		${num}<br />
	</c:foreach>
	<hr/>
	<%--迭代存储在pageContext对象中的map集合 --%>
	<c:foreach items="${mapData}" var="me">
		${me}<br />
	</c:foreach>
</body>
</html>