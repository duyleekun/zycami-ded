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
import androidx.appcompat.widget.AppCompatImageView;
import l.a.q.b;
import l.a.q.j;
import l.a.q.l;
import l.a.q.z;

public class m
extends AppCompatImageView
implements z {
    private b a;
    private l b;

    public m(Context context) {
        this(context, null);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public m(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.a = object;
        ((b)object).c(attributeSet, n10);
        this.b = object = new l(this);
        ((l)object).c(attributeSet, n10);
    }

    public void e() {
        j j10 = this.a;
        if (j10 != null) {
            ((b)j10).a();
        }
        if ((j10 = this.b) != null) {
            ((l)j10).a();
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.a;
        if (b10 != null) {
            b10.d(n10);
        }
    }

    public void setImageResource(int n10) {
        l l10 = this.b;
        if (l10 != null) {
            l10.d(n10);
        }
    }
}

