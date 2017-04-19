package com.easytoolsoft.mybatis.service;

import java.util.List;

/**
 * @param <T> Po
 * @author zhiwei.deng
 * @date 2017-03-25
 */
public interface AddService<T> {
    /**
     * @param record
     * @return
     */
    int add(T record);

    /**
     * @param records
     * @return
     */
    int batchAdd(List<T> records);
}
