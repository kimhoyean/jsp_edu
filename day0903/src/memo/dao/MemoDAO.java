package memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;



import config.OracleDB;
import memo.dto.MemoDTO;

public class MemoDAO {
	Connection conn=null;
	public MemoDAO(){
		conn=OracleDB.dbConnect();
	}

	public ArrayList<MemoDTO> list() {
		String sql="select * from memo order by no desc";
		ArrayList<MemoDTO> list=new ArrayList<>();
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				
				int no=rs.getInt("no");
				String writer=rs.getString("writer");
				String memo=rs.getString("memo");
				Timestamp reg_date=rs.getTimestamp("reg_date");
				MemoDTO dto=new MemoDTO();
				dto.setNo(no);
				dto.setWriter(writer);
				dto.setMemo(memo);
				dto.setReg_date(reg_date);
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
	
	public void insert(MemoDTO dto) {
		// < &lt;  > &gt;
		String writer=dto.getWriter();
		String memo=dto.getMemo();
		//태그 문자처리
		writer=writer.replace("<", "&lt;");
		writer=writer.replace(">", "&gt;");
		memo=memo.replace("<", "&lt;");
		memo=memo.replace(">", "&gt;");
		//공백 적용
		writer=writer.replace("  ", "&nbsp;&nbsp;");
		memo=memo.replace("  ", "&nbsp;&nbsp;");
		String sql="insert into memo values (seq_memo.nextval, ?, ?, sysdate)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, writer);
			pstmt.setString(2, memo);
			
			int n=pstmt.executeUpdate();
			System.out.println(n+"개 메모 입력!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {if(pstmt!=null)pstmt.close();} catch (SQLException e) {}
			try {if(conn!=null)conn.close();} catch (SQLException e) {}
		}
		
	}
	//메모 디테일뷰 처리 
	public MemoDTO detailView(int no) {
		String sql="select * from memo where no=?";
		PreparedStatement pstmt=null;
		MemoDTO dto=new MemoDTO();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			no=rs.getInt("no");
			String writer=rs.getString("writer");
			String memo=rs.getString("memo");
			Timestamp reg_date=rs.getTimestamp("reg_date");
			
			//MemoDTO dto=new MemoDTO();
			dto.setNo(no);
			dto.setWriter(writer);
			dto.setMemo(memo);
			dto.setReg_date(reg_date);
			//return dto;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt !=null)pstmt.close();
				if(conn !=null)conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
		
	}

}
