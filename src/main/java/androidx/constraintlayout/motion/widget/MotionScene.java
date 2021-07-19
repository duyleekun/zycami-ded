/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.util.Xml
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AnimationUtils
 *  android.view.animation.AnticipateInterpolator
 *  android.view.animation.BounceInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  androidx.constraintlayout.motion.widget.MotionController
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyFrames;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker;
import androidx.constraintlayout.motion.widget.MotionLayout$TransitionState;
import androidx.constraintlayout.motion.widget.MotionScene$1;
import androidx.constraintlayout.motion.widget.MotionScene$Transition;
import androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

public class MotionScene {
    public static final int ANTICIPATE = 4;
    public static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    public static final int EASE_IN = 1;
    public static final int EASE_IN_OUT = 0;
    public static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = 254;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final int LINEAR = 3;
    private static final int SPLINE_STRING = 255;
    public static final String TAG = "MotionScene";
    public static final int TRANSITION_BACKWARD = 0;
    public static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = 255;
    private boolean DEBUG_DESKTOP;
    private ArrayList mAbstractTransitionList;
    private HashMap mConstraintSetIdMap;
    private SparseArray mConstraintSetMap;
    public MotionScene$Transition mCurrentTransition = null;
    private int mDefaultDuration;
    private MotionScene$Transition mDefaultTransition;
    private SparseIntArray mDeriveMap;
    private boolean mDisableAutoTransition = false;
    private boolean mIgnoreTouch;
    private MotionEvent mLastTouchDown;
    public float mLastTouchX;
    public float mLastTouchY;
    private int mLayoutDuringTransition;
    private final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion;
    private boolean mRtl;
    public StateSet mStateSet = null;
    private ArrayList mTransitionList;
    private MotionLayout$MotionTracker mVelocityTracker;

    public MotionScene(Context object, MotionLayout object2, int n10) {
        Object object3;
        ArrayList arrayList;
        this.mTransitionList = arrayList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = object3 = new ArrayList();
        this.mConstraintSetMap = object3 = new SparseArray();
        this.mConstraintSetIdMap = object3;
        super();
        this.mDeriveMap = object3;
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = object2;
        this.load((Context)object, n10);
        object = this.mConstraintSetMap;
        int n11 = R$id.motion_base;
        ConstraintSet constraintSet = new ConstraintSet();
        object.put(n11, (Object)constraintSet);
        object = this.mConstraintSetIdMap;
        object2 = n11;
        ((HashMap)object).put("motion_base", object2);
    }

    public MotionScene(MotionLayout motionLayout) {
        Object object;
        ArrayList arrayList;
        this.mTransitionList = arrayList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = object = new ArrayList();
        this.mConstraintSetMap = object = new SparseArray();
        this.mConstraintSetIdMap = object;
        super();
        this.mDeriveMap = object;
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mIgnoreTouch = false;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = motionLayout;
    }

    public static /* synthetic */ int access$1000(MotionScene motionScene) {
        return motionScene.mLayoutDuringTransition;
    }

    public static /* synthetic */ SparseArray access$1100(MotionScene motionScene) {
        return motionScene.mConstraintSetMap;
    }

    public static /* synthetic */ MotionLayout access$800(MotionScene motionScene) {
        return motionScene.mMotionLayout;
    }

    public static /* synthetic */ int access$900(MotionScene motionScene) {
        return motionScene.mDefaultDuration;
    }

    private int getId(Context object, String string2) {
        int n10;
        Object object2 = "/";
        int n11 = string2.contains((CharSequence)object2);
        int n12 = -1;
        int n13 = 1;
        if (n11 != 0) {
            n11 = string2.indexOf(47) + n13;
            object2 = string2.substring(n11);
            Object object3 = object.getResources();
            object = object.getPackageName();
            String string3 = "id";
            n10 = object3.getIdentifier((String)object2, string3, (String)object);
            n11 = this.DEBUG_DESKTOP ? 1 : 0;
            if (n11 != 0) {
                object2 = System.out;
                object3 = new StringBuilder();
                string3 = "id getMap res = ";
                ((StringBuilder)object3).append(string3);
                ((StringBuilder)object3).append(n10);
                object3 = ((StringBuilder)object3).toString();
                ((PrintStream)object2).println((String)object3);
            }
        } else {
            n10 = n12;
        }
        if (n10 == n12) {
            if (string2 != null && (n11 = string2.length()) > n13) {
                object = string2.substring(n13);
                n10 = Integer.parseInt((String)object);
            } else {
                string2 = TAG;
                object2 = "error in parsing id";
                Log.e((String)string2, (String)object2);
            }
        }
        return n10;
    }

    private int getIndex(MotionScene$Transition object) {
        int n10;
        int n11 = MotionScene$Transition.access$300((MotionScene$Transition)object);
        if (n11 != (n10 = -1)) {
            Object object2;
            int n12;
            for (int i10 = 0; i10 < (n12 = ((ArrayList)(object2 = this.mTransitionList)).size()); ++i10) {
                object2 = (MotionScene$Transition)this.mTransitionList.get(i10);
                n12 = MotionScene$Transition.access$300((MotionScene$Transition)object2);
                if (n12 != n11) continue;
                return i10;
            }
            return n10;
        }
        object = new IllegalArgumentException("The transition must have an id");
        throw object;
    }

    private int getRealID(int n10) {
        int n11;
        int n12;
        StateSet stateSet = this.mStateSet;
        if (stateSet != null && (n12 = stateSet.stateGetConstraintID(n10, n11 = -1, n11)) != n11) {
            return n12;
        }
        return n10;
    }

    private boolean hasCycleDependency(int n10) {
        SparseIntArray sparseIntArray = this.mDeriveMap;
        int n11 = sparseIntArray.get(n10);
        SparseIntArray sparseIntArray2 = this.mDeriveMap;
        int n12 = sparseIntArray2.size();
        while (n11 > 0) {
            boolean bl2 = true;
            if (n11 == n10) {
                return bl2;
            }
            int n13 = n12 + -1;
            if (n12 < 0) {
                return bl2;
            }
            sparseIntArray2 = this.mDeriveMap;
            n11 = sparseIntArray2.get(n11);
            n12 = n13;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        boolean bl2;
        MotionLayout$MotionTracker motionLayout$MotionTracker = this.mVelocityTracker;
        if (motionLayout$MotionTracker != null) {
            bl2 = true;
        } else {
            bl2 = false;
            motionLayout$MotionTracker = null;
        }
        return bl2;
    }

    /*
     * Exception decompiling
     */
    private void load(Context var1_1, int var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [67[CASE]], but top level block is 19[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int n10;
        int n11;
        ConstraintSet constraintSet = new ConstraintSet();
        MotionLayout motionLayout = null;
        constraintSet.setForceId(false);
        int n12 = xmlPullParser.getAttributeCount();
        int n13 = n11 = -1;
        int n14 = n11;
        for (n10 = 0; n10 < n12; ++n10) {
            Object object;
            Object object2 = xmlPullParser.getAttributeName(n10);
            String string2 = xmlPullParser.getAttributeValue(n10);
            boolean bl2 = this.DEBUG_DESKTOP;
            if (bl2) {
                object = System.out;
                CharSequence charSequence = new StringBuilder();
                String string3 = "id string = ";
                charSequence.append(string3);
                charSequence.append(string2);
                charSequence = charSequence.toString();
                ((PrintStream)object).println((String)charSequence);
            }
            ((String)object2).hashCode();
            object = "deriveConstraintsFrom";
            bl2 = ((String)object2).equals(object);
            if (!bl2) {
                object = "id";
                boolean bl3 = ((String)object2).equals(object);
                if (!bl3) continue;
                n13 = this.getId(context, string2);
                object2 = this.mConstraintSetIdMap;
                string2 = MotionScene.stripID(string2);
                object = n13;
                ((HashMap)object2).put(string2, object);
                continue;
            }
            n14 = this.getId(context, string2);
        }
        if (n13 != n11) {
            motionLayout = this.mMotionLayout;
            n10 = motionLayout.mDebugPath;
            if (n10 != 0) {
                n10 = 1;
                constraintSet.setValidateOnParse(n10 != 0);
            }
            constraintSet.load(context, xmlPullParser);
            if (n14 != n11) {
                context = this.mDeriveMap;
                context.put(n13, n14);
            }
            context = this.mConstraintSetMap;
            context.put(n13, (Object)constraintSet);
        }
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        xmlPullParser = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        int[] nArray = R$styleable.MotionScene;
        context = context.obtainStyledAttributes((AttributeSet)xmlPullParser, nArray);
        int n10 = context.getIndexCount();
        nArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            int n12 = context.getIndex(i10);
            if (n12 == (n11 = R$styleable.MotionScene_defaultDuration)) {
                n11 = this.mDefaultDuration;
                this.mDefaultDuration = n12 = context.getInt(n12, n11);
                continue;
            }
            n11 = R$styleable.MotionScene_layoutDuringTransition;
            if (n12 != n11) continue;
            this.mLayoutDuringTransition = n12 = context.getInteger(n12, 0);
        }
        context.recycle();
    }

    private void readConstraintChain(int n10) {
        Object object = this.mDeriveMap;
        int n11 = object.get(n10);
        if (n11 > 0) {
            int n12 = this.mDeriveMap.get(n10);
            this.readConstraintChain(n12);
            ConstraintSet constraintSet = (ConstraintSet)this.mConstraintSetMap.get(n10);
            ConstraintSet constraintSet2 = (ConstraintSet)this.mConstraintSetMap.get(n11);
            if (constraintSet2 == null) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("ERROR! invalid deriveConstraintsFrom: @id/");
                object = Debug.getName(this.mMotionLayout.getContext(), n11);
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                Log.e((String)TAG, (String)charSequence);
                return;
            }
            constraintSet.readFallback(constraintSet2);
            object = this.mDeriveMap;
            n12 = -1;
            object.put(n10, n12);
        }
    }

    public static String stripID(String string2) {
        if (string2 == null) {
            return "";
        }
        int n10 = string2.indexOf(47);
        if (n10 < 0) {
            return string2;
        }
        return string2.substring(++n10);
    }

    public void addOnClickListeners(MotionLayout motionLayout, int n10) {
        MotionScene$Transition$TransitionOnClick motionScene$Transition$TransitionOnClick;
        boolean bl2;
        int n11;
        Object object;
        Object object2;
        boolean bl3;
        Iterator iterator2 = this.mTransitionList.iterator();
        while (bl3 = iterator2.hasNext()) {
            object2 = (MotionScene$Transition)iterator2.next();
            object = MotionScene$Transition.access$400((MotionScene$Transition)object2);
            n11 = ((ArrayList)object).size();
            if (n11 <= 0) continue;
            object2 = MotionScene$Transition.access$400((MotionScene$Transition)object2).iterator();
            while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object = (MotionScene$Transition$TransitionOnClick)object2.next();
                ((MotionScene$Transition$TransitionOnClick)object).removeOnClickListeners(motionLayout);
            }
        }
        iterator2 = this.mAbstractTransitionList.iterator();
        while (bl3 = iterator2.hasNext()) {
            object2 = (MotionScene$Transition)iterator2.next();
            object = MotionScene$Transition.access$400((MotionScene$Transition)object2);
            n11 = ((ArrayList)object).size();
            if (n11 <= 0) continue;
            object2 = MotionScene$Transition.access$400((MotionScene$Transition)object2).iterator();
            while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object = (MotionScene$Transition$TransitionOnClick)object2.next();
                ((MotionScene$Transition$TransitionOnClick)object).removeOnClickListeners(motionLayout);
            }
        }
        iterator2 = this.mTransitionList.iterator();
        while (bl3 = iterator2.hasNext()) {
            object2 = (MotionScene$Transition)iterator2.next();
            object = MotionScene$Transition.access$400((MotionScene$Transition)object2);
            n11 = ((ArrayList)object).size();
            if (n11 <= 0) continue;
            object = MotionScene$Transition.access$400(object2).iterator();
            while (bl2 = object.hasNext()) {
                motionScene$Transition$TransitionOnClick = (MotionScene$Transition$TransitionOnClick)object.next();
                motionScene$Transition$TransitionOnClick.addOnClickListeners(motionLayout, n10, (MotionScene$Transition)object2);
            }
        }
        iterator2 = this.mAbstractTransitionList.iterator();
        while (bl3 = iterator2.hasNext()) {
            object2 = (MotionScene$Transition)iterator2.next();
            object = MotionScene$Transition.access$400((MotionScene$Transition)object2);
            n11 = ((ArrayList)object).size();
            if (n11 <= 0) continue;
            object = MotionScene$Transition.access$400((MotionScene$Transition)object2).iterator();
            while (bl2 = object.hasNext()) {
                motionScene$Transition$TransitionOnClick = (MotionScene$Transition$TransitionOnClick)object.next();
                motionScene$Transition$TransitionOnClick.addOnClickListeners(motionLayout, n10, (MotionScene$Transition)object2);
            }
        }
    }

    public void addTransition(MotionScene$Transition motionScene$Transition) {
        int n10;
        int n11 = this.getIndex(motionScene$Transition);
        if (n11 == (n10 = -1)) {
            ArrayList arrayList = this.mTransitionList;
            arrayList.add(motionScene$Transition);
        } else {
            ArrayList arrayList = this.mTransitionList;
            arrayList.set(n11, motionScene$Transition);
        }
    }

    public boolean autoTransition(MotionLayout motionLayout, int n10) {
        boolean bl2;
        int n11 = this.isProcessingTouch();
        if (n11 != 0) {
            return false;
        }
        n11 = this.mDisableAutoTransition;
        if (n11 != 0) {
            return false;
        }
        Object object = this.mTransitionList.iterator();
        while (bl2 = object.hasNext()) {
            int n12;
            int n13;
            MotionScene$Transition motionScene$Transition;
            MotionScene$Transition motionScene$Transition2 = (MotionScene$Transition)object.next();
            int n14 = MotionScene$Transition.access$600(motionScene$Transition2);
            if (!n14 || (motionScene$Transition = this.mCurrentTransition) == motionScene$Transition2) continue;
            n14 = MotionScene$Transition.access$100(motionScene$Transition2);
            int n15 = 1;
            if (n10 == n14 && ((n14 = MotionScene$Transition.access$600(motionScene$Transition2)) == (n13 = 4) || (n14 = MotionScene$Transition.access$600(motionScene$Transition2)) == (n12 = 2))) {
                MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                motionLayout.setState(motionLayout$TransitionState);
                motionLayout.setTransition(motionScene$Transition2);
                n11 = MotionScene$Transition.access$600(motionScene$Transition2);
                if (n11 == n13) {
                    motionLayout.transitionToEnd();
                    motionLayout$TransitionState = MotionLayout$TransitionState.SETUP;
                    motionLayout.setState(motionLayout$TransitionState);
                    motionLayout$TransitionState = MotionLayout$TransitionState.MOVING;
                    motionLayout.setState(motionLayout$TransitionState);
                } else {
                    n11 = 1065353216;
                    float f10 = 1.0f;
                    motionLayout.setProgress(f10);
                    motionLayout.evaluate(n15 != 0);
                    object = MotionLayout$TransitionState.SETUP;
                    motionLayout.setState((MotionLayout$TransitionState)((Object)object));
                    object = MotionLayout$TransitionState.MOVING;
                    motionLayout.setState((MotionLayout$TransitionState)((Object)object));
                    motionLayout.setState(motionLayout$TransitionState);
                    motionLayout.onNewStateAttachHandlers();
                }
                return n15 != 0;
            }
            n14 = MotionScene$Transition.access$000(motionScene$Transition2);
            if (n10 != n14 || (n14 = MotionScene$Transition.access$600(motionScene$Transition2)) != (n13 = 3) && (n14 = MotionScene$Transition.access$600(motionScene$Transition2)) != n15) continue;
            MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
            motionLayout.setState(motionLayout$TransitionState);
            motionLayout.setTransition(motionScene$Transition2);
            n11 = MotionScene$Transition.access$600(motionScene$Transition2);
            if (n11 == n13) {
                motionLayout.transitionToStart();
                motionLayout$TransitionState = MotionLayout$TransitionState.SETUP;
                motionLayout.setState(motionLayout$TransitionState);
                motionLayout$TransitionState = MotionLayout$TransitionState.MOVING;
                motionLayout.setState(motionLayout$TransitionState);
            } else {
                n11 = 0;
                float f11 = 0.0f;
                motionLayout.setProgress(0.0f);
                motionLayout.evaluate(n15 != 0);
                object = MotionLayout$TransitionState.SETUP;
                motionLayout.setState((MotionLayout$TransitionState)((Object)object));
                object = MotionLayout$TransitionState.MOVING;
                motionLayout.setState((MotionLayout$TransitionState)((Object)object));
                motionLayout.setState(motionLayout$TransitionState);
                motionLayout.onNewStateAttachHandlers();
            }
            return n15 != 0;
        }
        return false;
    }

    public MotionScene$Transition bestTransitionFor(int n10, float f10, float f11, MotionEvent motionEvent) {
        int n11 = -1;
        if (n10 != n11) {
            boolean bl2;
            Object object = this.getTransitionsWithState(n10);
            float f12 = 0.0f;
            MotionScene$Transition motionScene$Transition = null;
            RectF rectF = new RectF();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                float f13;
                float f14;
                float f15;
                TouchResponse touchResponse;
                MotionScene$Transition motionScene$Transition2 = (MotionScene$Transition)object.next();
                boolean bl3 = MotionScene$Transition.access$500(motionScene$Transition2);
                if (bl3 || (touchResponse = MotionScene$Transition.access$200(motionScene$Transition2)) == null) continue;
                touchResponse = MotionScene$Transition.access$200(motionScene$Transition2);
                int n12 = this.mRtl;
                touchResponse.setRTL(n12 != 0);
                touchResponse = MotionScene$Transition.access$200(motionScene$Transition2);
                MotionLayout motionLayout = this.mMotionLayout;
                touchResponse = touchResponse.getTouchRegion(motionLayout, rectF);
                if (touchResponse != null && motionEvent != null && !(bl3 = touchResponse.contains(f15 = motionEvent.getX(), f14 = motionEvent.getY()))) continue;
                touchResponse = MotionScene$Transition.access$200(motionScene$Transition2);
                motionLayout = this.mMotionLayout;
                if ((touchResponse = touchResponse.getTouchRegion(motionLayout, rectF)) != null && motionEvent != null && !(bl3 = touchResponse.contains(f15 = motionEvent.getX(), f14 = motionEvent.getY()))) continue;
                touchResponse = MotionScene$Transition.access$200(motionScene$Transition2);
                float f16 = touchResponse.dot(f10, f11);
                n12 = MotionScene$Transition.access$000(motionScene$Transition2);
                if (n12 == n10) {
                    n12 = -1082130432;
                    f15 = -1.0f;
                } else {
                    n12 = 1066192077;
                    f15 = 1.1f;
                }
                if ((n12 = (int)((f13 = (f16 *= f15) - f12) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1))) <= 0) continue;
                motionScene$Transition = motionScene$Transition2;
                f12 = f16;
            }
            return motionScene$Transition;
        }
        return this.mCurrentTransition;
    }

    public void disableAutoTransition(boolean bl2) {
        this.mDisableAutoTransition = bl2;
    }

    public int gatPathMotionArc() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        int n10 = motionScene$Transition != null ? MotionScene$Transition.access$1800(motionScene$Transition) : -1;
        return n10;
    }

    public ConstraintSet getConstraintSet(int n10) {
        int n11 = -1;
        return this.getConstraintSet(n10, n11, n11);
    }

    public ConstraintSet getConstraintSet(int n10, int n11, int n12) {
        Object object;
        Object object2;
        boolean bl2 = this.DEBUG_DESKTOP;
        if (bl2) {
            object2 = System.out;
            CharSequence charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("id ");
            ((StringBuilder)charSequence).append(n10);
            charSequence = ((StringBuilder)charSequence).toString();
            ((PrintStream)object2).println((String)charSequence);
            object2 = System.out;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("size ");
            SparseArray sparseArray = this.mConstraintSetMap;
            int n13 = sparseArray.size();
            ((StringBuilder)charSequence).append(n13);
            charSequence = ((StringBuilder)charSequence).toString();
            ((PrintStream)object2).println((String)charSequence);
        }
        if ((object2 = this.mStateSet) != null && (n11 = ((StateSet)object2).stateGetConstraintID(n10, n11, n12)) != (n12 = -1)) {
            n10 = n11;
        }
        if ((object = this.mConstraintSetMap.get(n10)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Warning could not find ConstraintSet id/");
            String string2 = Debug.getName(this.mMotionLayout.getContext(), n10);
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" In MotionScene");
            string2 = ((StringBuilder)object).toString();
            Log.e((String)TAG, (String)string2);
            string2 = this.mConstraintSetMap;
            n11 = string2.keyAt(0);
            return (ConstraintSet)string2.get(n11);
        }
        return (ConstraintSet)this.mConstraintSetMap.get(n10);
    }

    public ConstraintSet getConstraintSet(Context context, String string2) {
        int n10;
        int n11;
        String string3;
        CharSequence charSequence;
        PrintStream printStream;
        int n12 = this.DEBUG_DESKTOP;
        if (n12 != 0) {
            printStream = System.out;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("id ");
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            printStream.println((String)charSequence);
            printStream = System.out;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("size ");
            string3 = this.mConstraintSetMap;
            n11 = string3.size();
            ((StringBuilder)charSequence).append(n11);
            charSequence = ((StringBuilder)charSequence).toString();
            printStream.println((String)charSequence);
        }
        printStream = null;
        for (n12 = 0; n12 < (n10 = (charSequence = this.mConstraintSetMap).size()); ++n12) {
            charSequence = this.mConstraintSetMap;
            n10 = charSequence.keyAt(n12);
            string3 = context.getResources().getResourceName(n10);
            boolean bl2 = this.DEBUG_DESKTOP;
            if (bl2) {
                PrintStream printStream2 = System.out;
                CharSequence charSequence2 = new StringBuilder();
                charSequence2.append("Id for <");
                charSequence2.append(n12);
                charSequence2.append("> is <");
                charSequence2.append(string3);
                charSequence2.append("> looking for <");
                charSequence2.append(string2);
                String string4 = ">";
                charSequence2.append(string4);
                charSequence2 = charSequence2.toString();
                printStream2.println((String)charSequence2);
            }
            if ((n11 = string2.equals(string3)) == 0) continue;
            return (ConstraintSet)this.mConstraintSetMap.get(n10);
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        SparseArray sparseArray = this.mConstraintSetMap;
        int n10 = sparseArray.size();
        int[] nArray = new int[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            SparseArray sparseArray2 = this.mConstraintSetMap;
            nArray[i10] = n11 = sparseArray2.keyAt(i10);
        }
        return nArray;
    }

    public ArrayList getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            return MotionScene$Transition.access$1700(motionScene$Transition);
        }
        return this.mDefaultDuration;
    }

    public int getEndId() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return -1;
        }
        return MotionScene$Transition.access$000(motionScene$Transition);
    }

    public Interpolator getInterpolator() {
        int n10;
        Object object = this.mCurrentTransition;
        int n11 = MotionScene$Transition.access$1400((MotionScene$Transition)object);
        if (n11 != (n10 = -2)) {
            n10 = -1;
            if (n11 != n10) {
                if (n11 != 0) {
                    n10 = 1;
                    if (n11 != n10) {
                        n10 = 2;
                        if (n11 != n10) {
                            n10 = 4;
                            if (n11 != n10) {
                                n10 = 5;
                                if (n11 != n10) {
                                    return null;
                                }
                                object = new BounceInterpolator();
                                return object;
                            }
                            object = new AnticipateInterpolator();
                            return object;
                        }
                        object = new DecelerateInterpolator();
                        return object;
                    }
                    object = new AccelerateInterpolator();
                    return object;
                }
                object = new AccelerateDecelerateInterpolator();
                return object;
            }
            object = Easing.getInterpolator(MotionScene$Transition.access$1500(this.mCurrentTransition));
            MotionScene$1 motionScene$1 = new MotionScene$1(this, (Easing)object);
            return motionScene$1;
        }
        object = this.mMotionLayout.getContext();
        n10 = MotionScene$Transition.access$1600(this.mCurrentTransition);
        return AnimationUtils.loadInterpolator((Context)object, (int)n10);
    }

    public Key getKeyFrame(Context object, int n10, int n11, int n12) {
        boolean bl2;
        object = this.mCurrentTransition;
        if (object == null) {
            return null;
        }
        object = MotionScene$Transition.access$1300((MotionScene$Transition)object).iterator();
        while (bl2 = object.hasNext()) {
            int n13;
            KeyFrames keyFrames = (KeyFrames)object.next();
            Iterator iterator2 = keyFrames.getKeys().iterator();
            while ((n13 = iterator2.hasNext()) != 0) {
                Object object2 = (Integer)iterator2.next();
                int n14 = (Integer)object2;
                if (n11 != n14) continue;
                n13 = (Integer)object2;
                object2 = keyFrames.getKeyFramesForView(n13).iterator();
                while ((n14 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    Key key = (Key)object2.next();
                    int n15 = key.mFramePosition;
                    if (n15 != n12 || (n15 = key.mType) != n10) continue;
                    return key;
                }
            }
        }
        return null;
    }

    public void getKeyFrames(MotionController motionController) {
        boolean bl2;
        Object object = this.mCurrentTransition;
        if (object == null) {
            object = this.mDefaultTransition;
            if (object != null) {
                boolean bl3;
                object = MotionScene$Transition.access$1300((MotionScene$Transition)object).iterator();
                while (bl3 = object.hasNext()) {
                    KeyFrames keyFrames = (KeyFrames)object.next();
                    keyFrames.addFrames(motionController);
                }
            }
            return;
        }
        object = MotionScene$Transition.access$1300((MotionScene$Transition)object).iterator();
        while (bl2 = object.hasNext()) {
            KeyFrames keyFrames = (KeyFrames)object.next();
            keyFrames.addFrames(motionController);
        }
    }

    public float getMaxAcceleration() {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            return MotionScene$Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
        }
        return 0.0f;
    }

    public float getMaxVelocity() {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            return MotionScene$Transition.access$200(this.mCurrentTransition).getMaxVelocity();
        }
        return 0.0f;
    }

    public boolean getMoveWhenScrollAtTop() {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            return MotionScene$Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
        }
        return false;
    }

    public float getPathPercent(View view, int n10) {
        return 0.0f;
    }

    public float getProgressDirection(float f10, float f11) {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            return MotionScene$Transition.access$200(this.mCurrentTransition).getProgressDirection(f10, f11);
        }
        return 0.0f;
    }

    public float getStaggered() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            return MotionScene$Transition.access$1900(motionScene$Transition);
        }
        return 0.0f;
    }

    public int getStartId() {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition == null) {
            return -1;
        }
        return MotionScene$Transition.access$100(motionScene$Transition);
    }

    public MotionScene$Transition getTransitionById(int n10) {
        boolean bl2;
        Iterator iterator2 = this.mTransitionList.iterator();
        while (bl2 = iterator2.hasNext()) {
            MotionScene$Transition motionScene$Transition = (MotionScene$Transition)iterator2.next();
            int n11 = MotionScene$Transition.access$300(motionScene$Transition);
            if (n11 != n10) continue;
            return motionScene$Transition;
        }
        return null;
    }

    public int getTransitionDirection(int n10) {
        int n11;
        Iterator iterator2 = this.mTransitionList.iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            MotionScene$Transition motionScene$Transition = (MotionScene$Transition)iterator2.next();
            n11 = MotionScene$Transition.access$100(motionScene$Transition);
            if (n11 != n10) continue;
            return 0;
        }
        return 1;
    }

    public List getTransitionsWithState(int n10) {
        boolean bl2;
        n10 = this.getRealID(n10);
        ArrayList<MotionScene$Transition> arrayList = new ArrayList<MotionScene$Transition>();
        Iterator iterator2 = this.mTransitionList.iterator();
        while (bl2 = iterator2.hasNext()) {
            MotionScene$Transition motionScene$Transition = (MotionScene$Transition)iterator2.next();
            int n11 = MotionScene$Transition.access$100(motionScene$Transition);
            if (n11 != n10 && (n11 = MotionScene$Transition.access$000(motionScene$Transition)) != n10) continue;
            arrayList.add(motionScene$Transition);
        }
        return arrayList;
    }

    public boolean hasKeyFramePosition(View view, int n10) {
        boolean bl2;
        Object object = this.mCurrentTransition;
        if (object == null) {
            return false;
        }
        object = MotionScene$Transition.access$1300((MotionScene$Transition)object).iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (KeyFrames)object.next();
            int n11 = view.getId();
            object2 = ((KeyFrames)object2).getKeyFramesForView(n11).iterator();
            while ((n11 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                Key key = (Key)object2.next();
                n11 = key.mFramePosition;
                if (n11 != n10) continue;
                return true;
            }
        }
        return false;
    }

    public int lookUpConstraintId(String string2) {
        return (Integer)this.mConstraintSetIdMap.get(string2);
    }

    public String lookUpConstraintName(int n10) {
        boolean bl2;
        Iterator iterator2 = this.mConstraintSetIdMap.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Integer n11 = (Integer)entry.getValue();
            int n12 = n11;
            if (n12 != n10) continue;
            return (String)entry.getKey();
        }
        return null;
    }

    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
    }

    public void processScrollMove(float f10, float f11) {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            object = MotionScene$Transition.access$200(this.mCurrentTransition);
            ((TouchResponse)object).scrollMove(f10, f11);
        }
    }

    public void processScrollUp(float f10, float f11) {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            object = MotionScene$Transition.access$200(this.mCurrentTransition);
            ((TouchResponse)object).scrollUp(f10, f11);
        }
    }

    public void processTouchEvent(MotionEvent object, int n10, MotionLayout motionLayout) {
        float f10;
        boolean bl2;
        Object object2;
        Object object3 = new RectF();
        MotionLayout$MotionTracker motionLayout$MotionTracker = this.mVelocityTracker;
        if (motionLayout$MotionTracker == null) {
            this.mVelocityTracker = motionLayout$MotionTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement((MotionEvent)object);
        motionLayout$MotionTracker = null;
        int n11 = -1;
        int n12 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 != n11) {
            int n13 = object.getAction();
            int n14 = 0;
            float f12 = 0.0f;
            if (n13 != 0) {
                int n15 = 2;
                float f13 = 2.8E-45f;
                if (n13 == n15 && (n13 = (int)(this.mIgnoreTouch ? 1 : 0)) == 0) {
                    MotionEvent motionEvent;
                    double d10;
                    float f14 = object.getRawY();
                    f13 = this.mLastTouchY;
                    f14 -= f13;
                    f13 = object.getRawX();
                    float f15 = this.mLastTouchX;
                    double d11 = f13 -= f15;
                    double d12 = 0.0;
                    double d13 = d11 - d12;
                    double d14 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
                    if (d14 == false && (d14 = (d10 = (d11 = (double)f14) - d12) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) == false || (motionEvent = this.mLastTouchDown) == null) {
                        return;
                    }
                    object2 = this.bestTransitionFor(n10, f13, f14, motionEvent);
                    if (object2 != null) {
                        motionLayout.setTransition((MotionScene$Transition)object2);
                        object2 = MotionScene$Transition.access$200(this.mCurrentTransition);
                        MotionLayout motionLayout2 = this.mMotionLayout;
                        object3 = ((TouchResponse)object2).getTouchRegion(motionLayout2, (RectF)object3);
                        if (object3 != null && !(bl2 = object3.contains(f14 = (object2 = this.mLastTouchDown).getX(), f13 = (motionLayout2 = this.mLastTouchDown).getY()))) {
                            n14 = n12;
                            f12 = f11;
                        }
                        this.mMotionOutsideRegion = n14;
                        object3 = MotionScene$Transition.access$200(this.mCurrentTransition);
                        f14 = this.mLastTouchX;
                        f12 = this.mLastTouchY;
                        ((TouchResponse)object3).setUpTouchEvent(f14, f12);
                    }
                }
            } else {
                float f16;
                this.mLastTouchX = f16 = object.getRawX();
                this.mLastTouchY = f16 = object.getRawY();
                this.mLastTouchDown = object;
                this.mIgnoreTouch = false;
                object = MotionScene$Transition.access$200(this.mCurrentTransition);
                if (object != null) {
                    float f17;
                    boolean bl3;
                    object = MotionScene$Transition.access$200(this.mCurrentTransition);
                    MotionLayout motionLayout3 = this.mMotionLayout;
                    if ((object = ((TouchResponse)object).getLimitBoundsTo(motionLayout3, (RectF)object3)) != null && !(bl3 = object.contains(f16 = (motionLayout3 = this.mLastTouchDown).getX(), f17 = (motionLayout = this.mLastTouchDown).getY()))) {
                        this.mLastTouchDown = null;
                        this.mIgnoreTouch = n12;
                        return;
                    }
                    object = MotionScene$Transition.access$200(this.mCurrentTransition);
                    motionLayout3 = this.mMotionLayout;
                    this.mMotionOutsideRegion = (object = ((TouchResponse)object).getTouchRegion(motionLayout3, (RectF)object3)) != null && !(bl3 = object.contains(f16 = (motionLayout3 = this.mLastTouchDown).getX(), f17 = (motionLayout = this.mLastTouchDown).getY())) ? n12 : false;
                    object = MotionScene$Transition.access$200(this.mCurrentTransition);
                    f16 = this.mLastTouchX;
                    f17 = this.mLastTouchY;
                    ((TouchResponse)object).setDown(f16, f17);
                }
                return;
            }
        }
        if (bl2 = this.mIgnoreTouch) {
            return;
        }
        object3 = this.mCurrentTransition;
        if (object3 != null && (object3 = MotionScene$Transition.access$200((MotionScene$Transition)object3)) != null && !(bl2 = this.mMotionOutsideRegion)) {
            object3 = MotionScene$Transition.access$200(this.mCurrentTransition);
            object2 = this.mVelocityTracker;
            ((TouchResponse)object3).processTouchEvent((MotionEvent)object, (MotionLayout$MotionTracker)object2, n10, this);
        }
        this.mLastTouchX = f10 = object.getRawX();
        this.mLastTouchY = f10 = object.getRawY();
        int n16 = object.getAction();
        if (n16 == n12 && (object = this.mVelocityTracker) != null) {
            object.recycle();
            this.mVelocityTracker = null;
            n16 = motionLayout.mCurrentState;
            if (n16 != n11) {
                this.autoTransition(motionLayout, n16);
            }
        }
    }

    public void readFallback(MotionLayout motionLayout) {
        SparseArray sparseArray;
        int n10;
        int n11;
        int n12 = 0;
        Object object = null;
        for (n11 = 0; n11 < (n10 = (sparseArray = this.mConstraintSetMap).size()); ++n11) {
            sparseArray = this.mConstraintSetMap;
            n10 = sparseArray.keyAt(n11);
            boolean bl2 = this.hasCycleDependency(n10);
            if (bl2) {
                Log.e((String)TAG, (String)"Cannot be derived from yourself");
                return;
            }
            this.readConstraintChain(n10);
        }
        while (n12 < (n11 = (object = this.mConstraintSetMap).size())) {
            object = (ConstraintSet)this.mConstraintSetMap.valueAt(n12);
            ((ConstraintSet)object).readFallback(motionLayout);
            ++n12;
        }
    }

    public void removeTransition(MotionScene$Transition motionScene$Transition) {
        int n10;
        int n11 = this.getIndex(motionScene$Transition);
        if (n11 != (n10 = -1)) {
            ArrayList arrayList = this.mTransitionList;
            arrayList.remove(n11);
        }
    }

    public void setConstraintSet(int n10, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(n10, (Object)constraintSet);
    }

    public void setDuration(int n10) {
        MotionScene$Transition motionScene$Transition = this.mCurrentTransition;
        if (motionScene$Transition != null) {
            motionScene$Transition.setDuration(n10);
        } else {
            this.mDefaultDuration = n10;
        }
    }

    public void setKeyframe(View view, int n10, String string2, Object object) {
        boolean bl2;
        Object object2 = this.mCurrentTransition;
        if (object2 == null) {
            return;
        }
        object2 = MotionScene$Transition.access$1300((MotionScene$Transition)object2).iterator();
        while (bl2 = object2.hasNext()) {
            Object object3 = (KeyFrames)object2.next();
            int n11 = view.getId();
            object3 = ((KeyFrames)object3).getKeyFramesForView(n11).iterator();
            while ((n11 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                float f10;
                float f11;
                Object object4;
                Object object5 = (Key)object3.next();
                n11 = ((Key)object5).mFramePosition;
                if (n11 != n10) continue;
                n11 = 0;
                object5 = null;
                if (object != null) {
                    object4 = object;
                    object4 = (Float)object;
                    f11 = ((Float)object4).floatValue();
                } else {
                    object4 = null;
                    f11 = 0.0f;
                }
                n11 = (f10 = f11 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1);
                object5 = "app:PerpendicularPath_percent";
                string2.equalsIgnoreCase((String)object5);
            }
        }
    }

    public void setRtl(boolean bl2) {
        this.mRtl = bl2;
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            object = MotionScene$Transition.access$200(this.mCurrentTransition);
            boolean bl3 = this.mRtl;
            ((TouchResponse)object).setRTL(bl3);
        }
    }

    public void setTransition(int n10, int n11) {
        int n12;
        MotionScene$Transition motionScene$Transition;
        boolean bl2;
        int n13;
        int n14;
        int n15;
        block7: {
            block6: {
                block5: {
                    StateSet stateSet = this.mStateSet;
                    n15 = -1;
                    if (stateSet == null) break block5;
                    n14 = stateSet.stateGetConstraintID(n10, n15, n15);
                    if (n14 == n15) {
                        n14 = n10;
                    }
                    StateSet stateSet2 = this.mStateSet;
                    n13 = stateSet2.stateGetConstraintID(n11, n15, n15);
                    if (n13 == n15) break block6;
                    break block7;
                }
                n14 = n10;
            }
            n13 = n11;
        }
        Iterator iterator2 = this.mTransitionList.iterator();
        while (bl2 = iterator2.hasNext()) {
            TouchResponse touchResponse;
            motionScene$Transition = (MotionScene$Transition)iterator2.next();
            n12 = MotionScene$Transition.access$000(motionScene$Transition);
            if ((n12 != n13 || (n12 = MotionScene$Transition.access$100(motionScene$Transition)) != n14) && ((n12 = MotionScene$Transition.access$000(motionScene$Transition)) != n11 || (n12 = MotionScene$Transition.access$100(motionScene$Transition)) != n10)) continue;
            this.mCurrentTransition = motionScene$Transition;
            if (motionScene$Transition != null && (touchResponse = MotionScene$Transition.access$200(motionScene$Transition)) != null) {
                touchResponse = MotionScene$Transition.access$200(this.mCurrentTransition);
                n11 = this.mRtl ? 1 : 0;
                touchResponse.setRTL(n11 != 0);
            }
            return;
        }
        Object object = this.mDefaultTransition;
        iterator2 = this.mAbstractTransitionList.iterator();
        while (bl2 = iterator2.hasNext()) {
            motionScene$Transition = (MotionScene$Transition)iterator2.next();
            n12 = MotionScene$Transition.access$000(motionScene$Transition);
            if (n12 != n11) continue;
            object = motionScene$Transition;
        }
        MotionScene$Transition motionScene$Transition2 = new MotionScene$Transition(this, (MotionScene$Transition)object);
        MotionScene$Transition.access$102(motionScene$Transition2, n14);
        MotionScene$Transition.access$002(motionScene$Transition2, n13);
        if (n14 != n15) {
            object = this.mTransitionList;
            ((ArrayList)object).add(motionScene$Transition2);
        }
        this.mCurrentTransition = motionScene$Transition2;
    }

    public void setTransition(MotionScene$Transition object) {
        this.mCurrentTransition = object;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            object = MotionScene$Transition.access$200(this.mCurrentTransition);
            boolean bl2 = this.mRtl;
            ((TouchResponse)object).setRTL(bl2);
        }
    }

    public void setupTouch() {
        Object object = this.mCurrentTransition;
        if (object != null && (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) != null) {
            object = MotionScene$Transition.access$200(this.mCurrentTransition);
            ((TouchResponse)object).setupTouch();
        }
    }

    public boolean supportTouch() {
        boolean bl2;
        Object object;
        block2: {
            TouchResponse touchResponse;
            object = this.mTransitionList.iterator();
            do {
                boolean bl3 = object.hasNext();
                bl2 = true;
                if (!bl3) break block2;
            } while ((touchResponse = MotionScene$Transition.access$200((MotionScene$Transition)object.next())) == null);
            return bl2;
        }
        object = this.mCurrentTransition;
        if (object == null || (object = MotionScene$Transition.access$200((MotionScene$Transition)object)) == null) {
            bl2 = false;
        }
        return bl2;
    }

    public boolean validateLayout(MotionLayout object) {
        boolean bl2;
        MotionLayout motionLayout = this.mMotionLayout;
        if (object == motionLayout && (object = ((MotionLayout)object).mScene) == this) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

