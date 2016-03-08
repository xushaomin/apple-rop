/**
 *
 * 日    期：12-2-27
 */
package com.appleframework.rop.marshaller;

import com.appleframework.rop.RopException;
import com.appleframework.rop.RopMarshaller;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;

import java.io.IOException;
import java.io.OutputStream;

/**
 * <pre>
 *    将响应对象流化成JSON。 {@link ObjectMapper}是线程安全的。
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class JacksonJsonRopMarshaller implements RopMarshaller {
	
    private static ObjectMapper objectMapper;

	public void marshaller(Object object, OutputStream outputStream) {
        try {
            JsonGenerator jsonGenerator = getObjectMapper().getJsonFactory().createJsonGenerator(outputStream, JsonEncoding.UTF8);
            getObjectMapper().writeValue(jsonGenerator, object);
        } catch (IOException e) {
            throw new RopException(e);
        }
    }

	private ObjectMapper getObjectMapper() throws IOException {
        if (JacksonJsonRopMarshaller.objectMapper == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            AnnotationIntrospector introspector = new JaxbAnnotationIntrospector();
            objectMapper.setAnnotationIntrospector(introspector);
    		objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
    		objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    		//objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            JacksonJsonRopMarshaller.objectMapper = objectMapper;
        }
        return JacksonJsonRopMarshaller.objectMapper;
    }
}

