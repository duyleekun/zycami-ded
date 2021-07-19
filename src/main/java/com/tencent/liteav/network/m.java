/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.tencent.liteav.network;

import android.content.Context;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.network.m$a;
import org.json.JSONArray;
import org.json.JSONObject;

public class m {
    public static m a;
    private Context b = null;
    private long c = 3;

    static {
        m m10;
        a = m10 = new m();
    }

    private m$a a(String string2, boolean bl2) {
        long l10;
        long l11;
        boolean bl3;
        float f10;
        String string3;
        Object object;
        Object object2;
        int n10;
        Object object3;
        String string4;
        String string5;
        String string6;
        Object object4;
        m m10;
        block43: {
            block42: {
                m10 = this;
                object4 = "avgAudioQue";
                string6 = "avgVideoQue";
                string5 = "avgBlockCnt";
                string4 = "networkRTT";
                object3 = "";
                boolean bl4 = this.b(string2);
                n10 = 0;
                object2 = null;
                if (bl4) {
                    return null;
                }
                object = this.b;
                string3 = "com.tencent.liteav.network";
                f10 = 0.0f;
                object = object.getSharedPreferences(string3, 0);
                string3 = "34238512-C08C-4931-A000-40E1D8B5BA5B";
                object = object.getString(string3, (String)object3);
                bl3 = this.b((String)object);
                if (!bl3) break block42;
                return null;
            }
            string3 = new JSONObject((String)object);
            object = string2;
            object = string3.optJSONObject(string2);
            if (object == null) {
                return null;
            }
            string3 = bl2 ? "DomainArrayData" : "OriginArrayData";
            object = object.optJSONArray(string3);
            if (object != null) break block43;
            return null;
        }
        long l12 = object.length();
        long l13 = 0L;
        bl3 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (!bl3) {
            return null;
        }
        bl3 = false;
        string3 = null;
        string2 = null;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        int n11 = 0;
        while ((n10 = (l11 = (l10 = (long)n11) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
            object2 = object.getJSONObject(n11);
            long l14 = object2.optLong(string4);
            f10 = l14;
            f10 = f11 + f10;
            double d10 = f12;
            double d11 = object2.optDouble(string5);
            f12 = (float)(d10 + d11);
            d10 = f13;
            d11 = object2.optDouble(string6);
            f13 = (float)(d10 + d11);
            d10 = f14;
            d11 = object2.optDouble((String)object4);
            f14 = (float)(d10 += d11);
            String string7 = "%s \n isDomainAddressBetter\uff1aitemData domain = %b NetworkRTT = %d avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f";
            int n12 = 6;
            Object[] objectArray = new Object[n12];
            bl3 = false;
            string3 = null;
            objectArray[0] = object3;
            object3 = bl2;
            int n13 = 1;
            objectArray[n13] = object3;
            int n14 = 2;
            long l15 = object2.optLong(string4);
            Number number = l15;
            objectArray[n14] = number;
            n14 = 3;
            d11 = object2.optDouble(string5);
            number = d11;
            objectArray[n14] = number;
            n14 = 4;
            d11 = object2.optDouble(string6);
            number = d11;
            objectArray[n14] = number;
            n14 = 5;
            d11 = object2.optDouble((String)object4);
            object2 = d11;
            objectArray[n14] = object2;
            object3 = String.format(string7, objectArray);
            ++n11;
            f11 = f10;
            f10 = 0.0f;
        }
        float f15 = l12;
        float f16 = f11 / f15;
        f12 /= f15;
        f13 /= f15;
        f14 /= f15;
        try {
            object4 = new m$a(m10);
        }
        catch (Exception exception) {
            TXCLog.e("UploadQualityData", "get quality data failed.", exception);
            return null;
        }
        ((m$a)object4).a = f16;
        ((m$a)object4).b = f12;
        ((m$a)object4).c = f13;
        ((m$a)object4).d = f14;
        ((m$a)object4).e = l12;
        return object4;
    }

    public static m a() {
        return a;
    }

    private boolean b(String string2) {
        int n10;
        return string2 == null || (n10 = string2.length()) == 0;
        {
        }
    }

    private JSONObject c(String string2) {
        boolean bl2 = this.b(string2);
        if (!bl2) {
            Object object;
            try {
                object = new JSONObject(string2);
                return object;
            }
            catch (Exception exception) {
                object = "UploadQualityData";
                String string3 = "failed to parse json string";
                TXCLog.e((String)object, string3, exception);
            }
        }
        string2 = new JSONObject();
        return string2;
    }

    private void d() {
        long l10;
        long l11;
        c c10 = com.tencent.liteav.basic.c.c.a();
        String string2 = "Network";
        String string3 = "QualityDataCacheCount";
        this.c = l11 = c10.a(string2, string3);
        long l12 = -1;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        long l14 = 3;
        if (l13 == false || (l10 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1)) < 0) {
            this.c = l14;
        }
    }

    public long a(String string2) {
        Context context = this.b;
        long l10 = 0L;
        if (context != null) {
            return context.getSharedPreferences("com.tencent.liteav.network", 0).getLong(string2, l10);
        }
        return l10;
    }

    public void a(Context context) {
        Context context2 = this.b;
        if (context2 == null) {
            this.b = context = context.getApplicationContext();
        }
    }

    public void a(String string2, long l10) {
        Context context = this.b;
        if (context != null) {
            String string3 = "com.tencent.liteav.network";
            context = context.getSharedPreferences(string3, 0).edit();
            string2 = context.putLong(string2, l10);
            string2.commit();
        }
    }

    public void a(String string2, long l10, long l11, long l12, float f10, float f11, float f12) {
        JSONArray jSONArray;
        String string3;
        Object object;
        String string4;
        String string5;
        Context context;
        String string6;
        String string7;
        block35: {
            m m10;
            block34: {
                long l13;
                long l14;
                long l15;
                block33: {
                    m10 = this;
                    string7 = string2;
                    string6 = "34238512-C08C-4931-A000-40E1D8B5BA5B";
                    context = com.tencent.liteav.basic.c.c.a();
                    string5 = "Network";
                    long l16 = context.a(string5, "QualityDataCacheCount");
                    long l17 = 0L;
                    long l18 = l16 == l17 ? 0 : (l16 < l17 ? -1 : 1);
                    int n10 = 1;
                    string4 = null;
                    if (l18 > 0) {
                        l18 = n10;
                    } else {
                        l18 = 0;
                        context = null;
                    }
                    if (l18 == false) {
                        return;
                    }
                    context = new Object[7];
                    context[0] = string7;
                    context[n10] = object = Long.valueOf(l10);
                    context[2] = object = Long.valueOf(l11);
                    context[3] = object = Long.valueOf(l12);
                    context[4] = object = Float.valueOf(f10);
                    context[5] = object = Float.valueOf(f11);
                    n10 = 6;
                    context[n10] = object = Float.valueOf(f12);
                    context = String.format("updateQualityData: accessID = %s serverType = %d totalTime = %d networkRTT = %d avgBlockCnt = %f avgVideoQue = %f avgAudioQue = %f", (Object[])context);
                    string5 = "UploadQualityData";
                    TXCLog.e(string5, (String)context);
                    l18 = (long)this.b(string2);
                    if (l18 != false) {
                        return;
                    }
                    context = m10.b;
                    object = "com.tencent.liteav.network";
                    context = context.getSharedPreferences((String)object, 0);
                    string4 = "";
                    string4 = context.getString(string6, string4);
                    string4 = this.c(string4);
                    object = string4.optJSONObject(string7);
                    if (object != null) break block33;
                    object = new JSONObject();
                }
                string3 = (l15 = (l14 = l10 - (l13 = (long)3)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) == false ? "DomainArrayData" : "OriginArrayData";
                jSONArray = object.optJSONArray(string3);
                if (jSONArray != null) break block34;
                jSONArray = new JSONArray();
            }
            JSONObject jSONObject = new JSONObject();
            String string8 = "totalTime";
            jSONObject.put(string8, l11);
            string8 = "networkRTT";
            jSONObject.put(string8, l12);
            string8 = "avgBlockCnt";
            double d10 = f10;
            jSONObject.put(string8, d10);
            string8 = "avgVideoQue";
            d10 = f11;
            jSONObject.put(string8, d10);
            string8 = "avgAudioQue";
            d10 = f12;
            jSONObject.put(string8, d10);
            jSONArray.put((Object)jSONObject);
            int n11 = jSONArray.length();
            long l19 = n11;
            long l20 = m10.c;
            long l21 = l19 == l20 ? 0 : (l19 < l20 ? -1 : 1);
            if (l21 <= 0) break block35;
            JSONArray jSONArray2 = new JSONArray();
            long l22 = m10.c;
            for (int i10 = (int)(l19 -= l22); i10 < n11; ++i10) {
                Object object2 = jSONArray.get(i10);
                jSONArray2.put(object2);
                continue;
            }
            jSONArray = jSONArray2;
        }
        object.put(string3, (Object)jSONArray);
        string4.put(string7, object);
        string7 = string4.toString();
        context = context.edit();
        string7 = context.putString(string6, string7);
        try {
            string7.commit();
        }
        catch (Exception exception) {
            string6 = "build json object failed.";
            TXCLog.e(string5, string6, exception);
        }
    }

    public String b() {
        String string2;
        block9: {
            string2 = "";
            Context context = this.b;
            if (context == null) break block9;
            try {
                int n10 = g.d(context);
                if (n10 == 0) {
                    return string2;
                }
                int n11 = 1;
                if (n10 == n11) {
                    return "wifi:";
                }
                n11 = 2;
                if (n10 == n11) {
                    return "4g:";
                }
                n11 = 3;
                if (n10 == n11) {
                    return "3g:";
                }
                n11 = 4;
                if (n10 == n11) {
                    return "2g:";
                }
                n11 = 5;
                if (n10 == n11) {
                    return "ethernet:";
                }
                return "xg:";
            }
            catch (Exception exception) {
                CharSequence charSequence = new StringBuilder();
                String string3 = "get network type failed.";
                charSequence.append(string3);
                String string4 = exception.getMessage();
                charSequence.append(string4);
                string4 = charSequence.toString();
                charSequence = "UploadQualityData";
                TXCLog.e((String)charSequence, string4);
            }
        }
        return string2;
    }

    public boolean c() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        float f15;
        this.d();
        Object object = this.b();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("isDomainAddressBetter: accessID = ");
        ((StringBuilder)object2).append((String)object);
        String string2 = " minQualityDataCount = ";
        ((StringBuilder)object2).append(string2);
        long l15 = this.c;
        ((StringBuilder)object2).append(l15);
        object2 = ((StringBuilder)object2).toString();
        boolean bl2 = true;
        m$a m$a = this.a((String)object, bl2);
        object = this.a((String)object, false);
        int n10 = 5;
        float f16 = 7.0E-45f;
        int n11 = 4;
        int n12 = 3;
        int n13 = 2;
        int n14 = 6;
        if (m$a != null) {
            Object[] objectArray = new Object[n14];
            objectArray[0] = object2;
            long l16 = m$a.e;
            objectArray[bl2] = object2 = Long.valueOf(l16);
            objectArray[n13] = object2 = Float.valueOf(m$a.a);
            objectArray[n12] = object2 = Float.valueOf(m$a.b);
            objectArray[n11] = object2 = Float.valueOf(m$a.c);
            f15 = m$a.d;
            objectArray[n10] = object2 = Float.valueOf(f15);
            object2 = String.format("%s \n isDomainAddressBetter\uff1adomainQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", objectArray);
        }
        if (object != null) {
            Object[] objectArray = new Object[n14];
            objectArray[0] = object2;
            long l17 = ((m$a)object).e;
            objectArray[bl2] = object2 = Long.valueOf(l17);
            objectArray[n13] = object2 = Float.valueOf(((m$a)object).a);
            objectArray[n12] = object2 = Float.valueOf(((m$a)object).b);
            objectArray[n11] = object2 = Float.valueOf(((m$a)object).c);
            f15 = ((m$a)object).d;
            objectArray[n10] = object2 = Float.valueOf(f15);
            object2 = String.format("%s \n isDomainAddressBetter\uff1aoriginQualityData count = %d avgNetworkRTT = %f avgBlockCount = %f avgVideoQueue = %f avgAudioQueue = %f", objectArray);
        }
        String string3 = "UploadQualityData";
        TXCLog.e(string3, (String)object2);
        if (m$a != null && (l14 = (l13 = (l12 = m$a.e) - (l11 = this.c)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0 && object != null && (l14 = (l10 = (l12 = ((m$a)object).e) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0 && (l14 = (long)((f14 = (f15 = m$a.b) - (f16 = ((m$a)object).b)) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1))) < 0 && (l14 = (long)((f13 = (f15 = m$a.c) - (f16 = ((m$a)object).c)) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1))) < 0 && (f12 = (f11 = (f15 = m$a.d) - (f10 = ((m$a)object).d)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
            return bl2;
        }
        return false;
    }
}

