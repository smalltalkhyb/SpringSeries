package com.hyb.fly.flow.model;



import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


/**
 * @program: SpringSeries
 * @description:
 * @author: huyanbing
 * @create: 2025-09-29
 **/


@Data
@Entity
@Table(name = "leave_application")
public class LeaveApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicant;          // 申请人
    private String leaveType;          // 请假类型
    private LocalDateTime startTime;   // 开始时间
    private LocalDateTime endTime;     // 结束时间
    private String reason;             // 请假事由

    private String processInstanceId; // 关联的流程实例ID

    @Enumerated(EnumType.STRING)
    private LeaveStatus status;        // 审批状态

    private String currentApprover;    // 当前审批人
    private String approvalComments;   // 审批意见

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
        updateTime = LocalDateTime.now();
        status = LeaveStatus.PENDING;
    }

    @PreUpdate
    protected void onUpdate() {
        updateTime = LocalDateTime.now();
    }

    public enum LeaveStatus {
        PENDING,    // 待审批
        APPROVED,   // 已批准
        REJECTED,   // 已拒绝
        CANCELLED   // 已取消
    }
}