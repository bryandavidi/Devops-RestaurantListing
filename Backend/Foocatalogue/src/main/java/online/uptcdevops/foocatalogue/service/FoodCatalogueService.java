package online.uptcdevops.foocatalogue.service;

import online.uptcdevops.foocatalogue.dto.FoodCataloguePage;
import online.uptcdevops.foocatalogue.dto.FoodItemDTO;
import online.uptcdevops.foocatalogue.dto.Restaurant;
import online.uptcdevops.foocatalogue.entity.FoodItem;
import online.uptcdevops.foocatalogue.mapper.FoodItemMapper;
import online.uptcdevops.foocatalogue.repo.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class FoodCatalogueService {

    @Autowired
    FoodItemRepo foodItemRepo;


    @Autowired
    RestTemplate restTemplate;

    public FoodItemDTO addFoodItem (FoodItemDTO  foodItemDTO){
        FoodItem foodItemSaved =
            foodItemRepo.save(FoodItemMapper.INSTANCE.mapFoodItemDTOToFoodItem(foodItemDTO));
        return FoodItemMapper.INSTANCE.mapFoodItemToFoodItemDTO(foodItemSaved);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Long restaurantId){
        List<FoodItem> foodItemList = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetchRestaurantDetailsFromRestaurantMS(restaurantId);
        return createFoodCataloguePage(foodItemList, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(
            List<FoodItem> foodItemList, Restaurant restaurant
    ){
        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItemList(foodItemList);
        foodCataloguePage.setRestaurant(restaurant);
        return  foodCataloguePage;
    }

    private Restaurant fetchRestaurantDetailsFromRestaurantMS(Long restaurantID){
        return restTemplate.getForObject("http://localhost:9091/restaurant/fetchById/"+restaurantID , Restaurant.class);
    }

    private List<FoodItem> fetchFoodItemList (Long restauranId){
        return foodItemRepo.findByRestaurantId(restauranId);
    }
}
