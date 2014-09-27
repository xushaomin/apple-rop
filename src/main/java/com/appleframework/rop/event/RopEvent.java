/**
 * 版权声明： 版权所有 违者必究 2012
 * 日    期：12-6-2
 */
package com.appleframework.rop.event;

import com.appleframework.rop.RopContext;

import java.util.EventObject;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class RopEvent extends EventObject {

    private RopContext ropContext;

    public RopEvent(Object source, RopContext ropContext) {
        super(source);
        this.ropContext = ropContext;
    }

    public RopContext getRopContext() {
        return ropContext;
    }
}

