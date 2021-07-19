/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.text.format.DateFormat
 */
package com.zhiyun.common.util;

import android.text.TextUtils;
import android.text.format.DateFormat;
import com.zhiyun.common.util.Times$1;
import com.zhiyun.common.util.Times$2;
import com.zhiyun.common.util.Times$3;
import com.zhiyun.common.util.Times$4;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Times
extends Enum {
    public static final /* enum */ Times DATA;
    public static final String FORMAT_ISO_8601_DATE = "yyyy-MM-dd";
    public static final String FORMAT_ISO_8601_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_ISO_8601_TIME_DOT = "yyyy.MM.dd HH:mm:ss";
    public static final String FORMAT_ISO_8601_TIME_NO_SECOND = "yyyy-MM-dd HH:mm";
    public static final String FORMAT_TIMESTAMP = "yyyyMMdd_HHmmss";
    public static final String FORMAT_TIMEZONE = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";
    public static final /* enum */ Times TIME;
    public static final /* enum */ Times TIMESTAMP;
    public static final /* enum */ Times TIME_DOT;
    private static final /* synthetic */ Times[] a;

    static {
        Times$1 times$1 = new Times$1();
        DATA = times$1;
        int n10 = 1;
        Times$2 times$2 = new Times$2();
        TIME = times$2;
        int n11 = 2;
        Times$3 times$3 = new Times$3();
        TIME_DOT = times$3;
        int n12 = 3;
        Times$4 times$4 = new Times$4();
        TIMESTAMP = times$4;
        Times[] timesArray = new Times[4];
        timesArray[0] = times$1;
        timesArray[n10] = times$2;
        timesArray[n11] = times$3;
        timesArray[n12] = times$4;
        a = timesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Times() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ Times(Times$1 varnull) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static String getDate(String string2) {
        long l10 = System.currentTimeMillis();
        return DateFormat.format((CharSequence)string2, (long)l10).toString();
    }

    public static String getTimeZoneDesNoSecond(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        object = ((String)object).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_TIMEZONE);
        Object object2 = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone((TimeZone)object2);
        try {
            object = simpleDateFormat.parse((String)object);
            object2 = FORMAT_ISO_8601_TIME_NO_SECOND;
        }
        catch (Exception exception) {
            return string2;
        }
        simpleDateFormat = new SimpleDateFormat((String)object2);
        return simpleDateFormat.format((Date)object);
    }

    public static String getTimeZoneDesSecond(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        object = ((String)object).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_TIMEZONE);
        Object object2 = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone((TimeZone)object2);
        try {
            object = simpleDateFormat.parse((String)object);
            object2 = FORMAT_ISO_8601_TIME_DOT;
        }
        catch (Exception exception) {
            return string2;
        }
        simpleDateFormat = new SimpleDateFormat((String)object2);
        return simpleDateFormat.format((Date)object);
    }

    public static String getTimeZoneDescribe(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        object = ((String)object).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_TIMEZONE);
        Object object2 = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone((TimeZone)object2);
        try {
            object = simpleDateFormat.parse((String)object);
            object2 = FORMAT_ISO_8601_DATE;
        }
        catch (Exception exception) {
            return string2;
        }
        simpleDateFormat = new SimpleDateFormat((String)object2);
        return simpleDateFormat.format((Date)object);
    }

    public static Times valueOf(String string2) {
        return Enum.valueOf(Times.class, string2);
    }

    public static Times[] values() {
        return (Times[])a.clone();
    }

    public String getDate() {
        AbstractMethodError abstractMethodError = new AbstractMethodError();
        throw abstractMethodError;
    }
}

