package com.withstudy.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class PermissionInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		
		String uri = request.getRequestURI();
		logger.info("##### preHandle" + uri);
		
		
		// 세션 있는지 확인한다.
		// - 있으면: 로그인
		// - 아니면: 로그아웃
		HttpSession sesson = request.getSession();
		Integer userId = (Integer)sesson.getAttribute("userId");
		
		if(userId == null && uri.startsWith("/study")) {
			response.sendRedirect("/user/sign_in_view");
			return false;
		}
		
		if(userId == null && uri.startsWith("/user/mypage")) {
			response.sendRedirect("/user/sign_in_view");
			return false;
		}
		
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) {

		String uri = request.getRequestURI();
		logger.info("##### studyHandle" + uri);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		String uri = request.getRequestURI();
		logger.info("##### afterHandle" + uri);
		
	}
	
}
