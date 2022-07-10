package pers.boyuan.application.bill.converter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pers.boyuan.api.in.bill.CreateBillAO;
import pers.boyuan.api.in.bill.QueryBillPageAO;
import pers.boyuan.api.in.bill.UpdateBillAO;
import pers.boyuan.api.out.bill.QueryBillVO;
import pers.boyuan.domain.bill.model.BillModel;

import java.util.List;

/**
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Mapper
public interface BillDomainConverter {

    BillDomainConverter INSTANCE = Mappers.getMapper(BillDomainConverter.class);

    List<BillModel> createBillToModelList(List<CreateBillAO> aoList);

    BillModel updateToModel(UpdateBillAO ao);

    BillModel queryPageToModel(QueryBillPageAO ao);

    List<QueryBillVO> modelToQueryBill(List<BillModel> modelList);

}
