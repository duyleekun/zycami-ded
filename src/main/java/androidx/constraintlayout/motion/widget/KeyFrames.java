/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.Xml
 *  androidx.constraintlayout.motion.widget.MotionController
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KeyFrames {
    private static final String TAG = "KeyFrames";
    public static final int UNSET = 255;
    public static HashMap sKeyMakers;
    private HashMap mFramesMap;

    static {
        HashMap hashMap;
        sKeyMakers = hashMap = new HashMap();
        String string2 = "KeyAttribute";
        Constructor constructor = KeyAttributes.class;
        Class[] classArray = null;
        Class[] classArray2 = new Class[]{};
        constructor = ((Class)((Object)constructor)).getConstructor(classArray2);
        hashMap.put(string2, constructor);
        hashMap = sKeyMakers;
        string2 = "KeyPosition";
        constructor = KeyPosition.class;
        classArray2 = new Class[]{};
        constructor = ((Class)((Object)constructor)).getConstructor(classArray2);
        hashMap.put(string2, constructor);
        hashMap = sKeyMakers;
        string2 = "KeyCycle";
        constructor = KeyCycle.class;
        classArray2 = new Class[]{};
        constructor = ((Class)((Object)constructor)).getConstructor(classArray2);
        hashMap.put(string2, constructor);
        hashMap = sKeyMakers;
        string2 = "KeyTimeCycle";
        constructor = KeyTimeCycle.class;
        classArray2 = new Class[]{};
        constructor = ((Class)((Object)constructor)).getConstructor(classArray2);
        hashMap.put(string2, constructor);
        hashMap = sKeyMakers;
        string2 = "KeyTrigger";
        constructor = KeyTrigger.class;
        classArray = new Class[]{};
        constructor = ((Class)((Object)constructor)).getConstructor(classArray);
        try {
            hashMap.put(string2, constructor);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            string2 = TAG;
            constructor = "unable to load";
            Log.e((String)string2, constructor, (Throwable)noSuchMethodException);
        }
    }

    /*
     * Unable to fully structure code
     */
    public KeyFrames(Context var1_1, XmlPullParser var2_4) {
        super();
        var3_5 = new HashMap();
        this.mFramesMap = var3_5;
        var3_5 = null;
        var4_7 = var2_4.getEventType();
        while (var4_7 != (var5_8 = 1)) {
            block25: {
                block26: {
                    block27: {
                        block28: {
                            var5_8 = 2;
                            if (var4_7 == var5_8) break block28;
                            var5_8 = 3;
                            if (var4_7 != var5_8) ** GOTO lbl73
                            var6_9 = "KeyFrameSet";
                            var7_10 = var2_4.getName();
                            var4_7 = (int)var6_9.equals(var7_10);
                            if (var4_7 != 0) {
                                return;
                            }
                            ** GOTO lbl73
                        }
                        var6_9 = var2_4.getName();
                        var7_10 = KeyFrames.sKeyMakers;
                        var5_8 = (int)var7_10.containsKey(var6_9);
                        if (var5_8 == 0) break block25;
                        var7_10 = KeyFrames.sKeyMakers;
                        var6_9 = var7_10.get(var6_9);
                        var6_9 = (Constructor)var6_9;
                        var5_8 = 0;
                        var7_10 = null;
                        var7_10 = new Object[]{};
                        var6_9 = var6_9.newInstance(var7_10);
                        var6_9 = (Key)var6_9;
                        try {
                            var3_5 = Xml.asAttributeSet((XmlPullParser)var2_4);
                        }
                        catch (Exception var3_6) {
                            break block27;
                        }
                        var6_9.load(var1_1, (AttributeSet)var3_5);
                        this.addKey((Key)var6_9);
                        break block26;
                        catch (Exception var8_11) {
                            var6_9 = var3_5;
                            var3_5 = var8_11;
                        }
                    }
                    var7_10 = "KeyFrames";
                    var9_12 = "unable to create ";
                    Log.e((String)var7_10, (String)var9_12, var3_5);
                }
                var3_5 = var6_9;
                ** GOTO lbl73
            }
            var7_10 = "CustomAttribute";
            var4_7 = (int)var6_9.equalsIgnoreCase((String)var7_10);
            if (var4_7 == 0 || var3_5 == null) ** GOTO lbl73
            var6_9 = var3_5.mCustomConstraints;
            if (var6_9 == null) ** GOTO lbl73
            try {
                ConstraintAttribute.parse(var1_1, var2_4, (HashMap)var6_9);
lbl73:
                // 6 sources

                var4_7 = var2_4.next();
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

    private void addKey(Key key) {
        HashMap hashMap = this.mFramesMap;
        int n10 = key.mTargetId;
        Integer n11 = n10;
        boolean bl2 = hashMap.containsKey(n11);
        if (!bl2) {
            hashMap = this.mFramesMap;
            n10 = key.mTargetId;
            n11 = n10;
            ArrayList arrayList = new ArrayList();
            hashMap.put(n11, arrayList);
        }
        hashMap = this.mFramesMap;
        n11 = key.mTargetId;
        ((ArrayList)hashMap.get(n11)).add(key);
    }

    public static String name(int n10, Context context) {
        return context.getResources().getResourceEntryName(n10);
    }

    public void addFrames(MotionController motionController) {
        Object object = this.mFramesMap;
        int n10 = motionController.mId;
        Object object2 = n10;
        if ((object = (ArrayList)((HashMap)object).get(object2)) != null) {
            motionController.addKeys((ArrayList)object);
        }
        object = this.mFramesMap;
        n10 = -1;
        object2 = n10;
        if ((object = (ArrayList)((HashMap)object).get(object2)) != null) {
            object = ((ArrayList)object).iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                String string2;
                object2 = (Key)object.next();
                boolean bl2 = ((Key)object2).matches(string2 = ((ConstraintLayout$LayoutParams)motionController.mView.getLayoutParams()).constraintTag);
                if (!bl2) continue;
                motionController.addKey((Key)object2);
            }
        }
    }

    public ArrayList getKeyFramesForView(int n10) {
        HashMap hashMap = this.mFramesMap;
        Integer n11 = n10;
        return (ArrayList)hashMap.get(n11);
    }

    public Set getKeys() {
        return this.mFramesMap.keySet();
    }
}

