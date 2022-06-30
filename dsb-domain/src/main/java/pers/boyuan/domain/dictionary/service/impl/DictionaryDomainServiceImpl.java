package pers.boyuan.domain.dictionary.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.common.util.ObjectFieldUtil;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
     * @param modelList 字典模型列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<DictionaryModel> modelList) {
        if (CollectionUtil.isEmpty(modelList)) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.create(modelList);
    }

    /**
     * 根据参数删除字典
     *
     * @param model 删除参数
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(DictionaryModel model) {
        // 添加判断字段属性是否全部为null或空字符串，避免删除全表
        if (ObjectFieldUtil.allBlank(model)) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.delete(model);
    }

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否创建成功
     */
    @Override
    public Boolean update(DictionaryModel model) {
        return dictionaryRepository.update(model);
    }

    /**
     * 根据type查询字典数据
     *
     * @param typeList 根据type列表查询对应数据，为空拉取全量
     * @return 领域层处理后数据
     */
    @Override
    public Map<String, List<DictionaryModel>> query(List<String> typeList) {
        var queryResult = dictionaryRepository.query(typeList);

        if (CollectionUtil.isEmpty(queryResult)) {
            return Collections.emptyMap();
        }

        var result = queryResult.stream()
                .collect(Collectors.groupingBy(DictionaryModel::getType));

        return result;
    }

    /**
     * 根据type和code查询字典name
     *
     * @param type 字典表type
     * @param code 字典表code
     * @return 字典表name
     */
    @Override
    public String queryNameByTypeAndCode(String type, String code) {
        return dictionaryRepository.queryNameByTypeAndCode(type, code);
    }

}
