package via.sdj3.rest.orderapi.Controller;

import org.springframework.core.annotation.Order;
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
    public Order0 getOrderById(@PathVariable("id")Long id){

    return orderRepository.findById(id);
      // List<Order0> oList = orderRepository.findAll();
      //  return oList;
    }
    @RequestMapping(value = "/allorders",
            method = RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_ATOM_XML_VALUE})
    @ResponseBody
    public List<Order0> getAllOrders()
    {
        List<Order0> oList = orderRepository.findAll();
        return oList;
    }

  /*

  @PutMapping({"/orderId"})
    public Order0 updateOrder(@RequestBody Order0 orderI){
        orderRepository.update(orderRepository.update(orderI));
        return orderI;
   }
   */

    @RequestMapping(value="/orders",
            method = RequestMethod.POST,
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Order0 createOrder(@RequestBody Order0 o){

        System.out.println("[Backend - Server] Creating Order: " + o.getId());
        return orderRepository.save(o);
    }
/*
    @RequestMapping(value = "/update",
            method = RequestMethod.PUT)
    @ResponseBody
    public void updateOrders(Order0 order)
    {
        System.out.println("Update...");
        Order0 orders = new Order0(1, "Hello Hello", 12, true);
        orderRepository.update(orders);
    }

 */



}
