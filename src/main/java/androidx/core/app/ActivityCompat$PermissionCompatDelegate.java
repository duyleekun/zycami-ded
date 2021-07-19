/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Intent
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Intent;

public interface ActivityCompat$PermissionCompatDelegate {
    public boolean onActivityResult(Activity var1, int var2, int var3, Intent var4);

    public boolean requestPermissions(Activity var1, String[] var2, int var3);
}

