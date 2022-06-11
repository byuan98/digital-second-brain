package pers.boyuan.infrastructure.converter.dictionary;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.domain.dictionary.model.DictionaryModel;
import pers.boyuan.infrastructure.db.entity.DataDictionary;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface DictionaryEntityConverter {

    DictionaryEntityConverter INSTANCE = Mappers.getMapper(DictionaryEntityConverter.class);

    List<DataDictionary> modelToEntityList(List<DictionaryModel> modelList);

}
