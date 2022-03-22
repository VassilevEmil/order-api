package via.sdj3.rest.orderapi.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import via.sdj3.rest.orderapi.model.Order0;
import via.sdj3.rest.orderapi.repository.OrderRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class OrderController0 {

    private OrderRepository orderRepository;

    public OrderController0(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    @RequestMapping("/home")
    @ResponseBody
    public String  welcome(){
        return "welcome to the world of RESTful APIs!";
    }


    // get-ing an order given the id
    @RequestMapping(value="/orders/{id}",
                            method = RequestMethod.GET,
                            produces = {MediaType.APPLICATION_JSON_VALUE,
                            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Order0> getOrderById(@PathVariable("id")Long id){

    //return orderRepository.findById(id);
       List<Order0> oList = orderRepository.findAll();
        return oList;
    }

}
