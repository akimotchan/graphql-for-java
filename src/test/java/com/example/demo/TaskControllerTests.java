package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(TaskController.class)
public class TaskControllerTests {

	@Autowired
	private GraphQlTester graphQlTester;

	@Test
	void shouldGetTaskList() {
		this.graphQlTester
				.documentName("taskList")
				.variable("id", "task-1")
				.execute()
				.path("taskList")
				.matchesJson("""
					[
						{
							"id": "task-1",
							"name": "設計",
							"description": "GraphQLのスキーマを設計する",
							"user": {
								"id": "user-1",
								"firstName": "Aki",
								"lastName": "Masa"
							}
						},
						{
							"id": "task-2",
						    "name": "実装",
						    "description": "Javaで実装する",
						    "user": {
								"id": "user-2",
								"firstName": "あき",
								"lastName": "まさ"
						  	}
						},
						{
							"id": "task-3",
						    "name": "テスト",
						    "description": "playgroundで動作確認する",
							"user": {
								"id": "user-3",
								"firstName": "アキ",
								"lastName": "マサ"
							}
						}
					]
				""");
	}

	@Test
	void shouldGetFirstTask() {
		this.graphQlTester
				.documentName("taskDetails")
				.variable("id", "task-1")
				.execute()
				.path("taskById")
				.matchesJson("""
                    {
                        "id": "task-1",
                        "name": "設計",
                        "description": "GraphQLのスキーマを設計する",
                        "user": {
                          "firstName": "Aki",
                          "lastName": "Masa"
                        }
                    }
                """);
	}
}