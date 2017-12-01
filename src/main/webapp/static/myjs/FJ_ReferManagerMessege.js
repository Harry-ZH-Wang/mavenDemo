

/*修改按钮按键*/
$(function(){
    $("#changeManagerMessege").on("click",function(){
        $("#winManagerChange").window("open");
    });
});

$(function(){
	var row="";
    $("#managerMessege").datagrid({
        onClickRow:function(){
            row=$("#managerMessege").datagrid("getSelected");
            $("#id").val(row.id);
           
        	}
    	});
    });

/*from表单提交修改*/
function submitChangeManagerForm(){
	
    $('#messegeManagerFromChange').form('submit',{
        url:"messege/updateMnagerTel",
        data:{id:$("#id").val(),managerPhone:$("#updateManagerPhone").val()},
        success:function(data){
        	if(data==0){
        		alert("修改失败");
        	}else{
        		 alert("修改成功");
                 $('#messegeManagerFromChange').form('clear');
                 $("#winManagerChange").window("close");
                 $("#managerMessege").datagrid('load',{});
        	}
        }
    });
}
function clearChangeManagerForm(){
    $('#messegeManagerFromChange').form('clear');
}









