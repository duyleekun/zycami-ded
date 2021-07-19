/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.ChangeBounds$1;
import androidx.transition.ChangeBounds$10;
import androidx.transition.ChangeBounds$2;
import androidx.transition.ChangeBounds$3;
import androidx.transition.ChangeBounds$4;
import androidx.transition.ChangeBounds$5;
import androidx.transition.ChangeBounds$6;
import androidx.transition.ChangeBounds$7;
import androidx.transition.ChangeBounds$8;
import androidx.transition.ChangeBounds$9;
import androidx.transition.ChangeBounds$ViewBounds;
import androidx.transition.ObjectAnimatorUtils;
import androidx.transition.PathMotion;
import androidx.transition.PropertyValuesHolderUtils;
import androidx.transition.RectEvaluator;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class ChangeBounds
extends Transition {
    private static final Property BOTTOM_RIGHT_ONLY_PROPERTY;
    private static final Property BOTTOM_RIGHT_PROPERTY;
    private static final Property DRAWABLE_ORIGIN_PROPERTY;
    private static final Property POSITION_PROPERTY;
    private static final String PROPNAME_BOUNDS = "android:changeBounds:bounds";
    private static final String PROPNAME_CLIP = "android:changeBounds:clip";
    private static final String PROPNAME_PARENT = "android:changeBounds:parent";
    private static final String PROPNAME_WINDOW_X = "android:changeBounds:windowX";
    private static final String PROPNAME_WINDOW_Y = "android:changeBounds:windowY";
    private static final Property TOP_LEFT_ONLY_PROPERTY;
    private static final Property TOP_LEFT_PROPERTY;
    private static RectEvaluator sRectEvaluator;
    private static final String[] sTransitionProperties;
    private boolean mReparent;
    private boolean mResizeClip;
    private int[] mTempLocation;

    static {
        Object object;
        sTransitionProperties = new String[]{PROPNAME_BOUNDS, PROPNAME_CLIP, PROPNAME_PARENT, PROPNAME_WINDOW_X, PROPNAME_WINDOW_Y};
        DRAWABLE_ORIGIN_PROPERTY = object = new ChangeBounds$1(PointF.class, "boundsOrigin");
        String string2 = "topLeft";
        TOP_LEFT_PROPERTY = object = new ChangeBounds$2(PointF.class, string2);
        String string3 = "bottomRight";
        BOTTOM_RIGHT_PROPERTY = object = new ChangeBounds$3(PointF.class, string3);
        BOTTOM_RIGHT_ONLY_PROPERTY = object = new ChangeBounds$4(PointF.class, string3);
        TOP_LEFT_ONLY_PROPERTY = object = new ChangeBounds$5(PointF.class, string2);
        POSITION_PROPERTY = object = new ChangeBounds$6(PointF.class, "position");
        object = new RectEvaluator();
        sRectEvaluator = object;
    }

    public ChangeBounds() {
        int[] nArray = new int[2];
        this.mTempLocation = nArray;
        this.mResizeClip = false;
        this.mReparent = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = new int[2];
        this.mTempLocation = nArray;
        this.mResizeClip = false;
        this.mReparent = false;
        int[] nArray2 = Styleable.CHANGE_BOUNDS;
        context = context.obtainStyledAttributes(attributeSet, nArray2);
        attributeSet = (XmlResourceParser)attributeSet;
        boolean bl2 = TypedArrayUtils.getNamedBoolean((TypedArray)context, (XmlPullParser)attributeSet, "resizeClip", 0, false);
        context.recycle();
        this.setResizeClip(bl2);
    }

    private void captureValues(TransitionValues object) {
        View view = ((TransitionValues)object).view;
        int n10 = ViewCompat.isLaidOut(view);
        if (n10 != 0 || (n10 = view.getWidth()) != 0 || (n10 = view.getHeight()) != 0) {
            Object object2 = ((TransitionValues)object).values;
            int n11 = view.getLeft();
            int n12 = view.getTop();
            int n13 = view.getRight();
            int n14 = view.getBottom();
            Object object3 = new Rect(n11, n12, n13, n14);
            object2.put(PROPNAME_BOUNDS, object3);
            object2 = ((TransitionValues)object).values;
            object3 = ((TransitionValues)object).view.getParent();
            String string2 = PROPNAME_PARENT;
            object2.put(string2, object3);
            n10 = (int)(this.mReparent ? 1 : 0);
            if (n10 != 0) {
                object2 = ((TransitionValues)object).view;
                object3 = this.mTempLocation;
                object2.getLocationInWindow((int[])object3);
                object2 = ((TransitionValues)object).values;
                object3 = this.mTempLocation[0];
                object2.put(PROPNAME_WINDOW_X, object3);
                object2 = ((TransitionValues)object).values;
                object3 = this.mTempLocation;
                n11 = 1;
                Rect rect = object3[n11];
                object3 = (int)rect;
                string2 = PROPNAME_WINDOW_Y;
                object2.put(string2, object3);
            }
            if ((n10 = (int)(this.mResizeClip ? 1 : 0)) != 0) {
                object = ((TransitionValues)object).values;
                view = ViewCompat.getClipBounds(view);
                object2 = PROPNAME_CLIP;
                object.put(object2, view);
            }
        }
    }

    private boolean parentMatches(View view, View view2) {
        boolean bl2;
        block0: {
            TransitionValues transitionValues;
            boolean bl3 = this.mReparent;
            bl2 = true;
            if (!bl3 || ((transitionValues = this.getMatchedTransitionValues(view, bl2)) == null ? view == view2 : view2 == (view = transitionValues.view))) break block0;
            bl2 = false;
        }
        return bl2;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues object, TransitionValues transitionValues) {
        block26: {
            block27: {
                ChangeBounds$10 changeBounds$10;
                int n10;
                int n11;
                int n12;
                Object object2;
                int n13;
                Object object3;
                Object object4;
                Object object5;
                Object object6;
                Object object7;
                Object object8;
                ChangeBounds changeBounds;
                block30: {
                    block29: {
                        block28: {
                            boolean bl2;
                            float f10;
                            int n14;
                            changeBounds = this;
                            object8 = object;
                            object7 = transitionValues;
                            if (object == null || transitionValues == null) break block26;
                            object6 = ((TransitionValues)object).values;
                            object5 = transitionValues.values;
                            object4 = PROPNAME_PARENT;
                            object6 = (ViewGroup)object6.get(object4);
                            object5 = (ViewGroup)object5.get(object4);
                            if (object6 == null || object5 == null) break block27;
                            object3 = transitionValues.view;
                            n13 = this.parentMatches((View)object6, (View)object5);
                            if (n13 == 0) break block28;
                            object6 = ((TransitionValues)object).values;
                            object4 = PROPNAME_BOUNDS;
                            object6 = (Rect)object6.get(object4);
                            Map map = transitionValues.values;
                            object4 = (Rect)map.get(object4);
                            int n15 = ((Rect)object6).left;
                            int n16 = ((Rect)object4).left;
                            int n17 = ((Rect)object6).top;
                            int n18 = ((Rect)object4).top;
                            int n19 = ((Rect)object6).right;
                            int n20 = ((Rect)object4).right;
                            n13 = ((Rect)object6).bottom;
                            int n21 = ((Rect)object4).bottom;
                            int n22 = n19 - n15;
                            int n23 = n13 - n17;
                            int n24 = n20 - n16;
                            int n25 = n21 - n18;
                            object8 = ((TransitionValues)object).values;
                            View view = object3;
                            object3 = PROPNAME_CLIP;
                            object8 = (Rect)object8.get(object3);
                            object7 = transitionValues.values.get(object3);
                            object3 = object7;
                            object3 = (Rect)object7;
                            if (n22 != 0 && n23 != 0 || n24 != 0 && n25 != 0) {
                                if (n15 == n16 && n17 == n18) {
                                    n14 = 0;
                                    f10 = 0.0f;
                                    object7 = null;
                                } else {
                                    n14 = 1;
                                    f10 = Float.MIN_VALUE;
                                }
                                if (n19 != n20 || n13 != n21) {
                                    ++n14;
                                }
                            } else {
                                n14 = 0;
                                f10 = 0.0f;
                                object7 = null;
                            }
                            if (object8 != null && !(bl2 = object8.equals(object3)) || object8 == null && object3 != null) {
                                ++n14;
                            }
                            if (n14 > 0) {
                                Object object9;
                                float f11;
                                viewGroup = object3;
                                boolean bl3 = changeBounds.mResizeClip;
                                object = object8;
                                int n26 = 2;
                                float f12 = 2.8E-45f;
                                if (!bl3) {
                                    object3 = view;
                                    ViewUtils.setLeftTopRightBottom(view, n15, n17, n19, n13);
                                    if (n14 == n26) {
                                        if (n22 == n24 && n23 == n25) {
                                            object8 = this.getPathMotion();
                                            f10 = n15;
                                            f11 = n17;
                                            float f13 = n16;
                                            float f14 = n18;
                                            object8 = object8.getPath(f10, f11, f13, f14);
                                            object7 = POSITION_PROPERTY;
                                            object8 = ObjectAnimatorUtils.ofPointF(view, (Property)object7, (Path)object8);
                                        } else {
                                            object7 = new ChangeBounds$ViewBounds((View)object3);
                                            object9 = this.getPathMotion();
                                            float f15 = n15;
                                            float f16 = n17;
                                            float f17 = n16;
                                            float f18 = n18;
                                            object9 = ((PathMotion)object9).getPath(f15, f16, f17, f18);
                                            object5 = TOP_LEFT_PROPERTY;
                                            object9 = ObjectAnimatorUtils.ofPointF(object7, (Property)object5, (Path)object9);
                                            object5 = this.getPathMotion();
                                            f16 = n19;
                                            float f19 = n13;
                                            f17 = n20;
                                            f18 = n21;
                                            object6 = ((PathMotion)object5).getPath(f16, f19, f17, f18);
                                            object5 = BOTTOM_RIGHT_PROPERTY;
                                            object6 = ObjectAnimatorUtils.ofPointF(object7, (Property)object5, (Path)object6);
                                            object5 = new AnimatorSet();
                                            object8 = new Animator[n26];
                                            n22 = 0;
                                            f16 = 0.0f;
                                            object4 = null;
                                            object8[0] = object9;
                                            n23 = 1;
                                            f11 = Float.MIN_VALUE;
                                            object8[n23] = object6;
                                            object5.playTogether(object8);
                                            object8 = new ChangeBounds$7(changeBounds, (ChangeBounds$ViewBounds)object7);
                                            object5.addListener((Animator.AnimatorListener)object8);
                                            object8 = object5;
                                        }
                                    } else if (n15 == n16 && n17 == n18) {
                                        object8 = this.getPathMotion();
                                        f10 = n19;
                                        f11 = n13;
                                        float f20 = n20;
                                        float f21 = n21;
                                        object8 = object8.getPath(f10, f11, f20, f21);
                                        object7 = BOTTOM_RIGHT_ONLY_PROPERTY;
                                        object8 = ObjectAnimatorUtils.ofPointF(view, (Property)object7, (Path)object8);
                                    } else {
                                        object8 = this.getPathMotion();
                                        f10 = n15;
                                        f11 = n17;
                                        float f22 = n16;
                                        float f23 = n18;
                                        object8 = object8.getPath(f10, f11, f22, f23);
                                        object7 = TOP_LEFT_ONLY_PROPERTY;
                                        object8 = ObjectAnimatorUtils.ofPointF(object3, (Property)object7, (Path)object8);
                                    }
                                } else {
                                    float f24;
                                    Object object10;
                                    object3 = view;
                                    n14 = Math.max(n22, n24);
                                    n13 = Math.max(n23, n25);
                                    ViewUtils.setLeftTopRightBottom(view, n15, n17, n14 += n15, n13 += n17);
                                    if (n15 == n16 && n17 == n18) {
                                        n17 = 0;
                                        float f25 = 0.0f;
                                        object10 = null;
                                    } else {
                                        object7 = this.getPathMotion();
                                        f24 = n15;
                                        float f26 = n17;
                                        float f27 = n16;
                                        float f28 = n18;
                                        object7 = object7.getPath(f24, f26, f27, f28);
                                        object6 = POSITION_PROPERTY;
                                        object10 = object7 = ObjectAnimatorUtils.ofPointF(object3, (Property)object6, (Path)object7);
                                    }
                                    if (object == null) {
                                        n13 = 0;
                                        f24 = 0.0f;
                                        object6 = null;
                                        object7 = new Rect(0, 0, n22, n23);
                                    } else {
                                        n13 = 0;
                                        f24 = 0.0f;
                                        object6 = null;
                                        object7 = object;
                                    }
                                    object9 = viewGroup == null ? new Rect(0, 0, n24, n25) : viewGroup;
                                    n25 = (int)(object7.equals(object9) ? 1 : 0);
                                    if (n25 == 0) {
                                        ChangeBounds$8 changeBounds$8;
                                        ViewCompat.setClipBounds(object3, (Rect)object7);
                                        object5 = sRectEvaluator;
                                        object8 = new Object[n26];
                                        object8[0] = object7;
                                        n14 = 1;
                                        f10 = Float.MIN_VALUE;
                                        object8[n14] = object9;
                                        ObjectAnimator objectAnimator = ObjectAnimator.ofObject((Object)object3, (String)"clipBounds", (TypeEvaluator)object5, (Object[])object8);
                                        object8 = changeBounds$8;
                                        object7 = this;
                                        object9 = object3;
                                        object6 = viewGroup;
                                        n25 = n16;
                                        n22 = n18;
                                        n15 = n20;
                                        n16 = n21;
                                        changeBounds$8 = new ChangeBounds$8(this, (View)object3, (Rect)viewGroup, n25, n18, n20, n21);
                                        objectAnimator.addListener((Animator.AnimatorListener)changeBounds$8);
                                        object9 = objectAnimator;
                                    } else {
                                        n23 = 0;
                                        f11 = 0.0f;
                                        object9 = null;
                                    }
                                    object8 = TransitionUtils.mergeAnimators((Animator)object10, (Animator)object9);
                                }
                                object7 = object3.getParent();
                                n14 = object7 instanceof ViewGroup;
                                if (n14 != 0) {
                                    object7 = (ViewGroup)object3.getParent();
                                    n23 = 1;
                                    f11 = Float.MIN_VALUE;
                                    ViewGroupUtils.suppressLayout((ViewGroup)object7, n23 != 0);
                                    object9 = new ChangeBounds$9(changeBounds, (ViewGroup)object7);
                                    changeBounds.addListener((Transition$TransitionListener)object9);
                                }
                                return object8;
                            }
                            break block29;
                        }
                        object2 = ((TransitionValues)object).values;
                        object6 = PROPNAME_WINDOW_X;
                        object2 = (Integer)object2.get(object6);
                        n12 = (Integer)object2;
                        object8 = ((TransitionValues)object).values;
                        object5 = PROPNAME_WINDOW_Y;
                        object8 = (Integer)object8.get(object5);
                        n11 = object8.intValue();
                        object4 = transitionValues.values;
                        object6 = (Integer)object4.get(object6);
                        n13 = (Integer)object6;
                        object7 = (Integer)transitionValues.values.get(object5);
                        n10 = object7.intValue();
                        if (n12 != n13 || n11 != n10) break block30;
                    }
                    return null;
                }
                object5 = changeBounds.mTempLocation;
                object4 = viewGroup;
                viewGroup.getLocationInWindow((int[])object5);
                int n27 = object3.getWidth();
                int n28 = object3.getHeight();
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                object5 = Bitmap.createBitmap((int)n27, (int)n28, (Bitmap.Config)config);
                Canvas canvas = new Canvas((Bitmap)object5);
                object3.draw(canvas);
                canvas = new BitmapDrawable((Bitmap)object5);
                float f29 = ViewUtils.getTransitionAlpha(object3);
                ViewUtils.setTransitionAlpha(object3, 0.0f);
                ViewUtils.getOverlay((View)viewGroup).add((Drawable)canvas);
                object5 = this.getPathMotion();
                Object object11 = changeBounds.mTempLocation;
                int n29 = object11[0];
                float f30 = n12 - n29;
                n29 = 1;
                int n30 = object11[n29];
                float f31 = n11 - n30;
                n30 = object11[0];
                float f32 = n13 - n30;
                int n31 = object11[n29];
                float f33 = n10 - n31;
                object8 = ((PathMotion)object5).getPath(f30, f31, f32, f33);
                object8 = PropertyValuesHolderUtils.ofPointF(DRAWABLE_ORIGIN_PROPERTY, (Path)object8);
                object7 = new PropertyValuesHolder[n29];
                object7[0] = object8;
                object11 = ObjectAnimator.ofPropertyValuesHolder((Object)canvas, (PropertyValuesHolder[])object7);
                object8 = changeBounds$10;
                object7 = this;
                object2 = viewGroup;
                object6 = canvas;
                object5 = object3;
                float f34 = f29;
                changeBounds$10 = new ChangeBounds$10(this, viewGroup, (BitmapDrawable)canvas, (View)object3, f29);
                object11.addListener((Animator.AnimatorListener)changeBounds$10);
                return object11;
            }
            return null;
        }
        return null;
    }

    public boolean getResizeClip() {
        return this.mResizeClip;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public void setResizeClip(boolean bl2) {
        this.mResizeClip = bl2;
    }
}

