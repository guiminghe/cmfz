<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>

<script type="text/javascript">
    var toolbar = [{
        iconCls: 'icon-edit',
        text: "添加专辑",
        handler: function () {
            alert("添加专辑")
            $("#albumAdd").dialog("open")
        }
    }, '-', {
        iconCls: 'icon-help',
        text: "添加章节",
        handler: function () {
            var row = $("#chapter_tg").treegrid("getSelected");
            if (row == null) {
                alert("请先选中专辑")
            } else {
                if (row.score != null) {
                    $("#chapter_dd").dialog("open")
                    $("#p_id").val(row.id)
                } else {
                    alert("请先选中专辑")
                }
            }

        }
    }, '-', {
        text: "专辑详情",
        iconCls: 'icon-help',
        handler: function () {
            /*展示专辑相关的信息*/
            $('#album').dialog("open")
            /*把专辑信息填充到dialog*/
            var row = $("#chapter_tg").treegrid("getSelected");
            if (row == null) {
                alert("请先选中专辑")
            } else {
                if (row.score != null) {
                    $("#album_ff").form("load", row);
                    $("#album_img").prop("src", row.img)
                } else {
                    alert("请先选中专辑")
                }
            }
        }
    }, '-', {
        text: "下载音频",
        iconCls: 'icon-help',
        handler: function () {
            var row = $("#chapter_tg").treegrid("getSelected");
            if (row != null) {
                if (row.size != null) {
                    location.href = "${pageContext.request.contextPath}/chapter/download?url=" + row.url + "&title=" + row.title
                }
            }
        }
    }];
    $(function () {
        $("#chapter_tg").treegrid({
            onDblClickRow: function (row) {
                $("#audio").dialog("open")
                $("#audio_id").prop("src", "${pageContext.request.contextPath}/upload/" + row.url)
            },
            toolbar: toolbar,
            url: '${pageContext.request.contextPath}/selectAllAlbumAndAudio.do',
            idField: 'id',
            treeField: 'title',
            columns: [[
                {field: 'title', title: '名字', width: 60},
                {field: 'downPath', title: '路径', width: 60},
                {field: 'size', title: '大小', width: 80},
                {field: 'duration', title: '时长', width: 80}
            ]],
            fit: true,
            fitColumns: true
        })
        $('#album').dialog({
            title: '专辑详情',
            width: 400,
            height: 200,
            closed: true,
        });

        $('#audio').dialog({
            title: '播放',
            width: 400,
            height: 200,
            closed: true,
        });
        $('#chapter_dd').dialog({
            title: '添加章节',
            width: 400,
            height: 200,
            closed: true,
            buttons: [{
                text: '保存',
                handler: function () {

                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#chapter_dd").dialog("close")
                }
            }],
        });
        $('#albumAdd').dialog({
            title: '添加专辑',
            width: 400,
            height: 300,
            closed: true,
            buttons: [{
                text: '保存',
                handler: function () {
                    $('#album_dd').form('submit', {
                        url: "${pageContext.request.contextPath}/insertAlbum",
                        success: function (data) {
                            if (data == "true") {
                                $.messager.alert("提示框", "添加成功", "message");
                                $("#albumAdd").dialog("close");
                                $("#chapter_tg").treegrid("reload");
                            } else {
                                $.messager.alert("提示框", "添加失败", "warning");
                            }
                        }
                    });
                }
            }, {
                text: '关闭',
                handler: function () {
                    $("#albumAdd").dialog("close")
                }
            }],
        });
    })


    function addChapter() {
        $('#chapter_ff').form('submit', {
            url: "${pageContext.request.contextPath}/chapter/add"
        })
    }


</script>

<table id="chapter_tg"></table>

<div id="album">

    <form id="album_ff" method="post">
        <div>
            <input id="name" class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
        </div>
        <div>
            <input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
        </div>
        <div>
            <img src="" id="album_img">
        </div>
    </form>
</div>

<%--添加专辑--%>
<div id="albumAdd">

    <form id="album_dd" method="post">
        <div>
            标题:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            作者:<input class="easyui-validatebox" type="text" name="author" data-options="required:true"/>
        </div>
        <div>
            播音:<input class="easyui-validatebox" type="text" name="broadCast" data-options="required:true"/>
        </div>
        <div>
            简介:<input class="easyui-validatebox" type="text" name="brief" data-options="required:true"/>
        </div>
        <div>
            数量:<input class="easyui-validatebox" type="text" name="count" data-options="required:true"/>
        </div>
        <div>
            评分:<input class="easyui-validatebox" type="text" name="score" data-options="required:true"/>
        </div>
        <div>
            封面:<input type="file" name="coverImg" style="width:300px">
        </div>
    </form>
</div>

<div id="chapter_dd">

    <form id="chapter_ff" method="post" ENCTYPE="multipart/form-data">
        <div>
            标题:<input class="easyui-validatebox" type="text" name="title" data-options="required:true"/>
        </div>
        <div>
            请选择:<input type="file" name="chapter" style="width:300px">
        </div>
        <div>
            <input type="hidden" name="id" id="p_id" value="" style="width:300px">
        </div>
    </form>
</div>

<div id="audio">
    <audio id="audio_id" src="" autoplay="autoplay" controls="controls" loop="loop"></audio>
</div>
