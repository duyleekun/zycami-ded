/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.g1;
import com.huawei.hms.hatool.i;
import com.huawei.hms.hatool.k;
import com.huawei.hms.hatool.m;
import com.huawei.hms.hatool.q0;
import com.huawei.hms.hatool.y;
import java.util.LinkedHashMap;
import java.util.Map;

public class h1 {
    public String a;
    public m b;

    public h1(String object) {
        this.a = object;
        Object object2 = new m((String)object);
        this.b = object2;
        object = i.c();
        object2 = this.a;
        m m10 = this.b;
        ((i)object).a((String)object2, m10);
    }

    public void a(int n10) {
        Object object = this.a;
        object = n10;
        Object object2 = new Object[]{object, object};
        y.a("hmsSdk", "HiAnalyticsInstance.onReport() is execute.TAG: %s,TYPE: %d", (Object[])object2);
        object2 = g1.a();
        object = this.a;
        ((g1)object2).a((String)object, n10);
    }

    public void a(int n10, String charSequence, LinkedHashMap object) {
        Object object2;
        Object object3 = new Object[2];
        object3[0] = object2 = this.a;
        object2 = n10;
        int n11 = 1;
        object3[n11] = object2;
        object2 = "hmsSdk";
        y.a((String)object2, "HiAnalyticsInstance.onEvent(int type, String eventId, Map<String, String> mapValue) is execute.TAG: %s,TYPE: %d", object3);
        boolean bl2 = q0.a((String)charSequence);
        String string2 = ", TYPE: ";
        if (!bl2 && (bl2 = this.c(n10))) {
            bl2 = q0.a((Map)object);
            if (!bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("onEvent() parameter mapValue will be cleared.TAG: ");
                object3 = this.a;
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                y.e((String)object2, (String)object);
                object = null;
            }
            object3 = g1.a();
            object2 = this.a;
            object3.a((String)object2, n10, (String)charSequence, (LinkedHashMap)object);
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
        object = this.a;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n10);
        String string3 = ((StringBuilder)charSequence).toString();
        y.e((String)object2, string3);
    }

    public void a(Context object, String string2, String charSequence) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("HiAnalyticsInstance.onEvent(eventId, mapValue) is execute.TAG : ");
        String string3 = this.a;
        ((StringBuilder)object2).append(string3);
        object2 = ((StringBuilder)object2).toString();
        string3 = "hmsSdk";
        y.c(string3, (String)object2);
        if (object == null) {
            y.e(string3, "context is null in onevent ");
            return;
        }
        boolean bl2 = q0.a(string2);
        if (!bl2) {
            object2 = null;
            bl2 = this.c(0);
            if (bl2) {
                String string4 = "value";
                bl2 = q0.a(string4, (String)charSequence, 65536);
                if (!bl2) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("onEvent() parameter VALUE is overlong, content will be cleared.TAG: ");
                    object2 = this.a;
                    ((StringBuilder)charSequence).append((String)object2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    y.e(string3, (String)charSequence);
                    charSequence = "";
                }
                object2 = g1.a();
                string3 = this.a;
                ((g1)object2).a(string3, (Context)object, string2, (String)charSequence);
                return;
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onEvent() parameters check fail. Nothing will be recorded.TAG: ");
        string2 = this.a;
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        y.e(string3, (String)object);
    }

    public void a(k k10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : ");
        String string2 = this.a;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = "hmsSdk";
        y.c(string2, (String)charSequence);
        if (k10 == null) {
            y.e(string2, "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.b.a((k)null);
            return;
        }
        this.b.a(k10);
    }

    public final k b(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return this.b.a();
                }
                return this.b.d();
            }
            return this.b.b();
        }
        return this.b.c();
    }

    public void b(k k10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: ");
        String string2 = this.a;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        string2 = "hmsSdk";
        y.c(string2, (String)charSequence);
        if (k10 == null) {
            this.b.b(null);
            y.e(string2, "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
            return;
        }
        this.b.b(k10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean c(int n10) {
        String string2;
        boolean bl2 = true;
        String string3 = "hmsSdk";
        int n11 = 2;
        if (n10 == n11) {
            String string4 = "_default_config_tag";
            string2 = this.a;
            n10 = (int)(string4.equals(string2) ? 1 : 0);
            if (n10 != 0) {
                return bl2;
            }
            string2 = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        } else {
            Object object = this.b(n10);
            if (object != null && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object = ((k)object).h())) ? 1 : 0)) == 0) {
                return bl2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            object = "verifyURL(): URL check failed. type: ";
            stringBuilder.append((String)object);
            stringBuilder.append(n10);
            string2 = stringBuilder.toString();
        }
        y.e(string3, string2);
        return false;
    }
}

