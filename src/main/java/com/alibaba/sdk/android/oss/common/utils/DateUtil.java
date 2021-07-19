/*
 * Decompiled with CFR 0.151.
 */
package com.alibaba.sdk.android.oss.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DateUtil {
    private static final String ALTERNATIVE_ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final String RFC822_DATE_FORMAT = "EEE, dd MMM yyyy HH:mm:ss 'GMT'";
    private static volatile long amendTimeSkewed;

    public static String currentFixedSkewedTimeInRFC822Format() {
        Class<DateUtil> clazz = DateUtil.class;
        synchronized (clazz) {
            long l10 = DateUtil.getFixedSkewedTimeMillis();
            Object object = new Date(l10);
            object = DateUtil.formatRfc822Date((Date)object);
            return object;
        }
    }

    public static String formatAlternativeIso8601Date(Date date) {
        return DateUtil.getAlternativeIso8601DateFormat().format(date);
    }

    public static String formatIso8601Date(Date date) {
        return DateUtil.getIso8601DateFormat().format(date);
    }

    public static String formatRfc822Date(Date date) {
        return DateUtil.getRfc822DateFormat().format(date);
    }

    private static DateFormat getAlternativeIso8601DateFormat() {
        Cloneable cloneable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ALTERNATIVE_ISO8601_DATE_FORMAT, (Locale)cloneable);
        cloneable = new SimpleTimeZone(0, "GMT");
        simpleDateFormat.setTimeZone((TimeZone)cloneable);
        return simpleDateFormat;
    }

    public static long getFixedSkewedTimeMillis() {
        long l10 = System.currentTimeMillis();
        long l11 = amendTimeSkewed;
        return l10 + l11;
    }

    private static DateFormat getIso8601DateFormat() {
        Cloneable cloneable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ISO8601_DATE_FORMAT, (Locale)cloneable);
        cloneable = new SimpleTimeZone(0, "GMT");
        simpleDateFormat.setTimeZone((TimeZone)cloneable);
        return simpleDateFormat;
    }

    private static DateFormat getRfc822DateFormat() {
        Cloneable cloneable = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RFC822_DATE_FORMAT, (Locale)cloneable);
        cloneable = new SimpleTimeZone(0, "GMT");
        simpleDateFormat.setTimeZone((TimeZone)cloneable);
        return simpleDateFormat;
    }

    public static Date parseIso8601Date(String string2) {
        DateFormat dateFormat;
        try {
            dateFormat = DateUtil.getIso8601DateFormat();
        }
        catch (ParseException parseException) {
            return DateUtil.getAlternativeIso8601DateFormat().parse(string2);
        }
        return dateFormat.parse(string2);
    }

    public static Date parseRfc822Date(String string2) {
        return DateUtil.getRfc822DateFormat().parse(string2);
    }

    public static void setCurrentServerTime(long l10) {
        Class<DateUtil> clazz = DateUtil.class;
        synchronized (clazz) {
            long l11 = System.currentTimeMillis();
            l10 -= l11;
            amendTimeSkewed = l10;
            return;
        }
    }
}

