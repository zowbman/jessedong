<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">产品列表管理</h3>
    <form id="form-search-product" class="form-inline form-sigin" style="text-align:right;" novalidate="novalidate">
        <a href="/backend/product/save?type=add" class="btn btn-default banner-add-btn form-sigin-btn">添加</a>
    </form>
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>添加时间</th>
              <th>产品类别</th>
              <th>名称</th>
              <th>封面</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="item" items="${productListPos}">
                <tr>
                    <td>${item.code}</td>
                    <td>${item.addTime}</td>
                    <td>${item.categories}</td>
                    <td>${item.title}</td>
                    <td><a href="${item.coverImg}" target="_blank"><img src="${item.coverImg}" width="100"/></a></td>
                    <td>
                        <a class="btn btn-default btn-xs" href="/backend/product/save?type=edit&code=${item.code}"  role="button">修改</a>
                        <a class="btn btn-default btn-xs" onclick="if(!confirm('确认要删除该条记录?')) return false;" href="/backend/product/delete?code=${item.code}" role="button">移除</a>
                    </td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
</div>
<%@ include file="/jsp/backend/public/footer.jsp" %>