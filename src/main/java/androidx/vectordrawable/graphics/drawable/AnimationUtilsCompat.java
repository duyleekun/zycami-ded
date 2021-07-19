/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.XmlResourceParser
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Xml
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AnimationUtils
 *  android.view.animation.AnticipateInterpolator
 *  android.view.animation.AnticipateOvershootInterpolator
 *  android.view.animation.BounceInterpolator
 *  android.view.animation.CycleInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  android.view.animation.OvershootInterpolator
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimationUtilsCompat {
    private AnimationUtilsCompat() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private static Interpolator createInterpolatorFromXml(Context object, Resources object2, Resources.Theme object3, XmlPullParser xmlPullParser) {
        void var2_5;
        int n10;
        int n11;
        void var3_12;
        int n12 = var3_12.getDepth();
        Object var2_4 = null;
        while (((n11 = var3_12.next()) != (n10 = 3) || (n10 = var3_12.getDepth()) > n12) && n11 != (n10 = 1)) {
            String string2;
            n10 = 2;
            if (n11 != n10) continue;
            AttributeSet attributeSet = Xml.asAttributeSet((XmlPullParser)var3_12);
            Object object4 = var3_12.getName();
            n10 = (int)(((String)object4).equals(string2 = "linearInterpolator") ? 1 : 0);
            if (n10 != 0) {
                LinearInterpolator linearInterpolator = new LinearInterpolator();
                continue;
            }
            string2 = "accelerateInterpolator";
            n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
            if (n10 != 0) {
                object4 = new AccelerateInterpolator(object, attributeSet);
            } else {
                string2 = "decelerateInterpolator";
                n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                if (n10 != 0) {
                    object4 = new DecelerateInterpolator(object, attributeSet);
                } else {
                    string2 = "accelerateDecelerateInterpolator";
                    n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                    if (n10 != 0) {
                        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
                        continue;
                    }
                    string2 = "cycleInterpolator";
                    n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                    if (n10 != 0) {
                        object4 = new CycleInterpolator(object, attributeSet);
                    } else {
                        string2 = "anticipateInterpolator";
                        n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                        if (n10 != 0) {
                            object4 = new AnticipateInterpolator(object, attributeSet);
                        } else {
                            string2 = "overshootInterpolator";
                            n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                            if (n10 != 0) {
                                object4 = new OvershootInterpolator(object, attributeSet);
                            } else {
                                string2 = "anticipateOvershootInterpolator";
                                n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                                if (n10 != 0) {
                                    object4 = new AnticipateOvershootInterpolator(object, attributeSet);
                                } else {
                                    string2 = "bounceInterpolator";
                                    n10 = (int)(((String)object4).equals(string2) ? 1 : 0);
                                    if (n10 != 0) {
                                        BounceInterpolator bounceInterpolator = new BounceInterpolator();
                                        continue;
                                    }
                                    string2 = "pathInterpolator";
                                    n11 = (int)(((String)object4).equals(string2) ? 1 : 0);
                                    if (n11 == 0) {
                                        CharSequence charSequence = new StringBuilder();
                                        charSequence.append("Unknown interpolator name: ");
                                        String string3 = var3_12.getName();
                                        charSequence.append(string3);
                                        charSequence = charSequence.toString();
                                        RuntimeException runtimeException = new RuntimeException((String)charSequence);
                                        throw runtimeException;
                                    }
                                    object4 = new PathInterpolatorCompat((Context)object, attributeSet, (XmlPullParser)var3_12);
                                }
                            }
                        }
                    }
                }
            }
            String string4 = object4;
        }
        return var2_5;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Interpolator loadInterpolator(Context object, int n10) {
        Throwable throwable;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return AnimationUtils.loadInterpolator((Context)object, (int)n10);
        }
        n11 = 0;
        XmlResourceParser xmlResourceParser = null;
        n12 = 17563663;
        String string2 = "Can't load animation resource ID #0x";
        if (n10 == n12) {
            try {
                object = new FastOutLinearInInterpolator();
                return object;
            }
            catch (IOException iOException) {}
            catch (XmlPullParserException xmlPullParserException) {}
            finally {
            }
        } else {
            n12 = 17563661;
            if (n10 == n12) {
                return new FastOutSlowInInterpolator();
            }
            n12 = 17563662;
            if (n10 == n12) {
                return new LinearOutSlowInInterpolator();
            }
            Resources resources = object.getResources();
            xmlResourceParser = resources.getAnimation(n10);
            resources = object.getResources();
            Resources.Theme theme = object.getTheme();
            object = AnimationUtilsCompat.createInterpolatorFromXml(object, resources, theme, (XmlPullParser)xmlResourceParser);
            if (xmlResourceParser == null) return object;
            xmlResourceParser.close();
            return object;
        }
        if (xmlResourceParser == null) throw throwable;
        xmlResourceParser.close();
        throw throwable;
    }
}

