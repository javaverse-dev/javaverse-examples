package dev.javaverse.decision;

/// @author Javaverse
record MessageIntent(String msg, Intent intent) {

    void print(){
        IO.println(msg + " ===> " + intent);
    }
}