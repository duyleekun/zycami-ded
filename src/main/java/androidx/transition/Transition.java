/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.InflateException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AnimationUtils
 *  android.widget.ListView
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.AnimatorUtils;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import androidx.transition.Transition$1;
import androidx.transition.Transition$2;
import androidx.transition.Transition$3;
import androidx.transition.Transition$AnimationInfo;
import androidx.transition.Transition$ArrayListManager;
import androidx.transition.Transition$EpicenterCallback;
import androidx.transition.Transition$TransitionListener;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionSet;
import androidx.transition.TransitionValues;
import androidx.transition.TransitionValuesMaps;
import androidx.transition.ViewUtils;
import androidx.transition.WindowIdImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition
implements Cloneable {
    public static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION;
    private static ThreadLocal sRunningAnimators;
    private ArrayList mAnimators;
    public boolean mCanRemoveViews;
    public ArrayList mCurrentAnimators;
    public long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList mEndValuesList;
    private boolean mEnded;
    private Transition$EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList mListeners;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap mNameOverrides;
    private int mNumInstances;
    public TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    public TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot;
    private long mStartDelay;
    private TransitionValuesMaps mStartValues;
    private ArrayList mStartValuesList;
    private ArrayList mTargetChildExcludes;
    private ArrayList mTargetExcludes;
    private ArrayList mTargetIdChildExcludes;
    private ArrayList mTargetIdExcludes;
    public ArrayList mTargetIds;
    private ArrayList mTargetNameExcludes;
    private ArrayList mTargetNames;
    private ArrayList mTargetTypeChildExcludes;
    private ArrayList mTargetTypeExcludes;
    private ArrayList mTargetTypes;
    public ArrayList mTargets;

    static {
        Object object;
        int[] nArray = object = new int[4];
        int[] nArray2 = object;
        nArray[0] = 2;
        nArray2[1] = 1;
        nArray[2] = 3;
        nArray2[3] = 4;
        DEFAULT_MATCH_ORDER = object;
        object = new Transition$1;
        object();
        STRAIGHT_PATH_MOTION = object;
        object = new ThreadLocal;
        object();
        sRunningAnimators = object;
    }

    public Transition() {
        ArrayList arrayList;
        long l10;
        Object object = this.getClass().getName();
        this.mName = object;
        this.mStartDelay = l10 = (long)-1;
        this.mDuration = l10;
        this.mInterpolator = null;
        Object object2 = new ArrayList();
        this.mTargetIds = object2;
        object2 = new ArrayList();
        this.mTargets = object2;
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = object2 = new TransitionValuesMaps();
        this.mEndValues = object2 = new TransitionValuesMaps();
        this.mParent = null;
        object2 = DEFAULT_MATCH_ORDER;
        this.mMatchOrder = (int[])object2;
        this.mSceneRoot = null;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = arrayList = new ArrayList();
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        object = new ArrayList();
        this.mAnimators = object;
        this.mPathMotion = object = STRAIGHT_PATH_MOTION;
    }

    public Transition(Context object, AttributeSet attributeSet) {
        int n10;
        String string2;
        long l10;
        long l11;
        Object object2 = this.getClass().getName();
        this.mName = object2;
        this.mStartDelay = l11 = (long)-1;
        this.mDuration = l11;
        this.mInterpolator = null;
        Object object3 = new ArrayList();
        this.mTargetIds = object3;
        object3 = new ArrayList();
        this.mTargets = object3;
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = object3 = new TransitionValuesMaps();
        this.mEndValues = object3 = new TransitionValuesMaps();
        this.mParent = null;
        object3 = DEFAULT_MATCH_ORDER;
        this.mMatchOrder = (int[])object3;
        this.mSceneRoot = null;
        int n11 = 0;
        object3 = null;
        this.mCanRemoveViews = false;
        Object object4 = new ArrayList();
        this.mCurrentAnimators = object4;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mListeners = null;
        object2 = new ArrayList();
        this.mAnimators = object2;
        this.mPathMotion = object2 = STRAIGHT_PATH_MOTION;
        object2 = Styleable.TRANSITION;
        object2 = object.obtainStyledAttributes(attributeSet, (int[])object2);
        attributeSet = (XmlResourceParser)attributeSet;
        object4 = "duration";
        int n12 = 1;
        int n13 = -1;
        int n14 = TypedArrayUtils.getNamedInt((TypedArray)object2, (XmlPullParser)attributeSet, (String)object4, n12, n13);
        long l12 = n14;
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (l14 >= 0) {
            this.setDuration(l12);
        }
        if ((n13 = (int)((l10 = (l12 = (long)(n14 = TypedArrayUtils.getNamedInt((TypedArray)object2, (XmlPullParser)attributeSet, string2 = "startDelay", 2, n13))) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1))) > 0) {
            this.setStartDelay(l12);
        }
        if ((n11 = TypedArrayUtils.getNamedResourceId((TypedArray)object2, (XmlPullParser)attributeSet, (String)(object4 = "interpolator"), 0, 0)) > 0) {
            object = AnimationUtils.loadInterpolator((Context)object, (int)n11);
            this.setInterpolator((TimeInterpolator)object);
        }
        if ((object = TypedArrayUtils.getNamedString((TypedArray)object2, (XmlPullParser)attributeSet, (String)(object3 = "matchOrder"), n10 = 3)) != null) {
            object = Transition.parseMatchOrder((String)object);
            this.setMatchOrder((int[])object);
        }
        object2.recycle();
    }

    private void addUnmatched(ArrayMap object, ArrayMap arrayMap) {
        int n10;
        int n11;
        int n12;
        int n13 = 0;
        Object object2 = null;
        for (n12 = 0; n12 < (n11 = ((SimpleArrayMap)object).size()); ++n12) {
            Object object3 = (TransitionValues)((SimpleArrayMap)object).valueAt(n12);
            Object object4 = ((TransitionValues)object3).view;
            boolean bl2 = this.isValidTarget((View)object4);
            if (!bl2) continue;
            object4 = this.mStartValuesList;
            ((ArrayList)object4).add(object3);
            object3 = this.mEndValuesList;
            ((ArrayList)object3).add(null);
        }
        while (n13 < (n10 = arrayMap.size())) {
            object = (TransitionValues)arrayMap.valueAt(n13);
            object2 = ((TransitionValues)object).view;
            n12 = (int)(this.isValidTarget((View)object2) ? 1 : 0);
            if (n12 != 0) {
                object2 = this.mEndValuesList;
                ((ArrayList)object2).add(object);
                object = this.mStartValuesList;
                ((ArrayList)object).add(null);
            }
            ++n13;
        }
    }

    private static void addViewValues(TransitionValuesMaps object, View view, TransitionValues object2) {
        boolean bl2;
        int n10;
        Object object3;
        ((TransitionValuesMaps)object).mViewValues.put(view, object2);
        int bl22 = view.getId();
        if (bl22 >= 0) {
            object3 = ((TransitionValuesMaps)object).mIdValues;
            n10 = object3.indexOfKey(bl22);
            if (n10 >= 0) {
                object3 = ((TransitionValuesMaps)object).mIdValues;
                object3.put(bl22, null);
            } else {
                object3 = ((TransitionValuesMaps)object).mIdValues;
                object3.put(bl22, (Object)view);
            }
        }
        if ((object2 = ViewCompat.getTransitionName(view)) != null) {
            object3 = ((TransitionValuesMaps)object).mNameValues;
            n10 = (int)(((SimpleArrayMap)object3).containsKey(object2) ? 1 : 0);
            if (n10 != 0) {
                object3 = ((TransitionValuesMaps)object).mNameValues;
                ((SimpleArrayMap)object3).put(object2, null);
            } else {
                object3 = ((TransitionValuesMaps)object).mNameValues;
                ((SimpleArrayMap)object3).put(object2, view);
            }
        }
        if ((bl2 = (object2 = view.getParent()) instanceof ListView) && (n10 = (int)((object3 = (object2 = (ListView)view.getParent()).getAdapter()).hasStableIds() ? 1 : 0)) != 0) {
            object2 = ((TransitionValuesMaps)object).mItemIdValues;
            n10 = object2.getPositionForView(view);
            long l10 = object2.getItemIdAtPosition(n10);
            int n11 = ((LongSparseArray)object2).indexOfKey(l10);
            if (n11 >= 0) {
                view = (View)((TransitionValuesMaps)object).mItemIdValues.get(l10);
                if (view != null) {
                    boolean bl3 = false;
                    object2 = null;
                    ViewCompat.setHasTransientState(view, false);
                    object = ((TransitionValuesMaps)object).mItemIdValues;
                    ((LongSparseArray)object).put(l10, null);
                }
            } else {
                boolean bl4 = true;
                ViewCompat.setHasTransientState(view, bl4);
                object = ((TransitionValuesMaps)object).mItemIdValues;
                ((LongSparseArray)object).put(l10, view);
            }
        }
    }

    private static boolean alreadyContains(int[] nArray, int n10) {
        int n11 = nArray[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            if (n12 != n11) continue;
            return true;
        }
        return false;
    }

    private void captureHierarchy(View view, boolean bl2) {
        int n10;
        Object object;
        Integer n11;
        int n12;
        if (view == null) {
            return;
        }
        int n13 = view.getId();
        Object object2 = this.mTargetIdExcludes;
        if (object2 != null && (n12 = ((ArrayList)object2).contains(n11 = Integer.valueOf(n13))) != 0) {
            return;
        }
        object2 = this.mTargetExcludes;
        if (object2 != null && (n12 = ((ArrayList)object2).contains(view)) != 0) {
            return;
        }
        object2 = this.mTargetTypeExcludes;
        int n14 = 0;
        n11 = null;
        if (object2 != null) {
            n12 = ((ArrayList)object2).size();
            object = null;
            for (n10 = 0; n10 < n12; ++n10) {
                Class clazz = (Class)this.mTargetTypeExcludes.get(n10);
                boolean bl3 = clazz.isInstance(view);
                if (!bl3) continue;
                return;
            }
        }
        if ((n12 = (object2 = view.getParent()) instanceof ViewGroup) != 0) {
            object2 = new TransitionValues(view);
            if (bl2) {
                this.captureStartValues((TransitionValues)object2);
            } else {
                this.captureEndValues((TransitionValues)object2);
            }
            object = ((TransitionValues)object2).mTargetedTransitions;
            ((ArrayList)object).add(this);
            this.capturePropagationValues((TransitionValues)object2);
            if (bl2) {
                object = this.mStartValues;
                Transition.addViewValues((TransitionValuesMaps)object, view, (TransitionValues)object2);
            } else {
                object = this.mEndValues;
                Transition.addViewValues((TransitionValuesMaps)object, view, (TransitionValues)object2);
            }
        }
        if ((n12 = view instanceof ViewGroup) != 0) {
            Serializable serializable;
            object2 = this.mTargetIdChildExcludes;
            if (object2 != null && (n13 = (int)(((ArrayList)object2).contains(serializable = Integer.valueOf(n13)) ? 1 : 0)) != 0) {
                return;
            }
            serializable = this.mTargetChildExcludes;
            if (serializable != null && (n13 = (int)(((ArrayList)serializable).contains(view) ? 1 : 0)) != 0) {
                return;
            }
            serializable = this.mTargetTypeChildExcludes;
            if (serializable != null) {
                n13 = ((ArrayList)serializable).size();
                object2 = null;
                for (n12 = 0; n12 < n13; ++n12) {
                    object = (Class)this.mTargetTypeChildExcludes.get(n12);
                    n10 = (int)(((Class)object).isInstance(view) ? 1 : 0);
                    if (n10 == 0) continue;
                    return;
                }
            }
            view = (ViewGroup)view;
            while (n14 < (n13 = view.getChildCount())) {
                serializable = view.getChildAt(n14);
                this.captureHierarchy((View)serializable, bl2);
                ++n14;
            }
        }
    }

    private ArrayList excludeId(ArrayList arrayList, int n10, boolean bl2) {
        if (n10 > 0) {
            if (bl2) {
                Integer n11 = n10;
                arrayList = Transition$ArrayListManager.add(arrayList, n11);
            } else {
                Integer n12 = n10;
                arrayList = Transition$ArrayListManager.remove(arrayList, n12);
            }
        }
        return arrayList;
    }

    private static ArrayList excludeObject(ArrayList arrayList, Object object, boolean bl2) {
        if (object != null) {
            arrayList = bl2 ? Transition$ArrayListManager.add(arrayList, object) : Transition$ArrayListManager.remove(arrayList, object);
        }
        return arrayList;
    }

    private ArrayList excludeType(ArrayList arrayList, Class clazz, boolean bl2) {
        if (clazz != null) {
            arrayList = bl2 ? Transition$ArrayListManager.add(arrayList, clazz) : Transition$ArrayListManager.remove(arrayList, clazz);
        }
        return arrayList;
    }

    private ArrayList excludeView(ArrayList arrayList, View view, boolean bl2) {
        if (view != null) {
            arrayList = bl2 ? Transition$ArrayListManager.add(arrayList, view) : Transition$ArrayListManager.remove(arrayList, view);
        }
        return arrayList;
    }

    private static ArrayMap getRunningAnimators() {
        ArrayMap arrayMap = (ArrayMap)sRunningAnimators.get();
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            ThreadLocal threadLocal = sRunningAnimators;
            threadLocal.set(arrayMap);
        }
        return arrayMap;
    }

    private static boolean isValidMatch(int n10) {
        int n11;
        int n12 = 1;
        if (n10 < n12 || n10 > (n11 = 4)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String string2) {
        transitionValues = transitionValues.values.get(string2);
        transitionValues2 = transitionValues2.values.get(string2);
        boolean bl2 = true;
        if (transitionValues == null && transitionValues2 == null) {
            bl2 = false;
            string2 = null;
        } else if (transitionValues != null && transitionValues2 != null) {
            boolean bl3 = ((Object)transitionValues).equals(transitionValues2);
            bl2 ^= bl3;
        }
        return bl2;
    }

    private void matchIds(ArrayMap arrayMap, ArrayMap arrayMap2, SparseArray sparseArray, SparseArray sparseArray2) {
        int n10 = sparseArray.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            View view;
            int n11;
            View view2 = (View)sparseArray.valueAt(i10);
            if (view2 == null || (n11 = this.isValidTarget(view2)) == 0 || (view = (View)sparseArray2.get(n11 = sparseArray.keyAt(i10))) == null || !(bl2 = this.isValidTarget(view))) continue;
            Object object = (TransitionValues)arrayMap.get(view2);
            TransitionValues transitionValues = (TransitionValues)arrayMap2.get(view);
            if (object == null || transitionValues == null) continue;
            ArrayList arrayList = this.mStartValuesList;
            arrayList.add(object);
            object = this.mEndValuesList;
            ((ArrayList)object).add(transitionValues);
            arrayMap.remove(view2);
            arrayMap2.remove(view);
        }
    }

    private void matchInstances(ArrayMap arrayMap, ArrayMap arrayMap2) {
        for (int i10 = arrayMap.size() + -1; i10 >= 0; i10 += -1) {
            Object object;
            boolean bl2;
            Object object2 = (View)arrayMap.keyAt(i10);
            if (object2 == null || !(bl2 = this.isValidTarget((View)object2)) || (object2 = (TransitionValues)arrayMap2.remove(object2)) == null || !(bl2 = this.isValidTarget((View)(object = object2.view)))) continue;
            object = (TransitionValues)arrayMap.removeAt(i10);
            ArrayList arrayList = this.mStartValuesList;
            arrayList.add(object);
            object = this.mEndValuesList;
            ((ArrayList)object).add(object2);
        }
    }

    private void matchItemIds(ArrayMap arrayMap, ArrayMap arrayMap2, LongSparseArray longSparseArray, LongSparseArray longSparseArray2) {
        int n10 = longSparseArray.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            long l10;
            View view;
            boolean bl3;
            View view2 = (View)longSparseArray.valueAt(i10);
            if (view2 == null || !(bl3 = this.isValidTarget(view2)) || (view = (View)longSparseArray2.get(l10 = longSparseArray.keyAt(i10))) == null || !(bl2 = this.isValidTarget(view))) continue;
            Object object = (TransitionValues)arrayMap.get(view2);
            TransitionValues transitionValues = (TransitionValues)arrayMap2.get(view);
            if (object == null || transitionValues == null) continue;
            ArrayList arrayList = this.mStartValuesList;
            arrayList.add(object);
            object = this.mEndValuesList;
            ((ArrayList)object).add(transitionValues);
            arrayMap.remove(view2);
            arrayMap2.remove(view);
        }
    }

    private void matchNames(ArrayMap arrayMap, ArrayMap arrayMap2, ArrayMap arrayMap3, ArrayMap arrayMap4) {
        int n10 = arrayMap3.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2;
            boolean bl3;
            View view = (View)arrayMap3.valueAt(i10);
            if (view == null || !(bl3 = this.isValidTarget(view))) continue;
            Object object = arrayMap3.keyAt(i10);
            if ((object = (View)arrayMap4.get(object)) == null || !(bl2 = this.isValidTarget((View)object))) continue;
            Object object2 = (TransitionValues)arrayMap.get(view);
            TransitionValues transitionValues = (TransitionValues)arrayMap2.get(object);
            if (object2 == null || transitionValues == null) continue;
            ArrayList arrayList = this.mStartValuesList;
            arrayList.add(object2);
            object2 = this.mEndValuesList;
            ((ArrayList)object2).add(transitionValues);
            arrayMap.remove(view);
            arrayMap2.remove(object);
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        Object object;
        int n10;
        ArrayMap arrayMap = transitionValuesMaps.mViewValues;
        ArrayMap arrayMap2 = new ArrayMap(arrayMap);
        ArrayMap arrayMap3 = transitionValuesMaps2.mViewValues;
        arrayMap = new ArrayMap(arrayMap3);
        arrayMap3 = null;
        for (int i10 = 0; i10 < (n10 = ((int[])(object = this.mMatchOrder)).length); ++i10) {
            int n11 = object[i10];
            n10 = 1;
            if (n11 != n10) {
                Object object2;
                n10 = 2;
                if (n11 != n10) {
                    n10 = 3;
                    if (n11 != n10) {
                        n10 = 4;
                        if (n11 != n10) continue;
                        object = transitionValuesMaps.mItemIdValues;
                        object2 = transitionValuesMaps2.mItemIdValues;
                        this.matchItemIds(arrayMap2, arrayMap, (LongSparseArray)object, (LongSparseArray)object2);
                        continue;
                    }
                    object = transitionValuesMaps.mIdValues;
                    object2 = transitionValuesMaps2.mIdValues;
                    this.matchIds(arrayMap2, arrayMap, (SparseArray)object, (SparseArray)object2);
                    continue;
                }
                object = transitionValuesMaps.mNameValues;
                object2 = transitionValuesMaps2.mNameValues;
                this.matchNames(arrayMap2, arrayMap, (ArrayMap)object, (ArrayMap)object2);
                continue;
            }
            this.matchInstances(arrayMap2, arrayMap);
        }
        this.addUnmatched(arrayMap2, arrayMap);
    }

    private static int[] parseMatchOrder(String object) {
        int n10;
        Object object2 = new StringTokenizer((String)object, ",");
        int n11 = ((StringTokenizer)object2).countTokens();
        object = new int[n11];
        int n12 = 0;
        while ((n10 = ((StringTokenizer)object2).hasMoreTokens()) != 0) {
            Object object3;
            block8: {
                int n13;
                block4: {
                    boolean bl2;
                    block7: {
                        String string2;
                        block6: {
                            block5: {
                                block3: {
                                    object3 = ((StringTokenizer)object2).nextToken().trim();
                                    string2 = MATCH_ID_STR;
                                    bl2 = string2.equalsIgnoreCase((String)object3);
                                    n13 = 1;
                                    if (!bl2) break block3;
                                    n10 = 3;
                                    object[n12] = n10;
                                    break block4;
                                }
                                string2 = MATCH_INSTANCE_STR;
                                bl2 = string2.equalsIgnoreCase((String)object3);
                                if (!bl2) break block5;
                                object[n12] = n13;
                                break block4;
                            }
                            string2 = MATCH_NAME_STR;
                            bl2 = string2.equalsIgnoreCase((String)object3);
                            if (!bl2) break block6;
                            n10 = 2;
                            object[n12] = n10;
                            break block4;
                        }
                        string2 = MATCH_ITEM_ID_STR;
                        bl2 = string2.equalsIgnoreCase((String)object3);
                        if (!bl2) break block7;
                        n10 = 4;
                        object[n12] = n10;
                        break block4;
                    }
                    bl2 = ((String)object3).isEmpty();
                    if (!bl2) break block8;
                    n10 = ((Object)object).length - n13;
                    object3 = new int[n10];
                    System.arraycopy(object, 0, object3, 0, n12);
                    n12 += -1;
                    object = object3;
                }
                n12 += n13;
                continue;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unknown match type in matchOrder: '");
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append("'");
            object2 = ((StringBuilder)object2).toString();
            object = new InflateException((String)object2);
            throw object;
        }
        return object;
    }

    private void runAnimator(Animator animator2, ArrayMap arrayMap) {
        if (animator2 != null) {
            Transition$2 transition$2 = new Transition$2(this, arrayMap);
            animator2.addListener((Animator.AnimatorListener)transition$2);
            this.animate(animator2);
        }
    }

    public Transition addListener(Transition$TransitionListener transition$TransitionListener) {
        ArrayList arrayList = this.mListeners;
        if (arrayList == null) {
            this.mListeners = arrayList = new ArrayList();
        }
        this.mListeners.add(transition$TransitionListener);
        return this;
    }

    public Transition addTarget(int n10) {
        if (n10 != 0) {
            ArrayList arrayList = this.mTargetIds;
            Integer n11 = n10;
            arrayList.add(n11);
        }
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(Class clazz) {
        ArrayList arrayList = this.mTargetTypes;
        if (arrayList == null) {
            this.mTargetTypes = arrayList = new ArrayList();
        }
        this.mTargetTypes.add(clazz);
        return this;
    }

    public Transition addTarget(String string2) {
        ArrayList arrayList = this.mTargetNames;
        if (arrayList == null) {
            this.mTargetNames = arrayList = new ArrayList();
        }
        this.mTargetNames.add(string2);
        return this;
    }

    public void animate(Animator animator2) {
        if (animator2 == null) {
            this.end();
        } else {
            Object object;
            long l10;
            long l11;
            long l12 = this.getDuration();
            long l13 = l12 - (l11 = 0L);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 >= 0) {
                l12 = this.getDuration();
                animator2.setDuration(l12);
            }
            if ((object2 = (l10 = (l12 = this.getStartDelay()) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1)) >= 0) {
                l12 = this.getStartDelay();
                l11 = animator2.getStartDelay();
                animator2.setStartDelay(l12 += l11);
            }
            if ((object = this.getInterpolator()) != null) {
                object = this.getInterpolator();
                animator2.setInterpolator(object);
            }
            object = new Transition$3(this);
            animator2.addListener((Animator.AnimatorListener)object);
            animator2.start();
        }
    }

    public void cancel() {
        int n10;
        ArrayList arrayList = this.mCurrentAnimators;
        for (n10 = arrayList.size() + -1; n10 >= 0; n10 += -1) {
            Animator animator2 = (Animator)this.mCurrentAnimators.get(n10);
            animator2.cancel();
        }
        arrayList = this.mListeners;
        if (arrayList != null && (n10 = arrayList.size()) > 0) {
            arrayList = (ArrayList)this.mListeners.clone();
            int n11 = arrayList.size();
            for (int i10 = 0; i10 < n11; ++i10) {
                Transition$TransitionListener transition$TransitionListener = (Transition$TransitionListener)arrayList.get(i10);
                transition$TransitionListener.onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(TransitionValues var1);

    public void capturePropagationValues(TransitionValues transitionValues) {
        boolean bl2;
        Object object = this.mPropagation;
        if (object != null && !(bl2 = (object = transitionValues.values).isEmpty())) {
            boolean bl3;
            block5: {
                int n10;
                object = this.mPropagation.getPropagationProperties();
                if (object == null) {
                    return;
                }
                bl3 = false;
                for (int i10 = 0; i10 < (n10 = ((String[])object).length); ++i10) {
                    Map map = transitionValues.values;
                    String string2 = object[i10];
                    n10 = (int)(map.containsKey(string2) ? 1 : 0);
                    if (n10 != 0) {
                        continue;
                    }
                    break block5;
                }
                bl3 = true;
            }
            if (!bl3) {
                object = this.mPropagation;
                ((TransitionPropagation)object).captureValues(transitionValues);
            }
        }
    }

    public abstract void captureStartValues(TransitionValues var1);

    public void captureValues(ViewGroup object, boolean bl2) {
        int n10;
        Object object2;
        Object object3;
        this.clearValues(bl2);
        ArrayList arrayList = this.mTargetIds;
        int n11 = arrayList.size();
        int n12 = 0;
        if (n11 <= 0 && (n11 = (arrayList = this.mTargets).size()) <= 0 || (arrayList = this.mTargetNames) != null && (n11 = (int)(arrayList.isEmpty() ? 1 : 0)) == 0 || (arrayList = this.mTargetTypes) != null && (n11 = (int)(arrayList.isEmpty() ? 1 : 0)) == 0) {
            this.captureHierarchy((View)object, bl2);
        } else {
            int n13;
            arrayList = null;
            for (n11 = 0; n11 < (n13 = ((ArrayList)(object3 = this.mTargetIds)).size()); ++n11) {
                n13 = (Integer)this.mTargetIds.get(n11);
                object3 = object.findViewById(n13);
                if (object3 == null) continue;
                object2 = new TransitionValues((View)object3);
                if (bl2) {
                    this.captureStartValues((TransitionValues)object2);
                } else {
                    this.captureEndValues((TransitionValues)object2);
                }
                Object object4 = ((TransitionValues)object2).mTargetedTransitions;
                ((ArrayList)object4).add(this);
                this.capturePropagationValues((TransitionValues)object2);
                if (bl2) {
                    object4 = this.mStartValues;
                    Transition.addViewValues((TransitionValuesMaps)object4, (View)object3, (TransitionValues)object2);
                    continue;
                }
                object4 = this.mEndValues;
                Transition.addViewValues((TransitionValuesMaps)object4, (View)object3, (TransitionValues)object2);
            }
            object = null;
            for (n10 = 0; n10 < (n11 = (arrayList = this.mTargets).size()); ++n10) {
                arrayList = (View)this.mTargets.get(n10);
                object3 = new TransitionValues((View)arrayList);
                if (bl2) {
                    this.captureStartValues((TransitionValues)object3);
                } else {
                    this.captureEndValues((TransitionValues)object3);
                }
                object2 = ((TransitionValues)object3).mTargetedTransitions;
                ((ArrayList)object2).add(this);
                this.capturePropagationValues((TransitionValues)object3);
                if (bl2) {
                    object2 = this.mStartValues;
                    Transition.addViewValues((TransitionValuesMaps)object2, (View)arrayList, (TransitionValues)object3);
                    continue;
                }
                object2 = this.mEndValues;
                Transition.addViewValues((TransitionValuesMaps)object2, (View)arrayList, (TransitionValues)object3);
            }
        }
        if (!bl2 && (object = this.mNameOverrides) != null) {
            n10 = ((SimpleArrayMap)object).size();
            ArrayList<Object> arrayList2 = new ArrayList<Object>(n10);
            arrayList = null;
            for (n11 = 0; n11 < n10; ++n11) {
                object3 = (String)this.mNameOverrides.keyAt(n11);
                object2 = this.mStartValues.mNameValues;
                object3 = ((SimpleArrayMap)object2).remove(object3);
                arrayList2.add(object3);
            }
            while (n12 < n10) {
                arrayList = (View)arrayList2.get(n12);
                if (arrayList != null) {
                    object3 = (String)this.mNameOverrides.valueAt(n12);
                    object2 = this.mStartValues.mNameValues;
                    ((SimpleArrayMap)object2).put(object3, arrayList);
                }
                ++n12;
            }
        }
    }

    public void clearValues(boolean bl2) {
        if (bl2) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            LongSparseArray longSparseArray = this.mStartValues.mItemIdValues;
            longSparseArray.clear();
        } else {
            this.mEndValues.mViewValues.clear();
            this.mEndValues.mIdValues.clear();
            LongSparseArray longSparseArray = this.mEndValues.mItemIdValues;
            longSparseArray.clear();
        }
    }

    public Transition clone() {
        Object object;
        try {
            object = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
        object = (Transition)object;
        Object object2 = new ArrayList();
        ((Transition)object).mAnimators = object2;
        object2 = new TransitionValuesMaps();
        ((Transition)object).mStartValues = object2;
        object2 = new TransitionValuesMaps();
        ((Transition)object).mEndValues = object2;
        ((Transition)object).mStartValuesList = null;
        ((Transition)object).mEndValuesList = null;
        return object;
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList arrayList, ArrayList arrayList2) {
        Transition transition = this;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap arrayMap = Transition.getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n10 = arrayList.size();
        long l10 = Long.MAX_VALUE;
        int n11 = 0;
        Object object = null;
        while (true) {
            int n12;
            int n13;
            block17: {
                int n14;
                Object object2;
                int n15;
                Object object3;
                View view;
                Object object4;
                Object object5;
                Object object6;
                Object object7;
                block19: {
                    TransitionValues transitionValues;
                    block11: {
                        ArrayList arrayList3;
                        int n16;
                        block18: {
                            int n17;
                            int n18;
                            block12: {
                                block14: {
                                    block15: {
                                        block16: {
                                            block13: {
                                                int n19;
                                                if (n11 >= n10) break block12;
                                                object7 = arrayList;
                                                object6 = (TransitionValues)arrayList.get(n11);
                                                Object object8 = arrayList2;
                                                object5 = (TransitionValues)arrayList2.get(n11);
                                                if (object6 != null && (n16 = ((ArrayList)(object4 = ((TransitionValues)object6).mTargetedTransitions)).contains(transition)) == 0) {
                                                    n18 = 0;
                                                    object6 = null;
                                                }
                                                if (object5 != null && (n16 = ((ArrayList)(object4 = ((TransitionValues)object5).mTargetedTransitions)).contains(transition)) == 0) {
                                                    n17 = 0;
                                                    object5 = null;
                                                }
                                                if (object6 == null && object5 == null) break block13;
                                                if (object6 != null && object5 != null && (n16 = transition.isTransitionRequired((TransitionValues)object6, (TransitionValues)object5)) == 0) {
                                                    n16 = 0;
                                                    object4 = null;
                                                } else {
                                                    n16 = 1;
                                                }
                                                if (n16 == 0 || (object4 = transition.createAnimator(viewGroup2, (TransitionValues)object6, (TransitionValues)object5)) == null) break block13;
                                                if (object5 == null) break block14;
                                                view = ((TransitionValues)object5).view;
                                                object3 = this.getTransitionProperties();
                                                if (object3 == null || (n15 = ((View)object3).length) <= 0) break block15;
                                                transitionValues = new TransitionValues(view);
                                                arrayList3 = object4;
                                                n13 = n10;
                                                object2 = transitionValuesMaps2;
                                                object4 = (TransitionValues)transitionValuesMaps2.mViewValues.get(view);
                                                if (object4 == null) break block16;
                                                object2 = null;
                                                for (n10 = 0; n10 < (n19 = ((Object)object3).length); ++n10) {
                                                    object7 = transitionValues.values;
                                                    object8 = object3[n10];
                                                    n12 = n11;
                                                    object = ((TransitionValues)object4).values;
                                                    Object object9 = object4;
                                                    object4 = object3[n10];
                                                    object4 = object.get(object4);
                                                    object7.put(object8, object4);
                                                    object8 = arrayList2;
                                                    object4 = object9;
                                                }
                                                break block16;
                                            }
                                            n13 = n10;
                                            n12 = n11;
                                            break block17;
                                        }
                                        n12 = n11;
                                        n14 = arrayMap.size();
                                        object4 = null;
                                        break block18;
                                    }
                                    arrayList3 = object4;
                                    n13 = n10;
                                    n12 = n11;
                                    object3 = object4;
                                    n15 = 0;
                                    transitionValues = null;
                                    break block11;
                                }
                                arrayList3 = object4;
                                n13 = n10;
                                n12 = n11;
                                object3 = ((TransitionValues)object6).view;
                                view = object3;
                                object2 = object4;
                                n16 = 0;
                                object4 = null;
                                break block19;
                            }
                            n18 = sparseIntArray.size();
                            if (n18 != 0) {
                                transitionValues = null;
                                for (n15 = 0; n15 < (n18 = sparseIntArray.size()); ++n15) {
                                    n18 = sparseIntArray.keyAt(n15);
                                    object5 = transition.mAnimators;
                                    object6 = (Animator)((ArrayList)object5).get(n18);
                                    n17 = sparseIntArray.valueAt(n15);
                                    long l11 = (long)n17 - l10;
                                    long l12 = object6.getStartDelay();
                                    object6.setStartDelay(l11 += l12);
                                }
                            }
                            return;
                        }
                        for (n16 = 0; n16 < n14; ++n16) {
                            object2 = (Animator)arrayMap.keyAt(n16);
                            object2 = (Transition$AnimationInfo)arrayMap.get(object2);
                            object = ((Transition$AnimationInfo)object2).mValues;
                            if (object == null || (object = ((Transition$AnimationInfo)object2).mView) != view || (n11 = (int)(((String)(object = ((Transition$AnimationInfo)object2).mName)).equals(object7 = this.getName()) ? 1 : 0)) == 0 || (n10 = (int)(((TransitionValues)(object2 = ((Transition$AnimationInfo)object2).mValues)).equals(transitionValues) ? 1 : 0)) == 0) continue;
                            n14 = 0;
                            object3 = null;
                            break block11;
                        }
                        object3 = arrayList3;
                    }
                    object2 = object3;
                    object4 = transitionValues;
                }
                if (object2 != null) {
                    object3 = transition.mPropagation;
                    if (object3 != null) {
                        long l13 = ((TransitionPropagation)object3).getStartDelay(viewGroup2, transition, (TransitionValues)object6, (TransitionValues)object5);
                        object3 = transition.mAnimators;
                        n14 = ((ArrayList)object3).size();
                        n15 = (int)l13;
                        sparseIntArray.put(n14, n15);
                        l10 = Math.min(l13, l10);
                    }
                    object6 = this.getName();
                    object3 = ViewUtils.getWindowId((View)viewGroup);
                    Object object10 = object7;
                    object5 = this;
                    object7 = new Transition$AnimationInfo(view, (String)object6, this, (WindowIdImpl)object3, (TransitionValues)object4);
                    arrayMap.put(object2, object7);
                    object10 = transition.mAnimators;
                    ((ArrayList)object10).add(object2);
                }
            }
            n11 = n12 + 1;
            n10 = n13;
        }
    }

    public void end() {
        int n10 = this.mNumInstances;
        int n11 = 1;
        this.mNumInstances = n10 -= n11;
        if (n10 == 0) {
            LongSparseArray longSparseArray;
            int n12;
            ArrayList arrayList = this.mListeners;
            if (arrayList != null && (n10 = arrayList.size()) > 0) {
                arrayList = (ArrayList)this.mListeners.clone();
                n12 = arrayList.size();
                for (int i10 = 0; i10 < n12; ++i10) {
                    Transition$TransitionListener transition$TransitionListener = (Transition$TransitionListener)arrayList.get(i10);
                    transition$TransitionListener.onTransitionEnd(this);
                }
            }
            arrayList = null;
            for (n10 = 0; n10 < (n12 = (longSparseArray = this.mStartValues.mItemIdValues).size()); ++n10) {
                longSparseArray = (View)this.mStartValues.mItemIdValues.valueAt(n10);
                if (longSparseArray == null) continue;
                ViewCompat.setHasTransientState((View)longSparseArray, false);
            }
            arrayList = null;
            for (n10 = 0; n10 < (n12 = (longSparseArray = this.mEndValues.mItemIdValues).size()); ++n10) {
                longSparseArray = (View)this.mEndValues.mItemIdValues.valueAt(n10);
                if (longSparseArray == null) continue;
                ViewCompat.setHasTransientState((View)longSparseArray, false);
            }
            this.mEnded = n11;
        }
    }

    public Transition excludeChildren(int n10, boolean bl2) {
        ArrayList arrayList;
        ArrayList arrayList2 = this.mTargetIdChildExcludes;
        this.mTargetIdChildExcludes = arrayList = this.excludeId(arrayList2, n10, bl2);
        return this;
    }

    public Transition excludeChildren(View object, boolean bl2) {
        ArrayList arrayList = this.mTargetChildExcludes;
        object = this.excludeView(arrayList, (View)object, bl2);
        this.mTargetChildExcludes = object;
        return this;
    }

    public Transition excludeChildren(Class serializable, boolean bl2) {
        ArrayList arrayList = this.mTargetTypeChildExcludes;
        serializable = this.excludeType(arrayList, (Class)serializable, bl2);
        this.mTargetTypeChildExcludes = serializable;
        return this;
    }

    public Transition excludeTarget(int n10, boolean bl2) {
        ArrayList arrayList;
        ArrayList arrayList2 = this.mTargetIdExcludes;
        this.mTargetIdExcludes = arrayList = this.excludeId(arrayList2, n10, bl2);
        return this;
    }

    public Transition excludeTarget(View object, boolean bl2) {
        ArrayList arrayList = this.mTargetExcludes;
        object = this.excludeView(arrayList, (View)object, bl2);
        this.mTargetExcludes = object;
        return this;
    }

    public Transition excludeTarget(Class serializable, boolean bl2) {
        ArrayList arrayList = this.mTargetTypeExcludes;
        serializable = this.excludeType(arrayList, (Class)serializable, bl2);
        this.mTargetTypeExcludes = serializable;
        return this;
    }

    public Transition excludeTarget(String object, boolean bl2) {
        this.mTargetNameExcludes = object = Transition.excludeObject(this.mTargetNameExcludes, object, bl2);
        return this;
    }

    public void forceToEnd(ViewGroup object) {
        Object object2 = Transition.getRunningAnimators();
        int n10 = ((SimpleArrayMap)object2).size();
        if (object != null && n10 != 0) {
            object = ViewUtils.getWindowId((View)object);
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap)object2);
            ((SimpleArrayMap)object2).clear();
            n10 += -1;
            while (n10 >= 0) {
                boolean bl2;
                object2 = (Transition$AnimationInfo)arrayMap.valueAt(n10);
                View view = ((Transition$AnimationInfo)object2).mView;
                if (view != null && object != null && (bl2 = object.equals(object2 = ((Transition$AnimationInfo)object2).mWindowId))) {
                    object2 = (Animator)arrayMap.keyAt(n10);
                    object2.end();
                }
                n10 += -1;
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        Transition$EpicenterCallback transition$EpicenterCallback = this.mEpicenterCallback;
        if (transition$EpicenterCallback == null) {
            return null;
        }
        return transition$EpicenterCallback.onGetEpicenter(this);
    }

    public Transition$EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionValues getMatchedTransitionValues(View object, boolean bl2) {
        Cloneable cloneable = this.mParent;
        if (cloneable != null) {
            return ((Transition)cloneable).getMatchedTransitionValues((View)object, bl2);
        }
        cloneable = bl2 ? this.mStartValuesList : this.mEndValuesList;
        Object object2 = null;
        if (cloneable == null) {
            return null;
        }
        int n10 = ((ArrayList)cloneable).size();
        int n11 = -1;
        for (int i10 = 0; i10 < n10; ++i10) {
            TransitionValues transitionValues = (TransitionValues)((ArrayList)cloneable).get(i10);
            if (transitionValues == null) {
                return null;
            }
            transitionValues = transitionValues.view;
            if (transitionValues != object) continue;
            n11 = i10;
            break;
        }
        if (n11 >= 0) {
            object = bl2 ? this.mEndValuesList : this.mStartValuesList;
            object2 = object = object.get(n11);
            object2 = (TransitionValues)object;
        }
        return object2;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List getTargetIds() {
        return this.mTargetIds;
    }

    public List getTargetNames() {
        return this.mTargetNames;
    }

    public List getTargetTypes() {
        return this.mTargetTypes;
    }

    public List getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean bl2) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, bl2);
        }
        TransitionValuesMaps transitionValuesMaps = bl2 ? this.mStartValues : this.mEndValues;
        return (TransitionValues)transitionValuesMaps.mViewValues.get(view);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        String string2;
        boolean bl2;
        boolean bl3 = false;
        boolean bl4 = true;
        if (transitionValues == null) return bl3;
        if (transitionValues2 == null) return bl3;
        Object object = this.getTransitionProperties();
        if (object != null) {
            int n10 = ((String[])object).length;
            int n11 = 0;
            while (n11 < n10) {
                Object object2 = object[n11];
                boolean bl5 = Transition.isValueChanged(transitionValues, transitionValues2, (String)object2);
                if (bl5) return bl4;
                ++n11;
            }
            return bl3;
        }
        object = transitionValues.values.keySet().iterator();
        do {
            if (!(bl2 = object.hasNext())) return bl3;
        } while (!(bl2 = Transition.isValueChanged(transitionValues, transitionValues2, string2 = (String)object.next())));
        return bl4;
    }

    public boolean isValidTarget(View view) {
        int n10;
        Object object;
        int n11;
        int n12 = view.getId();
        Object object2 = this.mTargetIdExcludes;
        if (object2 != null && (n11 = ((ArrayList)object2).contains(object = Integer.valueOf(n12)))) {
            return false;
        }
        object2 = this.mTargetExcludes;
        if (object2 != null && (n11 = ((ArrayList)object2).contains(view))) {
            return false;
        }
        object2 = this.mTargetTypeExcludes;
        if (object2 != null) {
            n11 = ((ArrayList)object2).size();
            object = null;
            for (n10 = 0; n10 < n11; n10 += 1) {
                Class clazz = (Class)this.mTargetTypeExcludes.get(n10);
                boolean bl2 = clazz.isInstance(view);
                if (!bl2) continue;
                return false;
            }
        }
        if ((object2 = this.mTargetNameExcludes) != null && (object2 = ViewCompat.getTransitionName(view)) != null && (n11 = (int)(((ArrayList)(object2 = this.mTargetNameExcludes)).contains(object = ViewCompat.getTransitionName(view)) ? 1 : 0))) {
            return false;
        }
        object2 = this.mTargetIds;
        n11 = ((ArrayList)object2).size();
        n10 = 1;
        if (!(n11 || (n11 = ((ArrayList)(object2 = this.mTargets)).size()) || (object2 = this.mTargetTypes) != null && !(n11 = ((ArrayList)object2).isEmpty()) || (object2 = this.mTargetNames) != null && !(n11 = ((ArrayList)object2).isEmpty()))) {
            return n10 != 0;
        }
        object2 = this.mTargetIds;
        Serializable serializable = Integer.valueOf(n12);
        if ((n12 = (int)(((ArrayList)object2).contains(serializable) ? 1 : 0)) == 0 && (n12 = (int)(((ArrayList)(serializable = this.mTargets)).contains(view) ? 1 : 0)) == 0) {
            serializable = this.mTargetNames;
            if (serializable != null && (n12 = (int)(((ArrayList)serializable).contains(object2 = ViewCompat.getTransitionName(view)) ? 1 : 0)) != 0) {
                return n10 != 0;
            }
            serializable = this.mTargetTypes;
            if (serializable != null) {
                serializable = null;
                for (n12 = 0; n12 < (n11 = ((ArrayList)(object2 = this.mTargetTypes)).size()); ++n12) {
                    object2 = (Class)this.mTargetTypes.get(n12);
                    n11 = (int)(((Class)object2).isInstance(view) ? 1 : 0);
                    if (!n11) continue;
                    return n10 != 0;
                }
            }
            return false;
        }
        return n10 != 0;
    }

    public void pause(View object) {
        int n10 = this.mEnded;
        if (n10 == 0) {
            int n11;
            Object object2;
            ArrayMap arrayMap = Transition.getRunningAnimators();
            int n12 = arrayMap.size();
            object = ViewUtils.getWindowId((View)object);
            int n13 = 1;
            n12 -= n13;
            while (n12 >= 0) {
                boolean bl2;
                object2 = (Transition$AnimationInfo)arrayMap.valueAt(n12);
                View view = ((Transition$AnimationInfo)object2).mView;
                if (view != null && (bl2 = object.equals(object2 = ((Transition$AnimationInfo)object2).mWindowId))) {
                    object2 = (Animator)arrayMap.keyAt(n12);
                    AnimatorUtils.pause((Animator)object2);
                }
                n12 += -1;
            }
            object = this.mListeners;
            if (object != null && (n11 = ((ArrayList)object).size()) > 0) {
                object = (ArrayList)this.mListeners.clone();
                n10 = ((ArrayList)object).size();
                for (n12 = 0; n12 < n10; ++n12) {
                    object2 = (Transition$TransitionListener)((ArrayList)object).get(n12);
                    object2.onTransitionPause(this);
                }
            }
            this.mPaused = n13;
        }
    }

    public void playTransition(ViewGroup viewGroup) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7 = new ArrayList();
        this.mStartValuesList = object7;
        object7 = new ArrayList();
        this.mEndValuesList = object7;
        object7 = this.mStartValues;
        TransitionValuesMaps transitionValuesMaps = this.mEndValues;
        this.matchStartAndEnd((TransitionValuesMaps)object7, transitionValuesMaps);
        object7 = Transition.getRunningAnimators();
        int n10 = ((SimpleArrayMap)object7).size();
        WindowIdImpl windowIdImpl = ViewUtils.getWindowId((View)viewGroup);
        int n11 = 1;
        n10 -= n11;
        while (n10 >= 0) {
            boolean bl2;
            object6 = (Animator)((SimpleArrayMap)object7).keyAt(n10);
            if (object6 != null && (object5 = (Transition$AnimationInfo)((SimpleArrayMap)object7).get(object6)) != null && (object4 = ((Transition$AnimationInfo)object5).mView) != null && (bl2 = windowIdImpl.equals(object4 = ((Transition$AnimationInfo)object5).mWindowId))) {
                int n12;
                object4 = ((Transition$AnimationInfo)object5).mValues;
                object3 = ((Transition$AnimationInfo)object5).mView;
                object2 = this.getTransitionValues((View)object3, n11 != 0);
                object = this.getMatchedTransitionValues((View)object3, n11 != 0);
                if (object2 == null && object == null) {
                    object = object3 = this.mEndValues.mViewValues.get(object3);
                    object = (TransitionValues)object3;
                }
                if ((object2 != null || object != null) && (n12 = ((Transition)(object5 = ((Transition$AnimationInfo)object5).mTransition)).isTransitionRequired((TransitionValues)object4, (TransitionValues)object)) != 0) {
                    n12 = n11;
                } else {
                    n12 = 0;
                    object5 = null;
                }
                if (n12 != 0) {
                    n12 = object6.isRunning();
                    if (n12 == 0 && (n12 = object6.isStarted()) == 0) {
                        ((SimpleArrayMap)object7).remove(object6);
                    } else {
                        object6.cancel();
                    }
                }
            }
            n10 += -1;
        }
        object4 = this.mStartValues;
        object3 = this.mEndValues;
        object2 = this.mStartValuesList;
        object = this.mEndValuesList;
        object6 = this;
        object5 = viewGroup;
        this.createAnimators(viewGroup, (TransitionValuesMaps)object4, (TransitionValuesMaps)object3, (ArrayList)object2, (ArrayList)object);
        this.runAnimators();
    }

    public Transition removeListener(Transition$TransitionListener object) {
        ArrayList arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(object);
        object = this.mListeners;
        int n10 = ((ArrayList)object).size();
        if (n10 == 0) {
            n10 = 0;
            object = null;
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(int n10) {
        if (n10 != 0) {
            ArrayList arrayList = this.mTargetIds;
            Integer n11 = n10;
            arrayList.remove(n11);
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(Class clazz) {
        ArrayList arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(clazz);
        }
        return this;
    }

    public Transition removeTarget(String string2) {
        ArrayList arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(string2);
        }
        return this;
    }

    public void resume(View object) {
        int n10 = this.mPaused;
        if (n10 != 0) {
            n10 = this.mEnded;
            if (n10 == 0) {
                int n11;
                Object object2;
                ArrayMap arrayMap = Transition.getRunningAnimators();
                int n12 = arrayMap.size();
                object = ViewUtils.getWindowId((View)object);
                n12 += -1;
                while (n12 >= 0) {
                    boolean bl2;
                    object2 = (Transition$AnimationInfo)arrayMap.valueAt(n12);
                    View view = ((Transition$AnimationInfo)object2).mView;
                    if (view != null && (bl2 = object.equals(object2 = ((Transition$AnimationInfo)object2).mWindowId))) {
                        object2 = (Animator)arrayMap.keyAt(n12);
                        AnimatorUtils.resume((Animator)object2);
                    }
                    n12 += -1;
                }
                object = this.mListeners;
                if (object != null && (n11 = ((ArrayList)object).size()) > 0) {
                    object = (ArrayList)this.mListeners.clone();
                    n10 = ((ArrayList)object).size();
                    for (n12 = 0; n12 < n10; ++n12) {
                        object2 = (Transition$TransitionListener)((ArrayList)object).get(n12);
                        object2.onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        boolean bl2;
        this.start();
        ArrayMap arrayMap = Transition.getRunningAnimators();
        Iterator iterator2 = this.mAnimators.iterator();
        while (bl2 = iterator2.hasNext()) {
            Animator animator2 = (Animator)iterator2.next();
            boolean bl3 = arrayMap.containsKey(animator2);
            if (!bl3) continue;
            this.start();
            this.runAnimator(animator2, arrayMap);
        }
        this.mAnimators.clear();
        this.end();
    }

    public void setCanRemoveViews(boolean bl2) {
        this.mCanRemoveViews = bl2;
    }

    public Transition setDuration(long l10) {
        this.mDuration = l10;
        return this;
    }

    public void setEpicenterCallback(Transition$EpicenterCallback transition$EpicenterCallback) {
        this.mEpicenterCallback = transition$EpicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int ... object) {
        int n10;
        if (object != null && (n10 = ((int[])object).length) != 0) {
            int n11;
            for (n10 = 0; n10 < (n11 = ((int[])object).length); ++n10) {
                n11 = (int)(Transition.isValidMatch(object[n10]) ? 1 : 0);
                if (n11 != 0) {
                    n11 = (int)(Transition.alreadyContains(object, n10) ? 1 : 0);
                    if (n11 == 0) {
                        continue;
                    }
                    object = new IllegalArgumentException;
                    object("matches contains a duplicate value");
                    throw object;
                }
                object = new IllegalArgumentException;
                object("matches contains invalid value");
                throw object;
            }
            object = (int[])object.clone();
            this.mMatchOrder = object;
        } else {
            object = DEFAULT_MATCH_ORDER;
            this.mMatchOrder = object;
        }
    }

    public void setPathMotion(PathMotion pathMotion) {
        this.mPathMotion = pathMotion == null ? (pathMotion = STRAIGHT_PATH_MOTION) : pathMotion;
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public Transition setStartDelay(long l10) {
        this.mStartDelay = l10;
        return this;
    }

    public void start() {
        int n10 = this.mNumInstances;
        if (n10 == 0) {
            ArrayList arrayList = this.mListeners;
            if (arrayList != null && (n10 = arrayList.size()) > 0) {
                arrayList = (ArrayList)this.mListeners.clone();
                int n11 = arrayList.size();
                for (int i10 = 0; i10 < n11; ++i10) {
                    Transition$TransitionListener transition$TransitionListener = (Transition$TransitionListener)arrayList.get(i10);
                    transition$TransitionListener.onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances = n10 = this.mNumInstances + 1;
    }

    public String toString() {
        return this.toString("");
    }

    public String toString(String string2) {
        long l10;
        long l11;
        Serializable serializable = new StringBuilder();
        ((StringBuilder)serializable).append(string2);
        string2 = this.getClass().getSimpleName();
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append("@");
        int n10 = this.hashCode();
        string2 = Integer.toHexString(n10);
        ((StringBuilder)serializable).append(string2);
        ((StringBuilder)serializable).append(": ");
        string2 = ((StringBuilder)serializable).toString();
        long l12 = this.mDuration;
        long l13 = -1;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        String string3 = ") ";
        if (l14 != false) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append("dur(");
            l11 = this.mDuration;
            ((StringBuilder)serializable).append(l11);
            ((StringBuilder)serializable).append(string3);
            string2 = ((StringBuilder)serializable).toString();
        }
        if ((l14 = (l10 = (l11 = this.mStartDelay) - l13) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append("dly(");
            l13 = this.mStartDelay;
            ((StringBuilder)serializable).append(l13);
            ((StringBuilder)serializable).append(string3);
            string2 = ((StringBuilder)serializable).toString();
        }
        if ((serializable = this.mInterpolator) != null) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append("interp(");
            string2 = this.mInterpolator;
            ((StringBuilder)serializable).append((Object)string2);
            ((StringBuilder)serializable).append(string3);
            string2 = ((StringBuilder)serializable).toString();
        }
        if ((l14 = (long)((ArrayList)(serializable = this.mTargetIds)).size()) > 0 || (l14 = (long)((ArrayList)(serializable = this.mTargets)).size()) > 0) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append("tgts(");
            string2 = ((StringBuilder)serializable).toString();
            serializable = this.mTargetIds;
            l14 = ((ArrayList)serializable).size();
            string3 = ", ";
            int n11 = 0;
            if (l14 > 0) {
                Serializable serializable2;
                int n12;
                serializable = null;
                for (l14 = (long)0; l14 < (n12 = ((ArrayList)(serializable2 = this.mTargetIds)).size()); ++l14) {
                    if (l14 > 0) {
                        serializable2 = new StringBuilder();
                        ((StringBuilder)serializable2).append(string2);
                        ((StringBuilder)serializable2).append(string3);
                        string2 = ((StringBuilder)serializable2).toString();
                    }
                    serializable2 = new StringBuilder();
                    ((StringBuilder)serializable2).append(string2);
                    string2 = this.mTargetIds.get((int)l14);
                    ((StringBuilder)serializable2).append((Object)string2);
                    string2 = ((StringBuilder)serializable2).toString();
                }
            }
            if ((l14 = (long)((ArrayList)(serializable = this.mTargets)).size()) > 0) {
                while (n11 < (l14 = (long)((ArrayList)(serializable = this.mTargets)).size())) {
                    if (n11 > 0) {
                        serializable = new StringBuilder();
                        ((StringBuilder)serializable).append(string2);
                        ((StringBuilder)serializable).append(string3);
                        string2 = ((StringBuilder)serializable).toString();
                    }
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append(string2);
                    string2 = this.mTargets.get(n11);
                    ((StringBuilder)serializable).append((Object)string2);
                    string2 = ((StringBuilder)serializable).toString();
                    ++n11;
                }
            }
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append(string2);
            ((StringBuilder)serializable).append(")");
            string2 = ((StringBuilder)serializable).toString();
        }
        return string2;
    }
}

