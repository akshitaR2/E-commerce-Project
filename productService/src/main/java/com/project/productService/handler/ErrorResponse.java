package com.project.productService.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}
