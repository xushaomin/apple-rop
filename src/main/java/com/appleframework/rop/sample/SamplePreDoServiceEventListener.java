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

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
        	HttpServletRequest request = (HttpServletRequest)ropRequestContext.getRawRequestObject();
        	Map<String,String> allHeaders = this.getHeadersInfo(request);
            Map<String,String> allParams  = ropRequestContext.getAllParams();
            String header  = MessageMarshallerUtils.getMessage(allHeaders, MessageFormat.json);
            String message = MessageMarshallerUtils.getMessage(allParams,  MessageFormat.json);
            logger.info("header("+ropEvent.getServiceBeginTime()+")"+header);
            logger.info("message("+ropEvent.getServiceBeginTime()+")"+message);
        }
    }
    
	private Map<String, String> getHeadersInfo(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		Enumeration<?> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String key = (String) headerNames.nextElement();
			String value = request.getHeader(key);
			map.put(key, value);
		}
		return map;
	}

    @Override
    public int getOrder() {
        return 1;
    }
}

