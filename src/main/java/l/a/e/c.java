/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package l.a.e;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import l.a.e.g;
import l.a.q.d;

public class c
implements g {
    public View b(Context object, String object2, AttributeSet attributeSet) {
        ((String)object2).hashCode();
        String string2 = "androidx.cardview.widget.CardView";
        boolean bl2 = ((String)object2).equals(string2);
        if (!bl2) {
            object = null;
        } else {
            object2 = new d((Context)object, attributeSet);
            object = object2;
        }
        return object;
    }
}

