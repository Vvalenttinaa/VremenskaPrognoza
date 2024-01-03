module com.example.vremenskaprognoza {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.vremenskaprognoza to javafx.fxml;
    exports com.example.vremenskaprognoza;
    exports com.example.vremenskaprognoza.Zaposleni;
    opens com.example.vremenskaprognoza.Zaposleni to javafx.fxml;
    exports com.example.vremenskaprognoza.Pregled;
    opens com.example.vremenskaprognoza.Pregled to javafx.fxml;
    exports com.example.vremenskaprognoza.Pregled.DetaljanPregled;
    opens com.example.vremenskaprognoza.Pregled.DetaljanPregled to javafx.fxml;
    exports com.example.vremenskaprognoza.Zaposleni.Mjerenje;
    opens com.example.vremenskaprognoza.Zaposleni.Mjerenje to javafx.fxml;
    exports com.example.vremenskaprognoza.Zaposleni.Administracija;
    opens com.example.vremenskaprognoza.Zaposleni.Administracija to javafx.fxml;
    exports com.example.vremenskaprognoza.GUIUtil;
    opens com.example.vremenskaprognoza.GUIUtil to javafx.fxml;
}