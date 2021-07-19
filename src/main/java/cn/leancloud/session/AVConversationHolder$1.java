/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.ConversationControlPacket;
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

public class AVConversationHolder$1
extends SignatureCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ List val$members;
    public final /* synthetic */ int val$requestId;

    public AVConversationHolder$1(AVConversationHolder aVConversationHolder, int n10, List list) {
        this.this$0 = aVConversationHolder;
        this.val$requestId = n10;
        this.val$members = list;
    }

    public Signature computeSignature() {
        SignatureFactory signatureFactory = AVIMOptions.getGlobalOptions().getSignatureFactory();
        if (signatureFactory != null) {
            Object object = this.this$0;
            String string2 = ((AVConversationHolder)object).conversationId;
            object = ((AVConversationHolder)object).session.getSelfPeerId();
            List list = this.val$members;
            return signatureFactory.createConversationSignature(string2, (String)object, list, "invite");
        }
        return null;
    }

    public void onSignatureReady(Signature object, AVException object2) {
        if (object2 == null) {
            object2 = this.this$0.session.conversationOperationCache;
            int n10 = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER.getCode();
            String string2 = this.this$0.session.getSelfPeerId();
            Object object3 = this.this$0.conversationId;
            int n11 = this.val$requestId;
            Object object4 = AVIMOperationQueue$Operation.getOperation(n10, string2, (String)object3, n11);
            ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object4);
            object2 = this.this$0.session;
            object4 = ((AVSession)object2).getSelfPeerId();
            string2 = this.this$0.conversationId;
            object3 = this.val$members;
            Object var8_12 = null;
            int n12 = this.val$requestId;
            String string3 = "add";
            object = ConversationControlPacket.genConversationCommand((String)object4, string2, (List)object3, string3, null, (Signature)object, n12);
            ((AVSession)object2).sendPacket((CommandPacket)object);
        } else {
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string4 = this.this$0.session.getSelfPeerId();
            object = this.this$0;
            String string5 = ((AVConversationHolder)object).conversationId;
            int n13 = this.val$requestId;
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_ADD_MEMBER;
            operationTube.onOperationCompleted(string4, string5, n13, conversation$AVIMOperation, (Throwable)object2);
        }
    }
}

