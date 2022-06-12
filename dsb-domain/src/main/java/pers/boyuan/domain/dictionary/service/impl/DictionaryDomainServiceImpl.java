package pers.boyuan.domain.dictionary.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.List;

/**
 * 字典表领域层服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryDomainServiceImpl implements DictionaryDomainService {

    @Autowired
    private DictionaryRepository dictionaryRepository;

    /**
     * 创建字典
     *
     * @param dictionaryList 字典列表
     * @return 是否创建成功
     */
    @Override
    public Boolean createDictionary(List<DictionaryModel> dictionaryList) {

        if (CollectionUtil.isEmpty(dictionaryList)) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.createDictionary(dictionaryList);
    }
}
