/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 */
package com.meicam.sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NvsStatisticsInfo {
    private static int NV_OS_TYPE_ANDROID = 1;
    private Context context = null;

    public NvsStatisticsInfo(Context context) {
        this.context = context;
    }

    private static String toMD5(String object) {
        int n10;
        Object object2 = MessageDigest.getInstance("MD5");
        object = ((String)object).getBytes();
        object = ((MessageDigest)object2).digest((byte[])object);
        object2 = new StringBuilder();
        for (int i10 = 0; i10 < (n10 = ((Object)object).length); ++i10) {
            int n11;
            n10 = object[i10] & 0xFF;
            String string2 = Integer.toHexString(n10);
            int n12 = string2.length();
            if (n12 < (n11 = 2)) {
                ((StringBuilder)object2).append(0);
            }
            ((StringBuilder)object2).append(string2);
        }
        return ((StringBuilder)object2).toString();
    }

    public String getAppId() {
        return this.context.getApplicationInfo().packageName;
    }

    public String getDeviceId() {
        String string2 = Settings.Secure.getString((ContentResolver)this.context.getContentResolver(), (String)"android_id");
        String string3 = Build.SERIAL;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        string2 = stringBuilder.toString();
        try {
            string3 = NvsStatisticsInfo.toMD5(string2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            noSuchAlgorithmException.printStackTrace();
            return string2;
        }
        return string3.toUpperCase();
    }

    public ArrayList getLngAndLat() {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        Double d10 = 0.0;
        arrayList.add(d10);
        arrayList.add(d10);
        return arrayList;
    }

    public String getModel() {
        return Build.MODEL;
    }

    public int getOsType() {
        return NV_OS_TYPE_ANDROID;
    }

    public String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public String getPhoneNumber() {
        return "";
    }

    public String getStartTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long l10 = System.currentTimeMillis();
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public void release() {
        this.context = null;
    }
}

