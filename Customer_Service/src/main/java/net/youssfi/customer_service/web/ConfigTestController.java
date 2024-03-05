package net.youssfi.customer_service.web;

import net.youssfi.customer_service.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.p1}")
    private  int p1;
    @Value("${global.params.p2}")
    private  int p2;

@Autowired
    private  GlobalConfig globalConfig;

//    public ConfigTestController(GlobalConfig globalConfig) {
//        this.globalConfig = globalConfig;
//    }


    @GetMapping("/globalconfig")
    public GlobalConfig Config(){
        return globalConfig;
    }

     @GetMapping("/testconfig")
    public Map<String,Integer> testconfig (){
        return  Map.of("p1",p1,"p2",p2);
    }




}
