/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package d.v.e.l;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import d.v.e.l.v1;
import d.v.e.l.v1$b;
import m.a.a;

public class v1$a
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ v1$b b;

    public v1$a(View view, v1$b b10) {
        this.a = view;
        this.b = b10;
    }

    public void onGlobalLayout() {
        Rect rect = new Rect();
        Object[] objectArray = this.a;
        objectArray.getWindowVisibleDisplayFrame(rect);
        int n10 = rect.bottom;
        int n11 = rect.top;
        n10 -= n11;
        rect = this.a;
        n11 = rect.getHeight();
        double d10 = n10;
        double d11 = n11;
        d10 /= d11;
        d11 = 0.8;
        n11 = (int)(d10 == d11 ? 0 : (d10 < d11 ? -1 : 1));
        n10 = 1;
        String string2 = null;
        if (n11 < 0) {
            n11 = n10;
        } else {
            n11 = 0;
            rect = null;
        }
        int n12 = v1.a();
        if (n11 != n12) {
            this.b.a(n11 != 0);
            objectArray = new Object[n10];
            Boolean bl2 = n11 != 0;
            objectArray[0] = bl2;
            string2 = "addOnSoftKeyBoardVisibleListener, onSoftKeyBoardVisible visible : %s";
            m.a.a.b(string2, objectArray);
        }
        v1.b(n11 != 0);
    }
}

