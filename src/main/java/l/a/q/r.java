/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.TextView
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import l.a.q.a0;
import l.a.q.b;
import l.a.q.g;
import l.a.q.j;
import l.a.q.z;
import skin.support.appcompat.R$attr;

public class r
extends AppCompatRadioButton
implements z {
    private a0 a;
    private g b;
    private b c;

    public r(Context context) {
        this(context, null);
    }

    public r(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.radioButtonStyle;
        this(context, attributeSet, n10);
    }

    public r(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((CompoundButton)this);
        this.b = object;
        ((g)object).c(attributeSet, n10);
        this.a = object = a0.g((TextView)this);
        ((a0)object).i(attributeSet, n10);
        this.c = object = new b((View)this);
        ((b)object).c(attributeSet, n10);
    }

    public void e() {
        j j10 = this.c;
        if (j10 != null) {
            ((b)j10).a();
        }
        if ((j10 = this.b) != null) {
            ((g)j10).a();
        }
        if ((j10 = this.a) != null) {
            ((a0)j10).a();
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.c;
        if (b10 != null) {
            b10.d(n10);
        }
    }

    public void setButtonDrawable(int n10) {
        super.setButtonDrawable(n10);
        g g10 = this.b;
        if (g10 != null) {
            g10.d(n10);
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

