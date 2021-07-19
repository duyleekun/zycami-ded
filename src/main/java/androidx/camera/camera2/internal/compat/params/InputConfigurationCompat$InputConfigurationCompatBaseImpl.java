/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat.params;

import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat$InputConfigurationCompatImpl;

public final class InputConfigurationCompat$InputConfigurationCompatBaseImpl
implements InputConfigurationCompat$InputConfigurationCompatImpl {
    private final int mFormat;
    private final int mHeight;
    private final int mWidth;

    public InputConfigurationCompat$InputConfigurationCompatBaseImpl(int n10, int n11, int n12) {
        this.mWidth = n10;
        this.mHeight = n11;
        this.mFormat = n12;
    }

    public boolean equals(Object object) {
        int n10;
        int n11;
        int n12 = object instanceof InputConfigurationCompat$InputConfigurationCompatBaseImpl;
        boolean bl2 = false;
        if (n12 == 0) {
            return false;
        }
        n12 = ((InputConfigurationCompat$InputConfigurationCompatBaseImpl)(object = (InputConfigurationCompat$InputConfigurationCompatBaseImpl)object)).getWidth();
        if (n12 == (n11 = this.mWidth) && (n12 = ((InputConfigurationCompat$InputConfigurationCompatBaseImpl)object).getHeight()) == (n11 = this.mHeight) && (n10 = ((InputConfigurationCompat$InputConfigurationCompatBaseImpl)object).getFormat()) == (n12 = this.mFormat)) {
            bl2 = true;
        }
        return bl2;
    }

    public int getFormat() {
        return this.mFormat;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public Object getInputConfiguration() {
        return null;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int hashCode() {
        int n10 = this.mWidth ^ 0x1F;
        int n11 = (n10 << 5) - n10;
        n10 = this.mHeight ^ n11;
        n11 = (n10 << 5) - n10;
        return this.mFormat ^ n11;
    }

    public String toString() {
        Object[] objectArray = new Object[3];
        Integer n10 = this.mWidth;
        objectArray[0] = n10;
        n10 = this.mHeight;
        objectArray[1] = n10;
        n10 = this.mFormat;
        objectArray[2] = n10;
        return String.format("InputConfiguration(w:%d, h:%d, format:%d)", objectArray);
    }
}

