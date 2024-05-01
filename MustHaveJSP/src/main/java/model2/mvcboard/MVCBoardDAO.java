package model2.mvcboard;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnect;

public class MVCBoardDAO extends JDBConnect {
	public MVCBoardDAO() {
		super();
	}
	public int selectCount(Map<String, Object>map) {
		int totalCount = 0;
		String query = "select count(*) from mvcboard";
		if(map.get("searchWord")!=null) {
			query+=" where "+map.get("searchField")+" "
					+" like '%"+map.get("searchWord")+"%'";
		}
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("게시물 카운트 중 예외 발생");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<MVCBoardDTO> selectListPage(Map<String, Object> map){
		List<MVCBoardDTO> bbs = new Vector<MVCBoardDTO>();
		
		String query = "select * from mvcboard ";
		if(map.get("searchWord")!=null) {
			query += " where "+map.get("searchField")+" "
					+" like '%"+map.get("searchWord")+"%' ";
		}
		query+=" order by idx desc limit ?,?";
		
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, (int)map.get("start"));
			psmt.setInt(2, (int)map.get("pageSize"));
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				MVCBoardDTO dto = new MVCBoardDTO();
				
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
				
				bbs.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 조회 중 예외 발생");
			e.printStackTrace();
		}
		return bbs;
	}
	public int insertWrite(MVCBoardDTO dto) {
		int result = 0;
		try {
			String query = "insert into mvcboard ( "
					+" name, title, content, ofile, sfile,pass) "
					+" values ( "
					+" ?,?,?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			psmt.setString(6, dto.getPass());
			result=psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("게시글 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}
	public MVCBoardDTO selectView(String idx) {
		MVCBoardDTO dto = new MVCBoardDTO();
		String query = "select * from mvcboard where idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setSfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setPass(rs.getString(9));
				dto.setVisitcount(rs.getInt(10));
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외 발생");
			e.printStackTrace();
		}
		return dto;
	}
}