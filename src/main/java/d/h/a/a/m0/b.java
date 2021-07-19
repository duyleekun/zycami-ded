/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.h.a.a.m0;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;

public final class b
implements Handler.Callback {
    public final /* synthetic */ ConcatenatingMediaSource a;

    public /* synthetic */ b(ConcatenatingMediaSource concatenatingMediaSource) {
        this.a = concatenatingMediaSource;
    }

    public final boolean handleMessage(Message message) {
        return ConcatenatingMediaSource.c(this.a, message);
    }
}

