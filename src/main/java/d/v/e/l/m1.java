/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.TextUtils
 */
package d.v.e.l;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.zhiyun.common.R$string;
import d.v.e.f;
import d.v.e.l.o1;
import j$.util.DesugarTimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class m1 {
    private static final String a = "m1";
    public static final String b = "yyyy-MM-dd";
    public static final String c = "yyyy/MM/dd";
    public static final String d = "yyyy.MM.dd";
    public static final String e = "yyyy-MM-dd HH:mm:ss";
    public static final String f = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String g = "yyyy/MM/dd HH:mm:ss";
    public static final String h = "yyyy-MM-dd-HH:mm:ss";
    public static final String i = "HH:mm";
    public static final String j = "HH:mm:ss";
    public static final String k = "yyyy-MM-dd'T'HH:mm:ss.SSS Z";
    public static final String l = "yyyy-MM-dd HH:mm";
    public static final long m = 86400000L;
    public static final int n = 86400000;

    public static String A() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(g);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String B(String object) {
        long l10;
        String string2 = "";
        long l11 = Long.parseLong((String)object);
        object = l11;
        try {
            l10 = (Long)object;
        }
        catch (Exception exception) {
            return string2;
        }
        Date date = new Date(l10);
        l10 = System.currentTimeMillis();
        long l12 = date.getTime();
        l10 -= l12;
        l12 = 0L;
        Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object2 <= 0) {
            return string2;
        }
        l10 /= 1000L;
        long l13 = 60;
        long l14 = (l13 = (l10 /= l13) / l13) / (long)24;
        long l15 = 30;
        long l16 = l14 - l15;
        object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object2 >= 0) {
            return "\u4e00\u4e2a\u6708";
        }
        object2 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1);
        if (object2 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(l14);
            ((StringBuilder)object).append("\u5929");
            return ((StringBuilder)object).toString();
        }
        object2 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
        if (object2 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(l13);
            ((StringBuilder)object).append("\u5c0f\u65f6");
            return ((StringBuilder)object).toString();
        }
        object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object2 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append("\u5206\u949f");
            return ((StringBuilder)object).toString();
        }
        return "1\u5206\u949f";
    }

    public static String C(int n10) {
        CharSequence charSequence;
        Object object;
        if (n10 == 0) {
            return "00:00:00";
        }
        int n11 = n10 / 60 / 60;
        int n12 = (n10 %= 3600) / 60;
        int n13 = 1;
        Object object2 = new Object[n13];
        object2[0] = object = Integer.valueOf(n11);
        object = "%d";
        object2 = String.format((String)object, (Object[])object2);
        Object object3 = new Object[n13];
        Integer n14 = n12;
        object3[0] = n14;
        object3 = String.format((String)object, object3);
        Object object4 = new Object[n13];
        n14 = n10 %= 60;
        object4[0] = n14;
        object4 = String.format((String)object, object4);
        object = "0";
        int n15 = 10;
        if (n11 < n15) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
        }
        if (n12 < n15) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(n12);
            object3 = ((StringBuilder)charSequence).toString();
        }
        if (n10 < n15) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(n10);
            object4 = ((StringBuilder)charSequence).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        charSequence = ":";
        stringBuilder.append((String)charSequence);
        stringBuilder.append((String)object3);
        stringBuilder.append((String)charSequence);
        stringBuilder.append((String)object4);
        return stringBuilder.toString();
    }

    public static String D(int n10) {
        Object object;
        if (n10 == 0) {
            return "00:00";
        }
        int n11 = n10 / 60 / 60;
        int n12 = (n10 %= 3600) / 60;
        int n13 = 1;
        Object object2 = new Object[n13];
        object2[0] = object = Integer.valueOf(n11);
        object = "%d";
        object2 = String.format((String)object, (Object[])object2);
        Object object3 = new Object[n13];
        Integer n14 = n12;
        object3[0] = n14;
        object3 = String.format((String)object, (Object[])object3);
        Object object4 = new Object[n13];
        n14 = n10 %= 60;
        object4[0] = n14;
        object4 = String.format((String)object, object4);
        object = "0";
        int n15 = 10;
        if (n11 < n15) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(n11);
            object2 = ((StringBuilder)object2).toString();
        }
        if (n12 < n15) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(n12);
            object3 = ((StringBuilder)object3).toString();
        }
        if (n10 < n15) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(n10);
            object4 = stringBuilder.toString();
        }
        String string2 = ":";
        if (n11 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object3);
            stringBuilder.append(string2);
            stringBuilder.append((String)object4);
            string2 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object2);
            stringBuilder.append(string2);
            stringBuilder.append((String)object3);
            stringBuilder.append(string2);
            stringBuilder.append((String)object4);
            string2 = stringBuilder.toString();
        }
        return string2;
    }

    public static String E(int n10) {
        int n11 = n10 / 3600;
        n10 = n10 % 3600 / 60;
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[2];
        Integer n12 = n11;
        objectArray[0] = n12;
        Integer n13 = n10;
        objectArray[1] = n13;
        return String.format(locale, "%dH:%02d", objectArray);
    }

    public static String F() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static long G(String string2) {
        long l10;
        block5: {
            int n10 = 2;
            SimpleDateFormat[] simpleDateFormatArray = new SimpleDateFormat[n10];
            Cloneable cloneable = new SimpleDateFormat(e);
            simpleDateFormatArray[0] = cloneable;
            String string3 = c;
            cloneable = new SimpleDateFormat(string3);
            int n11 = 1;
            simpleDateFormatArray[n11] = cloneable;
            for (int i10 = 0; i10 < n10; ++i10) {
                try {
                    cloneable = simpleDateFormatArray[i10];
                }
                catch (ParseException parseException) {
                    parseException.printStackTrace();
                    continue;
                }
                cloneable = ((DateFormat)cloneable).parse(string2);
                l10 = ((Date)cloneable).getTime();
                break block5;
            }
            l10 = 0L;
        }
        return l10;
    }

    public static String H(Context object, String object2) {
        if ((object2 = m1.z((String)object2)) == null) {
            return "";
        }
        int n10 = R$string.date_by_lang;
        object = o1.L(object, n10);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)object);
        return simpleDateFormat.format((Date)object2);
    }

    public static String I(String object) {
        String string2 = "";
        String string3 = g;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string3);
        try {
            object = simpleDateFormat.parse((String)object);
        }
        catch (Exception exception) {
            return string2;
        }
        long l10 = System.currentTimeMillis();
        long l11 = ((Date)object).getTime();
        l10 -= l11;
        l11 = 0L;
        Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object2 <= 0) {
            return string2;
        }
        l10 /= 1000L;
        long l12 = 60;
        long l13 = (l12 = (l10 /= l12) / l12) / (long)24;
        long l14 = 30;
        long l15 = l13 - l14;
        object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 >= 0) {
            return "\u4e00\u4e2a\u6708";
        }
        object2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
        if (object2 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(l13);
            ((StringBuilder)object).append("\u5929");
            return ((StringBuilder)object).toString();
        }
        object2 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object2 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(l12);
            ((StringBuilder)object).append("\u5c0f\u65f6");
            return ((StringBuilder)object).toString();
        }
        object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object2 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append("\u5206\u949f");
            return ((StringBuilder)object).toString();
        }
        return "1\u5206\u949f";
    }

    public static final int J(long l10) {
        long l11 = System.currentTimeMillis() - l10;
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            return (int)(l11 / 86400000L + 1L);
        }
        return 0;
    }

    public static String K(Context context, String string2) {
        return m1.L(context.getResources(), string2);
    }

    public static String L(Resources object, String object2) {
        long l10;
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        String string2 = "";
        if (n10 != 0) {
            return string2;
        }
        object2 = ((String)object2).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            object2 = simpleDateFormat.parse((String)object2);
            l10 = ((Date)object2).getTime();
        }
        catch (Exception exception) {
            return string2;
        }
        long l11 = System.currentTimeMillis();
        l10 -= l11;
        l11 = 0L;
        Object object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object3 <= 0) {
            return string2;
        }
        l10 /= 1000L;
        long l12 = 60;
        long l13 = (l12 = (l10 /= l12) / l12) / (long)24;
        long l14 = l13 - l11;
        object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(l13);
            n10 = R$string.day;
            object = o1.N(object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object3 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(l12);
            n10 = R$string.hour;
            object = o1.N(object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(l10);
            n10 = R$string.minute;
            object = o1.N(object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("1");
        n10 = R$string.minute;
        object = o1.N(object, n10);
        ((StringBuilder)object2).append((String)object);
        return ((StringBuilder)object2).toString();
    }

    public static String M(String string2) {
        return m1.L(Resources.getSystem(), string2);
    }

    public static String N(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        object = ((String)object).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        Object object2 = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone((TimeZone)object2);
        try {
            object = simpleDateFormat.parse((String)object);
            object2 = e;
        }
        catch (Exception exception) {
            return string2;
        }
        simpleDateFormat = new SimpleDateFormat((String)object2);
        return simpleDateFormat.format((Date)object);
    }

    public static String O(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = "";
        if (bl2) {
            return string2;
        }
        object = ((String)object).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            object = simpleDateFormat.parse((String)object);
            simpleDateFormat = new SimpleDateFormat(l);
        }
        catch (Exception exception) {
            return string2;
        }
        return simpleDateFormat.format((Date)object);
    }

    public static String P(Context context, String string2) {
        return m1.Q(context.getResources(), string2);
    }

    public static String Q(Resources object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        String string2 = "";
        if (n10 != 0) {
            return string2;
        }
        object2 = ((String)object2).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            object2 = simpleDateFormat.parse((String)object2);
        }
        catch (Exception exception) {
            return string2;
        }
        long l10 = System.currentTimeMillis();
        long l11 = ((Date)object2).getTime();
        l10 -= l11;
        l11 = 0L;
        n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string3 = "1";
        if (n10 <= 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            n10 = R$string.minute_ago;
            object = o1.N((Resources)object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        l10 /= 1000L;
        long l12 = 60;
        long l13 = (l12 = (l10 /= l12) / l12) / (long)24;
        long l14 = l13 - l11;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 > 0) {
            object = new SimpleDateFormat(d);
            return ((DateFormat)object).format((Date)object2);
        }
        Object object3 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(l12);
            n10 = R$string.hour_ago;
            object = o1.N((Resources)object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(l10);
            n10 = R$string.minute_ago;
            object = o1.N((Resources)object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string3);
        n10 = R$string.minute_ago;
        object = o1.N((Resources)object, n10);
        ((StringBuilder)object2).append((String)object);
        return ((StringBuilder)object2).toString();
    }

    public static String R(String string2) {
        return m1.Q(Resources.getSystem(), string2);
    }

    public static String S(Context context, String string2) {
        return m1.T(context.getResources(), string2);
    }

    public static String T(Resources object, String object2) {
        int n10 = TextUtils.isEmpty((CharSequence)object2);
        String string2 = "";
        if (n10 != 0) {
            return string2;
        }
        object2 = ((String)object2).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            object2 = simpleDateFormat.parse((String)object2);
        }
        catch (Exception exception) {
            return string2;
        }
        long l10 = System.currentTimeMillis();
        long l11 = ((Date)object2).getTime();
        l10 -= l11;
        l11 = 0L;
        n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string3 = "1";
        if (n10 <= 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string3);
            n10 = R$string.minute_ago;
            object = o1.N((Resources)object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        l10 /= 1000L;
        long l12 = 60;
        long l13 = (l12 = (l10 /= l12) / l12) / (long)24;
        long l14 = l13 - l11;
        n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n10 > 0) {
            object = new SimpleDateFormat(b);
            return ((DateFormat)object).format((Date)object2);
        }
        Object object3 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(l12);
            n10 = R$string.hour_ago;
            object = o1.N((Resources)object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object3 > 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(l10);
            n10 = R$string.minute_ago;
            object = o1.N((Resources)object, n10);
            ((StringBuilder)object2).append((String)object);
            return ((StringBuilder)object2).toString();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string3);
        n10 = R$string.minute_ago;
        object = o1.N((Resources)object, n10);
        ((StringBuilder)object2).append((String)object);
        return ((StringBuilder)object2).toString();
    }

    public static String U(String string2) {
        return m1.T(Resources.getSystem(), string2);
    }

    public static long V(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        long l10 = 0L;
        if (bl2) {
            return l10;
        }
        string2 = string2.replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            return simpleDateFormat.parse(string2).getTime();
        }
        catch (Exception exception) {
            return l10;
        }
    }

    public static long W() {
        long l10 = System.currentTimeMillis();
        long l11 = 1000L;
        long l12 = (28800L + (l10 /= l11)) % 86400L;
        return (l10 - l12) * l11;
    }

    public static boolean X(long l10) {
        long l11 = System.currentTimeMillis();
        long l12 = 86400000L;
        long l13 = (l11 /= l12) - (l10 /= l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean Y(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        object = ((String)object).replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            object = simpleDateFormat.parse((String)object);
        }
        catch (Exception exception) {
            return bl3;
        }
        long l10 = System.currentTimeMillis();
        long l11 = ((Date)object).getTime();
        l10 -= l11;
        l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 < 0) return bl3;
        return true;
    }

    public static long Z() {
        return System.currentTimeMillis();
    }

    public static String a(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String a0(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = 1L;
        }
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[1];
        Long l13 = 1000000000L / l10;
        objectArray[0] = l13;
        return String.format(locale, "1/%d", objectArray);
    }

    public static String b(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(e);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String b0(long l10) {
        long l11 = 60;
        int n10 = (int)(l10 / l11);
        int n11 = (int)(l10 % l11);
        int n12 = 1;
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[2];
        Integer n13 = n10;
        objectArray[0] = n13;
        Integer n14 = n11 /= n12;
        objectArray[n12] = n14;
        return String.format(locale, "%1$02d:%2$02d", objectArray);
    }

    public static String c(long l10) {
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string2 = "\u521a\u521a";
        if (l12 <= 0) {
            return string2;
        }
        long l13 = System.currentTimeMillis() - l10;
        l12 = (int)(l13 / 60000L);
        long l14 = l13 / 3600000L;
        int n10 = (int)l14;
        long l15 = 86400000L;
        int n11 = (int)(l13 /= l15);
        if (l12 < 0) {
            return m1.k(l10);
        }
        int n12 = 5;
        if (l12 < n12) {
            return string2;
        }
        int n13 = 60;
        n12 = 0;
        int n14 = 1;
        if (l12 < n13) {
            Object[] objectArray = new Object[n14];
            Integer n15 = (int)l12;
            objectArray[0] = n15;
            return String.format("%d\u5206\u949f\u524d", objectArray);
        }
        l12 = 24;
        if (n10 < l12) {
            Object[] objectArray = new Object[n14];
            Integer n16 = n10;
            objectArray[0] = n16;
            return String.format("%d\u5c0f\u65f6\u524d", objectArray);
        }
        l12 = 7;
        if (n11 < l12) {
            Object[] objectArray = new Object[n14];
            Integer n17 = n11;
            objectArray[0] = n17;
            return String.format("%d\u5929\u524d", objectArray);
        }
        return m1.k(l10);
    }

    public static String c0(long l10) {
        long l11 = 3600L;
        int n10 = (int)(l10 / l11);
        int n11 = (int)(l10 % l11) / 60;
        int n12 = (int)(l10 % (long)60);
        int n13 = 1;
        Locale locale = Locale.getDefault();
        Object[] objectArray = new Object[3];
        Integer n14 = n10;
        objectArray[0] = n14;
        Integer n15 = n11;
        objectArray[n13] = n15;
        Integer n16 = n12 /= n13;
        objectArray[2] = n16;
        return String.format(locale, "%1$02d:%2$02d:%3$02d", objectArray);
    }

    public static String d(long l10) {
        Object object;
        long l11 = System.currentTimeMillis();
        long l12 = 86400000L;
        l11 /= l12;
        l12 = l10 / l12;
        long l13 = (l11 -= l12) - (l12 = (long)7);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 > 0) {
            object = m1.k(l10);
        } else {
            l12 = 1L;
            long l14 = l11 - l12;
            object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 > 0) {
                Calendar calendar = Calendar.getInstance();
                TimeZone timeZone = DesugarTimeZone.getTimeZone("GMT+8:00");
                calendar.setTimeZone(timeZone);
                calendar.setTimeInMillis(l10);
                String string2 = "\u661f\u671f\u5929";
                String string3 = "\u661f\u671f\u4e00";
                String string4 = "\u661f\u671f\u4e8c";
                String string5 = "\u661f\u671f\u4e09";
                String string6 = "\u661f\u671f\u56db";
                String string7 = "\u661f\u671f\u4e94";
                String string8 = "\u661f\u671f\u516d";
                object = new String[]{string2, string3, string4, string5, string6, string7, string8};
                int n10 = 7;
                int n11 = calendar.get(n10) + -1;
                if (n11 < 0) {
                    n11 = 0;
                    calendar = null;
                }
                object = object[n11 %= n10];
            } else {
                l12 = 0L;
                long l15 = l11 - l12;
                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                object = object3 > 0 ? "\u6628\u5929 " : m1.f(l10);
            }
        }
        return object;
    }

    public static String e(long l10) {
        int n10;
        long l11 = System.currentTimeMillis();
        long l12 = 1000L;
        long l13 = l11 / l12;
        int n11 = (int)(l13 -= (l12 = l10 / l12));
        int n12 = 1;
        if (n11 < n12) {
            return "\u521a\u521a";
        }
        int n13 = 60;
        if (n11 >= n12 && n11 < n13) {
            Object[] objectArray = new Object[n12];
            Integer n14 = n11;
            objectArray[0] = n14;
            return String.format("%d\u79d2\u524d", objectArray);
        }
        long l14 = 60000L;
        long l15 = l11 / l14;
        n11 = (int)(l15 -= (l14 = l10 / l14));
        if (n11 >= n12 && n11 < n13) {
            Object[] objectArray = new Object[n12];
            Integer n15 = n11;
            objectArray[0] = n15;
            return String.format("%d\u5206\u949f\u524d", objectArray);
        }
        l14 = 3600000L;
        l15 = l11 / l14;
        n11 = (int)(l15 -= (l14 = l10 / l14));
        if (n11 >= n12 && n11 < (n13 = 24)) {
            Object[] objectArray = new Object[n12];
            Integer n16 = n11;
            objectArray[0] = n16;
            return String.format("%d\u5c0f\u65f6\u524d", objectArray);
        }
        Date date = new Date(l10);
        Date date2 = new Date(l11);
        int n17 = m1.j(date, date2);
        if (n17 >= n12 && n17 < (n10 = 7)) {
            Object[] objectArray = new Object[n12];
            Integer n18 = n17;
            objectArray[0] = n18;
            return String.format("%d\u5929\u524d", objectArray);
        }
        return m1.k(l10);
    }

    public static String f(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(i);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String g(long l10) {
        String string2;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return "00:00";
        }
        l11 = l10 / 3600000L;
        object = (int)l11;
        l10 /= 60000L;
        long l13 = 60;
        int n10 = (int)(l10 %= l13);
        CharSequence charSequence = "0";
        CharSequence charSequence2 = "";
        String string3 = "00";
        int n11 = 10;
        if (object <= 0) {
            string2 = string3;
        } else if (object < n11) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append((int)object);
            string2 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence2);
            stringBuilder.append((int)object);
            string2 = stringBuilder.toString();
        }
        if (n10 > 0) {
            if (n10 < n11) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(n10);
                string3 = ((StringBuilder)charSequence2).toString();
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append(n10);
                string3 = ((StringBuilder)charSequence).toString();
            }
        }
        Object[] objectArray = new Object[]{string2, string3};
        return String.format("%s:%s", objectArray);
    }

    public static String h(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(h);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static long i(String object) {
        int n14;
        int n13;
        Calendar calendar = Calendar.getInstance();
        Object object2 = d.v.e.f.a().b();
        int n10 = R$string.today;
        int n11 = TextUtils.equals((CharSequence)(object2 = object2.getString(n10)), (CharSequence)object);
        if (n11 != 0) {
            return calendar.getTimeInMillis();
        }
        object2 = d.v.e.f.a().b();
        n10 = R$string.yesterday;
        n11 = TextUtils.equals((CharSequence)(object2 = object2.getString(n10)), (CharSequence)object);
        if (n11 != 0) {
            calendar.add(5, -1);
            return calendar.getTimeInMillis();
        }
        object2 = "-";
        object = ((String)object).split((String)object2);
        n11 = ((Object)object).length;
        n10 = 3;
        String string2 = "\u4f20\u5165\u7684\u65e5\u671f\u683c\u5f0f\u5fc5\u987b\u7528 - \u5206\u9694, \u4e14\u53ea\u80fd\u662f\u5e74\u6708\u65e5\u6216\u8005\u4eca\u5929, \u6628\u5929";
        if (n11 != n10) {
            object = new IllegalArgumentException(string2);
            throw object;
        }
        n11 = 0;
        object2 = null;
        try {
            object2 = object[0];
            n11 = Integer.parseInt((String)object2);
            n10 = 1;
        }
        catch (NumberFormatException numberFormatException) {
            object = new IllegalArgumentException(string2);
            throw object;
        }
        try {
            Object string3 = object[n10];
            int n12 = Integer.parseInt((String)string3);
            n13 = 2;
        }
        catch (NumberFormatException numberFormatException) {
            object = new IllegalArgumentException(string2);
            throw object;
        }
        try {
            object = object[n13];
            n14 = Integer.parseInt((String)object);
        }
        catch (NumberFormatException numberFormatException) {
            object = new IllegalArgumentException(string2);
            throw object;
        }
        calendar.set(n11, n12 -= n10, n14);
        return calendar.getTimeInMillis();
    }

    public static int j(Date date, Date date2) {
        String string2 = b;
        Cloneable cloneable = new SimpleDateFormat(string2);
        string2 = ((DateFormat)cloneable).format(date);
        date = ((DateFormat)cloneable).parse(string2);
        string2 = ((DateFormat)cloneable).format(date2);
        try {
            date2 = ((DateFormat)cloneable).parse(string2);
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        cloneable = Calendar.getInstance();
        ((Calendar)cloneable).setTime(date);
        long l10 = ((Calendar)cloneable).getTimeInMillis();
        ((Calendar)cloneable).setTime(date2);
        return Integer.parseInt(String.valueOf((((Calendar)cloneable).getTimeInMillis() - l10) / 86400000L));
    }

    public static String k(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String l(long l10, String object) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((String)object);
        object = new Date(l10);
        return simpleDateFormat.format((Date)object);
    }

    public static String m(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(g);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String n(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(l);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String o(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String p(long l10) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f);
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static String q(long l10) {
        return m1.r((Context)d.v.e.f.a().b(), l10);
    }

    public static String r(Context context, long l10) {
        String string2 = b;
        String string3 = m1.l(l10, string2);
        Object object = Calendar.getInstance();
        int n10 = 5;
        ((Calendar)object).add(n10, 0);
        long l11 = ((Calendar)object).getTimeInMillis();
        String string4 = m1.l(l11, string2);
        int n11 = -1;
        ((Calendar)object).add(n10, n11);
        long l12 = ((Calendar)object).getTimeInMillis();
        object = m1.l(l12, string2);
        boolean bl2 = string3.equals(string4);
        if (bl2) {
            int n12 = R$string.today;
            return o1.L(context, n12);
        }
        boolean bl3 = string3.equals(object);
        if (bl3) {
            int n13 = R$string.yesterday;
            return o1.L(context, n13);
        }
        return string3;
    }

    public static String s(String object) {
        int n10;
        String string2 = b;
        Cloneable cloneable = new SimpleDateFormat(string2);
        try {
            object = ((DateFormat)cloneable).parse((String)object);
        }
        catch (Exception exception) {
            n10 = 0;
            object = null;
        }
        long l10 = System.currentTimeMillis();
        cloneable = new Date(l10);
        if (object == null) {
            return "18";
        }
        int n11 = ((Date)cloneable).getYear();
        n10 = ((Date)object).getYear();
        object = new StringBuilder();
        ((StringBuilder)object).append(n11 -= n10);
        ((StringBuilder)object).append("");
        return ((StringBuilder)object).toString();
    }

    public static String t(long l10) {
        String string2;
        long l11 = System.currentTimeMillis();
        long l12 = 86400000L;
        l11 /= l12;
        l12 = l10 / l12;
        long l13 = (l11 -= l12) - (l12 = (long)7);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            string2 = m1.n(l10);
        } else {
            l12 = 1L;
            long l14 = l11 - l12;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object > 0) {
                Object object2 = Calendar.getInstance();
                String[] stringArray = DesugarTimeZone.getTimeZone("GMT+8:00");
                ((Calendar)object2).setTimeZone((TimeZone)stringArray);
                ((Calendar)object2).setTimeInMillis(l10);
                String string3 = "\u661f\u671f\u5929";
                String string4 = "\u661f\u671f\u4e00";
                String string5 = "\u661f\u671f\u4e8c";
                String string6 = "\u661f\u671f\u4e09";
                String string7 = "\u661f\u671f\u56db";
                String string8 = "\u661f\u671f\u4e94";
                String string9 = "\u661f\u671f\u516d";
                stringArray = new String[]{string3, string4, string5, string6, string7, string8, string9};
                object = 7;
                int n10 = ((Calendar)object2).get((int)object) + -1;
                if (n10 < 0) {
                    n10 = 0;
                    object2 = null;
                }
                object2 = stringArray[n10 %= object];
                string2 = m1.f(l10);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append((String)object2);
                object2 = " ";
                stringBuilder.append((String)object2);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
            } else {
                l12 = 0L;
                long l15 = l11 - l12;
                Object object3 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object3 > 0) {
                    string2 = m1.f(l10);
                    StringBuilder stringBuilder = new StringBuilder();
                    String string10 = "\u6628\u5929 ";
                    stringBuilder.append(string10);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                } else {
                    string2 = m1.f(l10);
                }
            }
        }
        return string2;
    }

    public static String u(long l10) {
        long l11 = 60;
        long l12 = (l10 /= 1000L) / l11;
        l11 = l12 / l11;
        int n10 = (int)l11;
        int n11 = (int)l12 % 60;
        int n12 = (int)l10 % 60;
        String string2 = "0%s";
        int n13 = 1;
        if (n10 < n13) {
            n13 = 59;
            if (n11 != n13 || n12 != n13) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("0");
                string2 = String.valueOf(n10);
                stringBuilder.append(string2);
                stringBuilder.append(":%s");
                string2 = stringBuilder.toString();
            }
        } else {
            n12 = 10;
            if (n10 >= n12) {
                string2 = "%s";
            }
        }
        return string2;
    }

    /*
     * WARNING - bad return control flow
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String v(String object) {
        int n10;
        int n11;
        int n12;
        Object object2 = "";
        String string2 = "\u7261\u7f8a\u5ea7";
        String string3 = "\u91d1\u725b\u5ea7";
        String string4 = "\u53cc\u5b50\u5ea7";
        String string5 = "\u5de8\u87f9\u5ea7";
        String string6 = "\u72ee\u5b50\u5ea7";
        String string7 = "\u5904\u5973\u5ea7";
        String string8 = "\u5929\u79e4\u5ea7";
        String string9 = "\u5929\u874e\u5ea7";
        String string10 = "\u5c04\u624b\u5ea7";
        String string11 = "\u9b54\u7faf\u5ea7";
        String[] stringArray = new String[]{"\u9b54\u7faf\u5ea7", "\u6c34\u74f6\u5ea7", "\u53cc\u9c7c\u5ea7", string2, string3, string4, string5, string6, string7, string8, string9, string10, string11};
        String string12 = b;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(string12);
        try {
            object = simpleDateFormat.parse((String)object);
            n12 = ((Date)object).getMonth() + 1;
            n11 = ((Date)object).getDate();
            n10 = 13;
            if (n12 >= n10) return object2;
            if (n12 <= 0 || n11 <= 0 || n11 >= (n10 = 32)) return object2;
        }
        catch (Exception exception) {}
        Object object3 = object2 = (Object)new int[12];
        object3[0] = 20;
        object3[1] = 18;
        object3[2] = 20;
        object3[3] = 20;
        object3[4] = 20;
        object3[5] = 21;
        object3[6] = 22;
        object3[7] = 22;
        object3[8] = 22;
        object3[9] = 22;
        object3[10] = 21;
        object3[11] = 21;
        n10 = n12 + -1;
        Object object4 = object2[n10];
        if (n11 <= object4) {
            n12 = n10;
        }
        if (n12 < 0) return stringArray[11];
        return stringArray[n12];
        return object2;
    }

    public static String w() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(j);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String x() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(c);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static final String y(long l10) {
        SimpleDateFormat simpleDateFormat;
        Date date = new Date(l10);
        long l11 = System.currentTimeMillis();
        long l12 = 86400000L;
        long l13 = l10 % l12;
        long l14 = l11 % l12;
        long l15 = (l11 -= l10) - l12;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object < 0 && (object = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1)) <= 0) {
            String string2 = j;
            simpleDateFormat = new SimpleDateFormat(string2);
        } else {
            String string3 = e;
            simpleDateFormat = new SimpleDateFormat(string3);
        }
        return simpleDateFormat.format(date);
    }

    private static Date z(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        Date date = null;
        if (bl2) {
            return null;
        }
        string2 = string2.replace("Z", " UTC");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(k);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            date = simpleDateFormat.parse(string2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return date;
    }
}

