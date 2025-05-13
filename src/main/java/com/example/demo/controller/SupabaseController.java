package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.SupabaseService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class SupabaseController {
    private final SupabaseService supabaseService;

    public SupabaseController(SupabaseService supabaseService) {
        this.supabaseService = supabaseService;
    }

    @GetMapping("/data")
    public Mono<List<Map<String, Object>>> getData() {
        return supabaseService.fetchData();
    }
}
