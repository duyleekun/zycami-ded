/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.k.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import l.a.j.a.h;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;
import skin.support.design.R$style;
import skin.support.design.R$styleable;

public class c
extends CollapsingToolbarLayout
implements z {
    private int a = 0;
    private int b = 0;
    private b c;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int[] nArray = R$styleable.CollapsingToolbarLayout;
        int n11 = R$style.Widget_Design_CollapsingToolbar;
        object = object.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        n10 = R$styleable.CollapsingToolbarLayout_contentScrim;
        this.a = n10 = object.getResourceId(n10, 0);
        n10 = R$styleable.CollapsingToolbarLayout_statusBarScrim;
        this.b = n10 = object.getResourceId(n10, 0);
        object.recycle();
        this.a();
        this.b();
        super((View)this);
        this.c = object;
        ((b)object).c(attributeSet, 0);
    }

    private void a() {
        int n10;
        this.a = n10 = j.b(this.a);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.a;
            if ((context = h.a(context, n11)) != null) {
                this.setContentScrim((Drawable)context);
            }
        }
    }

    private void b() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.b;
            if ((context = h.a(context, n11)) != null) {
                this.setStatusBarScrim((Drawable)context);
            }
        }
    }

    public void e() {
        this.a();
        this.b();
        b b10 = this.c;
        if (b10 != null) {
            b10.a();
        }
    }
}

