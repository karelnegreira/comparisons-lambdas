package com.karelcode.test;

import com.karelcode.model.Human;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

public class TestObject {
    @Test
    public void whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human("Karel", 25));
        humanList.add(new Human("Mayre", 20));

        humanList.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
        Assert.assertThat(humanList.get(0), equalTo(new Human("Karel", 25)));
    }

    @Test
    public void givenMethodDefinition_whenSortingEntitiesByNameThenAge_thenCorrectlySorted() {
        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human("Karel", 25));
        humanList.add(new Human("Xavier", 30));
        humanList.add(new Human("Karel", 15));

        humanList.sort(Human::compareByNameThenByAge);
        Assert.assertThat(humanList.get(0), equalTo(new Human("Karel", 15)));
    }

    @Test
    public void givenInstanceMethod_whenSortingEntitiesByName_thenCorrectlySorted() {
        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human("Karel", 25));
        humanList.add(new Human("Xavier", 30));
        humanList.add(new Human("Zulema", 15));

        humanList.sort(Comparator.comparing(Human::getName));
        Assert.assertThat(humanList.get(0), equalTo(new Human("Karel", 25)));
    }

    @Test
    public void whenSortingEntitiesByNameReversed_thenCorrectlySorted() {
        List<Human> humanList = new ArrayList<Human>();
        humanList.add(new Human("Karel", 25));
        humanList.add(new Human("Xavier", 30));
        humanList.add(new Human("Zulema", 15));

        humanList.sort(Comparator.comparing(Human::getName).reversed());
        Assert.assertThat(humanList.get(0), equalTo(new Human("Zulema", 15)));
    }

}
