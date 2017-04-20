<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/frontend/public/head.jsp" %>
        <div class="main">
            <div class="main-breadcrumbs">
                <div class="container">
                    <ul>
                        <li><a href="#"><i class="fa fa-home"></i><span data-localize="nav.home">Home</span></a></li>
                        <li><i class="fa fa-angle-right"></i><span data-localize="nav.news">News</span></li>
                    </ul>
                </div>
            </div><!--面包屑区域结束-->
            <div class="main-content news-list-content">
                <div class="container">
                    <div class="news-list">
                        <ul></ul>
                    </div>
                </div>
            </div>
        </div><!--内容区域-->
<%@ include file="/jsp/frontend/public/footer.jsp" %>
	</body>
</html>
