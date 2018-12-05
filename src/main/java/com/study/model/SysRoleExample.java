package com.study.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysRoleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRoleFlowIsNull() {
            addCriterion("role_flow is null");
            return (Criteria) this;
        }

        public Criteria andRoleFlowIsNotNull() {
            addCriterion("role_flow is not null");
            return (Criteria) this;
        }

        public Criteria andRoleFlowEqualTo(String value) {
            addCriterion("role_flow =", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowNotEqualTo(String value) {
            addCriterion("role_flow <>", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowGreaterThan(String value) {
            addCriterion("role_flow >", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowGreaterThanOrEqualTo(String value) {
            addCriterion("role_flow >=", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowLessThan(String value) {
            addCriterion("role_flow <", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowLessThanOrEqualTo(String value) {
            addCriterion("role_flow <=", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowLike(String value) {
            addCriterion("role_flow like", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowNotLike(String value) {
            addCriterion("role_flow not like", value, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowIn(List<String> values) {
            addCriterion("role_flow in", values, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowNotIn(List<String> values) {
            addCriterion("role_flow not in", values, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowBetween(String value1, String value2) {
            addCriterion("role_flow between", value1, value2, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleFlowNotBetween(String value1, String value2) {
            addCriterion("role_flow not between", value1, value2, "roleFlow");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andUseMarkIsNull() {
            addCriterion("use_mark is null");
            return (Criteria) this;
        }

        public Criteria andUseMarkIsNotNull() {
            addCriterion("use_mark is not null");
            return (Criteria) this;
        }

        public Criteria andUseMarkEqualTo(String value) {
            addCriterion("use_mark =", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkNotEqualTo(String value) {
            addCriterion("use_mark <>", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkGreaterThan(String value) {
            addCriterion("use_mark >", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkGreaterThanOrEqualTo(String value) {
            addCriterion("use_mark >=", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkLessThan(String value) {
            addCriterion("use_mark <", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkLessThanOrEqualTo(String value) {
            addCriterion("use_mark <=", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkLike(String value) {
            addCriterion("use_mark like", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkNotLike(String value) {
            addCriterion("use_mark not like", value, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkIn(List<String> values) {
            addCriterion("use_mark in", values, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkNotIn(List<String> values) {
            addCriterion("use_mark not in", values, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkBetween(String value1, String value2) {
            addCriterion("use_mark between", value1, value2, "useMark");
            return (Criteria) this;
        }

        public Criteria andUseMarkNotBetween(String value1, String value2) {
            addCriterion("use_mark not between", value1, value2, "useMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkIsNull() {
            addCriterion("delete_mark is null");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkIsNotNull() {
            addCriterion("delete_mark is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkEqualTo(String value) {
            addCriterion("delete_mark =", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotEqualTo(String value) {
            addCriterion("delete_mark <>", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkGreaterThan(String value) {
            addCriterion("delete_mark >", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkGreaterThanOrEqualTo(String value) {
            addCriterion("delete_mark >=", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkLessThan(String value) {
            addCriterion("delete_mark <", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkLessThanOrEqualTo(String value) {
            addCriterion("delete_mark <=", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkLike(String value) {
            addCriterion("delete_mark like", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotLike(String value) {
            addCriterion("delete_mark not like", value, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkIn(List<String> values) {
            addCriterion("delete_mark in", values, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotIn(List<String> values) {
            addCriterion("delete_mark not in", values, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkBetween(String value1, String value2) {
            addCriterion("delete_mark between", value1, value2, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andDeleteMarkNotBetween(String value1, String value2) {
            addCriterion("delete_mark not between", value1, value2, "deleteMark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUserFlowIsNull() {
            addCriterion("user_flow is null");
            return (Criteria) this;
        }

        public Criteria andUserFlowIsNotNull() {
            addCriterion("user_flow is not null");
            return (Criteria) this;
        }

        public Criteria andUserFlowEqualTo(String value) {
            addCriterion("user_flow =", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowNotEqualTo(String value) {
            addCriterion("user_flow <>", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowGreaterThan(String value) {
            addCriterion("user_flow >", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowGreaterThanOrEqualTo(String value) {
            addCriterion("user_flow >=", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowLessThan(String value) {
            addCriterion("user_flow <", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowLessThanOrEqualTo(String value) {
            addCriterion("user_flow <=", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowLike(String value) {
            addCriterion("user_flow like", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowNotLike(String value) {
            addCriterion("user_flow not like", value, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowIn(List<String> values) {
            addCriterion("user_flow in", values, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowNotIn(List<String> values) {
            addCriterion("user_flow not in", values, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowBetween(String value1, String value2) {
            addCriterion("user_flow between", value1, value2, "userFlow");
            return (Criteria) this;
        }

        public Criteria andUserFlowNotBetween(String value1, String value2) {
            addCriterion("user_flow not between", value1, value2, "userFlow");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}