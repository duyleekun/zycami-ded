/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package j.a.a.i;

import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import j.a.a.h;
import j.a.a.i.e;

public abstract class c
extends e {
    private static final String b = "BSPermissionsHelper";

    public c(Object object) {
        super(object);
    }

    public void j(String string2, String string3, String string4, int n10, int n11, String ... stringArray) {
        String string5;
        FragmentManager fragmentManager = this.m();
        Fragment fragment = fragmentManager.findFragmentByTag(string5 = "RationaleDialogFragmentCompat");
        boolean bl2 = fragment instanceof h;
        if (bl2) {
            Log.d((String)b, (String)"Found existing fragment, not showing rationale.");
            return;
        }
        h.h(string2, string3, string4, n10, n11, stringArray).i(fragmentManager, string5);
    }

    public abstract FragmentManager m();
}

