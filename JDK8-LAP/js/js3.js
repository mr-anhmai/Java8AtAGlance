var samplePrinter =  Java.type("com.csc.lap.nashorn.SamplePrinter");

var task = new samplePrinter {
    print: function() {
        print("Print from Sample Printer!")
    }
};

task.print();