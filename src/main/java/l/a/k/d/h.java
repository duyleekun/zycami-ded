/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.TextView
 */
package l.a.k.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import com.google.android.material.textfield.TextInputEditText;
import l.a.q.a0;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;

public class h
extends TextInputEditText
implements z {
    private a0 a;
    private b b;

    public h(Context context) {
        this(context, null);
    }

    public h(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.editTextStyle;
        this(context, attributeSet, n10);
    }

    public h(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.b = object;
        ((b)object).c(attributeSet, n10);
        this.a = object = a0.g((TextView)this);
        ((a0)object).i(attributeSet, n10);
    }

    public void e() {
        j j10 = this.b;
        if (j10 != null) {
            ((b)j10).a();
        }
        if ((j10 = this.a) != null) {
            ((a0)j10).a();
        }
    }

    public int getTextColorResId() {
        int n10;
        a0 a02 = this.a;
        if (a02 != null) {
            n10 = a02.h();
        } else {
            n10 = 0;
            a02 = null;
        }
        return n10;
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.b;
        if (b10 != null) {
            b10.d(n10);
        }
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(n10, n11, n12, n13);
        a0 a02 = this.a;
        if (a02 != null) {
            a02.j(n10, n11, n12, n13);
        }
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int n10, int n11, int n12, int n13) {
        super.setCompoundDrawablesWithIntrinsicBounds(n10, n11, n12, n13);
        a0 a02 = this.a;
        if (a02 != null) {
            a02.k(n10, n11, n12, n13);
        }
    }

    public void setTextAppearance(int n10) {
        Context context = this.getContext();
        this.setTextAppearance(context, n10);
    }

    public void setTextAppearance(Context context, int n10) {
        super.setTextAppearance(context, n10);
        a0 a02 = this.a;
        if (a02 != null) {
            a02.l(context, n10);
        }
    }
}

