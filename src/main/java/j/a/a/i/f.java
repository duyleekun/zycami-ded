/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package j.a.a.i;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import j.a.a.i.c;

public class f
extends c {
    public f(Fragment fragment) {
        super(fragment);
    }

    public void a(int n10, String ... stringArray) {
        ((Fragment)this.c()).requestPermissions(stringArray, n10);
    }

    public Context b() {
        return ((Fragment)this.c()).getActivity();
    }

    public boolean i(String string2) {
        return ((Fragment)this.c()).shouldShowRequestPermissionRationale(string2);
    }

    public FragmentManager m() {
        return ((Fragment)this.c()).getChildFragmentManager();
    }
}

