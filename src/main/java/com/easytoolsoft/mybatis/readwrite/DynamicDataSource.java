package com.easytoolsoft.mybatis.readwrite;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.util.Assert;

/**
 * @author zhiwei.deng
 * @date 2017-03-25
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * 写数据源
     */
    private Object writeDataSource;

    /**
     * 读数据源
     */
    private Object readDataSource;

    @Override
    public void afterPropertiesSet() {
        Assert.notNull(this.writeDataSource, "Property 'writeDataSource' is required");

        this.setDefaultTargetDataSource(this.writeDataSource);
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DynamicDataSourceType.WRITE.name(), this.writeDataSource);
        if (this.readDataSource != null) {
            targetDataSources.put(DynamicDataSourceType.READ.name(), this.readDataSource);
        }
        this.setTargetDataSources(targetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        DynamicDataSourceType dataSourceType = DynamicDataSourceHolder.getDataSource();
        if (dataSourceType == null || dataSourceType == DynamicDataSourceType.WRITE) {
            return DynamicDataSourceType.WRITE.name();
        }
        return DynamicDataSourceType.READ.name();
    }

    public void setWriteDataSource(Object writeDataSource) {
        this.writeDataSource = writeDataSource;
    }

    public Object getWriteDataSource() {
        return this.writeDataSource;
    }

    public Object getReadDataSource() {
        return this.readDataSource;
    }

    public void setReadDataSource(Object readDataSource) {
        this.readDataSource = readDataSource;
    }
}
