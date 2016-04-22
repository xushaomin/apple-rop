package com.appleframework.rop.sample;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appleframework.rop.config.SystemParameterNames;
import com.appleframework.rop.security.MonitorManager;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @version 1.0
 */
public class SampleMonitorManager implements MonitorManager {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void doMonitor(HttpServletRequest servletRequest, long time) {
		String method = servletRequest.getParameter(SystemParameterNames.getMethod());
		String version = servletRequest.getParameter(SystemParameterNames.getVersion());
		long t = System.currentTimeMillis() - time;
		if (logger.isWarnEnabled()) {
			logger.warn("调用服务方法：" + method + "(" + version + "),用时：" + t + "毫秒");
		}
	}

}
