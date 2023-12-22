<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>신규고객등록</h3>
<form method="post" action="insert.cu">
		
		<table class="table tb-row">

			<colgroup>
				<col width="180px">
				<col>
			</colgroup>


			<tr>
				<th>고객명</th>
				<td>
					<div class="row">
						<div class="col-auto">
							<input class="form-control" type="text" name="name">
								
						</div>
					</div>
				</td>

			</tr>

			<tr>
				<th>성별</th>
				<!--  <div class="form-check">
          <input class="form-check-input" type="radio" name="flexRadioDefault" id="flexRadioDefault1">
           <label class="form-check-label" for="flexRadioDefault1">
    
  </label> -->

				<td><div class="form-check form-check-inline">
					<label class=form-chek-label"> <input
						class="form-check-input" type="radio" name="gender" value="남">남

					</label>
				</div>

				<div class="form-check form-check-inline">
					<label class=form-chek-label"> <input
						class="form-check-input" type="radio" name="gender" value="여"
						<c:if test="${vo.gender eq '여'}"> checked </c:if>>여

					</label>
				</div>

</td>
			</tr>

			<tr>
				<th>이메일</th>
				<td>
					<div class="row">
						<div class="col-auto">
							<input class="form-control" type="text" name="email"
								>
						</div>
					</div>
				</td>
			</tr>

			<tr>
				<th>전화번호</th>
				<td>
					<div class="row">
						<div class="col-auto">
							<input class="form-control" type="text" name="phone"
								>
						</div>
					</div>
				</td>
			</tr>
		</table>

		<!--from태그내에있는 button태그의//////////?????????????-->
		<div class="btn-toolbar justify-content-center gap-2">

			<button class="btn btn-primary">저장</button>
			<!-- 		<button class="btn btn-outline-primary" onclick="history.go(-1)">취소</button> -->
			<%-- <button class="btn btn-outline-primary" onclick="location='info.cu?id=${vo.customer_id}' ">취소</button> --%>
			<button type="button" class="btn btn-outline-primary"
				onclick="location='list.cu'">취소</button>



		</div>
	</form>

</body>
</html>