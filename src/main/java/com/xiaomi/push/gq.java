/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.xiaomi.push;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.xiaomi.push.gh;
import com.xiaomi.push.gk;
import com.xiaomi.push.go;
import com.xiaomi.push.gp;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParserFactory;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class gq {
    private static gq a;
    private Map a;
    private Map b;

    private gq() {
        ConcurrentHashMap concurrentHashMap;
        this.a = concurrentHashMap = new ConcurrentHashMap();
        this.b = concurrentHashMap = new ConcurrentHashMap();
        this.a();
    }

    public static gq a() {
        Class<gq> clazz = gq.class;
        synchronized (clazz) {
            gq gq2 = a;
            if (gq2 == null) {
                a = gq2 = new gq();
            }
            gq2 = a;
            return gq2;
        }
    }

    private String a(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = "<";
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        String string5 = "/>";
        stringBuilder.append(string5);
        if (string2 != null) {
            stringBuilder.append(string4);
            stringBuilder.append(string3);
            stringBuilder.append(string5);
        }
        return stringBuilder.toString();
    }

    private ClassLoader[] a() {
        int n10 = 2;
        ClassLoader[] classLoaderArray = new ClassLoader[n10];
        ArrayList<ClassLoader> arrayList = gq.class.getClassLoader();
        classLoaderArray[0] = arrayList;
        arrayList = Thread.currentThread().getContextClassLoader();
        int n11 = 1;
        classLoaderArray[n11] = arrayList;
        arrayList = new ArrayList<ClassLoader>();
        for (int i10 = 0; i10 < n10; ++i10) {
            ClassLoader classLoader = classLoaderArray[i10];
            if (classLoader == null) continue;
            arrayList.add(classLoader);
        }
        ClassLoader[] classLoaderArray2 = new ClassLoader[arrayList.size()];
        return arrayList.toArray(classLoaderArray2);
    }

    public Object a(String string2, String string3) {
        string2 = this.a(string2, string3);
        return this.a.get(string2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        block24: {
            var1_1 = this.a();
            var2_4 = var1_1.length;
            var3_5 = 0;
lbl5:
            // 2 sources

            while (true) {
                if (var3_5 >= var2_4) return;
                var4_6 = var1_1[var3_5];
                var5_7 = "META-INF/smack.providers";
                var4_6 = var4_6.getResources((String)var5_7);
lbl10:
                // 3 sources

                while (var6_8 = var4_6.hasMoreElements()) {
                    var5_7 = var4_6.nextElement();
                    var5_7 = (URL)var5_7;
                    var7_9 = null;
                    ** GOTO lbl19
                }
                break block24;
                break;
            }
            {
                catch (Exception var1_3) {
                    var1_3.printStackTrace();
                    return;
                }
lbl19:
                // 1 sources

                try {
                    var7_9 = FirebasePerfUrlConnection.openStream((URL)var5_7);
                    var5_7 = XmlPullParserFactory.newInstance();
                    var5_7 = var5_7.newPullParser();
                    var8_10 = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
                    var9_13 = 1;
                    var5_7.setFeature(var8_10, (boolean)var9_13);
                    var8_10 = "UTF-8";
                    var5_7.setInput(var7_9, var8_10);
                    var10_14 = var5_7.getEventType();
                    block15: do {
                        if (var10_14 != (var11_15 = 2)) continue;
                        var8_10 = var5_7.getName();
                        var10_14 = (int)var8_10.equals(var12_16 /* !! */  = "iqProvider");
                        if (var10_14 != 0) {
                            var5_7.next();
                            var5_7.next();
                            var8_10 = var5_7.nextText();
                            var5_7.next();
                            var5_7.next();
                            var12_16 /* !! */  = var5_7.nextText();
                            var5_7.next();
                            var5_7.next();
                            var13_17 /* !! */  = var5_7.nextText();
                            var8_10 = this.a(var8_10, (String)var12_16 /* !! */ );
                            var12_16 /* !! */  = this.b;
                            var11_15 = (int)var12_16 /* !! */ .containsKey(var8_10);
                            if (var11_15 != 0) continue;
                            try {
                                var12_16 /* !! */  = Class.forName((String)var13_17 /* !! */ );
                                var13_17 /* !! */  = go.class;
                                var14_18 = var13_17 /* !! */ .isAssignableFrom(var12_16 /* !! */ );
                                if (var14_18) {
                                    var13_17 /* !! */  = this.b;
                                    var12_16 /* !! */  = var12_16 /* !! */ .newInstance();
lbl60:
                                    // 2 sources

                                    while (true) {
                                        var13_17 /* !! */ .put(var8_10, var12_16 /* !! */ );
                                        break;
                                    }
                                }
                                var13_17 /* !! */  = gh.class;
                                var14_18 = var13_17 /* !! */ .isAssignableFrom(var12_16 /* !! */ );
                                if (!var14_18) ** GOTO lbl113
                                var13_17 /* !! */  = this.b;
                                ** continue;
                            }
                            catch (ClassNotFoundException var8_11) lbl-1000:
                            // 2 sources

                            {
                                while (true) {
                                    var8_10.printStackTrace();
                                    break;
                                }
                            }
                        } else {
                            var8_10 = var5_7.getName();
                            var10_14 = (int)var8_10.equals(var12_16 /* !! */  = "extensionProvider");
                            if (var10_14 == 0) continue;
                            var5_7.next();
                            var5_7.next();
                            var8_10 = var5_7.nextText();
                            var5_7.next();
                            var5_7.next();
                            var12_16 /* !! */  = var5_7.nextText();
                            var5_7.next();
                            var5_7.next();
                            var13_17 /* !! */  = var5_7.nextText();
                            var8_10 = this.a(var8_10, (String)var12_16 /* !! */ );
                            var12_16 /* !! */  = this.a;
                            var11_15 = (int)var12_16 /* !! */ .containsKey(var8_10);
                            if (var11_15 != 0) continue;
                            try {
                                var12_16 /* !! */  = Class.forName(var13_17 /* !! */ );
                                var13_17 /* !! */  = gp.class;
                                var14_18 = var13_17 /* !! */ .isAssignableFrom(var12_16 /* !! */ );
                                if (var14_18) {
                                    var13_17 /* !! */  = this.a;
                                    var12_16 /* !! */  = var12_16 /* !! */ .newInstance();
lbl102:
                                    // 2 sources

                                    while (true) {
                                        var13_17 /* !! */ .put(var8_10, var12_16 /* !! */ );
                                        continue block15;
                                        break;
                                    }
                                }
                                var13_17 /* !! */  = gk.class;
                                var14_18 = var13_17 /* !! */ .isAssignableFrom(var12_16 /* !! */ );
                                if (!var14_18) continue;
                                var13_17 /* !! */  = this.a;
                                ** continue;
                            }
                            catch (ClassNotFoundException var8_12) {
                                ** continue;
                            }
                        }
lbl113:
                        // 9 sources

                    } while ((var10_14 = var5_7.next()) != var9_13);
                }
                catch (Throwable var1_2) {}
                {
                    var7_9.close();
                    throw var1_2;
                }
                try {
                    var7_9.close();
                }
                catch (Exception v0) {}
                ** GOTO lbl10
            }
        }
        ++var3_5;
        ** while (true)
    }

    public void a(String object, String string2, Object object2) {
        boolean bl2 = object2 instanceof gp;
        if (!bl2 && !(bl2 = object2 instanceof Class)) {
            object = new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
            throw object;
        }
        object = this.a((String)object, string2);
        this.a.put(object, object2);
    }
}

