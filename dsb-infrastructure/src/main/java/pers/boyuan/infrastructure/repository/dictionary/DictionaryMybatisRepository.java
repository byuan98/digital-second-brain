package pers.boyuan.infrastructure.repository.dictionary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.infrastructure.converter.dictionary.DictionaryEntityConverter;
import pers.boyuan.infrastructure.db.entity.DataDictionary;
import pers.boyuan.infrastructure.db.mapper.DataDictionaryMapper;
import pers.boyuan.infrastructure.db.service.IDataDictionaryService;

import java.util.List;

/**
 * 字典表底层数据库接口实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Component
public class DictionaryMybatisRepository implements DictionaryRepository {

    @Autowired
    private IDataDictionaryService dictionaryService;

    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    /**
     * 创建字典
     *
     * @param modelList 字典列表
     * @return 是否创建成功
     */
    @Override
    public Boolean createDictionary(List<DictionaryModel> modelList) {
        List<DataDictionary> dataDictionaryList = DictionaryEntityConverter.INSTANCE.modelToEntityList(modelList);

        return dictionaryService.saveBatch(dataDictionaryList);

    }

}
