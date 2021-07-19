/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 *  android.widget.SeekBar
 */
package l.a.q;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import l.a.j.a.h;
import l.a.q.j;
import l.a.q.q;
import skin.support.appcompat.R$styleable;

public class x
extends q {
    private final SeekBar h;
    private int i = 0;

    public x(SeekBar seekBar) {
        super((ProgressBar)seekBar);
        this.h = seekBar;
    }

    public void a() {
        int n10;
        super.a();
        this.i = n10 = j.b(this.i);
        if (n10 != 0) {
            SeekBar seekBar = this.h;
            Context context = seekBar.getContext();
            int n11 = this.i;
            context = l.a.j.a.h.a(context, n11);
            seekBar.setThumb((Drawable)context);
        }
    }

    public void e(AttributeSet attributeSet, int n10) {
        super.e(attributeSet, n10);
        Context context = this.h.getContext();
        int[] nArray = R$styleable.AppCompatSeekBar;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        n10 = R$styleable.AppCompatSeekBar_android_thumb;
        this.i = n10 = attributeSet.getResourceId(n10, 0);
        attributeSet.recycle();
        this.a();
    }
}

