/*
 * Decompiled with CFR 0.151.
 */
package f.d2;

import kotlin.DeprecationLevel;
import kotlin.internal.RequireKotlinVersionKind;

public @interface o {
    public int errorCode();

    public DeprecationLevel level();

    public String message();

    public String version();

    public RequireKotlinVersionKind versionKind();
}

