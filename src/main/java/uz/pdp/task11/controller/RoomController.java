package uz.pdp.task11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task11.RoomDto;
import uz.pdp.task11.entity.Hotel;
import uz.pdp.task11.entity.Room;
import uz.pdp.task11.repository.HotelRepository;
import uz.pdp.task11.repository.RoomRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    HotelRepository hotelRepository;
    @GetMapping
    public List<Room> getRoom(){
        return roomRepository.findAll();
    }
    @PostMapping
    public String addRoom(@RequestBody RoomDto roomDto){
        Optional<Hotel> optionalHotel = hotelRepository.findById(roomDto.getHotelId());
        if (optionalHotel.isPresent()){
            Room room=new Room();
            room.setFloor(roomDto.getFloor());
            room.setNumber(roomDto.getNumber());
            room.setSize(roomDto.getSize());
            room.setHotel(optionalHotel.get());
            roomRepository.save(room);
            return "Room added";
        }
        return "Hotel not found";
    }
    @GetMapping("/{hotelId}/{page}")
    public Page<Room> getRoomByHotelId(@PathVariable int hotelId,@RequestParam int page){
        Pageable pageable= PageRequest.of(page,10);
        return roomRepository.findAllByHotel_Id(hotelId, pageable);

    }
}
