/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.AVException;
import cn.leancloud.AVLogger;
import cn.leancloud.command.CommandPacket;
import cn.leancloud.command.SessionControlPacket;
import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.AVUserSignatureFactory;
import cn.leancloud.im.Signature;
import cn.leancloud.im.SignatureCallback;
import cn.leancloud.im.SignatureFactory;
import cn.leancloud.session.AVConnectionManager;
import cn.leancloud.session.AVSession;
import cn.leancloud.utils.StringUtil;
import java.util.ArrayList;

public class AVSession$1
extends SignatureCallback {
    public final /* synthetic */ AVSession this$0;
    public final /* synthetic */ int val$requestId;

    public AVSession$1(AVSession aVSession, int n10) {
        this.this$0 = aVSession;
        this.val$requestId = n10;
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
            object = AVSession.access$000();
            String string2 = "failed to generate signaure. cause:";
            ((AVLogger)object).d(string2, (Throwable)object2);
        } else {
            String string3 = AVSession.access$100(this.this$0);
            String string4 = this.this$0.getSelfPeerId();
            long l10 = this.this$0.getLastNotifyTime();
            long l11 = this.this$0.getLastPatchTime();
            int n10 = this.val$requestId;
            Integer n11 = n10;
            String string5 = "refresh";
            object = SessionControlPacket.genSessionCommand(string3, string4, null, string5, (Signature)object, l10, l11, n11);
            object2 = AVSession.access$200(this.this$0);
            ((SessionControlPacket)object).setTag((String)object2);
            object2 = AVSession.access$300(this.this$0);
            ((SessionControlPacket)object).setSessionToken((String)object2);
            object2 = this.this$0.connectionManager;
            ((AVConnectionManager)object2).sendPacket((CommandPacket)object);
        }
    }
}

