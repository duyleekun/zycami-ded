/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.hardware.fingerprint.FingerprintManager
 *  android.hardware.fingerprint.FingerprintManager$AuthenticationCallback
 *  android.hardware.fingerprint.FingerprintManager$CryptoObject
 *  android.os.Build$VERSION
 *  android.os.CancellationSignal
 *  android.os.Handler
 */
package androidx.core.hardware.fingerprint;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Handler;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat$1;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat$AuthenticationCallback;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat$CryptoObject;
import androidx.core.os.CancellationSignal;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

public class FingerprintManagerCompat {
    private final Context mContext;

    private FingerprintManagerCompat(Context context) {
        this.mContext = context;
    }

    public static FingerprintManagerCompat from(Context context) {
        FingerprintManagerCompat fingerprintManagerCompat = new FingerprintManagerCompat(context);
        return fingerprintManagerCompat;
    }

    private static FingerprintManager getFingerprintManagerOrNull(Context context) {
        String string2;
        PackageManager packageManager;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 == n11) {
            return (FingerprintManager)context.getSystemService(FingerprintManager.class);
        }
        if (n10 > n11 && (n10 = (int)((packageManager = context.getPackageManager()).hasSystemFeature(string2 = "android.hardware.fingerprint") ? 1 : 0)) != 0) {
            return (FingerprintManager)context.getSystemService(FingerprintManager.class);
        }
        return null;
    }

    public static FingerprintManagerCompat$CryptoObject unwrapCryptoObject(FingerprintManager.CryptoObject object) {
        FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject = null;
        if (object == null) {
            return null;
        }
        Object object2 = object.getCipher();
        if (object2 != null) {
            object = object.getCipher();
            fingerprintManagerCompat$CryptoObject = new FingerprintManagerCompat$CryptoObject((Cipher)object);
            return fingerprintManagerCompat$CryptoObject;
        }
        object2 = object.getSignature();
        if (object2 != null) {
            object = object.getSignature();
            fingerprintManagerCompat$CryptoObject = new FingerprintManagerCompat$CryptoObject((Signature)object);
            return fingerprintManagerCompat$CryptoObject;
        }
        object2 = object.getMac();
        if (object2 != null) {
            object = object.getMac();
            fingerprintManagerCompat$CryptoObject = new FingerprintManagerCompat$CryptoObject((Mac)object);
        }
        return fingerprintManagerCompat$CryptoObject;
    }

    private static FingerprintManager.AuthenticationCallback wrapCallback(FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback) {
        FingerprintManagerCompat$1 fingerprintManagerCompat$1 = new FingerprintManagerCompat$1(fingerprintManagerCompat$AuthenticationCallback);
        return fingerprintManagerCompat$1;
    }

    private static FingerprintManager.CryptoObject wrapCryptoObject(FingerprintManagerCompat$CryptoObject object) {
        FingerprintManager.CryptoObject cryptoObject = null;
        if (object == null) {
            return null;
        }
        Object object2 = ((FingerprintManagerCompat$CryptoObject)object).getCipher();
        if (object2 != null) {
            object = ((FingerprintManagerCompat$CryptoObject)object).getCipher();
            cryptoObject = new FingerprintManager.CryptoObject((Cipher)object);
            return cryptoObject;
        }
        object2 = ((FingerprintManagerCompat$CryptoObject)object).getSignature();
        if (object2 != null) {
            object = ((FingerprintManagerCompat$CryptoObject)object).getSignature();
            cryptoObject = new FingerprintManager.CryptoObject((Signature)object);
            return cryptoObject;
        }
        object2 = ((FingerprintManagerCompat$CryptoObject)object).getMac();
        if (object2 != null) {
            object = ((FingerprintManagerCompat$CryptoObject)object).getMac();
            cryptoObject = new FingerprintManager.CryptoObject((Mac)object);
        }
        return cryptoObject;
    }

    public void authenticate(FingerprintManagerCompat$CryptoObject fingerprintManagerCompat$CryptoObject, int n10, CancellationSignal cancellationSignal, FingerprintManagerCompat$AuthenticationCallback fingerprintManagerCompat$AuthenticationCallback, Handler handler) {
        Context context;
        FingerprintManager fingerprintManager;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12 && (fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(context = this.mContext)) != null) {
            cancellationSignal = cancellationSignal != null ? (android.os.CancellationSignal)cancellationSignal.getCancellationSignalObject() : null;
            FingerprintManager.CryptoObject cryptoObject = FingerprintManagerCompat.wrapCryptoObject(fingerprintManagerCompat$CryptoObject);
            FingerprintManager.AuthenticationCallback authenticationCallback = FingerprintManagerCompat.wrapCallback(fingerprintManagerCompat$AuthenticationCallback);
            fingerprintManager.authenticate(cryptoObject, (android.os.CancellationSignal)cancellationSignal, n10, authenticationCallback, handler);
        }
    }

    public boolean hasEnrolledFingerprints() {
        FingerprintManager fingerprintManager;
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        int n11 = 23;
        if (n10 >= n11 && (fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext)) != null && (n10 = (int)(fingerprintManager.hasEnrolledFingerprints() ? 1 : 0)) != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isHardwareDetected() {
        FingerprintManager fingerprintManager;
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        int n11 = 23;
        if (n10 >= n11 && (fingerprintManager = FingerprintManagerCompat.getFingerprintManagerOrNull(this.mContext)) != null && (n10 = (int)(fingerprintManager.isHardwareDetected() ? 1 : 0)) != 0) {
            bl2 = true;
        }
        return bl2;
    }
}

