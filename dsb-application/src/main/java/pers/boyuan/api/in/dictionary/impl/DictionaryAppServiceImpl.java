package pers.boyuan.api.in.dictionary.impl;

import cn.hutool.core.collection.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.DictionaryAppService;
import pers.boyuan.api.in.dictionary.converter.DictionaryDomainConverter;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.service.DictionaryDomainService;

import java.util.List;

/**
 * 字典表应用服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryAppServiceImpl implements DictionaryAppService {

    @Autowired
    private DictionaryDomainService dictionaryDomainService;

    /**
     * 新增字典数据
     *
     * @param aoList 入参列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<CreateDictionaryAO> aoList) {
        if (CollectionUtil.isEmpty(aoList)) {
            return Boolean.FALSE;
        }

        List<DictionaryModel> modelList = DictionaryDomainConverter.INSTANCE.createDictionaryToModelList(aoList);

        return dictionaryDomainService.create(modelList);
    }

    /**
     * 根据参数删除相关字典数据
     *
     * @param ao 入参
     * @return 是否创建成功
     */
    @Override
    public Boolean delete(DeleteDictionaryAO ao) {
        DictionaryModel model = DictionaryDomainConverter.INSTANCE.deleteDictionaryToModel(ao);

        return dictionaryDomainService.delete(model);
    }
}
