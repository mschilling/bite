package com.move4mobile.bite.resolver;

import com.move4mobile.bite.model.User;
import com.move4mobile.bite.service.BaseService;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Created by Wilco Wolters on 11/07/2016.
 */
@Component
public class CurrentUserMethodHandlerArgumentResolver implements HandlerMethodArgumentResolver {

    @Inject
    private BaseService<User> userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == User.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Optional<User> foundUser = userService.find(((User)((Authentication)webRequest.getUserPrincipal()).getPrincipal()).getId());
        if (foundUser.isPresent()) {
            return foundUser.get();
        } else {
            return WebArgumentResolver.UNRESOLVED;
        }
    }
}
