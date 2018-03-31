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
		    legend: {
		    	  orient : 'vertical',
			        x : 'right',
		        data: skillname
		    },
		    grid: {
		        left: '1%',
		        right: '8%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis: {
		        type: 'value',
		        boundaryGap: [0, 0.01]
		    },
		    yAxis: {
		        type: 'category',
		        data: skillname,
		        textStyle: {
		            fontSize: 30 // 用 legend.textStyle.fontSize 更改示例大小
		         }
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
			        boundaryGap: [0, 0.01]
			    },
			    yAxis: {
			        type: 'category',
			        data: backgroundname
			    },
			    series: [
			        {
			            name: '记录次数',
			            type: 'bar',
			            itemStyle:{
			                normal:{
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
	        textStyle:{
				        		fontSize: 24,
				               fontWeight: 'bolder',
				               color: '#333'},
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
	            label : {normal : 
	            					{
					    	    	textStyle : {
					    	    			fontSize: 24,
							               fontWeight: 'bolder',
					    	    	}
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
