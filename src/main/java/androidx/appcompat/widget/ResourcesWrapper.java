/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.AssetFileDescriptor
 *  android.content.res.AssetManager
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.content.res.TypedArray
 *  android.content.res.XmlResourceParser
 *  android.graphics.Movie
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 */
package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

public class ResourcesWrapper
extends Resources {
    private final Resources mResources;

    public ResourcesWrapper(Resources resources) {
        AssetManager assetManager = resources.getAssets();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        super(assetManager, displayMetrics, configuration);
        this.mResources = resources;
    }

    public XmlResourceParser getAnimation(int n10) {
        return this.mResources.getAnimation(n10);
    }

    public boolean getBoolean(int n10) {
        return this.mResources.getBoolean(n10);
    }

    public int getColor(int n10) {
        return this.mResources.getColor(n10);
    }

    public ColorStateList getColorStateList(int n10) {
        return this.mResources.getColorStateList(n10);
    }

    public Configuration getConfiguration() {
        return this.mResources.getConfiguration();
    }

    public float getDimension(int n10) {
        return this.mResources.getDimension(n10);
    }

    public int getDimensionPixelOffset(int n10) {
        return this.mResources.getDimensionPixelOffset(n10);
    }

    public int getDimensionPixelSize(int n10) {
        return this.mResources.getDimensionPixelSize(n10);
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.mResources.getDisplayMetrics();
    }

    public Drawable getDrawable(int n10) {
        return this.mResources.getDrawable(n10);
    }

    public Drawable getDrawable(int n10, Resources.Theme theme) {
        return this.mResources.getDrawable(n10, theme);
    }

    public Drawable getDrawableForDensity(int n10, int n11) {
        return this.mResources.getDrawableForDensity(n10, n11);
    }

    public Drawable getDrawableForDensity(int n10, int n11, Resources.Theme theme) {
        return this.mResources.getDrawableForDensity(n10, n11, theme);
    }

    public float getFraction(int n10, int n11, int n12) {
        return this.mResources.getFraction(n10, n11, n12);
    }

    public int getIdentifier(String string2, String string3, String string4) {
        return this.mResources.getIdentifier(string2, string3, string4);
    }

    public int[] getIntArray(int n10) {
        return this.mResources.getIntArray(n10);
    }

    public int getInteger(int n10) {
        return this.mResources.getInteger(n10);
    }

    public XmlResourceParser getLayout(int n10) {
        return this.mResources.getLayout(n10);
    }

    public Movie getMovie(int n10) {
        return this.mResources.getMovie(n10);
    }

    public String getQuantityString(int n10, int n11) {
        return this.mResources.getQuantityString(n10, n11);
    }

    public String getQuantityString(int n10, int n11, Object ... objectArray) {
        return this.mResources.getQuantityString(n10, n11, objectArray);
    }

    public CharSequence getQuantityText(int n10, int n11) {
        return this.mResources.getQuantityText(n10, n11);
    }

    public String getResourceEntryName(int n10) {
        return this.mResources.getResourceEntryName(n10);
    }

    public String getResourceName(int n10) {
        return this.mResources.getResourceName(n10);
    }

    public String getResourcePackageName(int n10) {
        return this.mResources.getResourcePackageName(n10);
    }

    public String getResourceTypeName(int n10) {
        return this.mResources.getResourceTypeName(n10);
    }

    public String getString(int n10) {
        return this.mResources.getString(n10);
    }

    public String getString(int n10, Object ... objectArray) {
        return this.mResources.getString(n10, objectArray);
    }

    public String[] getStringArray(int n10) {
        return this.mResources.getStringArray(n10);
    }

    public CharSequence getText(int n10) {
        return this.mResources.getText(n10);
    }

    public CharSequence getText(int n10, CharSequence charSequence) {
        return this.mResources.getText(n10, charSequence);
    }

    public CharSequence[] getTextArray(int n10) {
        return this.mResources.getTextArray(n10);
    }

    public void getValue(int n10, TypedValue typedValue, boolean bl2) {
        this.mResources.getValue(n10, typedValue, bl2);
    }

    public void getValue(String string2, TypedValue typedValue, boolean bl2) {
        this.mResources.getValue(string2, typedValue, bl2);
    }

    public void getValueForDensity(int n10, int n11, TypedValue typedValue, boolean bl2) {
        this.mResources.getValueForDensity(n10, n11, typedValue, bl2);
    }

    public XmlResourceParser getXml(int n10) {
        return this.mResources.getXml(n10);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] nArray) {
        return this.mResources.obtainAttributes(attributeSet, nArray);
    }

    public TypedArray obtainTypedArray(int n10) {
        return this.mResources.obtainTypedArray(n10);
    }

    public InputStream openRawResource(int n10) {
        return this.mResources.openRawResource(n10);
    }

    public InputStream openRawResource(int n10, TypedValue typedValue) {
        return this.mResources.openRawResource(n10, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int n10) {
        return this.mResources.openRawResourceFd(n10);
    }

    public void parseBundleExtra(String string2, AttributeSet attributeSet, Bundle bundle) {
        this.mResources.parseBundleExtra(string2, attributeSet, bundle);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.mResources.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        Resources resources = this.mResources;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics);
        }
    }
}

