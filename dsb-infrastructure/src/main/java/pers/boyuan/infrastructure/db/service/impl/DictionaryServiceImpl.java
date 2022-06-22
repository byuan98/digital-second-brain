package pers.boyuan.infrastructure.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import pers.boyuan.infrastructure.db.entity.Dictionary;
import pers.boyuan.infrastructure.db.mapper.DictionaryMapper;
import pers.boyuan.infrastructure.db.service.IDictionaryService;

/**
 * 字典表 服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements IDictionaryService {

}
