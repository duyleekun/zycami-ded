/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package d.c.a.s.j;

import android.util.Log;
import android.view.ViewTreeObserver;
import d.c.a.s.j.r$b;
import java.lang.ref.WeakReference;

public final class r$b$a
implements ViewTreeObserver.OnPreDrawListener {
    private final WeakReference a;

    public r$b$a(r$b b10) {
        WeakReference<r$b> weakReference;
        this.a = weakReference = new WeakReference<r$b>(b10);
    }

    public boolean onPreDraw() {
        Object object = "ViewTarget";
        boolean bl2 = Log.isLoggable((String)object, (int)2);
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "OnGlobalLayoutListener called attachStateListener=";
            charSequence.append(string2);
            charSequence.append(this);
            charSequence = charSequence.toString();
            Log.v((String)object, (String)charSequence);
        }
        if ((object = (r$b)this.a.get()) != null) {
            ((r$b)object).a();
        }
        return true;
    }
}

