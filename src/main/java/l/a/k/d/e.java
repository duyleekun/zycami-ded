/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.util.AttributeSet
 *  android.widget.ImageView
 */
package l.a.k.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import l.a.j.a.d;
import l.a.q.j;
import l.a.q.l;
import l.a.q.z;
import skin.support.design.R$style;
import skin.support.design.R$styleable;

public class e
extends FloatingActionButton
implements z {
    private int a = 0;
    private int b = 0;
    private l c;

    public e(Context context) {
        this(context, null);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public e(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int n11;
        int[] nArray = R$styleable.FloatingActionButton;
        int n12 = R$style.Widget_Design_FloatingActionButton;
        object = object.obtainStyledAttributes(attributeSet, nArray, n10, n12);
        int n13 = R$styleable.FloatingActionButton_backgroundTint;
        this.b = n13 = object.getResourceId(n13, 0);
        n13 = R$styleable.FloatingActionButton_rippleColor;
        this.a = n11 = object.getResourceId(n13, 0);
        object.recycle();
        this.a();
        this.b();
        super((ImageView)this);
        this.c = object;
        ((l)object).c(attributeSet, n10);
    }

    private void a() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.b;
            context = d.e(context, n11);
            this.setBackgroundTintList((ColorStateList)context);
        }
    }

    private void b() {
        int n10;
        this.a = n10 = j.b(this.a);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.a;
            n10 = d.c(context, n11);
            this.setRippleColor(n10);
        }
    }

    public void e() {
        this.a();
        this.b();
        l l10 = this.c;
        if (l10 != null) {
            l10.a();
        }
    }
}

