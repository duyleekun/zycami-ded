/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  android.view.View
 *  android.view.View$OnClickListener
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.MotionScene$Transition;
import androidx.constraintlayout.widget.R$styleable;
import org.xmlpull.v1.XmlPullParser;

public class MotionScene$Transition$TransitionOnClick
implements View.OnClickListener {
    public static final int ANIM_TOGGLE = 17;
    public static final int ANIM_TO_END = 1;
    public static final int ANIM_TO_START = 16;
    public static final int JUMP_TO_END = 256;
    public static final int JUMP_TO_START = 4096;
    public int mMode;
    public int mTargetId = -1;
    private final MotionScene$Transition mTransition;

    public MotionScene$Transition$TransitionOnClick(Context context, MotionScene$Transition motionScene$Transition, XmlPullParser object) {
        int n10;
        this.mMode = n10 = 17;
        this.mTransition = motionScene$Transition;
        motionScene$Transition = Xml.asAttributeSet((XmlPullParser)object);
        object = R$styleable.OnClick;
        context = context.obtainStyledAttributes((AttributeSet)motionScene$Transition, (int[])object);
        int n11 = context.getIndexCount();
        object = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            n10 = context.getIndex(i10);
            if (n10 == (n12 = R$styleable.OnClick_targetId)) {
                n12 = this.mTargetId;
                this.mTargetId = n10 = context.getResourceId(n10, n12);
                continue;
            }
            n12 = R$styleable.OnClick_clickAction;
            if (n10 != n12) continue;
            n12 = this.mMode;
            this.mMode = n10 = context.getInt(n10, n12);
        }
        context.recycle();
    }

    public void addOnClickListeners(MotionLayout object, int n10, MotionScene$Transition motionScene$Transition) {
        int n11 = this.mTargetId;
        int n12 = -1;
        if (n11 != n12) {
            object = object.findViewById(n11);
        }
        if (object == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("OnClick could not find id ");
            n10 = this.mTargetId;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Log.e((String)"MotionScene", (String)object);
            return;
        }
        n11 = MotionScene$Transition.access$100(motionScene$Transition);
        int n13 = MotionScene$Transition.access$000(motionScene$Transition);
        if (n11 == n12) {
            object.setOnClickListener((View.OnClickListener)this);
            return;
        }
        n12 = this.mMode;
        int n14 = n12 & 1;
        int n15 = 0;
        int n16 = 1;
        n14 = n14 != 0 && n10 == n11 ? n16 : 0;
        int n17 = n12 & 0x100;
        n17 = n17 != 0 && n10 == n11 ? n16 : 0;
        n14 |= n17;
        n17 = n12 & 1;
        n11 = n17 != 0 && n10 == n11 ? n16 : 0;
        n11 |= n14;
        n14 = n12 & 0x10;
        n14 = n14 != 0 && n10 == n13 ? n16 : 0;
        n11 |= n14;
        if ((n12 &= 0x1000) != 0 && n10 == n13) {
            n15 = n16;
        }
        if ((n10 = n11 | n15) != 0) {
            object.setOnClickListener((View.OnClickListener)this);
        }
    }

    public boolean isTransitionViable(MotionScene$Transition motionScene$Transition, MotionLayout motionLayout) {
        int n10;
        MotionScene$Transition motionScene$Transition2 = this.mTransition;
        boolean bl2 = true;
        if (motionScene$Transition2 == motionScene$Transition) {
            return bl2;
        }
        int n11 = MotionScene$Transition.access$000(motionScene$Transition2);
        motionScene$Transition2 = this.mTransition;
        int n12 = MotionScene$Transition.access$100(motionScene$Transition2);
        if (n12 == (n10 = -1)) {
            int n13 = motionLayout.mCurrentState;
            if (n13 == n11) {
                bl2 = false;
            }
            return bl2;
        }
        int n14 = motionLayout.mCurrentState;
        if (n14 != n12 && n14 != n11) {
            bl2 = false;
        }
        return bl2;
    }

    public void onClick(View object) {
        boolean bl2;
        int n10;
        int n11;
        int n12;
        MotionScene$Transition motionScene$Transition;
        block22: {
            int n13;
            block21: {
                int n14;
                MotionScene$Transition motionScene$Transition2;
                float f10;
                Object var5_17;
                object = MotionScene.access$800(MotionScene$Transition.access$700(this.mTransition));
                boolean n132 = ((MotionLayout)object).isInteractionEnabled();
                if (!n132) {
                    return;
                }
                motionScene$Transition = this.mTransition;
                int n15 = MotionScene$Transition.access$100(motionScene$Transition);
                if (n15 == (n12 = -1)) {
                    int n16 = ((MotionLayout)object).getCurrentState();
                    if (n16 == n12) {
                        int n17 = MotionScene$Transition.access$000(this.mTransition);
                        ((MotionLayout)object).transitionToState(n17);
                        return;
                    }
                    MotionScene motionScene = MotionScene$Transition.access$700(this.mTransition);
                    MotionScene$Transition motionScene$Transition3 = this.mTransition;
                    MotionScene$Transition motionScene$Transition4 = new MotionScene$Transition(motionScene, motionScene$Transition3);
                    MotionScene$Transition.access$102(motionScene$Transition4, n16);
                    int n18 = MotionScene$Transition.access$000(this.mTransition);
                    MotionScene$Transition.access$002(motionScene$Transition4, n18);
                    ((MotionLayout)object).setTransition(motionScene$Transition4);
                    ((MotionLayout)object).transitionToEnd();
                    return;
                }
                motionScene$Transition = MotionScene$Transition.access$700((MotionScene$Transition)this.mTransition).mCurrentTransition;
                n12 = this.mMode;
                n13 = n12 & 1;
                n11 = 0;
                Object var7_21 = null;
                n10 = 1;
                float f11 = Float.MIN_VALUE;
                if (n13 == 0 && (n13 = n12 & 0x100) == 0) {
                    n13 = 0;
                    Object var6_19 = null;
                } else {
                    n13 = n10;
                }
                int n19 = n12 & 0x10;
                if (n19 == 0 && (n12 &= 0x1000) == 0) {
                    n12 = 0;
                    var5_17 = null;
                } else {
                    n12 = n10;
                }
                if (n13 != 0 && n12 != 0) {
                    n19 = n10;
                    f10 = f11;
                } else {
                    n19 = 0;
                    motionScene$Transition2 = null;
                    f10 = 0.0f;
                }
                if (n19 == 0) break block21;
                motionScene$Transition2 = MotionScene$Transition.access$700((MotionScene$Transition)this.mTransition).mCurrentTransition;
                MotionScene$Transition motionScene$Transition5 = this.mTransition;
                if (motionScene$Transition2 != motionScene$Transition5) {
                    ((MotionLayout)object).setTransition(motionScene$Transition5);
                }
                if ((n19 = ((MotionLayout)object).getCurrentState()) == (n14 = ((MotionLayout)object).getEndState())) break block22;
                f10 = ((MotionLayout)object).getProgress();
                n14 = 0x3F000000;
                float f12 = 0.5f;
                float f13 = f10 - f12;
                n19 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                if (n19 > 0) break block22;
                n12 = 0;
                var5_17 = null;
            }
            n11 = n13;
        }
        if (bl2 = this.isTransitionViable(motionScene$Transition, (MotionLayout)object)) {
            int n20;
            int n21;
            int n22;
            int n23;
            if (n11 != 0 && (n23 = this.mMode & n10) != 0) {
                motionScene$Transition = this.mTransition;
                ((MotionLayout)object).setTransition(motionScene$Transition);
                ((MotionLayout)object).transitionToEnd();
            } else if (n12 != 0 && (n22 = this.mMode & 0x10) != 0) {
                motionScene$Transition = this.mTransition;
                ((MotionLayout)object).setTransition(motionScene$Transition);
                ((MotionLayout)object).transitionToStart();
            } else if (n11 != 0 && (n21 = this.mMode & 0x100) != 0) {
                motionScene$Transition = this.mTransition;
                ((MotionLayout)object).setTransition(motionScene$Transition);
                int n24 = 1065353216;
                float f14 = 1.0f;
                ((MotionLayout)object).setProgress(f14);
            } else if (n12 != 0 && (n20 = this.mMode & 0x1000) != 0) {
                motionScene$Transition = this.mTransition;
                ((MotionLayout)object).setTransition(motionScene$Transition);
                boolean bl3 = false;
                float f15 = 0.0f;
                motionScene$Transition = null;
                ((MotionLayout)object).setProgress(0.0f);
            }
        }
    }

    public void removeOnClickListeners(MotionLayout object) {
        int n10 = this.mTargetId;
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        if ((object = object.findViewById(n10)) == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(" (*)  could not find id ");
            n10 = this.mTargetId;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Log.e((String)"MotionScene", (String)object);
            return;
        }
        object.setOnClickListener(null);
    }
}

