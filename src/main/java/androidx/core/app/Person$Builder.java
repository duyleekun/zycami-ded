/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.app;

import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;

public class Person$Builder {
    public IconCompat mIcon;
    public boolean mIsBot;
    public boolean mIsImportant;
    public String mKey;
    public CharSequence mName;
    public String mUri;

    public Person$Builder() {
    }

    public Person$Builder(Person person) {
        boolean bl2;
        boolean bl3;
        Object object = person.mName;
        this.mName = object;
        this.mIcon = object = person.mIcon;
        this.mUri = object = person.mUri;
        this.mKey = object = person.mKey;
        this.mIsBot = bl3 = person.mIsBot;
        this.mIsImportant = bl2 = person.mIsImportant;
    }

    public Person build() {
        Person person = new Person(this);
        return person;
    }

    public Person$Builder setBot(boolean bl2) {
        this.mIsBot = bl2;
        return this;
    }

    public Person$Builder setIcon(IconCompat iconCompat) {
        this.mIcon = iconCompat;
        return this;
    }

    public Person$Builder setImportant(boolean bl2) {
        this.mIsImportant = bl2;
        return this;
    }

    public Person$Builder setKey(String string2) {
        this.mKey = string2;
        return this;
    }

    public Person$Builder setName(CharSequence charSequence) {
        this.mName = charSequence;
        return this;
    }

    public Person$Builder setUri(String string2) {
        this.mUri = string2;
        return this;
    }
}

