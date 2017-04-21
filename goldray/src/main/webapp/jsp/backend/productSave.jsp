<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">产品 <c:choose><c:when test="${type== 'add'}">添加</c:when><c:otherwise>修改</c:otherwise></c:choose></h3>
    <form id="productForm" action="/backend/product/saveSubmit" method="post" enctype="multipart/form-data" style="margin-top: 20px;">
        <input type="hidden" class="form-control" id="type" name="type" placeholder="TYPE"  value="${type}">
        <c:if test="${type == 'edit'}">
            <div class="form-group">
                 <label for="id">Code</label>
                 <input type="text" class="form-control" id="code" name="code" placeholder="Code" readonly value="${pp.code}">
            </div>
        </c:if>
        <div class="form-group">
            <label for="">标题</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Title" value="${pp.title}">
        </div>
        <div class="form-group">
            <label for="">类别</label>
            <select id="categoriesId" name="categoriesId" class="selectpicker form-control" data-live-search="true">
                <c:forEach var="item" items="${cp}">
                    <option value="${item.id}" <c:if test="${item.id == pp.categoriesId}">selected</c:if>>${item.categoriesName}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="">简介</label>
            <textarea class="form-control" rows="3" cols="20" placeholder="Introduction" name="introduction" id="introduction">${pp.introduction}</textarea>
        </div>
        <div class="form-group">
            <label for="">更新日期</label>
            <input size="16" id="addTime" name="addTime" type="text" value="${pp.addTime}" class="form-control form_datetime">
        </div>
        <div class="row">
          <div class="col-md-3">
            <div class="form-group">
                <label for="">封面</label>
                <input type="file" id="coverImg" name="coverImg" accept="image/*">
                <div style="margin-top:10px;">
                    <a href="${pp.coverImg}" target="_blank"><img src="${pp.coverImg}" width="100"/></a>
                </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="form-group">
                <label for="">图片1</label>
                <c:if test="${pp.firstImg != null && pp.firstImg != ''}">
                    <a href="/backend/product/rmPdImg?code=${pp.code}&imgNum=1">移除</a>
                </c:if>
                <input type="file" id="firstImg" name="firstImg" accept="image/*">
                <div style="margin-top:10px;">
                    <a href="${pp.firstImg}" target="_blank"><img src="${pp.firstImg}" width="100"/></a>
                </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="form-group">
                <label for="">图片2</label>
                <c:if test="${pp.secondImg != null && pp.secondImg != ''}">
                    <a href="/backend/product/rmPdImg?code=${pp.code}&imgNum=2">移除</a>
                </c:if>
                <input type="file" id="secondImg" name="secondImg" accept="image/*">
                <div style="margin-top:10px;">
                    <a href="${pp.secondImg}" target="_blank"><img src="${pp.secondImg}" width="100"/></a>
                </div>
            </div>
          </div>
          <div class="col-md-3">
            <div class="form-group">
                <label for="">图片3</label>
                <c:if test="${pp.thirdImg != null && pp.thirdImg != ''}">
                    <a href="/backend/product/rmPdImg?code=${pp.code}&imgNum=3">移除</a>
                </c:if>
                <input type="file" id="thirdImg" name="thirdImg" accept="image/*">
                <div style="margin-top:10px;">
                    <a href="${pp.thirdImg}" target="_blank"><img src="${pp.thirdImg}" width="100"/></a>
                </div>
            </div>
          </div>
        </div>
        <div class="form-group">
            <label for="">内容</label>
            <textarea id="richText" name="text">${pp.text}</textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <a href="/backend/product/list" class="btn btn-default" style="width:70px;">Back</a>
     </form>
</div>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        todayBtn:  1,
    	autoclose: 1,
    	format: 'yyyy-mm-dd hh:mm:ss'
    });
    UE.getEditor('richText');
    $('#categoriesId').selectpicker({
      style: 'btn-info',
      size: 4
    });
</script>
<%@ include file="/jsp/backend/public/footer.jsp" %>