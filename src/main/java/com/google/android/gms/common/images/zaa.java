/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 */
package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.zab;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

public abstract class zaa {
    public final zab zamv;
    private int zamw = 0;
    public int zamx = 0;
    private boolean zamy = false;
    private boolean zamz;
    private boolean zana;
    private boolean zanb;

    public zaa(Uri uri, int n10) {
        zab zab2;
        boolean bl2;
        this.zamz = bl2 = true;
        this.zana = false;
        this.zanb = bl2;
        this.zamv = zab2 = new zab(uri);
        this.zamx = n10;
    }

    public final void zaa(Context context, Bitmap bitmap, boolean bl2) {
        Asserts.checkNotNull(bitmap);
        context = context.getResources();
        BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources)context, bitmap);
        this.zaa((Drawable)bitmapDrawable, bl2, false, true);
    }

    public final void zaa(Context context, zak zak2) {
        boolean bl2 = this.zanb;
        if (bl2) {
            bl2 = false;
            boolean bl3 = true;
            this.zaa(null, false, bl3, false);
        }
    }

    public final void zaa(Context object, zak zak2, boolean bl2) {
        int n10 = this.zamx;
        object = n10 != 0 ? object.getResources().getDrawable(n10) : null;
        this.zaa((Drawable)object, bl2, false, false);
    }

    public abstract void zaa(Drawable var1, boolean var2, boolean var3, boolean var4);

    public final boolean zaa(boolean bl2, boolean bl3) {
        boolean bl4 = this.zamz;
        return bl4 && !bl3 && !bl2;
    }
}

