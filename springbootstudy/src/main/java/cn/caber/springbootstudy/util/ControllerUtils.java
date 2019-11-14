package cn.caber.springbootstudy.util;

import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author: zhaikaibo
 * @Date: 2019/9/12 15:39
 */
public class ControllerUtils {
    public static void unregisterController(String controllerBeanName){
        final RequestMappingHandlerMapping requestMappingHandlerMapping=(RequestMappingHandlerMapping) SpringUtil.getBeanByName("requestMappingHandlerMapping");
        if(requestMappingHandlerMapping!=null){
            String handler=controllerBeanName;
            Object controller = SpringUtil.getBeanByName(handler);
            if(controller==null){
                return;
            }
            final Class<?> targetClass=controller.getClass();
            ReflectionUtils.doWithMethods(targetClass, new ReflectionUtils.MethodCallback() {
                public void doWith(Method method) {
                    Method specificMethod = ClassUtils.getMostSpecificMethod(method, targetClass);
                    try {
                        Method createMappingMethod = RequestMappingHandlerMapping.class.getDeclaredMethod("getMappingForMethod", Method.class, Class.class);
                        createMappingMethod.setAccessible(true);
                        RequestMappingInfo requestMappingInfo =(RequestMappingInfo)
                                createMappingMethod.invoke(requestMappingHandlerMapping,specificMethod,targetClass);
                        if(requestMappingInfo != null) {
                            requestMappingHandlerMapping.unregisterMapping(requestMappingInfo);
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }, ReflectionUtils.USER_DECLARED_METHODS);
        }
    }



    public static void registerController(String controllerBeanName) throws Exception{
        final RequestMappingHandlerMapping requestMappingHandlerMapping = (RequestMappingHandlerMapping) SpringUtil.getBeanByName("requestMappingHandlerMapping");
        if (requestMappingHandlerMapping != null) {
            String handler = controllerBeanName;
            Object controller = SpringUtil.getBeanByName(handler);
            if (controller == null) {
                return;
            }
            unregisterController(controllerBeanName);
            //注册Controller
            Method method = requestMappingHandlerMapping.getClass().getSuperclass().getSuperclass().
                    getDeclaredMethod("detectHandlerMethods", Object.class);
            method.setAccessible(true);
            method.invoke(requestMappingHandlerMapping, handler);
        }
    }
}
