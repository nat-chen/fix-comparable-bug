package com.github.hcsp.polymorphism;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class User implements Comparable<User> {
    /**
     * 用户ID，数据库主键，全局唯一
     */
    private final Integer id;

    /**
     * 用户名
     */
    private final String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User person = (User) o;

        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    /**
     * 老板说让我按照用户名排序
     */
    @Override
    public int compareTo(User o) {
        char thisChar = getName().toCharArray()[0];
        char thatChar = o.getName().toCharArray()[0];
        if (thisChar < thatChar) {
            return -1;
        } else if (thisChar > thatChar) {
            return 1;
        }
        if (this.getId() < o.getId()) {
            return -1;
        } else if (this.getId() > o.getId()) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        List<User> users =
                Arrays.asList(
                        new User(100, "b"),
                        new User(10, "z"),
                        new User(1, "a"),
                        new User(2000, "a"));
        TreeSet<User> treeSet = new TreeSet<>(users);
        // 为什么这里的输出是3？试着修复其中的bug
        System.out.println(treeSet.size());
    }
}
