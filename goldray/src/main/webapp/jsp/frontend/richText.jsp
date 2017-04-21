<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/jsp/frontend/public/head.jsp" %>
        <div class="main">
            <div class="main-breadcrumbs">
                <div class="container">
                    <ul>
                        <li><a href="/nav/${page}"><i class="fa ${navIcon}"></i><span data-localize="nav.${page}">${page}</span></a></li>
                    </ul>
                </div>
            </div><!--面包屑区域结束-->
            <div class="main-content">
                <div class="container">
                    <div class="rich-text">
                        <div id="rich-text-content"></div>
                    </div>
                </div>
            </div>
        </div><!--内容区域-->

<%@ include file="/jsp/frontend/public/footer.jsp" %>
    <script>
        $(function(){
            $.ajax({
                type: 'GET',
                url: '/richText/json/v1/${richTextType}',
                success: function(data){
                    if(data.code==0){
                        $('#rich-text-content').html(data.data.text);
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
