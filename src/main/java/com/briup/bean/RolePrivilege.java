package com.briup.bean;

public class RolePrivilege {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role_privilege.id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role_privilege.rold_id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    private Integer roldId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_role_privilege.privilege_id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    private Integer privilegeId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role_privilege.id
     *
     * @return the value of cms_role_privilege.id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role_privilege.id
     *
     * @param id the value for cms_role_privilege.id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role_privilege.rold_id
     *
     * @return the value of cms_role_privilege.rold_id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    public Integer getRoldId() {
        return roldId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role_privilege.rold_id
     *
     * @param roldId the value for cms_role_privilege.rold_id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    public void setRoldId(Integer roldId) {
        this.roldId = roldId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_role_privilege.privilege_id
     *
     * @return the value of cms_role_privilege.privilege_id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    public Integer getPrivilegeId() {
        return privilegeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_role_privilege.privilege_id
     *
     * @param privilegeId the value for cms_role_privilege.privilege_id
     *
     * @mbg.generated Mon Nov 18 09:31:02 CST 2019
     */
    public void setPrivilegeId(Integer privilegeId) {
        this.privilegeId = privilegeId;
    }
}