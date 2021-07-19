/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.Keyframe
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.graphics.Path
 *  android.graphics.PathMeasure
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.TypedValue
 *  android.util.Xml
 *  android.view.InflateException
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.InflateException;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.vectordrawable.graphics.drawable.AndroidResources;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatorInflaterCompat$PathDataEvaluator;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

public class AnimatorInflaterCompat {
    private static final boolean DBG_ANIMATOR_INFLATER = false;
    private static final int MAX_NUM_POINTS = 100;
    private static final String TAG = "AnimatorInflater";
    private static final int TOGETHER = 0;
    private static final int VALUE_TYPE_COLOR = 3;
    private static final int VALUE_TYPE_FLOAT = 0;
    private static final int VALUE_TYPE_INT = 1;
    private static final int VALUE_TYPE_PATH = 2;
    private static final int VALUE_TYPE_UNDEFINED = 4;

    private AnimatorInflaterCompat() {
    }

    private static Animator createAnimatorFromXml(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, float f10) {
        AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
        return AnimatorInflaterCompat.createAnimatorFromXml(context, resources, theme, xmlPullParser, attributeSet, null, 0, f10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static Animator createAnimatorFromXml(Context var0, Resources var1_1, Resources.Theme var2_2, XmlPullParser var3_3, AttributeSet var4_4, AnimatorSet var5_5, int var6_6, float var7_7) {
        block13: {
            var8_8 = var1_1;
            var9_9 = var2_2;
            var10_10 = var3_3;
            var11_11 = var5_5;
            var12_12 = var3_3.getDepth();
            var13_13 /* !! */  = null;
            var14_14 = null;
            while (true) {
                var15_15 = var3_3.next();
                var16_16 = 3;
                var17_17 = 0;
                if (var15_15 == var16_16 && (var16_16 = var3_3.getDepth()) <= var12_12 || var15_15 == (var16_16 = 1)) break block13;
                var18_18 = 2;
                if (var15_15 != var18_18) continue;
                var19_19 = var3_3.getName();
                var18_18 = (int)var19_19.equals(var20_20 = "objectAnimator");
                if (var18_18 != 0) {
                    var13_13 /* !! */  = var0;
                    var19_19 = var1_1;
                    var21_21 /* !! */  = var2_2;
                    var20_20 = var4_4;
                    var13_13 /* !! */  = AnimatorInflaterCompat.loadObjectAnimator(var0, var1_1, var2_2, var4_4, var7_7, var3_3);
lbl23:
                    // 2 sources

                    while (true) {
                        var20_20 = var0;
                        break;
                    }
                } else {
                    var20_20 = "animator";
                    var18_18 = (int)var19_19.equals(var20_20);
                    if (var18_18 != 0) {
                        var22_22 = 0;
                        var23_23 = null;
                        var13_13 /* !! */  = var0;
                        var19_19 = var1_1;
                        var21_21 /* !! */  = var2_2;
                        var20_20 = var4_4;
                        var24_24 = var3_3;
                        var13_13 /* !! */  = AnimatorInflaterCompat.loadAnimator(var0, var1_1, var2_2, var4_4, null, var7_7, var3_3);
                        ** continue;
                    }
                    var20_20 = "set";
                    var18_18 = (int)var19_19.equals(var20_20);
                    if (var18_18 != 0) {
                        var25_25 = new AnimatorSet();
                        var13_13 /* !! */  = (Context)AndroidResources.STYLEABLE_ANIMATOR_SET;
                        var24_24 = TypedArrayUtils.obtainAttributes(var8_8, var9_9, var4_4, (int[])var13_13 /* !! */ );
                        var26_26 = TypedArrayUtils.getNamedInt((TypedArray)var24_24, var10_10, "ordering", 0, 0);
                        var13_13 /* !! */  = var0;
                        var19_19 = var1_1;
                        var21_21 /* !! */  = var2_2;
                        var20_20 = var3_3;
                        var23_23 = var4_4;
                        AnimatorInflaterCompat.createAnimatorFromXml(var0, var1_1, var2_2, var3_3, var4_4, var25_25, var26_26, var7_7);
                        var24_24.recycle();
                        var20_20 = var0;
                        var13_13 /* !! */  = var25_25;
                    } else {
                        var20_20 = "propertyValuesHolder";
                        var15_15 = (int)var19_19.equals(var20_20);
                        if (var15_15 == 0) break;
                        var19_19 = Xml.asAttributeSet((XmlPullParser)var3_3);
                        var20_20 = var0;
                        if ((var19_19 = AnimatorInflaterCompat.loadValues(var0, var8_8, var9_9, var10_10, (AttributeSet)var19_19)) != null && (var22_22 = var13_13 /* !! */  instanceof ValueAnimator) != 0) {
                            var23_23 = var13_13 /* !! */ ;
                            var23_23 = (ValueAnimator)var13_13 /* !! */ ;
                            var23_23.setValues((PropertyValuesHolder[])var19_19);
                        }
                        var17_17 = var16_16;
                    }
                }
                if (var11_11 == null || var17_17 != 0) continue;
                if (var14_14 == null) {
                    var14_14 = new ArrayList<Context>();
                }
                var14_14.add(var13_13 /* !! */ );
            }
            var19_19 = new StringBuilder();
            var19_19.append("Unknown animator name: ");
            var21_21 /* !! */  = var3_3.getName();
            var19_19.append((String)var21_21 /* !! */ );
            var19_19 = var19_19.toString();
            var13_13 /* !! */  = new RuntimeException((String)var19_19);
            throw var13_13 /* !! */ ;
        }
        if (var11_11 != null && var14_14 != null) {
            var15_15 = var14_14.size();
            var19_19 = new Animator[var15_15];
            var21_21 /* !! */  = var14_14.iterator();
            while ((var18_18 = (int)var21_21 /* !! */ .hasNext()) != 0) {
                var20_20 = (Animator)var21_21 /* !! */ .next();
                var22_22 = var17_17 + 1;
                var19_19[var17_17] = var20_20;
                var17_17 = var22_22;
            }
            if (var6_6 == 0) {
                var11_11.playTogether((Animator[])var19_19);
            } else {
                var11_11.playSequentially((Animator[])var19_19);
            }
        }
        return (Animator)var13_13 /* !! */ ;
    }

    private static Keyframe createNewKeyframe(Keyframe object, float f10) {
        Class<Float> clazz;
        Class<Integer> clazz2 = object.getType();
        object = clazz2 == (clazz = Float.TYPE) ? Keyframe.ofFloat((float)f10) : ((object = object.getType()) == (clazz2 = Integer.TYPE) ? Keyframe.ofInt((float)f10) : Keyframe.ofObject((float)f10));
        return object;
    }

    private static void distributeKeyframes(Keyframe[] keyframeArray, float f10, int n10, int n11) {
        int n12 = n11 - n10 + 2;
        float f11 = n12;
        f10 /= f11;
        while (n10 <= n11) {
            Keyframe keyframe = keyframeArray[n10];
            int n13 = n10 + -1;
            Keyframe keyframe2 = keyframeArray[n13];
            float f12 = keyframe2.getFraction() + f10;
            keyframe.setFraction(f12);
            ++n10;
        }
    }

    private static void dumpKeyframes(Object[] objectArray, String string2) {
        int n10;
        if (objectArray != null && (n10 = objectArray.length) != 0) {
            String string3 = TAG;
            Log.d((String)string3, (String)string2);
            int n11 = objectArray.length;
            for (int i10 = 0; i10 < n11; ++i10) {
                Object object = (Keyframe)objectArray[i10];
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Keyframe ");
                stringBuilder.append(i10);
                Object object2 = ": fraction ";
                stringBuilder.append((String)object2);
                float f10 = object.getFraction();
                float f11 = f10 - 0.0f;
                float f12 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
                Object object3 = "null";
                if (f12 < 0) {
                    object2 = object3;
                } else {
                    f10 = object.getFraction();
                    object2 = Float.valueOf(f10);
                }
                stringBuilder.append(object2);
                object2 = ", , value : ";
                stringBuilder.append((String)object2);
                f12 = (float)object.hasValue();
                if (f12 != false) {
                    object3 = object.getValue();
                }
                stringBuilder.append(object3);
                object = stringBuilder.toString();
                Log.d((String)string3, (String)object);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static PropertyValuesHolder getPVH(TypedArray object, int n10, int n11, int n12, String string2) {
        void var4_18;
        Object[] objectArray;
        int n13;
        int n14;
        void var3_17;
        int n15;
        int n16;
        TypedValue typedValue = object.peekValue(n16);
        int n17 = 1;
        int n18 = typedValue != null ? n17 : 0;
        if (n18 != 0) {
            n15 = typedValue.type;
        } else {
            n15 = 0;
            Object var5_20 = null;
        }
        TypedValue typedValue2 = object.peekValue((int)var3_17);
        int n19 = typedValue2 != null ? n17 : 0;
        if (n19 != 0) {
            n14 = typedValue2.type;
        } else {
            n14 = 0;
            typedValue2 = null;
        }
        int n20 = 4;
        int n21 = 3;
        if (n13 == n20) {
            if (n18 != 0 && (n13 = AnimatorInflaterCompat.isColorType(n15)) != 0 || n19 != 0 && (n13 = AnimatorInflaterCompat.isColorType(n14)) != 0) {
                n13 = n21;
            } else {
                n13 = 0;
                objectArray = null;
            }
        }
        n20 = n13 == 0 ? n17 : 0;
        PropertyValuesHolder propertyValuesHolder = null;
        int n22 = 2;
        if (n13 == n22) {
            void var0_7;
            objectArray = object.getString(n16);
            String string3 = object.getString((int)var3_17);
            InflateException inflateException = PathParser.createNodesFromPathData((String)objectArray);
            Object object2 = PathParser.createNodesFromPathData(string3);
            if (inflateException == null) {
                if (object2 == null) return propertyValuesHolder;
            }
            if (inflateException == null) {
                if (object2 == null) return propertyValuesHolder;
                AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator();
                objectArray = new Object[n17];
                objectArray[0] = object2;
                return PropertyValuesHolder.ofObject((String)var4_18, (TypeEvaluator)animatorInflaterCompat$PathDataEvaluator, (Object[])objectArray);
            }
            AnimatorInflaterCompat$PathDataEvaluator animatorInflaterCompat$PathDataEvaluator = new AnimatorInflaterCompat$PathDataEvaluator();
            if (object2 != null) {
                n18 = (int)(PathParser.canMorph((PathParser$PathDataNode[])inflateException, (PathParser$PathDataNode[])object2) ? 1 : 0);
                if (n18 == 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(" Can't morph from ");
                    ((StringBuilder)object2).append((String)objectArray);
                    ((StringBuilder)object2).append(" to ");
                    ((StringBuilder)object2).append(string3);
                    String string4 = ((StringBuilder)object2).toString();
                    inflateException = new InflateException(string4);
                    throw inflateException;
                }
                Object[] objectArray2 = new Object[n22];
                objectArray2[0] = inflateException;
                objectArray2[n17] = object2;
                PropertyValuesHolder propertyValuesHolder2 = PropertyValuesHolder.ofObject((String)var4_18, (TypeEvaluator)animatorInflaterCompat$PathDataEvaluator, (Object[])objectArray2);
                return var0_7;
            } else {
                Object[] objectArray3 = new Object[n17];
                objectArray3[0] = inflateException;
                PropertyValuesHolder propertyValuesHolder3 = PropertyValuesHolder.ofObject((String)var4_18, (TypeEvaluator)animatorInflaterCompat$PathDataEvaluator, (Object[])objectArray3);
            }
            return var0_7;
        }
        if (n13 == n21) {
            objectArray = ArgbEvaluator.getInstance();
        } else {
            n13 = 0;
            objectArray = null;
        }
        n21 = 5;
        if (n20 != 0) {
            void var0_13;
            if (n18 != 0) {
                float f10 = n15 == n21 ? object.getDimension(n16, 0.0f) : object.getFloat(n16, 0.0f);
                if (n19 != 0) {
                    float f11 = n14 == n21 ? object.getDimension((int)var3_17, 0.0f) : object.getFloat((int)var3_17, 0.0f);
                    float[] fArray = new float[n22];
                    fArray[0] = f10;
                    fArray[n17] = f11;
                    PropertyValuesHolder propertyValuesHolder4 = PropertyValuesHolder.ofFloat((String)var4_18, (float[])fArray);
                } else {
                    float[] fArray = new float[n17];
                    fArray[0] = f10;
                    PropertyValuesHolder propertyValuesHolder5 = PropertyValuesHolder.ofFloat((String)var4_18, (float[])fArray);
                }
            } else {
                float f12 = n14 == n21 ? object.getDimension((int)var3_17, 0.0f) : object.getFloat((int)var3_17, 0.0f);
                float[] fArray = new float[n17];
                fArray[0] = f12;
                PropertyValuesHolder propertyValuesHolder6 = PropertyValuesHolder.ofFloat((String)var4_18, (float[])fArray);
            }
            propertyValuesHolder = var0_13;
        } else if (n18 != 0) {
            if (n15 == n21) {
                float f13 = object.getDimension(n16, 0.0f);
                n16 = (int)f13;
            } else {
                n16 = (n15 = (int)(AnimatorInflaterCompat.isColorType(n15) ? 1 : 0)) != 0 ? object.getColor(n16, 0) : object.getInt(n16, 0);
            }
            if (n19 != 0) {
                int n23;
                if (n14 == n21) {
                    float f14 = object.getDimension((int)var3_17, 0.0f);
                    n23 = (int)f14;
                } else {
                    n15 = (int)(AnimatorInflaterCompat.isColorType(n14) ? 1 : 0);
                    n23 = n15 != 0 ? object.getColor((int)var3_17, 0) : object.getInt((int)var3_17, 0);
                }
                int[] nArray = new int[n22];
                nArray[0] = n16;
                nArray[n17] = n23;
                propertyValuesHolder = PropertyValuesHolder.ofInt((String)var4_18, (int[])nArray);
            } else {
                int[] nArray = new int[n17];
                nArray[0] = n16;
                propertyValuesHolder = PropertyValuesHolder.ofInt((String)var4_18, (int[])nArray);
            }
        } else if (n19 != 0) {
            int n24;
            if (n14 == n21) {
                float f15 = object.getDimension((int)var3_17, 0.0f);
                n24 = (int)f15;
            } else {
                n16 = AnimatorInflaterCompat.isColorType(n14);
                n24 = n16 != 0 ? object.getColor((int)var3_17, 0) : object.getInt((int)var3_17, 0);
            }
            int[] nArray = new int[n17];
            nArray[0] = n24;
            propertyValuesHolder = PropertyValuesHolder.ofInt((String)var4_18, (int[])nArray);
        }
        if (propertyValuesHolder == null) return propertyValuesHolder;
        if (objectArray == null) return propertyValuesHolder;
        propertyValuesHolder.setEvaluator((TypeEvaluator)objectArray);
        return propertyValuesHolder;
    }

    private static int inferValueTypeFromValues(TypedArray typedArray, int n10, int n11) {
        int n12;
        TypedValue typedValue = typedArray.peekValue(n10);
        boolean bl2 = true;
        int n13 = 0;
        boolean bl3 = typedValue != null ? bl2 : false;
        if (bl3) {
            n10 = typedValue.type;
        } else {
            n10 = 0;
            typedValue = null;
        }
        typedArray = typedArray.peekValue(n11);
        if (typedArray == null) {
            bl2 = false;
        }
        if (bl2) {
            n12 = typedArray.type;
        } else {
            n12 = 0;
            typedArray = null;
        }
        if (bl3 && (n10 = (int)(AnimatorInflaterCompat.isColorType(n10) ? 1 : 0)) != 0 || bl2 && (n12 = (int)(AnimatorInflaterCompat.isColorType(n12) ? 1 : 0)) != 0) {
            n13 = 3;
        }
        return n13;
    }

    private static int inferValueTypeOfKeyframe(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        boolean bl2;
        boolean bl3;
        int[] nArray = AndroidResources.STYLEABLE_KEYFRAME;
        resources = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, nArray);
        int n10 = 0;
        attributeSet = null;
        theme = TypedArrayUtils.peekNamedValue((TypedArray)resources, xmlPullParser, "value", 0);
        if (theme != null) {
            bl3 = true;
        } else {
            bl3 = false;
            xmlPullParser = null;
        }
        if (bl3 && (bl2 = AnimatorInflaterCompat.isColorType(theme.type))) {
            n10 = 3;
        }
        resources.recycle();
        return n10;
    }

    private static boolean isColorType(int n10) {
        int n11 = 28;
        n10 = n10 >= n11 && n10 <= (n11 = 31) ? 1 : 0;
        return n10 != 0;
    }

    public static Animator loadAnimator(Context context, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 24;
        if (n11 >= n12) {
            context = AnimatorInflater.loadAnimator((Context)context, (int)n10);
        } else {
            Resources resources = context.getResources();
            Resources.Theme theme = context.getTheme();
            context = AnimatorInflaterCompat.loadAnimator(context, resources, theme, n10);
        }
        return context;
    }

    public static Animator loadAnimator(Context context, Resources resources, Resources.Theme theme, int n10) {
        return AnimatorInflaterCompat.loadAnimator(context, resources, theme, n10, 1.0f);
    }

    /*
     * Exception decompiling
     */
    public static Animator loadAnimator(Context var0, Resources var1_4, Resources.Theme var2_5, int var3_6, float var4_7) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [6 : 45->48)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
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

    private static ValueAnimator loadAnimator(Context context, Resources resources, Resources.Theme object, AttributeSet attributeSet, ValueAnimator valueAnimator, float f10, XmlPullParser xmlPullParser) {
        Object object2 = AndroidResources.STYLEABLE_ANIMATOR;
        object2 = TypedArrayUtils.obtainAttributes(resources, object, attributeSet, object2);
        int[] nArray = AndroidResources.STYLEABLE_PROPERTY_ANIMATOR;
        resources = TypedArrayUtils.obtainAttributes(resources, object, attributeSet, nArray);
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
        }
        AnimatorInflaterCompat.parseAnimatorFromTypeArray(valueAnimator, (TypedArray)object2, (TypedArray)resources, f10, xmlPullParser);
        object = "interpolator";
        attributeSet = null;
        int n10 = TypedArrayUtils.getNamedResourceId((TypedArray)object2, xmlPullParser, (String)object, 0, 0);
        if (n10 > 0) {
            context = AnimationUtilsCompat.loadInterpolator(context, n10);
            valueAnimator.setInterpolator((TimeInterpolator)context);
        }
        object2.recycle();
        if (resources != null) {
            resources.recycle();
        }
        return valueAnimator;
    }

    private static Keyframe loadKeyframe(Context context, Resources resources, Resources.Theme object, AttributeSet object2, int n10, XmlPullParser xmlPullParser) {
        Object object3 = AndroidResources.STYLEABLE_KEYFRAME;
        resources = TypedArrayUtils.obtainAttributes(resources, object, object2, object3);
        object = "fraction";
        int n11 = 3;
        float f10 = 4.2E-45f;
        float f11 = -1.0f;
        float f12 = TypedArrayUtils.getNamedFloat((TypedArray)resources, xmlPullParser, (String)object, n11, f11);
        object3 = "value";
        TypedValue typedValue = TypedArrayUtils.peekNamedValue((TypedArray)resources, xmlPullParser, (String)object3, 0);
        int n12 = 1;
        int n13 = typedValue != null ? n12 : 0;
        int n14 = 4;
        if (n10 == n14) {
            n10 = n13 != 0 && (n10 = (int)(AnimatorInflaterCompat.isColorType(typedValue.type) ? 1 : 0)) != 0 ? n11 : 0;
        }
        if (n13 != 0) {
            if (n10 != 0) {
                if (n10 != n12 && n10 != n11) {
                    f12 = 0.0f;
                    object = null;
                } else {
                    n11 = TypedArrayUtils.getNamedInt((TypedArray)resources, xmlPullParser, (String)object3, 0, 0);
                    object = Keyframe.ofInt((float)f12, (int)n11);
                }
            } else {
                n11 = 0;
                object2 = null;
                f10 = TypedArrayUtils.getNamedFloat((TypedArray)resources, xmlPullParser, (String)object3, 0, 0.0f);
                object = Keyframe.ofFloat((float)f12, (float)f10);
            }
        } else {
            object = n10 == 0 ? Keyframe.ofFloat((float)f12) : Keyframe.ofInt((float)f12);
        }
        object2 = "interpolator";
        n11 = TypedArrayUtils.getNamedResourceId((TypedArray)resources, xmlPullParser, (String)object2, n12, 0);
        if (n11 > 0) {
            context = AnimationUtilsCompat.loadInterpolator(context, n11);
            object.setInterpolator((TimeInterpolator)context);
        }
        resources.recycle();
        return object;
    }

    private static ObjectAnimator loadObjectAnimator(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, float f10, XmlPullParser xmlPullParser) {
        ObjectAnimator objectAnimator = new ObjectAnimator();
        AnimatorInflaterCompat.loadAnimator(context, resources, theme, attributeSet, (ValueAnimator)objectAnimator, f10, xmlPullParser);
        return objectAnimator;
    }

    private static PropertyValuesHolder loadPvh(Context object, Resources resources, Resources.Theme keyframe, XmlPullParser xmlPullParser, String string2, int n10) {
        int n11;
        Keyframe keyframe2;
        AttributeSet attributeSet;
        float f10;
        float f11;
        int n12;
        int n13;
        int n14;
        Object object2 = 0;
        float f12 = 0.0f;
        PropertyValuesHolder propertyValuesHolder = null;
        int n15 = 0;
        ArrayList<String> arrayList = null;
        while ((n14 = xmlPullParser.next()) != (n13 = 3)) {
            String string3;
            n12 = 1;
            f11 = Float.MIN_VALUE;
            if (n14 == n12) break;
            String string4 = xmlPullParser.getName();
            n14 = (int)(string4.equals(string3 = "keyframe") ? 1 : 0);
            if (n14 == 0) continue;
            n14 = 4;
            f10 = 5.6E-45f;
            if (n10 == n14) {
                AttributeSet attributeSet2 = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
                n10 = AnimatorInflaterCompat.inferValueTypeOfKeyframe(resources, (Resources.Theme)keyframe, attributeSet2, xmlPullParser);
            }
            attributeSet = Xml.asAttributeSet((XmlPullParser)xmlPullParser);
            string4 = object;
            string3 = resources;
            keyframe2 = keyframe;
            string4 = AnimatorInflaterCompat.loadKeyframe(object, resources, (Resources.Theme)keyframe, attributeSet, n10, xmlPullParser);
            if (string4 != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList<String>();
                }
                arrayList.add(string4);
            }
            xmlPullParser.next();
        }
        if (arrayList != null && (n11 = arrayList.size()) > 0) {
            float f13;
            float f14;
            int n16 = 0;
            resources = null;
            keyframe = (Keyframe)arrayList.get(0);
            int n17 = n11 + -1;
            xmlPullParser = (Keyframe)arrayList.get(n17);
            f12 = xmlPullParser.getFraction();
            n14 = 1065353216;
            f10 = 1.0f;
            n12 = (int)(f12 == f10 ? 0 : (f12 < f10 ? -1 : 1));
            attributeSet = null;
            if (n12 < 0) {
                float f15 = f12 - 0.0f;
                object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                if (object2 < 0) {
                    xmlPullParser.setFraction(f10);
                } else {
                    object2 = arrayList.size();
                    xmlPullParser = AnimatorInflaterCompat.createNewKeyframe((Keyframe)xmlPullParser, f10);
                    arrayList.add((int)object2, (String)xmlPullParser);
                    ++n11;
                }
            }
            if ((object2 = (Object)((f14 = (f13 = keyframe.getFraction()) - 0.0f) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1))) != 0) {
                float f16 = f13 - 0.0f;
                n17 = (int)(f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1));
                if (n17 < 0) {
                    keyframe.setFraction(0.0f);
                } else {
                    keyframe = AnimatorInflaterCompat.createNewKeyframe(keyframe, 0.0f);
                    arrayList.add(0, (String)keyframe);
                    ++n11;
                }
            }
            keyframe = new Keyframe[n11];
            arrayList.toArray((T[])keyframe);
            while (n16 < n11) {
                xmlPullParser = keyframe[n16];
                f12 = xmlPullParser.getFraction();
                float f17 = f12 - 0.0f;
                object2 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
                if (object2 < 0) {
                    if (n16 == 0) {
                        xmlPullParser.setFraction(0.0f);
                    } else {
                        object2 = n11 + -1;
                        if (n16 == object2) {
                            xmlPullParser.setFraction(f10);
                        } else {
                            float f18;
                            n17 = n16 + 1;
                            n15 = n16;
                            while (n17 < object2 && (n12 = (int)((f18 = (f11 = (keyframe2 = keyframe[n17]).getFraction()) - 0.0f) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) < 0) {
                                int n18 = n17 + 1;
                                n15 = n17;
                                n17 = n18;
                            }
                            n17 = n15 + 1;
                            xmlPullParser = keyframe[n17];
                            f13 = xmlPullParser.getFraction();
                            object2 = n16 + -1;
                            propertyValuesHolder = keyframe[object2];
                            f12 = propertyValuesHolder.getFraction();
                            AnimatorInflaterCompat.distributeKeyframes((Keyframe[])keyframe, f13 -= f12, n16, n15);
                        }
                    }
                }
                ++n16;
            }
            propertyValuesHolder = PropertyValuesHolder.ofKeyframe((String)string2, (Keyframe[])keyframe);
            if (n10 == n13) {
                object = ArgbEvaluator.getInstance();
                propertyValuesHolder.setEvaluator((TypeEvaluator)object);
            }
        }
        return propertyValuesHolder;
    }

    private static PropertyValuesHolder[] loadValues(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Object object;
        int n10;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        PropertyValuesHolder[] propertyValuesHolderArray = null;
        ArrayList arrayList = null;
        while (true) {
            String string2;
            int n11;
            n10 = xmlPullParser.getEventType();
            int n12 = 3;
            if (n10 == n12 || n10 == (n11 = 1)) break;
            int n13 = 2;
            if (n10 != n13) {
                xmlPullParser.next();
                continue;
            }
            Object object2 = xmlPullParser.getName();
            n10 = (int)(((String)object2).equals(string2 = "propertyValuesHolder") ? 1 : 0);
            if (n10 != 0) {
                object2 = AndroidResources.STYLEABLE_PROPERTY_VALUES_HOLDER;
                TypedArray typedArray = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, (int[])object2);
                String string3 = TypedArrayUtils.getNamedString(typedArray, xmlPullParser2, "propertyName", n12);
                n10 = 4;
                int n14 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser2, "valueType", n13, n10);
                object2 = context;
                object = resources;
                string2 = xmlPullParser;
                object2 = AnimatorInflaterCompat.loadPvh(context, resources, theme, xmlPullParser, string3, n14);
                if (object2 == null) {
                    n12 = n14;
                    object2 = AnimatorInflaterCompat.getPVH(typedArray, n14, 0, n11, string3);
                }
                if (object2 != null) {
                    if (arrayList == null) {
                        object = new ArrayList();
                        arrayList = object;
                    }
                    arrayList.add(object2);
                }
                typedArray.recycle();
            }
            xmlPullParser.next();
        }
        if (arrayList != null) {
            n10 = arrayList.size();
            propertyValuesHolderArray = new PropertyValuesHolder[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                propertyValuesHolderArray[i10] = object = (PropertyValuesHolder)arrayList.get(i10);
            }
        }
        return propertyValuesHolderArray;
    }

    private static void parseAnimatorFromTypeArray(ValueAnimator valueAnimator, TypedArray typedArray, TypedArray typedArray2, float f10, XmlPullParser xmlPullParser) {
        int n10 = 1;
        int n11 = 300;
        long l10 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "duration", n10, n11);
        long l11 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "startOffset", 2, 0);
        String string2 = "valueType";
        int n12 = 4;
        int n13 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, string2, 7, n12);
        String string3 = "valueFrom";
        int n14 = TypedArrayUtils.hasAttribute(xmlPullParser, string3);
        if (n14 != 0 && (n14 = TypedArrayUtils.hasAttribute(xmlPullParser, string3 = "valueTo")) != 0) {
            String string4;
            n14 = 6;
            int n15 = 5;
            if (n13 == n12) {
                n13 = AnimatorInflaterCompat.inferValueTypeFromValues(typedArray, n15, n14);
            }
            if ((string3 = AnimatorInflaterCompat.getPVH(typedArray, n13, n15, n14, string4 = "")) != null) {
                PropertyValuesHolder[] propertyValuesHolderArray = new PropertyValuesHolder[n10];
                propertyValuesHolderArray[0] = string3;
                valueAnimator.setValues(propertyValuesHolderArray);
            }
        }
        valueAnimator.setDuration(l10);
        valueAnimator.setStartDelay(l11);
        String string5 = "repeatCount";
        n11 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, string5, 3, 0);
        valueAnimator.setRepeatCount(n11);
        String string6 = "repeatMode";
        int n16 = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, string6, n12, n10);
        valueAnimator.setRepeatMode(n16);
        if (typedArray2 != null) {
            AnimatorInflaterCompat.setupObjectAnimator(valueAnimator, typedArray2, n13, f10, xmlPullParser);
        }
    }

    private static void setupObjectAnimator(ValueAnimator valueAnimator, TypedArray object, int n10, float f10, XmlPullParser object2) {
        valueAnimator = (ObjectAnimator)valueAnimator;
        int n11 = 1;
        String string2 = TypedArrayUtils.getNamedString(object, object2, "pathData", n11);
        if (string2 != null) {
            int n12 = 2;
            String string3 = TypedArrayUtils.getNamedString(object, object2, "propertyXName", n12);
            int n13 = 3;
            String string4 = "propertyYName";
            object2 = TypedArrayUtils.getNamedString(object, object2, string4, n13);
            if (n10 != n12) {
                n12 = 4;
            }
            if (string3 == null && object2 == null) {
                StringBuilder stringBuilder = new StringBuilder();
                object = object.getPositionDescription();
                stringBuilder.append((String)object);
                stringBuilder.append(" propertyXName or propertyYName is needed for PathData");
                object = stringBuilder.toString();
                valueAnimator = new InflateException((String)object);
                throw valueAnimator;
            }
            object = PathParser.createPathFromPathData(string2);
            n10 = 0x3F000000;
            float f11 = 0.5f;
            AnimatorInflaterCompat.setupPathMotion((Path)object, (ObjectAnimator)valueAnimator, f10 *= f11, string3, (String)object2);
        } else {
            n10 = 0;
            float f12 = 0.0f;
            Object var11_12 = null;
            String string5 = "propertyName";
            object = TypedArrayUtils.getNamedString(object, object2, string5, 0);
            valueAnimator.setPropertyName((String)object);
        }
    }

    private static void setupPathMotion(Path propertyValuesHolderArray, ObjectAnimator objectAnimator, float f10, String propertyValuesHolderArray2, String propertyValuesHolderArray3) {
        Object object;
        Object object2;
        float f11;
        int n10;
        PropertyValuesHolder[] propertyValuesHolderArray4 = propertyValuesHolderArray;
        ObjectAnimator objectAnimator2 = objectAnimator;
        PropertyValuesHolder[] propertyValuesHolderArray5 = propertyValuesHolderArray2;
        PropertyValuesHolder[] propertyValuesHolderArray6 = propertyValuesHolderArray3;
        PathMeasure pathMeasure = new PathMeasure((Path)propertyValuesHolderArray, false);
        ArrayList<Float> arrayList = new ArrayList<Float>();
        float f12 = 0.0f;
        Float f13 = Float.valueOf(0.0f);
        arrayList.add(f13);
        f13 = null;
        float f14 = 0.0f;
        do {
            f11 = pathMeasure.getLength();
            object2 = Float.valueOf(f14 += f11);
            arrayList.add((Float)object2);
        } while ((n10 = pathMeasure.nextContour()) != 0);
        pathMeasure = new PathMeasure((Path)propertyValuesHolderArray4, false);
        f11 = f14 / f10;
        n10 = (int)f11;
        int n11 = 1;
        float f15 = Float.MIN_VALUE;
        int n12 = Math.min(100, n10 += n11);
        object2 = new float[n12];
        float[] fArray = new float[n12];
        int n13 = 2;
        float f16 = 2.8E-45f;
        float[] fArray2 = new float[n13];
        float f17 = n12 + -1;
        f14 /= f17;
        int n14 = 0;
        f17 = 0.0f;
        int n15 = 0;
        while (true) {
            float f18;
            n13 = 0;
            f16 = 0.0f;
            object = null;
            if (n14 >= n12) break;
            Float f19 = (Float)arrayList.get(n15);
            float f20 = f19.floatValue();
            f15 = f12 - f20;
            pathMeasure.getPosTan(f15, fArray2, null);
            f15 = fArray2[0];
            object2[n14] = f15;
            f15 = Float.MIN_VALUE;
            fArray[n14] = f16 = fArray2[1];
            n11 = n15 + 1;
            n13 = arrayList.size();
            if (n11 < n13 && (n13 = (int)((f18 = (f12 += f14) - (f16 = ((Float)(object = (Float)arrayList.get(n11))).floatValue())) == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1))) > 0) {
                pathMeasure.nextContour();
                n15 = n11;
            }
            ++n14;
            n11 = 1;
            f15 = Float.MIN_VALUE;
        }
        if (propertyValuesHolderArray5 != null) {
            propertyValuesHolderArray4 = PropertyValuesHolder.ofFloat((String)propertyValuesHolderArray5, (float[])object2);
        } else {
            n12 = 0;
            propertyValuesHolderArray4 = null;
        }
        if (propertyValuesHolderArray6 != null) {
            object = PropertyValuesHolder.ofFloat((String)propertyValuesHolderArray6, (float[])fArray);
        }
        if (propertyValuesHolderArray4 == null) {
            int n16 = 1;
            propertyValuesHolderArray4 = new PropertyValuesHolder[n16];
            propertyValuesHolderArray4[0] = object;
            objectAnimator2.setValues(propertyValuesHolderArray4);
        } else {
            int n17 = 1;
            if (object == null) {
                propertyValuesHolderArray5 = new PropertyValuesHolder[n17];
                propertyValuesHolderArray5[0] = propertyValuesHolderArray4;
                objectAnimator2.setValues(propertyValuesHolderArray5);
            } else {
                int n18 = 2;
                propertyValuesHolderArray6 = new PropertyValuesHolder[n18];
                propertyValuesHolderArray6[0] = propertyValuesHolderArray4;
                propertyValuesHolderArray6[n17] = object;
                objectAnimator2.setValues(propertyValuesHolderArray6);
            }
        }
    }
}

