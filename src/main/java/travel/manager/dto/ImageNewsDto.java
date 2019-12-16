package travel.manager.dto;

import lombok.Data;

@Data
public class ImageNewsDto {
    private int news_id;
    private int image_id;
    private String image_name;
    private String image_url;

    public ImageNewsDto(int news_id, int image_id, String image_name, String image_url) {
        this.news_id = news_id;
        this.image_id = image_id;
        this.image_name = image_name;
        this.image_url = image_url;
    }
    public ImageNewsDto(){};
}
