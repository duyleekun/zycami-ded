/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.g;

import d.v.d.h.f;
import d.v.d.i.a.a;
import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class j
extends a {
    public j() {
        this.a = "";
    }

    private String n() {
        Serializable serializable = Locale.US;
        Object object = new SimpleDateFormat("yyyyMMdd_HHmmss", (Locale)serializable);
        serializable = new Date();
        object = ((DateFormat)object).format((Date)serializable);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("VID_");
        ((StringBuilder)serializable).append((String)object);
        ((StringBuilder)serializable).append(".mp4");
        return ((StringBuilder)serializable).toString();
    }

    public String o() {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("Record path get=");
        Object object2 = (String)this.a;
        ((StringBuilder)object).append((String)object2);
        object2 = ",isSupport=";
        ((StringBuilder)object).append((String)object2);
        boolean bl22 = this.i();
        ((StringBuilder)object).append(bl22);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = (String)this.a;
        boolean n10 = ((String)object).isEmpty();
        if (!n10 && !(bl2 = this.i())) {
            object2 = object = this.a;
            object2 = (String)object;
            object = (String)object;
            String string2 = File.separator;
            int n11 = ((String)object).lastIndexOf(string2);
            object = ((String)object2).substring(0, n11);
            object2 = new StringBuilder();
            String string3 = "Record path get parentPath=";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append((String)object);
            d.v.d.h.f.a(((StringBuilder)object2).toString());
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            object = this.n();
            ((StringBuilder)object2).append((String)object);
            this.a = object = ((StringBuilder)object2).toString();
        }
        return (String)super.get();
    }

    public String p() {
        return (String)this.a;
    }

    public void q(String string2) {
        Object object = new StringBuilder();
        String string3 = "Record path set=";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(string2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.a;
        boolean bl2 = string2.equals(object);
        if (bl2) {
            d.v.d.h.f.a("current is same value ,return");
            return;
        }
        super.set(string2);
    }
}

