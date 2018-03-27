$(function(){//加载事件*************************************************************
	$.post("homepage.do",null,function(data){
		alert(data);
	},"json");
})  //加载事件*************************************************************************
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
        data:['java基础','框架','新技术','java高级','工具']  
      
    },
           calculable : true,
    series : [
        {
            name:'北大青鸟',
            type:'pie',
            radius : '80%',
            center: ['50%', '60%'],
            data:[
                {value:335, name:'java基础'},
                {value:310, name:'框架'},
                {value:234, name:'新技术'},
                {value:135, name:'java高级'},
                {value:1548, name:'工具'}
            ]
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
                var myChart2 = ec.init(document.getElementById('main2')); 
        var option2 = {
				    title: {
				        text: '面试数据分析',
				        subtext: '数据来自北大青鸟'
				    },
    tooltip: {
        trigger: 'axis',
        axisPointer: {
            type: 'shadow'
        }
    },
    legend: {
        data: ['技术面试', '人事面试']
    },
    grid: {
        left: '3%',
        right: '4%',
        bottom: '3%',
        containLabel: true
    },
    xAxis: {
        type: 'value',
        boundaryGap: [0, 0.01]
    },
    yAxis: {
        type: 'category',
        data: ['巴西','印尼','美国','印度','中国','世界人口(万)']
    },
    series: [
        {
            name: '技术面试',
            type: 'bar',
            data: [18203, 23489, 29034, 104970, 131744, 630230]
        },
        {
            name: '人事面试',
            type: 'bar',
            data: [19325, 23438, 31000, 121594, 134141, 681807]
        }
    ]
};       
                // 为echarts对象加载数据 
                myChart2.setOption(option2); 
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