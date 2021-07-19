/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.command.BlacklistCommandPacket;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.InternalConfiguration;
import cn.leancloud.im.OperationTube;
import cn.leancloud.im.Signature;
import cn.leancloud.im.SignatureCallback;
import cn.leancloud.im.SignatureFactory;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.session.AVConversationHolder;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.AVSession;
import java.util.List;

public class AVConversationHolder$3
extends SignatureCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ List val$members;
    public final /* synthetic */ int val$requestId;

    public AVConversationHolder$3(AVConversationHolder aVConversationHolder, int n10, List list) {
        this.this$0 = aVConversationHolder;
        this.val$requestId = n10;
        this.val$members = list;
    }

    public Signature computeSignature() {
        SignatureFactory signatureFactory = AVIMOptions.getGlobalOptions().getSignatureFactory();
        if (signatureFactory != null) {
            String string2 = this.this$0.session.getSelfPeerId();
            String string3 = this.this$0.conversationId;
            List list = this.val$members;
            return signatureFactory.createBlacklistSignature(string2, string3, list, "conversation-block-clients");
        }
        return null;
    }

    public void onSignatureReady(Signature object, AVException object2) {
        if (object2 == null) {
            object2 = this.this$0.session.conversationOperationCache;
            int n10 = Conversation$AVIMOperation.CONVERSATION_BLOCK_MEMBER.getCode();
            String string2 = this.this$0.session.getSelfPeerId();
            String string3 = this.this$0.conversationId;
            int n11 = this.val$requestId;
            Object object3 = AVIMOperationQueue$Operation.getOperation(n10, string2, string3, n11);
            ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object3);
            object2 = this.this$0.session;
            object3 = ((AVSession)object2).getSelfPeerId();
            string2 = this.this$0.conversationId;
            List list = this.val$members;
            int n12 = this.val$requestId;
            string3 = "block";
            Object object4 = object;
            object = BlacklistCommandPacket.genBlacklistCommandPacket((String)object3, string2, string3, list, (Signature)object, n12);
            ((AVSession)object2).sendPacket((CommandPacket)object);
        } else {
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string4 = this.this$0.session.getSelfPeerId();
            object = this.this$0;
            String string5 = ((AVConversationHolder)object).conversationId;
            int n13 = this.val$requestId;
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_BLOCK_MEMBER;
            operationTube.onOperationCompleted(string4, string5, n13, conversation$AVIMOperation, (Throwable)object2);
        }
    }
}

