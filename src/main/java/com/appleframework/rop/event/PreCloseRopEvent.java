/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-5
 */
package com.appleframework.rop.event;

import com.appleframework.rop.RopContext;

/**
 * <pre>
 * 功能说明：
 * </pre>
 * 
 * @author 陈雄华
 * @version 1.0
 */
@SuppressWarnings("serial")
public class PreCloseRopEvent extends RopEvent {
	
	public PreCloseRopEvent(Object source, RopContext ropContext) {
		super(source, ropContext);
	}
}
