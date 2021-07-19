/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.net;

import android.text.TextUtils;
import com.zhiyun.net.NetConfiguration;
import g.a0;
import g.a0$a;
import g.c0;
import g.t;
import g.t$a;
import g.u;
import g.u$a;
import java.util.Map;
import m.a.a;

public class ChangeHostInterceptor
implements u {
    private static final String STATIC = "static";
    private volatile String mHost;
    private volatile String mOldHost;

    public c0 intercept(u$a u$a) {
        int n10;
        int n11;
        String string2;
        Object object;
        int n12;
        Object object2;
        int n13;
        int n14;
        Object object3 = this.mHost;
        Object object4 = this.mOldHost;
        a0 a02 = u$a.C();
        Object object5 = a02.j(STATIC);
        if (object5 != null && (n14 = object5.size()) > 0) {
            return u$a.c(a02);
        }
        object5 = "base_url";
        Object object6 = a02.j((String)object5);
        if (object6 != null && (n13 = object6.size()) > 0 && (object2 = NetConfiguration.create().getOtherHost()) != null && (n12 = object2.isEmpty()) == 0) {
            object2 = object2.entrySet().iterator();
            while ((n12 = object2.hasNext()) != 0) {
                Object e10;
                object = (Map.Entry)object2.next();
                string2 = (String)object.getKey();
                n11 = string2.equals(e10 = object6.get(0));
                if (n11 == 0) continue;
                object3 = (String)object.getValue();
                n10 = TextUtils.isEmpty((CharSequence)object4);
                if (n10 == 0) break;
                object4 = this.mHost;
                break;
            }
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)object3)) == 0 && (n10 = ((String)(object6 = a02.q().toString())).contains((CharSequence)object3)) == 0) {
            n10 = 0;
            object6 = null;
            n13 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
            if (n13 == 0) {
                object6 = t.J((String)object4);
            }
            if ((object2 = t.J((String)object3)) != null) {
                object = new StringBuilder();
                string2 = "\u8bbe\u7f6e\u4e86\u65b0\u7684host\u4e3a\uff1a";
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append("\uff0c\u6b64\u65f6\u8001\u7684host\u4e3a\uff1a");
                ((StringBuilder)object).append((String)object4);
                object3 = ((StringBuilder)object).toString();
                object4 = new Object[]{};
                a.i((String)object3, (Object[])object4);
                object3 = a02.q().H();
                object4 = ((t)object2).X();
                int n15 = TextUtils.isEmpty((CharSequence)object4);
                if (n15 == 0) {
                    object4 = ((t)object2).X();
                    ((t$a)object3).M((String)object4);
                }
                if ((n15 = TextUtils.isEmpty((CharSequence)(object4 = ((t)object2).F()))) == 0) {
                    object4 = ((t)object2).F();
                    ((t$a)object3).x((String)object4);
                }
                n15 = ((t)object2).N();
                ((t$a)object3).D(n15);
                if (object6 != null) {
                    object4 = ((t)object2).L();
                    object6 = ((t)object6).L();
                    object2 = a02.q().L();
                    object = null;
                    for (n12 = 0; n12 < (n11 = object2.size()); ++n12) {
                        ((t$a)object3).K(0);
                    }
                    object = null;
                    for (n12 = 0; n12 < (n11 = object4.size()); ++n12) {
                        string2 = (String)object4.get(n12);
                        ((t$a)object3).e(string2);
                    }
                    n15 = object6.size();
                    if (n15 > 0 && (n15 = object2.size()) > (n12 = object6.size())) {
                        for (n15 = object6.size(); n15 < (n10 = object2.size()); ++n15) {
                            object6 = (String)object2.get(n15);
                            ((t$a)object3).e((String)object6);
                        }
                    }
                }
                object4 = a02.n().t((String)object5);
                object3 = ((t$a)object3).h();
                object3 = ((a0$a)object4).D((t)object3);
                a02 = ((a0$a)object3).b();
            }
        }
        object3 = new Object[]{object4 = a02.toString()};
        a.i("ApiLogInterceptor re request:%s", (Object[])object3);
        return u$a.c(a02);
    }

    public void setHost(String string2) {
        String string3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (bl2 = string2.endsWith(string3 = "/"))) {
            bl2 = false;
            string3 = null;
            int n10 = string2.length() + -1;
            string2 = string2.substring(0, n10);
        }
        this.mOldHost = string3 = this.mHost;
        this.mHost = string2;
    }
}

