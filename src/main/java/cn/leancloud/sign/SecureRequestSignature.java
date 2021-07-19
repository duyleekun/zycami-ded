/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.sign;

import cn.leancloud.core.RequestSignature;
import cn.leancloud.sign.NativeSignHelper;

public class SecureRequestSignature
implements RequestSignature {
    public String generateSign() {
        return NativeSignHelper.generateRequestAuth();
    }
}

