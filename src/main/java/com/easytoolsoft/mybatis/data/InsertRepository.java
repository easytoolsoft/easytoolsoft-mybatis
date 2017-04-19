package com.easytoolsoft.mybatis.data;

import java.util.List;

/**
 * @param <T>
 * @author zhiwei.deng
 * @date 2017-03-25
 */
public interface InsertRepository<T> {
    /**
     * 插入一条数据，忽略record中的ID
     *
     * @param record
     * @return 影响的记录数
     */
    int insert(T record);

    /**
     * @param records
     * @return 影响的记录数
     */
    int batchInsert(List<T> records);
}
