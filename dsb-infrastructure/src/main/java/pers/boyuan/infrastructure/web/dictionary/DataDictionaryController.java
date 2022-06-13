package pers.boyuan.infrastructure.web.dictionary;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.boyuan.application.in.dictionary.CreateDictionaryAO;
import pers.boyuan.application.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.application.dictionary.DictionaryAppService;
import pers.boyuan.application.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.application.out.dictionary.QueryDictionaryVO;
import pers.boyuan.common.constants.ResponseEnum;
import pers.boyuan.common.dto.Response;
import pers.boyuan.common.sheme.ValidationList;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 字典表 前端控制器
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@RestController
@RequestMapping("/data/dictionary")
@Api(tags = "字典相关接口")
public class DataDictionaryController {

    @Autowired
    private DictionaryAppService dictionaryAppService;

    @PostMapping("/create")
    @ApiOperation("创建字典数据")
    public Response<Boolean> create(@RequestBody @Valid ValidationList<CreateDictionaryAO> aoList) {
        Boolean createFlag = dictionaryAppService.create(aoList);
        return createFlag ? Response.success() : Response.error(ResponseEnum.FAIL);
    }

    @PostMapping("/delete")
    @ApiOperation("根据参数删除词典")
    public Response<Boolean> delete(@RequestBody DeleteDictionaryAO ao) {
        Boolean deleteFlag = dictionaryAppService.delete(ao);
        return deleteFlag ? Response.success() : Response.error(ResponseEnum.FAIL);
    }

    @PostMapping("/update")
    @ApiOperation("更新字典数据")
    public Response<Boolean> update(@RequestBody UpdateDictionaryAO ao) {
        Boolean updateFlag = dictionaryAppService.update(ao);
        return updateFlag ? Response.success() : Response.error(ResponseEnum.FAIL);
    }

    @GetMapping("/query")
    @ApiOperation("根据type查询字典数据，无参拉取全量")
    public Response<Map<String, List<QueryDictionaryVO>>> query(@RequestParam(name = "typeList", required = false) List<String> typeList) {
        Map<String, List<QueryDictionaryVO>> result = dictionaryAppService.query(typeList);
        return Response.success(result);
    }

}
