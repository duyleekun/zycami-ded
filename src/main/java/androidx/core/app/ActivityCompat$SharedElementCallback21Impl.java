/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.SharedElementCallback
 *  android.app.SharedElementCallback$OnSharedElementsReadyListener
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.os.Parcelable
 *  android.view.View
 */
package androidx.core.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import androidx.core.app.ActivityCompat$SharedElementCallback21Impl$1;
import androidx.core.app.SharedElementCallback;
import java.util.List;
import java.util.Map;

public class ActivityCompat$SharedElementCallback21Impl
extends android.app.SharedElementCallback {
    private final SharedElementCallback mCallback;

    public ActivityCompat$SharedElementCallback21Impl(SharedElementCallback sharedElementCallback) {
        this.mCallback = sharedElementCallback;
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
        return this.mCallback.onCaptureSharedElementSnapshot(view, matrix, rectF);
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        return this.mCallback.onCreateSnapshotView(context, parcelable);
    }

    public void onMapSharedElements(List list, Map map) {
        this.mCallback.onMapSharedElements(list, map);
    }

    public void onRejectSharedElements(List list) {
        this.mCallback.onRejectSharedElements(list);
    }

    public void onSharedElementEnd(List list, List list2, List list3) {
        this.mCallback.onSharedElementEnd(list, list2, list3);
    }

    public void onSharedElementStart(List list, List list2, List list3) {
        this.mCallback.onSharedElementStart(list, list2, list3);
    }

    public void onSharedElementsArrived(List list, List list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
        SharedElementCallback sharedElementCallback = this.mCallback;
        ActivityCompat$SharedElementCallback21Impl$1 activityCompat$SharedElementCallback21Impl$1 = new ActivityCompat$SharedElementCallback21Impl$1(this, onSharedElementsReadyListener);
        sharedElementCallback.onSharedElementsArrived(list, list2, activityCompat$SharedElementCallback21Impl$1);
    }
}

