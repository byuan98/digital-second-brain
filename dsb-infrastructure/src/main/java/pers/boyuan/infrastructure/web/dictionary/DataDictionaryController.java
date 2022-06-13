package pers.boyuan.infrastructure.web.dictionary;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DeleteDictionaryAO;
import pers.boyuan.api.in.dictionary.DictionaryAppService;
import pers.boyuan.api.in.dictionary.UpdateDictionaryAO;
import pers.boyuan.common.constants.ResponseEnum;
import pers.boyuan.common.dto.Response;
import pers.boyuan.common.sheme.ValidationList;

import javax.validation.Valid;

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

}
