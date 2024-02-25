package com.example.eatsy_project_backend.controller;

import com.example.eatsy_project_backend.model.Order;
import com.example.eatsy_project_backend.service.OrderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")

public class OrderController {

    @Autowired
    OrderServiceInterface orderservice;


    @GetMapping("/allorders")
    public List<Order> findAllOrders() {
        return orderservice.getAllOrders();


    }

    @GetMapping("/getOrderById/{id}")
    public Order findOrderById(@PathVariable(value = "id") int orderid) {
        return orderservice.getOrderByOrderId(orderid);


    }

    @PostMapping("/addOrder")
    public Order findOrderByOrderNo(@RequestBody Order order) {
        return orderservice.addOrder(order);

    }

    @PutMapping("/updateOrder")
    public Order updateOrder(@RequestBody Order order) {
        return orderservice.updateOrder(order);
    }


    @DeleteMapping("/deleteOrderById/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderservice.deleteOrderById(id);

    }


}
