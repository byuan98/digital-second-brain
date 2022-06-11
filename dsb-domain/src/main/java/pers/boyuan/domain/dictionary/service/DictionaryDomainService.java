package pers.boyuan.domain.dictionary.service;

import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryDomainService {

    /**
     * 创建字典
     *
     * @param dictionaryList 字典列表
     * @return 是否创建成功
     */
    Boolean createDictionary(List<DictionaryModel> dictionaryList);

}
