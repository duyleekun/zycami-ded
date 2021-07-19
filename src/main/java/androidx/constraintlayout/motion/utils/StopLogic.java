/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

public class StopLogic
extends MotionInterpolator {
    private boolean mBackwards = false;
    private float mLastPosition;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    private float calcY(float f10) {
        float f11 = this.mStage1Duration;
        Object object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        float f12 = 2.0f;
        if (object <= 0) {
            float f13 = this.mStage1Velocity;
            float f14 = f13 * f10;
            float f15 = (this.mStage2Velocity - f13) * f10 * f10;
            return f14 + (f15 /= (f11 *= f12));
        }
        object = this.mNumberOfStages;
        Object object2 = 1;
        float f16 = Float.MIN_VALUE;
        if (object == object2) {
            return this.mStage1EndPosition;
        }
        float f17 = (f10 -= f11) - (f11 = this.mStage2Duration);
        object2 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
        if (object2 < 0) {
            float f18 = this.mStage1EndPosition;
            f16 = this.mStage2Velocity;
            float f19 = f16 * f10;
            f18 += f19;
            f19 = (this.mStage3Velocity - f16) * f10 * f10;
            return f18 + (f19 /= (f11 *= f12));
        }
        object2 = 2;
        f16 = 2.8E-45f;
        if (object == object2) {
            return this.mStage2EndPosition;
        }
        float f20 = (f10 -= f11) - (f11 = this.mStage3Duration);
        object = f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1);
        if (object < 0) {
            float f21 = this.mStage2EndPosition;
            f16 = this.mStage3Velocity;
            float f22 = f16 * f10;
            f16 = f16 * f10 * f10;
            return (f21 += f22) - (f16 /= (f11 *= f12));
        }
        return this.mStage3EndPosition;
    }

    private void setup(float f10, float f11, float f12, float f13, float f14) {
        float f15 = f10 - 0.0f;
        Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object == false) {
            f10 = 1.0E-4f;
        }
        this.mStage1Velocity = f10;
        float f16 = f10 / f12;
        float f17 = f16 * f10;
        float f18 = 2.0f;
        f17 /= f18;
        float f19 = f10 - 0.0f;
        Object object2 = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
        int n10 = 3;
        int n11 = 2;
        if (object2 < 0) {
            f14 = -f10 / f12 * f10 / f18;
            double d10 = Math.sqrt((f11 - f14) * f12);
            float f20 = (f14 = (float)d10) - f13;
            object = f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1);
            if (object < 0) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = n11;
                this.mStage1Velocity = f10;
                this.mStage2Velocity = f14;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = f13 = (f14 - f10) / f12;
                this.mStage2Duration = f12 = f14 / f12;
                this.mStage1EndPosition = f10 = (f10 + f14) * f13 / f18;
                this.mStage2EndPosition = f11;
                this.mStage3EndPosition = f11;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = n10;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f13;
            this.mStage3Velocity = f13;
            this.mStage1Duration = f14 = (f13 - f10) / f12;
            this.mStage3Duration = f12 = f13 / f12;
            f10 = (f10 + f13) * f14 / f18;
            f12 = f12 * f13 / f18;
            this.mStage2Duration = f14 = (f11 - f10 - f12) / f13;
            this.mStage1EndPosition = f10;
            this.mStage2EndPosition = f10 = f11 - f12;
            this.mStage3EndPosition = f11;
            return;
        }
        object2 = f17 == f11 ? 0 : (f17 > f11 ? 1 : -1);
        if (object2 >= 0) {
            this.mType = "hard stop";
            f18 = f18 * f11 / f10;
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f11;
            this.mStage1Duration = f18;
            return;
        }
        float f21 = (f17 = f11 - f17) / f10;
        float f22 = f21 + f16;
        float f23 = f22 - f14;
        Object object3 = f23 == 0.0f ? 0 : (f23 < 0.0f ? -1 : 1);
        if (object3 < 0) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = n11;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f10;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f17;
            this.mStage2EndPosition = f11;
            this.mStage1Duration = f21;
            this.mStage2Duration = f16;
            return;
        }
        f14 = f12 * f11;
        f16 = f10 * f10 / f18;
        double d11 = Math.sqrt(f14 + f16);
        f14 = (float)d11;
        this.mStage1Duration = f16 = (f14 - f10) / f12;
        this.mStage2Duration = f17 = f14 / f12;
        object2 = f14 == f13 ? 0 : (f14 < f13 ? -1 : 1);
        if (object2 < 0) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = n11;
            this.mStage1Velocity = f10;
            this.mStage2Velocity = f14;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = f16;
            this.mStage2Duration = f17;
            this.mStage1EndPosition = f10 = (f10 + f14) * f16 / f18;
            this.mStage2EndPosition = f11;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = n10;
        this.mStage1Velocity = f10;
        this.mStage2Velocity = f13;
        this.mStage3Velocity = f13;
        this.mStage1Duration = f14 = (f13 - f10) / f12;
        this.mStage3Duration = f12 = f13 / f12;
        f10 = (f10 + f13) * f14 / f18;
        f12 = f12 * f13 / f18;
        this.mStage2Duration = f14 = (f11 - f10 - f12) / f13;
        this.mStage1EndPosition = f10;
        this.mStage2EndPosition = f10 = f11 - f12;
        this.mStage3EndPosition = f11;
    }

    public void config(float f10, float f11, float f12, float f13, float f14, float f15) {
        float f16;
        this.mStartPosition = f10;
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object > 0) {
            object = true;
            f16 = Float.MIN_VALUE;
        } else {
            object = false;
            f16 = 0.0f;
        }
        this.mBackwards = object;
        if (object != false) {
            f16 = -f12;
            float f17 = f10 - f11;
            this.setup(f16, f17, f14, f15, f13);
        } else {
            float f18 = f11 - f10;
            f16 = f12;
            this.setup(f12, f18, f14, f15, f13);
        }
    }

    public void debug(String string2, String string3, float f10) {
        float f11;
        float f12;
        float f13;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append(" ===== ");
        String string4 = this.mType;
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.v((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        int n10 = this.mBackwards;
        string4 = n10 != 0 ? "backwards" : "forward ";
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(" time = ");
        ((StringBuilder)charSequence).append(f10);
        ((StringBuilder)charSequence).append("  stages ");
        n10 = this.mNumberOfStages;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.v((String)string2, (String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(string3);
        string4 = " dur ";
        ((StringBuilder)charSequence).append(string4);
        float f14 = this.mStage1Duration;
        ((StringBuilder)charSequence).append(f14);
        String string5 = " vel ";
        ((StringBuilder)charSequence).append(string5);
        float f15 = this.mStage1Velocity;
        ((StringBuilder)charSequence).append(f15);
        String string6 = " pos ";
        ((StringBuilder)charSequence).append(string6);
        float f16 = this.mStage1EndPosition;
        ((StringBuilder)charSequence).append(f16);
        charSequence = ((StringBuilder)charSequence).toString();
        Log.v((String)string2, (String)charSequence);
        int n11 = this.mNumberOfStages;
        int n12 = 1;
        f16 = Float.MIN_VALUE;
        if (n11 > n12) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string4);
            f13 = this.mStage2Duration;
            ((StringBuilder)charSequence).append(f13);
            ((StringBuilder)charSequence).append(string5);
            f13 = this.mStage2Velocity;
            ((StringBuilder)charSequence).append(f13);
            ((StringBuilder)charSequence).append(string6);
            f13 = this.mStage2EndPosition;
            ((StringBuilder)charSequence).append(f13);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.v((String)string2, (String)charSequence);
        }
        n11 = this.mNumberOfStages;
        int n13 = 2;
        f13 = 2.8E-45f;
        if (n11 > n13) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(string4);
            float f17 = this.mStage3Duration;
            ((StringBuilder)charSequence).append(f17);
            ((StringBuilder)charSequence).append(string5);
            f17 = this.mStage3Velocity;
            ((StringBuilder)charSequence).append(f17);
            ((StringBuilder)charSequence).append(string6);
            f17 = this.mStage3EndPosition;
            ((StringBuilder)charSequence).append(f17);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.v((String)string2, (String)charSequence);
        }
        if ((n10 = (int)((f12 = f10 - (f11 = this.mStage1Duration)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1))) <= 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("stage 0");
            string3 = stringBuilder.toString();
            Log.v((String)string2, (String)string3);
            return;
        }
        n10 = this.mNumberOfStages;
        if (n10 == n12) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("end stage 0");
            string3 = stringBuilder.toString();
            Log.v((String)string2, (String)string3);
            return;
        }
        float f18 = (f10 -= f11) - (f11 = this.mStage2Duration);
        Object object = f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1);
        if (object < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(" stage 1");
            string3 = stringBuilder.toString();
            Log.v((String)string2, (String)string3);
            return;
        }
        if (n10 == n13) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append("end stage 1");
            string3 = stringBuilder.toString();
            Log.v((String)string2, (String)string3);
            return;
        }
        float f19 = (f10 -= f11) - (f11 = this.mStage3Duration);
        Object object2 = f19 == 0.0f ? 0 : (f19 < 0.0f ? -1 : 1);
        if (object2 < 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append(" stage 2");
            string3 = stringBuilder.toString();
            Log.v((String)string2, (String)string3);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append(" end stage 2");
        string3 = stringBuilder.toString();
        Log.v((String)string2, (String)string3);
    }

    public float getInterpolation(float f10) {
        float f11 = this.calcY(f10);
        this.mLastPosition = f10;
        boolean bl2 = this.mBackwards;
        f10 = bl2 ? this.mStartPosition - f11 : this.mStartPosition + f11;
        return f10;
    }

    public float getVelocity() {
        float f10;
        boolean bl2 = this.mBackwards;
        if (bl2) {
            f10 = this.mLastPosition;
            f10 = -this.getVelocity(f10);
        } else {
            f10 = this.mLastPosition;
            f10 = this.getVelocity(f10);
        }
        return f10;
    }

    public float getVelocity(float f10) {
        float f11 = this.mStage1Duration;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object <= 0) {
            float f13 = this.mStage1Velocity;
            float f14 = (this.mStage2Velocity - f13) * f10 / f11;
            return f13 + f14;
        }
        object = this.mNumberOfStages;
        Object object2 = 1;
        float f15 = Float.MIN_VALUE;
        if (object == object2) {
            return 0.0f;
        }
        float f16 = (f10 -= f11) - (f11 = this.mStage2Duration);
        object2 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
        if (object2 < 0) {
            float f17 = this.mStage2Velocity;
            f15 = (this.mStage3Velocity - f17) * f10 / f11;
            return f17 + f15;
        }
        object2 = 2;
        f15 = 2.8E-45f;
        if (object == object2) {
            return this.mStage2EndPosition;
        }
        float f18 = (f10 -= f11) - (f11 = this.mStage3Duration);
        object = f18 == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1);
        if (object < 0) {
            float f19 = this.mStage3Velocity;
            f10 = f10 * f19 / f11;
            return f19 - f10;
        }
        return this.mStage3EndPosition;
    }
}

