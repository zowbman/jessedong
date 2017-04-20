<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">新闻 <c:choose><c:when test="${type== 'add'}">添加</c:when><c:otherwise>修改</c:otherwise></c:choose></h3>
    <form id="newsForm" action="/backend/news/saveSubmit" method="post" enctype="multipart/form-data" style="margin-top: 20px;">
        <input type="hidden" class="form-control" id="type" name="type" placeholder="TYPE"  value="${type}">
        <input type="hidden" class="form-control" id="resume" name="resume" placeholder="RESUME"  value="${resume}">
        <c:if test="${type == 'edit'}">
            <div class="form-group">
                 <label for="id">ID</label>
                 <input type="text" class="form-control" id="id" name="id" placeholder="ID" readonly value="${np.id}">
            </div>
        </c:if>
        <div class="form-group">
            <label for="">标题</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="Title" value="${np.title}">
        </div>
        <div class="form-group">
            <label for="">添加时间</label>
            <input size="16" id="addTime" name="addTime" type="text" value="${np.addTime}" class="form-control form_datetime">
        </div>
        <div class="form-group">
            <label for="">是否置顶</label>
            <div>
                <label class="radio-inline">
                    <input type="radio" name="isTop" id="isTop" value="0" <c:if test="${np.isTop == 0 || np == null}">checked="true"</c:if>> 否
                </label>
                <label class="radio-inline">
                    <input type="radio" name="isTop" id="isTop" value="1" <c:if test="${np.isTop == 1}">checked="true"</c:if>> 是
                </label>
            </div>
        </div>
        <div class="form-group">
            <label for="">内容</label>
            <textarea id="richText" name="text">${np.text}</textarea>
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
        <a href="/backend/news/list" class="btn btn-default" style="width:70px;">Back</a>
     </form>
</div>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        todayBtn:  1,
    	autoclose: 1,
    	format: 'yyyy-mm-dd hh:mm:ss'
    });
    var ue = UE.getEditor('richText');
    ue.addListener('blur',function(){
       var editor=UE.getEditor('richText');
       var arr =(UE.getEditor('richText').getContentTxt());
       $('#resume').val(arr.substring(0,180));
   })
</script>
<%@ include file="/jsp/backend/public/footer.jsp" %>