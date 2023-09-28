package online.uptcdevops.foocatalogue.controller;

import online.uptcdevops.foocatalogue.dto.FoodCataloguePage;
import online.uptcdevops.foocatalogue.dto.FoodItemDTO;
import online.uptcdevops.foocatalogue.service.FoodCatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/foodCatalogue")
public class FoodCatalogueController {

    @Autowired
    FoodCatalogueService foodCatalogueService;

    @PostMapping("/addFoodItem")
    public ResponseEntity<FoodItemDTO> addFoodItem (@RequestBody FoodItemDTO foodItemDTO){
        FoodItemDTO foodItemSaved = foodCatalogueService.addFoodItem(foodItemDTO);
        return new ResponseEntity<>(foodItemSaved, HttpStatus.CREATED);
    }

    @GetMapping("/fetchRestaurantAndFoodItemsById/{restaurantId}")
    public ResponseEntity<FoodCataloguePage> fetchRestaurantDetailsWithFoodMenu(
            @PathVariable Long restaurantId)
    {
    FoodCataloguePage foodCataloguePage =
        foodCatalogueService.fetchFoodCataloguePageDetails(restaurantId);
    return new ResponseEntity<>(foodCataloguePage,HttpStatus.OK);
    }
}
