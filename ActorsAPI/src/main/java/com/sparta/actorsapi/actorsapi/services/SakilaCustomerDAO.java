package com.sparta.actorsapi.actorsapi.services;

import com.sparta.actorsapi.actorsapi.dataobcjects.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SakilaCustomerDAO {

    private DataSource dataSource;

    public SakilaCustomerDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Customer getCustomer(int id) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT customer_id,first_name,last_name,email from customer where customer_id=?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    } else throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> myCustomers = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT customer_id,first_name,last_name,email from customer ")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        myCustomers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myCustomers;
    }
}
