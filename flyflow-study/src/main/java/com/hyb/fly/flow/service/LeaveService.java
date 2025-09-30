package com.hyb.fly.flow.service;

import com.hyb.fly.flow.model.LeaveApplication;
import com.hyb.fly.flow.repository.LeaveRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.flowable.task.api.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: SpringSeries
 * @description:
 * @author: huyanbing
 * @create: 2025-09-29
 **/

@Slf4j
@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final RuntimeService runtimeService;
    private final TaskService taskService;

    /**
     * 提交请假申请并启动流程
     */
    @Transactional
    public LeaveApplication submitLeaveApplication(LeaveApplication application) {
        // 1. 保存业务数据
        LeaveApplication savedApp = leaveRepository.save(application);

        // 2. 设置流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("applicant", savedApp.getApplicant());
        variables.put("leaveType", savedApp.getLeaveType());
        variables.put("startTime", savedApp.getStartTime());
        variables.put("endTime", savedApp.getEndTime());
        variables.put("reason", savedApp.getReason());
        variables.put("applicationId", savedApp.getId()); // 将业务ID传入流程

        // 3. 启动流程实例
        // "leaveRequest" 是 BPMN 文件中 process 节点的 id
        var processInstance = runtimeService.startProcessInstanceByKey("leaveRequest", variables);
        savedApp.setProcessInstanceId(processInstance.getId());

        // 4. 更新业务数据，关联流程实例ID
        leaveRepository.save(savedApp);
        log.info("请假申请提交成功，流程实例ID: {}", processInstance.getId());
        return savedApp;
    }

    /**
     * 查询用户的任务 (例如，经理审批任务)
     */
    public List<Task> getTasksByCandidateGroup(String group) {
        return taskService.createTaskQuery().taskCandidateGroup(group).list();
    }

    /**
     * 完成任务 (例如，经理审批)
     */
    @Transactional
    public void completeTask(String taskId, Boolean approved, String comments) {
        Map<String, Object> taskVariables = new HashMap<>();
        taskVariables.put("approved", approved);
        taskVariables.put("comments", comments);
        // 完成任务，推动流程向下执行
        taskService.complete(taskId, taskVariables);
        log.info("任务 {} 已完成，审批结果: {}", taskId, approved ? "批准" : "拒绝");
    }

    /**
     * 根据流程实例ID查询申请
     */
    public LeaveApplication getApplicationByProcessInstanceId(String processInstanceId) {
//        return leaveRepository.findByProcessInstanceId(processInstanceId);
        return null;
    }
}