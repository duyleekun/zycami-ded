/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.utils;

import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    private static final String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static Random random;

    static {
        Random random;
        long l10 = System.currentTimeMillis();
        StringUtil.random = random = new Random(l10);
    }

    private static String convertTimestamp(String charSequence) {
        String string2 = "new Date(";
        int n10 = ((String)charSequence).indexOf(string2);
        if (n10 < 0) {
            return charSequence;
        }
        String string3 = ((String)charSequence).substring(0, n10);
        charSequence = ((String)charSequence).substring(n10).substring(9);
        n10 = ((String)charSequence).length() + -1;
        string2 = ((String)charSequence).substring(n10);
        int n11 = ((String)charSequence).length() + -2;
        charSequence = ((String)charSequence).substring(0, n11);
        long l10 = Long.valueOf((String)charSequence);
        Object object = new Date(l10);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        string3 = "\"";
        ((StringBuilder)charSequence).append(string3);
        object = StringUtil.stringFromDate((Date)object);
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Date dateFromString(String string2) {
        boolean bl2 = StringUtil.isEmpty(string2);
        Date date = null;
        if (bl2) {
            return null;
        }
        bl2 = StringUtil.isDigitString(string2);
        if (bl2) {
            long l10 = Long.parseLong(string2);
            return new Date(l10);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        try {
            return simpleDateFormat.parse(string2);
        }
        catch (Exception exception) {
            return date;
        }
    }

    public static boolean equals(String string2, String string3) {
        if (string2 != null && string3 != null) {
            return string2.equals(string3);
        }
        return false;
    }

    public static boolean equals(List list, List list2) {
        if (list != null && list2 != null) {
            int n10;
            int n11 = list.size();
            if (n11 != (n10 = list2.size())) {
                return false;
            }
            return list.containsAll(list2);
        }
        return false;
    }

    public static boolean equalsIgnoreCase(String string2, String string3) {
        if (string2 != null && string3 != null) {
            return string2.equalsIgnoreCase(string3);
        }
        return false;
    }

    public static String getRandomString(int n10) {
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Random random = StringUtil.random;
            int n11 = 62;
            char c10 = random.nextInt(n11);
            String string2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            c10 = string2.charAt(c10);
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static boolean isDigitString(String string2) {
        int n10;
        if (string2 == null) {
            return false;
        }
        for (int i10 = 0; i10 < (n10 = string2.length()); ++i10) {
            n10 = (int)(Character.isDigit(string2.charAt(i10)) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String string2) {
        int n10;
        if (string2 != null && (n10 = (string2 = string2.trim()).length()) != 0) {
            n10 = 0;
            string2 = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public static String join(CharSequence charSequence, Iterable object) {
        if (charSequence != null && object != null) {
            boolean bl2;
            StringBuilder stringBuilder = new StringBuilder();
            boolean bl3 = true;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                CharSequence charSequence2 = (CharSequence)object.next();
                if (!bl3) {
                    stringBuilder.append(charSequence);
                } else {
                    bl3 = false;
                }
                stringBuilder.append(charSequence2);
            }
            return stringBuilder.toString();
        }
        return "";
    }

    public static String replaceFastjsonDateForm(String string2) {
        String string3;
        String string4;
        boolean bl2;
        boolean bl3 = StringUtil.isEmpty(string2);
        if (bl3) {
            return string2;
        }
        Object object = Pattern.compile("\"[a-zA-Z0-9]+\":new Date\\(\\d+\\)[,})\\]]").matcher(string2);
        HashMap<String, String> hashMap = new HashMap<String, String>();
        while (bl2 = ((Matcher)object).find()) {
            string4 = ((Matcher)object).group();
            string3 = StringUtil.convertTimestamp(string4);
            hashMap.put(string4, string3);
        }
        object = hashMap.keySet().iterator();
        while (bl2 = object.hasNext()) {
            string4 = (String)object.next();
            string3 = (String)hashMap.get(string4);
            string2 = string2.replace(string4, string3);
        }
        return string2;
    }

    public static String stringFromBytes(byte[] byArray) {
        String string2 = "UTF-8";
        try {
            String string3 = new String(byArray, string2);
            return string3;
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static String stringFromDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        TimeZone timeZone = DesugarTimeZone.getTimeZone("UTC");
        simpleDateFormat.setTimeZone(timeZone);
        return simpleDateFormat.format(date);
    }
}

