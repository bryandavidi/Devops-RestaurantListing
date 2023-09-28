package online.uptcdevops.foocatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodItemDTO {

    private Long id;
    private String itemName;
    private String itemDescription;
    private Boolean isVeg;
    private Number price;
    private Long RestaurantId;
    private Integer quantity;

}
