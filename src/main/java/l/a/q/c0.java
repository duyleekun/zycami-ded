/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import l.a.q.a0;
import l.a.q.b;
import l.a.q.j;
import l.a.q.z;

public class c0
extends AppCompatTextView
implements z {
    private a0 a;
    private b b;

    public c0(Context context) {
        this(context, null);
    }

    public c0(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public c0(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.b = object;
        ((b)object).c(attributeSet, n10);
        this.a = object = a0.g(this);
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

