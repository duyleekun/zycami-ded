/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.hardware.fingerprint;

import androidx.core.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;

public final class FingerprintManagerCompat$AuthenticationResult {
    private final FingerprintManagerCompat$CryptoObject mCryptoObject;

    public FingerprintManagerCompat$AuthenticationResult(FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject) {
        this.mCryptoObject = fingerprintManagerCompat$CryptoObject;
    }

    public FingerprintManagerCompat$CryptoObject getCryptoObject() {
        return this.mCryptoObject;
    }
}

