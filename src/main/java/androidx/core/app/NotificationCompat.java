/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$Action
 *  android.app.PendingIntent
 *  android.app.Person
 *  android.app.RemoteInput
 *  android.content.LocusId
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.LocusId;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat$Action;
import androidx.core.app.NotificationCompat$BubbleMetadata;
import androidx.core.app.NotificationCompatJellybean;
import androidx.core.app.Person;
import androidx.core.app.Person$Builder;
import androidx.core.app.RemoteInput;
import androidx.core.content.LocusIdCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = 255;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";
    public static final String EXTRA_BIG_TEXT = "android.bigText";
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";
    public static final String EXTRA_COLORIZED = "android.colorized";
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";
    public static final String EXTRA_INFO_TEXT = "android.infoText";
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";
    public static final String EXTRA_MESSAGES = "android.messages";
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";
    public static final String EXTRA_PEOPLE = "android.people";
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";
    public static final String EXTRA_PICTURE = "android.picture";
    public static final String EXTRA_PROGRESS = "android.progress";
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";
    public static final String EXTRA_SMALL_ICON = "android.icon";
    public static final String EXTRA_SUB_TEXT = "android.subText";
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";
    public static final String EXTRA_TEMPLATE = "android.template";
    public static final String EXTRA_TEXT = "android.text";
    public static final String EXTRA_TEXT_LINES = "android.textLines";
    public static final String EXTRA_TITLE = "android.title";
    public static final String EXTRA_TITLE_BIG = "android.title.big";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = 255;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = 254;
    public static final int STREAM_DEFAULT = 255;
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = 255;

    public static NotificationCompat$Action getAction(Notification object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 20;
        if (n11 >= n12) {
            return NotificationCompat.getActionCompatFromAction(object.actions[n10]);
        }
        n12 = 19;
        Object object2 = null;
        if (n11 >= n12) {
            Notification.Action action = object.actions[n10];
            object = object.extras;
            String string2 = "android.support.actionExtras";
            if ((object = object.getSparseParcelableArray(string2)) != null) {
                object2 = object = object.get(n10);
                object2 = (Bundle)object;
            }
            int n13 = action.icon;
            CharSequence charSequence = action.title;
            action = action.actionIntent;
            return NotificationCompatJellybean.readAction(n13, charSequence, (PendingIntent)action, (Bundle)object2);
        }
        n12 = 16;
        if (n11 >= n12) {
            return NotificationCompatJellybean.getAction(object, n10);
        }
        return null;
    }

    public static NotificationCompat$Action getActionCompatFromAction(Notification.Action action) {
        NotificationCompat$Action notificationCompat$Action;
        int n10;
        int n11;
        Bundle bundle;
        CharSequence charSequence;
        CharSequence charSequence2;
        Object object;
        int n12;
        Object object2;
        RemoteInput[] remoteInputArray;
        Notification.Action action2 = action;
        int n13 = Build.VERSION.SDK_INT;
        Bundle bundle2 = action.getRemoteInputs();
        int n14 = 29;
        IconCompat iconCompat = null;
        boolean bl2 = false;
        if (bundle2 == null) {
            boolean bl3 = false;
            remoteInputArray = null;
        } else {
            int n15;
            int n16 = ((android.app.RemoteInput[])bundle2).length;
            object2 = new RemoteInput[n16];
            for (n12 = 0; n12 < (n15 = ((android.app.RemoteInput[])bundle2).length); ++n12) {
                RemoteInput remoteInput;
                object = bundle2[n12];
                charSequence2 = object.getResultKey();
                charSequence = object.getLabel();
                bundle = object.getChoices();
                boolean bl4 = object.getAllowFreeFormInput();
                int n17 = n13 >= n14 ? (n11 = object.getEditChoicesBeforeSending()) : 0;
                Bundle bundle3 = object.getExtras();
                n10 = 0;
                object2[n12] = remoteInput = new RemoteInput((String)charSequence2, charSequence, (CharSequence[])bundle, bl4, n17, bundle3, null);
            }
            remoteInputArray = object2;
        }
        int n18 = 24;
        object2 = "android.support.allowGeneratedReplies";
        n12 = 1;
        if (n13 >= n18) {
            bundle2 = action.getExtras();
            n18 = (int)(bundle2.getBoolean((String)object2) ? 1 : 0);
            if (n18 == 0 && (n18 = (int)(action.getAllowGeneratedReplies() ? 1 : 0)) == 0) {
                n18 = 0;
                bundle2 = null;
            } else {
                n18 = n12;
            }
        } else {
            bundle2 = action.getExtras();
            n18 = (int)(bundle2.getBoolean((String)object2) ? 1 : 0);
        }
        int n19 = n18;
        bundle2 = action.getExtras();
        object2 = "android.support.action.showsUserInterface";
        boolean bl5 = bundle2.getBoolean((String)object2, n12 != 0);
        n18 = 28;
        if (n13 >= n18) {
            n18 = action.getSemanticAction();
        } else {
            bundle2 = action.getExtras();
            object2 = "android.support.action.semanticAction";
            n18 = bundle2.getInt((String)object2, 0);
        }
        n10 = n18;
        if (n13 >= n14) {
            bl2 = action.isContextual();
        }
        boolean bl6 = bl2;
        n18 = 23;
        if (n13 >= n18) {
            Object object3 = action.getIcon();
            if (object3 == null && (n11 = action2.icon) != 0) {
                charSequence2 = action2.title;
                charSequence = action2.actionIntent;
                bundle = action.getExtras();
                object = object3;
                object3 = new NotificationCompat$Action(n11, charSequence2, (PendingIntent)charSequence, bundle, remoteInputArray, null, n19 != 0, n10, bl5, bl2);
                return object3;
            }
            object3 = action.getIcon();
            if (object3 != null) {
                object3 = action.getIcon();
                iconCompat = IconCompat.createFromIconOrNullIfZeroResId(object3);
            }
            charSequence2 = action2.title;
            charSequence = action2.actionIntent;
            bundle = action.getExtras();
            object = object3;
            object3 = new NotificationCompat$Action(iconCompat, charSequence2, (PendingIntent)charSequence, bundle, remoteInputArray, null, n19 != 0, n10, bl5, bl6);
            return object3;
        }
        n11 = action2.icon;
        charSequence2 = action2.title;
        charSequence = action2.actionIntent;
        bundle = action.getExtras();
        object = notificationCompat$Action;
        notificationCompat$Action = new NotificationCompat$Action(n11, charSequence2, (PendingIntent)charSequence, bundle, remoteInputArray, null, n19 != 0, n10, bl5, bl2);
        return notificationCompat$Action;
    }

    public static int getActionCount(Notification actionArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        int n12 = 19;
        if (n10 >= n12) {
            actionArray = actionArray.actions;
            if (actionArray != null) {
                n11 = actionArray.length;
            }
            return n11;
        }
        n12 = 16;
        if (n10 >= n12) {
            return NotificationCompatJellybean.getActionCount((Notification)actionArray);
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return notification.getAllowSystemGeneratedContextualActions();
        }
        return false;
    }

    public static boolean getAutoCancel(Notification notification) {
        int n10 = notification.flags & 0x10;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            notification = null;
        }
        return n10 != 0;
    }

    public static int getBadgeIconType(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return notification.getBadgeIconType();
        }
        return 0;
    }

    public static NotificationCompat$BubbleMetadata getBubbleMetadata(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return NotificationCompat$BubbleMetadata.fromPlatform(notification.getBubbleMetadata());
        }
        return null;
    }

    public static String getCategory(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return notification.category;
        }
        return null;
    }

    public static String getChannelId(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return notification.getChannelId();
        }
        return null;
    }

    public static int getColor(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return notification.color;
        }
        return 0;
    }

    public static CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    public static CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    public static Bundle getExtras(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return notification.extras;
        }
        n11 = 16;
        if (n10 >= n11) {
            return NotificationCompatJellybean.getExtras(notification);
        }
        return null;
    }

    public static String getGroup(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 20;
        if (n10 >= n11) {
            return notification.getGroup();
        }
        n11 = 19;
        String string2 = "android.support.groupKey";
        if (n10 >= n11) {
            return notification.extras.getString(string2);
        }
        n11 = 16;
        if (n10 >= n11) {
            return NotificationCompatJellybean.getExtras(notification).getString(string2);
        }
        return null;
    }

    public static int getGroupAlertBehavior(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return notification.getGroupAlertBehavior();
        }
        return 0;
    }

    public static boolean getHighPriority(Notification notification) {
        int n10 = notification.flags & 0x80;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            notification = null;
        }
        return n10 != 0;
    }

    public static List getInvisibleActions(Notification notification) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            notification = notification.extras;
            String string2 = "android.car.EXTENSIONS";
            if ((notification = notification.getBundle(string2)) == null) {
                return arrayList;
            }
            string2 = "invisible_actions";
            if ((notification = notification.getBundle(string2)) != null) {
                string2 = null;
                for (n10 = 0; n10 < (n11 = notification.size()); ++n10) {
                    Object object = Integer.toString(n10);
                    object = NotificationCompatJellybean.getActionFromBundle(notification.getBundle((String)object));
                    arrayList.add(object);
                }
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        int n11 = 20;
        if (n10 >= n11) {
            int n12 = notification.flags & 0x100;
            if (n12 != 0) {
                bl2 = true;
            }
            return bl2;
        }
        n11 = 19;
        String string2 = "android.support.localOnly";
        if (n10 >= n11) {
            return notification.extras.getBoolean(string2);
        }
        n11 = 16;
        if (n10 >= n11) {
            return NotificationCompatJellybean.getExtras(notification).getBoolean(string2);
        }
        return false;
    }

    public static LocusIdCompat getLocusId(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        LocusIdCompat locusIdCompat = null;
        int n11 = 29;
        if (n10 >= n11 && (notification = notification.getLocusId()) != null) {
            locusIdCompat = LocusIdCompat.toLocusIdCompat((LocusId)notification);
        }
        return locusIdCompat;
    }

    public static Notification[] getNotificationArrayFromBundle(Bundle bundle, String string2) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(string2);
        int n10 = parcelableArray instanceof Notification[];
        if (n10 == 0 && parcelableArray != null) {
            int n11;
            n10 = parcelableArray.length;
            Notification[] notificationArray = new Notification[n10];
            for (int i10 = 0; i10 < (n11 = parcelableArray.length); ++i10) {
                Notification notification;
                notificationArray[i10] = notification = (Notification)parcelableArray[i10];
            }
            bundle.putParcelableArray(string2, (Parcelable[])notificationArray);
            return notificationArray;
        }
        return (Notification[])parcelableArray;
    }

    public static boolean getOngoing(Notification notification) {
        int n10 = notification.flags & 2;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            notification = null;
        }
        return n10 != 0;
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        int n10 = notification.flags & 8;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            notification = null;
        }
        return n10 != 0;
    }

    public static List getPeople(Notification object) {
        ArrayList<Object> arrayList;
        block5: {
            int n10;
            int n11;
            block4: {
                arrayList = new ArrayList<Object>();
                n11 = Build.VERSION.SDK_INT;
                n10 = 28;
                if (n11 < n10) break block4;
                object = ((Notification)object).extras;
                Object object2 = EXTRA_PEOPLE_LIST;
                if ((object = object.getParcelableArrayList((String)object2)) == null || (n11 = (int)(((ArrayList)object).isEmpty() ? 1 : 0)) != 0) break block5;
                object = ((ArrayList)object).iterator();
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object2 = Person.fromAndroidPerson((android.app.Person)object.next());
                    arrayList.add(object2);
                }
                break block5;
            }
            n10 = 19;
            if (n11 >= n10) {
                object = ((Notification)object).extras;
                String string2 = EXTRA_PEOPLE;
                if ((object = object.getStringArray(string2)) != null && (n11 = ((Object)object).length) != 0) {
                    for (Object object3 : object) {
                        Person$Builder person$Builder = new Person$Builder();
                        object3 = person$Builder.setUri((String)object3).build();
                        arrayList.add(object3);
                    }
                }
            }
        }
        return arrayList;
    }

    public static Notification getPublicVersion(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return notification.publicVersion;
        }
        return null;
    }

    public static CharSequence getSettingsText(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return notification.getSettingsText();
        }
        return null;
    }

    public static String getShortcutId(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return notification.getShortcutId();
        }
        return null;
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    public static String getSortKey(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 20;
        if (n10 >= n11) {
            return notification.getSortKey();
        }
        n11 = 19;
        String string2 = "android.support.sortKey";
        if (n10 >= n11) {
            return notification.extras.getString(string2);
        }
        n11 = 16;
        if (n10 >= n11) {
            return NotificationCompatJellybean.getExtras(notification).getString(string2);
        }
        return null;
    }

    public static CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return notification.getTimeoutAfter();
        }
        return 0L;
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            return notification.visibility;
        }
        return 0;
    }

    public static boolean isGroupSummary(Notification notification) {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = false;
        int n11 = 20;
        if (n10 >= n11) {
            int n12 = notification.flags & 0x200;
            if (n12 != 0) {
                bl2 = true;
            }
            return bl2;
        }
        n11 = 19;
        String string2 = "android.support.isGroupSummary";
        if (n10 >= n11) {
            return notification.extras.getBoolean(string2);
        }
        n11 = 16;
        if (n10 >= n11) {
            return NotificationCompatJellybean.getExtras(notification).getBoolean(string2);
        }
        return false;
    }
}

