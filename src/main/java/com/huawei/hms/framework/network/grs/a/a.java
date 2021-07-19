/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.b;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.d.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static final String a = "a";
    private Map b;
    private Map c;
    private c d;
    private c e;
    private m f;

    public a(c c10, c c11, m m10) {
        ConcurrentHashMap concurrentHashMap;
        int n10 = 16;
        this.b = concurrentHashMap = new ConcurrentHashMap(n10);
        this.c = concurrentHashMap = new ConcurrentHashMap(n10);
        this.e = c11;
        this.d = c10;
        this.f = m10;
        m10.a(this);
    }

    private void a(GrsBaseInfo object, b b10, Context object2, String string2) {
        boolean bl2 = false;
        int n10 = 1;
        Object object3 = ((GrsBaseInfo)object).getGrsParasKey(false, n10 != 0, (Context)object2);
        Map map = this.c;
        boolean bl3 = com.huawei.hms.framework.network.grs.d.e.a((Long)(object3 = (Long)map.get(object3)));
        if (bl3) {
            b10.a(2);
            return;
        }
        long l10 = 300000L;
        bl2 = com.huawei.hms.framework.network.grs.d.e.a((Long)object3, l10);
        if (bl2) {
            object3 = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object, (Context)object2);
            object = this.f;
            object2 = this.e;
            bl3 = false;
            map = null;
            ((m)object).a((com.huawei.hms.framework.network.grs.c.b.c)object3, null, string2, (c)object2);
        }
        b10.a(n10);
    }

    private void a(GrsBaseInfo object, String object2, Context object3) {
        long l10;
        Map map = this.c;
        boolean bl2 = com.huawei.hms.framework.network.grs.d.e.a((Long)(object2 = (Long)map.get(object2)), l10 = 300000L);
        if (bl2) {
            object2 = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object, (Context)object3);
            object = this.f;
            object3 = this.e;
            map = null;
            ((m)object).a((com.huawei.hms.framework.network.grs.c.b.c)object2, null, null, (c)object3);
        }
    }

    public c a() {
        return this.d;
    }

    public String a(GrsBaseInfo object, String string2, String string3, b b10, Context context) {
        if ((object = this.a((GrsBaseInfo)object, string2, b10, context)) == null) {
            return null;
        }
        return (String)object.get(string3);
    }

    public Map a(GrsBaseInfo cloneable, String string2, b b10, Context context) {
        boolean bl2 = true;
        Object object = cloneable.getGrsParasKey(false, bl2, context);
        Map map = this.b;
        if ((object = (Map)map.get(object)) != null && !(bl2 = object.isEmpty())) {
            this.a((GrsBaseInfo)cloneable, b10, context, string2);
            return (Map)object.get(string2);
        }
        cloneable = new HashMap();
        return cloneable;
    }

    public void a(GrsBaseInfo object, Context object2) {
        object = ((GrsBaseInfo)object).getGrsParasKey(false, true, (Context)object2);
        object2 = this.d;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        String string2 = "time";
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        ((c)object2).b((String)charSequence, "0");
        object2 = this.c;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        object2.remove(charSequence);
        this.b.remove(object);
        this.f.a((String)object);
    }

    public void a(GrsBaseInfo object, f object2, Context object3, com.huawei.hms.framework.network.grs.c.b.c object4) {
        int n10;
        int n11 = ((f)object2).e();
        if (n11 == (n10 = 2)) {
            Logger.w(a, "update cache from server failed");
            return;
        }
        int n12 = (object4 = ((com.huawei.hms.framework.network.grs.c.b.c)object4).d()).size();
        if (n12 == 0) {
            n12 = 0;
            n11 = 1;
            object = ((GrsBaseInfo)object).getGrsParasKey(false, n11 != 0, (Context)object3);
            object3 = this.d;
            object4 = ((f)object2).i();
            ((c)object3).b((String)object, (String)object4);
            object3 = this.d;
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append("time");
            object4 = ((StringBuilder)object4).toString();
            String string2 = ((f)object2).a();
            ((c)object3).b((String)object4, string2);
            object3 = this.b;
            object4 = com.huawei.hms.framework.network.grs.a.a(((f)object2).i());
            object3.put(object, object4);
            object3 = this.c;
            long l10 = Long.parseLong(((f)object2).a());
            object2 = l10;
            object3.put(object, object2);
        } else {
            object = this.d;
            object3 = ((f)object2).i();
            object4 = "geoipCountryCode";
            ((c)object).b((String)object4, (String)object3);
            object = this.d;
            object2 = ((f)object2).a();
            object3 = "geoipCountryCodetime";
            ((c)object).b((String)object3, (String)object2);
        }
    }

    public m b() {
        return this.f;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        boolean bl2 = true;
        String string2 = grsBaseInfo.getGrsParasKey(false, bl2, context);
        Object object = this.d.a(string2, "");
        Object object2 = this.d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        charSequence.append("time");
        charSequence = charSequence.toString();
        String string3 = "0";
        object2 = ((c)object2).a((String)charSequence, string3);
        boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
        long l10 = 0L;
        if (!bl3 && (bl3 = ((String)object2).matches((String)(charSequence = "\\d+")))) {
            try {
                l10 = Long.parseLong((String)object2);
            }
            catch (NumberFormatException numberFormatException) {
                charSequence = a;
                String string4 = "convert urlParamKey from String to Long catch NumberFormatException.";
                Logger.w((String)charSequence, string4, numberFormatException);
            }
        }
        object2 = this.b;
        object = com.huawei.hms.framework.network.grs.a.a((String)object);
        object2.put(string2, object);
        object = this.c;
        object2 = l10;
        object.put(string2, object2);
        this.a(grsBaseInfo, string2, context);
    }

    public c c() {
        return this.e;
    }
}

