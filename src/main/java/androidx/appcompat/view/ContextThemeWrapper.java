/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.LayoutInflater
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

public class ContextThemeWrapper
extends ContextWrapper {
    private LayoutInflater mInflater;
    private Configuration mOverrideConfiguration;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResource;

    public ContextThemeWrapper() {
        super(null);
    }

    public ContextThemeWrapper(Context context, int n10) {
        super(context);
        this.mThemeResource = n10;
    }

    public ContextThemeWrapper(Context context, Resources.Theme theme) {
        super(context);
        this.mTheme = theme;
    }

    private Resources getResourcesInternal() {
        Resources resources = this.mResources;
        if (resources == null) {
            resources = this.mOverrideConfiguration;
            if (resources == null) {
                this.mResources = resources = super.getResources();
            } else {
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 17;
                if (n10 >= n11) {
                    this.mResources = resources = this.createConfigurationContext((Configuration)resources).getResources();
                } else {
                    resources = super.getResources();
                    Configuration configuration = resources.getConfiguration();
                    Configuration configuration2 = new Configuration(configuration);
                    configuration = this.mOverrideConfiguration;
                    configuration2.updateFrom(configuration);
                    AssetManager assetManager = resources.getAssets();
                    resources = resources.getDisplayMetrics();
                    configuration = new Resources(assetManager, (DisplayMetrics)resources, configuration2);
                    this.mResources = configuration;
                }
            }
        }
        return this.mResources;
    }

    private void initializeTheme() {
        Resources.Theme theme;
        boolean bl2;
        Resources.Theme theme2 = this.mTheme;
        if (theme2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            theme2 = null;
        }
        if (bl2) {
            this.mTheme = theme = this.getResources().newTheme();
            theme = this.getBaseContext().getTheme();
            if (theme != null) {
                Resources.Theme theme3 = this.mTheme;
                theme3.setTo(theme);
            }
        }
        theme = this.mTheme;
        int n10 = this.mThemeResource;
        this.onApplyThemeResource(theme, n10, bl2);
    }

    public void applyOverrideConfiguration(Configuration object) {
        Resources resources = this.mResources;
        if (resources == null) {
            resources = this.mOverrideConfiguration;
            if (resources == null) {
                resources = new Configuration(object);
                this.mOverrideConfiguration = resources;
                return;
            }
            object = new IllegalStateException("Override configuration has already been set");
            throw object;
        }
        object = new IllegalStateException("getResources() or getAssets() has already been called");
        throw object;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    public Resources getResources() {
        return this.getResourcesInternal();
    }

    public Object getSystemService(String string2) {
        String string3 = "layout_inflater";
        boolean bl2 = string3.equals(string2);
        if (bl2) {
            string2 = this.mInflater;
            if (string2 == null) {
                string2 = LayoutInflater.from((Context)this.getBaseContext()).cloneInContext((Context)this);
                this.mInflater = string2;
            }
            return this.mInflater;
        }
        return this.getBaseContext().getSystemService(string2);
    }

    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme != null) {
            return theme;
        }
        int n10 = this.mThemeResource;
        if (n10 == 0) {
            this.mThemeResource = n10 = R$style.Theme_AppCompat_Light;
        }
        this.initializeTheme();
        return this.mTheme;
    }

    public int getThemeResId() {
        return this.mThemeResource;
    }

    public void onApplyThemeResource(Resources.Theme theme, int n10, boolean bl2) {
        theme.applyStyle(n10, true);
    }

    public void setTheme(int n10) {
        int n11 = this.mThemeResource;
        if (n11 != n10) {
            this.mThemeResource = n10;
            this.initializeTheme();
        }
    }
}

