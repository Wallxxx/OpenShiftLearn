package org.walx.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.walx.controllers.docs.SwaggerDocsOtherAbout;
import org.walx.services.OtherService;

@RestController
@RequestMapping(value = "/api/other")
public class OtherController {

    private final OtherService otherService;

    public OtherController(OtherService otherService) {
        this.otherService = otherService;
    }

    @SwaggerDocsOtherAbout
    @GetMapping(value = "about")
    public ResponseEntity<String> about() {
        return ResponseEntity.status(HttpStatus.OK).body(otherService.about());
    }
}
