package com.ztm.messageboard.controller;

import com.ztm.messageboard.dao.MessageDao;
import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.UserService;
import com.ztm.messageboard.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private UserDao userDao;

    /**
     * 登录
     */
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody UserVO userVO) {
        Result result = new Result();
        UserData userData = userService.getUser(userVO.getName());
        if (userData.getUserName() == null) { //用户不存在
            result.setCode(-1);
        }else if (!userData.getPassword().equals(userVO.getPassword().toString())) { //密码错误
            result.setCode(-2);
        }else if (userData.getUserName().equals(userVO.getName()) //管理员登陆成功
                && userData.getPassword().equals(userVO.getPassword())
                && userData.getType().equals(2)) {
            result.setCode(2);
            result.setData(userData);
        }
        else{ //普通用户登陆成功
            result.setCode(1);
            result.setData(userData);
        }
        return result;
    }

    /**
     * 注册
     */
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(UserHead userHead) {
        Result result = new Result();
        UserDO userDO = new UserDO();
        userDO.setUserName(userHead.getUserName());
        userDO.setPassword(userHead.getPassword());
        if(userHead.getHeadImg() != null) {
            String filename = ImageUtil.add(userHead.getHeadImg(), headImagePath, "/head/", domainName);
            userDO.setHeadImg(filename);
        }
        result.setCode(userService.addUser(userDO));
        return result;
    }

    /**
     * 删除用户及所有相关数据
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteUserData", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteUserData(@RequestBody UserData userData) {
        Result result = new Result();
        result.setCode(userService.deleteUserData(userData.getId()));
        return result;
    }
    /**
     * 批量删除用户及所有相关数据
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteSomeUser", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteSomeUser(@RequestBody List<UserData> userDataList) {
        Result result = new Result();
        for(UserData userData : userDataList){
            userService.deleteUserData(userData.getId());
        }
        result.setCode(1);
        return result;
    }
    /**
     * 修改用户权限
     */
    @CrossOrigin
    @RequestMapping(value = "/editUserType", method = RequestMethod.POST)
    @ResponseBody
    public Result editUserType(@RequestBody UserData userData) {
        Result result = new Result();
        result.setCode(userService.editUserType(userData));
        return result;
    }
    /**
     *查询所有用户信息
     */
    @CrossOrigin
    @RequestMapping(value = "/queryAllUserData", method = RequestMethod.POST)
    @ResponseBody
    public Result queryAllUserData(){
        Result result = new Result();
        List<UserDO> userDOList = userService.queryAllUserData();
        result.setData(userDOList);
        return result;
    }

    /**
     *查询条件用户信息
     */
    @CrossOrigin
    @RequestMapping(value = "/selectUser", method = RequestMethod.POST)
    @ResponseBody
    public Result selectUser(@RequestBody UserData userData){
        Result result = new Result();
        List<UserDO> userDOList = userService.selectUser(userData);
        result.setData(userDOList);
        return result;
    }

    /**
     * 获取该用户的信息
     */
    @CrossOrigin
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public Result getUser(@RequestBody UserData user) {
        Result result = new Result();
        UserData userData = userService.getUser(user.getUserName());
        result.setData(userData);
        return result;
    }
    /**
     * 修改头像和昵称（用户名）
     */
    @CrossOrigin
    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    @ResponseBody
    public Result editUser(UserHead userHead) {
        Result result = new Result();
        UserData userData = new UserData();
        userData.setId(userHead.getId());
        if(userHead.getHeadImg() != null) {
            String filename = ImageUtil.add(userHead.getHeadImg(), headImagePath, "/head/", domainName);
            userData.setHeadImg(filename);
            UserDO userDO = userDao.queryUserById(userData.getId());
            Integer in;
            if (userHead.getUserName() == null) {
                in = userDao.editUserHeadImage(userData);
            } else {
                userData.setUserName(userHead.getUserName());
                in = userService.editUser(userData);
            }
            if (in == 1) {
                while (userDO.getHeadImg() != null){
                    ImageUtil.deleteImage(userDO.getHeadImg(), domainName);
                }
            }
            result.setCode(in);
        } else {
            userData.setUserName(userHead.getUserName());
            result.setCode(userService.editUserName(userData));
        }
        result.setData(userData);
        return result;
    }

    /**
     * 修改密码
     */
    @CrossOrigin
    @RequestMapping(value = "/editPassword", method = RequestMethod.POST)
    @ResponseBody
    public Result editPassword(@RequestBody UserVO userVO) {
        Result result = new Result();
        result.setCode(userService.editPassword(userVO));
        return result;
    }

    /**
     * 添加关注的人
     */
    @CrossOrigin
    @RequestMapping(value = "/addCare", method = RequestMethod.POST)
    @ResponseBody
    public Result addCare(@RequestBody CarePersonDO carePersonDO) {
        Result result = new Result();
        Integer num = userService.addCarePerson(carePersonDO);
        result.setCode(num);
        return result;
    }
    /**
     * 获该关注的人
     */
    @CrossOrigin
    @RequestMapping(value = "/getCare", method = RequestMethod.POST)
    @ResponseBody
    public Result getCare(@RequestBody UserData userData) {
        Result result = new Result();
        List<CarePerson> carePersonList = userService.getCarePerson(userData.getId());
        result.setData(carePersonList);
        return result;
    }

    /**
     * 取消关注
     */
    @CrossOrigin
    @RequestMapping(value = "/unfollow", method = RequestMethod.POST)
    @ResponseBody
    public Result unfollow(@RequestBody CarePersonDO carePersonDO) {
        Result result = new Result();
        Integer num = userService.unfollow(carePersonDO);
        result.setCode(num);
        return result;
    }

    /**
     * 取消收藏
     */
    @CrossOrigin
    @RequestMapping(value = "/unCollection", method = RequestMethod.POST)
    @ResponseBody
    public Result unCollection(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        Integer num = userService.unCollection(messageVO);
        result.setCode(num);
        return result;
    }
    /**
     * 取消关注增长数
     */
    @CrossOrigin
    @RequestMapping(value = "/cancelShowCared", method = RequestMethod.POST)
    @ResponseBody
    public Result cancelShowCaredAdditions(@RequestBody UserVO userVO) {
        Result result = new Result();
        Integer num = userService.unShowCared(userVO.getUserId());
        result.setCode(num);
        return result;
    }
    /**
     * 取消点赞增长数
     */
    @CrossOrigin
    @RequestMapping(value = "/cancelShowPraise", method = RequestMethod.POST)
    @ResponseBody
    public Result cancelShowPraiseAdditions(@RequestBody UserVO userVO) {
        Result result = new Result();
        Integer num = userService.unShowPraise(userVO.getUserId());
        result.setCode(num);
        return result;
    }
}
