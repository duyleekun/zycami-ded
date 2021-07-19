/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.util.Xml
 *  org.xmlpull.v1.XmlPullParser
 *  org.xmlpull.v1.XmlPullParserException
 */
package androidx.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.util.Xml;
import androidx.navigation.NavAction;
import androidx.navigation.NavArgument;
import androidx.navigation.NavArgument$Builder;
import androidx.navigation.NavDeepLink;
import androidx.navigation.NavDeepLink$Builder;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavOptions;
import androidx.navigation.NavOptions$Builder;
import androidx.navigation.NavType;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.R$styleable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class NavInflater {
    public static final String APPLICATION_ID_PLACEHOLDER = "${applicationId}";
    private static final String TAG_ACTION = "action";
    private static final String TAG_ARGUMENT = "argument";
    private static final String TAG_DEEP_LINK = "deepLink";
    private static final String TAG_INCLUDE = "include";
    private static final ThreadLocal sTmpValue;
    private Context mContext;
    private NavigatorProvider mNavigatorProvider;

    static {
        ThreadLocal threadLocal;
        sTmpValue = threadLocal = new ThreadLocal();
    }

    public NavInflater(Context context, NavigatorProvider navigatorProvider) {
        this.mContext = context;
        this.mNavigatorProvider = navigatorProvider;
    }

    private static NavType checkNavType(TypedValue object, NavType object2, NavType object3, String string2, String string3) {
        if (object2 != null && object2 != object3) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("Type is ");
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(" but found ");
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append(": ");
            int n10 = object.data;
            ((StringBuilder)object3).append(n10);
            object = ((StringBuilder)object3).toString();
            object2 = new XmlPullParserException((String)object);
            throw object2;
        }
        if (object2 == null) {
            object2 = object3;
        }
        return object2;
    }

    private NavDestination inflate(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int n10) {
        int n11;
        int n12;
        Object object = this.mNavigatorProvider;
        Object object2 = xmlResourceParser.getName();
        object = ((NavigatorProvider)object).getNavigator((String)object2).createDestination();
        object2 = this.mContext;
        ((NavDestination)object).onInflate((Context)object2, attributeSet);
        int n13 = xmlResourceParser.getDepth();
        int n14 = 1;
        int n15 = n13 + 1;
        while ((n13 = xmlResourceParser.next()) != n14 && ((n12 = xmlResourceParser.getDepth()) >= n15 || n13 != (n11 = 3))) {
            Object object3;
            n11 = 2;
            if (n13 != n11 || n12 > n15) continue;
            Object object4 = TAG_ARGUMENT;
            object2 = xmlResourceParser.getName();
            n12 = (int)(((String)object4).equals(object2) ? 1 : 0);
            if (n12 != 0) {
                this.inflateArgumentForDestination(resources, (NavDestination)object, attributeSet, n10);
                continue;
            }
            object4 = TAG_DEEP_LINK;
            n12 = (int)(((String)object4).equals(object2) ? 1 : 0);
            if (n12 != 0) {
                this.inflateDeepLink(resources, (NavDestination)object, attributeSet);
                continue;
            }
            object4 = TAG_ACTION;
            n12 = (int)(((String)object4).equals(object2) ? 1 : 0);
            if (n12 != 0) {
                object2 = this;
                object4 = resources;
                object3 = object;
                this.inflateAction(resources, (NavDestination)object, attributeSet, xmlResourceParser, n10);
                continue;
            }
            object4 = TAG_INCLUDE;
            n13 = (int)(((String)object4).equals(object2) ? 1 : 0);
            if (n13 != 0 && (n13 = object instanceof NavGraph) != 0) {
                object2 = R$styleable.NavInclude;
                object2 = resources.obtainAttributes(attributeSet, (int[])object2);
                n12 = R$styleable.NavInclude_graph;
                n11 = 0;
                n12 = object2.getResourceId(n12, 0);
                object3 = object;
                object3 = (NavGraph)object;
                object4 = this.inflate(n12);
                ((NavGraph)object3).addDestination((NavDestination)object4);
                object2.recycle();
                continue;
            }
            n13 = object instanceof NavGraph;
            if (n13 == 0) continue;
            object2 = object;
            object2 = (NavGraph)object;
            object4 = this.inflate(resources, xmlResourceParser, attributeSet, n10);
            ((NavGraph)object2).addDestination((NavDestination)object4);
        }
        return (NavDestination)object;
    }

    private void inflateAction(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int n10) {
        int n11;
        Object object = androidx.navigation.common.R$styleable.NavAction;
        object = resources.obtainAttributes(attributeSet, object);
        int n12 = androidx.navigation.common.R$styleable.NavAction_android_id;
        n12 = object.getResourceId(n12, 0);
        int n13 = androidx.navigation.common.R$styleable.NavAction_destination;
        n13 = object.getResourceId(n13, 0);
        NavAction navAction = new NavAction(n13);
        NavOptions$Builder navOptions$Builder = new NavOptions$Builder();
        int n14 = androidx.navigation.common.R$styleable.NavAction_launchSingleTop;
        n14 = (int)(object.getBoolean(n14, false) ? 1 : 0);
        navOptions$Builder.setLaunchSingleTop(n14 != 0);
        n14 = androidx.navigation.common.R$styleable.NavAction_popUpTo;
        int n15 = -1;
        n14 = object.getResourceId(n14, n15);
        int n16 = androidx.navigation.common.R$styleable.NavAction_popUpToInclusive;
        int n17 = object.getBoolean(n16, false);
        navOptions$Builder.setPopUpTo(n14, n17 != 0);
        n17 = androidx.navigation.common.R$styleable.NavAction_enterAnim;
        n17 = object.getResourceId(n17, n15);
        navOptions$Builder.setEnterAnim(n17);
        n17 = androidx.navigation.common.R$styleable.NavAction_exitAnim;
        n17 = object.getResourceId(n17, n15);
        navOptions$Builder.setExitAnim(n17);
        n17 = androidx.navigation.common.R$styleable.NavAction_popEnterAnim;
        n17 = object.getResourceId(n17, n15);
        navOptions$Builder.setPopEnterAnim(n17);
        n17 = androidx.navigation.common.R$styleable.NavAction_popExitAnim;
        n17 = object.getResourceId(n17, n15);
        navOptions$Builder.setPopExitAnim(n17);
        NavOptions navOptions = navOptions$Builder.build();
        navAction.setNavOptions(navOptions);
        navOptions = new Bundle();
        n13 = xmlResourceParser.getDepth();
        n14 = 1;
        while ((n15 = xmlResourceParser.next()) != n14 && ((n16 = xmlResourceParser.getDepth()) >= (n13 += n14) || n15 != (n11 = 3))) {
            String string2;
            String string3;
            n11 = 2;
            if (n15 != n11 || n16 > n13 || (n15 = (int)((string3 = TAG_ARGUMENT).equals(string2 = xmlResourceParser.getName()) ? 1 : 0)) == 0) continue;
            this.inflateArgumentForBundle(resources, (Bundle)navOptions, attributeSet, n10);
        }
        boolean bl2 = navOptions.isEmpty();
        if (!bl2) {
            navAction.setDefaultArguments((Bundle)navOptions);
        }
        navDestination.putAction(n12, navAction);
        object.recycle();
    }

    /*
     * Enabled aggressive block sorting
     */
    private NavArgument inflateArgument(TypedArray object, Resources object2, int n10) {
        Object object3;
        Object object4;
        Object object5;
        block16: {
            TypedValue typedValue;
            block20: {
                String string2;
                Object object6;
                block21: {
                    int n11;
                    CharSequence charSequence;
                    String string3;
                    block22: {
                        boolean bl2;
                        block23: {
                            int n12;
                            int n13;
                            int n14;
                            block19: {
                                int n15;
                                block18: {
                                    String string4;
                                    String string5;
                                    block17: {
                                        object5 = new NavArgument$Builder();
                                        int n16 = androidx.navigation.common.R$styleable.NavArgument_nullable;
                                        bl2 = false;
                                        string3 = null;
                                        n16 = (int)(object.getBoolean(n16, false) ? 1 : 0);
                                        ((NavArgument$Builder)object5).setIsNullable(n16 != 0);
                                        object6 = sTmpValue;
                                        typedValue = (TypedValue)((ThreadLocal)object6).get();
                                        if (typedValue == null) {
                                            typedValue = new TypedValue();
                                            ((ThreadLocal)object6).set(typedValue);
                                        }
                                        n16 = androidx.navigation.common.R$styleable.NavArgument_argType;
                                        object6 = object.getString(n16);
                                        n14 = 0;
                                        object4 = null;
                                        if (object6 != null) {
                                            object3 = charSequence.getResourcePackageName(n13);
                                            object3 = NavType.fromArgType((String)object6, (String)object3);
                                        } else {
                                            n13 = 0;
                                            object3 = null;
                                        }
                                        n15 = androidx.navigation.common.R$styleable.NavArgument_android_defaultValue;
                                        boolean bl3 = object.getValue(n15, typedValue);
                                        if (!bl3) break block16;
                                        object4 = NavType.ReferenceType;
                                        string5 = "' for ";
                                        string4 = "unsupported value '";
                                        n12 = 16;
                                        if (object3 != object4) break block17;
                                        int n17 = typedValue.resourceId;
                                        if (n17 != 0) {
                                            object4 = n17;
                                            break block16;
                                        } else {
                                            n17 = typedValue.type;
                                            if (n17 == n12 && (n17 = typedValue.data) == 0) {
                                                object4 = 0;
                                                break block16;
                                            } else {
                                                charSequence = new StringBuilder();
                                                ((StringBuilder)charSequence).append(string4);
                                                object5 = typedValue.string;
                                                ((StringBuilder)charSequence).append(object5);
                                                ((StringBuilder)charSequence).append(string5);
                                                object3 = ((NavType)object3).getName();
                                                ((StringBuilder)charSequence).append((String)object3);
                                                ((StringBuilder)charSequence).append(". Must be a reference to a resource.");
                                                charSequence = ((StringBuilder)charSequence).toString();
                                                XmlPullParserException xmlPullParserException = new XmlPullParserException((String)charSequence);
                                                throw xmlPullParserException;
                                            }
                                        }
                                    }
                                    int n18 = typedValue.resourceId;
                                    if (n18 == 0) break block18;
                                    if (object3 != null) {
                                        charSequence = new StringBuilder();
                                        ((StringBuilder)charSequence).append(string4);
                                        object5 = typedValue.string;
                                        ((StringBuilder)charSequence).append(object5);
                                        ((StringBuilder)charSequence).append(string5);
                                        object3 = ((NavType)object3).getName();
                                        ((StringBuilder)charSequence).append((String)object3);
                                        ((StringBuilder)charSequence).append(". You must use a \"");
                                        object3 = ((NavType)object4).getName();
                                        ((StringBuilder)charSequence).append((String)object3);
                                        ((StringBuilder)charSequence).append("\" type to reference other resources.");
                                        charSequence = ((StringBuilder)charSequence).toString();
                                        XmlPullParserException xmlPullParserException = new XmlPullParserException((String)charSequence);
                                        throw xmlPullParserException;
                                    }
                                    Integer n19 = n18;
                                    object3 = object4;
                                    object4 = n19;
                                    break block16;
                                }
                                object4 = NavType.StringType;
                                if (object3 != object4) break block19;
                                object4 = object.getString(n15);
                                break block16;
                            }
                            n11 = typedValue.type;
                            n14 = 3;
                            if (n11 == n14) break block20;
                            n14 = 4;
                            string2 = "float";
                            if (n11 == n14) break block21;
                            n14 = 5;
                            if (n11 == n14) break block22;
                            int n20 = 18;
                            if (n11 == n20) break block23;
                            if (n11 >= n12 && n11 <= (n20 = 31)) {
                                NavType navType = NavType.FloatType;
                                if (object3 == navType) {
                                    object3 = NavInflater.checkNavType(typedValue, (NavType)object3, navType, (String)object6, string2);
                                    n11 = typedValue.data;
                                    float f10 = n11;
                                    object4 = Float.valueOf(f10);
                                    break block16;
                                } else {
                                    NavType navType2 = NavType.IntType;
                                    charSequence = "integer";
                                    object3 = NavInflater.checkNavType(typedValue, (NavType)object3, navType2, (String)object6, (String)charSequence);
                                    n11 = typedValue.data;
                                    object4 = n11;
                                }
                                break block16;
                            } else {
                                charSequence = new StringBuilder();
                                ((StringBuilder)charSequence).append("unsupported argument type ");
                                n13 = typedValue.type;
                                ((StringBuilder)charSequence).append(n13);
                                charSequence = ((StringBuilder)charSequence).toString();
                                XmlPullParserException xmlPullParserException = new XmlPullParserException((String)charSequence);
                                throw xmlPullParserException;
                            }
                        }
                        NavType navType = NavType.BoolType;
                        charSequence = "boolean";
                        object3 = NavInflater.checkNavType(typedValue, (NavType)object3, navType, (String)object6, (String)charSequence);
                        n11 = typedValue.data;
                        if (n11 != 0) {
                            bl2 = true;
                        }
                        object4 = bl2;
                        break block16;
                    }
                    NavType navType = NavType.IntType;
                    string3 = "dimension";
                    object3 = NavInflater.checkNavType(typedValue, (NavType)object3, navType, (String)object6, string3);
                    DisplayMetrics displayMetrics = charSequence.getDisplayMetrics();
                    float f11 = typedValue.getDimension(displayMetrics);
                    n11 = (int)f11;
                    object4 = n11;
                    break block16;
                }
                NavType navType = NavType.FloatType;
                object3 = NavInflater.checkNavType(typedValue, (NavType)object3, navType, (String)object6, string2);
                float f12 = typedValue.getFloat();
                object4 = Float.valueOf(f12);
                break block16;
            }
            String string6 = typedValue.string.toString();
            if (object3 == null) {
                object3 = NavType.inferFromValue(string6);
            }
            object4 = ((NavType)object3).parseValue(string6);
        }
        if (object4 != null) {
            ((NavArgument$Builder)object5).setDefaultValue(object4);
        }
        if (object3 != null) {
            ((NavArgument$Builder)object5).setType((NavType)object3);
        }
        return ((NavArgument$Builder)object5).build();
    }

    private void inflateArgumentForBundle(Resources object, Bundle bundle, AttributeSet attributeSet, int n10) {
        int n11;
        Object object2 = androidx.navigation.common.R$styleable.NavArgument;
        if ((object2 = (Object)(attributeSet = object.obtainAttributes(attributeSet, object2)).getString(n11 = androidx.navigation.common.R$styleable.NavArgument_android_name)) != null) {
            if ((n10 = (int)(((NavArgument)(object = this.inflateArgument((TypedArray)attributeSet, (Resources)object, n10))).isDefaultValuePresent() ? 1 : 0)) != 0) {
                ((NavArgument)object).putDefaultValue((String)object2, bundle);
            }
            attributeSet.recycle();
            return;
        }
        object = new XmlPullParserException("Arguments must have a name");
        throw object;
    }

    private void inflateArgumentForDestination(Resources object, NavDestination navDestination, AttributeSet attributeSet, int n10) {
        int n11;
        Object object2 = androidx.navigation.common.R$styleable.NavArgument;
        if ((object2 = (Object)(attributeSet = object.obtainAttributes(attributeSet, object2)).getString(n11 = androidx.navigation.common.R$styleable.NavArgument_android_name)) != null) {
            object = this.inflateArgument((TypedArray)attributeSet, (Resources)object, n10);
            navDestination.addArgument((String)object2, (NavArgument)object);
            attributeSet.recycle();
            return;
        }
        object = new XmlPullParserException("Arguments must have a name");
        throw object;
    }

    private void inflateDeepLink(Resources object, NavDestination navDestination, AttributeSet object2) {
        Object object3 = androidx.navigation.common.R$styleable.NavDeepLink;
        object = object.obtainAttributes((AttributeSet)object2, (int[])object3);
        int n10 = androidx.navigation.common.R$styleable.NavDeepLink_uri;
        object2 = object.getString(n10);
        int n11 = androidx.navigation.common.R$styleable.NavDeepLink_action;
        object3 = object.getString(n11);
        int n12 = androidx.navigation.common.R$styleable.NavDeepLink_mimeType;
        String string2 = object.getString(n12);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)object3)) && (bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            object = new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
            throw object;
        }
        NavDeepLink$Builder navDeepLink$Builder = new NavDeepLink$Builder();
        String string3 = APPLICATION_ID_PLACEHOLDER;
        if (object2 != null) {
            String string4 = this.mContext.getPackageName();
            object2 = ((String)object2).replace(string3, string4);
            navDeepLink$Builder.setUriPattern((String)object2);
        }
        if ((n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0)) == 0) {
            object2 = this.mContext.getPackageName();
            object2 = ((String)object3).replace(string3, (CharSequence)object2);
            navDeepLink$Builder.setAction((String)object2);
        }
        if (string2 != null) {
            object2 = this.mContext.getPackageName();
            object2 = string2.replace(string3, (CharSequence)object2);
            navDeepLink$Builder.setMimeType((String)object2);
        }
        object2 = navDeepLink$Builder.build();
        navDestination.addDeepLink((NavDeepLink)object2);
        object.recycle();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavGraph inflate(int var1_1) {
        var2_2 = this.mContext.getResources();
        var3_3 = var2_2.getXml(var1_1);
        var4_4 /* !! */  = Xml.asAttributeSet((XmlPullParser)var3_3);
        try {
            while ((var5_6 = var3_3.next()) != (var6_7 = 2) && var5_6 != (var7_8 = 1)) {
            }
            if (var5_6 != var6_7) ** GOTO lbl46
            var8_9 = var3_3.getName();
            ** GOTO lbl27
        }
        catch (Exception var4_5) {
            var9_12 = new StringBuilder();
            var10_14 = "Exception inflating ";
            var9_12.append(var10_14);
            var11_16 = var2_2.getResourceName(var1_1);
            var9_12.append(var11_16);
            var11_16 = " line ";
            var9_12.append(var11_16);
            var1_1 = var3_3.getLineNumber();
            var9_12.append(var1_1);
            var11_16 = var9_12.toString();
            var8_9 = new RuntimeException(var11_16, var4_5);
            throw var8_9;
lbl27:
            // 1 sources

            var6_7 = (var4_4 /* !! */  = this.inflate(var2_2, var3_3, var4_4 /* !! */ , var1_1)) instanceof NavGraph;
            if (var6_7 == 0) ** GOTO lbl-1000
            try {
                var4_4 /* !! */  = (NavGraph)var4_4 /* !! */ ;
            }
            catch (Throwable var11_15) {}
            var3_3.close();
            return var4_4 /* !! */ ;
lbl-1000:
            // 1 sources

            {
                var9_11 = new StringBuilder();
                var10_13 = "Root element <";
                var9_11.append(var10_13);
                var9_11.append((String)var8_9);
                var8_9 = "> did not inflate into a NavGraph";
                var9_11.append((String)var8_9);
                var8_9 = var9_11.toString();
                var4_4 /* !! */  = new IllegalArgumentException((String)var8_9);
                throw var4_4 /* !! */ ;
lbl46:
                // 1 sources

                var8_10 = "No start tag found";
                var4_4 /* !! */  = new XmlPullParserException(var8_10);
                throw var4_4 /* !! */ ;
            }
        }
        var3_3.close();
        throw var11_15;
    }
}

