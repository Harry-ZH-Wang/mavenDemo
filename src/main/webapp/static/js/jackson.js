$(function(){
	//涓簅ne娣诲姞涓�釜鐐瑰嚮浜嬩欢
	$('#one').click(function(){
		//鎿嶄綔涓�釜瀵硅薄,鐢ㄤ簬娣诲姞鎴栬�淇敼
		var user = {id:'1',
				userName:"AAAA",
				password:"123456"};
		//鎴戜滑灏咼S瀵硅薄杞崲涓篔SON瀵硅薄
		var json = $.toJSON(user);
		$.ajax({
			type:"POST",
			url:"jackson/one",
			data:json,
			async:true,//榛樿灏辨槸true(寮傛鎻愪氦)
			contentType:"application/json",
			success:function(msg){
				alert(msg.status);
				alert(msg.msg);
				alert(msg.information);
			}
		});
	});
	
	
	
	
	
		//涓簍wo娣诲姞涓�釜鐐瑰嚮浜嬩欢	
		$('#two').click(function(){
			var ids = [];
			var a = 1;
			var b =2;
			ids.push(a);
			ids.push(b);
			
			var json = $.toJSON(ids);
			$.ajax({
				type:"POST",
				url:"jackson/two",
				data:json,
				async:true,//榛樿灏辨槸true(寮傛鎻愪氦)
				contentType:"application/json",
				success:function(msg){
					alert(msg.status);
					alert(msg.msg);
					alert(msg.information);
				}
			});
		});
	
		//涓簍hree娣诲姞涓�釜鐐瑰嚮浜嬩欢	
		$('#three').click(function(){
			var users = [];
			var user = {id:'1',
					userName:"灏忓紶",
					password:"123456"};
			var user2 = {id:'2',
					userName:"灏忕帇",
					password:"654321"};
			
			users.push(user);
			users.push(user2);
			
			var json = $.toJSON(users);
			$.ajax({
				type:"POST",
				url:"jackson/three",
				data:json,
				async:true,//榛樿灏辨槸true(寮傛鎻愪氦)
				contentType:"application/json",
				success:function(msg){
					alert(msg.status);
					alert(msg.msg);
					alert(msg.information);
				}
			});
		});
		
		//涓篺our娣诲姞涓�釜鐐瑰嚮浜嬩欢
		$('#four').click(function(){
			var userName = "灏忔潕";
			$.ajax({
				type:"POST",
				url:"jackson/four",
				data:{userName:userName},
				success:function(msg){
					alert(msg);
					var lenth = msg.length;
					for(var i = 0; i < lenth; i ++){
						alert(msg[i].id);
						alert(msg[i].userName);
					}
				}
			});
		});
		
		//涓篺ive娣诲姞涓�釜鐐瑰嚮浜嬩欢
		$('#five').click(function(){
			var userName = "灏忔潕";
			$.ajax({
				type:"POST",
				url:"jackson/five",
				data:{userName:userName},
				success:function(msg){
					alert(msg.userName);
					alert(msg.password);
				}
			});
			
			
			
			
		});
		
		
		$('#six').click(function(){
			$.ajax({
				type:"GET",
				cache:true,
				url:"jackson/six",
				success:function(msg){
					alert(msg);
				}
			});
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
});