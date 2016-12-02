<!DOCTYPE html>
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html;charset="utf-8" />
			<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap.min.css"/>
			<script src="${base.contextPath}/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
			<script type="text/javascript" src="${base.contextPath}/static/js/jquery.min.js"></script>
			<script type="text/javascript">
				$(document).ready(function(){
					$(".xiaoai-2").click(function(){
						$(".xiaoai-4").css({"display":"block"});
					});
					$(".xiaoai-5").click(function(){
						$(".xiaoai-4").css({"display":"none"});
					});
					$("button[value='delete']").click(function(){
						var list=$("table").find(":checkbox:checked");
						var params="params=1"
						list.each(function(){
							params=params+"&reply_id="+$(this).val();
						})
						$.ajax({
							url:"/xiaoaitext/user/ajaxdel",
							dataType:"text",
							type:"get",
							data:params,
							success:function(data){
								list.each(function(){
									var id="#tr"+$(this).val();
									$(id).remove();
								})
							}
						})
					})
				})
			</script>
			<title></title>
		</head>
		<body>
			
			<div> <h1 style="text-align:center;">主贴</h1> </div>
			<table border="1" class="table table-striped">	
				<#list post as p>
				<tr>
						<td>${p['post_title']}</td>
						<td>${p['post_author']}</td>
						<td>${p['post_date']?string('dd.MM.yyyy')}</td>
				</tr>
				</#list>
			</table>
			<div><h2 style="text-align:center;">回复</h2></div>
			<table  border="1" class="table table-striped">	
				<tr>
					
					<td>回帖内容</td>
					<td>回帖者</td>
					<td>回帖时间</td>
					<td><button type="button" value="delete"  class="btn btn-danger">删除</button></td>
					<td><button type="button" value="回复" class="xiaoai-2 btn btn-info">回复</button></td>
				</tr>
				<#list list as p>
					<tr id="tr${p['reply_id']}">
						
						<td>${p['reply_content']}</td>
						<td>${p['reply_author']}</td>
						<td>${p['reply_date']}</td>
						<td><input type="checkbox" value="${p['reply_id']}"/></td>
					</tr>
				</#list>
			</table>
			<form class="xiaoai-4" style="display:none" action="${base.contextPath}/user/addReply">
					<input type="text" name="reply_content" class="xiaoai-1"/>
					<input type="button" value="取消" class="xiaoai-5">
					<input type="submit" class="xiaoai-3" value="提交回复">
				</form>
		</body>
		
</html>