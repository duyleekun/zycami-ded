/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources$Theme
 *  android.util.AttributeSet
 *  android.util.TypedValue
 *  android.widget.FrameLayout
 */
package l.a.k.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import l.a.j.a.d;
import l.a.q.j;
import l.a.q.z;
import skin.support.design.R$attr;
import skin.support.design.R$style;
import skin.support.design.R$styleable;

public class b
extends BottomNavigationView
implements z {
    private static final int[] d;
    private static final int[] e;
    private int a = 0;
    private int b = 0;
    private int c = 0;

    static {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = 0x10100A0;
        d = nArray;
        int[] nArray2 = new int[n10];
        nArray2[0] = -16842910;
        e = nArray2;
    }

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int[] nArray = R$styleable.BottomNavigationView;
        int n11 = R$style.Widget_Design_BottomNavigationView;
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        int n12 = R$styleable.BottomNavigationView_itemIconTint;
        n10 = (int)(context.hasValue(n12) ? 1 : 0);
        if (n10 != 0) {
            this.b = n12 = context.getResourceId(n12, 0);
        } else {
            this.c = n12 = this.d();
        }
        n12 = R$styleable.BottomNavigationView_itemTextColor;
        n10 = (int)(context.hasValue(n12) ? 1 : 0);
        if (n10 != 0) {
            this.a = n12 = context.getResourceId(n12, 0);
        } else {
            this.c = n12 = this.d();
        }
        context.recycle();
        this.a();
        this.b();
    }

    private void a() {
        int n10;
        this.b = n10 = j.b(this.b);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.b;
            context = l.a.j.a.d.e(context, n11);
            this.setItemIconTintList((ColorStateList)context);
        } else {
            this.c = n10 = j.b(this.c);
            if (n10 != 0) {
                n10 = 16842808;
                ColorStateList colorStateList = this.c(n10);
                this.setItemIconTintList(colorStateList);
            }
        }
    }

    private void b() {
        int n10;
        this.a = n10 = j.b(this.a);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.a;
            context = l.a.j.a.d.e(context, n11);
            this.setItemTextColor((ColorStateList)context);
        } else {
            this.c = n10 = j.b(this.c);
            if (n10 != 0) {
                n10 = 16842808;
                ColorStateList colorStateList = this.c(n10);
                this.setItemTextColor(colorStateList);
            }
        }
    }

    private ColorStateList c(int n10) {
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
        int[] nArray = e;
        nArrayArray[0] = nArray;
        int[] nArray2 = d;
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

    private int d() {
        boolean bl2;
        int n10;
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = this.getContext().getTheme();
        boolean bl3 = theme.resolveAttribute(n10 = R$attr.colorPrimary, typedValue, bl2 = true);
        if (!bl3) {
            return 0;
        }
        return typedValue.resourceId;
    }

    public void e() {
        this.a();
        this.b();
    }
}

