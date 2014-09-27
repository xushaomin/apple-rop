/**
 *
 * 日    期：12-2-10
 */
package com.appleframework.rop.response;

import javax.xml.bind.annotation.*;

/**
 * <pre>
 * 功能说明：
 * </pre>
 * 
 * @author 陈雄华
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "successResponse")
public class SuccessResponse {

	@XmlElement
	protected Integer result = 1;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

}
