package pers.boyuan.domain.dictionary.service;

import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;
import java.util.Map;

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

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否创建成功
     */
    Boolean update(DictionaryModel model);

    /**
     * 根据type查询字典数据
     *
     * @param typeList 根据type列表查询对应数据，为空拉取全量
     * @return 领域层处理后数据
     */
    Map<String, List<DictionaryModel>> query(List<String> typeList);

}
