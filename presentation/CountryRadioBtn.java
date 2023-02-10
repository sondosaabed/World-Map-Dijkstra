package presentation;

import application.Country;
import javafx.geometry.Insets;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class CountryRadioBtn {
	//Fields
	private Country country;
	private RadioButton btn;
	private Label label ;
	private int id;
	private ToggleGroup group;

	public CountryRadioBtn(Country country, int id) {
		setCountry(country);		
		
		this.label = new Label(country.getName());
		this.btn = new RadioButton();

		group= new ToggleGroup();
		getBtn().setToggleGroup(group);
		getBtn().setStyle("-fx-color:black;");

	   	label.setPadding(new Insets(-5));
	   	label.setGraphic(btn);
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 11));
	   	label.setTextFill(Color.BLACK);
	   	label.setPrefHeight(57);
		label.setPrefWidth(61);
    	label.setContentDisplay(ContentDisplay.RIGHT);
    	
		Tooltip tip = new Tooltip(this.getCountry().getName());
	    tip.setFont(new Font(16));
	    tip.setStyle("-fx-background-color:grey;");
	    label.setTooltip(tip);
	    btn.setTooltip(tip);
	
		setId(id);
	}
	public ToggleGroup getGroup() {
		return group;
	}

	public void setGroup(ToggleGroup group) {
		this.group = group;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}

	public RadioButton getBtn() {
		return btn;
	}

	public void setBtn(RadioButton btn) {
		this.btn = btn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}
}