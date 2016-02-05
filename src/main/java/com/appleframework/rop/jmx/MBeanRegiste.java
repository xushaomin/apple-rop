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
    

	public static void registe() {
		try {
			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			Hashtable<String, String> properties = new Hashtable<String, String>();

			properties.put(SignEnableConfigMBean.ROP_TYPE_KEY, SignEnableConfigMBean.ROP_DEFAULT_TYPE);
			properties.put(SignEnableConfigMBean.ROP_ID_KEY, "SignEnable");
					
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