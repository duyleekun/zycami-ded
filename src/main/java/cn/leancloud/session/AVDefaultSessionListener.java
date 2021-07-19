/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.AVIMClient;
import cn.leancloud.im.v2.AVIMClientEventHandler;
import cn.leancloud.im.v2.AVIMMessageManagerHelper;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSession$Status;
import cn.leancloud.session.AVSessionCacheHelper;
import cn.leancloud.session.AVSessionCacheHelper$SessionTagCache;
import cn.leancloud.session.AVSessionListener;
import cn.leancloud.session.AVSessionManager;
import cn.leancloud.utils.LogUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AVDefaultSessionListener
extends AVSessionListener {
    private static final AVLogger LOGGER = LogUtil.getLogger(AVDefaultSessionListener.class);

    private void broadcastSessionStatus(AVSession object, int n10) {
        AVIMClientEventHandler aVIMClientEventHandler = AVIMMessageManagerHelper.getClientEventHandler();
        if (aVIMClientEventHandler != null) {
            object = AVIMClient.getInstance(((AVSession)object).getSelfPeerId());
            aVIMClientEventHandler.processEvent(n10, null, null, object);
        }
    }

    private void cleanSession(AVSession object) {
        Object object2 = AVSessionCacheHelper.getTagCacheInstance();
        String string2 = ((AVSession)object).getSelfPeerId();
        ((AVSessionCacheHelper$SessionTagCache)object2).removeSession(string2);
        object2 = AVSession$Status.Closed;
        ((AVSession)object).setSessionStatus((AVSession$Status)((Object)object2));
        ((AVSession)object).cleanUp();
        object2 = AVSessionManager.getInstance();
        object = ((AVSession)object).getSelfPeerId();
        ((AVSessionManager)object2).removeSession((String)object);
    }

    public void onError(AVSession aVSession, Throwable throwable, int n10, int n11) {
        AVLogger aVLogger = LOGGER;
        CharSequence charSequence = new StringBuilder();
        String string2 = "session error:";
        charSequence.append(string2);
        charSequence.append(throwable);
        charSequence = charSequence.toString();
        aVLogger.e((String)charSequence);
        int n12 = -65537;
        if (n11 > n12) {
            Conversation$AVIMOperation conversation$AVIMOperation;
            String string3;
            OperationTube operationTube;
            n12 = 10004;
            if (n10 != n12) {
                n12 = 10005;
                if (n10 == n12) {
                    operationTube = InternalConfiguration.getOperationTube();
                    string3 = aVSession.getSelfPeerId();
                    conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_DISCONNECT;
                    operationTube.onOperationCompleted(string3, null, n11, conversation$AVIMOperation, throwable);
                }
            } else {
                operationTube = InternalConfiguration.getOperationTube();
                string3 = aVSession.getSelfPeerId();
                conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_OPEN;
                operationTube.onOperationCompleted(string3, null, n11, conversation$AVIMOperation, throwable);
            }
            conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_CREATION;
            n12 = conversation$AVIMOperation.getCode();
            if (n10 == n12) {
                operationTube = InternalConfiguration.getOperationTube();
                string3 = aVSession.getSelfPeerId();
                operationTube.onOperationCompleted(string3, null, n11, conversation$AVIMOperation, throwable);
            }
        }
    }

    public void onOnlineQuery(AVSession aVSession, List object, int n10) {
        int n11 = -65537;
        if (n10 != n11) {
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList(object);
            object = "callbackOnlineClient";
            hashMap.put(object, arrayList);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string2 = aVSession.getSelfPeerId();
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_ONLINE_QUERY;
            operationTube.onOperationCompletedEx(string2, null, n10, conversation$AVIMOperation, hashMap);
        }
    }

    public void onSessionClose(AVSession aVSession, int n10) {
        AVSessionManager aVSessionManager = AVSessionManager.getInstance();
        Object object = aVSession.getSelfPeerId();
        aVSessionManager.removeSession((String)object);
        int n11 = -65537;
        if (n10 > n11) {
            object = InternalConfiguration.getOperationTube();
            String string2 = aVSession.getSelfPeerId();
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_DISCONNECT;
            object.onOperationCompleted(string2, null, n10, conversation$AVIMOperation, null);
        }
    }

    public void onSessionClosedFromServer(AVSession object, int n10) {
        this.cleanSession((AVSession)object);
        AVIMClientEventHandler aVIMClientEventHandler = AVIMMessageManagerHelper.getClientEventHandler();
        if (aVIMClientEventHandler != null) {
            int n11 = 50010;
            Integer n12 = n10;
            object = AVIMClient.getInstance(((AVSession)object).getSelfPeerId());
            aVIMClientEventHandler.processEvent(n11, null, n12, object);
        }
    }

    public void onSessionOpen(AVSession aVSession, int n10) {
        Object object = AVSessionCacheHelper.getTagCacheInstance();
        Object object2 = aVSession.getSelfPeerId();
        String string2 = aVSession.getTag();
        ((AVSessionCacheHelper$SessionTagCache)object).addSession((String)object2, string2);
        int n11 = -65537;
        if (n10 > n11) {
            object2 = InternalConfiguration.getOperationTube();
            string2 = aVSession.getSelfPeerId();
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_OPEN;
            object2.onOperationCompleted(string2, null, n10, conversation$AVIMOperation, null);
            n10 = 50011;
            this.broadcastSessionStatus(aVSession, n10);
        } else {
            AVLogger aVLogger = LOGGER;
            object = "internal session open.";
            aVLogger.d((String)object);
            this.onSessionResumed(aVSession);
        }
    }

    public void onSessionPaused(AVSession aVSession) {
        this.broadcastSessionStatus(aVSession, 50006);
    }

    public void onSessionResumed(AVSession aVSession) {
        this.broadcastSessionStatus(aVSession, 50007);
    }

    public void onSessionTokenRenewed(AVSession aVSession, int n10) {
        int n11 = -65537;
        if (n10 > n11) {
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string2 = aVSession.getSelfPeerId();
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CLIENT_REFRESH_TOKEN;
            operationTube.onOperationCompleted(string2, null, n10, conversation$AVIMOperation, null);
        }
    }
}

