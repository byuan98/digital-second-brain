package pers.boyuan.infrastructure.web.dictionary;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.boyuan.api.in.dictionary.CreateDictionaryAO;
import pers.boyuan.api.in.dictionary.DictionaryAppService;
import pers.boyuan.common.constants.ResponseEnum;
import pers.boyuan.common.dto.Response;

import java.util.List;

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
    @ApiOperation("创建字典")
    public Response query(@RequestBody List<CreateDictionaryAO> dictionaryList) {
        Boolean createFlag = dictionaryAppService.createDictionary(dictionaryList);
        return createFlag ? Response.success() : Response.error(ResponseEnum.FAIL);
    }

}
