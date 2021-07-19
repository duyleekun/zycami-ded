/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaomi.push.q;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class p {
    private static volatile p a;
    private Context a;
    private Handler a;
    private Map a;

    private p(Context object) {
        this.a = object;
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.a = object;
        super();
        this.a = object;
    }

    public static /* synthetic */ Context a(p p10) {
        return p10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static p a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = p.class;
        synchronized (object) {
            p p10 = a;
            if (p10 != null) return a;
            a = p10 = new p(context);
            return a;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(String object, String string2) {
        synchronized (this) {
            void var2_2;
            Map map = this.a;
            if (map == null) return "";
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) return "";
            bl2 = TextUtils.isEmpty((CharSequence)var2_2);
            if (!bl2) {
                try {
                    map = this.a;
                    object = map.get(object);
                    object = (Map)object;
                    if (object == null) return "";
                    object = object.get(var2_2);
                    return (String)object;
                }
                catch (Throwable throwable) {
                    return "";
                }
            }
            return "";
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(String string2, String object, String string3) {
        synchronized (this) {
            void var3_3;
            Map map;
            HashMap hashMap = this.a;
            if (hashMap == null) {
                hashMap = new HashMap();
                this.a = hashMap;
            }
            hashMap = this.a;
            hashMap = hashMap.get(string2);
            if ((hashMap = (Map)hashMap) == null) {
                hashMap = new HashMap();
            }
            hashMap.put(map, var3_3);
            map = this.a;
            map.put(string2, hashMap);
            return;
        }
    }

    public String a(String string2, String string3, String string4) {
        synchronized (this) {
            int n10;
            String string5;
            block8: {
                string5 = this.a(string2, string3);
                n10 = TextUtils.isEmpty((CharSequence)string5);
                if (n10 != 0) break block8;
                return string5;
            }
            string5 = this.a;
            n10 = 4;
            string2 = string5.getSharedPreferences(string2, n10);
            string2 = string2.getString(string3, string4);
            return string2;
        }
    }

    public void a(String string2, String string3, String string4) {
        synchronized (this) {
            this.b(string2, string3, string4);
            Handler handler = this.a;
            q q10 = new q(this, string2, string3, string4);
            handler.post((Runnable)q10);
            return;
        }
    }
}

