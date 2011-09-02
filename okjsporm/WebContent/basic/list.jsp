<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="java.util.List"                   %>
<%@ page import="java.util.Iterator"               %>
<%@ page import="org.hibernate.SessionFactory"     %>
<%@ page import="org.hibernate.Session"            %>
<%@ page import="org.hibernate.Transaction"        %>
<%@ page import="org.hibernate.util.HibernateUtil" %>
<%@ page import="org.hibernate.ch01.History"       %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title> list.jsp  </title>
</head>
<body>


<h2> 큐브리드   History 테이블에   입력된 자료를 가져오기 (list.jsp)  </h2> 
<h>

<table cellpadding="1">
    <tr>
        <td align="center"> eventCode </td>
        <td align="center"> athlete </td>
        <td align="center"> hostYear </td>
        <td align="center"> score </td>
        <td align="center"> unit </td>
    </tr>



<%
    List           result         = null ; 
    SessionFactory sessionFactory = null ; 
    Session        con            = null ; // Session session
    Transaction    transaction    = null ;

    sessionFactory = HibernateUtil.getSessionFactory() ; 
    con            = HibernateUtil.getSession() ; //Session session = HibernateUtil.getSession() ; 
    result         = con.createCriteria(History.class).list() ; 
    
    if ( result.size() > 0) {
        for ( Iterator it = result.iterator(); it.hasNext(); ) {
        	History history = (History)it.next() ; 
%>
        
    <tr>
        <td align="center"> <%= history.getEventCode() %> </td>
        <td align="center"> <%= history.getAthlete()   %> </td>
        <td align="center"> <%= history.getHostYear()  %> </td>
        <td align="center"> <%= history.getScore()     %> </td>
        <td align="center"> <%= history.getUnit()      %> </td>
    </tr>
    	

<%
        }
    } else {
%>
    <tr>
        <td colspan="5"> 자료가  없습니다. </td>
    </tr>
<%
    }
    con.close();
%>


</table>

</body>
</html>

