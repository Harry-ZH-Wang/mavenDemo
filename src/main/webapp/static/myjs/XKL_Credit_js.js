
/**
 * Created by zhihe on 2016/12/29.
 */

/*新增按钮按键*/
$(function(){
    $("#addCredit").on("click",function(){
        $("#winAdd").window("open");
    });
});



/*from表单提交新增*/
function submitAddForm(){
    $('#creditFormAdd').form('submit',{
        url:"credit/add",
        success:function(data){
        	var row=parseInt(data);
        	if(row==1){
        		alert("添加成功");
        		$('#creditFromAdd').form('clear');
                $("#winAdd").window("close");
                $("#credit").datagrid('load',{});
        	}else{
        		alert("添加失败");
        	}
        }
    });
}
function clearAddForm(){
    $('#creditFromAdd').form('clear');
}


//账号使用状态数字转变为中文
function getCreditState(creditState){
	if (creditState =="1"){
		return "正在使用";
	}else{
		return "已经暂停";
	}
		
}


/*模糊查询*/
$(function(){
	$("#findBtn").on("click",function(){
		$("#credit").datagrid('load',{
			creditNum:$("#findByNum").val(),
			creditName:$("#findByName").val(),
			creditIdCard:$("#findByIdCard").val()
		});
	});
});


$(function(){
	var row="";
	//点击选中
    $("#credit").datagrid({
        onClickRow:function(){
            row=$("#credit").datagrid("getSelected");
        }
    });
    
    /*查询账务详情*/
    $("#findCredit").on("click",function(){

    	if(row==null||row==""){
    		alert("请选择需要查询的数据");
    	}else{
    		var sid = row.id;
    		$.ajax({
    			type:"post",
    			url:"credit/findById",
    			data:{id:sid},
    			success:function(credit){
    				
    				
    				$("#findCreditName").html(credit.creditName);
    				if(credit.creditSex==0){
    					$("#changeCreditSex").html("女");
    					}else{
    					$("#changeCreditSex").html("男");
    					}
    				
    				$("#findCreditIdCard").html(credit.creditIdCard);
    				$("#findCreditNum").html(credit.creditNum);
    				$("#findCreditPwd").html(credit.creditPwd);
    				$("#findCreditPhone").html(credit.creditPhone);
    				$("#findCreditAddress").html(credit.creditAddress);
    				$("#findCreditPost").html(credit.creditPost);
    				$("#findCreditQQ").html(credit.creditQQ);
    				$("#winFind").window("open");
    				row="";
    			}
    		});
    		
    	}
 
    });
    
    
    /*修改账务状态*/
    $("#changeStateCredit").on("click",function(){
    	if(row==null||row==""){
    		alert("请选中需要修改的数据");
    	}else{
    		var sid = row.id;
    		var stateNumber = row.creditState;
    		$.ajax({
    			type:"post",
    			url:"credit/changeState",
    			data:{stateNumber:stateNumber,id:sid},
//    			contentType:"application/json",
    			success:function(data){
    				row="";
    				if(data=="1"){
    					alert("修改成功");
    					$("#credit").datagrid('load',{});
    				}else{
    					alert("修改失败,该账号处于使用状态");
    				}
    				
    			}	
    		});
    	} 		
    });
    
    
    
    
    
    
    /*修改业务信息*/
    $("#changeCredit").on("click",function(){

    	if(row==null||row==""){
    		alert("请选择需要修改的数据");
    	}else{
    		var sid = row.id;
    		$.ajax({
    			type:"post",
    			url:"credit/findById",
    			data:{id:sid},
    			success:function(credit){
    				$("#changeId").val(credit.id);
    				$("#changeCreditName").html(credit.creditName);
    				if(credit.creditSex==0){
    					$("#changeCreditSex").html("女");
    					}else{
    					$("#changeCreditSex").html("男");
    					}
    				
    				$("#changeCreditIdCard").html(credit.creditIdCard);
    				$("#changeCreditNum").html(credit.creditNum);
    				$("#changeCreditPwd").textbox("setValue",credit.creditPwd);
    				$("#changeCreditPhone").textbox("setValue",credit.creditPhone);
    				$("#changeCreditAddress").textbox("setValue",credit.creditAddress);
    				$("#changeCreditPost").textbox("setValue",credit.creditPost);
    				$("#changeCreditQQ").textbox("setValue",credit.creditQQ);
    				$("#winChange").window("open");
    				row="";
    				
    				
    			}
    		});
    		
    	}
 
    });
    
    
    
    
    
	
   /* 删除方法*/
    $("#deleteCredit").on("click",function(){
    	if(row==null||row==""){
    		alert("请选择需要删除的数据");
    	}else{
    		var sid = row.id;
    		if(confirm("请确认是否删除")){
    			$.ajax({
        			type:"post",
        			url:"credit/delete",
        			data:{"id":sid},
//        			contentType:"application/json",
        			success:function(data){
        				if(data=="0"){
        					alert("该账务账号未暂停，无法删除");
        				}else if(data=="1"){
        					alert("删除成功");
        					$("#credit").datagrid('load',{});
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
function submitchangeInfo(){
    $("#creditFormChange").form("submit",{
        url:"credit/update",
        success:function(data){
        	if(data=="1"){
                alert("修改成功");
                $('#creditFromChange').form('clear');
                $("#winChange").window("close");
                $("#credit").datagrid('load',{});
                row="";
        	}else{
        		alert("账号未暂停，修改失败");
        	}
        }
    });
}




