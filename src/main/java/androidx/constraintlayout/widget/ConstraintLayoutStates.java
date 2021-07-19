/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.util.Log
 *  android.util.SparseArray
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.SparseArray;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintLayoutStates$State;
import androidx.constraintlayout.widget.ConstraintLayoutStates$Variant;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.ConstraintsChangedListener;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    private final ConstraintLayout mConstraintLayout;
    private SparseArray mConstraintSetMap;
    private ConstraintsChangedListener mConstraintsChangedListener;
    public int mCurrentConstraintNumber;
    public int mCurrentStateId;
    public ConstraintSet mDefaultConstraintSet;
    private SparseArray mStateList;

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int n10) {
        SparseArray sparseArray;
        int n11;
        this.mCurrentStateId = n11 = -1;
        this.mCurrentConstraintNumber = n11;
        this.mStateList = sparseArray = new SparseArray();
        this.mConstraintSetMap = sparseArray = new SparseArray();
        this.mConstraintsChangedListener = null;
        this.mConstraintLayout = constraintLayout;
        this.load(context, n10);
    }

    /*
     * Unable to fully structure code
     */
    private void load(Context var1_1, int var2_4) {
        var3_5 = var1_1.getResources().getXml(var2_4);
        var4_6 = null;
        var5_7 = var3_5.getEventType();
        while (var5_7 != (var6_8 = 1)) {
            block29: {
                block30: {
                    block31: {
                        if (var5_7 == 0) ** GOTO lbl93
                        var7_9 = 2;
                        if (var5_7 != var7_9) ** GOTO lbl95
                        var8_10 = var3_5.getName();
                        var9_11 = -1;
                        var10_12 = var8_10.hashCode();
                        var11_13 = 4;
                        var12_14 = 3;
                        switch (var10_12) {
                            default: {
                                break;
                            }
                            case 1901439077: {
                                var13_15 = "Variant";
                                var10_12 = (int)var8_10.equals(var13_15);
                                if (var10_12 == 0) break;
                                var9_11 = var12_14;
                                break;
                            }
                            case 1657696882: {
                                var13_15 = "layoutDescription";
                                var10_12 = (int)var8_10.equals(var13_15);
                                if (var10_12 == 0) break;
                                var9_11 = 0;
                                var14_16 = null;
                                break;
                            }
                            case 1382829617: {
                                var13_15 = "StateSet";
                                var10_12 = (int)var8_10.equals(var13_15);
                                if (var10_12 == 0) break;
                                var9_11 = var6_8;
                                break;
                            }
                            case 80204913: {
                                var13_15 = "State";
                                var10_12 = (int)var8_10.equals(var13_15);
                                if (var10_12 == 0) break;
                                var9_11 = var7_9;
                                break;
                            }
                            case -1349929691: {
                                var13_15 = "ConstraintSet";
                                var10_12 = (int)var8_10.equals(var13_15);
                                if (var10_12 == 0) break;
                                var9_11 = var11_13;
                            }
                        }
                        if (var9_11 == 0 || var9_11 == var6_8) ** GOTO lbl95
                        if (var9_11 == var7_9) break block29;
                        if (var9_11 == var12_14) break block30;
                        if (var9_11 == var11_13) break block31;
                        var15_17 = "ConstraintLayoutStates";
                        var16_18 = new StringBuilder();
                        var14_16 = "unknown tag ";
                        var16_18.append(var14_16);
                        var16_18.append((String)var8_10);
                        var8_10 = var16_18.toString();
                        Log.v((String)var15_17, (String)var8_10);
                        ** GOTO lbl95
                    }
                    this.parseConstraintSet(var1_1, (XmlPullParser)var3_5);
                    ** GOTO lbl95
                }
                var8_10 = new ConstraintLayoutStates$Variant(var1_1, (XmlPullParser)var3_5);
                if (var4_6 == null) ** GOTO lbl95
                var4_6.add((ConstraintLayoutStates$Variant)var8_10);
                ** GOTO lbl95
            }
            var4_6 = new ConstraintLayoutStates$State(var1_1, (XmlPullParser)var3_5);
            var8_10 = this.mStateList;
            var6_8 = var4_6.mId;
            try {
                block32: {
                    var8_10.put(var6_8, (Object)var4_6);
                    break block32;
lbl93:
                    // 1 sources

                    var3_5.getName();
                }
                var5_7 = var3_5.next();
            }
            catch (IOException var1_2) {
                var1_2.printStackTrace();
                break;
            }
            catch (XmlPullParserException var1_3) {
                var1_3.printStackTrace();
                break;
            }
        }
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        ConstraintSet constraintSet = new ConstraintSet();
        int n10 = xmlPullParser.getAttributeCount();
        String string2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = "id";
            String string4 = xmlPullParser.getAttributeName(i10);
            int n11 = string3.equals(string4);
            if (n11 == 0) continue;
            String string5 = xmlPullParser.getAttributeValue(i10);
            string2 = "/";
            i10 = string5.contains(string2) ? 1 : 0;
            n11 = -1;
            int n12 = 1;
            if (i10 != 0) {
                i10 = string5.indexOf(47) + n12;
                string2 = string5.substring(i10);
                Resources resources = context.getResources();
                String string6 = context.getPackageName();
                i10 = resources.getIdentifier(string2, string3, string6);
            } else {
                i10 = n11;
            }
            if (i10 == n11) {
                if (string5 != null && (n11 = string5.length()) > n12) {
                    string5 = string5.substring(n12);
                    i10 = Integer.parseInt(string5);
                } else {
                    string5 = TAG;
                    string4 = "error in parsing id";
                    Log.e((String)string5, (String)string4);
                }
            }
            constraintSet.load(context, xmlPullParser);
            context = this.mConstraintSetMap;
            context.put(i10, (Object)constraintSet);
            break;
        }
    }

    public boolean needsToChange(int n10, float f10, float f11) {
        ArrayList arrayList;
        ConstraintLayoutStates$Variant constraintLayoutStates$Variant;
        int n11 = this.mCurrentStateId;
        boolean bl2 = true;
        if (n11 != n10) {
            return bl2;
        }
        int n12 = -1;
        Object object = n10 == n12 ? this.mStateList.valueAt(0) : this.mStateList.get(n11);
        object = (ConstraintLayoutStates$State)object;
        n11 = this.mCurrentConstraintNumber;
        if (n11 != n12 && (n11 = (int)((constraintLayoutStates$Variant = (ConstraintLayoutStates$Variant)(arrayList = ((ConstraintLayoutStates$State)object).mVariants).get(n11)).match(f10, f11) ? 1 : 0)) != 0) {
            return false;
        }
        n11 = this.mCurrentConstraintNumber;
        n10 = ((ConstraintLayoutStates$State)object).findMatch(f10, f11);
        if (n11 == n10) {
            return false;
        }
        return bl2;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public void updateConstraints(int n10, float f10, float f11) {
        int n11 = this.mCurrentStateId;
        int n12 = -1;
        if (n11 == n10) {
            ArrayList arrayList;
            ConstraintLayoutStates$Variant constraintLayoutStates$Variant;
            Object object;
            if (n10 == n12) {
                object = this.mStateList;
                n11 = 0;
                constraintLayoutStates$Variant = null;
                object = (ConstraintLayoutStates$State)object.valueAt(0);
            } else {
                object = (ConstraintLayoutStates$State)this.mStateList.get(n11);
            }
            n11 = this.mCurrentConstraintNumber;
            if (n11 != n12 && (n11 = (int)((constraintLayoutStates$Variant = (ConstraintLayoutStates$Variant)(arrayList = ((ConstraintLayoutStates$State)object).mVariants).get(n11)).match(f10, f11) ? 1 : 0)) != 0) {
                return;
            }
            int n13 = this.mCurrentConstraintNumber;
            int n14 = ((ConstraintLayoutStates$State)object).findMatch(f10, f11);
            if (n13 == n14) {
                return;
            }
            ConstraintSet constraintSet = n14 == n12 ? this.mDefaultConstraintSet : ((ConstraintLayoutStates$Variant)object.mVariants.get((int)n14)).mConstraintSet;
            if (n14 == n12) {
                n10 = ((ConstraintLayoutStates$State)object).mConstraintID;
            } else {
                object = (ConstraintLayoutStates$Variant)((ConstraintLayoutStates$State)object).mVariants.get(n14);
                n10 = ((ConstraintLayoutStates$Variant)object).mConstraintID;
            }
            if (constraintSet == null) {
                return;
            }
            this.mCurrentConstraintNumber = n14;
            Object object2 = this.mConstraintsChangedListener;
            if (object2 != null) {
                ((ConstraintsChangedListener)object2).preLayoutChange(n12, n10);
            }
            object2 = this.mConstraintLayout;
            constraintSet.applyTo((ConstraintLayout)((Object)object2));
            object2 = this.mConstraintsChangedListener;
            if (object2 != null) {
                ((ConstraintsChangedListener)object2).postLayoutChange(n12, n10);
            }
        } else {
            this.mCurrentStateId = n10;
            Object object = (ConstraintLayoutStates$State)this.mStateList.get(n10);
            int n15 = ((ConstraintLayoutStates$State)object).findMatch(f10, f11);
            ConstraintSet constraintSet = n15 == n12 ? ((ConstraintLayoutStates$State)object).mConstraintSet : ((ConstraintLayoutStates$Variant)object.mVariants.get((int)n15)).mConstraintSet;
            if (n15 == n12) {
                n11 = ((ConstraintLayoutStates$State)object).mConstraintID;
            } else {
                object = (ConstraintLayoutStates$Variant)((ConstraintLayoutStates$State)object).mVariants.get(n15);
                n11 = ((ConstraintLayoutStates$Variant)object).mConstraintID;
            }
            if (constraintSet == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("NO Constraint set found ! id=");
                ((StringBuilder)object).append(n10);
                ((StringBuilder)object).append(", dim =");
                ((StringBuilder)object).append(f10);
                ((StringBuilder)object).append(", ");
                ((StringBuilder)object).append(f11);
                String string2 = ((StringBuilder)object).toString();
                Log.v((String)TAG, (String)string2);
                return;
            }
            this.mCurrentConstraintNumber = n15;
            Object object3 = this.mConstraintsChangedListener;
            if (object3 != null) {
                ((ConstraintsChangedListener)object3).preLayoutChange(n10, n11);
            }
            object3 = this.mConstraintLayout;
            constraintSet.applyTo((ConstraintLayout)((Object)object3));
            object3 = this.mConstraintsChangedListener;
            if (object3 != null) {
                ((ConstraintsChangedListener)object3).postLayoutChange(n10, n11);
            }
        }
    }
}

