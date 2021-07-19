/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.k.d;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import l.a.q.b;
import l.a.q.z;

public class d
extends CoordinatorLayout
implements z {
    private b a;

    public d(Context context) {
        this(context, null);
    }

    public d(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public d(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((View)this);
        this.a = object;
        ((b)object).c(attributeSet, 0);
    }

    public void e() {
        b b10 = this.a;
        if (b10 != null) {
            b10.a();
        }
    }
}

