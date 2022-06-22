-- 初始化数据库

-- 创建字典表
CREATE TABLE `data_dictionary`
(
    `id`     INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键id',
    `type`   VARCHAR(255) NOT NULL COMMENT '类型',
    `code`   VARCHAR(255) NOT NULL COMMENT '编码',
    `name`   VARCHAR(255) NOT NULL COMMENT '名称',
    `remark` VARCHAR(255) COMMENT '备注'
) COMMENT '数据_字典表';

-- 创建账单表
CREATE TABLE `biz_bill`
(
    `id`          BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '主键id',
    `type`        TINYINT NOT NULL COMMENT '账单类型: 1 -> 收入, -1 -> 支出',
    `category_id` INT COMMENT '账单分类id, 关联data_dictionary表',
    `content`     VARCHAR(255) COMMENT '账单内容',
    `remark`      TEXT COMMENT '账单备注',
    `amount`      DECIMAL(10, 2) COMMENT '账单金额: 单位(元)',
    `year`        INT(4) COMMENT '账单所属年份yyyy',
    `month`       INT(2) COMMENT '账单所属月份: 1~12',
    `day`         INT(2) COMMENT '账单所属日: 1~31',
    `week`        INT(1) COMMENT '账单所属星期: 1~7',
    `gmt_create`  DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `gmt_update`  DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) COMMENT '业务_消费账单表';