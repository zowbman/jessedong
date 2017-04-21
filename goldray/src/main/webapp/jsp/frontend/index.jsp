<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/frontend/public/head.jsp" %>
        <div class="main">
            <div class="main-breadcrumbs">
                <div class="container">
                    <ul>
                        <li><a href="/"><i class="fa fa-home"></i><span data-localize="nav.home">Home</span></a></li>
                    </ul>
                </div>
            </div><!--面包屑区域结束-->
            <div class="main-content">
                <div class="container">
                    <div class="row-right">
                        <div class="row-banner">
                            <div id="banner">
                              <!-- 载入中的Loading图片(可选) -->
                              <div class="loading"><img src="/myfocus/mf-pattern/img/loading.gif" alt="请稍候..." /></div>
                              <!-- 内容列表 -->
                              <div class="pic">
                              	<ul></ul>
                              </div>
                            </div>
                            <div id="topNews" class="topNews-box">
                                <div class="topNews">
                                    <a href="#" class="topNews_title">
                                        Introduction,Introduction,Introduction,Introduction
                                    </a>
                                    <div class="topNews_text topNews_resume">
                                        Introduction text,Introduction text,Introduction text,Introduction text,Introduction text,Introduction text,Introduction text,Introduction text,Introduction text,Introduction text,Introduction text.
                                    </div>
                                    <div class="topNews_text">
                                        <a href="javascript:;" class="topNews_more primary-b">Read more</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="pro-list-box">
                            <div class="pro-list">
                                <a href="#" class="pro-list_title">
                                    <span data-localize="product.product">Product</span>
                                </a>
                                <div id="pro-item"></div>
                                <div style="clear:both"></div>
                            </div>
                        </div>
                    </div><!--右区域结束-->
                    <div class="row-left">
                        <div class="row-form input-search">
                            <input class="form-control" type="text" placeholder="Enter your keywords">
                            <span class="b-btn b-btn-search f-btn-search fa fa-search fa-2x"></span>
                        </div><!--搜索结束-->
                        <div class="row-categories">
                            <h4 class="primary-b categories-h4">Products Categories</h4>
                            <ul id="pdCategories-ul"></ul>
                        </div>
                    </div><!--左区域结束-->
                </div>
            </div>
        </div><!--内容区域-->
        <%@ include file="/jsp/frontend/public/footer.jsp" %>
	</body>
</html>