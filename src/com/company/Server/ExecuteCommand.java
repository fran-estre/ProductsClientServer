package com.company.Server;

import com.company.Shared.Commands.Command;
import com.fasterxml.jackson.core.JsonProcessingException;

abstract class ExecuteCommand {
    public abstract String execute(Command command) throws JsonProcessingException;
}