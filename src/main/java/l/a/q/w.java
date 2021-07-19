/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package l.a.q;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import l.a.q.x;
import l.a.q.z;
import skin.support.appcompat.R$attr;

public class w
extends AppCompatSeekBar
implements z {
    private x a;

    public w(Context context) {
        this(context, null);
    }

    public w(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.seekBarStyle;
        this(context, attributeSet, n10);
    }

    public w(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super(this);
        this.a = object;
        ((x)object).e(attributeSet, n10);
    }

    public void e() {
        x x10 = this.a;
        if (x10 != null) {
            x10.a();
        }
    }
}

