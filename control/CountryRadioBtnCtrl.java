package control;


import application.Country;
import presentation.CountryRadioBtn;

public class CountryRadioBtnCtrl {
	//Fields
	private CountryRadioBtn radio;
	
	public CountryRadioBtnCtrl(Country country, int id) {
		initialize(country,id);
	}
	
	private void initialize(Country country, int id) {
		setRadio(new CountryRadioBtn(country, id));		
	}

	public CountryRadioBtn getRadio() {
		return radio;
	}

	public void setRadio(CountryRadioBtn radio) {
		this.radio = radio;
	}	
}