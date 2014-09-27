/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-5
 */
package com.appleframework.rop.config;

import com.appleframework.rop.event.RopEventListener;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class RopEventListenerHodler {

	private RopEventListener ropEventListener;

    public RopEventListenerHodler(RopEventListener ropEventListener) {
        this.ropEventListener = ropEventListener;
    }

    public RopEventListener getRopEventListener() {
        return ropEventListener;
    }
}

