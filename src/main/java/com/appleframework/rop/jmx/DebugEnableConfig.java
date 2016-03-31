package com.appleframework.rop.jmx;

import com.appleframework.rop.impl.DefaultRopContext;

public class DebugEnableConfig implements DebugEnableConfigMBean {

	public boolean isDebugEnable() {
		return DefaultRopContext.readDebugEnable();
	}

	public void setDebugEnable(boolean debugEnable) {
		DefaultRopContext.resetDebugEnable(debugEnable);
	}
	
}
