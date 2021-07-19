/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.util.AttributeSet
 */
package androidx.navigation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigator;
import androidx.navigation.NavigatorProvider;
import androidx.navigation.R$styleable;

public class ActivityNavigator$Destination
extends NavDestination {
    private String mDataPattern;
    private Intent mIntent;

    public ActivityNavigator$Destination(Navigator navigator) {
        super(navigator);
    }

    public ActivityNavigator$Destination(NavigatorProvider object) {
        object = ((NavigatorProvider)object).getNavigator(ActivityNavigator.class);
        this((Navigator)object);
    }

    public final String getAction() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return null;
        }
        return intent.getAction();
    }

    public final ComponentName getComponent() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return null;
        }
        return intent.getComponent();
    }

    public final Uri getData() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return null;
        }
        return intent.getData();
    }

    public final String getDataPattern() {
        return this.mDataPattern;
    }

    public final Intent getIntent() {
        return this.mIntent;
    }

    public final String getTargetPackage() {
        Intent intent = this.mIntent;
        if (intent == null) {
            return null;
        }
        return intent.getPackage();
    }

    public void onInflate(Context object, AttributeSet attributeSet) {
        String string2;
        super.onInflate((Context)object, attributeSet);
        Object object2 = object.getResources();
        Object object3 = R$styleable.ActivityNavigator;
        attributeSet = object2.obtainAttributes(attributeSet, (int[])object3);
        int n10 = R$styleable.ActivityNavigator_targetPackage;
        object2 = attributeSet.getString(n10);
        if (object2 != null) {
            object3 = object.getPackageName();
            string2 = "${applicationId}";
            object2 = ((String)object2).replace(string2, (CharSequence)object3);
        }
        this.setTargetPackage((String)object2);
        n10 = R$styleable.ActivityNavigator_android_name;
        object2 = attributeSet.getString(n10);
        if (object2 != null) {
            char c10;
            object3 = null;
            char c11 = ((String)object2).charAt(0);
            if (c11 == (c10 = '.')) {
                object3 = new StringBuilder;
                ((StringBuilder)object3)();
                string2 = object.getPackageName();
                ((StringBuilder)object3).append(string2);
                ((StringBuilder)object3).append((String)object2);
                object2 = ((StringBuilder)object3).toString();
            }
            object3 = new ComponentName;
            object3(object, (String)object2);
            this.setComponentName((ComponentName)object3);
        }
        int n11 = R$styleable.ActivityNavigator_action;
        object = attributeSet.getString(n11);
        this.setAction((String)object);
        n11 = R$styleable.ActivityNavigator_data;
        object = attributeSet.getString(n11);
        if (object != null) {
            object = Uri.parse((String)object);
            this.setData((Uri)object);
        }
        n11 = R$styleable.ActivityNavigator_dataPattern;
        object = attributeSet.getString(n11);
        this.setDataPattern((String)object);
        attributeSet.recycle();
    }

    public final ActivityNavigator$Destination setAction(String string2) {
        Intent intent = this.mIntent;
        if (intent == null) {
            this.mIntent = intent = new Intent();
        }
        this.mIntent.setAction(string2);
        return this;
    }

    public final ActivityNavigator$Destination setComponentName(ComponentName componentName) {
        Intent intent = this.mIntent;
        if (intent == null) {
            this.mIntent = intent = new Intent();
        }
        this.mIntent.setComponent(componentName);
        return this;
    }

    public final ActivityNavigator$Destination setData(Uri uri) {
        Intent intent = this.mIntent;
        if (intent == null) {
            this.mIntent = intent = new Intent();
        }
        this.mIntent.setData(uri);
        return this;
    }

    public final ActivityNavigator$Destination setDataPattern(String string2) {
        this.mDataPattern = string2;
        return this;
    }

    public final ActivityNavigator$Destination setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public final ActivityNavigator$Destination setTargetPackage(String string2) {
        Intent intent = this.mIntent;
        if (intent == null) {
            this.mIntent = intent = new Intent();
        }
        this.mIntent.setPackage(string2);
        return this;
    }

    public boolean supportsActions() {
        return false;
    }

    public String toString() {
        Object object = this.getComponent();
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = super.toString();
        stringBuilder.append(string2);
        if (object != null) {
            string2 = " class=";
            stringBuilder.append(string2);
            object = object.getClassName();
            stringBuilder.append((String)object);
        } else {
            object = this.getAction();
            if (object != null) {
                string2 = " action=";
                stringBuilder.append(string2);
                stringBuilder.append((String)object);
            }
        }
        return stringBuilder.toString();
    }
}

