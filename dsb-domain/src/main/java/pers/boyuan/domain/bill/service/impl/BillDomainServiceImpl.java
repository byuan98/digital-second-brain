package pers.boyuan.domain.bill.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.domain.bill.repository.BillRepository;
import pers.boyuan.domain.bill.service.BillDomainService;

/**
 * 账单表领域层服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Service
public class BillDomainServiceImpl implements BillDomainService {

    @Autowired
    private BillRepository billRepository;

}
