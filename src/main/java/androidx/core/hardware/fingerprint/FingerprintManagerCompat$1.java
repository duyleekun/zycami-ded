/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationResult
 */
package androidx.core.hardware.fingerprint;

import android.hardware.fingerprint.FingerprintManager;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationResult;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;

public class FingerprintManagerCompat$1
extends FingerprintManager.AuthenticationCallback {
    public final /* synthetic */ FingerprintManagerCompat$AuthenticationCallback val$callback;

    public FingerprintManagerCompat$1(FingerprintManagerCompat$AuthenticationCallback authenticationCallback) {
        this.val$callback = authenticationCallback;
    }

    public void onAuthenticationError(int n10, CharSequence charSequence) {
        this.val$callback.onAuthenticationError(n10, charSequence);
    }

    public void onAuthenticationFailed() {
        this.val$callback.onAuthenticationFailed();
    }

    public void onAuthenticationHelp(int n10, CharSequence charSequence) {
        this.val$callback.onAuthenticationHelp(n10, charSequence);
    }

    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult object) {
        FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback = this.val$callback;
        object = FingerprintManagerCompat.unwrapCryptoObject(object.getCryptoObject());
        FingerprintManagerCompat$AuthenticationResult fingerprintManagerCompat$AuthenticationResult = new FingerprintManagerCompat$AuthenticationResult((FingerprintManagerCompat$CryptoObject)object);
        fingerprintManagerCompat$AuthenticationCallback.onAuthenticationSucceeded(fingerprintManagerCompat$AuthenticationResult);
    }
}

