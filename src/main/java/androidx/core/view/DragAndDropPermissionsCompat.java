/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Build$VERSION
 *  android.view.DragAndDropPermissions
 *  android.view.DragEvent
 */
package androidx.core.view;

import android.app.Activity;
import android.os.Build;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;

public final class DragAndDropPermissionsCompat {
    private Object mDragAndDropPermissions;

    private DragAndDropPermissionsCompat(Object object) {
        this.mDragAndDropPermissions = object;
    }

    public static DragAndDropPermissionsCompat request(Activity activity, DragEvent object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11 && (activity = activity.requestDragAndDropPermissions(object)) != null) {
            object = new DragAndDropPermissionsCompat(activity);
            return object;
        }
        return null;
    }

    public void release() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            DragAndDropPermissions dragAndDropPermissions = (DragAndDropPermissions)this.mDragAndDropPermissions;
            dragAndDropPermissions.release();
        }
    }
}

