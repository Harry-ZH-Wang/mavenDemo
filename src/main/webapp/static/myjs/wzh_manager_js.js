
/*模糊查询*/
$(function(){
	$("#findManager").on("click",function(){
		$("#manager").datagrid("load",{
			managerName:$("#selectName").val(),
			managerNum:$("#selectNum").val(),
			managerPhone:$("#selectPhone").val()
		});
	});
});

/*新增方法*/
$(function(){
	$("#addManager").on("click",function(){
		$("#winAdd").window("open");
	});
	
	var roleRow=[];
    $("#role").datagrid({
    	onCheck:function(){
        	roleRow=$("#role").datagrid("getChecked");
        }
    });
	$("#addRoleBtn").on("click",function(){
		$("#rolelStr").textbox("setValue",roleRow[0].id);
		
		
		$("#managerFromAdd").form('submit',{
			url:"manager/add",
			success:function(data){
				if(data=="exist"){
					$.messager.alert('NG','账号已存在');
				}else if(data==1){
					roleRow=[];
					$.messager.alert('OK','添加成功'); 
					$("#winAdd").window("close");
					$('#managerFromAdd').form('clear');
					$("#role").datagrid("clearChecked");
					$("#manager").datagrid("load",{});
				}else{
					$.messager.alert('NG','添加失败'); 
				}
				
			}
		});
		
		
		
	});
	
	
});
function clearAddManagerForm(){
    $('#managerFromAdd').form('clear');
}


/*选择行*/
var changeRow="";
$(function(){
	
	$("#manager").datagrid({
		onClickRow:function(){
			changeRow=$("#manager").datagrid("getSelected");
		}
	});
});

/*修改方法*/
var changeRole=[];
$(function(){
	
	$("#roleChange").datagrid({
		onCheck:function(){
			changeRole=$("#roleChange").datagrid("getChecked");
			
		}
	});
});
$(function(){
	
	$("#changeManager").on("click",function(){
		if(changeRow==null||changeRow==""){
			$.messager.alert('警告','请选择需要修改的数据'); 
		}else{
			
			$.ajax({
				type:"post",
				url:"manager/findManagerById",
				data:{"id":changeRow.id},
				success:function(manager){
					changeRow="";
					$("#managerId").textbox("setValue",manager.id);
					$("#managerName").textbox("setValue",manager.managerName);
					$("#managerNum").textbox("setValue",manager.managerNum);
					$("#managerPhone").textbox("setValue",manager.managerPhone);
					$("#managerEmail").textbox("setValue",manager.managerEmail);
					$("#mmanagerChangeStr").textbox("setValue",manager.rolel.id);
					/*表格数据加载完成之后进行判断*/
					$("#roleChange").datagrid("load",{});
					$("#roleChange").datagrid("clearChecked");
				}
			});
			
			$("#winChange").window("open");
		}
	});
	
	
	//修改页面加载完成后调用方法判断
	$("#roleChange").datagrid({
		onLoadSuccess:function(roleList){
			var changeHiden=$("#mmanagerChangeStr").textbox("getValue");
			for(var j=0;j<roleList.rows.length;j++){
				if(changeHiden==roleList.rows[j].id){
					$("#roleChange").datagrid("checkRow",j);
				}
			}
		}
	});
	
	/*修改方法*/
	$("#changeRoleBtn").on("click",function(){
		
		$("#mmanagerChangeStr").textbox("setValue",changeRole[0].id);
		
		
		$("#managerFromChange").form("submit",{
			url:"manager/changeManager",
			success:function(data){
				if(data==1){
					$.messager.alert('OK','修改成功'); 
					$("#winChange").window("close");
					changeRole=[];
					$('#managerFromChange').form('clear');
					$("#manager").datagrid("load",{});
					$("#manager").datagrid("clearSelections");
				}else{
					$.messager.alert('NG','修改失败'); 
				}
			}
		});
	});
	
	
});

function clearClosedForm(){
	changeRole=[];
	$('#managerFromChange').form('clear');
	$("#winChange").window("close");
	$("#manager").datagrid("clearSelections");
}

/*删除方法*/
$(function(){
	$("#deleteManager").on("click",function(){
		if(changeRow==null||changeRow==""){
			$.messager.alert('警告','请选择需要删除的数据');
		}else{
			$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
			    if (r){    
			    	$.ajax({
						type:"post",
						url:"manager/deleteManager",
						data:{id:changeRow.id},
						success:function(manager){
							if(manager==1){
								changeRow="";
								$.messager.alert('OK','删除成功');
								$("#manager").datagrid("load",{});
							}else{
								$.messager.alert('NG','删除失败');
							}
						}
						
					}); 
			    }    
			}); 
			
			
		}
	});
})

