/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;

public class DisabledBreadcrumbSource
implements BreadcrumbSource {
    public void registerBreadcrumbHandler(BreadcrumbHandler breadcrumbHandler) {
        Logger.getLogger().d("Could not register handler for breadcrumbs events.");
    }
}

