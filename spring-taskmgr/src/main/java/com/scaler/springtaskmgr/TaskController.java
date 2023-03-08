package com.scaler.springtaskmgr;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class  TaskController {


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

    /**
     * Get a task by id
     * @param id
     * @return Task object
     */
    @GetMapping("/tasks/{id}")
    Task getTask(@PathVariable("id") Integer id)
    {
        // TODO: Implement this method
        // TODO: BONUS: return 404 if task not found
        return null;
    }

    /**
     * Delete a task by given id
     * @param id
     * @return Task deleted task
     */
    @DeleteMapping("/tasks/{id}")
    Task deleteTask(@PathVariable("id") Integer id)
    {
        // TODO: Implement this method
        // TODO: BONUS: Return 404 if task not found
        return null;
    }


}
