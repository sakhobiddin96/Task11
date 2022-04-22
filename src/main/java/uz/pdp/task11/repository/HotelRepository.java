package uz.pdp.task11.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task11.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
