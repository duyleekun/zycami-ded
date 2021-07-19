/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.params.InputConfiguration
 */
package androidx.camera.camera2.internal.compat.params;

import android.hardware.camera2.params.InputConfiguration;
import androidx.camera.camera2.internal.compat.params.InputConfigurationCompat$InputConfigurationCompatImpl;
import java.util.Objects;

public final class InputConfigurationCompat$InputConfigurationCompatApi23Impl
implements InputConfigurationCompat$InputConfigurationCompatImpl {
    private final InputConfiguration mObject;

    public InputConfigurationCompat$InputConfigurationCompatApi23Impl(int n10, int n11, int n12) {
        InputConfiguration inputConfiguration = new InputConfiguration(n10, n11, n12);
        this(inputConfiguration);
    }

    public InputConfigurationCompat$InputConfigurationCompatApi23Impl(Object object) {
        object = (InputConfiguration)object;
        this.mObject = object;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof InputConfigurationCompat$InputConfigurationCompatImpl;
        if (!bl2) {
            return false;
        }
        InputConfiguration inputConfiguration = this.mObject;
        object = ((InputConfigurationCompat$InputConfigurationCompatImpl)object).getInputConfiguration();
        return Objects.equals(inputConfiguration, object);
    }

    public int getFormat() {
        return this.mObject.getFormat();
    }

    public int getHeight() {
        return this.mObject.getHeight();
    }

    public Object getInputConfiguration() {
        return this.mObject;
    }

    public int getWidth() {
        return this.mObject.getWidth();
    }

    public int hashCode() {
        return this.mObject.hashCode();
    }

    public String toString() {
        return this.mObject.toString();
    }
}

