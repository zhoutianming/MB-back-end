package com.ztm.messageboard.controller;

import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.MessageService;
import com.ztm.messageboard.utils.ImageUtil;
import com.ztm.messageboard.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/message")
public class MessageController {
    /**
     * 资源访问域名
     */
    @Value("${domain.name}")
    private String domainName;
    /**
     * 留言图片保存路径
     */
    @Value("${message.image}")
    private String messageImagePath;
    @Autowired
    private MessageService messageService;
    /**
     * 获取所有留言内容
     */
    @CrossOrigin
    @RequestMapping(value = "/getAllMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllMessage(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        List<Content> contentList = messageService.getAllContent(messageVO);
        result.setData(contentList);
        return result;
    }
    /**
     * 获取分类下所有留言内容
     */
    @CrossOrigin
    @RequestMapping(value = "/getTabAllMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result getTabAllMessage(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        List<Content> contentList = messageService.getContent(messageVO);
        result.setData(contentList);
        return result;
    }

    /**
     * 关键字搜索内容
     */
    @CrossOrigin
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ResponseBody
    public Result search(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        List<Content> contentList = messageService.searchContent(messageVO);
        result.setData(contentList);
        return result;
    }
    /**
     * 获该取用户的留言
     */
    @CrossOrigin
    @RequestMapping(value = "/getUserMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserMessage(@RequestBody UserData userData) {
        Result result = new Result();
        List<Content> contentList = messageService.getUserContent(userData.getId());
        result.setData(contentList);
        return result;
    }

    /**
     * 获该取用户收藏
     */
    @CrossOrigin
    @RequestMapping(value = "/getUserCollection", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserCollection(@RequestBody UserData userData) {
        Result result = new Result();
        List<Content> contentList = messageService.getUserCollection(userData.getId());
        result.setData(contentList);
        return result;
    }

    /**
     * 删除用户该留言
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMessage(@RequestBody MessageDO messageDO) {
        Result result = new Result();
        Integer num = messageService.deleteMessage(messageDO.getMessageId());
        if(num.equals(1)){
            result.setMessage("ok");
        }
        return result;
    }

    /**
     * 删除留言及所有相关数据
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteMessageData", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteMessageData(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        result.setCode(messageService.deleteMessageData(messageVO.getMessageId()));
        return result;
    }
    /**
     * 批量删除留言及所有相关数据
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteSomeMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteSomeMessage(@RequestBody List<MessageVO> messageVOList) {
        Result result = new Result();
        for(MessageVO messageVO : messageVOList){
            messageService.deleteMessageData(messageVO.getMessageId());
        }
        result.setCode(1);
        return result;
    }

    /**
     *条件查询用户信息
     */
    @CrossOrigin
    @RequestMapping(value = "/selectMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result selectMessage(@RequestBody MessageVO messageVO){
        Result result = new Result();
        List<Content> contentList = messageService.selectMessage(messageVO);
        if(contentList == null){
            result.setCode(0);
        }
        result.setData(contentList);
        return result;
    }
    /**
     * 保存留言
     */
    @CrossOrigin
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result addMessage(MessageVO messageVO) {
        Result result = new Result();
        MessageDO messageDO = new MessageDO();
        messageDO.setMessageContent(messageVO.getMessageContent());
        if(messageVO.getImage() != null) {
            String filename = ImageUtil.add(messageVO.getImage(), messageImagePath, "/image/", domainName);
            messageDO.setMessageImg(filename);
            messageDO.setImageWidth(messageVO.getImageWidth());
            messageDO.setImageHeight(messageVO.getImageHeight());
        }
        messageDO.setUserId(messageVO.getUserId());
        messageDO.setTime(TimeUtil.dateTOString(new Date()));
        messageDO.setMessageTabs(messageVO.getMessageTabs());
        messageService.addMessage(messageDO);
        result.setData(messageDO);
        return result;
    }

    /**
     * 修改留言
     */
    @CrossOrigin
    @RequestMapping(value = "/editMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result editMessage(MessageVO messageVO) {
        String filename = ImageUtil.add(messageVO.getImage(),messageImagePath,"/image/",domainName);
        Result result = new Result();
        MessageDO messageDO = new MessageDO();
        messageDO.setMessageId(messageVO.getMessageId());
        messageDO.setMessageContent(messageVO.getMessageContent());
        messageDO.setMessageImg(filename);
        messageDO.setImageWidth(messageVO.getImageWidth());
        messageDO.setImageHeight(messageVO.getImageHeight());
        messageDO.setUserId(messageVO.getUserId());
        Integer num = messageService.editMessage(messageDO);
        if(num.equals(1)){
            result.setCode(1);
        }
        return result;
    }

    /**
     * 修改留言文字内容
     */
    @CrossOrigin
    @RequestMapping(value = "/editMessageText", method = RequestMethod.POST)
    @ResponseBody
    public Result editMessageText(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        MessageDO messageDO = new MessageDO();
        messageDO.setMessageId(messageVO.getMessageId());
        messageDO.setMessageContent(messageVO.getMessageContent());
        Integer num = messageService.editMessageText(messageDO);
        if(num.equals(1)){
            result.setCode(1);
        }
        return result;
    }

    /**
     * 点赞
     */
    @CrossOrigin
    @RequestMapping(value = "/addPraise", method = RequestMethod.POST)
    @ResponseBody
    public Result addPraise(@RequestBody UserData userData) {
        Result result = new Result();
        Integer num = messageService.addPraise(userData);
        result.setCode(num);
        return result;
    }

    /**
     * 收藏
     */
    @CrossOrigin
    @RequestMapping(value = "/addCollection", method = RequestMethod.POST)
    @ResponseBody
    public Result addCollection(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        Integer num = messageService.addCollection(messageVO);
        result.setCode(num);
        return result;
    }

    /**
     * 增加浏览数
     */
    @CrossOrigin
    @RequestMapping(value = "/addView", method = RequestMethod.POST)
    @ResponseBody
    public Result addView(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        Integer num = messageService.addView(messageVO.getMessageId());
        if(num.equals(1)){
            result.setMessage("ok");
        }
        return result;
    }
}
