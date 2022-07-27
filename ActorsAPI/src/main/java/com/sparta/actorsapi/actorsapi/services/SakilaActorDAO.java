package com.sparta.actorsapi.actorsapi.services;

import com.sparta.actorsapi.actorsapi.dataobcjects.Actor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SakilaActorDAO {

    private final DataSource dataSource;

    public SakilaActorDAO(DataSource dataSource) {
        this.dataSource = dataSource;
    }



    public Actor getActor(int id) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * from actor where actor_id=?")) {
                ps.setInt(1, id);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Actor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate("last_update"));
                    } else throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Actor getActor(String fname, String lname) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * from actor where first_name=? and last_name=?")) {
                ps.setString(1, fname);
                ps.setString(2,lname);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        return new Actor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate("last_update"));
                    } else return null;//throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Actor> getAllActors() {
        List<Actor> myActorsList = new ArrayList<>();
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps = conn.prepareStatement("SELECT * from actor ")) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        myActorsList.add(new Actor(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate("last_update")));

                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return myActorsList;
    }

    public void addActor(Actor newActor) {
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement ps =
                         conn.prepareStatement(
                                 "INSERT INTO ACTOR (actor_id, first_name, last_name)"
                                 + "VALUES (?, ?, ?)")) {
                ps.setInt(1, newActor.getActorId());
                ps.setString(2, newActor.getFirstName());
                ps.setString(3, newActor.getLastname());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

