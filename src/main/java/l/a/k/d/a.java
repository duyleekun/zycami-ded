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
import com.google.android.material.appbar.AppBarLayout;
import l.a.q.b;
import l.a.q.z;

public class a
extends AppBarLayout
implements z {
    private b a;

    public a(Context context) {
        this(context, null);
    }

    public a(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
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

