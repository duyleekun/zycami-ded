/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.util.AttributeSet
 */
package l.a.k.d;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import com.google.android.material.tabs.TabLayout;
import l.a.j.a.d;
import l.a.q.j;
import l.a.q.z;
import skin.support.design.R$style;
import skin.support.design.R$styleable;

public class g
extends TabLayout
implements z {
    private int a = 0;
    private int b = 0;
    private int c = 0;

    public g(Context context) {
        this(context, null);
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public g(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int[] nArray = R$styleable.TabLayout;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        n10 = R$styleable.TabLayout_tabIndicatorColor;
        this.a = n10 = attributeSet.getResourceId(n10, 0);
        n10 = R$styleable.TabLayout_tabTextAppearance;
        int n11 = R$style.TextAppearance_Design_Tab;
        n10 = attributeSet.getResourceId(n10, n11);
        nArray = R$styleable.SkinTextAppearance;
        context = context.obtainStyledAttributes(n10, nArray);
        n10 = R$styleable.SkinTextAppearance_android_textColor;
        this.b = n10 = context.getResourceId(n10, 0);
        int n12 = R$styleable.TabLayout_tabTextColor;
        n10 = (int)(attributeSet.hasValue(n12) ? 1 : 0);
        if (n10 != 0) {
            this.b = n12 = attributeSet.getResourceId(n12, 0);
        }
        if ((n10 = (int)(attributeSet.hasValue(n12 = R$styleable.TabLayout_tabSelectedTextColor) ? 1 : 0)) != 0) {
            this.c = n12 = attributeSet.getResourceId(n12, 0);
        }
        attributeSet.recycle();
        this.e();
        return;
        finally {
            context.recycle();
        }
    }

    public void e() {
        int n10;
        Context context;
        int n11;
        this.a = n11 = j.b(this.a);
        if (n11 != 0) {
            context = this.getContext();
            n10 = this.a;
            n11 = d.c(context, n10);
            this.setSelectedTabIndicatorColor(n11);
        }
        this.b = n11 = j.b(this.b);
        if (n11 != 0) {
            context = this.getContext();
            n10 = this.b;
            context = d.e(context, n10);
            this.setTabTextColors((ColorStateList)context);
        }
        this.c = n11 = j.b(this.c);
        if (n11 != 0) {
            context = this.getContext();
            n10 = this.c;
            n11 = d.c(context, n10);
            ColorStateList colorStateList = this.getTabTextColors();
            if (colorStateList != null) {
                colorStateList = this.getTabTextColors();
                n10 = colorStateList.getDefaultColor();
                this.setTabTextColors(n10, n11);
            }
        }
    }
}

