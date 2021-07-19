/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserFactory
 */
package com.xiaomi.push;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fy {
    private static int a = 5000;
    private static Vector a;
    private static int b = 330000;
    private static int c = 600000;
    private static int d = 330000;

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        block18: {
            block20: {
                block19: {
                    fy.a = var0 = new Vector();
                    try {
                        var0 = fy.a();
                        var1_3 = var0.length;
                        var2_4 = 0;
lbl6:
                        // 2 sources

                        while (var2_4 < var1_3) {
                            var3_5 = var0[var2_4];
                            var4_6 = "META-INF/smack-config.xml";
                            var3_5 = var3_5.getResources((String)var4_6);
lbl10:
                            // 3 sources

                            while (true) {
                                var5_8 = var3_5.hasMoreElements();
                                if (!var5_8) break block18;
                                var4_6 = var3_5.nextElement();
                                var4_6 = (URL)var4_6;
                                var6_9 = null;
                                break block19;
                                break;
                            }
                        }
                        return;
                    }
                    catch (Exception var0_2) {
                        var0_2.printStackTrace();
                        return;
                    }
                }
                var6_9 = FirebasePerfUrlConnection.openStream((URL)var4_6);
                var4_6 = XmlPullParserFactory.newInstance();
                var4_6 = var4_6.newPullParser();
                var7_10 = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
                var8_11 = 1;
                var4_6.setFeature((String)var7_10, (boolean)var8_11);
                var7_10 = "UTF-8";
                var4_6.setInput(var6_9, (String)var7_10);
                var9_12 = var4_6.getEventType();
                do {
                    if (var9_12 != (var10_13 = 2)) continue;
                    var7_10 = var4_6.getName();
                    var9_12 = (int)var7_10.equals(var11_14 = "className");
                    if (var9_12 != 0) {
                        fy.a((XmlPullParser)var4_6);
                        continue;
                    }
                    var7_10 = var4_6.getName();
                    var9_12 = (int)var7_10.equals(var11_14 = "packetReplyTimeout");
                    if (var9_12 != 0) {
                        var9_12 = fy.a;
                        fy.a = var9_12 = fy.a((XmlPullParser)var4_6, var9_12);
                        continue;
                    }
                    var7_10 = var4_6.getName();
                    var9_12 = (int)var7_10.equals(var11_14 = "keepAliveInterval");
                    if (var9_12 != 0) {
                        var9_12 = fy.b;
                        fy.b = var9_12 = fy.a((XmlPullParser)var4_6, var9_12);
                        continue;
                    }
                    var7_10 = var4_6.getName();
                    var9_12 = (int)var7_10.equals(var11_14 = "mechName");
                    if (var9_12 == 0) continue;
                    var7_10 = fy.a;
                    var11_14 = var4_6.nextText();
                    var7_10.add(var11_14);
                } while ((var9_12 = var4_6.next()) != var8_11);
                {
                    catch (Throwable var0_1) {
                        break block20;
                    }
                    catch (Exception var4_7) {}
                    {
                        var4_7.printStackTrace();
                    }
                }
                try {
                    var6_9.close();
                }
                catch (Exception v0) {}
            }
            try {
                var6_9.close();
            }
            catch (Exception v1) {
                throw var0_1;
            }
            {
                throw var0_1;
            }
        }
        ++var2_4;
        ** GOTO lbl6
        ** while (true)
    }

    private fy() {
    }

    public static int a() {
        return b;
    }

    private static int a(XmlPullParser object, int n10) {
        try {
            object = object.nextText();
        }
        catch (NumberFormatException numberFormatException) {
            numberFormatException.printStackTrace();
            return n10;
        }
        return Integer.parseInt((String)object);
    }

    public static String a() {
        return "3.1.0";
    }

    private static void a(XmlPullParser object) {
        object = object.nextText();
        try {
            Class.forName((String)object);
        }
        catch (ClassNotFoundException classNotFoundException) {
            PrintStream printStream = System.err;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "Error! A startup class specified in smack-config.xml could not be loaded: ";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            printStream.println((String)object);
        }
    }

    private static ClassLoader[] a() {
        int n10 = 2;
        ClassLoader[] classLoaderArray = new ClassLoader[n10];
        ArrayList<ClassLoader> arrayList = fy.class.getClassLoader();
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

    public static int b() {
        return c;
    }
}

