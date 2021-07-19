/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.xiaomi.push;

import android.os.Bundle;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl$a;
import com.xiaomi.push.gl$b;
import com.xiaomi.push.gn;
import com.xiaomi.push.gu;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gl
extends gj {
    private int a;
    private gl$a a;
    private gl$b a;
    private String b;

    public gl(Bundle object) {
        super((Bundle)object);
        Object object2;
        this.a = object2 = gl$b.a;
        int n10 = 0;
        this.b = null;
        this.a = -1 << -1;
        this.a = null;
        object2 = "ext_pres_type";
        boolean bl2 = object.containsKey((String)object2);
        if (bl2) {
            this.a = object2 = gl$b.valueOf(object.getString((String)object2));
        }
        if (bl2 = object.containsKey((String)(object2 = "ext_pres_status"))) {
            object2 = object.getString((String)object2);
            this.b = object2;
        }
        if (bl2 = object.containsKey((String)(object2 = "ext_pres_prio"))) {
            this.a = n10 = object.getInt((String)object2);
        }
        if (bl2 = object.containsKey((String)(object2 = "ext_pres_mode"))) {
            object = gl$a.valueOf(object.getString((String)object2));
            this.a = object;
        }
    }

    public gl(gl$b gl$b) {
        gl$b gl$b2;
        this.a = gl$b2 = gl$b.a;
        this.b = null;
        this.a = -1 << -1;
        this.a = null;
        this.a(gl$b);
    }

    public Bundle a() {
        int n10;
        int n11;
        Object object;
        Bundle bundle = super.a();
        Object object2 = this.a;
        if (object2 != null) {
            object2 = object2.toString();
            object = "ext_pres_type";
            bundle.putString(object, (String)object2);
        }
        if ((object2 = this.b) != null) {
            object = "ext_pres_status";
            bundle.putString(object, (String)object2);
        }
        if ((n11 = this.a) != (n10 = -1 << -1)) {
            object = "ext_pres_prio";
            bundle.putInt(object, n11);
        }
        if ((object2 = this.a) != null && object2 != (object = gl$a.b)) {
            object2 = object2.toString();
            object = "ext_pres_mode";
            bundle.putString(object, (String)object2);
        }
        return bundle;
    }

    public String a() {
        int n10;
        int n11;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<presence");
        Object object = this.p();
        Object object2 = "\"";
        if (object != null) {
            stringBuilder.append(" xmlns=\"");
            object = this.p();
            stringBuilder.append((String)object);
            stringBuilder.append((String)object2);
        }
        if ((object = this.j()) != null) {
            stringBuilder.append(" id=\"");
            object = this.j();
            stringBuilder.append((String)object);
            stringBuilder.append((String)object2);
        }
        if ((object = this.l()) != null) {
            stringBuilder.append(" to=\"");
            object = gu.a(this.l());
            stringBuilder.append((String)object);
            stringBuilder.append((String)object2);
        }
        if ((object = this.m()) != null) {
            stringBuilder.append(" from=\"");
            object = gu.a(this.m());
            stringBuilder.append((String)object);
            stringBuilder.append((String)object2);
        }
        if ((object = this.k()) != null) {
            stringBuilder.append(" chid=\"");
            object = gu.a(this.k());
            stringBuilder.append((String)object);
            stringBuilder.append((String)object2);
        }
        if ((object = this.a) != null) {
            stringBuilder.append(" type=\"");
            object = this.a;
            stringBuilder.append(object);
            stringBuilder.append((String)object2);
        }
        stringBuilder.append(">");
        object = this.b;
        if (object != null) {
            stringBuilder.append("<status>");
            object = gu.a(this.b);
            stringBuilder.append((String)object);
            object = "</status>";
            stringBuilder.append((String)object);
        }
        if ((n11 = this.a) != (n10 = -1 << -1)) {
            stringBuilder.append("<priority>");
            n11 = this.a;
            stringBuilder.append(n11);
            object = "</priority>";
            stringBuilder.append((String)object);
        }
        if ((object = this.a) != null && object != (object2 = gl$a.b)) {
            stringBuilder.append("<show>");
            object = this.a;
            stringBuilder.append(object);
            object = "</show>";
            stringBuilder.append((String)object);
        }
        object = this.o();
        stringBuilder.append((String)object);
        object = this.a();
        if (object != null) {
            object = ((gn)object).a();
            stringBuilder.append((String)object);
        }
        stringBuilder.append("</presence>");
        return stringBuilder.toString();
    }

    public void a(int n10) {
        int n11 = -128;
        if (n10 >= n11 && n10 <= (n11 = 128)) {
            this.a = n10;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Priority value ");
        stringBuilder.append(n10);
        stringBuilder.append(" is not valid. Valid range is -128 through 128.");
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void a(gl$a gl$a) {
        this.a = gl$a;
    }

    public void a(gl$b gl$b) {
        Objects.requireNonNull(gl$b, "Type cannot be null");
        this.a = gl$b;
    }

    public void a(String string2) {
        this.b = string2;
    }
}

