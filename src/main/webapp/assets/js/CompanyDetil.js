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
  //定义一个全局的图表对象
    var myChart;
    var name=[];
    var arr=[];
	require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
              function(ec){
            myChart = ec.init(document.getElementById('companyDetilCharts'));
            $.post("CompanyIndexes.do", {"id":id}, function(data) {
              	 for(var i=0;i<data.length;i++){
              		 name.push(data[i].name);
                        arr.push({
                          name : data[i].name,
                          value : data[i].value
                       }); 
                     };
                     myChart.hideLoading();    //隐藏加载动画
                     myChart.setOption({        //加载数据图表
                    	 title : { 
               		        text: '来源北大青鸟光谷校区',
               		        subtext: '真实有效数据分析',
               		        x:'center'
               		    },
                  	   legend: {
             		        orient : 'vertical',
             		        x : 'left',
             		        data:name,
             		       textStyle:{
             		        	 fontSize:20 // 让字体变大
             	            }
             		    },
             		   tooltip : {
             		        trigger: 'item',
             		        formatter: "{a} <br/>{b} : {c} ({d}%)"
             		    }, 
             		 series : [
             		        {
             		            name:'关注点',
             		            type:'pie',
             		            radius : '80%',
             		            center: ['50%', '60%'],
             		           textStyle : {
                                   fontWeight : 300 ,
                                   fontSize : 20   //文字的字体大小
                               },
             		            data:arr
             		        }
             		    ]
                     });
              },"json");
    });
}(jQuery));
	