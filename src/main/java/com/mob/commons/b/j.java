/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.Signature
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.text.TextUtils
 */
package com.mob.commons.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import com.mob.commons.b.f;
import com.mob.commons.b.f$c;
import com.mob.commons.k;
import java.security.MessageDigest;

public class j
extends f {
    private String c;

    public j(Context context) {
        super(context);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final String a(IBinder iBinder, String string2) {
        String string3;
        String string4;
        String string5;
        Object object;
        int n10;
        block6: {
            String string6 = this.b;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string6);
            if (bl2) {
                String string7;
                this.b = string7 = this.a.getPackageName();
            }
            String string8 = this.c;
            bl2 = TextUtils.isEmpty((CharSequence)string8);
            n10 = 3;
            int n11 = 1;
            if (bl2) {
                try {
                    int n12;
                    Context context = this.a;
                    PackageManager packageManager = context.getPackageManager();
                    object = this.b;
                    int n13 = 64;
                    PackageInfo packageInfo = packageManager.getPackageInfo((String)object, n13);
                    Signature[] signatureArray = packageInfo.signatures;
                    if (signatureArray == null || (n12 = signatureArray.length) <= 0) break block6;
                    Signature signature = signatureArray[0];
                    byte[] byArray = signature.toByteArray();
                    object = "SHA1";
                    if ((object = MessageDigest.getInstance((String)object)) != null) {
                        String string9;
                        byte[] byArray2 = ((MessageDigest)object).digest(byArray);
                        object = new StringBuilder();
                        n13 = byArray2.length;
                        for (int n14 = 0; n14 < n13; string5 = string5.substring(n11, n10), ++n14) {
                            int n15 = byArray2[n14] & 0xFF | 0x100;
                            string5 = Integer.toHexString(n15);
                            ((StringBuilder)object).append(string5);
                        }
                        this.c = string9 = ((StringBuilder)object).toString();
                    }
                }
                catch (Throwable throwable) {}
            }
        }
        string5 = k.a(93);
        String[] stringArray = new String[n10];
        stringArray[0] = string4 = this.b;
        stringArray[n11] = string3 = this.c;
        stringArray[2] = string2;
        object = this;
        return this.a(string2, iBinder, string5, 1, stringArray);
    }

    public Intent a() {
        Intent intent = new Intent();
        String string2 = k.a(87);
        String string3 = k.a(88);
        Object object = new ComponentName(string2, string3);
        intent.setComponent(object);
        object = k.a(89);
        intent.setAction((String)object);
        return intent;
    }

    public f$c a(IBinder object) {
        f$c f$c = new f$c();
        String string2 = k.a(90);
        f$c.c = string2 = this.a((IBinder)object, string2);
        string2 = k.a(91);
        f$c.b = string2 = this.a((IBinder)object, string2);
        string2 = k.a(92);
        object = this.a((IBinder)object, string2);
        f$c.e = object;
        return f$c;
    }

    public boolean h() {
        synchronized (this) {
            int n10;
            block12: {
                int n11;
                Context context;
                block10: {
                    block11: {
                        n10 = 0;
                        try {
                            context = this.a;
                        }
                        catch (Throwable throwable) {
                            return false;
                        }
                        context = context.getPackageManager();
                        int n12 = 87;
                        String string2 = k.a(n12);
                        context = context.getPackageInfo(string2, 0);
                        n12 = Build.VERSION.SDK_INT;
                        int n13 = 28;
                        n11 = 1;
                        if (n12 < n13) break block10;
                        if (context == null) break block11;
                        long l10 = context.getLongVersionCode();
                        long l11 = 1L;
                        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                        if (l12 < 0) break block11;
                        n10 = n11;
                    }
                    return n10 != 0;
                }
                if (context != null) {
                    int n14 = context.versionCode;
                    if (n14 < n11) break block12;
                    n10 = n11;
                }
            }
            return n10 != 0;
        }
    }
}

