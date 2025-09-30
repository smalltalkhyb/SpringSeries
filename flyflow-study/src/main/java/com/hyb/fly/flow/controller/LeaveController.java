package com.hyb.fly.flow.controller;



import com.hyb.fly.flow.model.LeaveApplication;
import com.hyb.fly.flow.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.flowable.task.api.Task;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * @program: SpringSeries
 * @description:
 * @author: huyanbing
 * @create: 2025-09-29
 **/

@RestController
@RequestMapping("/api/leave")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/submit")
    public LeaveApplication submitLeave(@RequestBody LeaveApplication application) {
        return leaveService.submitLeaveApplication(application);
    }

    @GetMapping("/tasks/{group}")
    public List<Task> getGroupTasks(@PathVariable String group) {
        return leaveService.getTasksByCandidateGroup(group);
    }

    @PostMapping("/complete/{taskId}")
    public void completeTask(@PathVariable String taskId,
                             @RequestParam Boolean approved,
                             @RequestParam(required = false) String comments) {
        leaveService.completeTask(taskId, approved, comments);
    }
}