/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.breadcrumbs;

import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;

public interface BreadcrumbSource {
    public void registerBreadcrumbHandler(BreadcrumbHandler var1);
}

