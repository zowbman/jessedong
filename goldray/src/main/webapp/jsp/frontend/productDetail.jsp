<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/frontend/public/head.jsp" %>
        <div class="main">
            <div class="main-breadcrumbs">
                <div class="container">
                    <ul>
                        <li><a href="#"><i class="fa fa-home"></i><span data-localize="nav.home">Home</span></a></li>
                        <li><i class="fa fa-angle-right"></i><span>Pro Detail</span></li>
                    </ul>
                </div>
            </div><!--面包屑区域结束-->
            <div class="main-content">
                <div class="container">
                    <div>
                        <div class="pro-detail-right">
                            <div class="pro-detail-title">
                                <h1>商品标题</h1>
                            </div>
                            <div class="pro-detail-num">
                                Item Code: XX00000-0
                            </div>
                            <div class="pro-detail-share">
                                <b>Share this:</b>
                            </div>
                            <div class="pro-detail-info">
                                商品简介
                            </div>
                        </div><!--产品详细右区域结束-->
                        <div class="pro-detail-left">
                            <div id="proDetailImg">
                                <div class="loading"><img src="/myfocus/mf-pattern/img/loading.gif" alt="请稍候..." /></div>
                                <!-- 内容列表 -->
                                <div class="pic">
                                    <ul></ul>
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
		    $(function(){
                $.ajax({
                    type: 'GET',
                    url: '/product/json/v1/${code}',
                    success: function(data){
                        if(data.code==0){
                            $('.pro-detail-title h1').html(data.data.title);
                            $('.pro-detail-num').html('Item Code: '+data.data.code);
                            $('.pro-detail-info').html(data.data.introduction);
                            var _html='';
                            $.each(data.data.pdImg,function(i,item){
                                _html+='<li><a href="'+item+'" target="blank"><img src="'+item+'" alt="" /></a></li>';
                            });
                            $('#proDetailImg ul').html(_html);
                            $('#pro-detail-more-content').html(data.data.text);
                            myFocus.set({
                                pattern:'mF_games_tb',
                                id: 'proDetailImg',
                                height:455,
                                wrap:false
                            });
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
