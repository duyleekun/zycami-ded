/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

public final class AccessibilityViewCommand$SetProgressArguments
extends AccessibilityViewCommand$CommandArguments {
    public float getProgress() {
        return this.mBundle.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
    }
}

