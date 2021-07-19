/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.util.AttributeSet
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VClipPath;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VFullPath;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VObject;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPath;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class VectorDrawableCompat$VGroup
extends VectorDrawableCompat$VObject {
    public int mChangingConfigurations;
    public final ArrayList mChildren;
    private String mGroupName;
    public final Matrix mLocalMatrix;
    private float mPivotX;
    private float mPivotY;
    public float mRotate;
    private float mScaleX;
    private float mScaleY;
    public final Matrix mStackedMatrix;
    private int[] mThemeAttrs;
    private float mTranslateX;
    private float mTranslateY;

    public VectorDrawableCompat$VGroup() {
        super(null);
        float f10;
        Object object;
        this.mStackedMatrix = object = new Matrix();
        super();
        this.mChildren = object;
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        this.mScaleX = f10 = 1.0f;
        this.mScaleY = f10;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = object = new Matrix();
        this.mGroupName = null;
    }

    public VectorDrawableCompat$VGroup(VectorDrawableCompat$VGroup object, ArrayMap arrayMap) {
        int n10;
        Object object2;
        float f10;
        float f11;
        Object object3;
        int n11 = 0;
        super(null);
        this.mStackedMatrix = object3 = new Matrix();
        super();
        this.mChildren = object3;
        int n12 = 0;
        this.mRotate = 0.0f;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        this.mScaleX = f11 = 1.0f;
        this.mScaleY = f11;
        this.mTranslateX = 0.0f;
        this.mTranslateY = 0.0f;
        this.mLocalMatrix = object3 = new Matrix();
        this.mGroupName = null;
        this.mRotate = f10 = ((VectorDrawableCompat$VGroup)object).mRotate;
        this.mPivotX = f10 = ((VectorDrawableCompat$VGroup)object).mPivotX;
        this.mPivotY = f10 = ((VectorDrawableCompat$VGroup)object).mPivotY;
        this.mScaleX = f10 = ((VectorDrawableCompat$VGroup)object).mScaleX;
        this.mScaleY = f10 = ((VectorDrawableCompat$VGroup)object).mScaleY;
        this.mTranslateX = f10 = ((VectorDrawableCompat$VGroup)object).mTranslateX;
        this.mTranslateY = f10 = ((VectorDrawableCompat$VGroup)object).mTranslateY;
        this.mThemeAttrs = object2 = ((VectorDrawableCompat$VGroup)object).mThemeAttrs;
        object2 = ((VectorDrawableCompat$VGroup)object).mGroupName;
        this.mGroupName = object2;
        this.mChangingConfigurations = n10 = ((VectorDrawableCompat$VGroup)object).mChangingConfigurations;
        if (object2 != null) {
            arrayMap.put(object2, this);
        }
        object2 = ((VectorDrawableCompat$VGroup)object).mLocalMatrix;
        object3.set((Matrix)object2);
        object = ((VectorDrawableCompat$VGroup)object).mChildren;
        f10 = 0.0f;
        object2 = null;
        for (n11 = 0; n11 < (n12 = ((ArrayList)object).size()); ++n11) {
            block8: {
                Object object4;
                block7: {
                    block6: {
                        object3 = ((ArrayList)object).get(n11);
                        n10 = object3 instanceof VectorDrawableCompat$VGroup;
                        if (n10 != 0) {
                            object3 = (VectorDrawableCompat$VGroup)object3;
                            object4 = this.mChildren;
                            VectorDrawableCompat$VGroup vectorDrawableCompat$VGroup = new VectorDrawableCompat$VGroup((VectorDrawableCompat$VGroup)object3, arrayMap);
                            ((ArrayList)object4).add(vectorDrawableCompat$VGroup);
                            continue;
                        }
                        n10 = object3 instanceof VectorDrawableCompat$VFullPath;
                        if (n10 == 0) break block6;
                        object3 = (VectorDrawableCompat$VFullPath)object3;
                        object4 = new VectorDrawableCompat$VFullPath((VectorDrawableCompat$VFullPath)object3);
                        break block7;
                    }
                    n10 = object3 instanceof VectorDrawableCompat$VClipPath;
                    if (n10 == 0) break block8;
                    object3 = (VectorDrawableCompat$VClipPath)object3;
                    object4 = new VectorDrawableCompat$VClipPath((VectorDrawableCompat$VClipPath)object3);
                }
                this.mChildren.add(object4);
                object3 = ((VectorDrawableCompat$VPath)object4).mPathName;
                if (object3 == null) continue;
                arrayMap.put(object3, object4);
                continue;
            }
            object = new IllegalStateException("Unknown object in the tree!");
            throw object;
        }
    }

    private void updateLocalMatrix() {
        this.mLocalMatrix.reset();
        Matrix matrix = this.mLocalMatrix;
        float f10 = -this.mPivotX;
        float f11 = -this.mPivotY;
        matrix.postTranslate(f10, f11);
        matrix = this.mLocalMatrix;
        f10 = this.mScaleX;
        f11 = this.mScaleY;
        matrix.postScale(f10, f11);
        matrix = this.mLocalMatrix;
        f10 = this.mRotate;
        matrix.postRotate(f10, 0.0f, 0.0f);
        matrix = this.mLocalMatrix;
        f10 = this.mTranslateX;
        f11 = this.mPivotX;
        f10 += f11;
        f11 = this.mTranslateY;
        float f12 = this.mPivotY;
        matrix.postTranslate(f10, f11 += f12);
    }

    private void updateStateFromTypedArray(TypedArray object, XmlPullParser xmlPullParser) {
        float f10;
        this.mThemeAttrs = null;
        float f11 = this.mRotate;
        this.mRotate = f11 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, "rotation", 5, f11);
        f11 = this.mPivotX;
        this.mPivotX = f11 = object.getFloat(1, f11);
        f11 = this.mPivotY;
        int n10 = 2;
        this.mPivotY = f11 = object.getFloat(n10, f11);
        f11 = this.mScaleX;
        this.mScaleX = f11 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, "scaleX", 3, f11);
        f11 = this.mScaleY;
        this.mScaleY = f11 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, "scaleY", 4, f11);
        f11 = this.mTranslateX;
        this.mTranslateX = f11 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, "translateX", 6, f11);
        f11 = this.mTranslateY;
        String string2 = "translateY";
        int n11 = 7;
        this.mTranslateY = f10 = TypedArrayUtils.getNamedFloat(object, xmlPullParser, string2, n11, f11);
        f10 = 0.0f;
        xmlPullParser = null;
        if ((object = object.getString(0)) != null) {
            this.mGroupName = object;
        }
        this.updateLocalMatrix();
    }

    public String getGroupName() {
        return this.mGroupName;
    }

    public Matrix getLocalMatrix() {
        return this.mLocalMatrix;
    }

    public float getPivotX() {
        return this.mPivotX;
    }

    public float getPivotY() {
        return this.mPivotY;
    }

    public float getRotation() {
        return this.mRotate;
    }

    public float getScaleX() {
        return this.mScaleX;
    }

    public float getScaleY() {
        return this.mScaleY;
    }

    public float getTranslateX() {
        return this.mTranslateX;
    }

    public float getTranslateY() {
        return this.mTranslateY;
    }

    public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        int[] nArray = AndroidResources.STYLEABLE_VECTOR_DRAWABLE_GROUP;
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, nArray);
        this.updateStateFromTypedArray((TypedArray)resources, xmlPullParser);
        resources.recycle();
    }

    public boolean isStateful() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mChildren)).size()); ++i10) {
            object = (VectorDrawableCompat$VObject)this.mChildren.get(i10);
            n10 = (int)(((VectorDrawableCompat$VObject)object).isStateful() ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public boolean onStateChanged(int[] nArray) {
        Object object;
        int n10;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = ((ArrayList)(object = this.mChildren)).size()); ++i10) {
            object = (VectorDrawableCompat$VObject)this.mChildren.get(i10);
            n10 = (int)(((VectorDrawableCompat$VObject)object).onStateChanged(nArray) ? 1 : 0);
            n11 |= n10;
        }
        return n11 != 0;
    }

    public void setPivotX(float f10) {
        float f11 = this.mPivotX;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mPivotX = f10;
            this.updateLocalMatrix();
        }
    }

    public void setPivotY(float f10) {
        float f11 = this.mPivotY;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mPivotY = f10;
            this.updateLocalMatrix();
        }
    }

    public void setRotation(float f10) {
        float f11 = this.mRotate;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mRotate = f10;
            this.updateLocalMatrix();
        }
    }

    public void setScaleX(float f10) {
        float f11 = this.mScaleX;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mScaleX = f10;
            this.updateLocalMatrix();
        }
    }

    public void setScaleY(float f10) {
        float f11 = this.mScaleY;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mScaleY = f10;
            this.updateLocalMatrix();
        }
    }

    public void setTranslateX(float f10) {
        float f11 = this.mTranslateX;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mTranslateX = f10;
            this.updateLocalMatrix();
        }
    }

    public void setTranslateY(float f10) {
        float f11 = this.mTranslateY;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.mTranslateY = f10;
            this.updateLocalMatrix();
        }
    }
}

