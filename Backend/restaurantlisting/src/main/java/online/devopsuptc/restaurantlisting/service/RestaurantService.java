package online.devopsuptc.restaurantlisting.service;

import online.devopsuptc.restaurantlisting.dto.RestaurantDTO;
import online.devopsuptc.restaurantlisting.entity.Restaurant;
import online.devopsuptc.restaurantlisting.mapper.RestaurantMapper;
import online.devopsuptc.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepo.findAll();
        return restaurants.stream().
                map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).collect(Collectors.toList());
    }


    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO){
        Restaurant savaRestaurant =
                restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savaRestaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Long id){
        Optional<Restaurant> restaurant = restaurantRepo.findById(id);
        if (restaurant.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant.get()),
                HttpStatus.OK);
    }
}
