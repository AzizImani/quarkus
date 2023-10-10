package org.agoncal.fascicle.quarkus.mappers;

import java.util.Date;

public class ApiError {
    private final Date errorDate;
    private final String reason;

    public ApiError(Date errorDate, String reason) {
        this.errorDate = errorDate;
        this.reason = reason;
    }

    public Date getErrorDate() {
        return errorDate;
    }

    public String getReason() {
        return reason;
    }
}
