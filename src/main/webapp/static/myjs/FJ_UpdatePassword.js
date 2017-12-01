
/*from表单提交修改*/
function submitChange(){
	var urll = "";
	var type=$("#changType").val();
	if(type=="managerType"){
		urll="messege/updateManagerPwd";
		
	}
	if(type=="userType"){
		urll="messege/updateMessegePwd";
	}
	
	
    $("#ChangePwd").form('submit',{
        url:urll,
       
        success:function(data){
        	if(data==0){
        		alert("输入有误，请重新输入！");
        	}else{
        		 alert("修改成功");
                 $('#ChangePwd').form('clear');
               
        	}
        }
    });
}
function clearChangeForm(){
    $('#ChangePwd').form('clear');
}