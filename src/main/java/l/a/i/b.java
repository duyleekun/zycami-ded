/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.i;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import l.a.q.z;

public class b
extends ConstraintLayout
implements z {
    private final l.a.q.b a;

    public b(Context context) {
        this(context, null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.a = object;
        ((l.a.q.b)object).c(attributeSet, n10);
    }

    public void e() {
        l.a.q.b b10 = this.a;
        if (b10 != null) {
            b10.a();
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        l.a.q.b b10 = this.a;
        if (b10 != null) {
            b10.d(n10);
        }
    }
}

