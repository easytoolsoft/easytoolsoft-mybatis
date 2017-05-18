package com.easytoolsoft.mybatis.readwrite;

/**
 *
 * @author zhiwei.deng
 * @date 2017-03-25
 */
public final class DynamicDataSourceHolder {
    private static final ThreadLocal<DynamicDataSourceType> holder = new ThreadLocal<DynamicDataSourceType>();

    private DynamicDataSourceHolder() {
    }

    public static void putDataSource(DynamicDataSourceType dataSource) {
        holder.set(dataSource);
    }

    public static DynamicDataSourceType getDataSource() {
        return holder.get();
    }

    public static void clearDataSource() {
        holder.remove();
    }

}
