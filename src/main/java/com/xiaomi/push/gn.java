/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import com.xiaomi.push.gg;
import com.xiaomi.push.gk;
import com.xiaomi.push.gn$a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gn {
    private int a;
    private String a;
    private List a = null;
    private String b;
    private String c;
    private String d;

    public gn(int n10, String string2, String string3, String string4, String string5, List list) {
        this.a = n10;
        this.a = string2;
        this.c = string3;
        this.b = string4;
        this.d = string5;
        this.a = list;
    }

    public gn(Bundle parcelableArray) {
        int n10;
        this.a = n10 = parcelableArray.getInt("ext_err_code");
        Object object = "ext_err_type";
        int n11 = parcelableArray.containsKey((String)object);
        if (n11 != 0) {
            object = parcelableArray.getString((String)object);
            this.a = object;
        }
        object = parcelableArray.getString("ext_err_cond");
        this.b = object;
        object = parcelableArray.getString("ext_err_reason");
        this.c = object;
        object = parcelableArray.getString("ext_err_msg");
        this.d = object;
        object = "ext_exts";
        if ((parcelableArray = parcelableArray.getParcelableArray((String)object)) != null) {
            n11 = parcelableArray.length;
            this.a = object = new Object(n11);
            n10 = parcelableArray.length;
            for (n11 = 0; n11 < n10; ++n11) {
                gg gg2 = gg.a((Bundle)parcelableArray[n11]);
                if (gg2 == null) continue;
                List list = this.a;
                list.add(gg2);
            }
        }
    }

    public gn(gn$a gn$a) {
        this.a(gn$a);
        this.d = null;
    }

    private void a(gn$a object) {
        this.b = object = gn$a.a((gn$a)object);
    }

    public Bundle a() {
        String string2;
        Bundle bundle = new Bundle();
        Object object = this.a;
        if (object != null) {
            string2 = "ext_err_type";
            bundle.putString(string2, (String)object);
        }
        int n10 = this.a;
        string2 = "ext_err_code";
        bundle.putInt(string2, n10);
        object = this.c;
        if (object != null) {
            string2 = "ext_err_reason";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.b) != null) {
            string2 = "ext_err_cond";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.d) != null) {
            string2 = "ext_err_msg";
            bundle.putString(string2, (String)object);
        }
        if ((object = this.a) != null) {
            boolean bl2;
            n10 = object.size();
            object = new Bundle[n10];
            int n11 = 0;
            string2 = null;
            Iterator iterator2 = this.a.iterator();
            while (bl2 = iterator2.hasNext()) {
                Bundle bundle2 = ((gg)iterator2.next()).a();
                if (bundle2 == null) continue;
                int n12 = n11 + 1;
                object[n11] = bundle2;
                n11 = n12;
            }
            string2 = "ext_exts";
            bundle.putParcelableArray(string2, (Parcelable[])object);
        }
        return bundle;
    }

    public String a() {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<error code=\"");
        int n10 = this.a;
        stringBuilder.append(n10);
        Object object = "\"";
        stringBuilder.append((String)object);
        String string2 = this.a;
        if (string2 != null) {
            stringBuilder.append(" type=\"");
            string2 = this.a;
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
        }
        if ((string2 = this.c) != null) {
            stringBuilder.append(" reason=\"");
            string2 = this.c;
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
        }
        stringBuilder.append(">");
        object = this.b;
        if (object != null) {
            stringBuilder.append("<");
            object = this.b;
            stringBuilder.append((String)object);
            object = " xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>";
            stringBuilder.append((String)object);
        }
        if ((object = this.d) != null) {
            stringBuilder.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            object = this.d;
            stringBuilder.append((String)object);
            object = "</text>";
            stringBuilder.append((String)object);
        }
        object = this.a().iterator();
        while (bl2 = object.hasNext()) {
            string2 = ((gk)object.next()).d();
            stringBuilder.append(string2);
        }
        stringBuilder.append("</error>");
        return stringBuilder.toString();
    }

    public List a() {
        synchronized (this) {
            List list = this.a;
            if (list == null) {
                list = Collections.emptyList();
                return list;
            }
            list = Collections.unmodifiableList(list);
            return list;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.b;
        if (string2 != null) {
            stringBuilder.append(string2);
        }
        stringBuilder.append("(");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        string2 = this.d;
        if (string2 != null) {
            stringBuilder.append(" ");
            string2 = this.d;
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

