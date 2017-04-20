<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>GoldrayTech|后台管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="GoldrayTech,后台管理">
	<meta http-equiv="description" content="Live House">
	<link rel="stylesheet" type="text/css" href="/css/common.css">
	<link rel="stylesheet" type="text/css" href="/css/backend.css">
	<link rel="stylesheet" type="text/css" href="/bootstrap3/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="/bootstrap3/css/bootstrap-datetimepicker.min.css">
	<link rel="stylesheet" type="text/css" href="/bootstrap3/css/bootstrap-select.min.css">
	<script src="/js/jquery/jquery-1.11.1.min.js"></script>
	<script src="/js/jquery.validate.min.js"></script>
    <script src="/bootstrap3/js/bootstrap.min.js"></script>
    <script src="/bootstrap3/js/bootstrap-select.min.js"></script>
    <script src="/bootstrap3/js/bootstrap-datetimepicker.min.js"></script>
    <script type="text/javascript"src="/ueditor/ueditor.config.js"></script>
    <script type="text/javascript"src="/ueditor/ueditor.all.min.js"></script>
    <script src="/js/pinyin_dict_firstletter.js"></script>
    <script src="/js/pinyinUtil.js"></script>
    <script src="/js/common.js"></script>
    <script src="/js/backend.js"></script>
  </head>
  <body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container"><!--container-fluid-->
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="javascript:;">GoldrayTech 后台管理</a>
      </div>
      <div id="navbar" class="collapse navbar-collapse" role="navigation">
        <ul id="mytab" class="nav navbar-nav">
          <li><a href="/backend/categories/list">分类管理</a></li>
          <li><a href="/backend/product/list">产品管理管理</a></li>
          <li class="dropdown">
            <a data-toggle="dropdown" href="#" >
              站内信息管理 <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
              <li><a href="/backend/banner/list">BANNER 管理</a></li>
              <!--<li><a href="#">成功案例管理</a></li>-->
              <li><a href="/backend/news/list">新闻管理</a></li>
              <li><a href="/backend/richText/save?richType=0">关于我们、技术支持、联系我们信息管理</a></li>
            </ul>
          </li>

        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </nav>