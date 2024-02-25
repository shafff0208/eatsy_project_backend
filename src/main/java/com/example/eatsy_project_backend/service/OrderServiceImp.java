package com.example.eatsy_project_backend.service;

import com.example.eatsy_project_backend.model.Order;
import com.example.eatsy_project_backend.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class OrderServiceImp implements OrderServiceInterface {

    @Autowired
    OrderRepo orderRepo;

    public List<Order> getAllOrders() {
        List<Order> result = new ArrayList<>();
        Iterable<Order> it = orderRepo.findAll();
        it.forEach(result::add);
        return result;

    }

    public Order getOrderByOrderId(int id) {
        return orderRepo.findById(id).get();
    }

    public Order addOrder(Order o) {
        return orderRepo.save(o);

    }

    public Order updateOrder(Order o) {

        Order existingOrder = orderRepo.findByOrderNo(o.getOrderNo()).orElse(null);
        existingOrder.setOrderDate(o.getOrderDate());
        existingOrder.setOrderStatus(o.getOrderStatus());
        return orderRepo.save(existingOrder);
    }


    public void deleteOrderById(int id) {
        orderRepo.deleteById(id);
    }


}


