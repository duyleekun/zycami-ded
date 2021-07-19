/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.provider;

import androidx.core.provider.FontsContractCompat$FontInfo;

public class FontsContractCompat$FontFamilyResult {
    public static final int STATUS_OK = 0;
    public static final int STATUS_UNEXPECTED_DATA_PROVIDED = 2;
    public static final int STATUS_WRONG_CERTIFICATES = 1;
    private final FontsContractCompat$FontInfo[] mFonts;
    private final int mStatusCode;

    public FontsContractCompat$FontFamilyResult(int n10, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray) {
        this.mStatusCode = n10;
        this.mFonts = fontsContractCompat$FontInfoArray;
    }

    public static FontsContractCompat$FontFamilyResult create(int n10, FontsContractCompat$FontInfo[] fontsContractCompat$FontInfoArray) {
        FontsContractCompat$FontFamilyResult fontsContractCompat$FontFamilyResult = new FontsContractCompat$FontFamilyResult(n10, fontsContractCompat$FontInfoArray);
        return fontsContractCompat$FontFamilyResult;
    }

    public FontsContractCompat$FontInfo[] getFonts() {
        return this.mFonts;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}

