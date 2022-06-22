package pers.boyuan.api.in.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 删除字典入参
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Data
@ApiModel("删除字典入参")
public class DeleteDictionaryAO {
    /**
     * 主键自增id
     */
    @ApiModelProperty("主键自增id")
    private Integer id;

    /**
     * 类型
     */
    @ApiModelProperty("类型")
    private String type;

    /**
     * 编码
     */
    @ApiModelProperty("编码")
    private String code;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

}
