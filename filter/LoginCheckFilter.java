package web.filter;

import java.io.IOException;
import java.util.Set;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/*
@WebFilter(
		urlPatterns = "/*",
		initParams = {
				@WebInitParam(name="attrName", value ="LOGIN_USER")
		}
)
*/
public class LoginCheckFilter implements Filter{
	
	//로그인한 사용자만 접근이 허용된 요청URI를 저장하는 Set개체다
	private Set<String> urlSet = Set.of(
			"/comm/board/form.jsp",
			"/comm/board/insert",
			"/comm/board/modifyform.jsp",
			"/comm/board/modify.jsp",
			"/comm/noard/delete.jsp",
			"/comm/user/info.jsp",
			"/comm/todo/fom.jsp",
			"/comm/todo/insert.jsp",
			"/comm/file/form.jsp",
			"/comm/file.insert.jsp");
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	@Override
	public void destroy() {

	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		HttpServletResponse httpRes = (HttpServletResponse) res;
		
		// 전처리 코드 작성하는 곳 
		
		//요청 URI값을 조회한다.
		// 요청URI는 URI에서 url-path값을 반환한다.
		String requestURI = httpReq.getRequestURI();
		System.out.println("요청 URI:" + requestURI);
		
		if(urlSet.contains(requestURI)) {
			System.out.println("로그인이 필요한 요청이다");
			//로그인이 필요한요청이다.
			HttpSession session = httpReq.getSession();
			if (session.getAttribute("LOGIN_USER") !=null) {
				//filterchain.doFilter(req,res);
			}else {
				System.out.println("로그인이 안된 상태다");
				httpRes.sendRedirect("/comm/loginform.jsp?error=deny");
			}
		}else {
			// 로그인이 필요하지 않는 요청이다.
			System.out.println("로그인이 필요하지 않은 요청이다");
			filterChain.doFilter(req, res);
		}
		
		
		// 후처리 코드 작성하는 곳
	}
}
