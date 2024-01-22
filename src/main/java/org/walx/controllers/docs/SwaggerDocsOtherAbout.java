package org.walx.controllers.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Operation(summary = "Get about application")
@ApiResponses(value = @ApiResponse(responseCode = "200",
        description = "About application",
        content = @Content(
                mediaType = "text/plain",
                examples = @ExampleObject(value = "OpenShiftLearn application")
                )
        )
)
public @interface SwaggerDocsOtherAbout { }
