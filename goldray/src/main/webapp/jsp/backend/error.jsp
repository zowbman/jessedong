<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h1 class="page-header">ERROR</h1>
    <p class="lead">${msg}</p>
    <p><a href="#" onClick="javascript:history.back();">Back to the history.</a></p>
</div>
<%@ include file="/jsp/backend/public/footer.jsp" %>