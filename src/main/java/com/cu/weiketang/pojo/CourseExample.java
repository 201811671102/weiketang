package com.cu.weiketang.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CourseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CourseExample() {
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCpictureIsNull() {
            addCriterion("cpicture is null");
            return (Criteria) this;
        }

        public Criteria andCpictureIsNotNull() {
            addCriterion("cpicture is not null");
            return (Criteria) this;
        }

        public Criteria andCpictureEqualTo(String value) {
            addCriterion("cpicture =", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotEqualTo(String value) {
            addCriterion("cpicture <>", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureGreaterThan(String value) {
            addCriterion("cpicture >", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureGreaterThanOrEqualTo(String value) {
            addCriterion("cpicture >=", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureLessThan(String value) {
            addCriterion("cpicture <", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureLessThanOrEqualTo(String value) {
            addCriterion("cpicture <=", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureLike(String value) {
            addCriterion("cpicture like", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotLike(String value) {
            addCriterion("cpicture not like", value, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureIn(List<String> values) {
            addCriterion("cpicture in", values, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotIn(List<String> values) {
            addCriterion("cpicture not in", values, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureBetween(String value1, String value2) {
            addCriterion("cpicture between", value1, value2, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCpictureNotBetween(String value1, String value2) {
            addCriterion("cpicture not between", value1, value2, "cpicture");
            return (Criteria) this;
        }

        public Criteria andCintroduceIsNull() {
            addCriterion("cintroduce is null");
            return (Criteria) this;
        }

        public Criteria andCintroduceIsNotNull() {
            addCriterion("cintroduce is not null");
            return (Criteria) this;
        }

        public Criteria andCintroduceEqualTo(String value) {
            addCriterion("cintroduce =", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceNotEqualTo(String value) {
            addCriterion("cintroduce <>", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceGreaterThan(String value) {
            addCriterion("cintroduce >", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceGreaterThanOrEqualTo(String value) {
            addCriterion("cintroduce >=", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceLessThan(String value) {
            addCriterion("cintroduce <", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceLessThanOrEqualTo(String value) {
            addCriterion("cintroduce <=", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceLike(String value) {
            addCriterion("cintroduce like", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceNotLike(String value) {
            addCriterion("cintroduce not like", value, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceIn(List<String> values) {
            addCriterion("cintroduce in", values, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceNotIn(List<String> values) {
            addCriterion("cintroduce not in", values, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceBetween(String value1, String value2) {
            addCriterion("cintroduce between", value1, value2, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCintroduceNotBetween(String value1, String value2) {
            addCriterion("cintroduce not between", value1, value2, "cintroduce");
            return (Criteria) this;
        }

        public Criteria andCgradeIsNull() {
            addCriterion("cgrade is null");
            return (Criteria) this;
        }

        public Criteria andCgradeIsNotNull() {
            addCriterion("cgrade is not null");
            return (Criteria) this;
        }

        public Criteria andCgradeEqualTo(String value) {
            addCriterion("cgrade =", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeNotEqualTo(String value) {
            addCriterion("cgrade <>", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeGreaterThan(String value) {
            addCriterion("cgrade >", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeGreaterThanOrEqualTo(String value) {
            addCriterion("cgrade >=", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeLessThan(String value) {
            addCriterion("cgrade <", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeLessThanOrEqualTo(String value) {
            addCriterion("cgrade <=", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeLike(String value) {
            addCriterion("cgrade like", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeNotLike(String value) {
            addCriterion("cgrade not like", value, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeIn(List<String> values) {
            addCriterion("cgrade in", values, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeNotIn(List<String> values) {
            addCriterion("cgrade not in", values, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeBetween(String value1, String value2) {
            addCriterion("cgrade between", value1, value2, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCgradeNotBetween(String value1, String value2) {
            addCriterion("cgrade not between", value1, value2, "cgrade");
            return (Criteria) this;
        }

        public Criteria andCrequirementsIsNull() {
            addCriterion("crequirements is null");
            return (Criteria) this;
        }

        public Criteria andCrequirementsIsNotNull() {
            addCriterion("crequirements is not null");
            return (Criteria) this;
        }

        public Criteria andCrequirementsEqualTo(Integer value) {
            addCriterion("crequirements =", value, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsNotEqualTo(Integer value) {
            addCriterion("crequirements <>", value, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsGreaterThan(Integer value) {
            addCriterion("crequirements >", value, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsGreaterThanOrEqualTo(Integer value) {
            addCriterion("crequirements >=", value, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsLessThan(Integer value) {
            addCriterion("crequirements <", value, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsLessThanOrEqualTo(Integer value) {
            addCriterion("crequirements <=", value, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsIn(List<Integer> values) {
            addCriterion("crequirements in", values, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsNotIn(List<Integer> values) {
            addCriterion("crequirements not in", values, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsBetween(Integer value1, Integer value2) {
            addCriterion("crequirements between", value1, value2, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCrequirementsNotBetween(Integer value1, Integer value2) {
            addCriterion("crequirements not between", value1, value2, "crequirements");
            return (Criteria) this;
        }

        public Criteria andCnumberIsNull() {
            addCriterion("cnumber is null");
            return (Criteria) this;
        }

        public Criteria andCnumberIsNotNull() {
            addCriterion("cnumber is not null");
            return (Criteria) this;
        }

        public Criteria andCnumberEqualTo(String value) {
            addCriterion("cnumber =", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotEqualTo(String value) {
            addCriterion("cnumber <>", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberGreaterThan(String value) {
            addCriterion("cnumber >", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberGreaterThanOrEqualTo(String value) {
            addCriterion("cnumber >=", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberLessThan(String value) {
            addCriterion("cnumber <", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberLessThanOrEqualTo(String value) {
            addCriterion("cnumber <=", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberLike(String value) {
            addCriterion("cnumber like", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotLike(String value) {
            addCriterion("cnumber not like", value, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberIn(List<String> values) {
            addCriterion("cnumber in", values, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotIn(List<String> values) {
            addCriterion("cnumber not in", values, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberBetween(String value1, String value2) {
            addCriterion("cnumber between", value1, value2, "cnumber");
            return (Criteria) this;
        }

        public Criteria andCnumberNotBetween(String value1, String value2) {
            addCriterion("cnumber not between", value1, value2, "cnumber");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Integer value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Integer value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Integer value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Integer value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Integer value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Integer> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Integer> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Integer value1, Integer value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Integer value1, Integer value2) {
            addCriterion("uid not between", value1, value2, "uid");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Boolean value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Boolean value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Boolean value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Boolean value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Boolean value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Boolean> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Boolean> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Boolean value1, Boolean value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("state not between", value1, value2, "state");
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