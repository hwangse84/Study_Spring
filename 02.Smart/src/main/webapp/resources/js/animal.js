/**
 * 
 */
 
 $(document)
 .on("change","#sido",function(){//시도변경시
	animal_sigungu();
	animal_list(1);
	
})

  .on("change","#sigungu",function(){//시군구변경시
	animal_shelter();
	animal_list(1);
	
})

 .on("change","#shelter",function(){//보호소	변경시
	animal_list(1);
	
})
 
 .on("change","#upkind",function(){//축종변경
	animal_kind();
	animal_list(1);
	
})
 
 .on("change","#kind",function(){//품종변경
	
	animal_list(1);
	
})
 
 //품종조회
 function animal_kind(){
	$("#kind").remove();
	if($("#upkind").val()=="") return;//축종 선택한경우만 품종조회가능
	
	$.ajax({
		url: "animal/kind" ,
		data:{upkind:$("#upkind").val()}
	}).done(function(response){
		$("#upkind").after(response);
	})
}
 
 function animal_type(){
//	축종코드
// - 개 : 417000
// - 고양이 : 422400
// - 기타 : 429900

	
	var tag=`
	<select class="form-select w-px200" id="upkind">
		<option value="">축종 선택</option><option value="417000">개</option>
		<option value="422400">고양이</option>
		<option value="429900">기타</option>
	</select>
	`;
	$(".animal-top").append(tag);
}
 
 
 
 
function animal_sigungu(){
	$("#sigungu").remove();//시군구가 있으면 없애고..
	$("#shelter").remove();//시군구에 따라오는 보호소도 없애고...
	
	if($("#sido").val()=="") return;//시도코드가 있는 경우만 시군구 조회
	
	$.ajax({
		url:"animal/sigungu",
		data: {sido:$("#sido").val()}
	}).done(function(response){
		$("#sido").after(response);
	})
	
}
 
 
 $("#sigungu").change(function(){
	animal_shelter( );
	animal_list( 1 );
})
function animal_shelter(){
	$("#shelter").remove(); //보호소 없애고...
	
	//시군구 코드(입력시 데이터o,미입력시 데이터x)
	if($("#sigungu").val()=="") return;
	$.ajax({
		url:"animal_shelter",
		date:{ sido : $("#sido").val(), sigungu : $("#sigungu").val()}
		
	}).done(function(response){
		$("#sigungu").after(response)
		
	})
}
