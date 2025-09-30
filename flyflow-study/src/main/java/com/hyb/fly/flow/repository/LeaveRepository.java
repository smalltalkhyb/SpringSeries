package com.hyb.fly.flow.repository;


import com.hyb.fly.flow.model.LeaveApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @program: SpringSeries
 * @description:
 * @author: huyanbing
 * @create: 2025-09-29
 **/
public interface LeaveRepository extends JpaRepository<LeaveApplication, Long> {

    List<LeaveApplication> findByCurrentApproverAndStatus(
            String currentApprover, LeaveApplication.LeaveStatus status);

    List<LeaveApplication> findByApplicantOrderByCreateTimeDesc(String applicant);
}