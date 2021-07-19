/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;

public class AVIMOperationQueue$1
implements Runnable {
    public final /* synthetic */ AVIMOperationQueue this$0;
    public final /* synthetic */ AVIMOperationQueue$Operation val$op;

    public AVIMOperationQueue$1(AVIMOperationQueue aVIMOperationQueue, AVIMOperationQueue$Operation aVIMOperationQueue$Operation) {
        this.this$0 = aVIMOperationQueue;
        this.val$op = aVIMOperationQueue$Operation;
    }

    public void run() {
        Object object = this.this$0;
        Object object2 = this.val$op;
        int n10 = ((AVIMOperationQueue$Operation)object2).requestId;
        if ((object = ((AVIMOperationQueue)object).poll(n10)) != null) {
            n10 = ((AVIMOperationQueue$Operation)object).operation;
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.getAVIMOperation(n10);
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string2 = ((AVIMOperationQueue$Operation)object).sessionId;
            String string3 = ((AVIMOperationQueue$Operation)object).conversationId;
            int n11 = ((AVIMOperationQueue$Operation)object).requestId;
            int n12 = 124;
            object2 = "Timeout Exception";
            AVException aVException = new AVException(n12, (String)object2);
            operationTube.onOperationCompleted(string2, string3, n11, conversation$AVIMOperation, aVException);
        }
    }
}

