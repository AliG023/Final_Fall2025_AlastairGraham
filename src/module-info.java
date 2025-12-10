module Final_Winter2025_AlastairGraham {
	
	requires transitive javafx.controls;
	requires transitive javafx.graphics;
	requires transitive javafx.base;
	requires transitive javafx.fxml;
	requires transitive java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	exports application;
}
