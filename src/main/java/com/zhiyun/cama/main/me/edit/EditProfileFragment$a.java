/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package com.zhiyun.cama.main.me.edit;

import android.text.Editable;
import android.text.TextWatcher;
import com.zhiyun.cama.main.me.edit.EditProfileFragment;

public class EditProfileFragment$a
implements TextWatcher {
    public final /* synthetic */ EditProfileFragment a;

    public EditProfileFragment$a(EditProfileFragment editProfileFragment) {
        this.a = editProfileFragment;
    }

    public void afterTextChanged(Editable editable) {
        editable = EditProfileFragment.j((EditProfileFragment)this.a).j;
        String string2 = EditProfileFragment.j((EditProfileFragment)this.a).a.getText().toString();
        int n10 = string2.length();
        if (n10 > 0) {
            n10 = 8;
        } else {
            n10 = 0;
            string2 = null;
        }
        editable.setVisibility(n10);
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

