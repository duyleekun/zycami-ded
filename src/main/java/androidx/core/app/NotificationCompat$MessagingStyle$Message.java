/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification$MessagingStyle$Message
 *  android.app.Person
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package androidx.core.app;

import android.app.Notification;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.Person;
import androidx.core.app.Person$Builder;
import java.util.ArrayList;
import java.util.List;

public final class NotificationCompat$MessagingStyle$Message {
    public static final String KEY_DATA_MIME_TYPE = "type";
    public static final String KEY_DATA_URI = "uri";
    public static final String KEY_EXTRAS_BUNDLE = "extras";
    public static final String KEY_NOTIFICATION_PERSON = "sender_person";
    public static final String KEY_PERSON = "person";
    public static final String KEY_SENDER = "sender";
    public static final String KEY_TEXT = "text";
    public static final String KEY_TIMESTAMP = "time";
    private String mDataMimeType;
    private Uri mDataUri;
    private Bundle mExtras;
    private final Person mPerson;
    private final CharSequence mText;
    private final long mTimestamp;

    public NotificationCompat$MessagingStyle$Message(CharSequence charSequence, long l10, Person person) {
        Bundle bundle;
        this.mExtras = bundle = new Bundle();
        this.mText = charSequence;
        this.mTimestamp = l10;
        this.mPerson = person;
    }

    public NotificationCompat$MessagingStyle$Message(CharSequence charSequence, long l10, CharSequence object) {
        Person$Builder person$Builder = new Person$Builder();
        object = person$Builder.setName((CharSequence)object).build();
        this(charSequence, l10, (Person)object);
    }

    public static Bundle[] getBundleArrayForMessages(List list) {
        int n10 = list.size();
        Bundle[] bundleArray = new Bundle[n10];
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            Bundle bundle;
            bundleArray[i10] = bundle = ((NotificationCompat$MessagingStyle$Message)list.get(i10)).toBundle();
        }
        return bundleArray;
    }

    public static NotificationCompat$MessagingStyle$Message getMessageFromBundle(Bundle bundle) {
        block31: {
            Object object;
            block37: {
                String string2;
                String string3;
                block36: {
                    boolean bl2;
                    String string4;
                    String string5;
                    CharSequence charSequence;
                    Object object2;
                    String string6;
                    block33: {
                        block35: {
                            block34: {
                                int n10;
                                block32: {
                                    string3 = KEY_DATA_URI;
                                    string2 = KEY_EXTRAS_BUNDLE;
                                    string6 = KEY_DATA_MIME_TYPE;
                                    object2 = KEY_SENDER;
                                    object = KEY_NOTIFICATION_PERSON;
                                    charSequence = KEY_PERSON;
                                    string5 = KEY_TIMESTAMP;
                                    string4 = KEY_TEXT;
                                    try {
                                        n10 = bundle.containsKey(string4);
                                        if (n10 == 0) break block31;
                                    }
                                    catch (ClassCastException classCastException) {}
                                    n10 = bundle.containsKey(string5);
                                    if (n10 == 0) break block31;
                                    n10 = bundle.containsKey(charSequence);
                                    if (n10 == 0) break block32;
                                    object2 = bundle.getBundle(charSequence);
                                    object2 = Person.fromBundle((Bundle)object2);
                                    break block33;
                                }
                                int n11 = bundle.containsKey((String)object);
                                if (n11 == 0) break block34;
                                n11 = Build.VERSION.SDK_INT;
                                n10 = 28;
                                if (n11 < n10) break block34;
                                object2 = bundle.getParcelable((String)object);
                                object2 = (android.app.Person)object2;
                                object2 = Person.fromAndroidPerson((android.app.Person)object2);
                                break block33;
                            }
                            boolean bl3 = bundle.containsKey((String)object2);
                            if (!bl3) break block35;
                            object = new Person$Builder();
                            object2 = bundle.getCharSequence((String)object2);
                            object2 = ((Person$Builder)object).setName((CharSequence)object2);
                            object2 = ((Person$Builder)object2).build();
                            break block33;
                        }
                        bl2 = false;
                        object2 = null;
                    }
                    charSequence = bundle.getCharSequence(string4);
                    long l10 = bundle.getLong(string5);
                    object = new NotificationCompat$MessagingStyle$Message(charSequence, l10, (Person)object2);
                    bl2 = bundle.containsKey(string6);
                    if (!bl2) break block36;
                    bl2 = bundle.containsKey(string3);
                    if (!bl2) break block36;
                    string6 = bundle.getString(string6);
                    string3 = bundle.getParcelable(string3);
                    string3 = (Uri)string3;
                    ((NotificationCompat$MessagingStyle$Message)object).setData(string6, (Uri)string3);
                }
                boolean bl4 = bundle.containsKey(string2);
                if (!bl4) break block37;
                string3 = ((NotificationCompat$MessagingStyle$Message)object).getExtras();
                bundle = bundle.getBundle(string2);
                string3.putAll(bundle);
            }
            return object;
        }
        return null;
    }

    public static List getMessagesFromBundleArray(Parcelable[] parcelableArray) {
        int n10;
        int n11 = parcelableArray.length;
        ArrayList<Parcelable> arrayList = new ArrayList<Parcelable>(n11);
        for (n11 = 0; n11 < (n10 = parcelableArray.length); ++n11) {
            Object object = parcelableArray[n11];
            n10 = object instanceof Bundle;
            if (n10 == 0 || (object = NotificationCompat$MessagingStyle$Message.getMessageFromBundle((Bundle)parcelableArray[n11])) == null) continue;
            arrayList.add((Parcelable)object);
        }
        return arrayList;
    }

    private Bundle toBundle() {
        String string2;
        Bundle bundle = new Bundle();
        Object object = this.mText;
        if (object != null) {
            string2 = KEY_TEXT;
            bundle.putCharSequence(string2, (CharSequence)object);
        }
        long l10 = this.mTimestamp;
        String string3 = KEY_TIMESTAMP;
        bundle.putLong(string3, l10);
        object = this.mPerson;
        if (object != null) {
            object = ((Person)object).getName();
            string2 = KEY_SENDER;
            bundle.putCharSequence(string2, (CharSequence)object);
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 28;
            if (n10 >= n11) {
                object = this.mPerson.toAndroidPerson();
                string2 = KEY_NOTIFICATION_PERSON;
                bundle.putParcelable(string2, (Parcelable)object);
            } else {
                object = this.mPerson.toBundle();
                string2 = KEY_PERSON;
                bundle.putBundle(string2, (Bundle)object);
            }
        }
        if ((object = this.mDataMimeType) != null) {
            string2 = KEY_DATA_MIME_TYPE;
            bundle.putString(string2, (String)object);
        }
        if ((object = this.mDataUri) != null) {
            string2 = KEY_DATA_URI;
            bundle.putParcelable(string2, (Parcelable)object);
        }
        if ((object = this.mExtras) != null) {
            string2 = KEY_EXTRAS_BUNDLE;
            bundle.putBundle(string2, (Bundle)object);
        }
        return bundle;
    }

    public String getDataMimeType() {
        return this.mDataMimeType;
    }

    public Uri getDataUri() {
        return this.mDataUri;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public Person getPerson() {
        return this.mPerson;
    }

    public CharSequence getSender() {
        Object object = this.mPerson;
        object = object == null ? null : ((Person)object).getName();
        return object;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public NotificationCompat$MessagingStyle$Message setData(String string2, Uri uri) {
        this.mDataMimeType = string2;
        this.mDataUri = uri;
        return this;
    }

    public Notification.MessagingStyle.Message toAndroidMessage() {
        Notification.MessagingStyle.Message message;
        Object object = this.getPerson();
        int n10 = Build.VERSION.SDK_INT;
        Object object2 = null;
        int n11 = 28;
        if (n10 >= n11) {
            CharSequence charSequence = this.getText();
            long l10 = this.getTimestamp();
            if (object != null) {
                object2 = ((Person)object).toAndroidPerson();
            }
            message = new Notification.MessagingStyle.Message(charSequence, l10, object2);
        } else {
            CharSequence charSequence = this.getText();
            long l11 = this.getTimestamp();
            if (object != null) {
                object2 = ((Person)object).getName();
            }
            message = new Notification.MessagingStyle.Message(charSequence, l11, (CharSequence)object2);
        }
        object = this.getDataMimeType();
        if (object != null) {
            object = this.getDataMimeType();
            object2 = this.getDataUri();
            message.setData((String)object, (Uri)object2);
        }
        return message;
    }
}

