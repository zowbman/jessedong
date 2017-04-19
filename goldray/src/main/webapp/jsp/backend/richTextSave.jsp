<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <ul class="nav nav-tabs page-header">
      <li role="presentation" <c:if test="${richType == 0}">class="active"</c:if>><a href="/backend/richText/save?richType=0">关于我们</a></li>
      <li role="presentation" <c:if test="${richType == 1}">class="active"</c:if>><a href="/backend/richText/save?richType=1">技术支持</a></li>
      <li role="presentation" <c:if test="${richType == 2}">class="active"</c:if>><a href="/backend/richText/save?richType=2">联系我们</a></li>
    </ul>
    <form id="richTextForm" action="/backend/richText/saveSubmit" method="post" enctype="multipart/form-data" style="margin-top: 20px;">
        <input type="hidden" class="form-control" id="type" name="type" placeholder="TYPE"  value="${type}">
        <input type="hidden" class="form-control" id="richType" name="richType" placeholder="RICHTYPE"  value="${richType}">
        <c:if test="${type == 'edit'}">
            <div class="form-group">
                 <label for="id">ID</label>
                 <input type="text" class="form-control" id="id" name="id" placeholder="ID" readonly value="${rtps.id}">
            </div>
        </c:if>
        <div class="form-group">
            <label for="">添加时间</label>
            <input size="16" id="addTime" name="addTime" type="text" value="${rtps.addTime}" class="form-control form_datetime">
        </div>
        <div class="form-group">
            <label for="">内容</label>
            <textarea id="richText" name="text">${rtps.text}</textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
     </form>
</div>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        todayBtn:  1,
    	autoclose: 1,
    	format: 'yyyy-mm-dd hh:mm:ss'
    });
    UE.getEditor('richText');
</script>
<%@ include file="/jsp/backend/public/footer.jsp" %>