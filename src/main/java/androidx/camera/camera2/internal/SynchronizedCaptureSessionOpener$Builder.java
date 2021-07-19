/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package androidx.camera.camera2.internal;

import android.os.Build;
import android.os.Handler;
import androidx.camera.camera2.internal.CaptureSessionRepository;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionBaseImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionImpl;
import androidx.camera.camera2.internal.SynchronizedCaptureSessionOpener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public class SynchronizedCaptureSessionOpener$Builder {
    private final CaptureSessionRepository mCaptureSessionRepository;
    private final Handler mCompatHandler;
    private final Set mEnableFeature;
    private final Executor mExecutor;
    private final ScheduledExecutorService mScheduledExecutorService;
    private final int mSupportedHardwareLevel;

    public SynchronizedCaptureSessionOpener$Builder(Executor object, ScheduledExecutorService scheduledExecutorService, Handler object2, CaptureSessionRepository captureSessionRepository, int n10) {
        int n11;
        HashSet<Object> hashSet;
        this.mEnableFeature = hashSet = new HashSet<Object>();
        this.mExecutor = object;
        this.mScheduledExecutorService = scheduledExecutorService;
        this.mCompatHandler = object2;
        this.mCaptureSessionRepository = captureSessionRepository;
        this.mSupportedHardwareLevel = n10;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 23;
        if (n12 < n13) {
            object2 = "force_close";
            hashSet.add(object2);
        }
        if (n10 == (n11 = 2) || n12 <= n13) {
            object = "deferrableSurface_close";
            hashSet.add(object);
        }
        if (n10 == n11) {
            object = "wait_for_request";
            hashSet.add(object);
        }
    }

    public SynchronizedCaptureSessionOpener build() {
        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl;
        Object object = this.mEnableFeature;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            CaptureSessionRepository captureSessionRepository = this.mCaptureSessionRepository;
            Executor executor = this.mExecutor;
            ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutorService;
            Handler handler = this.mCompatHandler;
            SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl = new SynchronizedCaptureSessionBaseImpl(captureSessionRepository, executor, scheduledExecutorService, handler);
            object = new SynchronizedCaptureSessionOpener(synchronizedCaptureSessionBaseImpl);
            return object;
        }
        Set set = this.mEnableFeature;
        CaptureSessionRepository captureSessionRepository = this.mCaptureSessionRepository;
        Executor executor = this.mExecutor;
        ScheduledExecutorService scheduledExecutorService = this.mScheduledExecutorService;
        Handler handler = this.mCompatHandler;
        SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl2 = synchronizedCaptureSessionImpl;
        synchronizedCaptureSessionImpl = new SynchronizedCaptureSessionImpl(set, captureSessionRepository, executor, scheduledExecutorService, handler);
        object = new SynchronizedCaptureSessionOpener(synchronizedCaptureSessionImpl);
        return object;
    }
}

