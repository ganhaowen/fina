<%@page contentType="text/html;UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    $(function () {
        $('#test').edatagrid({
            updateUrl:"${pageContext.request.contextPath}/banner/update",
            url: '${pageContext.request.contextPath}/banner/selectAll',
            columns: [[
                {field: 'name', title: '名称', width: 100},
/*
                {field: 'id', hidden:true, title: '编号', width: 100},
*/
                {
                    field: 'status', title: '状态', width: 100, editor: {
                        type: "text",
                        options: {
                            required: true
                        }
                    }
                },

            ]],

            fit: true,
            fitColumns: true,
            pagination: true,
            pageSize: 5,
            pageList: [5, 10, 15],
            toolbar: [{
                iconCls: 'icon-add',
                text: "添加",
                handler: function () {
                    $("#add").dialog("open")
                }
            }, '-', {
                iconCls: 'icon-edit',
                text: "修改",
                handler: function () {
                    var row = $("#test").edatagrid("getSelected")
                    if (row == null) {
                        alert("没有选中任何行")
                    }else {
                        var index = $("#test").edatagrid("getRowIndex", row);
                        $("#test").edatagrid("editRow", index);
                    }

                }
            }, '-', {
                iconCls: 'icon-remove',
                text: "删除",
                handler: function () {
                    MultiDelete()
                }
            }, '-', {
                iconCls: 'icon-save',
                text: "保存",
                handler: function () {
                    $("#test").edatagrid("saveRow")
                    $("#test").edatagrid("load")

                }
            }],
            view: detailview,
            detailFormatter: function (rowIndex, rowData) {
                console.log(rowData.url.substring(rowData.url.indexOf("_")+1))
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.url + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.des + '</p>' +
                    '<p>createdate: ' + rowData.createdate + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },


        });

        $("#add").dialog({
            title: "添加",
            width: 230,
            height: 210,
            resizable: true,
            closed: true,
            buttons: "#btn"
        })
        $("#btn").linkbutton({})


    })
    
    function doadd() {
        $("#addform").form("submit", {
                url:"${pageContext.request.contextPath}/banner/add",
                success: function (data) {
                    var obj = JSON.parse(data);
                    if (obj) {
                        $("#add").dialog("close");
                        $("#test").edatagrid("load");
                    } else {
                        alert("添加失败")
                    }
                }
            }
        )
    }

    function MultiDelete() {
        var dearr = $("#test").edatagrid("getSelections")
        if (dearr.length != 0) {
            $.messager.confirm("删除确定", "确定要删除吗？？？", function (r) {
                if (r) {
                    var allid = new Array(dearr.length)
                    for (var i = 0; i < allid.length; i++) {
                        allid[i] = dearr[i].id;
                    }
                    $.ajax({
                        url: "${pageContext.request.contextPath}/banner/multiDelete",
                        data: "ids=" + allid,
                        type: "post",
                        dataType: "json",
                        success: function (data) {
                            if (data) {
                                $.messager.show({
                                    showType: "fade",
                                    showSpeed: 5000,
                                    title: "删除提示",
                                    msg: "删除成功"
                                });
                            } else {
                                $.messager.show({
                                    title: "删除提示",
                                    msg: "删除失败"
                                });
                            }

                            $("#test").edatagrid("load");

                        }
                    })
                }
            })
        } else {
            $.messager.alert("删除提示", "没有选中任何内容", "warning")
        }
    }

</script>

<div id="add">
    <form method="post" id="addform" enctype="multipart/form-data">
        名字：<input name="name" ><br>
        描述：<input name="des" id="upage"><br>
        图片：<input type="file" name="file">
    </form>
</div>
<table id="test"></table>

<a id="btn"  onclick="doadd()">立即添加</a>
