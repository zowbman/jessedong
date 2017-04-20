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
            <div class="main-content">
                <div class="container">
                    <div class="news-detail-title"></div>
                    <div class="news-detail-addTime"></div>
                    <div id="news-content" class="news-content"></div>
                </div>
            </div>
        </div><!--内容区域-->
<%@ include file="/jsp/frontend/public/footer.jsp" %>
    <script>
        $(function(){
            $.ajax({
                type: 'GET',
                url: '/news/json/v1/${id}',
                success: function(data){
                    if(data.code==0){
                        $('.news-detail-title').html(data.data.title);
                        $('.news-detail-addTime').html(data.data.addTime);
                        $('#news-content').html(data.data.text);
                    }else{
                        alert(data.msg);
                    }
                },
                error: function() {
                    alert('请求数据失败');
                }
            });
        });
    </script>
	</body>
</html>
