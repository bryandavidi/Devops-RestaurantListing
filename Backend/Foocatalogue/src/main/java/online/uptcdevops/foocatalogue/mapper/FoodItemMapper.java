package online.uptcdevops.foocatalogue.mapper;


import online.uptcdevops.foocatalogue.dto.FoodItemDTO;
import online.uptcdevops.foocatalogue.entity.FoodItem;
import org.mapstruct.factory.Mappers;

public interface FoodItemMapper {

    FoodItemMapper INSTANCE= Mappers.getMapper(FoodItemMapper.class);
    FoodItem mapFoodItemDTOToFoodItem(FoodItemDTO foodItemDTO);
    FoodItemDTO mapFoodItemToFoodItemDTO(FoodItem foodItem);
}
