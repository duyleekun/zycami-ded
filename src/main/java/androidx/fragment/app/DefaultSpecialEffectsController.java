/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.os.CancellationSignal$OnCancelListener;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.DefaultSpecialEffectsController$1;
import androidx.fragment.app.DefaultSpecialEffectsController$10;
import androidx.fragment.app.DefaultSpecialEffectsController$2;
import androidx.fragment.app.DefaultSpecialEffectsController$3;
import androidx.fragment.app.DefaultSpecialEffectsController$4;
import androidx.fragment.app.DefaultSpecialEffectsController$5;
import androidx.fragment.app.DefaultSpecialEffectsController$6;
import androidx.fragment.app.DefaultSpecialEffectsController$7;
import androidx.fragment.app.DefaultSpecialEffectsController$8;
import androidx.fragment.app.DefaultSpecialEffectsController$9;
import androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo;
import androidx.fragment.app.DefaultSpecialEffectsController$SpecialEffectsInfo;
import androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim$AnimationOrAnimator;
import androidx.fragment.app.FragmentAnim$EndViewTransitionAnimation;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.SpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController$Operation;
import androidx.fragment.app.SpecialEffectsController$Operation$State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DefaultSpecialEffectsController
extends SpecialEffectsController {
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void startAnimations(List list, List list2, boolean bl2, Map map) {
        boolean bl3;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        int n10;
        String string2;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        ViewGroup viewGroup = this.getContainer();
        Context context = viewGroup.getContext();
        Object object5 = new ArrayList();
        Iterator iterator2 = list.iterator();
        boolean bl4 = false;
        Object var11_13 = null;
        while (true) {
            SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
            StringBuilder stringBuilder;
            Animator animator2;
            Object object6;
            block20: {
                block18: {
                    block19: {
                        block17: {
                            boolean bl5 = iterator2.hasNext();
                            string2 = "FragmentManager";
                            n10 = 2;
                            if (!bl5) break;
                            object6 = object4 = iterator2.next();
                            object6 = (DefaultSpecialEffectsController$AnimationInfo)object4;
                            bl5 = ((DefaultSpecialEffectsController$SpecialEffectsInfo)object6).isVisibilityUnchanged();
                            if (!bl5) break block17;
                            ((DefaultSpecialEffectsController$SpecialEffectsInfo)object6).completeSpecialEffect();
                            break block18;
                        }
                        object4 = ((DefaultSpecialEffectsController$AnimationInfo)object6).getAnimation(context);
                        if (object4 != null) break block19;
                        ((DefaultSpecialEffectsController$SpecialEffectsInfo)object6).completeSpecialEffect();
                        break block18;
                    }
                    animator2 = ((FragmentAnim$AnimationOrAnimator)object4).animator;
                    if (animator2 != null) break block20;
                    ((ArrayList)object5).add(object6);
                }
                object3 = map;
                continue;
            }
            object2 = ((DefaultSpecialEffectsController$SpecialEffectsInfo)object6).getOperation();
            object4 = ((SpecialEffectsController$Operation)object2).getFragment();
            object = Boolean.TRUE;
            object3 = map;
            Object v10 = map.get(object2);
            bl3 = ((Boolean)object).equals(v10);
            if (bl3) {
                if ((n10 = (int)(FragmentManager.isLoggingEnabled(n10) ? 1 : 0)) != 0) {
                    stringBuilder = new StringBuilder();
                    object = "Ignoring Animator set on ";
                    stringBuilder.append((String)object);
                    stringBuilder.append(object4);
                    stringBuilder.append(" as this Fragment was involved in a Transition.");
                    object4 = stringBuilder.toString();
                    Log.v((String)string2, (String)object4);
                }
                ((DefaultSpecialEffectsController$SpecialEffectsInfo)object6).completeSpecialEffect();
                continue;
            }
            SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = ((SpecialEffectsController$Operation)object2).getFinalState();
            if (specialEffectsController$Operation$State2 == (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.GONE)) {
                bl3 = true;
            } else {
                bl3 = false;
                object = null;
            }
            List list3 = list2;
            if (bl3) {
                list2.remove(object2);
            }
            stringBuilder = ((Fragment)object4).mView;
            viewGroup.startViewTransition((View)stringBuilder);
            object4 = this;
            ViewGroup viewGroup2 = viewGroup;
            object3 = object6;
            DefaultSpecialEffectsController$2 defaultSpecialEffectsController$2 = new DefaultSpecialEffectsController$2(this, viewGroup, (View)stringBuilder, bl3, (SpecialEffectsController$Operation)object2, (DefaultSpecialEffectsController$AnimationInfo)object6);
            animator2.addListener((Animator.AnimatorListener)defaultSpecialEffectsController$2);
            StringBuilder stringBuilder2 = stringBuilder;
            animator2.setTarget((Object)stringBuilder);
            animator2.start();
            CancellationSignal cancellationSignal = ((DefaultSpecialEffectsController$SpecialEffectsInfo)object6).getSignal();
            object4 = new DefaultSpecialEffectsController$3(defaultSpecialEffectsController, animator2);
            cancellationSignal.setOnCancelListener((CancellationSignal$OnCancelListener)object4);
            bl4 = true;
        }
        object4 = ((ArrayList)object5).iterator();
        while (bl3 = object4.hasNext()) {
            SpecialEffectsController$Operation$State specialEffectsController$Operation$State;
            boolean bl6;
            object = (DefaultSpecialEffectsController$AnimationInfo)object4.next();
            object2 = ((DefaultSpecialEffectsController$SpecialEffectsInfo)object).getOperation();
            object3 = ((SpecialEffectsController$Operation)object2).getFragment();
            object5 = "Ignoring Animation set on ";
            if (bl2) {
                bl6 = FragmentManager.isLoggingEnabled(n10);
                if (bl6) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object5);
                    ((StringBuilder)object2).append(object3);
                    object3 = " as Animations cannot run alongside Transitions.";
                    ((StringBuilder)object2).append((String)object3);
                    object2 = ((StringBuilder)object2).toString();
                    Log.v((String)string2, (String)object2);
                }
                ((DefaultSpecialEffectsController$SpecialEffectsInfo)object).completeSpecialEffect();
                continue;
            }
            if (bl4) {
                bl6 = FragmentManager.isLoggingEnabled(n10);
                if (bl6) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append((String)object5);
                    ((StringBuilder)object2).append(object3);
                    object3 = " as Animations cannot run alongside Animators.";
                    ((StringBuilder)object2).append((String)object3);
                    object2 = ((StringBuilder)object2).toString();
                    Log.v((String)string2, (String)object2);
                }
                ((DefaultSpecialEffectsController$SpecialEffectsInfo)object).completeSpecialEffect();
                continue;
            }
            object3 = ((Fragment)object3).mView;
            object5 = (Animation)Preconditions.checkNotNull(((FragmentAnim$AnimationOrAnimator)Preconditions.checkNotNull((Object)object.getAnimation((Context)context))).animation);
            if ((object2 = ((SpecialEffectsController$Operation)object2).getFinalState()) != (specialEffectsController$Operation$State = SpecialEffectsController$Operation$State.REMOVED)) {
                object3.startAnimation((Animation)object5);
                ((DefaultSpecialEffectsController$SpecialEffectsInfo)object).completeSpecialEffect();
            } else {
                viewGroup.startViewTransition((View)object3);
                object2 = new FragmentAnim$EndViewTransitionAnimation((Animation)object5, viewGroup, (View)object3);
                object5 = new DefaultSpecialEffectsController$4(defaultSpecialEffectsController, viewGroup, (View)object3, (DefaultSpecialEffectsController$AnimationInfo)object);
                object2.setAnimationListener((Animation.AnimationListener)object5);
                object3.startAnimation((Animation)object2);
            }
            object2 = ((DefaultSpecialEffectsController$SpecialEffectsInfo)object).getSignal();
            object5 = new DefaultSpecialEffectsController$5(defaultSpecialEffectsController, (View)object3, viewGroup, (DefaultSpecialEffectsController$AnimationInfo)object);
            ((CancellationSignal)object2).setOnCancelListener((CancellationSignal$OnCancelListener)object5);
        }
        return;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private Map startTransitions(List var1_1, List var2_2, boolean var3_3, SpecialEffectsController$Operation var4_4, SpecialEffectsController$Operation var5_5) {
        var6_6 = this;
        var7_7 = var3_3;
        var8_8 = var4_4;
        var9_9 = var5_5;
        var10_10 = Boolean.TRUE;
        var11_11 = Boolean.FALSE;
        var12_12 /* !! */  = new HashMap();
        var13_13 = var1_1.iterator();
        var14_14 = false;
        var15_15 = null;
        while ((var16_16 = var13_13.hasNext()) != 0) {
            var17_17 = (DefaultSpecialEffectsController$TransitionInfo)var13_13.next();
            var18_18 = var17_17.isVisibilityUnchanged();
            if (var18_18) continue;
            var19_19 = var17_17.getHandlingImpl();
            if (var15_15 == null) {
                var15_15 = var19_19;
                continue;
            }
            if (var19_19 == null || var15_15 == var19_19) continue;
            var19_19 = new StringBuilder();
            var19_19.append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            var20_20 = var17_17.getOperation().getFragment();
            var19_19.append(var20_20);
            var19_19.append(" returned Transition ");
            var17_17 = var17_17.getTransition();
            var19_19.append(var17_17);
            var19_19.append(" which uses a different Transition  type than other Fragments.");
            var17_17 = var19_19.toString();
            var13_13 = new IllegalArgumentException((String)var17_17);
            throw var13_13;
        }
        if (var15_15 == null) {
            var13_13 = var1_1.iterator();
            while ((var16_16 = var13_13.hasNext()) != 0) {
                var17_17 = (DefaultSpecialEffectsController$TransitionInfo)var13_13.next();
                var19_19 = var17_17.getOperation();
                var12_12 /* !! */ .put(var19_19, var11_11);
                var17_17.completeSpecialEffect();
            }
            return var12_12 /* !! */ ;
        }
        var13_13 = this.getContainer().getContext();
        var21_22 = new View((Context)var13_13);
        var22_23 = new Rect();
        var23_24 /* !! */  = new ArrayList<E>();
        var20_21 = new ArrayList();
        var19_19 = new ArrayMap();
        var24_25 = var1_1.iterator();
        var25_26 = 0;
        var13_13 = null;
        var26_27 = false;
        var27_28 = null;
        var28_29 = false;
        while (true) {
            block56: {
                block54: {
                    block55: {
                        var29_30 = var24_25.hasNext();
                        var30_31 = var27_28;
                        if (!var29_30) break;
                        var31_32 = (DefaultSpecialEffectsController$TransitionInfo)var24_25.next();
                        var32_33 = var31_32.hasSharedElementTransition();
                        if (!var32_33 || var8_8 == null || var9_9 == null) break block54;
                        var13_13 = var31_32.getSharedElementTransition();
                        var13_13 = var15_15.cloneTransition(var13_13);
                        var13_13 = var15_15.wrapTransitionInSet(var13_13);
                        var27_28 = var5_5.getFragment().getSharedElementSourceNames();
                        var17_17 = var4_4.getFragment().getSharedElementSourceNames();
                        var31_32 = var4_4.getFragment();
                        var33_34 /* !! */  = var13_13;
                        var13_13 = var31_32.getSharedElementTargetNames();
                        var31_32 = var22_23;
                        var34_35 = var11_11;
                        var22_23 = null;
                        for (var35_36 = 0; var35_36 < (var36_37 = var13_13.size()); ++var35_36) {
                            var11_11 = var13_13.get(var35_36);
                            var36_37 = var27_28.indexOf(var11_11);
                            var37_38 = var13_13;
                            var25_26 = -1;
                            if (var36_37 != var25_26) {
                                var13_13 = var17_17.get(var35_36);
                                var27_28.set(var36_37, var13_13);
                            }
                            var13_13 = var37_38;
                        }
                        var13_13 = var5_5.getFragment();
                        var11_11 = var13_13.getSharedElementTargetNames();
                        if (!var7_7) {
                            var13_13 = var4_4.getFragment().getExitTransitionCallback();
                            var17_17 = var5_5.getFragment().getEnterTransitionCallback();
                        } else {
                            var13_13 = var4_4.getFragment().getEnterTransitionCallback();
                            var17_17 = var5_5.getFragment().getExitTransitionCallback();
                        }
                        var35_36 = var27_28.size();
                        var9_9 = null;
                        for (var38_39 = 0; var38_39 < var35_36; ++var38_39) {
                            var37_38 = var27_28.get(var38_39);
                            var22_23 = var37_38;
                            var22_23 = (String)var37_38;
                            var37_38 = var11_11.get(var38_39);
                            var8_8 = var37_38;
                            var8_8 = (String)var37_38;
                            var19_19.put(var22_23, var8_8);
                            var8_8 = var4_4;
                        }
                        var8_8 = new ArrayMap();
                        var22_23 = var4_4.getFragment().mView;
                        var6_6.findNamedViews((Map)var8_8, (View)var22_23);
                        var8_8.retainAll((Collection)var27_28);
                        if (var13_13 != null) {
                            var13_13.onMapSharedElements((List)var27_28, (Map)var8_8);
                            var25_26 = var27_28.size();
                            var35_36 = 1;
                            var25_26 -= var35_36;
                            while (var25_26 >= 0) {
                                var22_23 = (String)var27_28.get(var25_26);
                                var9_9 = (View)var8_8.get(var22_23);
                                if (var9_9 == null) {
                                    var19_19.remove(var22_23);
                                    var39_40 = var10_10;
                                } else {
                                    var39_40 = var10_10;
                                    var10_10 = ViewCompat.getTransitionName((View)var9_9);
                                    var40_41 = var22_23.equals(var10_10);
                                    if (!var40_41) {
                                        var22_23 = (String)var19_19.remove(var22_23);
                                        var9_9 = ViewCompat.getTransitionName((View)var9_9);
                                        var19_19.put(var9_9, var22_23);
                                    }
                                }
                                var25_26 += -1;
                                var10_10 = var39_40;
                            }
                            var39_40 = var10_10;
                        } else {
                            var39_40 = var10_10;
                            var13_13 = var8_8.keySet();
                            var19_19.retainAll((Collection)var13_13);
                        }
                        var9_9 = new ArrayMap();
                        var13_13 = var5_5.getFragment().mView;
                        var6_6.findNamedViews((Map)var9_9, (View)var13_13);
                        var9_9.retainAll((Collection)var11_11);
                        var13_13 = var19_19.values();
                        var9_9.retainAll((Collection)var13_13);
                        if (var17_17 != null) {
                            var17_17.onMapSharedElements((List)var11_11, (Map)var9_9);
                            var25_26 = var11_11.size();
                            var16_16 = 1;
                            var25_26 -= var16_16;
                            while (var25_26 >= 0) {
                                var17_17 = (String)var11_11.get(var25_26);
                                var22_23 = (View)var9_9.get(var17_17);
                                if (var22_23 == null) {
                                    if ((var17_17 = FragmentTransition.findKeyForValue((ArrayMap)var19_19, (String)var17_17)) != null) {
                                        var19_19.remove(var17_17);
                                    }
                                } else {
                                    var10_10 = ViewCompat.getTransitionName((View)var22_23);
                                    var40_41 = var17_17.equals(var10_10);
                                    if (!var40_41 && (var17_17 = FragmentTransition.findKeyForValue((ArrayMap)var19_19, (String)var17_17)) != null) {
                                        var22_23 = ViewCompat.getTransitionName((View)var22_23);
                                        var19_19.put(var17_17, var22_23);
                                    }
                                }
                                var25_26 += -1;
                            }
                        } else {
                            FragmentTransition.retainValues((ArrayMap)var19_19, (ArrayMap)var9_9);
                        }
                        var13_13 = var19_19.keySet();
                        var6_6.retainMatchingViews((ArrayMap)var8_8, (Collection)var13_13);
                        var13_13 = var19_19.values();
                        var6_6.retainMatchingViews((ArrayMap)var9_9, (Collection)var13_13);
                        var25_26 = (int)var19_19.isEmpty();
                        if (var25_26 == 0) break block55;
                        var23_24 /* !! */ .clear();
                        var20_21.clear();
                        var22_23 = var4_4;
                        var9_9 = var5_5;
                        var41_42 = var19_19;
                        var19_19 = var23_24 /* !! */ ;
                        var42_43 /* !! */  = var12_12 /* !! */ ;
                        var17_17 = var21_22;
                        var23_24 /* !! */  = var15_15;
                        var27_28 = var30_31;
                        var8_8 = var39_40;
                        var25_26 = 0;
                        var13_13 = null;
                        var12_12 /* !! */  = var20_21;
                        var20_21 = var31_32;
                        break block56;
                    }
                    var13_13 = var5_5.getFragment();
                    var17_17 = var4_4.getFragment();
                    var40_41 = true;
                    FragmentTransition.callSharedElementStartEnd((Fragment)var13_13, (Fragment)var17_17, var7_7, (ArrayMap)var8_8, var40_41);
                    var22_23 = this.getContainer();
                    var10_10 = var33_34 /* !! */ ;
                    var13_13 = var17_17;
                    var42_43 /* !! */  = var17_17;
                    var17_17 = this;
                    var41_42 = var19_19;
                    var19_19 = var5_5;
                    var43_44 = var12_12 /* !! */ ;
                    var12_12 /* !! */  = var20_21;
                    var20_21 = var4_4;
                    var44_45 = var21_22;
                    var21_22 = var23_24 /* !! */ ;
                    var45_46 /* !! */  = var31_32;
                    var31_32 = var11_11;
                    var11_11 = var22_23;
                    var22_23 = var9_9;
                    var13_13 = new DefaultSpecialEffectsController$6(this, var5_5, var4_4, var3_3, (ArrayMap)var9_9);
                    OneShotPreDrawListener.add((View)var11_11, (Runnable)var13_13);
                    var13_13 = var8_8.values().iterator();
                    while ((var16_16 = (int)var13_13.hasNext()) != 0) {
                        var17_17 = (View)var13_13.next();
                        var6_6.captureTransitioningViews((ArrayList)var21_22, (View)var17_17);
                    }
                    var25_26 = (int)var27_28.isEmpty();
                    if (var25_26 == 0) {
                        var25_26 = 0;
                        var17_17 = (String)var27_28.get(0);
                        var13_13 = (View)var8_8.get(var17_17);
                        var15_15.setEpicenter(var10_10, (View)var13_13);
                        var27_28 = var13_13;
                    } else {
                        var27_28 = var30_31;
                    }
                    var13_13 = var9_9.values().iterator();
                    while ((var16_16 = (int)var13_13.hasNext()) != 0) {
                        var17_17 = (View)var13_13.next();
                        var6_6.captureTransitioningViews((ArrayList)var12_12 /* !! */ , (View)var17_17);
                    }
                    var25_26 = (int)var31_32.isEmpty();
                    if (var25_26 != 0) ** GOTO lbl-1000
                    var13_13 = var31_32;
                    var16_16 = 0;
                    var17_17 = null;
                    var13_13 = (String)var31_32.get(0);
                    if ((var13_13 = (View)var9_9.get(var13_13)) != null) {
                        var17_17 = this.getContainer();
                        var20_21 = var45_46 /* !! */ ;
                        var19_19 = new DefaultSpecialEffectsController$7(var6_6, (FragmentTransitionImpl)var15_15, (View)var13_13, (Rect)var45_46 /* !! */ );
                        OneShotPreDrawListener.add((View)var17_17, (Runnable)var19_19);
                        var13_13 = var44_45;
                        var28_29 = true;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var20_21 = var45_46 /* !! */ ;
                        var13_13 = var44_45;
                    }
                    var15_15.setSharedElementTargets(var10_10, (View)var13_13, (ArrayList)var21_22);
                    var29_30 = false;
                    var31_32 = null;
                    var32_33 = false;
                    var44_45 = null;
                    var33_34 /* !! */  = null;
                    var37_38 = null;
                    var17_17 = var13_13;
                    var19_19 = var21_22;
                    var21_22 = var15_15;
                    var23_24 /* !! */  = var15_15;
                    var15_15 = var10_10;
                    var46_47 = var10_10;
                    var21_22.scheduleRemoveTargets(var10_10, null, null, null, null, var10_10, (ArrayList)var12_12 /* !! */ );
                    var22_23 = var4_4;
                    var8_8 = var39_40;
                    var42_43 /* !! */  = var43_44;
                    var43_44.put(var4_4, var39_40);
                    var9_9 = var5_5;
                    var43_44.put(var5_5, var39_40);
                    var13_13 = var10_10;
                    break block56;
                }
                var41_42 = var19_19;
                var19_19 = var23_24 /* !! */ ;
                var34_35 = var11_11;
                var42_43 /* !! */  = var12_12 /* !! */ ;
                var17_17 = var21_22;
                var23_24 /* !! */  = var15_15;
                var12_12 /* !! */  = var20_21;
                var20_21 = var22_23;
                var22_23 = var8_8;
                var8_8 = var10_10;
                var27_28 = var30_31;
            }
            var21_22 = var17_17;
            var15_15 = var23_24 /* !! */ ;
            var10_10 = var8_8;
            var11_11 = var34_35;
            var23_24 /* !! */  = var19_19;
            var8_8 = var22_23;
            var19_19 = var41_42;
            var22_23 = var20_21;
            var20_21 = var12_12 /* !! */ ;
            var12_12 /* !! */  = var42_43 /* !! */ ;
            var7_7 = var3_3;
        }
        var41_42 = var19_19;
        var19_19 = var23_24 /* !! */ ;
        var34_35 = var11_11;
        var42_43 /* !! */  = var12_12 /* !! */ ;
        var17_17 = var21_22;
        var23_24 /* !! */  = var15_15;
        var12_12 /* !! */  = var20_21;
        var20_21 = var22_23;
        var22_23 = var8_8;
        var8_8 = var10_10;
        var10_10 = new ArrayList();
        var11_11 = var1_1.iterator();
        var26_27 = false;
        var27_28 = null;
        var14_14 = false;
        var15_15 = null;
        while (var47_48 = var11_11.hasNext()) {
            var24_25 = var21_22 = var11_11.next();
            var24_25 = (DefaultSpecialEffectsController$TransitionInfo)var21_22;
            var47_48 = var24_25.isVisibilityUnchanged();
            if (var47_48) {
                var21_22 = var24_25.getOperation();
                var48_49 = var11_11;
                var11_11 = var34_35;
                var42_43 /* !! */ .put(var21_22, var34_35);
                var24_25.completeSpecialEffect();
                var11_11 = var48_49;
                continue;
            }
            var48_49 = var11_11;
            var11_11 = var34_35;
            var21_22 = var24_25.getTransition();
            var21_22 = var23_24 /* !! */ .cloneTransition(var21_22);
            var34_35 = var27_28;
            var27_28 = var24_25.getOperation();
            if (var13_13 != null && (var27_28 == var22_23 || var27_28 == var9_9)) {
                var29_30 = true;
            } else {
                var29_30 = false;
                var31_32 = null;
            }
            if (var21_22 == null) {
                if (!var29_30) {
                    var42_43 /* !! */ .put(var27_28, var11_11);
                    var24_25.completeSpecialEffect();
                }
                var43_44 = var17_17;
                var46_47 = var19_19;
                var39_40 = var11_11;
                var19_19 = var30_31;
                var27_28 = var34_35;
                var36_37 = 0;
                var11_11 = null;
            } else {
                var39_40 = var11_11;
                var11_11 = new ArrayList();
                var44_45 = var15_15;
                var15_15 = var27_28.getFragment().mView;
                var6_6.captureTransitioningViews((ArrayList)var11_11, (View)var15_15);
                if (var29_30) {
                    if (var27_28 == var22_23) {
                        var11_11.removeAll((Collection<?>)var19_19);
                    } else {
                        var11_11.removeAll((Collection<?>)var12_12 /* !! */ );
                    }
                }
                if (var14_14 = var11_11.isEmpty()) {
                    var23_24 /* !! */ .addTarget(var21_22, (View)var17_17);
                    var43_44 = var17_17;
                    var46_47 = var19_19;
                    var17_17 = var44_45;
                } else {
                    var23_24 /* !! */ .addTargets(var21_22, (ArrayList)var11_11);
                    var33_34 /* !! */  = null;
                    var37_38 = null;
                    var46_47 = null;
                    var15_15 = var21_22;
                    var21_22 = var23_24 /* !! */ ;
                    var43_44 = var17_17;
                    var45_46 /* !! */  = var15_15;
                    var17_17 = var44_45;
                    var31_32 = var15_15;
                    var44_45 = var11_11;
                    var23_24 /* !! */ .scheduleRemoveTargets(var15_15, var15_15, (ArrayList)var11_11, null, null, null, null);
                    var21_22 = var27_28.getFinalState();
                    var15_15 = SpecialEffectsController$Operation$State.GONE;
                    if (var21_22 == var15_15) {
                        var21_22 = var2_2;
                        var2_2.remove(var27_28);
                        var15_15 = var27_28.getFragment().mView;
                        var21_22 = var45_46 /* !! */ ;
                        var23_24 /* !! */ .scheduleHideFragmentView(var45_46 /* !! */ , (View)var15_15, (ArrayList)var11_11);
                        var15_15 = this.getContainer();
                        var46_47 = var19_19;
                        var19_19 = new DefaultSpecialEffectsController$8(var6_6, (ArrayList)var11_11);
                        OneShotPreDrawListener.add((View)var15_15, (Runnable)var19_19);
                    } else {
                        var46_47 = var19_19;
                        var21_22 = var45_46 /* !! */ ;
                    }
                }
                var19_19 = var27_28.getFinalState();
                var15_15 = SpecialEffectsController$Operation$State.VISIBLE;
                if (var19_19 == var15_15) {
                    var10_10.addAll(var11_11);
                    if (var28_29) {
                        var23_24 /* !! */ .setEpicenter(var21_22, (Rect)var20_21);
                    }
                    var19_19 = var30_31;
                } else {
                    var19_19 = var30_31;
                    var23_24 /* !! */ .setEpicenter(var21_22, (View)var30_31);
                }
                var42_43 /* !! */ .put(var27_28, var8_8);
                var36_37 = (int)var24_25.isOverlapAllowed();
                if (var36_37 != 0) {
                    var27_28 = var34_35;
                    var36_37 = 0;
                    var11_11 = null;
                    var27_28 = var23_24 /* !! */ .mergeTransitionsTogether(var34_35, var21_22, null);
                } else {
                    var27_28 = var34_35;
                    var36_37 = 0;
                    var11_11 = null;
                    var17_17 = var23_24 /* !! */ .mergeTransitionsTogether(var17_17, var21_22, null);
                }
                var15_15 = var17_17;
            }
            var11_11 = var48_49;
            var30_31 = var19_19;
            var19_19 = var46_47;
            var34_35 = var39_40;
            var17_17 = var43_44;
        }
        var46_47 = var19_19;
        var17_17 = var15_15;
        var17_17 = var23_24 /* !! */ .mergeTransitionsInSequence(var27_28, var15_15, var13_13);
        var19_19 = var1_1.iterator();
        while (var49_50 = var19_19.hasNext()) {
            var20_21 = (DefaultSpecialEffectsController$TransitionInfo)var19_19.next();
            var50_51 = var20_21.isVisibilityUnchanged();
            if (var50_51) continue;
            var8_8 = var20_21.getTransition();
            var11_11 = var20_21.getOperation();
            if (var13_13 != null && (var11_11 == var22_23 || var11_11 == var9_9)) {
                var26_27 = true;
            } else {
                var26_27 = false;
                var27_28 = null;
            }
            if (var8_8 == null && !var26_27) continue;
            var8_8 = this.getContainer();
            var50_51 = ViewCompat.isLaidOut((View)var8_8);
            if (!var50_51) {
                var50_51 = FragmentManager.isLoggingEnabled(2);
                if (var50_51) {
                    var8_8 = new StringBuilder();
                    var8_8.append("SpecialEffectsController: Container ");
                    var27_28 = this.getContainer();
                    var8_8.append(var27_28);
                    var27_28 = " has not been laid out. Completing operation ";
                    var8_8.append((String)var27_28);
                    var8_8.append(var11_11);
                    var8_8 = var8_8.toString();
                    var11_11 = "FragmentManager";
                    Log.v((String)var11_11, (String)var8_8);
                }
                var20_21.completeSpecialEffect();
                continue;
            }
            var8_8 = var20_21.getOperation().getFragment();
            var11_11 = var20_21.getSignal();
            var27_28 = new DefaultSpecialEffectsController$9(var6_6, (DefaultSpecialEffectsController$TransitionInfo)var20_21);
            var23_24 /* !! */ .setListenerForTransitionEnd((Fragment)var8_8, var17_17, (CancellationSignal)var11_11, (Runnable)var27_28);
        }
        var19_19 = this.getContainer();
        var18_18 = ViewCompat.isLaidOut((View)var19_19);
        if (!var18_18) {
            return var42_43 /* !! */ ;
        }
        FragmentTransition.setViewVisibility((ArrayList)var10_10, 4);
        var33_34 /* !! */  = var23_24 /* !! */ .prepareSetNameOverridesReordered((ArrayList)var12_12 /* !! */ );
        var19_19 = this.getContainer();
        var23_24 /* !! */ .beginDelayedTransition((ViewGroup)var19_19, var17_17);
        var15_15 = this.getContainer();
        var21_22 = var23_24 /* !! */ ;
        var31_32 = var46_47;
        var44_45 = var12_12 /* !! */ ;
        var37_38 = var41_42;
        var23_24 /* !! */ .setNameOverridesReordered((View)var15_15, (ArrayList)var46_47, (ArrayList)var12_12 /* !! */ , (ArrayList)var33_34 /* !! */ , (Map)var41_42);
        FragmentTransition.setViewVisibility((ArrayList)var10_10, 0);
        var17_17 = var46_47;
        var23_24 /* !! */ .swapSharedElementTargets(var13_13, (ArrayList)var46_47, (ArrayList)var12_12 /* !! */ );
        return var42_43 /* !! */ ;
    }

    public void applyContainerChanges(SpecialEffectsController$Operation specialEffectsController$Operation) {
        View view = specialEffectsController$Operation.getFragment().mView;
        specialEffectsController$Operation.getFinalState().applyState(view);
    }

    public void captureTransitioningViews(ArrayList arrayList, View view) {
        int n10 = view instanceof ViewGroup;
        if (n10 != 0) {
            String string2;
            n10 = arrayList.contains(view);
            if (n10 == 0 && (string2 = ViewCompat.getTransitionName(view)) != null) {
                arrayList.add(view);
            }
            view = (ViewGroup)view;
            n10 = view.getChildCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                View view2 = view.getChildAt(i10);
                int n11 = view2.getVisibility();
                if (n11 != 0) continue;
                this.captureTransitioningViews(arrayList, view2);
            }
        } else {
            n10 = arrayList.contains(view);
            if (n10 == 0) {
                arrayList.add(view);
            }
        }
    }

    public void executeOperations(List iterator2, boolean bl2) {
        Object object;
        boolean bl3;
        int n10;
        Object object2;
        Object object3;
        Object object4;
        boolean bl4;
        ArrayList<DefaultSpecialEffectsController$AnimationInfo> arrayList = iterator2.iterator();
        boolean bl5 = false;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        while (true) {
            bl5 = arrayList.hasNext();
            bl4 = true;
            if (!bl5) break;
            arrayList2 = (SpecialEffectsController$Operation)arrayList.next();
            object4 = SpecialEffectsController$Operation$State.from(arrayList2.getFragment().mView);
            object3 = DefaultSpecialEffectsController$10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;
            object2 = ((SpecialEffectsController$Operation)((Object)arrayList2)).getFinalState();
            n10 = object2.ordinal();
            bl3 = object3[n10];
            if (bl3 != bl4 && bl3 != (bl4 = 2 != 0) && bl3 != (bl4 = 3 != 0)) {
                bl4 = 4 != 0;
                if (bl3 != bl4 || object4 == (object = SpecialEffectsController$Operation$State.VISIBLE)) continue;
                arrayList4 = arrayList2;
                continue;
            }
            object = SpecialEffectsController$Operation$State.VISIBLE;
            if (object4 != object || arrayList3 != null) continue;
            arrayList3 = arrayList2;
        }
        arrayList = new ArrayList<DefaultSpecialEffectsController$AnimationInfo>();
        object4 = new ArrayList();
        arrayList2 = new ArrayList(iterator2);
        iterator2 = iterator2.iterator();
        while (bl3 = iterator2.hasNext()) {
            object3 = (SpecialEffectsController$Operation)iterator2.next();
            object2 = new CancellationSignal();
            object3.markStartedSpecialEffect((CancellationSignal)object2);
            DefaultSpecialEffectsController$SpecialEffectsInfo defaultSpecialEffectsController$SpecialEffectsInfo = new DefaultSpecialEffectsController$AnimationInfo((SpecialEffectsController$Operation)object3, (CancellationSignal)object2, bl2);
            arrayList.add((DefaultSpecialEffectsController$AnimationInfo)defaultSpecialEffectsController$SpecialEffectsInfo);
            object2 = new CancellationSignal();
            object3.markStartedSpecialEffect((CancellationSignal)object2);
            boolean bl6 = false;
            if (bl2 ? object3 == arrayList3 : object3 == arrayList4) {
                bl6 = bl4;
            }
            defaultSpecialEffectsController$SpecialEffectsInfo = new DefaultSpecialEffectsController$TransitionInfo((SpecialEffectsController$Operation)object3, (CancellationSignal)object2, bl2, bl6);
            object4.add(defaultSpecialEffectsController$SpecialEffectsInfo);
            object2 = new DefaultSpecialEffectsController$1(this, arrayList2, (SpecialEffectsController$Operation)object3);
            object3.addCompletionListener((Runnable)object2);
        }
        object = this;
        object3 = arrayList2;
        n10 = (int)(bl2 ? 1 : 0);
        iterator2 = this.startTransitions((List)object4, arrayList2, bl2, (SpecialEffectsController$Operation)((Object)arrayList3), (SpecialEffectsController$Operation)((Object)arrayList4));
        Object object5 = Boolean.TRUE;
        bl2 = iterator2.containsValue(object5);
        this.startAnimations(arrayList, arrayList2, bl2, (Map)((Object)iterator2));
        iterator2 = arrayList2.iterator();
        while (bl2 = iterator2.hasNext()) {
            object5 = (SpecialEffectsController$Operation)iterator2.next();
            this.applyContainerChanges((SpecialEffectsController$Operation)object5);
        }
        arrayList2.clear();
    }

    public void findNamedViews(Map map, View view) {
        int n10;
        String string2 = ViewCompat.getTransitionName(view);
        if (string2 != null) {
            map.put(string2, view);
        }
        if ((n10 = view instanceof ViewGroup) != 0) {
            view = (ViewGroup)view;
            n10 = view.getChildCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                View view2 = view.getChildAt(i10);
                int n11 = view2.getVisibility();
                if (n11 != 0) continue;
                this.findNamedViews(map, view2);
            }
        }
    }

    public void retainMatchingViews(ArrayMap object, Collection collection) {
        boolean bl2;
        object = ((ArrayMap)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            String string2 = ViewCompat.getTransitionName((View)((Map.Entry)object.next()).getValue());
            bl2 = collection.contains(string2);
            if (bl2) continue;
            object.remove();
        }
    }
}

