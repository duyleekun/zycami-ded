/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.app.Notification$BigTextStyle
 *  android.app.Notification$Builder
 *  android.app.Notification$MessagingStyle
 *  android.app.Notification$MessagingStyle$Message
 *  android.app.Person
 *  android.content.pm.ApplicationInfo
 *  android.content.res.ColorStateList
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.text.style.TextAppearanceSpan
 */
package androidx.core.app;

import android.app.Notification;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;
import androidx.core.app.NotificationCompat$Builder;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.app.NotificationCompat$Style;
import androidx.core.app.Person;
import androidx.core.app.Person$Builder;
import androidx.core.text.BidiFormatter;
import java.util.ArrayList;
import java.util.List;

public class NotificationCompat$MessagingStyle
extends NotificationCompat$Style {
    public static final int MAXIMUM_RETAINED_MESSAGES = 25;
    private static final String TEMPLATE_CLASS_NAME = "androidx.core.app.NotificationCompat$MessagingStyle";
    private CharSequence mConversationTitle;
    private final List mHistoricMessages;
    private Boolean mIsGroupConversation;
    private final List mMessages;
    private Person mUser;

    public NotificationCompat$MessagingStyle() {
        ArrayList arrayList;
        this.mMessages = arrayList = new ArrayList();
        this.mHistoricMessages = arrayList = new ArrayList();
    }

    public NotificationCompat$MessagingStyle(Person object) {
        Object object2 = new ArrayList();
        this.mMessages = object2;
        object2 = new ArrayList();
        this.mHistoricMessages = object2;
        object2 = ((Person)object).getName();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (!bl2) {
            this.mUser = object;
            return;
        }
        object = new IllegalArgumentException("User's name must not be empty.");
        throw object;
    }

    public NotificationCompat$MessagingStyle(CharSequence object) {
        Object object2 = new ArrayList();
        this.mMessages = object2;
        object2 = new ArrayList();
        this.mHistoricMessages = object2;
        object2 = new Person$Builder();
        this.mUser = object = ((Person$Builder)object2).setName((CharSequence)object).build();
    }

    public static NotificationCompat$MessagingStyle extractMessagingStyleFromNotification(Notification object) {
        boolean bl2 = (object = NotificationCompat$Style.extractStyleFromNotification(object)) instanceof NotificationCompat$MessagingStyle;
        if (bl2) {
            return (NotificationCompat$MessagingStyle)object;
        }
        return null;
    }

    private NotificationCompat$MessagingStyle$Message findLatestIncomingMessage() {
        int n10;
        List list = this.mMessages;
        for (n10 = list.size() + -1; n10 >= 0; n10 += -1) {
            boolean bl2;
            NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = (NotificationCompat$MessagingStyle$Message)this.mMessages.get(n10);
            Object object = notificationCompat$MessagingStyle$Message.getPerson();
            if (object == null || (bl2 = TextUtils.isEmpty((CharSequence)(object = notificationCompat$MessagingStyle$Message.getPerson().getName())))) continue;
            return notificationCompat$MessagingStyle$Message;
        }
        list = this.mMessages;
        n10 = (int)(list.isEmpty() ? 1 : 0);
        if (n10 == 0) {
            list = this.mMessages;
            int n11 = list.size() + -1;
            return (NotificationCompat$MessagingStyle$Message)list.get(n11);
        }
        return null;
    }

    private boolean hasMessagesWithoutSender() {
        List list = this.mMessages;
        int n10 = list.size();
        int n11 = 1;
        n10 -= n11;
        while (n10 >= 0) {
            Object object = (NotificationCompat$MessagingStyle$Message)this.mMessages.get(n10);
            Person person = ((NotificationCompat$MessagingStyle$Message)object).getPerson();
            if (person != null && (object = ((NotificationCompat$MessagingStyle$Message)object).getPerson().getName()) == null) {
                return n11 != 0;
            }
            n10 += -1;
        }
        return false;
    }

    private TextAppearanceSpan makeFontColorSpan(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, colorStateList, null);
        return textAppearanceSpan;
    }

    private CharSequence makeMessageLine(NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message) {
        Object object;
        Object object2 = BidiFormatter.getInstance();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        n11 = n10 != 0 ? -16777216 : -1;
        Object object3 = notificationCompat$MessagingStyle$Message.getPerson();
        CharSequence charSequence = "";
        object3 = object3 == null ? charSequence : notificationCompat$MessagingStyle$Message.getPerson().getName();
        int n12 = TextUtils.isEmpty((CharSequence)object3);
        if (n12 != 0) {
            object3 = this.mUser.getName();
            if (n10 != 0 && (n10 = ((NotificationCompat$Builder)(object = this.mBuilder)).getColor()) != 0) {
                object = this.mBuilder;
                n11 = n10 = ((NotificationCompat$Builder)object).getColor();
            }
        }
        object = ((BidiFormatter)object2).unicodeWrap((CharSequence)object3);
        spannableStringBuilder.append((CharSequence)object);
        TextAppearanceSpan textAppearanceSpan = this.makeFontColorSpan(n11);
        int n13 = spannableStringBuilder.length();
        n10 = object.length();
        n13 -= n10;
        n10 = spannableStringBuilder.length();
        n12 = 33;
        spannableStringBuilder.setSpan((Object)textAppearanceSpan, n13, n10, n12);
        object = notificationCompat$MessagingStyle$Message.getText();
        if (object != null) {
            charSequence = notificationCompat$MessagingStyle$Message.getText();
        }
        notificationCompat$MessagingStyle$Message = spannableStringBuilder.append((CharSequence)"  ");
        object2 = ((BidiFormatter)object2).unicodeWrap(charSequence);
        notificationCompat$MessagingStyle$Message.append((CharSequence)object2);
        return spannableStringBuilder;
    }

    public void addCompatExtras(Bundle bundle) {
        boolean bl2;
        super.addCompatExtras(bundle);
        Object object = this.mUser.getName();
        bundle.putCharSequence("android.selfDisplayName", (CharSequence)object);
        object = this.mUser.toBundle();
        bundle.putBundle("android.messagingStyleUser", (Bundle)object);
        object = this.mConversationTitle;
        String string2 = "android.hiddenConversationTitle";
        bundle.putCharSequence(string2, (CharSequence)object);
        object = this.mConversationTitle;
        if (object != null && (bl2 = ((Boolean)(object = this.mIsGroupConversation)).booleanValue())) {
            object = this.mConversationTitle;
            string2 = "android.conversationTitle";
            bundle.putCharSequence(string2, (CharSequence)object);
        }
        if (!(bl2 = (object = this.mMessages).isEmpty())) {
            object = NotificationCompat$MessagingStyle$Message.getBundleArrayForMessages(this.mMessages);
            string2 = "android.messages";
            bundle.putParcelableArray(string2, (Parcelable[])object);
        }
        if (!(bl2 = (object = this.mHistoricMessages).isEmpty())) {
            object = NotificationCompat$MessagingStyle$Message.getBundleArrayForMessages(this.mHistoricMessages);
            string2 = "android.messages.historic";
            bundle.putParcelableArray(string2, (Parcelable[])object);
        }
        if ((object = this.mIsGroupConversation) != null) {
            bl2 = (Boolean)object;
            string2 = "android.isGroupConversation";
            bundle.putBoolean(string2, bl2);
        }
    }

    public NotificationCompat$MessagingStyle addHistoricMessage(NotificationCompat$MessagingStyle$Message object) {
        if (object != null) {
            List list = this.mHistoricMessages;
            list.add(object);
            object = this.mHistoricMessages;
            int n10 = object.size();
            int n11 = 25;
            if (n10 > n11) {
                object = this.mHistoricMessages;
                n11 = 0;
                list = null;
                object.remove(0);
            }
        }
        return this;
    }

    public NotificationCompat$MessagingStyle addMessage(NotificationCompat$MessagingStyle$Message object) {
        if (object != null) {
            List list = this.mMessages;
            list.add(object);
            object = this.mMessages;
            int n10 = object.size();
            int n11 = 25;
            if (n10 > n11) {
                object = this.mMessages;
                n11 = 0;
                list = null;
                object.remove(0);
            }
        }
        return this;
    }

    public NotificationCompat$MessagingStyle addMessage(CharSequence charSequence, long l10, Person person) {
        NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = new NotificationCompat$MessagingStyle$Message(charSequence, l10, person);
        this.addMessage(notificationCompat$MessagingStyle$Message);
        return this;
    }

    public NotificationCompat$MessagingStyle addMessage(CharSequence object, long l10, CharSequence object2) {
        List list = this.mMessages;
        Person$Builder person$Builder = new Person$Builder();
        object2 = person$Builder.setName((CharSequence)object2).build();
        NotificationCompat$MessagingStyle$Message notificationCompat$MessagingStyle$Message = new NotificationCompat$MessagingStyle$Message((CharSequence)object, l10, (Person)object2);
        list.add(notificationCompat$MessagingStyle$Message);
        object = this.mMessages;
        int n10 = object.size();
        int n11 = 25;
        if (n10 > n11) {
            object = this.mMessages;
            n11 = 0;
            object.remove(0);
        }
        return this;
    }

    public void apply(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = this.isGroupConversation();
        this.setGroupConversation(n11 != 0);
        n11 = 24;
        if (n10 >= n11) {
            Notification.MessagingStyle.Message message;
            boolean bl2;
            Notification.MessagingStyle messagingStyle;
            Object object;
            n11 = 28;
            if (n10 >= n11) {
                object = this.mUser.toAndroidPerson();
                messagingStyle = new Notification.MessagingStyle((android.app.Person)object);
            } else {
                object = this.mUser.getName();
                messagingStyle = new Notification.MessagingStyle((CharSequence)object);
            }
            object = this.mMessages.iterator();
            while (bl2 = object.hasNext()) {
                message = ((NotificationCompat$MessagingStyle$Message)object.next()).toAndroidMessage();
                messagingStyle.addMessage(message);
            }
            int n12 = 26;
            if (n10 >= n12) {
                object = this.mHistoricMessages.iterator();
                while (bl2 = object.hasNext()) {
                    message = ((NotificationCompat$MessagingStyle$Message)object.next()).toAndroidMessage();
                    messagingStyle.addHistoricMessage(message);
                }
            }
            if ((n12 = (int)(((Boolean)(object = this.mIsGroupConversation)).booleanValue() ? 1 : 0)) != 0 || n10 >= n11) {
                object = this.mConversationTitle;
                messagingStyle.setConversationTitle((CharSequence)object);
            }
            if (n10 >= n11) {
                Boolean bl3 = this.mIsGroupConversation;
                n10 = (int)(bl3.booleanValue() ? 1 : 0);
                messagingStyle.setGroupConversation(n10 != 0);
            }
            notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
            messagingStyle.setBuilder((Notification.Builder)notificationBuilderWithBuilderAccessor);
        } else {
            CharSequence charSequence;
            boolean bl4;
            Object object = this.findLatestIncomingMessage();
            Object object2 = this.mConversationTitle;
            if (object2 != null && (bl4 = ((Boolean)(object2 = this.mIsGroupConversation)).booleanValue())) {
                object2 = notificationBuilderWithBuilderAccessor.getBuilder();
                charSequence = this.mConversationTitle;
                object2.setContentTitle(charSequence);
            } else if (object != null) {
                object2 = notificationBuilderWithBuilderAccessor.getBuilder();
                charSequence = "";
                object2.setContentTitle(charSequence);
                object2 = ((NotificationCompat$MessagingStyle$Message)object).getPerson();
                if (object2 != null) {
                    object2 = notificationBuilderWithBuilderAccessor.getBuilder();
                    charSequence = ((NotificationCompat$MessagingStyle$Message)object).getPerson().getName();
                    object2.setContentTitle(charSequence);
                }
            }
            if (object != null) {
                object2 = notificationBuilderWithBuilderAccessor.getBuilder();
                charSequence = this.mConversationTitle;
                object = charSequence != null ? this.makeMessageLine((NotificationCompat$MessagingStyle$Message)object) : ((NotificationCompat$MessagingStyle$Message)object).getText();
                object2.setContentText((CharSequence)object);
            }
            if (n10 >= (n11 = 16)) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                object = this.mConversationTitle;
                bl4 = false;
                object2 = null;
                int n13 = 1;
                if (object == null && (n11 = (int)(this.hasMessagesWithoutSender() ? 1 : 0)) == 0) {
                    n11 = 0;
                    object = null;
                } else {
                    n11 = n13;
                }
                List list = this.mMessages;
                for (int i10 = list.size() - n13; i10 >= 0; i10 += -1) {
                    Object object3 = (NotificationCompat$MessagingStyle$Message)this.mMessages.get(i10);
                    object3 = n11 != 0 ? this.makeMessageLine((NotificationCompat$MessagingStyle$Message)object3) : ((NotificationCompat$MessagingStyle$Message)object3).getText();
                    Object object4 = this.mMessages;
                    int n14 = object4.size() - n13;
                    if (i10 != n14) {
                        object4 = "\n";
                        spannableStringBuilder.insert(0, (CharSequence)object4);
                    }
                    spannableStringBuilder.insert(0, (CharSequence)object3);
                }
                notificationBuilderWithBuilderAccessor = notificationBuilderWithBuilderAccessor.getBuilder();
                object = new Notification.BigTextStyle((Notification.Builder)notificationBuilderWithBuilderAccessor);
                notificationBuilderWithBuilderAccessor = object.setBigContentTitle(null);
                notificationBuilderWithBuilderAccessor.bigText((CharSequence)spannableStringBuilder);
            }
        }
    }

    public void clearCompatExtraKeys(Bundle bundle) {
        super.clearCompatExtraKeys(bundle);
        bundle.remove("android.messagingStyleUser");
        bundle.remove("android.selfDisplayName");
        bundle.remove("android.conversationTitle");
        bundle.remove("android.hiddenConversationTitle");
        bundle.remove("android.messages");
        bundle.remove("android.messages.historic");
        bundle.remove("android.isGroupConversation");
    }

    public String getClassName() {
        return TEMPLATE_CLASS_NAME;
    }

    public CharSequence getConversationTitle() {
        return this.mConversationTitle;
    }

    public List getHistoricMessages() {
        return this.mHistoricMessages;
    }

    public List getMessages() {
        return this.mMessages;
    }

    public Person getUser() {
        return this.mUser;
    }

    public CharSequence getUserDisplayName() {
        return this.mUser.getName();
    }

    public boolean isGroupConversation() {
        Object object = this.mBuilder;
        boolean bl2 = false;
        if (object != null) {
            object = ((NotificationCompat$Builder)object).mContext.getApplicationInfo();
            int n10 = ((ApplicationInfo)object).targetSdkVersion;
            int n11 = 28;
            if (n10 < n11 && (object = this.mIsGroupConversation) == null) {
                object = this.mConversationTitle;
                if (object != null) {
                    bl2 = true;
                }
                return bl2;
            }
        }
        if ((object = this.mIsGroupConversation) != null) {
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public void restoreFromCompatExtras(Bundle object) {
        Object object2;
        super.restoreFromCompatExtras((Bundle)object);
        this.mMessages.clear();
        Object object3 = "android.messagingStyleUser";
        boolean bl2 = object.containsKey((String)object3);
        if (bl2) {
            object3 = Person.fromBundle(object.getBundle((String)object3));
            this.mUser = object3;
        } else {
            object3 = new Person$Builder();
            object2 = object.getString("android.selfDisplayName");
            object3 = object3.setName((CharSequence)object2).build();
            this.mUser = object3;
        }
        object3 = object.getCharSequence("android.conversationTitle");
        this.mConversationTitle = object3;
        if (object3 == null) {
            this.mConversationTitle = object3 = object.getCharSequence("android.hiddenConversationTitle");
        }
        if ((object3 = object.getParcelableArray("android.messages")) != null) {
            object2 = this.mMessages;
            object3 = NotificationCompat$MessagingStyle$Message.getMessagesFromBundleArray(object3);
            object2.addAll(object3);
        }
        if ((object3 = object.getParcelableArray("android.messages.historic")) != null) {
            object2 = this.mHistoricMessages;
            object3 = NotificationCompat$MessagingStyle$Message.getMessagesFromBundleArray(object3);
            object2.addAll(object3);
        }
        if (bl2 = object.containsKey((String)(object3 = "android.isGroupConversation"))) {
            boolean bl3 = object.getBoolean((String)object3);
            object = bl3;
            this.mIsGroupConversation = object;
        }
    }

    public NotificationCompat$MessagingStyle setConversationTitle(CharSequence charSequence) {
        this.mConversationTitle = charSequence;
        return this;
    }

    public NotificationCompat$MessagingStyle setGroupConversation(boolean bl2) {
        Boolean bl3;
        this.mIsGroupConversation = bl3 = Boolean.valueOf(bl2);
        return this;
    }
}

