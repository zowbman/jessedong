var name = 'somoveLanguage';
function chgLang() {
    var value = $('#langSelect').children('option:selected').val();
    SetCookie(name, value);
    location.reload();
}
function SetCookie(name, value) {
    var Days = 30; //此 cookie 将被保存 30 天
    var exp = new Date(); //new Date("December 31, 9998");
    exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
    document.cookie = name + '=' + escape(value) + ';expires=' + exp.toGMTString();
}
function getCookie(name) //取cookies函数
{
    var arr = document.cookie.match(new RegExp('(^| )' + name + '=([^;]*)(;|$)'));
    if (arr != null) return unescape(arr[2]);
    return null
}
function setLang(language){
    $('[data-localize]').localize('text', {
        pathPrefix: '/lang',
        language: language
    });
}
$(function() {
    var uulanguage = (navigator.language || navigator.browserLanguage).toLowerCase();
    var tmp;
    if(uulanguage.indexOf('zh') > -1){
        setLang('zh');
        tmp='zh';
    }else{
        setLang('en');
        tmp='en';
    }
    if (getCookie(name) != '') {
        if (getCookie(name) == 'zh') {
            setLang(getCookie(name));
            tmp='zh';
        }
        if (getCookie(name) == 'en') {
            setLang(getCookie(name));
            tmp='en';
        }
    }
    $("#langSelect").find("option[value='"+tmp+"']").attr("selected",true);
});