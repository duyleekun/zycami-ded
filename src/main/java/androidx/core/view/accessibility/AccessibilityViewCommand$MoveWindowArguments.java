/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

public final class AccessibilityViewCommand$MoveWindowArguments
extends AccessibilityViewCommand$CommandArguments {
    public int getX() {
        return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
    }

    public int getY() {
        return this.mBundle.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
    }
}

