package com.yayangchun.traditionalchinesemedicinemuseum.enity.vo;


import lombok.Data;

/**
 * 作者：崖洋春
 * 时间：2023/3/10 18:59
 * @Description:这里我们就不能使用简单的文本消息进行消息的发送了，我们使用json进行消息的发送。
 * 所以需要先创建一个消息对象，里面包含了消息发送者，消息接受者，消息类型（单聊还是群聊），还是就是消息，如下：
 */
@Data
public class SocketMsg {
    private String laoZonYiId;  //老中医Id
    private String passageway;   //频道
    private String fromUser;//发送者.
    private String toUser;//接受者.
    private String msg;//消息
    private String img;


}