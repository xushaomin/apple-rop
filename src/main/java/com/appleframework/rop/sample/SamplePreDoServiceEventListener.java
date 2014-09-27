/**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-7-17
 */
package com.appleframework.rop.sample;

import com.appleframework.rop.MessageFormat;
import com.appleframework.rop.RopRequestContext;
import com.appleframework.rop.event.PreDoServiceEvent;
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
public class SamplePreDoServiceEventListener implements RopEventListener<PreDoServiceEvent> {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onRopEvent(PreDoServiceEvent ropEvent) {
        RopRequestContext ropRequestContext = ropEvent.getRopRequestContext();
        if(ropRequestContext != null){
            Map<String,String> allParams = ropRequestContext.getAllParams();
            String message = MessageMarshallerUtils.getMessage(allParams, MessageFormat.json);
            logger.info("message("+ropEvent.getServiceBeginTime()+")"+message);
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}

