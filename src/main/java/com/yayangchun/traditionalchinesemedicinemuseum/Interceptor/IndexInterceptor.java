package com.yayangchun.traditionalchinesemedicinemuseum.Interceptor;


import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.LoginUserVo;
import com.yayangchun.traditionalchinesemedicinemuseum.unit.SecurityUnit;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 作者：崖洋春
 * 时间：2023/3/7 21:50
 **/

@Component
public class IndexInterceptor implements HandlerInterceptor {

    //preHandler方法实在连接到达前进行判断,false为连接拒绝,true为连接通过
    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        System.out.println("====拦截器启动====");
        String uri = request.getRequestURI();
        System.out.println(uri);
//        Integer power = (Integer) request.getSession().getAttribute("ro");
        LoginUserVo loginInfo = SecurityUnit.getLoginInfo();
        if (loginInfo!=null){
            if (uri.startsWith("/admin")){
                if (loginInfo.getPower() != 0){
                    response.sendRedirect("/login/admin");
                    return false;
                }
            }
            return true;
        }else {
            if (uri.startsWith("/admin")){
                response.sendRedirect("/login/admin");
            }else if (uri.startsWith("/doctor")){
                response.sendRedirect("/login/doctor");
            }
        }

        System.out.println("====拦截器结束----->b=====");
        return false;
    }
    /*
    postHandler用于对拦截信息处理完毕后进行其他操作
    需要perHandler方法的返回值为true时才能执行
    通肠胃preHandler通过后,就会执行
    */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /* 需要perHandler方法的返回值为true时才能执行
    该方法主要用于清理资源等
    它将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行后,才会运行
    */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}

