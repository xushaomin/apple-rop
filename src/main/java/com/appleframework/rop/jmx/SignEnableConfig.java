package com.appleframework.rop.jmx;

import com.appleframework.rop.impl.DefaultRopContext;

public class SignEnableConfig implements SignEnableConfigMBean {

	public boolean isSignEnable() {
		return DefaultRopContext.readSignEnable();
	}

	public void setSignEnable(boolean signEnable) {
		DefaultRopContext.resetSignEnable(signEnable);
	}
	
	
}
