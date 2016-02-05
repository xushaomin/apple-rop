package com.appleframework.rop.jmx;

import java.lang.management.ManagementFactory;
import java.util.Hashtable;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.log4j.Logger;

/**
 *
 * @author Cruise.Xu
 */
public class MBeanRegiste {
        
    private static Logger logger = Logger.getLogger(MBeanRegiste.class);
    
	/* 默认的Type */
	public static final String ROP_DEFAULT_TYPE = "rop";
	/* type的key */
	public static final String ROP_TYPE_KEY = "type";
	/* name的key */
	public static final String ROP_ID_KEY = "id";

	public static void registe() {
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			Hashtable<String, String> properties = new Hashtable<String, String>();

			properties.put(ROP_TYPE_KEY, ROP_DEFAULT_TYPE);
			properties.put(ROP_ID_KEY, "signEnable");
					
			ObjectName oname = ObjectName.getInstance("com.appleframework", properties);
			
			SignEnableConfig mbean = new SignEnableConfig();

			if (mbs.isRegistered(oname)) {
				mbs.unregisterMBean(oname);
			}
			mbs.registerMBean(mbean, oname);            
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}