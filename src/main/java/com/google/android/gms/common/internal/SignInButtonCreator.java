/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.view.View
 */
package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.internal.ISignInButtonCreator;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.common.internal.zah;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException;

public final class SignInButtonCreator
extends RemoteCreator {
    private static final SignInButtonCreator zapf;

    static {
        SignInButtonCreator signInButtonCreator;
        zapf = signInButtonCreator = new SignInButtonCreator();
    }

    private SignInButtonCreator() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View createView(Context context, int n10, int n11) {
        return zapf.zaa(context, n10, n11);
    }

    private final View zaa(Context object, int n10, int n11) {
        Object object2;
        IObjectWrapper iObjectWrapper = null;
        try {
            object2 = new SignInButtonConfig(n10, n11, null);
            iObjectWrapper = ObjectWrapper.wrap(object);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("Could not get button with size ");
            stringBuilder.append(n10);
            stringBuilder.append(" and color ");
            stringBuilder.append(n11);
            String string2 = stringBuilder.toString();
            object2 = new RemoteCreator$RemoteCreatorException(string2, exception);
            throw object2;
        }
        object = this.getRemoteCreatorInstance((Context)object);
        object = (ISignInButtonCreator)object;
        object = object.newSignInButtonFromConfig(iObjectWrapper, (SignInButtonConfig)object2);
        object = ObjectWrapper.unwrap((IObjectWrapper)object);
        return (View)object;
    }

    public final ISignInButtonCreator getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        boolean bl2 = iInterface instanceof ISignInButtonCreator;
        if (bl2) {
            return (ISignInButtonCreator)iInterface;
        }
        iInterface = new zah(iBinder);
        return iInterface;
    }
}

