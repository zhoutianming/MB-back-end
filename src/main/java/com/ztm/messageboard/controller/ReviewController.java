package com.ztm.messageboard.controller;

import com.ztm.messageboard.entity.*;
import com.ztm.messageboard.service.ReviewService;
import com.ztm.messageboard.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    /**
     * 查询所有留言的留言评论
     */
    @CrossOrigin
    @RequestMapping(value = "/getAllMessageReview", method = RequestMethod.POST)
    @ResponseBody
    public Result getAllMessageReview() {
        Result result = new Result();
        List<ReviewData> reviewDataList = reviewService.getAllMessageReview();
        result.setData(reviewDataList);
        return result;
    }
    /**
     * 条件查询留言评论
     */
    @CrossOrigin
    @RequestMapping(value = "/selectReview", method = RequestMethod.POST)
    @ResponseBody
    public Result selectReview(@RequestBody ReviewData reviewData) {
        Result result = new Result();
        List<ReviewData> reviewDataList = reviewService.selectReview(reviewData);
        if(reviewDataList == null){
            result.setCode(0);
        }
        result.setData(reviewDataList);
        return result;
    }
    /**
     * 查询该评论的所有评论
     */
    @CrossOrigin
    @RequestMapping(value = "/getRemarkReview", method = RequestMethod.POST)
    @ResponseBody
    public Result getRemarkReview(@RequestBody List<ReviewData> reviewDataList) {
        Result result = new Result();
        List<ReviewData> dataArrayList = new ArrayList<>();
        for (ReviewData reviewData : reviewDataList){
            List<ReviewData> reviewData1 = reviewService.getRemarkReview(reviewData);
            for(ReviewData reviewDa : reviewData1){
                reviewDa.setReviewedContent(reviewData.getReviewContent());
            }
            dataArrayList.addAll(reviewData1);
        }
        result.setData(dataArrayList);
        return result;
    }
    /**
     * 获取该留言的评论
     */
    @CrossOrigin
    @RequestMapping(value = "/getReview", method = RequestMethod.POST)
    @ResponseBody
    public Result getReview(@RequestBody MessageVO messageVO) {
        Result result = new Result();
        List<Review> contentList = reviewService.getMessageReview(messageVO.getMessageId());
        result.setData(contentList);
        return result;
    }

    /**
     * 添加留言的评论
     */
    @CrossOrigin
    @RequestMapping(value = "/addReview", method = RequestMethod.POST)
    @ResponseBody
    public Result addReview(@RequestBody ReviewDO reviewDO) {
        Result result = new Result();
        reviewService.addReview(reviewDO);
        result.setData(reviewDO);
        return result;
    }
    /**
     * 添加评论的评论
     */
    @CrossOrigin
    @RequestMapping(value = "/addPlusReview", method = RequestMethod.POST)
    @ResponseBody
    public Result addPlusReview(@RequestBody ReviewDO reviewDO) {
        Result result = new Result();
        reviewService.addPlusReview(reviewDO);
        result.setData(reviewDO);
        return result;
    }
    /**
     * 修改评论内容
     */
    @CrossOrigin
    @RequestMapping(value = "/editReview", method = RequestMethod.POST)
    @ResponseBody
    public Result editReview(@RequestBody ReviewData reviewData) {
        Result result = new Result();
        Integer num = reviewService.editReview(reviewData);
        if(num.equals(1)){
            result.setCode(1);
        }
        return result;
    }

    /**
     * 删除评论
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteReview", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteReview(@RequestBody ReviewData reviewData) {
        Result result = new Result();
        reviewService.deleteReview(reviewData.getReviewId());
        result.setCode(1);
        return result;
    }

    /**
     * 删除评论
     */
    @CrossOrigin
    @RequestMapping(value = "/deleteSomeReview", method = RequestMethod.POST)
    @ResponseBody
    public Result deleteSomeReview(@RequestBody List<ReviewData> reviewDataList) {
        Result result = new Result();
        for (ReviewData reviewData : reviewDataList){
            reviewService.deleteReview(reviewData.getReviewId());
        }
        result.setCode(1);
        return result;
    }
}
