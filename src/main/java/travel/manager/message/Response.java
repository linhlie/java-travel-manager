package travel.manager.message;

import lombok.Data;
import travel.manager.dto.OrderDetailBillDTO;
import travel.manager.model.admin.UserDto;
import travel.manager.model.home.OrdersDetails;
import travel.manager.model.home.Tour;

import java.util.List;

@Data
public class Response {

	String msg;
	private boolean status;
	private Object data;
	private UserDto userDto;
	private List<OrderDetailBillDTO> ordersDetails;

	
	public Response(){
		
	}
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
