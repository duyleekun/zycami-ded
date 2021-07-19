/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.SeekBar
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatSeekBarHelper;
import androidx.appcompat.widget.ThemeUtils;

public class AppCompatSeekBar
extends SeekBar {
    private final AppCompatSeekBarHelper mAppCompatSeekBarHelper;

    public AppCompatSeekBar(Context context) {
        this(context, null);
    }

    public AppCompatSeekBar(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.seekBarStyle;
        this(context, attributeSet, n10);
    }

    public AppCompatSeekBar(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        object = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object);
        super(this);
        this.mAppCompatSeekBarHelper = object;
        ((AppCompatSeekBarHelper)object).loadFromAttributes(attributeSet, n10);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mAppCompatSeekBarHelper.drawableStateChanged();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.mAppCompatSeekBarHelper.jumpDrawablesToCurrentState();
    }

    public void onDraw(Canvas canvas) {
        synchronized (this) {
            super.onDraw(canvas);
            AppCompatSeekBarHelper appCompatSeekBarHelper = this.mAppCompatSeekBarHelper;
            appCompatSeekBarHelper.drawTickMarks(canvas);
            return;
        }
    }
}

