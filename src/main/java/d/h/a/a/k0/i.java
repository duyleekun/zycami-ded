/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.offline.Download;
import com.google.android.exoplayer2.offline.DownloadManager$InternalHandler;
import java.util.Comparator;

public final class i
implements Comparator {
    public static final /* synthetic */ i a;

    static {
        i i10;
        a = i10 = new i();
    }

    public final int compare(Object object, Object object2) {
        object = (Download)object;
        object2 = (Download)object2;
        return DownloadManager$InternalHandler.a((Download)object, (Download)object2);
    }
}

