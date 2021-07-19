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
import androidx.core.view.ViewCompat;
import l.a.j.a.h;
import l.a.q.j;
import skin.support.R$styleable;

public class b
extends j {
    private final View c;
    private int d = 0;

    public b(View view) {
        this.c = view;
    }

    public void a() {
        int n10;
        this.d = n10 = j.b(this.d);
        if (n10 == 0) {
            return;
        }
        Context context = this.c.getContext();
        int n11 = this.d;
        if ((context = h.a(context, n11)) != null) {
            View view = this.c;
            n11 = view.getPaddingLeft();
            View view2 = this.c;
            int n12 = view2.getPaddingTop();
            View view3 = this.c;
            int n13 = view3.getPaddingRight();
            View view4 = this.c;
            int n14 = view4.getPaddingBottom();
            View view5 = this.c;
            ViewCompat.setBackground(view5, (Drawable)context);
            context = this.c;
            context.setPadding(n11, n12, n13, n14);
        }
    }

    public void c(AttributeSet attributeSet, int n10) {
        block6: {
            Context context = this.c.getContext();
            int[] nArray = R$styleable.SkinBackgroundHelper;
            attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
            n10 = R$styleable.SkinBackgroundHelper_android_background;
            boolean bl2 = attributeSet.hasValue(n10);
            if (!bl2) break block6;
            this.d = n10 = attributeSet.getResourceId(n10, 0);
        }
        this.a();
        return;
        finally {
            attributeSet.recycle();
        }
    }

    public void d(int n10) {
        this.d = n10;
        this.a();
    }
}

