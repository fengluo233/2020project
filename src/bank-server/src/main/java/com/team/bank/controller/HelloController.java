package com.team.bank.controller;

import com.team.bank.enums.ResultEnum;
import com.team.bank.model.User;
import com.team.bank.service.UserService;
import org.slf4j.ILoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @title: HelloController
 * @package com.team.bank.controller
 * @description: Controller层主要是调用Service层我们已经实现了的接口来处理业务逻辑
 * 这里要注意接口的实现类在controller层的注入问题，我折腾了半个晚上才找到原因，不然疯狂报错空指针异常
 * @author: fengluo
 * @date: 2020/6/25 2:18
 */

@CrossOrigin
@RestController
@ResponseBody
public class HelloController {
    @Resource(name = "userServerImpl")
    private  UserService userService;

    @RequestMapping(value = "/hello")
    public String index(@RequestBody User user) throws Exception {
        /**
         *@title: index
         *@author: fengluo
         *@description: 这个方法是个简单的实例，接收一个json返回个json。我们可以在这里调用我们在
         *  service中实现的方法，也建议将方法放在service中实现。我这里自动进行了错误处理，尽量还是不要这么做。
         *  推荐大家全部使用POST请求，安全性高，URL也短
         *@date: 2020/6/25 2:34
         *@param: [request]
         *@return: org.json.JSONObject
         *@throws:
         */
        ResultEnum resultEnum = userService.insertUser(user);
            return resultEnum.getMessage();
    }
}
