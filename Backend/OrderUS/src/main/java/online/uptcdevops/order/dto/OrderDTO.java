package online.uptcdevops.order.dto;

import java.util.List;

public class OrderDTO {
    private List<FoodItemDTO> foodItemList;
    private Long OrderId;

    private RestaurantDTO restaurantDTO;

    private UserDTO userDTO;
}
