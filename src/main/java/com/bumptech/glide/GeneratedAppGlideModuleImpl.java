/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package com.bumptech.glide;

import android.content.Context;
import android.util.Log;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.Registry;
import com.zhiyun.cama.ApplicationGlideModule;
import d.c.a.a;
import d.c.a.d;
import d.c.a.n.a.c;
import java.util.Collections;
import java.util.Set;

public final class GeneratedAppGlideModuleImpl
extends GeneratedAppGlideModule {
    private final ApplicationGlideModule a;

    public GeneratedAppGlideModuleImpl(Context object) {
        this.a = object;
        object = "Glide";
        boolean bl2 = Log.isLoggable((String)object, (int)3);
        if (bl2) {
            Log.d((String)object, (String)"Discovered AppGlideModule from annotation: com.zhiyun.cama.ApplicationGlideModule");
            String string2 = "Discovered LibraryGlideModule from annotation: com.bumptech.glide.integration.webp.WebpGlideLibraryModule";
            Log.d((String)object, (String)string2);
        }
    }

    public void a(Context context, d d10) {
        this.a.a(context, d10);
    }

    public void b(Context context, d.c.a.c c10, Registry registry) {
        c c11 = new c();
        c11.b(context, c10, registry);
        this.a.b(context, c10, registry);
    }

    public boolean c() {
        return this.a.c();
    }

    public Set d() {
        return Collections.emptySet();
    }

    public a f() {
        a a10 = new a();
        return a10;
    }
}

