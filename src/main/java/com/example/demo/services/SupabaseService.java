package com.example.demo.services;

import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import io.github.cdimascio.dotenv.Dotenv;
import reactor.core.publisher.Mono;

@Service
public class SupabaseService {
    private final WebClient weblClient;
    Dotenv dotenv = Dotenv.load();
    String apiKey = dotenv.get("SUPABASE_API_KEY");
    String baseUrl = dotenv.get("SUPABASE_URL");
    
    public SupabaseService() {

        this.weblClient = WebClient.builder()
                .baseUrl(baseUrl)
                .defaultHeader("apikey",apiKey)
                .defaultHeader("Authorization", "Bearer " + apiKey)
                .build();
    }
    
    public Mono<List<Map<String, Object>>> fetchData() {
        return weblClient.get()
                .uri("/restaruants?select=*")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Map<String, Object>>>() {
                    
                });
    }
}
