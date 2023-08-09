package com.youlan.common.db.service;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.youlan.common.db.entity.dto.PageDTO;
import com.youlan.common.db.helper.DBHelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> {

    public void loadOne(Serializable id, Object target) {
        T data = getById(id);
        if (data != null) {
            BeanUtil.copyProperties(data, target);
        }
    }

    public <VO> VO loadOne(Serializable id, Class<VO> clz) {
        T data = getById(id);
        if (data == null) {
            return null;
        }
        return BeanUtil.copyProperties(data, clz);
    }

    public <VO> VO loadOne(QueryWrapper<T> queryWrapper, Class<VO> clz) {
        return CollectionUtil.getFirst(loadMore(queryWrapper, clz));
    }

    public T loadOne(Serializable id) {
        return this.getById(id);
    }

    public T loadOne(Wrapper<T> wrapper) {
        return CollectionUtil.getFirst(this.list(wrapper));
    }

    public T loadOne(SFunction<T, ?> sFunction, Object value) {
        return CollectionUtil.getFirst(loadMore(sFunction, value));
    }

    public Optional<T> loadOneOpt(Serializable id) {
        return Optional.ofNullable(loadOne(id));
    }

    public Optional<T> loadOneOpt(SFunction<T, ?> sFunction, Object value) {
        return Optional.ofNullable(loadOne(sFunction, value));
    }

    public <VO> VO loadOne(SFunction<T, ?> sFunction, Object value, Class<VO> clz) {
        return CollectionUtil.getFirst(loadMore(sFunction, value, clz));
    }

    public <VO> List<VO> loadMore(QueryWrapper<T> queryWrapper, Class<VO> clz) {
        List<T> dataList = this.list(queryWrapper);
        if (CollectionUtil.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(dataList, clz);
    }

    public List<T> loadMore(QueryWrapper<T> queryWrapper) {
        return this.list(queryWrapper);
    }

    public List<T> loadMore(SFunction<T, ?> sFunction, Object value) {
        List<T> dataList = this.lambdaQuery()
                .eq(sFunction, value)
                .list();
        if (CollectionUtil.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return dataList;
    }

    public <VO> List<VO> loadMore(SFunction<T, ?> sFunction, Object value, Class<VO> clz) {
        List<T> dataList = this.lambdaQuery()
                .eq(sFunction, value)
                .list();
        if (CollectionUtil.isEmpty(dataList)) {
            return new ArrayList<>();
        }
        return BeanUtil.copyToList(dataList, clz);
    }

    public IPage<T> loadPage(PageDTO dto, QueryWrapper<T> queryWrapper) {
        return loadPage(DBHelper.getIPage(dto), queryWrapper);
    }

    public IPage<T> loadPage(PageDTO dto, Object queryObj) {
        return loadPage(DBHelper.getIPage(dto), DBHelper.getQueryWrapper(queryObj));
    }

    public <VO> IPage<VO> loadPage(PageDTO dto, QueryWrapper<T> queryWrapper, Class<VO> clz) {
        IPage<T> pageRes = loadPage(dto, queryWrapper);
        return pageRes.convert(t -> BeanUtil.copyProperties(t, clz));
    }

    public IPage<T> loadPage(IPage<T> page, QueryWrapper<T> queryWrapper) {
        if (queryWrapper == null) {
            return this.page(page);
        }
        return this.page(page, queryWrapper);
    }

    public <VO> IPage<VO> loadPage(IPage<T> page, QueryWrapper<T> queryWrapper, Class<VO> clz) {
        return this.loadPage(page, queryWrapper).convert(t -> BeanUtil.copyProperties(t, clz));
    }

    public <VO> IPage<VO> loadPage(IPage<T> page, Class<VO> clz) {
        return this.loadPage(page, null, clz);
    }
}
