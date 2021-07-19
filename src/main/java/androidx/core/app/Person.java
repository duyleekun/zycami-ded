/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Person
 *  android.app.Person$Builder
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.os.PersistableBundle
 */
package androidx.core.app;

import android.app.Person;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.core.app.Person$Builder;
import androidx.core.graphics.drawable.IconCompat;

public class Person {
    private static final String ICON_KEY = "icon";
    private static final String IS_BOT_KEY = "isBot";
    private static final String IS_IMPORTANT_KEY = "isImportant";
    private static final String KEY_KEY = "key";
    private static final String NAME_KEY = "name";
    private static final String URI_KEY = "uri";
    public IconCompat mIcon;
    public boolean mIsBot;
    public boolean mIsImportant;
    public String mKey;
    public CharSequence mName;
    public String mUri;

    public Person(Person$Builder person$Builder) {
        boolean bl2;
        boolean bl3;
        Object object = person$Builder.mName;
        this.mName = object;
        this.mIcon = object = person$Builder.mIcon;
        this.mUri = object = person$Builder.mUri;
        this.mKey = object = person$Builder.mKey;
        this.mIsBot = bl3 = person$Builder.mIsBot;
        this.mIsImportant = bl2 = person$Builder.mIsImportant;
    }

    public static Person fromAndroidPerson(android.app.Person person) {
        boolean bl2;
        Person$Builder person$Builder = new Person$Builder();
        Object object = person.getName();
        person$Builder = person$Builder.setName((CharSequence)object);
        object = person.getIcon();
        if (object != null) {
            object = IconCompat.createFromIcon(person.getIcon());
        } else {
            bl2 = false;
            object = null;
        }
        person$Builder = person$Builder.setIcon((IconCompat)object);
        object = person.getUri();
        person$Builder = person$Builder.setUri((String)object);
        object = person.getKey();
        person$Builder = person$Builder.setKey((String)object);
        bl2 = person.isBot();
        person$Builder = person$Builder.setBot(bl2);
        boolean bl3 = person.isImportant();
        return person$Builder.setImportant(bl3).build();
    }

    public static Person fromBundle(Bundle bundle) {
        Object object = bundle.getBundle(ICON_KEY);
        Object object2 = new Person$Builder();
        CharSequence charSequence = bundle.getCharSequence(NAME_KEY);
        object2 = ((Person$Builder)object2).setName(charSequence);
        object = object != null ? IconCompat.createFromBundle((Bundle)object) : null;
        object = ((Person$Builder)object2).setIcon((IconCompat)object);
        object2 = bundle.getString(URI_KEY);
        object = ((Person$Builder)object).setUri((String)object2);
        object2 = bundle.getString(KEY_KEY);
        object = ((Person$Builder)object).setKey((String)object2);
        boolean bl2 = bundle.getBoolean(IS_BOT_KEY);
        object = ((Person$Builder)object).setBot(bl2);
        boolean bl3 = bundle.getBoolean(IS_IMPORTANT_KEY);
        return ((Person$Builder)object).setImportant(bl3).build();
    }

    public static Person fromPersistableBundle(PersistableBundle persistableBundle) {
        Person$Builder person$Builder = new Person$Builder();
        String string2 = persistableBundle.getString(NAME_KEY);
        person$Builder = person$Builder.setName(string2);
        string2 = persistableBundle.getString(URI_KEY);
        person$Builder = person$Builder.setUri(string2);
        string2 = persistableBundle.getString(KEY_KEY);
        person$Builder = person$Builder.setKey(string2);
        boolean bl2 = persistableBundle.getBoolean(IS_BOT_KEY);
        person$Builder = person$Builder.setBot(bl2);
        boolean bl3 = persistableBundle.getBoolean(IS_IMPORTANT_KEY);
        return person$Builder.setImportant(bl3).build();
    }

    public IconCompat getIcon() {
        return this.mIcon;
    }

    public String getKey() {
        return this.mKey;
    }

    public CharSequence getName() {
        return this.mName;
    }

    public String getUri() {
        return this.mUri;
    }

    public boolean isBot() {
        return this.mIsBot;
    }

    public boolean isImportant() {
        return this.mIsImportant;
    }

    public String resolveToLegacyUri() {
        CharSequence charSequence = this.mUri;
        if (charSequence != null) {
            return charSequence;
        }
        charSequence = this.mName;
        if (charSequence != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("name:");
            CharSequence charSequence2 = this.mName;
            ((StringBuilder)charSequence).append((Object)charSequence2);
            return ((StringBuilder)charSequence).toString();
        }
        return "";
    }

    public android.app.Person toAndroidPerson() {
        boolean bl2;
        Person.Builder builder = new Person.Builder();
        Object object = this.getName();
        builder = builder.setName((CharSequence)object);
        object = this.getIcon();
        if (object != null) {
            object = this.getIcon().toIcon();
        } else {
            bl2 = false;
            object = null;
        }
        builder = builder.setIcon((Icon)object);
        object = this.getUri();
        builder = builder.setUri((String)object);
        object = this.getKey();
        builder = builder.setKey((String)object);
        bl2 = this.isBot();
        builder = builder.setBot(bl2);
        bl2 = this.isImportant();
        return builder.setImportant(bl2).build();
    }

    public Person$Builder toBuilder() {
        Person$Builder person$Builder = new Person$Builder(this);
        return person$Builder;
    }

    public Bundle toBundle() {
        boolean bl2;
        Bundle bundle = new Bundle();
        Object object = this.mName;
        String string2 = NAME_KEY;
        bundle.putCharSequence(string2, (CharSequence)object);
        object = this.mIcon;
        if (object != null) {
            object = ((IconCompat)object).toBundle();
        } else {
            bl2 = false;
            object = null;
        }
        bundle.putBundle(ICON_KEY, (Bundle)object);
        object = this.mUri;
        bundle.putString(URI_KEY, (String)object);
        object = this.mKey;
        bundle.putString(KEY_KEY, (String)object);
        bl2 = this.mIsBot;
        bundle.putBoolean(IS_BOT_KEY, bl2);
        bl2 = this.mIsImportant;
        bundle.putBoolean(IS_IMPORTANT_KEY, bl2);
        return bundle;
    }

    public PersistableBundle toPersistableBundle() {
        boolean bl2;
        PersistableBundle persistableBundle = new PersistableBundle();
        CharSequence charSequence = this.mName;
        if (charSequence != null) {
            charSequence = charSequence.toString();
        } else {
            bl2 = false;
            charSequence = null;
        }
        persistableBundle.putString(NAME_KEY, (String)charSequence);
        charSequence = this.mUri;
        persistableBundle.putString(URI_KEY, (String)charSequence);
        charSequence = this.mKey;
        persistableBundle.putString(KEY_KEY, (String)charSequence);
        bl2 = this.mIsBot;
        persistableBundle.putBoolean(IS_BOT_KEY, bl2);
        bl2 = this.mIsImportant;
        persistableBundle.putBoolean(IS_IMPORTANT_KEY, bl2);
        return persistableBundle;
    }
}

