package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     * @param payDTO
     * @return
     */
    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return payFeignApi.addPay(payDTO);
    }
    // 删除+修改操作作为家庭作业，O(∩_∩)O。。。。。。。
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        ResultData payInfo = null;
        try {
            System.out.println("调用开始-----"+DateUtil.now());
            payInfo = payFeignApi.getPayInfo(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("调用结束-----"+DateUtil.now());
            throw new RuntimeException(e);
        }
        return payInfo;
    }



//    // 删除
//    @GetMapping("/consumer/pay/delete/{id}")
//    public ResultData deletePay(@PathVariable("id") Integer id){
//        return restTemplate.exchange(PaymentSrv_URL + "/pay/del/"+id, HttpMethod.DELETE , new HttpEntity<>(null),ResultData.class).getBody();
//    }
//
//    // 修改
//    @GetMapping("/consumer/pay/update")
//    public ResultData updatePay(PayDTO payDTO){
//        return restTemplate.exchange(PaymentSrv_URL + "/pay/update", HttpMethod.PUT , new HttpEntity<>(payDTO),ResultData.class).getBody();
//    }


}
