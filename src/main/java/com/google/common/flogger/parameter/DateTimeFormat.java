/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.parameter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DateTimeFormat
extends Enum {
    private static final /* synthetic */ DateTimeFormat[] $VALUES;
    public static final /* enum */ DateTimeFormat DATETIME_FULL;
    public static final /* enum */ DateTimeFormat DATETIME_HOURS_MINUTES;
    public static final /* enum */ DateTimeFormat DATETIME_HOURS_MINUTES_SECONDS;
    public static final /* enum */ DateTimeFormat DATETIME_HOURS_MINUTES_SECONDS_12H;
    public static final /* enum */ DateTimeFormat DATETIME_MONTH_DAY_YEAR;
    public static final /* enum */ DateTimeFormat DATETIME_YEAR_MONTH_DAY;
    public static final /* enum */ DateTimeFormat DATE_CENTURY_PADDED;
    public static final /* enum */ DateTimeFormat DATE_DAY_FULL;
    public static final /* enum */ DateTimeFormat DATE_DAY_OF_MONTH;
    public static final /* enum */ DateTimeFormat DATE_DAY_OF_MONTH_PADDED;
    public static final /* enum */ DateTimeFormat DATE_DAY_OF_YEAR_PADDED;
    public static final /* enum */ DateTimeFormat DATE_DAY_SHORT;
    public static final /* enum */ DateTimeFormat DATE_MONTH_FULL;
    public static final /* enum */ DateTimeFormat DATE_MONTH_PADDED;
    public static final /* enum */ DateTimeFormat DATE_MONTH_SHORT;
    public static final /* enum */ DateTimeFormat DATE_MONTH_SHORT_ALT;
    public static final /* enum */ DateTimeFormat DATE_YEAR_OF_CENTURY_PADDED;
    public static final /* enum */ DateTimeFormat DATE_YEAR_PADDED;
    private static final Map MAP;
    public static final /* enum */ DateTimeFormat TIME_AM_PM;
    public static final /* enum */ DateTimeFormat TIME_EPOCH_MILLIS;
    public static final /* enum */ DateTimeFormat TIME_EPOCH_SECONDS;
    public static final /* enum */ DateTimeFormat TIME_HOUR_12H;
    public static final /* enum */ DateTimeFormat TIME_HOUR_12H_PADDED;
    public static final /* enum */ DateTimeFormat TIME_HOUR_OF_DAY;
    public static final /* enum */ DateTimeFormat TIME_HOUR_OF_DAY_PADDED;
    public static final /* enum */ DateTimeFormat TIME_MILLIS_OF_SECOND_PADDED;
    public static final /* enum */ DateTimeFormat TIME_MINUTE_OF_HOUR_PADDED;
    public static final /* enum */ DateTimeFormat TIME_NANOS_OF_SECOND_PADDED;
    public static final /* enum */ DateTimeFormat TIME_SECONDS_OF_MINUTE_PADDED;
    public static final /* enum */ DateTimeFormat TIME_TZ_NUMERIC;
    public static final /* enum */ DateTimeFormat TIME_TZ_SHORT;
    private final char formatChar;

    static {
        Object object;
        DateTimeFormat dateTimeFormat;
        DateTimeFormat dateTimeFormat2;
        DateTimeFormat dateTimeFormat3;
        DateTimeFormat dateTimeFormat4;
        DateTimeFormat dateTimeFormat5;
        DateTimeFormat dateTimeFormat6;
        DateTimeFormat dateTimeFormat7;
        DateTimeFormat dateTimeFormat8;
        DateTimeFormat dateTimeFormat9;
        DateTimeFormat dateTimeFormat10;
        char c10 = 'H';
        Object object2 = new DateTimeFormat("TIME_HOUR_OF_DAY_PADDED", 0, c10);
        TIME_HOUR_OF_DAY_PADDED = object2;
        char c11 = 'k';
        Object object3 = new DateTimeFormat("TIME_HOUR_OF_DAY", 1, c11);
        TIME_HOUR_OF_DAY = object3;
        char c12 = 'I';
        TIME_HOUR_12H_PADDED = dateTimeFormat10 = new DateTimeFormat("TIME_HOUR_12H_PADDED", 2, c12);
        char c13 = 'l';
        TIME_HOUR_12H = dateTimeFormat9 = new DateTimeFormat("TIME_HOUR_12H", 3, c13);
        char c14 = 'M';
        TIME_MINUTE_OF_HOUR_PADDED = dateTimeFormat8 = new DateTimeFormat("TIME_MINUTE_OF_HOUR_PADDED", 4, c14);
        char c15 = 'S';
        TIME_SECONDS_OF_MINUTE_PADDED = dateTimeFormat7 = new DateTimeFormat("TIME_SECONDS_OF_MINUTE_PADDED", 5, c15);
        TIME_MILLIS_OF_SECOND_PADDED = dateTimeFormat6 = new DateTimeFormat("TIME_MILLIS_OF_SECOND_PADDED", 6, 'L');
        char c16 = 'N';
        TIME_NANOS_OF_SECOND_PADDED = dateTimeFormat5 = new DateTimeFormat("TIME_NANOS_OF_SECOND_PADDED", 7, c16);
        char c17 = 'p';
        TIME_AM_PM = dateTimeFormat4 = new DateTimeFormat("TIME_AM_PM", 8, c17);
        char c18 = 'z';
        TIME_TZ_NUMERIC = dateTimeFormat3 = new DateTimeFormat("TIME_TZ_NUMERIC", 9, c18);
        char c19 = 'Z';
        TIME_TZ_SHORT = dateTimeFormat2 = new DateTimeFormat("TIME_TZ_SHORT", 10, c19);
        TIME_EPOCH_SECONDS = dateTimeFormat = new DateTimeFormat("TIME_EPOCH_SECONDS", 11, 's');
        TIME_EPOCH_MILLIS = object = new DateTimeFormat("TIME_EPOCH_MILLIS", 12, 'Q');
        DateTimeFormat dateTimeFormat11 = object;
        DateTimeFormat[] dateTimeFormatArray = new DateTimeFormat("DATE_MONTH_FULL", 13, 'B');
        DATE_MONTH_FULL = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray2 = dateTimeFormatArray;
        DATE_MONTH_SHORT = object = new DateTimeFormat("DATE_MONTH_SHORT", 14, 'b');
        DateTimeFormat dateTimeFormat12 = object;
        dateTimeFormatArray = new DateTimeFormat("DATE_MONTH_SHORT_ALT", 15, 'h');
        DATE_MONTH_SHORT_ALT = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray3 = dateTimeFormatArray;
        DATE_DAY_FULL = object = new DateTimeFormat("DATE_DAY_FULL", 16, 'A');
        DateTimeFormat dateTimeFormat13 = object;
        dateTimeFormatArray = new DateTimeFormat("DATE_DAY_SHORT", 17, 'a');
        DATE_DAY_SHORT = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray4 = dateTimeFormatArray;
        DATE_CENTURY_PADDED = object = new DateTimeFormat("DATE_CENTURY_PADDED", 18, 'C');
        DateTimeFormat dateTimeFormat14 = object;
        dateTimeFormatArray = new DateTimeFormat("DATE_YEAR_PADDED", 19, 'Y');
        DATE_YEAR_PADDED = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray5 = dateTimeFormatArray;
        DATE_YEAR_OF_CENTURY_PADDED = object = new DateTimeFormat("DATE_YEAR_OF_CENTURY_PADDED", 20, 'y');
        DateTimeFormat dateTimeFormat15 = object;
        dateTimeFormatArray = new DateTimeFormat("DATE_DAY_OF_YEAR_PADDED", 21, 'j');
        DATE_DAY_OF_YEAR_PADDED = dateTimeFormatArray;
        String string2 = "DATE_MONTH_PADDED";
        DateTimeFormat[] dateTimeFormatArray6 = dateTimeFormatArray;
        DATE_MONTH_PADDED = object = new DateTimeFormat(string2, 22, 'm');
        DateTimeFormat dateTimeFormat16 = object;
        dateTimeFormatArray = new DateTimeFormat("DATE_DAY_OF_MONTH_PADDED", 23, 'd');
        DATE_DAY_OF_MONTH_PADDED = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray7 = dateTimeFormatArray;
        DATE_DAY_OF_MONTH = object = new DateTimeFormat("DATE_DAY_OF_MONTH", 24, 'e');
        DateTimeFormat dateTimeFormat17 = object;
        dateTimeFormatArray = new DateTimeFormat("DATETIME_HOURS_MINUTES", 25, 'R');
        DATETIME_HOURS_MINUTES = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray8 = dateTimeFormatArray;
        DATETIME_HOURS_MINUTES_SECONDS = object = new DateTimeFormat("DATETIME_HOURS_MINUTES_SECONDS", 26, 'T');
        DateTimeFormat dateTimeFormat18 = object;
        dateTimeFormatArray = new DateTimeFormat("DATETIME_HOURS_MINUTES_SECONDS_12H", 27, 'r');
        DATETIME_HOURS_MINUTES_SECONDS_12H = dateTimeFormatArray;
        DateTimeFormat[] dateTimeFormatArray9 = dateTimeFormatArray;
        DATETIME_MONTH_DAY_YEAR = object = new DateTimeFormat("DATETIME_MONTH_DAY_YEAR", 28, 'D');
        DateTimeFormat dateTimeFormat19 = object;
        char c20 = 'F';
        dateTimeFormatArray = new DateTimeFormat("DATETIME_YEAR_MONTH_DAY", 29, c20);
        DATETIME_YEAR_MONTH_DAY = dateTimeFormatArray;
        int n10 = 30;
        DateTimeFormat[] dateTimeFormatArray10 = dateTimeFormatArray;
        DATETIME_FULL = object = new DateTimeFormat("DATETIME_FULL", n10, 'c');
        dateTimeFormatArray = new DateTimeFormat[31];
        dateTimeFormatArray[0] = object2;
        dateTimeFormatArray[1] = object3;
        dateTimeFormatArray[2] = dateTimeFormat10;
        dateTimeFormatArray[3] = dateTimeFormat9;
        dateTimeFormatArray[4] = dateTimeFormat8;
        dateTimeFormatArray[5] = dateTimeFormat7;
        dateTimeFormatArray[6] = dateTimeFormat6;
        dateTimeFormatArray[7] = dateTimeFormat5;
        dateTimeFormatArray[8] = dateTimeFormat4;
        dateTimeFormatArray[9] = dateTimeFormat3;
        dateTimeFormatArray[10] = dateTimeFormat2;
        dateTimeFormatArray[11] = dateTimeFormat;
        dateTimeFormatArray[12] = dateTimeFormat11;
        dateTimeFormatArray[13] = dateTimeFormatArray2;
        dateTimeFormatArray[14] = dateTimeFormat12;
        dateTimeFormatArray[15] = dateTimeFormatArray3;
        dateTimeFormatArray[16] = dateTimeFormat13;
        dateTimeFormatArray[17] = dateTimeFormatArray4;
        dateTimeFormatArray[18] = dateTimeFormat14;
        dateTimeFormatArray[19] = dateTimeFormatArray5;
        dateTimeFormatArray[20] = dateTimeFormat15;
        dateTimeFormatArray[21] = dateTimeFormatArray6;
        dateTimeFormatArray[22] = dateTimeFormat16;
        dateTimeFormatArray[23] = dateTimeFormatArray7;
        dateTimeFormatArray[24] = dateTimeFormat17;
        dateTimeFormatArray[25] = dateTimeFormatArray8;
        dateTimeFormatArray[26] = dateTimeFormat18;
        dateTimeFormatArray[27] = dateTimeFormatArray9;
        dateTimeFormatArray[28] = dateTimeFormat19;
        dateTimeFormatArray[29] = dateTimeFormatArray10;
        int n11 = 30;
        dateTimeFormatArray[n11] = object;
        $VALUES = dateTimeFormatArray;
        object2 = new HashMap();
        object3 = DateTimeFormat.values();
        int n12 = ((DateTimeFormat[])object3).length;
        for (int i10 = 0; i10 < n12; ++i10) {
            dateTimeFormat10 = object3[i10];
            c20 = dateTimeFormat10.formatChar;
            object = Character.valueOf(c20);
            if ((object = object2.put(object, dateTimeFormat10)) == null) {
                continue;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("duplicate format character: ");
            ((StringBuilder)object3).append((Object)dateTimeFormat10);
            object3 = ((StringBuilder)object3).toString();
            object2 = new IllegalStateException((String)object3);
            throw object2;
        }
        MAP = Collections.unmodifiableMap(object2);
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DateTimeFormat() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.formatChar = var3_1;
    }

    public static final DateTimeFormat of(char c10) {
        Map map = MAP;
        Character c11 = Character.valueOf(c10);
        return (DateTimeFormat)((Object)map.get(c11));
    }

    public static DateTimeFormat valueOf(String string2) {
        return Enum.valueOf(DateTimeFormat.class, string2);
    }

    public static DateTimeFormat[] values() {
        return (DateTimeFormat[])$VALUES.clone();
    }

    public char getChar() {
        return this.formatChar;
    }
}

