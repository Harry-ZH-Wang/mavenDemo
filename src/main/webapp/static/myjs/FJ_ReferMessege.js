

/*修改按钮按键*/
$(function(){
    $("#changeMessege").on("click",function(){
        $("#winChange").window("open");
    });
});

$(function(){
	var row="";
    $("#messege").datagrid({
        onClickRow:function(){
            row=$("#messege").datagrid("getSelected");
            $("#id").val(row.id);
           
        	}
    	});
    });

/*from表单提交修改*/
function submitChangeForm(){
	
    $('#messegeFromChange').form('submit',{
        url:"messege/updateMessegeTel",
        data:{id:$("#id").val(),creditPhone:$("#updatePhone").val()},
        success:function(data){
        	if(data==0){
        		alert("修改失败");
        	}else{
        		 alert("修改成功");
                 $('#messegeFromChange').form('clear');
                 $("#winChange").window("close");
                 $("#messege").datagrid('load',{});
        	}
        }
    });
}
function clearChangeForm(){
    $('#messegeFromChange').form('clear');
}









