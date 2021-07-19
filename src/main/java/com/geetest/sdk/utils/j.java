/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.net.Proxy
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Proxy;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.ArrayList;
import org.json.JSONObject;

public class j {
    private static String a = "$unknown";

    public static float a(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        if ((context = context.registerReceiver(null, intentFilter)) != null) {
            int n10 = context.getIntExtra("level", 0);
            int n11 = context.getIntExtra("scale", 100);
            float f10 = (float)n10 * 100.0f;
            float f11 = n11;
            return f10 / f11;
        }
        return 0.0f;
    }

    public static String a() {
        int n10;
        Object object;
        Object object2 = "/proc/meminfo";
        try {
            object = new FileReader((String)object2);
            n10 = 8192;
        }
        catch (Exception exception) {
            return "$unknown";
        }
        object2 = new BufferedReader((Reader)object, n10);
        object = ((BufferedReader)object2).readLine();
        CharSequence charSequence = "\\s+";
        object = ((String)object).split((String)charSequence);
        n10 = 1;
        object = object[n10];
        object = Long.valueOf((String)object);
        long l10 = (Long)object;
        ((BufferedReader)object2).close();
        double d10 = l10;
        double d11 = 1024.0;
        d10 = d10 / d11 / d11;
        object2 = new BigDecimal(d10);
        int n11 = 2;
        n10 = 4;
        object2 = ((BigDecimal)object2).setScale(n11, n10);
        double d12 = ((BigDecimal)object2).doubleValue();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(d12);
        object2 = "GB";
        ((StringBuilder)charSequence).append((String)object2);
        return ((StringBuilder)charSequence).toString();
    }

    public static String b() {
        ArrayList<String> arrayList = new ArrayList<String>();
        InetAddress[] inetAddressArray = "$unknown";
        String string2 = a;
        int n10 = inetAddressArray.equals(string2);
        if (n10 != 0) {
            n10 = 0;
            string2 = null;
            inetAddressArray = new InetAddress[]{};
            String string3 = "www.geetest.com";
            try {
                inetAddressArray = InetAddress.getAllByName(string3);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            int n11 = inetAddressArray.length;
            while (n10 < n11) {
                String string4 = inetAddressArray[n10].getHostAddress();
                arrayList.add(string4);
                ++n10;
            }
            a = ((Object)arrayList).toString();
            return ((Object)arrayList).toString();
        }
        return a;
    }

    public static JSONObject b(Context object) {
        String string2 = "";
        JSONObject jSONObject = new JSONObject();
        Object object2 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        int n10 = 0;
        CharSequence charSequence = null;
        if ((object = object.registerReceiver(null, (IntentFilter)object2)) != null) {
            object2 = "level";
            n10 = -1;
            int n11 = object.getIntExtra((String)object2, n10);
            String string3 = "scale";
            int n12 = object.getIntExtra(string3, n10);
            double d10 = -1.0;
            if (n11 != n10 && n12 != n10) {
                d10 = n11;
                double d11 = n12;
                d10 /= d11;
            }
            object2 = "status";
            n11 = object.getIntExtra((String)object2, n10);
            string3 = "plugged";
            n12 = object.getIntExtra(string3, n10);
            String string4 = "health";
            int n13 = object.getIntExtra(string4, n10);
            charSequence = "br";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(d10);
            stringBuilder.append(string2);
            CharSequence charSequence2 = stringBuilder.toString();
            jSONObject.put((String)charSequence, (Object)charSequence2);
            charSequence = "bs";
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(n11);
            ((StringBuilder)charSequence2).append(string2);
            object2 = ((StringBuilder)charSequence2).toString();
            jSONObject.put((String)charSequence, object2);
            object2 = "plugState";
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(n12);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            jSONObject.put((String)object2, (Object)charSequence);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(n13);
            ((StringBuilder)object2).append(string2);
            object = ((StringBuilder)object2).toString();
            try {
                jSONObject.put(string4, object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return jSONObject;
    }

    /*
     * WARNING - void declaration
     */
    public static boolean c(Context object) {
        void var1_7;
        int n10;
        void var1_4;
        String string2;
        int bl3 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 14;
        if (bl3 >= n11) {
            boolean bl4 = bl2;
        } else {
            boolean bl5 = false;
            string2 = null;
        }
        if (var1_4 != false) {
            object = System.getProperty("http.proxyHost");
            string2 = System.getProperty("http.proxyPort");
            if (string2 == null) {
                string2 = "-1";
            }
            int n12 = Integer.parseInt(string2);
        } else {
            string2 = Proxy.getHost((Context)object);
            int n13 = n10 = Proxy.getPort((Context)object);
            object = string2;
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        if (n10 != 0 || var1_7 == (n10 = -1)) {
            bl2 = false;
        }
        return bl2;
    }
}

