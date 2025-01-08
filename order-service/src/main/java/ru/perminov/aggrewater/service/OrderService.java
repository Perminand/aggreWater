package ru.perminov.aggrewater.service;

import ru.perminov.aggrewater.dto.OrderDto;

import java.util.List;

public interface OrderService {
    OrderDto create(OrderDto orderDto);

    List<OrderDto> getAll();

    OrderDto getById(Long id);

    OrderDto update(Long id, OrderDto orderDto);

    OrderDto deleteById(Long id);
}
