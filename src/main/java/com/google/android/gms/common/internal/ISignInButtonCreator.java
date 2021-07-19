/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package com.google.android.gms.common.internal;

import android.os.IInterface;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface ISignInButtonCreator
extends IInterface {
    public IObjectWrapper newSignInButton(IObjectWrapper var1, int var2, int var3);

    public IObjectWrapper newSignInButtonFromConfig(IObjectWrapper var1, SignInButtonConfig var2);
}

