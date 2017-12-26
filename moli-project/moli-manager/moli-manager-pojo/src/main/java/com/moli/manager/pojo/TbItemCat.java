package com.moli.manager.pojo;

import java.util.Date;

/**
 * 商品类目表
 * 
 * @author wcyong
 * 
 * @date 2017-12-25
 */
public class TbItemCat {
    /**
     * 商品类目id
     */
    private Long id;

    /**
     * 父目录id为0时代表顶级目录
     */
    private Long parentId;

    /**
     * 类目名称
     */
    private String name;

    /**
     * 状态：1正常   2删除
     */
    private Integer status;

    /**
     * 同级目录的展示次序
     */
    private Integer sortOrder;

    /**
     * 是否为父级类目，1为true  0为false
     */
    private Boolean isParent;

    /**
     * 创建时间
     */
    private Date created;

    /**
     * 更新时间
     */
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}