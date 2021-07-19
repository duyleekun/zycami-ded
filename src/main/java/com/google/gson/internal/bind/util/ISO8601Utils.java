/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind.util;

import j$.util.DesugarTimeZone;
import java.io.Serializable;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class ISO8601Utils {
    private static final TimeZone TIMEZONE_UTC = DesugarTimeZone.getTimeZone("UTC");
    private static final String UTC_ID = "UTC";

    private static boolean checkOffset(String string2, int n10, char c10) {
        char c11;
        int n11 = string2.length();
        if (n10 < n11 && (c11 = string2.charAt(n10)) == c10) {
            c11 = '\u0001';
        } else {
            c11 = '\u0000';
            string2 = null;
        }
        return c11 != 0;
    }

    public static String format(Date date) {
        TimeZone timeZone = TIMEZONE_UTC;
        return ISO8601Utils.format(date, false, timeZone);
    }

    public static String format(Date date, boolean bl2) {
        TimeZone timeZone = TIMEZONE_UTC;
        return ISO8601Utils.format(date, bl2, timeZone);
    }

    public static String format(Date date, boolean n10, TimeZone timeZone) {
        long l10;
        char c10;
        Serializable serializable = Locale.US;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, (Locale)serializable);
        gregorianCalendar.setTime(date);
        char c11 = '\u0004';
        if (n10 != 0) {
            c10 = c11;
        } else {
            c10 = '\u0000';
            serializable = null;
        }
        int n11 = 19 + c10;
        c10 = timeZone.getRawOffset();
        char c12 = '\u0001';
        c10 = c10 == '\u0000' ? c12 : (char)'\u0006';
        serializable = new StringBuilder(n11 += c10);
        n11 = gregorianCalendar.get(c12);
        ISO8601Utils.padInt((StringBuilder)serializable, n11, c11);
        c11 = '-';
        ((StringBuilder)serializable).append(c11);
        n11 = 2;
        int n12 = gregorianCalendar.get(n11) + c12;
        ISO8601Utils.padInt((StringBuilder)serializable, n12, n11);
        ((StringBuilder)serializable).append(c11);
        int n13 = gregorianCalendar.get(5);
        ISO8601Utils.padInt((StringBuilder)serializable, n13, n11);
        ((StringBuilder)serializable).append('T');
        int n14 = gregorianCalendar.get(11);
        ISO8601Utils.padInt((StringBuilder)serializable, n14, n11);
        char c13 = ':';
        ((StringBuilder)serializable).append(c13);
        n12 = gregorianCalendar.get(12);
        ISO8601Utils.padInt((StringBuilder)serializable, n12, n11);
        ((StringBuilder)serializable).append(c13);
        n12 = gregorianCalendar.get(13);
        ISO8601Utils.padInt((StringBuilder)serializable, n12, n11);
        if (n10 != 0) {
            ((StringBuilder)serializable).append('.');
            n10 = gregorianCalendar.get(14);
            n12 = 3;
            ISO8601Utils.padInt((StringBuilder)serializable, n10, n12);
        }
        if ((n10 = timeZone.getOffset(l10 = gregorianCalendar.getTimeInMillis())) != 0) {
            int n15 = n10 / 60000;
            int n16 = Math.abs(n15 / 60);
            n15 = Math.abs(n15 % 60);
            if (n10 >= 0) {
                c11 = '+';
            }
            ((StringBuilder)serializable).append(c11);
            ISO8601Utils.padInt((StringBuilder)serializable, n16, n11);
            ((StringBuilder)serializable).append(c13);
            ISO8601Utils.padInt((StringBuilder)serializable, n15, n11);
        } else {
            c11 = 'Z';
            ((StringBuilder)serializable).append(c11);
        }
        return ((StringBuilder)serializable).toString();
    }

    private static int indexOfNonDigit(String string2, int n10) {
        int n11;
        while (n10 < (n11 = string2.length())) {
            int n12;
            n11 = string2.charAt(n10);
            if (n11 >= (n12 = 48) && n11 <= (n12 = 57)) {
                ++n10;
                continue;
            }
            return n10;
        }
        return string2.length();
    }

    private static void padInt(StringBuilder stringBuilder, int n10, int n11) {
        String string2 = Integer.toString(n10);
        int c10 = string2.length();
        n11 -= c10;
        while (n11 > 0) {
            char c11 = '0';
            stringBuilder.append(c11);
            n11 += -1;
        }
        stringBuilder.append(string2);
    }

    /*
     * WARNING - void declaration
     */
    public static Date parse(String string2, ParsePosition parsePosition) {
        void var20_24;
        CharSequence charSequence;
        RuntimeException runtimeException;
        CharSequence charSequence2;
        Object object;
        int n10;
        String string3;
        block90: {
            Object object2;
            int n11;
            int n12;
            int n13;
            int n14;
            int n15;
            int n16;
            int n17;
            int n18;
            int n19;
            ParsePosition parsePosition2;
            block92: {
                block94: {
                    block95: {
                        int n20;
                        int n21;
                        int n22;
                        block93: {
                            int n23;
                            block91: {
                                block89: {
                                    block98: {
                                        block97: {
                                            block87: {
                                                block88: {
                                                    block86: {
                                                        block85: {
                                                            string3 = string2;
                                                            parsePosition2 = parsePosition;
                                                            n19 = parsePosition.getIndex();
                                                            n18 = n19 + 4;
                                                            n19 = ISO8601Utils.parseInt(string2, n19, n18);
                                                            n10 = 45;
                                                            n17 = ISO8601Utils.checkOffset(string2, n18, (char)n10);
                                                            if (n17 != 0) {
                                                                ++n18;
                                                            }
                                                            n17 = n18 + 2;
                                                            n18 = ISO8601Utils.parseInt(string3, n18, n17);
                                                            n16 = ISO8601Utils.checkOffset(string3, n17, (char)n10);
                                                            if (n16 != 0) {
                                                                ++n17;
                                                            }
                                                            n16 = n17 + 2;
                                                            n17 = ISO8601Utils.parseInt(string3, n17, n16);
                                                            n15 = 84;
                                                            n15 = (int)(ISO8601Utils.checkOffset(string3, n16, (char)n15) ? 1 : 0);
                                                            n14 = 1;
                                                            if (n15 != 0) break block85;
                                                            n22 = string2.length();
                                                            if (n22 > n16) break block85;
                                                            n18 -= n14;
                                                            object = new GregorianCalendar(n19, n18, n17);
                                                            parsePosition2.setIndex(n16);
                                                            return ((Calendar)object).getTime();
                                                        }
                                                        n22 = 43;
                                                        n21 = 90;
                                                        n23 = 2;
                                                        if (n15 == 0) break block97;
                                                        n15 = ++n16 + 2;
                                                        n16 = ISO8601Utils.parseInt(string3, n16, n15);
                                                        n13 = 58;
                                                        n12 = ISO8601Utils.checkOffset(string3, n15, (char)n13);
                                                        if (n12 != 0) {
                                                            ++n15;
                                                        }
                                                        n12 = n15 + 2;
                                                        n15 = ISO8601Utils.parseInt(string3, n15, n12);
                                                        n13 = (int)(ISO8601Utils.checkOffset(string3, n12, (char)n13) ? 1 : 0);
                                                        if (n13 == 0) break block86;
                                                        ++n12;
                                                    }
                                                    n13 = string2.length();
                                                    if (n13 <= n12) break block87;
                                                    n13 = string3.charAt(n12);
                                                    if (n13 == n21 || n13 == n22 || n13 == n10) break block87;
                                                    n13 = n12 + 2;
                                                    n12 = ISO8601Utils.parseInt(string3, n12, n13);
                                                    n20 = 59;
                                                    if (n12 > n20 && n12 < (n20 = 63)) {
                                                        n12 = 59;
                                                    }
                                                    n20 = 46;
                                                    n20 = (int)(ISO8601Utils.checkOffset(string3, n13, (char)n20) ? 1 : 0);
                                                    if (n20 == 0) break block88;
                                                    n20 = ++n13 + 1;
                                                    n20 = ISO8601Utils.indexOfNonDigit(string3, n20);
                                                    n11 = n13 + 3;
                                                    n11 = Math.min(n20, n11);
                                                    int n24 = ISO8601Utils.parseInt(string3, n13, n11);
                                                    if ((n11 -= n13) != n14) {
                                                        if (n11 == n23) {
                                                            n24 *= 10;
                                                        }
                                                    } else {
                                                        n24 *= 100;
                                                    }
                                                    n11 = n15;
                                                    n13 = n24;
                                                    n15 = n16;
                                                    n16 = n20;
                                                    break block89;
                                                }
                                                n11 = n15;
                                                n15 = n16;
                                                n16 = n13;
                                                n13 = 0;
                                                break block89;
                                            }
                                            n11 = n15;
                                            n13 = 0;
                                            n15 = n16;
                                            n16 = n12;
                                            break block98;
                                        }
                                        n15 = 0;
                                        n11 = 0;
                                        n13 = 0;
                                    }
                                    n12 = 0;
                                }
                                n20 = string2.length();
                                if (n20 <= n16) break block90;
                                n20 = string3.charAt(n16);
                                n23 = 5;
                                if (n20 != n21) break block91;
                                object = TIMEZONE_UTC;
                                n16 += n14;
                                break block92;
                            }
                            if (n20 != n22 && n20 != n10) {
                                charSequence2 = new StringBuilder();
                                object = "Invalid time zone indicator '";
                                ((StringBuilder)charSequence2).append((String)object);
                                ((StringBuilder)charSequence2).append((char)n20);
                                object = "'";
                                ((StringBuilder)charSequence2).append((String)object);
                                charSequence2 = ((StringBuilder)charSequence2).toString();
                                runtimeException = new IndexOutOfBoundsException((String)charSequence2);
                                throw runtimeException;
                            }
                            object = string3.substring(n16);
                            n22 = ((String)object).length();
                            if (n22 >= n23) break block93;
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append((String)object);
                            object = "00";
                            ((StringBuilder)object2).append((String)object);
                            object = ((StringBuilder)object2).toString();
                        }
                        n22 = ((String)object).length();
                        n16 += n22;
                        object2 = "+0000";
                        n22 = (int)(((String)object2).equals(object) ? 1 : 0);
                        if (n22 != 0) break block94;
                        object2 = "+00:00";
                        n22 = (int)(((String)object2).equals(object) ? 1 : 0);
                        if (n22 != 0) break block94;
                        object2 = new StringBuilder();
                        String string4 = "GMT";
                        ((StringBuilder)object2).append(string4);
                        ((StringBuilder)object2).append((String)object);
                        object = ((StringBuilder)object2).toString();
                        object2 = DesugarTimeZone.getTimeZone((String)object);
                        string4 = ((TimeZone)object2).getID();
                        n20 = (int)(string4.equals(object) ? 1 : 0);
                        if (n20 != 0) break block95;
                        String string5 = ":";
                        String string6 = "";
                        string4 = string4.replace(string5, string6);
                        n21 = (int)(string4.equals(object) ? 1 : 0);
                        if (n21 != 0) break block95;
                        charSequence2 = new StringBuilder();
                        charSequence = "Mismatching time zone indicator: ";
                        ((StringBuilder)charSequence2).append((String)charSequence);
                        ((StringBuilder)charSequence2).append((String)object);
                        object = " given, resolves to ";
                        ((StringBuilder)charSequence2).append((String)object);
                        object = ((TimeZone)object2).getID();
                        ((StringBuilder)charSequence2).append((String)object);
                        charSequence2 = ((StringBuilder)charSequence2).toString();
                        runtimeException = new IndexOutOfBoundsException((String)charSequence2);
                        throw runtimeException;
                    }
                    object = object2;
                    break block92;
                }
                object = TIMEZONE_UTC;
            }
            object2 = new GregorianCalendar((TimeZone)object);
            n10 = 0;
            object = null;
            ((Calendar)object2).setLenient(false);
            ((Calendar)object2).set(n14, n19);
            n18 -= n14;
            n19 = 2;
            ((Calendar)object2).set(n19, n18);
            n19 = 5;
            ((Calendar)object2).set(n19, n17);
            n19 = 11;
            ((Calendar)object2).set(n19, n15);
            n19 = 12;
            ((Calendar)object2).set(n19, n11);
            n19 = 13;
            ((Calendar)object2).set(n19, n12);
            n19 = 14;
            ((Calendar)object2).set(n19, n13);
            parsePosition2.setIndex(n16);
            return ((Calendar)object2).getTime();
        }
        charSequence2 = "No time zone indicator";
        try {
            runtimeException = new IllegalArgumentException((String)charSequence2);
            throw runtimeException;
        }
        catch (IllegalArgumentException illegalArgumentException) {
        }
        catch (NumberFormatException numberFormatException) {
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            // empty catch block
        }
        if (string3 == null) {
            string3 = null;
        } else {
            charSequence2 = new StringBuilder();
            n10 = 34;
            ((StringBuilder)charSequence2).append((char)n10);
            ((StringBuilder)charSequence2).append(string3);
            ((StringBuilder)charSequence2).append((char)n10);
            string3 = ((StringBuilder)charSequence2).toString();
        }
        charSequence2 = var20_24.getMessage();
        if (charSequence2 == null || (n10 = (int)(((String)charSequence2).isEmpty() ? 1 : 0)) != 0) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("(");
            object = var20_24.getClass().getName();
            ((StringBuilder)charSequence2).append((String)object);
            object = ")";
            ((StringBuilder)charSequence2).append((String)object);
            charSequence2 = ((StringBuilder)charSequence2).toString();
        }
        charSequence = new StringBuilder();
        charSequence.append("Failed to parse date [");
        charSequence.append(string3);
        charSequence.append("]: ");
        charSequence.append((String)charSequence2);
        string3 = charSequence.toString();
        int n25 = parsePosition.getIndex();
        object = new ParseException(string3, n25);
        ((Throwable)object).initCause((Throwable)var20_24);
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int parseInt(String string2, int n10, int n11) {
        int n12;
        if (n10 >= 0 && n11 <= (n12 = string2.length()) && n10 <= n11) {
            int n13;
            n12 = 0;
            NumberFormatException numberFormatException = null;
            String string3 = "Invalid number: ";
            int n14 = 10;
            if (n10 < n11) {
                n12 = n10 + 1;
                n13 = Character.digit(string2.charAt(n10), n14);
                if (n13 < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    string2 = string2.substring(n10, n11);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                    numberFormatException = new NumberFormatException(string2);
                    throw numberFormatException;
                }
                n13 = -n13;
            } else {
                n13 = 0;
                n12 = n10;
            }
            while (true) {
                if (n12 >= n11) {
                    return -n13;
                }
                int n15 = n12 + 1;
                if ((n12 = Character.digit(string2.charAt(n12), n14)) < 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(string3);
                    string2 = string2.substring(n10, n11);
                    stringBuilder.append(string2);
                    string2 = stringBuilder.toString();
                    numberFormatException = new NumberFormatException(string2);
                    throw numberFormatException;
                }
                n13 = n13 * 10 - n12;
                n12 = n15;
            }
        }
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }
}

