/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 */
package d.v.c.j1.a.q0;

import android.widget.PopupWindow;
import android.widget.RadioGroup;
import d.v.c.j1.a.q0.l;
import d.v.c.j1.a.q0.l$a;
import d.v.c.w0.ke;
import java.util.List;

public final class j
implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ l$a a;
    public final /* synthetic */ ke b;
    public final /* synthetic */ List c;
    public final /* synthetic */ PopupWindow d;

    public /* synthetic */ j(l$a l$a, ke ke2, List list, PopupWindow popupWindow) {
        this.a = l$a;
        this.b = ke2;
        this.c = list;
        this.d = popupWindow;
    }

    public final void onCheckedChanged(RadioGroup radioGroup, int n10) {
        l$a l$a = this.a;
        ke ke2 = this.b;
        List list = this.c;
        PopupWindow popupWindow = this.d;
        l.e(l$a, ke2, list, popupWindow, radioGroup, n10);
    }
}

