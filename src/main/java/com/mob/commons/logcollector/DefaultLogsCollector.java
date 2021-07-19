/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.mob.commons.logcollector;

import android.content.Context;
import android.content.Intent;
import com.mob.MobSDK;
import com.mob.commons.logcollector.c;
import com.mob.tools.MobLog;
import com.mob.tools.log.LogCollector;
import com.mob.tools.log.NLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.mob.tools.utils.Data;
import java.util.HashMap;

public class DefaultLogsCollector
implements LogCollector,
PublicMemberKeeper {
    private static DefaultLogsCollector a;
    private final HashMap b;
    private c c;
    private boolean d;

    private DefaultLogsCollector() {
        block5: {
            Object object = new HashMap();
            this.b = object;
            this.c = object = com.mob.commons.logcollector.c.a();
            object = MobSDK.getContext();
            object = object.getPackageManager();
            String string2 = "cn.sharesdk.log";
            int n10 = 64;
            object = object.getPackageInfo(string2, n10);
            if (object == null) break block5;
            boolean bl2 = true;
            try {
                this.d = bl2;
            }
            catch (Throwable throwable) {
                bl2 = false;
                object = null;
                this.d = false;
            }
        }
    }

    public static DefaultLogsCollector get() {
        Class<DefaultLogsCollector> clazz = DefaultLogsCollector.class;
        synchronized (clazz) {
            DefaultLogsCollector defaultLogsCollector = a;
            if (defaultLogsCollector == null) {
                a = defaultLogsCollector = new DefaultLogsCollector();
            }
            defaultLogsCollector = a;
            return defaultLogsCollector;
        }
    }

    public final int a(int n10, String object) {
        boolean bl2;
        Context context = MobSDK.getContext();
        if (context != null && (bl2 = this.d)) {
            context = new Intent();
            String string2 = "cn.sharesdk.log";
            context.setPackage(string2);
            string2 = MobSDK.getContext();
            string2 = string2.getPackageName();
            String string3 = "package";
            context.putExtra(string3, string2);
            string3 = "priority";
            context.putExtra(string3, n10);
            String string4 = "msg";
            object = Data.AES128Encode(string2, (String)object);
            context.putExtra(string4, (byte[])object);
            string4 = MobSDK.getContext();
            try {
                string4.sendBroadcast((Intent)context);
            }
            catch (Throwable throwable) {
                object = MobLog.getInstance();
                ((NLog)object).w(throwable);
            }
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addSDK(String string2, int n10) {
        HashMap hashMap = this.b;
        synchronized (hashMap) {
            Object object = this.b;
            object = ((HashMap)object).get(string2);
            object = (Integer)object;
            HashMap hashMap2 = this.b;
            Integer n11 = n10;
            hashMap2.put(string2, n11);
            if (object == null && (object = this.c) != null) {
                ((c)object).a(n10, string2);
            }
            return;
        }
    }

    public final void log(String string2, int n10, int n11, String object, String string3) {
        int n12;
        this.a(n10, string3);
        Object object2 = "MOBTOOLS";
        n10 = (int)(((String)object2).equalsIgnoreCase(string2) ? 1 : 0);
        if (n10 != 0) {
            object2 = this.b;
            object = "MOBSDK";
            if ((object2 = (Integer)((HashMap)object2).get(object)) == null) {
                n10 = -999;
                object2 = n10;
            }
        } else {
            object2 = (Integer)this.b.get(string2);
            if (object2 == null) {
                return;
            }
        }
        if ((n12 = ((String)(object = "SHARESDK")).equals(string2)) != 0 && ((n12 = (int)(string3.contains((CharSequence)(object = "com.mob.")) ? 1 : 0)) == 0 || (n12 = (int)(string3.contains((CharSequence)(object = "cn.sharesdk.")) ? 1 : 0)) == 0)) {
            return;
        }
        n12 = 1;
        if (n11 == n12) {
            object = this.c;
            n10 = (Integer)object2;
            ((c)object).b(n10, n11, string2, string3);
        } else {
            n12 = 2;
            if (n11 == n12) {
                object = this.c;
                n10 = (Integer)object2;
                ((c)object).a(n10, n11, string2, string3);
            } else {
                n12 = 3;
                if (n11 == n12) {
                    object = this.c;
                    n10 = (Integer)object2;
                    ((c)object).a(n10, n11, string2, string3);
                }
            }
        }
    }
}

