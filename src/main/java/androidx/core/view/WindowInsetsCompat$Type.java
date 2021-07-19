/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view;

public final class WindowInsetsCompat$Type {
    public static final int CAPTION_BAR = 4;
    public static final int DISPLAY_CUTOUT = 128;
    public static final int FIRST = 1;
    public static final int IME = 8;
    public static final int LAST = 256;
    public static final int MANDATORY_SYSTEM_GESTURES = 32;
    public static final int NAVIGATION_BARS = 2;
    public static final int SIZE = 9;
    public static final int STATUS_BARS = 1;
    public static final int SYSTEM_GESTURES = 16;
    public static final int TAPPABLE_ELEMENT = 64;
    public static final int WINDOW_DECOR = 256;

    private WindowInsetsCompat$Type() {
    }

    public static int all() {
        return -1;
    }

    public static int captionBar() {
        return 4;
    }

    public static int displayCutout() {
        return 128;
    }

    public static int ime() {
        return 8;
    }

    public static int indexOf(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n11 = 4;
                if (n10 != n11) {
                    n12 = 8;
                    if (n10 != n12) {
                        int n13 = 16;
                        if (n10 != n13) {
                            n11 = 32;
                            if (n10 != n11) {
                                n11 = 64;
                                if (n10 != n11) {
                                    n11 = 128;
                                    if (n10 != n11) {
                                        n11 = 256;
                                        if (n10 == n11) {
                                            return n12;
                                        }
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("type needs to be >= FIRST and <= LAST, type=");
                                        stringBuilder.append(n10);
                                        String string2 = stringBuilder.toString();
                                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                                        throw illegalArgumentException;
                                    }
                                    return 7;
                                }
                                return 6;
                            }
                            return 5;
                        }
                        return n11;
                    }
                    return 3;
                }
                return n12;
            }
            return n11;
        }
        return 0;
    }

    public static int mandatorySystemGestures() {
        return 32;
    }

    public static int navigationBars() {
        return 2;
    }

    public static int statusBars() {
        return 1;
    }

    public static int systemBars() {
        return 7;
    }

    public static int systemGestures() {
        return 16;
    }

    public static int tappableElement() {
        return 64;
    }
}

