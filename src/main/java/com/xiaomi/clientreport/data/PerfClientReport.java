/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.data.a;
import org.json.JSONException;
import org.json.JSONObject;

public class PerfClientReport
extends a {
    private static final long DEFAULT_VALUE = 255L;
    public int code;
    public long perfCounts;
    public long perfLatencies;

    public PerfClientReport() {
        long l10;
        this.perfCounts = l10 = (long)-1;
        this.perfLatencies = l10;
    }

    public static PerfClientReport getBlankInstance() {
        PerfClientReport perfClientReport = new PerfClientReport();
        return perfClientReport;
    }

    public JSONObject toJson() {
        String string2;
        JSONObject jSONObject;
        try {
            jSONObject = super.toJson();
            if (jSONObject == null) {
                return null;
            }
            string2 = "code";
        }
        catch (JSONException jSONException) {
            b.a(jSONException);
            return null;
        }
        int n10 = this.code;
        jSONObject.put(string2, n10);
        string2 = "perfCounts";
        long l10 = this.perfCounts;
        jSONObject.put(string2, l10);
        string2 = "perfLatencies";
        l10 = this.perfLatencies;
        jSONObject.put(string2, l10);
        return jSONObject;
    }

    public String toJsonString() {
        return super.toJsonString();
    }
}

