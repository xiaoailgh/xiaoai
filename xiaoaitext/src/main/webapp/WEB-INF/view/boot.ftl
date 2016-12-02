
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap.min.css"/>
	<script type="text/javascript" src="${base.contextPath}/static/js/jquery.min.js"></script>
	<script src="${base.contextPath}/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript"">
		$(document).ready(function(){
			$(".xiaoai-1").click(function(){
				var post_content=$(".xiaoai-2").val();
				var post_title=$(".xiaoai-3").val();
				$.ajax({
					url:"${base.contextPath}/user/bootPost",
					data:"post_content="+post_content+"&post_title="+post_title,
					dataType:"text",
					type:"get",
					success:function(data){
						alert("发表成功");
						window.location.href="http://localhost:8080/xiaoaitext/user/post"
					}
				})
			})
		})
	</script>
	<title>发帖</title>
</head>
<body>
	<div> <h1 style="text-align:center">欢迎来到李天才贴吧</h1></div>
	<div  class="input-group" >
		<lable>帖子主题</lable><input type="text" class="xiaoai-3"/>
		<textarea class="form-control xiaoai-2" rows="3" style="width:500px"></textarea>
		<button type="button" class="btn btn-info xiaoai-1">发表</button>
	</div>
</body>
</html>
