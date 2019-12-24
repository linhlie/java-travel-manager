package travel.manager.dto;

import lombok.Data;

@Data
public class UserDtoComment {
    private int id;
    private String name;
    private Long image;

    public UserDtoComment(int id, String name, Long image) {
        this.id =id;
        this.name = name;
        this.image = image;
    }
}
