package pers.boyuan.domain.dictionary.repository;

import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;

/**
 * 字典表底层数据库接口
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryRepository {

    /**
     * 创建字典
     *
     * @param modelList 字典列表
     * @return 是否创建成功
     */
    Boolean createDictionary(List<DictionaryModel> modelList);

}
