/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/5/23 17:14:35                           */
/*==============================================================*/


drop table if exists xj_ad_info;

drop table if exists xj_ad_place;

drop table if exists xj_address;

drop table if exists xj_app_info;

drop table if exists xj_business_activity;

drop table if exists xj_car_repair_company;

drop table if exists xj_driver_company;

drop table if exists xj_gov_department;

drop table if exists xj_gov_news;

drop table if exists xj_gov_news_category;

drop table if exists xj_group_buying;

drop table if exists xj_group_product;

drop table if exists xj_members;

drop table if exists xj_news;

drop table if exists xj_order;

drop table if exists xj_order_item;

drop table if exists xj_product;

drop table if exists xj_shopping_car_log;

drop table if exists xj_town_info;

drop table if exists xj_town_news;

drop table if exists xj_town_news_category;

drop table if exists xj_visit_card;

/*==============================================================*/
/* Table: xj_ad_info                                            */
/*==============================================================*/
create table xj_ad_info
(
   id                   varchar(50) not null comment '主键',
   title                varchar(1000) comment '标题',
   ad_img               varchar(500) comment '广告图片',
   ad_content           text comment '广告详情，富文本内容',
   status               varchar(20) comment '状态，启用：1，停用：0',
   description          varchar(1000) comment '描述',
   ad_url               varchar(1000) comment '广告URL，外部链接',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_ad_info comment '广告信息表';

/*==============================================================*/
/* Table: xj_ad_place                                           */
/*==============================================================*/
create table xj_ad_place
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(100) comment '广告位名称',
   type                 varchar(20) comment '广告位类型，启动页：0，普通：1',
   tag                  varchar(50) comment '广告位标识，跟app匹配的位置标识',
   ad_id                varchar(50) comment '广告ID，放置的广告',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   description          varchar(1000) comment '描述',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_ad_place comment '广告位信息表';

/*==============================================================*/
/* Table: xj_address                                            */
/*==============================================================*/
create table xj_address
(
   id                   varchar(50) not null comment '主键',
   member_id            varchar(50) comment '会员ID',
   province             varchar(100) comment '省份',
   city                 varchar(100) comment '城市',
   district             varchar(100) comment '地区',
   detail_location      varchar(2000) comment '详细地址',
   zip_code             varchar(20) comment '邮编',
   contact_user         varchar(100) comment '收货人姓名',
   contact_phone        varchar(50) comment '收货人电话',
   is_default           varchar(20) comment '是否为默认当前使用的地址，0-否，1-是',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_address comment '地址信息表';

/*==============================================================*/
/* Table: xj_app_info                                           */
/*==============================================================*/
create table xj_app_info
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200),
   version              varchar(50),
   type                 varchar(10),
   build_url            varchar(1000),
   build_size           bigint,
   description          varchar(500),
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_app_info comment 'app build信息';

/*==============================================================*/
/* Table: xj_business_activity                                  */
/*==============================================================*/
create table xj_business_activity
(
   id                   varchar(50) not null comment '主键',
   title                varchar(2000) comment '标题',
   thumbnail            varchar(500) comment '缩略图，列表上显示',
   content              text comment '详细内容，富文本内容',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_business_activity comment '商业活动表';

/*==============================================================*/
/* Table: xj_car_repair_company                                 */
/*==============================================================*/
create table xj_car_repair_company
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200) comment '名称',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   content              text comment '详细内容，富文本详细内容',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_car_repair_company comment '汽修公司表';

/*==============================================================*/
/* Table: xj_driver_company                                     */
/*==============================================================*/
create table xj_driver_company
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200) comment '名称',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   content              text comment '详细内容，富文本详细内容',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_driver_company comment '代驾公司表';

/*==============================================================*/
/* Table: xj_gov_department                                     */
/*==============================================================*/
create table xj_gov_department
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200) comment '名称',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   banner_imgs          varchar(2000) comment 'banner图片，多张以（|） 分隔',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   category_ids         varchar(2000) comment '栏目id，多个以|分隔',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_gov_department comment '政务部门表';

/*==============================================================*/
/* Table: xj_gov_news                                           */
/*==============================================================*/
create table xj_gov_news
(
   id                   varchar(50) not null comment '主键',
   gov_id               varchar(50) comment '部门ID',
   category_id          varchar(50) comment '分类ID',
   title                varchar(1000) comment '标题',
   sub_title            varchar(1000) comment '副标题',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   author               varchar(200) comment '发布人名称',
   from_unit            varchar(200) comment '来源',
   contents             text comment '资讯内容，富文本内容',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_gov_news comment '政务资讯表';

/*==============================================================*/
/* Table: xj_gov_news_category                                  */
/*==============================================================*/
create table xj_gov_news_category
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200) comment '名称',
   icon                 varchar(200) comment '图标',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_gov_news_category comment '政务信息分类表';

/*==============================================================*/
/* Table: xj_group_buying                                       */
/*==============================================================*/
create table xj_group_buying
(
   id                   varchar(50) not null comment '主键',
   title                varchar(500) comment '标题',
   sub_title            varchar(500) comment '副标题',
   thumbnail            varchar(200) comment '缩略图',
   banner_imgs          varchar(1000) comment '轮播图片，多张图片以（|）分隔',
   original_price       decimal(10,2) comment '原价，订单上的对应原价以此为准（每次团购价可能不一样）',
   price                decimal(10,2) comment '价格，订单上的对应现价以此为准（每次团购价可能不一样）',
   unit                 varchar(20) comment '单位',
   tag                  varchar(1000) comment '标签或分类，多个以（|）分隔',
   description          text comment '详情，富文本',
   group_limit          int comment '开团人数，达到多少人便成团，以下单的人数为准',
   start_date           datetime comment '开始时间，团购开放时间',
   end_date             datetime comment '结束时间，团购结束时间',
   ship_amount          decimal(10,2) comment '运费，为0则为免运费',
   current_num          int comment '参团人数，当前已购买人数',
   status               varchar(20) comment '状态，0：停用，1：进行中，2：成团，3：已结束，4：不满团',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_group_buying comment '团购信息表';

/*==============================================================*/
/* Table: xj_group_product                                      */
/*==============================================================*/
create table xj_group_product
(
   id                   varchar(50) not null comment '主键',
   group_id             varchar(50) comment '团购ID',
   product_id           varchar(50) comment '商品ID',
   product_qty          int comment '数量，一次团购中包含该商品的数量',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_group_product comment '团购商品表';

/*==============================================================*/
/* Table: xj_members                                            */
/*==============================================================*/
create table xj_members
(
   id                   varchar(50) not null comment '主键',
   phone                varchar(50) comment '手机号，用于登录',
   password             varchar(100) comment '登录密码，md5加密',
   member_no            varchar(50) comment '会员号，注册时生成的随机唯一编码，也可用于登录',
   status               varchar(20) comment '状态，启用：1，停用：0',
   nick_name            varchar(20) comment '会员昵称',
   sex                  varchar(20) comment '性别，男：0，女：1',
   email                varchar(50) comment '电子邮箱',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_members comment '会员信息表';

/*==============================================================*/
/* Table: xj_news                                               */
/*==============================================================*/
create table xj_news
(
   id                   varchar(50) not null comment '主键',
   title                varchar(1000) comment '标题',
   sub_title            varchar(1000) comment '副标题',
   category             varchar(20) comment '分类：辛集资讯-0，办事指南-1，劳务招聘-2，劳务维权-3，劳务政策-4，个人求职-5，辛集热点-6，本地号码-7，本地旅游-8',
   thumbnail            varchar(1000) comment '缩略图，列表上显示',
   author               varchar(200) comment '发布人名称',
   from_unit            varchar(200) comment '来源，来自哪里',
   contents             text comment '资讯内容，富文本内容',
   status               varchar(20) comment '资讯状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_news comment '资讯表';

/*==============================================================*/
/* Table: xj_order                                              */
/*==============================================================*/
create table xj_order
(
   id                   varchar(50) not null comment '主键',
   order_code           varchar(100) comment '订单号，随机生成',
   member_id            varchar(50) comment '会员ID',
   address_id           varchar(50) comment '地址ID',
   order_amount         decimal(10,2) comment '订单总额，商品总金额',
   product_amount       decimal(10,2) comment '商品总额',
   ship_amount          decimal(10,2) comment '运费',
   status               varchar(20) comment '状态，1：待支付，2：已支付，3：已发货，4：已收货，5：不成团，6：用户取消',
   payment_type         varchar(20) comment '支付方式，1：货到付款，2：微信支付，3：支付宝支付',
   payment_amount       decimal(10,2) comment '支付金额，一般等于订单金额',
   paid_time            datetime comment '支付时间',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_order comment '订单表';

/*==============================================================*/
/* Table: xj_order_item                                         */
/*==============================================================*/
create table xj_order_item
(
   id                   varchar(50) not null comment '主键',
   member_id            varchar(50) comment '会员ID（冗余）',
   order_id             varchar(50) comment '订单ID',
   item_id              varchar(50) comment '项目ID，对应的团购ID',
   price                decimal(10,2) comment '价格，购买的价格',
   qty                  int comment '数量，购买的团购份数',
   comment              varchar(500) comment '备注，可对每个项目进行备注',
   shopping_car_id      varchar(50) comment '购物车ID，用于记录购物车项目转化率',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_order_item comment '订单项目表';

/*==============================================================*/
/* Table: xj_product                                            */
/*==============================================================*/
create table xj_product
(
   id                   varchar(50) not null comment '主键',
   sku                  varchar(20) comment 'SKU',
   name                 varchar(200) comment '商品名称',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   imgs                 varchar(1000) comment '商品图片，多张图片以（|）分隔（预留）',
   original_price       decimal(10,2) comment '原价',
   price                decimal(10,2) comment '现价',
   unit                 varchar(20) comment '单位',
   description          text comment '商品详情，富文本商品详情',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_product comment '商品信息表';

/*==============================================================*/
/* Table: xj_shopping_car_log                                   */
/*==============================================================*/
create table xj_shopping_car_log
(
   id                   varchar(50) not null comment '主键',
   member_id            varchar(50) comment '会员ID',
   item_id              varchar(50) comment '项目ID，对应的团购ID',
   price                decimal(10,2) comment '价格',
   qty                  int comment '数量',
   comment              varchar(500) comment '备注，可对每个项目进行备注',
   status               varchar(20) comment '状态，1：待下单，2：已下单，',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_shopping_car_log comment '购物车记录表';

/*==============================================================*/
/* Table: xj_town_info                                          */
/*==============================================================*/
create table xj_town_info
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200) comment '名称',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   banner_imgs          varchar(2000) comment 'banner图片，多张以（|） 分隔',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   category_ids         varchar(2000) comment '栏目id，多个以|分隔',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_town_info comment '乡镇信息表';

/*==============================================================*/
/* Table: xj_town_news                                          */
/*==============================================================*/
create table xj_town_news
(
   id                   varchar(50) not null comment '主键',
   town_id              varchar(50) comment '乡镇ID',
   category_id          varchar(50) comment '分类ID',
   title                varchar(1000) comment '标题',
   sub_title            varchar(1000) comment '副标题',
   thumbnail            varchar(200) comment '缩略图，列表上显示',
   author               varchar(200) comment '发布人名称',
   from_unit            varchar(500) comment '来源',
   contents             text comment '资讯内容，富文本内容',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_town_news comment '乡镇资讯表';

/*==============================================================*/
/* Table: xj_town_news_category                                 */
/*==============================================================*/
create table xj_town_news_category
(
   id                   varchar(50) not null comment '主键',
   name                 varchar(200) comment '名称',
   icon                 varchar(200) comment '图标',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_town_news_category comment '乡镇资讯分类表';

/*==============================================================*/
/* Table: xj_visit_card                                         */
/*==============================================================*/
create table xj_visit_card
(
   id                   varchar(50) not null comment '主键',
   title                varchar(1000) comment '标题',
   thumbnail            varchar(500) comment '缩略图，列表上显示',
   content              text comment '详细内容，富文本内容',
   sort_order           int comment '序号',
   status               varchar(20) comment '状态，启用：1，停用：0',
   create_by            varchar(50) comment '创建人登录名称',
   create_name          varchar(50) comment '创建人名字',
   create_date          datetime comment '创建日期',
   update_by            varchar(50) comment '更新人登录名称',
   update_name          varchar(50) comment '更新人名字',
   update_date          datetime comment '更新日期',
   primary key (id)
);

alter table xj_visit_card comment '辛集名片表';

