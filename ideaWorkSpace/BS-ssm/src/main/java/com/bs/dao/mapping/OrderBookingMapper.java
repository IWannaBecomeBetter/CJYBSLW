package com.bs.dao.mapping;

import com.bs.dao.entity.OrderBooking;
import com.bs.dao.entity.OrderBookingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderBookingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int countByExample(OrderBookingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int deleteByExample(OrderBookingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int insert(OrderBooking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int insertSelective(OrderBooking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    List<OrderBooking> selectByExample(OrderBookingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    OrderBooking selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OrderBooking record, @Param("example") OrderBookingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OrderBooking record, @Param("example") OrderBookingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OrderBooking record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_booking
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OrderBooking record);
}