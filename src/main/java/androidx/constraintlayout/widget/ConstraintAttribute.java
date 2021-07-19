/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.ColorDrawable
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.util.Xml
 *  android.view.View
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintAttribute$1;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintAttribute {
    private static final String TAG = "TransitionLayout";
    public boolean mBooleanValue;
    private int mColorValue;
    private float mFloatValue;
    private int mIntegerValue;
    public String mName;
    private String mStringValue;
    private ConstraintAttribute$AttributeType mType;

    public ConstraintAttribute(ConstraintAttribute object, Object object2) {
        String string2;
        this.mName = string2 = object.mName;
        object = object.mType;
        this.mType = object;
        this.setValue(object2);
    }

    public ConstraintAttribute(String string2, ConstraintAttribute$AttributeType constraintAttribute$AttributeType) {
        this.mName = string2;
        this.mType = constraintAttribute$AttributeType;
    }

    public ConstraintAttribute(String string2, ConstraintAttribute$AttributeType constraintAttribute$AttributeType, Object object) {
        this.mName = string2;
        this.mType = constraintAttribute$AttributeType;
        this.setValue(object);
    }

    private static int clamp(int n10) {
        int n11 = ~(n10 >> 31);
        n10 = (n10 & n11) + -255;
        n11 = n10 >> 31;
        return (n10 & n11) + 255;
    }

    public static HashMap extractAttributes(HashMap hashMap, View view) {
        boolean bl2;
        HashMap<String, Object[]> hashMap2 = new HashMap<String, Object[]>();
        Class<?> clazz = view.getClass();
        Iterator iterator2 = hashMap.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object;
            Object object2;
            ConstraintAttribute constraintAttribute;
            String string2;
            block22: {
                string2 = (String)iterator2.next();
                constraintAttribute = (ConstraintAttribute)hashMap.get(string2);
                object2 = "BackgroundColor";
                int n10 = string2.equals(object2);
                if (n10 == 0) break block22;
                object2 = view.getBackground();
                object2 = (ColorDrawable)object2;
                n10 = object2.getColor();
                object2 = n10;
                object = new ConstraintAttribute(constraintAttribute, object2);
                hashMap2.put(string2, (Object[])object);
            }
            object2 = new StringBuilder();
            object = "getMap";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            object = null;
            Class[] classArray = new Class[]{};
            object2 = clazz.getMethod((String)object2, classArray);
            object = new Object[]{};
            object2 = ((Method)object2).invoke(view, object);
            object = new ConstraintAttribute(constraintAttribute, object2);
            try {
                hashMap2.put(string2, (Object[])object);
            }
            catch (InvocationTargetException invocationTargetException) {
                invocationTargetException.printStackTrace();
            }
            catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            catch (NoSuchMethodException noSuchMethodException) {
                noSuchMethodException.printStackTrace();
            }
        }
        return hashMap2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static void parse(Context object, XmlPullParser xmlPullParser, HashMap hashMap) {
        void var7_9;
        AttributeSet attributeSet;
        attributeSet = Xml.asAttributeSet((XmlPullParser)attributeSet);
        int[] nArray = R$styleable.CustomAttribute;
        attributeSet = object.obtainStyledAttributes(attributeSet, nArray);
        int n10 = attributeSet.getIndexCount();
        String string2 = null;
        boolean bl2 = false;
        Object var7_8 = null;
        int n11 = 0;
        Object var9_21 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < n10; ++i10) {
            void var7_12;
            void var9_25;
            StringBuilder stringBuilder;
            int n12 = attributeSet.getIndex(i10);
            int n13 = R$styleable.CustomAttribute_attributeName;
            int n14 = 1;
            if (n12 == n13) {
                string2 = attributeSet.getString(n12);
                if (string2 == null || (n12 = string2.length()) <= 0) continue;
                stringBuilder = new StringBuilder();
                n13 = Character.toUpperCase(string2.charAt(0));
                stringBuilder.append((char)n13);
                string2 = string2.substring(n14);
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                continue;
            }
            n13 = R$styleable.CustomAttribute_customBoolean;
            if (n12 == n13) {
                bl2 = attributeSet.getBoolean(n12, false);
                Boolean bl3 = bl2;
                ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.BOOLEAN_TYPE;
                continue;
            }
            n13 = R$styleable.CustomAttribute_customColorValue;
            if (n12 == n13) {
                ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_TYPE;
                n11 = attributeSet.getColor(n12, 0);
                Integer n15 = n11;
            } else {
                n13 = R$styleable.CustomAttribute_customColorDrawableValue;
                if (n12 == n13) {
                    ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.COLOR_DRAWABLE_TYPE;
                    n11 = attributeSet.getColor(n12, 0);
                    Integer n16 = n11;
                } else {
                    n13 = R$styleable.CustomAttribute_customPixelDimension;
                    if (n12 == n13) {
                        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
                        f10 = attributeSet.getDimension(n12, 0.0f);
                        stringBuilder = object.getResources().getDisplayMetrics();
                        f10 = TypedValue.applyDimension((int)n14, (float)f10, (DisplayMetrics)stringBuilder);
                        Float f11 = Float.valueOf(f10);
                    } else {
                        n13 = R$styleable.CustomAttribute_customDimension;
                        if (n12 == n13) {
                            ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.DIMENSION_TYPE;
                            f10 = attributeSet.getDimension(n12, 0.0f);
                            Float f12 = Float.valueOf(f10);
                        } else {
                            n13 = R$styleable.CustomAttribute_customFloatValue;
                            if (n12 == n13) {
                                ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.FLOAT_TYPE;
                                n11 = 2143289344;
                                f10 = attributeSet.getFloat(n12, 0.0f / 0.0f);
                                Float f13 = Float.valueOf(f10);
                            } else {
                                n13 = R$styleable.CustomAttribute_customIntegerValue;
                                if (n12 == n13) {
                                    ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.INT_TYPE;
                                    f10 = 0.0f / 0.0f;
                                    n11 = attributeSet.getInteger(n12, -1);
                                    Integer n17 = n11;
                                } else {
                                    n13 = R$styleable.CustomAttribute_customStringValue;
                                    if (n12 != n13) continue;
                                    ConstraintAttribute$AttributeType constraintAttribute$AttributeType = ConstraintAttribute$AttributeType.STRING_TYPE;
                                    String string3 = attributeSet.getString(n12);
                                }
                            }
                        }
                    }
                }
            }
            void var16_39 = var9_25;
            void var9_26 = var7_12;
            void var7_13 = var16_39;
        }
        if (string2 != null && var7_9 != null) {
            void var2_3;
            void var9_22;
            ConstraintAttribute constraintAttribute = new ConstraintAttribute(string2, (ConstraintAttribute$AttributeType)var9_22, var7_9);
            var2_3.put(string2, constraintAttribute);
        }
        attributeSet.recycle();
    }

    /*
     * Exception decompiling
     */
    public static void setAttributes(View var0, HashMap var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [60[CASE]], but top level block is 12[TRYBLOCK]
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

    public boolean diff(ConstraintAttribute constraintAttribute) {
        Object object;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType;
        boolean bl2 = false;
        if (constraintAttribute != null && (constraintAttribute$AttributeType = this.mType) == (object = constraintAttribute.mType)) {
            object = ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
            Object object2 = constraintAttribute$AttributeType.ordinal();
            object2 = (Object)object[object2];
            boolean bl3 = true;
            switch (object2) {
                default: {
                    return false;
                }
                case 7: {
                    float f10 = this.mFloatValue;
                    float f11 = constraintAttribute.mFloatValue;
                    float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                    if (f12 == false) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                case 6: {
                    object2 = this.mBooleanValue;
                    Object object3 = constraintAttribute.mBooleanValue;
                    if (object2 == object3) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                case 5: {
                    object2 = this.mIntegerValue;
                    int n10 = constraintAttribute.mIntegerValue;
                    if (object2 == n10) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                case 4: {
                    float f13 = this.mFloatValue;
                    float f14 = constraintAttribute.mFloatValue;
                    float f15 = f13 == f14 ? 0 : (f13 > f14 ? 1 : -1);
                    if (f15 == false) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                case 3: {
                    object2 = this.mIntegerValue;
                    int n11 = constraintAttribute.mIntegerValue;
                    if (object2 == n11) {
                        bl2 = bl3;
                    }
                    return bl2;
                }
                case 1: 
                case 2: 
            }
            object2 = this.mColorValue;
            int n12 = constraintAttribute.mColorValue;
            if (object2 == n12) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public ConstraintAttribute$AttributeType getType() {
        return this.mType;
    }

    public float getValueToInterpolate() {
        Object object = ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = this.mType;
        int n10 = constraintAttribute$AttributeType.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                return 0.0f / 0.0f;
            }
            case 7: {
                return this.mFloatValue;
            }
            case 6: {
                float f10;
                n11 = this.mBooleanValue ? 1 : 0;
                if (n11 != 0) {
                    n11 = 1065353216;
                    f10 = 1.0f;
                } else {
                    n11 = 0;
                    f10 = 0.0f;
                    object = null;
                }
                return f10;
            }
            case 5: {
                object = new RuntimeException;
                object("Cannot interpolate String");
                throw object;
            }
            case 4: {
                return this.mFloatValue;
            }
            case 3: {
                return this.mIntegerValue;
            }
            case 1: 
            case 2: 
        }
        object = new RuntimeException;
        object("Color does not have a single color to interpolate");
        throw object;
    }

    public void getValuesToInterpolate(float[] object) {
        int[] nArray = ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
        int n10 = this.mType.ordinal();
        int n11 = nArray[n10];
        n10 = 0;
        float f10 = 0.0f;
        switch (n11) {
            default: {
                break;
            }
            case 7: {
                float f11;
                object[0] = f11 = this.mFloatValue;
                break;
            }
            case 6: {
                float f12;
                n11 = this.mBooleanValue ? 1 : 0;
                if (n11 != 0) {
                    n11 = 1065353216;
                    f12 = 1.0f;
                } else {
                    n11 = 0;
                    f12 = 0.0f;
                    nArray = null;
                }
                object[0] = f12;
                break;
            }
            case 5: {
                object = new RuntimeException;
                object("Color does not have a single color to interpolate");
                throw object;
            }
            case 4: {
                float f13;
                object[0] = f13 = this.mFloatValue;
                break;
            }
            case 3: {
                float f14;
                n11 = this.mIntegerValue;
                object[0] = f14 = (float)n11;
                break;
            }
            case 1: 
            case 2: {
                n11 = this.mColorValue;
                int n12 = n11 >> 24 & 0xFF;
                int n13 = n11 >> 16 & 0xFF;
                int n14 = n11 >> 8 & 0xFF;
                float f15 = n13;
                float f16 = 255.0f;
                double d10 = f15 / f16;
                double d11 = 2.2;
                f15 = (float)Math.pow(d10, d11);
                float f17 = (float)Math.pow((float)n14 / f16, d11);
                d10 = Math.pow((float)(n11 &= 0xFF) / f16, d11);
                float f18 = (float)d10;
                object[0] = f15;
                object[1] = f17;
                n10 = 2;
                object[n10] = f18;
                n11 = 3;
                f18 = 4.2E-45f;
                object[n11] = f10 = (float)n12 / f16;
            }
        }
    }

    public int noOfInterpValues() {
        int n10;
        int[] nArray = ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = this.mType;
        int n11 = constraintAttribute$AttributeType.ordinal();
        int n12 = nArray[n11];
        if (n12 != (n11 = 1) && n12 != (n10 = 2)) {
            return n11;
        }
        return 4;
    }

    public void setColorValue(int n10) {
        this.mColorValue = n10;
    }

    public void setFloatValue(float f10) {
        this.mFloatValue = f10;
    }

    public void setIntValue(int n10) {
        this.mIntegerValue = n10;
    }

    /*
     * Exception decompiling
     */
    public void setInterpolatedValue(View var1_1, float[] var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [82[CASE]], but top level block is 12[TRYBLOCK]
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

    public void setStringValue(String string2) {
        this.mStringValue = string2;
    }

    public void setValue(Object object) {
        int[] nArray = ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
        ConstraintAttribute$AttributeType constraintAttribute$AttributeType = this.mType;
        int n10 = constraintAttribute$AttributeType.ordinal();
        int n11 = nArray[n10];
        switch (n11) {
            default: {
                break;
            }
            case 7: {
                float f10;
                object = (Float)object;
                this.mFloatValue = f10 = ((Float)object).floatValue();
                break;
            }
            case 6: {
                boolean bl2;
                object = (Boolean)object;
                this.mBooleanValue = bl2 = ((Boolean)object).booleanValue();
                break;
            }
            case 5: {
                this.mStringValue = object = (String)object;
                break;
            }
            case 4: {
                float f11;
                object = (Float)object;
                this.mFloatValue = f11 = ((Float)object).floatValue();
                break;
            }
            case 3: {
                int n12;
                object = (Integer)object;
                this.mIntegerValue = n12 = ((Integer)object).intValue();
                break;
            }
            case 1: 
            case 2: {
                int n13;
                object = (Integer)object;
                this.mColorValue = n13 = ((Integer)object).intValue();
            }
        }
    }

    public void setValue(float[] object) {
        int[] nArray = ConstraintAttribute$1.$SwitchMap$androidx$constraintlayout$widget$ConstraintAttribute$AttributeType;
        int n10 = this.mType.ordinal();
        int n11 = nArray[n10];
        n10 = 0;
        float f10 = 0.0f;
        switch (n11) {
            default: {
                break;
            }
            case 7: {
                float f11;
                this.mFloatValue = f11 = object[0];
                break;
            }
            case 6: {
                float f12 = object[0];
                double d10 = f12;
                double d11 = 0.5;
                double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
                if (d12 > 0) {
                    n10 = 1;
                    f10 = Float.MIN_VALUE;
                }
                this.mBooleanValue = n10;
                break;
            }
            case 5: {
                object = new RuntimeException;
                object("Color does not have a single color to interpolate");
                throw object;
            }
            case 4: {
                float f13;
                this.mFloatValue = f13 = object[0];
                break;
            }
            case 3: {
                int n12;
                float f14 = object[0];
                this.mIntegerValue = n12 = (int)f14;
                break;
            }
            case 1: 
            case 2: {
                int n13;
                this.mColorValue = n11 = Color.HSVToColor((float[])object);
                n10 = 1132396544;
                f10 = 255.0f;
                int n14 = 3;
                float f15 = object[n14] * f10;
                this.mColorValue = n13 = ConstraintAttribute.clamp((int)f15) << 24 | (n11 &= 0xFFFFFF);
            }
        }
    }
}

