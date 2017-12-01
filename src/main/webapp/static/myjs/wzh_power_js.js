/**
 * Created by zhihe on 2016/12/29.
 */

/*新增按钮按键*/
$(function(){
    $("#addPower").on("click",function(){
        $("#winAdd").window("open");
    });
});

/*from表单提交新增*/
function submitAddForm(){
    $('#powerFromAdd').form('submit',{
        url:"power/add",
        success:function(data){
        	var row=parseInt(data);
        	if(row==1){
        		alert("添加成功");
        		$('#powerFromAdd').form('clear');
                $("#winAdd").window("close");
                $("#power").datagrid('load',{});
        	}else{
        		alert("添加失败");
        	}
        }
    });
}
function clearAddForm(){
    $('#powerFromAdd').form('clear');
}


/*模糊查询*/
$(function(){
	$("#findBtn").on("click",function(){
		$("#power").datagrid('load',{
			powerName:$("#findByName").val()
		});
	});
});


$(function(){
	var row="";
    $("#power").datagrid({
        onClickRow:function(){
            row=$("#power").datagrid("getSelected");
        }
    });
    
    /*修改方法*/
    $("#changePower").on("click",function(){

    	if(row==null||row==""){
    		alert("请选择需要修改的数据");
    	}else{
    		
    		var json = $.toJSON(row);
    		$.ajax({
    			type:"post",
    			url:"power/findById",
    			data:json,
    			contentType:"application/json",
    			success:function(power){
    				$("#changeId ").val(power.id);
    				$("#changePowerName").html(power.powerName);
    				$("#changePowerUrl").textbox("setValue",power.powerUrl);
    				$("#changePid").numberbox("setValue",power.pid);
    				$("#winChange").window("open");
    			}
    		});
    		
    	}
 
    });
	
   /* 删除方法*/
    $("#deletePower").on("click",function(){
    	if(row==null||row==""){
    		alert("请选择需要删除的数据");
    	}else{
    		var json = $.toJSON(row);
    		if(confirm("请确认是否删除")){
    			$.ajax({
        			type:"post",
        			url:"power/delete",
        			data:json,
        			contentType:"application/json",
        			success:function(data){
        				if(data==0){
        					alert("该角色有人使用，无法删除");
        				}else if(data==1){
        					alert("删除成功");
        					$("#power").datagrid('load',{});
        					row="";
        				}else{
        					alert("删除失败");
        				}
        				
        			}
        		});
    		}
    		
    	}
    });
    
});

/*from表单提交修改*/
function submitChangeForm(){
    $('#powerFromChange').form('submit',{
        url:"power/change",
        success:function(data){
        	if(data==1){
                alert("修改成功");
                $('#powerFromChange').form('clear');
                $("#winChange").window("close");
                $("#power").datagrid('load',{});
                row="";
        	}else{
        		alert("修改失败");
        	}
        }
    });
}
function clearChangeForm(){
    $('#powerFromChange').form('clear');
}

