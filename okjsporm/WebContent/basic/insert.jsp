<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<%@ page import="org.hibernate.SessionFactory"     %>
<%@ page import="org.hibernate.Session"            %>
<%@ page import="org.hibernate.Transaction"        %>
<%@ page import="org.hibernate.util.HibernateUtil" %>


<% request.setCharacterEncoding("euc-kr"); %>

<jsp:useBean scope="page" id="history" class="org.hibernate.ch01.History" />
<jsp:setProperty name="history" property="*" />

<%
	SessionFactory sessionFactory = null ; 
	Session        con            = null ; // Session session
	Transaction    tx             = null;

    try {
        sessionFactory = HibernateUtil.getSessionFactory() ; 
        con            = HibernateUtil.getSession()        ; 
        tx             = con.beginTransaction()            ; 
        con.save(history)      ; 
        tx.commit()            ; 
    } catch (Exception ex) {
    	if (tx != null) {
    		tx.rollback() ; 
    	}
    } finally {
    	con.close();
    } 
%>


<jsp:forward page="list.jsp"/>


