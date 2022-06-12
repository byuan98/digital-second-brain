package pers.boyuan.infrastructure.repository.dictionary;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.infrastructure.converter.dictionary.DictionaryEntityConverter;
import pers.boyuan.infrastructure.db.entity.DataDictionary;
import pers.boyuan.infrastructure.db.mapper.DataDictionaryMapper;
import pers.boyuan.infrastructure.db.service.IDataDictionaryService;

import java.util.List;
import java.util.Objects;

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
    public Boolean create(List<DictionaryModel> modelList) {
        List<DataDictionary> dataDictionaryList = DictionaryEntityConverter.INSTANCE.modelToEntityList(modelList);

        return dictionaryService.saveBatch(dataDictionaryList);

    }

    /**
     * 根据参数删除字典
     *
     * @param model 删除参数
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(DictionaryModel model) {
        DataDictionary entity = DictionaryEntityConverter.INSTANCE.modelToEntity(model);

        LambdaQueryWrapper<DataDictionary> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper
                .eq(Objects.nonNull(entity.getId()), DataDictionary::getId, entity.getId())
                .or()
                .eq(StringUtils.isNotBlank(entity.getType()), DataDictionary::getType, entity.getType())
                .or()
                .eq(StringUtils.isNotBlank(entity.getCode()), DataDictionary::getCode, entity.getCode())
                .or()
                .eq(StringUtils.isNotBlank(entity.getName()), DataDictionary::getName, entity.getName());

        return dictionaryService.remove(queryWrapper);
    }

}
