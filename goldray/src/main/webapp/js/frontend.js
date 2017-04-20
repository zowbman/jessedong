$(function(){
    //pdCategories
    if($('#pdCategories-ul').length ==1){
        $.ajax({
            type: 'GET',
            url: '/categories/json/v1/pdCount',
            success: function(data){
                if(data.code==0){
                    var _html='';
                    $.each(data.data, function(i,item){
                        _html+='<li><a class="categories_name" href="javascript"><i class="fa fa-plus"></i> '+item.categoriesName+'</a><span class="categories_count">'+item.count+'</span></li>'
                    });
                    $('#pdCategories-ul').html(_html)
                }else{
                    alert(data.msg);
                }
            },
            error: function() {
                alert('产品分类请求数据失败');
            }
        });
    }
    //banner
    if($('#banner').length ==1){
        _bannerPic = $('#banner .pic ul');
        $.ajax({
            type: 'GET',
            url: '/banner/json/v1/list',
            success: function(data){
                if(data.code==0){
                    var _html='';
                    $.each(data.data, function(i,item){
                        _html+='<li><a href="'+ (item.url == '' ? 'javascript:;': item.url);
                        if(item.isBlank == 1){
                            _html+= '" target="_blank">';
                        }else{
                            _html+= '">';
                        }
                        _html+='<img src="'+item.path+item.imgName+'" alt="" /></a></li>';
                    });
                    _bannerPic.html(_html);
                    console.log(data.data);
                    myFocus.set({
                        pattern:'mF_fancy',
                        id: 'banner',
                        height:420,
                        wrap:false
                    });
                }else{
                    alert(data.msg);
                }
            },
            error: function() {
                alert('banner请求数据失败');
            }
        });
    }
    //topnews
    if($('#topNews').length ==1){
        $.ajax({
            type: 'GET',
            url: '/news/json/v1/top',
            success: function(data){
                if(data.code==0){
                    if(data.data != null){
                        $('.topNews_title').html(data.data.title);
                        $('.topNews_resume').html(data.data.resume);
                        $('.topNews_more').attr('href','/news/' + data.data.id);
                    }
                }else{
                    alert(data.msg);
                }
            },
            error: function() {
                alert('news请求数据失败');
            }
        });
    }
    //product
    if($('#pro-item').length ==1){
        $.ajax({
            type: 'GET',
            url: '/product/json/v1/list',
            success: function(data){
                if(data.code==0){
                    var _html='';
                    $.each(data.data, function(i,item){
                        _html+='<dl class="pro-item">';
                        _html+='<dt><a class="pic_box" href="/product/'+item.code+'" title=""><img src="'+item.path+item.coverImgName+'"><span></span></a></dt>';
                        _html+='<dd class="pro-name"><a href="/product/'+item.code+'" title="" class="">'+item.title+'</a></dd>';
                        _html+='<dd class="pro-norms">'+item.code+'</dd>';
                        _html+='<dd class="pro-detail"><a href="/product/'+item.code+'" title=""><span data-localize="product.viewDetail">View Detail</span><em></em></a></dd>';
                        _html+='</dl>';
                    });
                    $('#pro-item').html(_html);
                }else{
                    alert(data.msg);
                }
            },
            error: function() {
                alert('产品请求数据失败');
            }
        });
    }
    //news
    if($('.news-list').length ==1){
        _newList = $('.news-list ul');
        $.ajax({
            type: 'GET',
            url: '/news/json/v1/list',
            success: function(data){
                if(data.code==0){
                    var _html='';
                    $.each(data.data, function(i,item){
                        _html+='<li><a class="news_title" href="/news/'+item.id+'">';
                        _html+='<i class="fa fa-newspaper-o"></i> ';
                        if(item.isTop !=null){
                            _html+=item.isTop+" ";
                        }
                        _html+=item.title;
                        _html+='</a><span class="news_addTime">'+item.addTime+'</span></li>'
                    });
                    _newList.html(_html);
                }else{
                    alert(data.msg);
                }
            },
            error: function() {
                alert('news请求数据失败');
            }
        });
    }
});