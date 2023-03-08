package com.scaler.springtaskmgr;

import com.scaler.springtaskmgr.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
     * @param id Task id
     * @return Task object
     */
    @GetMapping("/tasks/{id}")
    Task getTask(@PathVariable("id") Integer id)
    {
         Optional<Task> task=taskList.stream().filter(t-> t.id==id).findFirst();

         if(task.isPresent())
         {
             return task.get();
         }
         else
         {
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task with id:%d not found",id));
             throw new ResourceNotFoundException(String.format("Task with id:%d not found",id));
         }
    }

    /**
     * Delete a task by given id
     * @param id Task id
     * @return Task deleted task
     */
    @DeleteMapping("/tasks/{id}")
    Task deleteTask(@PathVariable("id") Integer id)
    {

        Optional<Task> task=taskList.stream().filter(t-> t.id==id).findFirst();

        if(task.isPresent())
        {
            Task taskToBeDeleted= task.get();

            taskList.remove(taskToBeDeleted);
            return taskToBeDeleted;
        }
        else
        {
            // throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Task with id:%d not found",id));
            throw new ResourceNotFoundException(String.format("Task with id:%d not found",id));
        }

    }

    /**
     * Update a task by given id
     * @param id Task id to update
     * @param task Task object sent by client
     * @return the udpated task
     */
    Task updateTask(@PathVariable("id") Integer id,@RequestBody Task task)
    {
        // TODO: BONUS: Update the task with given id
        // Request body might have only title, description or dueData ( not necessarily all fields)
        return null;

    }

}
