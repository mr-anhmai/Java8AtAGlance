var Thread = Java.type("java.lang.Thread");
var threadExtender = Java.extend(Thread);
var t = new threadExtender() {
    run: function() { print("Thread running!") }};
t.run();
