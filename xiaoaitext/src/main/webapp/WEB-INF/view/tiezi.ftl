<!DOCTYPE html>
<html>
		<head>
			<meta http-equiv="Content-Type" content="text/html;charset="utf-8" />
			<link rel="stylesheet" type="text/css" href="${base.contextPath}/static/css/bootstrap.min.css"/>
			<script type="text/javascript" src="${base.contextPath}/static/js/jquery.min.js"></script>
			<script src="${base.contextPath}/static/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
			<script type="text/javascript">
				$(document).ready(function(){
					$(".xiaoai-1").click(function(){
						window.location.href="http://localhost:8080/xiaoaitext/view/boot.ftl";
					})
					$(".xiaoai-100").click(function(){
						var list=$("table").find(":checkbox:checked");
						var params="params=1"
						list.each(function(){
							params=params+"&post_id="+$(this).val();
						})
						
						$.ajax({
							url:"/xiaoaitext/user/deletePost",
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
		<div class="page-header"><h1 style="text-align:center;">主页</h1></div>
			<form action="/xiaoaitext/user/select2" style="text-align:center;">
			<lable>作者</lable><input type="text" name="post_author" />  <lable>时间</lable><input type="text" name="post_date" /> <input type="submit" class="btn btn-success" value="查询"/>
			<button type="button" class="btn btn-warning xiaoai-1">发帖</button>
			<button type="button" class="btn btn-danger xiaoai-100">删帖</button>
			</form>
			
			<table border="1" class="table table-striped">	
				<tr>
					<td>发帖主题</td>
					<td>发帖作者</td>
					<td>发帖内容</td>
					<td>发帖时间</td>
					
				</tr>
				
				<#list list as p>
					<tr id="tr${p['post_id']}">
						<td><a href="/xiaoaitext/user/reply?post_id=${p['post_id']}">${p['post_title']}</a></td>
						<td>${p['post_author']}</td>
						<td>${p['post_content']}</td>
						<td>${p['post_date']?string('yyyy-MM-dd HH:mm:ss')}</td>
						<td><input type="checkbox" value="${p['post_id']}"/></td>
					</tr>
				</#list>
				
			</table>
		</body>
		
</html>