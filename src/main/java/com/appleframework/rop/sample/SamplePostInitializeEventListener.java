/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-6-2
 */
package com.appleframework.rop.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.appleframework.rop.event.AfterStartedRopEvent;
import com.appleframework.rop.event.RopEventListener;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class SamplePostInitializeEventListener implements RopEventListener<AfterStartedRopEvent> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onRopEvent(AfterStartedRopEvent ropRopEvent) {
    	logger.info("execute SamplePostInitializeEventListener!");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

