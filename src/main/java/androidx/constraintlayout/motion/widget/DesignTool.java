/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Pair
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.motion.widget.MotionController
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ProxyInterface;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import java.io.PrintStream;
import java.util.HashMap;

public class DesignTool
implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    public static final HashMap allAttributes;
    public static final HashMap allMargins;
    private String mLastEndState = null;
    private int mLastEndStateId;
    private String mLastStartState = null;
    private int mLastStartStateId;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        HashMap<String, Object> hashMap;
        Object object = new HashMap();
        allAttributes = object;
        allMargins = hashMap = new HashMap<String, Object>();
        Integer n10 = 4;
        Object object2 = Pair.create((Object)n10, (Object)n10);
        String string2 = "layout_constraintBottom_toBottomOf";
        ((HashMap)object).put(object2, string2);
        object2 = 3;
        Object object3 = Pair.create((Object)n10, (Object)object2);
        String string3 = "layout_constraintBottom_toTopOf";
        ((HashMap)object).put(object3, string3);
        n10 = Pair.create((Object)object2, (Object)n10);
        object3 = "layout_constraintTop_toBottomOf";
        ((HashMap)object).put(n10, object3);
        n10 = Pair.create((Object)object2, (Object)object2);
        object2 = "layout_constraintTop_toTopOf";
        ((HashMap)object).put(n10, object2);
        n10 = 6;
        Object object4 = Pair.create((Object)n10, (Object)n10);
        String string4 = "layout_constraintStart_toStartOf";
        ((HashMap)object).put(object4, string4);
        object4 = 7;
        Object object5 = Pair.create((Object)n10, (Object)object4);
        String string5 = "layout_constraintStart_toEndOf";
        ((HashMap)object).put(object5, string5);
        n10 = Pair.create((Object)object4, (Object)n10);
        object5 = "layout_constraintEnd_toStartOf";
        ((HashMap)object).put(n10, object5);
        n10 = Pair.create((Object)object4, (Object)object4);
        object4 = "layout_constraintEnd_toEndOf";
        ((HashMap)object).put(n10, object4);
        n10 = 1;
        Object object6 = Pair.create((Object)n10, (Object)n10);
        String string6 = "layout_constraintLeft_toLeftOf";
        ((HashMap)object).put(object6, string6);
        object6 = 2;
        Pair pair = Pair.create((Object)n10, (Object)object6);
        String string7 = "layout_constraintLeft_toRightOf";
        ((HashMap)object).put(pair, string7);
        pair = Pair.create((Object)object6, (Object)object6);
        String string8 = "layout_constraintRight_toRightOf";
        ((HashMap)object).put(pair, string8);
        n10 = Pair.create((Object)object6, (Object)n10);
        object6 = "layout_constraintRight_toLeftOf";
        ((HashMap)object).put(n10, object6);
        n10 = 5;
        n10 = Pair.create((Object)n10, (Object)n10);
        ((HashMap)object).put(n10, "layout_constraintBaseline_toBaselineOf");
        object = "layout_marginBottom";
        hashMap.put(string2, object);
        hashMap.put(string3, object);
        object = "layout_marginTop";
        hashMap.put((String)object3, object);
        hashMap.put((String)object2, object);
        object = "layout_marginStart";
        hashMap.put(string4, object);
        hashMap.put(string5, object);
        hashMap.put((String)object5, "layout_marginEnd");
        hashMap.put((String)object4, "layout_marginEnd");
        hashMap.put(string6, "layout_marginLeft");
        hashMap.put(string7, "layout_marginLeft");
        hashMap.put(string8, "layout_marginRight");
        hashMap.put((String)object6, "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        int n10;
        this.mLastStartStateId = n10 = -1;
        this.mLastEndStateId = n10;
        this.mMotionLayout = motionLayout;
    }

    private static void Connect(int n10, ConstraintSet constraintSet, View view, HashMap object, int n11, int n12) {
        Object object2 = allAttributes;
        Object object3 = n11;
        Integer n13 = n12;
        object3 = Pair.create((Object)object3, (Object)n13);
        if ((object3 = (String)((HashMap)object).get(object2 = (String)((HashMap)object2).get(object3))) != null) {
            int n14 = 0;
            n13 = null;
            Object object4 = allMargins;
            if ((object2 = (String)((HashMap)object4).get(object2)) != null) {
                object = (String)((HashMap)object).get(object2);
                n14 = DesignTool.GetPxFromDp(n10, (String)object);
            }
            int n15 = Integer.parseInt((String)object3);
            int n16 = view.getId();
            object4 = constraintSet;
            constraintSet.connect(n16, n11, n15, n12, n14);
        }
    }

    private static int GetPxFromDp(int n10, String string2) {
        int n11;
        if (string2 == null) {
            return 0;
        }
        int n12 = string2.indexOf(100);
        if (n12 == (n11 = -1)) {
            return 0;
        }
        return (int)((float)(Integer.valueOf(string2.substring(0, n12)) * n10) / 160.0f);
    }

    private static void SetAbsolutePositions(int n10, ConstraintSet constraintSet, View view, HashMap object) {
        String string2 = (String)((HashMap)object).get("layout_editor_absoluteX");
        if (string2 != null) {
            int n11 = view.getId();
            int n12 = DesignTool.GetPxFromDp(n10, string2);
            constraintSet.setEditorAbsoluteX(n11, n12);
        }
        if ((object = (String)((HashMap)object).get(string2 = "layout_editor_absoluteY")) != null) {
            int n13 = view.getId();
            n10 = DesignTool.GetPxFromDp(n10, (String)object);
            constraintSet.setEditorAbsoluteY(n13, n10);
        }
    }

    private static void SetBias(ConstraintSet constraintSet, View view, HashMap object, int n10) {
        int n11 = 1;
        String string2 = n10 == n11 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias";
        if ((object = (String)((HashMap)object).get(string2)) != null) {
            if (n10 == 0) {
                int n12 = view.getId();
                float f10 = Float.parseFloat((String)object);
                constraintSet.setHorizontalBias(n12, f10);
            } else if (n10 == n11) {
                int n13 = view.getId();
                float f11 = Float.parseFloat((String)object);
                constraintSet.setVerticalBias(n13, f11);
            }
        }
    }

    private static void SetDimensions(int n10, ConstraintSet constraintSet, View view, HashMap object, int n11) {
        int n12 = 1;
        String string2 = n11 == n12 ? "layout_height" : "layout_width";
        if ((object = (String)((HashMap)object).get(string2)) != null) {
            n12 = -2;
            String string3 = "wrap_content";
            boolean bl2 = ((String)object).equalsIgnoreCase(string3);
            if (!bl2) {
                n12 = DesignTool.GetPxFromDp(n10, (String)object);
            }
            if (n11 == 0) {
                n10 = view.getId();
                constraintSet.constrainWidth(n10, n12);
            } else {
                n10 = view.getId();
                constraintSet.constrainHeight(n10, n12);
            }
        }
    }

    public int designAccess(int n10, String string2, Object object, float[] fArray, int n11, float[] fArray2, int n12) {
        object = (View)object;
        int n13 = 0;
        n11 = -1;
        if (n10 != 0) {
            Object object2 = this.mMotionLayout;
            MotionScene motionScene = ((MotionLayout)object2).mScene;
            if (motionScene == null) {
                return n11;
            }
            if (object == null || (object = (MotionController)((HashMap)(object2 = ((MotionLayout)object2).mFrameArrayList)).get(object)) == null) {
                return n11;
            }
        } else {
            object = null;
        }
        int n14 = 1;
        if (n10 != 0) {
            if (n10 != n14) {
                n14 = 2;
                if (n10 != n14) {
                    n13 = 3;
                    if (n10 != n13) {
                        return n11;
                    }
                    n10 = this.mMotionLayout.mScene.getDuration() / 16;
                    return object.getAttributeValues(string2, fArray2, n12);
                }
                n10 = this.mMotionLayout.mScene.getDuration() / 16;
                object.buildKeyFrames(fArray2, null);
                return n10;
            }
            n10 = this.mMotionLayout.mScene.getDuration() / 16;
            object.buildPath(fArray2, n10);
            return n10;
        }
        return n14;
    }

    public void disableAutoTransition(boolean bl2) {
        this.mMotionLayout.disableAutoTransition(bl2);
    }

    public void dumpConstraintSet(String object) {
        Object object2 = this.mMotionLayout;
        Object object3 = ((MotionLayout)object2).mScene;
        if (object3 == null) {
            object3 = this.mSceneCache;
            ((MotionLayout)object2).mScene = object3;
        }
        int n10 = ((MotionLayout)object2).lookUpConstraintId((String)object);
        object3 = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = " dumping  ";
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append(" (");
        stringBuilder.append(n10);
        stringBuilder.append(")");
        object = stringBuilder.toString();
        ((PrintStream)object3).println((String)object);
        object = this.mMotionLayout;
        object = ((MotionLayout)object).mScene;
        object = ((MotionScene)object).getConstraintSet(n10);
        object2 = this.mMotionLayout;
        object2 = ((MotionLayout)object2).mScene;
        object3 = null;
        object3 = new int[0];
        try {
            ((ConstraintSet)object).dump((MotionScene)object2, (int[])object3);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object object, float[] fArray) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int n10 = motionScene.getDuration() / 16;
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        if ((object = (MotionController)hashMap.get(object)) == null) {
            return 0;
        }
        object.buildKeyFrames(fArray, null);
        return n10;
    }

    public int getAnimationPath(Object object, float[] fArray, int n10) {
        Object object2 = this.mMotionLayout;
        MotionScene motionScene = ((MotionLayout)object2).mScene;
        if (motionScene == null) {
            return -1;
        }
        object2 = ((MotionLayout)object2).mFrameArrayList;
        if ((object = (MotionController)((HashMap)object2).get(object)) == null) {
            return 0;
        }
        object.buildPath(fArray, n10);
        return n10;
    }

    public void getAnimationRectangles(Object object, float[] fArray) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene == null) {
            return;
        }
        int n10 = motionScene.getDuration() / 16;
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        if ((object = (MotionController)hashMap.get(object)) == null) {
            return;
        }
        object.buildRectangles(fArray, n10);
    }

    public String getEndState() {
        int n10 = this.mLastEndStateId;
        MotionLayout motionLayout = this.mMotionLayout;
        int n11 = motionLayout.getEndState();
        if (n10 == n11) {
            return this.mLastEndState;
        }
        String string2 = this.mMotionLayout.getConstraintSetNames(n11);
        if (string2 != null) {
            this.mLastEndState = string2;
            this.mLastEndStateId = n11;
        }
        return string2;
    }

    public int getKeyFrameInfo(Object object, int n10, int[] nArray) {
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        object = (View)object;
        if ((object = (MotionController)hashMap.get(object)) == null) {
            return 0;
        }
        return object.getKeyFrameInfo(n10, nArray);
    }

    public float getKeyFramePosition(Object object, int n10, float f10, float f11) {
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        object = (View)object;
        return ((MotionController)hashMap.get(object)).getKeyFrameParameter(n10, f10, f11);
    }

    public int getKeyFramePositions(Object object, int[] nArray, float[] fArray) {
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        object = (View)object;
        if ((object = (MotionController)hashMap.get(object)) == null) {
            return 0;
        }
        return object.getkeyFramePositions(nArray, fArray);
    }

    public Object getKeyframe(int n10, int n11, int n12) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return null;
        }
        motionLayout = motionLayout.getContext();
        return motionScene.getKeyFrame((Context)motionLayout, n10, n11, n12);
    }

    public Object getKeyframe(Object object, int n10, int n11) {
        Object object2 = this.mMotionLayout.mScene;
        if (object2 == null) {
            return null;
        }
        int n12 = ((View)object).getId();
        object2 = this.mMotionLayout;
        MotionScene motionScene = ((MotionLayout)object2).mScene;
        object2 = object2.getContext();
        return motionScene.getKeyFrame((Context)object2, n10, n12, n11);
    }

    public Object getKeyframeAtLocation(Object object, float f10, float f11) {
        object = (View)object;
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            return -1;
        }
        int n10 = 0;
        motionScene = null;
        if (object != null) {
            motionLayout = (MotionController)motionLayout.mFrameArrayList.get(object);
            if (motionLayout == null) {
                return null;
            }
            object = (ViewGroup)object.getParent();
            n10 = object.getWidth();
            int n11 = object.getHeight();
            return motionLayout.getPositionKeyframe(n10, n11, f10, f11);
        }
        return null;
    }

    public Boolean getPositionKeyframe(Object object, Object object2, float f10, float f11, String[] stringArray, float[] fArray) {
        boolean bl2 = object instanceof KeyPositionBase;
        if (bl2) {
            Object object3 = object;
            object3 = (KeyPositionBase)object;
            object = this.mMotionLayout.mFrameArrayList;
            Object object4 = object2;
            object4 = (View)object2;
            object = ((HashMap)object).get(object4);
            ((MotionController)object).positionKeyframe((View)object4, (KeyPositionBase)object3, f10, f11, stringArray, fArray);
            this.mMotionLayout.rebuildScene();
            this.mMotionLayout.mInTransition = true;
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int n10 = this.mLastStartStateId;
        MotionLayout motionLayout = this.mMotionLayout;
        int n11 = motionLayout.getStartState();
        if (n10 == n11) {
            return this.mLastStartState;
        }
        String string2 = this.mMotionLayout.getConstraintSetNames(n11);
        if (string2 != null) {
            this.mLastStartState = string2;
            this.mLastStartStateId = n11;
        }
        return this.mMotionLayout.getConstraintSetNames(n11);
    }

    public String getState() {
        String string2 = this.mLastStartState;
        if (string2 != null && (string2 = this.mLastEndState) != null) {
            float f10;
            float f11 = this.getProgress();
            float f12 = f11 - (f10 = 0.01f);
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object <= 0) {
                return this.mLastStartState;
            }
            object = 1065185444;
            f10 = 0.99f;
            float f13 = f11 - f10;
            Object object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2 >= 0) {
                return this.mLastEndState;
            }
        }
        return this.mLastStartState;
    }

    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        boolean bl2;
        String string2 = this.mLastStartState;
        if (string2 != null && (string2 = this.mLastEndState) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public void setAttributes(int n10, String string2, Object object, Object object2) {
        object = (View)object;
        object2 = (HashMap)object2;
        MotionScene motionScene = this.mMotionLayout.mScene;
        int n11 = this.mMotionLayout.lookUpConstraintId(string2);
        ConstraintSet constraintSet = motionScene.getConstraintSet(n11);
        if (constraintSet == null) {
            return;
        }
        int n12 = object.getId();
        constraintSet.clear(n12);
        DesignTool.SetDimensions(n10, constraintSet, (View)object, (HashMap)object2, 0);
        int n13 = 1;
        DesignTool.SetDimensions(n10, constraintSet, (View)object, (HashMap)object2, n13);
        int n14 = 6;
        n12 = n10;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 6);
        int n15 = 7;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, n15);
        n14 = 7;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, n15);
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 6);
        n14 = 1;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 1);
        n15 = 2;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, n15);
        n14 = 2;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, n15);
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 1);
        n14 = 3;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 3);
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 4);
        n14 = 4;
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 3);
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, n14, 4);
        DesignTool.Connect(n10, constraintSet, (View)object, (HashMap)object2, 5, 5);
        DesignTool.SetBias(constraintSet, (View)object, (HashMap)object2, 0);
        DesignTool.SetBias(constraintSet, (View)object, (HashMap)object2, n13);
        DesignTool.SetAbsolutePositions(n10, constraintSet, (View)object, (HashMap)object2);
        this.mMotionLayout.updateState(n11, constraintSet);
        this.mMotionLayout.requestLayout();
    }

    public void setKeyFrame(Object object, int n10, String string2, Object object2) {
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (motionScene != null) {
            object = (View)object;
            motionScene.setKeyframe((View)object, n10, string2, object2);
            object = this.mMotionLayout;
            float f10 = n10;
            float f11 = 100.0f;
            ((MotionLayout)object).mTransitionGoalPosition = f10 /= f11;
            ((MotionLayout)object).mTransitionLastPosition = 0.0f;
            ((MotionLayout)object).rebuildScene();
            object = this.mMotionLayout;
            n10 = 1;
            f10 = Float.MIN_VALUE;
            ((MotionLayout)object).evaluate(n10 != 0);
        }
    }

    public boolean setKeyFramePosition(Object object, int n10, int n11, float f10, float f11) {
        Object object2 = this.mMotionLayout;
        Object object3 = ((MotionLayout)object2).mScene;
        if (object3 != null) {
            object2 = (MotionController)((MotionLayout)object2).mFrameArrayList.get(object);
            object3 = this.mMotionLayout;
            float f12 = ((MotionLayout)object3).mTransitionPosition;
            float f13 = 100.0f;
            int n12 = (int)(f12 *= f13);
            if (object2 != null && (n11 = (int)(((MotionScene)(object3 = ((MotionLayout)object3).mScene)).hasKeyFramePosition((View)(object = (View)object), n12) ? 1 : 0)) != 0) {
                float f14 = object2.getKeyFrameParameter(2, f10, f11);
                float f15 = object2.getKeyFrameParameter(5, f10, f11);
                MotionScene motionScene = this.mMotionLayout.mScene;
                object3 = Float.valueOf(f14);
                motionScene.setKeyframe((View)object, n12, "motion:percentX", object3);
                object3 = this.mMotionLayout.mScene;
                object2 = Float.valueOf(f15);
                ((MotionScene)object3).setKeyframe((View)object, n12, "motion:percentY", object2);
                this.mMotionLayout.rebuildScene();
                object = this.mMotionLayout;
                n10 = 1;
                ((MotionLayout)object).evaluate(n10 != 0);
                this.mMotionLayout.invalidate();
                return n10 != 0;
            }
        }
        return false;
    }

    public void setKeyframe(Object object, String string2, Object object2) {
        boolean bl2 = object instanceof Key;
        if (bl2) {
            boolean bl3;
            ((Key)object).setValue(string2, object2);
            this.mMotionLayout.rebuildScene();
            object = this.mMotionLayout;
            ((MotionLayout)object).mInTransition = bl3 = true;
        }
    }

    public void setState(String object) {
        Object object2;
        if (object == null) {
            object = "motion_base";
        }
        if ((object2 = this.mLastStartState) == object) {
            return;
        }
        this.mLastStartState = object;
        int n10 = 0;
        this.mLastEndState = null;
        object2 = this.mMotionLayout;
        MotionScene motionScene = ((MotionLayout)object2).mScene;
        if (motionScene == null) {
            ((MotionLayout)object2).mScene = motionScene = this.mSceneCache;
        }
        int n11 = object != null ? ((MotionLayout)object2).lookUpConstraintId((String)object) : R$id.motion_base;
        this.mLastStartStateId = n11;
        if (n11 != 0) {
            object2 = this.mMotionLayout;
            n10 = ((MotionLayout)object2).getStartState();
            if (n11 == n10) {
                object = this.mMotionLayout;
                n10 = 0;
                object2 = null;
                ((MotionLayout)object).setProgress(0.0f);
            } else {
                object2 = this.mMotionLayout;
                n10 = ((MotionLayout)object2).getEndState();
                float f10 = 1.0f;
                if (n11 == n10) {
                    object = this.mMotionLayout;
                    ((MotionLayout)object).setProgress(f10);
                } else {
                    object2 = this.mMotionLayout;
                    ((MotionLayout)object2).transitionToState(n11);
                    object = this.mMotionLayout;
                    ((MotionLayout)object).setProgress(f10);
                }
            }
        }
        this.mMotionLayout.requestLayout();
    }

    public void setToolPosition(float f10) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            motionLayout.mScene = motionScene = this.mSceneCache;
        }
        motionLayout.setProgress(f10);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String string2, String string3) {
        MotionLayout motionLayout = this.mMotionLayout;
        MotionScene motionScene = motionLayout.mScene;
        if (motionScene == null) {
            motionLayout.mScene = motionScene = this.mSceneCache;
        }
        int n10 = motionLayout.lookUpConstraintId(string2);
        int n11 = this.mMotionLayout.lookUpConstraintId(string3);
        this.mMotionLayout.setTransition(n10, n11);
        this.mLastStartStateId = n10;
        this.mLastEndStateId = n11;
        this.mLastStartState = string2;
        this.mLastEndState = string3;
    }

    public void setViewDebug(Object object, int n10) {
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        if ((object = (MotionController)hashMap.get(object)) != null) {
            object.setDrawPath(n10);
            object = this.mMotionLayout;
            object.invalidate();
        }
    }
}

