<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">Banner列表管理</h3>
    <form id="form-search-banner" class="form-inline form-sigin" style="text-align:right;" novalidate="novalidate">
        <a href="/backend/banner/save?type=add" class="btn btn-default banner-add-btn form-sigin-btn">添加</a>
    </form>
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>添加时间</th>
              <th>标题</th>
              <th>图片</th>
              <th>是否显示</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="item" items="${bannerPos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.addTime}</td>
                    <td>${item.title}</td>
                    <td><a href="${item.imgUrl}" target="_blank"><img src="${item.imgUrl}" width="100"/></a></td>
                    <td>${item.isShow}</td>
                    <td>
                        <a class="btn btn-default btn-xs" href="/backend/banner/save?type=edit&id=${item.id}"  role="button">修改</a>
                        <a class="btn btn-default btn-xs" onclick="if(!confirm('确认要删除该条记录?')) return false;" href="/backend/banner/delete?id=${item.id}" role="button">移除</a>
                    </td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
</div>
<%@ include file="/jsp/backend/public/footer.jsp" %>