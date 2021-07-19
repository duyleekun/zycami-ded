/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import java.nio.ByteBuffer;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class f {
    private static final String a = "f";
    private Map b;
    private byte[] c;
    private int d = 0;
    private long e;
    private long f;
    private long g;
    private String h;
    private int i = 2;
    private int j = 9001;
    private String k;
    private String l;
    private String m;
    private long n;
    private Exception o;
    private String p;
    private int q;

    public f(int n10, Map map, byte[] byArray, long l10) {
        String string2;
        this.k = string2 = "";
        this.l = string2;
        this.m = string2;
        this.n = 0L;
        this.d = n10;
        this.b = map;
        byte[] byArray2 = ByteBuffer.wrap(byArray).array();
        this.c = byArray2;
        this.e = l10;
        this.q();
    }

    public f(Exception exception, long l10) {
        String string2;
        this.k = string2 = "";
        this.l = string2;
        this.m = string2;
        this.n = 0L;
        this.o = exception;
        this.e = l10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(Map object) {
        block13: {
            long l10;
            long l11;
            int n10;
            long l12;
            long l13;
            block11: {
                block12: {
                    boolean bl2;
                    Object object2;
                    int n11;
                    block14: {
                        block10: {
                            if (object == null || (n11 = object.size()) <= 0) break block13;
                            object2 = "Cache-Control";
                            bl2 = object.containsKey(object2);
                            l13 = 1000L;
                            l12 = 0L;
                            n10 = 1;
                            if (!bl2) break block14;
                            n11 = (int)(TextUtils.isEmpty((CharSequence)(object = (String)object.get(object2))) ? 1 : 0);
                            if (n11 != 0 || !(bl2 = ((String)object).contains((CharSequence)(object2 = "max-age=")))) break block12;
                            try {
                                n11 = ((String)object).indexOf((String)object2) + 8;
                                object = ((String)object).substring(n11);
                                l11 = Long.parseLong((String)object);
                            }
                            catch (NumberFormatException numberFormatException) {
                                l11 = l12;
                                break block10;
                            }
                            try {
                                object = a;
                                String string2 = "Cache-Control value{%s}";
                                Object[] string3 = new Object[n10];
                                Long l14 = l11;
                                string3[0] = l14;
                                Logger.v((String)object, string2, string3);
                                break block11;
                            }
                            catch (NumberFormatException numberFormatException) {}
                        }
                        String object4 = a;
                        String string2 = "getExpireTime addHeadersToResult NumberFormatException";
                        Logger.w(object4, string2, (Throwable)object);
                        break block11;
                    }
                    object2 = "Expires";
                    bl2 = object.containsKey(object2);
                    if (bl2) {
                        long l15;
                        object2 = (String)object.get(object2);
                        Object object3 = a;
                        Object object4 = new Object[n10];
                        object4[0] = object2;
                        Logger.v((String)object3, "expires is{%s}", object4);
                        object4 = Locale.ROOT;
                        object3 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", (Locale)object4);
                        object4 = null;
                        String string3 = "Date";
                        boolean bl3 = object.containsKey(string3);
                        if (bl3) {
                            object = object.get(string3);
                            object4 = object;
                            object4 = (String)object;
                        }
                        try {
                            object = ((DateFormat)object3).parse((String)object2);
                            n11 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
                            object2 = n11 != 0 ? new Date() : ((DateFormat)object3).parse((String)object4);
                            l15 = ((Date)object).getTime();
                            l11 = ((Date)object2).getTime();
                            l15 -= l11;
                        }
                        catch (ParseException parseException) {
                            object2 = a;
                            object3 = "getExpireTime ParseException.";
                            Logger.w((String)object2, (String)object3, parseException);
                            break block12;
                        }
                        {
                            l11 = l15 / l13;
                            break block11;
                        }
                    }
                    object = a;
                    object2 = "response headers neither contains Cache-Control nor Expires.";
                    Logger.i((String)object, object2);
                }
                l11 = l12;
            }
            long l16 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l16 <= 0 || (l16 = (l10 = l11 - (l12 = 2592000L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
                l11 = 86400L;
            }
            object = a;
            Object[] objectArray = new Object[n10];
            Long l17 = l11 *= l13;
            objectArray[0] = l17;
            Logger.v((String)object, "convert expireTime{%s}", objectArray);
            l13 = System.currentTimeMillis();
            object = String.valueOf(l11 + l13);
            this.b((String)object);
            return;
        }
        Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
    }

    private void b(int n10) {
        this.j = n10;
    }

    private void b(String string2) {
        this.m = string2;
    }

    private void b(Map object) {
        int n10;
        if (object != null && (n10 = object.size()) > 0) {
            Object object2;
            boolean bl2;
            long l10 = 0L;
            Object[] objectArray = "Retry-After";
            boolean bl3 = object.containsKey(objectArray);
            if (bl3 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = (String)object.get(objectArray))))) {
                try {
                    l10 = Long.parseLong((String)object);
                }
                catch (NumberFormatException numberFormatException) {
                    objectArray = a;
                    object2 = "getRetryAfter addHeadersToResult NumberFormatException";
                    Logger.w((String)objectArray, (String)object2, numberFormatException);
                }
            }
            object = a;
            object2 = l10 *= 1000L;
            objectArray = new Object[]{object2};
            Logger.v((String)object, "convert retry-afterTime{%s}", objectArray);
            this.c(l10);
            return;
        }
        Logger.w(a, "getExpireTime {headers == null} or {headers.size() <= 0}");
    }

    private void c(int n10) {
        this.i = n10;
    }

    private void c(long l10) {
        this.n = l10;
    }

    private void c(String string2) {
        this.k = string2;
    }

    private void d(String string2) {
        this.l = string2;
    }

    private void e(String string2) {
        this.h = string2;
    }

    /*
     * WARNING - void declaration
     */
    private void n() {
        block35: {
            String string2;
            int n10;
            String string3;
            String string4;
            block36: {
                void var5_10;
                String string5;
                int n11;
                int n12;
                JSONObject jSONObject;
                String string6;
                block31: {
                    Object object;
                    block30: {
                        block29: {
                            String string7;
                            block28: {
                                block27: {
                                    string6 = "errorDesc";
                                    string4 = "errorList";
                                    string3 = "errorCode";
                                    string7 = "isSuccess";
                                    boolean n13 = this.m();
                                    n10 = 2;
                                    if (!n13) {
                                        Logger.i(a, "GRSSDK parse server body all failed.");
                                        this.c(n10);
                                        return;
                                    }
                                    object = this.c;
                                    object = StringUtils.byte2Str((byte[])object);
                                    jSONObject = new JSONObject((String)object);
                                    n12 = -1;
                                    boolean bl2 = jSONObject.has(string7);
                                    string2 = "resultCode";
                                    if (bl2) break block27;
                                    n11 = jSONObject.has(string2);
                                    if (n11 == 0) break block28;
                                    string7 = string2;
                                }
                                n12 = jSONObject.getInt(string7);
                                break block29;
                            }
                            string7 = a;
                            string5 = "sth. wrong because server errorcode's key.";
                            Logger.e(string7, string5);
                        }
                        this.c(n12);
                        n11 = 1;
                        string5 = "services";
                        if (n12 != 0) break block30;
                        boolean bl3 = ((String)object).contains(string5);
                        if (!bl3) break block30;
                        int n13 = n11;
                        break block31;
                    }
                    boolean bl4 = false;
                    object = null;
                }
                string2 = "";
                if (n12 != n11 && var5_10 == false) {
                    block34: {
                        int n14;
                        block33: {
                            block32: {
                                this.c(n10);
                                n14 = jSONObject.has(string3);
                                if (n14 == 0) break block32;
                                n14 = jSONObject.getInt(string3);
                                break block33;
                            }
                            n14 = 9001;
                        }
                        this.b(n14);
                        n14 = (int)(jSONObject.has(string6) ? 1 : 0);
                        if (n14 == 0) break block34;
                        string2 = jSONObject.getString(string6);
                    }
                    this.c(string2);
                }
                string6 = jSONObject.getJSONObject(string5);
                string6 = string6.toString();
                this.e(string6);
                if (var5_10 == false) break block35;
                boolean bl5 = jSONObject.has(string4);
                if (!bl5) break block36;
                string2 = jSONObject.getString(string4);
            }
            try {
                this.d(string2);
            }
            catch (JSONException jSONException) {
                string4 = a;
                string3 = "GrsResponse GrsResponse(String result) JSONException";
                Logger.w(string4, string3, jSONException);
                this.c(n10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void o() {
        boolean bl2 = this.m();
        if (!bl2 && !(bl2 = this.l())) {
            return;
        }
        Map map = this.p();
        try {
            boolean bl3 = this.m();
            if (bl3) {
                this.a(map);
            }
            if (!(bl3 = this.l())) return;
            this.b(map);
            return;
        }
        catch (JSONException jSONException) {
            String string2 = a;
            String string3 = "parseHeader catch JSONException";
            Logger.w(string2, string3, jSONException);
        }
    }

    private Map p() {
        int n10 = 16;
        HashMap<String, Map.Entry> hashMap = new HashMap<String, Map.Entry>(n10);
        Object object = this.b;
        if (object != null && (n10 = object.size()) > 0) {
            boolean bl2;
            object = this.b.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                Map.Entry entry = (Map.Entry)object.next();
                String string2 = (String)entry.getKey();
                entry = ((List)entry.getValue()).get(0);
                hashMap.put(string2, entry);
            }
            return hashMap;
        }
        Logger.v(a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
        return hashMap;
    }

    private void q() {
        this.o();
        this.n();
    }

    public String a() {
        return this.m;
    }

    public void a(int n10) {
        this.q = n10;
    }

    public void a(long l10) {
        this.g = l10;
    }

    public void a(String string2) {
        this.p = string2;
    }

    public int b() {
        return this.d;
    }

    public void b(long l10) {
        this.f = l10;
    }

    public int c() {
        return this.j;
    }

    public Exception d() {
        return this.o;
    }

    public int e() {
        return this.i;
    }

    public long f() {
        return this.g;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public String i() {
        return this.h;
    }

    public long j() {
        return this.n;
    }

    public String k() {
        return this.p;
    }

    public boolean l() {
        int n10 = this.d;
        int n11 = 503;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public boolean m() {
        int n10 = this.d;
        int n11 = 200;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }
}

