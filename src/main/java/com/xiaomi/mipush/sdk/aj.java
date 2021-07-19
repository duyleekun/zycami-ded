/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.ak;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.mipush.sdk.t;
import com.xiaomi.push.bc;
import com.xiaomi.push.h;
import com.xiaomi.push.hm;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.id;
import com.xiaomi.push.ih;
import com.xiaomi.push.ii;
import com.xiaomi.push.il;
import com.xiaomi.push.in;
import com.xiaomi.push.io;
import com.xiaomi.push.ip;
import com.xiaomi.push.ir;
import com.xiaomi.push.it;
import com.xiaomi.push.iv;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import java.nio.ByteBuffer;

public class aj {
    public static ii a(Context context, ix ix2, hm hm2) {
        hm hm3 = hm.a;
        boolean bl2 = hm2.equals((Object)hm3) ^ true;
        String string2 = context.getPackageName();
        String string3 = b.a(context).a();
        return aj.a(context, ix2, hm2, bl2, string2, string3);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ii a(Context object, ix object2, hm hm2, boolean bl2, String string2, String string3) {
        void var5_14;
        void var4_13;
        void var2_11;
        void var3_12;
        ii ii2;
        byte[] byArray;
        block6: {
            String string4;
            block7: {
                void var0_2;
                block5: {
                    block4: {
                        if ((byArray = iw.a((ix)byArray)) != null) break block4;
                        String string5 = "invoke convertThriftObjectToBytes method, return null.";
                        break block5;
                    }
                    ii2 = new ii();
                    if (var3_12 == false) break block6;
                    string4 = b.a(object).d();
                    boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
                    if (!bl3) break block7;
                    String string6 = "regSecret is empty, return null";
                }
                com.xiaomi.channel.commonutils.logger.b.a((String)var0_2);
                return null;
            }
            byte[] byArray2 = bc.a(string4);
            try {
                byArray = h.b(byArray2, byArray);
            }
            catch (Exception exception) {
                String string7 = "encryption error. ";
                com.xiaomi.channel.commonutils.logger.b.d(string7);
            }
        }
        ib ib2 = new ib();
        ib2.a = 5;
        ib2.a = "fakeid";
        ii2.a(ib2);
        ByteBuffer byteBuffer = ByteBuffer.wrap(byArray);
        ii2.a(byteBuffer);
        ii2.a((hm)var2_11);
        ii2.b(true);
        ii2.b((String)var4_13);
        ii2.a((boolean)var3_12);
        ii2.a((String)var5_14);
        return ii2;
    }

    public static ix a(Context object, ii serializable) {
        Object object2;
        boolean bl2 = serializable.b();
        if (bl2) {
            object = bc.a(b.a(object).d());
            try {
                object2 = serializable.a();
            }
            catch (Exception exception) {
                serializable = new t("the aes decrypt failed.", exception);
                throw serializable;
            }
            object = h.a((byte[])object, (byte[])object2);
        } else {
            object = serializable.a();
        }
        object2 = serializable.a();
        boolean bl3 = serializable.b;
        serializable = aj.a(object2, bl3);
        if (serializable != null) {
            iw.a(serializable, (byte[])object);
        }
        return serializable;
    }

    private static ix a(hm object, boolean bl2) {
        int[] nArray = ak.a;
        int n10 = ((Enum)object).ordinal();
        n10 = nArray[n10];
        switch (n10) {
            default: {
                return null;
            }
            case 10: {
                object = new ih();
                return object;
            }
            case 9: {
                if (bl2) {
                    object = new il();
                    return object;
                }
                object = new id();
                ((id)object).a(true);
                return object;
            }
            case 8: {
                object = new io();
                return object;
            }
            case 7: {
                object = new ih();
                return object;
            }
            case 6: {
                object = new ic();
                return object;
            }
            case 5: {
                object = new ip();
                return object;
            }
            case 4: {
                object = new iv();
                return object;
            }
            case 3: {
                object = new ir();
                return object;
            }
            case 2: {
                object = new it();
                return object;
            }
            case 1: 
        }
        object = new in();
        return object;
    }
}

