/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 */
package com.huawei.hms.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

public class SafeIntent
extends Intent {
    public SafeIntent(Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        super(intent);
    }

    public String getAction() {
        try {
            return super.getAction();
        }
        catch (Exception exception) {
            return "";
        }
    }

    public boolean[] getBooleanArrayExtra(String string2) {
        try {
            return super.getBooleanArrayExtra(string2);
        }
        catch (Exception exception) {
            return new boolean[0];
        }
    }

    public boolean getBooleanExtra(String string2, boolean bl2) {
        try {
            return super.getBooleanExtra(string2, bl2);
        }
        catch (Exception exception) {
            return bl2;
        }
    }

    public Bundle getBundleExtra(String string2) {
        try {
            return super.getBundleExtra(string2);
        }
        catch (Exception exception) {
            string2 = new Bundle();
            return string2;
        }
    }

    public byte[] getByteArrayExtra(String string2) {
        try {
            return super.getByteArrayExtra(string2);
        }
        catch (Exception exception) {
            return new byte[0];
        }
    }

    public byte getByteExtra(String string2, byte by2) {
        try {
            return super.getByteExtra(string2, by2);
        }
        catch (Exception exception) {
            return by2;
        }
    }

    public char[] getCharArrayExtra(String string2) {
        try {
            return super.getCharArrayExtra(string2);
        }
        catch (Exception exception) {
            return new char[0];
        }
    }

    public char getCharExtra(String string2, char c10) {
        try {
            return super.getCharExtra(string2, c10);
        }
        catch (Exception exception) {
            return c10;
        }
    }

    public CharSequence[] getCharSequenceArrayExtra(String string2) {
        try {
            return super.getCharSequenceArrayExtra(string2);
        }
        catch (Exception exception) {
            return new CharSequence[0];
        }
    }

    public ArrayList getCharSequenceArrayListExtra(String arrayList) {
        try {
            return super.getCharSequenceArrayListExtra((String)((Object)arrayList));
        }
        catch (Exception exception) {
            arrayList = new ArrayList();
            return arrayList;
        }
    }

    public CharSequence getCharSequenceExtra(String string2) {
        try {
            return super.getCharSequenceExtra(string2);
        }
        catch (Exception exception) {
            return "";
        }
    }

    public double[] getDoubleArrayExtra(String string2) {
        try {
            return super.getDoubleArrayExtra(string2);
        }
        catch (Exception exception) {
            return new double[0];
        }
    }

    public double getDoubleExtra(String string2, double d10) {
        try {
            return super.getDoubleExtra(string2, d10);
        }
        catch (Exception exception) {
            return d10;
        }
    }

    public Bundle getExtras() {
        try {
            return super.getExtras();
        }
        catch (Exception exception) {
            Bundle bundle = new Bundle();
            return bundle;
        }
    }

    public float[] getFloatArrayExtra(String string2) {
        try {
            return super.getFloatArrayExtra(string2);
        }
        catch (Exception exception) {
            return new float[0];
        }
    }

    public float getFloatExtra(String string2, float f10) {
        try {
            return super.getFloatExtra(string2, f10);
        }
        catch (Exception exception) {
            return f10;
        }
    }

    public int[] getIntArrayExtra(String string2) {
        try {
            return super.getIntArrayExtra(string2);
        }
        catch (Exception exception) {
            return new int[0];
        }
    }

    public int getIntExtra(String string2, int n10) {
        try {
            return super.getIntExtra(string2, n10);
        }
        catch (Exception exception) {
            return n10;
        }
    }

    public ArrayList getIntegerArrayListExtra(String arrayList) {
        try {
            return super.getIntegerArrayListExtra((String)((Object)arrayList));
        }
        catch (Exception exception) {
            arrayList = new ArrayList();
            return arrayList;
        }
    }

    public long[] getLongArrayExtra(String string2) {
        try {
            return super.getLongArrayExtra(string2);
        }
        catch (Exception exception) {
            return new long[0];
        }
    }

    public long getLongExtra(String string2, long l10) {
        try {
            return super.getLongExtra(string2, l10);
        }
        catch (Exception exception) {
            return l10;
        }
    }

    public Parcelable[] getParcelableArrayExtra(String string2) {
        try {
            return super.getParcelableArrayExtra(string2);
        }
        catch (Exception exception) {
            return new Parcelable[0];
        }
    }

    public ArrayList getParcelableArrayListExtra(String string2) {
        try {
            return super.getParcelableArrayListExtra(string2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public Parcelable getParcelableExtra(String string2) {
        try {
            return super.getParcelableExtra(string2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public Serializable getSerializableExtra(String string2) {
        try {
            return super.getSerializableExtra(string2);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public short[] getShortArrayExtra(String string2) {
        try {
            return super.getShortArrayExtra(string2);
        }
        catch (Exception exception) {
            return new short[0];
        }
    }

    public short getShortExtra(String string2, short s10) {
        try {
            return super.getShortExtra(string2, s10);
        }
        catch (Exception exception) {
            return s10;
        }
    }

    public String[] getStringArrayExtra(String string2) {
        try {
            return super.getStringArrayExtra(string2);
        }
        catch (Exception exception) {
            return new String[0];
        }
    }

    public ArrayList getStringArrayListExtra(String arrayList) {
        try {
            return super.getStringArrayListExtra((String)((Object)arrayList));
        }
        catch (Exception exception) {
            arrayList = new ArrayList();
            return arrayList;
        }
    }

    public String getStringExtra(String string2) {
        try {
            return super.getStringExtra(string2);
        }
        catch (Exception exception) {
            return "";
        }
    }

    public boolean hasExtra(String string2) {
        try {
            return super.hasExtra(string2);
        }
        catch (Exception exception) {
            return false;
        }
    }
}

