$(function(){//加载事件*************************************************************
	var location=[];
	var atc=[];
	$.post("homepage.do",null,function(data){
		for(var i=0;i<data.length;i++){
			location.push(data[i].name);
		}
		atc=data;
	},"json");
require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
        var option = {
    title : { 
        text: '来源北大青鸟光谷校区',
        subtext: '真实有效数据分析',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    }, 
    legend: {
        orient : 'vertical',
        x : 'left',
        data:location
    },
           calculable : true,
    series : [
        {
            name:'北大青鸟',
            type:'pie',
            radius : '80%',
            center: ['50%', '60%'],
            data:atc
        }
    ]
};
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            }
        );
   			require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart3 = ec.init(document.getElementById('main3')); 
var option = {
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [120, 200, 150, 80, 70, 110, 130],
        type: 'bar'
    }]
};
  		myChart3.setOption(option); 
            }
        );
  			require(
            [
                'echarts',
                'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart4 = ec.init(document.getElementById('main4')); 
var option = {
    xAxis: {
        type: 'category',
        data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    },
    yAxis: {
        type: 'value'
    },
    series: [{
        data: [820, 932, 901, 934, 1290, 1330, 1320],
        type: 'line'
    }]
};
	myChart4.setOption(option); 
            }
        );
})  //加载事件*************************************************************************