public class ShopDAO {
	
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public ShopMember selectMember(Connection conn, String MemberId) {
		
		ShopMember sm = null;
		
		try {
			String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
			pstmt = conn.prepareStatement(sql);
			
			if(rs.next()) {
				
				// 각 컬럼의 값 얻어오기
				String id      = rs.getString("MEMBER_ID");
				String pw   = rs.getString("MEMBER_PW");
				String phone   = rs.getString("PHONE");
				String gender = rs.getString("성별");
				
				sm = new ShopMember(id, pw, phone, gender);
		}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sm;
	}
}

SHOP_MEMBER 테이블에는

컬럼명 MEMBER_ID, MEMBER_PW, PHONE, GENDER 이렇게 4가지 컬럼명이 있고,

컬럼명 MEMBER_ID는 데이터타입은 VARCHAR2(20)이고, 제약조건은 PRIMARY KEY 이고, 설명은 아이디 이며,
컬럼명 MEMBER_PW는 데이터타입은 VARCHAR2(20)이고, 제약조건은 NOT NULL 이고, 설명은 패스워드 이며,
컬럼명 PHONE은 데이터타입은 CHAR(11)이고, 제약조건은 NOT NULL 이고, 설명은 전화번호 이며,
컬럼명 GENDER는 데이터타입은 CHAR(1)이고, 제약조건은 CHECK('M','F') 이고, 설명은 성별 이다


