/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.view.accessibility;

import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

public final class AccessibilityViewCommand$SetTextArguments
extends AccessibilityViewCommand$CommandArguments {
    public CharSequence getText() {
        return this.mBundle.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
    }
}

