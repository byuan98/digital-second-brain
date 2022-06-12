package pers.boyuan.domain.dictionary.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.common.util.ObjectFieldUtil;
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
        // 添加判断字段属性是否全部为null，避免删除全表
        if (ObjectFieldUtil.allNull(model)) {
            return Boolean.FALSE;
        }

        return dictionaryRepository.delete(model);
    }
}
