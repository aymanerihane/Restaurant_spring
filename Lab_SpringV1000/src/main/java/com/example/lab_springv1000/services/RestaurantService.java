package com.example.lab_springv1000.services;

import com.example.lab_springv1000.models.Restaurant;
import com.example.lab_springv1000.repositories.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public List<Restaurant> getAllRestaurant(){
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(int id){
        return restaurantRepository.findById(id);
    }

    public Restaurant createRestaurant(Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(int id,Restaurant restaurantDetail){
        return restaurantRepository.findById(id)
                .map(restaurant -> {
                    restaurant.setName(restaurantDetail.getName());
                    restaurant.setLatitude(restaurantDetail.getLatitude());
                    restaurant.setLongitude(restaurantDetail.getLongitude());
                    return restaurantRepository.save(restaurant);
                })
                .orElseThrow(()->new RuntimeException("Restaurant not found"));

    }

    public void deleteRestaurant(int id){
        restaurantRepository.deleteById(id);
    }
}
