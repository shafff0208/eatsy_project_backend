package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.Order;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OrderServiceInterface {

    public List<Order> getAllOrders();

    public Order getOrderByOrderId(int id);

    public Order addOrder(Order o);

    public Order updateOrder(Order o);

    public void deleteOrderById(int id);


}
