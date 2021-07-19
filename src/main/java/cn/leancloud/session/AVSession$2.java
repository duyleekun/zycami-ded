/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.AVUserSignatureFactory;
import cn.leancloud.im.Signature;
import cn.leancloud.im.SignatureCallback;
import cn.leancloud.im.SignatureFactory;
import cn.leancloud.im.WindTalker;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.AVSession;
import cn.leancloud.session.AVSessionListener;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;

public class AVSession$2
extends SignatureCallback {
    public final /* synthetic */ AVSession this$0;
    public final /* synthetic */ boolean val$notifyListener;
    public final /* synthetic */ boolean val$reconnectionFlag;
    public final /* synthetic */ int val$requestId;

    public AVSession$2(AVSession aVSession, boolean bl2, int n10, boolean bl3) {
        this.this$0 = aVSession;
        this.val$notifyListener = bl2;
        this.val$requestId = n10;
        this.val$reconnectionFlag = bl3;
    }

    public Signature computeSignature() {
        String string2;
        boolean bl2;
        SignatureFactory signatureFactory = AVIMOptions.getGlobalOptions().getSignatureFactory();
        if (signatureFactory == null && !(bl2 = StringUtil.isEmpty(string2 = this.this$0.getUserSessionToken()))) {
            string2 = this.this$0.getUserSessionToken();
            signatureFactory = new AVUserSignatureFactory(string2);
        }
        if (signatureFactory != null) {
            string2 = this.this$0.getSelfPeerId();
            ArrayList arrayList = new ArrayList();
            return signatureFactory.createSignature(string2, arrayList);
        }
        return null;
    }

    public void onSignatureReady(Signature object, AVException object2) {
        if (object2 != null) {
            Object object3;
            boolean bl2 = this.val$notifyListener;
            if (bl2) {
                object = this.this$0;
                object3 = ((AVSession)object).sessionListener;
                int n10 = 10004;
                int n11 = this.val$requestId;
                ((AVSessionListener)object3).onError((AVSession)object, (Throwable)object2, n10, n11);
            }
            object = AVSession.access$000();
            object3 = "failed to generate signaure. cause:";
            ((AVLogger)object).d((String)object3, (Throwable)object2);
        } else {
            object2 = this.this$0.conversationOperationCache;
            int n12 = Conversation$AVIMOperation.CLIENT_OPEN.getCode();
            Object object4 = this.this$0.getSelfPeerId();
            boolean bl3 = false;
            int n13 = this.val$requestId;
            AVIMOperationQueue$Operation aVIMOperationQueue$Operation = AVIMOperationQueue$Operation.getOperation(n12, (String)object4, null, n13);
            ((AVIMOperationQueue)object2).offer(aVIMOperationQueue$Operation);
            object4 = WindTalker.getInstance();
            String string2 = AVSession.access$100(this.this$0);
            String string3 = this.this$0.getSelfPeerId();
            String string4 = AVSession.access$200(this.this$0);
            long l10 = this.this$0.getLastNotifyTime();
            long l11 = this.this$0.getLastPatchTime();
            boolean bl4 = this.val$reconnectionFlag;
            int n14 = this.val$requestId;
            object = ((WindTalker)object4).assembleSessionOpenPacket(string2, string3, string4, (Signature)object, l10, l11, bl4, n14);
            object2 = this.this$0.connectionManager;
            ((AVConnectionManager)object2).sendPacket((CommandPacket)object);
        }
    }
}

