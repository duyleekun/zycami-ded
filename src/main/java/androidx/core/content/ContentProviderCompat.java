/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentProvider
 *  android.content.Context
 */
package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;

public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    public static Context requireContext(ContentProvider object) {
        if ((object = object.getContext()) != null) {
            return object;
        }
        object = new IllegalStateException("Cannot find context from the provider.");
        throw object;
    }
}

