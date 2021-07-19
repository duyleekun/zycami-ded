/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.widget.RadioGroup
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioGroup;
import l.a.q.b;
import l.a.q.z;

public class s
extends RadioGroup
implements z {
    private b a;

    public s(Context context) {
        this(context, null);
    }

    public s(Context object, AttributeSet attributeSet) {
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

    public void setBackgroundResource(int n10) {
        super.setBackgroundResource(n10);
        b b10 = this.a;
        if (b10 != null) {
            b10.d(n10);
        }
    }
}

