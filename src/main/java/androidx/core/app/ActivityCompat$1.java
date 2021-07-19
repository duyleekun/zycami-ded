/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package androidx.core.app;

import android.app.Activity;
import androidx.core.app.ActivityCompat$OnRequestPermissionsResultCallback;

public class ActivityCompat$1
implements Runnable {
    public final /* synthetic */ Activity val$activity;
    public final /* synthetic */ String[] val$permissions;
    public final /* synthetic */ int val$requestCode;

    public ActivityCompat$1(String[] stringArray, Activity activity, int n10) {
        this.val$permissions = stringArray;
        this.val$activity = activity;
        this.val$requestCode = n10;
    }

    public void run() {
        int n10 = this.val$permissions.length;
        int[] nArray = new int[n10];
        Object object = this.val$activity.getPackageManager();
        String string2 = this.val$activity.getPackageName();
        String[] stringArray = this.val$permissions;
        int n11 = stringArray.length;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            String string3 = this.val$permissions[i10];
            nArray[i10] = n12 = object.checkPermission(string3, string2);
        }
        object = (ActivityCompat$OnRequestPermissionsResultCallback)this.val$activity;
        int n13 = this.val$requestCode;
        stringArray = this.val$permissions;
        object.onRequestPermissionsResult(n13, stringArray, nArray);
    }
}

