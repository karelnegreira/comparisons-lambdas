package com.karelcode.service;

import com.karelcode.model.Human;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DbConnectionProvider {
    public List<Human> connectToDb(String query) {
        List<Human> humanList = new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test2",
                    "postgres", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                String name = resultSet.getString("name");
                int age = Integer.parseInt(resultSet.getString("age"));
                Human human = new Human(name, age);
                humanList.add(human);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return humanList;
    }

    public List<Human> sortListByAgeAsc(List<Human> listHumans) {
        listHumans.sort(Comparator.comparing(Human::getAge));
        return listHumans;
    }

    public List<Human> sortListByAgeDesc(List<Human> humanList) {
        humanList.sort(Comparator.comparing(Human::getAge).reversed());
        return humanList;
    }
}
