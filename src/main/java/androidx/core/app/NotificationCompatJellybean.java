/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Builder
 *  android.app.PendingIntent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.util.SparseArray
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.RemoteInput;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class NotificationCompatJellybean {
    public static final String EXTRA_ALLOW_GENERATED_REPLIES = "android.support.allowGeneratedReplies";
    public static final String EXTRA_DATA_ONLY_REMOTE_INPUTS = "android.support.dataRemoteInputs";
    private static final String KEY_ACTION_INTENT = "actionIntent";
    private static final String KEY_ALLOWED_DATA_TYPES = "allowedDataTypes";
    private static final String KEY_ALLOW_FREE_FORM_INPUT = "allowFreeFormInput";
    private static final String KEY_CHOICES = "choices";
    private static final String KEY_DATA_ONLY_REMOTE_INPUTS = "dataOnlyRemoteInputs";
    private static final String KEY_EXTRAS = "extras";
    private static final String KEY_ICON = "icon";
    private static final String KEY_LABEL = "label";
    private static final String KEY_REMOTE_INPUTS = "remoteInputs";
    private static final String KEY_RESULT_KEY = "resultKey";
    private static final String KEY_SEMANTIC_ACTION = "semanticAction";
    private static final String KEY_SHOWS_USER_INTERFACE = "showsUserInterface";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "NotificationCompat";
    private static Field sActionIconField;
    private static Field sActionIntentField;
    private static Field sActionTitleField;
    private static boolean sActionsAccessFailed;
    private static Field sActionsField;
    private static final Object sActionsLock;
    private static Field sExtrasField;
    private static boolean sExtrasFieldAccessFailed;
    private static final Object sExtrasLock;

    static {
        Object object;
        sExtrasLock = object = new Object();
        sActionsLock = object = new Object();
    }

    private NotificationCompatJellybean() {
    }

    public static SparseArray buildActionExtrasMap(List list) {
        int n10 = list.size();
        SparseArray sparseArray = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Bundle bundle = (Bundle)list.get(i10);
            if (bundle == null) continue;
            if (sparseArray == null) {
                sparseArray = new SparseArray();
            }
            sparseArray.put(i10, (Object)bundle);
        }
        return sparseArray;
    }

    private static boolean ensureActionReflectionReadyLocked() {
        boolean bl2;
        block14: {
            String string2 = "Unable to access notification actions";
            String string3 = TAG;
            bl2 = sActionsAccessFailed;
            if (bl2) {
                return false;
            }
            bl2 = true;
            Object object = sActionsField;
            if (object != null) break block14;
            object = "android.app.Notification$Action";
            object = Class.forName((String)object);
            Object object2 = KEY_ICON;
            object2 = ((Class)object).getDeclaredField((String)object2);
            sActionIconField = object2;
            object2 = KEY_TITLE;
            object2 = ((Class)object).getDeclaredField((String)object2);
            sActionTitleField = object2;
            object2 = KEY_ACTION_INTENT;
            object = ((Class)object).getDeclaredField((String)object2);
            sActionIntentField = object;
            object = Notification.class;
            object2 = "actions";
            object = ((Class)object).getDeclaredField((String)object2);
            sActionsField = object;
            try {
                ((Field)object).setAccessible(bl2);
            }
            catch (NoSuchFieldException noSuchFieldException) {
                Log.e((String)string3, (String)string2, (Throwable)noSuchFieldException);
                sActionsAccessFailed = bl2;
            }
            catch (ClassNotFoundException classNotFoundException) {
                Log.e((String)string3, (String)string2, (Throwable)classNotFoundException);
                sActionsAccessFailed = bl2;
            }
        }
        return sActionsAccessFailed ^ bl2;
    }

    private static RemoteInput fromBundle(Bundle bundle) {
        Object object;
        Iterator iterator2 = bundle.getStringArrayList(KEY_ALLOWED_DATA_TYPES);
        HashSet<String> hashSet = new HashSet<String>();
        if (iterator2 != null) {
            boolean bl2;
            iterator2 = ((ArrayList)((Object)iterator2)).iterator();
            while (bl2 = iterator2.hasNext()) {
                object = (String)iterator2.next();
                hashSet.add((String)object);
            }
        }
        String string2 = bundle.getString(KEY_RESULT_KEY);
        CharSequence charSequence = bundle.getCharSequence(KEY_LABEL);
        CharSequence[] charSequenceArray = bundle.getCharSequenceArray(KEY_CHOICES);
        boolean bl3 = bundle.getBoolean(KEY_ALLOW_FREE_FORM_INPUT);
        Bundle bundle2 = bundle.getBundle(KEY_EXTRAS);
        object = iterator2;
        iterator2 = new Iterator(string2, charSequence, charSequenceArray, bl3, 0, bundle2, hashSet);
        return iterator2;
    }

    private static RemoteInput[] fromBundleArray(Bundle[] bundleArray) {
        int n10;
        if (bundleArray == null) {
            return null;
        }
        int n11 = bundleArray.length;
        RemoteInput[] remoteInputArray = new RemoteInput[n11];
        for (int i10 = 0; i10 < (n10 = bundleArray.length); ++i10) {
            RemoteInput remoteInput;
            remoteInputArray[i10] = remoteInput = NotificationCompatJellybean.fromBundle(bundleArray[i10]);
        }
        return remoteInputArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static NotificationCompat$Action getAction(Notification object, int n10) {
        Object object2 = sActionsLock;
        synchronized (object2) {
            Throwable throwable2;
            block7: {
                try {
                    try {
                        Object object3;
                        PendingIntent pendingIntent = NotificationCompatJellybean.getActionObjectsLocked(object);
                        if (pendingIntent == null) return null;
                        pendingIntent = pendingIntent[n10];
                        if ((object = NotificationCompatJellybean.getExtras(object)) != null && (object = object.getSparseParcelableArray((String)(object3 = "android.support.actionExtras"))) != null) {
                            object = object.get(n10);
                            object = (Bundle)object;
                        } else {
                            boolean bl2 = false;
                            object = null;
                        }
                        Field field = sActionIconField;
                        n10 = field.getInt(pendingIntent);
                        object3 = sActionTitleField;
                        object3 = ((Field)object3).get(pendingIntent);
                        object3 = (CharSequence)object3;
                        Field field2 = sActionIntentField;
                        pendingIntent = field2.get(pendingIntent);
                        pendingIntent = pendingIntent;
                        return NotificationCompatJellybean.readAction(n10, (CharSequence)object3, pendingIntent, (Bundle)object);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        boolean bl3;
                        String string2 = TAG;
                        String string3 = "Unable to access notification actions";
                        Log.e((String)string2, (String)string3, (Throwable)illegalAccessException);
                        sActionsAccessFailed = bl3 = true;
                    }
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                return null;
            }
            throw throwable2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getActionCount(Notification objectArray) {
        Object object = sActionsLock;
        synchronized (object) {
            objectArray = NotificationCompatJellybean.getActionObjectsLocked((Notification)objectArray);
            if (objectArray == null) return 0;
            return objectArray.length;
        }
    }

    public static NotificationCompat$Action getActionFromBundle(Bundle bundle) {
        String string2;
        String string3 = KEY_EXTRAS;
        Object object = bundle.getBundle(string3);
        boolean bl2 = false;
        Parcelable parcelable = null;
        if (object != null) {
            string2 = EXTRA_ALLOW_GENERATED_REPLIES;
            bl2 = object.getBoolean(string2, false);
        }
        int n10 = bundle.getInt(KEY_ICON);
        CharSequence charSequence = bundle.getCharSequence(KEY_TITLE);
        Parcelable parcelable2 = parcelable = bundle.getParcelable(KEY_ACTION_INTENT);
        parcelable2 = (PendingIntent)parcelable;
        Bundle bundle2 = bundle.getBundle(string3);
        RemoteInput[] remoteInputArray = NotificationCompatJellybean.fromBundleArray(NotificationCompatJellybean.getBundleArrayFromBundle(bundle, KEY_REMOTE_INPUTS));
        RemoteInput[] remoteInputArray2 = NotificationCompatJellybean.fromBundleArray(NotificationCompatJellybean.getBundleArrayFromBundle(bundle, KEY_DATA_ONLY_REMOTE_INPUTS));
        int n11 = bundle.getInt(KEY_SEMANTIC_ACTION);
        boolean bl3 = bundle.getBoolean(KEY_SHOWS_USER_INTERFACE);
        string2 = object;
        object = new NotificationCompat$Action(n10, charSequence, (PendingIntent)parcelable2, bundle2, remoteInputArray, remoteInputArray2, bl2, n11, bl3, false);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object[] getActionObjectsLocked(Notification objectArray) {
        Object object = sActionsLock;
        synchronized (object) {
            boolean bl2 = NotificationCompatJellybean.ensureActionReflectionReadyLocked();
            if (!bl2) {
                return null;
            }
            try {
                Field field = sActionsField;
                objectArray = field.get(objectArray);
                return objectArray;
            }
            catch (IllegalAccessException illegalAccessException) {
                boolean bl3;
                String string2 = TAG;
                String string3 = "Unable to access notification actions";
                Log.e((String)string2, (String)string3, (Throwable)illegalAccessException);
                sActionsAccessFailed = bl3 = true;
                return null;
            }
        }
    }

    private static Bundle[] getBundleArrayFromBundle(Bundle bundle, String string2) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(string2);
        int n10 = parcelableArray instanceof Bundle[];
        if (n10 == 0 && parcelableArray != null) {
            n10 = parcelableArray.length;
            parcelableArray = (Bundle[])Arrays.copyOf(parcelableArray, n10, Bundle[].class);
            bundle.putParcelableArray(string2, parcelableArray);
            return parcelableArray;
        }
        return (Bundle[])parcelableArray;
    }

    /*
     * WARNING - void declaration
     */
    public static Bundle getBundleForAction(NotificationCompat$Action notificationCompat$Action) {
        void var3_5;
        Bundle bundle = new Bundle();
        Object object = notificationCompat$Action.getIconCompat();
        if (object != null) {
            int bl2 = object.getResId();
        } else {
            boolean bl2 = false;
            object = null;
        }
        bundle.putInt(KEY_ICON, (int)var3_5);
        object = notificationCompat$Action.getTitle();
        bundle.putCharSequence(KEY_TITLE, (CharSequence)object);
        object = notificationCompat$Action.getActionIntent();
        String string2 = KEY_ACTION_INTENT;
        bundle.putParcelable(string2, (Parcelable)object);
        object = notificationCompat$Action.getExtras();
        if (object != null) {
            string2 = notificationCompat$Action.getExtras();
            object = new Bundle((Bundle)string2);
        } else {
            object = new Bundle();
        }
        boolean bl3 = notificationCompat$Action.getAllowGeneratedReplies();
        object.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, bl3);
        bundle.putBundle(KEY_EXTRAS, (Bundle)object);
        object = NotificationCompatJellybean.toBundleArray(notificationCompat$Action.getRemoteInputs());
        bundle.putParcelableArray(KEY_REMOTE_INPUTS, (Parcelable[])object);
        boolean bl4 = notificationCompat$Action.getShowsUserInterface();
        bundle.putBoolean(KEY_SHOWS_USER_INTERFACE, bl4);
        int n10 = notificationCompat$Action.getSemanticAction();
        bundle.putInt(KEY_SEMANTIC_ACTION, n10);
        return bundle;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Bundle getExtras(Notification object) {
        Object object2 = sExtrasLock;
        synchronized (object2) {
            boolean bl2 = sExtrasFieldAccessFailed;
            if (bl2) {
                return null;
            }
            bl2 = true;
            try {
                Class<Bundle> clazz;
                Object object3 = sExtrasField;
                if (object3 == null) {
                    object3 = Notification.class;
                    clazz = KEY_EXTRAS;
                    clazz = Bundle.class;
                    Class<?> clazz2 = ((Field)(object3 = ((Class)object3).getDeclaredField((String)((Object)clazz)))).getType();
                    boolean bl3 = clazz.isAssignableFrom(clazz2);
                    if (!bl3) {
                        object = TAG;
                        object3 = "Notification.extras field is not of type Bundle";
                        Log.e((String)object, (String)object3);
                        sExtrasFieldAccessFailed = bl2;
                        return null;
                    }
                    ((Field)object3).setAccessible(bl2);
                    sExtrasField = object3;
                }
                object3 = sExtrasField;
                object3 = ((Field)object3).get(object);
                if ((object3 = (Bundle)object3) == null) {
                    object3 = new Bundle();
                    clazz = sExtrasField;
                    ((Field)((Object)clazz)).set(object, object3);
                }
                return object3;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                String string2 = TAG;
                String string3 = "Unable to access notification extras";
                Log.e((String)string2, (String)string3, (Throwable)noSuchFieldException);
            }
            catch (IllegalAccessException illegalAccessException) {
                String string4 = TAG;
                String string5 = "Unable to access notification extras";
                Log.e((String)string4, (String)string5, (Throwable)illegalAccessException);
            }
            sExtrasFieldAccessFailed = bl2;
            return null;
        }
    }

    public static NotificationCompat$Action readAction(int n10, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle) {
        NotificationCompat$Action notificationCompat$Action;
        boolean bl2;
        RemoteInput[] remoteInputArray;
        RemoteInput[] remoteInputArray2;
        CharSequence charSequence2;
        RemoteInput[] remoteInputArray3 = null;
        if (bundle != null) {
            remoteInputArray3 = NotificationCompatJellybean.fromBundleArray(NotificationCompatJellybean.getBundleArrayFromBundle(bundle, "android.support.remoteInputs"));
            RemoteInput[] remoteInputArray4 = NotificationCompatJellybean.fromBundleArray(NotificationCompatJellybean.getBundleArrayFromBundle(bundle, EXTRA_DATA_ONLY_REMOTE_INPUTS));
            charSequence2 = EXTRA_ALLOW_GENERATED_REPLIES;
            boolean bl3 = bundle.getBoolean(charSequence2);
            remoteInputArray2 = remoteInputArray3;
            remoteInputArray = remoteInputArray4;
            bl2 = bl3;
        } else {
            Object var5_6 = null;
            remoteInputArray2 = null;
            remoteInputArray = null;
            bl2 = false;
        }
        remoteInputArray3 = notificationCompat$Action;
        charSequence2 = charSequence;
        notificationCompat$Action = new NotificationCompat$Action(n10, charSequence, pendingIntent, bundle, remoteInputArray2, remoteInputArray, bl2, 0, true, false);
        return notificationCompat$Action;
    }

    private static Bundle toBundle(RemoteInput object) {
        Bundle bundle = new Bundle();
        Object object2 = ((RemoteInput)object).getResultKey();
        bundle.putString(KEY_RESULT_KEY, (String)object2);
        object2 = ((RemoteInput)object).getLabel();
        bundle.putCharSequence(KEY_LABEL, (CharSequence)object2);
        object2 = ((RemoteInput)object).getChoices();
        bundle.putCharSequenceArray(KEY_CHOICES, (CharSequence[])object2);
        boolean bl2 = ((RemoteInput)object).getAllowFreeFormInput();
        bundle.putBoolean(KEY_ALLOW_FREE_FORM_INPUT, bl2);
        object2 = ((RemoteInput)object).getExtras();
        String string2 = KEY_EXTRAS;
        bundle.putBundle(string2, (Bundle)object2);
        object = ((RemoteInput)object).getAllowedDataTypes();
        if (object != null && !(bl2 = object.isEmpty())) {
            int n10 = object.size();
            object2 = new ArrayList(n10);
            object = object.iterator();
            while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                string2 = (String)object.next();
                ((ArrayList)object2).add(string2);
            }
            object = KEY_ALLOWED_DATA_TYPES;
            bundle.putStringArrayList((String)object, (ArrayList)object2);
        }
        return bundle;
    }

    private static Bundle[] toBundleArray(RemoteInput[] remoteInputArray) {
        int n10;
        if (remoteInputArray == null) {
            return null;
        }
        int n11 = remoteInputArray.length;
        Bundle[] bundleArray = new Bundle[n11];
        for (int i10 = 0; i10 < (n10 = remoteInputArray.length); ++i10) {
            Bundle bundle;
            bundleArray[i10] = bundle = NotificationCompatJellybean.toBundle(remoteInputArray[i10]);
        }
        return bundleArray;
    }

    public static Bundle writeActionAndGetExtras(Notification.Builder builder, NotificationCompat$Action notificationCompat$Action) {
        int n10;
        RemoteInput[] remoteInputArray = notificationCompat$Action.getIconCompat();
        if (remoteInputArray != null) {
            n10 = remoteInputArray.getResId();
        } else {
            n10 = 0;
            remoteInputArray = null;
        }
        CharSequence charSequence = notificationCompat$Action.getTitle();
        PendingIntent pendingIntent = notificationCompat$Action.getActionIntent();
        builder.addAction(n10, charSequence, pendingIntent);
        remoteInputArray = notificationCompat$Action.getExtras();
        builder = new Bundle((Bundle)remoteInputArray);
        remoteInputArray = notificationCompat$Action.getRemoteInputs();
        if (remoteInputArray != null) {
            remoteInputArray = NotificationCompatJellybean.toBundleArray(notificationCompat$Action.getRemoteInputs());
            charSequence = "android.support.remoteInputs";
            builder.putParcelableArray((String)charSequence, (Parcelable[])remoteInputArray);
        }
        if ((remoteInputArray = notificationCompat$Action.getDataOnlyRemoteInputs()) != null) {
            remoteInputArray = NotificationCompatJellybean.toBundleArray(notificationCompat$Action.getDataOnlyRemoteInputs());
            charSequence = EXTRA_DATA_ONLY_REMOTE_INPUTS;
            builder.putParcelableArray((String)charSequence, (Parcelable[])remoteInputArray);
        }
        boolean bl2 = notificationCompat$Action.getAllowGeneratedReplies();
        builder.putBoolean(EXTRA_ALLOW_GENERATED_REPLIES, bl2);
        return builder;
    }
}

