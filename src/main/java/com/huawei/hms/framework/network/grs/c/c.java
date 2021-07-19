/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.c.n;
import com.huawei.hms.framework.network.grs.d.e;
import org.json.JSONException;

public class c {
    private Context a;
    private GrsBaseInfo b;
    private com.huawei.hms.framework.network.grs.a.a c;

    public c(Context context, com.huawei.hms.framework.network.grs.a.a a10, GrsBaseInfo grsBaseInfo) {
        this.a = context;
        this.b = grsBaseInfo;
        this.c = a10;
    }

    public String a(boolean bl2) {
        boolean bl3;
        Object object = this.c.a();
        String string2 = "";
        object = ((com.huawei.hms.framework.network.grs.a.c)object).a("geoipCountryCode", string2);
        String string3 = "geoip.countrycode";
        String string4 = "ROOT";
        object = com.huawei.hms.framework.network.grs.a.a((String)object, string3, string4);
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("geoIpCountry is: ");
        ((StringBuilder)object2).append((String)object);
        object2 = ((StringBuilder)object2).toString();
        String string5 = "GeoipCountry";
        Logger.i(string5, object2);
        object2 = this.c.a();
        Object object3 = "geoipCountryCodetime";
        String string6 = "0";
        object2 = ((com.huawei.hms.framework.network.grs.a.c)object2).a((String)object3, string6);
        boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
        long l10 = 0L;
        if (!bl4 && (bl4 = ((String)object2).matches((String)(object3 = "\\d+")))) {
            try {
                l10 = Long.parseLong((String)object2);
            }
            catch (NumberFormatException numberFormatException) {
                object3 = "convert urlParamKey from String to Long catch NumberFormatException.";
                Logger.w(string5, (String)object3, numberFormatException);
            }
        }
        if ((bl3 = TextUtils.isEmpty((CharSequence)object)) || (bl3 = e.a((Long)(object2 = Long.valueOf(l10))))) {
            object3 = this.b;
            string6 = this.a;
            object2 = new com.huawei.hms.framework.network.grs.c.b.c((GrsBaseInfo)object3, (Context)string6);
            ((com.huawei.hms.framework.network.grs.c.b.c)object2).a(string3);
            object3 = this.c.c();
            string6 = null;
            if (object3 != null) {
                String string7 = "services";
                string2 = ((com.huawei.hms.framework.network.grs.a.c)object3).a(string7, string2);
                String string8 = ((com.huawei.hms.framework.network.grs.c.b.c)object2).c();
                try {
                    string2 = n.a(string2, string8);
                }
                catch (JSONException jSONException) {
                    string8 = "getGeoipCountry merge services occure jsonException.";
                    Logger.w(string5, string8, jSONException);
                    string2 = null;
                }
                boolean bl5 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl5) {
                    ((com.huawei.hms.framework.network.grs.a.c)object3).b(string7, string2);
                }
            }
            if (bl2) {
                Object object4 = this.c.b().a((com.huawei.hms.framework.network.grs.c.b.c)object2, string3, (com.huawei.hms.framework.network.grs.a.c)object3);
                if (object4 != null) {
                    object = object4 = com.huawei.hms.framework.network.grs.a.a(((f)object4).i(), string3, string4);
                }
                object4 = new StringBuilder();
                string3 = "sync request to query geoip.countrycode is:";
                ((StringBuilder)object4).append(string3);
                ((StringBuilder)object4).append((String)object);
                object4 = ((StringBuilder)object4).toString();
                Logger.i(string5, object4);
            } else {
                Logger.i(string5, "async request to query geoip.countrycode");
                m m10 = this.c.b();
                m10.a((com.huawei.hms.framework.network.grs.c.b.c)object2, null, string3, (com.huawei.hms.framework.network.grs.a.c)object3);
            }
        }
        return object;
    }
}

