package travel.manager.repository.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import travel.manager.dto.ImageNewsDto;
import travel.manager.model.home.Image;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {

    @Query(value = "select * from tour_manager.tour_image,tour_manager.image where tour_image.image_id = image.image_id", nativeQuery = true)
    List<Image> findByTourId();

    @Query(value = "select * from image where image_id in(select image_id from tour_image where tour_id in(SELECT tour_id FROM tour_manager.tour where country=1))", nativeQuery = true)
    List<Image> findImageToursVN();

    @Query(value = "select * from tour_manager.place_image,tour_manager.image where place_image.image_id = image.image_id", nativeQuery = true)
    List<Image> findByPlaces();

    @Query(value = "select news_id,news_image.image_id,image_name,image_url from tour_manager.news_image,tour_manager.image where news_image.image_id = image.image_id;", nativeQuery = true)
    List<Object[]> findByNews();

    @Query(value = "select * from tour_manager.tour_image,tour_manager.image where tour_image.image_id = image.image_id and tour_image.tour_id = :tourId", nativeQuery = true)
    List<Image> findImageByTourId(@Param("tourId") long tourId);

    @Query(value = "select * from user,image where user.image_id = image.image_id", nativeQuery = true)
    List<Image> getImagesUsersComment();

    @Query(value = "select * from image where image_id in(select image_id from tour_image where tour_id in(SELECT tour_id FROM tour_manager.tour where country=2))", nativeQuery = true)
    List<Image> findImageToursNA();

    @Query(value = "select * from tour_manager.place_image,tour_manager.image where place_image.image_id = image.image_id and place_image.place_id = :placeId", nativeQuery = true)
    List<Image> findImageByPlaceId(@Param("placeId") int placeId);

    @Query(value = "select * from tour_manager.news_image,tour_manager.image where news_image.image_id = image.image_id and news_image.news_id =:newsId", nativeQuery = true)
    List<Image> findImageByNewsId(@Param("newsId") int newsId);

    @Query(value = "select * from tour_manager.image where image_id =:id", nativeQuery = true)
    Image findById(@Param("id") int id);

    @Query(value = "SELECT MAX(image_id) FROM image", nativeQuery = true)
    int findImageIdMax();
}
