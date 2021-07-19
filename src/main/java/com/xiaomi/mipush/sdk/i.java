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
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.d;
import com.xiaomi.mipush.sdk.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class i
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ d a;
    public final /* synthetic */ String a;

    public i(String string2, Context context, d d10) {
        this.a = string2;
        this.a = context;
        this.a = d10;
    }

    public void run() {
        Object object = this.a;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0) {
            d d10;
            int n11;
            String string2;
            block4: {
                object = this.a;
                string2 = "~";
                object = object.split(string2);
                n11 = ((String[])object).length;
                d10 = null;
                for (int i10 = 0; i10 < n11; ++i10) {
                    String string3;
                    String string4 = object[i10];
                    boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
                    if (bl2 || !(bl2 = string4.startsWith(string3 = "token:"))) continue;
                    n10 = string4.indexOf(":") + 1;
                    object = string4.substring(n10);
                    break block4;
                }
                object = "";
            }
            n11 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n11 == 0) {
                b.a("ASSEMBLE_PUSH : receive correct token");
                string2 = this.a;
                d10 = this.a;
                h.c((Context)string2, d10, (String)object);
                object = this.a;
                h.a(object);
            } else {
                object = "ASSEMBLE_PUSH : receive incorrect token";
                b.a((String)object);
            }
        }
    }
}

