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

	private static final long serialVersionUID = -5175597518557160634L;
	
	private long expireTime = 86400000;
	private long createTime = System.currentTimeMillis();
	private String sessionId;
	
	@Override
	public boolean isExpire() {
		if(System.currentTimeMillis() - createTime > expireTime)
			return true;
		else
			return false;
	}	
	
	@Override
	public long getExpiresIn() {
		long expiresIn = expireTime - (System.currentTimeMillis() - createTime);
		if(expiresIn > 0)
			return expiresIn;
		else
			return 0;
	}

	public SimpleSession() {
		super();
	}
	
	public SimpleSession(long expireTime) {
		super();
		this.expireTime = expireTime;
	}

	public SimpleSession(long expireTime, String sessionId) {
		super();
		this.expireTime = expireTime;
		this.sessionId = sessionId;
	}

	@Override
	public String getSessionId() {
		return sessionId;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public long getExpireTime() {
		return expireTime;
	}

	public void setExpireTime(long expireTime) {
		this.expireTime = expireTime;
	}
	
}

