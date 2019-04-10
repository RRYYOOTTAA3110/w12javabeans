<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
import="java.util.List"
import="java.util.ListIterator"
import="jp.webschool.javaweb.chapter12.bean.ResBean"
import="jp.webschool.javaweb.chapter12.util.Cast"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>掲示板</title>
</head>
<body>
	<h1>掲示板</h1>
	<ul>
		<li>名前、題名、内容をすべて入力し、[書き込む]をクリックしましす。</li>
	</ul>
	<form method="post" action="/w12javabeans/Controller">
		<table>
			<tr>
				<td>名前</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>題名</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>内容</td>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="書き込む"></td>
			</tr>
		</table>
	</form>
	<hr>
	<%
	List<ResBean> list = Cast.castList(session.getAttribute("list"));
	if(list != null){
		ListIterator<ResBean> iterator = list.listIterator(list.size());
		while(iterator.hasPrevious()){
			ResBean res = iterator.previous();
	%>
	<p>名前：<%=res.getName() %> :<%=res.getTime() %></p>
	<p>題名：<%=res.getTitle() %></p>
	<p>内容：<%=res.getContents() %></p>
	<hr>
	<% }
	} %>

</body>
</html>