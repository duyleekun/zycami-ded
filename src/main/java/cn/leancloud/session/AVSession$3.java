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
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVIMOperationQueue;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.AVSession;
import java.util.List;
import java.util.Map;

public class AVSession$3
extends SignatureCallback {
    public final /* synthetic */ AVSession this$0;
    public final /* synthetic */ Map val$attributes;
    public final /* synthetic */ boolean val$isSystem;
    public final /* synthetic */ boolean val$isTemp;
    public final /* synthetic */ boolean val$isTransient;
    public final /* synthetic */ boolean val$isUnique;
    public final /* synthetic */ List val$members;
    public final /* synthetic */ int val$requestId;
    public final /* synthetic */ int val$tempTTL;

    public AVSession$3(AVSession aVSession, List list, int n10, Map map, boolean bl2, boolean bl3, boolean bl4, int n11, boolean bl5) {
        this.this$0 = aVSession;
        this.val$members = list;
        this.val$requestId = n10;
        this.val$attributes = map;
        this.val$isTransient = bl2;
        this.val$isUnique = bl3;
        this.val$isTemp = bl4;
        this.val$tempTTL = n11;
        this.val$isSystem = bl5;
    }

    public Signature computeSignature() {
        SignatureFactory signatureFactory = AVIMOptions.getGlobalOptions().getSignatureFactory();
        if (signatureFactory != null) {
            String string2 = AVSession.access$400(this.this$0);
            List list = this.val$members;
            return signatureFactory.createConversationSignature(null, string2, list, "create");
        }
        return null;
    }

    public void onSignatureReady(Signature object, AVException object2) {
        if (object2 == null) {
            object2 = this.this$0.conversationOperationCache;
            int n10 = Conversation$AVIMOperation.CONVERSATION_CREATION.getCode();
            String string2 = this.this$0.getSelfPeerId();
            Object var5_6 = null;
            int n11 = this.val$requestId;
            Object object3 = AVIMOperationQueue$Operation.getOperation(n10, string2, null, n11);
            ((AVIMOperationQueue)object2).offer((AVIMOperationQueue$Operation)object3);
            object2 = this.this$0;
            object3 = ((AVSession)object2).connectionManager;
            string2 = AVSession.access$400((AVSession)object2);
            List list = this.val$members;
            Map map = this.val$attributes;
            boolean bl2 = this.val$isTransient;
            boolean bl3 = this.val$isUnique;
            boolean bl4 = this.val$isTemp;
            int n12 = this.val$tempTTL;
            boolean bl5 = this.val$isSystem;
            int n13 = this.val$requestId;
            String string3 = "start";
            object = ConversationControlPacket.genConversationCommand(string2, null, list, string3, map, (Signature)object, bl2, bl3, bl4, n12, bl5, n13);
            ((AVConnectionManager)object3).sendPacket((CommandPacket)object);
        } else {
            OperationTube operationTube = InternalConfiguration.getOperationTube();
            object = this.this$0;
            String string4 = ((AVSession)object).getSelfPeerId();
            boolean bl6 = false;
            Object var8_12 = null;
            int n14 = this.val$requestId;
            Conversation$AVIMOperation conversation$AVIMOperation = Conversation$AVIMOperation.CONVERSATION_CREATION;
            operationTube.onOperationCompleted(string4, null, n14, conversation$AVIMOperation, (Throwable)object2);
        }
    }
}

