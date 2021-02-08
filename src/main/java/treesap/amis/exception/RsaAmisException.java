package treesap.amis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class RsaAmisException extends RuntimeException {
    public RsaAmisException() {
        super();
    }
    public RsaAmisException(String message, Throwable cause) {
        super(message, cause);
    }
    public RsaAmisException(String message) {
        super(message);
    }
    public RsaAmisException(Throwable cause) {
        super(cause);
    }
}
