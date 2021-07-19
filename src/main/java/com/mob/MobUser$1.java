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
import java.util.HashMap;

public final class MobUser$1
implements Handler.Callback {
    public boolean handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 3;
        int n12 = 2;
        int n13 = 1;
        if (n10 != n13) {
            if (n10 != n12) {
                if (n10 == n11) {
                    MobUser.b();
                }
            } else {
                object = (MobUser$OnUserGotListener)object.obj;
                MobUser.b((MobUser$OnUserGotListener)object);
            }
        } else {
            object = (Object[])object.obj;
            String string2 = (String)object[0];
            String string3 = (String)object[n13];
            String string4 = (String)object[n12];
            HashMap hashMap = (HashMap)object[n11];
            int n14 = 4;
            object = (String)object[n14];
            MobUser.b(string2, string3, string4, hashMap, (String)object);
        }
        return false;
    }
}

