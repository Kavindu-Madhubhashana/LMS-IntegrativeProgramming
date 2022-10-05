package lk.ac.kln.lms.domain;

import lk.ac.kln.lms.enums.Status;

import java.sql.Date;

public abstract class Auditable {

    private Status status;

    private Date createdAt;

    private Date updatedAt;

    private String createdBy;

    private String updatedBy;
}
