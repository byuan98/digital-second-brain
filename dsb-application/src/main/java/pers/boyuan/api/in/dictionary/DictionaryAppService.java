package pers.boyuan.api.in.dictionary;

import java.util.List;

/**
 * 字典表应用服务
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryAppService {

    /**
     * 新增字典数据
     *
     * @param aoList 入参列表
     * @return 是否创建成功
     */
    Boolean create(List<CreateDictionaryAO> aoList);

    /**
     * 根据参数删除相关字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    Boolean delete(DeleteDictionaryAO ao);

}
