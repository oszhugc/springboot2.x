package com.oszhugc.websocket.service;

import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Service
@ServerEndpoint("/ws")
public class WebSocketServiceImpl {

    private static int onlineCount = 0;

    private static CopyOnWriteArraySet<WebSocketServiceImpl>
            webSocketSet = new CopyOnWriteArraySet<>();

    private Session session;

    @OnOpen
    public void onOpen(){
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入! 当前在线人数为: " + getOnlineCount());
        try {
            sendMsg("有新的连接加入了!!!");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(){
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一个连接关闭! 当前在线人数: " + getOnlineCount());
    }

    @OnMessage
    public void onMsg(String msg, Session session){
        System.out.println("来自客户端的消息: " + msg);
        for (WebSocketServiceImpl item:webSocketSet
             ) {
            try {
                item.sendMsg(msg);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    @OnError
    public void onError(Session session,Throwable error){
        System.out.println("发生了错误...");
        error.printStackTrace();
    }



    private void subOnlineCount() {
        WebSocketServiceImpl.onlineCount--;
    }


    private void sendMsg(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    private int getOnlineCount() {
        return onlineCount;
    }

    private void addOnlineCount() {
        WebSocketServiceImpl.onlineCount++;
    }


}
