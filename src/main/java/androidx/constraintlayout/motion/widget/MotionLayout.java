/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Interpolator
 *  androidx.constraintlayout.motion.widget.MotionController
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.DesignTool;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout$1;
import androidx.constraintlayout.motion.widget.MotionLayout$2;
import androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw;
import androidx.constraintlayout.motion.widget.MotionLayout$Model;
import androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker;
import androidx.constraintlayout.motion.widget.MotionLayout$MyTracker;
import androidx.constraintlayout.motion.widget.MotionLayout$StateCache;
import androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener;
import androidx.constraintlayout.motion.widget.MotionLayout$TransitionState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.MotionScene$Transition;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayoutStates;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout
extends ConstraintLayout
implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int MAX_KEY_FRAMES = 50;
    public static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    public boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    public int mCurrentState;
    public int mDebugPath;
    private MotionLayout$DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    public MotionLayout$DevModeDraw mDevModeDraw;
    private int mEndState;
    public int mEndWrapHeight;
    public int mEndWrapWidth;
    public HashMap mFrameArrayList;
    private int mFrames;
    public int mHeightMeasureMode;
    private boolean mInLayout;
    public boolean mInTransition;
    public boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    public Interpolator mInterpolator;
    public boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    public int mLastLayoutHeight;
    public int mLastLayoutWidth;
    public float mLastVelocity = 0.0f;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    public boolean mMeasureDuringTransition;
    public MotionLayout$Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    public int mOldHeight;
    public int mOldWidth;
    private ArrayList mOnHideHelpers;
    private ArrayList mOnShowHelpers;
    public float mPostInterpolationPosition;
    private View mRegionView;
    public MotionScene mScene;
    public float mScrollTargetDT;
    public float mScrollTargetDX;
    public float mScrollTargetDY;
    public long mScrollTargetTime;
    public int mStartWrapHeight;
    public int mStartWrapWidth;
    private MotionLayout$StateCache mStateCache;
    private StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    public ArrayList mTransitionCompleted;
    private float mTransitionDuration;
    public float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    public float mTransitionLastPosition;
    private long mTransitionLastTime;
    private MotionLayout$TransitionListener mTransitionListener;
    private ArrayList mTransitionListeners;
    public float mTransitionPosition;
    public MotionLayout$TransitionState mTransitionState;
    public boolean mUndergoingMotion;
    public int mWidthMeasureMode;

    public MotionLayout(Context object) {
        super((Context)object);
        boolean bl2;
        int n10;
        this.mBeginState = n10 = -1;
        this.mCurrentState = n10;
        this.mEndState = n10;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = bl2 = true;
        Object object2 = new HashMap();
        this.mFrameArrayList = object2;
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = object2 = new StopLogic();
        this.mDecelerateLogic = object2 = new MotionLayout$DecelerateInterpolator(this);
        this.firstDown = bl2;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        super();
        this.mKeyCache = object;
        this.mInLayout = false;
        object = MotionLayout$TransitionState.UNDEFINED;
        this.mTransitionState = object;
        super(this);
        this.mModel = object;
        this.mNeedsFireTransitionCompleted = false;
        super();
        this.mBoundsCheck = object;
        this.mRegionView = null;
        super();
        this.mTransitionCompleted = object;
        this.init(null);
    }

    public MotionLayout(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        boolean bl2;
        int n10;
        this.mBeginState = n10 = -1;
        this.mCurrentState = n10;
        this.mEndState = n10;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = bl2 = true;
        Object object2 = new HashMap();
        this.mFrameArrayList = object2;
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = object2 = new StopLogic();
        this.mDecelerateLogic = object2 = new MotionLayout$DecelerateInterpolator(this);
        this.firstDown = bl2;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        super();
        this.mKeyCache = object;
        this.mInLayout = false;
        object = MotionLayout$TransitionState.UNDEFINED;
        this.mTransitionState = object;
        super(this);
        this.mModel = object;
        this.mNeedsFireTransitionCompleted = false;
        super();
        this.mBoundsCheck = object;
        this.mRegionView = null;
        super();
        this.mTransitionCompleted = object;
        this.init(attributeSet);
    }

    public MotionLayout(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        boolean bl2;
        this.mBeginState = n10 = -1;
        this.mCurrentState = n10;
        this.mEndState = n10;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = bl2 = true;
        Object object2 = new HashMap();
        this.mFrameArrayList = object2;
        this.mAnimationStartTime = 0L;
        this.mTransitionDuration = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionGoalPosition = 0.0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = object2 = new StopLogic();
        this.mDecelerateLogic = object2 = new MotionLayout$DecelerateInterpolator(this);
        this.firstDown = bl2;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0.0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0.0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        super();
        this.mKeyCache = object;
        this.mInLayout = false;
        object = MotionLayout$TransitionState.UNDEFINED;
        this.mTransitionState = object;
        super(this);
        this.mModel = object;
        this.mNeedsFireTransitionCompleted = false;
        super();
        this.mBoundsCheck = object;
        this.mRegionView = null;
        super();
        this.mTransitionCompleted = object;
        this.init(attributeSet);
    }

    public static /* synthetic */ int access$000(MotionLayout motionLayout) {
        return motionLayout.mEndState;
    }

    public static /* synthetic */ int access$100(MotionLayout motionLayout) {
        return motionLayout.mBeginState;
    }

    public static /* synthetic */ int access$1000(MotionLayout motionLayout) {
        return motionLayout.mLastHeightMeasureSpec;
    }

    public static /* synthetic */ void access$1100(MotionLayout motionLayout) {
        motionLayout.setupMotionViews();
    }

    public static /* synthetic */ void access$1200(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1300(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1400(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1500(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1600(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1700(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1800(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ void access$1900(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n10, int n11, int n12) {
        motionLayout.resolveSystem(constraintWidgetContainer, n10, n11, n12);
    }

    public static /* synthetic */ ConstraintWidgetContainer access$200(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    public static /* synthetic */ void access$2000(MotionLayout motionLayout, int n10, int n11, int n12, int n13, boolean bl2, boolean bl3) {
        motionLayout.resolveMeasuredDimension(n10, n11, n12, n13, bl2, bl3);
    }

    public static /* synthetic */ ConstraintWidgetContainer access$300(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$400(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    public static /* synthetic */ ConstraintWidgetContainer access$500(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    public static /* synthetic */ boolean access$600(MotionLayout motionLayout) {
        return motionLayout.isRtl();
    }

    public static /* synthetic */ boolean access$700(MotionLayout motionLayout) {
        return motionLayout.isRtl();
    }

    public static /* synthetic */ void access$800(MotionLayout motionLayout, boolean bl2, View view, ConstraintWidget constraintWidget, ConstraintLayout$LayoutParams constraintLayout$LayoutParams, SparseArray sparseArray) {
        motionLayout.applyConstraintsFromLayoutParams(bl2, view, constraintWidget, constraintLayout$LayoutParams, sparseArray);
    }

    public static /* synthetic */ int access$900(MotionLayout motionLayout) {
        return motionLayout.mLastWidthMeasureSpec;
    }

    private void checkStructure() {
        int n10;
        MotionScene motionScene = this.mScene;
        String string2 = TAG;
        if (motionScene == null) {
            Log.e((String)string2, (String)"CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int n11 = motionScene.getStartId();
        Object object = this.mScene;
        int n12 = ((MotionScene)object).getStartId();
        object = ((MotionScene)object).getConstraintSet(n12);
        this.checkStructure(n11, (ConstraintSet)object);
        motionScene = new SparseIntArray();
        object = new SparseIntArray();
        Iterator iterator2 = this.mScene.getDefinedTransitions().iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            String string3;
            CharSequence charSequence;
            Object object2;
            Object object3 = (MotionScene$Transition)iterator2.next();
            if (object3 == (object2 = this.mScene.mCurrentTransition)) {
                object2 = "CHECK: CURRENT";
                Log.v((String)string2, (String)object2);
            }
            this.checkStructure((MotionScene$Transition)object3);
            int n13 = ((MotionScene$Transition)object3).getStartConstraintSetId();
            n10 = ((MotionScene$Transition)object3).getEndConstraintSetId();
            String string4 = Debug.getName(this.getContext(), n13);
            Object object4 = Debug.getName(this.getContext(), n10);
            int n14 = motionScene.get(n13);
            String string5 = "->";
            if (n14 == n10) {
                charSequence = new StringBuilder();
                string3 = "CHECK: two transitions with the same start and end ";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append((String)object4);
                charSequence = ((StringBuilder)charSequence).toString();
                Log.e((String)string2, (String)charSequence);
            }
            if ((n14 = object.get(n10)) == n13) {
                charSequence = new StringBuilder();
                string3 = "CHECK: you can't have reverse transitions";
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(string4);
                ((StringBuilder)charSequence).append(string5);
                ((StringBuilder)charSequence).append((String)object4);
                object4 = ((StringBuilder)charSequence).toString();
                Log.e((String)string2, (String)object4);
            }
            motionScene.put(n13, n10);
            object.put(n10, n13);
            object4 = this.mScene;
            object2 = ((MotionScene)object4).getConstraintSet(n13);
            if (object2 == null) {
                object2 = new StringBuilder();
                object4 = " no such constraintSetStart ";
                ((StringBuilder)object2).append((String)object4);
                ((StringBuilder)object2).append(string4);
                object2 = ((StringBuilder)object2).toString();
                Log.e((String)string2, (String)object2);
            }
            if ((object3 = ((MotionScene)(object2 = this.mScene)).getConstraintSet(n10)) != null) continue;
            object3 = new StringBuilder();
            object2 = " no such constraintSetEnd ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append(string4);
            object3 = ((StringBuilder)object3).toString();
            Log.e((String)string2, (String)object3);
        }
    }

    private void checkStructure(int n10, ConstraintSet constraintSet) {
        String string2;
        Object object;
        Object object2;
        String string3;
        String string4;
        int n11;
        Object object3 = this.getContext();
        String string5 = Debug.getName(object3, n10);
        int n12 = this.getChildCount();
        int n13 = 0;
        Object object4 = 0;
        CharSequence charSequence = null;
        while (true) {
            Object object5;
            n11 = -1;
            string4 = "CHECK: ";
            string3 = TAG;
            if (object4 >= n12) break;
            object2 = this.getChildAt((int)object4);
            object = object2.getId();
            if (object == n11) {
                object5 = new StringBuilder();
                ((StringBuilder)object5).append(string4);
                ((StringBuilder)object5).append(string5);
                ((StringBuilder)object5).append(" ALL VIEWS SHOULD HAVE ID's ");
                string2 = object2.getClass().getName();
                ((StringBuilder)object5).append(string2);
                string2 = " does not!";
                ((StringBuilder)object5).append(string2);
                object5 = ((StringBuilder)object5).toString();
                Log.w((String)string3, (String)object5);
            }
            if ((object5 = constraintSet.getConstraint((int)object)) == null) {
                object5 = new StringBuilder();
                ((StringBuilder)object5).append(string4);
                ((StringBuilder)object5).append(string5);
                ((StringBuilder)object5).append(" NO CONSTRAINTS for ");
                string4 = Debug.getName((View)object2);
                ((StringBuilder)object5).append(string4);
                object5 = ((StringBuilder)object5).toString();
                Log.w((String)string3, (String)object5);
            }
            ++object4;
        }
        object3 = constraintSet.getKnownIds();
        while (n13 < (object4 = ((Context)object3).length)) {
            object4 = object3[n13];
            object2 = Debug.getName(this.getContext(), object4);
            object = object3[n13];
            Object object6 = this.findViewById((int)object);
            if (object6 == null) {
                object6 = new StringBuilder();
                ((StringBuilder)object6).append(string4);
                ((StringBuilder)object6).append(string5);
                string2 = " NO View matches id ";
                ((StringBuilder)object6).append(string2);
                ((StringBuilder)object6).append((String)object2);
                object6 = ((StringBuilder)object6).toString();
                Log.w((String)string3, (String)object6);
            }
            object = constraintSet.getHeight((int)object4);
            string2 = ") no LAYOUT_HEIGHT";
            String string6 = "(";
            if (object == n11) {
                object6 = new StringBuilder();
                ((StringBuilder)object6).append(string4);
                ((StringBuilder)object6).append(string5);
                ((StringBuilder)object6).append(string6);
                ((StringBuilder)object6).append((String)object2);
                ((StringBuilder)object6).append(string2);
                object6 = ((StringBuilder)object6).toString();
                Log.w((String)string3, (String)object6);
            }
            if ((object4 = constraintSet.getWidth((int)object4)) == n11) {
                charSequence = new StringBuilder();
                charSequence.append(string4);
                charSequence.append(string5);
                charSequence.append(string6);
                charSequence.append((String)object2);
                charSequence.append(string2);
                charSequence = charSequence.toString();
                Log.w((String)string3, (String)charSequence);
            }
            ++n13;
        }
    }

    private void checkStructure(MotionScene$Transition object) {
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("CHECK: transition = ");
        Object object2 = this.getContext();
        object2 = ((MotionScene$Transition)object).debugString((Context)object2);
        ((StringBuilder)charSequence).append((String)object2);
        charSequence = ((StringBuilder)charSequence).toString();
        object2 = TAG;
        Log.v((String)object2, (String)charSequence);
        charSequence = new StringBuilder();
        String string2 = "CHECK: transition.setDuration = ";
        ((StringBuilder)charSequence).append(string2);
        int n10 = ((MotionScene$Transition)object).getDuration();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.v((String)object2, (String)charSequence);
        int n11 = ((MotionScene$Transition)object).getStartConstraintSetId();
        int n12 = ((MotionScene$Transition)object).getEndConstraintSetId();
        if (n11 == n12) {
            object = "CHECK: start and end constraint set should not be the same!";
            Log.e((String)object2, (String)object);
        }
    }

    private void computeCurrentPositions() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = this.getChildAt(i10);
            MotionController motionController = (MotionController)this.mFrameArrayList.get(view);
            if (motionController == null) continue;
            motionController.setStartCurrentState(view);
        }
    }

    private void debugPos() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            Object object = this.getChildAt(i10);
            CharSequence charSequence = new StringBuilder();
            String string2 = " ";
            charSequence.append(string2);
            String string3 = Debug.getLocation();
            charSequence.append(string3);
            charSequence.append(string2);
            string3 = Debug.getName((View)this);
            charSequence.append(string3);
            charSequence.append(string2);
            string3 = this.getContext();
            int n11 = this.mCurrentState;
            string3 = Debug.getName((Context)string3, n11);
            charSequence.append(string3);
            charSequence.append(string2);
            string3 = Debug.getName(object);
            charSequence.append(string3);
            int n12 = object.getLeft();
            charSequence.append(n12);
            charSequence.append(string2);
            n10 = object.getTop();
            charSequence.append(n10);
            object = charSequence.toString();
            charSequence = TAG;
            Log.v((String)charSequence, (String)object);
        }
    }

    private void evaluateLayout() {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        long l10;
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        float f20;
        float f21;
        float f22;
        float f23 = this.mTransitionGoalPosition;
        float f24 = this.mTransitionLastPosition;
        f23 = Math.signum(f23 - f24);
        long l11 = this.getNanoTime();
        Interpolator interpolator2 = this.mInterpolator;
        int n10 = interpolator2 instanceof StopLogic;
        float f25 = 1.0E-9f;
        int n11 = 0;
        if (n10 == 0) {
            long l12 = this.mTransitionLastTime;
            l12 = l11 - l12;
            f22 = (float)l12 * f23 * f25;
            f21 = this.mTransitionDuration;
            f22 /= f21;
        } else {
            n10 = 0;
            f22 = 0.0f;
        }
        f21 = this.mTransitionLastPosition + f22;
        n10 = this.mTransitionInstantly;
        if (n10 != 0) {
            f21 = this.mTransitionGoalPosition;
        }
        n10 = (f20 = f23 - 0.0f) == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
        int n12 = 0;
        if (n10 > 0 && (f19 = (f18 = f21 - (f17 = this.mTransitionGoalPosition)) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1)) >= 0 || (f19 = (f16 = f23 - 0.0f) == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1)) <= 0 && (f19 = (f15 = f21 - (f17 = this.mTransitionGoalPosition)) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) <= 0) {
            f21 = this.mTransitionGoalPosition;
            f19 = 1.0f;
            f17 = Float.MIN_VALUE;
        } else {
            f19 = 0.0f;
            f17 = 0.0f;
        }
        if (interpolator2 != null && f19 == false) {
            f19 = (float)this.mTemporalInterpolator;
            if (f19 != false) {
                l10 = this.mAnimationStartTime;
                f24 = (float)(l11 -= l10) * f25;
                f21 = interpolator2.getInterpolation(f24);
            } else {
                f21 = interpolator2.getInterpolation(f21);
            }
        }
        if (n10 > 0 && (f14 = (f13 = f21 - (f24 = this.mTransitionGoalPosition)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) >= 0 || (f12 = (f11 = f23 - 0.0f) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0 && (f12 = (f10 = f21 - (f23 = this.mTransitionGoalPosition)) == 0.0f ? 0 : (f10 < 0.0f ? -1 : 1)) <= 0) {
            f21 = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f21;
        n11 = this.getChildCount();
        l10 = this.getNanoTime();
        while (n12 < n11) {
            View view = this.getChildAt(n12);
            MotionController motionController = (MotionController)this.mFrameArrayList.get(view);
            if (motionController != null) {
                KeyCache keyCache = this.mKeyCache;
                motionController.interpolate(view, f21, l10, keyCache);
            }
            ++n12;
        }
        f12 = (float)this.mMeasureDuringTransition;
        if (f12 != false) {
            this.requestLayout();
        }
    }

    private void fireTransitionChange() {
        float f10;
        float f11;
        float f12;
        int n10;
        Object object = this.mTransitionListener;
        if ((object != null || (object = this.mTransitionListeners) != null && (n10 = ((ArrayList)object).isEmpty()) == 0) && (n10 = (f12 = (f11 = this.mListenerPosition) - (f10 = this.mTransitionPosition)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) != 0) {
            int n11;
            int n12;
            n10 = this.mListenerState;
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
            int n13 = -1;
            if (n10 != n13) {
                object = this.mTransitionListener;
                if (object != null) {
                    n12 = this.mBeginState;
                    n11 = this.mEndState;
                    object.onTransitionStarted(this, n12, n11);
                }
                if ((object = this.mTransitionListeners) != null) {
                    object = ((ArrayList)object).iterator();
                    while ((n12 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        MotionLayout$TransitionListener motionLayout$TransitionListener = (MotionLayout$TransitionListener)object.next();
                        n11 = this.mBeginState;
                        int n14 = this.mEndState;
                        motionLayout$TransitionListener.onTransitionStarted(this, n11, n14);
                    }
                }
                this.mIsAnimating = bl2;
            }
            this.mListenerState = n13;
            this.mListenerPosition = f11 = this.mTransitionPosition;
            MotionLayout$TransitionListener motionLayout$TransitionListener = this.mTransitionListener;
            if (motionLayout$TransitionListener != null) {
                n12 = this.mBeginState;
                n11 = this.mEndState;
                motionLayout$TransitionListener.onTransitionChange(this, n12, n11, f11);
            }
            if ((object = this.mTransitionListeners) != null) {
                object = ((ArrayList)object).iterator();
                while ((n13 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    motionLayout$TransitionListener = (MotionLayout$TransitionListener)object.next();
                    n12 = this.mBeginState;
                    n11 = this.mEndState;
                    float f13 = this.mTransitionPosition;
                    motionLayout$TransitionListener.onTransitionChange(this, n12, n11, f13);
                }
            }
            this.mIsAnimating = bl2;
        }
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int n10, int n11) {
        Object object = this.mTransitionListener;
        if (object != null) {
            object.onTransitionStarted(this, n10, n11);
        }
        if ((object = this.mTransitionListeners) != null) {
            boolean bl2;
            object = ((ArrayList)object).iterator();
            while (bl2 = object.hasNext()) {
                MotionLayout$TransitionListener motionLayout$TransitionListener = (MotionLayout$TransitionListener)object.next();
                motionLayout$TransitionListener.onTransitionStarted(motionLayout, n10, n11);
            }
        }
    }

    private boolean handlesTouchEvent(float f10, float f11, View view, MotionEvent motionEvent) {
        float f12;
        RectF rectF;
        int n10;
        int n11;
        float f13;
        int n12;
        View view2;
        boolean bl2 = view instanceof ViewGroup;
        boolean bl3 = true;
        if (bl2) {
            view2 = view;
            view2 = (ViewGroup)view;
            n12 = view2.getChildCount();
            f13 = 0.0f;
            for (n11 = 0; n11 < n12; ++n11) {
                int n13;
                float f14;
                View view3 = view2.getChildAt(n11);
                int n14 = view.getLeft();
                float f15 = (float)n14 + f10;
                n10 = (int)(this.handlesTouchEvent(f15, f14 = (float)(n13 = view.getTop()) + f11, view3, motionEvent) ? 1 : 0);
                if (n10 == 0) continue;
                return bl3;
            }
        }
        view2 = this.mBoundsCheck;
        n12 = view.getLeft();
        float f16 = (float)n12 + f10;
        n11 = view.getTop();
        f13 = (float)n11 + f11;
        float f17 = view.getRight();
        f10 += f17;
        n10 = view.getBottom();
        f17 = n10;
        view2.set(f16, f13, f10, f11 += f17);
        int n15 = motionEvent.getAction();
        if (n15 == 0 ? (n15 = (int)((rectF = this.mBoundsCheck).contains(f11 = motionEvent.getX(), f12 = motionEvent.getY()) ? 1 : 0)) != 0 && (n15 = (int)(view.onTouchEvent(motionEvent) ? 1 : 0)) != 0 : (n15 = (int)(view.onTouchEvent(motionEvent) ? 1 : 0)) != 0) {
            return bl3;
        }
        return false;
    }

    private void init(AttributeSet object) {
        int n10;
        IS_IN_EDIT_MODE = this.isInEditMode();
        int n11 = -1;
        if (object != null) {
            boolean bl2;
            Object object2 = this.getContext();
            int[] nArray = R$styleable.MotionLayout;
            object = object2.obtainStyledAttributes((AttributeSet)object, nArray);
            int n12 = object.getIndexCount();
            boolean bl3 = bl2 = true;
            for (int i10 = 0; i10 < n12; ++i10) {
                float f10;
                MotionScene motionScene;
                int n13;
                int n14 = object.getIndex(i10);
                if (n14 == (n13 = R$styleable.MotionLayout_layoutDescription)) {
                    n14 = object.getResourceId(n14, n11);
                    Context context = this.getContext();
                    this.mScene = motionScene = new MotionScene(context, this, n14);
                    continue;
                }
                n13 = R$styleable.MotionLayout_currentState;
                if (n14 == n13) {
                    this.mCurrentState = n14 = object.getResourceId(n14, n11);
                    continue;
                }
                n13 = R$styleable.MotionLayout_motionProgress;
                if (n14 == n13) {
                    n13 = 0;
                    motionScene = null;
                    this.mTransitionGoalPosition = f10 = object.getFloat(n14, 0.0f);
                    this.mInTransition = bl2;
                    continue;
                }
                n13 = R$styleable.MotionLayout_applyMotionScene;
                if (n14 == n13) {
                    bl3 = object.getBoolean(n14, bl3);
                    continue;
                }
                n13 = R$styleable.MotionLayout_showPaths;
                if (n14 == n13) {
                    n13 = this.mDebugPath;
                    if (n13 != 0) continue;
                    if ((n14 = (int)(object.getBoolean(n14, false) ? 1 : 0)) != 0) {
                        n14 = 2;
                        f10 = 2.8E-45f;
                    } else {
                        n14 = 0;
                        f10 = 0.0f;
                    }
                    this.mDebugPath = n14;
                    continue;
                }
                n13 = R$styleable.MotionLayout_motionDebug;
                if (n14 != n13) continue;
                this.mDebugPath = n14 = object.getInt(n14, 0);
            }
            object.recycle();
            object = this.mScene;
            if (object == null) {
                object = TAG;
                object2 = "WARNING NO app:layoutDescription tag";
                Log.e((String)object, (String)object2);
            }
            if (!bl3) {
                n10 = 0;
                object = null;
                this.mScene = null;
            }
        }
        if ((n10 = this.mDebugPath) != 0) {
            this.checkStructure();
        }
        if ((n10 = this.mCurrentState) == n11 && (object = this.mScene) != null) {
            this.mCurrentState = n10 = ((MotionScene)object).getStartId();
            this.mBeginState = n10 = this.mScene.getStartId();
            object = this.mScene;
            this.mEndState = n10 = ((MotionScene)object).getEndId();
        }
    }

    private void processTransitionCompleted() {
        boolean bl2;
        boolean bl3;
        Object object = this.mTransitionListener;
        if (object == null && ((object = this.mTransitionListeners) == null || (bl3 = ((ArrayList)object).isEmpty()))) {
            return;
        }
        bl3 = false;
        this.mIsAnimating = false;
        object = this.mTransitionCompleted.iterator();
        while (bl2 = object.hasNext()) {
            int n10;
            Integer n11 = (Integer)object.next();
            Object object2 = this.mTransitionListener;
            if (object2 != null) {
                n10 = n11;
                object2.onTransitionCompleted(this, n10);
            }
            if ((object2 = this.mTransitionListeners) == null) continue;
            object2 = ((ArrayList)object2).iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                MotionLayout$TransitionListener motionLayout$TransitionListener = (MotionLayout$TransitionListener)object2.next();
                int n12 = n11;
                motionLayout$TransitionListener.onTransitionCompleted(this, n12);
            }
        }
        this.mTransitionCompleted.clear();
    }

    private void setupMotionViews() {
        block16: {
            int n10;
            float f10;
            float f11;
            int n11;
            float f12;
            float f13;
            float f14;
            float f15;
            HashMap hashMap;
            int n12;
            int n13;
            int n14;
            int n15;
            Object object;
            int n16;
            block15: {
                int n17;
                int n18;
                Object object2;
                n16 = this.getChildCount();
                object = this.mModel;
                ((MotionLayout$Model)object).build();
                this.mInTransition = n15 = 1;
                n14 = this.getWidth();
                int n19 = this.getHeight();
                Object object3 = this.mScene;
                int n20 = ((MotionScene)object3).gatPathMotionArc();
                n13 = 0;
                n12 = -1;
                if (n20 != n12) {
                    object2 = null;
                    for (n12 = 0; n12 < n16; ++n12) {
                        hashMap = this.mFrameArrayList;
                        View view = this.getChildAt(n12);
                        if ((hashMap = (MotionController)hashMap.get(view)) == null) continue;
                        hashMap.setPathMotionArc(n20);
                    }
                }
                View view = null;
                float f16 = 0.0f;
                for (n18 = 0; n18 < n16; ++n18) {
                    object3 = this.mFrameArrayList;
                    object2 = this.getChildAt(n18);
                    if ((object3 = (MotionController)((HashMap)object3).get(object2)) == null) continue;
                    object2 = this.mScene;
                    ((MotionScene)object2).getKeyFrames((MotionController)object3);
                    f15 = this.mTransitionDuration;
                    long l10 = this.getNanoTime();
                    n12 = n14;
                    n17 = n19;
                    object3.setup(n14, n19, f15, l10);
                }
                object3 = this.mScene;
                f14 = ((MotionScene)object3).getStaggered();
                object2 = null;
                float f17 = f14 - 0.0f;
                n12 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
                if (n12 == 0) break block16;
                double d10 = f14;
                double d11 = 0.0;
                double d12 = d10 - d11;
                n12 = (int)(d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1));
                if (n12 < 0) {
                    n12 = n15;
                } else {
                    n12 = 0;
                    object2 = null;
                }
                f14 = Math.abs(f14);
                n17 = -8388609;
                f13 = -3.4028235E38f;
                int n21 = 0x7F7FFFFF;
                f15 = Float.MAX_VALUE;
                n14 = n17;
                f12 = f13;
                n11 = n21;
                f11 = f15;
                f10 = 0.0f;
                for (n10 = 0; n10 < n16; ++n10) {
                    HashMap hashMap2 = this.mFrameArrayList;
                    view = this.getChildAt(n10);
                    hashMap2 = (MotionController)hashMap2.get(view);
                    f16 = ((MotionController)hashMap2).mMotionStagger;
                    n18 = (int)(Float.isNaN(f16) ? 1 : 0);
                    if (n18 != 0) {
                        f16 = hashMap2.getFinalX();
                        float f18 = hashMap2.getFinalY();
                        f18 = n12 != 0 ? (f18 -= f16) : (f18 += f16);
                        f11 = Math.min(f11, f18);
                        f12 = Math.max(f12, f18);
                        continue;
                    }
                    break block15;
                }
                n15 = 0;
                object = null;
            }
            n10 = 1065353216;
            f10 = 1.0f;
            if (n15 != 0) {
                HashMap hashMap3;
                object = null;
                for (n15 = 0; n15 < n16; ++n15) {
                    hashMap3 = this.mFrameArrayList;
                    View view = this.getChildAt(n15);
                    hashMap3 = (MotionController)hashMap3.get(view);
                    f12 = ((MotionController)hashMap3).mMotionStagger;
                    n14 = (int)(Float.isNaN(f12) ? 1 : 0);
                    if (n14 != 0) continue;
                    f12 = ((MotionController)hashMap3).mMotionStagger;
                    f15 = Math.min(f15, f12);
                    f11 = ((MotionController)hashMap3).mMotionStagger;
                    f13 = Math.max(f13, f11);
                }
                while (n13 < n16) {
                    object = this.mFrameArrayList;
                    hashMap3 = this.getChildAt(n13);
                    object = (MotionController)((HashMap)object).get(hashMap3);
                    f11 = ((MotionController)object).mMotionStagger;
                    n11 = (int)(Float.isNaN(f11) ? 1 : 0);
                    if (n11 == 0) {
                        f11 = f10 - f14;
                        ((MotionController)object).mStaggerScale = f11 = f10 / f11;
                        if (n12 != 0) {
                            f11 = ((MotionController)object).mMotionStagger;
                            f11 = f13 - f11;
                            f12 = f13 - f15;
                            f11 = f11 / f12 * f14;
                            ((MotionController)object).mStaggerOffset = f11 = f14 - f11;
                        } else {
                            f11 = (((MotionController)object).mMotionStagger - f15) * f14;
                            f12 = f13 - f15;
                            f11 /= f12;
                            ((MotionController)object).mStaggerOffset = f11 = f14 - f11;
                        }
                    }
                    ++n13;
                }
            } else {
                while (n13 < n16) {
                    object = this.mFrameArrayList;
                    hashMap = this.getChildAt(n13);
                    object = (MotionController)((HashMap)object).get(hashMap);
                    f13 = object.getFinalX();
                    f15 = object.getFinalY();
                    f15 = n12 != 0 ? (f15 -= f13) : (f15 += f13);
                    f13 = f10 - f14;
                    ((MotionController)object).mStaggerScale = f13 = f10 / f13;
                    f15 = (f15 - f11) * f14;
                    f13 = f12 - f11;
                    f15 /= f13;
                    ((MotionController)object).mStaggerOffset = f13 = f14 - f15;
                    ++n13;
                }
            }
        }
    }

    private static boolean willJump(float f10, float f11, float f12) {
        float f13 = 0.0f;
        float f14 = f10 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        boolean bl2 = true;
        float f16 = 2.0f;
        if (f15 > 0) {
            f13 = f10 / f12;
            f10 *= f13;
            f12 = f12 * f13 * f13 / f16;
            f10 -= f12;
            float f17 = (f11 += f10) - (f10 = 1.0f);
            Object object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (object <= 0) {
                bl2 = false;
            }
            return bl2;
        }
        float f18 = -f10 / f12;
        f10 *= f18;
        float f19 = (f11 += (f10 += (f12 = f12 * f18 * f18 / f16))) - 0.0f;
        Object object = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
        if (object >= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public void addTransitionListener(MotionLayout$TransitionListener motionLayout$TransitionListener) {
        ArrayList arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            this.mTransitionListeners = arrayList = new ArrayList();
        }
        this.mTransitionListeners.add(motionLayout$TransitionListener);
    }

    public void animateTo(float f10) {
        long l10;
        Interpolator interpolator2;
        float f11;
        float f12;
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f13 = this.mTransitionLastPosition;
        float f14 = this.mTransitionPosition;
        float f15 = f13 - f14;
        Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object != false && (object = (Object)this.mTransitionInstantly) != false) {
            this.mTransitionLastPosition = f14;
        }
        if ((f12 = (f11 = (f13 = this.mTransitionLastPosition) - f10) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) == false) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f10;
        this.mTransitionDuration = f10 = (float)motionScene.getDuration() / 1000.0f;
        f10 = this.mTransitionGoalPosition;
        this.setProgress(f10);
        this.mInterpolator = interpolator2 = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = l10 = this.getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f13;
        this.mTransitionLastPosition = f13;
        this.invalidate();
    }

    public void disableAutoTransition(boolean bl2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(bl2);
    }

    public void dispatchDraw(Canvas canvas) {
        int n10;
        int n11 = 0;
        MotionLayout$DevModeDraw motionLayout$DevModeDraw = null;
        this.evaluate(false);
        super.dispatchDraw(canvas);
        Object object = this.mScene;
        if (object == null) {
            return;
        }
        int n12 = this.mDebugPath;
        int n13 = 1;
        if ((n12 &= n13) == n13 && (n12 = (int)(this.isInEditMode() ? 1 : 0)) == 0) {
            int n14;
            float f10;
            float f11;
            this.mFrames = n12 = this.mFrames + n13;
            long l10 = this.getNanoTime();
            long l11 = this.mLastDrawTime;
            long l12 = -1;
            long l13 = l11 - l12;
            n12 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n12 != 0) {
                l12 = 200000000L;
                long l14 = (l11 = l10 - l11) - l12;
                n12 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
                if (n12 > 0) {
                    f11 = this.mFrames;
                    f10 = l11;
                    float f12 = 1.0E-9f;
                    n14 = 1120403456;
                    f10 = 100.0f;
                    n12 = (int)((f11 /= (f10 *= f12)) * f10);
                    this.mLastFps = f11 = (float)n12 / f10;
                    this.mFrames = 0;
                    this.mLastDrawTime = l10;
                }
            } else {
                this.mLastDrawTime = l10;
            }
            motionLayout$DevModeDraw = new Paint();
            motionLayout$DevModeDraw.setTextSize(42.0f);
            f11 = (int)(this.getProgress() * 1000.0f);
            n10 = 1092616192;
            float f13 = 10.0f;
            CharSequence charSequence = new StringBuilder();
            f10 = this.mLastFps;
            charSequence.append(f10);
            charSequence.append(" fps ");
            n14 = this.mBeginState;
            CharSequence charSequence2 = Debug.getState(this, n14);
            charSequence.append((String)charSequence2);
            charSequence.append(" -> ");
            charSequence = charSequence.toString();
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            int n15 = this.mEndState;
            charSequence = Debug.getState(this, n15);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence = " (progress: ";
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(f11 /= f13);
            object = " ) state=";
            ((StringBuilder)charSequence2).append((String)object);
            n12 = this.mCurrentState;
            n15 = -1;
            float f14 = 0.0f / 0.0f;
            object = n12 == n15 ? "undefined" : Debug.getState(this, n12);
            ((StringBuilder)charSequence2).append((String)object);
            object = ((StringBuilder)charSequence2).toString();
            motionLayout$DevModeDraw.setColor(-16777216);
            n14 = this.getHeight() + -29;
            f10 = n14;
            canvas.drawText((String)object, 11.0f, f10, (Paint)motionLayout$DevModeDraw);
            motionLayout$DevModeDraw.setColor(-7864184);
            n15 = this.getHeight() + -30;
            f14 = n15;
            canvas.drawText((String)object, f13, f14, (Paint)motionLayout$DevModeDraw);
        }
        if ((n11 = this.mDebugPath) > n13) {
            motionLayout$DevModeDraw = this.mDevModeDraw;
            if (motionLayout$DevModeDraw == null) {
                this.mDevModeDraw = motionLayout$DevModeDraw = new MotionLayout$DevModeDraw(this);
            }
            motionLayout$DevModeDraw = this.mDevModeDraw;
            object = this.mFrameArrayList;
            MotionScene motionScene = this.mScene;
            n13 = motionScene.getDuration();
            n10 = this.mDebugPath;
            motionLayout$DevModeDraw.draw(canvas, (HashMap)object, n13, n10);
        }
    }

    public void enableTransition(int n10, boolean bl2) {
        MotionScene$Transition motionScene$Transition = this.getTransition(n10);
        if (bl2) {
            motionScene$Transition.setEnable(true);
            return;
        }
        Object object = this.mScene;
        MotionScene$Transition motionScene$Transition2 = ((MotionScene)object).mCurrentTransition;
        if (motionScene$Transition == motionScene$Transition2) {
            int n11 = this.mCurrentState;
            object = ((MotionScene)object).getTransitionsWithState(n11).iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                motionScene$Transition2 = (MotionScene$Transition)object.next();
                boolean bl3 = motionScene$Transition2.isEnabled();
                if (!bl3) continue;
                object = this.mScene;
                ((MotionScene)object).mCurrentTransition = motionScene$Transition2;
                break;
            }
        }
        motionScene$Transition.setEnable(false);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void evaluate(boolean bl2) {
        boolean bl3;
        boolean bl4;
        int n10;
        float f10;
        MotionLayout motionLayout;
        block41: {
            float f11;
            float f12;
            int n11;
            block40: {
                int n12;
                block39: {
                    float f13;
                    float f14;
                    float f15;
                    block35: {
                        float f16;
                        float f17;
                        float f18;
                        float f19;
                        boolean bl5;
                        boolean bl6;
                        boolean bl7;
                        boolean bl8;
                        int n13;
                        double d10;
                        double d11;
                        double d12;
                        double d13;
                        void var10_34;
                        float f20;
                        float f21;
                        float f22;
                        float f23;
                        float f24;
                        float f25;
                        float f26;
                        float f27;
                        float f28;
                        float f29;
                        float f30;
                        float f31;
                        float f32;
                        float f33;
                        float f34;
                        float f35;
                        float f36;
                        int n14;
                        View view;
                        float f37;
                        int n15;
                        int n16;
                        long l10;
                        float f38;
                        int n17;
                        int n18;
                        block36: {
                            block38: {
                                Interpolator interpolator2;
                                float f39;
                                Interpolator interpolator3;
                                float f40;
                                block37: {
                                    float f41;
                                    float f42;
                                    float f43;
                                    float f44;
                                    float f45;
                                    float f46;
                                    float f47;
                                    float f48;
                                    float f49;
                                    float f50;
                                    float f51;
                                    boolean bl9;
                                    float f52;
                                    motionLayout = this;
                                    long l11 = this.mTransitionLastTime;
                                    long l12 = -1;
                                    long l13 = l11 - l12;
                                    Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                                    if (object == false) {
                                        this.mTransitionLastTime = l11 = this.getNanoTime();
                                    }
                                    f10 = motionLayout.mTransitionLastPosition;
                                    n12 = 0;
                                    float f53 = f10 - 0.0f;
                                    float f54 = f53 == 0.0f ? 0 : (f53 > 0.0f ? 1 : -1);
                                    n18 = -1;
                                    f40 = 0.0f / 0.0f;
                                    n17 = 1065353216;
                                    f38 = 1.0f;
                                    if (f54 > 0 && (f52 = f10 == f38 ? 0 : (f10 < f38 ? -1 : 1)) < 0) {
                                        motionLayout.mCurrentState = n18;
                                    }
                                    boolean bl10 = motionLayout.mKeepAnimating;
                                    n11 = 1;
                                    f12 = Float.MIN_VALUE;
                                    n10 = 0;
                                    f11 = 0.0f;
                                    if (!bl10 && (!(bl9 = motionLayout.mInTransition) || !bl2 && (f51 = (f50 = (f15 = motionLayout.mTransitionGoalPosition) - f10) == 0.0f ? 0 : (f50 > 0.0f ? 1 : -1)) == false)) break block35;
                                    f15 = motionLayout.mTransitionGoalPosition - f10;
                                    f10 = Math.signum(f15);
                                    l10 = this.getNanoTime();
                                    interpolator3 = motionLayout.mInterpolator;
                                    n16 = interpolator3 instanceof MotionInterpolator;
                                    n15 = 814313567;
                                    float f55 = 1.0E-9f;
                                    if (n16 == 0) {
                                        long l14 = motionLayout.mTransitionLastTime;
                                        l14 = l10 - l14;
                                        f39 = (float)l14 * f10 * f55;
                                        f37 = motionLayout.mTransitionDuration;
                                        motionLayout.mLastVelocity = f39 /= f37;
                                    } else {
                                        n16 = 0;
                                        view = null;
                                        f39 = 0.0f;
                                    }
                                    f37 = motionLayout.mTransitionLastPosition + f39;
                                    n14 = motionLayout.mTransitionInstantly;
                                    if (n14 != 0) {
                                        f37 = motionLayout.mTransitionGoalPosition;
                                    }
                                    if ((n14 = (f49 = f10 - 0.0f) == 0.0f ? 0 : (f49 > 0.0f ? 1 : -1)) > 0 && (f48 = (f47 = f37 - (f46 = motionLayout.mTransitionGoalPosition)) == 0.0f ? 0 : (f47 > 0.0f ? 1 : -1)) >= 0 || (f48 = (f45 = f10 - 0.0f) == 0.0f ? 0 : (f45 < 0.0f ? -1 : 1)) <= 0 && (f48 = (f44 = f37 - (f46 = motionLayout.mTransitionGoalPosition)) == 0.0f ? 0 : (f44 < 0.0f ? -1 : 1)) <= 0) {
                                        f37 = motionLayout.mTransitionGoalPosition;
                                        motionLayout.mInTransition = false;
                                        f48 = n11;
                                        f46 = f12;
                                    } else {
                                        f48 = 0.0f;
                                        f46 = 0.0f;
                                    }
                                    motionLayout.mTransitionLastPosition = f37;
                                    motionLayout.mTransitionPosition = f37;
                                    motionLayout.mTransitionLastTime = l10;
                                    f36 = 1.0E-5f;
                                    if (interpolator3 == null || f48 != false) break block36;
                                    f48 = (float)motionLayout.mTemporalInterpolator;
                                    if (f48 == false) break block37;
                                    long l15 = motionLayout.mAnimationStartTime;
                                    l15 = l10 - l15;
                                    f40 = (float)l15 * f55;
                                    motionLayout.mTransitionLastPosition = f15 = interpolator3.getInterpolation(f40);
                                    motionLayout.mTransitionLastTime = l10;
                                    interpolator2 = motionLayout.mInterpolator;
                                    n17 = interpolator2 instanceof MotionInterpolator;
                                    if (n17 == 0) break block38;
                                    interpolator2 = (MotionInterpolator)interpolator2;
                                    motionLayout.mLastVelocity = f40 = interpolator2.getVelocity();
                                    f38 = Math.abs(f40);
                                    float f56 = motionLayout.mTransitionDuration;
                                    float f57 = (f38 *= f56) - f36;
                                    n17 = (int)(f57 == 0.0f ? 0 : (f57 < 0.0f ? -1 : 1));
                                    if (n17 <= 0) {
                                        motionLayout.mInTransition = false;
                                    }
                                    if ((n17 = (int)((f43 = f40 - 0.0f) == 0.0f ? 0 : (f43 > 0.0f ? 1 : -1))) > 0) {
                                        n17 = 1065353216;
                                        f38 = 1.0f;
                                        float f58 = f15 - f38;
                                        Object object2 = f58 == 0.0f ? 0 : (f58 > 0.0f ? 1 : -1);
                                        if (object2 >= 0) {
                                            motionLayout.mTransitionLastPosition = f38;
                                            motionLayout.mInTransition = false;
                                            int n19 = 1065353216;
                                            f15 = 1.0f;
                                        }
                                    }
                                    if ((n18 = (int)((f42 = f40 - 0.0f) == 0.0f ? 0 : (f42 < 0.0f ? -1 : 1))) >= 0 || (n18 = (int)((f41 = f15 - 0.0f) == 0.0f ? 0 : (f41 < 0.0f ? -1 : 1))) > 0) break block38;
                                    motionLayout.mTransitionLastPosition = 0.0f;
                                    motionLayout.mInTransition = false;
                                    f37 = 0.0f;
                                    break block36;
                                }
                                f15 = interpolator3.getInterpolation(f37);
                                interpolator2 = motionLayout.mInterpolator;
                                n17 = interpolator2 instanceof MotionInterpolator;
                                if (n17 != 0) {
                                    interpolator2 = (MotionInterpolator)interpolator2;
                                    motionLayout.mLastVelocity = f40 = interpolator2.getVelocity();
                                } else {
                                    motionLayout.mLastVelocity = f40 = (interpolator2.getInterpolation(f37 += f39) - f15) * f10 / f39;
                                }
                            }
                            f37 = f15;
                        }
                        if ((f35 = (f34 = (f15 = Math.abs(motionLayout.mLastVelocity)) - f36) == 0.0f ? 0 : (f34 > 0.0f ? 1 : -1)) > 0) {
                            MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.MOVING;
                            motionLayout.setState(motionLayout$TransitionState);
                        }
                        if (n14 > 0 && (f33 = (f32 = f37 - (f15 = motionLayout.mTransitionGoalPosition)) == 0.0f ? 0 : (f32 > 0.0f ? 1 : -1)) >= 0 || (f31 = (f30 = f10 - 0.0f) == 0.0f ? 0 : (f30 < 0.0f ? -1 : 1)) <= 0 && (f29 = (f28 = f37 - (f15 = motionLayout.mTransitionGoalPosition)) == 0.0f ? 0 : (f28 < 0.0f ? -1 : 1)) <= 0) {
                            f37 = motionLayout.mTransitionGoalPosition;
                            motionLayout.mInTransition = false;
                        }
                        int n20 = 1065353216;
                        f15 = 1.0f;
                        float f59 = f37 - f15;
                        n18 = (int)(f59 == 0.0f ? 0 : (f59 > 0.0f ? 1 : -1));
                        if (n18 >= 0 || (f27 = (f26 = f37 - 0.0f) == 0.0f ? 0 : (f26 < 0.0f ? -1 : 1)) <= 0) {
                            motionLayout.mInTransition = false;
                            MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                            motionLayout.setState(motionLayout$TransitionState);
                        }
                        int n21 = this.getChildCount();
                        motionLayout.mKeepAnimating = false;
                        l10 = this.getNanoTime();
                        motionLayout.mPostInterpolationPosition = f37;
                        Object object = null;
                        f38 = 0.0f;
                        for (n17 = 0; n17 < n21; ++n17) {
                            Object v10;
                            view = motionLayout.getChildAt(n17);
                            Object v11 = v10 = motionLayout.mFrameArrayList.get(view);
                            MotionController motionController = (MotionController)v10;
                            if (motionController == null) continue;
                            n15 = (int)(motionLayout.mKeepAnimating ? 1 : 0);
                            KeyCache keyCache = motionLayout.mKeyCache;
                            n16 = motionController.interpolate(view, f37, l10, keyCache) | n15;
                            motionLayout.mKeepAnimating = n16;
                        }
                        if (n14 > 0 && (f25 = (f24 = f37 - (f15 = motionLayout.mTransitionGoalPosition)) == 0.0f ? 0 : (f24 > 0.0f ? 1 : -1)) >= 0 || (f23 = (f22 = f10 - 0.0f) == 0.0f ? 0 : (f22 < 0.0f ? -1 : 1)) <= 0 && (f21 = (f20 = f37 - (f15 = motionLayout.mTransitionGoalPosition)) == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1)) <= 0) {
                            int n22 = n11;
                            f15 = f12;
                        } else {
                            boolean bl11 = false;
                            Object var22_62 = null;
                            f15 = 0.0f;
                        }
                        n17 = (int)(motionLayout.mKeepAnimating ? 1 : 0);
                        if (n17 == 0 && (n17 = (int)(motionLayout.mInTransition ? 1 : 0)) == 0 && var10_34 != false) {
                            object = MotionLayout$TransitionState.FINISHED;
                            motionLayout.setState((MotionLayout$TransitionState)((Object)object));
                        }
                        if ((n17 = (int)(motionLayout.mMeasureDuringTransition ? 1 : 0)) != 0) {
                            this.requestLayout();
                        }
                        n17 = (int)(motionLayout.mKeepAnimating ? 1 : 0);
                        int n23 = var10_34 ^ n11 | n17;
                        motionLayout.mKeepAnimating = n23;
                        float f60 = f37 - 0.0f;
                        Object object3 = f60 == 0.0f ? 0 : (f60 < 0.0f ? -1 : 1);
                        if (object3 <= 0) {
                            int n24 = motionLayout.mBeginState;
                            n17 = -1;
                            f38 = 0.0f / 0.0f;
                            if (n24 != n17 && (n17 = motionLayout.mCurrentState) != n24) {
                                motionLayout.mCurrentState = n24;
                                object = motionLayout.mScene;
                                ((MotionScene)object).getConstraintSet(n24).applyCustomAttributes(motionLayout);
                                MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                                motionLayout.setState(motionLayout$TransitionState);
                                n10 = n11;
                                f11 = f12;
                            }
                        }
                        if ((d13 = (d12 = (d11 = (double)f37) - (d10 = 1.0)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) >= 0 && (n13 = motionLayout.mCurrentState) != (n17 = motionLayout.mEndState)) {
                            motionLayout.mCurrentState = n17;
                            motionLayout.mScene.getConstraintSet(n17).applyCustomAttributes(motionLayout);
                            MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                            motionLayout.setState(motionLayout$TransitionState);
                            n10 = n11;
                            f11 = f12;
                        }
                        if (!(bl8 = motionLayout.mKeepAnimating) && !(bl7 = motionLayout.mInTransition)) {
                            float f61;
                            float f62;
                            float f63;
                            float f64;
                            if (n14 > 0 && n18 == 0 || (f64 = (f63 = f10 - 0.0f) == 0.0f ? 0 : (f63 < 0.0f ? -1 : 1)) < 0 && (f62 = (f61 = f37 - 0.0f) == 0.0f ? 0 : (f61 > 0.0f ? 1 : -1)) == false) {
                                MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                                motionLayout.setState(motionLayout$TransitionState);
                            }
                        } else {
                            this.invalidate();
                        }
                        if (!(bl6 = motionLayout.mKeepAnimating) && (bl5 = motionLayout.mInTransition) && n14 > 0 && n18 == 0 || (f19 = (f18 = f10 - 0.0f) == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1)) < 0 && (f17 = (f16 = f37 - 0.0f) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) == false) {
                            this.onNewStateAttachHandlers();
                        }
                    }
                    if ((f14 = (f13 = (f10 = motionLayout.mTransitionLastPosition) - (f15 = 1.0f)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) < 0) break block39;
                    int n25 = motionLayout.mCurrentState;
                    n12 = motionLayout.mEndState;
                    if (n25 == n12) {
                        n11 = n10;
                        f12 = f11;
                    }
                    motionLayout.mCurrentState = n12;
                    break block40;
                }
                float f65 = f10 - 0.0f;
                Object object = f65 == 0.0f ? 0 : (f65 < 0.0f ? -1 : 1);
                if (object > 0) break block41;
                int n26 = motionLayout.mCurrentState;
                n12 = motionLayout.mBeginState;
                if (n26 == n12) {
                    n11 = n10;
                    f12 = f11;
                }
                motionLayout.mCurrentState = n12;
            }
            n10 = n11;
            f11 = f12;
        }
        motionLayout.mNeedsFireTransitionCompleted = bl4 = motionLayout.mNeedsFireTransitionCompleted | n10;
        if (n10 != 0 && !(bl3 = motionLayout.mInLayout)) {
            this.requestLayout();
        }
        motionLayout.mTransitionPosition = f10 = motionLayout.mTransitionLastPosition;
    }

    public void fireTransitionCompleted() {
        int n10;
        int n11;
        Object object = this.mTransitionListener;
        if ((object != null || (object = this.mTransitionListeners) != null && (n11 = (int)(((ArrayList)object).isEmpty() ? 1 : 0)) == 0) && (n11 = this.mListenerState) == (n10 = -1)) {
            int n12;
            this.mListenerState = n11 = this.mCurrentState;
            object = this.mTransitionCompleted;
            n11 = (int)(((ArrayList)object).isEmpty() ? 1 : 0);
            if (n11 == 0) {
                object = this.mTransitionCompleted;
                n12 = ((ArrayList)object).size() + -1;
                object = (Integer)((ArrayList)object).get(n12);
                n11 = (Integer)object;
            } else {
                n11 = n10;
            }
            n12 = this.mCurrentState;
            if (n11 != n12 && n12 != n10) {
                object = this.mTransitionCompleted;
                Integer n13 = n12;
                ((ArrayList)object).add(n13);
            }
        }
        this.processTransitionCompleted();
    }

    public void fireTrigger(int n10, boolean bl2, float f10) {
        Object object = this.mTransitionListener;
        if (object != null) {
            object.onTransitionTrigger(this, n10, bl2, f10);
        }
        if ((object = this.mTransitionListeners) != null) {
            boolean bl3;
            object = ((ArrayList)object).iterator();
            while (bl3 = object.hasNext()) {
                MotionLayout$TransitionListener motionLayout$TransitionListener = (MotionLayout$TransitionListener)object.next();
                motionLayout$TransitionListener.onTransitionTrigger(this, n10, bl2, f10);
            }
        }
    }

    public void getAnchorDpDt(int n10, float f10, float f11, float f12, float[] fArray) {
        HashMap hashMap = this.mFrameArrayList;
        View view = this.getViewById(n10);
        if ((hashMap = (MotionController)hashMap.get(view)) != null) {
            hashMap.getDpDt(f10, f11, f12, fArray);
            float f13 = view.getY();
            f11 = this.lastPos;
            f11 = f10 - f11;
            f12 = 0.0f;
            float f14 = f11 - 0.0f;
            Object cfr_ignored_1 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            this.lastPos = f10;
            this.lastY = f13;
        } else {
            String string2;
            String string3;
            CharSequence charSequence;
            if (view == null) {
                charSequence = new StringBuilder();
                string3 = "";
                charSequence.append(string3);
                charSequence.append(n10);
                string2 = charSequence.toString();
            } else {
                charSequence = view.getContext().getResources();
                string2 = charSequence.getResourceName(n10);
            }
            charSequence = new StringBuilder();
            string3 = "WARNING could not find view id ";
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = charSequence.toString();
            charSequence = TAG;
            Log.w((String)charSequence, (String)string2);
        }
    }

    public ConstraintSet getConstraintSet(int n10) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSet(n10);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public String getConstraintSetNames(int n10) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(n10);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    /*
     * WARNING - void declaration
     */
    public void getDebugMode(boolean bl2) {
        void var1_4;
        if (bl2) {
            int n10 = 2;
        } else {
            boolean bl3 = true;
        }
        this.mDebugPath = var1_4;
        this.invalidate();
    }

    public ArrayList getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        DesignTool designTool = this.mDesignTool;
        if (designTool == null) {
            this.mDesignTool = designTool = new DesignTool(this);
        }
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    public long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene$Transition getTransition(int n10) {
        return this.mScene.getTransitionById(n10);
    }

    public Bundle getTransitionState() {
        MotionLayout$StateCache motionLayout$StateCache = this.mStateCache;
        if (motionLayout$StateCache == null) {
            this.mStateCache = motionLayout$StateCache = new MotionLayout$StateCache(this);
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        float f10 = 1000.0f;
        if (motionScene != null) {
            float f11;
            int n10 = motionScene.getDuration();
            this.mTransitionDuration = f11 = (float)n10 / f10;
        }
        return (long)(this.mTransitionDuration * f10);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f10, float f11, float[] fArray, int n10) {
        float f12;
        float f13 = this.mLastVelocity;
        float f14 = this.mTransitionLastPosition;
        Interpolator interpolator2 = this.mInterpolator;
        if (interpolator2 != null) {
            f13 = 1.0E-5f;
            f14 = Math.signum(this.mTransitionGoalPosition - f14);
            interpolator2 = this.mInterpolator;
            float f15 = this.mTransitionLastPosition + f13;
            f12 = interpolator2.getInterpolation(f15);
            Interpolator interpolator3 = this.mInterpolator;
            float f16 = this.mTransitionLastPosition;
            f15 = interpolator3.getInterpolation(f16);
            f12 = (f12 - f15) / f13;
            f13 = this.mTransitionDuration;
            f13 = (f14 *= f12) / f13;
            f12 = f15;
        } else {
            f12 = f14;
        }
        Interpolator interpolator4 = this.mInterpolator;
        int n11 = interpolator4 instanceof MotionInterpolator;
        if (n11 != 0) {
            interpolator4 = (MotionInterpolator)interpolator4;
            f13 = interpolator4.getVelocity();
        }
        interpolator4 = (MotionController)this.mFrameArrayList.get(view);
        n11 = n10 & 1;
        if (n11 == 0) {
            n11 = view.getWidth();
            int n12 = view.getHeight();
            interpolator4.getPostLayoutDvDp(f12, n11, n12, f10, f11, fArray);
        } else {
            interpolator4.getDpDt(f12, f10, f11, fArray);
        }
        int n13 = 2;
        if (n10 < n13) {
            view = null;
            fArray[0] = f10 = fArray[0] * f13;
            n13 = 1;
            fArray[n13] = f10 = fArray[n13] * f13;
        }
    }

    public boolean isAttachedToWindow() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return super.isAttachedToWindow();
        }
        IBinder iBinder = this.getWindowToken();
        if (iBinder != null) {
            n10 = 1;
        } else {
            n10 = 0;
            iBinder = null;
        }
        return n10 != 0;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public void loadLayoutDescription(int n10) {
        block20: {
            if (n10 != 0) {
                Object object;
                Object object2;
                block19: {
                    try {
                        object2 = this.getContext();
                    }
                    catch (Exception exception) {
                        object = new IllegalArgumentException("unable to parse MotionScene file", exception);
                        throw object;
                    }
                    object = new MotionScene((Context)object2, this, n10);
                    this.mScene = object;
                    n10 = Build.VERSION.SDK_INT;
                    int bl2 = 19;
                    if (n10 < bl2) break block19;
                    n10 = (int)(this.isAttachedToWindow() ? 1 : 0);
                    if (n10 == 0) break block20;
                }
                Object exception = this.mScene;
                ((MotionScene)exception).readFallback(this);
                exception = this.mModel;
                object = this.mLayoutWidget;
                object2 = this.mScene;
                int n11 = this.mBeginState;
                object2 = ((MotionScene)object2).getConstraintSet(n11);
                Object object3 = this.mScene;
                int n12 = this.mEndState;
                object3 = ((MotionScene)object3).getConstraintSet(n12);
                ((MotionLayout$Model)exception).initFrom((ConstraintWidgetContainer)object, (ConstraintSet)object2, (ConstraintSet)object3);
                this.rebuildScene();
                exception = this.mScene;
                boolean bl2 = this.isRtl();
                ((MotionScene)exception).setRtl(bl2);
            }
            n10 = 0;
            Object var5_8 = null;
            this.mScene = null;
        }
    }

    public int lookUpConstraintId(String string2) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(string2);
    }

    public MotionLayout$MotionTracker obtainVelocityTracker() {
        return MotionLayout$MyTracker.obtain();
    }

    public void onAttachedToWindow() {
        int n10;
        int n11;
        int n12;
        super.onAttachedToWindow();
        Object object = this.mScene;
        if (object != null && (n12 = this.mCurrentState) != (n11 = -1)) {
            object = ((MotionScene)object).getConstraintSet(n12);
            MotionScene motionScene = this.mScene;
            motionScene.readFallback(this);
            if (object != null) {
                ((ConstraintSet)object).applyTo(this);
            }
            this.mBeginState = n10 = this.mCurrentState;
        }
        this.onNewStateAttachHandlers();
        object = this.mStateCache;
        if (object != null) {
            ((MotionLayout$StateCache)object).apply();
        } else {
            object = this.mScene;
            if (object != null && (object = ((MotionScene)object).mCurrentTransition) != null && (n10 = ((MotionScene$Transition)object).getAutoTransition()) == (n12 = 4)) {
                this.transitionToEnd();
                object = MotionLayout$TransitionState.SETUP;
                this.setState((MotionLayout$TransitionState)((Object)object));
                object = MotionLayout$TransitionState.MOVING;
                this.setState((MotionLayout$TransitionState)((Object)object));
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int n10;
        Object object = this.mScene;
        if (object != null && (n10 = this.mInteractionEnabled) != 0 && (object = ((MotionScene)object).mCurrentTransition) != null && (n10 = ((MotionScene$Transition)object).isEnabled()) != 0 && (object = ((MotionScene$Transition)object).getTouchResponse()) != null) {
            float f10;
            float f11;
            RectF rectF;
            n10 = motionEvent.getAction();
            if (n10 == 0) {
                rectF = new RectF();
                if ((rectF = ((TouchResponse)object).getTouchRegion(this, rectF)) != null && (n10 = (int)(rectF.contains(f11 = motionEvent.getX(), f10 = motionEvent.getY()) ? 1 : 0)) == 0) {
                    return false;
                }
            }
            int n11 = ((TouchResponse)object).getTouchRegionId();
            n10 = -1;
            float f12 = 0.0f / 0.0f;
            if (n11 != n10) {
                rectF = this.mRegionView;
                if (rectF == null || (n10 = rectF.getId()) != n11) {
                    object = this.findViewById(n11);
                    this.mRegionView = object;
                }
                if ((object = this.mRegionView) != null) {
                    rectF = this.mBoundsCheck;
                    float f13 = object.getLeft();
                    View view = this.mRegionView;
                    int n12 = view.getTop();
                    f11 = n12;
                    View view2 = this.mRegionView;
                    int n13 = view2.getRight();
                    f10 = n13;
                    View view3 = this.mRegionView;
                    int n14 = view3.getBottom();
                    float f14 = n14;
                    rectF.set(f13, f11, f10, f14);
                    object = this.mBoundsCheck;
                    f12 = motionEvent.getX();
                    f11 = motionEvent.getY();
                    n11 = (int)(object.contains(f12, f11) ? 1 : 0);
                    if (n11 != 0) {
                        object = this.mRegionView;
                        n10 = 0;
                        f12 = 0.0f;
                        rectF = null;
                        n11 = (int)(this.handlesTouchEvent(0.0f, 0.0f, (View)object, motionEvent) ? 1 : 0);
                        if (n11 == 0) {
                            return this.onTouchEvent(motionEvent);
                        }
                    }
                }
            }
        }
        return false;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        block14: {
            boolean bl2;
            block13: {
                block12: {
                    this.mInLayout = bl2 = true;
                    MotionScene motionScene = this.mScene;
                    if (motionScene != null) break block12;
                    super.onLayout(n10 != 0, n11, n12, n13, n14);
                    return;
                }
                n13 -= n11;
                n14 -= n12;
                n10 = this.mLastLayoutWidth;
                if (n10 != n13) break block13;
                n10 = this.mLastLayoutHeight;
                if (n10 == n14) break block14;
            }
            this.rebuildScene();
            this.evaluate(bl2);
        }
        this.mLastLayoutWidth = n13;
        this.mLastLayoutHeight = n14;
        this.mOldWidth = n13;
        try {
            this.mOldHeight = n14;
            this.mInLayout = false;
            return;
        }
        finally {
            this.mInLayout = false;
        }
    }

    public void onMeasure(int n10, int n11) {
        ConstraintWidgetContainer constraintWidgetContainer;
        int n12;
        float f10;
        Object object = this.mScene;
        if (object == null) {
            super.onMeasure(n10, n11);
            return;
        }
        int n13 = this.mLastWidthMeasureSpec;
        int n14 = 0;
        float f11 = 0.0f;
        int n15 = 1;
        float f12 = Float.MIN_VALUE;
        if (n13 == n10 && (n13 = this.mLastHeightMeasureSpec) == n11) {
            n13 = 0;
            object = null;
            f10 = 0.0f;
        } else {
            n13 = n15;
            f10 = f12;
        }
        int n16 = this.mNeedsFireTransitionCompleted;
        if (n16 != 0) {
            this.mNeedsFireTransitionCompleted = false;
            this.onNewStateAttachHandlers();
            this.processTransitionCompleted();
            n13 = n15;
            f10 = f12;
        }
        if ((n16 = this.mDirtyHierarchy) != 0) {
            n13 = n15;
            f10 = f12;
        }
        this.mLastWidthMeasureSpec = n10;
        this.mLastHeightMeasureSpec = n11;
        MotionScene motionScene = this.mScene;
        n16 = motionScene.getStartId();
        MotionScene motionScene2 = this.mScene;
        int n17 = motionScene2.getEndId();
        if ((n13 != 0 || (n13 = (int)(((MotionLayout$Model)(object = this.mModel)).isNotConfiguredWith(n16, n17) ? 1 : 0)) != 0) && (n13 = this.mBeginState) != (n12 = -1)) {
            super.onMeasure(n10, n11);
            MotionLayout$Model motionLayout$Model = this.mModel;
            constraintWidgetContainer = this.mLayoutWidget;
            object = this.mScene.getConstraintSet(n16);
            ConstraintSet constraintSet = this.mScene.getConstraintSet(n17);
            motionLayout$Model.initFrom(constraintWidgetContainer, (ConstraintSet)object, constraintSet);
            this.mModel.reEvaluateState();
            motionLayout$Model = this.mModel;
            motionLayout$Model.setMeasuredId(n16, n17);
        } else {
            n14 = n15;
            f11 = f12;
        }
        n10 = (int)(this.mMeasureDuringTransition ? 1 : 0);
        if (n10 != 0 || n14 != 0) {
            float f13;
            n10 = this.getPaddingTop();
            n11 = this.getPaddingBottom();
            n10 += n11;
            n11 = this.getPaddingLeft();
            n13 = this.getPaddingRight();
            n11 += n13;
            object = this.mLayoutWidget;
            n13 = ((ConstraintWidget)object).getWidth() + n11;
            constraintWidgetContainer = this.mLayoutWidget;
            n11 = constraintWidgetContainer.getHeight() + n10;
            n10 = this.mWidthMeasureMode;
            n14 = -1 << -1;
            f11 = -0.0f;
            if (n10 == n14 || n10 == 0) {
                n10 = this.mStartWrapWidth;
                f10 = n10;
                f12 = this.mPostInterpolationPosition;
                n16 = this.mEndWrapWidth - n10;
                f13 = n16;
                n13 = (int)(f10 += (f12 *= f13));
                this.requestLayout();
            }
            if ((n10 = this.mHeightMeasureMode) == n14 || n10 == 0) {
                n10 = this.mStartWrapHeight;
                float f14 = n10;
                f11 = this.mPostInterpolationPosition;
                n15 = this.mEndWrapHeight - n10;
                f13 = n15;
                n11 = (int)(f14 += (f11 *= f13));
                this.requestLayout();
            }
            this.setMeasuredDimension(n13, n11);
        }
        this.evaluateLayout();
    }

    public boolean onNestedFling(View view, float f10, float f11, boolean bl2) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    public void onNestedPreScroll(View view, int n10, int n11, int[] nArray, int n12) {
        Object object = this.mScene;
        if (object != null && (object = ((MotionScene)object).mCurrentTransition) != null) {
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            int n13;
            Object object2;
            int n14;
            n12 = (int)(((MotionScene$Transition)object).isEnabled() ? 1 : 0);
            if (n12 == 0) {
                return;
            }
            object = this.mScene.mCurrentTransition;
            int n15 = -1;
            if (object != null && (n14 = ((MotionScene$Transition)object).isEnabled()) != 0 && (object2 = ((MotionScene$Transition)object).getTouchResponse()) != null && (n14 = ((TouchResponse)object2).getTouchRegionId()) != n15 && (n13 = view.getId()) != n14) {
                return;
            }
            object2 = this.mScene;
            n13 = 1065353216;
            float f17 = 1.0f;
            if (object2 != null && (n14 = ((MotionScene)object2).getMoveWhenScrollAtTop()) != 0 && ((f16 = (f15 = (f14 = this.mTransitionPosition) - f17) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) == false || (n14 = (int)((f13 = f14 - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) == 0) && (n15 = (int)(view.canScrollVertically(n15) ? 1 : 0)) != 0) {
                return;
            }
            object = ((MotionScene$Transition)object).getTouchResponse();
            n15 = 0;
            n14 = 1;
            f14 = Float.MIN_VALUE;
            if (object != null && (n12 = ((TouchResponse)(object = this.mScene.mCurrentTransition.getTouchResponse())).getFlags() & n14) != 0) {
                float f18;
                float f19;
                object = this.mScene;
                f12 = n10;
                f11 = n11;
                f10 = ((MotionScene)object).getProgressDirection(f12, f11);
                f12 = this.mTransitionLastPosition;
                float f20 = f12 - 0.0f;
                Object object3 = f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1);
                if (object3 <= 0 && (object3 = (f19 = f10 - 0.0f) == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1)) < 0 || (n13 = (int)(f12 == f17 ? 0 : (f12 > f17 ? 1 : -1))) >= 0 && (n12 = (int)((f18 = f10 - 0.0f) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) > 0) {
                    n10 = Build.VERSION.SDK_INT;
                    n11 = 21;
                    if (n10 >= n11) {
                        view.setNestedScrollingEnabled(false);
                        MotionLayout$1 motionLayout$1 = new MotionLayout$1(this, view);
                        view.post((Runnable)motionLayout$1);
                    }
                    return;
                }
            }
            float f21 = this.mTransitionPosition;
            long l10 = this.getNanoTime();
            this.mScrollTargetDX = f10 = (float)n10;
            this.mScrollTargetDY = f12 = (float)n11;
            long l11 = this.mScrollTargetTime;
            l11 = l10 - l11;
            double d10 = l11;
            double d11 = 1.0E-9;
            this.mScrollTargetDT = f11 = (float)(d10 *= d11);
            this.mScrollTargetTime = l10;
            MotionScene motionScene = this.mScene;
            motionScene.processScrollMove(f10, f12);
            f10 = this.mTransitionPosition;
            float f22 = f21 == f10 ? 0 : (f21 > f10 ? 1 : -1);
            if (f22 != false) {
                nArray[0] = n10;
                nArray[n14] = n11;
            }
            this.evaluate(false);
            f22 = nArray[0];
            if (f22 != false || (f22 = (float)nArray[n14]) != false) {
                this.mUndergoingMotion = n14;
            }
        }
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14) {
    }

    public void onNestedScroll(View view, int n10, int n11, int n12, int n13, int n14, int[] nArray) {
        int n15 = this.mUndergoingMotion;
        if (n15 != 0 || n10 != 0 || n11 != 0) {
            nArray[0] = n15 = nArray[0] + n12;
            n15 = 1;
            nArray[n15] = n10 = nArray[n15] + n13;
        }
        this.mUndergoingMotion = false;
    }

    public void onNestedScrollAccepted(View view, View view2, int n10, int n11) {
    }

    public void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        int n10 = this.mCurrentState;
        int n11 = motionScene.autoTransition(this, n10);
        if (n11 != 0) {
            this.requestLayout();
            return;
        }
        n11 = this.mCurrentState;
        n10 = -1;
        if (n11 != n10) {
            MotionScene motionScene2 = this.mScene;
            motionScene2.addOnClickListeners(this, n11);
        }
        if ((n11 = (int)((motionScene = this.mScene).supportTouch() ? 1 : 0)) != 0) {
            motionScene = this.mScene;
            motionScene.setupTouch();
        }
    }

    public void onRtlPropertiesChanged(int n10) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            boolean bl2 = this.isRtl();
            motionScene.setRtl(bl2);
        }
    }

    public boolean onStartNestedScroll(View object, View view, int n10, int n11) {
        int n12;
        object = this.mScene;
        return object != null && (object = ((MotionScene)object).mCurrentTransition) != null && (object = ((MotionScene$Transition)object).getTouchResponse()) != null && (n12 = ((TouchResponse)(object = this.mScene.mCurrentTransition.getTouchResponse())).getFlags() & 2) == 0;
        {
        }
    }

    public void onStopNestedScroll(View object, int n10) {
        object = this.mScene;
        if (object == null) {
            return;
        }
        float f10 = this.mScrollTargetDX;
        float f11 = this.mScrollTargetDT;
        float f12 = this.mScrollTargetDY / f11;
        ((MotionScene)object).processScrollUp(f10 /= f11, f12);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        int n10;
        Object object = this.mScene;
        if (object != null && (n10 = this.mInteractionEnabled) != 0 && (bl2 = ((MotionScene)object).supportTouch())) {
            object = this.mScene.mCurrentTransition;
            if (object != null && !(bl2 = ((MotionScene$Transition)object).isEnabled())) {
                return super.onTouchEvent(motionEvent);
            }
            object = this.mScene;
            n10 = this.getCurrentState();
            ((MotionScene)object).processTouchEvent(motionEvent, n10, this);
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        boolean bl2 = view instanceof MotionHelper;
        if (bl2) {
            view = (MotionHelper)view;
            ArrayList arrayList = this.mTransitionListeners;
            if (arrayList == null) {
                this.mTransitionListeners = arrayList = new ArrayList();
            }
            arrayList = this.mTransitionListeners;
            arrayList.add(view);
            bl2 = view.isUsedOnShow();
            if (bl2) {
                arrayList = this.mOnShowHelpers;
                if (arrayList == null) {
                    this.mOnShowHelpers = arrayList = new ArrayList();
                }
                arrayList = this.mOnShowHelpers;
                arrayList.add(view);
            }
            if (bl2 = view.isUseOnHide()) {
                arrayList = this.mOnHideHelpers;
                if (arrayList == null) {
                    this.mOnHideHelpers = arrayList = new ArrayList();
                }
                arrayList = this.mOnHideHelpers;
                arrayList.add(view);
            }
        }
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        if ((arrayList = this.mOnHideHelpers) != null) {
            arrayList.remove(view);
        }
    }

    public void parseLayoutDescription(int n10) {
        this.mConstraintLayoutSpec = null;
    }

    public void rebuildMotion() {
        Log.e((String)TAG, (String)"This method is deprecated. Please call rebuildScene() instead.");
        this.rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        this.invalidate();
    }

    public boolean removeTransitionListener(MotionLayout$TransitionListener motionLayout$TransitionListener) {
        ArrayList arrayList = this.mTransitionListeners;
        if (arrayList == null) {
            return false;
        }
        return arrayList.remove(motionLayout$TransitionListener);
    }

    public void requestLayout() {
        Object object;
        int n10;
        int n11 = this.mMeasureDuringTransition;
        if (n11 == 0 && (n11 = this.mCurrentState) == (n10 = -1) && (object = this.mScene) != null && (object = ((MotionScene)object).mCurrentTransition) != null && (n11 = ((MotionScene$Transition)object).getLayoutDuringTransition()) == 0) {
            return;
        }
        super.requestLayout();
    }

    public void setDebugMode(int n10) {
        this.mDebugPath = n10;
        this.invalidate();
    }

    public void setInteractionEnabled(boolean bl2) {
        this.mInteractionEnabled = bl2;
    }

    public void setInterpolatedProgress(float f10) {
        Object object = this.mScene;
        if (object != null) {
            object = MotionLayout$TransitionState.MOVING;
            this.setState((MotionLayout$TransitionState)((Object)object));
            object = this.mScene.getInterpolator();
            if (object != null) {
                f10 = object.getInterpolation(f10);
                this.setProgress(f10);
                return;
            }
        }
        this.setProgress(f10);
    }

    public void setOnHide(float f10) {
        ArrayList arrayList = this.mOnHideHelpers;
        if (arrayList != null) {
            int n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                MotionHelper motionHelper = (MotionHelper)this.mOnHideHelpers.get(i10);
                motionHelper.setProgress(f10);
            }
        }
    }

    public void setOnShow(float f10) {
        ArrayList arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            int n10 = arrayList.size();
            for (int i10 = 0; i10 < n10; ++i10) {
                MotionHelper motionHelper = (MotionHelper)this.mOnShowHelpers.get(i10);
                motionHelper.setProgress(f10);
            }
        }
    }

    public void setProgress(float f10) {
        long l10;
        float f11;
        Object object = 0;
        float f12 = 0.0f;
        Object object2 = null;
        float f13 = f10 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        float f15 = 1.0f;
        if (f14 < 0 || (f11 = f10 == f15 ? 0 : (f10 > f15 ? 1 : -1)) > 0) {
            String string2 = TAG;
            String string3 = "Warning! Progress is defined for values between 0.0 and 1.0 inclusive";
            Log.w((String)string2, (String)string3);
        }
        if ((f11 = (float)this.isAttachedToWindow()) == false) {
            object2 = this.mStateCache;
            if (object2 == null) {
                this.mStateCache = object2 = new MotionLayout$StateCache(this);
            }
            this.mStateCache.setProgress(f10);
            return;
        }
        if (f14 <= 0) {
            f14 = this.mBeginState;
            this.mCurrentState = (int)f14;
            float f16 = this.mTransitionLastPosition;
            float f17 = f16 - 0.0f;
            object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (object == 0) {
                object2 = MotionLayout$TransitionState.FINISHED;
                this.setState((MotionLayout$TransitionState)((Object)object2));
            }
        } else {
            object = f10 == f15 ? 0 : (f10 > f15 ? 1 : -1);
            if (object >= 0) {
                this.mCurrentState = object = this.mEndState;
                f12 = this.mTransitionLastPosition;
                float f18 = f12 - f15;
                object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
                if (object == 0) {
                    object2 = MotionLayout$TransitionState.FINISHED;
                    this.setState((MotionLayout$TransitionState)((Object)object2));
                }
            } else {
                object = -1;
                f12 = 0.0f / 0.0f;
                this.mCurrentState = object;
                object2 = MotionLayout$TransitionState.MOVING;
                this.setState((MotionLayout$TransitionState)((Object)object2));
            }
        }
        if ((object2 = this.mScene) == null) {
            return;
        }
        object = 1;
        this.mTransitionInstantly = object;
        this.mTransitionGoalPosition = f10;
        this.mTransitionPosition = f10;
        this.mTransitionLastTime = l10 = (long)-1;
        this.mAnimationStartTime = l10;
        this.mInterpolator = null;
        this.mInTransition = object;
        this.invalidate();
    }

    public void setProgress(float f10, float f11) {
        boolean bl2 = this.isAttachedToWindow();
        if (!bl2) {
            MotionLayout$StateCache motionLayout$StateCache = this.mStateCache;
            if (motionLayout$StateCache == null) {
                this.mStateCache = motionLayout$StateCache = new MotionLayout$StateCache(this);
            }
            this.mStateCache.setProgress(f10);
            this.mStateCache.setVelocity(f11);
            return;
        }
        this.setProgress(f10);
        MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.MOVING;
        this.setState(motionLayout$TransitionState);
        this.mLastVelocity = f11;
        this.animateTo(1.0f);
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        boolean bl2 = this.isRtl();
        motionScene.setRtl(bl2);
        this.rebuildScene();
    }

    public void setState(int n10, int n11, int n12) {
        int n13;
        Object object = MotionLayout$TransitionState.SETUP;
        this.setState((MotionLayout$TransitionState)((Object)object));
        this.mCurrentState = n10;
        this.mBeginState = n13 = -1;
        this.mEndState = n13;
        object = this.mConstraintLayoutSpec;
        if (object != null) {
            float f10 = n11;
            float f11 = n12;
            ((ConstraintLayoutStates)object).updateConstraints(n10, f10, f11);
        } else {
            MotionScene motionScene = this.mScene;
            if (motionScene != null) {
                ConstraintSet constraintSet = motionScene.getConstraintSet(n10);
                constraintSet.applyTo(this);
            }
        }
    }

    public void setState(MotionLayout$TransitionState motionLayout$TransitionState) {
        int n10;
        int n11;
        MotionLayout$TransitionState motionLayout$TransitionState2 = MotionLayout$TransitionState.FINISHED;
        if (motionLayout$TransitionState == motionLayout$TransitionState2 && (n11 = this.mCurrentState) == (n10 = -1)) {
            return;
        }
        MotionLayout$TransitionState motionLayout$TransitionState3 = this.mTransitionState;
        this.mTransitionState = motionLayout$TransitionState;
        MotionLayout$TransitionState motionLayout$TransitionState4 = MotionLayout$TransitionState.MOVING;
        if (motionLayout$TransitionState3 == motionLayout$TransitionState4 && motionLayout$TransitionState == motionLayout$TransitionState4) {
            this.fireTransitionChange();
        }
        int[] nArray = MotionLayout$2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState;
        n11 = motionLayout$TransitionState3.ordinal();
        int n12 = 1;
        if ((n11 = nArray[n11]) != n12 && n11 != (n12 = 2)) {
            n10 = 3;
            if (n11 == n10 && motionLayout$TransitionState == motionLayout$TransitionState2) {
                this.fireTransitionCompleted();
            }
        } else {
            if (motionLayout$TransitionState == motionLayout$TransitionState4) {
                this.fireTransitionChange();
            }
            if (motionLayout$TransitionState == motionLayout$TransitionState2) {
                this.fireTransitionCompleted();
            }
        }
    }

    public void setTransition(int n10) {
        Object object = this.mScene;
        if (object != null) {
            int n11;
            Object object2 = this.getTransition(n10);
            this.mBeginState = n11 = ((MotionScene$Transition)object2).getStartConstraintSetId();
            this.mEndState = n11 = ((MotionScene$Transition)object2).getEndConstraintSetId();
            n11 = (int)(this.isAttachedToWindow() ? 1 : 0);
            if (n11 == 0) {
                object2 = this.mStateCache;
                if (object2 == null) {
                    this.mStateCache = object2 = new MotionLayout$StateCache(this);
                }
                object2 = this.mStateCache;
                n11 = this.mBeginState;
                ((MotionLayout$StateCache)object2).setStartState(n11);
                object2 = this.mStateCache;
                n11 = this.mEndState;
                ((MotionLayout$StateCache)object2).setEndState(n11);
                return;
            }
            n11 = 2143289344;
            float f10 = 0.0f / 0.0f;
            int n12 = this.mCurrentState;
            int n13 = this.mBeginState;
            float f11 = 0.0f;
            if (n12 == n13) {
                n11 = 0;
                object = null;
                f10 = 0.0f;
            } else {
                n13 = this.mEndState;
                if (n12 == n13) {
                    n11 = 1065353216;
                    f10 = 1.0f;
                }
            }
            this.mScene.setTransition((MotionScene$Transition)object2);
            object2 = this.mModel;
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            Object object3 = this.mScene;
            int n14 = this.mBeginState;
            object3 = ((MotionScene)object3).getConstraintSet(n14);
            Object object4 = this.mScene;
            int n15 = this.mEndState;
            object4 = ((MotionScene)object4).getConstraintSet(n15);
            ((MotionLayout$Model)object2).initFrom(constraintWidgetContainer, (ConstraintSet)object3, (ConstraintSet)object4);
            this.rebuildScene();
            n10 = (int)(Float.isNaN(f10) ? 1 : 0);
            if (n10 == 0) {
                f11 = f10;
            }
            this.mTransitionLastPosition = f11;
            n10 = (int)(Float.isNaN(f10) ? 1 : 0);
            if (n10 != 0) {
                object2 = new StringBuilder();
                object = Debug.getLocation();
                ((StringBuilder)object2).append((String)object);
                ((StringBuilder)object2).append(" transitionToStart ");
                object2 = ((StringBuilder)object2).toString();
                object = TAG;
                Log.v((String)object, (String)object2);
                this.transitionToStart();
            } else {
                this.setProgress(f10);
            }
        }
    }

    public void setTransition(int n10, int n11) {
        boolean bl2 = this.isAttachedToWindow();
        if (!bl2) {
            MotionLayout$StateCache motionLayout$StateCache = this.mStateCache;
            if (motionLayout$StateCache == null) {
                this.mStateCache = motionLayout$StateCache = new MotionLayout$StateCache(this);
            }
            this.mStateCache.setStartState(n10);
            this.mStateCache.setEndState(n11);
            return;
        }
        Object object = this.mScene;
        if (object != null) {
            this.mBeginState = n10;
            this.mEndState = n11;
            ((MotionScene)object).setTransition(n10, n11);
            object = this.mModel;
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            ConstraintSet constraintSet = this.mScene.getConstraintSet(n10);
            MotionScene motionScene = this.mScene;
            ConstraintSet constraintSet2 = motionScene.getConstraintSet(n11);
            ((MotionLayout$Model)object).initFrom(constraintWidgetContainer, constraintSet, constraintSet2);
            this.rebuildScene();
            n10 = 0;
            constraintSet = null;
            this.mTransitionLastPosition = 0.0f;
            this.transitionToStart();
        }
    }

    public void setTransition(MotionScene$Transition object) {
        float f10;
        this.mScene.setTransition((MotionScene$Transition)object);
        Object object2 = MotionLayout$TransitionState.SETUP;
        this.setState((MotionLayout$TransitionState)((Object)object2));
        int n10 = this.mCurrentState;
        Object object3 = this.mScene;
        int n11 = ((MotionScene)object3).getEndId();
        if (n10 == n11) {
            n10 = 1065353216;
            this.mTransitionLastPosition = f10 = 1.0f;
            this.mTransitionPosition = f10;
            this.mTransitionGoalPosition = f10;
        } else {
            n10 = 0;
            f10 = 0.0f;
            object2 = null;
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        n10 = 1;
        f10 = Float.MIN_VALUE;
        boolean n12 = ((MotionScene$Transition)object).isTransitionFlag(n10);
        long l10 = n12 ? (long)-1 : this.getNanoTime();
        this.mTransitionLastTime = l10;
        object = this.mScene;
        int n13 = ((MotionScene)object).getStartId();
        object2 = this.mScene;
        n10 = ((MotionScene)object2).getEndId();
        n11 = this.mBeginState;
        if (n13 == n11 && n10 == (n11 = this.mEndState)) {
            return;
        }
        this.mBeginState = n13;
        this.mEndState = n10;
        this.mScene.setTransition(n13, n10);
        object = this.mModel;
        object2 = this.mLayoutWidget;
        object3 = this.mScene;
        int n14 = this.mBeginState;
        object3 = ((MotionScene)object3).getConstraintSet(n14);
        Object object4 = this.mScene;
        int n15 = this.mEndState;
        object4 = ((MotionScene)object4).getConstraintSet(n15);
        ((MotionLayout$Model)object).initFrom((ConstraintWidgetContainer)object2, (ConstraintSet)object3, (ConstraintSet)object4);
        object = this.mModel;
        n10 = this.mBeginState;
        n11 = this.mEndState;
        ((MotionLayout$Model)object).setMeasuredId(n10, n11);
        this.mModel.reEvaluateState();
        this.rebuildScene();
    }

    public void setTransitionDuration(int n10) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e((String)TAG, (String)"MotionScene not defined");
            return;
        }
        motionScene.setDuration(n10);
    }

    public void setTransitionListener(MotionLayout$TransitionListener motionLayout$TransitionListener) {
        this.mTransitionListener = motionLayout$TransitionListener;
    }

    public void setTransitionState(Bundle object) {
        MotionLayout$StateCache motionLayout$StateCache = this.mStateCache;
        if (motionLayout$StateCache == null) {
            this.mStateCache = motionLayout$StateCache = new MotionLayout$StateCache(this);
        }
        motionLayout$StateCache = this.mStateCache;
        motionLayout$StateCache.setTransitionState((Bundle)object);
        boolean bl2 = this.isAttachedToWindow();
        if (bl2) {
            object = this.mStateCache;
            ((MotionLayout$StateCache)object).apply();
        }
    }

    public String toString() {
        Object object = this.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = this.mBeginState;
        String string2 = Debug.getName(object, n10);
        stringBuilder.append(string2);
        stringBuilder.append("->");
        n10 = this.mEndState;
        object = Debug.getName(object, n10);
        stringBuilder.append((String)object);
        stringBuilder.append(" (pos:");
        float f10 = this.mTransitionLastPosition;
        stringBuilder.append(f10);
        stringBuilder.append(" Dpos/Dt:");
        f10 = this.mLastVelocity;
        stringBuilder.append(f10);
        return stringBuilder.toString();
    }

    public void touchAnimateTo(int n10, float f10, float f11) {
        long l10;
        float f12;
        long l11;
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        float f13 = this.mTransitionLastPosition;
        float f14 = f13 - f10;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object == false) {
            return;
        }
        object = true;
        f13 = Float.MIN_VALUE;
        this.mTemporalInterpolator = object;
        this.mAnimationStartTime = l11 = this.getNanoTime();
        this.mTransitionDuration = f12 = (float)this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f10;
        this.mInTransition = object;
        int n11 = 2;
        if (n10 != 0 && n10 != object && n10 != n11) {
            object = 4;
            f13 = 5.6E-45f;
            if (n10 != object) {
                object = 5;
                f13 = 7.0E-45f;
                if (n10 == object) {
                    float f15 = this.mTransitionLastPosition;
                    motionScene = this.mScene;
                    f13 = motionScene.getMaxAcceleration();
                    n10 = (int)(MotionLayout.willJump(f11, f15, f13) ? 1 : 0);
                    if (n10 != 0) {
                        MotionLayout$DecelerateInterpolator motionLayout$DecelerateInterpolator = this.mDecelerateLogic;
                        f10 = this.mTransitionLastPosition;
                        motionScene = this.mScene;
                        f13 = motionScene.getMaxAcceleration();
                        motionLayout$DecelerateInterpolator.config(f11, f10, f13);
                        motionLayout$DecelerateInterpolator = this.mDecelerateLogic;
                        this.mInterpolator = motionLayout$DecelerateInterpolator;
                    } else {
                        StopLogic stopLogic = this.mStopLogic;
                        float f16 = this.mTransitionLastPosition;
                        float f17 = this.mTransitionDuration;
                        f12 = this.mScene.getMaxAcceleration();
                        float f18 = this.mScene.getMaxVelocity();
                        float f19 = f10;
                        stopLogic.config(f16, f10, f11, f17, f12, f18);
                        this.mLastVelocity = 0.0f;
                        n10 = this.mCurrentState;
                        this.mTransitionGoalPosition = f10;
                        this.mCurrentState = n10;
                        StopLogic stopLogic2 = this.mStopLogic;
                        this.mInterpolator = stopLogic2;
                    }
                }
            } else {
                MotionLayout$DecelerateInterpolator motionLayout$DecelerateInterpolator = this.mDecelerateLogic;
                f10 = this.mTransitionLastPosition;
                motionScene = this.mScene;
                f13 = motionScene.getMaxAcceleration();
                motionLayout$DecelerateInterpolator.config(f11, f10, f13);
                motionLayout$DecelerateInterpolator = this.mDecelerateLogic;
                this.mInterpolator = motionLayout$DecelerateInterpolator;
            }
        } else {
            if (n10 == object) {
                f10 = 0.0f;
            } else if (n10 == n11) {
                f10 = 1.0f;
            }
            StopLogic stopLogic = this.mStopLogic;
            float f20 = this.mTransitionLastPosition;
            float f21 = this.mScene.getMaxAcceleration();
            float f22 = this.mScene.getMaxVelocity();
            float f23 = f11;
            stopLogic.config(f20, f10, f11, f12, f21, f22);
            n10 = this.mCurrentState;
            this.mTransitionGoalPosition = f10;
            this.mCurrentState = n10;
            StopLogic stopLogic3 = this.mStopLogic;
            this.mInterpolator = stopLogic3;
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = l10 = this.getNanoTime();
        this.invalidate();
    }

    public void transitionToEnd() {
        this.animateTo(1.0f);
    }

    public void transitionToStart() {
        this.animateTo(0.0f);
    }

    public void transitionToState(int n10) {
        int n11 = this.isAttachedToWindow();
        if (n11 == 0) {
            MotionLayout$StateCache motionLayout$StateCache = this.mStateCache;
            if (motionLayout$StateCache == null) {
                this.mStateCache = motionLayout$StateCache = new MotionLayout$StateCache(this);
            }
            this.mStateCache.setEndState(n10);
            return;
        }
        n11 = -1;
        this.transitionToState(n10, n11, n11);
    }

    public void transitionToState(int n10, int n11, int n12) {
        int n13;
        float f10;
        Object object;
        Object object2;
        Object object3;
        int n14;
        long l10;
        float f11;
        float f12;
        int n15;
        Object object4 = this.mScene;
        int n16 = -1;
        if (object4 != null && (object4 = ((MotionScene)object4).mStateSet) != null && (n11 = ((StateSet)object4).convertToConstraintSet(n15 = this.mCurrentState, n10, f12 = (float)n11, f11 = (float)n12)) != n16) {
            n10 = n11;
        }
        if ((n11 = this.mCurrentState) == n10) {
            return;
        }
        n12 = this.mBeginState;
        object4 = null;
        if (n12 == n10) {
            this.animateTo(0.0f);
            return;
        }
        n12 = this.mEndState;
        n15 = 1065353216;
        float f13 = 1.0f;
        if (n12 == n10) {
            this.animateTo(f13);
            return;
        }
        this.mEndState = n10;
        if (n11 != n16) {
            this.setTransition(n11, n10);
            this.animateTo(f13);
            this.mTransitionLastPosition = 0.0f;
            this.transitionToEnd();
            return;
        }
        n11 = 0;
        f12 = 0.0f;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f13;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = l10 = this.getNanoTime();
        this.mAnimationStartTime = l10 = this.getNanoTime();
        this.mTransitionInstantly = false;
        n12 = 0;
        f11 = 0.0f;
        this.mInterpolator = null;
        float f14 = this.mScene.getDuration();
        float f15 = 1000.0f;
        this.mTransitionDuration = f14 /= f15;
        this.mBeginState = n16;
        MotionScene motionScene = this.mScene;
        int n17 = this.mEndState;
        motionScene.setTransition(n16, n17);
        MotionScene motionScene2 = this.mScene;
        motionScene2.getStartId();
        n16 = this.getChildCount();
        this.mFrameArrayList.clear();
        motionScene = null;
        f14 = 0.0f;
        for (n14 = 0; n14 < n16; ++n14) {
            object3 = this.getChildAt(n14);
            object2 = new MotionController((View)object3);
            object = this.mFrameArrayList;
            ((HashMap)object).put(object3, object2);
        }
        n14 = 1;
        f14 = Float.MIN_VALUE;
        this.mInTransition = n14;
        object3 = this.mModel;
        object2 = this.mLayoutWidget;
        object = this.mScene;
        Object object5 = ((MotionScene)object).getConstraintSet(n10);
        ((MotionLayout$Model)object3).initFrom((ConstraintWidgetContainer)object2, null, (ConstraintSet)object5);
        this.rebuildScene();
        object5 = this.mModel;
        ((MotionLayout$Model)object5).build();
        this.computeCurrentPositions();
        n10 = this.getWidth();
        n12 = this.getHeight();
        for (int i10 = 0; i10 < n16; ++i10) {
            object3 = this.mFrameArrayList;
            object2 = this.getChildAt(i10);
            object3 = (MotionController)((HashMap)object3).get(object2);
            object2 = this.mScene;
            ((MotionScene)object2).getKeyFrames((MotionController)object3);
            f10 = this.mTransitionDuration;
            long l11 = this.getNanoTime();
            n13 = n10;
            object3.setup(n10, n12, f10, l11);
        }
        object5 = this.mScene;
        float f16 = ((MotionScene)object5).getStaggered();
        float f17 = f16 - 0.0f;
        n12 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
        if (n12 != 0) {
            float f18;
            n12 = 0x7F7FFFFF;
            f11 = Float.MAX_VALUE;
            n17 = -8388609;
            f15 = -3.4028235E38f;
            object2 = null;
            for (n13 = 0; n13 < n16; ++n13) {
                object = this.mFrameArrayList;
                View view = this.getChildAt(n13);
                object = (MotionController)((HashMap)object).get(view);
                f10 = object.getFinalX();
                f18 = object.getFinalY() + f10;
                f11 = Math.min(f11, f18);
                f15 = Math.max(f15, f18);
            }
            while (n11 < n16) {
                object2 = this.mFrameArrayList;
                object = this.getChildAt(n11);
                object2 = (MotionController)((HashMap)object2).get(object);
                f18 = object2.getFinalX();
                f10 = object2.getFinalY();
                float f19 = f13 - f16;
                ((MotionController)object2).mStaggerScale = f19 = f13 / f19;
                f18 = (f18 + f10 - f11) * f16;
                f10 = f15 - f11;
                f18 /= f10;
                ((MotionController)object2).mStaggerOffset = f18 = f16 - f18;
                ++n11;
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = n14;
        this.invalidate();
    }

    public void updateState() {
        MotionLayout$Model motionLayout$Model = this.mModel;
        ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
        Object object = this.mScene;
        int n10 = this.mBeginState;
        object = ((MotionScene)object).getConstraintSet(n10);
        Object object2 = this.mScene;
        int n11 = this.mEndState;
        object2 = ((MotionScene)object2).getConstraintSet(n11);
        motionLayout$Model.initFrom(constraintWidgetContainer, (ConstraintSet)object, (ConstraintSet)object2);
        this.rebuildScene();
    }

    public void updateState(int n10, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(n10, constraintSet);
        }
        this.updateState();
        int n11 = this.mCurrentState;
        if (n11 == n10) {
            constraintSet.applyTo(this);
        }
    }
}

