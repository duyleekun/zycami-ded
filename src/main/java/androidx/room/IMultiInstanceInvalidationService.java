/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package androidx.room;

import android.os.IInterface;
import androidx.room.IMultiInstanceInvalidationCallback;

public interface IMultiInstanceInvalidationService
extends IInterface {
    public void broadcastInvalidation(int var1, String[] var2);

    public int registerCallback(IMultiInstanceInvalidationCallback var1, String var2);

    public void unregisterCallback(IMultiInstanceInvalidationCallback var1, int var2);
}

