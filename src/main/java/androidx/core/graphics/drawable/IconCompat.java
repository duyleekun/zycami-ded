/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.Context
 *  android.content.Intent
 *  android.content.Intent$ShortcutIconResource
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.AdaptiveIconDrawable
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;

public class IconCompat
extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    public static final String EXTRA_INT1 = "int1";
    public static final String EXTRA_INT2 = "int2";
    public static final String EXTRA_OBJ = "obj";
    public static final String EXTRA_STRING1 = "string1";
    public static final String EXTRA_TINT_LIST = "tint_list";
    public static final String EXTRA_TINT_MODE = "tint_mode";
    public static final String EXTRA_TYPE = "type";
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG = "IconCompat";
    public static final int TYPE_ADAPTIVE_BITMAP = 5;
    public static final int TYPE_BITMAP = 1;
    public static final int TYPE_DATA = 3;
    public static final int TYPE_RESOURCE = 2;
    public static final int TYPE_UNKNOWN = 255;
    public static final int TYPE_URI = 4;
    public static final int TYPE_URI_ADAPTIVE_BITMAP = 6;
    public byte[] mData = null;
    public int mInt1 = 0;
    public int mInt2 = 0;
    public Object mObj1;
    public Parcelable mParcelable = null;
    public String mString1;
    public ColorStateList mTintList = null;
    public PorterDuff.Mode mTintMode;
    public String mTintModeStr;
    public int mType = -1;

    public IconCompat() {
        PorterDuff.Mode mode;
        this.mTintMode = mode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
    }

    private IconCompat(int n10) {
        PorterDuff.Mode mode;
        this.mTintMode = mode = DEFAULT_TINT_MODE;
        this.mTintModeStr = null;
        this.mType = n10;
    }

    public static IconCompat createFromBundle(Bundle object) {
        String string2;
        int n10;
        String string3 = EXTRA_TYPE;
        int n11 = object.getInt(string3);
        IconCompat iconCompat = new IconCompat(n11);
        iconCompat.mInt1 = n10 = object.getInt(EXTRA_INT1);
        iconCompat.mInt2 = n10 = object.getInt(EXTRA_INT2);
        iconCompat.mString1 = string2 = object.getString(EXTRA_STRING1);
        string2 = EXTRA_TINT_LIST;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            string2 = (ColorStateList)object.getParcelable(string2);
            iconCompat.mTintList = string2;
        }
        if (bl2 = object.containsKey(string2 = EXTRA_TINT_MODE)) {
            string2 = PorterDuff.Mode.valueOf((String)object.getString(string2));
            iconCompat.mTintMode = string2;
        }
        string2 = EXTRA_OBJ;
        switch (n11) {
            default: {
                object = new StringBuilder();
                ((StringBuilder)object).append("Unknown type ");
                ((StringBuilder)object).append(n11);
                object = ((StringBuilder)object).toString();
                Log.w((String)TAG, (String)object);
                return null;
            }
            case 3: {
                iconCompat.mObj1 = object = (Object)object.getByteArray(string2);
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                iconCompat.mObj1 = object = object.getString(string2);
                break;
            }
            case -1: 
            case 1: 
            case 5: {
                iconCompat.mObj1 = object = object.getParcelable(string2);
            }
        }
        return iconCompat;
    }

    public static IconCompat createFromIcon(Context object, Icon icon) {
        Preconditions.checkNotNull(icon);
        int n10 = IconCompat.getType(icon);
        int n11 = 2;
        if (n10 != n11) {
            int n12 = 4;
            if (n10 != n12) {
                n12 = 6;
                if (n10 != n12) {
                    object = new IconCompat(-1);
                    object.mObj1 = icon;
                    return object;
                }
                return IconCompat.createWithAdaptiveBitmapContentUri(IconCompat.getUri(icon));
            }
            return IconCompat.createWithContentUri(IconCompat.getUri(icon));
        }
        String string2 = IconCompat.getResPackage(icon);
        try {
            object = IconCompat.getResources(object, string2);
        }
        catch (Resources.NotFoundException notFoundException) {
            object = new IllegalArgumentException("Icon resource cannot be found");
            throw object;
        }
        int n13 = IconCompat.getResId(icon);
        return IconCompat.createWithResource((Resources)object, string2, n13);
    }

    public static IconCompat createFromIcon(Icon icon) {
        Preconditions.checkNotNull(icon);
        int n10 = IconCompat.getType(icon);
        int n11 = 2;
        if (n10 != n11) {
            n11 = 4;
            if (n10 != n11) {
                n11 = 6;
                if (n10 != n11) {
                    IconCompat iconCompat = new IconCompat(-1);
                    iconCompat.mObj1 = icon;
                    return iconCompat;
                }
                return IconCompat.createWithAdaptiveBitmapContentUri(IconCompat.getUri(icon));
            }
            return IconCompat.createWithContentUri(IconCompat.getUri(icon));
        }
        String string2 = IconCompat.getResPackage(icon);
        int n12 = IconCompat.getResId(icon);
        return IconCompat.createWithResource(null, string2, n12);
    }

    public static IconCompat createFromIconOrNullIfZeroResId(Icon icon) {
        int n10;
        int n11 = IconCompat.getType(icon);
        if (n11 == (n10 = 2) && (n11 = IconCompat.getResId(icon)) == 0) {
            return null;
        }
        return IconCompat.createFromIcon(icon);
    }

    public static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean bl2) {
        float f10;
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        float f11 = Math.min(n10, n11);
        n11 = 1059760811;
        float f12 = 0.6666667f;
        n10 = (int)(f11 *= f12);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        config = Bitmap.createBitmap((int)n10, (int)n10, (Bitmap.Config)config);
        Canvas canvas = new Canvas((Bitmap)config);
        int n12 = 3;
        Paint paint = new Paint(n12);
        float f13 = n10;
        float f14 = 0.5f * f13;
        float f15 = 0.9166667f * f14;
        if (bl2) {
            int n13 = 1009429163;
            float f16 = 0.010416667f * f13;
            paint.setColor(0);
            int n14 = 0x3D000000;
            f10 = 0.03125f;
            paint.setShadowLayer(f16, 0.0f, f13 *= 0.020833334f, n14);
            canvas.drawCircle(f14, f14, f15, paint);
            n12 = 0x1E000000;
            f13 = 6.7762636E-21f;
            paint.setShadowLayer(f16, 0.0f, 0.0f, n12);
            canvas.drawCircle(f14, f14, f15, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        tileMode = new Matrix();
        f10 = -(bitmap.getWidth() - n10) / 2;
        float f17 = -(bitmap.getHeight() - n10) / 2;
        tileMode.setTranslate(f10, f17);
        bitmapShader.setLocalMatrix((Matrix)tileMode);
        paint.setShader((Shader)bitmapShader);
        canvas.drawCircle(f14, f14, f15, paint);
        canvas.setBitmap(null);
        return config;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap object) {
        if (object != null) {
            IconCompat iconCompat = new IconCompat(5);
            iconCompat.mObj1 = object;
            return iconCompat;
        }
        object = new IllegalArgumentException("Bitmap must not be null.");
        throw object;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(Uri object) {
        if (object != null) {
            return IconCompat.createWithAdaptiveBitmapContentUri(object.toString());
        }
        object = new IllegalArgumentException("Uri must not be null.");
        throw object;
    }

    public static IconCompat createWithAdaptiveBitmapContentUri(String object) {
        if (object != null) {
            IconCompat iconCompat = new IconCompat(6);
            iconCompat.mObj1 = object;
            return iconCompat;
        }
        object = new IllegalArgumentException("Uri must not be null.");
        throw object;
    }

    public static IconCompat createWithBitmap(Bitmap object) {
        if (object != null) {
            IconCompat iconCompat = new IconCompat(1);
            iconCompat.mObj1 = object;
            return iconCompat;
        }
        object = new IllegalArgumentException("Bitmap must not be null.");
        throw object;
    }

    public static IconCompat createWithContentUri(Uri object) {
        if (object != null) {
            return IconCompat.createWithContentUri(object.toString());
        }
        object = new IllegalArgumentException("Uri must not be null.");
        throw object;
    }

    public static IconCompat createWithContentUri(String object) {
        if (object != null) {
            IconCompat iconCompat = new IconCompat(4);
            iconCompat.mObj1 = object;
            return iconCompat;
        }
        object = new IllegalArgumentException("Uri must not be null.");
        throw object;
    }

    public static IconCompat createWithData(byte[] object, int n10, int n11) {
        if (object != null) {
            IconCompat iconCompat = new IconCompat(3);
            iconCompat.mObj1 = object;
            iconCompat.mInt1 = n10;
            iconCompat.mInt2 = n11;
            return iconCompat;
        }
        object = new IllegalArgumentException;
        object("Data must not be null.");
        throw object;
    }

    public static IconCompat createWithResource(Context object, int n10) {
        if (object != null) {
            Resources resources = object.getResources();
            object = object.getPackageName();
            return IconCompat.createWithResource(resources, (String)object, n10);
        }
        object = new IllegalArgumentException("Context must not be null.");
        throw object;
    }

    public static IconCompat createWithResource(Resources object, String string2, int n10) {
        if (string2 != null) {
            if (n10 != 0) {
                int n11 = 2;
                IconCompat iconCompat = new IconCompat(n11);
                iconCompat.mInt1 = n10;
                if (object != null) {
                    try {
                        object = object.getResourceName(n10);
                    }
                    catch (Resources.NotFoundException notFoundException) {
                        object = new IllegalArgumentException("Icon resource cannot be found");
                        throw object;
                    }
                    iconCompat.mObj1 = object;
                } else {
                    iconCompat.mObj1 = string2;
                }
                iconCompat.mString1 = string2;
                return iconCompat;
            }
            object = new IllegalArgumentException("Drawable resource ID must not be 0");
            throw object;
        }
        object = new IllegalArgumentException("Package must not be null.");
        throw object;
    }

    private static int getResId(Icon object) {
        String string2 = "Unable to get icon resource";
        String string3 = TAG;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return object.getResId();
        }
        n10 = 0;
        GenericDeclaration genericDeclaration = object.getClass();
        Object[] objectArray = "getResId";
        Class[] classArray = new Class[]{};
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
        objectArray = new Object[]{};
        object = ((Method)genericDeclaration).invoke(object, objectArray);
        object = (Integer)object;
        try {
            return (Integer)object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)string3, (String)string2, (Throwable)noSuchMethodException);
            return 0;
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)string3, (String)string2, (Throwable)invocationTargetException);
            return 0;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
            return 0;
        }
    }

    private static String getResPackage(Icon object) {
        String string2 = "Unable to get icon package";
        String string3 = TAG;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return object.getResPackage();
        }
        n10 = 0;
        GenericDeclaration genericDeclaration = object.getClass();
        Object[] objectArray = "getResPackage";
        Class[] classArray = new Class[]{};
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
        objectArray = new Object[]{};
        object = ((Method)genericDeclaration).invoke(object, objectArray);
        try {
            return (String)object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)string3, (String)string2, (Throwable)noSuchMethodException);
            return null;
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)string3, (String)string2, (Throwable)invocationTargetException);
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
            return null;
        }
    }

    private static Resources getResources(Context context, String string2) {
        block4: {
            Object[] objectArray = "android";
            int n10 = objectArray.equals(string2);
            if (n10 != 0) {
                return Resources.getSystem();
            }
            context = context.getPackageManager();
            n10 = 8192;
            try {
                objectArray = context.getApplicationInfo(string2, n10);
                if (objectArray == null) break block4;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                objectArray = new Object[]{string2};
                string2 = String.format("Unable to find pkg=%s for icon", objectArray);
                Log.e((String)TAG, (String)string2, (Throwable)nameNotFoundException);
                return null;
            }
            return context.getResourcesForApplication((ApplicationInfo)objectArray);
        }
        return null;
    }

    private static int getType(Icon object) {
        String string2 = "Unable to get icon type ";
        String string3 = TAG;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return object.getType();
        }
        n10 = -1;
        Object object2 = object.getClass();
        CharSequence charSequence = "getType";
        Class[] classArray = new Class[]{};
        object2 = ((Class)object2).getMethod((String)charSequence, classArray);
        charSequence = new Object[]{};
        object2 = ((Method)object2).invoke(object, (Object[])charSequence);
        object2 = (Integer)object2;
        try {
            return (Integer)object2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)string3, (String)object, (Throwable)noSuchMethodException);
            return n10;
        }
        catch (InvocationTargetException invocationTargetException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)string3, (String)object, (Throwable)invocationTargetException);
            return n10;
        }
        catch (IllegalAccessException illegalAccessException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(object);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)string3, (String)object, (Throwable)illegalAccessException);
            return n10;
        }
    }

    private static Uri getUri(Icon object) {
        String string2 = "Unable to get icon uri";
        String string3 = TAG;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return object.getUri();
        }
        n10 = 0;
        GenericDeclaration genericDeclaration = object.getClass();
        Object[] objectArray = "getUri";
        Class[] classArray = new Class[]{};
        genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
        objectArray = new Object[]{};
        object = ((Method)genericDeclaration).invoke(object, objectArray);
        try {
            return (Uri)object;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            Log.e((String)string3, (String)string2, (Throwable)noSuchMethodException);
            return null;
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.e((String)string3, (String)string2, (Throwable)invocationTargetException);
            return null;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.e((String)string3, (String)string2, (Throwable)illegalAccessException);
            return null;
        }
    }

    private Drawable loadDrawableInner(Context context) {
        int n10 = this.mType;
        Object object = null;
        int n11 = 0;
        Object object2 = null;
        switch (n10) {
            default: {
                break;
            }
            case 6: {
                InputStream inputStream = this.getUriInputStream(context);
                if (inputStream == null) break;
                int n12 = Build.VERSION.SDK_INT;
                int n13 = 26;
                if (n12 >= n13) {
                    context = context.getResources();
                    inputStream = BitmapFactory.decodeStream((InputStream)inputStream);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources)context, (Bitmap)inputStream);
                    object2 = new AdaptiveIconDrawable(null, (Drawable)bitmapDrawable);
                    return object2;
                }
                context = context.getResources();
                inputStream = IconCompat.createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream((InputStream)inputStream), false);
                object = new BitmapDrawable((Resources)context, (Bitmap)inputStream);
                return object;
            }
            case 5: {
                context = context.getResources();
                object = IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false);
                BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources)context, (Bitmap)object);
                return bitmapDrawable;
            }
            case 4: {
                InputStream inputStream = this.getUriInputStream(context);
                if (inputStream == null) break;
                context = context.getResources();
                inputStream = BitmapFactory.decodeStream((InputStream)inputStream);
                object = new BitmapDrawable((Resources)context, (Bitmap)inputStream);
                return object;
            }
            case 3: {
                context = context.getResources();
                object = (byte[])this.mObj1;
                n11 = this.mInt1;
                int n14 = this.mInt2;
                object = BitmapFactory.decodeByteArray((byte[])object, (int)n11, (int)n14);
                BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources)context, (Bitmap)object);
                return bitmapDrawable;
            }
            case 2: {
                Object object3 = this.getResPackage();
                int n15 = TextUtils.isEmpty((CharSequence)object3);
                if (n15 != 0) {
                    object3 = context.getPackageName();
                }
                object3 = IconCompat.getResources(context, (String)object3);
                try {
                    n15 = this.mInt1;
                }
                catch (RuntimeException runtimeException) {
                    Object object4;
                    n10 = 2;
                    object3 = new Object[n10];
                    n15 = this.mInt1;
                    object3[0] = object4 = Integer.valueOf(n15);
                    n11 = 1;
                    object3[n11] = object4 = this.mObj1;
                    object3 = String.format("Unable to load resource 0x%08x from pkg=%s", object3);
                    object2 = TAG;
                    Log.e((String)object2, (String)object3, (Throwable)runtimeException);
                    break;
                }
                context = context.getTheme();
                return ResourcesCompat.getDrawable((Resources)object3, n15, (Resources.Theme)context);
            }
            case 1: {
                context = context.getResources();
                object = (Bitmap)this.mObj1;
                BitmapDrawable bitmapDrawable = new BitmapDrawable((Resources)context, (Bitmap)object);
                return bitmapDrawable;
            }
        }
        return null;
    }

    private static String typeToString(int n10) {
        switch (n10) {
            default: {
                return "UNKNOWN";
            }
            case 6: {
                return "URI_MASKABLE";
            }
            case 5: {
                return "BITMAP_MASKABLE";
            }
            case 4: {
                return "URI";
            }
            case 3: {
                return "DATA";
            }
            case 2: {
                return "RESOURCE";
            }
            case 1: 
        }
        return "BITMAP";
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void addToShortcutIntent(Intent object, Drawable object2, Context object3) {
        int n10;
        void var2_4;
        String string2;
        int n11;
        Object object4;
        this.checkResource((Context)object4);
        int n12 = this.mType;
        int n13 = 1;
        if (n12 != n13) {
            n11 = 2;
            if (n12 != n11) {
                int n14 = 5;
                if (n12 != n14) {
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Icon type not supported for intent shortcuts");
                    throw illegalArgumentException;
                }
                object4 = IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, n13 != 0);
            } else {
                try {
                    string2 = this.getResPackage();
                    n13 = 0;
                    Canvas canvas = null;
                    object4 = object4.createPackageContext(string2, 0);
                    if (var2_4 == null) {
                        String string3 = "android.intent.extra.shortcut.ICON_RESOURCE";
                        n12 = this.mInt1;
                        object4 = Intent.ShortcutIconResource.fromContext((Context)object4, (int)n12);
                        object.putExtra(string3, (Parcelable)object4);
                        return;
                    }
                    n12 = this.mInt1;
                    string2 = ContextCompat.getDrawable((Context)object4, n12);
                    n11 = string2.getIntrinsicWidth();
                    if (n11 > 0 && (n11 = string2.getIntrinsicHeight()) > 0) {
                        int n15 = string2.getIntrinsicWidth();
                        n11 = string2.getIntrinsicHeight();
                        Bitmap.Config config = Bitmap.Config.ARGB_8888;
                        object4 = Bitmap.createBitmap((int)n15, (int)n11, (Bitmap.Config)config);
                    } else {
                        String string4 = "activity";
                        object4 = object4.getSystemService(string4);
                        object4 = (ActivityManager)object4;
                        int n16 = object4.getLauncherLargeIconSize();
                        string4 = Bitmap.Config.ARGB_8888;
                        object4 = Bitmap.createBitmap((int)n16, (int)n16, (Bitmap.Config)string4);
                    }
                    n11 = object4.getWidth();
                    n10 = object4.getHeight();
                    string2.setBounds(0, 0, n11, n10);
                    canvas = new Canvas((Bitmap)object4);
                    string2.draw(canvas);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object4 = new StringBuilder();
                    ((StringBuilder)object4).append("Can't find package ");
                    Object object5 = this.mObj1;
                    ((StringBuilder)object4).append(object5);
                    object4 = ((StringBuilder)object4).toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object4, nameNotFoundException);
                    throw illegalArgumentException;
                }
            }
        } else {
            object4 = (Bitmap)this.mObj1;
            if (var2_4 != null) {
                string2 = object4.getConfig();
                object4 = object4.copy((Bitmap.Config)string2, n13 != 0);
            }
        }
        if (var2_4 != null) {
            n12 = object4.getWidth();
            n13 = object4.getHeight();
            n11 = n12 / 2;
            n10 = n13 / 2;
            var2_4.setBounds(n11, n10, n12, n13);
            string2 = new Canvas((Bitmap)object4);
            var2_4.draw((Canvas)string2);
        }
        object.putExtra("android.intent.extra.shortcut.ICON", (Parcelable)object4);
    }

    public void checkResource(Context context) {
        Object object;
        int n10 = this.mType;
        int n11 = 2;
        if (n10 == n11 && (object = this.mObj1) != null) {
            CharSequence charSequence = ":";
            boolean n12 = ((String)(object = (String)object)).contains(charSequence);
            if (!n12) {
                return;
            }
            int n13 = -1;
            Object object2 = ((String)object).split((String)charSequence, n13);
            int n14 = 1;
            object2 = object2[n14];
            String string2 = "/";
            String string3 = ((String)object2).split(string2, n13)[0];
            object2 = ((String)object2).split(string2, n13)[n14];
            charSequence = ((String)object).split((String)charSequence, n13)[0];
            String string4 = "0_resource_name_obfuscated";
            boolean bl2 = string4.equals(object2);
            String string5 = TAG;
            if (bl2) {
                Log.i((String)string5, (String)"Found obfuscated resource, not trying to update resource id for it");
                return;
            }
            n11 = this.mInt1;
            string4 = this.getResPackage();
            int n15 = (context = IconCompat.getResources(context, string4)).getIdentifier((String)object2, string3, (String)charSequence);
            if (n11 != n15) {
                charSequence = new StringBuilder();
                object2 = "Id has changed for ";
                ((StringBuilder)charSequence).append((String)object2);
                ((StringBuilder)charSequence).append(string4);
                string4 = " ";
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
                Log.i((String)string5, (String)object);
                this.mInt1 = n15;
            }
        }
    }

    public Bitmap getBitmap() {
        int n10;
        int n11 = this.mType;
        int n12 = -1;
        if (n11 == n12 && (n12 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
            Object object = this.mObj1;
            n12 = object instanceof Bitmap;
            if (n12) {
                return (Bitmap)object;
            }
            return null;
        }
        n12 = 1;
        if (n11 == n12) {
            return (Bitmap)this.mObj1;
        }
        n10 = 5;
        if (n11 == n10) {
            return IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, n12 != 0);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("called getBitmap() on ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public int getResId() {
        int n10;
        int n11 = this.mType;
        int n12 = -1;
        if (n11 == n12 && (n12 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
            return IconCompat.getResId((Icon)this.mObj1);
        }
        n12 = 2;
        if (n11 == n12) {
            return this.mInt1;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("called getResId() on ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public String getResPackage() {
        int n10;
        int n11;
        int n12 = this.mType;
        int n13 = -1;
        if (n12 == n13 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
            return IconCompat.getResPackage((Icon)this.mObj1);
        }
        n11 = 2;
        if (n12 == n11) {
            String string2 = this.mString1;
            n12 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n12 != 0) {
                return ((String)this.mObj1).split(":", n13)[0];
            }
            return this.mString1;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("called getResPackage() on ");
        charSequence.append(this);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public int getType() {
        int n10;
        int n11 = this.mType;
        int n12 = -1;
        if (n11 == n12 && (n12 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
            Icon icon = (Icon)this.mObj1;
            n11 = IconCompat.getType(icon);
        }
        return n11;
    }

    public Uri getUri() {
        int n10;
        int n11 = this.mType;
        int n12 = -1;
        if (n11 == n12 && (n12 = Build.VERSION.SDK_INT) >= (n10 = 23)) {
            return IconCompat.getUri((Icon)this.mObj1);
        }
        n12 = 4;
        if (n11 != n12 && n11 != (n12 = 6)) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("called getUri() on ");
            charSequence.append(this);
            charSequence = charSequence.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
            throw illegalStateException;
        }
        return Uri.parse((String)((String)this.mObj1));
    }

    public InputStream getUriInputStream(Context object) {
        boolean bl2;
        Object object2 = this.getUri();
        Object object3 = object2.getScheme();
        Object object4 = "content";
        boolean bl3 = ((String)object4).equals(object3);
        String string2 = TAG;
        if (!bl3 && !(bl2 = ((String)(object4 = "file")).equals(object3))) {
            object4 = this.mObj1;
            object4 = (String)object4;
            object3 = new File((String)object4);
            try {
                object = new FileInputStream((File)object3);
                return object;
            }
            catch (FileNotFoundException fileNotFoundException) {
                object3 = new StringBuilder();
                object4 = "Unable to load image from path: ";
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(object2);
                object2 = ((StringBuilder)object3).toString();
                Log.w((String)string2, (String)object2, (Throwable)fileNotFoundException);
            }
        } else {
            object = object.getContentResolver();
            try {
                return object.openInputStream(object2);
            }
            catch (Exception exception) {
                object3 = new StringBuilder();
                object4 = "Unable to load image from URI: ";
                ((StringBuilder)object3).append((String)object4);
                ((StringBuilder)object3).append(object2);
                object2 = ((StringBuilder)object3).toString();
                Log.w((String)string2, (String)object2, (Throwable)exception);
            }
        }
        return null;
    }

    public Drawable loadDrawable(Context context) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList;
        this.checkResource(context);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return this.toIcon(context).loadDrawable(context);
        }
        if ((context = this.loadDrawableInner(context)) != null && ((colorStateList = this.mTintList) != null || (colorStateList = this.mTintMode) != (mode = DEFAULT_TINT_MODE))) {
            context.mutate();
            colorStateList = this.mTintList;
            DrawableCompat.setTintList((Drawable)context, colorStateList);
            colorStateList = this.mTintMode;
            DrawableCompat.setTintMode((Drawable)context, (PorterDuff.Mode)colorStateList);
        }
        return context;
    }

    public void onPostParceling() {
        Object object = PorterDuff.Mode.valueOf((String)this.mTintModeStr);
        this.mTintMode = object;
        int n10 = this.mType;
        switch (n10) {
            default: {
                break;
            }
            case 3: {
                this.mObj1 = object = (Object)this.mData;
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                Object object2 = this.mData;
                Object object3 = Charset.forName("UTF-16");
                this.mObj1 = object = new String((byte[])object2, (Charset)object3);
                int n11 = this.mType;
                int n12 = 2;
                if (n11 != n12 || (object2 = (Object)this.mString1) != null) break;
                object = (String)object;
                n11 = -1;
                object3 = ":";
                this.mString1 = object = ((String)object).split((String)object3, n11)[0];
                break;
            }
            case 1: 
            case 5: {
                int n13;
                object = this.mParcelable;
                if (object != null) {
                    this.mObj1 = object;
                    break;
                }
                this.mObj1 = object = (Object)this.mData;
                this.mType = n13 = 3;
                this.mInt1 = 0;
                this.mInt2 = n10 = ((PorterDuff.Mode)object).length;
                break;
            }
            case -1: {
                object = this.mParcelable;
                if (object != null) {
                    this.mObj1 = object;
                    break;
                }
                object = new IllegalArgumentException("Invalid icon");
                throw object;
            }
        }
    }

    public void onPreParceling(boolean bl2) {
        Object object = this.mTintMode.name();
        this.mTintModeStr = object;
        int n10 = this.mType;
        String string2 = "UTF-16";
        switch (n10) {
            default: {
                break;
            }
            case 4: 
            case 6: {
                Object object2 = this.mObj1.toString();
                object = Charset.forName(string2);
                object2 = ((String)object2).getBytes((Charset)object);
                this.mData = (byte[])object2;
                break;
            }
            case 3: {
                byte[] byArray = (byte[])this.mObj1;
                this.mData = byArray;
                break;
            }
            case 2: {
                Object object3 = (String)this.mObj1;
                object = Charset.forName(string2);
                object3 = ((String)object3).getBytes((Charset)object);
                this.mData = (byte[])object3;
                break;
            }
            case 1: 
            case 5: {
                Parcelable parcelable;
                if (bl2) {
                    Object object4 = (Bitmap)this.mObj1;
                    object = new ByteArrayOutputStream();
                    string2 = Bitmap.CompressFormat.PNG;
                    int n11 = 90;
                    object4.compress((Bitmap.CompressFormat)string2, n11, (OutputStream)object);
                    object4 = ((ByteArrayOutputStream)object).toByteArray();
                    this.mData = (byte[])object4;
                    break;
                }
                this.mParcelable = parcelable = (Parcelable)this.mObj1;
                break;
            }
            case -1: {
                if (!bl2) {
                    Parcelable parcelable;
                    this.mParcelable = parcelable = (Parcelable)this.mObj1;
                    break;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                throw illegalArgumentException;
            }
        }
    }

    public IconCompat setTint(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        return this.setTintList(colorStateList);
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    public Bundle toBundle() {
        Object object;
        Object object2 = new Bundle();
        int n10 = this.mType;
        String string2 = EXTRA_OBJ;
        switch (n10) {
            default: {
                object2 = new IllegalArgumentException("Invalid icon");
                throw object2;
            }
            case 3: {
                object = (byte[])this.mObj1;
                object2.putByteArray(string2, object);
                break;
            }
            case 2: 
            case 4: 
            case 6: {
                object = (String)this.mObj1;
                object2.putString(string2, (String)object);
                break;
            }
            case 1: 
            case 5: {
                object = (Bitmap)this.mObj1;
                object2.putParcelable(string2, (Parcelable)object);
                break;
            }
            case -1: {
                object = (Parcelable)this.mObj1;
                object2.putParcelable(string2, (Parcelable)object);
            }
        }
        n10 = this.mType;
        object2.putInt(EXTRA_TYPE, n10);
        n10 = this.mInt1;
        object2.putInt(EXTRA_INT1, n10);
        n10 = this.mInt2;
        object2.putInt(EXTRA_INT2, n10);
        object = this.mString1;
        string2 = EXTRA_STRING1;
        object2.putString(string2, (String)object);
        object = this.mTintList;
        if (object != null) {
            string2 = EXTRA_TINT_LIST;
            object2.putParcelable(string2, (Parcelable)object);
        }
        if ((object = (Object)this.mTintMode) != (string2 = DEFAULT_TINT_MODE)) {
            object = object.name();
            string2 = EXTRA_TINT_MODE;
            object2.putString(string2, (String)object);
        }
        return object2;
    }

    public Icon toIcon() {
        return this.toIcon(null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Icon toIcon(Context var1_1) {
        var2_2 = Build.VERSION.SDK_INT;
        var3_3 = this.mType;
        var4_4 = 26;
        switch (var3_3) {
            default: {
                var1_1 /* !! */  = new IllegalArgumentException("Unknown type");
                throw var1_1 /* !! */ ;
            }
            case 6: {
                var3_3 = 30;
                if (var2_2 < var3_3) ** GOTO lbl13
                var1_1 /* !! */  = Icon.createWithAdaptiveBitmapContentUri((Uri)this.getUri());
                ** GOTO lbl54
lbl13:
                // 1 sources

                if (var1_1 /* !! */  == null) ** GOTO lbl26
                if ((var1_1 /* !! */  = this.getUriInputStream(var1_1 /* !! */ )) == null) ** GOTO lbl17
                var1_1 /* !! */  = var2_2 >= var4_4 ? Icon.createWithAdaptiveBitmap((Bitmap)BitmapFactory.decodeStream((InputStream)var1_1 /* !! */ )) : Icon.createWithBitmap((Bitmap)IconCompat.createLegacyIconFromAdaptiveIcon(BitmapFactory.decodeStream((InputStream)var1_1 /* !! */ ), false));
                ** GOTO lbl54
lbl17:
                // 1 sources

                var5_5 /* !! */  = new StringBuilder();
                var5_5 /* !! */ .append("Cannot load adaptive icon from uri: ");
                var6_8 = this.getUri();
                var5_5 /* !! */ .append(var6_8);
                var5_5 /* !! */  = var5_5 /* !! */ .toString();
                var1_1 /* !! */  = new IllegalStateException((String)var5_5 /* !! */ );
                throw var1_1 /* !! */ ;
lbl26:
                // 1 sources

                var5_6 /* !! */  = new StringBuilder();
                var5_6 /* !! */ .append("Context is required to resolve the file uri of the icon: ");
                var6_9 = this.getUri();
                var5_6 /* !! */ .append(var6_9);
                var5_6 /* !! */  = var5_6 /* !! */ .toString();
                var1_1 /* !! */  = new IllegalArgumentException((String)var5_6 /* !! */ );
                throw var1_1 /* !! */ ;
            }
            case 5: {
                var1_1 /* !! */  = var2_2 >= var4_4 ? Icon.createWithAdaptiveBitmap((Bitmap)((Bitmap)this.mObj1)) : Icon.createWithBitmap((Bitmap)IconCompat.createLegacyIconFromAdaptiveIcon((Bitmap)this.mObj1, false));
                ** GOTO lbl54
            }
            case 4: {
                var1_1 /* !! */  = Icon.createWithContentUri((String)((String)this.mObj1));
                ** GOTO lbl54
            }
            case 3: {
                var1_1 /* !! */  = (Context)((byte[])this.mObj1);
                var2_2 = this.mInt1;
                var3_3 = this.mInt2;
                var1_1 /* !! */  = Icon.createWithData((byte[])var1_1 /* !! */ , (int)var2_2, (int)var3_3);
                ** GOTO lbl54
            }
            case 2: {
                var1_1 /* !! */  = this.getResPackage();
                var2_2 = this.mInt1;
                var1_1 /* !! */  = Icon.createWithResource((String)var1_1 /* !! */ , (int)var2_2);
                ** GOTO lbl54
            }
            case 1: {
                var1_1 /* !! */  = Icon.createWithBitmap((Bitmap)((Bitmap)this.mObj1));
lbl54:
                // 7 sources

                var5_7 = this.mTintList;
                if (var5_7 != null) {
                    var1_1 /* !! */ .setTintList(var5_7);
                }
                if ((var5_7 = this.mTintMode) != (var6_10 = IconCompat.DEFAULT_TINT_MODE)) {
                    var1_1 /* !! */ .setTintMode((PorterDuff.Mode)var5_7);
                }
                return var1_1 /* !! */ ;
            }
            case -1: 
        }
        return (Icon)this.mObj1;
    }

    public String toString() {
        Object object;
        int n10 = this.mType;
        int n11 = -1;
        if (n10 == n11) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder stringBuilder = new StringBuilder("Icon(typ=");
        Object object2 = IconCompat.typeToString(this.mType);
        stringBuilder.append((String)object2);
        n11 = this.mType;
        switch (n11) {
            default: {
                break;
            }
            case 4: 
            case 6: {
                stringBuilder.append(" uri=");
                object2 = this.mObj1;
                stringBuilder.append(object2);
                break;
            }
            case 3: {
                object2 = " len=";
                stringBuilder.append((String)object2);
                n11 = this.mInt1;
                stringBuilder.append(n11);
                n11 = this.mInt2;
                if (n11 == 0) break;
                object2 = " off=";
                stringBuilder.append((String)object2);
                n11 = this.mInt2;
                stringBuilder.append(n11);
                break;
            }
            case 2: {
                stringBuilder.append(" pkg=");
                object2 = this.mString1;
                stringBuilder.append((String)object2);
                stringBuilder.append(" id=");
                n11 = 1;
                object2 = new Object[n11];
                int n12 = this.getResId();
                Integer n13 = n12;
                object2[0] = n13;
                object = "0x%08x";
                object2 = String.format((String)object, (Object[])object2);
                stringBuilder.append((String)object2);
                break;
            }
            case 1: 
            case 5: {
                stringBuilder.append(" size=");
                n11 = ((Bitmap)this.mObj1).getWidth();
                stringBuilder.append(n11);
                stringBuilder.append("x");
                object2 = (Bitmap)this.mObj1;
                n11 = object2.getHeight();
                stringBuilder.append(n11);
            }
        }
        object2 = this.mTintList;
        if (object2 != null) {
            stringBuilder.append(" tint=");
            object2 = this.mTintList;
            stringBuilder.append(object2);
        }
        if ((object2 = this.mTintMode) != (object = DEFAULT_TINT_MODE)) {
            stringBuilder.append(" mode=");
            object2 = this.mTintMode;
            stringBuilder.append(object2);
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

