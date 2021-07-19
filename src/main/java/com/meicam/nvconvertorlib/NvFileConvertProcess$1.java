/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.meicam.nvconvertorlib;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.meicam.nvconvertorlib.Logger;
import com.meicam.nvconvertorlib.NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo;
import com.meicam.nvconvertorlib.NvFileConvertProcess;
import com.meicam.nvconvertorlib.NvFileConvertProcess$NvFileConvertProgressNotify;

public class NvFileConvertProcess$1
extends Handler {
    public final /* synthetic */ NvFileConvertProcess this$0;

    public NvFileConvertProcess$1(NvFileConvertProcess nvFileConvertProcess, Looper looper) {
        this.this$0 = nvFileConvertProcess;
        super(looper);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void handleMessage(Message object) {
        int n10 = ((Message)object).what;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 == n11) {
                NvFileConvertProcess$NvFileConvertProgressNotify nvFileConvertProcess$NvFileConvertProgressNotify = this.this$0.m_progressNotify;
                if (nvFileConvertProcess$NvFileConvertProgressNotify == null) return;
                int n12 = ((Message)object).arg1;
                nvFileConvertProcess$NvFileConvertProgressNotify.convertProgress(n12);
                return;
            }
            n11 = 2;
            if (n10 != n11) {
                int n13 = 3;
                if (n10 == n13) return;
                object = "NvFileConvertProcess";
                String string2 = "Invalid message";
                Logger.e((String)object, string2);
                return;
            }
            Object object2 = "handleMessage: MSG_CONVERT_REVERSE_CONTINUE1111";
            Logger.e("NvFileConvertProcess", object2);
            Object object3 = this.this$0.m_reverseContinue;
            synchronized (object3) {
                object = ((Message)object).obj;
                if (object == null) {
                    object = this.this$0;
                    long l10 = -1;
                    NvFileConvertProcess.access$102((NvFileConvertProcess)object, l10);
                } else {
                    object = (NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo)object;
                    object2 = this.this$0;
                    long l11 = ((NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo)object).startTime;
                    NvFileConvertProcess.access$102((NvFileConvertProcess)object2, l11);
                    object2 = this.this$0;
                    l11 = ((NvAndroidSurfaceFileWriterVideoWorker$ReverseInfo)object).endTime;
                    NvFileConvertProcess.access$202((NvFileConvertProcess)object2, l11);
                }
                object = "NvFileConvertProcess";
                object2 = "handleMessage: MSG_CONVERT_REVERSE_CONTINUE2222";
                Logger.e((String)object, object2);
                object = this.this$0;
                object = ((NvFileConvertProcess)object).m_reverseContinue;
                object.notifyAll();
                return;
            }
        }
        object = "NvFileConvertProcess";
        Object object4 = this.this$0.m_completeNotify;
        if (object4 == null) {
            n11 = 0;
            Object var6_11 = null;
        }
        object4 = n11 != 0;
        Logger.e((String)object, object4);
        object = this.this$0;
        object4 = ((NvFileConvertProcess)object).m_completeNotify;
        if (object4 == null) return;
        object = NvFileConvertProcess.access$000((NvFileConvertProcess)object);
        object4.convertComplete((String)object);
    }
}

