package jpabook.jpashop.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpabook.jpashop.domain.*;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static org.thymeleaf.util.StringUtils.isEmpty;

public class OrderRepositoryImpl implements OrderRepositoryCustm {

    private final JPAQueryFactory queryFactory;

    public OrderRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    QMember member = QMember.member;
    QOrder order = QOrder.order;

    @Override
    public List<Order> OrderSearch(OrderSearch orderSearch) {


        return queryFactory
                .select(order)
                .from(order)
                .join(order.member, member)
                .where(
                        nameLike(orderSearch.getMemberName()),
                        statusEq(orderSearch.getOrderStatus()))
                .limit(1000)
                .fetch();

    }

    private BooleanExpression nameLike(String nameCond) {
        if (!StringUtils.hasText(nameCond)) {
            return null;
        }
        return member.name.like(nameCond);
    }

    private BooleanExpression statusEq(OrderStatus statusCond) {
        if (statusCond == null) {
            return null;
        }
        return order.status.eq(statusCond);
    }
}
