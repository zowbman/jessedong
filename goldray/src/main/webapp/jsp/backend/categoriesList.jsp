<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/backend/public/head.jsp" %>
<div class="container" style="padding-bottom: 60px;">
    <h3 class="page-header">产品分类列表管理</h3>
    <form id="form-search-categories" class="form-inline form-sigin" style="text-align:right;" novalidate="novalidate">
        <a href="/backend/categories/save?type=add" class="btn btn-default categories-add-btn form-sigin-btn">添加</a>
    </form>
    <div class="table-responsive">
        <table class="table table-bordered table-hover">
          <thead>
            <tr>
              <th>#</th>
              <th>分类名称</th>
              <th>拼音缩写</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach var="item" items="${categoriesPos}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.categoriesName}</td>
                    <td>${item.cAbbreviate}</td>
                    <td>
                        <a class="btn btn-default btn-xs" href="/backend/categories/save?type=edit&id=${item.id}"  role="button">修改</a>
                        <a class="btn btn-default btn-xs" onclick="if(!confirm('确认要删除该条记录?')) return false;" href="/backend/categories/delete?id=${item.id}" role="button">移除</a>
                    </td>
                </tr>
            </c:forEach>
          </tbody>
        </table>
      </div>
</div>
<%@ include file="/jsp/backend/public/footer.jsp" %>