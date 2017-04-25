package com.easytoolsoft.mybatis.data;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> Key字段数据类型(Integer,Long,String等)
 * @author zhiwei.deng
 * @date 2017-03-25
 */
public interface DeleteRepository<T, U, K> {
    /**
     * 根据主键删除记录
     *
     * @param id id主键值
     * @return 影响的记录数
     */
    int deleteById(K id);

    /**
     * 根据条件删除记录
     *
     * @param example 查询Example条件参数
     * @return 影响的记录数
     */
    int deleteByExample(@Param("example") U example);

    /**
     * @param records
     * @return
     */
    int deleteIn(List<T> records);
}

