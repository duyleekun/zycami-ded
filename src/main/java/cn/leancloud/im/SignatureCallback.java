/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.im.Signature;

public abstract class SignatureCallback {
    public boolean cacheSignature() {
        return false;
    }

    public abstract Signature computeSignature();

    public abstract void onSignatureReady(Signature var1, AVException var2);

    public boolean useSignatureCache() {
        return false;
    }
}

