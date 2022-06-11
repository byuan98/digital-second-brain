package pers.boyuan.api.in.dictionary;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
public interface DictionaryAppService {

    /**
     * 创建字典
     *
     * @param dictionaryList 字典列表
     * @return 是否创建成功
     */
    Boolean createDictionary(List<CreateDictionaryAO> dictionaryList);
}
