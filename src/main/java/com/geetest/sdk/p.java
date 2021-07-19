/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.provider.Settings$System
 *  android.util.Base64
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Base64;
import com.geetest.sdk.h;
import com.geetest.sdk.i;
import com.geetest.sdk.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import org.json.JSONObject;

public final class p {
    public static String a(Context context) {
        String string2;
        block51: {
            int n10;
            String string3;
            String string4;
            String string5;
            String string6;
            String string7;
            String[] stringArray;
            block50: {
                boolean bl2;
                block49: {
                    block48: {
                        boolean bl3;
                        String string8;
                        Object object;
                        boolean bl4;
                        block47: {
                            stringArray = "deviceid";
                            string7 = "/sdcard/baidu/.cuid";
                            string2 = "$unknown";
                            string6 = "/sdcard/backups/.SystemConfig/.cuid";
                            string5 = "30212102dicudiab";
                            string4 = "utf-8";
                            string3 = "gt_db";
                            String string9 = i.b(context, string3);
                            bl4 = i.a(string9);
                            if (!bl4) {
                                return string9;
                            }
                            string9 = context.getContentResolver();
                            object = "com.baidu.deviceid";
                            bl4 = i.a(string9 = Settings.System.getString((ContentResolver)string9, (String)object));
                            if (!bl4) {
                                i.a(context, string3, string9);
                                return string9;
                            }
                            n10 = 2;
                            try {
                                object = context.getContentResolver();
                                string8 = "com.baidu.deviceid.v2";
                            }
                            catch (Exception exception) {}
                            object = Settings.System.getString((ContentResolver)object, (String)string8);
                            bl3 = i.a((String)object);
                            if (bl3) break block47;
                            object = Base64.decode((String)object, (int)n10);
                            object = h.a((byte[])object, string5, string5);
                            object = o.a((byte[])object, string4);
                            string8 = new JSONObject((String)object);
                            object = string8.getString((String)stringArray);
                            bl3 = i.a((String)object);
                            if (bl3) break block47;
                            i.a(context, string3, (String)object);
                            return object;
                        }
                        string8 = "/sdcard/backups/.SystemConfig/.cuid2";
                        try {
                            object = new FileInputStream(string8);
                        }
                        catch (Exception exception) {}
                        object = o.a((InputStream)object, string4);
                        bl3 = i.a((String)object);
                        if (bl3) break block48;
                        object = Base64.decode((String)object, (int)n10);
                        object = h.a((byte[])object, string5, string5);
                        object = o.a((byte[])object, string4);
                        string8 = new JSONObject((String)object);
                        stringArray = string8.getString((String)stringArray);
                        bl4 = i.a((String)stringArray);
                        if (bl4) break block48;
                        i.a(context, string3, (String)stringArray);
                        return stringArray;
                    }
                    try {
                        stringArray = new File(string6);
                        bl2 = stringArray.exists();
                        if (!bl2) break block49;
                    }
                    catch (Exception exception) {}
                    stringArray = new FileInputStream(string6);
                    stringArray = o.a((InputStream)stringArray, string4);
                    break block50;
                }
                stringArray = new File(string7);
                bl2 = stringArray.exists();
                if (!bl2) break block51;
                stringArray = new FileInputStream(string7);
                stringArray = o.a((InputStream)stringArray, string4);
            }
            stringArray = (String[])Base64.decode((String)stringArray, (int)n10);
            stringArray = (String[])h.a((byte[])stringArray, string5, string5);
            stringArray = o.a((byte[])stringArray, string4);
            string7 = "=";
            stringArray = stringArray.split(string7);
            int n11 = 1;
            string6 = stringArray[n11];
            boolean bl5 = i.a(string6);
            if (bl5) break block51;
            string6 = stringArray[n11];
            i.a(context, string3, string6);
            return stringArray[n11];
        }
        return string2;
    }
}

