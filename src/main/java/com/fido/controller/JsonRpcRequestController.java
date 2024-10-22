package com.fido.controller;

import com.fido.model.JsonRpcRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class JsonRpcRequestController {



    @PostMapping("/jsonrpc")
    public ResponseEntity<String> receiveJsonRpcRequest(
            @RequestHeader("Header-Login") String login,
            @RequestHeader("Header-Sign") String sign,
            @RequestHeader("Authorization") String authorization,
            @RequestBody JsonRpcRequest request) {

        // Kelayotgan ma'lumotlarni konsolda ko'rsatish
        System.out.println("Header-Login: " + login);
        System.out.println("Header-Sign: " + sign);
        System.out.println("Authorization: " + authorization);
        System.out.println("Request Body: " + request.toString());

        // Javobni qaytarish
        String responseMessage = "{\"status\":\"success\",\"message\":\"Request received successfully\"}";
        return ResponseEntity.ok(responseMessage);
    }



}
