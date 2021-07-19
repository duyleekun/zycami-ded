/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import com.google.android.gms.internal.mlkit_vision_face.zzis;

public final class zzip {
    public static String zza(zzez serializable) {
        char c10;
        zzis zzis2 = new zzis((zzez)serializable);
        int n10 = zzis2.zza();
        serializable = new StringBuilder(n10);
        for (n10 = 0; n10 < (c10 = zzis2.zza()); ++n10) {
            String string2;
            char c11;
            c10 = (char)zzis2.zza(n10);
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
                                    ((StringBuilder)serializable).append(c10);
                                    break;
                                }
                                ((StringBuilder)serializable).append(c11);
                                c11 = (char)((c10 >>> 6 & 3) + 48);
                                ((StringBuilder)serializable).append(c11);
                                c11 = (char)((c10 >>> 3 & 7) + 48);
                                ((StringBuilder)serializable).append(c11);
                                c10 = (char)((c10 & 7) + 48);
                                ((StringBuilder)serializable).append(c10);
                                break;
                            }
                            case '\r': {
                                string2 = "\\r";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                            case '\f': {
                                string2 = "\\f";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                            case '\u000b': {
                                string2 = "\\v";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                            case '\n': {
                                string2 = "\\n";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                            case '\t': {
                                string2 = "\\t";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                            case '\b': {
                                string2 = "\\b";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                            case '\u0007': {
                                string2 = "\\a";
                                ((StringBuilder)serializable).append(string2);
                                break;
                            }
                        }
                        continue;
                    }
                    string2 = "\\\\";
                    ((StringBuilder)serializable).append(string2);
                    continue;
                }
                string2 = "\\'";
                ((StringBuilder)serializable).append(string2);
                continue;
            }
            string2 = "\\\"";
            ((StringBuilder)serializable).append(string2);
        }
        return ((StringBuilder)serializable).toString();
    }
}

