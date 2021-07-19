/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.k0;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.offline.DownloadHelper;

public final class a
implements MetadataOutput {
    public static final /* synthetic */ a a;

    static {
        a a10;
        a = a10 = new a();
    }

    public final void onMetadata(Metadata metadata) {
        DownloadHelper.b(metadata);
    }
}

