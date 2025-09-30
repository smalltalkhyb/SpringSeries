流程说明：

提交申请：员工提交请假申请。

经理审批：经理审批申请，managers 为候选组。

排他网关：根据 approved 变量决定流程走向。

通知与记录：根据审批结果发送通知，批准后可能需员工确认记录。

3. 核心 Java 代码实现
   a. 请假申请实体 (LeaveApplication.java)



人员与组管理：示例中使用了固定的候选组 "managers"。实际项目中，你需要集成用户权限系统（如 Spring Security），并实现 flowable:candidateUsers 或 flowable:candidateGroups 的动态解析。FlyFlow 也支持远程加载审批人员 。

流程可视化与监控：FlyFlow/Flowable 通常提供管理界面（如 Flowable UI Apps  或 FlyFlow 自带的管理后台 ），用于监控运行中的流程实例、任务和历史记录。

表单集成：可以在用户任务中集成动态表单，更灵活地收集和展示数据。FlyFlow 支持丰富的低代码表单配置 。

多租户：如需多租户支持，可研究 FlyFlow 的跨租户审批功能 。


``` 提交请假申请

curl -X POST http://localhost:8080/api/leave/submit \
  -H "Content-Type: application/json" \
  -d '{
    "applicant": "zhangsan",
    "leaveType": "年假",
    "startTime": "2024-09-30T09:00:00",
    "endTime": "2024-10-08T18:00:00",
    "reason": "国庆休假"
  }'
```

```查询经理待办：
curl http://localhost:8080/api/leave/tasks/managers
```
返回的 Task 列表中包含 id。


```经理审批：
curl -X POST "http://localhost:8080/api/leave/complete/{taskId}?approved=true&comments=同意"
```


