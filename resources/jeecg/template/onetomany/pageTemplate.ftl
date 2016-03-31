package ${bussiPackage}.page.${entityPackage};

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

<#list subTab as sub>
import ${bussiPackage}.entity.${sub.entityPackage}.${sub.entityName}Entity;
</#list>

/**   
 * @Title: Entity
 * @Description: ${ftl_description}
 * @author liliming
 * @date ${ftl_create_time}
 * @version V1.0   
 *
 */
@Entity
@Table(name = "${tableName}", schema = "")
@SuppressWarnings("serial")
public class ${entityName}Page implements java.io.Serializable {
  <#list subTab as sub>
  /**保存-${sub.ftlDescription}*/
  private List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List = new ArrayList<${sub.entityName}Entity>();
  public List<${sub.entityName}Entity> get${sub.entityName}List() {
    return ${sub.entityName?uncap_first}List;
  }
  public void set${sub.entityName}List(List<${sub.entityName}Entity> ${sub.entityName?uncap_first}List) {
    this.${sub.entityName?uncap_first}List = ${sub.entityName?uncap_first}List;
  }
  </#list>


  <#list originalColumns as po>
  /**${po.filedComment}*/
  private ${po.fieldType} ${po.fieldName};
  </#list>
  
  <#list originalColumns as po>
  /**
   *方法: 取得${po.fieldType}
   *@return: ${po.fieldType}  ${po.filedComment}
   */
  <#if po.fieldName == jeecg_table_id>
  
  <#if jeecg_primary_key_policy == 'uuid'>
  @Id
  @GeneratedValue(generator = "paymentableGenerator")
  @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
  </#if>
  <#if jeecg_primary_key_policy == 'identity'>
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  </#if>
  <#if jeecg_primary_key_policy == 'sequence'>
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="sequence")
  @SequenceGenerator(name="sequence",sequenceName="${jeecg_sequence_code}",allocationSize=1)
  </#if>
  </#if>
  @Column(name ="${po.fieldDbName}",nullable=<#if po.nullable == 'Y'>true<#else>false</#if><#if po.precision != ''>,precision=${po.precision}</#if><#if po.scale != ''>,scale=${po.scale}</#if><#if po.charmaxLength != ''&& po.charmaxLength?length lte 8 >,length=${po.charmaxLength}</#if>)
  public ${po.fieldType} get${po.fieldName?cap_first}(){
    return this.${po.fieldName};
  }

  /**
   *方法: 设置${po.fieldType}
   *@param: ${po.fieldType}  ${po.filedComment}
   */
  public void set${po.fieldName?cap_first}(${po.fieldType} ${po.fieldName}){
    this.${po.fieldName} = ${po.fieldName};
  }
  </#list>
}
