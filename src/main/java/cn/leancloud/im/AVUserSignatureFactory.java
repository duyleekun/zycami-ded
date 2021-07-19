/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.Signature;
import cn.leancloud.im.SignatureFactory;
import cn.leancloud.service.RealtimeClient;
import java.util.HashMap;
import java.util.List;

public class AVUserSignatureFactory
implements SignatureFactory {
    private String sessionToken;

    public AVUserSignatureFactory(String string2) {
        this.sessionToken = string2;
    }

    public Signature createBlacklistSignature(String string2, String string3, List list, String string4) {
        return null;
    }

    public Signature createConversationSignature(String string2, String string3, List list, String string4) {
        return null;
    }

    public Signature createSignature(String hashMap, List object) {
        hashMap = new HashMap<String, Object>();
        object = this.sessionToken;
        hashMap.put("session_token", object);
        return (Signature)RealtimeClient.getInstance().createSignature(hashMap).r();
    }
}

