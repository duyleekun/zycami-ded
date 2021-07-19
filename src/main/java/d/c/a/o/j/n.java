/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetManager
 */
package d.c.a.o.j;

import android.content.res.AssetManager;
import d.c.a.o.j.b;
import java.io.InputStream;

public class n
extends b {
    public n(AssetManager assetManager, String string2) {
        super(assetManager, string2);
    }

    public Class a() {
        return InputStream.class;
    }

    public void f(InputStream inputStream) {
        inputStream.close();
    }

    public InputStream g(AssetManager assetManager, String string2) {
        return assetManager.open(string2);
    }
}

