<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="Css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script language="JavaScript" src="js/house.js"></script>
</head>
<body>

<!--展示数据-->
<table id="dg"></table>

<!--定义工具栏-->
<div id="ToolBar">
    <div style="height: 40px;">
        <a href="javascript:Add()" class="easyui-linkbutton"
           iconCls="icon-add" plain="true">添加</a>
        <a
                href="javascript:ModifyBySelect()" class="easyui-linkbutton"
                iconCls="icon-edit" plain="true">修改</a>
        <a
                href="javascript:DeleteMore()" class="easyui-linkbutton"
                iconCls="icon-remove" plain="true">删除选中项</a>
    </div>
    <!--搜索条件-->
    <div>
         区域:<select name=""></select>
         街道:<select name=""></select>
         类型:<select name=""></select>
         开始价格:<input type="text" name="startPrice" id="startAge"/>
         结束价格:<input type="text" name="endPrice" id="endAge"/>
        <a id="btn" href="javascript:searchUser();" class="easyui-linkbutton" data-options="iconCls:'icon-search'">搜索</a>

    </div>
</div>

</body>
</html>
