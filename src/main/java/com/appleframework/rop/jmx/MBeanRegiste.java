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
			
			//regist signEanbale
			properties.put(SignEnableConfigMBean.ROP_ID_KEY, "SignEnable");
			ObjectName signEnableName = ObjectName.getInstance("com.appleframework", properties);
			SignEnableConfigMBean signEnableBean = new SignEnableConfig();
			if (mbs.isRegistered(signEnableName)) {
				mbs.unregisterMBean(signEnableName);
			}
			mbs.registerMBean(signEnableBean, signEnableName);
			
			//regist debugEnable
			properties.put(SignEnableConfigMBean.ROP_ID_KEY, "DebugEnable");
			ObjectName debugEnableName = ObjectName.getInstance("com.appleframework", properties);
			DebugEnableConfigMBean debugEnableBean = new DebugEnableConfig();
			if (mbs.isRegistered(debugEnableName)) {
				mbs.unregisterMBean(debugEnableName);
			}
			mbs.registerMBean(debugEnableBean, debugEnableName);
			
			//regist monitorEnable
			properties.put(SignEnableConfigMBean.ROP_ID_KEY, "MonitorEnable");
			ObjectName monitorEnableName = ObjectName.getInstance("com.appleframework", properties);
			MonitorEnableConfigMBean monitorEnableBean = new MonitorEnableConfig();
			if (mbs.isRegistered(monitorEnableName)) {
				mbs.unregisterMBean(monitorEnableName);
			}
			mbs.registerMBean(monitorEnableBean, monitorEnableName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}