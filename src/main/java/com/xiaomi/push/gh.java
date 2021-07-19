/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.xiaomi.push;

import android.os.Bundle;
import com.xiaomi.push.gh$a;
import com.xiaomi.push.gj;
import com.xiaomi.push.gn;
import com.xiaomi.push.gu;
import java.util.HashMap;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gh
extends gj {
    private gh$a a;
    private final Map a;

    public gh() {
        HashMap hashMap = gh$a.a;
        this.a = hashMap;
        this.a = hashMap = new HashMap();
    }

    public gh(Bundle object) {
        super((Bundle)object);
        Object object2 = gh$a.a;
        this.a = object2;
        object2 = new HashMap();
        this.a = object2;
        object2 = "ext_iq_type";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            object = gh$a.a(object.getString((String)object2));
            this.a = object;
        }
    }

    public Bundle a() {
        Bundle bundle = super.a();
        Object object = this.a;
        if (object != null) {
            object = ((gh$a)object).toString();
            String string2 = "ext_iq_type";
            bundle.putString(string2, (String)object);
        }
        return bundle;
    }

    public gh$a a() {
        return this.a;
    }

    public String a() {
        boolean bl2;
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<iq ");
        Object object2 = this.j();
        String string2 = "\" ";
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("id=\"");
            object = this.j();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            stringBuilder.append((String)object2);
        }
        if ((object2 = this.l()) != null) {
            stringBuilder.append("to=\"");
            object2 = gu.a(this.l());
            stringBuilder.append((String)object2);
            stringBuilder.append(string2);
        }
        if ((object2 = this.m()) != null) {
            stringBuilder.append("from=\"");
            object2 = gu.a(this.m());
            stringBuilder.append((String)object2);
            stringBuilder.append(string2);
        }
        if ((object2 = this.k()) != null) {
            stringBuilder.append("chid=\"");
            object2 = gu.a(this.k());
            stringBuilder.append((String)object2);
            stringBuilder.append(string2);
        }
        object2 = this.a.entrySet().iterator();
        while (bl2 = object2.hasNext()) {
            object = (Map.Entry)object2.next();
            String string3 = gu.a((String)object.getKey());
            stringBuilder.append(string3);
            string3 = "=\"";
            stringBuilder.append(string3);
            object = gu.a((String)object.getValue());
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
        }
        object2 = this.a;
        if (object2 == null) {
            object2 = "type=\"get\">";
        } else {
            stringBuilder.append("type=\"");
            object2 = this.a();
            stringBuilder.append(object2);
            object2 = "\">";
        }
        stringBuilder.append((String)object2);
        object2 = this.b();
        if (object2 != null) {
            stringBuilder.append((String)object2);
        }
        object2 = this.o();
        stringBuilder.append((String)object2);
        object2 = this.a();
        if (object2 != null) {
            object2 = ((gn)object2).a();
            stringBuilder.append((String)object2);
        }
        stringBuilder.append("</iq>");
        return stringBuilder.toString();
    }

    public void a(gh$a gh$a) {
        if (gh$a == null) {
            gh$a = gh$a.a;
        }
        this.a = gh$a;
    }

    public void a(Map map) {
        synchronized (this) {
            Map map2 = this.a;
            map2.putAll(map);
            return;
        }
    }

    public String b() {
        return null;
    }
}

