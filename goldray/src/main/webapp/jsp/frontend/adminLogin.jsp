<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>GoldrayTech Trade Co|admin</title>
		<link rel="shortcut icon" href="favicon.ico">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
        <link rel="stylesheet" type="text/css" href="/bootstrap3/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="/css/common.css">
        <script src="/js/jquery/jquery-1.11.1.min.js"></script>
        <script src="/js/jquery.validate.min.js"></script>
        <script src="/js/frontend.js"></script>
	<body>
	    <div class="container" style="margin-top:50px;">
	        <h3 class="page-header">GoldrayTech Trade Co | Admin</h3>
            <form id="admin-login" class="form-horizontal" style="padding-top:30px;">
                <div class="form-group">
                    <label for="username" class="col-sm-3 control-label">用户名</label>
                    <div class="col-sm-6">
                      <input type="text" id="username" name="username" class="form-control" placeholder="USERNAME">
                    </div>
                </div>
                <div class="form-group">
                    <label for="pwd" class="col-sm-3 control-label">密码</label>
                    <div class="col-sm-6">
                      <input type="password" id="pwd" name="pwd" class="form-control" placeholder="PASSWORD">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-6">
                        <button class="form-control" type="submit">SUBMIT</button>
                    </div>
                </div>
            </form>
        <div>
	</body>
</html>