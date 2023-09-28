package online.devopsuptc.restaurantlisting.controller;

import online.devopsuptc.restaurantlisting.dto.RestaurantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import online.devopsuptc.restaurantlisting.service.RestaurantService;

import java.util.List;

@Controller
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;
@GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants(){
    List <RestaurantDTO> allRestaurants = restaurantService.findAllRestaurants();
    return  new ResponseEntity<>(allRestaurants, HttpStatus.OK);
}

@PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> saveRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
    RestaurantDTO restaurantAdded = restaurantService.addRestaurantInDB(restaurantDTO);
    return new ResponseEntity<>(restaurantAdded, HttpStatus.CREATED);
}

@GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> findRestaurantById(@PathVariable Long id){
    return restaurantService.fetchRestaurantById(id);
}



}


