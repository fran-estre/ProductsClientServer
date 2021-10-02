package com.company.Shared.Commands;

abstract class PrepareCommand {
    public abstract boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments);
}
