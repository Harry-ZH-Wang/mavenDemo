/**
 * Created by Administrator on 2016/12/30.
 */
//点击查询按钮，弹出数据页面
//$(function(){
//    $("#findBtn1").click(function(){
//        $('#dateSoureWin').window('open');
//    });
//});
//点击返回按钮
$(function(){
    $("#backBtn").click(function(){
        $('#dateSoureWin').window('close');
        $('#dateSoureWin').form('clear');
    });
});

$(function() {
	$("#findBtn2").click(function() {
		$('#DataTable').datagrid("load",{
			serverDate:$("#Date").textbox("getValue"),
			serverIp:$("#Ip").val(),

		});
	});
});

//查看详情
$(function(){
	var row="";
    $("#DataTable").datagrid({
        onClickRow:function(){
            row=$("#DataTable").datagrid("getSelected");
           
            /*查看*/
            $("#findBtn1").on("click",function(){
            	
            	if(row==null||row==""){
            		alert("请选择需要修改的数据");
            	}else{
            		
            		$("#data111").datagrid('load',{
            			serverIp:row.serverIp,
            			page:1,
            			rows:10
            		});
            		
          			$('#dateSoureWin').window('open');
            	
            		
            	}
         
            });
        }
});
});


