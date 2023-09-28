package online.uptcdevops.order.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import online.uptcdevops.order.dto.FoodItemDTO;
import online.uptcdevops.order.dto.RestaurantDTO;
import online.uptcdevops.order.dto.UserDTO;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("Order")
public class Order
{
    private Long orderId;
    private List<FoodItemDTO> foodItemList;
    private RestaurantDTO restaurantDTO;
    private UserDTO userDTO;
}
