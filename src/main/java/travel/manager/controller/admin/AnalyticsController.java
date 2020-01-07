package travel.manager.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import travel.manager.dto.Analytics;
import travel.manager.message.AjaxResponseBody;
import travel.manager.message.Response;
import travel.manager.service.admin.AnalyticsService;

import java.security.Principal;
import java.util.List;

@Controller
public class AnalyticsController {
    @Autowired
    private AnalyticsService analyticsService;

    @RequestMapping(value = { "order/revenue/{year}"}, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getRevenue(@PathVariable("year") int year) {
        Response result = new Response();
        try {
            List analytics= analyticsService.getData(year);
            result.setListMoney(analytics);
            result.setMsg("revenue");
            result.setStatus(true);
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            result.setStatus(false);
        }
        return ResponseEntity.ok(result);
    }
}
