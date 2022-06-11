-- 初始化数据库

-- 创建字典表
CREATE TABLE `data_dictionary`(
    `id`     INT(11) PRIMARY KEY AUTO_INCREMENT COMMENT '自增主键id',
    `type`   VARCHAR(255) NOT NULL COMMENT '类型',
    `code`   VARCHAR(255) NOT NULL COMMENT '编码',
    `name`   VARCHAR(255) NOT NULL COMMENT '名称',
    `remark` VARCHAR(255) COMMENT '备注'
) COMMENT '字典表';