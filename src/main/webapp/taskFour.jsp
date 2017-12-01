<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>表格-子任务4</title>
</head>
<body>
	请输入要显示的表格信息：
	<form action="" method="post">
		行数:<input type="text" name="oneNum"
			value="<%=request.getParameter("oneNum") == null ? "" : request.getParameter("oneNum")%>"
			onkeyup="this.value=this.value.replace(/\D/g,'')"
			onafterpaste="this.value=this.value.replace(/\D/g,'')" /></br> 列数:<input
			type="text" name="towNum"
			value="<%=request.getParameter("towNum") == null ? "" : request.getParameter("towNum")%>"
			onkeyup="this.value=this.value.replace(/\D/g,'')"
			onafterpaste="this.value=this.value.replace(/\D/g,'')" /></br> 边界宽度:<input
			type="text" name="threeNum"
			value="<%=request.getParameter("threeNum") == null ? "" : request.getParameter("threeNum")%>"
			onkeyup="this.value=this.value.replace(/\D/g,'')"
			onafterpaste="this.value=this.value.replace(/\D/g,'')" /> </br> 是否显示行间隔色:<input
			type="radio" value="1" name="colrow" />是 <input type="radio"
			value="2" name="colrow" />否 </br> 是否显示列间隔色:<input type="radio" value="1"
			name="colcol" />是 <input type="radio" value="2" name="colcol" />否 </br>
		合并单元格:&nbsp;&nbsp;从<input type="text" name="startrow" />行&nbsp;&nbsp;<input
			type="text" name="startcol" />列开始 </br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		合并<input type="text" name="rownum" />行<input type="text"
			name="colnum" />列 </br> <input type="submit" value="提交" /> </br>
	</form>
	<%
		int cells = 0;
		String threeNum = request.getParameter("threeNum");
		String row = request.getParameter("oneNum");
		String col = request.getParameter("towNum");
		String colorrow = request.getParameter("colrow");
		String colorcol = request.getParameter("colcol");
		String startrow = request.getParameter("startrow");
		String startcol = request.getParameter("startcol");
		String rownum = request.getParameter("rownum");
		String colnum = request.getParameter("colnum");
		if (threeNum != null && threeNum.length() > 0) {
			cells = Integer.parseInt(threeNum);
		}
		if (row == null || "".equals(row.trim())) {
			row = "1";
		}
		if (col == null || "".equals(col.trim())) {
			col = "1";
		}
		if (colorrow == null || "".equals(colorrow.trim())) {
			colorrow = "2";
		}
		if (colorcol == null || "".equals(colorcol.trim())) {
			colorcol = "2";
		}
		if (startrow == null || "".equals(startrow.trim())) {
			startrow = "-1";
		}
		if (startcol == null || "".equals(startcol.trim())) {
			startcol = "-1";
		}
		if (rownum == null || "".equals(rownum.trim())) {
			rownum = "-1";
		}
		if (colnum == null || "".equals(colnum.trim())) {
			colnum = "-1";
		}

		if (row != null || col != null) {
	%>
	<table cellpadding="0" cellspacing="1" border="<%=cells%>" width="100%">
		<%
			int n = -1;
				int m = -1;
				for (int i = 1; i <= Integer.parseInt(row); i++) {
					int j = 1;
					if (m != -1 && n < Integer.parseInt(rownum) - 2) {
						j = Integer.parseInt(colnum) + 1;
						n++;
					}
					if (i % 2 == 0 && Integer.parseInt(colorrow) == 1&&Integer.parseInt(colorcol) == 2) {
						out.print("<tr bgcolor=#CCCCCC>");

					} else {
						out.print("<tr>");
					}
					for (; j <= Integer.parseInt(col); j++) {
						if(Integer.parseInt(colorcol) == 1&&Integer.parseInt(colorrow) ==1){
							if(i%2==0){
								if(j%2==0){
									if (!(i == Integer.parseInt(startrow) && j == Integer.parseInt(startcol))) {
										out.print("<td bgcolor=#CCCCCC>");
										out.print("helloWorld!");
										out.print("</td>");
									} else {
										j += Integer.parseInt(colnum) - 1;
										m = i;
				%>
				<td style="background-color: #CCCCCC;" colspan="<%=colnum%>"
					rowspan="<%=rownum%>">helloWorld！</td>
				<%
					}
								}else{
									if (!(i == Integer.parseInt(startrow) && j == Integer.parseInt(startcol))) {
										out.print("<td >");
										out.print("helloWorld!");
										out.print("</td>");
									} else {
										j += Integer.parseInt(colnum) - 1;
										m = i;
				%>
				<td style="background-color: #CCCCCC;" colspan="<%=colnum%>"
					rowspan="<%=rownum%>">helloWorld！</td>
				<%
					}
								}
							}else{
								if(j%2!=0){
									if (!(i == Integer.parseInt(startrow) && j == Integer.parseInt(startcol))) {
										out.print("<td bgcolor=#CCCCCC>");
										out.print("helloWorld!");
										out.print("</td>");
									} else {
										j += Integer.parseInt(colnum) - 1;
										m = i;
				%>
				<td style="background-color: #CCCCCC;" colspan="<%=colnum%>"
					rowspan="<%=rownum%>">helloWorld！</td>
				<%
					}
								}else{
									if (!(i == Integer.parseInt(startrow) && j == Integer.parseInt(startcol))) {
										out.print("<td >");
										out.print("helloWorld!");
										out.print("</td>");
									} else {
										j += Integer.parseInt(colnum) - 1;
										m = i;
				%>
				<td style="background-color: #CCCCCC;" colspan="<%=colnum%>"
					rowspan="<%=rownum%>">helloWorld！</td>
				<%
					}
								}
							}
							
						}
						else if ( j % 2 == 0&&Integer.parseInt(colorcol) == 1&&Integer.parseInt(colorrow) ==2) {
							if (!(i == Integer.parseInt(startrow) && j == Integer.parseInt(startcol))) {
								out.print("<td bgcolor=#CCCCCC>");
								out.print("helloWorld!");
								out.print("</td>");
							} else {
								j += Integer.parseInt(colnum) - 1;
								m = i;
		%>
		<td style="background-color: #CCCCCC;" colspan="<%=colnum%>"
			rowspan="<%=rownum%>">helloWorld！</td>
		<%
			}
						} else {
							if (!(i == Integer.parseInt(startrow) && j == Integer.parseInt(startcol))) {
								out.print("<td>");
								out.print("helloWorld!");
								out.print("</td>");
							} else {
								m = i;
								j = j + Integer.parseInt(colnum) - 1;
		%>
		<td style="background-color: #CCCCCC;" colspan="<%=colnum%>"
			rowspan="<%=rownum%>">helloWorld!</td>
		<%
			}

						}
					}
					out.print("</tr>");
				}
		%>

		<%
			}
		%>
	</table>


</body>
</html>