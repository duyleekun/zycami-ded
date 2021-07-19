/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source.dash.manifest;

import java.util.Locale;

public final class UrlTemplate {
    private static final String BANDWIDTH = "Bandwidth";
    private static final int BANDWIDTH_ID = 3;
    private static final String DEFAULT_FORMAT_TAG = "%01d";
    private static final String ESCAPED_DOLLAR = "$$";
    private static final String NUMBER = "Number";
    private static final int NUMBER_ID = 2;
    private static final String REPRESENTATION = "RepresentationID";
    private static final int REPRESENTATION_ID = 1;
    private static final String TIME = "Time";
    private static final int TIME_ID = 4;
    private final int identifierCount;
    private final String[] identifierFormatTags;
    private final int[] identifiers;
    private final String[] urlPieces;

    private UrlTemplate(String[] stringArray, int[] nArray, String[] stringArray2, int n10) {
        this.urlPieces = stringArray;
        this.identifiers = nArray;
        this.identifierFormatTags = stringArray2;
        this.identifierCount = n10;
    }

    public static UrlTemplate compile(String string2) {
        String[] stringArray = new String[5];
        int n10 = 4;
        int[] nArray = new int[n10];
        String[] stringArray2 = new String[n10];
        int n11 = UrlTemplate.parseTemplate(string2, stringArray, nArray, stringArray2);
        UrlTemplate urlTemplate = new UrlTemplate(stringArray, nArray, stringArray2, n11);
        return urlTemplate;
    }

    private static int parseTemplate(String string2, String[] object, int[] object2, String[] stringArray) {
        int n10;
        String string3;
        object[0] = string3 = "";
        int n11 = 0;
        String string4 = null;
        int n12 = 0;
        while (n11 < (n10 = string2.length())) {
            int n13;
            String string5 = "$";
            int n14 = string2.indexOf(string5, n11);
            if (n14 == (n13 = -1)) {
                string5 = String.valueOf(object[n12]);
                string4 = String.valueOf(string2.substring(n11));
                n14 = string4.length();
                string4 = n14 != 0 ? string5.concat(string4) : new String(string5);
                object[n12] = string4;
                n11 = string2.length();
                continue;
            }
            if (n14 != n11) {
                string5 = String.valueOf(object[n12]);
                string4 = String.valueOf(string2.substring(n11, n14));
                n13 = string4.length();
                string4 = n13 != 0 ? string5.concat(string4) : new String(string5);
                object[n12] = string4;
                n11 = n14;
                continue;
            }
            String string6 = ESCAPED_DOLLAR;
            n14 = (int)(string2.startsWith(string6, n11) ? 1 : 0);
            if (n14 != 0) {
                string6 = String.valueOf(object[n12]);
                object[n12] = string5 = string6.concat(string5);
                n11 += 2;
                continue;
            }
            n10 = string2.indexOf(string5, ++n11);
            string4 = string2.substring(n11, n10);
            string6 = REPRESENTATION;
            n14 = (int)(string4.equals(string6) ? 1 : 0);
            int n15 = 1;
            if (n14 != 0) {
                object2[n12] = n15;
            } else {
                String string7;
                string6 = "%0";
                n14 = string4.indexOf(string6);
                if (n14 != n13) {
                    String string8;
                    String string9;
                    string7 = string4.substring(n14);
                    boolean bl2 = string7.endsWith(string9 = "d");
                    if (!bl2 && !(bl2 = string7.endsWith(string8 = "x"))) {
                        string7 = String.valueOf(string7).concat(string9);
                    }
                    string4 = string4.substring(0, n14);
                } else {
                    string7 = DEFAULT_FORMAT_TAG;
                }
                string4.hashCode();
                n14 = string4.hashCode();
                int n16 = 2;
                switch (n14) {
                    default: {
                        break;
                    }
                    case 38199441: {
                        string6 = BANDWIDTH;
                        n11 = (int)(string4.equals(string6) ? 1 : 0);
                        if (n11 == 0) break;
                        n13 = n16;
                        break;
                    }
                    case 2606829: {
                        string6 = TIME;
                        n11 = (int)(string4.equals(string6) ? 1 : 0);
                        if (n11 == 0) break;
                        n13 = n15;
                        break;
                    }
                    case -1950496919: {
                        string6 = NUMBER;
                        n11 = (int)(string4.equals(string6) ? 1 : 0);
                        if (n11 == 0) break;
                        n13 = 0;
                    }
                }
                switch (n13) {
                    default: {
                        object2 = "Invalid template: ";
                        string2 = String.valueOf(string2);
                        int n17 = string2.length();
                        string2 = n17 != 0 ? ((String)object2).concat(string2) : new String((String)object2);
                        object = new IllegalArgumentException(string2);
                        throw object;
                    }
                    case 2: {
                        object2[n12] = n11 = 3;
                        break;
                    }
                    case 1: {
                        object2[n12] = n11 = 4;
                        break;
                    }
                    case 0: {
                        object2[n12] = n16;
                    }
                }
                stringArray[n12] = string7;
            }
            object[++n12] = string3;
            n11 = ++n10;
        }
        return n12;
    }

    public String buildUri(String string2, long l10, int n10, long l11) {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i10 = 0; i10 < (object = this.identifierCount); ++i10) {
            Number number;
            Object[] objectArray;
            String string3;
            Object object2 = this.urlPieces[i10];
            stringBuilder.append((String)object2);
            object2 = this.identifiers;
            Object object3 = object2[i10];
            int n11 = 1;
            if (object3 == n11) {
                stringBuilder.append(string2);
                continue;
            }
            object3 = object2[i10];
            int n12 = 2;
            if (object3 == n12) {
                object2 = Locale.US;
                string3 = this.identifierFormatTags[i10];
                objectArray = new Object[n11];
                number = l10;
                objectArray[0] = number;
                object2 = String.format((Locale)object2, string3, objectArray);
                stringBuilder.append((String)object2);
                continue;
            }
            object3 = object2[i10];
            n12 = 3;
            if (object3 == n12) {
                object2 = Locale.US;
                string3 = this.identifierFormatTags[i10];
                objectArray = new Object[n11];
                number = n10;
                objectArray[0] = number;
                object2 = String.format((Locale)object2, string3, objectArray);
                stringBuilder.append((String)object2);
                continue;
            }
            object = object2[i10];
            object3 = 4;
            if (object != object3) continue;
            object2 = Locale.US;
            string3 = this.identifierFormatTags[i10];
            objectArray = new Object[n11];
            number = l11;
            objectArray[0] = number;
            object2 = String.format((Locale)object2, string3, objectArray);
            stringBuilder.append((String)object2);
        }
        string2 = this.urlPieces[object];
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}

