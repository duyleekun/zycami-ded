/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;

public final class zzju {
    public static String zza(zzgs zzgs2) {
        char c10;
        int n10 = zzgs2.zzc();
        StringBuilder stringBuilder = new StringBuilder(n10);
        for (n10 = 0; n10 < (c10 = zzgs2.zzc()); ++n10) {
            String string2;
            char c11;
            c10 = (char)zzgs2.zza(n10);
            if (c10 != (c11 = '\"')) {
                c11 = '\'';
                if (c10 != c11) {
                    c11 = '\\';
                    if (c10 != c11) {
                        switch (c10) {
                            default: {
                                char c12 = ' ';
                                if (c10 >= c12 && c10 <= (c12 = '~')) {
                                    c10 = c10;
                                    stringBuilder.append(c10);
                                    break;
                                }
                                stringBuilder.append(c11);
                                c11 = (char)((c10 >>> 6 & 3) + 48);
                                stringBuilder.append(c11);
                                c11 = (char)((c10 >>> 3 & 7) + 48);
                                stringBuilder.append(c11);
                                c10 = (char)((c10 & 7) + 48);
                                stringBuilder.append(c10);
                                break;
                            }
                            case '\r': {
                                string2 = "\\r";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\f': {
                                string2 = "\\f";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\u000b': {
                                string2 = "\\v";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\n': {
                                string2 = "\\n";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\t': {
                                string2 = "\\t";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\b': {
                                string2 = "\\b";
                                stringBuilder.append(string2);
                                break;
                            }
                            case '\u0007': {
                                string2 = "\\a";
                                stringBuilder.append(string2);
                                break;
                            }
                        }
                        continue;
                    }
                    string2 = "\\\\";
                    stringBuilder.append(string2);
                    continue;
                }
                string2 = "\\'";
                stringBuilder.append(string2);
                continue;
            }
            string2 = "\\\"";
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }
}

