/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-21
 */
package com.appleframework.rop.session;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public abstract class AbstractSession implements Session {
	
	private static final long serialVersionUID = 2041564829722215502L;
	
	private String id;

	private long creationTime = System.currentTimeMillis();

	private int maxInactiveInterval;

	private long lastAccessedTime = System.currentTimeMillis();

	private boolean invalid = false;
	
	private boolean changed = false;
	
	private Map<String, Object> attributes = new HashMap<String, Object>();

    @Override
    public void setAttribute(String name, Object obj) {
        markChanged();
        attributes.put(name, obj);
    }

    @Override
    public Object getAttribute(String name) {
        markChanged();
        return attributes.get(name);
    }

    @Override
    public Map<String, Object> getAllAttributes() {
        return this.attributes;
    }

    @Override
    public void removeAttribute(String name) {
        markChanged();
        attributes.remove(name);
    }

    @Override
    public boolean isChanged() {
        return this.changed;
    }

    private void markChanged(){
        changed = Boolean.TRUE;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMaxInactiveInterval() {
		return maxInactiveInterval;
	}

	public void setMaxInactiveInterval(int maxInactiveInterval) {
		this.maxInactiveInterval = maxInactiveInterval;
	}

	public long getLastAccessedTime() {
		return lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	public boolean isInvalid() {
		long lastTime = System.currentTimeMillis() - creationTime;
		if(invalid && (lastTime - maxInactiveInterval) > 0)
			return true;
		else
			return false;
	}

	public void setInvalid(boolean invalid) {
		this.invalid = invalid;
	}

	public long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(long creationTime) {
		this.creationTime = creationTime;
	}
	
	/**
	 * Invalidates this session then unbinds any objects bound to it.
	 *
	 * @throws IllegalStateException if this method is called on an already invalidated session
	 */
	public void invalidate() {
		if (this.invalid) {
			throw new IllegalStateException("The session has already been invalidated");
		}

		// else
		this.invalid = true;
		clearAttributes();
	}
	
	/**
	 * Clear all of this session's attributes.
	 */
	public void clearAttributes() {
		attributes.clear();
	}

	@Override
	public void clearChanged() {
		changed = Boolean.FALSE;
	}
    
}

