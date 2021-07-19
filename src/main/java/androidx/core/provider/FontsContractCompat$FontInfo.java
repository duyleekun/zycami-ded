/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package androidx.core.provider;

import android.net.Uri;
import androidx.core.util.Preconditions;

public class FontsContractCompat$FontInfo {
    private final boolean mItalic;
    private final int mResultCode;
    private final int mTtcIndex;
    private final Uri mUri;
    private final int mWeight;

    public FontsContractCompat$FontInfo(Uri uri, int n10, int n11, boolean bl2, int n12) {
        this.mUri = uri = (Uri)Preconditions.checkNotNull(uri);
        this.mTtcIndex = n10;
        this.mWeight = n11;
        this.mItalic = bl2;
        this.mResultCode = n12;
    }

    public static FontsContractCompat$FontInfo create(Uri uri, int n10, int n11, boolean bl2, int n12) {
        FontsContractCompat$FontInfo fontsContractCompat$FontInfo = new FontsContractCompat$FontInfo(uri, n10, n11, bl2, n12);
        return fontsContractCompat$FontInfo;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public int getTtcIndex() {
        return this.mTtcIndex;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public int getWeight() {
        return this.mWeight;
    }

    public boolean isItalic() {
        return this.mItalic;
    }
}

