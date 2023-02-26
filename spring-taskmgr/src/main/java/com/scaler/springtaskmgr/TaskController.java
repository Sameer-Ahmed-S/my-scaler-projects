package com.scaler.springtaskmgr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class TaskController {

    private final List<Task> taskList;
    private final AtomicInteger taskId = new AtomicInteger(0);

    public TaskController() {
        taskList = new ArrayList<>();
        for(int i=1;i<=4;i++) {
            int id = taskId.incrementAndGet();
            taskList.add(new Task(id, "Task" + id, "Description" + id, new Date()));
        }
    }

    @GetMapping("/tasks")
    public List<Task> getTaskList() {
        return taskList;
    }

    @PostMapping("/tasks")
    Task createTask(@RequestBody Task task) {

        var newTask = new Task(taskId.incrementAndGet(), task.getTitle(), task.getDescription(), task.getDueDate());
        taskList.add(newTask);
        return newTask;
    }
}
