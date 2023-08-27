package com.example.demo;

import java.util.Arrays;
import java.util.List;

public record Task(String id, String name, String description, String userId) {

    private final static List<Task> tasks = Arrays.asList(
            new Task("task-1", "設計", "GraphQLのスキーマを設計する", "user-1"),
            new Task("task-2", "実装", "Javaで実装する", "user-2"),
            new Task("task-3", "テスト", "playgroundで動作確認する", "user-3")
    );

    public static Task getById(String id) {
        return tasks.stream()
				.filter(book -> book.id().equals(id))
				.findFirst()
				.orElse(null);
    }

    public static List<Task> getList() {
        return tasks;
    }
}
