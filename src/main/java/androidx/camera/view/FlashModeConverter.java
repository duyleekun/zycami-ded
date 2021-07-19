/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.view;

import java.util.Objects;

public final class FlashModeConverter {
    private FlashModeConverter() {
    }

    public static String nameOf(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 == n11) {
                    return "OFF";
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown flash mode ");
                stringBuilder.append(n10);
                String string2 = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            return "ON";
        }
        return "AUTO";
    }

    public static int valueOf(String string2) {
        CharSequence charSequence;
        Object object = "name cannot be null";
        Objects.requireNonNull(string2, (String)object);
        string2.hashCode();
        int n10 = -1;
        int n11 = string2.hashCode();
        int n12 = 2;
        int n13 = 1;
        switch (n11) {
            default: {
                break;
            }
            case 2020783: {
                charSequence = "AUTO";
                n11 = string2.equals(charSequence) ? 1 : 0;
                if (n11 == 0) break;
                n10 = n12;
                break;
            }
            case 78159: {
                charSequence = "OFF";
                n11 = string2.equals(charSequence) ? 1 : 0;
                if (n11 == 0) break;
                n10 = n13;
                break;
            }
            case 2527: {
                charSequence = "ON";
                n11 = string2.equals(charSequence) ? 1 : 0;
                if (n11 == 0) break;
                n10 = 0;
                object = null;
            }
        }
        switch (n10) {
            default: {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Unknown flash mode name ");
                ((StringBuilder)charSequence).append(string2);
                string2 = ((StringBuilder)charSequence).toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            case 2: {
                return 0;
            }
            case 1: {
                return n12;
            }
            case 0: 
        }
        return n13;
    }
}

