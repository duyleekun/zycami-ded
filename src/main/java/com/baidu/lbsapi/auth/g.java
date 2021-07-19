/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.ConnectivityManager
 *  android.net.Network
 *  android.os.Build$VERSION
 */
package com.baidu.lbsapi.auth;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import com.baidu.lbsapi.auth.ErrorMessage;
import com.baidu.lbsapi.auth.a;
import com.baidu.lbsapi.auth.h;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class g {
    private Context a;
    private String b = null;
    private HashMap c = null;
    private String d = null;

    public g(Context context) {
        this.a = context;
    }

    private String a(Context object) {
        block39: {
            String string2;
            block40: {
                String string3;
                String string4;
                block41: {
                    int n10;
                    block37: {
                        block38: {
                            block36: {
                                string4 = "connectivity";
                                try {
                                    object = object.getSystemService(string4);
                                }
                                catch (Exception exception) {
                                    n10 = com.baidu.lbsapi.auth.a.a;
                                    if (n10 != 0) {
                                        exception.printStackTrace();
                                    }
                                    return null;
                                }
                                object = (ConnectivityManager)object;
                                if (object != null) break block36;
                                return null;
                            }
                            n10 = Build.VERSION.SDK_INT;
                            int n11 = 29;
                            string2 = "wifi";
                            if (n10 < n11) break block37;
                            string4 = object.getActiveNetwork();
                            object = object.getNetworkCapabilities((Network)string4);
                            if (object == null) break block38;
                            n10 = 1;
                            n10 = (int)(object.hasTransport(n10) ? 1 : 0);
                            n11 = 0;
                            Object var6_7 = null;
                            n11 = (int)(object.hasTransport(0) ? 1 : 0);
                            int n12 = 3;
                            n12 = (int)(object.hasTransport(n12) ? 1 : 0);
                            int n13 = 6;
                            n13 = (int)(object.hasTransport(n13) ? 1 : 0);
                            int n14 = 4;
                            n14 = (int)(object.hasTransport(n14) ? 1 : 0);
                            int n15 = 5;
                            boolean bl2 = object.hasTransport(n15);
                            if (n10 != 0) {
                                string2 = "WIFI";
                                break block38;
                            }
                            if (n11 != 0) {
                                string2 = "CELLULAR";
                                break block38;
                            }
                            if (n12 != 0) {
                                string2 = "ETHERNET";
                                break block38;
                            }
                            if (n13 != 0) {
                                string2 = "LoWPAN";
                                break block38;
                            }
                            if (n14 != 0) {
                                string2 = "VPN";
                                break block38;
                            }
                            if (!bl2) break block38;
                            string2 = "WifiAware";
                        }
                        return string2;
                    }
                    object = object.getActiveNetworkInfo();
                    if (object == null) break block39;
                    n10 = (int)(object.isAvailable() ? 1 : 0);
                    if (n10 == 0) break block39;
                    object = object.getExtraInfo();
                    string4 = "cmwap";
                    string3 = "ctwap";
                    if (object == null) break block40;
                    String string5 = ((String)object).trim();
                    string5 = string5.toLowerCase();
                    boolean bl3 = string5.equals(string4);
                    if (bl3) break block41;
                    string5 = ((String)object).trim();
                    string5 = string5.toLowerCase();
                    String string6 = "uniwap";
                    bl3 = string5.equals(string6);
                    if (bl3) break block41;
                    string5 = ((String)object).trim();
                    string5 = string5.toLowerCase();
                    string6 = "3gwap";
                    bl3 = string5.equals(string6);
                    if (bl3) break block41;
                    string5 = ((String)object).trim();
                    string5 = string5.toLowerCase();
                    bl3 = string5.equals(string3);
                    if (!bl3) break block40;
                }
                object = ((String)object).trim();
                object = ((String)object).toLowerCase();
                boolean bl4 = ((String)object).equals(string3);
                string2 = bl4 ? string3 : string4;
            }
            return string2;
        }
        return null;
    }

    /*
     * Exception decompiling
     */
    private void a(HttpsURLConnection var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 37[TRYBLOCK] [138 : 644->647)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static String b(HashMap object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = ((HashMap)object).entrySet().iterator();
        boolean bl3 = true;
        while (bl2 = object.hasNext()) {
            String string2;
            Object object2 = (Map.Entry)object.next();
            if (bl3) {
                bl3 = false;
            } else {
                string2 = "&";
                stringBuilder.append(string2);
            }
            string2 = (String)object2.getKey();
            String string3 = "UTF-8";
            string2 = URLEncoder.encode(string2, string3);
            stringBuilder.append(string2);
            string2 = "=";
            stringBuilder.append(string2);
            object2 = URLEncoder.encode((String)object2.getValue(), string3);
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HttpsURLConnection b() {
        Object object = "Current network is not available.";
        int n10 = -11;
        try {
            int n11;
            String string2 = this.b;
            Object object2 = new URL(string2);
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "https URL: ";
            stringBuilder.append(string3);
            string3 = this.b;
            stringBuilder.append(string3);
            String string4 = stringBuilder.toString();
            com.baidu.lbsapi.auth.a.a(string4);
            Context context = this.a;
            String string5 = this.a(context);
            if (string5 != null && (n11 = string5.equals(string3 = "")) == 0) {
                object = new StringBuilder();
                string3 = "checkNetwork = ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string5);
                object = ((StringBuilder)object).toString();
                com.baidu.lbsapi.auth.a.a((String)object);
                object = "cmwap";
                boolean bl2 = string5.equals(object);
                n11 = 80;
                if (bl2) {
                    Proxy.Type type = Proxy.Type.HTTP;
                    String string6 = "10.0.0.172";
                    InetSocketAddress inetSocketAddress = new InetSocketAddress(string6, n11);
                    object = new Proxy(type, inetSocketAddress);
                    object = ((URL)object2).openConnection((Proxy)object);
                    object = FirebasePerfUrlConnection.instrument(object);
                    object = (URLConnection)object;
                } else {
                    object = "ctwap";
                    bl2 = string5.equals(object);
                    if (bl2) {
                        Proxy.Type type = Proxy.Type.HTTP;
                        String string7 = "10.0.0.200";
                        InetSocketAddress inetSocketAddress = new InetSocketAddress(string7, n11);
                        object = new Proxy(type, inetSocketAddress);
                        object = ((URL)object2).openConnection((Proxy)object);
                        object = FirebasePerfUrlConnection.instrument(object);
                        object = (URLConnection)object;
                    } else {
                        object = ((URL)object2).openConnection();
                        object = FirebasePerfUrlConnection.instrument(object);
                        object = (URLConnection)object;
                    }
                }
                object = (HttpsURLConnection)object;
                object2 = new h(this);
                ((HttpsURLConnection)object).setHostnameVerifier((HostnameVerifier)object2);
                int n12 = 1;
                ((URLConnection)object).setDoInput(n12 != 0);
                ((URLConnection)object).setDoOutput(n12 != 0);
                object2 = "POST";
                ((HttpURLConnection)object).setRequestMethod((String)object2);
                n12 = 50000;
                ((URLConnection)object).setConnectTimeout(n12);
                ((URLConnection)object).setReadTimeout(n12);
                return object;
            }
            com.baidu.lbsapi.auth.a.c((String)object);
            int n13 = -10;
            object = ErrorMessage.a(n13, (String)object);
            this.d = object;
            return null;
        }
        catch (Exception exception) {
            String string8;
            block10: {
                boolean bl3 = com.baidu.lbsapi.auth.a.a;
                if (bl3) {
                    exception.printStackTrace();
                    string8 = exception.getMessage();
                    com.baidu.lbsapi.auth.a.a(string8);
                }
                string8 = "Init httpsurlconnection failed.";
                break block10;
                catch (MalformedURLException malformedURLException) {
                    boolean bl4 = com.baidu.lbsapi.auth.a.a;
                    if (bl4) {
                        malformedURLException.printStackTrace();
                        string8 = malformedURLException.getMessage();
                        com.baidu.lbsapi.auth.a.a(string8);
                    }
                    string8 = "Auth server could not be parsed as a URL.";
                }
            }
            this.d = string8 = ErrorMessage.a(n10, string8);
            return null;
        }
    }

    private HashMap c(HashMap hashMap) {
        boolean bl2;
        HashMap hashMap2 = new HashMap();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = ((String)iterator2.next()).toString();
            Object v10 = hashMap.get(string2);
            hashMap2.put(string2, v10);
        }
        return hashMap2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a(HashMap object) {
        this.c = object = this.c((HashMap)object);
        String string2 = "url";
        this.b = object = (String)((HashMap)object).get(string2);
        object = this.b();
        if (object == null) {
            object = "syncConnect failed,httpsURLConnection is null";
            com.baidu.lbsapi.auth.a.c((String)object);
            return this.d;
        }
        this.a((HttpsURLConnection)object);
        return this.d;
    }

    public boolean a() {
        block15: {
            boolean bl2;
            Object object;
            block13: {
                block14: {
                    int n10;
                    String string2;
                    block12: {
                        com.baidu.lbsapi.auth.a.a("checkNetwork start");
                        try {
                            object = this.a;
                            string2 = "connectivity";
                        }
                        catch (Exception exception) {
                            n10 = com.baidu.lbsapi.auth.a.a;
                            if (n10 != 0) {
                                exception.printStackTrace();
                            }
                            return false;
                        }
                        object = object.getSystemService(string2);
                        object = (ConnectivityManager)object;
                        if (object != null) break block12;
                        return false;
                    }
                    n10 = Build.VERSION.SDK_INT;
                    int n11 = 29;
                    bl2 = true;
                    if (n10 < n11) break block13;
                    string2 = object.getActiveNetwork();
                    object = object.getNetworkCapabilities((Network)string2);
                    if (object == null) break block14;
                    n10 = 12;
                    n10 = (int)(object.hasCapability(n10) ? 1 : 0);
                    if (n10 == 0) break block14;
                    n10 = 16;
                    boolean bl3 = object.hasCapability(n10);
                    if (!bl3) break block14;
                    return bl2;
                }
                return false;
            }
            object = object.getActiveNetworkInfo();
            if (object == null) break block15;
            boolean bl4 = object.isAvailable();
            if (!bl4) break block15;
            com.baidu.lbsapi.auth.a.a("checkNetwork end");
            return bl2;
        }
        return false;
    }
}

