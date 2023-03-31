package com.yayangchun.traditionalchinesemedicinemuseum.websocket;

/**
 * 作者：崖洋春
 * 时间：2023/3/10 18:35
 *
 * @Description: websocket的具体实现类
 * 使用springboot的唯一区别是要@Component声明下，而使用独立容器是由容器自己管理websocket的，
 * 但在springboot中连容器都是spring管理的。
 * 虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，
 * 所以可以用一个静态set保存起来。
 **/

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yayangchun.traditionalchinesemedicinemuseum.enity.vo.SocketMsg;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{nickname}")
@Component
public class MyWebSocket {

    //用来记录sessionId和该session进行绑定
    private static Map<String, Session> map = new HashMap<String, Session>();

    //用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    private static Session laoZhongYi;

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private String username;


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("nickname") String nickname) {
        SocketMsg socketMsg = new SocketMsg();
        if (!"老中医".equals(nickname)) {
            this.session = session;
            this.username = nickname;
            webSocketSet.add(this);     //加入set中
            map.put(session.getId(), session);
            System.out.println("有新连接加入：" + session.getId() + "当前在线人数为" + webSocketSet.size());
            socketMsg.setPassageway(session.getId());
            this.session.getAsyncRemote().sendText(JSON.toJSONString(socketMsg));
            laoZhongYi.getAsyncRemote().sendText(JSON.toJSONString(socketMsg));
            //        this.session.getAsyncRemote().sendText("恭喜"+session.getId()+"成功连接上WebSocket(其频道号："+session.getId()+")-->当前在线人数为："+webSocketSet.size());
        } else {
            laoZhongYi = session;
            socketMsg.setLaoZonYiId(laoZhongYi.getId());
            socketMsg.setMsg("老中医连接成功");
            laoZhongYi.getAsyncRemote().sendText(JSON.toJSONString(socketMsg));
        }

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        map.remove(this.session.getId());
        System.out.println("有一连接关闭！当前在线人数为" + webSocketSet.size());
    }


    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
//        System.out.println("来自客户端的消息-->" + session.getId() + ": " + message);
//        session.getBasicRemote().sendBinary(buffer);
        if (laoZhongYi == null) {
            session.getAsyncRemote().sendText("系统消息：老中医正在休息");
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        SocketMsg socketMsg;
        try {
            socketMsg = objectMapper.readValue(message, SocketMsg.class);

                if ((session.getId()).equals(laoZhongYi.getId())) {
                    Session toSession = map.get(socketMsg.getToUser());
                    toSession.getAsyncRemote().sendText(JSON.toJSONString(socketMsg));
                } else {
                    laoZhongYi.getAsyncRemote().sendText(JSON.toJSONString(socketMsg));
                }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 群发自定义消息
     */
    public void broadcast(String message) {
        for (MyWebSocket item : webSocketSet) {
            //同步异步说明参考：http://blog.csdn.net/who_is_xiaoming/article/details/53287691
            //this.session.getBasicRemote().sendText(message);
            item.session.getAsyncRemote().sendText(message);//异步发送消息.
        }
    }
}
