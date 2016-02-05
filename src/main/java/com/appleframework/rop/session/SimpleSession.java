/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-21
 */
package com.appleframework.rop.session;

/**
 *
 * @author 陈雄华
 * @version 1.0
 */
public class SimpleSession extends AbstractSession {

	private static final long serialVersionUID = -6905190691689485375L;

	private String id;
	private String username;
	private long time = System.currentTimeMillis();
	private String sessionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public long getGenerateTime() {
		return time;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
}
