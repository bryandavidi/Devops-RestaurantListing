package online.uptcdevops.order.service;

import online.uptcdevops.order.dto.OrderDTO;
import online.uptcdevops.order.dto.OrderDTOFromFE;
import online.uptcdevops.order.dto.UserDTO;
import online.uptcdevops.order.entity.Order;
import online.uptcdevops.order.mapper.OrderMapper;
import online.uptcdevops.order.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;
    @Autowired
    SequenceGenerator sequenceGenerator;
    @Autowired
    RestTemplate restTemplate;

    public OrderDTO saveOrderInDB(OrderDTOFromFE orderDetails){
        Long newOrderID = sequenceGenerator.generatorNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());
        Order orderToBeSaved =
                new Order(newOrderID, orderDetails.getFoodItemList(), orderDetails.getRestaurantDTO(), userDTO);
        orderRepo.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderDTO(orderToBeSaved);
    }

    private UserDTO fetchUserDetailsFromUserId(Long userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
