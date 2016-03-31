/**
 *
 * 日    期：12-2-23
 */
package com.appleframework.rop.response;

import com.appleframework.rop.security.MainError;
import com.appleframework.rop.security.SubError;
import com.appleframework.rop.security.SubErrorType;
import com.appleframework.rop.security.SubErrors;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Locale;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "error")
public class ServiceUnavailableErrorYYYResponse extends ErrorResponse {

    private static final String ISP = "isp.";

    private static final String SERVICE_UNAVAILABLE = "-service-unavailable";

    //注意，这个不能删除，否则无法进行流化
    public ServiceUnavailableErrorYYYResponse() {
    }

    public ServiceUnavailableErrorYYYResponse(String method, Locale locale) {
        MainError mainError = SubErrors.getMainError(SubErrorType.ISP_SERVICE_UNAVAILABLE, locale);
        String errorCodeKey = ISP + transform(method) + SERVICE_UNAVAILABLE;
        SubError subError = SubErrors.getSubError(errorCodeKey,
                SubErrorType.ISP_SERVICE_UNAVAILABLE_YYY.value(),
                locale, method, null, null);
        ArrayList<SubError> subErrors = new ArrayList<SubError>();
        subErrors.add(subError);

        setMainError(mainError);
        setSubErrors(subErrors);
    }

}

