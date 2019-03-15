package com.ztm.messageboard.controller;

import com.ztm.messageboard.entity.Content;
import com.ztm.messageboard.entity.MessageDO;
import com.ztm.messageboard.entity.MessageVO;
import com.ztm.messageboard.entity.Result;
import com.ztm.messageboard.service.MessageService;
import com.ztm.messageboard.utils.ImageUtil;
import com.ztm.messageboard.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

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
    public Result getAllMessage() {
        Result result = new Result();
        List<Content> contentList = messageService.getContent();
        result.setData(contentList);
        return result;
    }
    /**
     * 保存留言
     */
    @CrossOrigin
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    @ResponseBody
    public Result addMessage(@RequestBody MultipartFile image,@RequestBody String messageContent) {
        System.out.println(image);
        System.out.println("----------------");
        System.out.println(messageContent);
//        String filename = ImageUtil.add(messageVO.getImage(),messageImagePath,"/image/",domainName);
        Result result = new Result();
//        MessageDO messageDO = new MessageDO();
//        messageDO.setMessageContent(messageVO.getMessageContent());
//        messageDO.setMessageImg(filename);
//        messageDO.setUserId(messageVO.getUserId());
//        messageDO.setTime(TimeUtil.dateTOString(new Date()));
//        Integer ret = messageService.addMassage(messageDO);
//        if(ret.equals(1)){
//            result.setData(filename);
//        }
        return result;
    }

//    /**
//     * 保存留言内容
//     */
//    @CrossOrigin
//    @RequestMapping(value = "/addText", method = RequestMethod.POST)
//    @ResponseBody
//    public Result addText(@RequestBody MessageVO messageVO) {
//        Result result = new Result();
//        MessageDO messageDO = new MessageDO();
//        messageDO.setMessageContent(messageVO.getMessageContent());
//        messageDO.setUserId(messageVO.getUserId());
//        messageDO.setTime(TimeUtil.dateTOString(new Date()));
//        Integer num = messageService.addContent(messageDO);
//        if(num.equals(1)){
//            result.setMessage("ok");
//        }
//        return result;
//    }
}
