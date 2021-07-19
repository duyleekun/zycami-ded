/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.widget.ProgressBar
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import l.a.q.q;
import l.a.q.z;

public class p
extends ProgressBar
implements z {
    private q a;

    public p(Context context) {
        this(context, null);
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0x1010077);
    }

    public p(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super(this);
        this.a = object;
        ((q)object).e(attributeSet, n10);
    }

    public void e() {
        q q10 = this.a;
        if (q10 != null) {
            q10.a();
        }
    }
}

