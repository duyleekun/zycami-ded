/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.app.DialogFragment
 *  android.app.FragmentManager
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package pub.devrel.easypermissions;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import j.a.a.d$a;
import j.a.a.d$b;
import j.a.a.f;
import j.a.a.g;

public class RationaleDialogFragment
extends DialogFragment {
    public static final String d = "RationaleDialogFragment";
    private d$a a;
    private d$b b;
    private boolean c = false;

    public static RationaleDialogFragment a(String string2, String string3, String string4, int n10, int n11, String[] stringArray) {
        RationaleDialogFragment rationaleDialogFragment = new RationaleDialogFragment();
        g g10 = new g(string2, string3, string4, n10, n11, stringArray);
        string2 = g10.c();
        rationaleDialogFragment.setArguments((Bundle)string2);
        return rationaleDialogFragment;
    }

    public void b(FragmentManager fragmentManager, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11 && (n10 = (int)(fragmentManager.isStateSaved() ? 1 : 0)) != 0) {
            return;
        }
        n10 = (int)(this.c ? 1 : 0);
        if (n10 != 0) {
            return;
        }
        this.show(fragmentManager, string2);
    }

    public void onAttach(Context object) {
        Object object2;
        super.onAttach(object);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11 && (object2 = this.getParentFragment()) != null) {
            object2 = this.getParentFragment();
            n10 = object2 instanceof d$a;
            if (n10 != 0) {
                object2 = (d$a)this.getParentFragment();
                this.a = object2;
            }
            if ((n10 = (object2 = this.getParentFragment()) instanceof d$b) != 0) {
                object2 = (d$b)this.getParentFragment();
                this.b = object2;
            }
        }
        if ((n10 = object instanceof d$a) != 0) {
            object2 = object;
            object2 = (d$a)object;
            this.a = object2;
        }
        if ((n10 = object instanceof d$b) != 0) {
            object = (d$b)object;
            this.b = object;
        }
    }

    public Dialog onCreateDialog(Bundle object) {
        this.setCancelable(false);
        Object object2 = this.getArguments();
        object = new g((Bundle)object2);
        d$a d$a = this.a;
        d$b d$b = this.b;
        object2 = new f(this, (g)object, d$a, d$b);
        d$a = this.getActivity();
        return ((g)object).a((Context)d$a, (DialogInterface.OnClickListener)object2);
    }

    public void onDetach() {
        super.onDetach();
        this.a = null;
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.c = true;
        super.onSaveInstanceState(bundle);
    }
}

