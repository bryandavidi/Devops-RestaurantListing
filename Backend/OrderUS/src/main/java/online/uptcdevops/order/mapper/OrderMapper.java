package online.uptcdevops.order.mapper;

import online.uptcdevops.order.dto.OrderDTO;
import online.uptcdevops.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderDTOoOrder(OrderDTO orderDTO);
    OrderDTO mapOrderToOrderDTO(Order order);
}
