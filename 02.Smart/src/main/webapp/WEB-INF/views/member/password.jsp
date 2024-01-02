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
<h3 class="mb-4">비밀번호 변경</h3>

<table class="table tb-row">
<colgroup>
    <col width='180px'>

    <col>
</colgroup>
<tr>
    <th>현재 비밀번호</th>
     <td><div class="row">
          <div class="col-auto">
          <input class="form-control" type="password" name="currentPw"  >
          </div>
     </div>
   </td>
    <th></th>
</tr>
<tr>
    <th>새 비밀번호</th>
   
    <td><div class="row input-check">
         <div class="col-auto">
             <input class="form-control check-item" type="password" 
                     name="user_pw" title="새 비밀번호" >
         </div>
         <div class="col-auto desc"></div>
         <div class="mt-2">비밀번호는 영문 대/소문자, 숫자 조합 5자~10자</div>
       </div>
    </td>
</tr>

<tr>
    <th>새 비밀번호 확인</th>
    <td><div class="row input-check">
         <div class="col-auto">
             <input class="form-control check-item" type="password" name="user_pw_ck" title="비밀번호 확인" >
         </div>
         <div class="col=auto desc"></div>
       </div>
    </td>
</tr>
</table>

<div class="btn-toolbar justify-content-center gap-2">
    <button class="btn btn-primary px-4" id="btn-change" >변경</button>

</div>
<script type="text/javascript" src="<c:url value='/js/member.js'/>"></script>
<script>
$("btn-change").click(function(){
	//입력이 잘 되어져있는지 확인후 DB에 변경저장
	if(tatIsValid()){
		//alert("ok")
		//현재비번이 DB의 현재비번과 일치하는지확인
		/* $.ajax({
			url:"confirmPassword",
			date:{user-pw; $("[name-user_pw]").val()},
			success:function(){
				
			}
		}) */
		
		$.ajax({
			url:"confirmPassword",
			date:{user_pw: $("[name=current_pw]").val()},
		}).done(function(response){
				
			conxole.log(response)
			response=0
			if(response==-1) location="login";
			else if(respomse==0){//일치
				//새비번과 현재 비번이 동일한지 확인
				if($("[name=user_pw]").val()==$("[name=currentPw]").val()){
					alert("현재 비밀번호와 새 비밀번호가 일치!\n 새 비밀번호를 다시 입력하세요")
					$("[name=user-pw]").focus()
					}else{
						reserPassword()	
					
				}
			}else if(respomse==1){//불일치
			 	alert("현재 비밀번호가 일치하지 않습니다");
			$("[name=currentPw]").val("");
			$("[name=currentPw]").fodus();
			}
		})
	}
})

function reserPassword(){
	
	$.ajax({
		url: "updatePassword",
		data: {user_pw:$("[name=user_pw]").val()}
	}).done(function(response){
		if(response){ alert("비밀번호가 변경되었습니다"); location="<c:url value='/'/>"}
		else         alert("비밀번호가 변경실패!!!")
	})
}

function tagIsValid(){

	var ok=true;
	if($("[name=currentPw]"),val()==""){
		alert("현재 비밀번호를 입력하세요!")
		$("[namecurrentPw]").focus();
		ok=false;
	}else{
		$(".check-item").each(function(){
			//비번, 비번확인 입력상태 확인 처리
			var status=member.tagStatus($(this))
			//console.log(status.is,status.desc)
			if(!status.is){
				alert("비밀번호 변경 불가\n"+status.desc)
				$(this).focus();
				ok=false
				return ok;
			}
		})
	}
	return ok;
}
$(".check-item").keyup(function(){
	member.showStatus($(this))
})
</script>


</body>
</html>