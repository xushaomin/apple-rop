/**
 *
 * 日    期：12-2-13
 */
package com.appleframework.rop;

/**
 * <pre>
 *   ROP的异常。
 * </pre>
 *
 * @author 陈雄华
 * @version 1.0
 */
@SuppressWarnings("serial")
public class RopException extends RuntimeException {
	
    public RopException() {
    }

    public RopException(String message) {
        super(message);
    }

    public RopException(String message, Throwable cause) {
        super(message, cause);
    }

    public RopException(Throwable cause) {
        super(cause);
    }
}

