/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVFile;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class AVFile$5
implements Callable {
    public final /* synthetic */ AVFile this$0;

    public AVFile$5(AVFile aVFile) {
        this.this$0 = aVFile;
    }

    public InputStream call() {
        return this.this$0.getDataStream();
    }
}

