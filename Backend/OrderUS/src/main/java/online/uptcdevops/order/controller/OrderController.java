package online.uptcdevops.order.controller;

import online.uptcdevops.order.dto.OrderDTO;
import online.uptcdevops.order.dto.OrderDTOFromFE;
import online.uptcdevops.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/saveOrder")
    public ResponseEntity<OrderDTO> saveOrder(@RequestBody OrderDTOFromFE orderDetails){
        OrderDTO orderSavedIntBD = orderService.saveOrderInDB(orderDetails);
        return new ResponseEntity<>(orderSavedIntBD, HttpStatus.CREATED);
    }
}
