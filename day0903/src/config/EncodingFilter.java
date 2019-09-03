package config;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/*")
public class EncodingFilter implements Filter {


//서버가 꺼질때
	public void destroy() {
		System.out.println("서버 끝날때 호출되는 필터: 필터 제거");
	}

//request 가 발생했을   때
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("utf-8 인코딩 처리완료");
		chain.doFilter(request, response);
	}
//서버가 시작될때 호출
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("서버 시작시 호출되는 필터: 필터초기화");
	}

}
