/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;

public final class TrackEncryptionBox {
    private static final String TAG = "TrackEncryptionBox";
    public final TrackOutput$CryptoData cryptoData;
    public final byte[] defaultInitializationVector;
    public final boolean isEncrypted;
    public final int perSampleIvSize;
    public final String schemeType;

    public TrackEncryptionBox(boolean bl2, String string2, int n10, byte[] byArray, int n11, int n12, byte[] byArray2) {
        TrackOutput$CryptoData trackOutput$CryptoData;
        boolean bl3 = true;
        boolean bl4 = n10 == 0 ? bl3 : false;
        if (byArray2 != null) {
            bl3 = false;
        }
        Assertions.checkArgument(bl3 ^ bl4);
        this.isEncrypted = bl2;
        this.schemeType = string2;
        this.perSampleIvSize = n10;
        this.defaultInitializationVector = byArray2;
        int n13 = TrackEncryptionBox.schemeToCryptoMode(string2);
        this.cryptoData = trackOutput$CryptoData = new TrackOutput$CryptoData(n13, byArray, n11, n12);
    }

    private static int schemeToCryptoMode(String string2) {
        String string3;
        CharSequence charSequence;
        int n10 = 1;
        if (string2 == null) {
            return n10;
        }
        string2.hashCode();
        int n11 = -1;
        int n12 = string2.hashCode();
        int n13 = 2;
        switch (n12) {
            default: {
                break;
            }
            case 3049895: {
                charSequence = "cens";
                n12 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n12 == 0) break;
                n11 = 3;
                break;
            }
            case 3049879: {
                charSequence = "cenc";
                n12 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n12 == 0) break;
                n11 = n13;
                break;
            }
            case 3046671: {
                charSequence = "cbcs";
                n12 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n12 == 0) break;
                n11 = n10;
                break;
            }
            case 3046605: {
                charSequence = "cbc1";
                n12 = (int)(string2.equals(charSequence) ? 1 : 0);
                if (n12 == 0) break;
                n11 = 0;
                string3 = null;
            }
        }
        switch (n11) {
            default: {
                n11 = String.valueOf(string2).length() + 68;
                charSequence = new StringBuilder(n11);
                ((StringBuilder)charSequence).append("Unsupported protection scheme type '");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("'. Assuming AES-CTR crypto mode.");
                string2 = ((StringBuilder)charSequence).toString();
                string3 = TAG;
                Log.w(string3, string2);
            }
            case 2: 
            case 3: {
                return n10;
            }
            case 0: 
            case 1: 
        }
        return n13;
    }
}

