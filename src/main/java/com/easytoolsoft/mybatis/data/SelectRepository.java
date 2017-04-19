package com.easytoolsoft.mybatis.data;

import java.util.List;

import com.easytoolsoft.mybatis.pager.PageInfo;
import org.apache.ibatis.annotations.Param;

/**
 * @param <T> Po
 * @param <U> Example
 * @param <K> Key字段数据类型(Integer,Long,String等)
 * @author zhiwei.deng
 * @date 2017-03-25
 */
public interface SelectRepository<T, U, K> {
    /**
     * 通过主键找出一条数据
     *
     * @param id 主键id值
     * @return
     */
    T selectById(K id);

    /**
     * 根据条件查询零条及多条数据
     *
     * @param example 查询条件参数
     * @return 记录列表
     */
    List<T> selectByExample(U example);

    /**
     * 根据条件查询一条数据
     *
     * @param example 查询条件参数
     * @return 分页记录列表
     */
    T selectOneByExample(U example);

    /**
     * @param records
     * @return
     */
    List<T> selectIn(List<T> records);

    /**
     * 获取当前分页查询的总记录数
     *
     * @param pager
     * @param example 查询条件参数
     * @return 总记录数
     */
    int countByPager(@Param("pager") PageInfo pager, @Param("example") U example);

    /**
     * 分页查询
     *
     * @param pager
     * @param example 查询条件参数
     * @return 分页记录列表
     */
    List<T> selectByPager(@Param("pager") PageInfo pager, @Param("example") U example);

    /**
     * 根据条件获取查询的总记录数
     *
     * @param example 查询条件参数
     * @return 总记录数
     */
    int countByExample(U example);
}
