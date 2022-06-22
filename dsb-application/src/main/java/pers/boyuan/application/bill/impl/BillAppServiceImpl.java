package pers.boyuan.application.bill.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.application.bill.BillAppService;
import pers.boyuan.domain.bill.service.BillDomainService;

/**
 * 账单表应用服务实现类
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Service
public class BillAppServiceImpl implements BillAppService {

    @Autowired
    private BillDomainService billDomainService;

}
