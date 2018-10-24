<%@page isELIgnored="false" pageEncoding="UTF-8" contentType="text/html; UTF-8" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>持名法州后台管理中心</title>

    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

    <link rel="icon" href="img/favicon.ico" type="image/x-icon"/>
    <link rel="stylesheet" href="css/common.css" type="text/css"></link>
    <link rel="stylesheet" href="css/login.css" type="text/css"></link>
    <script type="text/javascript" src="script/jquery.js"></script>
    <script type="text/javascript" src="script/common.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
    <!-- 需要引入两个css文件：图标样式文件，easyUI样式文件 -->
    <link rel="stylesheet" type="text/css" href="themes/icon.css">
    <link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
    <script type="text/javascript">

        function fx() {
            $("#captchaImage").prop("src", "/app/kaptcha?t=" + new Date().getTime())
        }

        $(function () {
            $("#username").validatebox({
                required: true,
                missingMessage: "用户名不能为空",
                validType: "length[3,16]",
                invalidMessage: "用户名必须为4-16位"
            });

            $("#password").validatebox({
                required: true,
                missingMessage: "密码不能为空",
                validType: "length[1,6]",
                invalidMessage: "密码必须为4-6位"
            });
            $("#enCode").validatebox({
                required: true,
                missingMessage: "验证码不能为空",
                validType: "length[1,4]",
                invalidMessage: "密码必须为1-4位"
            });

            $("#loginForm").submit(function () {
                return $("#loginForm").form("validate")
            })
        });


    </script>
</head>
<body>
<div class="login">
    <form id="loginForm" action="/app/login" method="post">

        <table>
            <tbody>
            <tr>
                <td width="190" rowspan="2" align="center" valign="bottom">
                    <img src="img/header_logo.gif"/>
                </td>
                <th>
                    用户名:
                </th>
                <td>
                    <input type="text" id="username" name="username" class="text" value="" maxlength="20"/>
                </td>
            </tr>
            <tr>
                <th>
                    密&nbsp;&nbsp;&nbsp;码:
                </th>
                <td>
                    <input type="password" id="password" name="password" class="text" value="" maxlength="20"
                           autocomplete="off"/>
                </td>
            </tr>

            <tr>
                <td>&nbsp;</td>
                <th>验证码:</th>
                <td>
                    <input type="text" id="enCode" name="kaptcha" class="text captcha" maxlength="4"
                           autocomplete="off"/>
                    <img id="captchaImage" onclick="fx()" class="captchaImage" src="/app/kaptcha" title="点击更换验证码"/>
                    <div id="info">${param.info}</div>
                </td>
            </tr>
            <tr>
                <td>
                    &nbsp;
                </td>
                <th>
                    &nbsp;
                </th>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <th>&nbsp;</th>
                <td>
                    <input type="button" class="homeButton" name="kaptcha" onclick="location.href='/'"><input
                        class="loginButton" type="submit" value="登录">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="powered">COPYRIGHT © 2008-2017.</div>
        <div class="link">
            <a href="http://www.chimingfowang.com/">持名佛网首页</a> |
            <a href="http://www.chimingbbs.com/">交流论坛</a> |
            <a href="">关于我们</a> |
            <a href="">联系我们</a> |
            <a href="">授权查询</a>
        </div>
    </form>
</div>
</body>
</html>