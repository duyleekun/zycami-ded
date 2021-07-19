/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.auth.b$a;
import java.util.HashMap;
import java.util.Map;

public final class b {
    private Map i;

    private b() {
        HashMap hashMap;
        this.i = hashMap = new HashMap();
    }

    public /* synthetic */ b(byte by2) {
        this();
    }

    public static b f() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            b b10 = b$a.g();
            return b10;
        }
    }

    public final WbAuthListener a(String object) {
        synchronized (this) {
            block7: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                if (!bl2) break block7;
                return null;
            }
            Map map = this.i;
            object = map.get(object);
            object = (WbAuthListener)object;
            return object;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String string2, WbAuthListener wbAuthListener) {
        synchronized (this) {
            void var2_2;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2 && var2_2 != null) {
                Map map = this.i;
                map.put(string2, var2_2);
                return;
            }
            return;
        }
    }

    public final void b(String string2) {
        synchronized (this) {
            block5: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block5;
                return;
            }
            Map map = this.i;
            map.remove(string2);
            return;
        }
    }
}

