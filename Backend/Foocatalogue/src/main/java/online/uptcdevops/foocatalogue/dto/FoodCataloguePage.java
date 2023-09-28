package online.uptcdevops.foocatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.uptcdevops.foocatalogue.entity.FoodItem;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FoodCataloguePage {
    private List<FoodItem> foodItemList;
    private Restaurant restaurant;
}
