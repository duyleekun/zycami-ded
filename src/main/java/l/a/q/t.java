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
import androidx.appcompat.widget.AppCompatRatingBar;
import l.a.q.q;
import l.a.q.z;
import skin.support.appcompat.R$attr;

public class t
extends AppCompatRatingBar
implements z {
    private q a;

    public t(Context context) {
        this(context, null);
    }

    public t(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.ratingBarStyle;
        this(context, attributeSet, n10);
    }

    public t(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super((ProgressBar)this);
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

