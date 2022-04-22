package uz.pdp.task11.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.task11.entity.Room;

public interface RoomRepository extends JpaRepository<Room,Integer> {
    Page<Room> findAllByHotel_Id(int hotel_id, Pageable pageable);
}
