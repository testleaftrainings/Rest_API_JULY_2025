package week4.day2.servicenow.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Result {

    private String parent;
    @JsonProperty(value = "made_sla")
    private String madeSla;
    @JsonProperty(value = "caused_by")
    private String causedBy;
    @JsonProperty(value = "watch_list")
    private String watchList;
    @JsonProperty(value = "upon_reject")
    private String uponReject;
    @JsonProperty(value = "sys_updated_on")
    private String sysUpdatedOn;
    @JsonProperty(value = "child_incidents")
    private String childIncidents;
    @JsonProperty(value = "hold_reason")
    private String holdReason;
    @JsonProperty(value = "origin_table")
    private String originTable;
    @JsonProperty(value = "task_effective_number")
    private String taskEffectiveNumber;
    @JsonProperty(value = "approval_history")
    private String approvalHistory;
    private String number;
    @JsonProperty(value = "resolved_by")
    private String resolvedBy;
    @JsonProperty(value = "sys_updated_by")
    private String sysUpdatedBy;
    @JsonProperty(value = "opened_by")
    private OpenedBy openedBy;
    @JsonProperty(value = "user_input")
    private String userInput;
    @JsonProperty(value = "sys_created_on")
    private String sysCreatedOn;
    @JsonProperty(value = "sys_domain")
    private SysDomain sysDomain;
    private String state;
    @JsonProperty(value = "route_reason")
    private String routeReason;
    @JsonProperty(value = "sys_created_by")
    private String sysCreatedBy;
    private String knowledge;
    private String order;
    @JsonProperty(value = "calendar_stc")
    private String calendarStc;
    @JsonProperty(value = "closed_at")
    private String closedAt;
    @JsonProperty(value = "cmdb_ci")
    private String cmdbCi;
    @JsonProperty(value = "delivery_plan")
    private String deliveryPlan;
    private String contract;
    private String impact;
    private String active;
    @JsonProperty(value = "work_notes_list")
    private String workNotesList;
    @JsonProperty(value = "business_service")
    private String businessService;
    @JsonProperty(value = "business_impact")
    private String businessImpact;
    private String priority;
    @JsonProperty(value = "sys_domain_path")
    private String sysDomainPath;
    private String rfc;
    @JsonProperty(value = "time_worked")
    private String timeWorked;
    @JsonProperty(value = "expected_start")
    private String expectedStart;
    @JsonProperty(value = "opened_at")
    private String openedAt;
    @JsonProperty(value = "business_duration")
    private String businessDuration;
    @JsonProperty(value = "group_list")
    private String groupList;
    @JsonProperty(value = "work_end")
    private String workEnd;
    @JsonProperty(value = "caller_id")
    private String callerId;
    @JsonProperty(value = "reopened_time")
    private String reopenedTime;
    @JsonProperty(value = "resolved_at")
    private String resolvedAt;
    @JsonProperty(value = "approval_set")
    private String approvalSet;    
    private String subcategory;
    @JsonProperty(value = "work_notes")
    private String workNotes;
    @JsonProperty(value = "universal_request")
    private String universalRequest;
    @JsonProperty(value = "short_description")
    private String shortDescription;
    @JsonProperty(value = "close_code")
    private String closeCode;
    @JsonProperty(value = "correlation_display")
    private String correlationDisplay;
    @JsonProperty(value = "delivery_task")
    private String deliveryTask;
    @JsonProperty(value = "work_start")
    private String workStart;
    @JsonProperty(value = "assignment_group")
    private String assignmentGroup;
    @JsonProperty(value = "additional_assignee_list")
    private String additionalAssigneeList;
    @JsonProperty(value = "business_stc")
    private String businessStc;
    private String cause;
    private String description;
    @JsonProperty(value = "origin_id")
    private String originId;
    @JsonProperty(value = "calendar_duration")
    private String calendarDuration;
    @JsonProperty(value = "close_notes")
    private String closeNotes;
    private String notify;
    @JsonProperty(value = "service_offering")
    private String serviceOffering;
    @JsonProperty(value = "sys_class_name")
    private String sysClassName;
    @JsonProperty(value = "closed_by")
    private String closedBy;
    @JsonProperty(value = "follow_up")
    private String followUp;
    @JsonProperty(value = "parent_incident")
    private String parentIncident;
    @JsonProperty(value = "sys_id")
    private String sysId;
    @JsonProperty(value = "contact_type")
    private String contactType;
    @JsonProperty(value = "reopened_by")
    private String reopenedBy;
    @JsonProperty(value = "incident_state")
    private String incidentState;
    private String urgency;
    @JsonProperty(value = "problem_id")
    private String problemId;
    private String company;
    @JsonProperty(value = "reassignment_count")
    private String reassignmentCount;
    @JsonProperty(value = "activity_due")
    private String activityDue;
    @JsonProperty(value = "assigned_to")
    private String assignedTo;
    private String severity;
    private String comments;
    private String approval;
    @JsonProperty(value = "sla_due")
    private String slaDue;
    @JsonProperty(value = "comments_and_work_notes")
    private String commentsAndWorkNotes;
    @JsonProperty(value = "due_date")
    private String dueDate;
    @JsonProperty(value = "sys_mod_count")
    private String sysModCount;
    @JsonProperty(value = "reopen_count")
    private String reopenCount;
    @JsonProperty(value = "sys_tags")
    private String sysTags;
    private String escalation;
    @JsonProperty(value = "upon_approval")
    private String uponApproval;
    @JsonProperty(value = "correlation_id")
    private String correlationId;
    private String location;
    private String category;    

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getMadeSla() {
        return madeSla;
    }

    public void setMadeSla(String madeSla) {
        this.madeSla = madeSla;
    }

    public String getCausedBy() {
        return causedBy;
    }

    public void setCausedBy(String causedBy) {
        this.causedBy = causedBy;
    }

    public String getWatchList() {
        return watchList;
    }

    public void setWatchList(String watchList) {
        this.watchList = watchList;
    }

    public String getUponReject() {
        return uponReject;
    }

    public void setUponReject(String uponReject) {
        this.uponReject = uponReject;
    }

    public String getSysUpdatedOn() {
        return sysUpdatedOn;
    }

    public void setSysUpdatedOn(String sysUpdatedOn) {
        this.sysUpdatedOn = sysUpdatedOn;
    }

    public String getChildIncidents() {
        return childIncidents;
    }

    public void setChildIncidents(String childIncidents) {
        this.childIncidents = childIncidents;
    }

    public String getHoldReason() {
        return holdReason;
    }

    public void setHoldReason(String holdReason) {
        this.holdReason = holdReason;
    }

    public String getOriginTable() {
        return originTable;
    }

    public void setOriginTable(String originTable) {
        this.originTable = originTable;
    }

    public String getTaskEffectiveNumber() {
        return taskEffectiveNumber;
    }

    public void setTaskEffectiveNumber(String taskEffectiveNumber) {
        this.taskEffectiveNumber = taskEffectiveNumber;
    }

    public String getApprovalHistory() {
        return approvalHistory;
    }

    public void setApprovalHistory(String approvalHistory) {
        this.approvalHistory = approvalHistory;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getResolvedBy() {
        return resolvedBy;
    }

    public void setResolvedBy(String resolvedBy) {
        this.resolvedBy = resolvedBy;
    }

    public String getSysUpdatedBy() {
        return sysUpdatedBy;
    }

    public void setSysUpdatedBy(String sysUpdatedBy) {
        this.sysUpdatedBy = sysUpdatedBy;
    }

    public OpenedBy getOpenedBy() {
        return openedBy;
    }

    public void setOpenedBy(OpenedBy openedBy) {
        this.openedBy = openedBy;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getSysCreatedOn() {
        return sysCreatedOn;
    }

    public void setSysCreatedOn(String sysCreatedOn) {
        this.sysCreatedOn = sysCreatedOn;
    }

    public SysDomain getSysDomain() {
        return sysDomain;
    }

    public void setSysDomain(SysDomain sysDomain) {
        this.sysDomain = sysDomain;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRouteReason() {
        return routeReason;
    }

    public void setRouteReason(String routeReason) {
        this.routeReason = routeReason;
    }

    public String getSysCreatedBy() {
        return sysCreatedBy;
    }

    public void setSysCreatedBy(String sysCreatedBy) {
        this.sysCreatedBy = sysCreatedBy;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getCalendarStc() {
        return calendarStc;
    }

    public void setCalendarStc(String calendarStc) {
        this.calendarStc = calendarStc;
    }

    public String getClosedAt() {
        return closedAt;
    }

    public void setClosedAt(String closedAt) {
        this.closedAt = closedAt;
    }

    public String getCmdbCi() {
        return cmdbCi;
    }

    public void setCmdbCi(String cmdbCi) {
        this.cmdbCi = cmdbCi;
    }

    public String getDeliveryPlan() {
        return deliveryPlan;
    }

    public void setDeliveryPlan(String deliveryPlan) {
        this.deliveryPlan = deliveryPlan;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getWorkNotesList() {
        return workNotesList;
    }

    public void setWorkNotesList(String workNotesList) {
        this.workNotesList = workNotesList;
    }

    public String getBusinessService() {
        return businessService;
    }

    public void setBusinessService(String businessService) {
        this.businessService = businessService;
    }

    public String getBusinessImpact() {
        return businessImpact;
    }

    public void setBusinessImpact(String businessImpact) {
        this.businessImpact = businessImpact;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getSysDomainPath() {
        return sysDomainPath;
    }

    public void setSysDomainPath(String sysDomainPath) {
        this.sysDomainPath = sysDomainPath;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTimeWorked() {
        return timeWorked;
    }

    public void setTimeWorked(String timeWorked) {
        this.timeWorked = timeWorked;
    }

    public String getExpectedStart() {
        return expectedStart;
    }

    public void setExpectedStart(String expectedStart) {
        this.expectedStart = expectedStart;
    }

    public String getOpenedAt() {
        return openedAt;
    }

    public void setOpenedAt(String openedAt) {
        this.openedAt = openedAt;
    }

    public String getBusinessDuration() {
        return businessDuration;
    }

    public void setBusinessDuration(String businessDuration) {
        this.businessDuration = businessDuration;
    }

    public String getGroupList() {
        return groupList;
    }

    public void setGroupList(String groupList) {
        this.groupList = groupList;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        this.workEnd = workEnd;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getReopenedTime() {
        return reopenedTime;
    }

    public void setReopenedTime(String reopenedTime) {
        this.reopenedTime = reopenedTime;
    }

    public String getResolvedAt() {
        return resolvedAt;
    }

    public void setResolvedAt(String resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    public String getApprovalSet() {
        return approvalSet;
    }

    public void setApprovalSet(String approvalSet) {
        this.approvalSet = approvalSet;
    }

    public String getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }

    public String getWorkNotes() {
        return workNotes;
    }

    public void setWorkNotes(String workNotes) {
        this.workNotes = workNotes;
    }

    public String getUniversalRequest() {
        return universalRequest;
    }

    public void setUniversalRequest(String universalRequest) {
        this.universalRequest = universalRequest;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getCloseCode() {
        return closeCode;
    }

    public void setCloseCode(String closeCode) {
        this.closeCode = closeCode;
    }

    public String getCorrelationDisplay() {
        return correlationDisplay;
    }

    public void setCorrelationDisplay(String correlationDisplay) {
        this.correlationDisplay = correlationDisplay;
    }

    public String getDeliveryTask() {
        return deliveryTask;
    }

    public void setDeliveryTask(String deliveryTask) {
        this.deliveryTask = deliveryTask;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    public String getAssignmentGroup() {
        return assignmentGroup;
    }

    public void setAssignmentGroup(String assignmentGroup) {
        this.assignmentGroup = assignmentGroup;
    }

    public String getAdditionalAssigneeList() {
        return additionalAssigneeList;
    }

    public void setAdditionalAssigneeList(String additionalAssigneeList) {
        this.additionalAssigneeList = additionalAssigneeList;
    }

    public String getBusinessStc() {
        return businessStc;
    }

    public void setBusinessStc(String businessStc) {
        this.businessStc = businessStc;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginId() {
        return originId;
    }

    public void setOriginId(String originId) {
        this.originId = originId;
    }

    public String getCalendarDuration() {
        return calendarDuration;
    }

    public void setCalendarDuration(String calendarDuration) {
        this.calendarDuration = calendarDuration;
    }

    public String getCloseNotes() {
        return closeNotes;
    }

    public void setCloseNotes(String closeNotes) {
        this.closeNotes = closeNotes;
    }

    public String getNotify() {
        return notify;
    }

    public void setNotify(String notify) {
        this.notify = notify;
    }

    public String getServiceOffering() {
        return serviceOffering;
    }

    public void setServiceOffering(String serviceOffering) {
        this.serviceOffering = serviceOffering;
    }

    public String getSysClassName() {
        return sysClassName;
    }

    public void setSysClassName(String sysClassName) {
        this.sysClassName = sysClassName;
    }

    public String getClosedBy() {
        return closedBy;
    }

    public void setClosedBy(String closedBy) {
        this.closedBy = closedBy;
    }

    public String getFollowUp() {
        return followUp;
    }

    public void setFollowUp(String followUp) {
        this.followUp = followUp;
    }

    public String getParentIncident() {
        return parentIncident;
    }

    public void setParentIncident(String parentIncident) {
        this.parentIncident = parentIncident;
    }

    public String getSysId() {
        return sysId;
    }

    public void setSysId(String sysId) {
        this.sysId = sysId;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getReopenedBy() {
        return reopenedBy;
    }

    public void setReopenedBy(String reopenedBy) {
        this.reopenedBy = reopenedBy;
    }

    public String getIncidentState() {
        return incidentState;
    }

    public void setIncidentState(String incidentState) {
        this.incidentState = incidentState;
    }

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public String getProblemId() {
        return problemId;
    }

    public void setProblemId(String problemId) {
        this.problemId = problemId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getReassignmentCount() {
        return reassignmentCount;
    }

    public void setReassignmentCount(String reassignmentCount) {
        this.reassignmentCount = reassignmentCount;
    }

    public String getActivityDue() {
        return activityDue;
    }

    public void setActivityDue(String activityDue) {
        this.activityDue = activityDue;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getSlaDue() {
        return slaDue;
    }

    public void setSlaDue(String slaDue) {
        this.slaDue = slaDue;
    }

    public String getCommentsAndWorkNotes() {
        return commentsAndWorkNotes;
    }

    public void setCommentsAndWorkNotes(String commentsAndWorkNotes) {
        this.commentsAndWorkNotes = commentsAndWorkNotes;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getSysModCount() {
        return sysModCount;
    }

    public void setSysModCount(String sysModCount) {
        this.sysModCount = sysModCount;
    }

    public String getReopenCount() {
        return reopenCount;
    }

    public void setReopenCount(String reopenCount) {
        this.reopenCount = reopenCount;
    }

    public String getSysTags() {
        return sysTags;
    }

    public void setSysTags(String sysTags) {
        this.sysTags = sysTags;
    }

    public String getEscalation() {
        return escalation;
    }

    public void setEscalation(String escalation) {
        this.escalation = escalation;
    }

    public String getUponApproval() {
        return uponApproval;
    }

    public void setUponApproval(String uponApproval) {
        this.uponApproval = uponApproval;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }    

}