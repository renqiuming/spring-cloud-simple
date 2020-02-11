package com.rqm.springclouddomain1.model.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
/**
 * @author renqiuming
 * @date 2020/2/3 下午12:03
 */
@TableName("u_user")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 后端盐值
     */
    private String b_salt;

    /**
     * 后端salt值更新时间
     */
    private Date b_salt_update_time;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真实姓名
     */
    private String identity_card_name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 头像url
     */
    private String head_pic_url;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 工号
     */
    private String employe_num;

    private Integer type;

    /**
     * 是否可用，0-不可用，1可用
     */
    private Integer is_available;

    /**
     * 逻辑删除,0-未删除，id-已删除
     */
    private Long is_deleted;

    /**
     * 版本号
     */
    private Integer version_no;

    /**
     * 创建用户ID
     */
    private Long create_userid;

    /**
     * 创建用户名
     */
    private String create_username;

    /**
     * 创建用户MAC
     */
    private String create_usermac;

    /**
     * 创建日期
     */
    private Date create_time;

    /**
     * 创建日期 数据库
     */
    private Date create_time_db;

    /**
     * 服务器ip
     */
    private String server_ip;

    /**
     * 更新用户ID
     */
    private Long update_userid;

    /**
     * 更新用户名
     */
    private String update_username;

    /**
     * 更新用户ip
     */
    private String update_userip;

    /**
     * 更新用户MAC
     */
    private String update_usermac;

    /**
     * 更新时间
     */
    private Date update_time;

    /**
     * 更新时间 数据库
     */
    private Date update_time_db;

    /**
     * 客户端版本号
     */
    private String client_versionno;

    /**
     * 公司ID
     */
    private Long company_id;

    /**
     * 创建用户IP
     */
    private String create_userip;

    /**
     * 数据导入原始id
     */
    private String original_id;

    /**
     * 1.机械师，2诊断师
     */
    private Integer identity_type;

    private Long parent_id;

    /**
     * 公司名称
     */
    private String company_name;

    /**
     * 联系人
     */
    private String contact_person;

    /**
     * 固定电话
     */
    private String telephone;

    /**
     * 地址
     */
    private String address;

    /**
     * 状态：0：待审核；1：审核通过；2：审核不通过；
     */
    private Integer status;

    /**
     * points`
     */
    private BigDecimal points;

    /**
     * 省份
     */
    private String user_province;

    /**
     * 市
     */
    private String user_city;

    /**
     * 区域
     */
    private String user_region;

    /**
     * 用户地址
     */
    private String user_address;

    /**
     * 邮编
     */
    private String post_code;

    /**
     * 审核时间
     */
    private Date check_time;

    /**
     * 审核人id
     */
    private Long check_user_id;

    /**
     * 是否实名认证：默认0未认证，1认证
     */
    private Integer is_certification;

    /**
     * 法人姓名
     */
    private String legal_person_name;

    /**
     * 法人证件号码
     */
    private String legal_personNo_number;

    /**
     * 组织机构代码
     */
    private String organization_code;

    /**
     * 营业执照号码
     */
    private String business_license_number;

    /**
     * 营业执照url
     */
    private String business_license_url;

    /**
     * 公司类型
     */
    private Integer company_type;

    /**
     * 经营范围
     */
    private String business_scope;

    /**
     * 经营开始时间
     */
    private Date business_start;

    /**
     * 经营结束时间
     */
    private Date business_end;

    /**
     * 商家注册地址
     */
    private String registered_address;

    /**
     * 商家注册资金
     */
    private String registered_capital;

    /**
     * 商家总人数
     */
    private Integer population;

    /**
     * 生日被修改的次数
     */
    private Integer birthday_update_count;

    private Long qq;

    /**
     * 数据来源： 0注册会员 1手工录入
     */
    private Integer source;

    /**
     * 前端加密算法版本
     */
    private Integer f_algorithm_version;

    /**
     * 后端加密算法版本
     */
    private Integer b_algorithm_version;

    /**
     * 前端盐值
     */
    private String f_salt;

    /**
     * 前端salt值更新时间
     */
    private Date f_salt_update_time;

    /**
     * 注册平台id
     */
    private Long platform_id;

    /**
     * 平台组id
     */
    private Long platform_group_id;

    /**
     * 实体type(商家、分销商...)
     */
    private Integer entity_type;

    /**
     * 实体id 与entity_type联合使用
     */
    private Long entity_id;

    /**
     * 备注
     */
    private String remark;

    /**
     * 外部id
     */
    private Long exter_id;

    /**
     * 手机号区号
     */
    private String dial_code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getB_salt() {
        return b_salt;
    }

    public void setB_salt(String b_salt) {
        this.b_salt = b_salt;
    }
    public Date getB_salt_update_time() {
        return b_salt_update_time;
    }

    public void setB_salt_update_time(Date b_salt_update_time) {
        this.b_salt_update_time = b_salt_update_time;
    }
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getIdentity_card_name() {
        return identity_card_name;
    }

    public void setIdentity_card_name(String identity_card_name) {
        this.identity_card_name = identity_card_name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public String getHead_pic_url() {
        return head_pic_url;
    }

    public void setHead_pic_url(String head_pic_url) {
        this.head_pic_url = head_pic_url;
    }
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getEmploye_num() {
        return employe_num;
    }

    public void setEmploye_num(String employe_num) {
        this.employe_num = employe_num;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getIs_available() {
        return is_available;
    }

    public void setIs_available(Integer is_available) {
        this.is_available = is_available;
    }
    public Long getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Long is_deleted) {
        this.is_deleted = is_deleted;
    }
    public Integer getVersion_no() {
        return version_no;
    }

    public void setVersion_no(Integer version_no) {
        this.version_no = version_no;
    }
    public Long getCreate_userid() {
        return create_userid;
    }

    public void setCreate_userid(Long create_userid) {
        this.create_userid = create_userid;
    }
    public String getCreate_username() {
        return create_username;
    }

    public void setCreate_username(String create_username) {
        this.create_username = create_username;
    }
    public String getCreate_usermac() {
        return create_usermac;
    }

    public void setCreate_usermac(String create_usermac) {
        this.create_usermac = create_usermac;
    }
    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
    public Date getCreate_time_db() {
        return create_time_db;
    }

    public void setCreate_time_db(Date create_time_db) {
        this.create_time_db = create_time_db;
    }
    public String getServer_ip() {
        return server_ip;
    }

    public void setServer_ip(String server_ip) {
        this.server_ip = server_ip;
    }
    public Long getUpdate_userid() {
        return update_userid;
    }

    public void setUpdate_userid(Long update_userid) {
        this.update_userid = update_userid;
    }
    public String getUpdate_username() {
        return update_username;
    }

    public void setUpdate_username(String update_username) {
        this.update_username = update_username;
    }
    public String getUpdate_userip() {
        return update_userip;
    }

    public void setUpdate_userip(String update_userip) {
        this.update_userip = update_userip;
    }
    public String getUpdate_usermac() {
        return update_usermac;
    }

    public void setUpdate_usermac(String update_usermac) {
        this.update_usermac = update_usermac;
    }
    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
    public Date getUpdate_time_db() {
        return update_time_db;
    }

    public void setUpdate_time_db(Date update_time_db) {
        this.update_time_db = update_time_db;
    }
    public String getClient_versionno() {
        return client_versionno;
    }

    public void setClient_versionno(String client_versionno) {
        this.client_versionno = client_versionno;
    }
    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }
    public String getCreate_userip() {
        return create_userip;
    }

    public void setCreate_userip(String create_userip) {
        this.create_userip = create_userip;
    }
    public String getOriginal_id() {
        return original_id;
    }

    public void setOriginal_id(String original_id) {
        this.original_id = original_id;
    }
    public Integer getIdentity_type() {
        return identity_type;
    }

    public void setIdentity_type(Integer identity_type) {
        this.identity_type = identity_type;
    }
    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }
    public String getContact_person() {
        return contact_person;
    }

    public void setContact_person(String contact_person) {
        this.contact_person = contact_person;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public BigDecimal getPoints() {
        return points;
    }

    public void setPoints(BigDecimal points) {
        this.points = points;
    }
    public String getUser_province() {
        return user_province;
    }

    public void setUser_province(String user_province) {
        this.user_province = user_province;
    }
    public String getUser_city() {
        return user_city;
    }

    public void setUser_city(String user_city) {
        this.user_city = user_city;
    }
    public String getUser_region() {
        return user_region;
    }

    public void setUser_region(String user_region) {
        this.user_region = user_region;
    }
    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }
    public Date getCheck_time() {
        return check_time;
    }

    public void setCheck_time(Date check_time) {
        this.check_time = check_time;
    }
    public Long getCheck_user_id() {
        return check_user_id;
    }

    public void setCheck_user_id(Long check_user_id) {
        this.check_user_id = check_user_id;
    }
    public Integer getIs_certification() {
        return is_certification;
    }

    public void setIs_certification(Integer is_certification) {
        this.is_certification = is_certification;
    }
    public String getLegal_person_name() {
        return legal_person_name;
    }

    public void setLegal_person_name(String legal_person_name) {
        this.legal_person_name = legal_person_name;
    }
    public String getLegal_personNo_number() {
        return legal_personNo_number;
    }

    public void setLegal_personNo_number(String legal_personNo_number) {
        this.legal_personNo_number = legal_personNo_number;
    }
    public String getOrganization_code() {
        return organization_code;
    }

    public void setOrganization_code(String organization_code) {
        this.organization_code = organization_code;
    }
    public String getBusiness_license_number() {
        return business_license_number;
    }

    public void setBusiness_license_number(String business_license_number) {
        this.business_license_number = business_license_number;
    }
    public String getBusiness_license_url() {
        return business_license_url;
    }

    public void setBusiness_license_url(String business_license_url) {
        this.business_license_url = business_license_url;
    }
    public Integer getCompany_type() {
        return company_type;
    }

    public void setCompany_type(Integer company_type) {
        this.company_type = company_type;
    }
    public String getBusiness_scope() {
        return business_scope;
    }

    public void setBusiness_scope(String business_scope) {
        this.business_scope = business_scope;
    }
    public Date getBusiness_start() {
        return business_start;
    }

    public void setBusiness_start(Date business_start) {
        this.business_start = business_start;
    }
    public Date getBusiness_end() {
        return business_end;
    }

    public void setBusiness_end(Date business_end) {
        this.business_end = business_end;
    }
    public String getRegistered_address() {
        return registered_address;
    }

    public void setRegistered_address(String registered_address) {
        this.registered_address = registered_address;
    }
    public String getRegistered_capital() {
        return registered_capital;
    }

    public void setRegistered_capital(String registered_capital) {
        this.registered_capital = registered_capital;
    }
    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }
    public Integer getBirthday_update_count() {
        return birthday_update_count;
    }

    public void setBirthday_update_count(Integer birthday_update_count) {
        this.birthday_update_count = birthday_update_count;
    }
    public Long getQq() {
        return qq;
    }

    public void setQq(Long qq) {
        this.qq = qq;
    }
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }
    public Integer getF_algorithm_version() {
        return f_algorithm_version;
    }

    public void setF_algorithm_version(Integer f_algorithm_version) {
        this.f_algorithm_version = f_algorithm_version;
    }
    public Integer getB_algorithm_version() {
        return b_algorithm_version;
    }

    public void setB_algorithm_version(Integer b_algorithm_version) {
        this.b_algorithm_version = b_algorithm_version;
    }
    public String getF_salt() {
        return f_salt;
    }

    public void setF_salt(String f_salt) {
        this.f_salt = f_salt;
    }
    public Date getF_salt_update_time() {
        return f_salt_update_time;
    }

    public void setF_salt_update_time(Date f_salt_update_time) {
        this.f_salt_update_time = f_salt_update_time;
    }
    public Long getPlatform_id() {
        return platform_id;
    }

    public void setPlatform_id(Long platform_id) {
        this.platform_id = platform_id;
    }
    public Long getPlatform_group_id() {
        return platform_group_id;
    }

    public void setPlatform_group_id(Long platform_group_id) {
        this.platform_group_id = platform_group_id;
    }
    public Integer getEntity_type() {
        return entity_type;
    }

    public void setEntity_type(Integer entity_type) {
        this.entity_type = entity_type;
    }
    public Long getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(Long entity_id) {
        this.entity_id = entity_id;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public Long getExter_id() {
        return exter_id;
    }

    public void setExter_id(Long exter_id) {
        this.exter_id = exter_id;
    }
    public String getDial_code() {
        return dial_code;
    }

    public void setDial_code(String dial_code) {
        this.dial_code = dial_code;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
        "id=" + id +
        ", mobile=" + mobile +
        ", username=" + username +
        ", password=" + password +
        ", b_salt=" + b_salt +
        ", b_salt_update_time=" + b_salt_update_time +
        ", nickname=" + nickname +
        ", identity_card_name=" + identity_card_name +
        ", email=" + email +
        ", remarks=" + remarks +
        ", sex=" + sex +
        ", head_pic_url=" + head_pic_url +
        ", birthday=" + birthday +
        ", employe_num=" + employe_num +
        ", type=" + type +
        ", is_available=" + is_available +
        ", is_deleted=" + is_deleted +
        ", version_no=" + version_no +
        ", create_userid=" + create_userid +
        ", create_username=" + create_username +
        ", create_usermac=" + create_usermac +
        ", create_time=" + create_time +
        ", create_time_db=" + create_time_db +
        ", server_ip=" + server_ip +
        ", update_userid=" + update_userid +
        ", update_username=" + update_username +
        ", update_userip=" + update_userip +
        ", update_usermac=" + update_usermac +
        ", update_time=" + update_time +
        ", update_time_db=" + update_time_db +
        ", client_versionno=" + client_versionno +
        ", company_id=" + company_id +
        ", create_userip=" + create_userip +
        ", original_id=" + original_id +
        ", identity_type=" + identity_type +
        ", parent_id=" + parent_id +
        ", company_name=" + company_name +
        ", contact_person=" + contact_person +
        ", telephone=" + telephone +
        ", address=" + address +
        ", status=" + status +
        ", points=" + points +
        ", user_province=" + user_province +
        ", user_city=" + user_city +
        ", user_region=" + user_region +
        ", user_address=" + user_address +
        ", post_code=" + post_code +
        ", check_time=" + check_time +
        ", check_user_id=" + check_user_id +
        ", is_certification=" + is_certification +
        ", legal_person_name=" + legal_person_name +
        ", legal_personNo_number=" + legal_personNo_number +
        ", organization_code=" + organization_code +
        ", business_license_number=" + business_license_number +
        ", business_license_url=" + business_license_url +
        ", company_type=" + company_type +
        ", business_scope=" + business_scope +
        ", business_start=" + business_start +
        ", business_end=" + business_end +
        ", registered_address=" + registered_address +
        ", registered_capital=" + registered_capital +
        ", population=" + population +
        ", birthday_update_count=" + birthday_update_count +
        ", qq=" + qq +
        ", source=" + source +
        ", f_algorithm_version=" + f_algorithm_version +
        ", b_algorithm_version=" + b_algorithm_version +
        ", f_salt=" + f_salt +
        ", f_salt_update_time=" + f_salt_update_time +
        ", platform_id=" + platform_id +
        ", platform_group_id=" + platform_group_id +
        ", entity_type=" + entity_type +
        ", entity_id=" + entity_id +
        ", remark=" + remark +
        ", exter_id=" + exter_id +
        ", dial_code=" + dial_code +
        "}";
    }
}
