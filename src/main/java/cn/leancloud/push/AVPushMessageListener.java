/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.push;

import cn.leancloud.AVInstallation;
import cn.leancloud.Messages$DataCommand;
import cn.leancloud.Messages$ErrorCommand;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.Messages$JsonObjectMessage;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.im.WindTalker;
import cn.leancloud.push.AVNotificationManager;
import cn.leancloud.push.DummyNotificationManager;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.session.AVConnectionManager;
import java.util.List;

public class AVPushMessageListener
implements AVConnectionListener {
    public static final String DEFAULT_ID = "leancloud_push_default_id";
    private static final AVPushMessageListener instance;
    private AVNotificationManager notificationManager;

    static {
        AVPushMessageListener aVPushMessageListener;
        instance = aVPushMessageListener = new AVPushMessageListener();
    }

    private AVPushMessageListener() {
        DummyNotificationManager dummyNotificationManager = new DummyNotificationManager();
        this.notificationManager = dummyNotificationManager;
    }

    public static AVPushMessageListener getInstance() {
        return instance;
    }

    public AVNotificationManager getNotificationManager() {
        return this.notificationManager;
    }

    public void onError(Integer n10, Messages$ErrorCommand messages$ErrorCommand) {
    }

    public void onMessageArriving(String object, Integer object2, Messages$GenericCommand object3) {
        if (object3 != null && (object = ((Messages$GenericCommand)object3).getDataMessage()) != null) {
            int n10;
            object = ((Messages$GenericCommand)object3).getDataMessage();
            object2 = ((Messages$DataCommand)object).getIdsList();
            object = ((Messages$DataCommand)object).getMsgList();
            object3 = null;
            for (int i10 = 0; i10 < (n10 = object.size()) && i10 < (n10 = object2.size()); ++i10) {
                Object object4 = object.get(i10);
                if (object4 == null) continue;
                object4 = this.notificationManager;
                String string2 = ((Messages$JsonObjectMessage)object.get(i10)).getData();
                String string3 = (String)object2.get(i10);
                ((AVNotificationManager)object4).processPushMessage(string2, string3);
            }
            object = WindTalker.getInstance();
            object3 = AVInstallation.getCurrentInstallation().getInstallationId();
            object = ((WindTalker)object).assemblePushAckPacket((String)object3, (List)object2);
            object2 = AVConnectionManager.getInstance();
            ((AVConnectionManager)object2).sendPacket((CommandPacket)object);
        }
    }

    public void onWebSocketClose() {
    }

    public void onWebSocketOpen() {
    }

    public void setNotificationManager(AVNotificationManager aVNotificationManager) {
        this.notificationManager = aVNotificationManager;
    }
}

