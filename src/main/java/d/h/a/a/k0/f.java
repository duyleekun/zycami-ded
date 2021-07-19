/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.text.TextOutput;
import java.util.List;

public final class f
implements TextOutput {
    public static final /* synthetic */ f a;

    static {
        f f10;
        a = f10 = new f();
    }

    public final void onCues(List list) {
        DownloadHelper.a(list);
    }
}

