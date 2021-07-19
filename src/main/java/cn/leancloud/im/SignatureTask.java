/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.BackgroundThreadpool;
import cn.leancloud.im.Signature;
import cn.leancloud.im.SignatureCallback;
import cn.leancloud.im.SignatureFactory$SignatureException;
import cn.leancloud.session.AVSessionCacheHelper$SignatureCache;

public class SignatureTask
implements Runnable {
    private final SignatureCallback callback;
    private final String clientId;

    public SignatureTask(SignatureCallback signatureCallback, String string2) {
        this.callback = signatureCallback;
        this.clientId = string2;
    }

    public void run() {
        block18: {
            boolean bl2;
            Object object;
            block17: {
                block15: {
                    block16: {
                        object = this.callback;
                        if (object == null) {
                            return;
                        }
                        boolean bl3 = ((SignatureCallback)object).useSignatureCache();
                        if (!bl3) break block15;
                        object = this.clientId;
                        object = AVSessionCacheHelper$SignatureCache.getSessionSignature((String)object);
                        if (object == null) break block16;
                        bl2 = ((Signature)object).isExpired();
                        if (!bl2) break block17;
                    }
                    object = this.callback;
                    object = ((SignatureCallback)object).computeSignature();
                    break block17;
                }
                object = this.callback;
                object = ((SignatureCallback)object).computeSignature();
            }
            Object object2 = this.callback;
            ((SignatureCallback)object2).onSignatureReady((Signature)object, null);
            object2 = this.callback;
            bl2 = ((SignatureCallback)object2).cacheSignature();
            if (!bl2) break block18;
            object2 = this.clientId;
            try {
                AVSessionCacheHelper$SignatureCache.addSessionSignature((String)object2, (Signature)object);
            }
            catch (SignatureFactory$SignatureException signatureFactory$SignatureException) {
                object2 = this.callback;
                ((SignatureCallback)object2).onSignatureReady(null, signatureFactory$SignatureException);
            }
        }
    }

    public void start() {
        BackgroundThreadpool.getInstance().execute(this);
    }
}

