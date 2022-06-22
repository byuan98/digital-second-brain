package pers.boyuan.infrastructure.db.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import pers.boyuan.infrastructure.db.entity.Dictionary;

/**
 * 字典表 Mapper 接口
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface DictionaryMapper extends BaseMapper<Dictionary> {

}
