/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 */
package j.a.a.i;

import android.app.Activity;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import j.a.a.i.c;

public class b
extends c {
    public b(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
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

    public FragmentManager m() {
        return ((AppCompatActivity)this.c()).getSupportFragmentManager();
    }
}

