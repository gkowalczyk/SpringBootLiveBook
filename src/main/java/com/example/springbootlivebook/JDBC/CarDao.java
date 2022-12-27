package com.example.springbootlivebook.JDBC;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class CarDao { //DATA ACCESS OBJECTS

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add(Car car) {
       // String sql0 = "CREATE TABLE Car(id int, mark varchar(255), model varchar(255), color varchar(255))";
        String sql = "INSERT INTO Car VALUES(?,?,?,?)";
        //jdbcTemplate.update(sql0);

        jdbcTemplate.update(sql, new Object[] {
                car.getId(),
                car.getMark(),
                car.getModel(),
                car.getColor()
        });
    }
    public void delete() {
String sql = "DELETE FROM Car ";
        jdbcTemplate.update(sql);
        //String sql = "DELETE FROM customer_coupon WHERE coupon_id IN (SELECT company_coupon.coupon_Id FROM company_coupon WHERE company_coupon.company_id = ";
    }


    @EventListener(ApplicationReadyEvent.class)
    public void dbInit() {
        add(new Car(1L, "Fiat", "126p", "red"));
        add(new Car(2L, "Fiat", "126p", "white"));
        log.info("Saving start..............");
    }

    public List<Map<String, Object>> showByMark(String mark) {
        String sql = "SELECT * FROM Car WHERE mark LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{mark});
    }

}

