/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Typeface
 */
package androidx.core.provider;

import android.graphics.Typeface;

public class FontsContractCompat$FontRequestCallback {
    public static final int FAIL_REASON_FONT_LOAD_ERROR = 253;
    public static final int FAIL_REASON_FONT_NOT_FOUND = 1;
    public static final int FAIL_REASON_FONT_UNAVAILABLE = 2;
    public static final int FAIL_REASON_MALFORMED_QUERY = 3;
    public static final int FAIL_REASON_PROVIDER_NOT_FOUND = 255;
    public static final int FAIL_REASON_SECURITY_VIOLATION = 252;
    public static final int FAIL_REASON_WRONG_CERTIFICATES = 254;
    public static final int RESULT_OK;
    public static final int RESULT_SUCCESS;

    public void onTypefaceRequestFailed(int n10) {
    }

    public void onTypefaceRetrieved(Typeface typeface) {
    }
}

