/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.NetworkInfo
 *  android.telephony.TelephonyManager
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.xiaomi.push.ax;
import com.xiaomi.push.az$b;
import com.xiaomi.push.be;
import com.xiaomi.push.y;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class az {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b;
    public static final Pattern c;

    static {
        int n10 = 2;
        b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", n10);
        c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", n10);
    }

    public static int a(Context object) {
        block5: {
            int n10;
            block4: {
                n10 = -1;
                String string2 = "connectivity";
                try {
                    object = object.getSystemService(string2);
                }
                catch (Exception exception) {
                    return n10;
                }
                object = (ConnectivityManager)object;
                if (object != null) break block4;
                return n10;
            }
            object = object.getActiveNetworkInfo();
            if (object != null) break block5;
            return n10;
        }
        return object.getType();
    }

    public static NetworkInfo a(Context object) {
        block4: {
            String string2 = "connectivity";
            try {
                object = object.getSystemService(string2);
            }
            catch (Exception exception) {
                return null;
            }
            object = (ConnectivityManager)object;
            if (object != null) break block4;
            return null;
        }
        return object.getActiveNetworkInfo();
    }

    /*
     * Loose catch block
     */
    public static ax a(Context object, String object2, String object3, Map object4, String object5) {
        int n10;
        Object object6;
        block74: {
            Object object7 = new ax();
            Object object8 = null;
            object6 = az.a((String)object2);
            object = az.a((Context)object, (URL)object6);
            n10 = 10000;
            ((URLConnection)object).setConnectTimeout(n10);
            n10 = 15000;
            ((URLConnection)object).setReadTimeout(n10);
            if (object3 != null) break block74;
            object3 = "GET";
        }
        ((HttpURLConnection)object).setRequestMethod((String)object3);
        if (object4 != null) {
            object3 = object4.keySet();
            object3 = object3.iterator();
            while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                object6 = object3.next();
                object6 = (String)object6;
                Object object9 = object4.get(object6);
                object9 = (String)object9;
                ((URLConnection)object).setRequestProperty((String)object6, (String)object9);
            }
        }
        int n11 = TextUtils.isEmpty((CharSequence)object5);
        return n11;
        {
            catch (Throwable throwable) {}
            catch (IOException iOException) {}
        }
        finally {
            n11 = 0;
            object3 = null;
        }
    }

    public static ax a(Context context, String string2, Map object) {
        object = az.a((Map)object);
        return az.a(context, string2, "POST", null, (String)object);
    }

    public static InputStream a(Context context, URL uRL, boolean bl2, String string2, String string3) {
        return az.a(context, uRL, bl2, string2, string3, null, null);
    }

    /*
     * WARNING - void declaration
     */
    public static InputStream a(Context object, URL hashMap, boolean bl2, String string2, String object2, Map map, az$b az$b) {
        if (object != null) {
            if (hashMap != null) {
                Object object3;
                block45: {
                    void var6_20;
                    void var5_19;
                    Object object4;
                    block43: {
                        void var3_11;
                        if (!bl2) {
                            String string3 = az.a(((URL)((Object)hashMap)).toString());
                            object3 = new URL(string3);
                        } else {
                            object3 = hashMap;
                        }
                        boolean bl3 = true;
                        HttpURLConnection.setFollowRedirects(bl3);
                        object = az.a((Context)object, (URL)object3);
                        int n10 = 10000;
                        ((URLConnection)object).setConnectTimeout(n10);
                        int n11 = 15000;
                        ((URLConnection)object).setReadTimeout(n11);
                        boolean bl4 = TextUtils.isEmpty((CharSequence)var3_11);
                        if (bl4) break block43;
                        object3 = "User-Agent";
                        ((URLConnection)object).setRequestProperty((String)object3, (String)var3_11);
                    }
                    if (object4 != null) {
                        object3 = "Cookie";
                        ((URLConnection)object).setRequestProperty((String)object3, (String)object4);
                    }
                    if (var5_19 != null) {
                        object3 = var5_19.keySet();
                        object3 = object3.iterator();
                        while (true) {
                            boolean bl5 = object3.hasNext();
                            if (!bl5) break;
                            Object k10 = object3.next();
                            String string4 = (String)k10;
                            object4 = var5_19.get(string4);
                            object4 = (String)object4;
                            ((URLConnection)object).setRequestProperty(string4, (String)object4);
                            continue;
                            break;
                        }
                    }
                    if (var6_20 != null) {
                        int n12;
                        block46: {
                            block44: {
                                object3 = ((URL)((Object)hashMap)).getProtocol();
                                String string5 = "http";
                                boolean bl6 = ((String)object3).equals(string5);
                                if (bl6) break block44;
                                hashMap = ((URL)((Object)hashMap)).getProtocol();
                                object3 = "https";
                                n12 = (int)(((String)((Object)hashMap)).equals(object3) ? 1 : 0);
                                if (n12 == 0) break block45;
                            }
                            n12 = ((HttpURLConnection)object).getResponseCode();
                            var6_20.a = n12;
                            hashMap = var6_20.a;
                            if (hashMap != null) break block46;
                            hashMap = new HashMap();
                            var6_20.a = hashMap;
                        }
                        n12 = 0;
                        hashMap = null;
                        while (true) {
                            block47: {
                                object3 = ((HttpURLConnection)object).getHeaderFieldKey(n12);
                                String string6 = ((HttpURLConnection)object).getHeaderField(n12);
                                if (object3 == null && string6 == null) break;
                                boolean bl7 = TextUtils.isEmpty((CharSequence)object3);
                                if (bl7) break block47;
                                bl7 = TextUtils.isEmpty((CharSequence)string6);
                                if (bl7) break block47;
                                object4 = var6_20.a;
                                object4.put((Object)object3, (String)string6);
                            }
                            ++n12;
                        }
                    }
                }
                object = ((URLConnection)object).getInputStream();
                try {
                    hashMap = new HashMap((InputStream)object);
                    return hashMap;
                }
                catch (Throwable throwable) {
                    String string7 = throwable.getMessage();
                    hashMap = new HashMap(string7);
                    throw hashMap;
                }
                catch (IOException iOException) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("IOException:");
                    String string8 = iOException.getClass().getSimpleName();
                    ((StringBuilder)object3).append(string8);
                    string8 = ((StringBuilder)object3).toString();
                    hashMap = new HashMap(string8);
                    throw hashMap;
                }
            }
            object = new IllegalArgumentException("url");
            throw object;
        }
        object = new IllegalArgumentException("context");
        throw object;
    }

    public static String a(Context object) {
        String string2;
        CharSequence charSequence;
        block6: {
            charSequence = "";
            boolean bl2 = az.d(object);
            if (bl2) {
                return "wifi";
            }
            string2 = "connectivity";
            try {
                object = object.getSystemService(string2);
            }
            catch (Exception exception) {
                return charSequence;
            }
            object = (ConnectivityManager)object;
            if (object != null) break block6;
            return charSequence;
        }
        object = object.getActiveNetworkInfo();
        if (object == null) {
            return charSequence;
        }
        charSequence = new StringBuilder();
        string2 = object.getTypeName();
        ((StringBuilder)charSequence).append(string2);
        string2 = "-";
        ((StringBuilder)charSequence).append(string2);
        String string3 = object.getSubtypeName();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        object = object.getExtraInfo();
        ((StringBuilder)charSequence).append((String)object);
        return ((StringBuilder)charSequence).toString().toLowerCase();
    }

    public static String a(Context context, URL uRL) {
        return az.a(context, uRL, false, null, "UTF-8", null);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String a(Context object, URL serializable, boolean bl2, String object2, String string2, String string3) {
        void var1_4;
        block5: {
            Object object3;
            try {
                void var5_9;
                object = az.a((Context)object, (URL)serializable, bl2, (String)object3, (String)var5_9);
            }
            catch (Throwable throwable) {
                object = null;
                break block5;
            }
            try {
                int n13;
                int n12;
                Object var4_8;
                int n10 = 1024;
                serializable = new StringBuilder(n10);
                object3 = new InputStreamReader((InputStream)object, var4_8);
                BufferedReader bufferedReader = new BufferedReader((Reader)object3);
                int n11 = 4096;
                object3 = new char[n11];
                while ((n12 = -1) != (n13 = bufferedReader.read((char[])object3))) {
                    n12 = 0;
                    var4_8 = null;
                    ((StringBuilder)serializable).append((char[])object3, 0, n13);
                }
            }
            catch (Throwable throwable) {
                break block5;
            }
            y.a((Closeable)object);
            return ((StringBuilder)serializable).toString();
        }
        y.a((Closeable)object);
        throw var1_4;
    }

    public static String a(String string2) {
        int n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
        if (n10 == 0) {
            new String();
            n10 = 1;
            Object object = new Object[n10];
            object[0] = string2;
            object = String.format("%sbe988a6134bc8254465424e5a70ef037", object);
            Object[] objectArray = new Object[2];
            objectArray[0] = string2;
            string2 = be.a((String)object);
            objectArray[n10] = string2;
            return String.format("%s&key=%s", objectArray);
        }
        return null;
    }

    public static String a(String object, Map object2, File object3, String object4) {
        String string2 = "--";
        String string3 = "\r\n";
        boolean n10 = ((File)object3).exists();
        Object object5 = null;
        if (!n10) {
            return null;
        }
        String string4 = ((File)object3).getName();
        try {
            URL uRL = new URL((String)object);
            object = uRL.openConnection();
            object = FirebasePerfUrlConnection.instrument(object);
            object = (URLConnection)object;
            object = (HttpURLConnection)object;
            int n11 = 15000;
            ((URLConnection)object).setReadTimeout(n11);
            int n12 = 10000;
            ((URLConnection)object).setConnectTimeout(n12);
            boolean bl2 = true;
            ((URLConnection)object).setDoInput(bl2);
            ((URLConnection)object).setDoOutput(bl2);
        }
        catch (IOException iOException) {}
        finally {
            boolean bl3 = false;
            object3 = null;
        }
    }

    public static String a(Map object) {
        int n10;
        String string2 = "UTF-8";
        if (object != null && (n10 = object.size()) > 0) {
            boolean bl2;
            CharSequence charSequence = new StringBuffer();
            Iterator iterator2 = object.entrySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                Map.Entry entry = iterator2.next();
                Object object2 = entry.getKey();
                if (object2 == null || (object2 = entry.getValue()) == null) continue;
                try {
                    object2 = entry.getKey();
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("Failed to convert from params map to string: ");
                    CharSequence charSequence2 = unsupportedEncodingException.toString();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    charSequence2 = ((StringBuilder)charSequence).toString();
                    charSequence = "com.xiaomi.common.Network";
                    Log.d((String)charSequence, (String)charSequence2);
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append("map: ");
                    object = object.toString();
                    ((StringBuilder)charSequence2).append((String)object);
                    object = ((StringBuilder)charSequence2).toString();
                    Log.d((String)charSequence, (String)object);
                    return null;
                }
                object2 = (String)object2;
                object2 = URLEncoder.encode(object2, string2);
                ((StringBuffer)charSequence).append((String)object2);
                object2 = "=";
                ((StringBuffer)charSequence).append((String)object2);
                entry = entry.getValue();
                entry = (String)((Object)entry);
                entry = URLEncoder.encode((String)((Object)entry), string2);
                ((StringBuffer)charSequence).append((String)((Object)entry));
                entry = "&";
                ((StringBuffer)charSequence).append((String)((Object)entry));
            }
            int n11 = ((StringBuffer)charSequence).length();
            if (n11 > 0) {
                n11 = ((StringBuffer)charSequence).length() + -1;
                charSequence = ((StringBuffer)charSequence).deleteCharAt(n11);
            }
            return ((StringBuffer)charSequence).toString();
        }
        return null;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static HttpURLConnection a(Context object, URL uRL) {
        void var0_2;
        boolean bl2;
        void var1_5;
        Object object2 = "http";
        String string2 = var1_5.getProtocol();
        boolean bl3 = ((String)object2).equals(string2);
        if (!bl3 || !(bl2 = az.a(object))) {
            URLConnection uRLConnection = var1_5.openConnection();
            return (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var0_2));
        }
        Proxy.Type type = Proxy.Type.HTTP;
        int n10 = 80;
        String string3 = "10.0.0.200";
        object2 = new InetSocketAddress(string3, n10);
        Proxy proxy = new Proxy(type, (SocketAddress)object2);
        URLConnection uRLConnection = var1_5.openConnection(proxy);
        return (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(var0_2));
    }

    private static URL a(String string2) {
        URL uRL = new URL(string2);
        return uRL;
    }

    public static boolean a(Context object) {
        boolean bl2;
        int n10;
        int n11;
        String string2;
        block7: {
            block6: {
                string2 = ((TelephonyManager)object.getSystemService("phone")).getSimCountryIso();
                n11 = "CN".equalsIgnoreCase(string2);
                if (n11 == 0) {
                    return false;
                }
                string2 = "connectivity";
                try {
                    object = object.getSystemService(string2);
                }
                catch (Exception exception) {}
                object = (ConnectivityManager)object;
                if (object != null) break block6;
                return false;
            }
            object = object.getActiveNetworkInfo();
            if (object != null) break block7;
            return false;
        }
        object = object.getExtraInfo();
        n11 = TextUtils.isEmpty((CharSequence)object);
        if (n11 == 0 && (n11 = ((String)object).length()) >= (n10 = 3) && (bl2 = ((String)object).contains(string2 = "ctwap"))) {
            return true;
        }
        return false;
    }

    public static boolean b(Context context) {
        int n10 = az.a(context);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    public static boolean c(Context object) {
        boolean bl2;
        String string2 = "connectivity";
        object = object.getSystemService(string2);
        object = (ConnectivityManager)object;
        try {
            object = object.getActiveNetworkInfo();
        }
        catch (Exception exception) {
            bl2 = false;
            object = null;
        }
        if (object != null && (bl2 = object.isConnected())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean d(Context object) {
        NetworkInfo networkInfo;
        int n10;
        block6: {
            ConnectivityManager connectivityManager;
            block5: {
                Object object2;
                n10 = 0;
                String string2 = "connectivity";
                try {
                    object2 = object.getSystemService(string2);
                }
                catch (Exception exception) {
                    return n10 != 0;
                }
                connectivityManager = (ConnectivityManager)object2;
                if (connectivityManager != null) break block5;
                return false;
            }
            networkInfo = connectivityManager.getActiveNetworkInfo();
            if (networkInfo != null) break block6;
            return false;
        }
        int n11 = networkInfo.getType();
        int n12 = 1;
        if (n12 != n11) return n10 != 0;
        return n12 != 0;
    }

    public static boolean e(Context context) {
        boolean bl2;
        boolean bl3 = az.f(context);
        if (!(bl3 || (bl3 = az.g(context)) || (bl2 = az.h(context)))) {
            bl2 = false;
            context = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean f(Context context) {
        context = az.a(context);
        boolean bl2 = false;
        if (context == null) {
            return false;
        }
        int n10 = context.getType();
        if (n10 != 0) {
            return false;
        }
        n10 = 13;
        int n11 = context.getSubtype();
        if (n10 == n11) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean g(Context context) {
        if ((context = az.a(context)) == null) {
            return false;
        }
        int n10 = context.getType();
        if (n10 != 0) {
            return false;
        }
        String string2 = context.getSubtypeName();
        String string3 = "TD-SCDMA";
        boolean bl2 = string3.equalsIgnoreCase(string2);
        boolean bl3 = true;
        if (!bl2 && !(bl2 = (string3 = "CDMA2000").equalsIgnoreCase(string2)) && (n10 = (int)((string3 = "WCDMA").equalsIgnoreCase(string2) ? 1 : 0)) == 0) {
            int n11 = context.getSubtype();
            switch (n11) {
                default: {
                    return false;
                }
                case 3: 
                case 5: 
                case 6: 
                case 8: 
                case 9: 
                case 10: 
                case 12: 
                case 14: 
                case 15: 
            }
        }
        return bl3;
    }

    public static boolean h(Context context) {
        int n10;
        if ((context = az.a(context)) == null) {
            return false;
        }
        int n11 = context.getType();
        if (n11) {
            return false;
        }
        int n12 = context.getSubtype();
        if (n12 != (n11 = 1) && n12 != (n10 = 2) && n12 != (n10 = 4) && n12 != (n10 = 7) && n12 != (n10 = 11)) {
            return false;
        }
        return n11 != 0;
    }
}

