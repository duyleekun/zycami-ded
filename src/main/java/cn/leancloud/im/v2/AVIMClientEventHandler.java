/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2;

import cn.leancloud.AVLogger;
import cn.leancloud.im.AVIMEventHandler;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.utils.LogUtil;

public abstract class AVIMClientEventHandler
extends AVIMEventHandler {
    public static final AVLogger LOGGER = LogUtil.getLogger(AVIMClientEventHandler.class);
    private int prevOperation;

    public AVIMClientEventHandler() {
        int n10;
        this.prevOperation = n10 = Conversation$AVIMOperation.CONVERSATION_UNKNOWN.getCode();
    }

    public abstract void onClientOffline(AVIMClient var1, int var2);

    public abstract void onConnectionPaused(AVIMClient var1);

    public abstract void onConnectionResume(AVIMClient var1);

    public final void processEvent0(int n10, Object object, Object object2, Object object3) {
        int n11 = this.prevOperation;
        if (n11 == n10) {
            object = LOGGER;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("ignore duplicated operation: ");
            ((StringBuilder)object2).append(n10);
            String string2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).d(string2);
            return;
        }
        this.prevOperation = n10;
        switch (n10) {
            default: {
                AVLogger aVLogger = LOGGER;
                object = new StringBuilder();
                object3 = "ignore operation:";
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(object2);
                object = ((StringBuilder)object).toString();
                aVLogger.d((String)object);
                break;
            }
            case 50010: {
                object3 = (AVIMClient)object3;
                object2 = (Integer)object2;
                n10 = (Integer)object2;
                this.onClientOffline((AVIMClient)object3, n10);
                n10 = 0;
                Object var6_8 = null;
                ((AVIMClient)object3).close(null);
                break;
            }
            case 50007: {
                object3 = (AVIMClient)object3;
                this.onConnectionResume((AVIMClient)object3);
                break;
            }
            case 50006: {
                object3 = (AVIMClient)object3;
                this.onConnectionPaused((AVIMClient)object3);
            }
        }
    }
}

