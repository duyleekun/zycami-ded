/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.text;

public class BidiFormatter$DirectionalityEstimator {
    private static final byte[] DIR_TYPE_CACHE;
    private static final int DIR_TYPE_CACHE_SIZE = 1792;
    private int charIndex;
    private final boolean isHtml;
    private char lastChar;
    private final int length;
    private final CharSequence text;

    static {
        int n10 = 1792;
        DIR_TYPE_CACHE = new byte[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            byte by2;
            byte[] byArray = DIR_TYPE_CACHE;
            byArray[i10] = by2 = Character.getDirectionality(i10);
        }
    }

    public BidiFormatter$DirectionalityEstimator(CharSequence charSequence, boolean bl2) {
        int n10;
        this.text = charSequence;
        this.isHtml = bl2;
        this.length = n10 = charSequence.length();
    }

    private static byte getCachedDirectionality(char c10) {
        char c11 = '\u0700';
        if (c10 < c11) {
            byte[] byArray = DIR_TYPE_CACHE;
            c10 = byArray[c10];
        } else {
            c10 = (char)Character.getDirectionality(c10);
        }
        return (byte)c10;
    }

    private byte skipEntityBackward() {
        int n10;
        int n11;
        int n12 = this.charIndex;
        do {
            n11 = this.charIndex;
            n10 = 59;
            if (n11 <= 0) break;
            CharSequence charSequence = this.text;
            this.charIndex = n11 += -1;
            n11 = charSequence.charAt(n11);
            this.lastChar = (char)n11;
            int n13 = 38;
            if (n11 != n13) continue;
            return 12;
        } while (n11 != n10);
        this.charIndex = n12;
        this.lastChar = (char)n10;
        return 13;
    }

    private byte skipEntityForward() {
        int n10;
        int n11;
        while ((n11 = this.charIndex) < (n10 = this.length)) {
            int n12;
            CharSequence charSequence = this.text;
            this.charIndex = n12 = n11 + 1;
            n11 = charSequence.charAt(n11);
            this.lastChar = (char)n11;
            n10 = 59;
            if (n11 != n10) continue;
        }
        return 12;
    }

    /*
     * Unable to fully structure code
     */
    private byte skipTagBackward() {
        var1_1 = this.charIndex;
        block0: while (true) {
            var2_2 = this.charIndex;
            var3_3 = 62;
            if (var2_2 <= 0) break;
            var4_4 = this.text;
            this.charIndex = var2_2 += -1;
            var2_2 = var4_4.charAt(var2_2);
            this.lastChar = (char)var2_2;
            var5_5 = 60;
            if (var2_2 == var5_5) {
                return 12;
            }
            if (var2_2 == var3_3) break;
            var3_3 = 34;
            if (var2_2 != var3_3 && var2_2 != (var3_3 = 39)) continue;
            while (true) {
                if ((var3_3 = this.charIndex) <= 0) continue block0;
                var4_4 = this.text;
                this.charIndex = var3_3 += -1;
                var3_3 = var4_4.charAt(var3_3);
                this.lastChar = (char)var3_3;
                if (var3_3 != var2_2) ** break;
                continue block0;
            }
            break;
        }
        this.charIndex = var1_1;
        this.lastChar = (char)var3_3;
        return 13;
    }

    private byte skipTagForward() {
        int n10;
        int n11;
        int n12 = this.charIndex;
        block0: while ((n11 = this.charIndex) < (n10 = this.length)) {
            int n13;
            CharSequence charSequence = this.text;
            this.charIndex = n13 = n11 + 1;
            n11 = charSequence.charAt(n11);
            this.lastChar = (char)n11;
            n10 = 62;
            if (n11 == n10) {
                return 12;
            }
            n10 = 34;
            if (n11 != n10 && n11 != (n10 = 39)) continue;
            while ((n10 = this.charIndex) < (n13 = this.length)) {
                int n14;
                CharSequence charSequence2 = this.text;
                this.charIndex = n14 = n10 + 1;
                n10 = charSequence2.charAt(n10);
                this.lastChar = (char)n10;
                if (n10 == n11) continue block0;
            }
        }
        this.charIndex = n12;
        this.lastChar = (char)60;
        return 13;
    }

    public byte dirTypeBackward() {
        byte by2;
        CharSequence charSequence = this.text;
        int n10 = this.charIndex + -1;
        this.lastChar = by2 = charSequence.charAt(n10);
        if ((by2 = (byte)(Character.isLowSurrogate((char)by2) ? 1 : 0)) != 0) {
            charSequence = this.text;
            n10 = this.charIndex;
            by2 = Character.codePointBefore(charSequence, n10);
            n10 = this.charIndex;
            int n11 = Character.charCount(by2);
            this.charIndex = n10 -= n11;
            return Character.getDirectionality(by2);
        }
        by2 = this.charIndex + -1;
        this.charIndex = by2;
        by2 = BidiFormatter$DirectionalityEstimator.getCachedDirectionality(this.lastChar);
        n10 = (int)(this.isHtml ? 1 : 0);
        if (n10 != 0) {
            n10 = this.lastChar;
            int n12 = 62;
            if (n10 == n12) {
                by2 = this.skipTagBackward();
            } else {
                n12 = 59;
                if (n10 == n12) {
                    by2 = this.skipEntityBackward();
                }
            }
        }
        return by2;
    }

    public byte dirTypeForward() {
        byte by2;
        CharSequence charSequence = this.text;
        int n10 = this.charIndex;
        this.lastChar = by2 = charSequence.charAt(n10);
        if ((by2 = (byte)(Character.isHighSurrogate((char)by2) ? 1 : 0)) != 0) {
            charSequence = this.text;
            n10 = this.charIndex;
            by2 = Character.codePointAt(charSequence, n10);
            n10 = this.charIndex;
            int n11 = Character.charCount(by2);
            this.charIndex = n10 += n11;
            return Character.getDirectionality(by2);
        }
        by2 = this.charIndex + 1;
        this.charIndex = by2;
        by2 = BidiFormatter$DirectionalityEstimator.getCachedDirectionality(this.lastChar);
        n10 = (int)(this.isHtml ? 1 : 0);
        if (n10 != 0) {
            n10 = this.lastChar;
            int n12 = 60;
            if (n10 == n12) {
                by2 = this.skipTagForward();
            } else {
                n12 = 38;
                if (n10 == n12) {
                    by2 = this.skipEntityForward();
                }
            }
        }
        return by2;
    }

    public int getEntryDir() {
        int n10;
        int n11;
        this.charIndex = 0;
        int n12 = -1;
        int n13 = 1;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        while ((n11 = this.charIndex) < (n10 = this.length) && n14 == 0) {
            block18: {
                block16: {
                    block17: {
                        n11 = this.dirTypeForward();
                        if (n11 == 0) break block16;
                        if (n11 == n13 || n11 == (n10 = 2)) break block17;
                        n10 = 9;
                        if (n11 == n10) continue;
                        switch (n11) {
                            default: {
                                break block18;
                            }
                            case 18: {
                                n16 += -1;
                                n15 = 0;
                                break;
                            }
                            case 16: 
                            case 17: {
                                ++n16;
                                n15 = n13;
                                break;
                            }
                            case 14: 
                            case 15: {
                                ++n16;
                                n15 = n12;
                                break;
                            }
                        }
                        continue;
                    }
                    if (n16 == 0) {
                        return n13;
                    }
                    break block18;
                }
                if (n16 == 0) {
                    return n12;
                }
            }
            n14 = n16;
        }
        if (n14 == 0) {
            return 0;
        }
        if (n15 != 0) {
            return n15;
        }
        block11: while ((n15 = this.charIndex) > 0) {
            n15 = this.dirTypeBackward();
            switch (n15) {
                default: {
                    continue block11;
                }
                case 18: {
                    ++n16;
                    continue block11;
                }
                case 16: 
                case 17: {
                    if (n14 != n16) break;
                    return n13;
                }
                case 14: 
                case 15: {
                    if (n14 != n16) break;
                    return n12;
                }
            }
            n16 += -1;
        }
        return 0;
    }

    public int getExitDir() {
        int n10;
        this.charIndex = n10 = this.length;
        n10 = 0;
        int n11 = 0;
        block5: while (true) {
            int n12;
            int n13 = n11;
            block6: while ((n12 = this.charIndex) > 0) {
                n12 = this.dirTypeBackward();
                int n14 = -1;
                if (n12 != 0) {
                    int n15;
                    int n16 = 1;
                    if (n12 != n16 && n12 != (n15 = 2)) {
                        n15 = 9;
                        if (n12 == n15) continue;
                        switch (n12) {
                            default: {
                                if (n13 != 0) continue block6;
                                continue block5;
                            }
                            case 18: {
                                ++n11;
                                continue block6;
                            }
                            case 16: 
                            case 17: {
                                if (n13 != n11) break;
                                return n16;
                            }
                            case 14: 
                            case 15: {
                                if (n13 != n11) break;
                                return n14;
                            }
                        }
                        n11 += -1;
                        continue;
                    }
                    if (n11 == 0) {
                        return n16;
                    }
                    if (n13 != 0) continue;
                    continue block5;
                }
                if (n11 == 0) {
                    return n14;
                }
                if (n13 != 0) continue;
                continue block5;
            }
            break;
        }
        return 0;
    }
}

