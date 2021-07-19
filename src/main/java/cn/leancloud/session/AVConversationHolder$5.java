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
import java.util.Arrays;
import java.util.List;

public class AVConversationHolder$5
extends SignatureCallback {
    public final /* synthetic */ AVConversationHolder this$0;
    public final /* synthetic */ int val$requestId;

    public AVConversationHolder$5(AVConversationHolder aVConversationHolder, int n10) {
        this.this$0 = aVConversationHolder;
        this.val$requestId = n10;
    }

    public Signature computeSignature() {
        SignatureFactory signatureFactory = AVIMOptions.getGlobalOptions().getSignatureFactory();
        if (signatureFactory != null) {
            Object object = this.this$0;
            String string2 = ((AVConversationHolder)object).conversationId;
            object = ((AVConversationHolder)object).session.getSelfPeerId();
            String string3 = this.this$0.session.getSelfPeerId();
            Object object2 = new String[]{string3};
            object2 = Arrays.asList(object2);
            return signatureFactory.createConversationSignature(string2, (String)object, (List)object2, "invite");
        }
        return null;
    }

    public void onSignatureReady(Signature object, AVException object2) {
        if (object2 == null) {
            object2 = this.this$0.session.conversationOperationCache;
            int n10 = Conversation$AVIMOperation.CONVERSATION_JOIN.getCode();
            Object object3 = this.this$0.session.getSelfPeerId();
            Object object4 = this.this$0.conversationId;
            int n11 = this.val$requestId;
            Object object5 = AVIMOperationQueue$Operation.getOperation(n10, (String)object3, (String)object4, n11);
            ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object5);
            object2 = this.this$0.session;
            object5 = ((AVSession)object2).getSelfPeerId();
            object3 = this.this$0;
            object4 = ((AVConversationHolder)object3).conversationId;
            n11 = 1;
            Object object6 = new String[n11];
            object6[0] = object3 = ((AVConversationHolder)object3).session.getSelfPeerId();
            object6 = Arrays.asList(object6);
            Object var9_13 = null;
            int n12 = this.val$requestId;
            object3 = object4;
            object4 = object6;
            object6 = "add";
            object = ConversationControlPacket.genConversationCommand((String)object5, (String)object3, (List)object4, (String)object6, null, (Signature)object, n12);
            ((AVSession)object2).sendPacket((CommandPacket)object);
        } else {
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            String string2 = this.this$0.session.getSelfPeerId();
            object = this.this$0;
            String string3 = ((AVConversationHolder)object).conversationId;
            int n13 = this.val$requestId;
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_JOIN;
            operationTube.onOperationCompleted(string2, string3, n13, conversation$AVIMOperation, (Throwable)object2);
        }
    }
}

