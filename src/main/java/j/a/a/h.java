/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.content.Context
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Bundle
 */
package j.a.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import j.a.a.d$a;
import j.a.a.d$b;
import j.a.a.f;
import j.a.a.g;

public class h
extends AppCompatDialogFragment {
    public static final String c = "RationaleDialogFragmentCompat";
    private d$a a;
    private d$b b;

    public static h h(String string2, String string3, String string4, int n10, int n11, String[] stringArray) {
        h h10 = new h();
        g g10 = new g(string3, string4, string2, n10, n11, stringArray);
        string2 = g10.c();
        h10.setArguments((Bundle)string2);
        return h10;
    }

    public void i(FragmentManager fragmentManager, String string2) {
        boolean bl2 = fragmentManager.isStateSaved();
        if (bl2) {
            return;
        }
        this.show(fragmentManager, string2);
    }

    public void onAttach(Context object) {
        boolean bl2;
        super.onAttach((Context)object);
        Object object2 = this.getParentFragment();
        if (object2 != null) {
            object2 = this.getParentFragment();
            bl2 = object2 instanceof d$a;
            if (bl2) {
                this.a = object2 = (d$a)((Object)this.getParentFragment());
            }
            if (bl2 = (object2 = this.getParentFragment()) instanceof d$b) {
                this.b = object2 = (d$b)((Object)this.getParentFragment());
            }
        }
        if (bl2 = object instanceof d$a) {
            object2 = object;
            this.a = object2 = (d$a)object;
        }
        if (bl2 = object instanceof d$b) {
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
        d$a = this.getContext();
        return ((g)object).b((Context)d$a, (DialogInterface.OnClickListener)object2);
    }

    public void onDetach() {
        super.onDetach();
        this.a = null;
        this.b = null;
    }
}

