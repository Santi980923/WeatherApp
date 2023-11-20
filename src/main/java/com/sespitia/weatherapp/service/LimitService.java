package com.sespitia.weatherapp.service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class LimitService {

    private final Map<String, Bucket> userBuckets = new ConcurrentHashMap<>();
    private final int apiRateLimit;

    public LimitService(@Value("${api.rate.limit}") int apiRateLimit) {
        this.apiRateLimit = apiRateLimit;
    }


    public boolean tryConsume(String username) {
        // Obtener o crear un Bucket para el usuario específico
        Bucket bucket = userBuckets.computeIfAbsent(username, k -> createNewBucket());

        // Lógica para verificar y consumir de la tasa de solicitud
        return bucket.tryConsume(1);
    }

    public Bucket createNewBucket() {
        Bandwidth limit = Bandwidth.classic(apiRateLimit, Refill.greedy(apiRateLimit, Duration.ofHours(1)));
        return Bucket.builder()
                .addLimit(limit)
                .build();
    }
}
