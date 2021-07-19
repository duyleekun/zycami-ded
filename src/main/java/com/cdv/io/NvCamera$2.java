/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Camera
 *  android.util.Log
 */
package com.cdv.io;

import android.hardware.Camera;
import android.util.Log;
import com.cdv.io.NvCamera$CameraOpenParam;

public class NvCamera$2
implements Runnable {
    public final /* synthetic */ int val$cameraId;
    public final /* synthetic */ NvCamera$CameraOpenParam val$param;

    public NvCamera$2(NvCamera$CameraOpenParam cameraOpenParam, int n10) {
        this.val$param = cameraOpenParam;
        this.val$cameraId = n10;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        var1_1 = this.val$param;
        var2_4 = this.val$cameraId;
        var1_1.m_cam = var3_5 = Camera.open((int)var2_4);
        var1_1 = this.val$param.m_semaphore;
        var1_1.release();
        return;
        {
            catch (Exception var1_3) {}
            var3_6 = "CDV Camera";
            {
                var4_7 /* !! */  = new StringBuilder();
                var5_8 = "";
                var4_7 /* !! */ .append(var5_8);
                var5_8 = var1_3.getMessage();
                var4_7 /* !! */ .append(var5_8);
                var4_7 /* !! */  = var4_7 /* !! */ .toString();
                Log.e((String)var3_6, (String)var4_7 /* !! */ );
                var1_3.printStackTrace();
            }
        }
        ** finally { 
lbl22:
        // 1 sources

        this.val$param.m_semaphore.release();
        throw var1_2;
    }
}

