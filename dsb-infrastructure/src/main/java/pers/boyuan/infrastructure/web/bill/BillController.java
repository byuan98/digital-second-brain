package pers.boyuan.infrastructure.web.bill;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.boyuan.api.in.bill.CreateBillPageAO;
import pers.boyuan.api.in.bill.ExportBillAO;
import pers.boyuan.api.in.bill.QueryBillAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;
import pers.boyuan.application.bill.BillAppService;
import pers.boyuan.common.constants.ResponseEnum;
import pers.boyuan.common.dto.PageResponse;
import pers.boyuan.common.dto.Response;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 消费账单表 前端控制器
 *
 * @author ZhangBoyuan
 * @date 2022-06-22
 */
@Controller
@RequestMapping("/biz/bill")
@Api(tags = "消费账单表相关接口")
public class BillController {

    @Autowired
    private BillAppService billAppService;

    @PostMapping("/create")
    @ApiOperation("创建账单表数据")
    public Response create(@RequestBody CreateBillPageAO ao) {
        return null;
    }

    @PostMapping("/delete")
    @ApiOperation("根据条件逻辑删除账单表数据")
    public Response delete(List<Long> idList) {
        return null;
    }

    @PostMapping("update")
    @ApiOperation("更新账单表数据")
    public Response update(@RequestBody UpdateBillAO ao) {
        return null;
    }

    @PostMapping("/queryPage")
    @ApiOperation("查询账单表数据分页")
    public PageResponse<QueryBillVO> queryPage(@RequestBody QueryBillAO ao) {
        return null;
    }

    @GetMapping("exportExcel")
    @ApiOperation("根据指定条件导出账单表数据为excel")
    public void exportExcel(ExportBillAO ao, HttpServletResponse response) {
        return;
    }

}
