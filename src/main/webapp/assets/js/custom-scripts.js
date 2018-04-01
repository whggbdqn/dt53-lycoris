(function ($) {
	var location=[];//图表1的地区列
	var atc=[];//图表1的统计
	var skillname=[];//图表2的技术名列
	var skill=[];//图表2 的数据
	var backgroundname=[];//图表3的项目列
	var background=[];//图表3 的数据
	$.post("json/homepage.json",null,function(data){
		for(var i=0;i<data.atc.length;i++){
			location.push(data.atc[i].name);
		}
		for(var i=0;i<data.skill.length;i++){
			skillname.push(data.skill[i].name);
		}
		skill=data.skill;
		for(var i=0;i<data.background.length;i++){
			backgroundname.push(data.background[i].name);
		}
		background=data.background;
		atc=data.atc;
		$(".companycount").text(data.count2);
		$(".datacount").text(data.count1);
	},"json");
    "use strict";
    
    var mainApp = {
        initFunction: function () {
            /*MENU 
            ------------------------------------*/
            $('#main-menu').metisMenu();
            $(window).bind("load resize", function () {
                if ($(this).width() < 768) {
                    $('div.sidebar-collapse').addClass('collapse')
                } else {
                    $('div.sidebar-collapse').removeClass('collapse')
                }
            });
          
        },

        initialization: function () {
            mainApp.initFunction();
        }
    }
    // Initializing ///
    $(document).ready(function () {
        mainApp.initFunction(); 
		$("#sideNav").click(function(){
			if($(this).hasClass('closed')){
				$('.navbar-side').animate({left: '0px'});
				$(this).removeClass('closed');
				$('#page-wrapper').animate({'margin-left' : '260px'});
				
			}
			else{
			    $(this).addClass('closed');
				$('.navbar-side').animate({left: '-260px'});
				$('#page-wrapper').animate({'margin-left' : '0px'}); 
			}
		});
    });

    require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart3 = ec.init(document.getElementById('Skillchart')); 
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
		    grid: {
		        left: '1%',
		        right: '8%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'value',
		        boundaryGap: [0, 0.01],
		        axisLabel:{ //调整x轴的lable  
		            textStyle:{
		                fontSize:15 // 让字体变大
		            }
		        }
		    },
		    yAxis: {
		        type: 'category',
		        data: skillname,
		        axisLabel:{ //调整x轴的lable  
		            textStyle:{
		                fontSize:15 // 让字体变大
		            }
		        }
		    },
		    series: [
		        {
		            name: '记录次数',
		            color:'#337AB7',
		            type: 'bar',
		            data: skill
		        }
		    ]
};
  		myChart3.setOption(option); 
            }
        );
	require(
	            [
	                'echarts',
	                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
	            ],
	            function (ec) {
	                // 基于准备好的dom，初始化echarts图表
	                var myChart3 = ec.init(document.getElementById('Backgroundchart')); 
	var option = {
			   title: {
			        text: '关注点:面试',
			        subtext: '数据来自青鸟'
			    },
			    tooltip: {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'shadow'
			        }
			    },
			    grid: {
			        left: '1%',
			        right: '8%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis: {
			        type: 'value',
			        boundaryGap: [0, 0.01],
			        axisLabel:{ //调整x轴的lable  
			            textStyle:{
			                fontSize:15 // 让字体变大
			            }
			        }
			    },
			    yAxis: {
			        type: 'category',
			        data: backgroundname,
			        axisLabel:{ //调整x轴的lable  
			            textStyle:{
			                fontSize:15 // 让字体变大
			            }
			        }
			    },
			    series: [
			        {
			            name: '记录次数',
			            type: 'bar',
			            itemStyle:{
			                normal:{
			                	color:'#337AB7',
			                    lable:{
			                    show:true,
			                    formatter:'{a}%'
			                    }
			                }
			            },
			            data: background
			        }
			    ]
	};
	  		myChart3.setOption(option); 
	            }
	        );
	//图表1展示地区统计 *********************************************************************************
	require(
	            [
	                'echarts',
	                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
	            ],
	            function (ec) {
	                // 基于准备好的dom，初始化echarts图表
	                var myChart = ec.init(document.getElementById('companyCount')); 
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
	        data:location,
	        textStyle:{
	        	 fontSize:20 // 让字体变大
            },
	    },
	           calculable : true,
	    series : [
	        {
	            name:'北大青鸟',
	            type:'pie',
	            radius : '75%',
	            center: ['50%', '60%'],
	            label:{            //饼图图形上的文本标签
                    normal:{
                        show:true,
                        position:'inner', //标签的位置
                        textStyle : {
                            fontWeight : 300 ,
                            fontSize : 20   //文字的字体大小
                        },
                        formatter:'{d}%'
                    }
                },
	            data:atc
	        }
	    ]
	};
	                // 为echarts对象加载数据 
	                myChart.setOption(option); 
	            }
	        );
    
}(jQuery));
