package memo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import memo.dao.MemoDAO;
import memo.dto.MemoDTO;


public class MemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("memoController입니다.");
		MemoDAO dao=new MemoDAO();
		
		String url=request.getRequestURL().toString();
		if(url.indexOf("list.mo") != -1) {
			System.out.println("url : "+url);
			//oracle 에서 데이터 읽어오기
			ArrayList<MemoDTO> list=dao.list();
			for(MemoDTO dto : list) {
				System.out.println(dto);
			}
			request.setAttribute("list", list);
			//PrintWriter pw=response.getWriter();
			//pw.println(list);
			String page="/memo/memo_list.jsp";
  			RequestDispatcher rd=request.getRequestDispatcher(page);
  			rd.forward(request, response);
			
		}else if(url.indexOf("insert.mo") != -1) {
			//필터에서 인코딩처리
			//request.setCharacterEncoding("utf-8");
			System.out.println("메모등록 처리");
			String writer=request.getParameter("writer").trim();
			String memo=request.getParameter("memo").trim();
			MemoDTO dto=new MemoDTO(writer, memo);
			System.out.println(writer);
			System.out.println(memo);
			dao.insert(dto);
			//요청될때 경로/
			String path=request.getRequestURL().toString();
			System.out.println("요청URL : "+path);
			//http://localhost/day0822/memo/memo_servlet/list.mo
			//페이지이동
			// "/" -> localhost
			String root=request.getContextPath();
			System.out.println("root:"+root);
			String page="../memo_list.jsp";
			response.sendRedirect(page);
 
		}else if(url.indexOf("detailView.mo") != -1) {
			int no=Integer.parseInt(request.getParameter("no"));
			MemoDTO dto=dao.detailView(no);
			request.setAttribute("dto", dto);
			String page="/memo/detailView.jsp";
  			RequestDispatcher rd=request.getRequestDispatcher(page);
  			rd.forward(request, response);
		}else if(url.indexOf("edit.mo") != -1) {
			System.out.println("memo-edit 처리 페이지");
			int no=Integer.parseInt(request.getParameter("no"));
			String writer = request.
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
