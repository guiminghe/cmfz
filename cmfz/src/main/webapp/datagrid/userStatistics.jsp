<%@page pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; utf-8" %>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    $(function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/selectCountUser",
            //dataType:JSON,
            success: function (data) {
                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));

                // 指定图表的配置项和数据
                var option = {
                    title: {
                        text: '用户注册数量统计分析'
                    },
                    //提示框
                    tooltip: {},
                    //选项卡
                    legend: {
                        data: ['销量']
                    },
                    //x轴y轴
                    xAxis: {
                        data: ["第一周", "第二周", "第三周"]
                    },
                    yAxis: {},
                    //归选项卡管理的系列
                    series: [{
                        name: '用户注册数量',
                        type: 'bar',
                        data: data,
                    }]
                };
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
    })

</script>
<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;">
</div>
