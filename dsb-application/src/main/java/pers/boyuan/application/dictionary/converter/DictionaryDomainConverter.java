package pers.boyuan.application.dictionary.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.application.in.dictionary.CreateDictionaryAO;
import pers.boyuan.application.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.application.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.application.out.dictionary.QueryDictionaryVO;
import pers.boyuan.domain.dictionary.model.DictionaryModel;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface DictionaryDomainConverter {

    DictionaryDomainConverter INSTANCE = Mappers.getMapper(DictionaryDomainConverter.class);

    List<DictionaryModel> createDictionaryToModelList(List<CreateDictionaryAO> aoList);

    DictionaryModel deleteDictionaryToModel(DeleteDictionaryAO ao);

    DictionaryModel updateDictionaryToModel(UpdateDictionaryAO ao);

    List<QueryDictionaryVO> modelToQueryDictionary(List<DictionaryModel> modelList);

}
