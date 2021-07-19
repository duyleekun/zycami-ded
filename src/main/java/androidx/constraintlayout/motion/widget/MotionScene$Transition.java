/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class MotionScene$Transition {
    public static final int AUTO_ANIMATE_TO_END = 4;
    public static final int AUTO_ANIMATE_TO_START = 3;
    public static final int AUTO_JUMP_TO_END = 2;
    public static final int AUTO_JUMP_TO_START = 1;
    public static final int AUTO_NONE = 0;
    public static final int TRANSITION_FLAG_FIRST_DRAW = 1;
    private int mAutoTransition;
    private int mConstraintSetEnd;
    private int mConstraintSetStart;
    private int mDefaultInterpolator;
    private int mDefaultInterpolatorID;
    private String mDefaultInterpolatorString;
    private boolean mDisable;
    private int mDuration;
    private int mId;
    private boolean mIsAbstract;
    private ArrayList mKeyFramesList;
    private int mLayoutDuringTransition;
    private final MotionScene mMotionScene;
    private ArrayList mOnClicks;
    private int mPathMotionArc;
    private float mStagger;
    private TouchResponse mTouchResponse;
    private int mTransitionFlags;

    public MotionScene$Transition(int n10, MotionScene motionScene, int n11, int n12) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int n13;
        this.mId = n13 = -1;
        this.mIsAbstract = false;
        this.mConstraintSetEnd = n13;
        this.mConstraintSetStart = n13;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = n13;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFramesList = arrayList2 = new ArrayList();
        this.mTouchResponse = null;
        this.mOnClicks = arrayList = new ArrayList();
        this.mAutoTransition = 0;
        this.mDisable = false;
        this.mPathMotionArc = n13;
        this.mLayoutDuringTransition = 0;
        this.mTransitionFlags = 0;
        this.mId = n10;
        this.mMotionScene = motionScene;
        this.mConstraintSetStart = n11;
        this.mConstraintSetEnd = n12;
        this.mDuration = n10 = MotionScene.access$900(motionScene);
        this.mLayoutDuringTransition = n10 = MotionScene.access$1000(motionScene);
    }

    public MotionScene$Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int n10;
        this.mId = n10 = -1;
        this.mIsAbstract = false;
        this.mConstraintSetEnd = n10;
        this.mConstraintSetStart = n10;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = n10;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFramesList = arrayList2 = new ArrayList();
        this.mTouchResponse = null;
        this.mOnClicks = arrayList = new ArrayList();
        this.mAutoTransition = 0;
        this.mDisable = false;
        this.mPathMotionArc = n10;
        this.mLayoutDuringTransition = 0;
        this.mTransitionFlags = 0;
        this.mDuration = n10 = MotionScene.access$900(motionScene);
        this.mLayoutDuringTransition = n10 = MotionScene.access$1000(motionScene);
        this.mMotionScene = motionScene;
        xmlPullParser = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        this.fillFromAttributeList(motionScene, context, (AttributeSet)xmlPullParser);
    }

    public MotionScene$Transition(MotionScene object, MotionScene$Transition motionScene$Transition) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int n10;
        this.mId = n10 = -1;
        this.mIsAbstract = false;
        this.mConstraintSetEnd = n10;
        this.mConstraintSetStart = n10;
        this.mDefaultInterpolator = 0;
        this.mDefaultInterpolatorString = null;
        this.mDefaultInterpolatorID = n10;
        this.mDuration = 400;
        this.mStagger = 0.0f;
        this.mKeyFramesList = arrayList2 = new ArrayList();
        this.mTouchResponse = null;
        this.mOnClicks = arrayList = new ArrayList();
        this.mAutoTransition = 0;
        this.mDisable = false;
        this.mPathMotionArc = n10;
        this.mLayoutDuringTransition = 0;
        this.mTransitionFlags = 0;
        this.mMotionScene = object;
        if (motionScene$Transition != null) {
            float f10;
            int n11;
            this.mPathMotionArc = n11 = motionScene$Transition.mPathMotionArc;
            this.mDefaultInterpolator = n11 = motionScene$Transition.mDefaultInterpolator;
            this.mDefaultInterpolatorString = object = motionScene$Transition.mDefaultInterpolatorString;
            this.mDefaultInterpolatorID = n11 = motionScene$Transition.mDefaultInterpolatorID;
            this.mDuration = n11 = motionScene$Transition.mDuration;
            this.mKeyFramesList = object = motionScene$Transition.mKeyFramesList;
            this.mStagger = f10 = motionScene$Transition.mStagger;
            this.mLayoutDuringTransition = n11 = motionScene$Transition.mLayoutDuringTransition;
        }
    }

    public static /* synthetic */ int access$000(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mConstraintSetEnd;
    }

    public static /* synthetic */ int access$002(MotionScene$Transition motionScene$Transition, int n10) {
        motionScene$Transition.mConstraintSetEnd = n10;
        return n10;
    }

    public static /* synthetic */ int access$100(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mConstraintSetStart;
    }

    public static /* synthetic */ int access$102(MotionScene$Transition motionScene$Transition, int n10) {
        motionScene$Transition.mConstraintSetStart = n10;
        return n10;
    }

    public static /* synthetic */ boolean access$1200(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mIsAbstract;
    }

    public static /* synthetic */ ArrayList access$1300(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mKeyFramesList;
    }

    public static /* synthetic */ int access$1400(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDefaultInterpolator;
    }

    public static /* synthetic */ String access$1500(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDefaultInterpolatorString;
    }

    public static /* synthetic */ int access$1600(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDefaultInterpolatorID;
    }

    public static /* synthetic */ int access$1700(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDuration;
    }

    public static /* synthetic */ int access$1800(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mPathMotionArc;
    }

    public static /* synthetic */ float access$1900(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mStagger;
    }

    public static /* synthetic */ TouchResponse access$200(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mTouchResponse;
    }

    public static /* synthetic */ TouchResponse access$202(MotionScene$Transition motionScene$Transition, TouchResponse touchResponse) {
        motionScene$Transition.mTouchResponse = touchResponse;
        return touchResponse;
    }

    public static /* synthetic */ int access$300(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mId;
    }

    public static /* synthetic */ ArrayList access$400(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mOnClicks;
    }

    public static /* synthetic */ boolean access$500(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mDisable;
    }

    public static /* synthetic */ int access$600(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mAutoTransition;
    }

    public static /* synthetic */ MotionScene access$700(MotionScene$Transition motionScene$Transition) {
        return motionScene$Transition.mMotionScene;
    }

    private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
        int n10;
        int n11;
        int n12 = typedArray.getIndexCount();
        int n13 = 0;
        while (true) {
            SparseArray sparseArray;
            Object object;
            n11 = 1;
            float f10 = Float.MIN_VALUE;
            n10 = -1;
            if (n13 >= n12) break;
            int n14 = typedArray.getIndex(n13);
            int n15 = R$styleable.Transition_constraintSetEnd;
            String string2 = "layout";
            if (n14 == n15) {
                n11 = this.mConstraintSetEnd;
                this.mConstraintSetEnd = n11 = typedArray.getResourceId(n14, n11);
                object = context.getResources();
                n10 = this.mConstraintSetEnd;
                n11 = string2.equals(object = object.getResourceTypeName(n10)) ? 1 : 0;
                if (n11 != 0) {
                    object = new ConstraintSet();
                    n10 = this.mConstraintSetEnd;
                    ((ConstraintSet)object).load(context, n10);
                    sparseArray = MotionScene.access$1100(motionScene);
                    n14 = this.mConstraintSetEnd;
                    sparseArray.append(n14, object);
                }
            } else {
                n15 = R$styleable.Transition_constraintSetStart;
                if (n14 == n15) {
                    n11 = this.mConstraintSetStart;
                    this.mConstraintSetStart = n11 = typedArray.getResourceId(n14, n11);
                    object = context.getResources();
                    n10 = this.mConstraintSetStart;
                    n11 = string2.equals(object = object.getResourceTypeName(n10)) ? 1 : 0;
                    if (n11 != 0) {
                        object = new ConstraintSet();
                        n10 = this.mConstraintSetStart;
                        ((ConstraintSet)object).load(context, n10);
                        sparseArray = MotionScene.access$1100(motionScene);
                        n14 = this.mConstraintSetStart;
                        sparseArray.append(n14, object);
                    }
                } else {
                    n15 = R$styleable.Transition_motionInterpolator;
                    if (n14 == n15) {
                        Object object2 = typedArray.peekValue(n14);
                        n15 = object2.type;
                        int n16 = -2;
                        if (n15 == n11) {
                            this.mDefaultInterpolatorID = n11 = typedArray.getResourceId(n14, n10);
                            if (n11 != n10) {
                                this.mDefaultInterpolator = n16;
                            }
                        } else {
                            n11 = 3;
                            f10 = 4.2E-45f;
                            if (n15 == n11) {
                                object = typedArray.getString(n14);
                                this.mDefaultInterpolatorString = object;
                                object2 = "/";
                                n11 = ((String)object).indexOf((String)object2);
                                if (n11 > 0) {
                                    this.mDefaultInterpolatorID = n11 = typedArray.getResourceId(n14, n10);
                                    this.mDefaultInterpolator = n16;
                                } else {
                                    this.mDefaultInterpolator = n10;
                                }
                            } else {
                                n11 = this.mDefaultInterpolator;
                                this.mDefaultInterpolator = n11 = typedArray.getInteger(n14, n11);
                            }
                        }
                    } else {
                        n11 = R$styleable.Transition_duration;
                        if (n14 == n11) {
                            n11 = this.mDuration;
                            this.mDuration = n11 = typedArray.getInt(n14, n11);
                        } else {
                            n11 = R$styleable.Transition_staggered;
                            if (n14 == n11) {
                                f10 = this.mStagger;
                                this.mStagger = f10 = typedArray.getFloat(n14, f10);
                            } else {
                                n11 = R$styleable.Transition_autoTransition;
                                if (n14 == n11) {
                                    n11 = this.mAutoTransition;
                                    this.mAutoTransition = n11 = typedArray.getInteger(n14, n11);
                                } else {
                                    n11 = R$styleable.Transition_android_id;
                                    if (n14 == n11) {
                                        n11 = this.mId;
                                        this.mId = n11 = typedArray.getResourceId(n14, n11);
                                    } else {
                                        n11 = R$styleable.Transition_transitionDisable;
                                        if (n14 == n11) {
                                            n11 = this.mDisable ? 1 : 0;
                                            n11 = typedArray.getBoolean(n14, n11 != 0) ? 1 : 0;
                                            this.mDisable = n11;
                                        } else {
                                            n11 = R$styleable.Transition_pathMotionArc;
                                            if (n14 == n11) {
                                                this.mPathMotionArc = n11 = typedArray.getInteger(n14, n10);
                                            } else {
                                                n11 = R$styleable.Transition_layoutDuringTransition;
                                                if (n14 == n11) {
                                                    this.mLayoutDuringTransition = n11 = typedArray.getInteger(n14, 0);
                                                } else {
                                                    n11 = R$styleable.Transition_transitionFlags;
                                                    if (n14 == n11) {
                                                        this.mTransitionFlags = n11 = typedArray.getInteger(n14, 0);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ++n13;
        }
        int n17 = this.mConstraintSetStart;
        if (n17 == n10) {
            this.mIsAbstract = n11;
        }
    }

    private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.Transition;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        this.fill(motionScene, context, (TypedArray)attributeSet);
        attributeSet.recycle();
    }

    public void addOnClick(Context context, XmlPullParser xmlPullParser) {
        ArrayList arrayList = this.mOnClicks;
        MotionScene$Transition$TransitionOnClick motionScene$Transition$TransitionOnClick = new MotionScene$Transition$TransitionOnClick(context, this, xmlPullParser);
        arrayList.add(motionScene$Transition$TransitionOnClick);
    }

    public String debugString(Context object) {
        int n10;
        String string2;
        int n11 = this.mConstraintSetStart;
        int n12 = -1;
        if (n11 == n12) {
            string2 = "null";
        } else {
            string2 = object.getResources();
            n10 = this.mConstraintSetStart;
            string2 = string2.getResourceEntryName(n10);
        }
        n10 = this.mConstraintSetEnd;
        if (n10 == n12) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            string2 = " -> null";
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = " -> ";
            stringBuilder.append(string2);
            object = object.getResources();
            n11 = this.mConstraintSetEnd;
            object = object.getResourceEntryName(n11);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        }
        return object;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getEndConstraintSetId() {
        return this.mConstraintSetEnd;
    }

    public int getId() {
        return this.mId;
    }

    public List getKeyFrameList() {
        return this.mKeyFramesList;
    }

    public int getLayoutDuringTransition() {
        return this.mLayoutDuringTransition;
    }

    public List getOnClickList() {
        return this.mOnClicks;
    }

    public int getPathMotionArc() {
        return this.mPathMotionArc;
    }

    public float getStagger() {
        return this.mStagger;
    }

    public int getStartConstraintSetId() {
        return this.mConstraintSetStart;
    }

    public TouchResponse getTouchResponse() {
        return this.mTouchResponse;
    }

    public boolean isEnabled() {
        return this.mDisable ^ true;
    }

    public boolean isTransitionFlag(int n10) {
        int n11 = this.mTransitionFlags;
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setAutoTransition(int n10) {
        this.mAutoTransition = n10;
    }

    public void setDuration(int n10) {
        this.mDuration = n10;
    }

    public void setEnable(boolean bl2) {
        this.mDisable = bl2 ^= true;
    }

    public void setPathMotionArc(int n10) {
        this.mPathMotionArc = n10;
    }

    public void setStagger(float f10) {
        this.mStagger = f10;
    }
}

