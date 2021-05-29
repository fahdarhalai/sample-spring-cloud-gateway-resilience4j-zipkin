package dev.fahd.user.exception.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionResponse {

    private Integer status;
    private String message;
}
