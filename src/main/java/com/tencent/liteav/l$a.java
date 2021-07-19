/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.l$b;
import org.json.JSONException;
import org.json.JSONObject;

public class l$a
extends l$b {
    private int c = 60;
    private boolean d = false;
    private long e = 0L;

    public l$a(int n10, boolean bl2, long l10, String string2) {
        super(string2, "40302");
        this.c = n10;
        this.d = bl2;
        this.e = l10;
    }

    public l$a(String string2) {
        this.a(string2);
    }

    public static /* synthetic */ long a(l$a l$a) {
        return l$a.e;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        String string2 = "SengmentDuration";
        int bl2 = this.c;
        jSONObject.put(string2, bl2);
        string2 = "ReportSwitch";
        boolean bl3 = this.d;
        jSONObject.put(string2, bl3);
        string2 = "ExpireTime";
        long l10 = this.e;
        jSONObject.put(string2, l10);
        string2 = "appid";
        CharSequence charSequence = this.a;
        jSONObject.put(string2, (Object)charSequence);
        string2 = "eventid";
        charSequence = this.b;
        try {
            jSONObject.put(string2, (Object)charSequence);
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            String string3 = "toJsonObject jsonexception: ";
            charSequence.append(string3);
            String string4 = jSONException.toString();
            charSequence.append(string4);
            string4 = charSequence.toString();
            charSequence = "TXCVodPlayReportControl";
            TXCLog.e((String)charSequence, string4);
        }
        return jSONObject;
    }

    public static /* synthetic */ int b(l$a l$a) {
        return l$a.c;
    }

    public static /* synthetic */ boolean c(l$a l$a) {
        return l$a.d;
    }

    public void a(String string2) {
        String string3 = "";
        int n10 = 60;
        Object object = new JSONObject(string2);
        string2 = "SengmentDuration";
        int n11 = object.optInt(string2, n10);
        this.c = n11;
        string2 = "ReportSwitch";
        n11 = (int)(object.optBoolean(string2, false) ? 1 : 0);
        this.d = n11;
        string2 = "ExpireTime";
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        l10 /= l11;
        l11 = 3600L;
        l10 += l11;
        l10 = object.optLong(string2, l10);
        this.e = l10;
        string2 = "appid";
        string2 = object.optString(string2, string3);
        this.a = string2;
        string2 = "eventid";
        string2 = object.optString(string2, string3);
        try {
            this.b = string2;
        }
        catch (JSONException jSONException) {
            long l12;
            object = new StringBuilder();
            String string4 = "parseFromString: ";
            ((StringBuilder)object).append(string4);
            String string5 = jSONException.toString();
            ((StringBuilder)object).append(string5);
            string5 = ((StringBuilder)object).toString();
            object = "TXCVodPlayReportControl";
            TXCLog.i((String)object, string5);
            this.c = n10;
            this.d = false;
            this.e = l12 = 0L;
            this.a = string3;
            this.b = string5 = "40302";
        }
    }

    public String toString() {
        return this.a().toString();
    }
}

