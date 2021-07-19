/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 *  android.content.res.Resources$Theme
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.util.Log
 *  android.util.TypedValue
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.util.Preconditions;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat {
    public static final int ID_NULL = 0;
    private static final String TAG = "ResourcesCompat";

    private ResourcesCompat() {
    }

    public static Typeface getCachedFont(Context context, int n10) {
        boolean bl2 = context.isRestricted();
        if (bl2) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        return ResourcesCompat.loadFont(context, n10, typedValue, 0, null, null, false, true);
    }

    public static int getColor(Resources resources, int n10, Resources.Theme theme) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return resources.getColor(n10, theme);
        }
        return resources.getColor(n10);
    }

    public static ColorStateList getColorStateList(Resources resources, int n10, Resources.Theme theme) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            return resources.getColorStateList(n10, theme);
        }
        return resources.getColorStateList(n10);
    }

    public static Drawable getDrawable(Resources resources, int n10, Resources.Theme theme) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return resources.getDrawable(n10, theme);
        }
        return resources.getDrawable(n10);
    }

    public static Drawable getDrawableForDensity(Resources resources, int n10, int n11, Resources.Theme theme) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 21;
        if (n12 >= n13) {
            return resources.getDrawableForDensity(n10, n11, theme);
        }
        int n14 = 15;
        if (n12 >= n14) {
            return resources.getDrawableForDensity(n10, n11);
        }
        return resources.getDrawable(n10);
    }

    public static float getFloat(Resources object, int n10) {
        TypedValue typedValue = new TypedValue();
        object.getValue(n10, typedValue, true);
        int n11 = typedValue.type;
        int n12 = 4;
        if (n11 == n12) {
            return typedValue.getFloat();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource ID #0x");
        String string2 = Integer.toHexString(n10);
        stringBuilder.append(string2);
        stringBuilder.append(" type #0x");
        string2 = Integer.toHexString(typedValue.type);
        stringBuilder.append(string2);
        stringBuilder.append(" is not valid");
        string2 = stringBuilder.toString();
        object = new Resources.NotFoundException(string2);
        throw object;
    }

    public static Typeface getFont(Context context, int n10) {
        boolean bl2 = context.isRestricted();
        if (bl2) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        return ResourcesCompat.loadFont(context, n10, typedValue, 0, null, null, false, false);
    }

    public static Typeface getFont(Context context, int n10, TypedValue typedValue, int n11, ResourcesCompat$FontCallback resourcesCompat$FontCallback) {
        boolean bl2 = context.isRestricted();
        if (bl2) {
            return null;
        }
        return ResourcesCompat.loadFont(context, n10, typedValue, n11, resourcesCompat$FontCallback, null, true, false);
    }

    public static void getFont(Context context, int n10, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler) {
        Preconditions.checkNotNull(resourcesCompat$FontCallback);
        boolean bl2 = context.isRestricted();
        if (bl2) {
            resourcesCompat$FontCallback.callbackFailAsync(-4, handler);
            return;
        }
        TypedValue typedValue = new TypedValue();
        ResourcesCompat.loadFont(context, n10, typedValue, 0, resourcesCompat$FontCallback, handler, false, false);
    }

    private static Typeface loadFont(Context context, int n10, TypedValue typedValue, int n11, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler, boolean bl2, boolean bl3) {
        Object object = context.getResources();
        boolean bl4 = true;
        Object object2 = typedValue;
        object.getValue(n10, typedValue, bl4);
        Object object3 = context;
        object3 = ResourcesCompat.loadFont(context, (Resources)object, typedValue, n10, n11, resourcesCompat$FontCallback, handler, bl2, bl3);
        if (object3 == null && resourcesCompat$FontCallback == null && !bl3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Font resource ID #0x");
            object2 = Integer.toHexString(n10);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" could not be retrieved.");
            object = ((StringBuilder)object).toString();
            object3 = new Resources.NotFoundException((String)object);
            throw object3;
        }
        return object3;
    }

    private static Typeface loadFont(Context context, Resources resources, TypedValue typedValue, int n10, int n11, ResourcesCompat$FontCallback resourcesCompat$FontCallback, Handler handler, boolean bl2, boolean bl3) {
        Object object = resources;
        Object object2 = typedValue;
        ResourcesCompat$FontCallback resourcesCompat$FontCallback2 = resourcesCompat$FontCallback;
        Handler handler2 = handler;
        String string2 = TAG;
        Object object3 = typedValue.string;
        if (object3 != null) {
            int n12;
            block24: {
                block22: {
                    String string3;
                    block23: {
                        block19: {
                            block20: {
                                block21: {
                                    string3 = object3.toString();
                                    object2 = "res/";
                                    boolean bl4 = string3.startsWith((String)object2);
                                    n12 = -3;
                                    if (!bl4) {
                                        if (resourcesCompat$FontCallback != null) {
                                            resourcesCompat$FontCallback.callbackFailAsync(n12, handler);
                                        }
                                        return null;
                                    }
                                    object2 = TypefaceCompat.findFromCache(resources, n10, n11);
                                    if (object2 != null) {
                                        if (resourcesCompat$FontCallback != null) {
                                            resourcesCompat$FontCallback.callbackSuccessAsync((Typeface)object2, handler);
                                        }
                                        return object2;
                                    }
                                    if (bl3) {
                                        return null;
                                    }
                                    object2 = string3.toLowerCase();
                                    object3 = ".xml";
                                    bl4 = ((String)object2).endsWith((String)object3);
                                    if (!bl4) break block19;
                                    object2 = resources.getXml(n10);
                                    object3 = FontResourcesParserCompat.parse((XmlPullParser)object2, resources);
                                    if (object3 != null) break block20;
                                    object = "Failed to find font-family tag";
                                    Log.e((String)string2, (String)object);
                                    if (resourcesCompat$FontCallback == null) break block21;
                                    resourcesCompat$FontCallback.callbackFailAsync(n12, handler);
                                }
                                return null;
                            }
                            object2 = context;
                            Resources resources2 = resources;
                            return TypefaceCompat.createFromResourcesFamilyXml(context, (FontResourcesParserCompat$FamilyResourceEntry)object3, resources, n10, n11, resourcesCompat$FontCallback, handler, bl2);
                        }
                        object2 = context;
                        object = TypefaceCompat.createFromResourcesFontFile(context, resources, n10, string3, n11);
                        if (resourcesCompat$FontCallback == null) break block22;
                        if (object == null) break block23;
                        resourcesCompat$FontCallback.callbackSuccessAsync((Typeface)object, handler);
                        break block22;
                    }
                    try {
                        resourcesCompat$FontCallback.callbackFailAsync(n12, handler);
                    }
                    catch (IOException iOException) {
                        object2 = new StringBuilder();
                        object3 = "Failed to read xml resource ";
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append(string3);
                        object2 = ((StringBuilder)object2).toString();
                        Log.e((String)string2, (String)object2, (Throwable)iOException);
                        break block24;
                    }
                    catch (XmlPullParserException xmlPullParserException) {
                        object2 = new StringBuilder();
                        object3 = "Failed to parse xml resource ";
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append(string3);
                        object2 = ((StringBuilder)object2).toString();
                        Log.e((String)string2, (String)object2, (Throwable)xmlPullParserException);
                    }
                }
                return object;
            }
            if (resourcesCompat$FontCallback2 != null) {
                resourcesCompat$FontCallback2.callbackFailAsync(n12, handler2);
            }
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Resource \"");
        object = resources.getResourceName(n10);
        stringBuilder.append((String)object);
        stringBuilder.append("\" (");
        object = Integer.toHexString(n10);
        stringBuilder.append((String)object);
        stringBuilder.append(") is not a Font: ");
        stringBuilder.append(typedValue);
        object = stringBuilder.toString();
        object3 = new Resources.NotFoundException((String)object);
        throw object3;
    }
}

