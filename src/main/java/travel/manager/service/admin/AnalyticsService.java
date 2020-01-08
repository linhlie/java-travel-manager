package travel.manager.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.repository.home.OrderDetailRepository;
//import travel.manager.repository.admin.AnalyticsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public float[] getData(int year){
        List<Object[]>  objects = orderDetailRepository.findTourByYear(year);
        float data[];
         data = new float[13];

        for (Object[] objects1 : objects){
            for (int i=0;i<13;i++){
                if (Float.parseFloat(String.valueOf(objects1[0]))==i){
                    data[i]=Float.parseFloat(String.valueOf(objects1[1]));
                }
            }
        }
        List analytics = new ArrayList<>();

        return data;
    }
}
