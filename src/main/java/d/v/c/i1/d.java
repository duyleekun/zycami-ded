/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package d.v.c.i1;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.NavController$OnDestinationChangedListener;
import androidx.navigation.NavDestination;
import com.zhiyun.cama.main.EditorMainActivity;

public final class d
implements NavController$OnDestinationChangedListener {
    public final /* synthetic */ EditorMainActivity a;

    public /* synthetic */ d(EditorMainActivity editorMainActivity) {
        this.a = editorMainActivity;
    }

    public final void onDestinationChanged(NavController navController, NavDestination navDestination, Bundle bundle) {
        this.a.v(navController, navDestination, bundle);
    }
}

