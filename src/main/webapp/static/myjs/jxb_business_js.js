/**
 * Created by zhihe on 2016/12/29.
 */

function dayLoad(){

	
	$("#dayDetailShow").datagrid("load",{
		businessDate:$("#businessDayOnload").val(),
		creditNum:$("#dayNumOnload").val()		
});
}

function getPayState(payType){
	if(payType=='0'){
		return "";
}else if(payType=='1'){
	return "现金支付";
}else if(payType=='2'){
	return "手机支付";
}else{
	return "银行卡支付";
}
}


$(function(){
	$("#findItemsMonth").on("click",function(){
		$("#businessMainInfo").datagrid("load",{
			creditNum:$("#findCreditNum").val(),
			creditName:$("#findCreditName").val(),
			creditIdCard:$("#findCreditIdCard").val(),
			businessDate:$("#findMonthDate").val()	
		});
	});	
});


function getFeeState(feeState){
	if(feeState=='0'){
		return "未交费";
	}else {
		return "已缴";
	}	
}


function getcreditName(value,row,index){
	if(row.credit!=null){
		return row.credit.creditName;
	}
}
function getcreditIdCard(value,row,index){
	if(row.credit!=null){
		return row.credit.creditIdCard;
	}
}


/*-----------------------------------------------*/
function findbusinessDate(value,row,index){
	if(row.businessDay!=null){
		return row.businessDay.businessDate;
	}
}
function findcreditName(value,row,index){
	if(row.credit!=null){
		return row.credit.creditName;
	}
}
function findcreditNum(value,row,index){
	if(row.credit!=null){
		return row.credit.creditNum;
	}
}
function findcreditIdCard(value,row,index){
	if(row.credit!=null){
		return row.credit.creditIdCard;
	}
}
function findbusinessServerIp(value,row,index){
	if(row.business!=null){
		return row.business.serverIp;
	}
}
function findSectionLoginTime(value,row,index){
	if(row.sertion!=null){
		return row.sertion.loginTime;
	}
}
function findSectionOutTime(value,row,index){
	if(row.section!=null){
		return row.section.outTime;
	}
}
function findTariffTariffName(value,row,index){
	if(row.tariff!=null){
		return row.tariff.tariffName;
	}
}

/*选中行*/

$(function(){
	var row = "";
	$("#businessMainInfo").datagrid({
		onClickRow:function(){
			row=$("#businessMainInfo").datagrid("getSelected");
		}
	});
	
	/*查看月表选中行的详细信息*/
	$(function(){
		$("#findsingleMonth").on("click",function(){
			

			if(row==null||row==""){
				$.messager.alert('请选中需要查看的数据行');
			}else{
				var findBusinessDate=row.businessDate;
				var findCreditNum = row.creditNum;
				
				location.href="businessDetail/model?businessDate="+findBusinessDate+"&creditNum="+findCreditNum;
			}
		});
	});

/*修改方法*/
$("#saveFeeBtn").on("click",function(){
	if(row==null||row==""){
		alert("请选择需要修改的数据");
	}
	if(row.payType==0){
		$("#changeDate").val(row.businessDate);
		$("#date").html(row.businessDate);
		$("#changeNum").val(row.creditNum);
		$("#num").html(row.creditNum);
		$("#totalMoney").html(row.totalMonthFee);
		$('#saveWinChange').window('open');
	}
	if(row.payType==1||row.payType==2||row.payType==3){
		alert("该账号已结清费用");
	}
		
	
});
});
/*from表单提交缴费*/
function submitChangeForm(){
    $('#saveFormChange').form('submit',{
        url:"businessMain/saveMoney",
        success:function(data){
        	if(data>0){
                alert("修改成功");
                $('#saveFormChange').form('clear');
                $("#saveWinChange").window("close");
                $("#businessMainInfo").datagrid('load',{});
                row="";
        	}else{
        		alert("修改失败");
        	}
        }
    });
}

function clearChangeForm(){
    $('#saveFormChange').form('clear');
}



