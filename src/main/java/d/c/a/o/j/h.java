/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 *  android.os.ParcelFileDescriptor
 */
package d.c.a.o.j;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import d.c.a.o.j.b;

public class h
extends b {
    public h(AssetManager assetManager, String string2) {
        super(assetManager, string2);
    }

    public Class a() {
        return ParcelFileDescriptor.class;
    }

    public void f(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    public ParcelFileDescriptor g(AssetManager assetManager, String string2) {
        return assetManager.openFd(string2).getParcelFileDescriptor();
    }
}

