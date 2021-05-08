    //package com.msita.demo.interceptors;
    //
    //import org.springframework.stereotype.Component;
    //import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
    //
    //import javax.servlet.http.HttpServletRequest;
    //import javax.servlet.http.HttpServletResponse;
    //import javax.servlet.http.HttpSession;
    //
    //@Component
    //public class AuthorizedInterceptor extends HandlerInterceptorAdapter {
    //    @Override
    //    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    //        HttpSession session = request.getSession();
    //        Integer loginUserId = (Integer) session.getAttribute("loginUser");
    //        if (loginUserId == null) {
    //            response.sendRedirect("/login");
    //            return false;
    //        }
    //
    //        return true;
    //    }
    //
    //}