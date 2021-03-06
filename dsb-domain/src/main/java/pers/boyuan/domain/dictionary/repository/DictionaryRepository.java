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
     * @return 数据库查询结果模型
     */
    List<DictionaryModel> query(List<String> typeList);

    /**
     * 根据type和code查询字典name
     *
     * @param type 字典表type
     * @param code 字典表code
     * @return 字典表name
     */
    String queryNameByTypeAndCode(String type, String code);

}
