/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.view.WindowInsets$Builder
 */
package androidx.core.view;

import android.graphics.Insets;
import android.view.WindowInsets;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$BuilderImpl29;
import androidx.core.view.WindowInsetsCompat$TypeImpl30;

public class WindowInsetsCompat$BuilderImpl30
extends WindowInsetsCompat$BuilderImpl29 {
    public WindowInsetsCompat$BuilderImpl30() {
    }

    public WindowInsetsCompat$BuilderImpl30(WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
    }

    public void setInsets(int n10, androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        n10 = WindowInsetsCompat$TypeImpl30.toPlatformType(n10);
        insets = insets.toPlatformInsets();
        builder.setInsets(n10, (Insets)insets);
    }

    public void setInsetsIgnoringVisibility(int n10, androidx.core.graphics.Insets insets) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        n10 = WindowInsetsCompat$TypeImpl30.toPlatformType(n10);
        insets = insets.toPlatformInsets();
        builder.setInsetsIgnoringVisibility(n10, (Insets)insets);
    }

    public void setVisible(int n10, boolean bl2) {
        WindowInsets.Builder builder = this.mPlatBuilder;
        n10 = WindowInsetsCompat$TypeImpl30.toPlatformType(n10);
        builder.setVisible(n10, bl2);
    }
}

