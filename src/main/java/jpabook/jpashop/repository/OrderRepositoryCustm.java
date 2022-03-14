package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.domain.OrderSearch;
import jpabook.jpashop.domain.QOrderSearch;

import java.util.List;

public interface OrderRepositoryCustm {
    List<Order> OrderSearch(OrderSearch orderSearch);
}
