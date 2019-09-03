package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDAO;
import member.dto.MemberDTO;



public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("uri :"+request.getRequestURI());
		String uri=request.getRequestURI();
		
		String[] strs=uri.split("/");
		//System.out.println(strs[strs.length-1]);//0~
		String path=strs[strs.length-1];
		
		/* 회원가입처리 */
		if(path.equals("regist.me")) {
			//System.out.println("url :"+request.getRequestURL());
			//System.out.println("path :"+request.getContextPath());
				
			String name=request.getParameter("name");
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			String email=request.getParameter("email");
			
			
			MemberDTO member=new MemberDTO();
			member.setName(name);
			member.setId(id);
			member.setPass(pass);
			member.setEmail(email);
			
			MemberDAO dao=new MemberDAO();
			dao.insertMember(member);
			
			HttpSession session=request.getSession();
			session.setAttribute("logName", name);
		
			
			//페이지이동
			String root=request.getContextPath(); 
			String location=root+"/index.jsp";
			response.sendRedirect(location);
			 //
			//request.setAttribute("logName", name);
			//String location="/index.jsp";
			//RequestDispatcher rd=request.getRequestDispatcher(location);
			//rd.forward(request, response);
		
		}else if(path.equals("login.me")) {
			String id=request.getParameter("id");
			String pass=request.getParameter("pass");
			
						
			MemberDAO dao=new MemberDAO();
			String name=dao.loginCheck(id, pass);
			if(name != null) {
				HttpSession session=request.getSession();
				session.setAttribute("logName", name);
				session.setMaxInactiveInterval(-1);
			}
			String root=request.getContextPath(); 
			String location=root+"/index.jsp";
			response.sendRedirect(location);
			
		}else if(path.equals("logout.me")) {
			System.out.println("logout처리부분");
			//세션삭제
			HttpSession session=request.getSession();
			session.removeAttribute("logName");
			
			//String root=request.getContextPath(); 
			//String location=root+"/index.jsp";
			String location="../index.jsp";
			response.sendRedirect(location);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
