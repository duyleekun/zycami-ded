/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package com.tencent.ijk.media.player;

import android.graphics.Rect;

public final class IjkTimedText {
    private Rect mTextBounds = null;
    private String mTextChars = null;

    public IjkTimedText(Rect rect, String string2) {
        this.mTextBounds = rect;
        this.mTextChars = string2;
    }

    public Rect getBounds() {
        return this.mTextBounds;
    }

    public String getText() {
        return this.mTextChars;
    }
}

