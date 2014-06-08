<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="myblog.Topic,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>閱讀 Blog</title>
</head>
<body>
  <h2>簡單的 Blog</h2>
  <a href="read">重新載入</a>
  
  <form action="post" method="POST">
     標題<input type="text" name="title" size="40">
    <br>
    <textarea name="content" rows="5" cols="5"></textarea>
    <br>
    <input type="submit" value="投稿">
  </form>
  
  <%
    List<Topic> topics = (List<Topic>)request.getAttribute("topics");
    if(topics != null){
    	for(int i=topics.size()-1; i>=0; i--) {
    		Topic topic = (Topic)topics.get(i);
   
  %>
    <hr>
        標題 <%=topic.getTitle()%>
     (<%=topic.getPostDate()%>)
     <pre><%=topic.getContent()%></pre>
  
  
  <%
     	}
    }
  %>
  
</body>
</html>