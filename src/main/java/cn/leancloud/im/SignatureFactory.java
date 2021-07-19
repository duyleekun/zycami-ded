/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.Signature;
import java.util.List;

public interface SignatureFactory {
    public static final int SIGNATURE_FAILED_LOGIN = 4102;

    public Signature createBlacklistSignature(String var1, String var2, List var3, String var4);

    public Signature createConversationSignature(String var1, String var2, List var3, String var4);

    public Signature createSignature(String var1, List var2);
}

