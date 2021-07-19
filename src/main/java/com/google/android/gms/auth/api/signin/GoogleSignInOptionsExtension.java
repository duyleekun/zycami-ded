/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import java.util.List;

public interface GoogleSignInOptionsExtension {
    public static final int FITNESS = 3;
    public static final int GAMES = 1;

    public int getExtensionType();

    public List getImpliedScopes();

    public Bundle toBundle();
}

