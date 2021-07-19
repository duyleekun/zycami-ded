/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.livequery;

import cn.leancloud.command.CommandPacket;
import cn.leancloud.im.WindTalker;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;

public class LiveQueryOperationDelegate {
    public static final String LIVEQUERY_DEFAULT_ID = "leancloud_livequery_default_id";
    private static final LiveQueryOperationDelegate instance;
    public AVIMOperationQueue operationCache;

    static {
        LiveQueryOperationDelegate liveQueryOperationDelegate;
        instance = liveQueryOperationDelegate = new LiveQueryOperationDelegate();
    }

    private LiveQueryOperationDelegate() {
        AVIMOperationQueue aVIMOperationQueue;
        this.operationCache = aVIMOperationQueue = new AVIMOperationQueue(LIVEQUERY_DEFAULT_ID);
    }

    public static LiveQueryOperationDelegate getInstance() {
        return instance;
    }

    public void ackOperationReplied(int n10) {
        this.operationCache.poll(n10);
    }

    public boolean login(String object, int n10) {
        Object object2 = this.operationCache;
        AVIMOperationQueue$Operation aVIMOperationQueue$Operation = AVIMOperationQueue$Operation.getOperation(Conversation$AVIMOperation.LIVEQUERY_LOGIN.getCode(), LIVEQUERY_DEFAULT_ID, null, n10);
        ((AVIMOperationQueue)object2).offer(aVIMOperationQueue$Operation);
        object2 = AVConnectionManager.getInstance();
        object = WindTalker.getInstance().assembleLiveQueryLoginPacket((String)object, n10);
        ((AVConnectionManager)object2).sendPacket((CommandPacket)object);
        return true;
    }
}

