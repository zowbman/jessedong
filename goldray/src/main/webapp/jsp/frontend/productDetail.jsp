<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/frontend/public/head.jsp" %>
        <div class="main">
            <div class="main-breadcrumbs">
                <div class="container">
                    <ul>
                        <li><a href="#"><i class="fa fa-home"></i>Home</a></li>
                        <li><i class="fa fa-angle-right"></i><span>Pro Detail</span></li>
                    </ul>
                </div>
            </div><!--面包屑区域结束-->
            <div class="main-content">
                <div class="container">
                    <div class="pro-detail">
                        <div class="pro-detail-right">
                            <div class="pro-detail-title">
                                <h1>Product Product Product Product Product Product Product Product Product Product Product Product Product Product</h1>
                            </div>
                            <div class="pro-detail-num">
                                Item Code: LC61094-1
                            </div>
                            <div class="pro-detail-share">
                                <b>Share this:</b>
                            </div>
                            <div class="pro-detail-info">
                                Product Product Product Product Product Product Product Product Product Product Product Product Product ProductProduct Product Product Product Product Product Product Product Product Product Product Product Product ProductProduct Product Product Product Product Product Product Product Product Product Product Product Product Product
                            </div>
                        </div><!--产品详细右区域结束-->
                        <div class="pro-detail-left">
                            <div id="proDetailImg">
                                <div class="loading"><img src="/myfocus/mf-pattern/img/loading.gif" alt="请稍候..." /></div>
                                <!-- 内容列表 -->
                                <div class="pic">
                                    <ul>
                                        <li><a href="#"><img src="/img/banner/3.jpg" alt="标题1" /></a></li>
                                        <li><a href="#"><img src="/img/banner/2.jpg" alt="标题2" /></a></li>
                                        <li><a href="#"><img src="/img/banner/1.jpg" alt="标题3" /></a></li>
                                        <li><a href="#"><img src="/img/banner/4.jpg" alt="标题4" /></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div><!--产品详细左区域结束-->
                    </div>
                    <div class="pro-detail-more">
                        <ul class="pro-detail-more-title">
                            <li class="current"><span>Description</span></li>
                        </ul>
                        <div id="pro-detail-more-content">
                            text
                        </div>
                    <div>
                </div>
            </div>
        </div><!--内容区域-->
<%@ include file="/jsp/frontend/public/footer.jsp" %>
        <script>
		    myFocus.set({
		    pattern:'mF_games_tb',
		    id: 'proDetailImg',
		    height:455,
		    wrap:false
		    });
		</script>
	</body>
</html>
