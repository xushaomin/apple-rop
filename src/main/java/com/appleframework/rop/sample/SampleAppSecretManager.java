package com.appleframework.rop.sample; /**
 * 版权声明：中图一购网络科技有限公司 版权所有 违者必究 2012 
 * 日    期：12-5-25
 */

import com.appleframework.rop.security.AppSecretManager;

import java.util.HashMap;
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
public class SampleAppSecretManager implements AppSecretManager {
	
    protected final Logger logger = LoggerFactory.getLogger(getClass());


    private static Map<String, String> appKeySecretMap = new HashMap<String, String>();

    static {
        appKeySecretMap.put("120390", "d23c0510bd614b64bf65580519572bee");
    }

    @Override
    public String getSecret(String appKey) {
    	logger.info("use SampleAppSecretManager!");
        return appKeySecretMap.get(appKey);
    }

    @Override
    public boolean isValidAppKey(String appKey) {
        return getSecret(appKey) != null;
    }
}

