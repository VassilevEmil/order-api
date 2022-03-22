package via.sdj3.rest.orderapi.repository;

import org.springframework.stereotype.Repository;
import via.sdj3.rest.orderapi.model.Order0;

import java.util.*;


// DAO****
@Repository   // notify the Spring framework it is a Java bean

public class OrderRepository {
    // N/B will use SOLID later

    private static final Map<Long, Order0> orderMap = new HashMap<Long, Order0>();

    // assuming dot are persisted to the database


    static{
        initDataSourse();
    }

    private static void initDataSourse() {

        Order0 o1 = new Order0(1L, "Exotic sandwich for lunch", 55.00, true);
        Order0 o2 = new Order0(2L, "Pizza", 35.00, true);
        Order0 o3 = new Order0(3L, "Beef menu", 75.00, true);
        Order0 o4 = new Order0(4L, "banana", 5.00, true);
        Order0 o5 = new Order0(5L, "coffee", 10.00, true);


        orderMap.put(o1.getId(), o1);
        orderMap.put(o2.getId(), o2);
        orderMap.put(o3.getId(), o3);
        orderMap.put(o4.getId(), o4);
        orderMap.put(o5.getId(), o5);

    }

    //CRUD R-GET

    public Order0 findById(Long id){

        return orderMap.get(id);
    }

    // find all

    public List<Order0> findAll(){
        Collection<Order0> c = orderMap.values();
        List<Order0> oList = new ArrayList<Order0>();
        oList.addAll(c);
        return oList;
    }

    //Post-ing C -- create

    public Order0 save(Order0 order0){
        orderMap.put(order0.getId(), order0);
        return order0;
    }

    // Put--ting U -- update

    public Order0 update(Order0 o){
        orderMap.put(o.getId(), o);
        return o;
    }



}
