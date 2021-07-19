/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnKeyListener
 *  android.view.KeyEvent
 */
package d.v.g0;

import android.content.DialogInterface;
import android.view.KeyEvent;
import androidx.activity.ComponentActivity;
import d.v.g0.s;

public class s$a
implements DialogInterface.OnKeyListener {
    public final /* synthetic */ s a;

    public s$a(s s10) {
        this.a = s10;
    }

    public boolean onKey(DialogInterface object, int n10, KeyEvent keyEvent) {
        int n11 = 4;
        if (n10 == n11) {
            object = this.a;
            n11 = (int)(s.h((s)object) ? 1 : 0);
            if (n11 != 0 && (object = this.a.getActivity()) != null) {
                object = this.a.getActivity();
                ((ComponentActivity)object).onBackPressed();
            }
            return false;
        }
        return true;
    }
}

