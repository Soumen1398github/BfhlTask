package com.example.bfhl.controller;

import com.example.bfhl.dto.BfhlRequest;
import com.example.bfhl.dto.BfhlResponse;
import com.example.bfhl.service.BfhlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
@CrossOrigin(origins = "*")
public class BfhlController {

    @Autowired
    private BfhlService bfhlService;

    @PostMapping
    public ResponseEntity<BfhlResponse> processBfhl(@RequestBody BfhlRequest request) {
        try {
            BfhlResponse response = bfhlService.processData(request.getData());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            BfhlResponse errorResponse = new BfhlResponse();
            errorResponse.setIs_success(false);
            return ResponseEntity.ok(errorResponse);
        }
    }

    @GetMapping
    public ResponseEntity<Object> getOperationCode() {
        return ResponseEntity.ok(new Object() {
            public final int operation_code = 1;
        });
    }
}