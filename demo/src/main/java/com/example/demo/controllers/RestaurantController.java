package com.example.demo.controllers;

import com.example.demo.models.Restaurant;
import com.example.demo.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurant(){
        return restaurantService.getAllRestaurant();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable int id){
        return restaurantService.getRestaurantById(id)
                .map(ResponseEntity :: ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant){
        return restaurantService.createRestaurant(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable int id,@RequestBody Restaurant restaurantDetails){
        try{
            return ResponseEntity.ok(restaurantService.updateRestaurant(id,restaurantDetails));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable int id){
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}
