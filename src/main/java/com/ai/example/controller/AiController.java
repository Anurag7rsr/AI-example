package com.ai.example.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/ai")
public class AiController {

    private final OllamaChatModel client;

    // Define the prompt text to be used
    private static final String PROMPT = "What is Java language?";

    // Inject OllamaChatModel via constructor
    @Autowired
    public AiController(OllamaChatModel client) {
        this.client = client;
    }

    // Endpoint to send the prompt to the AI model
    @GetMapping("/prompt")
    public String promptResponse(
            @RequestParam ("prompt") String prompt) {

        return client.call("prompt");
    }

}

