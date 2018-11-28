<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/28 0028
  Time: 下午 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/datagrid-detailview.js"></script>
    <script type="text/javascript">
        var toolbar = [{
            iconCls: 'icon-edit',
            text: "添加",
            handler: function () {
                alert('编辑按钮')
            }
        }, '-', {
            iconCls: 'icon-help',
            text: "删除",
            handler: function () {
                alert('帮助按钮')
            }
        }, '-', {
            text: "修改",
            iconCls: 'icon-help',
            handler: function () {
                /*获取选中行*/
                var row = $("#dg").edatagrid("getSelected")
                if (row == null) {
                    $.messager.show({
                        title: '警告',
                        msg: '请选中修改行。',
                        showType: 'show',
                        style: {
                            right: '',
                            top: document.body.scrollTop + document.documentElement.scrollTop,
                            bottom: ''
                        }
                    });
                } else {
                    /*将当前行变成可编辑模式*/
                    var index = $("#dg").edatagrid("getRowIndex", row);
                    $("#dg").edatagrid("editRow", index);
                }

            }
        }, '-', {
            text: "保存",
            iconCls: 'icon-help',
            handler: function () {
                $("#dg").edatagrid("saveRow");
            }
        }];

        /*构建数据表格*/
        $(function () {
            $('#dg').edatagrid({
                updateUrl: "",
                toolbar: toolbar,
                url: "selectAllBanner.do",
                //method: "get",
                columns: [[
                    {field: 'title', title: '名字', width: 100},
                    {
                        field: 'status', title: '状态', width: 100, editor: {
                            type: "text",
                            options: {
                                required: true
                            }
                        }
                    },
                    {field: 'desc', title: '描述', width: 100, align: 'right'}
                ]],
                fit: true,
                fitColumns: true,
                pagination: true,
                // pageSize: 3,
                //pageList: [3, 6, 9],
                view: detailview,
                detailFormatter: function (rowIndex, rowData) {
                    return '<table><tr>' +
                        '<td rowspan=2 style="border:0"><img src="' + rowData.imagePath + '" style="height:50px;"></td>' +
                        '<td style="border:0">' +
                        '<p>时间: ' + rowData.date + '</p>' +
                        '<p>:描述:' + rowData.desc + '</p>' +
                        '</td>' +
                        '</tr></table>';
                }

            });

        })

    </script>
</head>
<body>
<table id="dg"></table>
</body>
</html>
