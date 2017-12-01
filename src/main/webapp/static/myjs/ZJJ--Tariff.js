/**
 * Created by Administrator on 2016/12/30.
 */
//点击包月添加弹出包月添加窗口
$(function(){
    $("#monthly").click(function(){
        $('#MonthlyWin').window('open');
    });
});





//包月添加Form提交
$(function(){
    $("#addBtntan").click(function(){

    	$('#addMonthly').form('submit',{	
            url:"tariff/addMonthly",
            success:function(data){
            	var row=parseInt(data);
            	if(row==1){
            		$('#addMonthly').form('clear');
                    $("#MonthlyWin").window("close");
                    $("#tariff").datagrid('load',{});
            	}else{
            		alert("添加失败");
            	}
            }
    	});
    });
});

//计时添加Form提交
$(function(){
    $("#addBtntan1").click(function(){
    	$('#addOnTime').form('submit',{
            url:"tariff/addOnTime",
            success:function(data){
            	var row=parseInt(data);
            	if(row==1){
            		$('#addOnTime').form('clear');
                    $("#OnTimeWin").window("close");
                    $("#tariff").datagrid('load',{});
            	}else{
            		alert("添加失败");
            	}
            }
    	});
    });
});

//套餐添加Form提交
$(function(){
    $("#addBtntan2").click(function(){
    	$('#addSetMeal').form('submit',{
            url:"tariff/addSetMeal",
            success:function(data){
            	var row=parseInt(data);
            	if(row==1){
            		$('#addSetMeal').form('clear');
                    $("#setmealWin").window("close");
                    $("#tariff").datagrid('load',{});
            	}else{
            		alert("添加失败");
            	}
            }
    	});
    });
});


//包月小窗口取消
$(function(){
    $("#cancel").click(function(){
        $('#MonthlyWin').window('close');
        $('#MonthlyWin').form('clear');
    });
});


$(function(){
    $("#ontime").click(function(){
        $('#OnTimeWin').window('open');
    });
});
$(function(){
    $("#cancel1").click(function(){
        $('#OnTimeWin').window('close');
        $('#OnTimeWin').form('clear');
    });
});


$(function(){
    $("#setmeal").click(function(){
        $('#setmealWin').window('open');
    });
});
$(function(){
    $("#cancel2").click(function(){
        $('#setmealWin').window('close');
        $('#setmealWin').form('clear');
    });
});


$(function(){
    $("#updatebtn").click(function(){
        $('#updateWin').window('open');
    });
});
$(function(){
    $("#cancel3").click(function(){
        $('#updateWin').window('close');
        $('#updateWin').form('clear');
    });
});


$(function(){
	var row="";
    $("#tariff").datagrid({
        onClickRow:function(){
            row=$("#tariff").datagrid("getSelected");
        }
    });
    
    /*修改方法*/
    $("#updatebtn").on("click",function(){
    	if(row==null||row==""){
    		alert("请选择需要修改的数据");
    	}else{
    		
    		var json = $.toJSON(row);
    		
    		$.ajax({
    			type:"post",
    			url:"tariff/findById",
    			data:json,
    			contentType:"application/json",
    			success:function(tariff){
    				$("#tariffId ").val(tariff.id);
    				$("#tarName").textbox("setValue",tariff.tariffName);

    				$("#unitFee").numberbox("setValue",tariff.basicMoney);
    				
    				$("#unitTimeID").numberbox("setValue",tariff.basicTime);
    				$("#basFee").numberbox("setValue",tariff.unitMoney);

    				$("#desc").textbox("setValue",tariff.describe);
    				$("#updateWin").window("open");
    			
    			}
    		});
    		
    	}
 
    });
   
   /* 删除方法*/
    $("#delbtn").on("click",function(){
    	if(row==null||row==""){
    		alert("请选择需要删除的数据");
    	}else{
    		var id =row.id ;
    
    		if(confirm("请确认是否删除")){
    			$.ajax({
        			type:"post",
        			url:"tariff/delete",
        			data:{id:id},
        			success:function(data){
        				if(data == "gg"){
        					alert("资费没有被暂停，不能删除");
        				}else{
        					alert("删除成功");
        				}
        				
        			$("#tariff").datagrid('load',{});
        						
        			}
        		});
    		}
    		
    	}
    });
    
  //资费开通
    	$("#dredgebtn").on("click",function(){
    		if(row==null||row==""){
        		alert("请选择数据");
    		}else{	
    			var id =row.id ;
    			if(confirm("请确认是否开通资费")){
        			$.ajax({
            			type:"post",
            			url:"tariff/dredge",
            			data:{id:id},
            			success:function(data){
            				alert("开通成功");
            			$("#tariff").datagrid('load',{});
            						
            			}
            		});
        		}
        		
    		}
    		
    	});

    	//资费暂停
    	$("#stopbtn").on("click",function(){
    		if(row==null||row==""){
        		alert("请选择数据");
    		}else{	
    			var id =row.id ;
    			if(confirm("请确认是否暂停资费")){
        			$.ajax({
            			type:"post",
            			url:"tariff/suspend",
            			data:{id:id},
            			success:function(data){
            				if(data=="exit"){
            					alert("资费正在被使用，不能暂停");
            				}else{
            					alert("暂停成功");
                    			$("#tariff").datagrid('load',{});
                    						
            				}
            				
            				
            		
            			}
            		});
        		}
        		
    		}
    		
    	});
    		
 

    
});

/*from表单提交修改*/
function updataTariff(){
	 $('#updateTariff').form('submit',{
	    	
	        url:"tariff/update",
	        success:function(data){
	        	if(data==1){
	                alert("修改成功");
	                $('#updateTariff').form('clear');
	                $("#updateWin").window("close");
	                $("#tariff").datagrid('load',{});
	                row="";
	        	}else{
	        		alert("资费没有被暂停，不允许修改");
	        	}
	        }
	    });
}



/*模糊查询*/
$(function(){
	$("#selectBtn").on("click",function(){

		var  type = $("#TypeId").val();
		
		var  state = $("#StateId").val();
		
		if(type==null||type==""){
			type=0;
		}
		if(type  == "包月"){
			type=1;
		}
		if(type  == "计时"){
			type=2;
		}
		if(type  == "套餐"){
			type=3;
		}
		
		if(state==null||state==""){
			state=0;
		}
		
		if(state  == "暂停"){
			state=1;
		}
		if(state  == "开通"){
			state=2;
		}
		$("#tariff").datagrid('load',{
			tariffName:$("#NameId").val(),		
			tariffType:type,
			tariffState:state
		});
	});
});



