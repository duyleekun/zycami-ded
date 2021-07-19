/*
 * Decompiled with CFR 0.151.
 */
package androidx.databinding;

import androidx.databinding.MergedDataBinderMapper;

public class DataBinderMapperImpl
extends MergedDataBinderMapper {
    public DataBinderMapperImpl() {
        com.zhiyun.cama.DataBinderMapperImpl dataBinderMapperImpl = new com.zhiyun.cama.DataBinderMapperImpl();
        this.addMapper(dataBinderMapperImpl);
    }
}

