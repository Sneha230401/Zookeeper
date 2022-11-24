package sneha.zookeeper.demo.util;

import sneha.zookeeper.demo.model.Person;

import java.util.ArrayList;
import java.util.List;

public final class DataStorage {

  private static List<Person> personList = new ArrayList<>();

  public static List<Person> getPersonListFromStorage() {
    return personList;
  }

  public static void setPerson(Person person) {
    personList.add(person);
  }

  private DataStorage() {}
}
