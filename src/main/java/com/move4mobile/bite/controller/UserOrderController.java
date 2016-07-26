package com.move4mobile.bite.controller;

import com.move4mobile.bite.model.Order;
import com.move4mobile.bite.model.OrderProduct;
import com.move4mobile.bite.model.User;
import com.move4mobile.bite.model.UserOrder;
import com.move4mobile.bite.model.requestbody.UserOrderRequestBody;
import com.move4mobile.bite.service.BaseService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import static com.move4mobile.bite.support.Validate.notNull;

/**
 * Created by Wilco Wolters on 10/07/2016.
 */
@RestController
@RequestMapping("/orders/{order_id}/user")
public class UserOrderController {

    @Inject
    private BaseService<UserOrder> service;

    @RequestMapping(method = RequestMethod.GET)
    public UserOrder getForCurrentUser(@PathVariable("order_id") Order order, User user) {
        return getForUser(order, user);
    }

    @RequestMapping(value = "{user_id}", method = RequestMethod.GET)
    public UserOrder getForUser(@PathVariable("order_id") Order order, @PathVariable("user_id") User user) {
        notNull(user, "User");
        notNull(order, "Order");
        return user.getOrders().stream()
                .filter(userOrder -> userOrder.getOrder().equals(order) && userOrder.getUser().equals(user))
                .findAny().orElseGet(() -> new UserOrder(user, order));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public UserOrder placeForCurrentUser(@PathVariable("order_id") Order order, User user, @Valid @RequestBody UserOrderRequestBody userOrder) {
        return placeForUser(order, user, userOrder);
    }

    @RequestMapping(value = "{user_id}", method = RequestMethod.PUT)
    public UserOrder placeForUser(@PathVariable("order_id") Order order, @PathVariable("user_id") User user, @Valid @RequestBody UserOrderRequestBody userOrder) {
        UserOrder foundOrder = getForUser(order, user);
        List<OrderProduct> products = userOrder.getProducts()
                .stream()
                .map(orderProduct -> new OrderProduct(foundOrder, orderProduct.getProduct(), orderProduct.getAccessory(), orderProduct.getQuantity()))
                .collect(Collectors.toList());
        products.forEach(orderProduct -> orderProduct.setOrder(foundOrder));
        foundOrder.setProducts(products);
        return service.store(foundOrder);
    }

}
