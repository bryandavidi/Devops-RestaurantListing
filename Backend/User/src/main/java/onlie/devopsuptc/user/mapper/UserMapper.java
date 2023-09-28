package onlie.devopsuptc.user.mapper;


import onlie.devopsuptc.user.dto.UserDTO;
import onlie.devopsuptc.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUserDTOToUser(UserDTO userDTO);

    UserDTO mapUsertoUserDTO(User user);

}