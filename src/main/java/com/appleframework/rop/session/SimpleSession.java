/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-21
 */
package com.appleframework.rop.session;

import com.appleframework.rop.utils.UuidUtils;

/**
 *
 * @author 陈雄华
 * @version 1.0
 */
public class SimpleSession extends AbstractSession {
	
	private static final long serialVersionUID = 1346637459785314040L;
	
	public static final String SESSION_COOKIE_NAME = "ROP_SESSION";

	public SimpleSession() {
		setId(UuidUtils.getUUID());
	}
	
}
