/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Matrix
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.AnimatorUtils;
import androidx.transition.ChangeTransform$1;
import androidx.transition.ChangeTransform$2;
import androidx.transition.ChangeTransform$3;
import androidx.transition.ChangeTransform$GhostListener;
import androidx.transition.ChangeTransform$PathAnimatorMatrix;
import androidx.transition.ChangeTransform$Transforms;
import androidx.transition.FloatArrayEvaluator;
import androidx.transition.GhostView;
import androidx.transition.GhostViewUtils;
import androidx.transition.MatrixUtils;
import androidx.transition.PathMotion;
import androidx.transition.PropertyValuesHolderUtils;
import androidx.transition.R$id;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeTransform
extends Transition {
    private static final Property NON_TRANSLATIONS_PROPERTY;
    private static final String PROPNAME_INTERMEDIATE_MATRIX = "android:changeTransform:intermediateMatrix";
    private static final String PROPNAME_INTERMEDIATE_PARENT_MATRIX = "android:changeTransform:intermediateParentMatrix";
    private static final String PROPNAME_MATRIX = "android:changeTransform:matrix";
    private static final String PROPNAME_PARENT = "android:changeTransform:parent";
    private static final String PROPNAME_PARENT_MATRIX = "android:changeTransform:parentMatrix";
    private static final String PROPNAME_TRANSFORMS = "android:changeTransform:transforms";
    private static final boolean SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
    private static final Property TRANSLATIONS_PROPERTY;
    private static final String[] sTransitionProperties;
    private boolean mReparent;
    private Matrix mTempMatrix;
    public boolean mUseOverlay;

    static {
        Property property;
        sTransitionProperties = new String[]{PROPNAME_MATRIX, PROPNAME_TRANSFORMS, PROPNAME_PARENT_MATRIX};
        NON_TRANSLATIONS_PROPERTY = property = new ChangeTransform$1(float[].class, "nonTranslations");
        Class<PointF> clazz = PointF.class;
        String string2 = "translations";
        TRANSLATIONS_PROPERTY = property = new ChangeTransform$2(clazz, string2);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            property = null;
        }
        SUPPORTS_VIEW_REMOVAL_SUPPRESSION = n10;
    }

    public ChangeTransform() {
        Matrix matrix;
        boolean bl2;
        this.mUseOverlay = bl2 = true;
        this.mReparent = bl2;
        this.mTempMatrix = matrix = new Matrix();
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean bl2;
        boolean bl3;
        Object object;
        boolean bl4;
        this.mUseOverlay = bl4 = true;
        this.mReparent = bl4;
        this.mTempMatrix = object = new Matrix();
        object = Styleable.CHANGE_TRANSFORM;
        context = context.obtainStyledAttributes(attributeSet, (int[])object);
        attributeSet = (XmlPullParser)attributeSet;
        this.mUseOverlay = bl3 = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)attributeSet, "reparentWithOverlay", (int)(bl4 ? 1 : 0), bl4);
        this.mReparent = bl2 = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)attributeSet, "reparent", 0, bl4);
        context.recycle();
    }

    private void captureValues(TransitionValues object) {
        Object object2 = ((TransitionValues)object).view;
        int n10 = object2.getVisibility();
        int n11 = 8;
        float f10 = 1.1E-44f;
        if (n10 == n11) {
            return;
        }
        Object object3 = ((TransitionValues)object).values;
        Object object4 = object2.getParent();
        object3.put(PROPNAME_PARENT, object4);
        object3 = new ChangeTransform$Transforms((View)object2);
        object4 = ((TransitionValues)object).values;
        String string2 = PROPNAME_TRANSFORMS;
        object4.put(string2, object3);
        object3 = object2.getMatrix();
        if (object3 != null && (n11 = (int)(object3.isIdentity() ? 1 : 0)) == 0) {
            object4 = new Matrix((Matrix)object3);
        } else {
            n11 = 0;
            f10 = 0.0f;
            object4 = null;
        }
        object3 = ((TransitionValues)object).values;
        string2 = PROPNAME_MATRIX;
        object3.put(string2, object4);
        n10 = (int)(this.mReparent ? 1 : 0);
        if (n10 != 0) {
            object3 = new Matrix();
            object4 = (ViewGroup)object2.getParent();
            ViewUtils.transformMatrixToGlobal((View)object4, (Matrix)object3);
            int n12 = -object4.getScrollX();
            float f11 = n12;
            f10 = -object4.getScrollY();
            object3.preTranslate(f11, f10);
            ((TransitionValues)object).values.put(PROPNAME_PARENT_MATRIX, object3);
            object3 = ((TransitionValues)object).values;
            n11 = R$id.transition_transform;
            object4 = object2.getTag(n11);
            string2 = PROPNAME_INTERMEDIATE_MATRIX;
            object3.put(string2, object4);
            object = ((TransitionValues)object).values;
            n10 = R$id.parent_matrix;
            object2 = object2.getTag(n10);
            object3 = PROPNAME_INTERMEDIATE_PARENT_MATRIX;
            object.put(object3, object2);
        }
    }

    private void createGhostView(ViewGroup object, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = transitionValues2.view;
        Object object2 = (Matrix)transitionValues2.values.get(PROPNAME_PARENT_MATRIX);
        Object object3 = new Matrix((Matrix)object2);
        ViewUtils.transformMatrixToLocal((View)object, object3);
        object = GhostViewUtils.addGhost(view, (ViewGroup)object, object3);
        if (object == null) {
            return;
        }
        object2 = (ViewGroup)transitionValues.values.get(PROPNAME_PARENT);
        object3 = transitionValues.view;
        object.reserveEndViewTransition((ViewGroup)object2, (View)object3);
        object2 = this;
        while ((object3 = ((Transition)object2).mParent) != null) {
            object2 = object3;
        }
        object3 = new ChangeTransform$GhostListener(view, (GhostView)object);
        ((Transition)object2).addListener((Transition$TransitionListener)object3);
        int n10 = SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
        if (n10 != 0) {
            object = transitionValues.view;
            transitionValues = transitionValues2.view;
            if (object != transitionValues) {
                transitionValues = null;
                ViewUtils.setTransitionAlpha((View)object, 0.0f);
            }
            n10 = 1065353216;
            float f10 = 1.0f;
            ViewUtils.setTransitionAlpha(view, f10);
        }
    }

    private ObjectAnimator createTransformAnimator(TransitionValues object, TransitionValues object2, boolean bl2) {
        object = ((TransitionValues)object).values;
        Object object3 = PROPNAME_MATRIX;
        object = (Matrix)object.get(object3);
        Object object4 = object2.values;
        object3 = (Matrix)object4.get(object3);
        if (object == null) {
            object = MatrixUtils.IDENTITY_MATRIX;
        }
        if (object3 == null) {
            object3 = MatrixUtils.IDENTITY_MATRIX;
        }
        String string2 = object3;
        boolean bl3 = object.equals(object3);
        if (bl3) {
            return null;
        }
        Object object5 = object3 = object2.values.get(PROPNAME_TRANSFORMS);
        object5 = (ChangeTransform$Transforms)object3;
        View view = object2.view;
        ChangeTransform.setIdentityTransforms(view);
        int n10 = 9;
        object3 = new float[n10];
        object.getValues((float[])object3);
        object = new float[n10];
        string2.getValues((float[])object);
        ChangeTransform$PathAnimatorMatrix changeTransform$PathAnimatorMatrix = new ChangeTransform$PathAnimatorMatrix(view, (float[])object3);
        object4 = NON_TRANSLATIONS_PROPERTY;
        object2 = new float[n10];
        Object object6 = new FloatArrayEvaluator((float[])object2);
        n10 = 2;
        float[][] fArrayArray = new float[n10][];
        fArrayArray[0] = (float[])object3;
        int n11 = 1;
        fArrayArray[n11] = (float[])object;
        object4 = PropertyValuesHolder.ofObject((Property)object4, (TypeEvaluator)object6, (Object[])fArrayArray);
        object6 = this.getPathMotion();
        Object object7 = object3[n10];
        int n12 = 5;
        Object object8 = object3[n12];
        Object object9 = object[n10];
        Object object10 = object[n12];
        object = ((PathMotion)object6).getPath((float)object7, (float)object8, (float)object9, (float)object10);
        object = PropertyValuesHolderUtils.ofPointF(TRANSLATIONS_PROPERTY, (Path)object);
        object2 = new PropertyValuesHolder[n10];
        object2[0] = object4;
        object2[n11] = object;
        object = ObjectAnimator.ofPropertyValuesHolder((Object)changeTransform$PathAnimatorMatrix, (PropertyValuesHolder[])object2);
        object4 = object2;
        object6 = this;
        object2 = new ChangeTransform$3(this, bl2, (Matrix)string2, view, (ChangeTransform$Transforms)object5, changeTransform$PathAnimatorMatrix);
        object.addListener((Animator.AnimatorListener)object2);
        AnimatorUtils.addPauseListener((Animator)object, (AnimatorListenerAdapter)object2);
        return object;
    }

    private boolean parentsMatch(ViewGroup object, ViewGroup viewGroup) {
        boolean bl2;
        block3: {
            boolean bl3;
            block5: {
                block4: {
                    block2: {
                        boolean bl4 = this.isValidTarget((View)object);
                        bl3 = true;
                        bl2 = false;
                        if (!bl4 || !(bl4 = this.isValidTarget((View)viewGroup))) break block2;
                        if ((object = this.getMatchedTransitionValues((View)object, bl3)) == null) break block3;
                        object = object.view;
                        if (viewGroup != object) break block4;
                        break block5;
                    }
                    if (object == viewGroup) break block5;
                }
                bl3 = false;
            }
            bl2 = bl3;
        }
        return bl2;
    }

    public static void setIdentityTransforms(View view) {
        ChangeTransform.setTransforms(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    private void setMatricesForParent(TransitionValues transitionValues, TransitionValues transitionValues2) {
        Map map = transitionValues2.values;
        String string2 = PROPNAME_PARENT_MATRIX;
        map = (Matrix)map.get(string2);
        transitionValues2 = transitionValues2.view;
        int n10 = R$id.parent_matrix;
        transitionValues2.setTag(n10, map);
        transitionValues2 = this.mTempMatrix;
        transitionValues2.reset();
        map.invert((Matrix)transitionValues2);
        map = transitionValues.values;
        String string3 = PROPNAME_MATRIX;
        map = (Matrix)map.get(string3);
        if (map == null) {
            map = new Matrix();
            Map map2 = transitionValues.values;
            map2.put(string3, map);
        }
        transitionValues = (Matrix)transitionValues.values.get(string2);
        map.postConcat((Matrix)transitionValues);
        map.postConcat((Matrix)transitionValues2);
    }

    public static void setTransforms(View view, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        view.setTranslationX(f10);
        view.setTranslationY(f11);
        ViewCompat.setTranslationZ(view, f12);
        view.setScaleX(f13);
        view.setScaleY(f14);
        view.setRotationX(f15);
        view.setRotationY(f16);
        view.setRotation(f17);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
        boolean bl2 = SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
        if (!bl2) {
            ViewGroup viewGroup = (ViewGroup)transitionValues.view.getParent();
            transitionValues = transitionValues.view;
            viewGroup.startViewTransition((View)transitionValues);
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        String string2;
        Map map;
        boolean bl2;
        if (transitionValues != null && transitionValues2 != null && (bl2 = (map = transitionValues.values).containsKey(string2 = PROPNAME_PARENT)) && (bl2 = (map = transitionValues2.values).containsKey(string2))) {
            String string3;
            boolean bl3;
            map = (ViewGroup)transitionValues.values.get(string2);
            Map map2 = transitionValues2.values;
            string2 = (ViewGroup)map2.get(string2);
            boolean bl4 = this.mReparent;
            if (bl4 && !(bl3 = this.parentsMatch((ViewGroup)map, (ViewGroup)string2))) {
                bl3 = true;
            } else {
                bl3 = false;
                string2 = null;
            }
            map2 = transitionValues.values;
            Object object = PROPNAME_INTERMEDIATE_MATRIX;
            map2 = (Matrix)map2.get(object);
            if (map2 != null) {
                object = transitionValues.values;
                string3 = PROPNAME_MATRIX;
                object.put(string3, map2);
            }
            map2 = transitionValues.values;
            object = PROPNAME_INTERMEDIATE_PARENT_MATRIX;
            if ((map2 = (Matrix)map2.get(object)) != null) {
                object = transitionValues.values;
                string3 = PROPNAME_PARENT_MATRIX;
                object.put(string3, map2);
            }
            if (bl3) {
                this.setMatricesForParent(transitionValues, transitionValues2);
            }
            map2 = this.createTransformAnimator(transitionValues, transitionValues2, bl3);
            if (bl3 && map2 != null && (bl3 = this.mUseOverlay)) {
                this.createGhostView(viewGroup, transitionValues, transitionValues2);
            } else {
                boolean bl5 = SUPPORTS_VIEW_REMOVAL_SUPPRESSION;
                if (!bl5) {
                    viewGroup = transitionValues.view;
                    map.endViewTransition((View)viewGroup);
                }
            }
            return map2;
        }
        return null;
    }

    public boolean getReparent() {
        return this.mReparent;
    }

    public boolean getReparentWithOverlay() {
        return this.mUseOverlay;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setReparent(boolean bl2) {
        this.mReparent = bl2;
    }

    public void setReparentWithOverlay(boolean bl2) {
        this.mUseOverlay = bl2;
    }
}

