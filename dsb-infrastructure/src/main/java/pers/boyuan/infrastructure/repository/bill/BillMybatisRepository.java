package pers.boyuan.infrastructure.repository.bill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pers.boyuan.domain.bill.repository.BillRepository;
import pers.boyuan.infrastructure.db.mapper.BillMapper;
import pers.boyuan.infrastructure.db.service.IBillService;

/**
 * 字典表底层数据库接口 Mybatis 实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Component
public class BillMybatisRepository implements BillRepository {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private IBillService billService;

}
