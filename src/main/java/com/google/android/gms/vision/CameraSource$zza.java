/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.os.SystemClock
 *  android.util.Log
 */
package com.google.android.gms.vision;

import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.Frame$Builder;
import java.nio.ByteBuffer;

public final class CameraSource$zza
implements Runnable {
    private final Object lock;
    private boolean zzaa;
    private long zzab;
    private int zzac;
    private ByteBuffer zzad;
    private final /* synthetic */ CameraSource zzae;
    private Detector zzx;
    private long zzz;

    public CameraSource$zza(CameraSource object, Detector detector) {
        long l10;
        this.zzae = object;
        this.zzz = l10 = SystemClock.elapsedRealtime();
        this.lock = object = new Object();
        this.zzaa = true;
        this.zzac = 0;
        this.zzx = detector;
    }

    public final void release() {
        this.zzx.release();
        this.zzx = null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void run() {
        Throwable throwable2222222;
        Object object;
        Object object2;
        while (true) {
            Object object3;
            Object object4 = this.lock;
            synchronized (object4) {
                boolean bl2;
                while ((bl2 = this.zzaa) && (object2 = this.zzad) == null) {
                    try {
                        object = this.lock;
                        object.wait();
                    }
                    catch (InterruptedException interruptedException) {
                        object2 = "CameraSource";
                        object3 = "Frame processing loop terminated.";
                        Log.d((String)object2, (String)object3, (Throwable)interruptedException);
                        return;
                    }
                }
                if (!bl2) {
                    return;
                }
                object = new Frame$Builder();
                object2 = this.zzad;
                object3 = this.zzae;
                object3 = CameraSource.zzf((CameraSource)object3);
                int n10 = ((Size)object3).getWidth();
                Object object5 = this.zzae;
                object5 = CameraSource.zzf((CameraSource)object5);
                int n11 = ((Size)object5).getHeight();
                int n12 = 17;
                object = ((Frame$Builder)object).setImageData((ByteBuffer)object2, n10, n11, n12);
                int n13 = this.zzac;
                object = ((Frame$Builder)object).setId(n13);
                long l10 = this.zzab;
                object = ((Frame$Builder)object).setTimestampMillis(l10);
                object2 = this.zzae;
                n13 = CameraSource.zze((CameraSource)object2);
                object = ((Frame$Builder)object).setRotation(n13);
                object = ((Frame$Builder)object).build();
                object2 = this.zzad;
                n10 = 0;
                object3 = null;
                this.zzad = null;
            }
            object4 = this.zzx;
            ((Detector)object4).receiveFrame((Frame)object);
            {
                catch (Throwable throwable2222222) {
                    break;
                }
                catch (Exception exception) {}
                object = "CameraSource";
                object3 = "Exception thrown from receiver.";
                {
                    Log.e((String)object, (String)object3, (Throwable)exception);
                }
                object4 = CameraSource.zzb(this.zzae);
                object = ((ByteBuffer)object2).array();
                object4.addCallbackBuffer((byte[])object);
                continue;
            }
            object4 = CameraSource.zzb(this.zzae);
            object = ((ByteBuffer)object2).array();
            object4.addCallbackBuffer((byte[])object);
        }
        object = CameraSource.zzb(this.zzae);
        object2 = ((ByteBuffer)object2).array();
        object.addCallbackBuffer((byte[])object2);
        throw throwable2222222;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void setActive(boolean bl2) {
        Object object = this.lock;
        synchronized (object) {
            this.zzaa = bl2;
            Object object2 = this.lock;
            object2.notifyAll();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void zza(byte[] object, Camera object2) {
        Object object3 = this.lock;
        synchronized (object3) {
            int n10;
            Object object4 = this.zzad;
            if (object4 != null) {
                object4 = ((ByteBuffer)object4).array();
                object2.addCallbackBuffer((byte[])object4);
                n10 = 0;
                object2 = null;
                this.zzad = null;
            }
            object2 = this.zzae;
            n10 = (object2 = CameraSource.zzd((CameraSource)object2)).containsKey(object);
            if (n10 == 0) {
                object = "CameraSource";
                object2 = "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.";
                Log.d((String)object, (String)object2);
                return;
            }
            long l10 = SystemClock.elapsedRealtime();
            long l11 = this.zzz;
            this.zzab = l10 -= l11;
            this.zzac = n10 = this.zzac + 1;
            object2 = this.zzae;
            object2 = CameraSource.zzd((CameraSource)object2);
            object = object2.get(object);
            object = (ByteBuffer)object;
            this.zzad = object;
            object = this.lock;
            object.notifyAll();
            return;
        }
    }
}

