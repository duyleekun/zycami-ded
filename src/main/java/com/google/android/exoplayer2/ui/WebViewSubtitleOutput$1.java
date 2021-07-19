/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.webkit.WebView
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.android.exoplayer2.ui.WebViewSubtitleOutput;

public class WebViewSubtitleOutput$1
extends WebView {
    public WebViewSubtitleOutput$1(WebViewSubtitleOutput webViewSubtitleOutput, Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return false;
    }

    public boolean performClick() {
        super.performClick();
        return false;
    }
}

