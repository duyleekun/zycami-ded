/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.TextView
 */
package l.a.q;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import l.a.j.a.h;
import l.a.q.a0;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;
import skin.support.appcompat.R$attr;

public class o
extends AppCompatMultiAutoCompleteTextView
implements z {
    private static final int[] d;
    private int a;
    private a0 b;
    private b c;

    static {
        int[] nArray = new int[]{16843126};
        d = nArray;
    }

    public o(Context context) {
        this(context, null);
    }

    public o(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.editTextStyle;
        this(context, attributeSet, n10);
    }

    public o(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        int n11 = 0;
        this.a = 0;
        int[] nArray = d;
        object = object.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        boolean bl2 = object.hasValue(0);
        if (bl2) {
            this.a = n11 = object.getResourceId(0, 0);
        }
        object.recycle();
        this.a();
        super((View)this);
        this.c = object;
        ((b)object).c(attributeSet, n10);
        this.b = object = a0.g((TextView)this);
        ((a0)object).i(attributeSet, n10);
    }

    private void a() {
        int n10;
        this.a = n10 = j.b(this.a);
        if (n10 != 0) {
            Context context = this.getContext();
            int n11 = this.a;
            if ((context = h.a(context, n11)) != null) {
                this.setDropDownBackgroundDrawable((Drawable)context);
            }
        }
    }

    public void e() {
        j j10 = this.c;
        if (j10 != null) {
            ((b)j10).a();
        }
        if ((j10 = this.b) != null) {
            ((a0)j10).a();
        }
        this.a();
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.c;
        if (b10 != null) {
            b10.d(n10);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(n10, n11, n12, n13);
        a0 a02 = this.b;
        if (a02 != null) {
            a02.j(n10, n11, n12, n13);
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        super.setCompoundDrawablesWithIntrinsicBounds(n10, n11, n12, n13);
        a0 a02 = this.b;
        if (a02 != null) {
            a02.k(n10, n11, n12, n13);
        }
    }

    public void setDropDownBackgroundResource(int n10) {
        super.setDropDownBackgroundResource(n10);
        this.a = n10;
        this.a();
    }

    public void setTextAppearance(int n10) {
        Context context = this.getContext();
        this.setTextAppearance(context, n10);
    }

    public void setTextAppearance(Context context, int n10) {
        super.setTextAppearance(context, n10);
        a0 a02 = this.b;
        if (a02 != null) {
            a02.l(context, n10);
        }
    }
}

