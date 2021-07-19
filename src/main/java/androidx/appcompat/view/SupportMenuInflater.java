/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.util.AttributeSet
 *  android.view.Menu
 *  android.view.MenuInflater
 *  org.xmlpull.v1.XmlPullParser
 */
package androidx.appcompat.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import androidx.appcompat.view.SupportMenuInflater$MenuState;
import androidx.core.view.ActionProvider;
import org.xmlpull.v1.XmlPullParser;

public class SupportMenuInflater
extends MenuInflater {
    public static final Class[] ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE;
    public static final Class[] ACTION_VIEW_CONSTRUCTOR_SIGNATURE;
    public static final String LOG_TAG = "SupportMenuInflater";
    public static final int NO_ID = 0;
    private static final String XML_GROUP = "group";
    private static final String XML_ITEM = "item";
    private static final String XML_MENU = "menu";
    public final Object[] mActionProviderConstructorArguments;
    public final Object[] mActionViewConstructorArguments;
    public Context mContext;
    private Object mRealOwner;

    static {
        Class[] classArray = new Class[]{Context.class};
        ACTION_VIEW_CONSTRUCTOR_SIGNATURE = classArray;
        ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE = classArray;
    }

    public SupportMenuInflater(Context context) {
        super(context);
        this.mContext = context;
        Object[] objectArray = new Object[]{context};
        this.mActionViewConstructorArguments = objectArray;
        this.mActionProviderConstructorArguments = objectArray;
    }

    private Object findRealOwner(Object object) {
        boolean bl2 = object instanceof Activity;
        if (bl2) {
            return object;
        }
        bl2 = object instanceof ContextWrapper;
        if (bl2) {
            object = ((ContextWrapper)object).getBaseContext();
            object = this.findRealOwner(object);
        }
        return object;
    }

    private void parseMenu(XmlPullParser object, AttributeSet object2, Menu object3) {
        boolean bl2;
        String string2;
        int n10;
        int n11;
        SupportMenuInflater$MenuState supportMenuInflater$MenuState = new SupportMenuInflater$MenuState(this, (Menu)object3);
        int n12 = object.getEventType();
        do {
            n10 = 2;
            string2 = XML_MENU;
            n11 = 1;
            if (n12 != n10) continue;
            object3 = object.getName();
            bl2 = ((String)object3).equals(string2);
            if (bl2) {
                n12 = object.next();
                break;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Expecting menu, got ");
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            object = new RuntimeException((String)object2);
            throw object;
        } while ((n12 = object.next()) != n11);
        bl2 = false;
        Object object4 = null;
        int n13 = 0;
        int n14 = 0;
        while (n13 == 0) {
            if (n12 != n11) {
                boolean bl3;
                boolean bl4;
                String string3 = XML_ITEM;
                String string4 = XML_GROUP;
                if (n12 != n10) {
                    int n15 = 3;
                    if (n12 == n15) {
                        object3 = object.getName();
                        if (n14 != 0 && (n15 = (int)(((String)object3).equals(object4) ? 1 : 0)) != 0) {
                            object4 = null;
                            n14 = 0;
                        } else {
                            bl4 = ((String)object3).equals(string4);
                            if (bl4) {
                                supportMenuInflater$MenuState.resetGroup();
                            } else {
                                bl3 = ((String)object3).equals(string3);
                                if (bl3) {
                                    n12 = supportMenuInflater$MenuState.hasAddedItem() ? 1 : 0;
                                    if (n12 == 0) {
                                        object3 = supportMenuInflater$MenuState.itemActionProvider;
                                        if (object3 != null && (n12 = (int)(((ActionProvider)object3).hasSubMenu() ? 1 : 0)) != 0) {
                                            supportMenuInflater$MenuState.addSubMenuItem();
                                        } else {
                                            supportMenuInflater$MenuState.addItem();
                                        }
                                    }
                                } else {
                                    n12 = ((String)object3).equals(string2) ? 1 : 0;
                                    if (n12 != 0) {
                                        n13 = n11;
                                    }
                                }
                            }
                        }
                    }
                } else if (n14 == 0) {
                    object3 = object.getName();
                    bl4 = ((String)object3).equals(string4);
                    if (bl4) {
                        supportMenuInflater$MenuState.readGroup((AttributeSet)object2);
                    } else {
                        bl3 = ((String)object3).equals(string3);
                        if (bl3) {
                            supportMenuInflater$MenuState.readItem((AttributeSet)object2);
                        } else {
                            bl3 = ((String)object3).equals(string2);
                            if (bl3) {
                                object3 = supportMenuInflater$MenuState.addSubMenuItem();
                                this.parseMenu((XmlPullParser)object, (AttributeSet)object2, (Menu)object3);
                            } else {
                                object4 = object3;
                                n14 = n11;
                            }
                        }
                    }
                }
                n12 = object.next();
                continue;
            }
            object = new RuntimeException("Unexpected end of document");
            throw object;
        }
    }

    public Object getRealOwner() {
        Object object = this.mRealOwner;
        if (object == null) {
            object = this.mContext;
            this.mRealOwner = object = this.findRealOwner(object);
        }
        return this.mRealOwner;
    }

    /*
     * Exception decompiling
     */
    public void inflate(int var1_1, Menu var2_2) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [15 : 87->90)] java.lang.Throwable
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

