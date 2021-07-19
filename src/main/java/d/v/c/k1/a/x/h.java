/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package d.v.c.k1.a.x;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import d.v.c.k1.a.x.l;
import d.v.j.g.b0;

public class h
extends l {
    public void e(Activity activity, Fragment stringArray, long l10, MutableLiveData mutableLiveData) {
        stringArray = b0.a(this.b());
        Intent intent = new Intent();
        intent.putExtra("templateMediaArray", stringArray);
        activity.setResult(-1, intent);
        activity.finish();
    }
}

