/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.InflateException
 *  android.view.ViewGroup
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.ArcMotion;
import androidx.transition.AutoTransition;
import androidx.transition.ChangeBounds;
import androidx.transition.ChangeClipBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeScroll;
import androidx.transition.ChangeTransform;
import androidx.transition.Explode;
import androidx.transition.Fade;
import androidx.transition.PathMotion;
import androidx.transition.PatternPathMotion;
import androidx.transition.Scene;
import androidx.transition.Slide;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;

public class TransitionInflater {
    private static final ArrayMap CONSTRUCTORS;
    private static final Class[] CONSTRUCTOR_SIGNATURE;
    private final Context mContext;

    static {
        Object object = new Class[]{Context.class, AttributeSet.class};
        CONSTRUCTOR_SIGNATURE = object;
        CONSTRUCTORS = object = new ArrayMap();
    }

    private TransitionInflater(Context context) {
        this.mContext = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object createCustom(AttributeSet object, Class object2, String object3) {
        Object object4 = null;
        String string2 = object.getAttributeValue(null, "class");
        if (string2 == null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(" tag must have a 'class' attribute");
            object2 = ((StringBuilder)object2).toString();
            object = new InflateException((String)object2);
            throw object;
        }
        try {
            object3 = CONSTRUCTORS;
            synchronized (object3) {
                object4 = ((SimpleArrayMap)object3).get(string2);
            }
        }
        catch (Exception exception) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Could not instantiate ");
            ((StringBuilder)object4).append(object2);
            ((StringBuilder)object4).append(" class ");
            ((StringBuilder)object4).append(string2);
            object2 = ((StringBuilder)object4).toString();
            object3 = new InflateException((String)object2, (Throwable)exception);
            throw object3;
        }
        {
            Object object5;
            object4 = (Constructor)object4;
            boolean bl2 = true;
            if (object4 == null) {
                object5 = this.mContext;
                object5 = object5.getClassLoader();
                object5 = Class.forName(string2, false, (ClassLoader)object5);
                if ((object5 = ((Class)object5).asSubclass(object2)) != null) {
                    object4 = CONSTRUCTOR_SIGNATURE;
                    object4 = ((Class)object5).getConstructor((Class<?>)object4);
                    ((Constructor)object4).setAccessible(bl2);
                    ((SimpleArrayMap)object3).put(string2, object4);
                }
            }
            int n10 = 2;
            object5 = new Object[n10];
            Context context = this.mContext;
            object5[0] = context;
            object5[bl2] = object;
            return ((Constructor)object4).newInstance((Object[])object5);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private Transition createTransitionFromXml(XmlPullParser object, AttributeSet object2, Transition object3) {
        Object object4;
        int n10 = object.getDepth();
        boolean bl2 = object3 instanceof TransitionSet;
        if (bl2) {
            object4 = object3;
            object4 = (TransitionSet)object3;
        } else {
            bl2 = false;
            object4 = null;
        }
        block0: while (true) {
            Transition transition = null;
            while (true) {
                int n11;
                int n12;
                if ((n12 = object.next()) == (n11 = 3)) {
                    n11 = object.getDepth();
                    if (n11 <= n10) return transition;
                }
                if (n12 == (n11 = 1)) return transition;
                n11 = 2;
                if (n12 != n11) continue;
                String string2 = "fade";
                Object object5 = object.getName();
                n11 = (int)(string2.equals(object5) ? 1 : 0);
                if (n11 != 0) {
                    object5 = this.mContext;
                    transition = new Fade((Context)object5, (AttributeSet)object2);
                } else {
                    string2 = "changeBounds";
                    n11 = (int)(string2.equals(object5) ? 1 : 0);
                    if (n11 != 0) {
                        object5 = this.mContext;
                        transition = new ChangeBounds((Context)object5, (AttributeSet)object2);
                    } else {
                        string2 = "slide";
                        n11 = (int)(string2.equals(object5) ? 1 : 0);
                        if (n11 != 0) {
                            object5 = this.mContext;
                            transition = new Slide((Context)object5, (AttributeSet)object2);
                        } else {
                            string2 = "explode";
                            n11 = (int)(string2.equals(object5) ? 1 : 0);
                            if (n11 != 0) {
                                object5 = this.mContext;
                                transition = new Explode((Context)object5, (AttributeSet)object2);
                            } else {
                                string2 = "changeImageTransform";
                                n11 = (int)(string2.equals(object5) ? 1 : 0);
                                if (n11 != 0) {
                                    object5 = this.mContext;
                                    transition = new ChangeImageTransform((Context)object5, (AttributeSet)object2);
                                } else {
                                    string2 = "changeTransform";
                                    n11 = (int)(string2.equals(object5) ? 1 : 0);
                                    if (n11 != 0) {
                                        object5 = this.mContext;
                                        transition = new ChangeTransform((Context)object5, (AttributeSet)object2);
                                    } else {
                                        string2 = "changeClipBounds";
                                        n11 = (int)(string2.equals(object5) ? 1 : 0);
                                        if (n11 != 0) {
                                            object5 = this.mContext;
                                            transition = new ChangeClipBounds((Context)object5, (AttributeSet)object2);
                                        } else {
                                            string2 = "autoTransition";
                                            n11 = (int)(string2.equals(object5) ? 1 : 0);
                                            if (n11 != 0) {
                                                object5 = this.mContext;
                                                transition = new AutoTransition((Context)object5, (AttributeSet)object2);
                                            } else {
                                                string2 = "changeScroll";
                                                n11 = (int)(string2.equals(object5) ? 1 : 0);
                                                if (n11 != 0) {
                                                    object5 = this.mContext;
                                                    transition = new ChangeScroll((Context)object5, (AttributeSet)object2);
                                                } else {
                                                    string2 = "transitionSet";
                                                    n11 = (int)(string2.equals(object5) ? 1 : 0);
                                                    if (n11 != 0) {
                                                        object5 = this.mContext;
                                                        transition = new TransitionSet((Context)object5, (AttributeSet)object2);
                                                    } else {
                                                        string2 = "transition";
                                                        boolean bl3 = string2.equals(object5);
                                                        if (bl3) {
                                                            transition = (Transition)this.createCustom((AttributeSet)object2, Transition.class, string2);
                                                        } else {
                                                            string2 = "targets";
                                                            n11 = (int)(string2.equals(object5) ? 1 : 0);
                                                            if (n11 != 0) {
                                                                this.getTargetIds((XmlPullParser)object, (AttributeSet)object2, (Transition)object3);
                                                            } else {
                                                                string2 = "arcMotion";
                                                                n11 = (int)(string2.equals(object5) ? 1 : 0);
                                                                if (n11 != 0) {
                                                                    if (object3 == null) {
                                                                        object = new RuntimeException("Invalid use of arcMotion element");
                                                                        throw object;
                                                                    }
                                                                    string2 = this.mContext;
                                                                    object5 = new ArcMotion((Context)string2, (AttributeSet)object2);
                                                                    ((Transition)object3).setPathMotion((PathMotion)object5);
                                                                } else {
                                                                    string2 = "pathMotion";
                                                                    bl3 = string2.equals(object5);
                                                                    if (bl3) {
                                                                        if (object3 == null) {
                                                                            object = new RuntimeException("Invalid use of pathMotion element");
                                                                            throw object;
                                                                        }
                                                                        object5 = (PathMotion)this.createCustom((AttributeSet)object2, PathMotion.class, string2);
                                                                        ((Transition)object3).setPathMotion((PathMotion)object5);
                                                                    } else {
                                                                        string2 = "patternPathMotion";
                                                                        n12 = (int)(string2.equals(object5) ? 1 : 0);
                                                                        if (n12 == 0) {
                                                                            object3 = new StringBuilder();
                                                                            ((StringBuilder)object3).append("Unknown scene name: ");
                                                                            object = object.getName();
                                                                            ((StringBuilder)object3).append((String)object);
                                                                            object = ((StringBuilder)object3).toString();
                                                                            object2 = new RuntimeException((String)object);
                                                                            throw object2;
                                                                        }
                                                                        if (object3 == null) {
                                                                            object = new RuntimeException("Invalid use of patternPathMotion element");
                                                                            throw object;
                                                                        }
                                                                        string2 = this.mContext;
                                                                        object5 = new PatternPathMotion((Context)string2, (AttributeSet)object2);
                                                                        ((Transition)object3).setPathMotion((PathMotion)object5);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (transition == null) continue;
                n12 = (int)(object.isEmptyElementTag() ? 1 : 0);
                if (n12 == 0) {
                    this.createTransitionFromXml((XmlPullParser)object, (AttributeSet)object2, transition);
                }
                if (object4 != null) {
                    ((TransitionSet)object4).addTransition(transition);
                    continue block0;
                }
                if (object3 != null) break block0;
            }
            break;
        }
        object = new InflateException("Could not add transition to another transition.");
        throw object;
    }

    private TransitionManager createTransitionManagerFromXml(XmlPullParser object, AttributeSet object2, ViewGroup object3) {
        int n10;
        int n11;
        int n12 = object.getDepth();
        TransitionManager transitionManager = null;
        while (((n11 = object.next()) != (n10 = 3) || (n10 = object.getDepth()) > n12) && n11 != (n10 = 1)) {
            String string2;
            n10 = 2;
            if (n11 != n10) continue;
            String string3 = object.getName();
            n10 = (int)(string3.equals(string2 = "transitionManager") ? 1 : 0);
            if (n10 != 0) {
                transitionManager = new TransitionManager();
                continue;
            }
            string2 = "transition";
            n11 = (int)(string3.equals(string2) ? 1 : 0);
            if (n11 != 0 && transitionManager != null) {
                this.loadTransition((AttributeSet)object2, (XmlPullParser)object, (ViewGroup)object3, transitionManager);
                continue;
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Unknown scene name: ");
            object = object.getName();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
        return transitionManager;
    }

    public static TransitionInflater from(Context context) {
        TransitionInflater transitionInflater = new TransitionInflater(context);
        return transitionInflater;
    }

    /*
     * Loose catch block
     */
    private void getTargetIds(XmlPullParser object, AttributeSet object2, Transition object3) {
        int n10;
        int n11;
        int n12;
        int n13 = object.getDepth();
        while (((n12 = object.next()) != (n11 = 3) || (n10 = object.getDepth()) > n13) && n12 != (n10 = 1)) {
            Object object4;
            int n14 = 2;
            if (n12 != n14) continue;
            String string2 = object.getName();
            n12 = (int)(string2.equals(object4 = "target") ? 1 : 0);
            if (n12 != 0) {
                String string3;
                block17: {
                    string2 = this.mContext;
                    object4 = Styleable.TRANSITION_TARGET;
                    int n15 = TypedArrayUtils.getNamedResourceId((TypedArray)(string2 = string2.obtainStyledAttributes(object2, (int[])object4)), object, (String)(object4 = "targetId"), n10, 0);
                    if (n15 != 0) {
                        ((Transition)object3).addTarget(n15);
                    } else {
                        object4 = "excludeId";
                        if ((n14 = TypedArrayUtils.getNamedResourceId((TypedArray)string2, object, (String)object4, n14, 0)) != 0) {
                            ((Transition)object3).excludeTarget(n14, n10 != 0);
                        } else {
                            object4 = "targetName";
                            n14 = 4;
                            Object object5 = TypedArrayUtils.getNamedString((TypedArray)string2, object, (String)object4, n14);
                            if (object5 != null) {
                                ((Transition)object3).addTarget((String)object5);
                            } else {
                                object4 = "excludeName";
                                n14 = 5;
                                object5 = TypedArrayUtils.getNamedString((TypedArray)string2, object, (String)object4, n14);
                                if (object5 != null) {
                                    ((Transition)object3).excludeTarget((String)object5, n10 != 0);
                                } else {
                                    object5 = "excludeClass";
                                    string3 = TypedArrayUtils.getNamedString((TypedArray)string2, object, (String)object5, n11);
                                    if (string3 != null) {
                                        object5 = Class.forName(string3);
                                        ((Transition)object3).excludeTarget((Class)object5, n10 != 0);
                                    }
                                    Object object6 = "targetClass";
                                    string3 = TypedArrayUtils.getNamedString((TypedArray)string2, object, (String)object6, 0);
                                    if (string3 == null) break block17;
                                    object6 = Class.forName(string3);
                                    ((Transition)object3).addTarget((Class)object6);
                                }
                            }
                        }
                    }
                }
                string2.recycle();
                continue;
                catch (ClassNotFoundException classNotFoundException) {
                    string2.recycle();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Could not create ");
                    ((StringBuilder)object3).append(string3);
                    object3 = ((StringBuilder)object3).toString();
                    object2 = new RuntimeException((String)object3, classNotFoundException);
                    throw object2;
                }
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Unknown scene name: ");
            object = object.getName();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            object2 = new RuntimeException((String)object);
            throw object2;
        }
    }

    private void loadTransition(AttributeSet object, XmlPullParser object2, ViewGroup viewGroup, TransitionManager transitionManager) {
        Object object3 = this.mContext;
        Object object4 = Styleable.TRANSITION_MANAGER;
        object = object3.obtainStyledAttributes(object, object4);
        object3 = "transition";
        int n10 = -1;
        int n11 = TypedArrayUtils.getNamedResourceId((TypedArray)object, (XmlPullParser)object2, (String)object3, 2, n10);
        object4 = "fromScene";
        int n12 = TypedArrayUtils.getNamedResourceId((TypedArray)object, (XmlPullParser)object2, (String)object4, 0, n10);
        Scene scene = null;
        if (n12 < 0) {
            n12 = 0;
            object4 = null;
        } else {
            Context context = this.mContext;
            object4 = Scene.getSceneForLayout(viewGroup, n12, context);
        }
        int n13 = 1;
        String string2 = "toScene";
        int n14 = TypedArrayUtils.getNamedResourceId((TypedArray)object, (XmlPullParser)object2, string2, n13, n10);
        if (n14 >= 0) {
            Context context = this.mContext;
            scene = Scene.getSceneForLayout(viewGroup, n14, context);
        }
        if (n11 >= 0 && (object2 = this.inflateTransition(n11)) != null) {
            if (scene != null) {
                if (object4 == null) {
                    transitionManager.setTransition(scene, (Transition)object2);
                } else {
                    transitionManager.setTransition((Scene)object4, scene, (Transition)object2);
                }
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("No toScene for transition ID ");
                ((StringBuilder)object2).append(n11);
                object2 = ((StringBuilder)object2).toString();
                object = new RuntimeException((String)object2);
                throw object;
            }
        }
        object.recycle();
    }

    /*
     * Exception decompiling
     */
    public Transition inflateTransition(int var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [6 : 43->46)] java.lang.Throwable
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

    /*
     * Exception decompiling
     */
    public TransitionManager inflateTransitionManager(int var1_1, ViewGroup var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 2[TRYBLOCK] [6 : 44->47)] java.lang.Throwable
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
}

