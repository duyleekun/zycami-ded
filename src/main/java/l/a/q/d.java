/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.util.AttributeSet
 */
package l.a.q;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.cardview.widget.CardView;
import l.a.q.j;
import l.a.q.z;
import skin.support.cardview.R$color;
import skin.support.cardview.R$style;
import skin.support.cardview.R$styleable;

public class d
extends CardView
implements z {
    private static final int[] c;
    private int a = 0;
    private int b = 0;

    static {
        int[] nArray = new int[]{0x1010031};
        c = nArray;
    }

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int[] nArray = R$styleable.CardView;
        int n11 = R$style.CardView;
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        int n12 = R$styleable.CardView_cardBackgroundColor;
        n10 = (int)(context.hasValue(n12) ? 1 : 0);
        if (n10 != 0) {
            this.b = n12 = context.getResourceId(n12, 0);
        } else {
            attributeSet = this.getContext();
            int[] nArray2 = c;
            attributeSet = attributeSet.obtainStyledAttributes(nArray2);
            this.a = n10 = attributeSet.getResourceId(0, 0);
            attributeSet.recycle();
        }
        context.recycle();
        this.a();
    }

    private void a() {
        int n10;
        this.b = n10 = j.b(this.b);
        this.a = n10 = j.b(this.a);
        int n11 = this.b;
        if (n11 != 0) {
            Context context = this.getContext();
            n11 = this.b;
            context = l.a.j.a.d.e(context, n11);
            this.setCardBackgroundColor((ColorStateList)context);
        } else if (n10 != 0) {
            Context context = this.getContext();
            n11 = this.a;
            n10 = l.a.j.a.d.c(context, n11);
            float[] fArray = new float[3];
            Color.colorToHSV((int)n10, (float[])fArray);
            float f10 = fArray[2];
            n11 = 0x3F000000;
            float f11 = 0.5f;
            n10 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
            if (n10 > 0) {
                context = this.getResources();
                n11 = R$color.cardview_light_background;
                n10 = context.getColor(n11);
            } else {
                context = this.getResources();
                n11 = R$color.cardview_dark_background;
                n10 = context.getColor(n11);
            }
            context = ColorStateList.valueOf((int)n10);
            this.setCardBackgroundColor((ColorStateList)context);
        }
    }

    public void e() {
        this.a();
    }
}

