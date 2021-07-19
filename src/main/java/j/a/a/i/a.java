/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.FragmentManager
 *  android.content.Context
 *  android.util.Log
 */
package j.a.a.i;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import j.a.a.i.e;
import pub.devrel.easypermissions.RationaleDialogFragment;

public class a
extends e {
    private static final String b = "ActPermissionHelper";

    public a(Activity activity) {
        super(activity);
    }

    public void a(int n10, String ... stringArray) {
        ActivityCompat.requestPermissions((Activity)this.c(), stringArray, n10);
    }

    public Context b() {
        return (Context)this.c();
    }

    public boolean i(String string2) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity)this.c(), string2);
    }

    public void j(String string2, String string3, String string4, int n10, int n11, String ... stringArray) {
        String string5;
        FragmentManager fragmentManager = ((Activity)this.c()).getFragmentManager();
        Object object = fragmentManager.findFragmentByTag(string5 = "RationaleDialogFragment");
        boolean bl2 = object instanceof RationaleDialogFragment;
        if (bl2) {
            Log.d((String)b, (String)"Found existing fragment, not showing rationale.");
            return;
        }
        object = string3;
        RationaleDialogFragment.a(string3, string4, string2, n10, n11, stringArray).b(fragmentManager, string5);
    }
}

