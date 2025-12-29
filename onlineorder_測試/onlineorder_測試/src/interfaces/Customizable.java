package interfaces;

import java.util.ArrayList;

public interface Customizable {

    void applyCustomization(String option);

    ArrayList<String> getCustomizations();

    double getCustomizationFee();
}
