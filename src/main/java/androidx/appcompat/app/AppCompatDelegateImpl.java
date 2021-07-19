/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Dialog
 *  android.app.UiModeManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.pm.ActivityInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.media.AudioManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.AndroidRuntimeException
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.ContextThemeWrapper
 *  android.view.KeyCharacterMap
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.LayoutInflater$Factory2
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.view.Window
 *  android.view.Window$Callback
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.PopupWindow
 *  android.widget.TextView
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$id;
import androidx.appcompat.R$layout;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle$Delegate;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDelegateImpl$1;
import androidx.appcompat.app.AppCompatDelegateImpl$2;
import androidx.appcompat.app.AppCompatDelegateImpl$3;
import androidx.appcompat.app.AppCompatDelegateImpl$4;
import androidx.appcompat.app.AppCompatDelegateImpl$5;
import androidx.appcompat.app.AppCompatDelegateImpl$6;
import androidx.appcompat.app.AppCompatDelegateImpl$7;
import androidx.appcompat.app.AppCompatDelegateImpl$ActionBarDrawableToggleImpl;
import androidx.appcompat.app.AppCompatDelegateImpl$ActionMenuPresenterCallback;
import androidx.appcompat.app.AppCompatDelegateImpl$ActionModeCallbackWrapperV9;
import androidx.appcompat.app.AppCompatDelegateImpl$Api17Impl;
import androidx.appcompat.app.AppCompatDelegateImpl$Api24Impl;
import androidx.appcompat.app.AppCompatDelegateImpl$Api26Impl;
import androidx.appcompat.app.AppCompatDelegateImpl$AppCompatWindowCallback;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoBatteryNightModeManager;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoNightModeManager;
import androidx.appcompat.app.AppCompatDelegateImpl$AutoTimeNightModeManager;
import androidx.appcompat.app.AppCompatDelegateImpl$ContextThemeWrapperCompatApi17Impl;
import androidx.appcompat.app.AppCompatDelegateImpl$ListMenuDecorView;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState;
import androidx.appcompat.app.AppCompatDelegateImpl$PanelMenuPresenterCallback;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatViewInflater;
import androidx.appcompat.app.LayoutIncludeDetector;
import androidx.appcompat.app.ResourcesFlusher;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.app.TwilightManager;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode$Callback;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.StandaloneActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuPresenter$Callback;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.ContentFrameLayout$OnAttachListener;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.FitWindowsViewGroup$OnFitSystemWindowsListener;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat$ThemeCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.KeyEventDispatcher;
import androidx.core.view.KeyEventDispatcher$Component;
import androidx.core.view.LayoutInflaterCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParser;

public class AppCompatDelegateImpl
extends AppCompatDelegate
implements MenuBuilder$Callback,
LayoutInflater.Factory2 {
    public static final String EXCEPTION_HANDLER_MESSAGE_SUFFIX = ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.";
    private static final boolean IS_PRE_LOLLIPOP;
    private static final boolean sCanApplyOverrideConfiguration;
    private static final boolean sCanReturnDifferentContext;
    private static boolean sInstalledExceptionHandler;
    private static final SimpleArrayMap sLocalNightModes;
    private static final int[] sWindowBackgroundStyleable;
    public ActionBar mActionBar;
    private AppCompatDelegateImpl$ActionMenuPresenterCallback mActionMenuPresenterCallback;
    public ActionMode mActionMode;
    public PopupWindow mActionModePopup;
    public ActionBarContextView mActionModeView;
    private boolean mActivityHandlesUiMode;
    private boolean mActivityHandlesUiModeChecked;
    public final AppCompatCallback mAppCompatCallback;
    private AppCompatViewInflater mAppCompatViewInflater;
    private AppCompatDelegateImpl$AppCompatWindowCallback mAppCompatWindowCallback;
    private AppCompatDelegateImpl$AutoNightModeManager mAutoBatteryNightModeManager;
    private AppCompatDelegateImpl$AutoNightModeManager mAutoTimeNightModeManager;
    private boolean mBaseContextAttached;
    private boolean mClosingActionMenu;
    public final Context mContext;
    private boolean mCreated;
    private DecorContentParent mDecorContentParent;
    private boolean mEnableDefaultActionBarUp;
    public ViewPropertyAnimatorCompat mFadeAnim;
    private boolean mFeatureIndeterminateProgress;
    private boolean mFeatureProgress;
    private boolean mHandleNativeActionModes;
    public boolean mHasActionBar;
    public final Object mHost;
    public int mInvalidatePanelMenuFeatures;
    public boolean mInvalidatePanelMenuPosted;
    private final Runnable mInvalidatePanelMenuRunnable;
    public boolean mIsDestroyed;
    public boolean mIsFloating;
    private LayoutIncludeDetector mLayoutIncludeDetector;
    private int mLocalNightMode;
    private boolean mLongPressBackDown;
    public MenuInflater mMenuInflater;
    public boolean mOverlayActionBar;
    public boolean mOverlayActionMode;
    private AppCompatDelegateImpl$PanelMenuPresenterCallback mPanelMenuPresenterCallback;
    private AppCompatDelegateImpl$PanelFeatureState[] mPanels;
    private AppCompatDelegateImpl$PanelFeatureState mPreparedPanel;
    public Runnable mShowActionModePopup;
    private boolean mStarted;
    private View mStatusGuard;
    public ViewGroup mSubDecor;
    private boolean mSubDecorInstalled;
    private Rect mTempRect1;
    private Rect mTempRect2;
    private int mThemeResId;
    private CharSequence mTitle;
    private TextView mTitleView;
    public Window mWindow;
    public boolean mWindowNoTitle;

    static {
        int n10;
        Object object = new SimpleArrayMap();
        sLocalNightModes = object;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 0;
        AppCompatDelegateImpl$1 appCompatDelegateImpl$1 = null;
        int n13 = 1;
        int n14 = 21;
        n14 = n11 < n14 ? n13 : 0;
        IS_PRE_LOLLIPOP = n14;
        Object object2 = new int[n13];
        object2[0] = n10 = 16842836;
        sWindowBackgroundStyleable = object2;
        object2 = Build.FINGERPRINT;
        String string2 = "robolectric";
        sCanReturnDifferentContext = string2.equals(object2) ^ n13;
        int n15 = 17;
        if (n11 >= n15) {
            n12 = n13;
        }
        sCanApplyOverrideConfiguration = n12;
        if (n14 != 0 && (n11 = (int)(sInstalledExceptionHandler ? 1 : 0)) == 0) {
            object = Thread.getDefaultUncaughtExceptionHandler();
            appCompatDelegateImpl$1 = new AppCompatDelegateImpl$1((Thread.UncaughtExceptionHandler)object);
            Thread.setDefaultUncaughtExceptionHandler(appCompatDelegateImpl$1);
            sInstalledExceptionHandler = n13;
        }
    }

    public AppCompatDelegateImpl(Activity activity, AppCompatCallback appCompatCallback) {
        this((Context)activity, null, appCompatCallback, activity);
    }

    public AppCompatDelegateImpl(Dialog dialog, AppCompatCallback appCompatCallback) {
        Context context = dialog.getContext();
        Window window = dialog.getWindow();
        this(context, window, appCompatCallback, dialog);
    }

    public AppCompatDelegateImpl(Context context, Activity activity, AppCompatCallback appCompatCallback) {
        this(context, null, appCompatCallback, activity);
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback) {
        this(context, window, appCompatCallback, context);
    }

    private AppCompatDelegateImpl(Context object, Window window, AppCompatCallback object2, Object object3) {
        int n10;
        this.mFadeAnim = null;
        this.mHandleNativeActionModes = true;
        this.mLocalNightMode = n10 = -100;
        AppCompatDelegateImpl$2 appCompatDelegateImpl$2 = new AppCompatDelegateImpl$2(this);
        this.mInvalidatePanelMenuRunnable = appCompatDelegateImpl$2;
        this.mContext = object;
        this.mAppCompatCallback = object2;
        this.mHost = object3;
        int n11 = this.mLocalNightMode;
        if (n11 == n10 && (n11 = object3 instanceof Dialog) != 0 && (object = this.tryUnwrapContext()) != null) {
            object = ((AppCompatActivity)object).getDelegate();
            this.mLocalNightMode = n11 = ((AppCompatDelegate)object).getLocalNightMode();
        }
        if ((n11 = this.mLocalNightMode) == n10) {
            object = sLocalNightModes;
            object2 = object3.getClass().getName();
            if ((object2 = (Integer)((SimpleArrayMap)object).get(object2)) != null) {
                int n12;
                this.mLocalNightMode = n12 = ((Integer)object2).intValue();
                object2 = object3.getClass().getName();
                ((SimpleArrayMap)object).remove(object2);
            }
        }
        if (window != null) {
            this.attachToWindow(window);
        }
        AppCompatDrawableManager.preload();
    }

    private boolean applyDayNight(boolean bl2) {
        int n10 = this.mIsDestroyed;
        if (n10 != 0) {
            return false;
        }
        n10 = this.calculateNightMode();
        Object object = this.mContext;
        int n11 = this.mapNightMode((Context)object, n10);
        bl2 = this.updateForNightMode(n11, bl2);
        if (n10 == 0) {
            object = this.mContext;
            object = this.getAutoTimeNightModeManager((Context)object);
            ((AppCompatDelegateImpl$AutoNightModeManager)object).setup();
        } else {
            object = this.mAutoTimeNightModeManager;
            if (object != null) {
                ((AppCompatDelegateImpl$AutoNightModeManager)object).cleanup();
            }
        }
        n11 = 3;
        if (n10 == n11) {
            Object object2 = this.mContext;
            object2 = this.getAutoBatteryNightModeManager((Context)object2);
            ((AppCompatDelegateImpl$AutoNightModeManager)object2).setup();
        } else {
            AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager = this.mAutoBatteryNightModeManager;
            if (appCompatDelegateImpl$AutoNightModeManager != null) {
                appCompatDelegateImpl$AutoNightModeManager.cleanup();
            }
        }
        return bl2;
    }

    private void applyFixedSizeWindow() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout)this.mSubDecor.findViewById(0x1020002);
        View view = this.mWindow.getDecorView();
        int n10 = view.getPaddingLeft();
        int n11 = view.getPaddingTop();
        int n12 = view.getPaddingRight();
        int n13 = view.getPaddingBottom();
        contentFrameLayout.setDecorPadding(n10, n11, n12, n13);
        view = this.mContext;
        int[] nArray = R$styleable.AppCompatTheme;
        view = view.obtainStyledAttributes(nArray);
        n10 = R$styleable.AppCompatTheme_windowMinWidthMajor;
        TypedValue typedValue = contentFrameLayout.getMinWidthMajor();
        view.getValue(n10, typedValue);
        n10 = R$styleable.AppCompatTheme_windowMinWidthMinor;
        typedValue = contentFrameLayout.getMinWidthMinor();
        view.getValue(n10, typedValue);
        n10 = R$styleable.AppCompatTheme_windowFixedWidthMajor;
        n11 = (int)(view.hasValue(n10) ? 1 : 0);
        if (n11 != 0) {
            typedValue = contentFrameLayout.getFixedWidthMajor();
            view.getValue(n10, typedValue);
        }
        if ((n11 = (int)(view.hasValue(n10 = R$styleable.AppCompatTheme_windowFixedWidthMinor) ? 1 : 0)) != 0) {
            typedValue = contentFrameLayout.getFixedWidthMinor();
            view.getValue(n10, typedValue);
        }
        if ((n11 = (int)(view.hasValue(n10 = R$styleable.AppCompatTheme_windowFixedHeightMajor) ? 1 : 0)) != 0) {
            typedValue = contentFrameLayout.getFixedHeightMajor();
            view.getValue(n10, typedValue);
        }
        if ((n11 = (int)(view.hasValue(n10 = R$styleable.AppCompatTheme_windowFixedHeightMinor) ? 1 : 0)) != 0) {
            typedValue = contentFrameLayout.getFixedHeightMinor();
            view.getValue(n10, typedValue);
        }
        view.recycle();
        contentFrameLayout.requestLayout();
    }

    private void attachToWindow(Window object) {
        Object object2 = this.mWindow;
        Object object3 = "AppCompat has already installed itself into the Window";
        if (object2 == null) {
            object2 = object.getCallback();
            boolean bl2 = object2 instanceof AppCompatDelegateImpl$AppCompatWindowCallback;
            if (!bl2) {
                this.mAppCompatWindowCallback = object3 = new AppCompatDelegateImpl$AppCompatWindowCallback(this, (Window.Callback)object2);
                object.setCallback((Window.Callback)object3);
                object2 = this.mContext;
                int[] nArray = sWindowBackgroundStyleable;
                object2 = TintTypedArray.obtainStyledAttributes((Context)object2, null, nArray);
                object3 = ((TintTypedArray)object2).getDrawableIfKnown(0);
                if (object3 != null) {
                    object.setBackgroundDrawable((Drawable)object3);
                }
                ((TintTypedArray)object2).recycle();
                this.mWindow = object;
                return;
            }
            object = new IllegalStateException((String)object3);
            throw object;
        }
        object = new IllegalStateException((String)object3);
        throw object;
    }

    private int calculateNightMode() {
        int n10 = this.mLocalNightMode;
        int n11 = -100;
        if (n10 == n11) {
            n10 = AppCompatDelegate.getDefaultNightMode();
        }
        return n10;
    }

    private void cleanupAutoManagers() {
        AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager = this.mAutoTimeNightModeManager;
        if (appCompatDelegateImpl$AutoNightModeManager != null) {
            appCompatDelegateImpl$AutoNightModeManager.cleanup();
        }
        if ((appCompatDelegateImpl$AutoNightModeManager = this.mAutoBatteryNightModeManager) != null) {
            appCompatDelegateImpl$AutoNightModeManager.cleanup();
        }
    }

    private Configuration createOverrideConfigurationForDayNight(Context context, int n10, Configuration configuration) {
        int n11;
        int n12 = 1;
        if (n10 != n12) {
            n12 = 2;
            if (n10 != n12) {
                context = context.getApplicationContext().getResources().getConfiguration();
                n11 = context.uiMode & 0x30;
            } else {
                n11 = 32;
            }
        } else {
            n11 = 16;
        }
        Configuration configuration2 = new Configuration();
        n12 = 0;
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        int n13 = configuration2.uiMode & 0xFFFFFFCF;
        configuration2.uiMode = n11 |= n13;
        return configuration2;
    }

    private ViewGroup createSubDecor() {
        int n10;
        Object object = this.mContext;
        Object object2 = R$styleable.AppCompatTheme;
        int n11 = (object = object.obtainStyledAttributes(object2)).hasValue(n10 = R$styleable.AppCompatTheme_windowActionBar);
        if (n11 != 0) {
            int n12;
            n11 = R$styleable.AppCompatTheme_windowNoTitle;
            boolean bl2 = false;
            n11 = (int)(object.getBoolean(n11, false) ? 1 : 0);
            int n13 = 1;
            if (n11 != 0) {
                this.requestWindowFeature(n13);
            } else if ((n10 = (int)(object.getBoolean(n10, false) ? 1 : 0)) != 0) {
                n10 = 108;
                this.requestWindowFeature(n10);
            }
            n10 = R$styleable.AppCompatTheme_windowActionBarOverlay;
            n10 = (int)(object.getBoolean(n10, false) ? 1 : 0);
            n11 = 109;
            if (n10 != 0) {
                this.requestWindowFeature(n11);
            }
            n10 = R$styleable.AppCompatTheme_windowActionModeOverlay;
            if ((n10 = (int)(object.getBoolean(n10, false) ? 1 : 0)) != 0) {
                n10 = 10;
                this.requestWindowFeature(n10);
            }
            n10 = R$styleable.AppCompatTheme_android_windowIsFloating;
            n10 = (int)(object.getBoolean(n10, false) ? 1 : 0);
            this.mIsFloating = n10;
            object.recycle();
            this.ensureWindow();
            this.mWindow.getDecorView();
            object = LayoutInflater.from((Context)this.mContext);
            n10 = (int)(this.mWindowNoTitle ? 1 : 0);
            if (n10 == 0) {
                n10 = (int)(this.mIsFloating ? 1 : 0);
                if (n10 != 0) {
                    n10 = R$layout.abc_dialog_title_material;
                    object = (ViewGroup)object.inflate(n10, null);
                    this.mOverlayActionBar = false;
                    this.mHasActionBar = false;
                } else {
                    int n14 = this.mHasActionBar;
                    if (n14 != 0) {
                        Context context;
                        object = new TypedValue();
                        object2 = this.mContext.getTheme();
                        n12 = R$attr.actionBarTheme;
                        object2.resolveAttribute(n12, (TypedValue)object, n13 != 0);
                        n10 = object.resourceId;
                        if (n10 != 0) {
                            object2 = (Object)new ContextThemeWrapper;
                            context = this.mContext;
                            n14 = object.resourceId;
                            object2(context, n14);
                        } else {
                            object2 = this.mContext;
                        }
                        object = LayoutInflater.from((Context)object2);
                        n10 = R$layout.abc_screen_toolbar;
                        object = (ViewGroup)object.inflate(n10, null);
                        n10 = R$id.decor_content_parent;
                        this.mDecorContentParent = object2 = (DecorContentParent)object.findViewById(n10);
                        context = this.getWindowCallback();
                        object2.setWindowCallback((Window.Callback)context);
                        n10 = (int)(this.mOverlayActionBar ? 1 : 0);
                        if (n10 != 0) {
                            object2 = this.mDecorContentParent;
                            object2.initFeature(n11);
                        }
                        if ((n10 = (int)(this.mFeatureProgress ? 1 : 0)) != 0) {
                            object2 = this.mDecorContentParent;
                            n11 = 2;
                            object2.initFeature(n11);
                        }
                        if ((n10 = (int)(this.mFeatureIndeterminateProgress ? 1 : 0)) != 0) {
                            object2 = this.mDecorContentParent;
                            n11 = 5;
                            object2.initFeature(n11);
                        }
                    } else {
                        n14 = 0;
                        object = null;
                    }
                }
            } else {
                n10 = (int)(this.mOverlayActionMode ? 1 : 0);
                if (n10 != 0) {
                    n10 = R$layout.abc_screen_simple_overlay_action_mode;
                    object = (ViewGroup)object.inflate(n10, null);
                } else {
                    n10 = R$layout.abc_screen_simple;
                    object = (ViewGroup)object.inflate(n10, null);
                }
            }
            if (object != null) {
                Object object3;
                n10 = Build.VERSION.SDK_INT;
                n11 = 21;
                if (n10 >= n11) {
                    object2 = new AppCompatDelegateImpl$3;
                    object2(this);
                    ViewCompat.setOnApplyWindowInsetsListener((View)object, (OnApplyWindowInsetsListener)object2);
                } else {
                    n10 = object instanceof FitWindowsViewGroup;
                    if (n10 != 0) {
                        object2 = object;
                        object2 = (FitWindowsViewGroup)object;
                        object3 = new AppCompatDelegateImpl$4(this);
                        object2.setOnFitSystemWindowsListener((FitWindowsViewGroup$OnFitSystemWindowsListener)object3);
                    }
                }
                object2 = this.mDecorContentParent;
                if (object2 == null) {
                    n10 = R$id.title;
                    object2 = (TextView)((ViewGroup)object).findViewById(n10);
                    this.mTitleView = object2;
                }
                ViewUtils.makeOptionalFitsSystemWindows((View)object);
                n10 = R$id.action_bar_activity_content;
                object2 = (ContentFrameLayout)((ViewGroup)object).findViewById(n10);
                object3 = this.mWindow;
                n13 = 0x1020002;
                object3 = (ViewGroup)object3.findViewById(n13);
                if (object3 != null) {
                    while ((n12 = object3.getChildCount()) > 0) {
                        View view = object3.getChildAt(0);
                        object3.removeViewAt(0);
                        object2.addView(view);
                    }
                    object3.setId(-1);
                    object2.setId(n13);
                    bl2 = object3 instanceof FrameLayout;
                    if (bl2) {
                        object3 = (FrameLayout)object3;
                        object3.setForeground(null);
                    }
                }
                this.mWindow.setContentView((View)object);
                object3 = new AppCompatDelegateImpl$5(this);
                object2.setAttachListener((ContentFrameLayout$OnAttachListener)object3);
                return (ViewGroup)object;
            }
            object2 = new StringBuilder;
            object2();
            object2.append("AppCompat does not support the current theme features: { windowActionBar: ");
            n11 = (int)(this.mHasActionBar ? 1 : 0);
            object2.append(n11 != 0);
            object2.append(", windowActionBarOverlay: ");
            n11 = this.mOverlayActionBar;
            object2.append(n11 != 0);
            object2.append(", android:windowIsFloating: ");
            n11 = this.mIsFloating;
            object2.append(n11 != 0);
            object2.append(", windowActionModeOverlay: ");
            n11 = this.mOverlayActionMode;
            object2.append(n11 != 0);
            object2.append(", windowNoTitle: ");
            n11 = (int)(this.mWindowNoTitle ? 1 : 0);
            object2.append(n11 != 0);
            object2.append(" }");
            object2 = object2.toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object.recycle();
        object = new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        throw object;
    }

    private void ensureSubDecor() {
        int n10 = this.mSubDecorInstalled;
        if (n10 == 0) {
            Object object;
            this.mSubDecor = object = this.createSubDecor();
            object = this.getTitle();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                Object object2 = this.mDecorContentParent;
                if (object2 != null) {
                    object2.setWindowTitle((CharSequence)object);
                } else {
                    object2 = this.peekSupportActionBar();
                    if (object2 != null) {
                        object2 = this.peekSupportActionBar();
                        ((ActionBar)object2).setWindowTitle((CharSequence)object);
                    } else {
                        object2 = this.mTitleView;
                        if (object2 != null) {
                            object2.setText((CharSequence)object);
                        }
                    }
                }
            }
            this.applyFixedSizeWindow();
            object = this.mSubDecor;
            this.onSubDecorInstalled((ViewGroup)object);
            this.mSubDecorInstalled = true;
            n10 = 0;
            object = this.getPanelState(0, false);
            bl2 = this.mIsDestroyed;
            if (!(bl2 || object != null && (object = object.menu) != null)) {
                n10 = 108;
                this.invalidatePanelMenu(n10);
            }
        }
    }

    private void ensureWindow() {
        boolean bl2;
        Object object = this.mWindow;
        if (object == null && (bl2 = (object = this.mHost) instanceof Activity)) {
            object = ((Activity)object).getWindow();
            this.attachToWindow((Window)object);
        }
        if ((object = this.mWindow) != null) {
            return;
        }
        object = new IllegalStateException("We have not been given a Window");
        throw object;
    }

    private static Configuration generateConfigDelta(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        int n10 = 0;
        float f10 = 0.0f;
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && (n10 = configuration.diff(configuration2)) != 0) {
            int n11;
            int n12;
            f10 = configuration.fontScale;
            float f11 = configuration2.fontScale;
            float f12 = f10 - f11;
            n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (n10 != 0) {
                configuration3.fontScale = f11;
            }
            if ((n10 = configuration.mcc) != (n12 = configuration2.mcc)) {
                configuration3.mcc = n12;
            }
            if ((n10 = configuration.mnc) != (n12 = configuration2.mnc)) {
                configuration3.mnc = n12;
            }
            n10 = Build.VERSION.SDK_INT;
            n12 = 24;
            f11 = 3.4E-44f;
            if (n10 >= n12) {
                AppCompatDelegateImpl$Api24Impl.generateConfigDelta_locale(configuration, configuration2, configuration3);
            } else {
                Locale locale = configuration.locale;
                Locale locale2 = configuration2.locale;
                n12 = (int)(ObjectsCompat.equals(locale, locale2) ? 1 : 0);
                if (n12 == 0) {
                    configuration3.locale = locale = configuration2.locale;
                }
            }
            n12 = configuration.touchscreen;
            int n13 = configuration2.touchscreen;
            if (n12 != n13) {
                configuration3.touchscreen = n13;
            }
            if ((n12 = configuration.keyboard) != (n13 = configuration2.keyboard)) {
                configuration3.keyboard = n13;
            }
            if ((n12 = configuration.keyboardHidden) != (n13 = configuration2.keyboardHidden)) {
                configuration3.keyboardHidden = n13;
            }
            if ((n12 = configuration.navigation) != (n13 = configuration2.navigation)) {
                configuration3.navigation = n13;
            }
            if ((n12 = configuration.navigationHidden) != (n13 = configuration2.navigationHidden)) {
                configuration3.navigationHidden = n13;
            }
            if ((n12 = configuration.orientation) != (n13 = configuration2.orientation)) {
                configuration3.orientation = n13;
            }
            if ((n12 = configuration.screenLayout & 0xF) != (n11 = (n13 = configuration2.screenLayout) & 0xF)) {
                n12 = configuration3.screenLayout;
                configuration3.screenLayout = n12 |= (n13 &= 0xF);
            }
            if ((n12 = configuration.screenLayout & 0xC0) != (n11 = (n13 = configuration2.screenLayout) & 0xC0)) {
                n12 = configuration3.screenLayout;
                configuration3.screenLayout = n12 |= (n13 &= 0xC0);
            }
            if ((n12 = configuration.screenLayout & 0x30) != (n11 = (n13 = configuration2.screenLayout) & 0x30)) {
                n12 = configuration3.screenLayout;
                configuration3.screenLayout = n12 |= (n13 &= 0x30);
            }
            if ((n12 = configuration.screenLayout & 0x300) != (n11 = (n13 = configuration2.screenLayout) & 0x300)) {
                n12 = configuration3.screenLayout;
                configuration3.screenLayout = n12 |= (n13 &= 0x300);
            }
            n12 = 26;
            f11 = 3.6E-44f;
            if (n10 >= n12) {
                AppCompatDelegateImpl$Api26Impl.generateConfigDelta_colorMode(configuration, configuration2, configuration3);
            }
            if ((n12 = configuration.uiMode & 0xF) != (n11 = (n13 = configuration2.uiMode) & 0xF)) {
                n12 = configuration3.uiMode;
                configuration3.uiMode = n12 |= (n13 &= 0xF);
            }
            if ((n12 = configuration.uiMode & 0x30) != (n11 = (n13 = configuration2.uiMode) & 0x30)) {
                n12 = configuration3.uiMode;
                configuration3.uiMode = n12 |= (n13 &= 0x30);
            }
            if ((n12 = configuration.screenWidthDp) != (n13 = configuration2.screenWidthDp)) {
                configuration3.screenWidthDp = n13;
            }
            if ((n12 = configuration.screenHeightDp) != (n13 = configuration2.screenHeightDp)) {
                configuration3.screenHeightDp = n13;
            }
            if ((n12 = configuration.smallestScreenWidthDp) != (n13 = configuration2.smallestScreenWidthDp)) {
                configuration3.smallestScreenWidthDp = n13;
            }
            n12 = 17;
            f11 = 2.4E-44f;
            if (n10 >= n12) {
                AppCompatDelegateImpl$Api17Impl.generateConfigDelta_densityDpi(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private AppCompatDelegateImpl$AutoNightModeManager getAutoBatteryNightModeManager(Context context) {
        AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager = this.mAutoBatteryNightModeManager;
        if (appCompatDelegateImpl$AutoNightModeManager == null) {
            this.mAutoBatteryNightModeManager = appCompatDelegateImpl$AutoNightModeManager = new AppCompatDelegateImpl$AutoBatteryNightModeManager(this, context);
        }
        return this.mAutoBatteryNightModeManager;
    }

    private AppCompatDelegateImpl$AutoNightModeManager getAutoTimeNightModeManager(Context object) {
        AppCompatDelegateImpl$AutoNightModeManager appCompatDelegateImpl$AutoNightModeManager = this.mAutoTimeNightModeManager;
        if (appCompatDelegateImpl$AutoNightModeManager == null) {
            object = TwilightManager.getInstance(object);
            this.mAutoTimeNightModeManager = appCompatDelegateImpl$AutoNightModeManager = new AppCompatDelegateImpl$AutoTimeNightModeManager(this, (TwilightManager)object);
        }
        return this.mAutoTimeNightModeManager;
    }

    private void initWindowDecorActionBar() {
        Object object;
        this.ensureSubDecor();
        boolean bl2 = this.mHasActionBar;
        if (bl2 && (object = this.mActionBar) == null) {
            object = this.mHost;
            boolean bl3 = object instanceof Activity;
            if (bl3) {
                Activity activity = (Activity)this.mHost;
                boolean bl4 = this.mOverlayActionBar;
                this.mActionBar = object = new WindowDecorActionBar(activity, bl4);
            } else {
                bl2 = object instanceof Dialog;
                if (bl2) {
                    Dialog dialog = (Dialog)this.mHost;
                    this.mActionBar = object = new WindowDecorActionBar(dialog);
                }
            }
            object = this.mActionBar;
            if (object != null) {
                bl3 = this.mEnableDefaultActionBarUp;
                ((ActionBar)object).setDefaultDisplayHomeAsUpEnabled(bl3);
            }
        }
    }

    private boolean initializePanelContent(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState) {
        Object object = appCompatDelegateImpl$PanelFeatureState.createdPanelView;
        boolean bl2 = true;
        if (object != null) {
            appCompatDelegateImpl$PanelFeatureState.shownPanelView = object;
            return bl2;
        }
        object = appCompatDelegateImpl$PanelFeatureState.menu;
        if (object == null) {
            return false;
        }
        object = this.mPanelMenuPresenterCallback;
        if (object == null) {
            object = new AppCompatDelegateImpl$PanelMenuPresenterCallback(this);
            this.mPanelMenuPresenterCallback = object;
        }
        object = this.mPanelMenuPresenterCallback;
        appCompatDelegateImpl$PanelFeatureState.shownPanelView = object = (View)appCompatDelegateImpl$PanelFeatureState.getListMenuView((MenuPresenter$Callback)object);
        if (object == null) {
            bl2 = false;
        }
        return bl2;
    }

    private boolean initializePanelDecor(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState) {
        Object object = this.getActionBarThemedContext();
        appCompatDelegateImpl$PanelFeatureState.setStyle((Context)object);
        Context context = appCompatDelegateImpl$PanelFeatureState.listPresenterContext;
        object = new AppCompatDelegateImpl$ListMenuDecorView(this, context);
        appCompatDelegateImpl$PanelFeatureState.decorView = object;
        appCompatDelegateImpl$PanelFeatureState.gravity = 81;
        return true;
    }

    private boolean initializePanelMenu(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState) {
        Object object;
        int n10;
        Object object2 = this.mContext;
        int n11 = appCompatDelegateImpl$PanelFeatureState.featureId;
        boolean bl2 = true;
        if ((n11 == 0 || n11 == (n10 = 108)) && (object = this.mDecorContentParent) != null) {
            object = new TypedValue();
            Resources.Theme theme = object2.getTheme();
            int n12 = R$attr.actionBarTheme;
            theme.resolveAttribute(n12, (TypedValue)object, bl2);
            n12 = 0;
            Resources.Theme theme2 = null;
            int n13 = ((TypedValue)object).resourceId;
            if (n13 != 0) {
                theme2 = object2.getResources().newTheme();
                theme2.setTo(theme);
                n13 = ((TypedValue)object).resourceId;
                theme2.applyStyle(n13, bl2);
                n13 = R$attr.actionBarWidgetTheme;
                theme2.resolveAttribute(n13, (TypedValue)object, bl2);
            } else {
                n13 = R$attr.actionBarWidgetTheme;
                theme.resolveAttribute(n13, (TypedValue)object, bl2);
            }
            n13 = ((TypedValue)object).resourceId;
            if (n13 != 0) {
                if (theme2 == null) {
                    theme2 = object2.getResources().newTheme();
                    theme2.setTo(theme);
                }
                n11 = ((TypedValue)object).resourceId;
                theme2.applyStyle(n11, bl2);
            }
            if (theme2 != null) {
                n10 = 0;
                theme = null;
                object = new ContextThemeWrapper((Context)object2, 0);
                object.getTheme().setTo(theme2);
                object2 = object;
            }
        }
        object = new MenuBuilder((Context)object2);
        ((MenuBuilder)object).setCallback(this);
        appCompatDelegateImpl$PanelFeatureState.setMenu((MenuBuilder)object);
        return bl2;
    }

    private void invalidatePanelMenu(int n10) {
        int n11 = this.mInvalidatePanelMenuFeatures;
        int n12 = 1;
        this.mInvalidatePanelMenuFeatures = n10 = n12 << n10 | n11;
        n10 = (int)(this.mInvalidatePanelMenuPosted ? 1 : 0);
        if (n10 == 0) {
            View view = this.mWindow.getDecorView();
            Runnable runnable = this.mInvalidatePanelMenuRunnable;
            ViewCompat.postOnAnimation(view, runnable);
            this.mInvalidatePanelMenuPosted = n12;
        }
    }

    private boolean isActivityManifestHandlingUiMode() {
        boolean bl2;
        block15: {
            String string2;
            String string3;
            int n10;
            block16: {
                Object object;
                block14: {
                    int n11;
                    block13: {
                        n10 = this.mActivityHandlesUiModeChecked;
                        bl2 = true;
                        if (n10 != 0 || (n10 = (object = this.mHost) instanceof Activity) == 0) break block15;
                        object = this.mContext.getPackageManager();
                        if (object == null) {
                            return false;
                        }
                        n11 = Build.VERSION.SDK_INT;
                        int n12 = 29;
                        if (n11 >= n12) {
                            n11 = 0x100C0000;
                            break block13;
                        }
                        n12 = 24;
                        if (n11 >= n12) {
                            n11 = 786432;
                            break block13;
                        }
                        n11 = 0;
                        string3 = null;
                    }
                    Context context = this.mContext;
                    Class<?> clazz = this.mHost;
                    clazz = clazz.getClass();
                    string2 = new ComponentName(context, clazz);
                    object = object.getActivityInfo((ComponentName)string2, n11);
                    if (object == null) break block14;
                    n10 = ((ActivityInfo)object).configChanges & 0x200;
                    if (n10 == 0) break block14;
                    n10 = (int)(bl2 ? 1 : 0);
                    break block16;
                }
                n10 = 0;
                object = null;
            }
            try {
                this.mActivityHandlesUiMode = n10;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                string3 = "AppCompatDelegate";
                string2 = "Exception while getting ActivityInfo";
                Log.d((String)string3, (String)string2, (Throwable)nameNotFoundException);
                this.mActivityHandlesUiMode = false;
            }
        }
        this.mActivityHandlesUiModeChecked = bl2;
        return this.mActivityHandlesUiMode;
    }

    private boolean onKeyDownPanel(int n10, KeyEvent keyEvent) {
        int n11 = keyEvent.getRepeatCount();
        if (n11 == 0) {
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.getPanelState(n10, true);
            n11 = (int)(appCompatDelegateImpl$PanelFeatureState.isOpen ? 1 : 0);
            if (n11 == 0) {
                return this.preparePanel(appCompatDelegateImpl$PanelFeatureState, keyEvent);
            }
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean onKeyUpPanel(int n10, KeyEvent object) {
        Object object2;
        ActionMode actionMode = this.mActionMode;
        if (actionMode != null) {
            return false;
        }
        int n11 = 1;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.getPanelState(n10, n11 != 0);
        if (n10 == 0 && (object2 = this.mDecorContentParent) != null && (n10 = (int)(object2.canShowOverflowMenu() ? 1 : 0)) != 0 && (n10 = (int)((object2 = ViewConfiguration.get((Context)this.mContext)).hasPermanentMenuKey() ? 1 : 0)) == 0) {
            object2 = this.mDecorContentParent;
            n10 = (int)(object2.isOverflowMenuShowing() ? 1 : 0);
            if (n10 == 0) {
                n10 = (int)(this.mIsDestroyed ? 1 : 0);
                if (n10 != 0) return 0 != 0;
                n10 = (int)(this.preparePanel(appCompatDelegateImpl$PanelFeatureState, (KeyEvent)object) ? 1 : 0);
                if (n10 == 0) return 0 != 0;
                object2 = this.mDecorContentParent;
                n11 = (int)(object2.showOverflowMenu() ? 1 : 0);
            } else {
                object2 = this.mDecorContentParent;
                n11 = (int)(object2.hideOverflowMenu() ? 1 : 0);
            }
        } else {
            boolean bl2;
            n10 = (int)(appCompatDelegateImpl$PanelFeatureState.isOpen ? 1 : 0);
            if (n10 == 0 && !(bl2 = appCompatDelegateImpl$PanelFeatureState.isHandled)) {
                n10 = (int)(appCompatDelegateImpl$PanelFeatureState.isPrepared ? 1 : 0);
                if (n10 == 0) return 0 != 0;
                n10 = (int)(appCompatDelegateImpl$PanelFeatureState.refreshMenuContent ? 1 : 0);
                if (n10 != 0) {
                    appCompatDelegateImpl$PanelFeatureState.isPrepared = false;
                    n10 = (int)(this.preparePanel(appCompatDelegateImpl$PanelFeatureState, (KeyEvent)object) ? 1 : 0);
                } else {
                    n10 = n11;
                }
                if (n10 == 0) return 0 != 0;
                this.openPanel(appCompatDelegateImpl$PanelFeatureState, (KeyEvent)object);
            } else {
                this.closePanel(appCompatDelegateImpl$PanelFeatureState, n11 != 0);
                n11 = n10;
            }
        }
        if (n11 == 0) return n11 != 0;
        object2 = this.mContext.getApplicationContext();
        String string2 = "audio";
        if ((object2 = (AudioManager)object2.getSystemService(string2)) != null) {
            object2.playSoundEffect(0);
            return n11 != 0;
        } else {
            object2 = "AppCompatDelegate";
            String string3 = "Couldn't get audio manager";
            Log.w((String)object2, (String)string3);
        }
        return n11 != 0;
    }

    private void openPanel(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, KeyEvent keyEvent) {
        block18: {
            int n10;
            block22: {
                KeyEvent keyEvent2;
                int n11;
                Window.Callback callback;
                ViewGroup viewGroup;
                int n12;
                block21: {
                    int n13;
                    block20: {
                        boolean bl2;
                        int n14;
                        String string2;
                        int n15;
                        block19: {
                            MenuBuilder menuBuilder;
                            int n16 = appCompatDelegateImpl$PanelFeatureState.isOpen;
                            if (n16 || (n16 = this.mIsDestroyed)) break block18;
                            n16 = appCompatDelegateImpl$PanelFeatureState.featureId;
                            n12 = 0;
                            viewGroup = null;
                            n10 = 1;
                            if (!n16) {
                                callback = this.mContext.getResources().getConfiguration();
                                n16 = callback.screenLayout & 0xF;
                                n15 = 4;
                                if (n16 == n15) {
                                    n16 = n10;
                                } else {
                                    n16 = 0;
                                    callback = null;
                                }
                                if (n16) {
                                    return;
                                }
                            }
                            if ((callback = this.getWindowCallback()) != null && !(n16 = (int)(callback.onMenuOpened(n15 = appCompatDelegateImpl$PanelFeatureState.featureId, (Menu)(menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu)) ? 1 : 0))) {
                                this.closePanel(appCompatDelegateImpl$PanelFeatureState, n10 != 0);
                                return;
                            }
                            callback = this.mContext;
                            string2 = "window";
                            if ((callback = (WindowManager)callback.getSystemService(string2)) == null) {
                                return;
                            }
                            n14 = this.preparePanel(appCompatDelegateImpl$PanelFeatureState, keyEvent);
                            if (n14 == 0) {
                                return;
                            }
                            keyEvent = appCompatDelegateImpl$PanelFeatureState.decorView;
                            n15 = -1;
                            n13 = -2;
                            if (keyEvent == null || (bl2 = appCompatDelegateImpl$PanelFeatureState.refreshDecorView)) break block19;
                            keyEvent = appCompatDelegateImpl$PanelFeatureState.createdPanelView;
                            if (keyEvent == null || (keyEvent = keyEvent.getLayoutParams()) == null || (n14 = keyEvent.width) != n15) break block20;
                            n11 = n15;
                            break block21;
                        }
                        if (keyEvent == null) {
                            n14 = this.initializePanelDecor(appCompatDelegateImpl$PanelFeatureState);
                            if (n14 == 0 || (keyEvent = appCompatDelegateImpl$PanelFeatureState.decorView) == null) {
                                return;
                            }
                        } else {
                            n15 = (int)(appCompatDelegateImpl$PanelFeatureState.refreshDecorView ? 1 : 0);
                            if (n15 != 0 && (n14 = keyEvent.getChildCount()) > 0) {
                                keyEvent = appCompatDelegateImpl$PanelFeatureState.decorView;
                                keyEvent.removeAllViews();
                            }
                        }
                        if ((n14 = (int)(this.initializePanelContent(appCompatDelegateImpl$PanelFeatureState) ? 1 : 0)) == 0 || (n14 = (int)(appCompatDelegateImpl$PanelFeatureState.hasPanelItems() ? 1 : 0)) == 0) break block22;
                        keyEvent = appCompatDelegateImpl$PanelFeatureState.shownPanelView.getLayoutParams();
                        if (keyEvent == null) {
                            keyEvent = new ViewGroup.LayoutParams(n13, n13);
                        }
                        n15 = appCompatDelegateImpl$PanelFeatureState.background;
                        keyEvent2 = appCompatDelegateImpl$PanelFeatureState.decorView;
                        keyEvent2.setBackgroundResource(n15);
                        string2 = appCompatDelegateImpl$PanelFeatureState.shownPanelView.getParent();
                        bl2 = string2 instanceof ViewGroup;
                        if (bl2) {
                            string2 = (ViewGroup)string2;
                            keyEvent2 = appCompatDelegateImpl$PanelFeatureState.shownPanelView;
                            string2.removeView((View)keyEvent2);
                        }
                        string2 = appCompatDelegateImpl$PanelFeatureState.decorView;
                        keyEvent2 = appCompatDelegateImpl$PanelFeatureState.shownPanelView;
                        string2.addView((View)keyEvent2, (ViewGroup.LayoutParams)keyEvent);
                        keyEvent = appCompatDelegateImpl$PanelFeatureState.shownPanelView;
                        n14 = (int)(keyEvent.hasFocus() ? 1 : 0);
                        if (n14 == 0) {
                            keyEvent = appCompatDelegateImpl$PanelFeatureState.shownPanelView;
                            keyEvent.requestFocus();
                        }
                    }
                    n11 = n13;
                }
                appCompatDelegateImpl$PanelFeatureState.isHandled = false;
                int n17 = appCompatDelegateImpl$PanelFeatureState.x;
                int n18 = appCompatDelegateImpl$PanelFeatureState.y;
                keyEvent2 = keyEvent;
                keyEvent = new WindowManager.LayoutParams(n11, -2, n17, n18, 1002, 0x820000, -3);
                keyEvent.gravity = n12 = appCompatDelegateImpl$PanelFeatureState.gravity;
                keyEvent.windowAnimations = n12 = appCompatDelegateImpl$PanelFeatureState.windowAnimations;
                viewGroup = appCompatDelegateImpl$PanelFeatureState.decorView;
                callback.addView((View)viewGroup, (ViewGroup.LayoutParams)keyEvent);
                appCompatDelegateImpl$PanelFeatureState.isOpen = n10;
                return;
            }
            appCompatDelegateImpl$PanelFeatureState.refreshDecorView = n10;
        }
    }

    private boolean performPanelShortcut(AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, int n10, KeyEvent object, int n11) {
        MenuBuilder menuBuilder;
        boolean bl2 = object.isSystem();
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        bl2 = appCompatDelegateImpl$PanelFeatureState.isPrepared;
        if ((bl2 || (bl2 = this.preparePanel(appCompatDelegateImpl$PanelFeatureState, (KeyEvent)object))) && (menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu) != null) {
            bl3 = menuBuilder.performShortcut(n10, (KeyEvent)object, n11);
        }
        if (bl3) {
            n10 = 1;
            int n12 = n11 & 1;
            if (n12 == 0 && (object = this.mDecorContentParent) == null) {
                this.closePanel(appCompatDelegateImpl$PanelFeatureState, n10 != 0);
            }
        }
        return bl3;
    }

    /*
     * WARNING - void declaration
     */
    private boolean preparePanel(AppCompatDelegateImpl$PanelFeatureState object, KeyEvent object2) {
        boolean bl2;
        Object object3;
        void var6_10;
        int n10;
        int n11;
        View view;
        boolean bl4 = this.mIsDestroyed;
        if (bl4) {
            return false;
        }
        bl4 = ((AppCompatDelegateImpl$PanelFeatureState)object).isPrepared;
        int bl5 = 1;
        if (bl4) {
            return bl5 != 0;
        }
        Object object4 = this.mPreparedPanel;
        if (object4 != null && object4 != object) {
            this.closePanel((AppCompatDelegateImpl$PanelFeatureState)object4, false);
        }
        if ((object4 = this.getWindowCallback()) != null) {
            int bl3 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId;
            ((AppCompatDelegateImpl$PanelFeatureState)object).createdPanelView = view = object4.onCreatePanelView(bl3);
        }
        if ((n11 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId) != 0 && n11 != (n10 = 108)) {
            boolean bl3 = false;
            view = null;
        } else {
            int n12 = bl5;
        }
        if (var6_10 != false && (object3 = this.mDecorContentParent) != null) {
            object3.setMenuPrepared();
        }
        if (!((object3 = ((AppCompatDelegateImpl$PanelFeatureState)object).createdPanelView) != null || var6_10 != false && (bl2 = (object3 = this.peekSupportActionBar()) instanceof ToolbarActionBar))) {
            void var13_27;
            void var13_23;
            MenuBuilder menuBuilder;
            boolean bl6;
            object3 = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
            if (object3 == null || (bl6 = ((AppCompatDelegateImpl$PanelFeatureState)object).refreshMenuContent)) {
                boolean bl7;
                if (!(object3 != null || (bl7 = this.initializePanelMenu((AppCompatDelegateImpl$PanelFeatureState)object)) && (object3 = ((AppCompatDelegateImpl$PanelFeatureState)object).menu) != null)) {
                    return false;
                }
                if (var6_10 != false && (object3 = this.mDecorContentParent) != null) {
                    object3 = this.mActionMenuPresenterCallback;
                    if (object3 == null) {
                        this.mActionMenuPresenterCallback = object3 = new AppCompatDelegateImpl$ActionMenuPresenterCallback(this);
                    }
                    object3 = this.mDecorContentParent;
                    menuBuilder = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
                    AppCompatDelegateImpl$ActionMenuPresenterCallback appCompatDelegateImpl$ActionMenuPresenterCallback = this.mActionMenuPresenterCallback;
                    object3.setMenu(menuBuilder, appCompatDelegateImpl$ActionMenuPresenterCallback);
                }
                object3 = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
                ((MenuBuilder)object3).stopDispatchingItemsChanged();
                int n13 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId;
                menuBuilder = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
                boolean bl8 = object4.onCreatePanelMenu(n13, (Menu)menuBuilder);
                if (!bl8) {
                    ((AppCompatDelegateImpl$PanelFeatureState)object).setMenu(null);
                    if (var6_10 != false && (object = this.mDecorContentParent) != null) {
                        object2 = this.mActionMenuPresenterCallback;
                        object.setMenu(null, (MenuPresenter$Callback)object2);
                    }
                    return false;
                }
                ((AppCompatDelegateImpl$PanelFeatureState)object).refreshMenuContent = false;
            }
            ((AppCompatDelegateImpl$PanelFeatureState)object).menu.stopDispatchingItemsChanged();
            object3 = ((AppCompatDelegateImpl$PanelFeatureState)object).frozenActionViewState;
            if (object3 != null) {
                menuBuilder = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
                menuBuilder.restoreActionViewStates((Bundle)object3);
                ((AppCompatDelegateImpl$PanelFeatureState)object).frozenActionViewState = null;
            }
            if (!(bl4 = object4.onPreparePanel(0, (View)(object3 = ((AppCompatDelegateImpl$PanelFeatureState)object).createdPanelView), (Menu)(menuBuilder = ((AppCompatDelegateImpl$PanelFeatureState)object).menu)))) {
                if (var6_10 != false && (object2 = this.mDecorContentParent) != null) {
                    object4 = this.mActionMenuPresenterCallback;
                    object2.setMenu(null, (MenuPresenter$Callback)object4);
                }
                ((AppCompatDelegateImpl$PanelFeatureState)object).menu.startDispatchingItemsChanged();
                return false;
            }
            if (object2 != null) {
                int n14 = object2.getDeviceId();
            } else {
                int n15 = -1;
            }
            object2 = KeyCharacterMap.load((int)var13_23);
            int n16 = object2.getKeyboardType();
            if (n16 != bl5) {
                int n17 = bl5;
            } else {
                boolean bl9 = false;
                object2 = null;
            }
            ((AppCompatDelegateImpl$PanelFeatureState)object).qwertyMode = var13_27;
            object4 = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
            ((MenuBuilder)object4).setQwertyMode((boolean)var13_27);
            object2 = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
            ((MenuBuilder)object2).startDispatchingItemsChanged();
        }
        ((AppCompatDelegateImpl$PanelFeatureState)object).isPrepared = bl5;
        ((AppCompatDelegateImpl$PanelFeatureState)object).isHandled = false;
        this.mPreparedPanel = object;
        return bl5 != 0;
    }

    private void reopenMenu(boolean bl2) {
        boolean bl3;
        DecorContentParent decorContentParent = this.mDecorContentParent;
        int n10 = 1;
        if (decorContentParent != null && (bl3 = decorContentParent.canShowOverflowMenu()) && (!(bl3 = (decorContentParent = ViewConfiguration.get((Context)this.mContext)).hasPermanentMenuKey()) || (bl3 = (decorContentParent = this.mDecorContentParent).isOverflowMenuShowPending()))) {
            decorContentParent = this.getWindowCallback();
            Object object = this.mDecorContentParent;
            boolean bl4 = object.isOverflowMenuShowing();
            int n11 = 108;
            if (bl4 && bl2) {
                Object object2 = this.mDecorContentParent;
                object2.hideOverflowMenu();
                bl2 = this.mIsDestroyed;
                if (!bl2) {
                    object2 = this.getPanelState((int)0, (boolean)n10).menu;
                    decorContentParent.onPanelClosed(n11, (Menu)object2);
                }
            } else if (decorContentParent != null && !(bl2 = this.mIsDestroyed)) {
                Object object3;
                bl2 = this.mInvalidatePanelMenuPosted;
                if (bl2 && (bl2 = this.mInvalidatePanelMenuFeatures & n10)) {
                    object3 = this.mWindow.getDecorView();
                    object = this.mInvalidatePanelMenuRunnable;
                    object3.removeCallbacks((Runnable)object);
                    object3 = this.mInvalidatePanelMenuRunnable;
                    object3.run();
                }
                object3 = this.getPanelState(0, n10 != 0);
                MenuBuilder menuBuilder = ((AppCompatDelegateImpl$PanelFeatureState)object3).menu;
                if (menuBuilder != null && !(bl4 = ((AppCompatDelegateImpl$PanelFeatureState)object3).refreshMenuContent) && (n10 = decorContentParent.onPreparePanel(0, (View)(object = ((AppCompatDelegateImpl$PanelFeatureState)object3).createdPanelView), menuBuilder)) != 0) {
                    object3 = ((AppCompatDelegateImpl$PanelFeatureState)object3).menu;
                    decorContentParent.onMenuOpened(n11, (Menu)object3);
                    object3 = this.mDecorContentParent;
                    object3.showOverflowMenu();
                }
            }
            return;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.getPanelState(0, n10 != 0);
        appCompatDelegateImpl$PanelFeatureState.refreshDecorView = n10;
        this.closePanel(appCompatDelegateImpl$PanelFeatureState, false);
        this.openPanel(appCompatDelegateImpl$PanelFeatureState, null);
    }

    private int sanitizeWindowFeatureId(int n10) {
        String string2 = "AppCompatDelegate";
        int n11 = 8;
        if (n10 == n11) {
            Log.i((String)string2, (String)"You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        }
        n11 = 9;
        if (n10 == n11) {
            String string3 = "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.";
            Log.i((String)string2, (String)string3);
            n10 = 109;
        }
        return n10;
    }

    private boolean shouldInheritContext(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View view = this.mWindow.getDecorView();
        while (true) {
            boolean bl2;
            if (viewParent == null) {
                return true;
            }
            if (viewParent == view || !(bl2 = viewParent instanceof View)) break;
            ViewParent viewParent2 = viewParent;
            viewParent2 = (View)viewParent;
            bl2 = ViewCompat.isAttachedToWindow((View)viewParent2);
            if (bl2) break;
            viewParent = viewParent.getParent();
        }
        return false;
    }

    private void throwFeatureRequestIfSubDecorInstalled() {
        boolean bl2 = this.mSubDecorInstalled;
        if (!bl2) {
            return;
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Window feature must be requested before adding content");
        throw androidRuntimeException;
    }

    private AppCompatActivity tryUnwrapContext() {
        Context context = this.mContext;
        while (context != null) {
            boolean bl2 = context instanceof AppCompatActivity;
            if (bl2) {
                return (AppCompatActivity)context;
            }
            bl2 = context instanceof ContextWrapper;
            if (!bl2) break;
            context = ((ContextWrapper)context).getBaseContext();
        }
        return null;
    }

    private boolean updateForNightMode(int n10, boolean bl2) {
        float f10;
        Object object;
        boolean bl3;
        Context context = this.mContext;
        context = this.createOverrideConfigurationForDayNight(context, n10, null);
        boolean bl4 = this.isActivityManifestHandlingUiMode();
        Configuration configuration = this.mContext.getResources().getConfiguration();
        int n11 = configuration.uiMode & 0x30;
        int n12 = context.uiMode & 0x30;
        boolean bl5 = true;
        float f11 = Float.MIN_VALUE;
        if (n11 != n12 && bl2 && !bl4 && (bl2 = this.mBaseContextAttached) && ((bl2 = sCanReturnDifferentContext) || (bl2 = this.mCreated)) && (bl3 = (object = this.mHost) instanceof Activity) && !(bl2 = (object = (Activity)object).isChild())) {
            object = (Activity)this.mHost;
            ActivityCompat.recreate((Activity)object);
            bl2 = bl5;
            f10 = f11;
        } else {
            bl2 = false;
            f10 = 0.0f;
            object = null;
        }
        if (!bl2 && n11 != n12) {
            this.updateResourcesConfigurationForNightMode(n12, bl4, null);
        } else {
            bl5 = bl2;
            f11 = f10;
        }
        if (bl5 && (n12 = (object = this.mHost) instanceof AppCompatActivity) != 0) {
            object = (AppCompatActivity)object;
            ((AppCompatActivity)object).onNightModeChanged(n10);
        }
        return bl5;
    }

    private void updateResourcesConfigurationForNightMode(int n10, boolean bl2, Configuration object) {
        Resources resources = this.mContext.getResources();
        Configuration configuration = resources.getConfiguration();
        Configuration configuration2 = new Configuration(configuration);
        if (object != null) {
            configuration2.updateFrom(object);
        }
        object = resources.getConfiguration();
        int n11 = object.uiMode & 0xFFFFFFCF;
        configuration2.uiMode = n10 |= n11;
        Object object2 = null;
        resources.updateConfiguration(configuration2, null);
        n10 = Build.VERSION.SDK_INT;
        n11 = 26;
        if (n10 < n11) {
            ResourcesFlusher.flush(resources);
        }
        if ((n11 = this.mThemeResId) != 0) {
            resources = this.mContext;
            resources.setTheme(n11);
            n11 = 23;
            if (n10 >= n11) {
                object2 = this.mContext.getTheme();
                n11 = this.mThemeResId;
                boolean bl3 = true;
                object2.applyStyle(n11, bl3);
            }
        }
        if (bl2 && (bl2 = (object2 = this.mHost) instanceof Activity)) {
            bl2 = (object2 = (Activity)object2) instanceof LifecycleOwner;
            if (bl2) {
                Object object3 = object2;
                object3 = ((LifecycleOwner)object2).getLifecycle().getCurrentState();
                bl2 = ((Lifecycle$State)((Object)object3)).isAtLeast((Lifecycle$State)((Object)(object = Lifecycle$State.STARTED)));
                if (bl2) {
                    ((Activity)object2).onConfigurationChanged(configuration2);
                }
            } else {
                bl2 = this.mStarted;
                if (bl2) {
                    object2.onConfigurationChanged(configuration2);
                }
            }
        }
    }

    private void updateStatusGuardColor(View view) {
        Context context;
        int n10 = ViewCompat.getWindowSystemUiVisibility(view) & 0x2000;
        if (n10 != 0) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        if (n10 != 0) {
            context = this.mContext;
            int n11 = R$color.abc_decor_view_status_guard_light;
            n10 = ContextCompat.getColor(context, n11);
        } else {
            context = this.mContext;
            int n12 = R$color.abc_decor_view_status_guard;
            n10 = ContextCompat.getColor(context, n12);
        }
        view.setBackgroundColor(n10);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.ensureSubDecor();
        ((ViewGroup)this.mSubDecor.findViewById(0x1020002)).addView(view, layoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public boolean applyDayNight() {
        return this.applyDayNight(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Context attachBaseContext2(Context context) {
        Object object;
        int n10;
        block13: {
            boolean bl2;
            block12: {
                Object object2;
                this.mBaseContextAttached = bl2 = true;
                n10 = this.calculateNightMode();
                n10 = this.mapNightMode(context, n10);
                int n11 = sCanApplyOverrideConfiguration;
                int n12 = 0;
                Configuration configuration = null;
                if (n11 != 0 && (n11 = context instanceof android.view.ContextThemeWrapper) != 0) {
                    object = this.createOverrideConfigurationForDayNight(context, n10, null);
                    object2 = context;
                    try {
                        object2 = (android.view.ContextThemeWrapper)context;
                        AppCompatDelegateImpl$ContextThemeWrapperCompatApi17Impl.applyOverrideConfiguration((android.view.ContextThemeWrapper)object2, (Configuration)object);
                        return context;
                    }
                    catch (IllegalStateException illegalStateException) {}
                }
                if ((n11 = context instanceof ContextThemeWrapper) != 0) {
                    object = this.createOverrideConfigurationForDayNight(context, n10, null);
                    object2 = context;
                    try {
                        object2 = (ContextThemeWrapper)context;
                        ((ContextThemeWrapper)((Object)object2)).applyOverrideConfiguration((Configuration)object);
                        return context;
                    }
                    catch (IllegalStateException illegalStateException) {}
                }
                if ((n11 = sCanReturnDifferentContext) == 0) {
                    return super.attachBaseContext2(context);
                }
                n11 = Build.VERSION.SDK_INT;
                int n13 = 17;
                if (n11 >= n13) {
                    int n14;
                    object = new Configuration();
                    ((Configuration)object).uiMode = -1;
                    n13 = 0;
                    ((Configuration)object).fontScale = 0.0f;
                    object = AppCompatDelegateImpl$Api17Impl.createConfigurationContext(context, (Configuration)object).getResources().getConfiguration();
                    object2 = context.getResources().getConfiguration();
                    ((Configuration)object).uiMode = n14 = ((Configuration)object2).uiMode;
                    n14 = (int)(object.equals((Configuration)object2) ? 1 : 0);
                    if (n14 == 0) {
                        configuration = AppCompatDelegateImpl.generateConfigDelta((Configuration)object, (Configuration)object2);
                    }
                }
                Configuration configuration2 = this.createOverrideConfigurationForDayNight(context, n10, configuration);
                n12 = R$style.Theme_AppCompat_Empty;
                object = new ContextThemeWrapper(context, n12);
                ((ContextThemeWrapper)((Object)object)).applyOverrideConfiguration(configuration2);
                n10 = 0;
                configuration2 = null;
                try {
                    context = context.getTheme();
                    if (context != null) break block12;
                    bl2 = false;
                }
                catch (NullPointerException nullPointerException) {
                    break block13;
                }
            }
            n10 = (int)(bl2 ? 1 : 0);
        }
        if (n10 != 0) {
            context = ((ContextThemeWrapper)((Object)object)).getTheme();
            ResourcesCompat$ThemeCompat.rebase((Resources.Theme)context);
        }
        return super.attachBaseContext2((Context)object);
    }

    public void callOnPanelClosed(int n10, AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState, Menu menu2) {
        boolean bl2;
        if (menu2 == null) {
            AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArray;
            int n11;
            if (appCompatDelegateImpl$PanelFeatureState == null && n10 >= 0 && n10 < (n11 = (appCompatDelegateImpl$PanelFeatureStateArray = this.mPanels).length)) {
                appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArray[n10];
            }
            if (appCompatDelegateImpl$PanelFeatureState != null) {
                menu2 = appCompatDelegateImpl$PanelFeatureState.menu;
            }
        }
        if (appCompatDelegateImpl$PanelFeatureState != null && !(bl2 = appCompatDelegateImpl$PanelFeatureState.isOpen)) {
            return;
        }
        bl2 = this.mIsDestroyed;
        if (!bl2) {
            appCompatDelegateImpl$PanelFeatureState = this.mAppCompatWindowCallback.getWrapped();
            appCompatDelegateImpl$PanelFeatureState.onPanelClosed(n10, menu2);
        }
    }

    public void checkCloseActionMenu(MenuBuilder menuBuilder) {
        int n10;
        boolean bl2 = this.mClosingActionMenu;
        if (bl2) {
            return;
        }
        this.mClosingActionMenu = bl2 = true;
        this.mDecorContentParent.dismissPopups();
        Window.Callback callback = this.getWindowCallback();
        if (callback != null && (n10 = this.mIsDestroyed) == 0) {
            n10 = 108;
            callback.onPanelClosed(n10, (Menu)menuBuilder);
        }
        this.mClosingActionMenu = false;
    }

    public void closePanel(int n10) {
        boolean bl2 = true;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.getPanelState(n10, bl2);
        this.closePanel(appCompatDelegateImpl$PanelFeatureState, bl2);
    }

    public void closePanel(AppCompatDelegateImpl$PanelFeatureState object, boolean bl2) {
        boolean bl3;
        ViewGroup viewGroup;
        boolean bl4;
        Object object2;
        int n10;
        if (bl2 && (n10 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId) == 0 && (object2 = this.mDecorContentParent) != null && (n10 = (int)(object2.isOverflowMenuShowing() ? 1 : 0)) != 0) {
            object = ((AppCompatDelegateImpl$PanelFeatureState)object).menu;
            this.checkCloseActionMenu((MenuBuilder)object);
            return;
        }
        object2 = (WindowManager)this.mContext.getSystemService("window");
        if (object2 != null && (bl4 = ((AppCompatDelegateImpl$PanelFeatureState)object).isOpen) && (viewGroup = ((AppCompatDelegateImpl$PanelFeatureState)object).decorView) != null) {
            object2.removeView((View)viewGroup);
            if (bl2) {
                int n11 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId;
                this.callOnPanelClosed(n11, (AppCompatDelegateImpl$PanelFeatureState)object, null);
            }
        }
        ((AppCompatDelegateImpl$PanelFeatureState)object).isPrepared = false;
        ((AppCompatDelegateImpl$PanelFeatureState)object).isHandled = false;
        ((AppCompatDelegateImpl$PanelFeatureState)object).isOpen = false;
        ((AppCompatDelegateImpl$PanelFeatureState)object).shownPanelView = null;
        ((AppCompatDelegateImpl$PanelFeatureState)object).refreshDecorView = bl3 = true;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.mPreparedPanel;
        if (appCompatDelegateImpl$PanelFeatureState == object) {
            this.mPreparedPanel = null;
        }
    }

    public View createView(View view, String string2, Context context, AttributeSet attributeSet) {
        int n10;
        boolean bl2;
        String string3;
        Object object;
        Object object2;
        block14: {
            int n11;
            block12: {
                int n12;
                block16: {
                    Object object3;
                    block15: {
                        int n13;
                        block13: {
                            object3 = this.mAppCompatViewInflater;
                            n11 = 0;
                            if (object3 == null) {
                                object3 = this.mContext;
                                object2 = R$styleable.AppCompatTheme;
                                object3 = object3.obtainStyledAttributes(object2);
                                n13 = R$styleable.AppCompatTheme_viewInflaterClass;
                                if ((object3 = object3.getString(n13)) == null) {
                                    this.mAppCompatViewInflater = object3 = new AppCompatViewInflater();
                                } else {
                                    object2 = Class.forName((String)object3);
                                    object = new Class[]{};
                                    object2 = object2.getDeclaredConstructor((Class<?>[])object);
                                    object = new Object[]{};
                                    object2 = object2.newInstance(object);
                                    object2 = (AppCompatViewInflater)object2;
                                    try {
                                        this.mAppCompatViewInflater = object2;
                                    }
                                    catch (Throwable throwable) {
                                        object = new StringBuilder();
                                        string3 = "Failed to instantiate custom view inflater ";
                                        object.append(string3);
                                        object.append((String)object3);
                                        object.append(". Falling back to default.");
                                        object3 = object.toString();
                                        object = "AppCompatDelegate";
                                        Log.i((String)object, (String)object3, (Throwable)throwable);
                                        this.mAppCompatViewInflater = object3 = new AppCompatViewInflater();
                                    }
                                }
                            }
                            bl2 = IS_PRE_LOLLIPOP;
                            n12 = 1;
                            if (!bl2) break block12;
                            object2 = this.mLayoutIncludeDetector;
                            if (object2 == null) {
                                object2 = new LayoutIncludeDetector;
                                object2();
                                this.mLayoutIncludeDetector = object2;
                            }
                            if ((n13 = (int)((object2 = (Object)this.mLayoutIncludeDetector).detect(attributeSet) ? 1 : 0)) == 0) break block13;
                            n10 = n12;
                            break block14;
                        }
                        n13 = attributeSet instanceof XmlPullParser;
                        if (n13 == 0) break block15;
                        object2 = attributeSet;
                        object2 = (XmlPullParser)attributeSet;
                        n13 = object2.getDepth();
                        if (n13 <= n12) break block12;
                        break block16;
                    }
                    object3 = view;
                    object3 = (ViewParent)view;
                    n12 = this.shouldInheritContext((ViewParent)object3);
                }
                n11 = n12;
            }
            n10 = n11;
        }
        object2 = this.mAppCompatViewInflater;
        boolean bl3 = VectorEnabledTintResources.shouldBeUsed();
        object = view;
        string3 = string2;
        return object2.createView(view, string2, context, attributeSet, n10 != 0, bl2, true, bl3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void dismissPopups() {
        boolean bl2;
        Object object = this.mDecorContentParent;
        if (object != null) {
            object.dismissPopups();
        }
        if ((object = this.mActionModePopup) != null) {
            object = this.mWindow.getDecorView();
            Runnable runnable = this.mShowActionModePopup;
            object.removeCallbacks(runnable);
            object = this.mActionModePopup;
            bl2 = object.isShowing();
            if (bl2) {
                try {
                    object = this.mActionModePopup;
                    object.dismiss();
                }
                catch (IllegalArgumentException illegalArgumentException) {}
            }
            bl2 = false;
            object = null;
            this.mActionModePopup = null;
        }
        this.endOnGoingFadeAnimation();
        bl2 = false;
        object = this.getPanelState(0, false);
        if (object != null && (object = ((AppCompatDelegateImpl$PanelFeatureState)object).menu) != null) {
            ((MenuBuilder)object).close();
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int n10;
        Object object = this.mHost;
        int n11 = object instanceof KeyEventDispatcher$Component;
        boolean bl2 = true;
        if ((n11 != 0 || (n10 = object instanceof AppCompatDialog) != 0) && (object = this.mWindow.getDecorView()) != null && (n10 = (int)(KeyEventDispatcher.dispatchBeforeHierarchy((View)object, keyEvent) ? 1 : 0)) != 0) {
            return bl2;
        }
        n10 = keyEvent.getKeyCode();
        if (n10 == (n11 = 82) && (n10 = (int)((object = this.mAppCompatWindowCallback.getWrapped()).dispatchKeyEvent(keyEvent) ? 1 : 0)) != 0) {
            return bl2;
        }
        n10 = keyEvent.getKeyCode();
        n11 = keyEvent.getAction();
        if (n11 != 0) {
            bl2 = false;
        }
        boolean bl3 = bl2 ? this.onKeyDown(n10, keyEvent) : this.onKeyUp(n10, keyEvent);
        return bl3;
    }

    public void doInvalidatePanelMenu(int n10) {
        DecorContentParent decorContentParent;
        int n11 = 1;
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.getPanelState(n10, n11 != 0);
        MenuBuilder menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu;
        if (menuBuilder != null) {
            menuBuilder = new Bundle();
            MenuBuilder menuBuilder2 = appCompatDelegateImpl$PanelFeatureState.menu;
            menuBuilder2.saveActionViewStates((Bundle)menuBuilder);
            int n12 = menuBuilder.size();
            if (n12 > 0) {
                appCompatDelegateImpl$PanelFeatureState.frozenActionViewState = menuBuilder;
            }
            appCompatDelegateImpl$PanelFeatureState.menu.stopDispatchingItemsChanged();
            menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu;
            menuBuilder.clear();
        }
        appCompatDelegateImpl$PanelFeatureState.refreshMenuContent = n11;
        appCompatDelegateImpl$PanelFeatureState.refreshDecorView = n11;
        n11 = 108;
        if ((n10 == n11 || n10 == 0) && (decorContentParent = this.mDecorContentParent) != null) {
            n10 = 0;
            decorContentParent = null;
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState2 = this.getPanelState(0, false);
            if (appCompatDelegateImpl$PanelFeatureState2 != null) {
                appCompatDelegateImpl$PanelFeatureState2.isPrepared = false;
                n10 = 0;
                decorContentParent = null;
                this.preparePanel(appCompatDelegateImpl$PanelFeatureState2, null);
            }
        }
    }

    public void endOnGoingFadeAnimation() {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.mFadeAnim;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.cancel();
        }
    }

    public AppCompatDelegateImpl$PanelFeatureState findMenuPanel(Menu menu2) {
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArray = this.mPanels;
        int n10 = appCompatDelegateImpl$PanelFeatureStateArray != null ? appCompatDelegateImpl$PanelFeatureStateArray.length : 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            MenuBuilder menuBuilder;
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = appCompatDelegateImpl$PanelFeatureStateArray[i10];
            if (appCompatDelegateImpl$PanelFeatureState == null || (menuBuilder = appCompatDelegateImpl$PanelFeatureState.menu) != menu2) continue;
            return appCompatDelegateImpl$PanelFeatureState;
        }
        return null;
    }

    public View findViewById(int n10) {
        this.ensureSubDecor();
        return this.mWindow.findViewById(n10);
    }

    public final Context getActionBarThemedContext() {
        ActionBar actionBar = this.getSupportActionBar();
        actionBar = actionBar != null ? actionBar.getThemedContext() : null;
        if (actionBar == null) {
            actionBar = this.mContext;
        }
        return actionBar;
    }

    public final AppCompatDelegateImpl$AutoNightModeManager getAutoTimeNightModeManager() {
        Context context = this.mContext;
        return this.getAutoTimeNightModeManager(context);
    }

    public final ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        AppCompatDelegateImpl$ActionBarDrawableToggleImpl appCompatDelegateImpl$ActionBarDrawableToggleImpl = new AppCompatDelegateImpl$ActionBarDrawableToggleImpl(this);
        return appCompatDelegateImpl$ActionBarDrawableToggleImpl;
    }

    public int getLocalNightMode() {
        return this.mLocalNightMode;
    }

    public MenuInflater getMenuInflater() {
        MenuInflater menuInflater = this.mMenuInflater;
        if (menuInflater == null) {
            this.initWindowDecorActionBar();
            ActionBar actionBar = this.mActionBar;
            actionBar = actionBar != null ? actionBar.getThemedContext() : this.mContext;
            this.mMenuInflater = menuInflater = new SupportMenuInflater((Context)actionBar);
        }
        return this.mMenuInflater;
    }

    public AppCompatDelegateImpl$PanelFeatureState getPanelState(int n10, boolean bl2) {
        Object object;
        int n11;
        AppCompatDelegateImpl$PanelFeatureState[] appCompatDelegateImpl$PanelFeatureStateArray = this.mPanels;
        if (appCompatDelegateImpl$PanelFeatureStateArray == null || (n11 = appCompatDelegateImpl$PanelFeatureStateArray.length) <= n10) {
            n11 = n10 + 1;
            object = new AppCompatDelegateImpl$PanelFeatureState[n11];
            if (appCompatDelegateImpl$PanelFeatureStateArray != null) {
                int n12 = appCompatDelegateImpl$PanelFeatureStateArray.length;
                System.arraycopy(appCompatDelegateImpl$PanelFeatureStateArray, 0, object, 0, n12);
            }
            this.mPanels = object;
            appCompatDelegateImpl$PanelFeatureStateArray = object;
        }
        if ((object = appCompatDelegateImpl$PanelFeatureStateArray[n10]) == null) {
            appCompatDelegateImpl$PanelFeatureStateArray[n10] = object = new AppCompatDelegateImpl$PanelFeatureState(n10);
        }
        return object;
    }

    public ViewGroup getSubDecor() {
        return this.mSubDecor;
    }

    public ActionBar getSupportActionBar() {
        this.initWindowDecorActionBar();
        return this.mActionBar;
    }

    public final CharSequence getTitle() {
        Object object = this.mHost;
        boolean bl2 = object instanceof Activity;
        if (bl2) {
            return ((Activity)object).getTitle();
        }
        return this.mTitle;
    }

    public final Window.Callback getWindowCallback() {
        return this.mWindow.getCallback();
    }

    public boolean hasWindowFeature(int n10) {
        Window window;
        int n11;
        int n12 = this.sanitizeWindowFeatureId(n10);
        if (n12 != (n11 = 1)) {
            int n13 = 2;
            if (n12 != n13) {
                n13 = 5;
                if (n12 != n13) {
                    n13 = 10;
                    if (n12 != n13) {
                        n13 = 108;
                        if (n12 != n13) {
                            n13 = 109;
                            if (n12 != n13) {
                                n12 = 0;
                                window = null;
                            } else {
                                n12 = (int)(this.mOverlayActionBar ? 1 : 0);
                            }
                        } else {
                            n12 = (int)(this.mHasActionBar ? 1 : 0);
                        }
                    } else {
                        n12 = (int)(this.mOverlayActionMode ? 1 : 0);
                    }
                } else {
                    n12 = (int)(this.mFeatureIndeterminateProgress ? 1 : 0);
                }
            } else {
                n12 = this.mFeatureProgress;
            }
        } else {
            n12 = (int)(this.mWindowNoTitle ? 1 : 0);
        }
        if (n12 == 0 && (n10 = (int)((window = this.mWindow).hasFeature(n10) ? 1 : 0)) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void installViewFactory() {
        Object object = LayoutInflater.from((Context)this.mContext);
        Object object2 = object.getFactory();
        if (object2 == null) {
            LayoutInflaterCompat.setFactory2(object, this);
        } else {
            boolean bl2 = (object = object.getFactory2()) instanceof AppCompatDelegateImpl;
            if (!bl2) {
                object = "AppCompatDelegate";
                object2 = "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's";
                Log.i((String)object, (String)object2);
            }
        }
    }

    public void invalidateOptionsMenu() {
        boolean bl2;
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null && (bl2 = actionBar.invalidateOptionsMenu())) {
            return;
        }
        this.invalidatePanelMenu(0);
    }

    public boolean isHandleNativeActionModesEnabled() {
        return this.mHandleNativeActionModes;
    }

    public int mapNightMode(Context object, int n10) {
        int n11 = -100;
        int n12 = -1;
        if (n10 != n11) {
            if (n10 != n12) {
                if (n10 != 0) {
                    n11 = 1;
                    if (n10 != n11 && n10 != (n11 = 2)) {
                        n11 = 3;
                        if (n10 == n11) {
                            return this.getAutoBatteryNightModeManager((Context)object).getApplyableNightMode();
                        }
                        object = new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        throw object;
                    }
                } else {
                    n10 = Build.VERSION.SDK_INT;
                    n11 = 23;
                    if (n10 >= n11) {
                        Context context = object.getApplicationContext();
                        String string2 = "uimode";
                        n10 = (context = (UiModeManager)context.getSystemService(string2)).getNightMode();
                        if (n10 == 0) {
                            return n12;
                        }
                    }
                    return this.getAutoTimeNightModeManager((Context)object).getApplyableNightMode();
                }
            }
            return n10;
        }
        return n12;
    }

    public boolean onBackPressed() {
        boolean bl2;
        Object object = this.mActionMode;
        boolean bl3 = true;
        if (object != null) {
            ((ActionMode)object).finish();
            return bl3;
        }
        object = this.getSupportActionBar();
        if (object != null && (bl2 = ((ActionBar)object).collapseActionView())) {
            return bl3;
        }
        return false;
    }

    public void onConfigurationChanged(Configuration object) {
        Object object2;
        boolean bl2 = this.mHasActionBar;
        if (bl2 && (bl2 = this.mSubDecorInstalled) && (object2 = this.getSupportActionBar()) != null) {
            ((ActionBar)object2).onConfigurationChanged((Configuration)object);
        }
        object = AppCompatDrawableManager.get();
        object2 = this.mContext;
        ((AppCompatDrawableManager)object).onConfigurationChanged((Context)object2);
        this.applyDayNight(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCreate(Bundle bundle) {
        boolean bl2;
        this.mBaseContextAttached = bl2 = true;
        this.applyDayNight(false);
        this.ensureWindow();
        Object object = this.mHost;
        boolean bl3 = object instanceof Activity;
        if (bl3) {
            bl3 = false;
            String string2 = null;
            try {
                object = (Activity)object;
                string2 = NavUtils.getParentActivityName((Activity)object);
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            if (string2 != null) {
                object = this.peekSupportActionBar();
                if (object == null) {
                    this.mEnableDefaultActionBarUp = bl2;
                } else {
                    ((ActionBar)object).setDefaultDisplayHomeAsUpEnabled(bl2);
                }
            }
            AppCompatDelegate.addActiveDelegate(this);
        }
        this.mCreated = bl2;
    }

    public final View onCreateView(View view, String string2, Context context, AttributeSet attributeSet) {
        return this.createView(view, string2, context, attributeSet);
    }

    public View onCreateView(String string2, Context context, AttributeSet attributeSet) {
        return this.onCreateView(null, string2, context, attributeSet);
    }

    public void onDestroy() {
        Object object;
        Object object2 = this.mHost;
        int n10 = object2 instanceof Activity;
        if (n10 != 0) {
            AppCompatDelegate.removeActivityDelegate(this);
        }
        if ((n10 = this.mInvalidatePanelMenuPosted) != 0) {
            object2 = this.mWindow.getDecorView();
            object = this.mInvalidatePanelMenuRunnable;
            object2.removeCallbacks((Runnable)object);
        }
        object2 = null;
        this.mStarted = false;
        this.mIsDestroyed = true;
        n10 = this.mLocalNightMode;
        int n11 = -100;
        if (n10 != n11 && (n11 = (object2 = this.mHost) instanceof Activity) != 0 && (n10 = (int)((object2 = (Activity)object2).isChangingConfigurations() ? 1 : 0)) != 0) {
            object2 = sLocalNightModes;
            object = this.mHost.getClass().getName();
            int n12 = this.mLocalNightMode;
            Integer n13 = n12;
            ((SimpleArrayMap)object2).put(object, n13);
        } else {
            object2 = sLocalNightModes;
            object = this.mHost.getClass().getName();
            ((SimpleArrayMap)object2).remove(object);
        }
        object2 = this.mActionBar;
        if (object2 != null) {
            ((ActionBar)object2).onDestroy();
        }
        this.cleanupAutoManagers();
    }

    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        int n11 = 4;
        boolean bl2 = true;
        if (n10 != n11) {
            n11 = 82;
            if (n10 == n11) {
                this.onKeyDownPanel(0, keyEvent);
                return bl2;
            }
        } else {
            n10 = keyEvent.getFlags() & 0x80;
            if (n10 == 0) {
                bl2 = false;
            }
            this.mLongPressBackDown = bl2;
        }
        return false;
    }

    public boolean onKeyShortcut(int n10, KeyEvent keyEvent) {
        int n11;
        ActionBar actionBar = this.getSupportActionBar();
        boolean bl2 = true;
        if (actionBar != null && (n10 = (int)(actionBar.onKeyShortcut(n10, keyEvent) ? 1 : 0)) != 0) {
            return bl2;
        }
        AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.mPreparedPanel;
        if (appCompatDelegateImpl$PanelFeatureState != null && (n10 = (int)(this.performPanelShortcut(appCompatDelegateImpl$PanelFeatureState, n11 = keyEvent.getKeyCode(), keyEvent, (int)(bl2 ? 1 : 0)) ? 1 : 0)) != 0) {
            appCompatDelegateImpl$PanelFeatureState = this.mPreparedPanel;
            if (appCompatDelegateImpl$PanelFeatureState != null) {
                appCompatDelegateImpl$PanelFeatureState.isHandled = bl2;
            }
            return bl2;
        }
        appCompatDelegateImpl$PanelFeatureState = this.mPreparedPanel;
        n11 = 0;
        actionBar = null;
        if (appCompatDelegateImpl$PanelFeatureState == null) {
            appCompatDelegateImpl$PanelFeatureState = this.getPanelState(0, bl2);
            this.preparePanel(appCompatDelegateImpl$PanelFeatureState, keyEvent);
            int n12 = keyEvent.getKeyCode();
            boolean bl3 = this.performPanelShortcut(appCompatDelegateImpl$PanelFeatureState, n12, keyEvent, (int)(bl2 ? 1 : 0));
            appCompatDelegateImpl$PanelFeatureState.isPrepared = false;
            if (bl3) {
                return bl2;
            }
        }
        return false;
    }

    public boolean onKeyUp(int n10, KeyEvent object) {
        int n11 = 4;
        boolean bl2 = true;
        if (n10 != n11) {
            n11 = 82;
            if (n10 == n11) {
                this.onKeyUpPanel(0, (KeyEvent)object);
                return bl2;
            }
        } else {
            n10 = (int)(this.mLongPressBackDown ? 1 : 0);
            this.mLongPressBackDown = false;
            object = this.getPanelState(0, false);
            if (object != null && (n11 = (int)(object.isOpen ? 1 : 0)) != 0) {
                if (n10 == 0) {
                    this.closePanel((AppCompatDelegateImpl$PanelFeatureState)object, bl2);
                }
                return bl2;
            }
            n10 = (int)(this.onBackPressed() ? 1 : 0);
            if (n10 != 0) {
                return bl2;
            }
        }
        return false;
    }

    public boolean onMenuItemSelected(MenuBuilder object, MenuItem menuItem) {
        boolean bl2;
        Window.Callback callback = this.getWindowCallback();
        if (callback != null && !(bl2 = this.mIsDestroyed)) {
            object = ((MenuBuilder)object).getRootMenu();
            if ((object = this.findMenuPanel((Menu)object)) != null) {
                int n10 = ((AppCompatDelegateImpl$PanelFeatureState)object).featureId;
                return callback.onMenuItemSelected(n10, menuItem);
            }
        }
        return false;
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        this.reopenMenu(true);
    }

    public void onMenuOpened(int n10) {
        ActionBar actionBar;
        int n11 = 108;
        if (n10 == n11 && (actionBar = this.getSupportActionBar()) != null) {
            n11 = 1;
            actionBar.dispatchMenuVisibilityChanged(n11 != 0);
        }
    }

    public void onPanelClosed(int n10) {
        int n11 = 108;
        if (n10 == n11) {
            ActionBar actionBar = this.getSupportActionBar();
            if (actionBar != null) {
                actionBar.dispatchMenuVisibilityChanged(false);
            }
        } else if (n10 == 0) {
            AppCompatDelegateImpl$PanelFeatureState appCompatDelegateImpl$PanelFeatureState = this.getPanelState(n10, true);
            n11 = (int)(appCompatDelegateImpl$PanelFeatureState.isOpen ? 1 : 0);
            if (n11 != 0) {
                this.closePanel(appCompatDelegateImpl$PanelFeatureState, false);
            }
        }
    }

    public void onPostCreate(Bundle bundle) {
        this.ensureSubDecor();
    }

    public void onPostResume() {
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            boolean bl2 = true;
            actionBar.setShowHideAnimationEnabled(bl2);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mStarted = true;
        this.applyDayNight();
    }

    public void onStop() {
        this.mStarted = false;
        ActionBar actionBar = this.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setShowHideAnimationEnabled(false);
        }
    }

    public void onSubDecorInstalled(ViewGroup viewGroup) {
    }

    public final ActionBar peekSupportActionBar() {
        return this.mActionBar;
    }

    public boolean requestWindowFeature(int n10) {
        n10 = this.sanitizeWindowFeatureId(n10);
        int n11 = this.mWindowNoTitle;
        int n12 = 108;
        if (n11 != 0 && n10 == n12) {
            return false;
        }
        n11 = this.mHasActionBar;
        int n13 = 1;
        if (n11 != 0 && n10 == n13) {
            this.mHasActionBar = false;
        }
        if (n10 != n13) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 5;
                if (n10 != n11) {
                    n11 = 10;
                    if (n10 != n11) {
                        if (n10 != n12) {
                            n11 = 109;
                            if (n10 != n11) {
                                return this.mWindow.requestFeature(n10);
                            }
                            this.throwFeatureRequestIfSubDecorInstalled();
                            this.mOverlayActionBar = n13;
                            return n13;
                        }
                        this.throwFeatureRequestIfSubDecorInstalled();
                        this.mHasActionBar = n13;
                        return n13;
                    }
                    this.throwFeatureRequestIfSubDecorInstalled();
                    this.mOverlayActionMode = n13;
                    return n13;
                }
                this.throwFeatureRequestIfSubDecorInstalled();
                this.mFeatureIndeterminateProgress = n13;
                return n13;
            }
            this.throwFeatureRequestIfSubDecorInstalled();
            this.mFeatureProgress = n13;
            return n13;
        }
        this.throwFeatureRequestIfSubDecorInstalled();
        this.mWindowNoTitle = n13;
        return n13;
    }

    public void setContentView(int n10) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        LayoutInflater.from((Context)this.mContext).inflate(n10, viewGroup);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setContentView(View view) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        this.ensureSubDecor();
        ViewGroup viewGroup = (ViewGroup)this.mSubDecor.findViewById(0x1020002);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.mAppCompatWindowCallback.getWrapped().onContentChanged();
    }

    public void setHandleNativeActionModesEnabled(boolean bl2) {
        this.mHandleNativeActionModes = bl2;
    }

    public void setLocalNightMode(int n10) {
        int n11 = this.mLocalNightMode;
        if (n11 != n10) {
            this.mLocalNightMode = n10;
            n10 = (int)(this.mBaseContextAttached ? 1 : 0);
            if (n10 != 0) {
                this.applyDayNight();
            }
        }
    }

    public void setSupportActionBar(Toolbar object) {
        Object object2 = this.mHost;
        boolean bl2 = object2 instanceof Activity;
        if (!bl2) {
            return;
        }
        object2 = this.getSupportActionBar();
        boolean bl3 = object2 instanceof WindowDecorActionBar;
        if (!bl3) {
            bl3 = false;
            CharSequence charSequence = null;
            this.mMenuInflater = null;
            if (object2 != null) {
                ((ActionBar)object2).onDestroy();
            }
            if (object != null) {
                charSequence = this.getTitle();
                AppCompatDelegateImpl$AppCompatWindowCallback appCompatDelegateImpl$AppCompatWindowCallback = this.mAppCompatWindowCallback;
                this.mActionBar = object2 = new ToolbarActionBar((Toolbar)((Object)object), charSequence, appCompatDelegateImpl$AppCompatWindowCallback);
                object = this.mWindow;
                object2 = ((ToolbarActionBar)object2).getWrappedWindowCallback();
                object.setCallback((Window.Callback)object2);
            } else {
                this.mActionBar = null;
                object = this.mWindow;
                object2 = this.mAppCompatWindowCallback;
                object.setCallback((Window.Callback)object2);
            }
            this.invalidateOptionsMenu();
            return;
        }
        object = new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        throw object;
    }

    public void setTheme(int n10) {
        this.mThemeResId = n10;
    }

    public final void setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        Object object = this.mDecorContentParent;
        if (object != null) {
            object.setWindowTitle(charSequence);
        } else {
            object = this.peekSupportActionBar();
            if (object != null) {
                object = this.peekSupportActionBar();
                ((ActionBar)object).setWindowTitle(charSequence);
            } else {
                object = this.mTitleView;
                if (object != null) {
                    object.setText(charSequence);
                }
            }
        }
    }

    public final boolean shouldAnimateActionModeView() {
        ViewGroup viewGroup;
        boolean bl2 = this.mSubDecorInstalled;
        if (bl2 && (viewGroup = this.mSubDecor) != null && (bl2 = ViewCompat.isLaidOut((View)viewGroup))) {
            bl2 = true;
        } else {
            bl2 = false;
            viewGroup = null;
        }
        return bl2;
    }

    public ActionMode startSupportActionMode(ActionMode$Callback object) {
        if (object != null) {
            Object object2 = this.mActionMode;
            if (object2 != null) {
                ((ActionMode)object2).finish();
            }
            object2 = new AppCompatDelegateImpl$ActionModeCallbackWrapperV9(this, (ActionMode$Callback)object);
            object = this.getSupportActionBar();
            if (object != null) {
                AppCompatCallback appCompatCallback;
                this.mActionMode = object = ((ActionBar)object).startActionMode((ActionMode$Callback)object2);
                if (object != null && (appCompatCallback = this.mAppCompatCallback) != null) {
                    appCompatCallback.onSupportActionModeStarted((ActionMode)object);
                }
            }
            if ((object = this.mActionMode) == null) {
                this.mActionMode = object = this.startSupportActionModeFromWindow((ActionMode$Callback)object2);
            }
            return this.mActionMode;
        }
        object = new IllegalArgumentException("ActionMode callback can not be null.");
        throw object;
    }

    public ActionMode startSupportActionModeFromWindow(ActionMode$Callback object) {
        float f10;
        boolean bl2;
        int n10;
        Object object2;
        block22: {
            this.endOnGoingFadeAnimation();
            object2 = this.mActionMode;
            if (object2 != null) {
                ((ActionMode)object2).finish();
            }
            if ((n10 = object instanceof AppCompatDelegateImpl$ActionModeCallbackWrapperV9) == 0) {
                object = object2 = new AppCompatDelegateImpl$ActionModeCallbackWrapperV9(this, (ActionMode$Callback)object);
            }
            if ((object2 = this.mAppCompatCallback) != null && !(bl2 = this.mIsDestroyed)) {
                try {
                    object2 = object2.onWindowStartingSupportActionMode((ActionMode$Callback)object);
                    break block22;
                }
                catch (AbstractMethodError abstractMethodError) {}
            }
            n10 = 0;
            object2 = null;
            f10 = 0.0f;
        }
        if (object2 != null) {
            this.mActionMode = object2;
        } else {
            Object object3;
            ActionBarContextView actionBarContextView;
            Object object4;
            object2 = this.mActionModeView;
            bl2 = false;
            boolean bl3 = true;
            if (object2 == null) {
                n10 = this.mIsFloating;
                if (n10 != 0) {
                    int n11;
                    object2 = new TypedValue();
                    object4 = this.mContext.getTheme();
                    int n12 = R$attr.actionBarTheme;
                    object4.resolveAttribute(n12, (TypedValue)object2, bl3);
                    n12 = ((TypedValue)object2).resourceId;
                    if (n12 != 0) {
                        actionBarContextView = this.mContext.getResources().newTheme();
                        actionBarContextView.setTo((Resources.Theme)object4);
                        n11 = ((TypedValue)object2).resourceId;
                        actionBarContextView.applyStyle(n11, bl3);
                        object3 = this.mContext;
                        object4 = new ContextThemeWrapper((Context)object3, 0);
                        object3 = object4.getTheme();
                        object3.setTo((Resources.Theme)actionBarContextView);
                    } else {
                        object4 = this.mContext;
                    }
                    this.mActionModeView = actionBarContextView = new ActionBarContextView((Context)object4);
                    int n13 = R$attr.actionModePopupWindowStyle;
                    actionBarContextView = new PopupWindow((Context)object4, null, n13);
                    this.mActionModePopup = actionBarContextView;
                    PopupWindowCompat.setWindowLayoutType((PopupWindow)actionBarContextView, 2);
                    actionBarContextView = this.mActionModePopup;
                    object3 = this.mActionModeView;
                    actionBarContextView.setContentView((View)object3);
                    this.mActionModePopup.setWidth(-1);
                    actionBarContextView = object4.getTheme();
                    n13 = R$attr.actionBarSize;
                    actionBarContextView.resolveAttribute(n13, (TypedValue)object2, bl3);
                    n10 = ((TypedValue)object2).data;
                    object4 = object4.getResources().getDisplayMetrics();
                    n10 = TypedValue.complexToDimensionPixelSize((int)n10, (DisplayMetrics)object4);
                    object4 = this.mActionModeView;
                    ((ActionBarContextView)((Object)object4)).setContentHeight(n10);
                    object2 = this.mActionModePopup;
                    n11 = -2;
                    object2.setHeight(n11);
                    this.mShowActionModePopup = object2 = new AppCompatDelegateImpl$6(this);
                } else {
                    object2 = this.mSubDecor;
                    int n14 = R$id.action_mode_bar_stub;
                    if ((object2 = (ViewStubCompat)object2.findViewById(n14)) != null) {
                        object4 = LayoutInflater.from((Context)this.getActionBarThemedContext());
                        ((ViewStubCompat)((Object)object2)).setLayoutInflater((LayoutInflater)object4);
                        object2 = (ActionBarContextView)((ViewStubCompat)((Object)object2)).inflate();
                        this.mActionModeView = object2;
                    }
                }
            }
            if ((object2 = this.mActionModeView) != null) {
                Menu menu2;
                this.endOnGoingFadeAnimation();
                this.mActionModeView.killMode();
                object4 = this.mActionModeView.getContext();
                actionBarContextView = this.mActionModeView;
                object3 = this.mActionModePopup;
                if (object3 != null) {
                    bl3 = false;
                    menu2 = null;
                }
                object2 = new StandaloneActionMode((Context)object4, actionBarContextView, (ActionMode$Callback)object, bl3);
                menu2 = ((ActionMode)object2).getMenu();
                boolean bl4 = ((ActionMode$Callback)object).onCreateActionMode((ActionMode)object2, menu2);
                if (bl4) {
                    ((ActionMode)object2).invalidate();
                    object = this.mActionModeView;
                    ((ActionBarContextView)((Object)object)).initForMode((ActionMode)object2);
                    this.mActionMode = object2;
                    bl4 = this.shouldAnimateActionModeView();
                    n10 = 1065353216;
                    f10 = 1.0f;
                    if (bl4) {
                        this.mActionModeView.setAlpha(0.0f);
                        object = ViewCompat.animate((View)this.mActionModeView).alpha(f10);
                        this.mFadeAnim = object;
                        object2 = new AppCompatDelegateImpl$7(this);
                        ((ViewPropertyAnimatorCompat)object).setListener((ViewPropertyAnimatorListener)object2);
                    } else {
                        this.mActionModeView.setAlpha(f10);
                        this.mActionModeView.setVisibility(0);
                        object = this.mActionModeView;
                        n10 = 32;
                        f10 = 4.5E-44f;
                        object.sendAccessibilityEvent(n10);
                        object = this.mActionModeView.getParent();
                        bl4 = object instanceof View;
                        if (bl4) {
                            object = (View)this.mActionModeView.getParent();
                            ViewCompat.requestApplyInsets((View)object);
                        }
                    }
                    object = this.mActionModePopup;
                    if (object != null) {
                        object = this.mWindow.getDecorView();
                        object2 = this.mShowActionModePopup;
                        object.post((Runnable)object2);
                    }
                } else {
                    this.mActionMode = null;
                }
            }
        }
        object = this.mActionMode;
        if (object != null && (object2 = this.mAppCompatCallback) != null) {
            object2.onSupportActionModeStarted((ActionMode)object);
        }
        return this.mActionMode;
    }

    public final int updateStatusGuard(WindowInsetsCompat windowInsetsCompat, Rect object) {
        int n10;
        boolean bl2;
        int n11 = 0;
        int n12 = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : (object != null ? object.top : 0);
        ActionBarContextView actionBarContextView = this.mActionModeView;
        int n13 = 8;
        if (actionBarContextView != null && (bl2 = (actionBarContextView = actionBarContextView.getLayoutParams()) instanceof ViewGroup.MarginLayoutParams)) {
            actionBarContextView = (ViewGroup.MarginLayoutParams)this.mActionModeView.getLayoutParams();
            ActionBarContextView actionBarContextView2 = this.mActionModeView;
            int n14 = actionBarContextView2.isShown();
            int n15 = 1;
            float f10 = Float.MIN_VALUE;
            if (n14 != 0) {
                float f11;
                int n16;
                int n17;
                int n18;
                int n19;
                actionBarContextView2 = this.mTempRect1;
                if (actionBarContextView2 == null) {
                    actionBarContextView2 = new Rect();
                    this.mTempRect1 = actionBarContextView2;
                    actionBarContextView2 = new Rect();
                    this.mTempRect2 = actionBarContextView2;
                }
                actionBarContextView2 = this.mTempRect1;
                Object object2 = this.mTempRect2;
                if (windowInsetsCompat == null) {
                    actionBarContextView2.set((Rect)object);
                } else {
                    n19 = windowInsetsCompat.getSystemWindowInsetLeft();
                    n18 = windowInsetsCompat.getSystemWindowInsetTop();
                    n17 = windowInsetsCompat.getSystemWindowInsetRight();
                    n10 = windowInsetsCompat.getSystemWindowInsetBottom();
                    actionBarContextView2.set(n19, n18, n17, n10);
                }
                windowInsetsCompat = this.mSubDecor;
                ViewUtils.computeFitSystemWindows((View)windowInsetsCompat, (Rect)actionBarContextView2, (Rect)object2);
                n10 = ((Rect)actionBarContextView2).top;
                n19 = ((Rect)actionBarContextView2).left;
                n14 = ((Rect)actionBarContextView2).right;
                object2 = ViewCompat.getRootWindowInsets((View)this.mSubDecor);
                n18 = object2 == null ? 0 : ((WindowInsetsCompat)object2).getSystemWindowInsetLeft();
                if (object2 == null) {
                    n16 = 0;
                    object2 = null;
                } else {
                    n16 = ((WindowInsetsCompat)object2).getSystemWindowInsetRight();
                }
                n17 = ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin;
                if (n17 == n10 && (n17 = ((ViewGroup.MarginLayoutParams)actionBarContextView).leftMargin) == n19 && (n17 = ((ViewGroup.MarginLayoutParams)actionBarContextView).rightMargin) == n14) {
                    n19 = 0;
                    object = null;
                    f11 = 0.0f;
                } else {
                    ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin = n10;
                    ((ViewGroup.MarginLayoutParams)actionBarContextView).leftMargin = n19;
                    ((ViewGroup.MarginLayoutParams)actionBarContextView).rightMargin = n14;
                    n19 = n15;
                    f11 = f10;
                }
                if (n10 > 0 && (windowInsetsCompat = this.mStatusGuard) == null) {
                    actionBarContextView2 = this.mContext;
                    windowInsetsCompat = new View((Context)actionBarContextView2);
                    this.mStatusGuard = windowInsetsCompat;
                    windowInsetsCompat.setVisibility(n13);
                    n14 = ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin;
                    n17 = 51;
                    int n20 = -1;
                    windowInsetsCompat = new FrameLayout.LayoutParams(n20, n14, n17);
                    ((FrameLayout.LayoutParams)windowInsetsCompat).leftMargin = n18;
                    ((FrameLayout.LayoutParams)windowInsetsCompat).rightMargin = n16;
                    actionBarContextView2 = this.mSubDecor;
                    object2 = this.mStatusGuard;
                    actionBarContextView2.addView((View)object2, n20, (ViewGroup.LayoutParams)windowInsetsCompat);
                } else {
                    windowInsetsCompat = this.mStatusGuard;
                    if (windowInsetsCompat != null) {
                        windowInsetsCompat = (ViewGroup.MarginLayoutParams)windowInsetsCompat.getLayoutParams();
                        n14 = ((ViewGroup.MarginLayoutParams)windowInsetsCompat).height;
                        n17 = ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin;
                        if (n14 != n17 || (n14 = ((ViewGroup.MarginLayoutParams)windowInsetsCompat).leftMargin) != n18 || (n14 = ((ViewGroup.MarginLayoutParams)windowInsetsCompat).rightMargin) != n16) {
                            ((ViewGroup.MarginLayoutParams)windowInsetsCompat).height = n17;
                            ((ViewGroup.MarginLayoutParams)windowInsetsCompat).leftMargin = n18;
                            ((ViewGroup.MarginLayoutParams)windowInsetsCompat).rightMargin = n16;
                            actionBarContextView2 = this.mStatusGuard;
                            actionBarContextView2.setLayoutParams((ViewGroup.LayoutParams)windowInsetsCompat);
                        }
                    }
                }
                windowInsetsCompat = this.mStatusGuard;
                if (windowInsetsCompat == null) {
                    n15 = 0;
                    f10 = 0.0f;
                }
                if (n15 != 0 && (n10 = windowInsetsCompat.getVisibility()) != 0) {
                    windowInsetsCompat = this.mStatusGuard;
                    this.updateStatusGuardColor((View)windowInsetsCompat);
                }
                if ((n10 = (int)(this.mOverlayActionMode ? 1 : 0)) == 0 && n15 != 0) {
                    n12 = 0;
                }
                n10 = n15;
                n15 = n19;
                f10 = f11;
            } else {
                n10 = ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin;
                if (n10 != 0) {
                    ((ViewGroup.MarginLayoutParams)actionBarContextView).topMargin = 0;
                    n10 = 0;
                    windowInsetsCompat = null;
                } else {
                    n10 = 0;
                    windowInsetsCompat = null;
                    n15 = 0;
                    f10 = 0.0f;
                }
            }
            if (n15 != 0) {
                object = this.mActionModeView;
                object.setLayoutParams((ViewGroup.LayoutParams)actionBarContextView);
            }
        } else {
            n10 = 0;
            windowInsetsCompat = null;
        }
        if ((object = this.mStatusGuard) != null) {
            if (n10 == 0) {
                n11 = n13;
            }
            object.setVisibility(n11);
        }
        return n12;
    }
}

