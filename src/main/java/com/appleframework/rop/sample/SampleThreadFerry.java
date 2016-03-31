/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-7-20
 */
package com.appleframework.rop.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appleframework.rop.ThreadFerry;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class SampleThreadFerry implements ThreadFerry{

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doInSrcThread() {
    	if(logger.isDebugEnabled()) {
    		logger.debug("doInSrcThread:"+Thread.currentThread().getId());
    	}
    }

    @Override
    public void doInDestThread() {
    	if(logger.isDebugEnabled()) {
    		logger.debug("doInSrcThread:"+Thread.currentThread().getId());
    	}
    }
}

