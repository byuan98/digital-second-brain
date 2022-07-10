package pers.boyuan.domain.bill.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.boyuan.domain.bill.model.BillModel;
import pers.boyuan.domain.bill.repository.BillRepository;
import pers.boyuan.domain.bill.service.BillDomainService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    /**
     * 创建账单表数据
     *
     * @param modelList 创建账单表数据入参列表
     * @return 是否创建成功
     */
    @Override
    public Boolean create(List<BillModel> modelList) {
        return billRepository.create(modelList);
    }

    /**
     * 根据主键id删除账单表数据
     *
     * @param idList 主键id列表
     * @return 是否删除成功
     */
    @Override
    public Boolean delete(List<Long> idList) {
        return billRepository.delete(idList);
    }

    /**
     * 更新账单表数据
     *
     * @param model 更新账单表数据入参
     * @return 是否更新成功
     */
    @Override
    public Boolean update(BillModel model) {
        return billRepository.update(model);
    }

    /**
     * 查询账单表数据分页
     *
     * @param model 查询账单表数据分页入参
     * @return 查询账单表分页数据
     */
    @Override
    public IPage<BillModel> queryPage(BillModel model) {
        return billRepository.queryPage(model, new Page<>(model.getPageIndex(), model.getPageSize()));
    }

    /**
     * 根据指定条件导出账单表数据为excel
     *
     * @param model    指定条件
     * @param response 响应头，导出数据写入
     */
    @Override
    public void exportExcel(BillModel model, HttpServletResponse response) {

    }
}
