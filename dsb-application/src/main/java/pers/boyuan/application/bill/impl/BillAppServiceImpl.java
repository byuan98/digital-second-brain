package pers.boyuan.application.bill.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.var;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.api.in.bill.CreateBillAO;
import pers.boyuan.api.in.bill.ExportBillAO;
import pers.boyuan.api.in.bill.QueryBillPageAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;
import pers.boyuan.application.bill.BillAppService;
import pers.boyuan.application.bill.converter.BillDomainConverter;
import pers.boyuan.domain.bill.model.BillModel;
import pers.boyuan.domain.bill.service.BillDomainService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    /**
     * 创建账单表数据
     *
     * @param aoList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<CreateBillAO> aoList) {
        if (CollectionUtil.isEmpty(aoList)) {
            return Boolean.FALSE;
        }

        var modelList = BillDomainConverter.INSTANCE.createBillToModelList(aoList);

        return billDomainService.create(modelList);
    }

    /**
     * 根据主键id删除账单表数据
     *
     * @param idList 主键id列表
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(List<Long> idList) {
        if (CollectionUtil.isEmpty(idList)) {
            return Boolean.FALSE;
        }
        return billDomainService.delete(idList);
    }

    /**
     * 更新账单表数据
     *
     * @param ao 更新账单表数据入参
     * @return 是否更新成功
     */
    @Override
    public Boolean update(UpdateBillAO ao) {
        var model = BillDomainConverter.INSTANCE.updateToModel(ao);
        return billDomainService.update(model);
    }

    /**
     * 查询账单表数据分页
     *
     * @param ao 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    @Override
    public IPage<QueryBillVO> queryPage(QueryBillPageAO ao) {
        IPage<QueryBillVO> result = new Page<>(ao.getPageIndex(), ao.getPageSize());

        var model = BillDomainConverter.INSTANCE.queryPageToModel(ao);
        var modelPage = billDomainService.queryPage(model);

        BeanUtils.copyProperties(modelPage, result);
        result.setRecords(BillDomainConverter.INSTANCE.modelToQueryBill(modelPage.getRecords()));

        return result;
    }

    /**
     * 根据指定条件导出账单表数据为excel
     *
     * @param ao       指定条件
     * @param response 响应头，导出数据写入
     */
    @Override
    public void exportExcel(ExportBillAO ao, HttpServletResponse response) {
        var model = BillDomainConverter.INSTANCE.exportToModel(ao);
        billDomainService.exportExcel(model, response);
    }

}
