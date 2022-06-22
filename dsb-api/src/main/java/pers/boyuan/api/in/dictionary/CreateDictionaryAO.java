package pers.boyuan.api.in.dictionary;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 创建字典入参
 *
 * @author ZhangBoyuan
 * @date 2022-06-11
 */
@Data
@ApiModel("创建字典入参")
public class CreateDictionaryAO {
    /**
     * 类型
     */
    @NotBlank(message = "字典类型不可为空")
    @ApiModelProperty("类型")
    private String type;

    /**
     * 编码
     */
    @NotBlank(message = "字典编码不可为空")
    @ApiModelProperty("编码")
    private String code;

    /**
     * 名称
     */
    @NotBlank(message = "字典名称不可为空")
    @ApiModelProperty("名称")
    private String name;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

}
