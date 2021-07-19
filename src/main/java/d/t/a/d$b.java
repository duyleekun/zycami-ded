/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 */
package d.t.a;

import android.view.View;
import android.view.ViewGroup;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import d.t.a.d;
import d.t.a.j.a;

public class d$b
implements View.OnClickListener {
    public final /* synthetic */ d a;

    public d$b(d d10) {
        this.a = d10;
    }

    public void onClick(View view) {
        Object object = d.m(this.a);
        Object object2 = view;
        object2 = (AspectRatioTextView)((ViewGroup)view).getChildAt(0);
        boolean bl2 = view.isSelected();
        float f10 = ((AspectRatioTextView)object2).c(bl2);
        ((a)object).setTargetAspectRatio(f10);
        object = d.m(this.a);
        ((a)object).A();
        boolean bl3 = view.isSelected();
        if (!bl3) {
            boolean bl4;
            object = d.n(this.a).iterator();
            while (bl4 = object.hasNext()) {
                object2 = (ViewGroup)object.next();
                bl2 = object2 == view;
                object2.setSelected(bl2);
            }
        }
    }
}

