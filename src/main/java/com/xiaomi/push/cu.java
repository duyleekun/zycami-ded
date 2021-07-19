/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class cu {
    private int a;
    private long a;
    private String a;
    private long b;
    private long c;

    public cu() {
        this(0, 0L, 0L, null);
    }

    public cu(int n10, long l10, long l11, Exception exception) {
        long l12;
        this.a = n10;
        this.a = l10;
        this.c = l11;
        this.b = l12 = System.currentTimeMillis();
        if (exception != null) {
            String string2;
            this.a = string2 = exception.getClass().getSimpleName();
        }
    }

    public int a() {
        return this.a;
    }

    public cu a(JSONObject object) {
        int n10;
        long l10;
        this.a = l10 = object.getLong("cost");
        this.c = l10 = object.getLong("size");
        this.b = l10 = object.getLong("ts");
        this.a = n10 = object.getInt("wt");
        object = object.optString("expt");
        this.a = object;
        return this;
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        long l10 = this.a;
        jSONObject.put("cost", l10);
        l10 = this.c;
        jSONObject.put("size", l10);
        l10 = this.b;
        jSONObject.put("ts", l10);
        int n10 = this.a;
        jSONObject.put("wt", n10);
        String string2 = this.a;
        jSONObject.put("expt", (Object)string2);
        return jSONObject;
    }
}

