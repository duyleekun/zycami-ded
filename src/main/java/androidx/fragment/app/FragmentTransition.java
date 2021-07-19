/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup
 */
package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.SharedElementCallback;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransaction$Op;
import androidx.fragment.app.FragmentTransition$1;
import androidx.fragment.app.FragmentTransition$2;
import androidx.fragment.app.FragmentTransition$3;
import androidx.fragment.app.FragmentTransition$4;
import androidx.fragment.app.FragmentTransition$5;
import androidx.fragment.app.FragmentTransition$6;
import androidx.fragment.app.FragmentTransition$Callback;
import androidx.fragment.app.FragmentTransition$FragmentContainerTransition;
import androidx.fragment.app.FragmentTransitionCompat21;
import androidx.fragment.app.FragmentTransitionImpl;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class FragmentTransition {
    private static final int[] INVERSE_OPS;
    public static final FragmentTransitionImpl PLATFORM_IMPL;
    public static final FragmentTransitionImpl SUPPORT_IMPL;

    static {
        Object object;
        int[] nArray = object = new int[11];
        int[] nArray2 = object;
        nArray[0] = 0;
        nArray2[1] = 3;
        nArray[2] = 0;
        nArray2[3] = 1;
        nArray[4] = 5;
        nArray2[5] = 4;
        nArray[6] = 7;
        nArray2[7] = 6;
        nArray[8] = 9;
        nArray2[9] = 8;
        nArray2[10] = 10;
        INVERSE_OPS = object;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            object = new FragmentTransitionCompat21;
            object();
        } else {
            n10 = 0;
            object = null;
        }
        PLATFORM_IMPL = object;
        SUPPORT_IMPL = FragmentTransition.resolveSupportImpl();
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList arrayList, ArrayMap arrayMap, Collection collection) {
        for (int i10 = arrayMap.size() + -1; i10 >= 0; i10 += -1) {
            View view = (View)arrayMap.valueAt(i10);
            String string2 = ViewCompat.getTransitionName(view);
            boolean bl2 = collection.contains(string2);
            if (!bl2) continue;
            arrayList.add(view);
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void addToFirstInLastOut(BackStackRecord var0, FragmentTransaction$Op var1_1, SparseArray var2_2, boolean var3_3, boolean var4_4) {
        block23: {
            block25: {
                block19: {
                    block18: {
                        block28: {
                            block26: {
                                block27: {
                                    block20: {
                                        block21: {
                                            block24: {
                                                block22: {
                                                    var5_5 = var1_1.mFragment;
                                                    if (var5_5 == null) {
                                                        return;
                                                    }
                                                    var6_6 = var5_5.mContainerId;
                                                    if (var6_6 == 0) {
                                                        return;
                                                    }
                                                    if (var3_3) {
                                                        var7_7 = FragmentTransition.INVERSE_OPS;
                                                        var8_8 = var1_1.mCmd;
                                                        var8_8 = var7_7[var8_8];
                                                    } else {
                                                        var8_8 = var1_1.mCmd;
                                                    }
                                                    var9_9 = 0;
                                                    var7_7 = null;
                                                    var10_10 = 1;
                                                    var11_11 = 1.4E-45f;
                                                    if (var8_8 == var10_10) break block19;
                                                    var12_12 = 3;
                                                    if (var8_8 == var12_12) break block20;
                                                    var12_12 = 4;
                                                    if (var8_8 == var12_12) break block21;
                                                    var12_12 = 5;
                                                    if (var8_8 == var12_12) break block22;
                                                    var12_12 = 6;
                                                    if (var8_8 == var12_12) break block20;
                                                    var12_12 = 7;
                                                    if (var8_8 == var12_12) break block19;
                                                    var8_8 = 0;
                                                    var1_1 = null;
                                                    var13_13 = 0.0f;
                                                    var10_10 = 0;
                                                    var14_16 = null;
                                                    var11_11 = 0.0f;
                                                    var12_12 = 0;
                                                    break block23;
                                                }
                                                if (!var4_4) break block24;
                                                var8_8 = (int)var5_5.mHiddenChanged;
                                                if (var8_8 == 0 || (var8_8 = (int)var5_5.mHidden) != 0 || (var8_8 = (int)var5_5.mAdded) == 0) ** GOTO lbl-1000
                                                ** GOTO lbl-1000
                                            }
                                            var8_8 = (int)var5_5.mHidden;
                                            break block25;
                                        }
                                        if (!(var4_4 != false ? (var8_8 = (int)var5_5.mHiddenChanged) != 0 && (var8_8 = (int)var5_5.mAdded) != 0 && (var8_8 = (int)var5_5.mHidden) != 0 : (var8_8 = (int)var5_5.mAdded) != 0 && (var8_8 = (int)var5_5.mHidden) == 0)) break block26;
                                        break block27;
                                    }
                                    if (!var4_4) break block28;
                                    var8_8 = (int)var5_5.mAdded;
                                    if (var8_8 != 0 || (var1_1 = var5_5.mView) == null || (var8_8 = var1_1.getVisibility()) != 0) break block26;
                                    var13_14 = var5_5.mPostponedAlpha;
                                    var12_12 = 0;
                                    cfr_temp_0 = var13_14 - 0.0f;
                                    var8_8 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                    if (var8_8 < 0) break block26;
                                }
lbl57:
                                // 2 sources

                                while (true) {
                                    var8_8 = var10_10;
                                    var13_14 = var11_11;
                                    break block18;
                                    break;
                                }
                            }
lbl62:
                            // 2 sources

                            while (true) {
                                var8_8 = 0;
                                var1_1 = null;
                                var13_14 = 0.0f;
                                break block18;
                                break;
                            }
                        }
                        ** while ((var8_8 = (int)var5_5.mAdded) == 0 || (var8_8 = (int)var5_5.mHidden) != 0)
lbl69:
                        // 1 sources

                        ** while (true)
                    }
                    var12_12 = var8_8;
                    var8_8 = var10_10;
                    var13_14 = var11_11;
                    var10_10 = 0;
                    var14_16 = null;
                    var11_11 = 0.0f;
                    break block23;
                }
                if (var4_4) {
                    var8_8 = (int)var5_5.mIsNewlyAdded;
                } else {
                    var8_8 = (int)var5_5.mAdded;
                    if (var8_8 == 0 && (var8_8 = (int)var5_5.mHidden) == 0) lbl-1000:
                    // 2 sources

                    {
                        var8_8 = var10_10;
                        var13_15 = var11_11;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var8_8 = 0;
                        var1_1 = null;
                        var13_15 = 0.0f;
                    }
                }
            }
            var12_12 = 0;
            var9_9 = var8_8;
            var8_8 = 0;
            var1_1 = null;
            var13_15 = 0.0f;
        }
        var15_17 = (FragmentTransition$FragmentContainerTransition)var2_2.get(var6_6);
        if (var9_9 != 0) {
            var15_17 = FragmentTransition.ensureContainer(var15_17, var2_2, var6_6);
            var15_17.lastIn = var5_5;
            var15_17.lastInIsPop = var3_3;
            var15_17.lastInTransaction = var0;
        }
        var9_9 = 0;
        var7_7 = null;
        if (!var4_4 && var10_10 != 0) {
            if (var15_17 != null && (var14_16 = var15_17.firstOut) == var5_5) {
                var15_17.firstOut = null;
            }
            if ((var10_10 = (int)var0.mReorderingAllowed) == 0) {
                var14_16 = var0.mManager;
                var16_18 = var14_16.createOrGetFragmentStateManager(var5_5);
                var17_19 = var14_16.getFragmentStore();
                var17_19.makeActive(var16_18);
                var14_16.moveToState(var5_5);
            }
        }
        if (var12_12 != 0 && (var15_17 == null || (var14_16 = var15_17.firstOut) == null)) {
            var15_17 = FragmentTransition.ensureContainer(var15_17, var2_2, var6_6);
            var15_17.firstOut = var5_5;
            var15_17.firstOutIsPop = var3_3;
            var15_17.firstOutTransaction = var0;
        }
        if (!var4_4 && var8_8 != 0 && var15_17 != null && (var0 = var15_17.lastIn) == var5_5) {
            var15_17.lastIn = null;
        }
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray sparseArray, boolean bl2) {
        ArrayList arrayList = backStackRecord.mOps;
        int n10 = arrayList.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op)backStackRecord.mOps.get(i10);
            FragmentTransition.addToFirstInLastOut(backStackRecord, fragmentTransaction$Op, sparseArray, false, bl2);
        }
    }

    private static ArrayMap calculateNameOverrides(int n10, ArrayList arrayList, ArrayList arrayList2, int n11, int n12) {
        ArrayMap arrayMap = new ArrayMap();
        n12 += -1;
        while (n12 >= n11) {
            Object object = (BackStackRecord)arrayList.get(n12);
            boolean bl2 = ((BackStackRecord)object).interactsWith(n10);
            if (bl2) {
                Object object2 = (Boolean)arrayList2.get(n12);
                bl2 = (Boolean)object2;
                ArrayList arrayList3 = ((FragmentTransaction)object).mSharedElementSourceNames;
                if (arrayList3 != null) {
                    int n13 = arrayList3.size();
                    if (bl2) {
                        object2 = ((FragmentTransaction)object).mSharedElementSourceNames;
                        object = ((FragmentTransaction)object).mSharedElementTargetNames;
                    } else {
                        object2 = ((FragmentTransaction)object).mSharedElementSourceNames;
                        object = ((FragmentTransaction)object).mSharedElementTargetNames;
                        Serializable serializable = object2;
                        object2 = object;
                        object = serializable;
                    }
                    for (int i10 = 0; i10 < n13; ++i10) {
                        String string2 = (String)((ArrayList)object).get(i10);
                        String string3 = (String)((ArrayList)object2).get(i10);
                        String string4 = (String)arrayMap.remove(string3);
                        if (string4 != null) {
                            arrayMap.put(string2, string4);
                            continue;
                        }
                        arrayMap.put(string2, string3);
                    }
                }
            }
            n12 += -1;
        }
        return arrayMap;
    }

    /*
     * WARNING - void declaration
     */
    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray sparseArray, boolean bl2) {
        Object object = backStackRecord.mManager.getContainer();
        boolean n10 = ((FragmentContainer)object).onHasView();
        if (!n10) {
            return;
        }
        object = backStackRecord.mOps;
        int n11 = ((ArrayList)object).size();
        int n12 = 1;
        int n13 = n11 - n12;
        while ((var4_7 += -1) >= 0) {
            void var4_7;
            FragmentTransaction$Op fragmentTransaction$Op = (FragmentTransaction$Op)backStackRecord.mOps.get((int)var4_7);
            FragmentTransition.addToFirstInLastOut(backStackRecord, fragmentTransaction$Op, sparseArray, n12 != 0, bl2);
        }
    }

    public static void callSharedElementStartEnd(Fragment object, Fragment arrayList, boolean bl2, ArrayMap arrayMap, boolean bl3) {
        object = bl2 ? ((Fragment)((Object)arrayList)).getEnterTransitionCallback() : ((Fragment)object).getEnterTransitionCallback();
        if (object != null) {
            arrayList = new ArrayList<Object>();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            int n10 = arrayMap == null ? 0 : arrayMap.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = arrayMap.keyAt(i10);
                arrayList2.add(object2);
                object2 = arrayMap.valueAt(i10);
                arrayList.add(object2);
            }
            arrayMap = null;
            if (bl3) {
                ((SharedElementCallback)object).onSharedElementStart(arrayList2, arrayList, null);
            } else {
                ((SharedElementCallback)object).onSharedElementEnd(arrayList2, arrayList, null);
            }
        }
    }

    private static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List list) {
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object e10 = list.get(i10);
            boolean bl2 = fragmentTransitionImpl.canHandle(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static ArrayMap captureInSharedElements(FragmentTransitionImpl object, ArrayMap arrayMap, Object object2, FragmentTransition$FragmentContainerTransition object3) {
        Object object4 = ((FragmentTransition$FragmentContainerTransition)object3).lastIn;
        Object object5 = ((Fragment)object4).getView();
        boolean bl2 = arrayMap.isEmpty();
        if (!bl2 && object2 != null && object5 != null) {
            object2 = new ArrayMap();
            ((FragmentTransitionImpl)object).findNamedViews((Map)object2, (View)object5);
            object = ((FragmentTransition$FragmentContainerTransition)object3).lastInTransaction;
            int n10 = ((FragmentTransition$FragmentContainerTransition)object3).lastInIsPop;
            if (n10 != 0) {
                object3 = ((Fragment)object4).getExitTransitionCallback();
                object = ((FragmentTransaction)object).mSharedElementSourceNames;
            } else {
                object3 = ((Fragment)object4).getEnterTransitionCallback();
                object = ((FragmentTransaction)object).mSharedElementTargetNames;
            }
            if (object != null) {
                ((ArrayMap)object2).retainAll((Collection)object);
                object4 = arrayMap.values();
                ((ArrayMap)object2).retainAll((Collection)object4);
            }
            if (object3 != null) {
                ((SharedElementCallback)object3).onMapSharedElements((List)object, (Map)object2);
                for (n10 = ((ArrayList)object).size() + -1; n10 >= 0; n10 += -1) {
                    object4 = (String)((ArrayList)object).get(n10);
                    object5 = (View)((SimpleArrayMap)object2).get(object4);
                    if (object5 == null) {
                        if ((object4 = FragmentTransition.findKeyForValue(arrayMap, (String)object4)) == null) continue;
                        arrayMap.remove(object4);
                        continue;
                    }
                    String string2 = ViewCompat.getTransitionName(object5);
                    bl2 = ((String)object4).equals(string2);
                    if (bl2 || (object4 = FragmentTransition.findKeyForValue(arrayMap, (String)object4)) == null) continue;
                    object5 = ViewCompat.getTransitionName(object5);
                    arrayMap.put(object4, object5);
                }
            } else {
                FragmentTransition.retainValues(arrayMap, (ArrayMap)object2);
            }
            return object2;
        }
        arrayMap.clear();
        return null;
    }

    private static ArrayMap captureOutSharedElements(FragmentTransitionImpl object, ArrayMap arrayMap, Object object2, FragmentTransition$FragmentContainerTransition object3) {
        boolean bl2 = arrayMap.isEmpty();
        if (!bl2 && object2 != null) {
            object2 = ((FragmentTransition$FragmentContainerTransition)object3).firstOut;
            ArrayMap arrayMap2 = new ArrayMap();
            Object object4 = ((Fragment)object2).requireView();
            ((FragmentTransitionImpl)object).findNamedViews(arrayMap2, (View)object4);
            object = ((FragmentTransition$FragmentContainerTransition)object3).firstOutTransaction;
            boolean bl3 = ((FragmentTransition$FragmentContainerTransition)object3).firstOutIsPop;
            if (bl3) {
                object2 = ((Fragment)object2).getEnterTransitionCallback();
                object = ((FragmentTransaction)object).mSharedElementTargetNames;
            } else {
                object2 = ((Fragment)object2).getExitTransitionCallback();
                object = ((FragmentTransaction)object).mSharedElementSourceNames;
            }
            if (object != null) {
                arrayMap2.retainAll((Collection)object);
            }
            if (object2 != null) {
                ((SharedElementCallback)object2).onMapSharedElements((List)object, arrayMap2);
                for (int i10 = ((ArrayList)object).size() + -1; i10 >= 0; i10 += -1) {
                    object3 = (String)((ArrayList)object).get(i10);
                    object4 = (View)arrayMap2.get(object3);
                    if (object4 == null) {
                        arrayMap.remove(object3);
                        continue;
                    }
                    String string2 = ViewCompat.getTransitionName(object4);
                    boolean bl4 = ((String)object3).equals(string2);
                    if (bl4) continue;
                    object3 = (String)arrayMap.remove(object3);
                    object4 = ViewCompat.getTransitionName(object4);
                    arrayMap.put(object4, object3);
                }
            } else {
                object = arrayMap2.keySet();
                arrayMap.retainAll((Collection)object);
            }
            return arrayMap2;
        }
        arrayMap.clear();
        return null;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment object, Fragment fragment) {
        boolean bl2;
        boolean bl3;
        Object object2;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object != null) {
            object2 = ((Fragment)object).getExitTransition();
            if (object2 != null) {
                arrayList.add(object2);
            }
            if ((object2 = ((Fragment)object).getReturnTransition()) != null) {
                arrayList.add(object2);
            }
            if ((object = ((Fragment)object).getSharedElementReturnTransition()) != null) {
                arrayList.add(object);
            }
        }
        if (fragment != null) {
            object = fragment.getEnterTransition();
            if (object != null) {
                arrayList.add(object);
            }
            if ((object = fragment.getReenterTransition()) != null) {
                arrayList.add(object);
            }
            if ((object = fragment.getSharedElementEnterTransition()) != null) {
                arrayList.add(object);
            }
        }
        boolean bl4 = arrayList.isEmpty();
        fragment = null;
        if (bl4) {
            return null;
        }
        object = PLATFORM_IMPL;
        if (object != null && (bl3 = FragmentTransition.canHandleAll((FragmentTransitionImpl)object, arrayList))) {
            return object;
        }
        object2 = SUPPORT_IMPL;
        if (object2 != null && (bl2 = FragmentTransition.canHandleAll((FragmentTransitionImpl)object2, arrayList))) {
            return object2;
        }
        if (object == null && object2 == null) {
            return null;
        }
        object = new IllegalArgumentException("Invalid Transition types");
        throw object;
    }

    public static ArrayList configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object object, Fragment fragment, ArrayList arrayList, View view) {
        ArrayList<View> arrayList2;
        if (object != null) {
            boolean bl2;
            arrayList2 = new ArrayList<View>();
            if ((fragment = fragment.getView()) != null) {
                fragmentTransitionImpl.captureTransitioningViews(arrayList2, (View)fragment);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            if (!(bl2 = arrayList2.isEmpty())) {
                arrayList2.add(view);
                fragmentTransitionImpl.addTargets(object, arrayList2);
            }
        } else {
            arrayList2 = null;
        }
        return arrayList2;
    }

    private static Object configureSharedElementsOrdered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap arrayMap, FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, ArrayList arrayList, ArrayList arrayList2, Object object, Object object2) {
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        Object object3 = fragmentTransition$FragmentContainerTransition;
        ArrayList arrayList3 = arrayList;
        Object object4 = object;
        Fragment fragment = fragmentTransition$FragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentTransition$FragmentContainerTransition.firstOut;
        Object object5 = null;
        if (fragment != null && fragment2 != null) {
            Object object6;
            Rect rect;
            Object object7;
            Object object8;
            Object object9;
            Object object10;
            boolean bl2 = fragmentTransition$FragmentContainerTransition.lastInIsPop;
            boolean bl3 = arrayMap.isEmpty();
            if (bl3) {
                object10 = arrayMap;
                bl3 = false;
                object9 = null;
            } else {
                object9 = FragmentTransition.getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, bl2);
                object10 = arrayMap;
            }
            Object object11 = FragmentTransition.captureOutSharedElements(fragmentTransitionImpl2, (ArrayMap)object10, object9, (FragmentTransition$FragmentContainerTransition)object3);
            boolean bl4 = arrayMap.isEmpty();
            if (bl4) {
                object8 = null;
            } else {
                object7 = ((ArrayMap)object11).values();
                arrayList3.addAll(object7);
                object8 = object9;
            }
            if (object4 == null && object2 == null && object8 == null) {
                return null;
            }
            bl3 = true;
            FragmentTransition.callSharedElementStartEnd(fragment, fragment2, bl2, (ArrayMap)object11, bl3);
            if (object8 != null) {
                rect = new Rect();
                object6 = view;
                fragmentTransitionImpl2.setSharedElementTargets(object8, view, arrayList3);
                boolean bl5 = ((FragmentTransition$FragmentContainerTransition)object3).firstOutIsPop;
                object7 = ((FragmentTransition$FragmentContainerTransition)object3).firstOutTransaction;
                object5 = fragmentTransitionImpl;
                object9 = object8;
                Object object12 = object7;
                object7 = object2;
                object6 = object12;
                FragmentTransition.setOutEpicenter(fragmentTransitionImpl, object8, object2, (ArrayMap)object11, bl5, (BackStackRecord)object12);
                if (object4 != null) {
                    fragmentTransitionImpl2.setEpicenter(object4, rect);
                }
            } else {
                rect = null;
            }
            object5 = object6;
            object9 = fragmentTransitionImpl;
            object7 = arrayMap;
            object11 = object8;
            object10 = object6;
            object6 = arrayList2;
            fragmentTransitionImpl2 = view;
            object3 = fragment;
            fragment = fragment2;
            arrayList3 = arrayList;
            object4 = object;
            ((FragmentTransition$6)object5)(fragmentTransitionImpl, arrayMap, object8, fragmentTransition$FragmentContainerTransition, arrayList2, view, (Fragment)object3, fragment2, bl2, arrayList, object, rect);
            object5 = viewGroup;
            OneShotPreDrawListener.add((View)viewGroup, (Runnable)object10);
            return object8;
        }
        return null;
    }

    private static Object configureSharedElementsReordered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap arrayMap, FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, ArrayList arrayList, ArrayList arrayList2, Object object, Object object2) {
        Object object3;
        boolean bl2;
        Object object4;
        Object object5 = view;
        Object object6 = arrayMap;
        FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition2 = fragmentTransition$FragmentContainerTransition;
        Object object7 = arrayList;
        Object object8 = arrayList2;
        Object object9 = object;
        Fragment fragment = fragmentTransition$FragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentTransition$FragmentContainerTransition.firstOut;
        if (fragment != null) {
            object4 = fragment.requireView();
            bl2 = false;
            object3 = null;
            object4.setVisibility(0);
        }
        boolean bl3 = false;
        object4 = null;
        if (fragment != null && fragment2 != null) {
            Object object10;
            boolean bl4 = fragmentTransition$FragmentContainerTransition2.lastInIsPop;
            bl2 = arrayMap.isEmpty();
            if (bl2) {
                bl2 = false;
                object3 = null;
            } else {
                object3 = FragmentTransition.getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, bl4);
            }
            ArrayMap arrayMap2 = FragmentTransition.captureOutSharedElements(fragmentTransitionImpl, (ArrayMap)object6, object3, fragmentTransition$FragmentContainerTransition2);
            ArrayMap arrayMap3 = FragmentTransition.captureInSharedElements(fragmentTransitionImpl, (ArrayMap)object6, object3, fragmentTransition$FragmentContainerTransition2);
            boolean bl5 = arrayMap.isEmpty();
            if (bl5) {
                if (arrayMap2 != null) {
                    arrayMap2.clear();
                }
                if (arrayMap3 != null) {
                    arrayMap3.clear();
                }
                bl5 = false;
                object10 = null;
            } else {
                object10 = arrayMap.keySet();
                FragmentTransition.addSharedElementsWithMatchingNames((ArrayList)object7, arrayMap2, (Collection)object10);
                object6 = arrayMap.values();
                FragmentTransition.addSharedElementsWithMatchingNames((ArrayList)object8, arrayMap3, (Collection)object6);
                object10 = object3;
            }
            if (object9 == null && object2 == null && object10 == null) {
                return null;
            }
            boolean bl6 = true;
            FragmentTransition.callSharedElementStartEnd(fragment, fragment2, bl4, arrayMap2, bl6);
            if (object10 != null) {
                ((ArrayList)object8).add(object5);
                fragmentTransitionImpl.setSharedElementTargets(object10, (View)object5, (ArrayList)object7);
                bl3 = fragmentTransition$FragmentContainerTransition2.firstOutIsPop;
                object3 = fragmentTransition$FragmentContainerTransition2.firstOutTransaction;
                object5 = fragmentTransitionImpl;
                object6 = object10;
                object7 = object2;
                object8 = arrayMap2;
                FragmentTransition.setOutEpicenter(fragmentTransitionImpl, object10, object2, arrayMap2, bl3, (BackStackRecord)object3);
                object5 = new Rect();
                object6 = FragmentTransition.getInEpicenterView(arrayMap3, fragmentTransition$FragmentContainerTransition2, object9, bl4);
                if (object6 != null) {
                    fragmentTransitionImpl.setEpicenter(object9, (Rect)object5);
                }
                fragmentTransition$FragmentContainerTransition2 = object5;
                object3 = object6;
            } else {
                bl2 = false;
                object3 = null;
                fragmentTransition$FragmentContainerTransition2 = null;
            }
            object5 = object9;
            object6 = fragment;
            object7 = fragment2;
            object4 = arrayMap3;
            object9 = new FragmentTransition$5(fragment, fragment2, bl4, arrayMap3, (View)object3, fragmentTransitionImpl, (Rect)fragmentTransition$FragmentContainerTransition2);
            object5 = viewGroup;
            OneShotPreDrawListener.add((View)viewGroup, (Runnable)object9);
            return object10;
        }
        return null;
    }

    private static void configureTransitionsOrdered(ViewGroup viewGroup, FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, View view, ArrayMap arrayMap, FragmentTransition$Callback fragmentTransition$Callback) {
        Object object = viewGroup;
        Object object2 = fragmentTransition$FragmentContainerTransition;
        View view2 = view;
        ArrayMap arrayMap2 = arrayMap;
        ArrayList arrayList = fragmentTransition$Callback;
        Fragment fragment = fragmentTransition$FragmentContainerTransition.firstOut;
        Fragment fragment2 = fragmentTransition$FragmentContainerTransition.lastIn;
        Object object3 = FragmentTransition.chooseImpl(fragment, fragment2);
        if (object3 == null) {
            return;
        }
        int n10 = fragmentTransition$FragmentContainerTransition.lastInIsPop;
        boolean bl2 = fragmentTransition$FragmentContainerTransition.firstOutIsPop;
        ArrayList arrayList2 = FragmentTransition.getEnterTransition((FragmentTransitionImpl)object3, fragment2, n10 != 0);
        ArrayList arrayList3 = FragmentTransition.getExitTransition((FragmentTransitionImpl)object3, fragment, bl2);
        Object object4 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Object object5 = object3;
        Object object6 = viewGroup;
        ArrayList arrayList5 = arrayList4;
        arrayList4 = fragmentTransition$FragmentContainerTransition;
        ArrayList arrayList6 = object4;
        ArrayList arrayList7 = arrayList3;
        arrayList3 = arrayList5;
        object = object3;
        object3 = arrayList7;
        arrayList3 = FragmentTransition.configureSharedElementsOrdered((FragmentTransitionImpl)object5, viewGroup, view, arrayMap, fragmentTransition$FragmentContainerTransition, object4, arrayList5, arrayList2, arrayList7);
        object3 = arrayList2;
        if (arrayList2 == null && arrayList3 == null) {
            object5 = arrayList7;
            if (arrayList7 == null) {
                return;
            }
        } else {
            object5 = arrayList7;
        }
        arrayList2 = arrayList6;
        if ((arrayList6 = FragmentTransition.configureEnteringExitingViews((FragmentTransitionImpl)object, object5, fragment, arrayList6, view2)) == null || (bl2 = arrayList6.isEmpty())) {
            n10 = 0;
            object5 = null;
        }
        arrayList7 = object5;
        ((FragmentTransitionImpl)object).addTarget(object3, view2);
        boolean bl3 = ((FragmentTransition$FragmentContainerTransition)object2).lastInIsPop;
        object5 = object;
        object6 = object3;
        arrayList4 = fragment2;
        object2 = FragmentTransition.mergeTransitions((FragmentTransitionImpl)object, object3, arrayList7, arrayList3, fragment2, bl3);
        if (fragment != null && arrayList6 != null && ((n10 = arrayList6.size()) > 0 || (n10 = arrayList2.size()) > 0)) {
            object5 = new CancellationSignal();
            arrayList.onStart(fragment, (CancellationSignal)object5);
            object6 = new FragmentTransition$3((FragmentTransition$Callback)((Object)arrayList), fragment, (CancellationSignal)object5);
            ((FragmentTransitionImpl)object).setListenerForTransitionEnd(fragment, object2, (CancellationSignal)object5, (Runnable)object6);
        }
        if (object2 != null) {
            arrayList = new ArrayList();
            object5 = object;
            object6 = object2;
            arrayList4 = arrayList7;
            object4 = arrayList6;
            arrayList2 = arrayList5;
            ((FragmentTransitionImpl)object).scheduleRemoveTargets(object2, object3, arrayList, arrayList7, arrayList6, arrayList3, arrayList5);
            object6 = viewGroup;
            arrayList4 = arrayList5;
            object4 = object3;
            arrayList3 = arrayList;
            arrayList2 = arrayList7;
            object3 = arrayList6;
            FragmentTransition.scheduleTargetChange((FragmentTransitionImpl)object, viewGroup, fragment2, view, arrayList5, object4, arrayList, arrayList7, arrayList6);
            object5 = viewGroup;
            object6 = object;
            ((FragmentTransitionImpl)object).setNameOverridesOrdered((View)viewGroup, arrayList5, arrayMap2);
            ((FragmentTransitionImpl)object).beginDelayedTransition(viewGroup, object2);
            ((FragmentTransitionImpl)object).scheduleNameReset(viewGroup, arrayList5, arrayMap2);
        }
    }

    private static void configureTransitionsReordered(ViewGroup viewGroup, FragmentTransition$FragmentContainerTransition object, View view, ArrayMap arrayMap, FragmentTransition$Callback fragmentTransition$Callback) {
        Object object2 = object;
        Object object3 = view;
        Object object4 = fragmentTransition$Callback;
        Object object5 = ((FragmentTransition$FragmentContainerTransition)object).firstOut;
        Object object6 = ((FragmentTransition$FragmentContainerTransition)object).lastIn;
        FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.chooseImpl((Fragment)object5, (Fragment)object6);
        if (fragmentTransitionImpl == null) {
            return;
        }
        boolean bl2 = ((FragmentTransition$FragmentContainerTransition)object).lastInIsPop;
        int n10 = ((FragmentTransition$FragmentContainerTransition)object).firstOutIsPop;
        ArrayList arrayList = new ArrayList();
        Object object7 = new ArrayList();
        ArrayList arrayList2 = FragmentTransition.getEnterTransition(fragmentTransitionImpl, (Fragment)object6, bl2);
        Object object8 = FragmentTransition.getExitTransition(fragmentTransitionImpl, (Fragment)object5, n10 != 0);
        Object object9 = fragmentTransitionImpl;
        Object object10 = view;
        Object object11 = object7;
        object = object8;
        object8 = arrayList;
        object4 = object7;
        object7 = object;
        object7 = FragmentTransition.configureSharedElementsReordered(fragmentTransitionImpl, viewGroup, view, arrayMap, (FragmentTransition$FragmentContainerTransition)object2, object11, arrayList, arrayList2, object);
        object8 = arrayList2;
        if (arrayList2 == null && object7 == null) {
            arrayList2 = object;
            if (object == null) {
                return;
            }
        } else {
            arrayList2 = object;
        }
        object11 = FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl, arrayList2, (Fragment)object5, (ArrayList)object4, object3);
        object3 = FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl, object8, (Fragment)object6, arrayList, object3);
        n10 = 4;
        FragmentTransition.setViewVisibility((ArrayList)object3, n10);
        object9 = fragmentTransitionImpl;
        object10 = arrayList2;
        object2 = object6;
        object6 = object11;
        Object object12 = FragmentTransition.mergeTransitions(fragmentTransitionImpl, object8, arrayList2, object7, (Fragment)object2, bl2);
        if (object5 != null && object11 != null && ((n10 = ((ArrayList)object11).size()) > 0 || (n10 = ((ArrayList)object4).size()) > 0)) {
            object9 = new CancellationSignal();
            fragmentTransition$Callback.onStart((Fragment)object5, (CancellationSignal)object9);
            object10 = new FragmentTransition$1(fragmentTransition$Callback, (Fragment)object5, (CancellationSignal)object9);
            fragmentTransitionImpl.setListenerForTransitionEnd((Fragment)object5, object12, (CancellationSignal)object9, (Runnable)object10);
        }
        if (object12 != null) {
            FragmentTransition.replaceHide(fragmentTransitionImpl, arrayList2, (Fragment)object5, (ArrayList)object6);
            object5 = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList);
            object9 = fragmentTransitionImpl;
            object10 = object8;
            object2 = arrayList2;
            object11 = object6;
            object8 = object7;
            arrayList2 = arrayList;
            fragmentTransitionImpl.scheduleRemoveTargets(object12, object10, (ArrayList)object3, object2, (ArrayList)object6, object7, arrayList);
            fragmentTransitionImpl.beginDelayedTransition(viewGroup, object12);
            object10 = object4;
            object2 = object5;
            object11 = arrayMap;
            fragmentTransitionImpl.setNameOverridesReordered((View)viewGroup, (ArrayList)object4, arrayList, (ArrayList)object5, arrayMap);
            n10 = 0;
            object9 = null;
            FragmentTransition.setViewVisibility((ArrayList)object3, 0);
            fragmentTransitionImpl.swapSharedElementTargets(object7, (ArrayList)object4, arrayList);
        }
    }

    private static FragmentTransition$FragmentContainerTransition ensureContainer(FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition, SparseArray sparseArray, int n10) {
        if (fragmentTransition$FragmentContainerTransition == null) {
            fragmentTransition$FragmentContainerTransition = new FragmentTransition$FragmentContainerTransition();
            sparseArray.put(n10, (Object)fragmentTransition$FragmentContainerTransition);
        }
        return fragmentTransition$FragmentContainerTransition;
    }

    public static String findKeyForValue(ArrayMap arrayMap, String string2) {
        int n10 = arrayMap.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = arrayMap.valueAt(i10);
            boolean bl2 = string2.equals(object);
            if (!bl2) continue;
            return (String)arrayMap.keyAt(i10);
        }
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment object, boolean bl2) {
        if (object == null) {
            return null;
        }
        object = bl2 ? ((Fragment)object).getReenterTransition() : ((Fragment)object).getEnterTransition();
        return fragmentTransitionImpl.cloneTransition(object);
    }

    private static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment object, boolean bl2) {
        if (object == null) {
            return null;
        }
        object = bl2 ? ((Fragment)object).getReturnTransition() : ((Fragment)object).getExitTransition();
        return fragmentTransitionImpl.cloneTransition(object);
    }

    public static View getInEpicenterView(ArrayMap arrayMap, FragmentTransition$FragmentContainerTransition object, Object object2, boolean bl2) {
        boolean bl3;
        object = ((FragmentTransition$FragmentContainerTransition)object).lastInTransaction;
        if (object2 != null && arrayMap != null && (object2 = ((FragmentTransaction)object).mSharedElementSourceNames) != null && !(bl3 = ((ArrayList)object2).isEmpty())) {
            bl3 = false;
            object2 = null;
            object = bl2 ? (String)((FragmentTransaction)object).mSharedElementSourceNames.get(0) : (String)((FragmentTransaction)object).mSharedElementTargetNames.get(0);
            return (View)arrayMap.get(object);
        }
        return null;
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment object, Fragment fragment, boolean bl2) {
        if (object != null && fragment != null) {
            object = bl2 ? fragment.getSharedElementReturnTransition() : ((Fragment)object).getSharedElementEnterTransition();
            object = fragmentTransitionImpl.cloneTransition(object);
            return fragmentTransitionImpl.wrapTransitionInSet(object);
        }
        return null;
    }

    private static Object mergeTransitions(FragmentTransitionImpl object, Object object2, Object object3, Object object4, Fragment fragment, boolean bl2) {
        boolean bl3 = object2 != null && object3 != null && fragment != null ? (bl2 ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap()) : true;
        object = bl3 ? ((FragmentTransitionImpl)object).mergeTransitionsTogether(object3, object2, object4) : ((FragmentTransitionImpl)object).mergeTransitionsInSequence(object3, object2, object4);
        return object;
    }

    private static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object object, Fragment fragment, ArrayList arrayList) {
        boolean bl2;
        if (fragment != null && object != null && (bl2 = fragment.mAdded) && (bl2 = fragment.mHidden) && (bl2 = fragment.mHiddenChanged)) {
            bl2 = true;
            fragment.setHideReplaced(bl2);
            View view = fragment.getView();
            fragmentTransitionImpl.scheduleHideFragmentView(object, view, arrayList);
            fragmentTransitionImpl = fragment.mContainer;
            object = new FragmentTransition$2(arrayList);
            OneShotPreDrawListener.add((View)fragmentTransitionImpl, (Runnable)object);
        }
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        Object[] objectArray;
        Constructor constructor = "androidx.transition.FragmentTransitionSupport";
        try {
            constructor = Class.forName((String)((Object)constructor));
            objectArray = null;
        }
        catch (Exception exception) {
            return null;
        }
        Class[] classArray = new Class[]{};
        constructor = ((Class)((Object)constructor)).getDeclaredConstructor(classArray);
        objectArray = new Object[]{};
        constructor = constructor.newInstance(objectArray);
        return (FragmentTransitionImpl)((Object)constructor);
    }

    public static void retainValues(ArrayMap arrayMap, ArrayMap arrayMap2) {
        for (int i10 = arrayMap.size() + -1; i10 >= 0; i10 += -1) {
            String string2 = (String)arrayMap.valueAt(i10);
            boolean bl2 = arrayMap2.containsKey(string2);
            if (bl2) continue;
            arrayMap.removeAt(i10);
        }
    }

    private static void scheduleTargetChange(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList arrayList, Object object, ArrayList arrayList2, Object object2, ArrayList arrayList3) {
        FragmentTransition$4 fragmentTransition$4 = new FragmentTransition$4(object, fragmentTransitionImpl, view, fragment, arrayList, arrayList2, arrayList3, object2);
        OneShotPreDrawListener.add((View)viewGroup, fragmentTransition$4);
    }

    private static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object object, Object object2, ArrayMap arrayMap, boolean bl2, BackStackRecord backStackRecord) {
        boolean bl3;
        ArrayList arrayList = backStackRecord.mSharedElementSourceNames;
        if (arrayList != null && !(bl3 = arrayList.isEmpty())) {
            bl3 = false;
            arrayList = null;
            String string2 = bl2 ? (String)backStackRecord.mSharedElementTargetNames.get(0) : (String)backStackRecord.mSharedElementSourceNames.get(0);
            arrayMap = (View)arrayMap.get(string2);
            fragmentTransitionImpl.setEpicenter(object, (View)arrayMap);
            if (object2 != null) {
                fragmentTransitionImpl.setEpicenter(object2, (View)arrayMap);
            }
        }
    }

    public static void setViewVisibility(ArrayList arrayList, int n10) {
        if (arrayList == null) {
            return;
        }
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            View view = (View)arrayList.get(i10);
            view.setVisibility(n10);
        }
    }

    public static void startTransitions(Context context, FragmentContainer fragmentContainer, ArrayList arrayList, ArrayList arrayList2, int n10, int n11, boolean bl2, FragmentTransition$Callback fragmentTransition$Callback) {
        int n12;
        Boolean bl3;
        BackStackRecord backStackRecord;
        int n13;
        SparseArray sparseArray = new SparseArray();
        for (n13 = n10; n13 < n11; ++n13) {
            backStackRecord = (BackStackRecord)arrayList.get(n13);
            bl3 = (Boolean)arrayList2.get(n13);
            n12 = bl3.booleanValue();
            if (n12 != 0) {
                FragmentTransition.calculatePopFragments(backStackRecord, sparseArray, bl2);
                continue;
            }
            FragmentTransition.calculateFragments(backStackRecord, sparseArray, bl2);
        }
        n13 = sparseArray.size();
        if (n13 != 0) {
            View view = new View(context);
            int n14 = sparseArray.size();
            backStackRecord = null;
            for (int i10 = 0; i10 < n14; ++i10) {
                n12 = sparseArray.keyAt(i10);
                ArrayMap arrayMap = FragmentTransition.calculateNameOverrides(n12, arrayList, arrayList2, n10, n11);
                FragmentTransition$FragmentContainerTransition fragmentTransition$FragmentContainerTransition = (FragmentTransition$FragmentContainerTransition)sparseArray.valueAt(i10);
                boolean bl4 = fragmentContainer.onHasView();
                if (!bl4 || (bl3 = (ViewGroup)fragmentContainer.onFindViewById(n12)) == null) continue;
                if (bl2) {
                    FragmentTransition.configureTransitionsReordered((ViewGroup)bl3, fragmentTransition$FragmentContainerTransition, view, arrayMap, fragmentTransition$Callback);
                    continue;
                }
                FragmentTransition.configureTransitionsOrdered((ViewGroup)bl3, fragmentTransition$FragmentContainerTransition, view, arrayMap, fragmentTransition$Callback);
            }
        }
    }

    public static boolean supportsTransition() {
        boolean bl2;
        FragmentTransitionImpl fragmentTransitionImpl = PLATFORM_IMPL;
        if (fragmentTransitionImpl == null && (fragmentTransitionImpl = SUPPORT_IMPL) == null) {
            bl2 = false;
            fragmentTransitionImpl = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

