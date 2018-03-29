$(function(){//加载事件*************************************************************
	var location=[];//图表1的地区列
	var atc=[];//图表1的统计
	var skillname=[];//图表2的技术名列
	var skill=[];//图表2 的数据
	var backgroundname=[];//图表3的项目列
	var background=[];//图表3 的数据
	$.post("homepage.do",null,function(data){
		for(var i=0;i<data.atc.length;i++){
			location.push(data.atc[i].name);
		}
		for(var i=0;i<data.skill.length;i++){
			skillname.push(data.skill[i].name);
			skill.push(data.skill[i].value);
		}
		atc=data.atc;
	},"json");
//图表1展示地区统计 *********************************************************************************
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
//图表2展示技术统计 ****************************************************************************
   			require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart3 = ec.init(document.getElementById('main1')); 
var option = {
		   title: {
		        text: '关注点:技术',
		        subtext: '数据来自青鸟'
		    },
		    tooltip: {
		        trigger: 'axis',
		        axisPointer: {
		            type: 'shadow'
		        }
		    },
//		    legend: {
//		        data: skillname
//		    },
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
		        data: skillname
		    },
		    series: [
		        {
		            name: '记录次数',
		            type: 'bar',
		            data: skill
		        }
		    ]
};
  		myChart3.setOption(option); 
            }
        );
  //图表3展示技术统计 *************************************************************************
  			require(
            [
                'echarts',
                'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
            ],
function (ec) {
    // 基于准备好的dom，初始化echarts图表
    var myChart4 = ec.init(document.getElementById('main2')); 
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