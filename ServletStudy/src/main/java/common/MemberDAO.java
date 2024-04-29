package common;

import java.util.List;
import java.util.Vector;

import common.JDBConnect;
import jakarta.servlet.ServletContext;

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
	public MemberDAO(ServletContext application) {
		super(application);
	}
	
	
	public List<MemberDTO> selectList(){
		List<MemberDTO> bbs = new Vector<MemberDTO>();
		
		String query = "select * from member ";
		query+=" order by name desc ";
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
				
				bbs.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
}
