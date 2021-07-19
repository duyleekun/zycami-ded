/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 */
package com.google.android.exoplayer2.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.GlUtil;
import com.google.android.exoplayer2.video.DummySurface$1;
import com.google.android.exoplayer2.video.DummySurface$DummySurfaceThread;

public final class DummySurface
extends Surface {
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurface$DummySurfaceThread thread;
    private boolean threadReleased;

    private DummySurface(DummySurface$DummySurfaceThread dummySurface$DummySurfaceThread, SurfaceTexture surfaceTexture, boolean bl2) {
        super(surfaceTexture);
        this.thread = dummySurface$DummySurfaceThread;
        this.secure = bl2;
    }

    public /* synthetic */ DummySurface(DummySurface$DummySurfaceThread dummySurface$DummySurfaceThread, SurfaceTexture surfaceTexture, boolean bl2, DummySurface$1 dummySurface$1) {
        this(dummySurface$DummySurfaceThread, surfaceTexture, bl2);
    }

    private static int getSecureMode(Context context) {
        boolean bl2 = GlUtil.isProtectedContentExtensionSupported(context);
        if (bl2) {
            bl2 = GlUtil.isSurfacelessContextExtensionSupported();
            if (bl2) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isSecureSupported(Context context) {
        Class<DummySurface> clazz = DummySurface.class;
        synchronized (clazz) {
            int n10;
            boolean bl2 = secureModeInitialized;
            boolean bl3 = true;
            if (!bl2) {
                secureMode = n10 = DummySurface.getSecureMode(context);
                secureModeInitialized = bl3;
            }
            if ((n10 = secureMode) == 0) return false;
            return bl3;
        }
    }

    public static DummySurface newInstanceV17(Context object, boolean bl2) {
        boolean bl3;
        int n10 = 0;
        if (bl2 && !(bl3 = DummySurface.isSecureSupported((Context)object))) {
            bl3 = false;
            object = null;
        } else {
            bl3 = true;
        }
        Assertions.checkState(bl3);
        object = new DummySurface$DummySurfaceThread();
        if (bl2) {
            n10 = secureMode;
        }
        return ((DummySurface$DummySurfaceThread)((Object)object)).init(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        super.release();
        DummySurface$DummySurfaceThread dummySurface$DummySurfaceThread = this.thread;
        synchronized (dummySurface$DummySurfaceThread) {
            boolean bl2 = this.threadReleased;
            if (!bl2) {
                DummySurface$DummySurfaceThread dummySurface$DummySurfaceThread2 = this.thread;
                dummySurface$DummySurfaceThread2.release();
                this.threadReleased = bl2 = true;
            }
            return;
        }
    }
}

