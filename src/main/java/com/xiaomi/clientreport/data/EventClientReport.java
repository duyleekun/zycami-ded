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

public class EventClientReport
extends a {
    public String eventContent;
    public String eventId;
    public long eventTime;
    public int eventType;

    public static EventClientReport getBlankInstance() {
        EventClientReport eventClientReport = new EventClientReport();
        return eventClientReport;
    }

    public JSONObject toJson() {
        String string2;
        String string3;
        JSONObject jSONObject;
        block11: {
            try {
                jSONObject = super.toJson();
                if (jSONObject == null) {
                    return null;
                }
                string3 = "eventId";
            }
            catch (JSONException jSONException) {
                b.a(jSONException);
                return null;
            }
            string2 = this.eventId;
            jSONObject.put(string3, (Object)string2);
            string3 = "eventType";
            int n10 = this.eventType;
            jSONObject.put(string3, n10);
            string3 = "eventTime";
            long l10 = this.eventTime;
            jSONObject.put(string3, l10);
            string3 = "eventContent";
            string2 = this.eventContent;
            if (string2 != null) break block11;
            string2 = "";
        }
        jSONObject.put(string3, (Object)string2);
        return jSONObject;
    }

    public String toJsonString() {
        return super.toJsonString();
    }
}

