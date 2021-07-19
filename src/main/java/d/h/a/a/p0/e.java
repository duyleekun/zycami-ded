/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package d.h.a.a.p0;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ui.PlayerNotificationManager;

public final class e
implements Handler.Callback {
    public final /* synthetic */ PlayerNotificationManager a;

    public /* synthetic */ e(PlayerNotificationManager playerNotificationManager) {
        this.a = playerNotificationManager;
    }

    public final boolean handleMessage(Message message) {
        return PlayerNotificationManager.a(this.a, message);
    }
}

