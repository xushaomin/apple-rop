/**
 *  
 * 日    期：12-5-18
 */
package com.appleframework.rop.marshaller;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;

/**
 * <pre>
 * 功能说明：
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
public class JaxbXmlRopResponseMarshallerTest {

    @Test
    public void buildMarshaller() throws Throwable {
        JaxbXmlRopMarshaller marshaller = new JaxbXmlRopMarshaller();
        marshaller.marshaller(new SampleResponse(), new ByteArrayOutputStream(1024));
    }
}

