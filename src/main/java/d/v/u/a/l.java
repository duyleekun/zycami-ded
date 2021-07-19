/*
 * Decompiled with CFR 0.151.
 */
package d.v.u.a;

import androidx.arch.core.util.Function;
import com.zhiyun.net.download.DownLoadHelper;

public final class l
implements Runnable {
    public final /* synthetic */ Function a;

    public /* synthetic */ l(Function function) {
        this.a = function;
    }

    public final void run() {
        DownLoadHelper.g(this.a);
    }
}

