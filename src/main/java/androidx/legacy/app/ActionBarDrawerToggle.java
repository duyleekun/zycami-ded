/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.MenuItem
 *  android.view.View
 *  android.widget.ImageView
 */
package androidx.legacy.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.drawerlayout.widget.DrawerLayout$DrawerListener;
import androidx.legacy.app.ActionBarDrawerToggle$Delegate;
import androidx.legacy.app.ActionBarDrawerToggle$DelegateProvider;
import androidx.legacy.app.ActionBarDrawerToggle$SetIndicatorInfo;
import androidx.legacy.app.ActionBarDrawerToggle$SlideDrawable;
import java.lang.reflect.Method;

public class ActionBarDrawerToggle
implements DrawerLayout$DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    public final Activity mActivity;
    private final ActionBarDrawerToggle$Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private ActionBarDrawerToggle$SetIndicatorInfo mSetIndicatorInfo;
    private ActionBarDrawerToggle$SlideDrawable mSlider;

    static {
        int[] nArray = new int[]{16843531};
        THEME_ATTRS = nArray;
    }

    public ActionBarDrawerToggle(Activity activity, DrawerLayout drawerLayout, int n10, int n11, int n12) {
        boolean bl2 = ActionBarDrawerToggle.assumeMaterial((Context)activity) ^ true;
        this(activity, drawerLayout, bl2, n10, n11, n12);
    }

    public ActionBarDrawerToggle(Activity object, DrawerLayout drawerLayout, boolean bl2, int n10, int n11, int n12) {
        float f10;
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = object;
        boolean bl3 = object instanceof ActionBarDrawerToggle$DelegateProvider;
        if (bl3) {
            Object object2 = object;
            object2 = ((ActionBarDrawerToggle$DelegateProvider)object).getDrawerToggleDelegate();
            this.mActivityImpl = object2;
        } else {
            bl3 = false;
            Object var8_9 = null;
            this.mActivityImpl = null;
        }
        this.mDrawerLayout = drawerLayout;
        this.mDrawerImageResource = n10;
        this.mOpenDrawerContentDescRes = n11;
        this.mCloseDrawerContentDescRes = n12;
        drawerLayout = this.getThemeUpIndicator();
        this.mHomeAsUpIndicator = drawerLayout;
        object = ContextCompat.getDrawable((Context)object, n10);
        this.mDrawerImage = object;
        drawerLayout = this.mDrawerImage;
        super(this, (Drawable)drawerLayout);
        this.mSlider = object;
        if (bl2) {
            f10 = 0.33333334f;
        } else {
            f10 = 0.0f;
            drawerLayout = null;
        }
        ((ActionBarDrawerToggle$SlideDrawable)((Object)object)).setOffset(f10);
    }

    private static boolean assumeMaterial(Context context) {
        context = context.getApplicationInfo();
        int n10 = context.targetSdkVersion;
        int n11 = 21;
        if (n10 >= n11 && (n10 = Build.VERSION.SDK_INT) >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }

    private Drawable getThemeUpIndicator() {
        ActionBarDrawerToggle$Delegate actionBarDrawerToggle$Delegate = this.mActivityImpl;
        if (actionBarDrawerToggle$Delegate != null) {
            return actionBarDrawerToggle$Delegate.getThemeUpIndicator();
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            actionBarDrawerToggle$Delegate = this.mActivity.getActionBar();
            actionBarDrawerToggle$Delegate = actionBarDrawerToggle$Delegate != null ? actionBarDrawerToggle$Delegate.getThemedContext() : this.mActivity;
            int[] nArray = THEME_ATTRS;
            actionBarDrawerToggle$Delegate = actionBarDrawerToggle$Delegate.obtainStyledAttributes(null, nArray, 16843470, 0);
            Drawable drawable2 = actionBarDrawerToggle$Delegate.getDrawable(0);
            actionBarDrawerToggle$Delegate.recycle();
            return drawable2;
        }
        actionBarDrawerToggle$Delegate = this.mActivity;
        Object object = THEME_ATTRS;
        actionBarDrawerToggle$Delegate = actionBarDrawerToggle$Delegate.obtainStyledAttributes((int[])object);
        object = actionBarDrawerToggle$Delegate.getDrawable(0);
        actionBarDrawerToggle$Delegate.recycle();
        return object;
    }

    private void setActionBarDescription(int n10) {
        Object object = this.mActivityImpl;
        if (object != null) {
            object.setActionBarDescription(n10);
            return;
        }
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 >= n12) {
            object = this.mActivity.getActionBar();
            if (object != null) {
                object.setHomeActionContentDescription(n10);
            }
        } else {
            Object object2;
            object = this.mSetIndicatorInfo;
            if (object == null) {
                object2 = this.mActivity;
                this.mSetIndicatorInfo = object = new ActionBarDrawerToggle$SetIndicatorInfo((Activity)object2);
            }
            if ((object = this.mSetIndicatorInfo.mSetHomeAsUpIndicator) != null) {
                object = this.mActivity;
                object = object.getActionBar();
                object2 = this.mSetIndicatorInfo;
                object2 = ((ActionBarDrawerToggle$SetIndicatorInfo)object2).mSetHomeActionContentDescription;
                int n13 = 1;
                Object[] objectArray = new Object[n13];
                Object object3 = n10;
                objectArray[0] = object3;
                ((Method)object2).invoke(object, objectArray);
                object3 = object.getSubtitle();
                try {
                    object.setSubtitle((CharSequence)object3);
                }
                catch (Exception exception) {
                    object = TAG;
                    object2 = "Couldn't set content description via JB-MR2 API";
                    Log.w((String)object, (String)object2, (Throwable)exception);
                }
            }
        }
    }

    private void setActionBarUpIndicator(Drawable object, int n10) {
        Object object2 = this.mActivityImpl;
        if (object2 != null) {
            object2.setActionBarUpIndicator((Drawable)object, n10);
            return;
        }
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 18;
        if (n11 >= n12) {
            object2 = this.mActivity.getActionBar();
            if (object2 != null) {
                object2.setHomeAsUpIndicator((Drawable)object);
                object2.setHomeActionContentDescription(n10);
            }
        } else {
            Object object3;
            object2 = this.mSetIndicatorInfo;
            if (object2 == null) {
                object3 = this.mActivity;
                this.mSetIndicatorInfo = object2 = new ActionBarDrawerToggle$SetIndicatorInfo((Activity)object3);
            }
            object2 = this.mSetIndicatorInfo;
            object3 = ((ActionBarDrawerToggle$SetIndicatorInfo)object2).mSetHomeAsUpIndicator;
            String string2 = TAG;
            if (object3 != null) {
                object2 = this.mActivity;
                object2 = object2.getActionBar();
                object3 = this.mSetIndicatorInfo;
                object3 = ((ActionBarDrawerToggle$SetIndicatorInfo)object3).mSetHomeAsUpIndicator;
                int n13 = 1;
                Object[] objectArray = new Object[n13];
                objectArray[0] = object;
                ((Method)object3).invoke(object2, objectArray);
                object = this.mSetIndicatorInfo;
                object = ((ActionBarDrawerToggle$SetIndicatorInfo)object).mSetHomeActionContentDescription;
                object3 = new Object[n13];
                Object object4 = n10;
                object3[0] = object4;
                try {
                    ((Method)object).invoke(object2, (Object[])object3);
                }
                catch (Exception exception) {
                    object4 = "Couldn't set home-as-up indicator via JB-MR2 API";
                    Log.w((String)string2, (String)object4, (Throwable)exception);
                }
            } else {
                ImageView imageView = ((ActionBarDrawerToggle$SetIndicatorInfo)object2).mUpIndicatorView;
                if (imageView != null) {
                    imageView.setImageDrawable((Drawable)object);
                } else {
                    object = "Couldn't set home-as-up indicator";
                    Log.w((String)string2, (String)object);
                }
            }
        }
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration configuration) {
        boolean bl2 = this.mHasCustomUpIndicator;
        if (!bl2) {
            configuration = this.getThemeUpIndicator();
            this.mHomeAsUpIndicator = configuration;
        }
        configuration = this.mActivity;
        int n10 = this.mDrawerImageResource;
        configuration = ContextCompat.getDrawable((Context)configuration, n10);
        this.mDrawerImage = configuration;
        this.syncState();
    }

    public void onDrawerClosed(View object) {
        object = this.mSlider;
        ((ActionBarDrawerToggle$SlideDrawable)((Object)object)).setPosition(0.0f);
        int n10 = this.mDrawerIndicatorEnabled;
        if (n10 != 0) {
            n10 = this.mOpenDrawerContentDescRes;
            this.setActionBarDescription(n10);
        }
    }

    public void onDrawerOpened(View object) {
        object = this.mSlider;
        float f10 = 1.0f;
        ((ActionBarDrawerToggle$SlideDrawable)((Object)object)).setPosition(f10);
        int n10 = this.mDrawerIndicatorEnabled;
        if (n10 != 0) {
            n10 = this.mCloseDrawerContentDescRes;
            this.setActionBarDescription(n10);
        }
    }

    public void onDrawerSlide(View object, float f10) {
        object = this.mSlider;
        float f11 = ((ActionBarDrawerToggle$SlideDrawable)((Object)object)).getPosition();
        float f12 = 0.5f;
        float f13 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        float f14 = 2.0f;
        if (f13 > 0) {
            f13 = 0.0f;
            f10 -= f12;
            f10 = Math.max(0.0f, f10) * f14;
            f11 = Math.max(f11, f10);
        } else {
            f11 = Math.min(f11, f10 *= f14);
        }
        this.mSlider.setPosition(f11);
    }

    public void onDrawerStateChanged(int n10) {
    }

    public boolean onOptionsItemSelected(MenuItem object) {
        int n10;
        int n11;
        if (object != null && (n11 = object.getItemId()) == (n10 = 16908332) && (n11 = (int)(this.mDrawerIndicatorEnabled ? 1 : 0)) != 0) {
            object = this.mDrawerLayout;
            n10 = 0x800003;
            n11 = (int)(((DrawerLayout)object).isDrawerVisible(n10) ? 1 : 0);
            if (n11 != 0) {
                object = this.mDrawerLayout;
                ((DrawerLayout)object).closeDrawer(n10);
            } else {
                object = this.mDrawerLayout;
                ((DrawerLayout)object).openDrawer(n10);
            }
            return true;
        }
        return false;
    }

    public void setDrawerIndicatorEnabled(boolean bl2) {
        boolean bl3 = this.mDrawerIndicatorEnabled;
        if (bl2 != bl3) {
            if (bl2) {
                ActionBarDrawerToggle$SlideDrawable actionBarDrawerToggle$SlideDrawable = this.mSlider;
                DrawerLayout drawerLayout = this.mDrawerLayout;
                int n10 = 0x800003;
                int n11 = drawerLayout.isDrawerOpen(n10);
                n11 = n11 != 0 ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
                this.setActionBarUpIndicator((Drawable)actionBarDrawerToggle$SlideDrawable, n11);
            } else {
                Drawable drawable2 = this.mHomeAsUpIndicator;
                boolean bl4 = false;
                Object var4_6 = null;
                this.setActionBarUpIndicator(drawable2, 0);
            }
            this.mDrawerIndicatorEnabled = bl2;
        }
    }

    public void setHomeAsUpIndicator(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Activity activity = this.mActivity;
            drawable2 = ContextCompat.getDrawable((Context)activity, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setHomeAsUpIndicator(drawable2);
    }

    public void setHomeAsUpIndicator(Drawable drawable2) {
        boolean bl2;
        if (drawable2 == null) {
            this.mHomeAsUpIndicator = drawable2 = this.getThemeUpIndicator();
            this.mHasCustomUpIndicator = false;
        } else {
            this.mHomeAsUpIndicator = drawable2;
            this.mHasCustomUpIndicator = bl2 = true;
        }
        bl2 = this.mDrawerIndicatorEnabled;
        if (!bl2) {
            drawable2 = this.mHomeAsUpIndicator;
            this.setActionBarUpIndicator(drawable2, 0);
        }
    }

    public void syncState() {
        DrawerLayout drawerLayout;
        Object object = this.mDrawerLayout;
        int n10 = 0x800003;
        boolean bl2 = object.isDrawerOpen(n10);
        if (bl2) {
            object = this.mSlider;
            float f10 = 1.0f;
            ((ActionBarDrawerToggle$SlideDrawable)((Object)object)).setPosition(f10);
        } else {
            object = this.mSlider;
            float f11 = 0.0f;
            drawerLayout = null;
            ((ActionBarDrawerToggle$SlideDrawable)((Object)object)).setPosition(0.0f);
        }
        bl2 = this.mDrawerIndicatorEnabled;
        if (bl2) {
            object = this.mSlider;
            drawerLayout = this.mDrawerLayout;
            n10 = (n10 = (int)(drawerLayout.isDrawerOpen(n10) ? 1 : 0)) != 0 ? this.mCloseDrawerContentDescRes : this.mOpenDrawerContentDescRes;
            this.setActionBarUpIndicator((Drawable)object, n10);
        }
    }
}

