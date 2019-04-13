package com.ztm.messageboard.controller;

import com.ztm.messageboard.dao.MessageDao;
import com.ztm.messageboard.dao.UserDao;
import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.UserService;
import com.ztm.messageboard.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
    private MessageDao messageDao;
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
        UserDO userDO = userService.getUser(userVO.getName());
        if (userDO == null) { //用户不存在
            result.setCode(-1);
        }else if (!userDO.getPassword().equals(userVO.getPassword().toString())) { //密码错误
            result.setCode(-2);
        }else if (userDO.getUserName().equals(userVO.getName()) //管理员登陆成功
                && userDO.getPassword().equals(userVO.getPassword())
        && userDO.getType().equals(2)) {
            UserData userData = new UserData();
            userData.setId(userDO.getId());
            userData.setUserName(userDO.getUserName());
            userData.setHeadImg(userDO.getHeadImg());
            result.setCode(2);
            result.setData(userData);
        }
        else{ //普通用户登陆成功
            UserData userData = new UserData();
            userData.setId(userDO.getId());
            userData.setUserName(userDO.getUserName());
            userData.setHeadImg(userDO.getHeadImg());
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
        UserDO userDO = userService.getUser(user.getUserName());
        UserData userData = new UserData();
        userData.setId(userDO.getId());
        userData.setType(userDO.getType());
        userData.setUserName(userDO.getUserName());
        userData.setHeadImg(userDO.getHeadImg());
        List<UserDO> userDOS = userDao.getCarePerson(userDO.getId());
        Long careNum = userDOS.stream()
                .count();
        userData.setCarePersonNum(careNum);
        List<MessageDO> messageDOS =messageDao.getUserCollection(userDO.getId());
        Long collectionNum = messageDOS.stream()
                .count();
        userData.setCollectionNum(collectionNum);
        Long caredNum = messageDao.getBeCaredNum(userDO.getId());
        userData.setBeCaredNum(caredNum);
        Long praisedNum = messageDao.getPraiseNum(userDO.getId());
        userData.setPraisedNum(praisedNum);
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
        String filename = ImageUtil.add(userHead.getHeadImg(),headImagePath,"/head/",domainName);
        Result result = new Result();
        UserData userData = new UserData();
        userData.setId(userHead.getId());
        userData.setUserName(userHead.getUserName());
        userData.setHeadImg(filename);
        Integer i = userService.editUser(userData);
        if(i.equals(1)){
            result.setData(userData);
        }
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
}
