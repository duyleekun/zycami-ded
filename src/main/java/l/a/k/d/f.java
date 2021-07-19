/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.view.View
 *  android.widget.FrameLayout
 */
package l.a.k.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationView;
import l.a.j.a.d;
import l.a.j.a.e;
import l.a.j.a.g;
import l.a.j.a.h;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;
import skin.support.design.R$style;
import skin.support.design.R$styleable;

public class f
extends NavigationView
implements z {
    private static final int[] f;
    private static final int[] g;
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private b e;

    static {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 0x10100A0;
        f = nArray;
        int[] nArray2 = new int[n10];
        nArray2[0] = -16842910;
        g = nArray2;
    }

    public f(Context context) {
        this(context, null);
    }

    public f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public f(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        Object object = new b((View)this);
        this.e = object;
        ((b)object).c(attributeSet, 0);
        object = R$styleable.NavigationView;
        int n12 = R$style.Widget_Design_NavigationView;
        attributeSet = context.obtainStyledAttributes(attributeSet, (int[])object, n10, n12);
        n10 = R$styleable.NavigationView_itemIconTint;
        int n13 = attributeSet.hasValue(n10);
        if (n13 != 0) {
            this.d = n10 = attributeSet.getResourceId(n10, 0);
        } else {
            this.c = n10 = l.a.j.a.g.c(context);
        }
        n10 = R$styleable.NavigationView_itemTextAppearance;
        n13 = attributeSet.hasValue(n10);
        if (n13 != 0 && (n10 = attributeSet.getResourceId(n10, 0)) != 0) {
            object = R$styleable.SkinTextAppearance;
            TypedArray typedArray = context.obtainStyledAttributes(n10, (int[])object);
            n12 = (int)(typedArray.hasValue(n13 = R$styleable.SkinTextAppearance_android_textColor) ? 1 : 0);
            if (n12 != 0) {
                this.b = n13 = typedArray.getResourceId(n13, 0);
            }
            typedArray.recycle();
        }
        if ((n13 = attributeSet.hasValue(n10 = R$styleable.NavigationView_itemTextColor)) != 0) {
            this.b = n10 = attributeSet.getResourceId(n10, 0);
        } else {
            this.c = n10 = l.a.j.a.g.c(context);
        }
        n10 = this.b;
        if (n10 == 0) {
            this.b = n11 = l.a.j.a.e.c(context);
        }
        n11 = R$styleable.NavigationView_itemBackground;
        this.a = n11 = attributeSet.getResourceId(n11, 0);
        attributeSet.recycle();
        this.b();
        this.c();
        this.a();
    }

    private void a() {
        int n10;
        this.a = n10 = j.b(this.a);
        if (n10 == 0) {
            return;
        }
        Context context = this.getContext();
        int n11 = this.a;
        if ((context = h.a(context, n11)) != null) {
            this.setItemBackground((Drawable)context);
        }
    }

    private void b() {
        int n10;
        this.d = n10 = j.b(this.d);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.d;
            context = l.a.j.a.d.e(context, n11);
            this.setItemIconTintList((ColorStateList)context);
        } else {
            this.c = n10 = j.b(this.c);
            if (n10 != 0) {
                n10 = 16842808;
                ColorStateList colorStateList = this.createDefaultColorStateList(n10);
                this.setItemIconTintList(colorStateList);
            }
        }
    }

    private void c() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.b;
            context = l.a.j.a.d.e(context, n11);
            this.setItemTextColor((ColorStateList)context);
        } else {
            this.c = n10 = j.b(this.c);
            if (n10 != 0) {
                n10 = 16842806;
                ColorStateList colorStateList = this.createDefaultColorStateList(n10);
                this.setItemTextColor(colorStateList);
            }
        }
    }

    private ColorStateList createDefaultColorStateList(int n10) {
        int n11;
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = this.getContext().getTheme();
        n10 = (int)(theme.resolveAttribute(n10, typedValue, (n11 = 1) != 0) ? 1 : 0);
        if (n10 == 0) {
            return null;
        }
        Context context = this.getContext();
        int n12 = typedValue.resourceId;
        context = l.a.j.a.d.e(context, n12);
        typedValue = this.getContext();
        int n13 = this.c;
        n12 = l.a.j.a.d.c((Context)typedValue, n13);
        n13 = context.getDefaultColor();
        int n14 = 3;
        int[][] nArrayArray = new int[n14][];
        int[] nArray = g;
        nArrayArray[0] = nArray;
        int[] nArray2 = f;
        nArrayArray[n11] = nArray2;
        nArray2 = FrameLayout.EMPTY_STATE_SET;
        int n15 = 2;
        nArrayArray[n15] = nArray2;
        int[] nArray3 = new int[n14];
        nArray3[0] = n10 = context.getColorForState(nArray, n13);
        nArray3[n11] = n12;
        nArray3[n15] = n13;
        ColorStateList colorStateList = new ColorStateList((int[][])nArrayArray, nArray3);
        return colorStateList;
    }

    public void e() {
        b b10 = this.e;
        if (b10 != null) {
            b10.a();
        }
        this.b();
        this.c();
        this.a();
    }

    public void setItemBackgroundResource(int n10) {
        super.setItemBackgroundResource(n10);
        this.a = n10;
        this.a();
    }

    public void setItemTextAppearance(int n10) {
        super.setItemTextAppearance(n10);
        if (n10 != 0) {
            int n11;
            int[] nArray;
            Context context = this.getContext();
            TypedArray typedArray = context.obtainStyledAttributes(n10, nArray = R$styleable.SkinTextAppearance);
            boolean bl2 = typedArray.hasValue(n11 = R$styleable.SkinTextAppearance_android_textColor);
            if (bl2) {
                bl2 = false;
                nArray = null;
                this.b = n11 = typedArray.getResourceId(n11, 0);
            }
            typedArray.recycle();
            this.c();
        }
    }
}

