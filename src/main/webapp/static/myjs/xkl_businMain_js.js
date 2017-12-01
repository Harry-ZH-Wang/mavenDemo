
/**
 * Created by zhihe on 2016/12/29.
 */

/*新增按钮按键*/
$(function(){
    $("#addBusin").on("click",function(){
        $("#winAdd").window("open");
        $.ajax({
        	type:"post",
        	url:"business/findTariffName",
        	success:function(data){
        		$("#tariffName").empty();
        		for (var i = 0; i < data.rows.length; i++) {
					$("#tariffName").append(
					"<option valut="+data.rows[i].id+">"+data.rows[i].tariffName+"</option>");
				}
        		/*加载完成后*/
        		$.ajax({
        			type:"post",
        			url:"business/findType",
        			data:{"id":$("#tariffName").val()},
        			success:function(data){
        				if(data.tariffType=="1"){
        					$("#tariffType").html("包月");
        				}else if(data.tariffType=="2"){
        					$("#tariffType").html("计时");
        				}else if(data.tariffType=="3"){
        					$("#tariffType").html("套餐");
        				}
        				
        			}
        		});
        		
        		
        	}
	
        });

    });
});

//资费名称下拉光变动，影响资费类型框
$(function(){
	$("#tariffName").on("change",function(){
		$.ajax({
			type:"post",
			url:"business/findType",
			
			data:{"id":$("#tariffName").val()},
			success:function(data){
				if(data.tariffType=="1"){
					$("#tariffType").html("包月");
				}else if(data.tariffType=="2"){
					$("#tariffType").html("计时");
				}else if(data.tariffType=="3"){
					$("#tariffType").html("套餐");
				}
				
			}
		});
	});
});


function getCreditNum(credit){
	if(credit!=null){
		return credit.creditNum;
	}
	
}

function getbusinessState(businessState){
	if (businessState =="1"){
		return "正在使用";
	}else{
		return "已经暂停";
	}
		
}




function returnMain(){
	$('#winFind').window('close');	
}




/*from表单提交新增*/
function submitAddForm(){

    $('#businFormAdd').form('submit',{
        url:"business/add",
        success:function(data){
        	var row=parseInt(data);
        	if(row=="1"){
        		alert("添加成功");
        		$('#businessFromAdd').form('clear');
                $("#winAdd").window("close");
                $("#business").datagrid('load',{});
        	}else if(row=="3"){
        		alert("业务账号已存在");
        	}else if(row=="4"){
        		alert("账务账号不存在");
        	}
        }
    });
}
function clearAddForm(){
    $('#creditFromAdd').form('clear');
}


/*模糊查询*/
$(function(){
	$("#findBtn").on("click",function(){
		$("#business").datagrid('load',{
			businessNum:$("#findByNum").val(),
		});
	});
});



$(function(){
	var row="";
	//点击选中
    $("#business").datagrid({
        onClickRow:function(){
            row=$("#business").datagrid("getSelected");
           
        }
    });
    /*查询账务详情*/
    $("#findBusin").on("click",function(){

    	if(row==null||row==""){
    		alert("请选择需要查询的数据");
    	}else{
    		var sid = row.id;
    		$.ajax({
    			type:"post",
    			url:"business/findById",
    			data:{id:sid},
    			success:function(business){
    				if(business != null && business !=""){
    					$("#findCreditNum").html(business.credit.creditNum);
        				$("#findServerIp").html(business.serverIp);
        				$("#findTariffName").html(business.tariff.tariffName);
        				$("#findTariffType").html(business.tariff.tariffType);
        				$("#findBusinessNum").html(business.businessNum);
        				$("#findBusinessPwd").html(business.businessPwd);
        				$("#winFind").window("open");
        				
    				}else{
    					alert("账务账号停用,无法查看");
    				}
    				row="";
    				
    			}
    		});
    		
    	}
 
    });
    
    
    /*修改业务状态*/
    $("#changeStateBusin").on("click",function(){
    	if(row==null||row==""){
    		alert("请选中需要修改的数据");
    	}else{
    		var sid = row.id;
    		var stateNumber = row.businessState;
    		$.ajax({
    			type:"post",
    			url:"business/changeState",
    			data:{stateNumber:stateNumber,id:sid},
    			success:function(data){
    				row="";
    				if(data=="1"){
    					alert("修改成功");
    					$("#business").datagrid('load',{});
    				}else{
    					alert("修改失败,该业务处于使用状态，需先暂停");
    				}
    				
    			}	
    		});
    	} 		
    });
    
    
    
    
    
    
    /*修改业务信息*/
    $("#changeBusin").on("click",function(){

    	if(row==null||row==""){
    		alert("请选择需要修改的数据");
    	}else{
    		var sid = row.id;
    		$.ajax({
    			type:"post",
    			url:"business/findById",
    			data:{id:sid},
    			success:function(business){
    				$("#changeId").val(row.id);
    				$("#changeCreditNum").html(business.credit.creditNum);
    				$("#changeServerIp").html(business.serverIp);
    				$("#changeTariffName").html(business.tariff.tariffName);
    				$("#changeTariffType").html(business.tariff.tariffType);
    				$("#changeBusinessNum").html(business.businessNum);
    				$("#changeBusinessPwd").textbox('setText',business.businessPwd);
    				$("#winChange").window("open");
    				row="";
    				
    				
    			}
    		});
    		
    	}
 
    });
    
    
    
    
    
	
   /* 删除方法*/
    $("#deleteBusin").on("click",function(){
    	if(row==null||row==""){
    		alert("请选择需要删除的数据");
    	}else{
    		var sid = row.id;
    		if(confirm("请确认是否删除")){
    			$.ajax({
        			type:"post",
        			url:"business/delete",
        			data:{"id":sid},
        			success:function(data){
        				if(data==0){
        					alert("该业务账号未暂停，无法删除");
        				}else if(data==1){
        					alert("删除成功");
        					$("#business").datagrid('load',{});
        					row="";
        				}else{
        					alert("操作错误");
        				}
        				
        			}
        		});
    		}
    		
    	}
    });
  
    
    
    
    
});





function clearChangeForm(){
    $('#creditFromChange').form('clear');
}

function returnMain(){
    $('#winFind').window('close');
}



/*from表单提交修改*/
function submitChangeForm(){
    $("#businessFormChange").form("submit",{
        url:"business/update",
        success:function(data){
        	if(data=="1"){
                alert("修改成功");
                $('#businessFromChange').form('clear');
                $("#winChange").window("close");
                $("#business").datagrid('load',{});
                row="";
        	}else{
        		alert("修改失败");
        	}
        }
    });
}




