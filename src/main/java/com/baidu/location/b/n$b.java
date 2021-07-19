/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import com.baidu.location.b.n;
import org.json.JSONObject;

public class n$b {
    public final /* synthetic */ n a;
    private String b;
    private String c;
    private long d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public n$b(n n10, String string2) {
        long l10;
        String string3 = "timeout";
        String string4 = "callback";
        String string5 = "action";
        this.a = n10;
        n10 = null;
        this.b = null;
        this.c = null;
        this.d = l10 = 0L;
        try {
            long l11;
            long l12;
            long l13;
            JSONObject jSONObject = new JSONObject(string2);
            int n11 = jSONObject.has(string5);
            if (n11 != 0) {
                this.b = string2 = jSONObject.getString(string5);
            }
            if ((n11 = jSONObject.has(string4)) != 0) {
                this.c = string2 = jSONObject.getString(string4);
            }
            if ((n11 = jSONObject.has(string3)) != 0 && (n11 = (l13 = (l12 = jSONObject.getLong(string3)) - (l11 = 1000L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
                n.a(l12);
            }
            this.d = l12 = System.currentTimeMillis();
            return;
        }
        catch (Exception exception) {
            this.b = null;
            this.c = null;
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }
}

