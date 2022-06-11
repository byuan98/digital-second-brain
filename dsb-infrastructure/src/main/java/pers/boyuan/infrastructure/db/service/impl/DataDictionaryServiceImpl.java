package pers.boyuan.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.boyuan.infrastructure.db.entity.DataDictionary;
import pers.boyuan.infrastructure.db.mapper.DataDictionaryMapper;
import pers.boyuan.infrastructure.db.service.IDataDictionaryService;

/**
 * 字典表 服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DataDictionaryServiceImpl extends ServiceImpl<DataDictionaryMapper, DataDictionary> implements IDataDictionaryService {

}
