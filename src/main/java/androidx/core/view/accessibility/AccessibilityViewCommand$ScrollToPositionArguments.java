/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

public final class AccessibilityViewCommand$ScrollToPositionArguments
extends AccessibilityViewCommand$CommandArguments {
    public int getColumn() {
        return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
    }

    public int getRow() {
        return this.mBundle.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
    }
}

