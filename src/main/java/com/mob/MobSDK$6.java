/*
 * Decompiled with CFR 0.151.
 */
package com.mob;

import com.mob.MobUser;
import com.mob.MobUser$OnUserGotListener;

public final class MobSDK$6
implements MobUser$OnUserGotListener {
    public final /* synthetic */ MobUser$OnUserGotListener a;

    public MobSDK$6(MobUser$OnUserGotListener mobUser$OnUserGotListener) {
        this.a = mobUser$OnUserGotListener;
    }

    public void onUserGot(MobUser mobUser) {
        MobUser$OnUserGotListener mobUser$OnUserGotListener = this.a;
        if (mobUser$OnUserGotListener != null) {
            String string2 = mobUser.getMobUserId();
            if (string2 == null) {
                mobUser = null;
            }
            mobUser$OnUserGotListener.onUserGot(mobUser);
        }
    }
}

