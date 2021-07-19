/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  android.view.MotionEvent
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker;
import androidx.constraintlayout.motion.widget.MotionLayout$TransitionState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.TouchResponse$1;
import androidx.constraintlayout.motion.widget.TouchResponse$2;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.NestedScrollView$OnScrollChangeListener;
import org.xmlpull.v1.XmlPullParser;

public class TouchResponse {
    private static final boolean DEBUG = false;
    public static final int FLAG_DISABLE_POST_SCROLL = 1;
    public static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final float[][] TOUCH_DIRECTION;
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final float[][] TOUCH_SIDES;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP;
    private float[] mAnchorDpDt;
    private float mDragScale;
    private boolean mDragStarted;
    private float mDragThreshold;
    private int mFlags;
    private float mLastTouchX;
    private float mLastTouchY;
    private int mLimitBoundsTo;
    private float mMaxAcceleration;
    private float mMaxVelocity;
    private final MotionLayout mMotionLayout;
    private boolean mMoveWhenScrollAtTop;
    private int mOnTouchUp = 0;
    private int mTouchAnchorId;
    private int mTouchAnchorSide = 0;
    private float mTouchAnchorX;
    private float mTouchAnchorY;
    private float mTouchDirectionX;
    private float mTouchDirectionY;
    private int mTouchRegionId;
    private int mTouchSide = 0;

    static {
        float[][] fArrayArray = new float[7][];
        int n10 = 2;
        float[] fArray = new float[n10];
        fArray[0] = 0.5f;
        fArray[1] = 0.0f;
        fArrayArray[0] = fArray;
        fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 0.5f;
        int n11 = 1;
        fArrayArray[n11] = fArray;
        fArray = new float[n10];
        fArray[0] = 1.0f;
        fArray[1] = 0.5f;
        fArrayArray[n10] = fArray;
        fArray = new float[n10];
        fArray[0] = 0.5f;
        fArray[1] = 1.0f;
        int n12 = 3;
        fArrayArray[n12] = fArray;
        fArray = new float[n10];
        fArray[0] = 0.5f;
        fArray[1] = 0.5f;
        int n13 = 4;
        fArrayArray[n13] = fArray;
        fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 0.5f;
        int n14 = 5;
        fArrayArray[n14] = fArray;
        fArray = new float[n10];
        fArray[0] = 1.0f;
        fArray[1] = 0.5f;
        int n15 = 6;
        fArrayArray[n15] = fArray;
        TOUCH_SIDES = fArrayArray;
        fArrayArray = new float[n15][];
        fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = -1.0f;
        fArrayArray[0] = fArray;
        fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[1] = 1.0f;
        fArrayArray[n11] = fArray;
        fArray = new float[n10];
        fArray[0] = -1.0f;
        fArray[1] = 0.0f;
        fArrayArray[n10] = fArray;
        fArray = new float[n10];
        fArray[0] = 1.0f;
        fArray[1] = 0.0f;
        fArrayArray[n12] = fArray;
        fArray = new float[n10];
        fArray[0] = -1.0f;
        fArray[1] = 0.0f;
        fArrayArray[n13] = fArray;
        float[] fArray2 = new float[n10];
        fArray2[0] = 1.0f;
        fArray2[1] = 0.0f;
        fArrayArray[n14] = fArray2;
        TOUCH_DIRECTION = fArrayArray;
    }

    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        float f10;
        int n10;
        this.mTouchAnchorId = n10 = -1;
        this.mTouchRegionId = n10;
        this.mLimitBoundsTo = n10;
        this.mTouchAnchorY = f10 = 0.5f;
        this.mTouchAnchorX = f10;
        this.mTouchDirectionX = 0.0f;
        this.mTouchDirectionY = f10 = 1.0f;
        this.mDragStarted = false;
        float[] fArray = new float[2];
        this.mAnchorDpDt = fArray;
        this.mMaxVelocity = 4.0f;
        this.mMaxAcceleration = 1.2f;
        this.mMoveWhenScrollAtTop = true;
        this.mDragScale = f10;
        this.mFlags = 0;
        this.mDragThreshold = 10.0f;
        this.mMotionLayout = motionLayout;
        motionLayout = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        this.fillFromAttributeList(context, (AttributeSet)motionLayout);
    }

    private void fill(TypedArray typedArray) {
        int n10 = typedArray.getIndexCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10;
            float f11;
            float[] fArray;
            float f12;
            float[] fArray2;
            float[][] fArray3;
            int n11;
            int n12 = typedArray.getIndex(i10);
            if (n12 == (n11 = R$styleable.OnSwipe_touchAnchorId)) {
                n11 = this.mTouchAnchorId;
                this.mTouchAnchorId = n12 = typedArray.getResourceId(n12, n11);
                continue;
            }
            n11 = R$styleable.OnSwipe_touchAnchorSide;
            int n13 = 1;
            if (n12 == n11) {
                n11 = this.mTouchAnchorSide;
                this.mTouchAnchorSide = n12 = typedArray.getInt(n12, n11);
                fArray3 = TOUCH_SIDES;
                fArray2 = fArray3[n12];
                this.mTouchAnchorX = f12 = fArray2[0];
                fArray = fArray3[n12];
                this.mTouchAnchorY = f11 = fArray[n13];
                continue;
            }
            n11 = R$styleable.OnSwipe_dragDirection;
            if (n12 == n11) {
                n11 = this.mTouchSide;
                this.mTouchSide = n12 = typedArray.getInt(n12, n11);
                fArray3 = TOUCH_DIRECTION;
                fArray2 = fArray3[n12];
                this.mTouchDirectionX = f12 = fArray2[0];
                fArray = fArray3[n12];
                this.mTouchDirectionY = f11 = fArray[n13];
                continue;
            }
            n11 = R$styleable.OnSwipe_maxVelocity;
            if (n12 == n11) {
                f10 = this.mMaxVelocity;
                this.mMaxVelocity = f11 = typedArray.getFloat(n12, f10);
                continue;
            }
            n11 = R$styleable.OnSwipe_maxAcceleration;
            if (n12 == n11) {
                f10 = this.mMaxAcceleration;
                this.mMaxAcceleration = f11 = typedArray.getFloat(n12, f10);
                continue;
            }
            n11 = R$styleable.OnSwipe_moveWhenScrollAtTop;
            if (n12 == n11) {
                n11 = this.mMoveWhenScrollAtTop ? 1 : 0;
                n12 = typedArray.getBoolean(n12, n11 != 0) ? 1 : 0;
                this.mMoveWhenScrollAtTop = n12;
                continue;
            }
            n11 = R$styleable.OnSwipe_dragScale;
            if (n12 == n11) {
                f10 = this.mDragScale;
                this.mDragScale = f11 = typedArray.getFloat(n12, f10);
                continue;
            }
            n11 = R$styleable.OnSwipe_dragThreshold;
            if (n12 == n11) {
                f10 = this.mDragThreshold;
                this.mDragThreshold = f11 = typedArray.getFloat(n12, f10);
                continue;
            }
            n11 = R$styleable.OnSwipe_touchRegionId;
            if (n12 == n11) {
                n11 = this.mTouchRegionId;
                this.mTouchRegionId = n12 = typedArray.getResourceId(n12, n11);
                continue;
            }
            n11 = R$styleable.OnSwipe_onTouchUp;
            if (n12 == n11) {
                n11 = this.mOnTouchUp;
                this.mOnTouchUp = n12 = typedArray.getInt(n12, n11);
                continue;
            }
            n11 = R$styleable.OnSwipe_nestedScrollFlags;
            if (n12 == n11) {
                this.mFlags = n12 = typedArray.getInteger(n12, 0);
                continue;
            }
            n11 = R$styleable.OnSwipe_limitBoundsTo;
            if (n12 != n11) continue;
            this.mLimitBoundsTo = n12 = typedArray.getResourceId(n12, 0);
        }
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.OnSwipe;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.fill((TypedArray)context);
        context.recycle();
    }

    public float dot(float f10, float f11) {
        float f12 = this.mTouchDirectionX;
        f10 *= f12;
        f12 = this.mTouchDirectionY;
        return f10 + (f11 *= f12);
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        int n10 = this.mLimitBoundsTo;
        float f10 = 0.0f;
        int n11 = -1;
        float f11 = 0.0f / 0.0f;
        if (n10 == n11) {
            return null;
        }
        if ((viewGroup = viewGroup.findViewById(n10)) == null) {
            return null;
        }
        float f12 = viewGroup.getLeft();
        f10 = viewGroup.getTop();
        f11 = viewGroup.getRight();
        float f13 = viewGroup.getBottom();
        rectF.set(f12, f10, f11, f13);
        return rectF;
    }

    public int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    public float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    public boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    public float getProgressDirection(float f10, float f11) {
        MotionLayout motionLayout = this.mMotionLayout;
        float f12 = motionLayout.getProgress();
        MotionLayout motionLayout2 = this.mMotionLayout;
        int n10 = this.mTouchAnchorId;
        float f13 = this.mTouchAnchorX;
        float f14 = this.mTouchAnchorY;
        float[] fArray = this.mAnchorDpDt;
        motionLayout2.getAnchorDpDt(n10, f12, f13, f14, fArray);
        float f15 = this.mTouchDirectionX;
        int n11 = 0;
        float f16 = 0.0f;
        motionLayout2 = null;
        float f17 = f15 - 0.0f;
        n10 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
        f12 = 1.0E-7f;
        if (n10 != 0) {
            float[] fArray2 = this.mAnchorDpDt;
            n10 = 0;
            float f18 = 0.0f;
            f13 = fArray2[0];
            float f19 = f13 - 0.0f;
            n11 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
            if (!n11) {
                fArray2[0] = f12;
            }
            f10 *= f15;
            f11 = fArray2[0];
            f10 /= f11;
        } else {
            float[] fArray3 = this.mAnchorDpDt;
            int n12 = 1;
            f15 = Float.MIN_VALUE;
            float f20 = fArray3[n12];
            float f21 = f20 - 0.0f;
            n11 = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
            if (!n11) {
                fArray3[n12] = f12;
            }
            f16 = this.mTouchDirectionY;
            f10 = fArray3[n12];
            f10 = (f11 *= f16) / f10;
        }
        return f10;
    }

    public RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        int n10 = this.mTouchRegionId;
        float f10 = 0.0f;
        int n11 = -1;
        float f11 = 0.0f / 0.0f;
        if (n10 == n11) {
            return null;
        }
        if ((viewGroup = viewGroup.findViewById(n10)) == null) {
            return null;
        }
        float f12 = viewGroup.getLeft();
        f10 = viewGroup.getTop();
        f11 = viewGroup.getRight();
        float f13 = viewGroup.getBottom();
        rectF.set(f12, f10, f11, f13);
        return rectF;
    }

    public int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void processTouchEvent(MotionEvent motionEvent, MotionLayout$MotionTracker motionLayout$MotionTracker, int n10, MotionScene motionScene) {
        float f10;
        float f11;
        float f12;
        float f13;
        float[] fArray;
        MotionLayout motionLayout;
        TouchResponse touchResponse = this;
        Object object = motionLayout$MotionTracker;
        MotionEvent motionEvent2 = motionEvent;
        motionLayout$MotionTracker.addMovement(motionEvent);
        int n11 = motionEvent.getAction();
        int n12 = 0;
        if (n11 == 0) {
            float f14;
            this.mLastTouchX = f14 = motionEvent.getRawX();
            this.mLastTouchY = f14 = motionEvent.getRawY();
            this.mDragStarted = false;
            return;
        }
        int n13 = -1;
        float f15 = 0.0f / 0.0f;
        int n14 = 1000;
        int n15 = 1065353216;
        float f16 = 1.0f;
        int n16 = 1;
        if (n11 != n16) {
            Object object2;
            float[] fArray2;
            float f17;
            float f18;
            Object object3;
            int n17;
            Object object4;
            int n18 = 2;
            float f19 = 2.8E-45f;
            if (n11 != n18) {
                return;
            }
            float f20 = motionEvent.getRawY();
            f19 = this.mLastTouchY;
            f20 -= f19;
            f19 = motionEvent.getRawX();
            float f21 = this.mLastTouchX;
            f19 -= f21;
            f21 = this.mTouchDirectionX * f19;
            float f22 = this.mTouchDirectionY * f20;
            float f23 = (f21 = Math.abs(f21 + f22)) - (f22 = this.mDragThreshold);
            float f24 = f23 == 0.0f ? 0 : (f23 > 0.0f ? 1 : -1);
            if (f24 <= 0) {
                f24 = (float)this.mDragStarted;
                if (f24 == false) return;
            }
            MotionLayout motionLayout2 = touchResponse.mMotionLayout;
            f21 = motionLayout2.getProgress();
            int n19 = touchResponse.mDragStarted;
            if (n19 == 0) {
                touchResponse.mDragStarted = n16;
                object4 = touchResponse.mMotionLayout;
                ((MotionLayout)object4).setProgress(f21);
            }
            if ((n17 = touchResponse.mTouchAnchorId) != n13) {
                object4 = touchResponse.mMotionLayout;
                float f25 = touchResponse.mTouchAnchorX;
                f15 = touchResponse.mTouchAnchorY;
                float[] fArray3 = touchResponse.mAnchorDpDt;
                float f26 = f21;
                ((MotionLayout)object4).getAnchorDpDt(n17, f21, f25, f15, fArray3);
            } else {
                object3 = touchResponse.mMotionLayout;
                n13 = object3.getWidth();
                n19 = touchResponse.mMotionLayout.getHeight();
                n13 = Math.min(n13, n19);
                f15 = n13;
                object4 = touchResponse.mAnchorDpDt;
                f18 = touchResponse.mTouchDirectionY * f15;
                object4[n16] = f18;
                f18 = touchResponse.mTouchDirectionX;
                object4[0] = f15 *= f18;
            }
            f15 = touchResponse.mTouchDirectionX;
            object4 = touchResponse.mAnchorDpDt;
            f18 = (float)object4[0];
            f15 *= f18;
            f18 = touchResponse.mTouchDirectionY;
            f22 = (float)object4[n16];
            f15 += (f18 *= f22);
            f22 = touchResponse.mDragScale;
            f15 = Math.abs(f15 * f22);
            double d10 = f15;
            double d11 = 0.01;
            n13 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
            if (n13 < 0) {
                object3 = touchResponse.mAnchorDpDt;
                n19 = 1008981770;
                f22 = 0.01f;
                object3[0] = f22;
                object3[n16] = f22;
            }
            if ((n13 = (int)((f17 = (f15 = touchResponse.mTouchDirectionX) - 0.0f) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) != 0) {
                fArray2 = touchResponse.mAnchorDpDt;
                f20 = fArray2[0];
                f19 /= f20;
            } else {
                object3 = touchResponse.mAnchorDpDt;
                f15 = (float)object3[n16];
                f19 = f20 / f15;
            }
            f20 = Math.max(Math.min(f21 += f19, f16), 0.0f);
            object3 = touchResponse.mMotionLayout;
            f15 = ((MotionLayout)object3).getProgress();
            n13 = f20 == f15 ? 0 : (f20 > f15 ? 1 : -1);
            if (n13 != 0) {
                object3 = touchResponse.mMotionLayout;
                ((MotionLayout)object3).setProgress(f20);
                object.computeCurrentVelocity(n14);
                f20 = motionLayout$MotionTracker.getXVelocity();
                object2 = motionLayout$MotionTracker.getYVelocity();
                f15 = touchResponse.mTouchDirectionX;
                float f27 = f15 - 0.0f;
                n13 = f27 == 0.0f ? 0 : (f27 > 0.0f ? 1 : -1);
                if (n13 != 0) {
                    object = touchResponse.mAnchorDpDt;
                    object2 = object[0];
                    f20 /= object2;
                } else {
                    fArray2 = touchResponse.mAnchorDpDt;
                    f20 = fArray2[n16];
                    f20 = object2 / f20;
                }
                object = touchResponse.mMotionLayout;
                ((MotionLayout)object).mLastVelocity = f20;
            } else {
                object = touchResponse.mMotionLayout;
                ((MotionLayout)object).mLastVelocity = 0.0f;
            }
            touchResponse.mLastTouchX = object2 = motionEvent.getRawX();
            touchResponse.mLastTouchY = object2 = motionEvent.getRawY();
            return;
        }
        this.mDragStarted = false;
        motionLayout$MotionTracker.computeCurrentVelocity(n14);
        float f28 = motionLayout$MotionTracker.getXVelocity();
        float f29 = motionLayout$MotionTracker.getYVelocity();
        MotionLayout motionLayout3 = this.mMotionLayout;
        float f30 = motionLayout3.getProgress();
        int n20 = this.mTouchAnchorId;
        if (n20 != n13) {
            MotionLayout motionLayout4 = this.mMotionLayout;
            float f31 = this.mTouchAnchorX;
            float f32 = this.mTouchAnchorY;
            float[] fArray4 = this.mAnchorDpDt;
            float f33 = f30;
            motionLayout4.getAnchorDpDt(n20, f30, f31, f32, fArray4);
        } else {
            motionLayout = this.mMotionLayout;
            n13 = motionLayout.getWidth();
            n14 = this.mMotionLayout.getHeight();
            n13 = Math.min(n13, n14);
            f15 = n13;
            fArray = this.mAnchorDpDt;
            fArray[n16] = f13 = this.mTouchDirectionY * f15;
            f13 = this.mTouchDirectionX;
            fArray[0] = f15 *= f13;
        }
        f15 = touchResponse.mTouchDirectionX;
        fArray = touchResponse.mAnchorDpDt;
        f13 = fArray[0];
        f13 = fArray[n16];
        float f34 = f15 - 0.0f;
        n13 = f34 == 0.0f ? 0 : (f34 > 0.0f ? 1 : -1);
        if (n13 != 0) {
            f29 = fArray[0];
            f28 /= f29;
        } else {
            f28 = fArray[n16];
            f28 = f29 / f28;
        }
        int n21 = Float.isNaN(f28);
        if (n21 == 0) {
            n21 = 0x40400000;
            f29 = f28 / 3.0f + f30;
        } else {
            f29 = f30;
        }
        n12 = (f12 = f29 - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (n12 != 0 && (n12 = f29 == f16 ? 0 : (f29 > f16 ? 1 : -1)) != 0) {
            n12 = touchResponse.mOnTouchUp;
            n13 = 3;
            f15 = 4.2E-45f;
            if (n12 != n13) {
                motionLayout = touchResponse.mMotionLayout;
                double d12 = f29;
                double d13 = 0.5;
                double d14 = d12 - d13;
                n21 = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
                if (n21 < 0) {
                    n21 = 0;
                    object = null;
                    f29 = 0.0f;
                } else {
                    n21 = n15;
                    f29 = f16;
                }
                motionLayout.touchAnimateTo(n12, f29, f28);
                float f35 = 0.0f - f30;
                n21 = f35 == 0.0f ? 0 : (f35 > 0.0f ? 1 : -1);
                if (n21 < 0) {
                    n21 = f16 == f30 ? 0 : (f16 < f30 ? -1 : 1);
                    if (n21 > 0) return;
                }
                object = touchResponse.mMotionLayout;
                MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
                ((MotionLayout)object).setState(motionLayout$TransitionState);
                return;
            }
        }
        if ((f11 = (f10 = 0.0f - f29) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) < 0) {
            n21 = f16 == f29 ? 0 : (f16 < f29 ? -1 : 1);
            if (n21 > 0) return;
        }
        object = touchResponse.mMotionLayout;
        MotionLayout$TransitionState motionLayout$TransitionState = MotionLayout$TransitionState.FINISHED;
        ((MotionLayout)object).setState(motionLayout$TransitionState);
    }

    public void scrollMove(float f10, float f11) {
        Object object;
        Object object2;
        MotionLayout motionLayout = this.mMotionLayout;
        float f12 = motionLayout.getProgress();
        int n10 = this.mDragStarted;
        int n11 = 1;
        if (n10 == 0) {
            this.mDragStarted = n11;
            object2 = this.mMotionLayout;
            ((MotionLayout)object2).setProgress(f12);
        }
        object2 = this.mMotionLayout;
        int n12 = this.mTouchAnchorId;
        float f13 = this.mTouchAnchorX;
        float f14 = this.mTouchAnchorY;
        float[] fArray = this.mAnchorDpDt;
        ((MotionLayout)object2).getAnchorDpDt(n12, f12, f13, f14, fArray);
        float f15 = this.mTouchDirectionX;
        float[] fArray2 = this.mAnchorDpDt;
        f13 = fArray2[0];
        f15 *= f13;
        f13 = this.mTouchDirectionY;
        float f16 = fArray2[n11];
        f15 = Math.abs(f15 + (f13 *= f16));
        double d10 = f15;
        double d11 = 0.01;
        n10 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        if (n10 < 0) {
            object2 = this.mAnchorDpDt;
            n12 = 1008981770;
            f16 = 0.01f;
            object2[0] = f16;
            object2[n11] = f16;
        }
        f15 = this.mTouchDirectionX;
        n12 = 0;
        f16 = 0.0f;
        fArray2 = null;
        float f17 = f15 - 0.0f;
        float f18 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
        if (f18 != false) {
            f10 *= f15;
            object = this.mAnchorDpDt;
            f11 = object[0];
            f10 /= f11;
        } else {
            f10 = this.mTouchDirectionY;
            f11 *= f10;
            float[] fArray3 = this.mAnchorDpDt;
            f10 = fArray3[n11];
            f10 = f11 / f10;
        }
        f12 += f10;
        f10 = Math.max(Math.min(f12, 1.0f), 0.0f);
        object = this.mMotionLayout;
        f11 = ((MotionLayout)object).getProgress();
        float f19 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (f19 != false) {
            object = this.mMotionLayout;
            ((MotionLayout)object).setProgress(f10);
        }
    }

    public void scrollUp(float f10, float f11) {
        float f12;
        int n10 = 0;
        MotionLayout motionLayout = null;
        this.mDragStarted = false;
        MotionLayout motionLayout2 = this.mMotionLayout;
        float f13 = motionLayout2.getProgress();
        MotionLayout motionLayout3 = this.mMotionLayout;
        int n11 = this.mTouchAnchorId;
        float f14 = this.mTouchAnchorX;
        float f15 = this.mTouchAnchorY;
        float[] fArray = this.mAnchorDpDt;
        float f16 = f13;
        motionLayout3.getAnchorDpDt(n11, f13, f14, f15, fArray);
        float f17 = this.mTouchDirectionX;
        float[] fArray2 = this.mAnchorDpDt;
        f16 = fArray2[0];
        f16 = this.mTouchDirectionY;
        int n12 = 1;
        f14 = Float.MIN_VALUE;
        f15 = fArray2[n12];
        f15 = 0.0f;
        float f18 = f17 - 0.0f;
        float f19 = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (f19 != false) {
            f10 *= f17;
            f11 = fArray2[0];
            f10 /= f11;
        } else {
            f10 = fArray2[n12];
            f10 = (f11 *= f16) / f10;
        }
        int n13 = Float.isNaN(f10);
        if (n13 == 0) {
            n13 = 0x40400000;
            f11 = f10 / 3.0f;
            f13 += f11;
        }
        if ((n13 = (int)((f12 = f13 - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) != 0) {
            n13 = 1065353216;
            f11 = 1.0f;
            float f20 = f13 - f11;
            float f21 = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
            if (f21 != false) {
                f21 = n12;
                f17 = f14;
            } else {
                f21 = 0.0f;
                motionLayout3 = null;
                f17 = 0.0f;
            }
            n11 = this.mOnTouchUp;
            int n14 = 3;
            f16 = 4.2E-45f;
            if (n11 != n14) {
                n10 = n12;
            }
            if ((n10 &= f21) != 0) {
                motionLayout = this.mMotionLayout;
                double d10 = f13;
                double d11 = 0.5;
                double d12 = d10 - d11;
                double d13 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
                if (d13 >= 0) {
                    f15 = f11;
                }
                motionLayout.touchAnimateTo(n11, f15, f10);
            }
        }
    }

    public void setAnchorId(int n10) {
        this.mTouchAnchorId = n10;
    }

    public void setDown(float f10, float f11) {
        this.mLastTouchX = f10;
        this.mLastTouchY = f11;
    }

    public void setMaxAcceleration(float f10) {
        this.mMaxAcceleration = f10;
    }

    public void setMaxVelocity(float f10) {
        this.mMaxVelocity = f10;
    }

    public void setRTL(boolean bl2) {
        float f10;
        float[][] fArray;
        int n10 = 6;
        int n11 = 3;
        float f11 = 4.2E-45f;
        int n12 = 4;
        int n13 = 1;
        int n14 = 5;
        int n15 = 2;
        if (bl2) {
            fArray = TOUCH_DIRECTION;
            float[] fArray2 = fArray[n11];
            fArray[n12] = fArray2;
            fArray2 = fArray[n15];
            fArray[n14] = fArray2;
            fArray = TOUCH_SIDES;
            fArray2 = fArray[n15];
            fArray[n14] = fArray2;
            fArray2 = fArray[n13];
            fArray[n10] = fArray2;
        } else {
            fArray = TOUCH_DIRECTION;
            float[] fArray3 = fArray[n15];
            fArray[n12] = fArray3;
            float[] fArray4 = fArray[n11];
            fArray[n14] = fArray4;
            fArray = TOUCH_SIDES;
            fArray4 = fArray[n13];
            fArray[n14] = fArray4;
            fArray4 = fArray[n15];
            fArray[n10] = fArray4;
        }
        fArray = TOUCH_SIDES;
        n10 = this.mTouchAnchorSide;
        this.mTouchAnchorX = f11 = fArray[n10][0];
        this.mTouchAnchorY = f10 = fArray[n10][n13];
        fArray = TOUCH_DIRECTION;
        n10 = this.mTouchSide;
        this.mTouchDirectionX = f11 = fArray[n10][0];
        this.mTouchDirectionY = f10 = fArray[n10][n13];
    }

    public void setTouchAnchorLocation(float f10, float f11) {
        this.mTouchAnchorX = f10;
        this.mTouchAnchorY = f11;
    }

    public void setUpTouchEvent(float f10, float f11) {
        this.mLastTouchX = f10;
        this.mLastTouchY = f11;
        this.mDragStarted = false;
    }

    public void setupTouch() {
        Object object;
        Object object2;
        int n10 = this.mTouchAnchorId;
        int n11 = -1;
        if (n10 != n11) {
            object2 = this.mMotionLayout;
            object = object2.findViewById(n10);
            if (object == null) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("cannot find TouchAnchorId @id/");
                Object object3 = this.mMotionLayout.getContext();
                int n12 = this.mTouchAnchorId;
                object3 = Debug.getName(object3, n12);
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                object3 = TAG;
                Log.e((String)object3, (String)object2);
            }
        } else {
            n10 = 0;
            object = null;
        }
        if ((n11 = object instanceof NestedScrollView) != 0) {
            object = (NestedScrollView)object;
            object2 = new TouchResponse$1(this);
            object.setOnTouchListener((View.OnTouchListener)object2);
            object2 = new TouchResponse$2(this);
            ((NestedScrollView)object).setOnScrollChangeListener((NestedScrollView$OnScrollChangeListener)object2);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        float f10 = this.mTouchDirectionX;
        stringBuilder.append(f10);
        stringBuilder.append(" , ");
        f10 = this.mTouchDirectionY;
        stringBuilder.append(f10);
        return stringBuilder.toString();
    }
}

