/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.quvideo.mobile.external.platform.httpcore.country;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.gson.Gson;
import com.quvideo.mobile.external.platform.httpcore.country.OooO0O0;
import com.quvideo.mobile.external.platform.httpcore.country.OooO0O0$OooO00o;
import com.quvideo.mobile.external.platform.httpcore.country.OooO0o;
import com.quvideo.mobile.external.platform.httpcore.country.OooOO0;
import com.quvideo.mobile.external.platform.httpcore.country.OooOO0O;
import java.util.Locale;

public class OooO0OO {
    private OooO0o OooO00o;
    private OooO0O0 OooO0O0;
    private com.quvideo.mobile.external.platform.httpcore.util.OooO0O0 OooO0OO;

    public OooO0OO(Context object, String object2, OooOO0O object3) {
        Object object4 = new OooO0o();
        this.OooO00o = object4;
        this.OooO0OO = object4 = new com.quvideo.mobile.external.platform.httpcore.util.OooO0O0((Context)object, "QuVideoZone");
        String string2 = "qv_key_country_zone";
        Gson gson = null;
        object4 = ((com.quvideo.mobile.external.platform.httpcore.util.OooO0O0)object4).OooO00o(string2, null);
        OooOO0.OooO00o((Context)object);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object4);
        if (!bl2) {
            gson = new Gson();
            Class<OooO0O0> clazz = OooO0O0.class;
            this.OooO0O0 = object4 = (OooO0O0)gson.fromJson((String)object4, clazz);
        }
        if ((object4 = this.OooO0O0) == null) {
            boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl3) {
                this.OooO0O0 = object;
                object4 = OooO0O0$OooO00o.SIM;
                ((OooO0O0)object).OooO00o((OooO0O0$OooO00o)((Object)object4));
                this.OooO0O0.OooO00o((String)object2);
                object = this.OooO0O0;
                if (object3 == null) {
                    object3 = ((OooO0O0)object).OooO00o();
                    object3 = this.OooO00o((String)object3);
                }
                ((OooO0O0)object).OooO00o((OooOO0O)((Object)object3));
                object = this.OooO0OO;
                super();
                object4 = this.OooO0O0;
                object3 = ((Gson)object3).toJson(object4);
                ((com.quvideo.mobile.external.platform.httpcore.util.OooO0O0)object).OooO0O0(string2, (String)object3);
                object = new StringBuilder();
                object3 = "defaultCountryCode=";
                ((StringBuilder)object).append((String)object3);
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(",zone=");
                object2 = this.OooO0O0.OooO0O0();
                ((StringBuilder)object).append(object2);
                object = ((StringBuilder)object).toString();
                object2 = "Jamin-->CountryZoneMgr";
                Log.d((String)object2, (String)object);
            } else {
                object = this.OooO00o((Context)object);
                this.OooO0O0 = object;
                object = this.OooO0OO;
                object2 = new Gson();
                object3 = this.OooO0O0;
                object2 = ((Gson)object2).toJson(object3);
                ((com.quvideo.mobile.external.platform.httpcore.util.OooO0O0)object).OooO0O0(string2, (String)object2);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private OooO0O0 OooO00o(Context object) {
        void var1_4;
        OooO0O0 oooO0O0 = new OooO0O0();
        String string2 = OooOO0.OooO00o(object);
        String string3 = Locale.getDefault().getCountry().toUpperCase();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            oooO0O0.OooO00o(string2);
            OooO0O0$OooO00o oooO0O0$OooO00o = OooO0O0$OooO00o.SIM;
        } else {
            boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
            if (!bl3) {
                oooO0O0.OooO00o(string3);
            } else {
                String string4 = "US";
                oooO0O0.OooO00o(string4);
            }
            OooO0O0$OooO00o oooO0O0$OooO00o = OooO0O0$OooO00o.LOCALE;
        }
        oooO0O0.OooO00o((OooO0O0$OooO00o)var1_4);
        String string5 = oooO0O0.OooO00o();
        OooOO0O oooOO0O = this.OooO00o(string5);
        oooO0O0.OooO00o(oooOO0O);
        return oooO0O0;
    }

    private OooOO0O OooO00o(String object) {
        Object object2 = "CN";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            object = OooOO0O.ZONE_BIG_CHINA;
        } else {
            object2 = this.OooO00o;
            object = ((OooO0o)object2).OooO00o((String)object);
        }
        return object;
    }

    public String OooO00o() {
        return this.OooO0O0.OooO00o();
    }

    public OooOO0O OooO0O0() {
        return this.OooO0O0.OooO0O0();
    }
}

