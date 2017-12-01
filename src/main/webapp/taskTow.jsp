<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.test.CountTest"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>排序-子任务2</title>
</head>
<body>
	<form action="" method="POST">
		<input type="text" name="number"
			onkeyup="this.value=this.value.replace(/\D/g,'')"
			onafterpaste="this.value=this.value.replace(/\D/g,'')" />
		<button type="submit">添加</button>
		</br> </br> <select class="select" name="FruitList" multiple="multiple"
			size="10" style="width: 100px">
			<%
				String number = request.getParameter("number");//获取input值
				if (number != null && number.length() > 0) {
					List list = (ArrayList) pageContext.getAttribute("val", pageContext.APPLICATION_SCOPE);
					if (list == null) {
						List arr = new ArrayList();
						arr.add(number);
						pageContext.setAttribute("val", arr, pageContext.APPLICATION_SCOPE);

					} else {
						list.add(number);
						pageContext.setAttribute("val", list, pageContext.APPLICATION_SCOPE);
					}
				}
				//获取到setAttribute里面的值
				List lists = (ArrayList) pageContext.getAttribute("val", pageContext.APPLICATION_SCOPE);
				if (lists != null) {
					for (int i = 0; i < lists.size(); i++) {
						for (int j = lists.size() - 1; j > i; j--) {
							if (lists.get(j).equals(lists.get(i))) {
								lists.remove(j);//去掉重复输入
							}
						}
			%> str+="
			<option value='<%=i%>'><%=lists.get(i)%></option>";
			<%
				}
				}
			%>
		</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

	</form>

	<form action="" method="POST">
		<select class="select" name="select" multiple="multiple" size="10"
			style="width: 150px">
			<option value="1">直接插入排序</option>
			<option value="2">快速排序</option>
			<option value="3">选择排序</option>
			<option value="4">归并排序</option>
		</select><br></br>
		<%
			String Fruit = request.getParameter("select");
			String check = request.getParameter("check");
			int f = 0;
			if (Fruit != null&&Fruit!="") {
				f = Integer.parseInt(Fruit);
			}
			
		%>

		<input name="hide" type="hidden" value="1" /> <input name="check"
			type="checkbox" value="1" <%=f%> />逆序排序&nbsp;&nbsp;
		<button type="submit">排序</button>
		</br>

		<%
			/* 过程排序字符串 */
			List tempList = null;
			String hidden = request.getParameter("hide");
			if (pageContext.getAttribute("val", pageContext.APPLICATION_SCOPE) != null && ("1").equals(hidden)) {
				List list = (ArrayList) pageContext.getAttribute("val", pageContext.APPLICATION_SCOPE);
				Object[] objs = list.toArray();
				int arr[] = new int[objs.length];
				for (int i = 0; i < objs.length; i++) {
					arr[i] = Integer.parseInt(objs[i].toString());
				}
				int a = arr[0];
				int b = arr[arr.length - 1];

				if (Fruit != null && "1".equals(Fruit)) {
					out.print("插入排序:");
					tempList = CountTest.insertSort(arr);
				} else if (Fruit != null && "2".equals(Fruit)) {
					out.print("快速排序:");
					CountTest.quickSort(arr, arr[0], arr[arr.length - 1]);
				} else if (Fruit != null && "3".equals(Fruit)) {
					out.print("选择排序:");
					CountTest.selectSort(arr);
				} else if (Fruit != null && "4".equals(Fruit)) {
					out.print("归并排序:");
					CountTest.mergeSort(arr, arr.length);
				}
				if (!"1".equals(check)) {
					out.print("<br>");
					for (int i = 0; i < tempList.size(); i++) {
		%>
		<label><%=tempList.get(i)%></label><br>

		<%
			}
				} else {
					for (int i = objs.length - 1; i >= 0; i--) {
		%>
		<label><%=arr[i]%></label>

		<%
			}
				}
			}
		%>
		</br>
	</form>

</body>
</html>