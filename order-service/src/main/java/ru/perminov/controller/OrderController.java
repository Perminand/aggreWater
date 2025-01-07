package ru.perminov.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.perminov.dto.OrderDto;
import ru.perminov.service.OrderService;

import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDto create(@RequestBody OrderDto orderDto) {
        log.info("Пришел POST запрос на добавление ордера. Состав: {}", orderDto);
        return orderService.create(orderDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDto> getAll() {
        log.info("Пришел GET запрос на получение всех ордеров");
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto getById(@PathVariable Long id) {
        log.info("Пришел GET запрос на получение ордера с ИД: {}", id);
        return orderService.getById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto update(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        log.info("Пришел PATCH запрос на обновление ордера с ИД: {}", id);
        return orderService.update(id, orderDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDto deleteById(@PathVariable Long id) {
        log.info("Пришел DELETE запрос на удаление ордера с ИД: {}", id);
        return orderService.deleteById(id);
    }
}
