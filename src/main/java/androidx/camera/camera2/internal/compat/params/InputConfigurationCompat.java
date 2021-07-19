/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.camera.camera2.internal.compat.params;

import android.os.Build;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat$InputConfigurationCompatApi23Impl;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat$InputConfigurationCompatBaseImpl;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat$InputConfigurationCompatImpl;

public final class InputConfigurationCompat {
    private final InputConfigurationCompat$InputConfigurationCompatImpl mImpl;

    public InputConfigurationCompat(int n10, int n11, int n12) {
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 23;
        if (n13 >= n14) {
            InputConfigurationCompat$InputConfigurationCompatApi23Impl inputConfigurationCompat$InputConfigurationCompatApi23Impl = new InputConfigurationCompat$InputConfigurationCompatApi23Impl(n10, n11, n12);
            this.mImpl = inputConfigurationCompat$InputConfigurationCompatApi23Impl;
        } else {
            InputConfigurationCompat$InputConfigurationCompatBaseImpl inputConfigurationCompat$InputConfigurationCompatBaseImpl = new InputConfigurationCompat$InputConfigurationCompatBaseImpl(n10, n11, n12);
            this.mImpl = inputConfigurationCompat$InputConfigurationCompatBaseImpl;
        }
    }

    private InputConfigurationCompat(InputConfigurationCompat$InputConfigurationCompatImpl inputConfigurationCompat$InputConfigurationCompatImpl) {
        this.mImpl = inputConfigurationCompat$InputConfigurationCompatImpl;
    }

    public static InputConfigurationCompat wrap(Object object) {
        InputConfigurationCompat inputConfigurationCompat = null;
        if (object == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 < n11) {
            return null;
        }
        InputConfigurationCompat$InputConfigurationCompatApi23Impl inputConfigurationCompat$InputConfigurationCompatApi23Impl = new InputConfigurationCompat$InputConfigurationCompatApi23Impl(object);
        inputConfigurationCompat = new InputConfigurationCompat(inputConfigurationCompat$InputConfigurationCompatApi23Impl);
        return inputConfigurationCompat;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof InputConfigurationCompat;
        if (!bl2) {
            return false;
        }
        InputConfigurationCompat$InputConfigurationCompatImpl inputConfigurationCompat$InputConfigurationCompatImpl = this.mImpl;
        object = ((InputConfigurationCompat)object).mImpl;
        return inputConfigurationCompat$InputConfigurationCompatImpl.equals(object);
    }

    public int getFormat() {
        return this.mImpl.getFormat();
    }

    public int getHeight() {
        return this.mImpl.getHeight();
    }

    public int getWidth() {
        return this.mImpl.getWidth();
    }

    public int hashCode() {
        return this.mImpl.hashCode();
    }

    public String toString() {
        return this.mImpl.toString();
    }

    public Object unwrap() {
        return this.mImpl.getInputConfiguration();
    }
}

