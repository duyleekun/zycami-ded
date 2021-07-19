/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.inputmethod.EditorInfo
 */
package androidx.core.view.inputmethod;

import android.view.inputmethod.EditorInfo;

public class EditorInfoCompat$Impl30 {
    private EditorInfoCompat$Impl30() {
    }

    public static CharSequence getInitialSelectedText(EditorInfo editorInfo, int n10) {
        return editorInfo.getInitialSelectedText(n10);
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo editorInfo, int n10, int n11) {
        return editorInfo.getInitialTextAfterCursor(n10, n11);
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo editorInfo, int n10, int n11) {
        return editorInfo.getInitialTextBeforeCursor(n10, n11);
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int n10) {
        editorInfo.setInitialSurroundingSubText(charSequence, n10);
    }
}

