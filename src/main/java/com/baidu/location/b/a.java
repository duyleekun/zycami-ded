/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Process
 *  android.text.TextUtils
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.a$a;
import com.baidu.location.b.a$b;
import com.baidu.location.h.l;
import java.util.Locale;
import org.json.JSONObject;

public class a {
    private static String h = "BDLocConfigManager";
    public boolean a = false;
    public int b = 16;
    public double c = 0.75;
    public int d = 0;
    public int e = 1;
    public double f = -0.1f;
    public int g = 0;
    private SharedPreferences i = null;
    private long j = 300L;
    private String k = null;
    private a$a l = null;
    private boolean m = false;
    private String n = null;
    private String o = null;
    private String p = null;

    public static /* synthetic */ SharedPreferences a(a a10) {
        return a10.i;
    }

    public static a a() {
        return a$b.a;
    }

    private String a(Context object) {
        String string2;
        block11: {
            int n10 = Process.myPid();
            string2 = "";
            String string3 = "activity";
            object = object.getSystemService(string3);
            object = (ActivityManager)object;
            object = object.getRunningAppProcesses();
            if (object == null) break block11;
            try {
                object = object.iterator();
            }
            catch (Exception exception) {}
            while (true) {
                boolean bl2 = object.hasNext();
                if (!bl2) break block11;
                break;
            }
            {
                string3 = object.next();
                string3 = (ActivityManager.RunningAppProcessInfo)string3;
                int n11 = ((ActivityManager.RunningAppProcessInfo)string3).pid;
                if (n11 != n10) continue;
                string2 = ((ActivityManager.RunningAppProcessInfo)string3).processName;
                continue;
            }
        }
        return string2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(LocationClientOption object) {
        int n10;
        int n11;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("&ver=");
        int n12 = com.baidu.location.h.l.A;
        ((StringBuilder)object2).append(n12);
        ((StringBuilder)object2).append("&usr=");
        String string2 = this.c();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append("&app=");
        string2 = this.n;
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append("&prod=");
        object = ((LocationClientOption)object).prodName;
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append("&newwf=1");
        object = ((StringBuilder)object2).toString();
        object2 = Build.VERSION.RELEASE;
        n12 = 0;
        string2 = null;
        if (object2 != null && (n11 = ((String)object2).length()) > (n10 = 6)) {
            object2 = ((String)object2).substring(0, n10);
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("&sv=");
        ((StringBuilder)charSequence).append((String)object2);
        object = ((StringBuilder)charSequence).toString();
        object2 = this.i;
        charSequence = new StringBuilder();
        String string3 = h;
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("_loc");
        charSequence = ((StringBuilder)charSequence).toString();
        n10 = 0;
        string3 = null;
        object2 = object2.getString((String)charSequence, null);
        n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
        if (n11 == 0) {
            try {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)object);
                string3 = "&loc=";
                ((StringBuilder)charSequence).append(string3);
                object2 = Base64.decode((String)object2, (int)0);
                string2 = "UTF-8";
                string3 = new String((byte[])object2, string2);
                ((StringBuilder)charSequence).append(string3);
                object = ((StringBuilder)charSequence).toString();
            }
            catch (Exception exception) {}
        }
        if ((object2 = this.l) == null) {
            this.l = object2 = new a$a(this);
        }
        this.l.a((String)object);
    }

    private void a(String string2) {
        block35: {
            int n10;
            JSONObject jSONObject;
            String string3;
            block34: {
                String string4;
                block33: {
                    int n11;
                    String string5;
                    block32: {
                        String string6;
                        block31: {
                            String string7;
                            block30: {
                                int n12;
                                String string8;
                                block29: {
                                    int n13;
                                    String string9;
                                    block28: {
                                        string3 = "lpcs";
                                        string4 = "gnmcon";
                                        string5 = "gnmcrm";
                                        string6 = "idmoc";
                                        string7 = "wfsm";
                                        string8 = "freq";
                                        string9 = "wfnum";
                                        String string10 = "is_check_Per";
                                        jSONObject = new JSONObject(string2);
                                        boolean bl2 = jSONObject.has(string10);
                                        if (!bl2) break block28;
                                        n13 = jSONObject.getInt(string10);
                                        if (n13 <= 0) break block28;
                                        n13 = 1;
                                        this.a = n13;
                                    }
                                    n13 = (int)(jSONObject.has(string9) ? 1 : 0);
                                    if (n13 == 0) break block29;
                                    n12 = jSONObject.getInt(string9);
                                    this.b = n12;
                                }
                                n12 = (int)(jSONObject.has(string8) ? 1 : 0);
                                if (n12 == 0) break block30;
                                long l10 = jSONObject.getLong(string8);
                                this.j = l10;
                            }
                            boolean bl3 = jSONObject.has(string7);
                            if (!bl3) break block31;
                            double d10 = jSONObject.getDouble(string7);
                            this.c = d10;
                        }
                        boolean bl4 = jSONObject.has(string6);
                        if (!bl4) break block32;
                        n11 = jSONObject.getInt(string6);
                        this.d = n11;
                    }
                    n11 = (int)(jSONObject.has(string5) ? 1 : 0);
                    if (n11 == 0) break block33;
                    double d11 = jSONObject.getDouble(string5);
                    this.f = d11;
                }
                boolean bl5 = jSONObject.has(string4);
                if (!bl5) break block34;
                n10 = jSONObject.getInt(string4);
                this.g = n10;
            }
            n10 = (int)(jSONObject.has(string3) ? 1 : 0);
            if (n10 == 0) break block35;
            int n14 = jSONObject.getInt(string3);
            this.e = n14;
        }
        try {
            this.k = string2;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static /* synthetic */ String b() {
        return h;
    }

    private String c() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("v8.4|");
        String string2 = this.o;
        stringBuilder.append(string2);
        stringBuilder.append("|");
        string2 = Build.MODEL;
        stringBuilder.append(string2);
        stringBuilder.append("&cu=");
        String string3 = this.o;
        stringBuilder.append(string3);
        stringBuilder.append("&mb=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(double d10, double d11, String object) {
        synchronized (this) {
            String string2;
            String string3;
            Object object2;
            Object object3;
            String string4;
            block28: {
                int n10;
                block27: {
                    string4 = this.p;
                    if (string4 != null || object == null) return;
                    string4 = "bd09";
                    boolean bl2 = ((String)object).equals(string4);
                    n10 = 1;
                    if (bl2) break block27;
                    string4 = "wgs84mc";
                    boolean bl3 = ((String)object).equals(string4);
                    if (!bl3) break block28;
                }
                object = "bd092gcj";
                object3 = Jni.coorEncrypt(d11, d10, (String)object);
                double d12 = object3[n10];
                double d13 = object3[0];
                d10 = d12;
                d11 = d13;
            }
            object = Locale.US;
            string4 = "%.5f|%.5f";
            int n11 = 2;
            try {
                Object[] objectArray = new Object[n11];
                objectArray[0] = object2 = Double.valueOf(d11);
                object3 = d10;
                objectArray[n10] = object3;
                object3 = String.format((Locale)object, string4, objectArray);
                this.p = object3;
                string3 = "UTF-8";
                object3 = object3.getBytes(string3);
                object3 = Base64.encodeToString((byte[])object3, (int)0);
                if (object3 == null || (string3 = this.i) == null) return;
                string3 = string3.edit();
                object2 = new StringBuilder();
                string2 = h;
                ((StringBuilder)object2).append(string2);
            }
            catch (Exception exception) {
                object3 = null;
                this.p = null;
                return;
            }
            finally {
            }
            string2 = "_loc";
            {
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                string3.putString((String)object2, (String)object3);
                string3.commit();
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Context object, LocationClientOption locationClientOption) {
        synchronized (this) {
            boolean bl2 = this.m;
            if (!bl2 && object != null) {
                LocationClientOption locationClientOption2;
                this.m = bl2 = true;
                if (locationClientOption2 == null) {
                    locationClientOption2 = new LocationClientOption();
                }
                Object object2 = new StringBuilder();
                String string2 = h;
                ((StringBuilder)object2).append(string2);
                string2 = "_";
                ((StringBuilder)object2).append(string2);
                string2 = this.a((Context)object);
                ((StringBuilder)object2).append(string2);
                object2 = ((StringBuilder)object2).toString();
                h = object2;
                object2 = object.getPackageName();
                this.n = object2;
                try {
                    object2 = LBSAuthManager.getInstance(object);
                    this.o = object2 = ((LBSAuthManager)object2).getCUID();
                }
                catch (Throwable throwable) {
                    bl2 = false;
                    object2 = null;
                    this.o = null;
                }
                object2 = this.i;
                if (object2 == null) {
                    object2 = new StringBuilder();
                    string2 = h;
                    ((StringBuilder)object2).append(string2);
                    string2 = "BDLocConfig";
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    string2 = null;
                    object = object.getSharedPreferences((String)object2, 0);
                    this.i = object;
                }
                if ((object = this.i) != null) {
                    object2 = new StringBuilder();
                    string2 = h;
                    ((StringBuilder)object2).append(string2);
                    string2 = "_lastCheckTime";
                    ((StringBuilder)object2).append(string2);
                    object2 = ((StringBuilder)object2).toString();
                    long l10 = 0L;
                    long l11 = object.getLong((String)object2, l10);
                    object = this.i;
                    CharSequence charSequence = new StringBuilder();
                    String string3 = h;
                    ((StringBuilder)charSequence).append(string3);
                    string3 = "_config";
                    ((StringBuilder)charSequence).append(string3);
                    charSequence = ((StringBuilder)charSequence).toString();
                    string3 = "";
                    object = object.getString((String)charSequence, string3);
                    boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                    if (!bl3) {
                        this.a((String)object);
                    }
                    long l12 = System.currentTimeMillis();
                    long l13 = 1000L;
                    l12 = l12 / l13 - l11;
                    l11 = Math.abs(l12);
                    long l14 = l11 - (l12 = this.j);
                    Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object3 > 0) {
                        l11 = System.currentTimeMillis();
                        object = this.i;
                        object = object.edit();
                        charSequence = new StringBuilder();
                        string3 = h;
                        ((StringBuilder)charSequence).append(string3);
                        string3 = "_lastCheckTime";
                        ((StringBuilder)charSequence).append(string3);
                        charSequence = ((StringBuilder)charSequence).toString();
                        object.putLong((String)charSequence, l11 /= l13);
                        object.commit();
                        this.a(locationClientOption2);
                    }
                }
            }
            return;
        }
    }
}

