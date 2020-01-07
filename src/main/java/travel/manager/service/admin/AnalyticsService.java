package travel.manager.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import travel.manager.dto.Analytics;
import travel.manager.repository.home.OrderDetailRepository;
//import travel.manager.repository.admin.AnalyticsRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AnalyticsService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public List getData(int year){
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
        for (int i=0;i<13;i++){
            System.out.println(data[i]);
        }
        List analytics = new ArrayList<>();

        analytics= Collections.singletonList(data);
        return analytics;
    }
}
