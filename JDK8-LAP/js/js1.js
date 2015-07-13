var im = new JavaImporter("java.lang.Math");
with (im ) {
	for(i=0; i<10; i++) {
		var rd = Math.random();
		print(rd);
	}
}