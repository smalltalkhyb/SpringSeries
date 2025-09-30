package com.hyb.fly.flow.componet;


import lombok.extern.slf4j.Slf4j;
import org.flowable.engine.delegate.DelegateExecution;
import org.flowable.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


/**
 * @program: SpringSeries
 * @description:
 * @author: huyanbing
 * @create: 2025-09-29
 **/
@Slf4j
@Component("sendApproveNotificationDelegate") // Bean名称与XML中class属性配置的简类名一致（首字母小写）或使用全限定名
public class SendApproveNotificationDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        // 从流程变量中获取信息
        String applicant = (String) execution.getVariable("applicant");
        // 实际应用中，这里可以集成邮件、短信、钉钉/企微/飞书消息等 :cite[1]
        log.info(">>>>>> 发送通知：员工 {} 的请假申请已批准。流程实例ID: {}", applicant, execution.getProcessInstanceId());
        // 示例：调用消息发送服务
        // notificationService.sendApproveMessage(applicant, ...);
    }
}