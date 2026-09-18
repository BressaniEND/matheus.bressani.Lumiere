package com.lumiere;

public class LumiereBusinessRulesGateway {

    public boolean canAuthorizePricingChange(String actorRole, String productId) {
        return isManager(actorRole) && hasText(productId);
    }

    public boolean canPromiseAvailability(int availableStock, boolean reservable) {
        return availableStock > 0 && reservable;
    }

    public boolean shouldSendSingleNotificationPerChannel(String channel, String eventId, String customerId) {
        return hasText(channel) && hasText(eventId) && hasText(customerId);
    }

    public boolean canSendPromotionalMessage(String customerId, String channel, boolean consentGranted, boolean consentSeparate) {
        return hasText(customerId) && hasText(channel) && consentGranted && consentSeparate;
    }

    public boolean isSingleChargeAndSingleOrder(String paymentId, String orderId) {
        return hasText(paymentId) && hasText(orderId);
    }

    public boolean shouldProcessOnlyNewDataDaily(String dataSet, boolean hasNewData) {
        return hasText(dataSet) && hasNewData;
    }

    public boolean canSearchByNameBrandCodeAndNotes(String term) {
        return hasText(term);
    }

    public boolean canApplyCombinedFilters(String occasion, String family, String notes, double maxPrice) {
        return hasText(occasion) && hasText(family) && hasText(notes) && maxPrice >= 0;
    }

    public boolean canRenderProductSheet(String productId, String family, String notes) {
        return hasText(productId) && hasText(family) && hasText(notes);
    }

    public boolean canCompareUpToThreeProducts(int itemCount) {
        return itemCount >= 1 && itemCount <= 3;
    }

    public boolean canSaveFavoritesAndAlerts(String customerId, String productId, boolean eligibleForReplenishment) {
        return hasText(customerId) && hasText(productId) && eligibleForReplenishment;
    }

    public boolean canRecommendWithJustification(String customerId, String occasion, String notes) {
        return hasText(customerId) && hasText(occasion) && hasText(notes);
    }

    public boolean shouldAvoidDuplicatePayment(String paymentId, String orderId, boolean retryAttempt) {
        return hasText(paymentId) && hasText(orderId);
    }

    public boolean shouldAllowCheckoutReviewBeforePayment(boolean subtotalKnown, boolean freightKnown, boolean totalKnown) {
        return subtotalKnown && freightKnown && totalKnown;
    }

    public boolean shouldKeepAvailabilityFreightAndDeadlineConsistent(boolean stockValid, boolean freightValid, boolean deadlineValid) {
        return stockValid && freightValid && deadlineValid;
    }

    public boolean canManageCatalogByAuthorizedManager(String actorRole, String productId) {
        return isManager(actorRole) && hasText(productId);
    }

    public boolean shouldExposeOrderWithHistoryAndStatus(String orderId, boolean hasItems, boolean hasHistory) {
        return hasText(orderId) && hasItems && hasHistory;
    }

    public boolean canConsultAuthorizedCatalogForAgent(String actorRole, String scope) {
        return "consultant".equalsIgnoreCase(actorRole) && hasText(scope);
    }

    public boolean shouldSendTransactionalNotification(String eventType, String channel, boolean consentValid) {
        return hasText(eventType) && hasText(channel) && consentValid;
    }

    public boolean canManageCustomerPreferences(String customerId, boolean hasConsent, boolean hasIdentity) {
        return hasText(customerId) && hasConsent && hasIdentity;
    }

    public boolean canProcessReturnOrRefund(String orderId, String customerId, boolean withinPolicy) {
        return hasText(orderId) && hasText(customerId) && withinPolicy;
    }

    public boolean canExportOperationalReport(String actorRole, String dataScope) {
        return isManager(actorRole) && hasText(dataScope);
    }

    public boolean shouldEnforcePermissionAndAudit(String actorRole, String objectId, boolean hasAuthorization) {
        return hasText(actorRole) && hasText(objectId) && hasAuthorization;
    }

    public boolean shouldProcessDailyJobWithOnlyNewData(boolean hasNewData, boolean containsOldData) {
        return hasNewData && !containsOldData;
    }

    public boolean shouldUseClearLanguageAndAllowRecovery(String flowStage, boolean inputValid) {
        return hasText(flowStage) && inputValid;
    }

    public boolean shouldShowRequiredCheckoutInfoBeforePayment(boolean totalsVisible, boolean recoveryAvailable) {
        return totalsVisible && recoveryAvailable;
    }

    public boolean shouldKeepComparisonAccessibleByKeyboard(boolean keyboardSupport, boolean notColorOnly) {
        return keyboardSupport && notColorOnly;
    }

    public boolean shouldMeetWcag22AaRequirements(boolean contrastOk, boolean focusVisible, boolean keyboardNavigationOk) {
        return contrastOk && focusVisible && keyboardNavigationOk;
    }

    public boolean shouldBlockUnauthorizedAccess(String actorRole, String objectType) {
        return hasText(actorRole) && hasText(objectType) && !isManager(actorRole) && !"consultant".equalsIgnoreCase(actorRole);
    }

    public boolean shouldNotExposesSensitiveData(boolean cardPresent, boolean credentialsPresent) {
        return !cardPresent && !credentialsPresent;
    }

    public boolean shouldRespectConsentAndDataMinimization(boolean hasConsent, boolean purposeMatches, boolean minimalData) {
        return hasConsent && purposeMatches && minimalData;
    }

    public boolean shouldProduceAuditTrailWithMasking(String actorRole, String operation, boolean loggingEnabled) {
        return hasText(actorRole) && hasText(operation) && loggingEnabled;
    }

    public boolean shouldMeetCatalogSearchPerformance(double p95Ms) {
        return p95Ms >= 0 && p95Ms <= 2000;
    }

    public boolean shouldMeetCartPerformance(double p95Ms) {
        return p95Ms >= 0 && p95Ms <= 1500;
    }

    public boolean shouldSyncInventoryWithinWindow(double elapsedSeconds, double percentile) {
        return elapsedSeconds >= 0 && elapsedSeconds <= 60 && percentile >= 99;
    }

    public boolean shouldRespondToSupportWithinDeadline(double elapsedSeconds) {
        return elapsedSeconds >= 0 && elapsedSeconds <= 30;
    }

    public boolean shouldSupportMobileAndDesktop(String platform) {
        return "mobile".equalsIgnoreCase(platform) || "desktop".equalsIgnoreCase(platform);
    }

    public boolean shouldRetainCartAndFavoritesAcrossDevices(boolean sameCustomer, boolean crossDevice) {
        return sameCustomer && crossDevice;
    }

    public boolean shouldSupportMajorBrowsers(String browserName) {
        return "Chrome".equalsIgnoreCase(browserName)
                || "Edge".equalsIgnoreCase(browserName)
                || "Firefox".equalsIgnoreCase(browserName)
                || "Safari".equalsIgnoreCase(browserName);
    }

    public boolean shouldMeetAvailabilityGoal(double monthlyAvailability) {
        return monthlyAvailability >= 99.5 && monthlyAvailability <= 100;
    }

    public boolean shouldRequireAuthorizationForCriticalChanges(String actorRole, boolean isCriticalChange) {
        return !isCriticalChange || isManager(actorRole);
    }

    public boolean shouldAvoidPaymentAndNotificationDuplication(boolean duplicatePayment, boolean duplicateNotification) {
        return !duplicatePayment && !duplicateNotification;
    }

    public boolean shouldReconcileSalesInventoryFreightAndPayments(boolean salesAligned, boolean inventoryAligned, boolean freightAligned, boolean paymentsAligned) {
        return salesAligned && inventoryAligned && freightAligned && paymentsAligned;
    }

    public boolean shouldAlertWithinFiveMinutes(double elapsedMinutes) {
        return elapsedMinutes >= 0 && elapsedMinutes <= 5;
    }

    public boolean shouldRecoverWithinRtoAndRpo(double rtoHours, double rpoHours) {
        return rtoHours >= 0 && rtoHours <= 4 && rpoHours >= 0 && rpoHours <= 1;
    }

    public boolean shouldSupportBackupAndRecoveryPlan(boolean backupConfigured, boolean restoreValidated) {
        return backupConfigured && restoreValidated;
    }

    public boolean shouldAllowCatalogContentToChangeWithoutBreakingCheckout(boolean contentEditable, boolean checkoutStable) {
        return contentEditable && checkoutStable;
    }

    public boolean shouldMaintainVersionHistoryForCatalog(String productId, boolean hasVersionHistory) {
        return hasText(productId) && hasVersionHistory;
    }

    public boolean shouldHaveVersionedContractsAndRuleTests(boolean contractsVersioned, boolean ruleTestsPresent) {
        return contractsVersioned && ruleTestsPresent;
    }

    public boolean shouldProvideTraceabilityForRecoveryAndTraining(boolean hasTraceability) {
        return hasTraceability;
    }

    public boolean shouldCorrelateOrderAndSupportEvents(boolean correlationPresent) {
        return correlationPresent;
    }

    public boolean shouldRecordResponsibleAndOutcome(String actorRole, String object, boolean resultRecorded) {
        return hasText(actorRole) && hasText(object) && resultRecorded;
    }

    public boolean shouldDisplaySourceAndTimestamp(String source, String timestamp) {
        return hasText(source) && hasText(timestamp);
    }

    public boolean shouldDefineMetricsWithOwnerAndFrequency(String owner, String frequency, boolean metricDefined) {
        return hasText(owner) && hasText(frequency) && metricDefined;
    }

    private boolean isManager(String actorRole) {
        return "manager".equalsIgnoreCase(actorRole) || "admin".equalsIgnoreCase(actorRole);
    }

    private boolean hasText(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
