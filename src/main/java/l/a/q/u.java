/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.RelativeLayout
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import l.a.q.b;
import l.a.q.z;

public class u
extends RelativeLayout
implements z {
    private b a;

    public u(Context context) {
        this(context, null);
    }

    public u(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public u(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.a = object;
        ((b)object).c(attributeSet, n10);
    }

    public void e() {
        b b10 = this.a;
        if (b10 != null) {
            b10.a();
        }
    }

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.a;
        if (b10 != null) {
            b10.d(n10);
        }
    }
}

