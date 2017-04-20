<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<header>
    <div class="function-box">
        <div class="container">
            <div class="language-box">
                Language :
                <select id="langSelect" name="langSelect" onchange="chgLang();">
                        <option value="zh">简体中文</option>
                        <option value="en">English</option>
                </select>
            </div>
        </div>
    </div>
    <div class="container header-box">
        <div class="header-box-r">
            <nav class="header-nav">
                <ul class="header-ul">
                    <li class="header-ul-li primary-b header-ul-li-active">
                        <a href="/">
                            <i class="fa fa-home header-ul-li-ico"></i><span data-localize="nav.home">Home</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                    <li class="header-ul-li primary-b">
                        <a href="/nav/aboutUs">
                            <i class="fa fa-user header-ul-li-ico"></i><span data-localize="nav.aboutUs">About Us</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                    <li class="header-ul-li primary-b">
                        <a href="#">
                            <i class="fa fa-product-hunt header-ul-li-ico"></i><span data-localize="nav.proCenter">Pro Center</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                    <li class="header-ul-li primary-b">
                        <a href="/news">
                            <i class="fa fa-newspaper-o header-ul-li-ico"></i><span data-localize="nav.news">News</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                    <li class="header-ul-li primary-b">
                        <a href="/nav/techSupport">
                            <i class="fa fa-rocket header-ul-li-ico"></i><span data-localize="nav.techSupport">Tech Support</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                    <li class="header-ul-li primary-b">
                        <a href="#">
                            <i class="fa fa-thumbs-o-up header-ul-li-ico"></i><span data-localize="nav.successCase">Success Case</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                    <li class="header-ul-li primary-b">
                        <a href="/nav/contactUs">
                            <i class="fa fa-phone header-ul-li-ico"></i><span data-localize="nav.contactUs">Contact Us</span>
                            <span class="header-ul-li-ico-dropdown"><i class="fa fa-arrow-circle-down"></i></span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header><!--导航结束-->
<div class="inner-page-header inner-page-header-bg">
    <div class="inner-page-header-content">
        <div class="container">
            <h1 class="f-primary-l c-default">GoldrayTech</h1>
        </div>
    </div>
</div><!--logo区域结束-->