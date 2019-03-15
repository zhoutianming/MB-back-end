package com.ztm.messageboard.controller;

import com.ztm.messageboard.entity.Result;
import com.ztm.messageboard.entity.UserDO;
import com.ztm.messageboard.entity.UserVO;
import com.ztm.messageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    /**
     * 资源访问域名
     */
    @Value("${domain.name}")
    private String domainName;
    /**
     * 头像保存路径
     */
    @Value("${head.image}")
    private String headImagePath;

    @Autowired
    private UserService userService;
//    @Autowired
//    private ImageService imageService;
    /**
     * 登录
     */
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody UserVO userVO) {
        Result result = new Result();
        UserDO userDO = userService.getUser(userVO.getName());
        if (userDO == null) { //用户不存在
            result.setCode(-1);
        }else if (!userDO.getPassword().equals(userVO.getPassword().toString())) { //密码错误
            result.setCode(-2);
        }else if (userDO.getUserName().equals(userVO.getName()) //管理员登陆成功
                && userDO.getPassword().equals(userVO.getPassword())
        && userDO.getType().equals(2)) {
            result.setCode(2);
            result.setData(userDO);
        }
        else{ //普通用户登陆成功
            result.setCode(1);
            result.setData(userDO);
        }
        return result;
    }

    /**
     * 注册
     */
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody UserVO userVO) {
        Result result = new Result();
        UserDO userDO = new UserDO();
        userDO.setUserName(userVO.getName());
        userDO.setPassword(userVO.getPassword());
        Integer number = userService.addUser(userDO);
        if(number.equals(1)){
            result.setMessage("ok");
        }
        return result;
    }

//    /**
//     * 保存上传头像
//     */
//    @CrossOrigin
//    @RequestMapping(value = "/addHeadImage", method = RequestMethod.POST)
//    @ResponseBody
//    public Result addHeadImage(@RequestBody MultipartFile image) {
//        Result result = new Result();
//        String filename = ImageUtil.add(image,headImagePath,"/head/",domainName);
//        Integer ret = imageService.addMassageImage(filename);
//        if(ret.equals(1)){
//            result.setData(filename);
//        }
//        return result;
//    }
}
