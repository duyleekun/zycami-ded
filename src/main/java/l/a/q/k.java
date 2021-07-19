/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.ImageView
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.AppCompatImageButton;
import l.a.q.b;
import l.a.q.j;
import l.a.q.l;
import l.a.q.z;

public class k
extends AppCompatImageButton
implements z {
    private b a;
    private l b;

    public k(Context context) {
        this(context, null);
    }

    public k(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.imageButtonStyle;
        this(context, attributeSet, n10);
    }

    public k(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.a = object;
        ((b)object).c(attributeSet, n10);
        this.b = object = new l((ImageView)this);
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

