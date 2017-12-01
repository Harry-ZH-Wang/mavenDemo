/*$('#clientCredit').datagrid({
 onDblClickRow: function(index,row){
 $(this).datagrid('beginEdit', index);
 var ed = $(this).datagrid('getEditor', {index:index,row:row});
 $(ed.target).focus();
 $("#winFind").window("open");
 }
 });*/

$(function() {
	$("#getBtn").on("click", function() {
			$("#winFind").window("open");
	});
});

$(function() {
	$("#reBtn").on("click", function() {
			$("#winFind").window("close");
	});
});


$(function() {
	var findRow = "";
	$("#clientCredit").datagrid({
		onClickRow : function() {
			findRow = $("#clientCredit").datagrid("getSelected");
		}
	});
	$("#getBtn").on("click", function() {
//		alert(findRow.creditNum)
		if (findRow == null || findRow == "") {
			$("#winFind").window("close");
			alert("请选择行");
		} else {
			
			$("#BusinessList").datagrid("load",{
				creditNum: findRow.creditNum,
				date:findRow.businessDate
			});
			
		}
	});
});


function getBusinessNum(value,row,index){
	if(row.sectionDay){
		return row.sectionDay.business.businessNum;
	}
}

function getTariffNum(value,row,index){
	if(row.sectionDay){
		return row.sectionDay.business.tariff.tariffName;
	}
}

function getIp(value,row,index){
	if(row.sectionDay!=null){
		return row.sectionDay.business.serverIp;
	}
}

function getLoginTime(value,row,index){
	if(row.sectionDay!=null){
		return row.sectionDay.loginTime;
	}
}

function getOutTime(value,row,index){
	if(row.sectionDay!=null){
		return row.sectionDay.outTime;
	}
}

function getSectionTime(value,row,index){
	if(row.sectionDay!=null){
		return row.sectionDay.sectionTime;
	}
}

function getSectionFee(value,row,index){
	if(row.sectionDay!=null){
		return row.sectionDay.sectionFee;
	}
}

function getTariffType(value,row,index){
	if(row.sectionDay!=null){
		return  row.sectionDay.business.tariff.tariffType;
	}
}