<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试显示头像</title>
</head>
<body>
	<p>下面是测试显示头像</p>
	<div class="uploadPicture">
		<img id="imgHead" src="" width="106" height="122" alt="头像"> <input
			type="file" onchange="uploadHead();" id="basicInfoHead"
			style="display: none;" name="basicInfoHead" /> <input type="hidden"
			id="basicHeadUrl"> <a href="#basicInfo"
			id="uploadBasicInfoHead">上传头像</a>
	</div>




<script type="text/javascript">
	//上传头像，触发click方法  
	$('#uploadBasicInfoHead').on('click', function() {
		$('#basicInfoHead').click();
	});

	function uploadHead() {
		$.ajaxFileUpload({
			url : "<%=basePath%>profile/uploadBasicHead",//需要链接到服务器地址   
			secureuri : false,
			fileElementId : "basicInfoHead",//文件选择框的id属性  
			dataType : 'json', //json  
			success : function(data) {
				$("#imgHead").attr(
						"src",
						"<%=basePath%>profile/readImage?imagePath="
								+ data.imagePath);
				$('#basicHeadUrl').val(data.imagePath);
			},
			error : function(XMLHttpRequest, textStatus,
					errorThrown) {
				alert('上传失败！');
			}
		});
	};
</script>
</body>
</html>