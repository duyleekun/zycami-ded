/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.auth;

import com.alibaba.sdk.android.oss.common.OSSLog;
import com.alibaba.sdk.android.oss.common.utils.BinaryUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSHA1Signature {
    private static final String ALGORITHM = "HmacSHA1";
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Object LOCK;
    private static final String VERSION = "1";
    private static Mac macInstance;

    static {
        Object object;
        LOCK = object = new Object();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] sign(byte[] var1_1, byte[] var2_2) {
        var3_3 = HmacSHA1Signature.macInstance;
        if (var3_3 != null) ** GOTO lbl21
        var3_3 = HmacSHA1Signature.LOCK;
        synchronized (var3_3) {
            var4_4 = HmacSHA1Signature.macInstance;
            if (var4_4 == null) {
                var4_4 = this.getAlgorithm();
            }
            ** GOTO lbl20
        }
        {
            catch (InvalidKeyException v0) {
                var1_1 /* !! */  = (byte[])new RuntimeException;
                var1_1 /* !! */ ("key must not be null");
                throw var1_1 /* !! */ ;
            }
            catch (NoSuchAlgorithmException v1) {
                var1_1 /* !! */  = (byte[])new RuntimeException;
                var1_1 /* !! */ ("Unsupported algorithm: HmacSHA1");
                throw var1_1 /* !! */ ;
            }
            {
                HmacSHA1Signature.macInstance = var4_4 = Mac.getInstance((String)var4_4);
lbl20:
                // 2 sources

                // MONITOREXIT @DISABLED, blocks:[5, 6] lbl19 : MonitorExitStatement: MONITOREXIT : var3_3
lbl21:
                // 2 sources

                try {
                    var3_3 = HmacSHA1Signature.macInstance;
                    var3_3 = var3_3.clone();
                    var3_3 = (Mac)var3_3;
                    ** GOTO lbl29
                }
                catch (CloneNotSupportedException v2) {}
                {
                    var3_3 = this.getAlgorithm();
                    var3_3 = Mac.getInstance((String)var3_3);
lbl29:
                    // 2 sources

                    var5_5 = this.getAlgorithm();
                    var4_4 = new SecretKeySpec(var1_1 /* !! */ , var5_5);
                    var3_3.init((Key)var4_4);
                    return var3_3.doFinal(var2_2);
                }
            }
        }
    }

    public String computeSignature(String object, String object2) {
        String string2 = DEFAULT_ENCODING;
        OSSLog.logDebug(this.getAlgorithm(), false);
        OSSLog.logDebug(this.getVersion(), false);
        String string3 = "sign start";
        try {
            OSSLog.logDebug(string3);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = new RuntimeException("Unsupported algorithm: UTF-8");
            throw object;
        }
        object = ((String)object).getBytes(string2);
        object2 = ((String)object2).getBytes(string2);
        object = this.sign((byte[])object, (byte[])object2);
        object2 = "base64 start";
        OSSLog.logDebug((String)object2);
        return BinaryUtil.toBase64String((byte[])object);
    }

    public String getAlgorithm() {
        return ALGORITHM;
    }

    public String getVersion() {
        return VERSION;
    }
}

