/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.session.AVConnectionListener;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVDefaultSessionListener;
import cn.leancloud.session.AVSession;
import cn.leancloud.utils.LogUtil;
import java.util.Collections;
import java.util.Map;

public class AVSessionManager {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVSessionManager.class);
    private static AVSessionManager instance = null;
    private final Map peerIdEnabledSessions;

    private AVSessionManager() {
        Map map = new Map();
        this.peerIdEnabledSessions = map = Collections.synchronizedMap(map);
        this.initSessionsIfExists();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AVSessionManager getInstance() {
        Object object = instance;
        if (object != null) return instance;
        object = AVSessionManager.class;
        synchronized (object) {
            AVSessionManager aVSessionManager = instance;
            if (aVSessionManager != null) return instance;
            instance = aVSessionManager = new AVSessionManager();
            return instance;
        }
    }

    private void initSessionsIfExists() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AVSession getOrCreateSession(String string2, String object, AVConnectionManager aVConnectionManager) {
        try {
            Object object2;
            Object object3 = this.peerIdEnabledSessions;
            boolean bl2 = object3.containsKey(string2) ^ true;
            if (bl2) {
                void var3_5;
                AVDefaultSessionListener aVDefaultSessionListener = new AVDefaultSessionListener();
                object3 = new AVSession((AVConnectionManager)var3_5, string2, (String)object2, aVDefaultSessionListener);
                object2 = ((AVSession)object3).getWebSocketListener();
                var3_5.subscribeConnectionListener(string2, (AVConnectionListener)object2);
                object2 = this.peerIdEnabledSessions;
                object2.put(string2, object3);
                return object3;
            }
            object2 = this.peerIdEnabledSessions;
            Object v10 = object2.get(string2);
            object3 = v10;
            return (AVSession)v10;
        }
        catch (Exception exception) {
            LOGGER.w("failed to create Session instance.", exception);
            return null;
        }
    }

    public void removeSession(String object) {
        Object object2 = this.peerIdEnabledSessions;
        if ((object = (AVSession)object2.remove(object)) != null && (object2 = ((AVSession)object).getWebSocketListener()) != null) {
            object2 = ((AVSession)object).connectionManager;
            object = ((AVSession)object).getSelfPeerId();
            ((AVConnectionManager)object2).unsubscribeConnectionListener((String)object);
        }
    }
}

