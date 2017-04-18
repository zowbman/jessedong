<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">Banner <c:choose><c:when test="${type== 'add'}">添加</c:when><c:otherwise>修改</c:otherwise></c:choose></h3>
    <form id="bannerForm" action="/backend/banner/saveSubmit" method="post" enctype="multipart/form-data">
        <input type="hidden" class="form-control" id="type" name="type" placeholder="TYPE"  value="${type}">
        <c:if test="${type == 'edit'}">
            <div class="form-group">
                 <label for="id">ID</label>
                 <input type="text" class="form-control" id="id" name="id" placeholder="ID" readonly value="${bp.id}">
            </div>
        </c:if>
        <div class="form-group">
            <label for="">标题</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Title" value="${bp.title}">
        </div>
        <div class="form-group">
            <label for="">图片</label>
            <input type="file" id="bannerImg" name="bannerImg" accept="image/*">
            <div style="margin-top:10px;">
                <a href="${bp.path}${bp.imgName}" target="_blank"><img src="${bp.path}${bp.imgName}" width="100"/></a>
            </div>
        </div>
        <div class="form-group">
            <label for="">是否显示</label>
            <div>

                <label class="radio-inline">
                    <input type="radio" name="isShow" id="isShow" value="0" <c:if test="${bp.isShow == 0 || bp == null}">checked="true"</c:if>> 否
                </label>
                <label class="radio-inline">
                    <input type="radio" name="isShow" id="isShow" value="1" <c:if test="${bp.isShow == 1}">checked="true"</c:if>> 是
                </label>
            </div>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <a href="/backend/banner/list" class="btn btn-default" style="width:70px;">Back</a>
     </form>
</div>
<%@ include file="/jsp/backend/public/footer.jsp" %>