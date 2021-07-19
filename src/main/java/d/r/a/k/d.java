/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.r.a.k;

import android.content.Context;
import android.text.TextUtils;
import d.r.a.u.c;
import d.r.a.u.c0;
import d.r.a.u.k;
import d.r.a.u.s;
import java.util.ArrayList;
import java.util.List;

public abstract class d {
    public static final byte[] c;
    public static final byte[] d;
    public static final Object e;
    public List a;
    public Context b;

    static {
        Object object;
        byte[] byArray;
        int n10 = 16;
        byte[] byArray2 = byArray = new byte[n10];
        byte[] byArray3 = byArray;
        byArray2[0] = 34;
        byArray3[1] = 32;
        byArray2[2] = 33;
        byArray3[3] = 37;
        byArray2[4] = 33;
        byArray3[5] = 34;
        byArray2[6] = 32;
        byArray3[7] = 33;
        byArray2[8] = 33;
        byArray3[9] = 33;
        byArray2[10] = 34;
        byArray3[11] = 41;
        byArray2[12] = 35;
        byArray3[13] = 32;
        byArray2[14] = 32;
        byArray3[15] = 32;
        c = byArray;
        byte[] byArray4 = object = new byte[n10];
        byte[] byArray5 = object;
        byArray4[0] = 33;
        byArray5[1] = 34;
        byArray4[2] = 35;
        byArray5[3] = 36;
        byArray4[4] = 37;
        byArray5[5] = 38;
        byArray4[6] = 39;
        byArray5[7] = 40;
        byArray4[8] = 41;
        byArray5[9] = 32;
        byArray4[10] = 38;
        byArray5[11] = 37;
        byArray4[12] = 36;
        byArray5[13] = 35;
        byArray4[14] = 34;
        byArray5[15] = 33;
        d = object;
        object = new Object;
        object();
        e = object;
    }

    public d(Context context) {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        this.b = context = d.r.a.u.c.c(context).getApplicationContext();
        this.d();
    }

    public abstract String a();

    public abstract List b(String var1);

    public abstract String c(String var1);

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void d() {
        Object object = e;
        synchronized (object) {
            Object object2 = this.a();
            k.a((String)object2);
            object2 = this.a;
            object2.clear();
            object2 = this.b;
            object2 = c0.c((Context)object2);
            Object object3 = this.a();
            int n10 = 0;
            CharSequence charSequence = null;
            object2 = ((c0)object2).a((String)object3, null);
            int n11 = TextUtils.isEmpty((CharSequence)object2);
            if (n11 != 0) {
                object2 = "CacheSettings";
                charSequence = "ClientManager init ";
                object3 = new StringBuilder((String)charSequence);
                charSequence = this.a();
                ((StringBuilder)object3).append((String)charSequence);
                charSequence = " strApps empty.";
                ((StringBuilder)object3).append((String)charSequence);
                object3 = ((StringBuilder)object3).toString();
                s.m((String)object2, (String)object3);
            } else {
                n11 = ((String)object2).length();
                if (n11 > (n10 = 10000)) {
                    object2 = "CacheSettings";
                    charSequence = "sync ";
                    object3 = new StringBuilder((String)charSequence);
                    charSequence = this.a();
                    ((StringBuilder)object3).append((String)charSequence);
                    charSequence = " strApps lenght too large";
                    ((StringBuilder)object3).append((String)charSequence);
                    object3 = ((StringBuilder)object3).toString();
                    s.m((String)object2, (String)object3);
                    this.e();
                } else {
                    object3 = "CacheSettings";
                    try {
                        String string2 = "ClientManager init ";
                        charSequence = new StringBuilder(string2);
                        string2 = this.a();
                        ((StringBuilder)charSequence).append(string2);
                        string2 = " strApps : ";
                        ((StringBuilder)charSequence).append(string2);
                        ((StringBuilder)charSequence).append((String)object2);
                        charSequence = ((StringBuilder)charSequence).toString();
                        s.m((String)object3, (String)charSequence);
                        object2 = this.c((String)object2);
                        object2 = this.b((String)object2);
                        if (object2 != null) {
                            object3 = this.a;
                            object3.addAll(object2);
                        }
                    }
                    catch (Exception exception) {
                        this.e();
                        object3 = "CacheSettings";
                        String string3 = s.d(exception);
                        s.m((String)object3, string3);
                    }
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void e() {
        Object object = e;
        synchronized (object) {
            Object object2 = this.a;
            object2.clear();
            object2 = "";
            Object object3 = this.b;
            object3 = c0.c((Context)object3);
            String string2 = this.a();
            ((c0)object3).b(string2, (String)object2);
            object2 = "CacheSettings";
            string2 = "clear ";
            object3 = new StringBuilder(string2);
            string2 = this.a();
            ((StringBuilder)object3).append(string2);
            string2 = " strApps";
            ((StringBuilder)object3).append(string2);
            object3 = ((StringBuilder)object3).toString();
            s.m((String)object2, (String)object3);
            return;
        }
    }
}

