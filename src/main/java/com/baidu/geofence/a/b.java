/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.geofence.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.geofence.GeoFenceClient;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.a.a;
import com.baidu.geofence.a.b$a;
import com.baidu.geofence.a.c;
import com.baidu.geofence.a.d;
import com.baidu.geofence.a.e;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import com.baidu.location.b.aa;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class b
extends f
implements LBSAuthManagerListener {
    private final String a;
    private String b;
    private String c;
    private boolean d = false;
    private GeoFenceListener e;
    private b$a f;

    public b(String string2, Context context) {
        this.a = "https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/geocoding/v3/";
        this.c = string2;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
    }

    public static /* synthetic */ GeoFenceListener a(b b10) {
        return b10.e;
    }

    public static /* synthetic */ b$a b(b b10) {
        return b10.f;
    }

    public void a() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = true;
        ExecutorService executorService = aa.a().c();
        this.a(executorService);
    }

    public void a(GeoFenceListener geoFenceListener) {
        this.e = geoFenceListener;
    }

    public void a(b$a b$a) {
        this.f = b$a;
    }

    public void a(boolean bl2) {
        block13: {
            Object object;
            Object object2;
            boolean bl3;
            Object object3 = "status";
            if (bl2 && (bl3 = TextUtils.isEmpty((CharSequence)(object2 = this.j)))) {
                Handler handler = GeoFenceClient.getHandlerInstance();
                object3 = new c(this);
                handler.post((Runnable)object3);
                return;
            }
            if (!bl2) {
                Handler object4 = GeoFenceClient.getHandlerInstance();
                object3 = new d(this);
                object4.post((Runnable)object3);
                return;
            }
            if (bl2 && (object = this.j) != null) {
                object2 = this.j;
                object = new JSONObject((String)object2);
                bl3 = object.has((String)object3);
                if (!bl3) break block13;
                int n10 = object.optInt((String)object3);
                object3 = GeoFenceClient.getHandlerInstance();
                object2 = new e(this, n10);
                try {
                    object3.post((Runnable)object2);
                }
                catch (JSONException jSONException) {
                    object = this.e;
                    if (object == null) break block13;
                    int n11 = 10;
                    bl3 = false;
                    object2 = null;
                    object.onGeoFenceCreateFinished(null, n11, null);
                }
            }
        }
        this.d = false;
    }

    public void b() {
        CharSequence charSequence = "json";
        Object object = "UTF-8";
        int n10 = 128;
        StringBuffer stringBuffer = new StringBuffer(n10);
        String string2 = "address=";
        stringBuffer.append(string2);
        string2 = this.c;
        string2 = URLEncoder.encode(string2, object);
        stringBuffer.append(string2);
        string2 = "&token=";
        stringBuffer.append(string2);
        string2 = this.b;
        string2 = URLEncoder.encode(string2, object);
        stringBuffer.append(string2);
        string2 = "&output=";
        stringBuffer.append(string2);
        object = URLEncoder.encode((String)charSequence, object);
        try {
            stringBuffer.append((String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            unsupportedEncodingException.printStackTrace();
        }
        object = new HashMap();
        string2 = this.c;
        ((HashMap)object).put("address", string2);
        string2 = this.b;
        ((HashMap)object).put("token", string2);
        ((HashMap)object).put("output", charSequence);
        charSequence = com.baidu.geofence.a.a.a(object, "&");
        stringBuffer.append("&sign=");
        stringBuffer.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("https://api.map.baidu.com/sdkproxy/v2/lbs_locsdk/geocoding/v3/?");
        object = stringBuffer.toString();
        ((StringBuilder)charSequence).append((String)object);
        charSequence = ((StringBuilder)charSequence).toString();
        this.h = charSequence;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onAuthResult(int n10, String string2) {
        Object object;
        String string3 = "token";
        if (n10 != 0 && (object = this.e) != null) {
            int n11 = 11;
            object.onGeoFenceCreateFinished(null, n11, null);
        }
        if (string2 == null) return;
        try {
            object = new JSONObject(string2);
            boolean bl2 = object.has(string3);
            if (!bl2) return;
            this.b = object = object.optString(string3);
            n10 = (int)(com.baidu.location.h.l.b() ? 1 : 0);
            if (n10 != 0) return;
            object = this.b;
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 != 0) return;
            this.a();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

