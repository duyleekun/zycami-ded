/*
 * Decompiled with CFR 0.151.
 */
package androidx.exifinterface.media;

public class ExifInterface$ExifTag {
    public final String name;
    public final int number;
    public final int primaryFormat;
    public final int secondaryFormat;

    public ExifInterface$ExifTag(String string2, int n10, int n11) {
        this.name = string2;
        this.number = n10;
        this.primaryFormat = n11;
        this.secondaryFormat = -1;
    }

    public ExifInterface$ExifTag(String string2, int n10, int n11, int n12) {
        this.name = string2;
        this.number = n10;
        this.primaryFormat = n11;
        this.secondaryFormat = n12;
    }

    public boolean isFormatCompatible(int n10) {
        int n11 = this.primaryFormat;
        int n12 = 7;
        boolean bl2 = true;
        if (n11 != n12 && n10 != n12 && n11 != n10 && (n12 = this.secondaryFormat) != n10) {
            int n13 = 4;
            if ((n11 == n13 || n12 == n13) && n10 == (n13 = 3)) {
                return bl2;
            }
            n13 = 9;
            if ((n11 == n13 || n12 == n13) && n10 == (n13 = 8)) {
                return bl2;
            }
            n13 = 12;
            if ((n11 == n13 || n12 == n13) && n10 == (n11 = 11)) {
                return bl2;
            }
            return false;
        }
        return bl2;
    }
}

