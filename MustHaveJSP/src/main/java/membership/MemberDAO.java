package membership;

import common.JDBConnect;

public class MemberDAO extends JDBConnect {
//	public static void main(String[] args) {
//		String drv = "com.mysql.cj.jdbc.Driver";
//		
//		String url = "jdbc:mysql://localhost:3306/musthave";
//		String id = "charles";
//		String pwd = "coeocjf2";
//		
//		MemberDAO dao = new MemberDAO(drv,url,id,pwd);
//		
//		MemberDTO dto = dao.getMemberDTO("musthave", "1234");
//		System.out.println(dto);
//	}
	public MemberDAO(String drv,String url, String id, String pw) {
		super(drv,url,id,pw);
	}
	
	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();
		String query = "SELECT * from member where id = ? and pass=?";
		try {
			psmt=con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	

}
