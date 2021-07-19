/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package com.google.android.gms.flags;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzc
extends IInterface {
    public boolean getBooleanFlagValue(String var1, boolean var2, int var3);

    public int getIntFlagValue(String var1, int var2, int var3);

    public long getLongFlagValue(String var1, long var2, int var4);

    public String getStringFlagValue(String var1, String var2, int var3);

    public void init(IObjectWrapper var1);
}

