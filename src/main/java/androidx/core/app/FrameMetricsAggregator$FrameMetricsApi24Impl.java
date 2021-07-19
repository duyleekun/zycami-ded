/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.SparseIntArray
 *  android.view.Window$OnFrameMetricsAvailableListener
 */
package androidx.core.app;

import android.app.Activity;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseIntArray;
import android.view.Window;
import androidx.core.app.FrameMetricsAggregator$FrameMetricsBaseImpl;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class FrameMetricsAggregator$FrameMetricsApi24Impl
extends FrameMetricsAggregator$FrameMetricsBaseImpl {
    private static final int NANOS_PER_MS = 1000000;
    private static final int NANOS_ROUNDING_VALUE = 500000;
    private static Handler sHandler;
    private static HandlerThread sHandlerThread;
    private ArrayList mActivities;
    public Window.OnFrameMetricsAvailableListener mListener;
    public SparseIntArray[] mMetrics;
    public int mTrackingFlags;

    public FrameMetricsAggregator$FrameMetricsApi24Impl(int n10) {
        Object object = new SparseIntArray[9];
        this.mMetrics = object;
        this.mActivities = object;
        super(this);
        this.mListener = object;
        this.mTrackingFlags = n10;
    }

    public void add(Activity activity) {
        Looper looper;
        int n10;
        Object object;
        Object object2 = sHandlerThread;
        if (object2 == null) {
            object2 = new HandlerThread("FrameMetricsAggregator");
            sHandlerThread = object2;
            object2.start();
            object = sHandlerThread.getLooper();
            object2 = new Handler(object);
            sHandler = object2;
        }
        object2 = null;
        for (int i10 = 0; i10 <= (n10 = 8); ++i10) {
            object = this.mMetrics;
            looper = object[i10];
            if (looper != null) continue;
            int n11 = this.mTrackingFlags;
            int n12 = 1 << i10;
            if ((n11 &= n12) == 0) continue;
            object[i10] = looper = new SparseIntArray();
        }
        object2 = activity.getWindow();
        object = this.mListener;
        looper = sHandler;
        object2.addOnFrameMetricsAvailableListener((Window.OnFrameMetricsAvailableListener)object, (Handler)looper);
        object2 = this.mActivities;
        object = new WeakReference(activity);
        ((ArrayList)object2).add(object);
    }

    public void addDurationItem(SparseIntArray sparseIntArray, long l10) {
        if (sparseIntArray != null) {
            long l11 = 500000L + l10;
            long l12 = 1000000L;
            int n10 = (int)(l11 /= l12);
            long l13 = 0L;
            long l14 = l10 - l13;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object >= 0) {
                object = sparseIntArray.get(n10) + 1;
                sparseIntArray.put(n10, (int)object);
            }
        }
    }

    public SparseIntArray[] getMetrics() {
        return this.mMetrics;
    }

    public SparseIntArray[] remove(Activity activity) {
        boolean bl2;
        Object object = this.mActivities.iterator();
        while (bl2 = object.hasNext()) {
            WeakReference weakReference = (WeakReference)object.next();
            Object t10 = weakReference.get();
            if (t10 != activity) continue;
            object = this.mActivities;
            ((ArrayList)object).remove(weakReference);
            break;
        }
        activity = activity.getWindow();
        object = this.mListener;
        activity.removeOnFrameMetricsAvailableListener((Window.OnFrameMetricsAvailableListener)object);
        return this.mMetrics;
    }

    public SparseIntArray[] reset() {
        SparseIntArray[] sparseIntArrayArray = this.mMetrics;
        SparseIntArray[] sparseIntArrayArray2 = new SparseIntArray[9];
        this.mMetrics = sparseIntArrayArray2;
        return sparseIntArrayArray;
    }

    public SparseIntArray[] stop() {
        ArrayList arrayList = this.mActivities;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            Object object = (WeakReference)this.mActivities.get(i10);
            Activity activity = (Activity)((Reference)object).get();
            if ((object = ((Reference)object).get()) == null) continue;
            object = activity.getWindow();
            activity = this.mListener;
            object.removeOnFrameMetricsAvailableListener((Window.OnFrameMetricsAvailableListener)activity);
            object = this.mActivities;
            ((ArrayList)object).remove(i10);
        }
        return this.mMetrics;
    }
}

