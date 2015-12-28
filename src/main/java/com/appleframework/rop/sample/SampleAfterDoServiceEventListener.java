/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-6-2
 */
package com.appleframework.rop.sample;

import com.appleframework.rop.RopRequestContext;
import com.appleframework.rop.event.AfterDoServiceEvent;
import com.appleframework.rop.event.RopEventListener;
import com.appleframework.rop.marshaller.MessageMarshallerUtils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class SampleAfterDoServiceEventListener implements RopEventListener<AfterDoServiceEvent> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onRopEvent(AfterDoServiceEvent ropEvent) {
    	if(logger.isInfoEnabled()) {
    		RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
            if(ropRequestContext != null){
                Map<String,String> allParams = ropRequestContext.getAllParams();
                String message = MessageMarshallerUtils.asUrlString(allParams);
                logger.info("message("+ropEvent.getServiceEndTime()+")"+message);
            }
    	}
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

