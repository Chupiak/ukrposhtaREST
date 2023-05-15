package org.ukrposhtarest.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int errorCode;
    private HttpStatus status;
    private List<String> errors;
}
