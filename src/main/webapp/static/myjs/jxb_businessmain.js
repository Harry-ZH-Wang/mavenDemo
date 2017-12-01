/**
 * Created by zhihe on 2016/12/29.
 */
$(function(){
    /*获取表格选中行id*/
    var row="";
    $("#business").datagrid({
        onClickRow:function(){
            row=$("#business").datagrid("getSelected");
            $("#tableLineId").val(row.id);
        }
    });

});
/*新增按钮按键*/
$(function(){
    $("#saveAllFee").on("click",function(){
        $("#winSaveFee").window("open");
    });
});
/*from表单提交新增*/
function submitSaveMoney(){
    $('#saveMoney').form('submit',{
        url:"控制器地址",
        success:function(){
            alert("提交成功");
            $("#winSaveFee").window("close");
        }
    });
}
function clearSaveForm(){
	 $("#winSaveFee").window("close");
}

/*from表单提交修改*/
function submitChangeForm(){
    $('#powerFromChange').form('submit',{
        url:"控制器地址",
        success:function(){
            alert("修改成功");
            $("#winChange").window("close");
        }
    });
}
