package com.welcomeToJeJu.wtj.handler;

public interface Command {

  void execute(CommandRequest request) throws Exception;


}
