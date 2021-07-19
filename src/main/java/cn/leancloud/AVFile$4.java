/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVFile;
import java.util.concurrent.Callable;

public class AVFile$4
implements Callable {
    public final /* synthetic */ AVFile this$0;

    public AVFile$4(AVFile aVFile) {
        this.this$0 = aVFile;
    }

    public byte[] call() {
        return this.this$0.getData();
    }
}

