<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3 class="mb-4">공지글등록</h3>

<form method="post" action="insert" enctype="multipart/form-data">
<input type ="hidden" name="writer" value="${loginInfo.user_id}">
<table class="table tb-row">
<colgroup>
	<col width="180px">
	<col>
</colgroup>
<tr><th>제목</th>
	<td><input type="text" autofocus class="check-empty  form-control"  title="제목" name="title"></td>
</tr>
<tr><th>내용</th>
	<td><textarea name="content" class="check-empty form-control"  title="제목" ></textarea></td>
</tr>

</tr>
<tr><th>첨부파일</th>
	<td>
	<div class="row">
          <div class="col-auto d-flex file-info align-items-center">
            <label>
             <input class="form-control" id="file-single" type="file" name="file"  >
             <i role="button" class="me-4 fa-regular fa-address-card fs-2"></i><!-- me:magin -->
             
            </label>
            <div class="d-flex align-items-center">
               <span class="file-name"> </span><!-- 미리보기 -->
               <i role="button" class="ms-4 file-delete  d-none  text-danger fs-4  fa-solid fa-file-plus"></i></i>
            </div>
          </div>
       </div>
	
	</td>
</tr>
</table>
</form>

<div class="btn-toolbar justify-content-center gap-2">
	<button class="btn btn-primary px-4" id="btn-save">저장</button>
	<button class="btn btn-outline-primary px-4" id="btn-cancel">취소</button>
</div>

<script>
$("#btn-save").click(function(){
	if(emptyCheck(){//입력값이 있는 경우만 서브밋
	$("form").submit()
		
	}
})
$("#btn-cancel").click(function(){
	location = "list"
})
</script>


</body>
</html>