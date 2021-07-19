/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnClickListener
 */
package j.a.a;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.fragment.app.Fragment;
import j.a.a.d$a;
import j.a.a.d$b;
import j.a.a.g;
import j.a.a.h;
import j.a.a.i.e;
import java.util.Arrays;
import java.util.List;
import pub.devrel.easypermissions.RationaleDialogFragment;

public class f
implements DialogInterface.OnClickListener {
    private Object a;
    private g b;
    private d$a c;
    private d$b d;

    public f(h activityResultCaller, g g10, d$a d$a, d$b d$b) {
        Fragment fragment = activityResultCaller.getParentFragment();
        activityResultCaller = fragment != null ? activityResultCaller.getParentFragment() : activityResultCaller.getActivity();
        this.a = activityResultCaller;
        this.b = g10;
        this.c = d$a;
        this.d = d$b;
    }

    public f(RationaleDialogFragment rationaleDialogFragment, g g10, d$a d$a, d$b d$b) {
        rationaleDialogFragment = rationaleDialogFragment.getActivity();
        this.a = rationaleDialogFragment;
        this.b = g10;
        this.c = d$a;
        this.d = d$b;
    }

    private void a() {
        d$a d$a = this.c;
        if (d$a != null) {
            Object object = this.b;
            int n10 = ((g)object).d;
            object = Arrays.asList(((g)object).f);
            d$a.c(n10, (List)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onClick(DialogInterface object, int n10) {
        object = this.b;
        int n11 = ((g)object).d;
        int n12 = -1;
        if (n10 == n12) {
            object = ((g)object).f;
            Object object2 = this.d;
            if (object2 != null) {
                object2.f(n11);
            }
            if ((n12 = (object2 = this.a) instanceof Fragment) != 0) {
                object2 = e.e((Fragment)object2);
                ((e)object2).a(n11, (String[])object);
                return;
            }
            n12 = object2 instanceof Activity;
            if (n12 != 0) {
                object2 = e.d((Activity)object2);
                ((e)object2).a(n11, (String[])object);
                return;
            }
            object = new RuntimeException("Host must be an Activity or Fragment!");
            throw object;
        }
        object = this.d;
        if (object != null) {
            object.d(n11);
        }
        this.a();
    }
}

