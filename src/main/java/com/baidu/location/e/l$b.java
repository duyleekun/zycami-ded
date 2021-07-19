/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import com.baidu.location.e.l;
import com.baidu.location.e.l$1;
import com.baidu.location.e.m;
import com.baidu.location.e.n;
import com.baidu.location.e.o;
import com.baidu.location.e.p;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

public abstract class l$b
extends Enum {
    public static final /* enum */ l$b a;
    public static final /* enum */ l$b b;
    public static final /* enum */ l$b c;
    public static final /* enum */ l$b d;
    private static final /* synthetic */ l$b[] j;
    private final int e;
    private final String f;
    private final String g;
    private final String h;
    private final int i;

    static {
        m m10;
        l$b l$b = m10;
        m10 = new m("RGCAREA", "area", "addrv", 0, 1000);
        a = m10;
        int n10 = 1000;
        l$b = new n("RGCROAD", "road", "addrv", n10, 10000);
        b = l$b;
        o o10 = new o("RGCSITE", "site", "addrv", 100, 50000);
        c = o10;
        p p10 = new p("RGCPOI", "poi", "poiv", n10, 5000);
        d = p10;
        l$b[] l$bArray = new l$b[]{m10, l$b, o10, p10};
        j = l$bArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private l$b(String string3, int n10, int n11) {
        void var7_5;
        void var6_4;
        void var2_-1;
        void var1_-1;
        this.f = string3;
        this.g = (String)n10;
        this.h = (String)n11;
        this.e = var6_4;
        this.i = var7_5;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ l$b(String string2, String string3, String string4, int n10, int n11, l$1 l$1) {
        this((String)var1_-1, (int)string3, string4, (String)n10, (String)n11, (int)l$1, (int)var7_6);
        void var7_6;
        void var1_-1;
    }

    private String a(int n10, double d10, double d11) {
        String string2;
        boolean bl2;
        Object object;
        int n11;
        l$b l$b = this;
        Object[] objectArray = new HashSet();
        CharSequence charSequence = l.a(n10, d10, d11);
        objectArray.add(charSequence);
        int n12 = this.e;
        double d12 = n12;
        double d13 = 1.414;
        d12 *= d13;
        int n13 = 1;
        if (n12 > 0) {
            charSequence = null;
            for (n12 = 0; n12 < (n11 = ((double[])(object = l.c())).length); ++n12) {
                double d14 = l.c()[n12];
                object = l.a(d11, d10, d12, d14);
                double d15 = object[n13];
                double d16 = object[0];
                n11 = n10;
                String string3 = l.a(n10, d15, d16);
                objectArray.add(string3);
            }
        }
        charSequence = new StringBuffer();
        objectArray = objectArray.iterator();
        int n14 = n13;
        while (bl2 = objectArray.hasNext()) {
            String string4 = (String)objectArray.next();
            if (n14 != 0) {
                n14 = 0;
                string2 = null;
            } else {
                n11 = 44;
                ((StringBuffer)charSequence).append((char)n11);
            }
            object = "\"";
            ((StringBuffer)charSequence).append((String)object);
            ((StringBuffer)charSequence).append(string4);
            ((StringBuffer)charSequence).append((String)object);
        }
        objectArray = new Object[2];
        string2 = l$b.f;
        objectArray[0] = string2;
        charSequence = ((StringBuffer)charSequence).toString();
        objectArray[n13] = charSequence;
        return String.format("SELECT * FROM %s WHERE gridkey IN (%s);", objectArray);
    }

    public static /* synthetic */ String a(l$b l$b) {
        return l$b.g;
    }

    public static /* synthetic */ String a(l$b l$b, int n10, double d10, double d11) {
        return l$b.a(n10, d10, d11);
    }

    public static /* synthetic */ String a(l$b l$b, JSONObject jSONObject) {
        return l$b.a(jSONObject);
    }

    private String a(JSONObject object) {
        Object[] objectArray;
        boolean bl2;
        object = object.keys();
        StringBuffer stringBuffer = new StringBuffer();
        while (bl2 = object.hasNext()) {
            String string2;
            objectArray = (Object[])object.next();
            int n10 = stringBuffer.length();
            if (n10 != 0) {
                string2 = ",";
                stringBuffer.append(string2);
            }
            string2 = "\"";
            stringBuffer.append(string2);
            stringBuffer.append((String)objectArray);
            stringBuffer.append(string2);
        }
        object = Locale.US;
        objectArray = new Object[2];
        String string3 = this.f;
        objectArray[0] = string3;
        objectArray[1] = stringBuffer;
        return String.format((Locale)object, "DELETE FROM %s WHERE gridkey IN (%s)", objectArray);
    }

    public static /* synthetic */ void a(StringBuffer stringBuffer, String string2, String string3, int n10) {
        l$b.b(stringBuffer, string2, string3, n10);
    }

    public static /* synthetic */ String b(l$b l$b) {
        return l$b.h;
    }

    private static void b(StringBuffer stringBuffer, String string2, String string3, int n10) {
        int n11 = stringBuffer.length();
        String string4 = ",";
        if (n11 > 0) {
            stringBuffer.append(string4);
        }
        stringBuffer.append("(\"");
        stringBuffer.append(string2);
        stringBuffer.append("\",\"");
        stringBuffer.append(string3);
        stringBuffer.append("\",");
        stringBuffer.append(n10);
        stringBuffer.append(string4);
        long l10 = System.currentTimeMillis() / 86400000L;
        stringBuffer.append(l10);
        stringBuffer.append(")");
    }

    public static /* synthetic */ int c(l$b l$b) {
        return l$b.i;
    }

    public static /* synthetic */ int d(l$b l$b) {
        return l$b.e;
    }

    public static l$b valueOf(String string2) {
        return Enum.valueOf(l$b.class, string2);
    }

    public static l$b[] values() {
        return (l$b[])j.clone();
    }

    public abstract List a(JSONObject var1, String var2, int var3);
}

