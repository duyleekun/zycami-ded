/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.widget.CompoundButton
 */
package l.a.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.core.widget.CompoundButtonCompat;
import l.a.j.a.d;
import l.a.j.a.h;
import l.a.q.j;
import skin.support.appcompat.R$styleable;

public class g
extends j {
    private final CompoundButton c;
    private int d = 0;
    private int e = 0;

    public g(CompoundButton compoundButton) {
        this.c = compoundButton;
    }

    public void a() {
        int n10;
        Context context;
        CompoundButton compoundButton;
        int n11;
        this.d = n11 = j.b(this.d);
        if (n11 != 0) {
            compoundButton = this.c;
            context = compoundButton.getContext();
            n10 = this.d;
            context = h.a(context, n10);
            compoundButton.setButtonDrawable((Drawable)context);
        }
        this.e = n11 = j.b(this.e);
        if (n11 != 0) {
            compoundButton = this.c;
            context = compoundButton.getContext();
            n10 = this.e;
            context = l.a.j.a.d.e(context, n10);
            CompoundButtonCompat.setButtonTintList(compoundButton, (ColorStateList)context);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(AttributeSet attributeSet, int n10) {
        Context context = this.c.getContext();
        int[] nArray = R$styleable.CompoundButton;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        try {
            n10 = R$styleable.CompoundButton_android_button;
            boolean bl2 = attributeSet.hasValue(n10);
            if (bl2) {
                this.d = n10 = attributeSet.getResourceId(n10, 0);
            }
            if (bl2 = attributeSet.hasValue(n10 = R$styleable.CompoundButton_buttonTint)) {
                this.e = n10 = attributeSet.getResourceId(n10, 0);
            }
            this.a();
            return;
        }
        finally {
            attributeSet.recycle();
        }
    }

    public void d(int n10) {
        this.d = n10;
        this.a();
    }
}

