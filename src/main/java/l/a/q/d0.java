/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.q;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import l.a.j.a.d;
import l.a.j.a.h;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;
import skin.support.appcompat.R$attr;
import skin.support.appcompat.R$styleable;

public class d0
extends Toolbar
implements z {
    private int a;
    private int b;
    private int c;
    private b d;

    public d0(Context context) {
        this(context, null);
    }

    public d0(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.toolbarStyle;
        this(context, attributeSet, n10);
    }

    public d0(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        this.a = 0;
        this.b = 0;
        this.c = 0;
        Object object = new b((View)this);
        this.d = object;
        ((b)object).c(attributeSet, n10);
        object = R$styleable.Toolbar;
        Object object2 = context.obtainStyledAttributes(attributeSet, (int[])object, n10, 0);
        int n12 = R$styleable.Toolbar_navigationIcon;
        this.c = n12 = object2.getResourceId(n12, 0);
        n12 = R$styleable.Toolbar_titleTextAppearance;
        n12 = object2.getResourceId(n12, 0);
        int n13 = R$styleable.Toolbar_subtitleTextAppearance;
        n13 = object2.getResourceId(n13, 0);
        object2.recycle();
        if (n12 != 0) {
            object2 = R$styleable.SkinTextAppearance;
            object2 = context.obtainStyledAttributes(n12, (int[])object2);
            n12 = R$styleable.SkinTextAppearance_android_textColor;
            this.a = n12 = object2.getResourceId(n12, 0);
            object2.recycle();
        }
        if (n13 != 0) {
            object2 = R$styleable.SkinTextAppearance;
            object2 = context.obtainStyledAttributes(n13, (int[])object2);
            n12 = R$styleable.SkinTextAppearance_android_textColor;
            this.b = n12 = object2.getResourceId(n12, 0);
            object2.recycle();
        }
        if ((n10 = (int)((context = context.obtainStyledAttributes(attributeSet, (int[])object, n10, 0)).hasValue(n11 = R$styleable.Toolbar_titleTextColor) ? 1 : 0)) != 0) {
            this.a = n11 = context.getResourceId(n11, 0);
        }
        if ((n10 = (int)(context.hasValue(n11 = R$styleable.Toolbar_subtitleTextColor) ? 1 : 0)) != 0) {
            this.b = n11 = context.getResourceId(n11, 0);
        }
        context.recycle();
        this.c();
        this.b();
        this.a();
    }

    private void a() {
        int n10;
        this.c = n10 = j.b(this.c);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.c;
            context = h.a(context, n11);
            this.setNavigationIcon((Drawable)context);
        }
    }

    private void b() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.b;
            n10 = l.a.j.a.d.c(context, n11);
            this.setSubtitleTextColor(n10);
        }
    }

    private void c() {
        int n10;
        this.a = n10 = j.b(this.a);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.a;
            n10 = l.a.j.a.d.c(context, n11);
            this.setTitleTextColor(n10);
        }
    }

    public void e() {
        b b10 = this.d;
        if (b10 != null) {
            b10.a();
        }
        this.c();
        this.b();
        this.a();
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.d;
        if (b10 != null) {
            b10.d(n10);
        }
    }

    public void setNavigationIcon(int n10) {
        super.setNavigationIcon(n10);
        this.c = n10;
        this.a();
    }
}

