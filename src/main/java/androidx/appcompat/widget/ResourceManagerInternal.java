/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.ResourceManagerInternal$AsldcInflateDelegate;
import androidx.appcompat.widget.ResourceManagerInternal$AvdcInflateDelegate;
import androidx.appcompat.widget.ResourceManagerInternal$ColorFilterLruCache;
import androidx.appcompat.widget.ResourceManagerInternal$DrawableDelegate;
import androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate;
import androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks;
import androidx.appcompat.widget.ResourceManagerInternal$VdcInflateDelegate;
import androidx.appcompat.widget.TintInfo;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourceManagerInternal {
    private static final ResourceManagerInternal$ColorFilterLruCache COLOR_FILTER_CACHE;
    private static final boolean DEBUG = false;
    private static final PorterDuff.Mode DEFAULT_MODE;
    private static ResourceManagerInternal INSTANCE;
    private static final String PLATFORM_VD_CLAZZ = "android.graphics.drawable.VectorDrawable";
    private static final String SKIP_DRAWABLE_TAG = "appcompat_skip_skip";
    private static final String TAG = "ResourceManagerInternal";
    private SimpleArrayMap mDelegates;
    private final WeakHashMap mDrawableCaches;
    private boolean mHasCheckedVectorDrawableSetup;
    private ResourceManagerInternal$ResourceManagerHooks mHooks;
    private SparseArrayCompat mKnownDrawableIdTags;
    private WeakHashMap mTintLists;
    private TypedValue mTypedValue;

    static {
        ResourceManagerInternal$ColorFilterLruCache resourceManagerInternal$ColorFilterLruCache;
        DEFAULT_MODE = PorterDuff.Mode.SRC_IN;
        COLOR_FILTER_CACHE = resourceManagerInternal$ColorFilterLruCache = new ResourceManagerInternal$ColorFilterLruCache(6);
    }

    public ResourceManagerInternal() {
        WeakHashMap weakHashMap;
        this.mDrawableCaches = weakHashMap = new WeakHashMap(0);
    }

    private void addDelegate(String string2, ResourceManagerInternal$InflateDelegate resourceManagerInternal$InflateDelegate) {
        SimpleArrayMap simpleArrayMap = this.mDelegates;
        if (simpleArrayMap == null) {
            this.mDelegates = simpleArrayMap = new SimpleArrayMap();
        }
        this.mDelegates.put(string2, resourceManagerInternal$InflateDelegate);
    }

    private boolean addDrawableToCache(Context object, long l10, Drawable drawable2) {
        synchronized (this) {
            block11: {
                Object object2;
                block12: {
                    drawable2 = drawable2.getConstantState();
                    if (drawable2 == null) break block11;
                    object2 = this.mDrawableCaches;
                    object2 = ((WeakHashMap)object2).get(object);
                    object2 = (LongSparseArray)object2;
                    if (object2 != null) break block12;
                    object2 = new LongSparseArray();
                    WeakHashMap weakHashMap = this.mDrawableCaches;
                    weakHashMap.put(object, object2);
                }
                object = new WeakReference(drawable2);
                ((LongSparseArray)object2).put(l10, object);
                return true;
            }
            return false;
        }
    }

    private void addTintListToCache(Context context, int n10, ColorStateList colorStateList) {
        WeakHashMap weakHashMap = this.mTintLists;
        if (weakHashMap == null) {
            weakHashMap = new WeakHashMap();
            this.mTintLists = weakHashMap;
        }
        if ((weakHashMap = (SparseArrayCompat)this.mTintLists.get(context)) == null) {
            weakHashMap = new SparseArrayCompat();
            WeakHashMap weakHashMap2 = this.mTintLists;
            weakHashMap2.put(context, weakHashMap);
        }
        ((SparseArrayCompat)((Object)weakHashMap)).append(n10, colorStateList);
    }

    private void checkVectorDrawableSetup(Context object) {
        boolean bl2;
        int n10 = this.mHasCheckedVectorDrawableSetup;
        if (n10 != 0) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = true;
        n10 = R$drawable.abc_vector_test;
        if ((object = this.getDrawable((Context)object, n10)) != null && (bl2 = ResourceManagerInternal.isVectorDrawable((Drawable)object))) {
            return;
        }
        this.mHasCheckedVectorDrawableSetup = false;
        object = new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        throw object;
    }

    private static long createCacheKey(TypedValue typedValue) {
        long l10 = (long)typedValue.assetCookie << 32;
        long l11 = typedValue.data;
        return l10 | l11;
    }

    private Drawable createDrawableIfNeeded(Context context, int n10) {
        Drawable drawable2;
        TypedValue typedValue = this.mTypedValue;
        if (typedValue == null) {
            this.mTypedValue = typedValue = new TypedValue();
        }
        typedValue = this.mTypedValue;
        Resources resources = context.getResources();
        boolean bl2 = true;
        resources.getValue(n10, typedValue, bl2);
        long l10 = ResourceManagerInternal.createCacheKey(typedValue);
        Object object = this.getCachedDrawable(context, l10);
        if (object != null) {
            return object;
        }
        object = this.mHooks;
        if (object == null) {
            n10 = 0;
            drawable2 = null;
        } else {
            drawable2 = object.createDrawableFor(this, context, n10);
        }
        if (drawable2 != null) {
            int n11 = typedValue.changingConfigurations;
            drawable2.setChangingConfigurations(n11);
            this.addDrawableToCache(context, l10, drawable2);
        }
        return drawable2;
    }

    private static PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, int[] nArray) {
        if (colorStateList != null && mode != null) {
            return ResourceManagerInternal.getPorterDuffColorFilter(colorStateList.getColorForState(nArray, 0), mode);
        }
        return null;
    }

    public static ResourceManagerInternal get() {
        Class<ResourceManagerInternal> clazz = ResourceManagerInternal.class;
        synchronized (clazz) {
            ResourceManagerInternal resourceManagerInternal = INSTANCE;
            if (resourceManagerInternal == null) {
                INSTANCE = resourceManagerInternal = new ResourceManagerInternal();
                ResourceManagerInternal.installDefaultInflateDelegates(resourceManagerInternal);
            }
            resourceManagerInternal = INSTANCE;
            return resourceManagerInternal;
        }
    }

    private Drawable getCachedDrawable(Context context, long l10) {
        synchronized (this) {
            Object object;
            block15: {
                object = this.mDrawableCaches;
                object = ((WeakHashMap)object).get(context);
                object = (LongSparseArray)object;
                if (object != null) break block15;
                return null;
            }
            Object object2 = ((LongSparseArray)object).get(l10);
            object2 = (WeakReference)object2;
            if (object2 != null) {
                object2 = ((Reference)object2).get();
                if ((object2 = (Drawable.ConstantState)object2) != null) {
                    context = context.getResources();
                    context = object2.newDrawable((Resources)context);
                    return context;
                }
                ((LongSparseArray)object).remove(l10);
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PorterDuffColorFilter getPorterDuffColorFilter(int n10, PorterDuff.Mode mode) {
        Class<ResourceManagerInternal> clazz = ResourceManagerInternal.class;
        synchronized (clazz) {
            ResourceManagerInternal$ColorFilterLruCache resourceManagerInternal$ColorFilterLruCache = COLOR_FILTER_CACHE;
            PorterDuffColorFilter porterDuffColorFilter = resourceManagerInternal$ColorFilterLruCache.get(n10, mode);
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(n10, mode);
                resourceManagerInternal$ColorFilterLruCache.put(n10, mode, porterDuffColorFilter);
            }
            return porterDuffColorFilter;
        }
    }

    private ColorStateList getTintListFromCache(Context object, int n10) {
        WeakHashMap weakHashMap = this.mTintLists;
        Object object2 = null;
        if (weakHashMap != null && (object = (SparseArrayCompat)weakHashMap.get(object)) != null) {
            object2 = object = ((SparseArrayCompat)object).get(n10);
            object2 = (ColorStateList)object;
        }
        return object2;
    }

    private static void installDefaultInflateDelegates(ResourceManagerInternal resourceManagerInternal) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            ResourceManagerInternal$InflateDelegate resourceManagerInternal$InflateDelegate = new ResourceManagerInternal$VdcInflateDelegate();
            resourceManagerInternal.addDelegate("vector", resourceManagerInternal$InflateDelegate);
            resourceManagerInternal$InflateDelegate = new ResourceManagerInternal$AvdcInflateDelegate();
            resourceManagerInternal.addDelegate("animated-vector", resourceManagerInternal$InflateDelegate);
            resourceManagerInternal$InflateDelegate = new ResourceManagerInternal$AsldcInflateDelegate();
            resourceManagerInternal.addDelegate("animated-selector", resourceManagerInternal$InflateDelegate);
            resourceManagerInternal$InflateDelegate = new ResourceManagerInternal$DrawableDelegate();
            String string2 = "drawable";
            resourceManagerInternal.addDelegate(string2, resourceManagerInternal$InflateDelegate);
        }
    }

    private static boolean isVectorDrawable(Drawable object) {
        String string2;
        boolean bl2;
        boolean bl3 = object instanceof VectorDrawableCompat;
        if (!bl3 && !(bl2 = (string2 = PLATFORM_VD_CLAZZ).equals(object = object.getClass().getName()))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable loadDrawableFromDelegates(Context object, int n10) {
        Object object2;
        boolean bl2;
        Object object3;
        int n11;
        Object object4 = this.mDelegates;
        Object object5 = null;
        if (object4 == null) return null;
        int n12 = ((SimpleArrayMap)object4).isEmpty();
        if (n12 != 0) {
            return null;
        }
        object4 = this.mKnownDrawableIdTags;
        String string2 = SKIP_DRAWABLE_TAG;
        if (object4 != null) {
            n11 = string2.equals(object4 = (String)((SparseArrayCompat)object4).get(n10));
            if (n11 != 0 || object4 != null && (object4 = ((SimpleArrayMap)(object3 = this.mDelegates)).get(object4)) == null) {
                return null;
            }
        } else {
            this.mKnownDrawableIdTags = object4 = new SparseArrayCompat();
        }
        if ((object4 = this.mTypedValue) == null) {
            object4 = new TypedValue();
            this.mTypedValue = object4;
        }
        object4 = this.mTypedValue;
        object5 = object.getResources();
        n11 = 1;
        object5.getValue(n10, (TypedValue)object4, n11 != 0);
        long l10 = ResourceManagerInternal.createCacheKey((TypedValue)object4);
        Drawable drawable2 = this.getCachedDrawable((Context)object, l10);
        if (drawable2 != null) {
            return drawable2;
        }
        CharSequence charSequence = ((TypedValue)object4).string;
        if (charSequence != null && (bl2 = ((String)(charSequence = charSequence.toString())).endsWith((String)(object2 = ".xml")))) {
            try {
                int n13;
                int n14;
                object5 = object5.getXml(n10);
                charSequence = Xml.asAttributeSet((XmlPullParser)object5);
                while ((n14 = object5.next()) != (n13 = 2) && n14 != n11) {
                }
                if (n14 != n13) {
                    object4 = "No start tag found";
                    object = new XmlPullParserException((String)object4);
                    throw object;
                }
                object3 = object5.getName();
                object2 = this.mKnownDrawableIdTags;
                ((SparseArrayCompat)object2).append(n10, object3);
                object2 = this.mDelegates;
                object3 = ((SimpleArrayMap)object2).get(object3);
                object3 = (ResourceManagerInternal$InflateDelegate)object3;
                if (object3 != null) {
                    object2 = object.getTheme();
                    object5 = object3.createFromXmlInner((Context)object, (XmlPullParser)object5, (AttributeSet)charSequence, (Resources.Theme)object2);
                    drawable2 = object5;
                }
                if (drawable2 != null) {
                    n12 = ((TypedValue)object4).changingConfigurations;
                    drawable2.setChangingConfigurations(n12);
                    this.addDrawableToCache((Context)object, l10, drawable2);
                }
            }
            catch (Exception exception) {
                object4 = TAG;
                object5 = "Exception while inflating drawable";
                Log.e((String)object4, (String)object5, (Throwable)exception);
            }
        }
        if (drawable2 == null) {
            object = this.mKnownDrawableIdTags;
            object.append(n10, string2);
        }
        return drawable2;
    }

    private Drawable tintDrawable(Context context, int n10, boolean bl2, Drawable drawable2) {
        Object object = this.getTintList(context, n10);
        if (object != null) {
            boolean bl3 = DrawableUtils.canSafelyMutateDrawable(drawable2);
            if (bl3) {
                drawable2 = drawable2.mutate();
            }
            drawable2 = DrawableCompat.wrap(drawable2);
            DrawableCompat.setTintList(drawable2, (ColorStateList)object);
            context = this.getTintMode(n10);
            if (context != null) {
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)context);
            }
        } else {
            boolean bl4;
            boolean bl5;
            object = this.mHooks;
            if (!(object != null && (bl5 = object.tintDrawable(context, n10, drawable2)) || (bl4 = this.tintDrawableUsingColorFilter(context, n10, drawable2)) || !bl2)) {
                drawable2 = null;
            }
        }
        return drawable2;
    }

    public static void tintDrawable(Drawable drawable2, TintInfo tintInfo, int[] nArray) {
        boolean bl2;
        Drawable drawable3;
        boolean bl3 = DrawableUtils.canSafelyMutateDrawable(drawable2);
        if (bl3 && (drawable3 = drawable2.mutate()) != drawable2) {
            Log.d((String)TAG, (String)"Mutated drawable is not the same instance as the input.");
            return;
        }
        bl3 = tintInfo.mHasTintList;
        if (!bl3 && !(bl2 = tintInfo.mHasTintMode)) {
            drawable2.clearColorFilter();
        } else {
            if (bl3) {
                drawable3 = tintInfo.mTintList;
            } else {
                bl3 = false;
                drawable3 = null;
            }
            bl2 = tintInfo.mHasTintMode;
            tintInfo = bl2 ? tintInfo.mTintMode : DEFAULT_MODE;
            tintInfo = ResourceManagerInternal.createTintFilter((ColorStateList)drawable3, (PorterDuff.Mode)tintInfo, nArray);
            drawable2.setColorFilter((ColorFilter)tintInfo);
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 <= n11) {
            drawable2.invalidateSelf();
        }
    }

    public Drawable getDrawable(Context context, int n10) {
        synchronized (this) {
            context = this.getDrawable(context, n10, false);
            return context;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Drawable getDrawable(Context context, int n10, boolean bl2) {
        synchronized (this) {
            void var2_2;
            this.checkVectorDrawableSetup(context);
            Drawable drawable2 = this.loadDrawableFromDelegates(context, (int)var2_2);
            if (drawable2 == null) {
                drawable2 = this.createDrawableIfNeeded(context, (int)var2_2);
            }
            if (drawable2 == null) {
                drawable2 = ContextCompat.getDrawable(context, (int)var2_2);
            }
            if (drawable2 != null) {
                void var3_3;
                drawable2 = this.tintDrawable(context, (int)var2_2, (boolean)var3_3, drawable2);
            }
            if (drawable2 != null) {
                DrawableUtils.fixDrawable(drawable2);
            }
            return drawable2;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public ColorStateList getTintList(Context context, int n10) {
        synchronized (this) {
            Object object;
            block6: {
                object = this.getTintListFromCache(context, n10);
                if (object != null) return object;
                object = this.mHooks;
                if (object != null) break block6;
                return null;
            }
            object = object.getTintListForDrawableRes(context, n10);
            if (object == null) return object;
            this.addTintListToCache(context, n10, (ColorStateList)object);
            return object;
        }
    }

    public PorterDuff.Mode getTintMode(int n10) {
        PorterDuff.Mode mode;
        ResourceManagerInternal$ResourceManagerHooks resourceManagerInternal$ResourceManagerHooks = this.mHooks;
        if (resourceManagerInternal$ResourceManagerHooks == null) {
            n10 = 0;
            mode = null;
        } else {
            mode = resourceManagerInternal$ResourceManagerHooks.getTintModeForDrawableRes(n10);
        }
        return mode;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onConfigurationChanged(Context object) {
        synchronized (this) {
            WeakHashMap weakHashMap = this.mDrawableCaches;
            object = weakHashMap.get(object);
            object = (LongSparseArray)object;
            if (object != null) {
                ((LongSparseArray)object).clear();
            }
            return;
        }
    }

    public Drawable onDrawableLoadedFromResources(Context context, VectorEnabledTintResources vectorEnabledTintResources, int n10) {
        synchronized (this) {
            Drawable drawable2;
            block7: {
                drawable2 = this.loadDrawableFromDelegates(context, n10);
                if (drawable2 != null) break block7;
                drawable2 = vectorEnabledTintResources.superGetDrawable(n10);
            }
            if (drawable2 != null) {
                vectorEnabledTintResources = null;
                context = this.tintDrawable(context, n10, false, drawable2);
                return context;
            }
            return null;
            finally {
            }
        }
    }

    public void setHooks(ResourceManagerInternal$ResourceManagerHooks resourceManagerInternal$ResourceManagerHooks) {
        synchronized (this) {
            this.mHooks = resourceManagerInternal$ResourceManagerHooks;
            return;
        }
    }

    public boolean tintDrawableUsingColorFilter(Context context, int n10, Drawable drawable2) {
        boolean bl2;
        ResourceManagerInternal$ResourceManagerHooks resourceManagerInternal$ResourceManagerHooks = this.mHooks;
        if (resourceManagerInternal$ResourceManagerHooks != null && (bl2 = resourceManagerInternal$ResourceManagerHooks.tintDrawableUsingColorFilter(context, n10, drawable2))) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }
}

