/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVLogger;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVDefaultConnectionListener;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.RequestStormSuppression$RequestCallback;
import java.util.HashMap;

public class AVDefaultConnectionListener$1
implements RequestStormSuppression$RequestCallback {
    public final /* synthetic */ AVDefaultConnectionListener this$0;
    public final /* synthetic */ HashMap val$bundle;

    public AVDefaultConnectionListener$1(AVDefaultConnectionListener aVDefaultConnectionListener, HashMap hashMap) {
        this.this$0 = aVDefaultConnectionListener;
        this.val$bundle = hashMap;
    }

    public void done(AVIMOperationQueue$Operation aVIMOperationQueue$Operation) {
        AVLogger aVLogger = AVDefaultConnectionListener.access$000();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("[RequestSuppression] requestId=");
        int n10 = aVIMOperationQueue$Operation.requestId;
        charSequence.append(n10);
        charSequence.append(", selfId=");
        Object object = aVIMOperationQueue$Operation.sessionId;
        charSequence.append((String)object);
        charSequence.append(" completed.");
        charSequence = charSequence.toString();
        aVLogger.d((String)charSequence);
        object = InternalConfiguration.getOperationTube();
        String string2 = aVIMOperationQueue$Operation.sessionId;
        int n11 = aVIMOperationQueue$Operation.requestId;
        Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_QUERY;
        HashMap hashMap = this.val$bundle;
        object.onOperationCompletedEx(string2, null, n11, conversation$AVIMOperation, hashMap);
    }
}

