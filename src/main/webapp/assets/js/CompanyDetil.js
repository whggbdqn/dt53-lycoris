(function ($) {
    "use strict";
    var id=$("#companyid").val();
	
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
	
}(jQuery));
var flag=0;
function getDetil(){
	if(flag==0){
	var id=$("#companyid").val();
	var index;//图表的数据
	var indexname=[];
	$.post("CompanyIndexes.do",{"id":id},function(data){
		for(var i=1;i<data.length;i++){
			indexname.push(data.name);
		}
		index=data;
	},"json");
	//图表1展示公司的面试统计 *********************************************************************************
		require(
		            [
		                'echarts',
		                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
		            ],
		            function (ec) {
		                // 基于准备好的dom，初始化echarts图表
		                var myChart = ec.init(document.getElementById('companyDetilCharts')); 
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
		            name:'关注点',
		            type:'pie',
		            radius : '80%',
		            center: ['50%', '60%'],
		            data:index
		        }
		    ]
		};
		                // 为echarts对象加载数据 
		                myChart.setOption(option); 
		            }
		        );
		//flag=1;	    
	}
}
	