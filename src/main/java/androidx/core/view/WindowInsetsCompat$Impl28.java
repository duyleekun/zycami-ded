/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets
 */
package androidx.core.view;

import android.view.WindowInsets;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Impl20;
import androidx.core.view.WindowInsetsCompat$Impl21;
import java.util.Objects;

public class WindowInsetsCompat$Impl28
extends WindowInsetsCompat$Impl21 {
    public WindowInsetsCompat$Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    public WindowInsetsCompat$Impl28(WindowInsetsCompat windowInsetsCompat, WindowInsetsCompat$Impl28 windowInsetsCompat$Impl28) {
        super(windowInsetsCompat, windowInsetsCompat$Impl28);
    }

    public WindowInsetsCompat consumeDisplayCutout() {
        return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeDisplayCutout());
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        boolean bl4 = object instanceof WindowInsetsCompat$Impl28;
        if (!bl4) {
            return false;
        }
        object = (WindowInsetsCompat$Impl28)object;
        Object object2 = this.mPlatformInsets;
        WindowInsets windowInsets = ((WindowInsetsCompat$Impl20)object).mPlatformInsets;
        bl4 = Objects.equals(object2, windowInsets);
        if (!bl4 || !(bl2 = Objects.equals(object2 = this.mRootViewVisibleInsets, object = ((WindowInsetsCompat$Impl20)object).mRootViewVisibleInsets))) {
            bl3 = false;
        }
        return bl3;
    }

    public DisplayCutoutCompat getDisplayCutout() {
        return DisplayCutoutCompat.wrap(this.mPlatformInsets.getDisplayCutout());
    }

    public int hashCode() {
        return this.mPlatformInsets.hashCode();
    }
}

