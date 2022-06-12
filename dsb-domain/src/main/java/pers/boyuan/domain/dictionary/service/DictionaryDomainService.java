package pers.boyuan.domain.dictionary.service;

import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;

/**
 * 字典表领域层服务
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryDomainService {

    /**
     * 创建字典
     *
     * @param modelList 字典模型列表
     * @return 是否创建成功
     */
    Boolean create(List<DictionaryModel> modelList);

    /**
     * 根据参数删除字典
     *
     * @param model 删除参数
     * @return 是否删除成功
     */
    Boolean delete(DictionaryModel model);

}
