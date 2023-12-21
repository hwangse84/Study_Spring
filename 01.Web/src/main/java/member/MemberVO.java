package member;

public class MemberVO {
    //DB설계 : Table생성(컬럼)
	//입력하면 태그의name 속성값을 Table의 컬럼명과 동일하게 지정
	// 데이터 객체(DTO,VO)의 필드를 화면의 태그 name 속성값과 동일하게 선언
	private String name, email, gender;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
