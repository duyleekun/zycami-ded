/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.h.a.a.r0;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.util.ListenerSet;

public final class b
implements Handler.Callback {
    public final /* synthetic */ ListenerSet a;

    public /* synthetic */ b(ListenerSet listenerSet) {
        this.a = listenerSet;
    }

    public final boolean handleMessage(Message message) {
        return ListenerSet.a(this.a, message);
    }
}

