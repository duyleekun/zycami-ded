/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.service.ai;
import com.xiaomi.push.service.ai$b;
import java.util.concurrent.Callable;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aa$a
implements Callable {
    private Context a;
    private String a;
    private boolean a;

    public aa$a(String string2, Context context, boolean bl2) {
        this.a = context;
        this.a = string2;
        this.a = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Bitmap a() {
        Object object = this.a;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = null;
        if (bl2) {
            object = "Failed get online picture/icon resource cause picUrl is empty";
            b.a((String)object);
            return string2;
        }
        object = this.a;
        bl2 = ((String)object).startsWith("http");
        String string3 = "Failed get online picture/icon resource";
        if (bl2) {
            object = this.a;
            String string4 = this.a;
            boolean bl3 = this.a;
            if ((object = ai.a((Context)object, string4, bl3)) != null) {
                return ((ai$b)object).a;
            }
        } else {
            object = this.a;
            string2 = this.a;
            if ((string2 = ai.a((Context)object, string2)) != null) return string2;
        }
        b.a(string3);
        return string2;
    }

    public /* synthetic */ Object call() {
        return this.a();
    }
}

