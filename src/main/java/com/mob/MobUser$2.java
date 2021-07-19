/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob;

import android.os.Handler;
import android.os.Message;
import com.mob.MobUser;
import com.mob.MobUser$OnUserGotListener;

public final class MobUser$2
implements Handler.Callback {
    public final /* synthetic */ MobUser$OnUserGotListener a;

    public MobUser$2(MobUser$OnUserGotListener mobUser$OnUserGotListener) {
        this.a = mobUser$OnUserGotListener;
    }

    public boolean handleMessage(Message object) {
        object = this.a;
        MobUser mobUser = MobUser.c();
        object.onUserGot(mobUser);
        return false;
    }
}

