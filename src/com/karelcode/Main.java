package com.karelcode;

import com.karelcode.model.Human;
import com.karelcode.service.DbConnectionProvider;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DbConnectionProvider connectionProvider = new DbConnectionProvider();
        List<Human> list = connectionProvider.connectToDb("select humansage.name, humansage.age from humansage ");
        System.out.println("Values unsorted from db....");
        list.stream().forEach(System.out::println);
        System.out.println("Sorting elements by age Asc******************");
        list = connectionProvider.sortListByAgeAsc(list);
        list.stream().forEach(System.out::println);
        System.out.println("Sorting elements by age Desc******************");
        list = connectionProvider.sortListByAgeDesc(list);
        list.stream().forEach(System.out::println);
    }
}
