package uz.pdp.task11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {
    private int id;
    private int number;
    private int floor;
    private String size;
    private int hotelId;
}
