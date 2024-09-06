public class shopMember {
	
	//필드
	private String memberId;
	private String memberPw;
	private String phone;
	private String gender;
	
	//생성자
	public ShopMember() {}
	
	public ShopMember(String memberId, String memberPw, String phone, String gender) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.phone = phone;
		this.gender = gender;
	}
	
	// getter/setter (문제없음)
	public String getMemberId() { return memberId; }
	public void setMemberId(String memberId) { this.memberId = memberId; }
	public String getMemberPw() { return memberPw; }
	public void setMemberPw(String memberPw) { this.memberPw = memberPw;; }
	public String getPhone() { return phone; }
	public void setPhone(String phone) { this.phone = phone; }
	public String getGender() { return gender; }
	public void setGender(String gender) { this.gender = gender; }
	
	@Override
	public String toString() {
		return memberId + "," + memberPw + "," + phone + "," + gender;
	}
	
}













원인 1. PreparedStatement와 ResultSet의 사용

 PreparedStatement를 선언하고 있지만, 
실제로 PreparedStatement를 사용하여 SQL 쿼리를 실행하는 코드가 없음

또 ResultSet 객체는 pstmt.executeQuery() 메서드를 호출하여 얻어야 하는데 
코드에는 해당 메서드 호출이 없음

ResultSet 객체가 초기화되지 않으므로, rs.next() 호출은 의미가 없으며, 
회원 정보를 조회할 수 없음
이로 인해 회원 정보 조회가 실패함











원인 2. ResultSet의 조회

ResultSet 객체는 rs.next() 메서드를 호출하여 
다음 행으로 이동해야 하는데 ResultSet 객체를 초기화하는 코드가 없음

ResultSet을 제대로 조회하지 않으므로, 데이터베이스에서 반환된 결과를 처리할 수 없음








원인 3. 쿼리 파라미터 설정

PreparedStatement에 쿼리 파라미터를 설정하는 코드가 없음
setString 메서드를 사용하여 ? 자리표시자에 값을 바인딩해야 됨
		
쿼리에서 ? 자리에 어떤 값도 설정되지 않으므로 쿼리가 올바르게 실행되지 않음






원인 4. ShopMember 생성자의 파라미터

ShopMember 클래스의 생성자가 id, pw, phone, gender 파라미터를 사용하여 
인스턴스를 생성한다고 가정했는데 실제 클래스 정의가 주어지지 않음

생성자와의 일치 여부를 확인할 수 없지만
생성자가 올바르게 정의되지 않았다면 객체 생성 시 문제가 발생할 수 있음






























