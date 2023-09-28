package online.uptcdevops.order.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class OrderDTOFromFE {
    private List<FoodItemDTO> foodItemList;
    private Long UserId;
    private RestaurantDTO restaurantDTO;

}
