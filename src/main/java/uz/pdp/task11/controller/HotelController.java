package uz.pdp.task11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.task11.entity.Hotel;
import uz.pdp.task11.repository.HotelRepository;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelRepository hotelRepository;
    @GetMapping
    public List<Hotel> getHotel(){
        return hotelRepository.findAll();
    }
    @PostMapping
    public String addHotel(@RequestBody Hotel hotel){
        Hotel hotel1=new Hotel();
        hotel1.setName(hotel.getName());
        hotelRepository.save(hotel1);
        return "Hotel added";
    }
}
