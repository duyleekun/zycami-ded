/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.util.TypedValue
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class KeyTrigger$Loader {
    private static final int COLLISION = 9;
    private static final int CROSS = 4;
    private static final int FRAME_POS = 8;
    private static final int NEGATIVE_CROSS = 1;
    private static final int POSITIVE_CROSS = 2;
    private static final int POST_LAYOUT = 10;
    private static final int TARGET_ID = 7;
    private static final int TRIGGER_ID = 6;
    private static final int TRIGGER_RECEIVER = 11;
    private static final int TRIGGER_SLACK = 5;
    private static SparseIntArray mAttrMap;

    static {
        SparseIntArray sparseIntArray;
        mAttrMap = sparseIntArray = new SparseIntArray();
        int n10 = R$styleable.KeyTrigger_framePosition;
        sparseIntArray.append(n10, 8);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_onCross;
        sparseIntArray.append(n10, 4);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_onNegativeCross;
        sparseIntArray.append(n10, 1);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_onPositiveCross;
        sparseIntArray.append(n10, 2);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_motionTarget;
        sparseIntArray.append(n10, 7);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_triggerId;
        sparseIntArray.append(n10, 6);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_triggerSlack;
        sparseIntArray.append(n10, 5);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_motion_triggerOnCollision;
        sparseIntArray.append(n10, 9);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_motion_postLayoutCollision;
        sparseIntArray.append(n10, 10);
        sparseIntArray = mAttrMap;
        n10 = R$styleable.KeyTrigger_triggerReceiver;
        sparseIntArray.append(n10, 11);
    }

    private KeyTrigger$Loader() {
    }

    public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
        int n10 = typedArray.getIndexCount();
        block12: for (int i10 = 0; i10 < n10; ++i10) {
            String string2;
            int n11 = typedArray.getIndex(i10);
            Object object = mAttrMap;
            int n12 = object.get(n11);
            switch (n12) {
                default: {
                    break;
                }
                case 11: {
                    n12 = KeyTrigger.access$700(keyTrigger);
                    n12 = typedArray.getResourceId(n11, n12);
                    KeyTrigger.access$702(keyTrigger, n12);
                    break;
                }
                case 10: {
                    n12 = KeyTrigger.access$600(keyTrigger) ? 1 : 0;
                    n11 = typedArray.getBoolean(n11, n12 != 0) ? 1 : 0;
                    KeyTrigger.access$602(keyTrigger, n11 != 0);
                    continue block12;
                }
                case 9: {
                    n12 = KeyTrigger.access$500(keyTrigger);
                    n11 = typedArray.getResourceId(n11, n12);
                    KeyTrigger.access$502(keyTrigger, n11);
                    continue block12;
                }
                case 8: {
                    n12 = keyTrigger.mFramePosition;
                    keyTrigger.mFramePosition = n11 = typedArray.getInteger(n11, n12);
                    float f10 = (float)n11 + 0.5f;
                    n12 = 1120403456;
                    float f11 = 100.0f;
                    KeyTrigger.access$002(keyTrigger, f10 /= f11);
                    continue block12;
                }
                case 7: {
                    int n13;
                    n12 = MotionLayout.IS_IN_EDIT_MODE ? 1 : 0;
                    if (n12 != 0) {
                        n12 = keyTrigger.mTargetId;
                        keyTrigger.mTargetId = n12 = typedArray.getResourceId(n11, n12);
                        n13 = -1;
                        if (n12 != n13) continue block12;
                        keyTrigger.mTargetString = string2 = typedArray.getString(n11);
                        continue block12;
                    }
                    object = typedArray.peekValue(n11);
                    n12 = ((TypedValue)object).type;
                    n13 = 3;
                    if (n12 == n13) {
                        keyTrigger.mTargetString = string2 = typedArray.getString(n11);
                        continue block12;
                    }
                    n12 = keyTrigger.mTargetId;
                    keyTrigger.mTargetId = n11 = typedArray.getResourceId(n11, n12);
                    continue block12;
                }
                case 6: {
                    n12 = KeyTrigger.access$400(keyTrigger);
                    n11 = typedArray.getResourceId(n11, n12);
                    KeyTrigger.access$402(keyTrigger, n11);
                    continue block12;
                }
                case 5: {
                    float f10;
                    float f11 = keyTrigger.mTriggerSlack;
                    keyTrigger.mTriggerSlack = f10 = typedArray.getFloat(n11, f11);
                    continue block12;
                }
                case 4: {
                    string2 = typedArray.getString(n11);
                    KeyTrigger.access$302(keyTrigger, string2);
                    continue block12;
                }
                case 2: {
                    string2 = typedArray.getString(n11);
                    KeyTrigger.access$202(keyTrigger, string2);
                    continue block12;
                }
                case 1: {
                    string2 = typedArray.getString(n11);
                    KeyTrigger.access$102(keyTrigger, string2);
                    continue block12;
                }
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("unused attribute 0x");
            String string3 = Integer.toHexString(n11);
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append("   ");
            string3 = mAttrMap;
            n11 = string3.get(n11);
            ((StringBuilder)object).append(n11);
            string2 = ((StringBuilder)object).toString();
            object = "KeyTrigger";
            Log.e((String)object, (String)string2);
        }
    }
}

