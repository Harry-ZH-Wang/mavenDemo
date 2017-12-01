/**
 * Created by zhihe on 2017/1/1.
 */
/*查询按钮，需要选择按年查询或按月查询*/

function load(){
	
	$("#creditByMonth").datagrid("load",{
			date:$("#monthOnload").val()			
});
}

function loadAllMonth(){
	
	$("#monthDetailByYear").datagrid("load",{
		date:$("#yearOnload").val(),
		serverIp:$("#ipOnload").val()		
	});
}

function loadDay(){
	$("#findAllDay").datagrid("load",{
		date:$("#dayOnLoad").val(),
		serverIp:$("#IpOnLoad").val()
	});
}

function dayLoad(){
	$("#findDayByMonth").datagrid("load",{
		date:$("#date").val(),
		serverIp:$("#serIpOnLoad").val()
	});
}

/*点击按月查询，解锁月份输入框，通过年月组合按年月查询月表数据*/
$(function(){
	$("#month").on("click",function(){			
			$("#findCreditByMonth").searchbox({disabled:false});		
	});
	
	$("#year").on("click",function(){		
		$("#findCreditByMonth").searchbox({disabled:true});	
});	
});

/*按年模糊查询*/
$(function(){
	$("#checkOut").on("click",function(){
		var radios = document.getElementsByName('creditCheck');	
		
		if(radios[0].checked){
		$("#credit").datagrid("load",{
			date:$("#findCreditDateByYear").val()			
		});
		}else{
			var str = $("#findCreditDateByYear").val()+"-"+$("#findCreditByMonth").val();
			location.href="serverMonth/yearAndMonth?date="+str;
		}
	});
});

/*选中年表的行*/
var findRow = "";
$(function(){
	$("#credit").datagrid({
		onClickRow:function(){
			findRow=$("#credit").datagrid("getSelected");
		}
	});	
});
/*选中按年查询月表的行*/
var findMonthRow="";
$(function(){
	$("#monthDetailByYear").datagrid({
		onClickRow:function(){
			findMonthRow=$("#monthDetailByYear").datagrid("getSelected");
		}
	});
});

/*选中按月查询月表的行*/
var findMonthRowByMonth="";
$(function(){
	$("#creditByMonth").datagrid({
	onClickRow:function(){
		findMonthRowByMonth=$("#creditByMonth").datagrid("getSelected");
	}
	});
});

/*查看年表选中行的详细信息*/
$(function(){
	$("#findByYearAndIp").on("click",function(){
		if(findRow==null||findRow==""){
			$.messager.alert('请选中需要查看的数据行');
		}else{
			var yearDate=findRow.serverDate;
			var serverIp = findRow.serverIp;
			
			location.href="serverMonth/yearDetail?dateByYear="+yearDate+"&serverip="+serverIp;
		}
	});
});

/*查看按年查询月表选中行的详细信息*/
$(function(){
	$("#findByMonthAndIp").on("click",function(){
		if(findMonthRow==null||findMonthRow==""){
			$.messager.alert("请选中需要查看的数据行");
		}else{
			var monthDate = findMonthRow.serverDate;
			var serverIp = findMonthRow.serverIp;
			
			location.href="serverDay/dayDetail?dateByMonth="+monthDate+"&serverip="+serverIp;
		}
	});
});

/*查看按月查询月表选中行的详细信息*/
$(function(){
	$("#findAllDayInfo").on("click",function(){
		if(findMonthRowByMonth==null||findMonthRowByMonth==""){
			$.messager.alert("请选中需要查看的数据行");
		}else{
			var monthDateByMonth = findMonthRowByMonth.serverDate;
			var serverIpByMonth = findMonthRowByMonth.serverIp;
			
			location.href="serverDay/dayDetailByMonth?date="+monthDateByMonth+"&serverIp="+serverIpByMonth;
		}
	});
});
/*双击年查询这个服务器下这年每月详情*/
//$(function(){
//	$("#dg").on("dblClick",function(){
//		var str = $("#serverDate").val();
//		var str1 = $("#serverIp").val();
//		location.href="serverMonth/page?date="+str&"serverIp="+str1;
//	});
//});


//$('#dg').datagrid({
//	onDblClickRow: function(index,row){
//		$(this).datagrid('beginEdit', index);
//		var ed = $(this).datagrid('getEditor', {index:$("serverIp"),field:field});
//		$(ed.target).focus();
//	}
//});









