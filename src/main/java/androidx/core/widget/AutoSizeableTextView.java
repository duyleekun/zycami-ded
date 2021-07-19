/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package androidx.core.widget;

import android.os.Build;

public interface AutoSizeableTextView {
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 27;
        n10 = n10 >= n11 ? 1 : 0;
        PLATFORM_SUPPORTS_AUTOSIZE = n10;
    }

    public int getAutoSizeMaxTextSize();

    public int getAutoSizeMinTextSize();

    public int getAutoSizeStepGranularity();

    public int[] getAutoSizeTextAvailableSizes();

    public int getAutoSizeTextType();

    public void setAutoSizeTextTypeUniformWithConfiguration(int var1, int var2, int var3, int var4);

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] var1, int var2);

    public void setAutoSizeTextTypeWithDefaults(int var1);
}

