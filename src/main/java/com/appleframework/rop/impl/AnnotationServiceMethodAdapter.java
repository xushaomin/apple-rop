/**
 * 日    期：12-2-11
 */
package com.appleframework.rop.impl;

import com.appleframework.rop.RopRequest;
import com.appleframework.rop.RopRequestContext;
import com.appleframework.rop.ServiceMethodAdapter;
import com.appleframework.rop.ServiceMethodHandler;
import com.appleframework.rop.response.ServiceExceptionResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * <pre>
 * 通过该服务方法适配器调用目标的服务方法
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class AnnotationServiceMethodAdapter implements ServiceMethodAdapter {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 调用ROP服务方法
	 *
	 * @param ropRequest
	 * @return
	 */
	public Object invokeServiceMethod(RopRequest ropRequest) {
		RopRequestContext ropRequestContext = ropRequest.getRopRequestContext();
		try {
			// 分析上下文中的错误
			ServiceMethodHandler serviceMethodHandler = ropRequestContext.getServiceMethodHandler();
			if (logger.isDebugEnabled()) {
				logger.debug("执行" + serviceMethodHandler.getHandler().getClass() + "."
						+ serviceMethodHandler.getHandlerMethod().getName());
			}
			if (serviceMethodHandler.isHandlerMethodWithParameter()) {
				return serviceMethodHandler.getHandlerMethod().invoke(serviceMethodHandler.getHandler(), ropRequest);
			} else {
				return serviceMethodHandler.getHandlerMethod().invoke(serviceMethodHandler.getHandler());
			}
		} catch (Throwable e) {
			if (e instanceof InvocationTargetException) {
				Class<?> serviceException = ropRequestContext.getRopContext().getServiceExceptionClass();
				InvocationTargetException inve = (InvocationTargetException) e;
				Throwable serviceThrowable = inve.getTargetException();
				if (null != serviceException) {
					if (serviceException.isAssignableFrom(serviceThrowable.getClass())) {
						return new ServiceExceptionResponse(ropRequestContext, serviceThrowable);
					} else {
						throw new RuntimeException(serviceThrowable);
					}
				} else {
					throw new RuntimeException(serviceThrowable);
				}
			} else {
				throw new RuntimeException(e);
			}
		}
	}

}
