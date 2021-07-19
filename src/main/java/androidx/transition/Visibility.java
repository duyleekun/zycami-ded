/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.R$id;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;
import androidx.transition.ViewGroupUtils;
import androidx.transition.ViewUtils;
import androidx.transition.Visibility$1;
import androidx.transition.Visibility$DisappearListener;
import androidx.transition.Visibility$VisibilityInfo;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility
extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    public static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    private int mMode;

    public Visibility() {
        this.mMode = 3;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        this.mMode = n10 = 3;
        Object object = Styleable.VISIBILITY_TRANSITION;
        context = context.obtainStyledAttributes(attributeSet, object);
        attributeSet = (XmlResourceParser)attributeSet;
        object = "transitionVisibilityMode";
        int n11 = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)attributeSet, (String)object, 0, 0);
        context.recycle();
        if (n11 != 0) {
            this.setMode(n11);
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        int n10 = transitionValues.view.getVisibility();
        Map map = transitionValues.values;
        Object object = n10;
        map.put(PROPNAME_VISIBILITY, object);
        object = transitionValues.values;
        map = transitionValues.view.getParent();
        object.put(PROPNAME_PARENT, map);
        object = new int[2];
        transitionValues.view.getLocationOnScreen((int[])object);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, object);
    }

    private Visibility$VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        int n10;
        Map map;
        int n11;
        Visibility$VisibilityInfo visibility$VisibilityInfo = new Visibility$VisibilityInfo();
        visibility$VisibilityInfo.mVisibilityChange = false;
        visibility$VisibilityInfo.mFadeIn = false;
        String string2 = PROPNAME_PARENT;
        int n12 = 0;
        Map map2 = null;
        int n13 = -1;
        String string3 = PROPNAME_VISIBILITY;
        if (transitionValues != null && (n11 = (map = transitionValues.values).containsKey(string3)) != 0) {
            visibility$VisibilityInfo.mStartVisibility = n11 = ((Integer)transitionValues.values.get(string3)).intValue();
            map = (ViewGroup)transitionValues.values.get(string2);
            visibility$VisibilityInfo.mStartParent = map;
        } else {
            visibility$VisibilityInfo.mStartVisibility = n13;
            visibility$VisibilityInfo.mStartParent = null;
        }
        if (transitionValues2 != null && (n11 = (map = transitionValues2.values).containsKey(string3)) != 0) {
            visibility$VisibilityInfo.mEndVisibility = n12 = ((Integer)transitionValues2.values.get(string3)).intValue();
            map2 = transitionValues2.values;
            string2 = (ViewGroup)map2.get(string2);
            visibility$VisibilityInfo.mEndParent = string2;
        } else {
            visibility$VisibilityInfo.mEndVisibility = n13;
            visibility$VisibilityInfo.mEndParent = null;
        }
        boolean bl2 = true;
        if (transitionValues != null && transitionValues2 != null) {
            ViewGroup viewGroup;
            int n14 = visibility$VisibilityInfo.mStartVisibility;
            int n15 = visibility$VisibilityInfo.mEndVisibility;
            if (n14 == n15 && (map2 = visibility$VisibilityInfo.mStartParent) == (viewGroup = visibility$VisibilityInfo.mEndParent)) {
                return visibility$VisibilityInfo;
            }
            if (n14 != n15) {
                if (n14 == 0) {
                    visibility$VisibilityInfo.mFadeIn = false;
                    visibility$VisibilityInfo.mVisibilityChange = bl2;
                } else if (n15 == 0) {
                    visibility$VisibilityInfo.mFadeIn = bl2;
                    visibility$VisibilityInfo.mVisibilityChange = bl2;
                }
            } else {
                transitionValues = visibility$VisibilityInfo.mEndParent;
                if (transitionValues == null) {
                    visibility$VisibilityInfo.mFadeIn = false;
                    visibility$VisibilityInfo.mVisibilityChange = bl2;
                } else {
                    transitionValues = visibility$VisibilityInfo.mStartParent;
                    if (transitionValues == null) {
                        visibility$VisibilityInfo.mFadeIn = bl2;
                        visibility$VisibilityInfo.mVisibilityChange = bl2;
                    }
                }
            }
        } else if (transitionValues == null && (n10 = visibility$VisibilityInfo.mEndVisibility) == 0) {
            visibility$VisibilityInfo.mFadeIn = bl2;
            visibility$VisibilityInfo.mVisibilityChange = bl2;
        } else if (transitionValues2 == null && (n10 = visibility$VisibilityInfo.mStartVisibility) == 0) {
            visibility$VisibilityInfo.mFadeIn = false;
            visibility$VisibilityInfo.mVisibilityChange = bl2;
        }
        return visibility$VisibilityInfo;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewGroup viewGroup2;
        Object object = this.getVisibilityChangeInfo(transitionValues, transitionValues2);
        boolean bl2 = ((Visibility$VisibilityInfo)object).mVisibilityChange;
        if (bl2 && ((viewGroup2 = ((Visibility$VisibilityInfo)object).mStartParent) != null || (viewGroup2 = ((Visibility$VisibilityInfo)object).mEndParent) != null)) {
            bl2 = ((Visibility$VisibilityInfo)object).mFadeIn;
            if (bl2) {
                int n10 = ((Visibility$VisibilityInfo)object).mStartVisibility;
                int n11 = ((Visibility$VisibilityInfo)object).mEndVisibility;
                return this.onAppear(viewGroup, transitionValues, n10, transitionValues2, n11);
            }
            int n12 = ((Visibility$VisibilityInfo)object).mStartVisibility;
            int n13 = ((Visibility$VisibilityInfo)object).mEndVisibility;
            object = this;
            viewGroup2 = viewGroup;
            return this.onDisappear(viewGroup, transitionValues, n12, transitionValues2, n13);
        }
        return null;
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(TransitionValues object, TransitionValues transitionValues) {
        int n10;
        Map map;
        boolean bl2;
        String string2;
        Map map2;
        boolean bl3;
        boolean bl4 = false;
        if (object == null && transitionValues == null) {
            return false;
        }
        if (object != null && transitionValues != null && (bl3 = (map2 = transitionValues.values).containsKey(string2 = PROPNAME_VISIBILITY)) != (bl2 = (map = ((TransitionValues)object).values).containsKey(string2))) {
            return false;
        }
        object = this.getVisibilityChangeInfo((TransitionValues)object, transitionValues);
        int n11 = ((Visibility$VisibilityInfo)object).mVisibilityChange;
        if (n11 != 0 && ((n11 = ((Visibility$VisibilityInfo)object).mStartVisibility) == 0 || (n10 = ((Visibility$VisibilityInfo)object).mEndVisibility) == 0)) {
            bl4 = true;
        }
        return bl4;
    }

    public boolean isVisible(TransitionValues object) {
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        Integer n10 = (Integer)((TransitionValues)object).values.get(PROPNAME_VISIBILITY);
        int n11 = n10;
        object = ((TransitionValues)object).values;
        String string2 = PROPNAME_PARENT;
        object = (View)object.get(string2);
        if (n11 == 0 && object != null) {
            bl2 = true;
        }
        return bl2;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int n10, TransitionValues transitionValues2, int n11) {
        n10 = this.mMode;
        n11 = 1;
        if ((n10 &= n11) == n11 && transitionValues2 != null) {
            Object object;
            if (transitionValues == null) {
                object = (View)transitionValues2.view.getParent();
                n11 = 0;
                TransitionValues transitionValues3 = this.getMatchedTransitionValues((View)object, false);
                object = this.getTransitionValues((View)object, false);
                object = this.getVisibilityChangeInfo(transitionValues3, (TransitionValues)object);
                n10 = (int)(object.mVisibilityChange ? 1 : 0);
                if (n10 != 0) {
                    return null;
                }
            }
            object = transitionValues2.view;
            return this.onAppear(viewGroup, (View)object, transitionValues, transitionValues2);
        }
        return null;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public Animator onDisappear(ViewGroup var1_1, TransitionValues var2_2, int var3_3, TransitionValues var4_4, int var5_5) {
        block17: {
            block20: {
                block19: {
                    block18: {
                        block16: {
                            var6_6 = this;
                            var7_7 = var1_1;
                            var8_8 = var2_2;
                            var9_9 = var4_4;
                            var10_10 /* !! */  = var5_5;
                            var11_11 = this.mMode;
                            var12_12 = 2;
                            var13_13 = false;
                            var14_14 = null;
                            if ((var11_11 &= var12_12) != var12_12) {
                                return null;
                            }
                            if (var2_2 == null) {
                                return null;
                            }
                            var15_15 = var2_2.view;
                            if (var4_4 != null) {
                                var16_16 = var4_4.view;
                            } else {
                                var17_17 = 0;
                                var16_16 = null;
                            }
                            var18_18 = R$id.save_overlay_view;
                            var19_19 = (View)var15_15.getTag(var18_18);
                            var20_20 = 1;
                            if (var19_19 == null) break block16;
                            var17_17 = 0;
                            var16_16 = null;
                            var21_21 = var20_20;
                            break block17;
                        }
                        if (var16_16 == null || (var19_19 = var16_16.getParent()) == null) break block18;
                        var22_22 = 4;
                        if (var10_10 /* !! */  != var22_22 && var15_15 != var16_16) ** GOTO lbl-1000
                        var19_19 = var16_16;
                        var21_21 = 0;
                        var23_24 = null;
                        var17_17 = 0;
                        var16_16 = null;
                        break block19;
                    }
                    if (var16_16 != null) {
                        var22_23 = false;
                        var19_19 = null;
                        var21_21 = 0;
                        var23_24 = null;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var17_17 = 0;
                        var16_16 = null;
                        var22_22 = 0;
                        var19_19 = null;
                        var21_21 = var20_20;
                    }
                }
                if (var21_21 == 0) ** GOTO lbl-1000
                var23_24 = var15_15.getParent();
                if (var23_24 == null) ** GOTO lbl-1000
                var23_24 = var15_15.getParent();
                var21_21 = var23_24 instanceof View;
                if (var21_21 == 0) ** GOTO lbl-1000
                var23_24 = (View)var15_15.getParent();
                var24_25 = var6_6.getTransitionValues((View)var23_24, (boolean)var20_20);
                var25_26 = var6_6.getMatchedTransitionValues((View)var23_24, (boolean)var20_20);
                var24_25 = var6_6.getVisibilityChangeInfo((TransitionValues)var24_25, var25_26);
                var26_27 = var24_25.mVisibilityChange;
                if (var26_27 != 0) break block20;
                var16_16 = TransitionUtils.copyViewImage((ViewGroup)var7_7, var15_15, (View)var23_24);
                ** GOTO lbl-1000
            }
            var26_27 = var23_24.getId();
            if ((var23_24 = var23_24.getParent()) == null && var26_27 != (var21_21 = -1) && (var23_24 = var7_7.findViewById(var26_27)) != null && (var21_21 = (int)var6_6.mCanRemoveViews) != 0) lbl-1000:
            // 2 sources

            {
                var16_16 = var19_19;
                var21_21 = 0;
                var23_24 = null;
                var19_19 = var15_15;
            } else lbl-1000:
            // 4 sources

            {
                var21_21 = 0;
                var23_24 = null;
                var27_28 = var19_19;
                var19_19 = var16_16;
                var16_16 = var27_28;
            }
        }
        if (var19_19 != null) {
            if (var21_21 == 0) {
                var28_29 = var8_8.values;
                var14_14 = "android:visibility:screenLocation";
                var28_29 = (int[])var28_29.get(var14_14);
                var13_13 = var28_29[0];
                var10_10 /* !! */  = (int)var28_29[var20_20];
                var29_30 = new int[var12_12];
                var7_7.getLocationOnScreen(var29_30);
                var17_17 = var29_30[0];
                var13_13 -= var17_17;
                var17_17 = var19_19.getLeft();
                var19_19.offsetLeftAndRight(var13_13 -= var17_17);
                var12_12 = var29_30[var20_20];
                var10_10 /* !! */  -= var12_12;
                var12_12 = var19_19.getTop();
                var19_19.offsetTopAndBottom(var10_10 /* !! */  -= var12_12);
                var28_29 = ViewGroupUtils.getOverlay(var1_1);
                var28_29.add(var19_19);
            }
            var8_8 = var6_6.onDisappear((ViewGroup)var7_7, var19_19, (TransitionValues)var8_8, (TransitionValues)var9_9);
            if (var21_21 == 0) {
                if (var8_8 == null) {
                    var7_7 = ViewGroupUtils.getOverlay(var1_1);
                    var7_7.remove(var19_19);
                } else {
                    var15_15.setTag(var18_18, (Object)var19_19);
                    var9_9 = new Visibility$1(var6_6, (ViewGroup)var7_7, var19_19, var15_15);
                    var6_6.addListener((Transition$TransitionListener)var9_9);
                }
            }
            return var8_8;
        }
        if (var16_16 != null) {
            var11_11 = var16_16.getVisibility();
            ViewUtils.setTransitionVisibility(var16_16, 0);
            var7_7 = var6_6.onDisappear((ViewGroup)var7_7, var16_16, (TransitionValues)var8_8, (TransitionValues)var9_9);
            if (var7_7 != null) {
                var8_8 = new Visibility$DisappearListener(var16_16, var10_10 /* !! */ , (boolean)var20_20);
                var7_7.addListener((Animator.AnimatorListener)var8_8);
                AnimatorUtils.addPauseListener((Animator)var7_7, (AnimatorListenerAdapter)var8_8);
                var6_6.addListener((Transition$TransitionListener)var8_8);
            } else {
                ViewUtils.setTransitionVisibility(var16_16, var11_11);
            }
            return var7_7;
        }
        return null;
    }

    public void setMode(int n10) {
        int n11 = n10 & 0xFFFFFFFC;
        if (n11 == 0) {
            this.mMode = n10;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        throw illegalArgumentException;
    }
}

