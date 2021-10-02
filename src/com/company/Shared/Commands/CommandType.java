package com.company.Shared.Commands;

import java.io.Serializable;

public enum CommandType implements Serializable {
    HELP,
    INFO,
    SHOW,
    CLEAR,
    ADD,
    UPDATE,
    REMOVE_BY_ID,
    INSERT_AT_INDEX,
    REMOVE_LAST,
    REMOVE_GREATER,
    REMOVE_ALL_BY_MANUFACTURER,
    GROUP_COUNTING_BY_PART_NUMBER,
    PRINT_FIELD_ASCENDING_MANUFACTURER,
    EXECUTE_SCRIPT
}


