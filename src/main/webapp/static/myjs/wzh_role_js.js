/**
 * Created by zhihe on 2017/1/1.
 */
/*新增按钮按键*/
$(function(){
    $("#addRole").on("click",function(){
        $("#winAdd").window("open");
    });
});

/*模糊查询*/
$(function(){
	$("#findRole").on("click",function(){
		$("#role").datagrid("load",{
			roleName:$("#selectName").val(),
			roleDescripe:$("#selectDes").val()
		});
	});
});
/*新增方法*/
var rows=[];
$(function(){
	var row="";
    $("#power").datagrid({
    	onCheck:function(){
            row=$("#power").datagrid('getChecked');
        }
    });
    
    $("#addRoleBtn").on("click",function(){
   	  for(var i=0;i<row.length;i++){
   	      rows.push(row[i].id);
   	   }
   	 $("#powerStr").textbox("setValue",rows);
   	 rows.splice(0,rows.length);
   	 $('#roleFromAdd').form('submit',{
   	        url:"role/add",
   	        success:function(data){
   	        	var row=parseInt(data);
   	        	if(row==1){
   	        		alert("添加成功");
   	        		$('#roleFromAdd').form('clear');
   	        		row=$("#power").datagrid('clearChecked');
   	        		rows.splice(0,rows.length);
   	                $("#winAdd").window("close");
   	                $("#role").datagrid('load',{});
   	        	}else{
   	        		alert("添加失败");
   	        		rows.splice(0,rows.length);
   	        	}
   	        }
   	    });
    });
    
});

function clearAddRoleForm(){
    $('#roleFromAdd').form('clear');
    rows.splice(0,rows.length);
}

/*角色修改*/
/*储存权限数组*/
var changeArr=[];
$(function(){
	var changeRow="";
	$("#role").datagrid({
		onClickRow:function(){
			
			changeRow=$("#role").datagrid("getSelected");
		}
	});
	
	$("#changeRole").on("click",function(){
		if(changeRow==null||changeRow==""){
			alert("请选择需要修改的数据");
		}else{
			$.ajax({
				type:"post",
				url:"role/findById",
				data:{id:changeRow.id},
				success:function(role){
					$("#roleIdChange").textbox("setValue",role.id);
					$("#roleDesChange").textbox("setValue",role.roleDescripe);
					$("#roleNameChange").textbox("setValue",role.roleName);
					var type=role.roleType;
					if(type==0){
						$("#roleTypeChange").combobox("setValue",0);
						$("#roleTypeChange").combobox("setText","管理员");
					}
					if(type==1){
						$("#roleTypeChange").combobox("setValue",1);
						$("#roleTypeChange").combobox("setText","用户");
					}
					var tempPowers=role.powers;
					for(var i=0;i<tempPowers.length;i++){
						changeArr.push(tempPowers[i].id);
						
					}

					$("#powerStrChange").textbox("setValue",changeArr);
					changeArr.splice(0, changeArr.length);

					/*表格数据加载完成之后进行判断*/
					$("#powerChange").datagrid("load",{});
					$("#powerChange").datagrid("clearChecked");
					
					$("#winChange").window("open");
				}
			});
		}
	});

	//修改页面加载完成后调用方法判断
	$("#powerChange").datagrid({
		onLoadSuccess:function(powersList){
			var changeHiden=$("#powerStrChange").textbox("getValue").split(",");
			
			for(var i=0;i<changeHiden.length;i++){
				for(var j=0;j<powersList.rows.length;j++){
					if(changeHiden[i]==powersList.rows[j].id){
						$("#powerChange").datagrid("checkRow",j);
					}
				}
			}
		}
	});
	
	/*储存权限*/
	var changePowrRole="";
    $("#powerChange").datagrid({
    	onCheck:function(){
    		changePowrRole=$("#powerChange").datagrid('getChecked');
        }
    });
    $("#ChangeRoleBtn").on("click",function(){
    	changeArr.splice(0, changeArr.length);
     	  for(var i=0;i<changePowrRole.length;i++){
     		 changeArr.push(changePowrRole[i].id);
     	  }
     	 $("#powerStrChange").textbox("setValue",changeArr);
     	 changeArr.splice(0, changeArr.length);
     });
	
	/*修改角色权限方法*/
    $("#ChangeRoleBtn").on("click",function(){
    	$("#roleFromChange").form("submit",{
    		url:"role/changRole",
    		success:function(row){    
    	        if(row==1){
    	        	alert("修改成功");
    	        	 $('#roleFromChange').form('clear');
    	        	 changeArr.splice(0, changeArr.length);
    	        	 $("#powerChange").datagrid("clearChecked");
    	        	 $("#winChange").window("close");
    	        	 $("#role").datagrid("load",{});
    	        	 changeRow="";
    	        }else{
    	        	alert("修改失败");
    	        }  
    	    }   
    	});
    });
	
    /*删除方法*/
    $("#deleteRole").on("click",function(){
    	if(changeRow==null||changeRow==""){
			alert("请选择需要删除的数据");
		}else{
			if(confirm("请确认是否删除")){
				$.ajax({
					type:"post",
					url:"role/delete",
					data:{id:changeRow.id},
					success:function(row){
						if(row==1){
							alert("删除成功");
							$("#role").datagrid("load",{});
							changeRow="";
						}else{
							alert("删除失败");
						}
					}
				});
			}
		}
    });
    
    
    
});
function clearChangeRoleForm(){
	 $('#roleFromChange').form('clear');
	 changeArr.splice(0, changeArr.length);
	 $("#powerChange").datagrid("clearChecked");
}











