/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.gui.BitmapProcessor;
import com.mob.tools.gui.BitmapProcessor$ManagerThread;
import com.mob.tools.gui.BitmapProcessor$WorkerThread;

public class BitmapProcessor$ManagerThread$1
implements Runnable {
    public final /* synthetic */ BitmapProcessor.ManagerThread this$0;

    public BitmapProcessor$ManagerThread$1(BitmapProcessor.ManagerThread managerThread) {
        this.this$0 = managerThread;
    }

    public void run() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((BitmapProcessor$WorkerThread[])(object = BitmapProcessor.access$700())).length); ++i10) {
            boolean bl2;
            object = BitmapProcessor.access$700()[i10];
            if (object != null) continue;
            object = BitmapProcessor.access$700();
            Object object2 = new BitmapProcessor$WorkerThread(null);
            object[i10] = object2;
            object = BitmapProcessor.access$700()[i10];
            object2 = new StringBuilder();
            String string2 = "worker ";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(i10);
            object2 = ((StringBuilder)object2).toString();
            ((Thread)object).setName((String)object2);
            object = BitmapProcessor.access$700()[i10];
            if (i10 == 0) {
                bl2 = true;
            } else {
                bl2 = false;
                object2 = null;
            }
            BitmapProcessor$WorkerThread.access$902((BitmapProcessor$WorkerThread)object, bl2);
            object = BitmapProcessor.access$700()[i10];
            ((Thread)object).start();
        }
    }
}

