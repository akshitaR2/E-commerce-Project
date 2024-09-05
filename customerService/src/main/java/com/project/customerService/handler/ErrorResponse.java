package com.project.customerService.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
