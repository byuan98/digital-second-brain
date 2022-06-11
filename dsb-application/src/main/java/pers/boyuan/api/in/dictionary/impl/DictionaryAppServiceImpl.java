package pers.boyuan.api.in.dictionary.impl;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DictionaryAppService;
import pers.boyuan.api.in.dictionary.converter.DictionaryDomainConverter;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryAppServiceImpl implements DictionaryAppService {

    @Autowired
    private DictionaryDomainService dictionaryDomainService;

    /**
     * 创建字典
     *
     * @param dictionaryList 字典列表
     * @return 是否创建成功
     */
    @Override
    public Boolean createDictionary(List<CreateDictionaryAO> dictionaryList) {
        if (CollectionUtil.isEmpty(dictionaryList)) {
            return Boolean.FALSE;
        }
        List<DictionaryModel> dictionaryModelList = DictionaryDomainConverter.INSTANCE.createDictionaryToModelList(dictionaryList);
        return dictionaryDomainService.createDictionary(dictionaryModelList);

    }
}
