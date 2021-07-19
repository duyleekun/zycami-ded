/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons.utag;

import android.os.Handler;
import android.os.Message;
import com.mob.commons.b;
import com.mob.commons.utag.UserTagError;
import com.mob.commons.utag.UserTager;
import java.util.HashMap;

public final class UserTager$1
implements Handler.Callback {
    public boolean handleMessage(Message object) {
        int n10 = b.Z();
        if (n10 == 0) {
            n10 = object.what;
            int n11 = 1;
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    object = (Object[])object.obj;
                    HashMap hashMap = (HashMap)object[0];
                    object = (UserTagError)object[n11];
                    UserTager.a(hashMap, (UserTagError)object);
                    UserTager.a();
                }
            } else {
                boolean bl2 = UserTager.b();
                if (!bl2) {
                    UserTager.a();
                }
            }
        }
        return false;
    }
}

