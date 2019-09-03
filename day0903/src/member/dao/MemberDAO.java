package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.OracleDB;
import member.dto.MemberDTO;

public class MemberDAO {
	Connection conn=null;
	public MemberDAO() {
		conn=OracleDB.dbConnect();
	}

	public void insertMember(MemberDTO member) {
		//oracle접속 해서 정보저장...
		String sql="insert into member values(seq_member.nextval,?,?,?,?,sysdate)";
	
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPass());
			pstmt.setString(4, member.getEmail());
			
			int n=pstmt.executeUpdate();
			System.out.println(n+"개의 회원정보 입력 완료!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
				try {
					if(conn != null)conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
	}
	
	/* 로그인 체그 처리 메서드 */
	public String loginCheck(String id, String pass) {
		String sql="select name from member where id=? and pass=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			pstmt.setString(2,pass);
			
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("name");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
