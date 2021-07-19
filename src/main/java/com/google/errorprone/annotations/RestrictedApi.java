/*
 * Decompiled with CFR 0.151.
 */
package com.google.errorprone.annotations;

public @interface RestrictedApi {
    public String allowedOnPath();

    public String checkerName();

    public String explanation();

    public String link();

    public Class[] whitelistAnnotations();

    public Class[] whitelistWithWarningAnnotations();
}

