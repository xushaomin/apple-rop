package com.appleframework.rop.jmx;

import com.appleframework.rop.impl.DefaultRopContext;

public class MonitorEnableConfig implements MonitorEnableConfigMBean {

	public boolean isMonitorEnable() {
		return DefaultRopContext.readMonitorEnable();
	}

	public void setMonitorEnable(boolean monitorEnable) {
		DefaultRopContext.resetMonitorEnable(monitorEnable);
	}
	
}
