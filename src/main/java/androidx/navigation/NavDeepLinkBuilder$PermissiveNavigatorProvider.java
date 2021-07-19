/*
 * Decompiled with CFR 0.151.
 */
package androidx.navigation;

import androidx.navigation.NavDeepLinkBuilder$PermissiveNavigatorProvider$1;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;

public class NavDeepLinkBuilder$PermissiveNavigatorProvider
extends NavigatorProvider {
    private final Navigator mDestNavigator;

    public NavDeepLinkBuilder$PermissiveNavigatorProvider() {
        Navigator navigator = new NavDeepLinkBuilder$PermissiveNavigatorProvider$1(this);
        this.mDestNavigator = navigator;
        super(this);
        this.addNavigator(navigator);
    }

    public Navigator getNavigator(String string2) {
        try {
            return super.getNavigator(string2);
        }
        catch (IllegalStateException illegalStateException) {
            return this.mDestNavigator;
        }
    }
}

