/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.Log
 */
package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.navigation.ActivityNavigator$Destination;
import androidx.navigation.ActivityNavigator$Extras;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.Navigator$Extras;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActivityNavigator
extends Navigator {
    private static final String EXTRA_NAV_CURRENT = "android-support-navigation:ActivityNavigator:current";
    private static final String EXTRA_NAV_SOURCE = "android-support-navigation:ActivityNavigator:source";
    private static final String EXTRA_POP_ENTER_ANIM = "android-support-navigation:ActivityNavigator:popEnterAnim";
    private static final String EXTRA_POP_EXIT_ANIM = "android-support-navigation:ActivityNavigator:popExitAnim";
    private static final String LOG_TAG = "ActivityNavigator";
    private Context mContext;
    private Activity mHostActivity;

    public ActivityNavigator(Context context) {
        boolean bl2;
        this.mContext = context;
        while (bl2 = context instanceof ContextWrapper) {
            bl2 = context instanceof Activity;
            if (bl2) {
                context = (Activity)context;
                this.mHostActivity = context;
                break;
            }
            context = ((ContextWrapper)context).getBaseContext();
        }
    }

    public static void applyPopAnimationsToPendingTransition(Activity activity) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        String string2 = EXTRA_POP_ENTER_ANIM;
        int n10 = -1;
        int n11 = intent.getIntExtra(string2, n10);
        String string3 = EXTRA_POP_EXIT_ANIM;
        int n12 = intent.getIntExtra(string3, n10);
        if (n11 != n10 || n12 != n10) {
            string3 = null;
            if (n11 == n10) {
                n11 = 0;
                string2 = null;
            }
            if (n12 == n10) {
                n12 = 0;
                intent = null;
            }
            activity.overridePendingTransition(n11, n12);
        }
    }

    public ActivityNavigator$Destination createDestination() {
        ActivityNavigator$Destination activityNavigator$Destination = new ActivityNavigator$Destination(this);
        return activityNavigator$Destination;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public NavDestination navigate(ActivityNavigator$Destination object, Bundle object2, NavOptions object3, Navigator$Extras object4) {
        Object object5 = ((ActivityNavigator$Destination)object).getIntent();
        if (object5 != null) {
            int n10;
            int n11;
            String string2;
            String string3;
            Matcher matcher;
            CharSequence charSequence;
            Object object6 = ((ActivityNavigator$Destination)object).getIntent();
            object5 = new Intent((Intent)object6);
            if (object2 != null) {
                object5.putExtras((Bundle)object2);
                object6 = ((ActivityNavigator$Destination)object).getDataPattern();
                boolean bl2 = TextUtils.isEmpty((CharSequence)object6);
                if (!bl2) {
                    int n12;
                    charSequence = new StringBuffer();
                    matcher = Pattern.compile("\\{(.+?)\\}").matcher((CharSequence)object6);
                    while ((n12 = matcher.find()) != 0) {
                        n12 = 1;
                        string3 = matcher.group(n12);
                        boolean bl3 = object2.containsKey(string3);
                        if (bl3) {
                            string2 = "";
                            matcher.appendReplacement((StringBuffer)charSequence, string2);
                            string3 = Uri.encode((String)object2.get(string3).toString());
                            ((StringBuffer)charSequence).append(string3);
                            continue;
                        }
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Could not find ");
                        ((StringBuilder)object3).append(string3);
                        ((StringBuilder)object3).append(" in ");
                        ((StringBuilder)object3).append(object2);
                        ((StringBuilder)object3).append(" to fill data pattern ");
                        ((StringBuilder)object3).append((String)object6);
                        object2 = ((StringBuilder)object3).toString();
                        object = new IllegalArgumentException((String)object2);
                        throw object;
                    }
                    matcher.appendTail((StringBuffer)charSequence);
                    object2 = Uri.parse((String)((StringBuffer)charSequence).toString());
                    object5.setData((Uri)object2);
                }
            }
            if ((n11 = object4 instanceof ActivityNavigator$Extras) != 0) {
                object6 = object4;
                object6 = (ActivityNavigator$Extras)object4;
                n10 = ((ActivityNavigator$Extras)object6).getFlags();
                object5.addFlags(n10);
            }
            if ((n10 = (object6 = this.mContext) instanceof Activity) == 0) {
                n10 = 0x10000000;
                object5.addFlags(n10);
            }
            if (object3 != null && (n10 = (int)(((NavOptions)object3).shouldLaunchSingleTop() ? 1 : 0)) != 0) {
                n10 = 0x20000000;
                object5.addFlags(n10);
            }
            object6 = this.mHostActivity;
            charSequence = EXTRA_NAV_CURRENT;
            matcher = null;
            if (object6 != null && (object6 = object6.getIntent()) != null && (n10 = object6.getIntExtra((String)charSequence, 0)) != 0) {
                string3 = EXTRA_NAV_SOURCE;
                object5.putExtra(string3, n10);
            }
            n10 = ((NavDestination)object).getId();
            object5.putExtra((String)charSequence, n10);
            object6 = this.getContext().getResources();
            charSequence = "when launching ";
            string3 = LOG_TAG;
            string2 = "animator";
            if (object3 != null) {
                CharSequence charSequence2;
                boolean bl4;
                int n13 = ((NavOptions)object3).getPopEnterAnim();
                int n14 = ((NavOptions)object3).getPopExitAnim();
                if (n13 > 0 && (bl4 = ((String)(charSequence2 = object6.getResourceTypeName(n13))).equals(string2)) || n14 > 0 && (bl4 = ((String)(charSequence2 = object6.getResourceTypeName(n14))).equals(string2))) {
                    charSequence2 = new StringBuilder();
                    String string4 = "Activity destinations do not support Animator resource. Ignoring popEnter resource ";
                    ((StringBuilder)charSequence2).append(string4);
                    String string5 = object6.getResourceName(n13);
                    ((StringBuilder)charSequence2).append(string5);
                    ((StringBuilder)charSequence2).append(" and popExit resource ");
                    string5 = object6.getResourceName(n14);
                    ((StringBuilder)charSequence2).append(string5);
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append(object);
                    string5 = ((StringBuilder)charSequence2).toString();
                    Log.w((String)string3, (String)string5);
                } else {
                    charSequence2 = EXTRA_POP_ENTER_ANIM;
                    object5.putExtra((String)charSequence2, n13);
                    String string6 = EXTRA_POP_EXIT_ANIM;
                    object5.putExtra(string6, n14);
                }
            }
            if (n11 != 0) {
                object2 = ((ActivityNavigator$Extras)(object4 = (ActivityNavigator$Extras)object4)).getActivityOptions();
                if (object2 != null) {
                    object4 = this.mContext;
                    object2 = ((ActivityOptionsCompat)object2).toBundle();
                    ContextCompat.startActivity((Context)object4, object5, (Bundle)object2);
                } else {
                    object2 = this.mContext;
                    object2.startActivity(object5);
                }
            } else {
                object2 = this.mContext;
                object2.startActivity(object5);
            }
            if (object3 != null && (object2 = this.mHostActivity) != null) {
                boolean bl5;
                n11 = ((NavOptions)object3).getEnterAnim();
                int n15 = ((NavOptions)object3).getExitAnim();
                if (n11 > 0 && (bl5 = ((String)(object4 = object6.getResourceTypeName(n11))).equals(string2)) || n15 > 0 && (bl5 = ((String)(object4 = object6.getResourceTypeName(n15))).equals(string2))) {
                    object4 = new StringBuilder();
                    object5 = "Activity destinations do not support Animator resource. Ignoring enter resource ";
                    ((StringBuilder)object4).append((String)object5);
                    object2 = object6.getResourceName(n11);
                    ((StringBuilder)object4).append((String)object2);
                    ((StringBuilder)object4).append(" and exit resource ");
                    object2 = object6.getResourceName(n15);
                    ((StringBuilder)object4).append((String)object2);
                    ((StringBuilder)object4).append((String)charSequence);
                    ((StringBuilder)object4).append(object);
                    object = ((StringBuilder)object4).toString();
                    Log.w((String)string3, (String)object);
                } else if (n11 >= 0 || n15 >= 0) {
                    int n16 = Math.max(n11, 0);
                    n11 = Math.max(n15, 0);
                    object3 = this.mHostActivity;
                    object3.overridePendingTransition(n16, n11);
                }
            }
            return null;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Destination ");
        int n17 = ((NavDestination)object).getId();
        ((StringBuilder)object3).append(n17);
        ((StringBuilder)object3).append(" does not have an Intent set.");
        object = ((StringBuilder)object3).toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public boolean popBackStack() {
        Activity activity = this.mHostActivity;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }
}

