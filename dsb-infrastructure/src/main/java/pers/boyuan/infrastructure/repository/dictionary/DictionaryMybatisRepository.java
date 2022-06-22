package pers.boyuan.infrastructure.repository.dictionary;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.var;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.domain.dictionary.repository.DictionaryRepository;
import pers.boyuan.infrastructure.converter.dictionary.DictionaryEntityConverter;
import pers.boyuan.infrastructure.db.entity.Dictionary;
import pers.boyuan.infrastructure.db.mapper.DictionaryMapper;
import pers.boyuan.infrastructure.db.service.IDictionaryService;

import java.util.Collections;
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
    private IDictionaryService dictionaryService;

    @Autowired
    private DictionaryMapper dictionaryMapper;

    /**
     * 创建字典
     *
     * @param modelList 字典列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<DictionaryModel> modelList) {
        List<Dictionary> dataDictionaryList = DictionaryEntityConverter.INSTANCE.modelToEntityList(modelList);

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
        Dictionary entity = DictionaryEntityConverter.INSTANCE.modelToEntity(model);

        LambdaQueryWrapper<Dictionary> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper
                .eq(Objects.nonNull(entity.getId()), Dictionary::getId, entity.getId())
                .or()
                .eq(StringUtils.isNotBlank(entity.getType()), Dictionary::getType, entity.getType())
                .or()
                .eq(StringUtils.isNotBlank(entity.getCode()), Dictionary::getCode, entity.getCode())
                .or()
                .eq(StringUtils.isNotBlank(entity.getName()), Dictionary::getName, entity.getName());

        return dictionaryService.remove(queryWrapper);
    }

    /**
     * 根据参数更新字典数据
     *
     * @param model 入参
     * @return 是否创建成功
     */
    @Override
    public Boolean update(DictionaryModel model) {
        Dictionary entity = DictionaryEntityConverter.INSTANCE.modelToEntity(model);

        LambdaUpdateWrapper<Dictionary> updateWrapper = Wrappers.lambdaUpdate();
        updateWrapper
                .set(StringUtils.isNotBlank(entity.getType()), Dictionary::getType, entity.getType())
                .set(StringUtils.isNotBlank(entity.getName()), Dictionary::getName, entity.getName())
                .set(StringUtils.isNotBlank(entity.getCode()), Dictionary::getCode, entity.getCode())
                .set(StringUtils.isNotBlank(entity.getRemark()), Dictionary::getRemark, entity.getRemark())
                .eq(Dictionary::getId, entity.getId());

        return dictionaryService.update(updateWrapper);
    }

    /**
     * 根据type查询字典数据
     *
     * @param typeList 根据type列表查询对应数据，为空拉取全量
     * @return 数据库查询结果模型
     */
    @Override
    public List<DictionaryModel> query(List<String> typeList) {
        LambdaQueryWrapper<Dictionary> queryWrapper = Wrappers.lambdaQuery();
        queryWrapper
                .in(CollectionUtil.isNotEmpty(typeList), Dictionary::getType, typeList);

        var queryResult = dictionaryService.list(queryWrapper);

        if (CollectionUtil.isNotEmpty(queryResult)) {
            var result = DictionaryEntityConverter.INSTANCE.entityToModelList(queryResult);
            return result;
        }

        return Collections.emptyList();
    }

}
