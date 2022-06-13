package pers.boyuan.application.dictionary.impl;

import cn.hutool.core.collection.CollectionUtil;
import lombok.var;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pers.boyuan.application.dictionary.DictionaryAppService;
import pers.boyuan.application.dictionary.converter.DictionaryDomainConverter;
import pers.boyuan.application.in.dictionary.CreateDictionaryAO;
import pers.boyuan.application.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.application.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.application.out.dictionary.QueryDictionaryVO;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典表应用服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryAppServiceImpl implements DictionaryAppService {

    @Autowired
    private DictionaryDomainService dictionaryDomainService;

    /**
     * 新增字典数据
     *
     * @param aoList 入参列表
     * @return 是否创建成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean create(List<CreateDictionaryAO> aoList) {
        if (CollectionUtil.isEmpty(aoList)) {
            return Boolean.FALSE;
        }

        List<DictionaryModel> modelList = DictionaryDomainConverter.INSTANCE.createDictionaryToModelList(aoList);

        return dictionaryDomainService.create(modelList);
    }

    /**
     * 根据参数删除相关字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean delete(DeleteDictionaryAO ao) {
        DictionaryModel model = DictionaryDomainConverter.INSTANCE.deleteDictionaryToModel(ao);

        return dictionaryDomainService.delete(model);
    }

    /**
     * 根据参数更新字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    @Override
    @CacheEvict(cacheNames = "dsb:cache:dictionary", allEntries = true)
    public Boolean update(UpdateDictionaryAO ao) {
        DictionaryModel model = DictionaryDomainConverter.INSTANCE.updateDictionaryToModel(ao);

        return dictionaryDomainService.update(model);
    }

    /**
     * 查询字典
     *
     * @param typeList 根据type列表查询对应数据，为空拉取全量
     * @return 应用层转换后数据
     */
    @Override
    @Cacheable(cacheNames = "dsb:cache:dictionary")
    public Map<String, List<QueryDictionaryVO>> query(List<String> typeList) {
        var queryResult = dictionaryDomainService.query(typeList);

        if (CollectionUtil.isEmpty(queryResult)) {
            return Collections.emptyMap();
        }

        Map<String, List<QueryDictionaryVO>> result = new HashMap(queryResult.keySet().size());
        queryResult.keySet().forEach(
                item -> result.put(item, DictionaryDomainConverter.INSTANCE.modelToQueryDictionary(queryResult.get(item)))
        );

        return result;
    }

}
