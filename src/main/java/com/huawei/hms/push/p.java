/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 */
package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.k;
import com.huawei.hms.push.o;
import com.huawei.hms.push.q;
import com.huawei.hms.support.log.HMSLog;

public class p
extends Thread {
    public Context a;
    public k b;

    public p(Context context, k k10) {
        this.a = context;
        this.b = k10;
    }

    public static Intent a(Context object, k object2) {
        String string2 = "PushSelfShowLog";
        CharSequence charSequence = null;
        if (object2 == null) {
            return null;
        }
        String string3 = ((k)object2).d();
        string3 = q.b((Context)object, string3);
        String string4 = ((k)object2).n();
        if (string4 != null) {
            string4 = ((k)object2).n();
            String string5 = null;
            string4 = Intent.parseUri((String)string4, (int)0);
            string4.setSelector(null);
            charSequence = new StringBuilder();
            string5 = "Intent.parseUri(msg.intentUri, 0), action:";
            ((StringBuilder)charSequence).append(string5);
            string5 = string4.getAction();
            ((StringBuilder)charSequence).append(string5);
            charSequence = ((StringBuilder)charSequence).toString();
            HMSLog.d(string2, (String)charSequence);
            object2 = ((k)object2).d();
            object = q.a((Context)object, (String)object2, (Intent)string4);
            try {
                boolean bl2 = (Boolean)object;
                if (bl2) {
                    string3 = string4;
                }
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                charSequence = "intentUri error,";
                ((StringBuilder)object2).append((String)charSequence);
                String string6 = exception.toString();
                ((StringBuilder)object2).append(string6);
                string6 = ((StringBuilder)object2).toString();
                HMSLog.w(string2, string6);
            }
        } else {
            string2 = ((k)object2).a();
            if (string2 != null) {
                charSequence = ((k)object2).a();
                string2 = new Intent((String)charSequence);
                charSequence = ((k)object2).d();
                boolean bl3 = (Boolean)(object = q.a((Context)object, (String)charSequence, (Intent)string2));
                if (bl3) {
                    string3 = string2;
                }
            }
            object = ((k)object2).d();
            string3.setPackage((String)object);
        }
        return string3;
    }

    public final boolean a(Context context) {
        String string2 = this.b.d();
        return q.c(context, string2);
    }

    public final boolean b(Context context) {
        String string2 = "cosa";
        String string3 = this.b.i();
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return this.a(context);
        }
        return true;
    }

    public final boolean b(Context object, k object2) {
        boolean bl2;
        String string2 = "cosa";
        String string3 = ((k)object2).i();
        boolean bl3 = string2.equals(string3);
        if (bl3 && (object = p.a(object, (k)object2)) == null) {
            object = "PushSelfShowLog";
            object2 = "launchCosaApp,intent == null";
            HMSLog.d((String)object, (String)object2);
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void run() {
        block9: {
            k k10;
            String string2;
            String string3;
            block10: {
                string3 = "PushSelfShowLog";
                string2 = "enter run()";
                HMSLog.i(string3, string2);
                string2 = this.a;
                boolean bl2 = this.b((Context)string2);
                if (!bl2) break block9;
                string2 = this.a;
                k10 = this.b;
                bl2 = this.b((Context)string2, k10);
                if (!bl2) break block10;
                return;
            }
            string2 = this.a;
            k10 = this.b;
            try {
                o.a((Context)string2, k10);
            }
            catch (Exception exception) {
                string2 = exception.toString();
                HMSLog.e(string3, string2);
            }
        }
    }
}

