<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">产品分类 <c:choose><c:when test="${type== 'add'}">添加</c:when><c:otherwise>修改</c:otherwise></c:choose></h3>
    <form id="categoriesForm" action="/backend/categories/saveSubmit" method="post">
        <input type="hidden" class="form-control" id="type" name="type" placeholder="TYPE"  value="${type}">
        <c:if test="${type == 'edit'}">
            <div class="form-group">
                 <label for="id">ID</label>
                 <input type="text" class="form-control" id="id" name="id" placeholder="ID" readonly value="${cPo.id}">
            </div>
        </c:if>
        <div class="form-group">
            <label for="">产品分类名称</label>
            <input type="text" class="form-control" id="categoriesName" name="categoriesName" placeholder="CategoriesName" value="${cPo.categoriesName}">
        </div>
        <div class="form-group">
            <label for="">分类名称拼音缩写</label>
            <input type="text" class="form-control" id="cAbbreviate" name="cAbbreviate" placeholder="CAbbreviate" value="${cPo.cAbbreviate}">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <a href="/backend/categories/list" class="btn btn-default" style="width:70px;">Back</a>
     </form>
</div>
<%@ include file="/jsp/backend/public/footer.jsp" %>