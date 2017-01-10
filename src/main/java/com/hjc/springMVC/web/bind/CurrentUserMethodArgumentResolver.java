package com.hjc.springMVC.web.bind;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Bravowhale on 2017/1/10.
 */
public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver{
    public boolean supportsParameter(MethodParameter methodParameter) {
        if(methodParameter.hasParameterAnnotation(CurrentUser.class))
            return true;
        return false;
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        CurrentUser currentUserAnnotation = methodParameter.getParameterAnnotation(CurrentUser.class);
        return nativeWebRequest.getAttribute(currentUserAnnotation.value(),NativeWebRequest.SCOPE_REQUEST);
    }
}
