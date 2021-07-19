/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.tencent.liteav.basic.c;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.tencent.liteav.basic.c.a;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.c.c$1;
import com.tencent.liteav.basic.c.c$a;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.PrivateKey;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c {
    public static c f;
    private static Context g;
    public String a;
    public SharedPreferences b;
    public SharedPreferences.Editor c;
    public String d = "";
    public long e = 0L;
    private boolean h = false;
    private boolean i = false;
    private c$a j;
    private final b k;
    private SharedPreferences l;
    private final Object m;

    public c() {
        Object object = new c$a(null);
        this.j = object;
        this.k = object = new b();
        this.m = object = new Object();
    }

    private long a(String string2, String string3, String string4) {
        JSONObject jSONObject;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        long l10 = -1;
        if (!bl2 && (jSONObject = c$a.r(this.j)) != null && (string2 = (jSONObject = c$a.r(this.j)).optJSONObject(string2)) != null && (string2 = string2.optJSONObject(string3)) != null) {
            l10 = string2.optLong(string4, l10);
        }
        return l10;
    }

    private c$a a(JSONObject jSONObject) {
        Object object = null;
        if (jSONObject == null) {
            return null;
        }
        Object object2 = new c$a(null);
        this.i(jSONObject, (c$a)object2);
        this.f(jSONObject, (c$a)object2);
        this.e(jSONObject, (c$a)object2);
        this.d(jSONObject, (c$a)object2);
        this.a(jSONObject, (c$a)object2);
        this.b(jSONObject, (c$a)object2);
        this.c(jSONObject, (c$a)object2);
        this.g(jSONObject, (c$a)object2);
        this.j(jSONObject, (c$a)object2);
        this.h(jSONObject, (c$a)object2);
        Object object3 = this.k;
        String string2 = "compatible_config";
        jSONObject = jSONObject.optJSONArray(string2);
        try {
            ((b)object3).a((JSONArray)jSONObject);
            object = object2;
        }
        catch (JSONException jSONException) {
            object2 = new StringBuilder();
            object3 = "parse config catch exception ";
            ((StringBuilder)object2).append((String)object3);
            String string3 = jSONException.toString();
            ((StringBuilder)object2).append(string3);
            string3 = ((StringBuilder)object2).toString();
            object2 = "CloudConfig";
            TXCLog.w((String)object2, string3);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c a() {
        Object object = f;
        if (object != null) return f;
        object = c.class;
        synchronized (object) {
            c c10 = f;
            if (c10 != null) return f;
            f = c10 = new c();
            return f;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static String a(File object) {
        Class<c> clazz = c.class;
        synchronized (clazz) {
            int n10;
            Object object2;
            boolean bl2;
            ZipFile zipFile = new ZipFile((File)object);
            object = zipFile.entries();
            do {
                if ((n10 = object.hasMoreElements()) == 0) {
                    zipFile.close();
                    return "";
                }
                object2 = object.nextElement();
            } while (bl2 = ((ZipEntry)(object2 = (ZipEntry)object2)).isDirectory());
            object = zipFile.getInputStream((ZipEntry)object2);
            n10 = 0x100000;
            object2 = new byte[n10];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int n11;
                if ((n11 = ((InputStream)object).read((byte[])object2)) <= 0) {
                    ((InputStream)object).close();
                    zipFile.close();
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write((byte[])object2, 0, n11);
            }
        }
    }

    private void a(int n10) {
        synchronized (this) {
            int n11 = 1;
            if (n10 < n11) {
                n10 = n11;
            }
            long l10 = System.currentTimeMillis();
            int n12 = n10 * 24 * 60 * 60 * 1000;
            long l11 = n12;
            l10 += l11;
            this.e = l10;
            String string2 = "CloudConfig";
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "setExpiredtime: days=";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            String string4 = " expiredTime=";
            stringBuilder.append(string4);
            l11 = this.e;
            stringBuilder.append(l11);
            string4 = stringBuilder.toString();
            TXCLog.i(string2, string4);
            return;
        }
    }

    /*
     * WARNING - void declaration
     */
    private void a(c$a object, JSONObject object2) {
        CharSequence charSequence;
        Object object3 = this.c;
        boolean n10 = false;
        String string2 = null;
        if (object3 == null && (object3 = g) != null && (object3 = object3.getSharedPreferences((String)(charSequence = "cloud_config"), 0)) != null) {
            object3 = object3.edit();
            this.c = object3;
        }
        if ((object3 = this.c) != null) {
            int n11;
            int n12;
            long l10 = this.e;
            String string3 = "expired_time";
            object3.putLong(string3, l10);
            object3 = this.c;
            int n13 = c$a.b((c$a)object);
            object3.putInt("hw_config", n13);
            object3 = this.c;
            int n14 = c$a.c((c$a)object);
            object3.putInt("ExposureCompensation", n14);
            object3 = this.c;
            int n15 = c$a.d((c$a)object);
            object3.putInt("UGCSWMuxerConfig", n15);
            object3 = this.c;
            int n16 = c$a.j((c$a)object);
            object3.putInt("CPU", n16);
            object3 = this.c;
            int n17 = c$a.k((c$a)object);
            object3.putInt("FPS", n17);
            object3 = this.c;
            int n18 = c$a.h((c$a)object);
            object3.putInt("CPU_MAX", n18);
            object3 = this.c;
            int n19 = c$a.i((c$a)object);
            object3.putInt("FPS_MIN", n19);
            object3 = this.c;
            int n20 = c$a.g((c$a)object);
            object3.putInt("CheckCount", n20);
            object3 = this.c;
            int n21 = c$a.e((c$a)object);
            object3.putInt("PreGenerateSW", n21);
            object3 = this.c;
            charSequence = c$a.a((c$a)object);
            object3.putString("trae_config", (String)charSequence);
            object3 = this.c;
            boolean bl2 = c$a.f((c$a)object);
            Object object4 = "EnableHWEncoderHighProfile";
            object3.putBoolean((String)object4, bl2);
            object3 = c$a.r((c$a)object);
            if (object3 != null) {
                object3 = this.c;
                charSequence = c$a.r((c$a)object).toString();
                object4 = "AppIDConfig";
                object3.putString((String)object4, (String)charSequence);
            }
            object3 = c$a.o((c$a)object);
            charSequence = "";
            if (object3 != null) {
                void var4_7;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append((String)charSequence);
                object4 = c$a.o((c$a)object);
                Object object5 = object4[0];
                ((StringBuilder)object3).append((int)object5);
                object3 = ((StringBuilder)object3).toString();
                boolean bl3 = true;
                while (++var4_7 < (n12 = ((Object)(object4 = (Object)c$a.o((c$a)object))).length)) {
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)object3);
                    ((StringBuilder)object4).append("|");
                    object3 = ((StringBuilder)object4).toString();
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append((String)object3);
                    n11 = c$a.o((c$a)object)[var4_7];
                    ((StringBuilder)object4).append(n11);
                    object3 = ((StringBuilder)object4).toString();
                }
            } else {
                object3 = "0";
            }
            if ((string2 = c$a.l((c$a)object)) == null) {
                c$a.a((c$a)object, (String)charSequence);
            }
            string2 = this.c;
            charSequence = new StringBuilder();
            n12 = c$a.m((c$a)object);
            ((StringBuilder)charSequence).append(n12);
            object4 = ",";
            ((StringBuilder)charSequence).append((String)object4);
            int n22 = c$a.n((c$a)object);
            ((StringBuilder)charSequence).append(n22);
            ((StringBuilder)charSequence).append((String)object4);
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append((String)object4);
            n11 = c$a.q((c$a)object);
            ((StringBuilder)charSequence).append(n11);
            ((StringBuilder)charSequence).append((String)object4);
            object = c$a.l((c$a)object);
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            object3 = "system_aec_config";
            string2.putString((String)object3, (String)object);
            object = "compatible_config";
            if (object2 == null) {
                object2 = this.c;
                n11 = 0;
                object3 = null;
                object2.putString((String)object, null);
            } else {
                object3 = this.c;
                object2 = object2.toString();
                object3.putString((String)object, (String)object2);
            }
            object = this.c;
            object.commit();
        }
    }

    public static /* synthetic */ void a(c c10) {
        c10.q();
    }

    private void a(String string2, c$a object) {
        block13: {
            int n10;
            String string3 = "InfoList";
            JSONObject jSONObject = new JSONObject(string2);
            boolean bl2 = jSONObject.has(string3);
            if (!bl2) break block13;
            try {
                string2 = jSONObject.getJSONArray(string3);
                n10 = 0;
                string3 = null;
            }
            catch (JSONException jSONException) {
                object = new StringBuilder();
                string3 = "parseTraeLocalConfig catch ecxeption";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append((Object)jSONException);
                String string4 = ((StringBuilder)object).toString();
                object = "CloudConfig";
                TXCLog.w((String)object, string4);
            }
            while (true) {
                block14: {
                    int n11 = string2.length();
                    if (n10 >= n11) break block13;
                    jSONObject = string2.getJSONObject(n10);
                    if (jSONObject == null) break block14;
                    String string5 = "MachineType";
                    string5 = jSONObject.getString(string5);
                    String string6 = Build.MODEL;
                    boolean bl3 = string5.equals(string6);
                    if (!bl3) break block14;
                    string2 = "ConfigValue";
                    string2 = jSONObject.getString(string2);
                    c$a.b((c$a)object, string2);
                }
                ++n10;
            }
        }
    }

    private void a(JSONObject jSONObject, c$a c$a) {
        Object object = jSONObject;
        Object object2 = c$a;
        int n10 = 0;
        String string2 = null;
        c$a.a(c$a, 0);
        c$a.b(c$a, 0);
        int n11 = 0;
        String string3 = null;
        c$a.a(c$a, null);
        c$a.c(c$a, 0);
        String string4 = "";
        c$a.a(c$a, string4);
        String string5 = "SystemAECConfig";
        int n12 = jSONObject.has(string5);
        String string6 = "CloudConfig";
        if (n12 != 0 && (n12 = (object = jSONObject.getJSONObject(string5)).has(string5 = "InfoList")) != 0) {
            int n13;
            string5 = object.getJSONArray(string5);
            String string7 = null;
            for (n12 = 0; n12 < (n13 = string5.length()); ++n12) {
                String string8;
                Object object3;
                int n14;
                int n15;
                Object object4;
                Object object5;
                CharSequence charSequence;
                int n16;
                object = string5.getJSONObject(n12);
                if (object == null || (n16 = ((String)(charSequence = object.getString("Manufacture"))).equalsIgnoreCase((String)(object5 = Build.MANUFACTURER))) == 0) continue;
                charSequence = object.optJSONArray("WhiteList");
                object5 = "Model";
                int n17 = 1;
                if (charSequence != null) {
                    object4 = null;
                    for (n15 = 0; n15 < (n14 = charSequence.length()); ++n15) {
                        object3 = charSequence.optJSONObject(n15);
                        if (object3 == null || (object3 = object3.optString((String)object5)) == null || (n14 = (int)((string8 = Build.MODEL).equals(object3) ? 1 : 0)) == 0) continue;
                        n16 = n17;
                        break;
                    }
                } else {
                    n16 = 0;
                    charSequence = null;
                }
                object4 = object.optJSONArray("BlackList");
                if (object4 != null) {
                    int n18;
                    object3 = null;
                    for (n14 = 0; n14 < (n18 = object4.length()); ++n14) {
                        String string9;
                        string8 = object4.optJSONObject(n14);
                        if (string8 == null || (string8 = string8.optString((String)object5)) == null || (n18 = (int)((string9 = Build.MODEL).equals(string8) ? 1 : 0)) == 0) {
                            continue;
                        }
                        break;
                    }
                } else {
                    n17 = 0;
                }
                if (n16 != 0) {
                    block33: {
                        charSequence = "SystemAEC";
                        n16 = object.optInt((String)charSequence, 0);
                        c$a.a((c$a)object2, n16);
                        charSequence = "AGC";
                        n16 = object.optInt((String)charSequence, 0);
                        c$a.b((c$a)object2, n16);
                        charSequence = "SampleRate";
                        string7 = object.optString((String)charSequence, string4);
                        n16 = (int)(string7.isEmpty() ? 1 : 0);
                        if (n16 != 0) break block33;
                        charSequence = "\\|";
                        charSequence = string7.split((String)charSequence);
                        int n19 = ((CharSequence)charSequence).length;
                        object5 = new int[n19];
                        c$a.a((c$a)object2, (int[])object5);
                        n19 = 0;
                        object5 = null;
                        while (true) {
                            n15 = ((CharSequence)charSequence).length;
                            if (n19 >= n15) break;
                            object4 = c$a.o(c$a);
                            object3 = charSequence[n19];
                            object3 = ((String)object3).trim();
                            object3 = Integer.valueOf((String)object3);
                            n14 = (Integer)object3;
                            object4[n19] = (JSONArray)n14;
                            ++n19;
                            continue;
                            break;
                        }
                    }
                    charSequence = "HWAACCodec";
                    n16 = object.optInt((String)charSequence, 0);
                    c$a.c((c$a)object2, n16);
                    charSequence = "SceneType";
                    object = object.optString((String)charSequence, string4);
                    try {
                        c$a.a((c$a)object2, (String)object);
                    }
                    catch (Exception exception) {
                        charSequence = new StringBuilder();
                        object5 = "parseSysAECConfig Exception: ";
                        ((StringBuilder)charSequence).append((String)object5);
                        object = exception.getMessage();
                        ((StringBuilder)charSequence).append((String)object);
                        object = ((StringBuilder)charSequence).toString();
                        TXCLog.e(string6, (String)object);
                    }
                }
                if (n17 == 0) continue;
                c$a.a((c$a)object2, 0);
                c$a.b((c$a)object2, 0);
                c$a.a((c$a)object2, null);
                c$a.c((c$a)object2, 0);
                c$a.a((c$a)object2, string4);
            }
            string3 = string7;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("system aec config1:");
        n10 = c$a.m(c$a);
        ((StringBuilder)object).append(n10);
        string2 = ",";
        ((StringBuilder)object).append(string2);
        int n20 = c$a.n(c$a);
        ((StringBuilder)object).append(n20);
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(string2);
        n11 = c$a.q(c$a);
        ((StringBuilder)object).append(n11);
        ((StringBuilder)object).append(string2);
        object2 = c$a.l(c$a);
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(", model = ");
        object2 = Build.MODEL;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(", manufacturer = ");
        object2 = Build.MANUFACTURER;
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append("\uff0c board = ");
        object2 = Build.BOARD;
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string6, (String)object);
    }

    private void b(String object) {
        block11: {
            int n10;
            Object object2;
            Object object3;
            block10: {
                object3 = "UpdateFrequency";
                object2 = null;
                this.b(false);
                object2 = new JSONObject((String)object);
                n10 = 1;
                boolean bl2 = object2.has((String)object3);
                if (!bl2) break block10;
                n10 = object2.getInt((String)object3);
            }
            this.a(n10);
            object = this.a((JSONObject)object2);
            if (object == null) break block11;
            this.j = object;
            object3 = this.k;
            object3 = ((b)object3).a();
            try {
                this.a((c$a)object, (JSONObject)object3);
            }
            catch (JSONException jSONException) {
                object3 = new StringBuilder();
                object2 = "parseRespon catch ecxeption";
                ((StringBuilder)object3).append((String)object2);
                ((StringBuilder)object3).append((Object)jSONException);
                String string2 = ((StringBuilder)object3).toString();
                object3 = "CloudConfig";
                TXCLog.w((String)object3, string2);
            }
        }
    }

    private void b(JSONObject object, c$a object2) {
        String string2 = "TraeConfig";
        int n10 = object.has(string2);
        if (n10 != 0 && (n10 = (object = object.getJSONObject(string2)).has(string2 = "InfoList")) != 0) {
            object = object.getJSONArray(string2);
            string2 = null;
            for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
                String string3;
                String string4;
                boolean bl2;
                JSONObject jSONObject = object.getJSONObject(i10);
                if (jSONObject == null || !(bl2 = (string4 = jSONObject.getString("MachineType")).equals(string3 = Build.MODEL))) continue;
                object = jSONObject.getString("ConfigValue");
                c$a.b((c$a)object2, (String)object);
                object = new StringBuilder();
                string2 = "parseTRAEConfig get TRAE config: ";
                ((StringBuilder)object).append(string2);
                object2 = c$a.a((c$a)object2);
                ((StringBuilder)object).append((String)object2);
                object = ((StringBuilder)object).toString();
                object2 = "CloudConfig";
                TXCLog.d((String)object2, (String)object);
                break;
            }
        }
    }

    private void b(boolean bl2) {
        synchronized (this) {
            this.h = bl2;
            return;
        }
    }

    private void c(JSONObject object, c$a object2) {
        String string2 = "WeiXinConfig";
        int n10 = object.has(string2);
        if (n10 != 0 && (n10 = (object = object.getJSONObject(string2)).has(string2 = "InfoList")) != 0) {
            object = object.getJSONArray(string2);
            string2 = null;
            for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
                JSONObject jSONObject = object.getJSONObject(i10);
                if (jSONObject == null) continue;
                String string3 = jSONObject.getString("Manufacture");
                String string4 = jSONObject.getString("Model");
                String string5 = Build.MANUFACTURER;
                boolean bl2 = string3.equals(string5);
                if (!bl2 || !(bl2 = string4.equals(string3 = Build.MODEL))) continue;
                int n11 = Integer.parseInt(jSONObject.getString("SampleRate"));
                c$a.d((c$a)object2, n11);
                object = new StringBuilder();
                string2 = "parseWeiXinConfig get WeiXin config: record sample rate = ";
                ((StringBuilder)object).append(string2);
                int n12 = c$a.p((c$a)object2);
                ((StringBuilder)object).append(n12);
                object = ((StringBuilder)object).toString();
                object2 = "CloudConfig";
                TXCLog.d((String)object2, (String)object);
                break;
            }
        }
    }

    private void c(boolean bl2) {
        synchronized (this) {
            this.i = bl2;
            return;
        }
    }

    private void d(JSONObject object, c$a c$a) {
        c$a.e(c$a, 60);
        c$a.f(c$a, 70);
        c$a.g(c$a, 80);
        c$a.h(c$a, 50);
        int n10 = 10;
        c$a.i(c$a, n10);
        CharSequence charSequence = "HWWhiteList";
        int n11 = object.has((String)charSequence);
        if (n11 != 0 && (n11 = (object = object.getJSONObject((String)charSequence)).has((String)(charSequence = "SWToHWThreshold"))) != 0) {
            object = object.getJSONObject((String)charSequence);
            charSequence = "CPU";
            n11 = object.has((String)charSequence);
            String string2 = "parseAutoSWHWConfig get SWToHWThreshold.CPU:";
            String string3 = "CloudConfig";
            if (n11 != 0) {
                n10 = object.getInt((String)charSequence);
                c$a.e(c$a, n10);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                n11 = c$a.j(c$a);
                ((StringBuilder)charSequence).append(n11);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.d(string3, (String)charSequence);
            }
            charSequence = "FPS";
            n11 = object.has((String)charSequence);
            String string4 = "parseAutoSWHWConfig get SWToHWThreshold.FPS:";
            if (n11 != 0) {
                n10 = object.getInt((String)charSequence);
                c$a.f(c$a, n10);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string4);
                n11 = c$a.k(c$a);
                ((StringBuilder)charSequence).append(n11);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.d(string3, (String)charSequence);
            }
            if ((n11 = object.has((String)(charSequence = "CPU_MAX"))) != 0) {
                n10 = object.getInt((String)charSequence);
                c$a.g(c$a, n10);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string2);
                n11 = c$a.h(c$a);
                ((StringBuilder)charSequence).append(n11);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.d(string3, (String)charSequence);
            }
            if ((n11 = (int)(object.has((String)(charSequence = "FPS_MIN")) ? 1 : 0)) != 0) {
                n10 = object.getInt((String)charSequence);
                c$a.h(c$a, n10);
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(string4);
                n11 = c$a.i(c$a);
                ((StringBuilder)charSequence).append(n11);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.d(string3, (String)charSequence);
            }
            if ((n11 = (int)(object.has((String)(charSequence = "CheckCount")) ? 1 : 0)) != 0) {
                int n12 = object.getInt((String)charSequence);
                c$a.i(c$a, n12);
                object = new StringBuilder();
                charSequence = "parseAutoSWHWConfig get SWToHWThreshold.CheckCount:";
                ((StringBuilder)object).append((String)charSequence);
                int n13 = c$a.g(c$a);
                ((StringBuilder)object).append(n13);
                object = ((StringBuilder)object).toString();
                TXCLog.d(string3, (String)object);
            }
        }
    }

    private void e(JSONObject object, c$a object2) {
        String string2 = "ExposureWhiteConfig";
        int n10 = object.has(string2);
        if (n10 != 0) {
            object = object.getJSONObject(string2).getJSONArray("InfoList");
            string2 = null;
            for (int i10 = 0; i10 < (n10 = object.length()); ++i10) {
                String string3;
                JSONObject jSONObject = object.getJSONObject(i10);
                String string4 = jSONObject.getString("Manufacture");
                boolean bl2 = string4.equalsIgnoreCase(string3 = Build.MANUFACTURER);
                if (!bl2 || !(bl2 = (string4 = jSONObject.getString("Model")).equalsIgnoreCase(string3 = Build.MODEL))) continue;
                int n11 = jSONObject.getInt("ExposureCompensation");
                c$a.j((c$a)object2, n11);
                object = new StringBuilder();
                string2 = "parseExposureConfig get exposure config: ";
                ((StringBuilder)object).append(string2);
                int n12 = c$a.c((c$a)object2);
                ((StringBuilder)object).append(n12);
                object = ((StringBuilder)object).toString();
                object2 = "CloudConfig";
                TXCLog.d((String)object2, (String)object);
                break;
            }
            if ((object = g) != null) {
                object = new Intent("com.tencent.liteav.basic.serverconfig.get");
                object2 = g;
                object2.sendBroadcast((Intent)object);
            }
        }
    }

    private void f(JSONObject object, c$a c$a) {
        String string2 = "HWBlackConfig";
        int n10 = object.has(string2);
        if (n10 != 0) {
            object = object.getJSONObject(string2);
            int n11 = 16;
            String string3 = "HWMiniSupportAPI";
            boolean bl2 = object.has(string3);
            if (bl2) {
                n11 = object.getInt(string3);
            }
            n10 = Build.VERSION.SDK_INT;
            bl2 = false;
            if (n10 < n11) {
                c$a.k(c$a, 0);
            } else {
                object = object.getJSONArray("InfoList");
                string2 = null;
                for (n11 = 0; n11 < (n10 = object.length()); ++n11) {
                    String string4;
                    string3 = object.getJSONObject(n11);
                    String string5 = string3.getString("Manufacture");
                    boolean bl3 = string5.equalsIgnoreCase(string4 = Build.MANUFACTURER);
                    if (!bl3 || !(bl3 = (string5 = string3.getString("Model")).equalsIgnoreCase(string4 = Build.MODEL))) continue;
                    object = "Profile";
                    boolean n12 = string3.has((String)object);
                    string2 = "parseHWBlackConfig get HWBlack config: ";
                    string3 = "CloudConfig";
                    if (n12) {
                        int n13 = 1;
                        c$a.k(c$a, n13);
                        object = new StringBuilder();
                        ((StringBuilder)object).append(string2);
                        int n14 = c$a.b(c$a);
                        ((StringBuilder)object).append(n14);
                        object = ((StringBuilder)object).toString();
                        TXCLog.d(string3, (String)object);
                        break;
                    }
                    c$a.k(c$a, 0);
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    int n14 = c$a.b(c$a);
                    ((StringBuilder)object).append(n14);
                    object = ((StringBuilder)object).toString();
                    TXCLog.d(string3, (String)object);
                    break;
                }
            }
        }
    }

    private void g(JSONObject jSONObject, c$a c$a) {
        String string2 = "UGCSWMuxerConfig";
        int n10 = jSONObject.has(string2);
        if (n10 != 0) {
            jSONObject = jSONObject.getJSONObject(string2).getJSONArray("InfoList");
            string2 = null;
            for (int i10 = 0; i10 < (n10 = jSONObject.length()); ++i10) {
                String string3;
                String string4 = jSONObject.getJSONObject(i10).getString("Manufacture");
                n10 = (int)(string4.equalsIgnoreCase(string3 = Build.MANUFACTURER) ? 1 : 0);
                if (n10 == 0) continue;
                int n11 = 1;
                c$a.l(c$a, n11);
                break;
            }
        }
    }

    private void h(JSONObject jSONObject, c$a c$a) {
        String string2 = "UGCConfig";
        int n10 = jSONObject.has(string2);
        if (n10 != 0 && (jSONObject = jSONObject.getJSONObject(string2)) != null) {
            int n11;
            string2 = "PreGenerateALLSW";
            n10 = jSONObject.has(string2);
            int n12 = 1;
            if (n10 != 0 && (n11 = jSONObject.getInt(string2)) == n12) {
                c$a.m(c$a, n12);
                return;
            }
            string2 = "PreGenerateSW";
            n10 = jSONObject.has(string2);
            if (n10 != 0 && (jSONObject = jSONObject.getJSONObject(string2)) != null) {
                jSONObject = jSONObject.getJSONArray("InfoList");
                string2 = null;
                for (n11 = 0; n11 < (n10 = jSONObject.length()); ++n11) {
                    String string3;
                    boolean bl2;
                    String string4;
                    boolean bl3;
                    String string5;
                    Object object = jSONObject.getJSONObject(n11);
                    boolean bl4 = object.has(string5 = "Manufacture");
                    if (!bl4 || !(bl3 = object.has(string4 = "Model")) || !(bl2 = (string5 = object.getString(string5)).equalsIgnoreCase(string3 = Build.MANUFACTURER)) || (n10 = (int)(((String)(object = object.getString(string4))).equalsIgnoreCase(string5 = Build.MODEL) ? 1 : 0)) == 0) continue;
                    c$a.m(c$a, n12);
                    break;
                }
            }
        }
    }

    private void i(JSONObject object, c$a object2) {
        String string2 = "VideoEncoderConfig";
        boolean bl2 = object.has(string2);
        if (bl2 && (object = object.getJSONObject(string2)) != null) {
            boolean bl3 = true;
            String string3 = "EnableHWEncoderHighProfile";
            boolean bl4 = object.optBoolean(string3, bl3);
            c$a.a((c$a)object2, bl4);
            object = new StringBuilder();
            string2 = "[Encoder] enable high profile:";
            ((StringBuilder)object).append(string2);
            boolean bl5 = c$a.f((c$a)object2);
            ((StringBuilder)object).append(bl5);
            object = ((StringBuilder)object).toString();
            object2 = "CloudConfig";
            TXCLog.i((String)object2, (String)object);
        }
    }

    private void j(JSONObject object, c$a object2) {
        String string2 = "AppIDConfig";
        boolean bl2 = object.has(string2);
        if (bl2 && (object = object.optJSONObject(string2)) != null) {
            c$a.a((c$a)object2, (JSONObject)object);
            object = new StringBuilder();
            string2 = "parse global config : ";
            ((StringBuilder)object).append(string2);
            object2 = c$a.r((c$a)object2);
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object2 = "CloudConfig";
            TXCLog.w((String)object2, (String)object);
        }
    }

    private void m() {
        this.n();
        this.k();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void n() {
        synchronized (this) {
            boolean bl2 = this.p();
            if (bl2) {
                bl2 = true;
                this.c(bl2);
                bl2 = this.r();
                if (!bl2) {
                    this.s();
                }
                String string2 = "CloudConfig";
                StringBuilder stringBuilder = new StringBuilder();
                Object object = "load config(system aec):";
                stringBuilder.append((String)object);
                object = this.j;
                int n10 = c$a.m((c$a)object);
                stringBuilder.append(n10);
                object = ",";
                stringBuilder.append((String)object);
                object = this.j;
                n10 = c$a.n((c$a)object);
                stringBuilder.append(n10);
                object = ",";
                stringBuilder.append((String)object);
                object = this.j;
                n10 = c$a.q((c$a)object);
                stringBuilder.append(n10);
                object = ",";
                stringBuilder.append((String)object);
                object = this.j;
                object = c$a.l((c$a)object);
                stringBuilder.append((String)object);
                object = ", model = ";
                stringBuilder.append((String)object);
                object = Build.MODEL;
                stringBuilder.append((String)object);
                object = ", manufacturer = ";
                stringBuilder.append((String)object);
                object = Build.MANUFACTURER;
                stringBuilder.append((String)object);
                object = "\uff0c board = ";
                stringBuilder.append((String)object);
                object = Build.BOARD;
                stringBuilder.append((String)object);
                String string3 = stringBuilder.toString();
                TXCLog.i(string2, string3);
            }
            return;
        }
    }

    private boolean o() {
        synchronized (this) {
            block5: {
                int n10 = this.h;
                if (n10 != 0) break block5;
                long l10 = this.e;
                long l11 = System.currentTimeMillis();
                n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (n10 > 0) break block5;
                return true;
            }
            return false;
        }
    }

    private boolean p() {
        synchronized (this) {
            block3: {
                boolean bl2 = this.i;
                if (!bl2) break block3;
                return false;
            }
            return true;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void q() {
        int n10;
        SharedPreferences.Editor editor;
        Object object;
        Object object2;
        block13: {
            Object object3;
            int n11;
            object2 = "CloudConfig";
            object = "update server config ";
            try {
                int n12;
                TXCLog.w((String)object2, (String)object);
                object2 = "http://dldir1.qq.com/hudongzhibo/liteavsvrcfg/serverconfig_en.zip";
                object = new URL((String)object2);
                object2 = ((URL)object).openConnection();
                object2 = FirebasePerfUrlConnection.instrument(object2);
                object2 = (URLConnection)object2;
                object2 = (HttpURLConnection)object2;
                object = this.d;
                int n13 = ((String)object).isEmpty();
                if (n13 == 0) {
                    object = "If-Modified-Since";
                    editor = this.d;
                    ((URLConnection)object2).addRequestProperty((String)object, (String)editor);
                }
                object = "Last-Modified";
                object = ((URLConnection)object2).getHeaderField((String)object);
                n10 = ((HttpURLConnection)object2).getResponseCode();
                if (n10 != (n11 = 200)) break block13;
                if (object != null && (n10 = (int)(((String)object).isEmpty() ? 1 : 0)) == 0) {
                    this.d = object;
                    editor = this.c;
                    if (editor != null) {
                        object3 = "last_modify";
                        editor.putString((String)object3, (String)object);
                    }
                }
                object2 = ((URLConnection)object2).getInputStream();
                n13 = 1024;
                object = new byte[n13];
                editor = new SharedPreferences.Editor();
                while ((n11 = ((InputStream)object2).read((byte[])object)) != (n12 = -1)) {
                    editor.write((byte[])object, 0, n11);
                }
                object2 = TXCCommonUtil.getConfigCenterKey();
                object = "UTF-8";
                object2 = ((String)object2).getBytes((String)object);
                n13 = 2;
                object2 = Base64.decode((byte[])object2, (int)n13);
                object2 = com.tencent.liteav.basic.c.a.a((byte[])object2);
                object = editor.toByteArray();
                object2 = com.tencent.liteav.basic.c.a.a((byte[])object, (PrivateKey)object2);
                n13 = 0;
                object = null;
                editor = c.class;
                synchronized (editor) {
                    object3 = this.a;
                }
            }
            catch (Exception exception) {
                object = "CloudConfig";
                editor = new SharedPreferences.Editor();
                object3 = "fetch config catch exception ";
                editor.append((String)object3);
                editor.append(exception);
                String string2 = editor.toString();
                TXCLog.e((String)object, string2);
                this.b(false);
                return;
            }
            {
                n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n11 == 0) {
                    object3 = this.a;
                    String string3 = "serverconfig_dec.zip";
                    object = new File((String)object3, string3);
                    object3 = new FileOutputStream((File)object);
                    ((FileOutputStream)object3).write((byte[])object2);
                    ((FileOutputStream)object3).close();
                }
            }
            {
                object2 = com.tencent.liteav.basic.c.c.a((File)object);
                this.b((String)object2);
                return;
            }
        }
        int n14 = 304;
        if (n10 != n14) return;
        n14 = 1;
        this.a(n14);
        object2 = g;
        if (object2 != null && (object2 = object2.getSharedPreferences((String)(object = "cloud_config"), 0)) != null) {
            object = "CloudConfig";
            editor = new SharedPreferences.Editor();
            String string4 = "updateInternal: return 304(code), update expiredTime into file. expiredTime=";
            editor.append(string4);
            long l10 = this.e;
            editor.append(l10);
            editor = editor.toString();
            TXCLog.i((String)object, (String)editor);
            object2 = object2.edit();
            object = "expired_time";
            long l11 = this.e;
            object2 = object2.putLong((String)object, l11);
            object2.commit();
        }
        this.b(false);
        object2 = "CloudConfig";
        object = new StringBuilder();
        editor = "fetch config Not-Modified-Since ";
        ((StringBuilder)object).append((String)editor);
        editor = this.d;
        ((StringBuilder)object).append((String)editor);
        object = ((StringBuilder)object).toString();
        object = object == null ? "" : this.d;
        TXCLog.d((String)object2, (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean r() {
        String string2;
        boolean bl2;
        SharedPreferences sharedPreferences;
        String string3 = "";
        Context context = g;
        if (context == null) {
            return false;
        }
        String string4 = "cloud_config";
        this.b = sharedPreferences = context.getSharedPreferences(string4, 0);
        if (sharedPreferences != null && (bl2 = sharedPreferences.contains(string2 = "expired_time"))) {
            String string5 = "CloudConfig";
            TXCLog.w(string5, "loadLocalFileConfig ");
            Object object = this.b.edit();
            this.c = object;
            try {
                int n10;
                int n11;
                String string6;
                String[] stringArray;
                long l10;
                object = this.b;
                Object object2 = "last_modify";
                object = object.getString((String)object2, string3);
                this.d = object;
                object = this.b;
                long l11 = System.currentTimeMillis();
                this.e = l10 = object.getLong(string2, l11);
                c$a c$a = this.j;
                object = this.b;
                object2 = "hw_config";
                int n12 = 2;
                int n13 = object.getInt((String)object2, n12);
                c$a.k(c$a, n13);
                c$a c$a2 = this.j;
                object = this.b;
                object2 = "ExposureCompensation";
                n13 = object.getInt((String)object2, 0);
                c$a.j(c$a2, n13);
                c$a c$a3 = this.j;
                object = this.b;
                object2 = "UGCSWMuxerConfig";
                n13 = object.getInt((String)object2, 0);
                c$a.l(c$a3, n13);
                c$a c$a4 = this.j;
                object = this.b;
                object2 = "CPU";
                int n14 = 60;
                n13 = object.getInt((String)object2, n14);
                c$a.e(c$a4, n13);
                c$a c$a5 = this.j;
                object = this.b;
                object2 = "FPS";
                n14 = 70;
                n13 = object.getInt((String)object2, n14);
                c$a.f(c$a5, n13);
                c$a c$a6 = this.j;
                object = this.b;
                object2 = "CPU_MAX";
                n14 = 80;
                n13 = object.getInt((String)object2, n14);
                c$a.g(c$a6, n13);
                c$a c$a7 = this.j;
                object = this.b;
                object2 = "FPS_MIN";
                n14 = 50;
                n13 = object.getInt((String)object2, n14);
                c$a.h(c$a7, n13);
                c$a c$a8 = this.j;
                object = this.b;
                object2 = "CheckCount";
                n14 = 10;
                n13 = object.getInt((String)object2, n14);
                c$a.i(c$a8, n13);
                c$a c$a9 = this.j;
                object = this.b;
                object2 = "trae_config";
                object = object.getString((String)object2, string3);
                c$a.b(c$a9, (String)object);
                c$a c$a10 = this.j;
                object = this.b;
                object2 = "PreGenerateSW";
                n14 = 1;
                n13 = object.getInt((String)object2, n14);
                c$a.m(c$a10, n13);
                c$a c$a11 = this.j;
                object = this.b;
                object2 = "EnableHWEncoderHighProfile";
                n13 = (int)(object.getBoolean((String)object2, n14 != 0) ? 1 : 0);
                c$a.a(c$a11, n13 != 0);
                SharedPreferences sharedPreferences2 = this.b;
                object = "system_aec_config";
                String string7 = sharedPreferences2.getString((String)object, string3);
                object = this.b;
                object2 = "AppIDConfig";
                String string8 = object.getString((String)object2, string3);
                n13 = TextUtils.isEmpty((CharSequence)string8);
                if (n13 == 0) {
                    object = this.j;
                    object2 = new JSONObject(string8);
                    c$a.a((c$a)object, (JSONObject)object2);
                }
                StringBuilder stringBuilder = new StringBuilder();
                object = "system aec config:";
                stringBuilder.append((String)object);
                stringBuilder.append(string7);
                String string9 = stringBuilder.toString();
                TXCLog.i(string5, string9);
                boolean bl3 = string7.isEmpty();
                if (!bl3 && (stringArray = string7.split(string6 = ",")) != null && (n11 = stringArray.length) >= (n13 = 5)) {
                    c$a c$a12 = this.j;
                    object = stringArray[0];
                    object = Integer.valueOf((String)object);
                    n13 = (Integer)object;
                    c$a.a(c$a12, n13);
                    c$a c$a13 = this.j;
                    object = stringArray[n14];
                    object = Integer.valueOf((String)object);
                    n13 = (Integer)object;
                    c$a.b(c$a13, n13);
                    String string10 = stringArray[n12];
                    object = "\\|";
                    String[] stringArray2 = string10.split((String)object);
                    if (stringArray2 != null) {
                        object = this.j;
                        n10 = stringArray2.length;
                        object2 = new int[n10];
                        c$a.a((c$a)object, (int[])object2);
                        object = null;
                        for (n13 = 0; n13 < (n10 = stringArray2.length); ++n13) {
                            object2 = this.j;
                            object2 = c$a.o((c$a)object2);
                            Object object3 = stringArray2[n13];
                            object3 = ((String)object3).trim();
                            object3 = Integer.valueOf((String)object3);
                            n12 = (Integer)object3;
                            object2[n13] = n12;
                        }
                    }
                    c$a c$a14 = this.j;
                    n13 = 3;
                    object = stringArray[n13];
                    object = Integer.valueOf((String)object);
                    n13 = (Integer)object;
                    c$a.c(c$a14, n13);
                    c$a c$a15 = this.j;
                    n13 = 4;
                    String string11 = stringArray[n13];
                    c$a.a(c$a15, string11);
                }
                b b10 = this.k;
                SharedPreferences sharedPreferences3 = this.b;
                object = "compatible_config";
                n10 = 0;
                object2 = null;
                String string12 = sharedPreferences3.getString((String)object, null);
                b10.a(string12);
                return n14 != 0;
            }
            catch (Exception exception) {
                this.c.clear();
                this.c.commit();
                StringBuilder stringBuilder = new StringBuilder();
                object = "loadLocalFileConfig catch exception ";
                stringBuilder.append((String)object);
                stringBuilder.append(exception);
                String string13 = stringBuilder.toString();
                TXCLog.d(string5, string13);
            }
        }
        return false;
    }

    private void s() {
        block5: {
            Object object = "CloudConfig";
            Object object2 = "loadDefaultConfig ";
            TXCLog.w((String)object, (String)object2);
            CharSequence charSequence = "{\n    \"version\": 3,\n    \"UpdateFrequency\": 1,\n    \"AppIDConfig\": {\n        \"Global\": {\n            \"DataReport\": {\n                \"UserPortrait\":0\n            },\n            \"DNSWhiteList\": {\n              \"InfoList\": [\n                \"qq\",\n                \"tencent\"\n              ]\n            },\n            \"Audio\": {\n                \"RTC_JitterCycle\":240,\n                \"LIVE_JitterCycle\":500,\n                \"LoadingThreshold\":800,\n                \"SmoothModeAdjust\":0,\n                \"SmoothAdjust\":10,\n                \"RtcPlayHungryTimeThreshold\":60,\n                \"BlockThreshold\": 100,\n                \"SmoothSpeed\":1.2\n            },\n            \"Network\": {\n                \"EnableRouteOptimize\":0,\n                \"RouteSamplingMaxCount\":10,\n                \"QualityDataCacheCount\":0,\n                \"NACKRetryCnt\": 8,\n                \"AccRetryCountWithoutSecret\":1\n            },\n            \"QUICMode\": {\n                \"Live\":2,\n                \"LinkMain\":2,\n                \"LinkSub\":2,\n                \"RTC\":2,\n                \"AVRoom\":0\n            },\n            \"ILiveRoom\": {\n               \"Live_FecRatioAudio\":0,\n               \"Live_FecRatioVideoI\":0,\n               \"Live_FecRatioVideoP\":0,\n               \"Chat_FecRatioAudio\":0,\n               \"Chat_FecRatioVideoI\":0,\n               \"Chat_FecRatioVideoP\":0,\n               \"Rtc_MinCacheTime\":300,\n               \"Rtc_MaxCacheTime\":1000,\n               \"MinCacheTime\":700,\n               \"MaxCacheTime\":2000\n           },\n           \"Video\": {\n               \"CheckVideoEncDownBps\":1\n           }\n       },\n       \"1252463788\":{\n            \"Network\": {\n                \"EnableRouteOptimize\":1,\n                \"RouteSamplingMaxCount\":100,\n                \"QualityDataCacheCount\":10\n            }\n       }\n    },\n    \"PlayModeConfig\":{\n        \"SmoothModeOffset\":300\n    },\n    \"UGCSWMuxerConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\"\n            }\n        ]\n    },\n    \"UGCConfig\": {\n        \"PreGenerateALLSW\":0,\n        \"PreGenerateSW\": {\n                \"InfoList\": [\n                    {\n                        \"Manufacture\": \"OPPO\",\n                        \"Model\": \"OPPO A57\"\n                    }\n                ]\n            }\n         },\n    \"VideoEncoderConfig\": {\n        \"EnableHWEncoderHighProfile\": true\n    },\n    \"HWBlackConfig\": {\n        \"HWMiniSupportAPI\": 17,\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"P6-U06\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"SCH-I939(S3)\"\n            },\n            {\n                \"Manufacture\": \"VIVO\",\n                \"Model\": \"vivo X5Pro D\"\n            },\n            {\n                \"Manufacture\": \"\u91d1\u7acb\",\n                \"Model\": \"GN9006\"\n            },\n            {\n                \"Manufacture\": \"Samsung\",\n                \"Model\": \"A7000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI NXT-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"HUAWEI MHA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL10\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L29\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-L00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"MHA-TL00\",\n\t\t\t\t\"Profile\": \"baseline\"\n            },\n             {\n                 \"Manufacture\": \"HUAWEI\",\n                 \"Model\": \"HUAWEI GRA-UL00\"\n             }\n        ]\n    },\n    \"ExposureWhiteConfig\": {\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"Meizu\",\n                \"Model\": \"MX4 Pro\",\n                \"ExposureCompensation\": 1\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3\",\n                \"ExposureCompensation\": 30\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"Model\": \"MI 3C\",\n                \"ExposureCompensation\": 30\n            }\n        ]\n    },\n    \"SystemAECConfig\": {\n        \"__comment__\":\"SceneType(\u5f00\u542f\u7cfb\u7edfaec\u7684\u573a\u666f\uff0c1\u4e3a\u8fde\u9ea6\uff0c2\u4e3a\u901a\u8bdd)\",\n        \"InfoList\": [\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9\"}],\n                \"BlackList\": [],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"vivo\",\n                \"WhiteList\": [{\"Model\":\"vivo X9Plus\"},{\"Model\":\"vivo X7Plus\"},{\"Model\":\"vivo X7\"}],\n                \"BlackList\": [{\"Model\":\"vivo Y51A\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"WhiteList\": [{\"Model\":\"VTR-TL00\"},{\"Model\":\"HUAWEI GRA-UL00\"},{\"Model\":\"HUAWEI NXT-AL10\"},{\"Model\":\"PLK-AL10\"},{\"Model\":\"PLK-UL00\"},{\"Model\":\"EVA-AL10\"},{\"Model\":\"HUAWEI MT7-TL10\"}],\n                \"BlackList\": [{\"Model\":\"MHA-AL00\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 2\"},{\"Model\":\"Redmi Note 4\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"Redmi Note 3\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Xiaomi\",\n                \"WhiteList\": [{\"Model\":\"MI 4\"},{\"Model\":\"MI 3C\"},{\"Model\":\"Mi-4c\"}],\n                \"BlackList\": [{\"Model\":\"MI 6\"},{\"Model\":\"Redmi 4A\"},{\"Model\":\"MI 5X\"},{\"Model\":\"MI 5\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"Google\",\n                \"WhiteList\": [{\"Model\":\"Pixel XL\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                \"Manufacture\": \"samsung\",\n                \"WhiteList\": [{\"Model\":\"SM-G9350\"},{\"Model\":\"SM-G9500\"},{\"Model\":\"SM-G950U\"}],\n                \"SystemAEC\": 1,\n                \"AGC\": 0,\n                \"SampleRate\": \"48000|16000\",\n                \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n            {\n                 \"Manufacture\": \"LeMobile\",\n                 \"WhiteList\": [{\"Model\":\"X620\"}],\n                 \"SystemAEC\": 1,\n                 \"AGC\": 0,\n                 \"SampleRate\": \"48000|16000\",\n                 \"HWAACCodec\": 1,\n                \"SceneType\": \"1|2\"\n            },\n             {\n                  \"Manufacture\": \"asus\",\n                  \"WhiteList\": [{\"Model\":\"ASUS_Z00ADB\"}],\n                  \"SystemAEC\": 1,\n                  \"AGC\": 0,\n                  \"SampleRate\": \"48000|16000\",\n                  \"HWAACCodec\": 1,\n                 \"SceneType\": \"1|2\"\n             }\n        ]\n    },\n    \"WeiXinConfig\": {\n        \"InfoList\":[\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"EVA-AL00\",\n                \"SampleRate\": \"16000\"\n            },\n            {\n                \"Manufacture\": \"HUAWEI\",\n                \"Model\": \"ALP-AL00\",\n                \"SampleRate\": \"16000\"\n            }\n        ]\n    },\n    \"HWWhiteList\": {\n        \"SWToHWThreshold\": {\n            \"CPU_MAX\": 80,\n            \"FPS_MIN\": 50,\n            \"CPU\": 20,\n            \"FPS\": 70,\n            \"CheckCount\": 10,\n            \"__comment__\": \"\u8f6f\u7f16\u6839\u636e\u6027\u80fd\u5207\u786c\u7f16\u7684\u9608\u503c\uff0cavgTotalCPU >= CPU_MAX || avgFPS <= FPS_MIN || (avgAppCPU >= CPU && avgFPS <= FPS) \u6027\u80fd\u6307\u6807\u6ee1\u8db3\u4e0a\u8ff0\u6761\u4ef6\u5219\u5207\u786c\u7f16\u3002CheckCount\u8868\u793a\u9700\u8981\u505aX\u6b21\u6709\u6548\u6027\u80fd\u6570\u636e\u91c7\u96c6\u3002\"\n\t\t}\n    },\n    \"TraeConfig\": {\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1074,\n            \"MachineType\": \"OPPO A57\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"OPPO R11s\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1076,\n            \"MachineType\": \"OPPO R11\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1077,\n            \"MachineType\": \"OPPO A83\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"OPPO A73\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"SM-G9006V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1081,\n            \"MachineType\": \"vivo Y83A\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1083,\n            \"MachineType\": \"OPPO R17\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1084,\n            \"MachineType\": \"OPPO R15\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1085,\n            \"MachineType\": \"OPPO A37M\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1086,\n            \"MachineType\": \"OPPO A7X\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1087,\n            \"MachineType\": \"OPPO A3\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1088,\n            \"MachineType\": \"OPPO A5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1089,\n            \"MachineType\": \"OPPO A83T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1090,\n            \"MachineType\": \"OPPO R11T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1091,\n            \"MachineType\": \"OPPO R9S PLUS\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1092,\n            \"MachineType\": \"vivo Y51A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1093,\n            \"MachineType\": \"vivo V1813A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1095,\n            \"MachineType\": \"vivo Y67\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1097,\n            \"MachineType\": \"MHA-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1098,\n            \"MachineType\": \"ALP-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1099,\n            \"MachineType\": \"VTR-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1100,\n            \"MachineType\": \"BND-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1101,\n            \"MachineType\": \"COL-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1102,\n            \"MachineType\": \"BKL-AL20\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1103,\n            \"MachineType\": \"PRA-AL00X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1104,\n            \"MachineType\": \"MI 6X\"\n          }\n        ]\n    }\n}\n";
            object2 = new JSONObject((String)charSequence);
            object2 = this.a((JSONObject)object2);
            if (object2 == null) break block5;
            try {
                this.j = object2;
            }
            catch (JSONException jSONException) {
                charSequence = new StringBuilder();
                String string2 = "loadDefaultConfig catch exception ";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((Object)jSONException);
                String string3 = ((StringBuilder)charSequence).toString();
                TXCLog.w((String)object, string3);
                string3 = null;
                this.j = object = new c$a(null);
            }
        }
    }

    public long a(String string2, String string3) {
        this.m();
        String string4 = TXCCommonUtil.getAppID();
        long l10 = this.a(string4, string2, string3);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            string4 = "Global";
            l10 = this.a(string4, string2, string3);
        }
        return l10;
    }

    public void a(Context object) {
        Object object2 = g;
        if (object2 == null) {
            object = object.getApplicationContext();
            g = object;
            object2 = null;
            if ((object = object.getExternalFilesDir(null)) != null) {
                object2 = new StringBuilder();
                object = ((File)object).getAbsolutePath();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append("/txrtmp/");
                this.a = object = ((StringBuilder)object2).toString();
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object;
        Object object2 = g;
        try {
            Object object3 = this.m;
            synchronized (object3) {
                object = this.l;
                if (object != null || object2 == null) break block5;
                object = "liteav_hw_encoder_config";
            }
        }
        catch (Exception exception) {
            object2 = "CloudConfig";
            String string2 = "enableHWHighProfile: error.";
            TXCLog.e((String)object2, string2, exception);
            return;
        }
        {
            block5: {
                object2 = object2.getSharedPreferences((String)object, 0);
                this.l = object2;
            }
            object2 = this.l;
            object2 = object2.edit();
            object = "enable_high_profile";
            SharedPreferences.Editor editor = object2.putBoolean((String)object, bl2);
            editor.commit();
            return;
        }
    }

    public boolean a(float f10, float f11, float f12) {
        c$a c$a;
        float f13;
        float f14;
        int n10;
        c$a c$a2;
        float f15;
        this.m();
        c$a c$a3 = this.j;
        int n11 = c$a.h(c$a3);
        float f16 = n11;
        float f17 = f11 == f16 ? 0 : (f11 > f16 ? 1 : -1);
        if (f17 < 0 && (f17 = (f15 = f12 - (f11 = (float)c$a.i(c$a2 = this.j))) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) > 0 && ((n10 = (f14 = f10 - (f11 = (float)(f17 = (float)c$a.j(c$a2 = this.j)))) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) < 0 || (n10 = (int)((f13 = f12 - (f10 = (float)c$a.k(c$a = this.j))) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1))) > 0)) {
            n10 = 0;
            f10 = 0.0f;
            c$a = null;
        } else {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        }
        return n10 != 0;
    }

    public boolean a(String string2) {
        this.m();
        JSONObject jSONObject = c$a.r(this.j);
        if (jSONObject != null) {
            jSONObject = c$a.r(this.j);
            String string3 = "Global";
            if ((jSONObject = jSONObject.optJSONObject(string3)) != null && (jSONObject = jSONObject.optJSONObject(string3 = "DNSWhiteList")) != null && (jSONObject = jSONObject.optJSONArray(string3 = "InfoList")) != null) {
                int n10;
                string3 = null;
                for (int i10 = 0; i10 < (n10 = jSONObject.length()); ++i10) {
                    String string4 = jSONObject.getString(i10);
                    try {
                        n10 = (int)(string2.contains(string4) ? 1 : 0);
                        if (n10 == 0) continue;
                        return true;
                    }
                    catch (Exception exception) {
                        String string5 = "CloudConfig";
                        String string6 = "get string from json failed.";
                        TXCLog.e(string5, string6, exception);
                    }
                }
            }
        }
        return false;
    }

    public b b() {
        return com.tencent.liteav.basic.c.c.a().k;
    }

    public String c() {
        this.m();
        Object object = c$a.a(this.j);
        boolean bl2 = ((String)object).isEmpty();
        if (bl2) {
            object = this.j;
            String string2 = "{\n        \"InfoList\": [\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 90,\n            \"MachineType\": \"MI 4W\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 94,\n            \"MachineType\": \"MI 5\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 96,\n            \"MachineType\": \"PLK-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 17\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 97,\n            \"MachineType\": \"SM-G9350\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 98,\n            \"MachineType\": \"MX4 Pro\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 99,\n            \"MachineType\": \"A31\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 118,\n            \"MachineType\": \"MI 4LTE\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 132,\n            \"MachineType\": \"OPPO R9tm\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 156,\n            \"MachineType\": \"Mi-4c\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 166,\n            \"MachineType\": \"OPPO A33\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 174,\n            \"MachineType\": \"OPPO A33m\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 191,\n            \"MachineType\": \"m1\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 213,\n            \"MachineType\": \"vivo X6Plus D\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 226,\n            \"MachineType\": \"vivo X5Pro V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 251,\n            \"MachineType\": \"vivo X5pro L\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 256,\n            \"MachineType\": \"EVA-DL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 257,\n            \"MachineType\": \"EVA-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 260,\n            \"MachineType\": \"EVA-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 270,\n            \"MachineType\": \"EVA-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 307,\n            \"MachineType\": \"SM-N9108V\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 500,\n            \"MachineType\": \"MI 5s Plus\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"PRO 7-H\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 989,\n            \"MachineType\": \"M10\"\n          },\n          {\n            \"Factory\": \"GiONEE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 388,\n            \"MachineType\": \"F103\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 394,\n            \"MachineType\": \"OPPO A33t\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -6.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 400,\n            \"MachineType\": \"OPPO R7\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 401,\n            \"MachineType\": \"OPPO R9m\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 406,\n            \"MachineType\": \"HUAWEI MT7-CL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 407,\n            \"MachineType\": \"HUAWEI MT7-TL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 421,\n            \"MachineType\": \"HUAWEI NXT-AL10\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 21\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 473,\n            \"MachineType\": \"SM-N9200\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 481,\n            \"MachineType\": \"MI 4C\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 485,\n            \"MachineType\": \"Redmi Note 3\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 518,\n            \"MachineType\": \"DOOV L5M\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nprep {\\r\\ndrop_mic_ms 300\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 530,\n            \"MachineType\": \"MI 3\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 554,\n            \"MachineType\": \"MX6\"\n          },\n          {\n            \"Factory\": \"LENOVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nUseHQAEC n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1041,\n            \"MachineType\": \"Lenovo K900\"\n          },\n          {\n            \"Factory\": \"M5\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 985,\n            \"MachineType\": \"X5 R1\"\n          },\n          {\n            \"Factory\": \"ZTE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 983,\n            \"MachineType\": \"ZTE N928Dt\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 2\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 426\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 778,\n            \"MachineType\": \"OPPO R9s\"\n          },\n          {\n            \"Factory\": \"JTY\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 12.0\\r\\npreAGCvvolmax 20.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 986,\n            \"MachineType\": \"KT096H\"\n          },\n          {\n            \"Factory\": \"TCL\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 984,\n            \"MachineType\": \"TCL P501M\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch n\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1050,\n            \"MachineType\": \"STF-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 857,\n            \"MachineType\": \"EVA-AL00\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.2\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 798,\n            \"MachineType\": \"OPPO R9km\"\n          },\n          {\n            \"Factory\": \"Haier\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 990,\n            \"MachineType\": \"HT-L700T\"\n          },\n          {\n            \"Factory\": \"Lenovo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 988,\n            \"MachineType\": \"Lenovo A916\"\n          },\n          {\n            \"Factory\": \"alps\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nplay {\\r\\nhw_sr 44100\\r\\nhw_ch 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 998,\n            \"MachineType\": \"em_ts809_p3mme\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nforcevoip y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\ntrae {\\r\\nplayRec {\\r\\ndelay 372\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 999,\n            \"MachineType\": \"vivo X5Pro D\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 858,\n            \"MachineType\": \"OPPO A59s\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nagc {\\r\\nswitch y\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 884,\n            \"MachineType\": \"Nexus 5\"\n          },\n          {\n            \"Factory\": \"LGE\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncap {\\r\\nhw_ch_191 2\\r\\nStereoCapLorR 1\\r\\n}\\r\\ncomponent 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 971,\n            \"MachineType\": \"Nexus 5X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\nhwcodec_new {\\r\\navc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\navc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.1\\r\\n}\\r\\n}\\r\\n}\\r\\nhwcodec_new {\\r\\nhevc_decoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\nhevc_encoder {\\r\\nwhite_list {\\r\\nmin_sdk 19\\r\\nmin_version 1.8.6\\r\\n}\\r\\n}\\r\\n}\\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 975,\n            \"MachineType\": \"MI 6\"\n          },\n          {\n            \"Factory\": \"koobee\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 20.0\\r\\npreAGCvvolmax 30.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 991,\n            \"MachineType\": \"koobee M9 Plus\"\n          },\n          {\n            \"Factory\": \"\\u8054\\u60f3\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\npreAGC {\\r\\npreAGCSwitch y\\r\\npreAGCdy 0\\r\\npreVADkind 1\\r\\npreAGCvvolmin 0.0\\r\\npreAGCvvolfst 15.0\\r\\npreAGCvvolmax 23.0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 992,\n            \"MachineType\": \"S6000\"\n          },\n          {\n            \"Factory\": \"DOOV\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1045,\n            \"MachineType\": \"DOOV L5\"\n          },\n          {\n            \"Factory\": \"Meizu\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\ncloseOpensl y\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"PRO 7 Plus\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndsp {\\r\\npost {\\r\\npostAGCmoddB -12.0\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"vivo Xplay6\"\n          },\n          {\n            \"Factory\": \"HTC\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1047,\n            \"MachineType\": \"HTC S720e\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\nfiAcc {\\r\\nring_buf_mp3 50\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1049,\n            \"MachineType\": \"A33w\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\naec {\\r\\nMkechoRatio 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1051,\n            \"MachineType\": \"STF-AL10\"\n          },\n          {\n            \"Factory\": \"unknown\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nmode 0\\r\\ncap {\\r\\nsource 0\\r\\n}\\r\\nplay {\\r\\nstreamtype 3\\r\\n}\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1073,\n            \"MachineType\": \"msm8909\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1074,\n            \"MachineType\": \"OPPO A57\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1075,\n            \"MachineType\": \"OPPO R11s\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1076,\n            \"MachineType\": \"OPPO R11\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1077,\n            \"MachineType\": \"OPPO A83\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1078,\n            \"MachineType\": \"OPPO A73\"\n          },\n          {\n            \"Factory\": \"samsung\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1079,\n            \"MachineType\": \"SM-G9006V\"\n          },\n          {\n            \"Factory\": \"vivo\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1081,\n            \"MachineType\": \"vivo Y83A\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1083,\n            \"MachineType\": \"OPPO R17\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1084,\n            \"MachineType\": \"OPPO R15\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1085,\n            \"MachineType\": \"OPPO A37M\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1086,\n            \"MachineType\": \"OPPO A7X\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1087,\n            \"MachineType\": \"OPPO A3\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1088,\n            \"MachineType\": \"OPPO A5\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1089,\n            \"MachineType\": \"OPPO A83T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1090,\n            \"MachineType\": \"OPPO R11T\"\n          },\n          {\n            \"Factory\": \"OPPO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1091,\n            \"MachineType\": \"OPPO R9S PLUS\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1092,\n            \"MachineType\": \"vivo Y51A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1093,\n            \"MachineType\": \"vivo V1813A\"\n          },\n          {\n            \"Factory\": \"VIVO\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1095,\n            \"MachineType\": \"vivo Y67\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1097,\n            \"MachineType\": \"MHA-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1098,\n            \"MachineType\": \"ALP-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1099,\n            \"MachineType\": \"VTR-AL00\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1100,\n            \"MachineType\": \"BND-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1101,\n            \"MachineType\": \"COL-AL10\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 1\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1102,\n            \"MachineType\": \"BKL-AL20\"\n          },\n          {\n            \"Factory\": \"HUAWEI\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1103,\n            \"MachineType\": \"PRA-AL00X\"\n          },\n          {\n            \"Factory\": \"Xiaomi\",\n            \"ConfigValue\": \"sharp{\\r\\nos android \\r\\ntrae {\\r\\ndev {\\r\\nlow_latency 0\\r\\n}\\r\\n}\\r\\n}\",\n            \"id\": 1104,\n            \"MachineType\": \"MI 6X\"\n          }\n        ]    }";
            this.a(string2, (c$a)object);
        }
        return c$a.a(this.j);
    }

    public int d() {
        this.m();
        return c$a.b(this.j);
    }

    public int e() {
        this.m();
        return c$a.c(this.j);
    }

    public int f() {
        this.m();
        return c$a.d(this.j);
    }

    public boolean g() {
        this.m();
        return c$a.f(this.j);
    }

    public int h() {
        this.m();
        return c$a.g(this.j);
    }

    public boolean i() {
        String string2;
        long l10;
        long l11;
        Object object;
        String string3 = "Audio";
        String string4 = "UseLowLatencySampleRate";
        long l12 = this.a(string3, string4);
        boolean bl2 = true;
        Object[] objectArray = new Object[bl2];
        objectArray[0] = object = Long.valueOf(l12);
        object = "CloudConfig";
        Object object2 = "defaultValueOfUseLowLatencySampleRate: %d";
        TXCLog.i((String)object, (String)object2, objectArray);
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 == false) {
            l12 = 0L;
        }
        if ((l11 = (l10 = (l13 = 1L) - (l12 = ((b)(object2 = this.b())).a(string2 = ".audio.use_low_latency_samplerate", l12))) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public long j() {
        long l10;
        Object object = "Audio";
        String string2 = "LowLatencySampleRateBlockTime";
        long l11 = this.a((String)object, string2);
        long l12 = l11 - (l10 = (long)-1);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            object = TimeUnit.DAYS;
            long l13 = 7;
            l11 = ((TimeUnit)((Object)object)).toMillis(l13);
        } else {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            l11 = timeUnit.toMillis(l11);
        }
        return l11;
    }

    public void k() {
        boolean bl2 = this.o();
        if (bl2) {
            bl2 = true;
            this.b(bl2);
            c$1 c$1 = new c$1(this);
            c$1.start();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean l() {
        Object object;
        Context context = g;
        boolean bl2 = true;
        try {
            Object object2 = this.m;
            synchronized (object2) {
                object = this.l;
                if (object != null || context == null) break block5;
                object = "liteav_hw_encoder_config";
            }
        }
        catch (Exception exception) {
            TXCLog.e("CloudConfig", "isEnableHWHighProfile: error.", exception);
            return bl2;
        }
        {
            block5: {
                context = context.getSharedPreferences((String)object, 0);
                this.l = context;
            }
            context = this.l;
            object = "enable_high_profile";
            return context.getBoolean((String)object, bl2);
        }
    }
}

