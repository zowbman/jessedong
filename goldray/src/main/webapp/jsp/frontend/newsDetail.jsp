<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/frontend/public/head.jsp" %>
        <div class="main">
            <div class="main-breadcrumbs">
                <div class="container">
                    <ul>
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><i class="fa fa-angle-right"></i><a href="#">News</a></li>
                        <li><i class="fa fa-angle-right"></i><span>12312</span></li>
                    </ul>
                </div>
            </div><!--面包屑区域结束-->
            <div class="main-content">
                <div class="container">
                    <div class="news-title"></div>
                    <div class="news-date"></div>
                    <div id="news-content" class="news-content"></div>
                </div>
            </div>
        </div><!--内容区域-->
<%@ include file="/jsp/frontend/public/footer.jsp" %>
	</body>
</html>
