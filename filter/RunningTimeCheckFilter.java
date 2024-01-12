package web.filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class RunningTimeCheckFilter implements Filter {
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChin)
			throws IOException, ServletException {
		
	
		
		
		long startUnixTime = System.currentTimeMillis();
		filterChin.doFilter(req,res);
		
		long endUnixTime =  System.currentTimeMillis();
		
		long runningTime = endUnixTime - startUnixTime;
		System.out.println("실행시간 :" + runningTime + "밀리초");		
	}
}
