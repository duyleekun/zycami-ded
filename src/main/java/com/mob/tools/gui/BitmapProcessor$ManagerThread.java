/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.gui;

import android.os.Handler;
import android.os.Message;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.gui.BitmapProcessor$ManagerThread$1;
import com.mob.tools.gui.BitmapProcessor$WorkerThread;
import com.mob.tools.gui.CachePool;
import com.mob.tools.log.NLog;
import java.util.ArrayList;

public class BitmapProcessor$ManagerThread
implements Handler.Callback {
    private Handler handler;

    public BitmapProcessor$ManagerThread() {
        BitmapProcessor$ManagerThread$1 bitmapProcessor$ManagerThread$1 = new BitmapProcessor$ManagerThread$1(this);
        bitmapProcessor$ManagerThread$1 = MobHandlerThread.newHandler(bitmapProcessor$ManagerThread$1, (Handler.Callback)this);
        this.handler = bitmapProcessor$ManagerThread$1;
        bitmapProcessor$ManagerThread$1.sendEmptyMessageDelayed(1, 20000L);
    }

    public boolean handleMessage(Message object) {
        int n10;
        long l10;
        object = BitmapProcessor.access$1000();
        if (object != null) {
            object = BitmapProcessor.access$1000();
            long l11 = System.currentTimeMillis();
            l10 = 60000L;
            ((CachePool)object).trimBeforeTime(l11 -= l10);
        }
        if ((object = BitmapProcessor.access$1000()) == null) {
            n10 = 0;
            object = null;
        } else {
            object = BitmapProcessor.access$1000();
            n10 = ((CachePool)object).size();
        }
        NLog nLog = MobLog.getInstance();
        Object object2 = new StringBuilder();
        String string2 = ">>>> BitmapProcessor.cachePool: ";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n10);
        object = ((StringBuilder)object2).toString();
        object2 = new Object[]{};
        nLog.d(object, (Object[])object2);
        object = BitmapProcessor.access$1100();
        if (object == null) {
            n10 = 0;
            object = null;
        } else {
            object = BitmapProcessor.access$1100();
            n10 = ((ArrayList)object).size();
        }
        nLog = MobLog.getInstance();
        object2 = new StringBuilder();
        string2 = ">>>> BitmapProcessor.reqList: ";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(n10);
        object = ((StringBuilder)object2).toString();
        object2 = new Object[]{};
        nLog.d(object, (Object[])object2);
        n10 = (int)(BitmapProcessor.access$1200() ? 1 : 0);
        if (n10 != 0) {
            object = this.handler;
            int n11 = 1;
            l10 = 20000L;
            object.sendEmptyMessageDelayed(n11, l10);
        }
        return false;
    }

    public void quit() {
        Object object;
        Handler handler = this.handler;
        int n10 = 1;
        handler.removeMessages(n10);
        this.handler.getLooper().quit();
        handler = null;
        for (int i10 = 0; i10 < (n10 = ((BitmapProcessor$WorkerThread[])(object = BitmapProcessor.access$700())).length); ++i10) {
            object = BitmapProcessor.access$700()[i10];
            if (object == null) continue;
            BitmapProcessor.access$700()[i10].interrupt();
            object = BitmapProcessor.access$700();
            object[i10] = null;
        }
    }
}

