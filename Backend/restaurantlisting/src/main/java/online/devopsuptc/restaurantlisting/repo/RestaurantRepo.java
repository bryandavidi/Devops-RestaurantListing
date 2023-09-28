package online.devopsuptc.restaurantlisting.repo;

import online.devopsuptc.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo  extends JpaRepository <Restaurant, Long> {

}
