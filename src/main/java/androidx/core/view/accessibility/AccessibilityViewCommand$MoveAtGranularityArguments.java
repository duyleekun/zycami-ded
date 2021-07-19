/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

public final class AccessibilityViewCommand$MoveAtGranularityArguments
extends AccessibilityViewCommand$CommandArguments {
    public boolean getExtendSelection() {
        return this.mBundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    }

    public int getGranularity() {
        return this.mBundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    }
}

