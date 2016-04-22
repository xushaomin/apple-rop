/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-3-1
 */
package com.appleframework.rop.security;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 *    性能监控，记录接口调用时间.
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public interface MonitorManager {

    void doMonitor(HttpServletRequest servletRequest, long time);
}

