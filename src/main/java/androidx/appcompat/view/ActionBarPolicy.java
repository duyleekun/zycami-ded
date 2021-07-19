/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build$VERSION
 *  android.view.ViewConfiguration
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.ViewConfiguration;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$bool;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$styleable;

public class ActionBarPolicy {
    private Context mContext;

    private ActionBarPolicy(Context context) {
        this.mContext = context;
    }

    public static ActionBarPolicy get(Context context) {
        ActionBarPolicy actionBarPolicy = new ActionBarPolicy(context);
        return actionBarPolicy;
    }

    public boolean enableHomeButtonByDefault() {
        ApplicationInfo applicationInfo = this.mContext.getApplicationInfo();
        int n10 = applicationInfo.targetSdkVersion;
        int n11 = 14;
        if (n10 < n11) {
            n10 = 1;
        } else {
            n10 = 0;
            applicationInfo = null;
        }
        return n10 != 0;
    }

    public int getEmbeddedMenuWidthLimit() {
        return this.mContext.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int getMaxActionButtons() {
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int n10 = configuration.screenWidthDp;
        int n11 = configuration.screenHeightDp;
        int n12 = configuration.smallestScreenWidthDp;
        int n13 = 600;
        if (n12 <= n13 && n10 <= n13) {
            n12 = 720;
            n13 = 960;
            if (!(n10 > n13 && n11 > n12 || n10 > n12 && n11 > n13)) {
                n12 = 500;
                if (n10 < n12) {
                    n12 = 480;
                    n13 = 640;
                    if (!(n10 > n13 && n11 > n12 || n10 > n12 && n11 > n13)) {
                        n12 = 360;
                        if (n10 >= n12) {
                            return 3;
                        }
                        return 2;
                    }
                }
                return 4;
            }
        }
        return 5;
    }

    public int getStackedTabMaxWidth() {
        Resources resources = this.mContext.getResources();
        int n10 = R$dimen.abc_action_bar_stacked_tab_max_width;
        return resources.getDimensionPixelSize(n10);
    }

    public int getTabContainerHeight() {
        Context context = this.mContext;
        int[] nArray = R$styleable.ActionBar;
        int n10 = R$attr.actionBarStyle;
        context = context.obtainStyledAttributes(null, nArray, n10, 0);
        int n11 = R$styleable.ActionBar_height;
        n11 = context.getLayoutDimension(n11, 0);
        Resources resources = this.mContext.getResources();
        int n12 = this.hasEmbeddedTabs();
        if (n12 == 0) {
            n12 = R$dimen.abc_action_bar_stacked_max_height;
            n10 = resources.getDimensionPixelSize(n12);
            n11 = Math.min(n11, n10);
        }
        context.recycle();
        return n11;
    }

    public boolean hasEmbeddedTabs() {
        Resources resources = this.mContext.getResources();
        int n10 = R$bool.abc_action_bar_embed_tabs;
        return resources.getBoolean(n10);
    }

    public boolean showsOverflowMenuButton() {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 19;
        if (n10 >= n11) {
            return bl2;
        }
        return ViewConfiguration.get((Context)this.mContext).hasPermanentMenuKey() ^ bl2;
    }
}

