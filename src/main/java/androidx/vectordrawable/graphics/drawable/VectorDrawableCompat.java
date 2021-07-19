/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCommon;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VClipPath;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VGroup;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableCompatState;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat
extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    public static final PorterDuff.Mode DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    public static final String LOGTAG = "VectorDrawableCompat";
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";
    private boolean mAllowCaching = true;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompat$VectorDrawableCompatState mVectorState;

    public VectorDrawableCompat() {
        Object object = new float[9];
        this.mTmpFloats = object;
        object = new Matrix;
        this.mTmpMatrix = (Matrix)object;
        object = new Rect;
        super();
        this.mTmpBounds = (Rect)object;
        object = (Object)new VectorDrawableCompat$VectorDrawableCompatState;
        super();
        this.mVectorState = (VectorDrawableCompat$VectorDrawableCompatState)((Object)object);
    }

    public VectorDrawableCompat(VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState) {
        Object object = new float[9];
        this.mTmpFloats = object;
        object = new Matrix;
        this.mTmpMatrix = (Matrix)object;
        object = new Rect;
        super();
        this.mTmpBounds = (Rect)object;
        this.mVectorState = vectorDrawableCompat$VectorDrawableCompatState;
        object = this.mTintFilter;
        ColorStateList colorStateList = vectorDrawableCompat$VectorDrawableCompatState.mTint;
        vectorDrawableCompat$VectorDrawableCompatState = vectorDrawableCompat$VectorDrawableCompatState.mTintMode;
        vectorDrawableCompat$VectorDrawableCompatState = this.updateTintFilter((PorterDuffColorFilter)object, colorStateList, (PorterDuff.Mode)vectorDrawableCompat$VectorDrawableCompatState);
        this.mTintFilter = vectorDrawableCompat$VectorDrawableCompatState;
    }

    public static int applyAlpha(int n10, float f10) {
        int n11 = Color.alpha((int)n10);
        int n12 = (int)((float)n11 * f10) << 24;
        return (n10 &= 0xFFFFFF) | n12;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static VectorDrawableCompat create(Resources object, int n10, Resources.Theme theme) {
        Object object2 = "parser error";
        String string2 = LOGTAG;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            object2 = new VectorDrawableCompat();
            object = ResourcesCompat.getDrawable(object, n10, theme);
            ((VectorDrawableCommon)object2).mDelegateDrawable = object;
            Drawable.ConstantState constantState = ((VectorDrawableCommon)object2).mDelegateDrawable.getConstantState();
            object = new VectorDrawableCompat$VectorDrawableDelegateState(constantState);
            ((VectorDrawableCompat)object2).mCachedConstantStateDelegate = object;
            return object2;
        }
        try {
            int n13;
            int n14;
            Object object3 = object.getXml(n10);
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)object3);
            while ((n12 = object3.next()) != (n14 = 2) && n12 != (n13 = 1)) {
            }
            if (n12 == n14) {
                return VectorDrawableCompat.createFromXmlInner(object, (XmlPullParser)object3, attributeSet, theme);
            }
            object3 = "No start tag found";
            object = new XmlPullParserException((String)object3);
            throw object;
        }
        catch (IOException iOException) {
            Log.e((String)string2, (String)object2, (Throwable)iOException);
            return null;
        }
        catch (XmlPullParserException xmlPullParserException) {
            Log.e((String)string2, (String)object2, (Throwable)xmlPullParserException);
        }
        return null;
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void inflateInternal(Resources object, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
        VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<Object>();
        Object object2 = vectorDrawableCompat$VPathRenderer.mRootGroup;
        arrayDeque.push(object2);
        int n10 = xmlPullParser.getEventType();
        int n11 = xmlPullParser.getDepth();
        int n12 = 1;
        n11 += n12;
        int n13 = n12;
        while (n10 != n12) {
            int n14 = xmlPullParser.getDepth();
            int n15 = 3;
            if (n14 < n11 && n10 == n15) break;
            n14 = 2;
            String string2 = SHAPE_GROUP;
            if (n10 == n14) {
                object2 = xmlPullParser.getName();
                Object object3 = (VectorDrawableCompat$VGroup)arrayDeque.peek();
                String string3 = SHAPE_PATH;
                n15 = (int)(string3.equals(object2) ? 1 : 0);
                if (n15 != 0) {
                    object2 = new VectorDrawableCompat$VFullPath();
                    ((VectorDrawableCompat$VFullPath)object2).inflate((Resources)object, attributeSet, theme, xmlPullParser);
                    ((VectorDrawableCompat$VGroup)object3).mChildren.add(object2);
                    Object object4 = ((VectorDrawableCompat$VPath)object2).getPathName();
                    if (object4 != null) {
                        object4 = vectorDrawableCompat$VPathRenderer.mVGTargetsMap;
                        object3 = ((VectorDrawableCompat$VPath)object2).getPathName();
                        ((SimpleArrayMap)object4).put(object3, object2);
                    }
                    n13 = 0;
                    object4 = null;
                    n14 = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
                    vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations = n10 = ((VectorDrawableCompat$VPath)object2).mChangingConfigurations | n14;
                } else {
                    string3 = SHAPE_CLIP_PATH;
                    n15 = (int)(string3.equals(object2) ? 1 : 0);
                    if (n15 != 0) {
                        object2 = new VectorDrawableCompat$VClipPath();
                        ((VectorDrawableCompat$VClipPath)object2).inflate((Resources)object, attributeSet, theme, xmlPullParser);
                        ((VectorDrawableCompat$VGroup)object3).mChildren.add(object2);
                        object3 = ((VectorDrawableCompat$VPath)object2).getPathName();
                        if (object3 != null) {
                            object3 = vectorDrawableCompat$VPathRenderer.mVGTargetsMap;
                            string3 = ((VectorDrawableCompat$VPath)object2).getPathName();
                            ((SimpleArrayMap)object3).put(string3, object2);
                        }
                        n14 = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
                        vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations = n10 = ((VectorDrawableCompat$VPath)object2).mChangingConfigurations | n14;
                    } else {
                        n10 = (int)(string2.equals(object2) ? 1 : 0);
                        if (n10 != 0) {
                            object2 = new VectorDrawableCompat$VGroup();
                            ((VectorDrawableCompat$VGroup)object2).inflate((Resources)object, attributeSet, theme, xmlPullParser);
                            ((VectorDrawableCompat$VGroup)object3).mChildren.add(object2);
                            arrayDeque.push(object2);
                            object3 = ((VectorDrawableCompat$VGroup)object2).getGroupName();
                            if (object3 != null) {
                                object3 = vectorDrawableCompat$VPathRenderer.mVGTargetsMap;
                                string3 = ((VectorDrawableCompat$VGroup)object2).getGroupName();
                                ((SimpleArrayMap)object3).put(string3, object2);
                            }
                            n14 = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
                            vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations = n10 = ((VectorDrawableCompat$VGroup)object2).mChangingConfigurations | n14;
                        }
                    }
                }
            } else if (n10 == n15 && (n10 = (int)(string2.equals(object2 = xmlPullParser.getName()) ? 1 : 0)) != 0) {
                arrayDeque.pop();
            }
            n10 = xmlPullParser.next();
        }
        if (n13 == 0) {
            return;
        }
        object = new XmlPullParserException("no path defined");
        throw object;
    }

    private boolean needMirroring() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        int n12 = 17;
        if (n10 >= n12) {
            n10 = (int)(this.isAutoMirrored() ? 1 : 0);
            n12 = 1;
            if (n10 != 0 && (n10 = DrawableCompat.getLayoutDirection(this)) == n12) {
                n11 = n12;
            }
        }
        return n11 != 0;
    }

    private static PorterDuff.Mode parseTintModeCompat(int n10, PorterDuff.Mode mode) {
        int n11 = 3;
        if (n10 != n11) {
            n11 = 5;
            if (n10 != n11) {
                n11 = 9;
                if (n10 != n11) {
                    switch (n10) {
                        default: {
                            return mode;
                        }
                        case 16: {
                            return PorterDuff.Mode.ADD;
                        }
                        case 15: {
                            return PorterDuff.Mode.SCREEN;
                        }
                        case 14: 
                    }
                    return PorterDuff.Mode.MULTIPLY;
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    private void printGroupTree(VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup, int n10) {
        int n11;
        CharSequence charSequence;
        int n12;
        int n13 = 0;
        Object object = "";
        CharSequence charSequence2 = null;
        for (n12 = 0; n12 < n10; ++n12) {
            charSequence = new StringBuilder();
            charSequence.append((String)object);
            charSequence.append("    ");
            object = charSequence.toString();
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append("current group is :");
        charSequence = vectorDrawableCompat$VGroup.getGroupName();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(" rotation is ");
        float f10 = vectorDrawableCompat$VGroup.mRotate;
        ((StringBuilder)charSequence2).append(f10);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        charSequence = LOGTAG;
        Log.v((String)charSequence, (String)charSequence2);
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append("matrix is :");
        object = vectorDrawableCompat$VGroup.getLocalMatrix().toString();
        ((StringBuilder)charSequence2).append((String)object);
        object = ((StringBuilder)charSequence2).toString();
        Log.v((String)charSequence, (String)object);
        while (n13 < (n11 = ((ArrayList)(object = vectorDrawableCompat$VGroup.mChildren)).size())) {
            object = (VectorDrawableCompat$VObject)vectorDrawableCompat$VGroup.mChildren.get(n13);
            n12 = object instanceof VectorDrawableCompat$VGroup;
            if (n12 != 0) {
                object = (VectorDrawableCompat$VGroup)object;
                n12 = n10 + 1;
                this.printGroupTree((VectorDrawableCompat$VGroup)object, n12);
            } else {
                object = (VectorDrawableCompat$VPath)object;
                n12 = n10 + 1;
                ((VectorDrawableCompat$VPath)object).printVPath(n12);
            }
            ++n13;
        }
    }

    private void updateStateFromTypedArray(TypedArray object, XmlPullParser object2, Resources.Theme object3) {
        float f10;
        int n10;
        Object object4;
        VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
        VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer;
        int n11 = -1;
        int bl2 = TypedArrayUtils.getNamedInt((TypedArray)object, (XmlPullParser)object2, "tintMode", 6, n11);
        Object object5 = PorterDuff.Mode.SRC_IN;
        vectorDrawableCompat$VectorDrawableCompatState.mTintMode = object4 = VectorDrawableCompat.parseTintModeCompat(bl2, object5);
        object4 = "tint";
        int n12 = 1;
        if ((object3 = TypedArrayUtils.getNamedColorStateList((TypedArray)object, (XmlPullParser)object2, (Resources.Theme)object3, (String)object4, n12)) != null) {
            vectorDrawableCompat$VectorDrawableCompatState.mTint = object3;
        }
        boolean bl3 = vectorDrawableCompat$VectorDrawableCompatState.mAutoMirrored;
        object5 = "autoMirrored";
        vectorDrawableCompat$VectorDrawableCompatState.mAutoMirrored = n10 = TypedArrayUtils.getNamedBoolean((TypedArray)object, (XmlPullParser)object2, (String)object5, 5, bl3);
        float f11 = vectorDrawableCompat$VPathRenderer.mViewportWidth;
        vectorDrawableCompat$VPathRenderer.mViewportWidth = f10 = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)object2, "viewportWidth", 7, f11);
        n10 = 8;
        f11 = vectorDrawableCompat$VPathRenderer.mViewportHeight;
        vectorDrawableCompat$VPathRenderer.mViewportHeight = f10 = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)object2, "viewportHeight", n10, f11);
        f11 = vectorDrawableCompat$VPathRenderer.mViewportWidth;
        boolean bl4 = false;
        object4 = null;
        float f12 = f11 - 0.0f;
        Object object6 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object6 > 0) {
            float f13 = f10 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
            if (n10 > 0) {
                f11 = vectorDrawableCompat$VPathRenderer.mBaseWidth;
                vectorDrawableCompat$VPathRenderer.mBaseWidth = f10 = object.getDimension(3, f11);
                n10 = 2;
                f11 = vectorDrawableCompat$VPathRenderer.mBaseHeight;
                vectorDrawableCompat$VPathRenderer.mBaseHeight = f10 = object.getDimension(n10, f11);
                f11 = vectorDrawableCompat$VPathRenderer.mBaseWidth;
                float f14 = f11 - 0.0f;
                object6 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                if (object6 > 0) {
                    float f15 = f10 - 0.0f;
                    n10 = (int)(f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1));
                    if (n10 > 0) {
                        n10 = 4;
                        f10 = 5.6E-45f;
                        f11 = vectorDrawableCompat$VPathRenderer.getAlpha();
                        object4 = "alpha";
                        float f16 = TypedArrayUtils.getNamedFloat((TypedArray)object, (XmlPullParser)object2, (String)object4, n10, f11);
                        vectorDrawableCompat$VPathRenderer.setAlpha(f16);
                        f16 = 0.0f;
                        object2 = null;
                        object = object.getString(0);
                        if (object != null) {
                            vectorDrawableCompat$VPathRenderer.mRootName = object;
                            object2 = vectorDrawableCompat$VPathRenderer.mVGTargetsMap;
                            ((SimpleArrayMap)object2).put(object, vectorDrawableCompat$VPathRenderer);
                        }
                        return;
                    }
                    object3 = new StringBuilder();
                    object = object.getPositionDescription();
                    ((StringBuilder)object3).append((String)object);
                    ((StringBuilder)object3).append("<vector> tag requires height > 0");
                    object = ((StringBuilder)object3).toString();
                    object2 = new XmlPullParserException((String)object);
                    throw object2;
                }
                object3 = new StringBuilder();
                object = object.getPositionDescription();
                ((StringBuilder)object3).append((String)object);
                ((StringBuilder)object3).append("<vector> tag requires width > 0");
                object = ((StringBuilder)object3).toString();
                object2 = new XmlPullParserException((String)object);
                throw object2;
            }
            object3 = new StringBuilder();
            object = object.getPositionDescription();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("<vector> tag requires viewportHeight > 0");
            object = ((StringBuilder)object3).toString();
            object2 = new XmlPullParserException((String)object);
            throw object2;
        }
        object3 = new StringBuilder();
        object = object.getPositionDescription();
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append("<vector> tag requires viewportWidth > 0");
        object = ((StringBuilder)object3).toString();
        object2 = new XmlPullParserException((String)object);
        throw object2;
    }

    public boolean canApplyTheme() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.canApplyTheme(drawable2);
        }
        return false;
    }

    public void draw(Canvas canvas) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.draw(canvas);
            return;
        }
        drawable2 = this.mTmpBounds;
        this.copyBounds((Rect)drawable2);
        drawable2 = this.mTmpBounds;
        int n10 = drawable2.width();
        if (n10 > 0 && (n10 = (drawable2 = this.mTmpBounds).height()) > 0) {
            int n11;
            int n12;
            float f10;
            drawable2 = this.mColorFilter;
            if (drawable2 == null) {
                drawable2 = this.mTintFilter;
            }
            Object object = this.mTmpMatrix;
            canvas.getMatrix((Matrix)object);
            object = this.mTmpMatrix;
            Object object2 = this.mTmpFloats;
            object.getValues(object2);
            object = this.mTmpFloats;
            boolean bl2 = false;
            object2 = null;
            float f11 = Math.abs((float)object[0]);
            float[] fArray = this.mTmpFloats;
            float f12 = Math.abs(fArray[4]);
            Object object3 = this.mTmpFloats;
            int n13 = 1;
            float f13 = Math.abs(object3[n13]);
            Object object4 = this.mTmpFloats;
            float f14 = Math.abs(object4[3]);
            float f15 = f13 - 0.0f;
            float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            int n14 = 1065353216;
            float f17 = 1.0f;
            if (f16 != false || (f16 = (f10 = f14 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != false) {
                n12 = n14;
                f11 = f17;
                n11 = n14;
                f12 = f17;
            }
            n12 = (int)((float)this.mTmpBounds.width() * f11);
            object3 = this.mTmpBounds;
            n11 = (int)((float)object3.height() * f12);
            f16 = 2048;
            f13 = 2.87E-42f;
            n12 = Math.min((int)f16, n12);
            n11 = Math.min((int)f16, n11);
            if (n12 > 0 && n11 > 0) {
                f16 = canvas.save();
                object4 = this.mTmpBounds;
                int n15 = object4.left;
                float f18 = n15;
                f14 = object4.top;
                canvas.translate(f18, f14);
                n13 = (int)(this.needMirroring() ? 1 : 0);
                if (n13 != 0) {
                    object4 = this.mTmpBounds;
                    f14 = object4.width();
                    canvas.translate(f14, 0.0f);
                    n13 = -1082130432;
                    f14 = -1.0f;
                    canvas.scale(f14, f17);
                }
                object4 = this.mTmpBounds;
                object4.offsetTo(0, 0);
                object2 = (Object)this.mVectorState;
                object2.createCachedBitmapIfNeeded(n12, n11);
                bl2 = this.mAllowCaching;
                if (!bl2) {
                    object2 = this.mVectorState;
                    object2.updateCachedBitmap(n12, n11);
                } else {
                    object2 = (Object)this.mVectorState;
                    bl2 = object2.canReuseCache();
                    if (!bl2) {
                        object2 = this.mVectorState;
                        object2.updateCachedBitmap(n12, n11);
                        object = this.mVectorState;
                        ((VectorDrawableCompat$VectorDrawableCompatState)((Object)object)).updateCacheStates();
                    }
                }
                object = this.mVectorState;
                object2 = this.mTmpBounds;
                ((VectorDrawableCompat$VectorDrawableCompatState)((Object)object)).drawCachedBitmapWithRootAlpha(canvas, (ColorFilter)drawable2, (Rect)object2);
                canvas.restoreToCount((int)f16);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.getAlpha(drawable2);
        }
        return this.mVectorState.mVPathRenderer.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getChangingConfigurations();
        }
        int n10 = super.getChangingConfigurations();
        int n11 = this.mVectorState.getChangingConfigurations();
        return n10 | n11;
    }

    public ColorFilter getColorFilter() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.getColorFilter(drawable2);
        }
        return this.mColorFilter;
    }

    public Drawable.ConstantState getConstantState() {
        int n10;
        int n11;
        Object object = this.mDelegateDrawable;
        if (object != null && (n11 = Build.VERSION.SDK_INT) >= (n10 = 24)) {
            Drawable.ConstantState constantState = this.mDelegateDrawable.getConstantState();
            object = new VectorDrawableCompat$VectorDrawableDelegateState(constantState);
            return object;
        }
        object = this.mVectorState;
        object.mChangingConfigurations = n10 = this.getChangingConfigurations();
        return this.mVectorState;
    }

    public int getIntrinsicHeight() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getIntrinsicHeight();
        }
        return (int)this.mVectorState.mVPathRenderer.mBaseHeight;
    }

    public int getIntrinsicWidth() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getIntrinsicWidth();
        }
        return (int)this.mVectorState.mVPathRenderer.mBaseWidth;
    }

    public int getOpacity() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -3;
    }

    public float getPixelSize() {
        Object object = this.mVectorState;
        if (object != null && (object = object.mVPathRenderer) != null) {
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18 = ((VectorDrawableCompat$VPathRenderer)object).mBaseWidth;
            boolean bl2 = false;
            float f19 = f18 - 0.0f;
            Object object2 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
            if (object2 != false && (f17 = (f16 = (f15 = ((VectorDrawableCompat$VPathRenderer)object).mBaseHeight) - 0.0f) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) != false && (f14 = (f13 = (f12 = ((VectorDrawableCompat$VPathRenderer)object).mViewportHeight) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) != false && (bl2 = (f11 = (f10 = ((VectorDrawableCompat$VPathRenderer)object).mViewportWidth) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) {
                return Math.min(f10 /= f18, f12 /= f15);
            }
        }
        return 1.0f;
    }

    public Object getTargetByName(String string2) {
        return this.mVectorState.mVPathRenderer.mVGTargetsMap.get(string2);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.inflate(resources, xmlPullParser, attributeSet);
            return;
        }
        this.inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int n10;
        Object object = this.mDelegateDrawable;
        if (object != null) {
            DrawableCompat.inflate(object, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        object = this.mVectorState;
        Object object2 = new VectorDrawableCompat$VPathRenderer();
        object.mVPathRenderer = object2;
        object2 = AndroidResources.STYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY;
        object2 = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, (int[])object2);
        this.updateStateFromTypedArray((TypedArray)object2, xmlPullParser, theme);
        object2.recycle();
        object.mChangingConfigurations = n10 = this.getChangingConfigurations();
        object.mCacheDirty = true;
        this.inflateInternal(resources, xmlPullParser, attributeSet, theme);
        resources = this.mTintFilter;
        xmlPullParser = object.mTint;
        attributeSet = object.mTintMode;
        resources = this.updateTintFilter((PorterDuffColorFilter)resources, (ColorStateList)xmlPullParser, (PorterDuff.Mode)attributeSet);
        this.mTintFilter = resources;
    }

    public void invalidateSelf() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.invalidateSelf();
            return;
        }
        super.invalidateSelf();
    }

    public boolean isAutoMirrored() {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return DrawableCompat.isAutoMirrored(drawable2);
        }
        return this.mVectorState.mAutoMirrored;
    }

    public boolean isStateful() {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            return object.isStateful();
        }
        boolean bl2 = super.isStateful();
        if (!(bl2 || (object = this.mVectorState) != null && ((bl2 = ((VectorDrawableCompat$VectorDrawableCompatState)((Object)object)).isStateful()) || (object = this.mVectorState.mTint) != null && (bl2 = object.isStateful())))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Drawable mutate() {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            object.mutate();
            return this;
        }
        boolean bl2 = this.mMutated;
        if (!bl2 && (object = super.mutate()) == this) {
            VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
            object = new VectorDrawableCompat$VectorDrawableCompatState(vectorDrawableCompat$VectorDrawableCompatState);
            this.mVectorState = object;
            this.mMutated = bl2 = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] nArray) {
        boolean bl2;
        boolean bl3;
        PorterDuff.Mode mode;
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setState(nArray);
        }
        boolean bl4 = false;
        float f10 = 0.0f;
        drawable2 = null;
        VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompat$VectorDrawableCompatState.mTint;
        boolean bl5 = true;
        float f11 = Float.MIN_VALUE;
        if (colorStateList != null && (mode = vectorDrawableCompat$VectorDrawableCompatState.mTintMode) != null) {
            drawable2 = this.mTintFilter;
            drawable2 = this.updateTintFilter((PorterDuffColorFilter)drawable2, colorStateList, mode);
            this.mTintFilter = drawable2;
            this.invalidateSelf();
            bl4 = bl5;
            f10 = f11;
        }
        if ((bl3 = vectorDrawableCompat$VectorDrawableCompatState.isStateful()) && (bl2 = vectorDrawableCompat$VectorDrawableCompatState.onStateChanged(nArray))) {
            this.invalidateSelf();
        } else {
            bl5 = bl4;
            f11 = f10;
        }
        return bl5;
    }

    public void scheduleSelf(Runnable runnable, long l10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.scheduleSelf(runnable, l10);
            return;
        }
        super.scheduleSelf(runnable, l10);
    }

    public void setAllowCaching(boolean bl2) {
        this.mAllowCaching = bl2;
    }

    public void setAlpha(int n10) {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            object.setAlpha(n10);
            return;
        }
        object = this.mVectorState.mVPathRenderer;
        int n11 = ((VectorDrawableCompat$VPathRenderer)object).getRootAlpha();
        if (n11 != n10) {
            object = this.mVectorState.mVPathRenderer;
            ((VectorDrawableCompat$VPathRenderer)object).setRootAlpha(n10);
            this.invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean bl2) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setAutoMirrored(drawable2, bl2);
            return;
        }
        this.mVectorState.mAutoMirrored = bl2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        this.invalidateSelf();
    }

    public void setTint(int n10) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            DrawableCompat.setTint(drawable2, n10);
            return;
        }
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setTintList(colorStateList);
    }

    public void setTintList(ColorStateList colorStateList) {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            DrawableCompat.setTintList(object, colorStateList);
            return;
        }
        object = this.mVectorState;
        ColorStateList colorStateList2 = object.mTint;
        if (colorStateList2 != colorStateList) {
            object.mTint = colorStateList;
            colorStateList2 = this.mTintFilter;
            object = object.mTintMode;
            colorStateList = this.updateTintFilter((PorterDuffColorFilter)colorStateList2, colorStateList, (PorterDuff.Mode)object);
            this.mTintFilter = colorStateList;
            this.invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Object object = this.mDelegateDrawable;
        if (object != null) {
            DrawableCompat.setTintMode(object, mode);
            return;
        }
        object = this.mVectorState;
        PorterDuff.Mode mode2 = object.mTintMode;
        if (mode2 != mode) {
            object.mTintMode = mode;
            mode2 = this.mTintFilter;
            object = object.mTint;
            mode = this.updateTintFilter((PorterDuffColorFilter)mode2, (ColorStateList)object, mode);
            this.mTintFilter = mode;
            this.invalidateSelf();
        }
    }

    public boolean setVisible(boolean bl2, boolean bl3) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            return drawable2.setVisible(bl2, bl3);
        }
        return super.setVisible(bl2, bl3);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable2 = this.mDelegateDrawable;
        if (drawable2 != null) {
            drawable2.unscheduleSelf(runnable);
            return;
        }
        super.unscheduleSelf(runnable);
    }

    public PorterDuffColorFilter updateTintFilter(PorterDuffColorFilter object, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            object = this.getState();
            int n10 = colorStateList.getColorForState((int[])object, 0);
            colorStateList = new PorterDuffColorFilter(n10, mode);
            return colorStateList;
        }
        return null;
    }
}

