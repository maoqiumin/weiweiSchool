package com.qmmao.weiweischool.dao.teachingdb.entity;

/**
 * @author DELL
 */
public class AuthorityGen {
    private Long id;

    private String authorityCode;

    private String authorityName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorityCode() {
        return authorityCode;
    }

    public void setAuthorityCode(String authorityCode) {
        this.authorityCode = authorityCode;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
