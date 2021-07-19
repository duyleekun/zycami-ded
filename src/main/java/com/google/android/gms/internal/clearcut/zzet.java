/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import com.google.android.gms.internal.clearcut.zzeu;

public final class zzet {
    /*
     * Enabled aggressive block sorting
     */
    public static String zzc(zzbb serializable) {
        zzeu zzeu2 = new zzeu((zzbb)serializable);
        int n10 = zzeu2.size();
        serializable = new StringBuilder(n10);
        n10 = 0;
        while (true) {
            block15: {
                String string2;
                block16: {
                    block12: {
                        block13: {
                            block14: {
                                int n11;
                                int n12;
                                if (n10 >= (n12 = zzeu2.size())) {
                                    return ((StringBuilder)serializable).toString();
                                }
                                n12 = zzeu2.zzj(n10);
                                if (n12 == (n11 = 34)) break block12;
                                n11 = 39;
                                if (n12 == n11) break block13;
                                n11 = 92;
                                if (n12 == n11) break block14;
                                switch (n12) {
                                    default: {
                                        int n13 = 32;
                                        if (n12 < n13 || n12 > (n13 = 126)) {
                                            ((StringBuilder)serializable).append((char)n11);
                                            n11 = (char)((n12 >>> 6 & 3) + 48);
                                            ((StringBuilder)serializable).append((char)n11);
                                            n11 = (char)((n12 >>> 3 & 7) + 48);
                                            ((StringBuilder)serializable).append((char)n11);
                                            n12 = (n12 & 7) + 48;
                                        }
                                        n12 = (char)n12;
                                        ((StringBuilder)serializable).append((char)n12);
                                        break block15;
                                    }
                                    case 13: {
                                        string2 = "\\r";
                                        break;
                                    }
                                    case 12: {
                                        string2 = "\\f";
                                        break;
                                    }
                                    case 11: {
                                        string2 = "\\v";
                                        break;
                                    }
                                    case 10: {
                                        string2 = "\\n";
                                        break;
                                    }
                                    case 9: {
                                        string2 = "\\t";
                                        break;
                                    }
                                    case 8: {
                                        string2 = "\\b";
                                        break;
                                    }
                                    case 7: {
                                        string2 = "\\a";
                                        break;
                                    }
                                }
                                break block16;
                            }
                            string2 = "\\\\";
                            break block16;
                        }
                        string2 = "\\'";
                        break block16;
                    }
                    string2 = "\\\"";
                }
                ((StringBuilder)serializable).append(string2);
            }
            ++n10;
        }
    }
}

