package onlie.devopsuptc.user.service;

import onlie.devopsuptc.user.dto.UserDTO;
import onlie.devopsuptc.user.entity.User;
import onlie.devopsuptc.user.mapper.UserMapper;
import onlie.devopsuptc.user.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;

    public UserDTO addRestaurantInDB(UserDTO userDTO) {
        User savaRestaurant =
                userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUsertoUserDTO(savaRestaurant);
    }

    public ResponseEntity<UserDTO> fetchUserById(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(UserMapper.INSTANCE.mapUsertoUserDTO(user.get()),
                HttpStatus.OK);
    }

}
