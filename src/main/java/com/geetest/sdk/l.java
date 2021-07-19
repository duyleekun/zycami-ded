/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.Process
 *  android.util.Base64
 *  android.util.Pair
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.util.Base64;
import android.util.Pair;
import com.geetest.sdk.h;
import com.geetest.sdk.i;
import com.geetest.sdk.o;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.UUID;
import org.json.JSONObject;

public final class l {
    private static final String[] a = new String[]{"/sdcard/.system_log.trace", "/sdcard/tencent/.DrvZPZQ", "/sdcard/alipay/.Wg83DS3"};

    public static Pair a(Context pair) {
        String string2 = "gt_di";
        String string3 = i.b((Context)pair, string2);
        int n10 = i.a(string3);
        String string4 = "utf-8";
        Object object = "gee_id";
        String string5 = "VedaT=ZbPq0Zv7Do";
        int n11 = 2;
        if (n10 != 0) {
            int n12 = Process.myPid();
            String[] stringArray = "android.permission.WRITE_EXTERNAL_STORAGE";
            n10 = Process.myUid();
            if ((n12 = pair.checkPermission((String)stringArray, n12, n10)) == 0) {
                n12 = Build.VERSION.SDK_INT;
                n10 = 29;
                if (n12 >= n10 && (n12 = (int)(Environment.isExternalStorageLegacy() ? 1 : 0)) == 0) {
                    return null;
                }
                n12 = 0;
                string3 = null;
                stringArray = a;
                stringArray = stringArray[0];
                Object object2 = new FileReader((String)stringArray);
                object2 = o.a((Reader)object2);
                stringArray = (String[])Base64.decode((String)object2, (int)n11);
                stringArray = (String[])h.a((byte[])stringArray, string5);
                Object object3 = new String((byte[])stringArray);
                Object object4 = new JSONObject((String)object3);
                i.a((Context)pair, string2, (String)object2);
                object4 = object4.getString((String)object);
                try {
                    stringArray = new Pair(object4, object2);
                    return stringArray;
                }
                catch (Exception exception) {
                    n10 = 1;
                    object4 = a;
                    object3 = object4[n10];
                    stringArray = new FileReader((String)object3);
                    stringArray = o.a((Reader)stringArray);
                    object3 = Base64.decode((String)stringArray, (int)n11);
                    object3 = h.a((byte[])object3, string5);
                    String string6 = new String((byte[])object3);
                    JSONObject jSONObject = new JSONObject(string6);
                    i.a((Context)pair, string2, (String)stringArray);
                    object4 = object4[0];
                    l.a((String)stringArray, (String)object4);
                    object3 = jSONObject.getString((String)object);
                    try {
                        object4 = new Pair(object3, (Object)stringArray);
                        return object4;
                    }
                    catch (Exception exception2) {
                        object4 = a;
                        object3 = object4[n11];
                        stringArray = new FileReader((String)object3);
                        stringArray = o.a((Reader)stringArray);
                        object3 = Base64.decode((String)stringArray, (int)n11);
                        object3 = h.a((byte[])object3, string5);
                        string6 = new String((byte[])object3);
                        jSONObject = new JSONObject(string6);
                        i.a((Context)pair, string2, (String)stringArray);
                        object3 = object4[0];
                        l.a((String)stringArray, (String)object3);
                        object4 = object4[n10];
                        l.a((String)stringArray, (String)object4);
                        object3 = jSONObject.getString((String)object);
                        try {
                            object4 = new Pair(object3, (Object)stringArray);
                            return object4;
                        }
                        catch (Exception exception3) {
                            try {
                                stringArray = UUID.randomUUID();
                            }
                            catch (Exception exception4) {}
                            stringArray = stringArray.toString();
                            object4 = new JSONObject();
                            object4.put((String)object, (Object)stringArray);
                            object = "ts";
                            long l10 = System.currentTimeMillis();
                            object4.put((String)object, l10);
                            object = "ver";
                            object3 = "1.0.0";
                            object4.put((String)object, object3);
                            object = object4.toString();
                            object = h.a((String)object, string5);
                            object = Base64.encode((byte[])object, (int)n11);
                            string4 = o.a((byte[])object, string4);
                            i.a((Context)pair, string2, string4);
                            pair = a;
                            string2 = pair[0];
                            l.a(string4, string2);
                            string2 = pair[n10];
                            l.a(string4, string2);
                            pair = pair[n11];
                            l.a(string4, (String)pair);
                            pair = new Pair((Object)stringArray, (Object)string4);
                            return pair;
                        }
                    }
                }
            }
            return null;
        }
        try {
            pair = (Pair)Base64.decode((String)string3, (int)n11);
        }
        catch (Exception exception) {
            return null;
        }
        pair = (Pair)h.a((byte[])pair, string5);
        pair = o.a((byte[])pair, string4);
        string2 = new JSONObject((String)pair);
        string2 = string2.getString((String)object);
        pair = new Pair((Object)string2, (Object)string3);
        return pair;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static void a(String string2, String string3) {
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(string3);
        }
        catch (IOException iOException) {
            return;
        }
        o.a(string2, (Writer)fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }
}

