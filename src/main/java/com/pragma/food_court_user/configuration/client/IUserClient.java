package com.pragma.food_court_user.configuration.client;

import com.pragma.food_court_user.domain.model.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "msvc-food-court", url = "http://localhost:8090/restaurant", configuration = FeignClientProperties.FeignClientConfiguration.class)

public interface IUserClient {
    @GetMapping("/{id}")
    ResponseEntity<Restaurant> findRestaurantById(@PathVariable Long id);}

