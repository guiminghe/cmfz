<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>

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
            var row = $("#dg").edatagrid("getSelected")
            if (row == null) {
                $.messager.show({
                    title: '警告',
                    msg: '请选中删除行。',
                    showType: 'show',
                    style: {
                        right: '',
                        top: document.body.scrollTop + document.documentElement.scrollTop,
                        bottom: ''
                    }
                });
            } else {
                $.messager.confirm('确认', '您确认想要删除记录吗？', function (r) {
                    if (r) {
                        alert('确认删除');
                        $.ajax({
                            url: "${pageContext.request.contextPath}/deleteById.do",
                            data: "id=" + row.id,
                            //traditional:true,
                            success: function (data) {
                                if (data) {
                                    alert("删除成功");
                                    $('#dg').edatagrid("reload");
                                } else {
                                    alert("删除失败");
                                    $('#dg').edatagrid("reload");
                                }
                            }
                        })
                    }
                });
            }


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
            var row = $("#dg").edatagrid("getSelected")
            if (row == null) {
                $.messager.show({
                    title: '警告',
                    msg: '请选中保存信息。',
                    showType: 'show',
                    style: {
                        right: '',
                        top: document.body.scrollTop + document.documentElement.scrollTop,
                        bottom: ''
                    }
                });
            } else {
                $.messager.confirm('确认', '您确认想要保存记录吗？', function (r) {
                    if (r) {
                        alert('确认保存');
                        $.ajax({
                            url: "${pageContext.request.contextPath}/updateStatus.do",
                            data: "id=" + row.id + "status=" + row.status,
                            //traditional:true,
                            success: function (data) {
                                if (data) {
                                    alert("保存信息成功");
                                    $('#dg').edatagrid("reload");
                                } else {
                                    alert("保存信息失败");
                                    $('#dg').edatagrid("reload");
                                }
                            }
                        })
                    }
                });
            }

        }
    }];

    /*构建数据表格*/
    $(function () {
        $('#dg').edatagrid({
            updateUrl: "${pageContext.request.contextPath}/banner/update",
            toolbar: toolbar,
            url: '${pageContext.request.contextPath}/selectAllBanner.do',
            method: "get",
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
            //pageSize: 3,
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
<table id="dg"></table>