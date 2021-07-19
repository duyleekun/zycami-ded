/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.room.util;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];

    private StringUtil() {
    }

    public static void appendPlaceholders(StringBuilder stringBuilder, int n10) {
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = "?";
            stringBuilder.append(string2);
            int n11 = n10 + -1;
            if (i10 >= n11) continue;
            string2 = ",";
            stringBuilder.append(string2);
        }
    }

    public static String joinIntoString(List list) {
        if (list == null) {
            return null;
        }
        int n10 = list.size();
        if (n10 == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = Integer.toString((Integer)list.get(i10));
            stringBuilder.append(string2);
            int n11 = n10 + -1;
            if (i10 >= n11) continue;
            string2 = ",";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static StringBuilder newStringBuilder() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder;
    }

    public static List splitToIntList(String object) {
        int n10;
        if (object == null) {
            return null;
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        String string2 = ",";
        StringTokenizer stringTokenizer = new StringTokenizer((String)object, string2);
        while ((n10 = stringTokenizer.hasMoreElements()) != 0) {
            object = stringTokenizer.nextToken();
            n10 = Integer.parseInt((String)object);
            object = n10;
            try {
                arrayList.add(object);
            }
            catch (NumberFormatException numberFormatException) {
                string2 = "ROOM";
                String string3 = "Malformed integer list";
                Log.e((String)string2, (String)string3, (Throwable)numberFormatException);
            }
        }
        return arrayList;
    }
}

