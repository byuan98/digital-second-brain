package pers.boyuan.application.in.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 修改字典入参
 *
 * @author ZhangBoyuan
 * @date 2022-06-13
 */
@Data
@ApiModel("修改字典入参")
public class UpdateDictionaryAO {
    /**
     * 主键自增id
     */
    @NotNull(message = "字典id不可为空")
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

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
