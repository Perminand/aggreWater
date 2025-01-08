package ru.perminov.aggrewater.service;

import org.springframework.stereotype.Service;
import ru.perminov.aggrewater.dto.OrderDto;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public OrderDto create(OrderDto orderDto) {
        return null;
    }

    @Override
    public List<OrderDto> getAll() {
        return List.of();
    }

    @Override
    public OrderDto getById(Long id) {
        return null;
    }

    @Override
    public OrderDto update(Long id, OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto deleteById(Long id) {
        return null;
    }
}
