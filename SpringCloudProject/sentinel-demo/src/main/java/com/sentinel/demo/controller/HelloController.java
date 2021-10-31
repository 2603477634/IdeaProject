package com.sentinel.demo.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.sentinel.demo.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class HelloController {
    private static final String RESOURCE_NAME= "hello";
    private static final String USER_RESOURCE_NAME= "user";
    private static final String DEGRADE_RESOURCE_NAME= "degrade";

    @RequestMapping("/hello")
    public String hello(){
        Entry entry = null;
            try {
                entry = SphU.entry(RESOURCE_NAME);
                String str = "hello world";
                log.info("===="+str+"====");
                return str;
            } catch (BlockException e) {
                log.info("block!");
                return "被流控了"+e;
            }catch (Exception e1){
                Tracer.traceEntry(e1,entry);
            }finally {
                if (entry!=null){
                    entry.exit();
                }
            }
            return null;
    }
    @RequestMapping("/user")
    @SentinelResource(value = USER_RESOURCE_NAME,fallback="fallbackHandlerForgetUser",blockHandler = "blockHandlerForgetUser")
    public User getUser(String id) {
        int a=1/0;
    return new User("xushu");
    }
    public User fallbackHandlerForgetUser(String id,Throwable e){
        e.printStackTrace();
        return new User("SDSDSD");
    }

    public User blockHandlerForgetUser(String id,BlockException ex){
        ex.printStackTrace();
        return new User("流控");
    }
//    @RequestMapping("/degrade")
//    @SentinelResource(value = DEGRADE_RESOURCE_NAME,blockHandler = "blockHandlerForgetDegrade")
//    public User getUser(String id) {
//        return new User("xushu");
//    }
//
//    public User blockHandlerForgetUser(String id,BlockException ex){
//        ex.printStackTrace();
//        return new User("流控");
//    }

    @PostConstruct
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule();
        rule.setResource(RESOURCE_NAME);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);

        FlowRule rule2 = new FlowRule();
        rule2.setResource(USER_RESOURCE_NAME);
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1);
        rules.add(rule2);
//
//        FlowRule rule3 = new FlowRule();
//        rule3.setResource(DEGRADE_RESOURCE_NAME);
//        rule3.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule3.setCount(1);
//        rules.add(rule3);

        FlowRuleManager.loadRules(rules);
    }

}
