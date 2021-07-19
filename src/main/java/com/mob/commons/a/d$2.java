/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.commons.a;

import android.os.Handler;
import android.os.Message;
import com.mob.commons.d;
import com.mob.commons.k;
import com.mob.tools.utils.ReflectHelper;

public final class d$2
implements Handler.Callback {
    public final /* synthetic */ Object a;
    public final /* synthetic */ String b;

    public d$2(Object object, String string2) {
        this.a = object;
        this.b = string2;
    }

    public boolean handleMessage(Message message) {
        Object object = d.a();
        int n10 = 16;
        ((d)object).a(n10);
        object = this.a;
        n10 = 13;
        Object object2 = k.a(n10);
        int n11 = 2;
        Object[] objectArray = new Object[n11];
        int n12 = 0;
        objectArray[0] = null;
        n12 = 1;
        Object[] objectArray2 = new Object[n12];
        String string2 = this.b;
        objectArray2[0] = string2;
        objectArray[n12] = objectArray2;
        ReflectHelper.invokeInstanceMethod(object, (String)object2, objectArray);
        object = d.a();
        n10 = 17;
        try {
            ((d)object).a(n10);
        }
        catch (Throwable throwable) {
            object2 = d.a();
            n11 = 7;
            ((d)object2).a(n11, throwable);
        }
        return false;
    }
}

