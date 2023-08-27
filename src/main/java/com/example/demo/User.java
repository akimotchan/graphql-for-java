package com.example.demo;

import java.util.Arrays;
import java.util.List;

public record User(String id, String firstName, String lastName) {

    private final static List<User> users = Arrays.asList(
            new User("user-1", "Aki", "Masa"),
            new User("user-2", "あき", "まさ"),
            new User("user-3", "アキ", "マサ")
    );

    public static User getById(String id) {
        return users.stream()
				.filter(author -> author.id().equals(id))
				.findFirst()
				.orElse(null);
    }
}