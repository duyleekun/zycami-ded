/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.SparseIntArray
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R$styleable;

public class ConstraintSet$Transform {
    private static final int ELEVATION = 11;
    private static final int ROTATION = 1;
    private static final int ROTATION_X = 2;
    private static final int ROTATION_Y = 3;
    private static final int SCALE_X = 4;
    private static final int SCALE_Y = 5;
    private static final int TRANSFORM_PIVOT_X = 6;
    private static final int TRANSFORM_PIVOT_Y = 7;
    private static final int TRANSLATION_X = 8;
    private static final int TRANSLATION_Y = 9;
    private static final int TRANSLATION_Z = 10;
    private static SparseIntArray mapToConstant;
    public boolean applyElevation;
    public float elevation;
    public boolean mApply = false;
    public float rotation = 0.0f;
    public float rotationX = 0.0f;
    public float rotationY = 0.0f;
    public float scaleX;
    public float scaleY;
    public float transformPivotX;
    public float transformPivotY;
    public float translationX;
    public float translationY;
    public float translationZ;

    static {
        SparseIntArray sparseIntArray;
        mapToConstant = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.Transform_android_rotation;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_rotationX;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_rotationY;
        sparseIntArray.append(n10, 3);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_scaleX;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_scaleY;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_transformPivotX;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_transformPivotY;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_translationX;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_translationY;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_translationZ;
        sparseIntArray.append(n10, 10);
        sparseIntArray = mapToConstant;
        n10 = R$styleable.Transform_android_elevation;
        sparseIntArray.append(n10, 11);
    }

    public ConstraintSet$Transform() {
        float f10;
        this.scaleX = f10 = 1.0f;
        this.scaleY = f10;
        this.transformPivotX = f10 = 0.0f / 0.0f;
        this.transformPivotY = f10;
        this.translationX = 0.0f;
        this.translationY = 0.0f;
        this.translationZ = 0.0f;
        this.applyElevation = false;
        this.elevation = 0.0f;
    }

    public void copyFrom(ConstraintSet$Transform constraintSet$Transform) {
        float f10;
        float f11;
        boolean bl2;
        this.mApply = bl2 = constraintSet$Transform.mApply;
        this.rotation = f11 = constraintSet$Transform.rotation;
        this.rotationX = f11 = constraintSet$Transform.rotationX;
        this.rotationY = f11 = constraintSet$Transform.rotationY;
        this.scaleX = f11 = constraintSet$Transform.scaleX;
        this.scaleY = f11 = constraintSet$Transform.scaleY;
        this.transformPivotX = f11 = constraintSet$Transform.transformPivotX;
        this.transformPivotY = f11 = constraintSet$Transform.transformPivotY;
        this.translationX = f11 = constraintSet$Transform.translationX;
        this.translationY = f11 = constraintSet$Transform.translationY;
        this.translationZ = f11 = constraintSet$Transform.translationZ;
        this.applyElevation = bl2 = constraintSet$Transform.applyElevation;
        this.elevation = f10 = constraintSet$Transform.elevation;
    }

    public void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int[] nArray = R$styleable.Transform;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.mApply = bl2 = true;
        int n11 = context.getIndexCount();
        block13: for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = context.getIndex(i10);
            SparseIntArray sparseIntArray = mapToConstant;
            int n13 = sparseIntArray.get(n12);
            int n14 = 21;
            switch (n13) {
                default: {
                    continue block13;
                }
                case 11: {
                    float f10;
                    if (n10 < n14) continue block13;
                    this.applyElevation = bl2;
                    float f11 = this.elevation;
                    this.elevation = f10 = context.getDimension(n12, f11);
                    continue block13;
                }
                case 10: {
                    float f10;
                    if (n10 < n14) continue block13;
                    float f11 = this.translationZ;
                    this.translationZ = f10 = context.getDimension(n12, f11);
                    continue block13;
                }
                case 9: {
                    float f10;
                    float f11 = this.translationY;
                    this.translationY = f10 = context.getDimension(n12, f11);
                    continue block13;
                }
                case 8: {
                    float f10;
                    float f11 = this.translationX;
                    this.translationX = f10 = context.getDimension(n12, f11);
                    continue block13;
                }
                case 7: {
                    float f10;
                    float f11 = this.transformPivotY;
                    this.transformPivotY = f10 = context.getDimension(n12, f11);
                    continue block13;
                }
                case 6: {
                    float f10;
                    float f11 = this.transformPivotX;
                    this.transformPivotX = f10 = context.getDimension(n12, f11);
                    continue block13;
                }
                case 5: {
                    float f10;
                    float f11 = this.scaleY;
                    this.scaleY = f10 = context.getFloat(n12, f11);
                    continue block13;
                }
                case 4: {
                    float f10;
                    float f11 = this.scaleX;
                    this.scaleX = f10 = context.getFloat(n12, f11);
                    continue block13;
                }
                case 3: {
                    float f10;
                    float f11 = this.rotationY;
                    this.rotationY = f10 = context.getFloat(n12, f11);
                    continue block13;
                }
                case 2: {
                    float f10;
                    float f11 = this.rotationX;
                    this.rotationX = f10 = context.getFloat(n12, f11);
                    continue block13;
                }
                case 1: {
                    float f10;
                    float f11 = this.rotation;
                    this.rotation = f10 = context.getFloat(n12, f11);
                }
            }
        }
        context.recycle();
    }
}

