public class ShopDAO {

    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    public ShopMember selectMember(Connection conn, String memberId) {
        ShopMember sm = null;

        try {
            String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
            pstmt = conn.prepareStatement(sql);

            // 쿼리 파라미터 설정
            pstmt.setString(1, memberId);

            // 쿼리 실행 및 결과 가져오기
            rs = pstmt.executeQuery();

            if (rs.next()) {
                // 각 컬럼의 값 얻어오기
                String id = rs.getString("MEMBER_ID");
                String pw = rs.getString("MEMBER_PW");
                String phone = rs.getString("PHONE");
                String gender = rs.getString("GENDER"); // 컬럼명 수정

                sm = new ShopMember(id, pw, phone, gender);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 자원 해제
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sm;
    }
}







조치 1.

pstmt.setString(1, memberId);를 추가하여 
SQL 쿼리에서 ? 자리표시자에 memberId 값을 설정
		
		pstmt.setString(1, memberId);
	

		
		
		
		
		
		
		

조치 2. 		

pstmt.executeQuery()로 ResultSet 객체를 초기화한 후,
rs.next() 메서드를 호출하여 결과 집합의 첫 번째 행으로 이동
이 메서드를 통해 데이터가 존재하는지 확인하고 데이터를 읽음



if(rs.next()) {
	
	// 각 컬럼의 값 얻어오기
	String id      = rs.getString("MEMBER_ID");
	String pw   = rs.getString("MEMBER_PW");
	String phone   = rs.getString("PHONE");
	String gender = rs.getString("성별");
	
	sm = new ShopMember(id, pw, phone, gender);
}

를

if (rs.next()) {
    String id = rs.getString("MEMBER_ID");
    String pw = rs.getString("MEMBER_PW");
    String phone = rs.getString("PHONE");
    String gender = rs.getString("GENDER"); // 컬럼명 수정
    sm = new ShopMember(id, pw, phone, gender);
}
		
		
로 수정












조치 3.


pstmt.setString(1, memberId)를 호출하여 
SQL 쿼리의 자리표시자에 memberId 값을 설정
이를 통해 쿼리가 올바르게 실행되게 하기


try문 안에

// 쿼리 파라미터 설정
pstmt.setString(1, memberId);

코드 추가








조치 4.


컬럼명을 데이터베이스 테이블 정의에 맞게 수정하여 올바르게 데이터를 읽을 수 있게 함

String gender = rs.getString("GENDER");

rs.getString("GENDER")는 데이터베이스 테이블에서 GENDER 컬럼의 값을 읽어옴
컬럼명을 올바르게 지정하여 데이터베이스와의 일치를 보장




조치 5.

finally 블록에서 rs와 pstmt를 닫아 자원을 해제

if 조건문을 사용하여 객체가 null이 아닐 때만 닫도록 함


DAO 소스코드
33번 이하 라인을

}catch (Exception e) {
e.printStackTrace();
}
return sm;
}
}

를

} catch (Exception e) {
    e.printStackTrace();
} finally {
    // 자원 해제
    try {
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
return sm;
}
}


로 변경
